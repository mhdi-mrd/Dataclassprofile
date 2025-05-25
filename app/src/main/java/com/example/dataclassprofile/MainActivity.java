package com.example.dataclassprofile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nameInput, ageInput, emailInput, bioInput;
    Button submitBtn;
    TextView profileResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        ageInput = findViewById(R.id.ageInput);
        emailInput = findViewById(R.id.emailInput);
        bioInput = findViewById(R.id.bioInput);
        submitBtn = findViewById(R.id.submitBtn);
        profileResult = findViewById(R.id.profileResult);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString().trim();
                String ageStr = ageInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();
                String bio = bioInput.getText().toString().trim();

                if (name.isEmpty() || ageStr.isEmpty() || email.isEmpty() || bio.isEmpty()) {
                    profileResult.setText("همه فیلدها را پر کنید!");
                    return;
                }

                int age;
                try {
                    age = Integer.parseInt(ageStr);
                } catch (Exception e) {
                    profileResult.setText("سن را به عدد وارد کنید!");
                    return;
                }

                com.example.datamodel.Profile profile = new com.example.datamodel.Profile(name, age, email, bio);
                String result = "نام: " + profile.getName() +
                        "\nسن: " + profile.getAge() +
                        "\nایمیل: " + profile.getEmail() +
                        "\nمعرفی: " + profile.getBio();

                profileResult.setText(result);
            }
        });
    }
}
