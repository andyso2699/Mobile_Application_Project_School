package ict.mgame.dit5303_assignment;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import static android.graphics.Typeface.BOLD;
import static ict.mgame.dit5303_assignment.R.color.colorPrimary;

public class firstaid extends AppCompatActivity implements View.OnClickListener{
    LinearLayout.LayoutParams params;
    Button button;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstaid);

        // Find the ScrollView
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView1);

        // Create a LinearLayout element
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        // Add Buttons
        String[] facArray = getResources().getStringArray(R.array.fa_cat);
        TypedArray imgs = getResources().obtainTypedArray(R.array.fa_cat_pics);

        for ( int i = 0; i <facArray.length; i++ )
        {
            button = new Button(this);
            button.setId(i);
            button.setBackgroundResource(R.drawable.round_corner_row_red_draw);
            button.setText(facArray[i]);
            button.setTextSize(60);
            button.setCompoundDrawablesWithIntrinsicBounds( imgs.getResourceId(i, -1), 0, 0, 0);
            button.setTextColor(getResources().getColor(colorPrimary));
            button.setTypeface(null,BOLD);
            button.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            button.setPadding(0,8,0,8);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMarginStart(8);
            params.setMargins(0, 16, 0, 16);

            button.setLayoutParams(params);
            linearLayout.addView(button);

            button.setOnClickListener(this);
        }

        // Add the LinearLayout element to the ScrollView
        scrollView.addView(linearLayout);
    }

    @Override
    public void onClick(View v) {
        button = findViewById(v.getId());
        // Do something in response to button click
        String message = (String) button.getText();
        intent = new Intent(this, firstaid_info.class);
        intent.putExtra("Value1",  button.getText());
        int ID = 0;
        switch(message){
            case "流鼻血":
                ID = R.string.fa_nosebleed;
                break;
            case "灼傷":
                ID = R.string.fa_burn;
                break;
            case "骨折":
                ID = R.string.fa_fracture;
                break;
            case "頭部創傷":
                ID = R.string.fa_headhurt;
                break;
        }
        intent.putExtra("Value2",  getString(ID));
        startActivity(intent);
    }
}