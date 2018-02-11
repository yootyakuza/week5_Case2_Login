package com.example.qq.week5;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2Register extends AppCompatActivity {

    Button btRegister;
    EditText ReUser,Repass,ReConpass;

    private Context con;
    private UserManager uManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_register);

        uManager = new UserManager(this);
        con = this;

        btRegister = (Button)findViewById(R.id.butRegister);
        ReUser = (EditText)findViewById(R.id.user2);
        Repass = (EditText)findViewById(R.id.pass2);
        ReConpass = (EditText)findViewById(R.id.confpass);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = ReUser.getText().toString().trim();
                String password = Repass.getText().toString();
                String confpass = ReConpass.getText().toString();

                if(username.isEmpty()){
                    Toast t = Toast.makeText(con,"Please input User name !!",Toast.LENGTH_SHORT);
                    ReUser.requestFocus();
                    t.show();
                }
                else if(password.isEmpty()){
                    Toast t = Toast.makeText(con,"Please input Password !!",Toast.LENGTH_SHORT);
                    Repass.requestFocus();
                    t.show();
                }
                else if(confpass.isEmpty()){
                    Toast t = Toast.makeText(con,"Please input Confirm Password !!",Toast.LENGTH_SHORT);
                    ReConpass.requestFocus();
                    t.show();
                }
                else if(!password.equals(confpass)){
                    Toast t = Toast.makeText(con,"Password does not match the confirm password. Please try again !!",Toast.LENGTH_SHORT);
                    ReConpass.requestFocus();
                    t.show();
                }
                else if(password.equals(confpass)){
                    boolean isSuccess = uManager.registerUser(username,password);
                    if(isSuccess){
                        Toast t = Toast.makeText(con,"Register success", Toast.LENGTH_SHORT);
                        t.show();
                        finish();
                    }
                    else
                    {
                        Toast t = Toast.makeText(con,"Register failed, Please try again!!",Toast.LENGTH_SHORT);
                        t.show();
                    }
                }
            }
        });
    }
}
