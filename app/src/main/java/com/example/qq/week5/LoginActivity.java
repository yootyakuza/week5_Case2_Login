package com.example.qq.week5;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button bt1;
    EditText User, Pass;
    TextView tvRegister;

    private UserManager uManager;
    private Context con ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uManager = new UserManager(this);
        con = this;
        setContentView(R.layout.activity_login);
        bt1 = (Button)findViewById(R.id.butLogin);
        User = (EditText)findViewById(R.id.user);
        Pass = (EditText)findViewById(R.id.pass);
        tvRegister = (TextView)findViewById(R.id.NewRegister);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = User.getText().toString().trim();
                String password = Pass.getText().toString();

                if(username.isEmpty()){
                    Toast t = Toast.makeText(con,"Please input User name !!",Toast.LENGTH_SHORT);
                    User.requestFocus();
                    t.show();
                }
                else if(password.isEmpty()){
                    Toast t = Toast.makeText(con,"Please input Password !!",Toast.LENGTH_SHORT);
                    Pass.requestFocus();
                    t.show();
                }
                else {
                    boolean isSuccess = uManager.checkLoginValidate(username,password);

                    if(isSuccess){
                        Intent intent = new Intent(getApplicationContext(),Activity3Welcome.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast t = Toast.makeText(con,"Username or Password is incorrect",Toast.LENGTH_SHORT);
                        t.show();
                    }
                }

            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Activity2Register.class);
                startActivity(intent);
            }
        });
    }
}
