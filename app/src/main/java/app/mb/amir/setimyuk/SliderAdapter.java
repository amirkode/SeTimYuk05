package app.mb.amir.setimyuk;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Amir Mu'tashim Billah on 3/16/18.
 * Sistem Informasi Institut Teknologi Sepuluh Nopember
 * NRP : 05211740000091
 * Angkatan 2017
 */

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    // list of image
    public int[] list_image={
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4
    };
    // list of titles
    public String[] list_title={
            "Bola",
            "Orang menendang",
            "Bola Baseball",
            "Bola SoftBall"
    };
    // list of description
    public String[] list_description={
            "Deskripsi 1",
            "Deskripsi 2",
            "Deskripsi 3",
            "Deskripsi 4"
    };
    // list of background colours
    public int[] list_backgroundcolour={
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,122)
    };

    public SliderAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(LinearLayout)object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView)view.findViewById(R.id.slideimg);
        TextView texttitle = (TextView)view.findViewById(R.id.slidetitle);
        TextView textdescription = (TextView)view.findViewById(R.id.textdescription);
        //layoutslide.setBackgroundColor(list_backgroundcolour[position]);
        imgslide.setImageResource(list_image[position]);
        texttitle.setText(list_title[position]);
        textdescription.setText(list_description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
