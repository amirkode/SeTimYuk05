package app.mb.amir.setimyuk;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import app.mb.amir.setimyuk.dummy.DummyContent;
import app.mb.amir.setimyuk.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CandidateFragment extends ListFragment {
    String[] nama = {"Amir", "Rifqi", "Rivza", "Kemal", "Ainul", "Alif"};
    String[] jurusan = {"Sistem Informasi","Sistem Informasi","Sistem Informasi","Sistem Informasi","Sistem Informasi","Sistem Informasi"};

    ArrayList<HashMap<String, String>> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_candidate_list, container, false);
        //map
        HashMap<String, String> map = new HashMap<String, String>();
        //fill
        for(int i=0;i<nama.length;i++){
            map = new HashMap<String, String>();
            map.put("Nama", nama[i]);
            map.put("jurusan", jurusan[i]);

            data.add(map);
        }
        //keys in map
        String[] from = {"Nama", "Jurusan"};
        //ids of views
        //int[]
        return view;
    }


}
