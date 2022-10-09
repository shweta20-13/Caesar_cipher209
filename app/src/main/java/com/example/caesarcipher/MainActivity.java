package com.example.caesarcipher;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


import com.example.caesarcipher.R;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    private Button encrypt,decrypt;
    private EditText message,key;
    private TextView screen_output;
    private static final String alphabetString="a´b@c#d$e%f*g!h&ij?k<l>m;n-o_p~q`r,s+t=u^v—w©x®y℗z";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        encrypt=findViewById(R.id.btnencrypt);
        decrypt=findViewById(R.id.btndecrypt);
        screen_output=findViewById(R.id.output);
        message=findViewById(R.id.inputMessage);
        key=findViewById(R.id.key_dt);

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigationview);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.navigationOpen,R.string.navigationClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                encrypt12(message.getText().toString(),Integer.parseInt(key.getText().toString()));
            }
        });

        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrypt12(message.getText().toString(),Integer.parseInt(key.getText().toString()));
            }
        });
    }


    public  void decrypt12(String cipher, int key)
    {
        screen_output.setText((utility.decrypt1(cipher, key).toLowerCase()));
    }

    public String encrypt12(String message, int shiftkey)
    {
        message=message.toLowerCase();
        String cipherText="";
        for(int i=0;i<message.length();i++)
        {
            int charPosition=alphabetString.indexOf(message.charAt(i));
            int keyval=(shiftkey+charPosition)%50;
            char replaceVAL=alphabetString.charAt(keyval);
            cipherText+=replaceVAL;
            screen_output.setText(cipherText);

        }
        return cipherText;
    }
}
