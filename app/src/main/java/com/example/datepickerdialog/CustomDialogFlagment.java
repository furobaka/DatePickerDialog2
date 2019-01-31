package com.example.datepickerdialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.CursorAdapter;
import android.widget.DatePicker;

import java.util.Calendar;

public class CustomDialogFlagment extends DialogFragment {

    //ダイアログが生成された時に呼び出されるメソッド　※必須
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //今日の日付のカレンダーインスタンスを取得
        final Calendar calendar = Calendar.getInstance();

        //ダイアログ生成　DatePickerDialogのBuilderクラスを指定してインスタンス化
        DatePickerDialog dateBuilder = new DatePickerDialog(
                getActivity(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        //選択された年・月・日を整形　※月は0-11なので+1
                        String dateStr = year + "年" + (month + 1) + "月" + dayOfMonth + "日";

                        //MainActivityのインスタンスを取得
                        MainActivity mainActivity = (MainActivity) getActivity();
                        mainActivity.setTextView(dateStr);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );

        //dateBuilderを返す
        return dateBuilder;
    }
}
