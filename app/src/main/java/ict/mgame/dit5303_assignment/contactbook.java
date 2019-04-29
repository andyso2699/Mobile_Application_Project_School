package ict.mgame.dit5303_assignment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import static ict.mgame.dit5303_assignment.R.color.colorPrimary;

public class contactbook extends AppCompatActivity implements View.OnClickListener{
    LinearLayout.LayoutParams params;
    Button button;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactbook);

        // Find the ScrollView
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);

        // Create a LinearLayout element
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        // Add Buttons
        String[] conArray = getResources().getStringArray(R.array.contact);

        for ( int i = 0; i <conArray.length; i++ )
        {
            button = new Button(this);
            button.setId(i);
            button.setBackgroundResource(R.drawable.round_corner_row_draw);
            button.setText(conArray[i]);
            button.setTextSize(30);
            button.setTextColor(getResources().getColor(colorPrimary));
            button.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            button.setPadding(16,8,0,8);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMarginStart(8);
            params.setMargins(0, 16, 0, 0);

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
        String tel =  "tel:" + message.substring(message.length()-8);
        intent = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));
        startActivity(intent);
    }
}
