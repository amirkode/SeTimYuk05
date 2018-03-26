package app.mb.amir.setimyuk;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText username_,password_;
    private Button loginBtn;
    private TextView regNow;
    private boolean click_duaKali;

    private int passLength;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //loginBtn = (Button)findViewById(R.id.loginbtn);
        username_= (EditText)findViewById(R.id.usernameLogin);
        password_= (EditText)findViewById(R.id.passLogin);
        regNow = (TextView)findViewById(R.id.regnow);
        regNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Register.class);
                startActivity(i);
            }
        });
      //  ActionBar actionBar = getActionBar();
      //  actionBar.setDisplayShowTitleEnabled(false);
    }

    public void LoginClicked(View v){
        passLength=password_.getText().toString().length();
        if(username_.getText().toString().matches("") || password_.getText().toString().matches("")){
            Toast.makeText(Login.this, "Silahkan isi yang kosong!", Toast.LENGTH_LONG).show();
        }else if(iniEmail(username_.getText().toString())){
            if(!ceckEmail(username_.getText().toString().toCharArray())){
                Toast.makeText(Login.this, "Masukkan email dengan tepat!", Toast.LENGTH_LONG).show();
            }else{
                Intent i = new Intent(Login.this, Candidates.class);
                startActivity(i);
            }
        }else if(passLength<8){
            Toast.makeText(Login.this, "Password yang Anda masukkan kurang dari 8 karakter", Toast.LENGTH_LONG).show();
        }else if (passLength>22){
            Toast.makeText(Login.this, "Password yang Anda masukkan lebih dari 22 karakter", Toast.LENGTH_LONG).show();
        }else{
            Intent i = new Intent(Login.this, Candidates.class);
            startActivity(i);
        }
    }

    //apakah yang dimasukkan berpotensi sebuah email
    private boolean iniEmail(String input){
        char[] inputPisah=input.toCharArray();
        boolean kondisi=false;
        for(int i=0;i<inputPisah.length;i++){
            if(inputPisah[i]=='@'){
                kondisi=true;
            }
        }
        return kondisi;
    }

    //method untuk cek format email apakah benar
    public Boolean ceckEmail(char[] mail_char){
        int isEmail=0;
        Boolean isEmailBisa=false;
        int position=0;
        for(int i=0;i<mail_char.length;i++){
            if(mail_char[i]=='@'){
                isEmail++;
                position=i;
            }
            if(mail_char[i]=='!' || mail_char[i]=='#' || mail_char[i]=='$' || mail_char[i]=='%' || mail_char[i]=='^' ||
                    mail_char[i]=='&' || mail_char[i]=='*' || mail_char[i]=='(' || mail_char[i]==')' || mail_char[i]=='-' || mail_char[i]=='=' ||
                    mail_char[i]=='+' || mail_char[i]=='[' || mail_char[i]==']' || mail_char[i]=='{' || mail_char[i]=='}' || mail_char[i]==':' || mail_char[i]==';' || mail_char[i]=='/' ||
                    mail_char[i]=='?' || mail_char[i]=='>' || mail_char[i]=='<' || mail_char[i]==',' || mail_char[i]=='`' || mail_char[i]=='~'){
                isEmail=0;
                break;
            }
        }
        if(isEmail==1 && (mail_char.length-position-1)>4 && mail_char[position+1]!='.'){
            int pointChar=0;
            int[] titikPosisi = new int[mail_char.length-position-1];
            for(int i=position+1; i<mail_char.length;i++){
                if(mail_char[i]=='.'){
                    titikPosisi[pointChar]=i;
                    pointChar++;
                }
            }
            if(pointChar>0 && pointChar<3 && (titikPosisi[1]-titikPosisi[0]!=1) && titikPosisi[1]!=(mail_char.length-1)){
                isEmailBisa=true;
            }
        }
        return isEmailBisa;
    }

    @Override
    public void onBackPressed() {
        if(click_duaKali){
            Intent i = new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
            System.exit(0);
        }
        Toast.makeText(Login.this, "Silahkan tekan lagi untuk keluar!", Toast.LENGTH_LONG).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                click_duaKali=false;
            }
        },3000);
        click_duaKali=true;
    }
}
