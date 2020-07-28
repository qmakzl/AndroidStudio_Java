package com.example.threadexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_start, btn_stop;
    Thread thread;
    boolean isThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //스레드 시작
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isThread = true;
                thread = new Thread(){
                  public void run(){
                      while (isThread){
                          try {
                              sleep(5000);
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                          handler.sendEmptyMessage(0);
                      }
                  }
                };
                thread.start();
            }
        });

        //스레드 종료
        btn_stop = (Button)findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                isThread = false;
            }
        });

    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(getApplicationContext(), "윤애기 강의", Toast.LENGTH_SHORT).show();
        }
    };
}
