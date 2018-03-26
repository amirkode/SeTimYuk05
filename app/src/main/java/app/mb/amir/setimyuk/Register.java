package app.mb.amir.setimyuk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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
}
