package com.example.fourthtask;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    private EditText dayEditText;
    private EditText timeEditText;
    private EditText commentsEditText;
    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        dayEditText = findViewById(R.id.day_edit_text);
        timeEditText = findViewById(R.id.time_edit_text);
        commentsEditText = findViewById(R.id.comments_edit_text);
        okButton = findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day = dayEditText.getText().toString();
                String time = timeEditText.getText().toString();
                String comments = commentsEditText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("day", day);
                intent.putExtra("time", time);
                intent.putExtra("comments", comments);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
