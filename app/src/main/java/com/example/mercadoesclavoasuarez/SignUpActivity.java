package com.example.mercadoesclavoasuarez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @BindView(R.id.username)
    EditText userNameLogin;
    @BindView(R.id.password)
    EditText passwordLogin;
    /*@BindView(R.id.google_signup)
    ImageButton googleLogin;
    @BindView(R.id.facebook_signup)
    ImageButton facebookLogin;*/
    @BindView(R.id.signup_button)
    Button signUpButton;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFarebaseUser = mAuth.getCurrentUser();
                if (mFarebaseUser != null){
                    Toast.makeText(SignUpActivity.this, "You are already part of the family", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(SignUpActivity.this, "Please Create an Account", Toast.LENGTH_SHORT).show();
                }
            }
        };

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = userNameLogin.getText().toString();
                String password = passwordLogin.getText().toString();
                String user = mAuth.getCurrentUser().toString();
                if(email.isEmpty()){
                    userNameLogin.setError("Please enter email");
                    userNameLogin.requestFocus();
                }else if (password.isEmpty()){
                    passwordLogin.setError("Please enter password");
                    passwordLogin.requestFocus();
                } else if (email.isEmpty() && password.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Fields are Empty!", Toast.LENGTH_SHORT).show();
                } else if (! (email.isEmpty() && password.isEmpty())){
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                                startActivity(intent);

                            } else {

                            }
                        }
                    });
                }
                else {
                    Toast.makeText(SignUpActivity.this, "Error Ocurred", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }
}
