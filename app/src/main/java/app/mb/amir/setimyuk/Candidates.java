package app.mb.amir.setimyuk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Candidates extends AppCompatActivity {
    String[] nama = {"Amir", "Rifqi", "Rivza", "Kemal", "Ainul", "Alif"};
    String[] jurusan = {"Sistem Informasi","Sistem Informasi","Sistem Informasi","Sistem Informasi","Sistem Informasi","Sistem Informasi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidates);
        ListView listView = (ListView)findViewById(R.id.daftarkandidat);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return nama.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.listviewlayout,null);
            TextView textNama = (TextView)view.findViewById(R.id.nama);
            TextView textJurusan = (TextView)view.findViewById(R.id.jurusan);
            textNama.setText(nama[i]);
            textJurusan.setText(jurusan[i]);
            return view;
        }
    }
}
