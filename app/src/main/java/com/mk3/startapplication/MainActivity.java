package com.mk3.startapplication;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button bt;
    ListView lv;
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

        // リストビューを作成し、配列から生成したアダプターをセット
        lv = new ListView(this);
        String[] str = {"検索", "電話"};
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        lv.setAdapter(ad);

        ll.addView(lv);

        bt.setOnClickListener(new ButtonClickListener());
        lv.setOnItemClickListener(new ListItemClickListener());



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

    class ButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            bt.setText(tv.getText());

        }
    }

    class ListItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> v, View iv, int pos,long id){
            Intent it = new Intent();
            if(pos == 0){
                // 標準アプリ(検索)起動のインテントを設定
                it.setAction(Intent.ACTION_SEARCH);
                // 名前と値の組み合わせをデータとして渡すメソッド
                it.putExtra(SearchManager.QUERY,"Android 開発");
                startActivity(it);
            }else if (pos == 1){
                // 標準アプリ起動のためのメソッド
                it.setAction(Intent.ACTION_VIEW);
                // 電話番号を指定して値としてセット
                it.setData(Uri.parse("tel:12345678"));
                startActivity(it);
            }

        }
    }

}
