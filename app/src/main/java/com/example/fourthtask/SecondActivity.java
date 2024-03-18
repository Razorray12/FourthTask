package com.example.fourthtask;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

public class SecondActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvSurname;
    private Button btnNext;

    private ActivityResultLauncher<Intent> mStartForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvName = findViewById(R.id.name_text_view);
        tvSurname = findViewById(R.id.surname_text_view);
        btnNext = findViewById(R.id.enter_info_button);

        String name = getIntent().getStringExtra("name");
        String surname = getIntent().getStringExtra("surname");
        tvName.setText(name);
        tvSurname.setText(surname);

       ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent data = result.getData();
                            String day = data.getStringExtra("day");
                            String time = data.getStringExtra("time");
                            String comments = data.getStringExtra("comments");
                            String resultText = "Day: " + day + "\nTime: " + time + "\nComments: " + comments;
                            ((TextView) findViewById(R.id.result)).setText(resultText);
                            showSuccessMessage();
                        }
                    }
                });

        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(this, ThirdActivity.class);
            mStartForResult.launch(intent);
        });
    }

    private void showSuccessMessage() {
        Toast.makeText(this, "Время передано успешно!",Toast.LENGTH_LONG).show();
    }
}
