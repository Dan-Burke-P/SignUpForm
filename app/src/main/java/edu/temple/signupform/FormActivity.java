package edu.temple.signupform;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the submit button
        Button submitBtn = findViewById(R.id.SubmitButton);

        // Get the fields
        final EditText nameInput = findViewById(R.id.NameInput);
        final EditText emailInput = findViewById(R.id.EmailInput);
        final EditText passwordInput = findViewById(R.id.PasswordInput);
        final EditText confirmPasswordInput = findViewById(R.id.ConfirmInput);

        // Set the on click event
        submitBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // Get the name input
                String nameRes = nameInput.getText().toString();
                // Get email input
                String emailRes = emailInput.getText().toString();
                // get the passwords
                String passwordRes = passwordInput.getText().toString();
                String passwordConfirmRes = confirmPasswordInput.getText().toString();

                // Check the inputs
                if(nameRes.length() < 1){
                    // The name was not set so throw an error
                    Toast.makeText(getApplication().getBaseContext(), "Please enter a name...", Toast.LENGTH_SHORT).show();
                } else if(emailRes.length() < 1){
                    // The email was not set
                    Toast.makeText(getApplication().getBaseContext(), "Please enter a valid email...", Toast.LENGTH_SHORT).show();
                } else if(passwordRes.length() < 1 || passwordConfirmRes.length() < 1){
                    // Password was not entered
                    Toast.makeText(getApplication().getBaseContext(), "Please enter a password...", Toast.LENGTH_SHORT).show();
                }else if(!passwordRes.equals(passwordConfirmRes)){
                    // The passwords don't match
                    Toast.makeText(getApplication().getBaseContext(), "Passwords do not match...", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplication().getBaseContext(), "Welcome, " + nameRes + ", to the SignUpForm App", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}