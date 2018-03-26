package app.mb.amir.setimyuk;

/* Credit
* Nama          : Amir Mu'tashim Billah
* Asal          : Probolinggo
* Institusi     : Institut Teknologi Sepuluh Nopember
* Departemen    : Sistem Informasi
* NRP           : 05211740000091
* Linked.in     : https://www.linkedin.com/in/amirmb/
* Line/WA       : amir1m0b/085321141025
*/
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private static final String file_name = "FirstOpenApp_info.txt";
    private ViewPager viewPager;
    private SliderAdapter myadapter;
    public int slideNow;
    private TextView[] dotsSlider;
    private LinearLayout mDotsLayout;

    private TextView nextbtn,prevbtn;
    private int currentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        mDotsLayout = (LinearLayout) findViewById(R.id.dots);
        myadapter = new SliderAdapter(this);
        nextbtn = (TextView) findViewById(R.id.nextBtn);
        prevbtn = (TextView) findViewById(R.id.prevBtn);
        if(isAppOpened()){
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
        }else {
            viewPager.setAdapter(myadapter);
            DotsIndicator(0);
            viewPager.addOnPageChangeListener(viewListener);

            prevbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewPager.setCurrentItem(currentPage - 1);
                }
            });
            nextbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewPager.setCurrentItem(currentPage + 1);
                }
            });

            openAppInfoWriter("App Opened");
        }
    }
    //suatu method untuk menampilkan dot indikator sesuai intro slide keberapa
    public void DotsIndicator(int position){
        dotsSlider = new TextView[4];
        mDotsLayout.removeAllViews();
        for(int i=0;i<dotsSlider.length;i++){
            dotsSlider[i]=new TextView(this);
            dotsSlider[i].setText(Html.fromHtml("&#8226;"));
            dotsSlider[i].setTextSize(35);
            dotsSlider[i].setTextColor(getResources().getColor(R.color.dotColor));//14.04

            mDotsLayout.addView(dotsSlider[i]);
        }

        if(dotsSlider.length>0){
            dotsSlider[position].setTextColor(getResources().getColor(R.color.dotColorCurrent));
        }
    }
    //suatu instance untuk melihat kondisi intro slider
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            DotsIndicator(position);
            currentPage=position;
            if(position == 0){
                prevbtn.setEnabled(false);
                nextbtn.setEnabled(true);
                prevbtn.setVisibility(View.INVISIBLE);

                nextbtn.setText("Next");
                prevbtn.setText("");
                nextbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewPager.setCurrentItem(currentPage+1);
                    }
                });
            }else if(position==dotsSlider.length-1){
                prevbtn.setEnabled(true);
                nextbtn.setEnabled(true);
                prevbtn.setVisibility(View.VISIBLE);

                nextbtn.setText("Finish");
                prevbtn.setText("Back");
                nextbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(MainActivity.this, Login.class);
                        startActivity(i);
                    }
                });
            }else{
                prevbtn.setEnabled(true);
                nextbtn.setEnabled(true);
                prevbtn.setVisibility(View.VISIBLE);

                nextbtn.setText("Next");
                prevbtn.setText("Back");
                nextbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewPager.setCurrentItem(currentPage+1);
                    }
                });
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    //method untuk menulis info bahwa sudah membuka aplikasi
    public void openAppInfoWriter(String info){
        String text = info;
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(file_name, MODE_PRIVATE);
            fos.write(text.getBytes());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(fos!=null){
                try{
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    //method buat cek apakah membuka aplikasi untuk pertama kalinya
    public boolean isAppOpened(){
        FileInputStream fis = null;
        boolean returnValue=false;
        try{
            fis = openFileInput(file_name);
            InputStreamReader isr = new InputStreamReader((fis));
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text=br.readLine();
            if(text.equals("App Opened")){
                returnValue=true;
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally{
            if(fis!=null){
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return returnValue;
    }
}
