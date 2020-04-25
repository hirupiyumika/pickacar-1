package com.orioton.pickacar.driver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.orioton.pickacar.R;
import com.orioton.pickacar.driver.model.DriverModel;

public class DriverSignUp extends AppCompatActivity {

    private EditText email,phone,password;
    private Button signup;

    private Firebase root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_sign_up);

        root = new Firebase("https://pickacar-b3bf4.firebaseio.com/drivers");

        email = (EditText) findViewById(R.id.dr_et_driver_email);
        phone = (EditText) findViewById(R.id.dr_et_driver_phone);
        password = (EditText) findViewById(R.id.dr_et_driver_password);

        signup = (Button) findViewById(R.id.dr_btn_driver_sign_up);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = email.getText().toString().trim();
                String value2 = phone.getText().toString().trim();
                String value3 = password.getText().toString().trim();

                DriverModel driver = new DriverModel(value1,value2,value3);

                root.push().setValue(driver);

            }
        });
    }
}
