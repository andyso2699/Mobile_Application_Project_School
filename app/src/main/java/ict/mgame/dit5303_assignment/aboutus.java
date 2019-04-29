package ict.mgame.dit5303_assignment;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("多謝支持!")
                .setPositiveButton(R.string.thankyou, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
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
