package app.mb.amir.setimyuk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by amirmb on 3/18/18.
 */

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
