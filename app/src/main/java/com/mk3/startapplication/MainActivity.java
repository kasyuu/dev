package com.mk3.startapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ll = (LinearLayout)findViewById(R.id.BaseLayout);
        ll.setGravity(Gravity.TOP);
        ll.setOrientation(LinearLayout.VERTICAL);

        tv = (TextView)findViewById(R.id.maintext);
        tv.setText("ようこそ");
        bt = (Button)findViewById(R.id.mainButton);
        bt.setText("押してください");

        bt.setOnClickListener(new SampleOnClickListener());


    }
    // メニューを作成する
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(Menu.NONE, 0, 0, "ようこそ");
        menu.add(Menu.NONE, 1, 1, "こんにちは");
        menu.add(Menu.NONE, 2, 2, "いらっしゃいませ");
        menu.add(Menu.NONE, 3, 3, "はじめまして");
        return super.onCreateOptionsMenu(menu);
    }

    // メニューを選択した時に呼び出されるメソッド
    public boolean onOptionsItemSelected(MenuItem mi){
        String str = null;

        switch(mi.getItemId()){
            case 0:
                str = (String)mi.getTitle();
                break;
            case  1:
                str = (String)mi.getTitle();
                break;
            case 2:
                str = (String)mi.getTitle();
                break;
            case 3:
                str = (String)mi.getTitle();
                break;
        }

        tv.setText(str);

        return true;
    }

    class SampleOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            bt.setText(tv.getText());

        }
    }

}
