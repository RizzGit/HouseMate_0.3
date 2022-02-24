package com.example.housemate_02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
        Context context = getApplicationContext();
    }

    public void onWindowFocusChanged (boolean hasFocus){
        getSupportActionBar().hide();
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
    }

    public void goHome(View view){
        EditText edittextemail = (EditText) findViewById(R.id.editTextTextPersonName3);
        EditText edittextpassword = (EditText) findViewById(R.id.editTextTextPassword2);

        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();



        // Condizione if non funzionante:
        //myRefEmail.get().toString().equals(edittextemail.getText().toString()) && myRefPassword.get().toString().equals(edittextpassword.getText().toString())
        if (true) {
            Context context = getApplicationContext();
            CharSequence text = "Accesso effettuato";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            Intent i = new Intent(Login_Activity.this, Home.class);
            Bundle b = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
            startActivity(i, b);
        }
        else{
            Context context = getApplicationContext();
            CharSequence text = "Credenziali errate";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}