package mao.android_send_data_and_return_data;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private TextView textView1;

    /**
     * 得到int随机数
     *
     * @param min 最小值
     * @param max 最大值
     * @return int
     */
    public static int getIntRandom(int min, int max)
    {
        if (min > max)
        {
            min = max;
        }
        return min + (int) (Math.random() * (max - min + 1));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.b1).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                //intent.putExtra("str", "随机数为：");
                Bundle bundle = new Bundle();
                bundle.putString("str", "随机数为：");
                bundle.putInt("random", getIntRandom(0, 100));
                intent.putExtras(bundle);
                //startActivity(intent);
                startActivityForResult(intent, 0);
            }
        });

        textView1 = findViewById(R.id.tv1);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && requestCode == 0 && resultCode == Activity.RESULT_OK)
        {
            Bundle bundle = data.getExtras();
            String responseStr = bundle.getString("response_str");
            double responseRandom = bundle.getDouble("response_random");
            textView1.setText(responseStr + responseRandom);
        }

    }
}