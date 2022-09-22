package mao.android_send_data_and_return_data;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity
{

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = findViewById(R.id.tv2);
        Bundle bundle = getIntent().getExtras();
        String str = bundle.getString("str");
        int random = bundle.getInt("random");
        textView.setText(str + random);
    }
}