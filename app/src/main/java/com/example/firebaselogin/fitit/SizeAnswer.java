package com.example.firebaselogin.fitit;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Objects;

public class SizeAnswer extends Fragment {
    Interpreter interpreter;
    TextView answer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_size_answer, container, false);

        try {
            interpreter = new Interpreter(loadModelFile(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bundle bundle = getArguments();
//        assert bundle != null;
        String ht = bundle.getString("HEIGHT");
        String wt = bundle.getString("WEIGHT");
        String age = bundle.getString("AGE");

        String[] sizes = {"L" , "M", "S", "XXS" ,"XXL", "XL"};
        int max_index = doInference( wt, age, ht);
        String size_determined = sizes[max_index];

        answer = v.findViewById(R.id.answer);
        answer.setText(size_determined);

        //passing the data to activity
        new Handler().postDelayed(() -> {
            Intent intent= new Intent( getActivity(), ProductList.class);
            intent.putExtra("SIZE",size_determined);
            startActivity(intent);
        }, 5000);

        return v;
    }

    private MappedByteBuffer loadModelFile() throws IOException {

        AssetFileDescriptor assetFileDescriptor = Objects.requireNonNull(getContext()).getAssets().openFd("clothessizeprediction.tflite");
        FileInputStream fileInputStream = new FileInputStream((assetFileDescriptor.getFileDescriptor()));
        FileChannel fileChannel = fileInputStream.getChannel();
        long startOffSet = assetFileDescriptor.getStartOffset();
        long length = assetFileDescriptor.getLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY,startOffSet,length);
    }
    
    public int doInference (String wt, String age, String ht) {
        float[][] input = new float[1][3];
        input[0][0] = Float.parseFloat(wt);
        input[0][1] = Float.parseFloat(age);
        input[0][2] = Float.parseFloat(ht);

        float[][] output = new float[1][6];
        interpreter.run(input,output);
        int maxAt = 0;

        for (int i = 0; i < 6; i++) {
            maxAt = output[0][i] > output[0][maxAt] ? i : maxAt;
        }
        return maxAt;

    }
}
