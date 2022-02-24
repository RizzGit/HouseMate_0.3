package com.example.housemate_02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register_Activity extends AppCompatActivity {

    //MySQLiteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();


        //db = (MySQLiteHelper) getIntent().getSerializableExtra("DB");
        //db.addBook(new Book("Utente","Users", "utente@gmail.com","14/01/1965"));
    }

    public void onWindowFocusChanged (boolean hasFocus){
        getSupportActionBar().hide();
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
    }

    public void goLogin(View view){
        EditText edittextname = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText edittextsurname = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText edittextemail = (EditText) findViewById(R.id.editTextTextPersonName3);
        EditText edittextpassword = (EditText) findViewById(R.id.editTextTextPassword2);

        //db.addBook(new Book(edittextname.getText().toString(),edittextsurname.getText().toString(),edittextemail.getText().toString(),edittextdnascita.getText().toString()));

        User tUtente = new User(edittextname.getText().toString(),edittextsurname.getText().toString(),edittextemail.getText().toString(),edittextemail.getText().toString());

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://housemate-2daec-default-rtdb.europe-west1.firebasedatabase.app/");

        DatabaseReference Ref = database.getReference("Utente");
        Ref.setValue(tUtente);

        Context context = getApplicationContext();
        CharSequence text = "Registrazione effettuata";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Intent i = new Intent(Register_Activity.this, Login_Activity.class);
        Bundle b = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        startActivity(i, b);
    }
}