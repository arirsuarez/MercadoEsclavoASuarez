package com.example.mercadoesclavoasuarez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
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

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignInActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @BindView(R.id.username)
    EditText emailLogin;
    @BindView(R.id.password)
    EditText passwordLogin;
    @BindView(R.id.signin_button)
    Button signInButton;
    /*@BindView(R.id.google_login)
    ImageButton googleLogin;
    @BindView(R.id.facebook_login)
    ImageButton facebookLogin;*/
    @BindView(R.id.signup_text_view)
    TextView signUpTextView;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailLogin.getText().toString();
                String password = passwordLogin.getText().toString();
                if (email.isEmpty()) {
                    emailLogin.setError("Please enter email");
                    emailLogin.requestFocus();
                } else if (password.isEmpty()) {
                    passwordLogin.setError("Please enter password");
                    passwordLogin.requestFocus();
                } else if (email.isEmpty() && password.isEmpty()) {
                    Toast.makeText(SignInActivity.this, "Fields are Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && password.isEmpty())) {
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignInActivity.this, "Please Try Again", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                                startActivity(intent);
                            }
                        }
                    });
                } else {
                    Toast.makeText(SignInActivity.this, "Error Ocurred", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }



}
