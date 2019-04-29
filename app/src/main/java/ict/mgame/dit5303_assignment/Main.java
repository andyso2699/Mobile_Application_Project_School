package ict.mgame.dit5303_assignment;

import android.content.*;
import android.net.Uri;
import android.support.v7.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.*;


public class Main extends AppCompatActivity {
    Calendar calendar;
    EditText editT;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editT = findViewById(R.id.CurrentDate);
        calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        editT.setText(year+" 年\n"+month+" 月 "+day+" 日");
    }

    public void Emergency(View view) {
        intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:999"));
        startActivity(intent);
    }

    public void FirstAid(View view) {
        intent = new Intent(this, firstaid.class);
        startActivity(intent);
    }

    public void GPSLocation(View view) {
        intent = new Intent(Intent.ACTION_VIEW);
        startActivity(intent);
    }

    public void ContactBook(View view) {
        intent = new Intent(this, contactbook.class);
        startActivity(intent);
    }

    public void AboutUs(View view) {
        intent = new Intent(this, aboutus.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("你是否離開？")
                .setPositiveButton(R.string.quit, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finishAffinity();
                        System.exit(0);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
        alert.getWindow().getAttributes();

        TextView textView = alert.findViewById(android.R.id.message);
        textView.setTextSize(36);
        Button btn1 = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
        Button btn2 = alert.getButton(DialogInterface.BUTTON_POSITIVE);
        btn1.setTextSize(28);
        btn2.setTextSize(28);
    }


}
