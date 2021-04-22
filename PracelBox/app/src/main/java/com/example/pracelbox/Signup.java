package com.example.pracelbox;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import java.util.regex.Pattern;
import static android.util.Patterns.PHONE;

public class Signup extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputNumber, textInputName, textInputUserName,textInputBoxAddress;


    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        login = (TextView)  findViewById(R.id.login_text);
        textInputEmail = findViewById(R.id.text_input_email);
        textInputPassword = findViewById(R.id.text_input_password);
        textInputNumber = findViewById(R.id.text_input_number);
        textInputName = findViewById(R.id.text_input_name);
        textInputUserName = findViewById(R.id.text_input_username);
        textInputBoxAddress = findViewById(R.id.text_input_boxaddress);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private boolean validateNumber(){
        String numberInput = textInputNumber.getEditText().getText().toString().trim();
        // int number = Integer.parseInt(numberInput);
        if (numberInput.isEmpty()) {
            textInputNumber.setError("Field can't be empty");
            return false;
        } else if(numberInput.length()!=10){
            textInputNumber.setError("Phone No is not valid");
            return false;
        } else if (!PHONE.matcher(numberInput).matches() ) {
            textInputNumber.setError("Phone No is not valid");
            return false;
        } else {
            textInputNumber.setError(null);
            return true;
        }
    }
    private boolean validateEmail() {
        String emailInput = textInputEmail.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()) {
            textInputEmail.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textInputEmail.setError("Please enter a valid email address");
            return false;
        } else {
            textInputEmail.setError(null);
            return true;
        }
    }
    private boolean validatePassword() {
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();
        if (passwordInput.isEmpty()) {
            textInputPassword.setError("Field can't be empty");
            return false;
        } else if (passwordInput.length()<4) {
            textInputPassword.setError("Password must contain at least 4 characters");
            return false;
        } else {
            textInputPassword.setError(null);
            return true;
        }
    }

    private boolean validateName() {
        String passwordInput = textInputName.getEditText().getText().toString().trim();
        if (passwordInput.isEmpty()) {
            textInputName.setError("Field can't be empty");
            return false;
        } else {
            textInputName.setError(null);
            return true;
        }
    }

    private boolean validateUserName() {
        String passwordInput = textInputUserName.getEditText().getText().toString().trim();
        if (passwordInput.isEmpty()) {
            textInputUserName.setError("Field can't be empty");
            return false;
        }  else {
            textInputUserName.setError(null);
            return true;
        }
    }

    private boolean validateBoxAddress() {
        String passwordInput = textInputBoxAddress.getEditText().getText().toString().trim();
        if (passwordInput.isEmpty()) {
            textInputBoxAddress.setError("Field can't be empty");
            return false;
        } else if (passwordInput.length()<4) {
            textInputBoxAddress.setError("Please add valid Address");
            return false;
        } else {
            textInputBoxAddress.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateNumber() | !validateEmail()  | !validatePassword() | !validateName() | !validateUserName()| !validateBoxAddress())
        {
            return;
        }
        String input = "Email: " + textInputEmail.getEditText().getText().toString();
        input += "\n";
        input += "Password: " + textInputPassword.getEditText().getText().toString();
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Signup.this, OTPverification.class);
        startActivity(intent);
    }
}