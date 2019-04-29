package ict.mgame.dit5303_assignment;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

import static android.graphics.Typeface.BOLD;
import static ict.mgame.dit5303_assignment.R.color.colorPrimary;

public class firstaid_info extends AppCompatActivity {
    TextView tv,tv1;
    ImageView iv;
    LinearLayout.LayoutParams layoutParams;
    TypedArray imgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstaid_info);

        // Find the ScrollView
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView2);

        // Create a LinearLayout element
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        tv = findViewById(R.id.textView3);
        tv.setText(getIntent().getStringExtra("Value1"));

        switch(getIntent().getStringExtra("Value1")){
            case "流鼻血":
                imgs = getResources().obtainTypedArray(R.array.fa_nosebleed_pics);
                break;
            case "灼傷":
                imgs = getResources().obtainTypedArray(R.array.fa_burn_pics);
                break;
        }

        if (getIntent().getStringExtra("Value1").equals("流鼻血")||getIntent().getStringExtra("Value1").equals("灼傷")){
            for ( int i = 0; i <imgs.length(); i++ ) {
                iv = new ImageView(this);
                iv.setId(i);
                iv.setImageDrawable(getResources().getDrawable(imgs.getResourceId(i, -1)));
                layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.gravity=Gravity.CENTER;
                layoutParams.setMarginStart(8);
                layoutParams.setMargins(0, 0, 0, 16);
                iv.setLayoutParams(layoutParams);
                linearLayout.addView(iv);
            }
        }
        else {
            tv1 = new TextView(this);
            tv1.setText(getIntent().getStringExtra("Value2"));
            tv1.setTextSize(40);

            tv1.setTextColor(getResources().getColor(colorPrimary));
            tv1.setTypeface(null, BOLD);
            tv1.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            tv1.setPadding(0, 8, 0, 8);

            linearLayout.addView(tv1);
        }
        scrollView.addView(linearLayout);
    }

}
