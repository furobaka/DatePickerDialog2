package com.example.datepickerdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //idがdialogButtonのButtonを取得
        Button dialogBtn = (Button)findViewById(R.id.dialogButton);
        //clickイベント追加
        dialogBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            //クリックしたらダイアログを表示する処理
            public void onClick(View v){
                //ダイアログクラスをインスタンス化
                CustomDialogFlagment dialog = new CustomDialogFlagment();
                //表示　getFlagmentManager()は固定、sampleは識別タグ
                dialog.show(getSupportFragmentManager(), "sample");
            }
        });
    }

    //ダイアログで入力した値をtextViewに入れる、ダイアログから呼び出される
    public void setTextView(String value){
        TextView textView = (TextView)findViewById(R.id.text);
        textView.setText(value);
    }
}
