package com.metacog.pc.metacog2k18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Sponsor extends AppCompatActivity {
    ListView mListView;
    String[] spon_title={"TECHPORTAL","APTRON","WORLDS OF WONDER","DHYEY IAS","UNIVERSITY INNOVATION FELLOWS", "APPU GHAR"};
    int[] spon_posters={R.drawable.techportal,R.drawable.aptron,R.drawable.wow, R.drawable.dhyey
            ,R.drawable.university_innovation_fellows,R.drawable.appu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);
        mListView=(ListView)findViewById(R.id.spon_list);
        SponAdapter sponAdapter=new SponAdapter();
        mListView.setAdapter(sponAdapter);
    }

    class SponAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return spon_title.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=getLayoutInflater().inflate(R.layout.spon_list,null);
            TextView title= (TextView) convertView.findViewById(R.id.spon_text);
            ImageView imageView= (ImageView) convertView.findViewById(R.id.spon_image);
            title.setText(spon_title[position]);
            imageView.setImageResource(spon_posters[position]);
            return convertView;
        }
    }
}
