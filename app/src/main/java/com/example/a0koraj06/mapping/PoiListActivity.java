package com.example.a0koraj06.mapping;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;

/**
 * Created by 0koraj06 on 23/02/2017.
 */
public class PoiListActivity extends ListActivity{

// created a subclass of listactivity

    private String[] names;
    private String[] descriptions;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        names = new String[] { "Firefox", "Chrome", "Internet Explorer" };
        descriptions = new String[] { "Mozilla Firefox", "Google Chrome", "IE " };
        MyAdapter adapter = new MyAdapter();
        setListAdapter(adapter);



    }// adapter takes raw data and adapts it for interface


    public void onListItemClick(ListView lv, View view, int index, long id)
    {
        // handle list item selection
    }

    class MyAdapter extends ArrayAdapter<String> {

        public MyAdapter() {

            super(PoiListActivity.this, android.R.layout.simple_list_item_1, names);
        }

        @Override
        public View getView(int index, View convertView, ViewGroup parent)
        {
            // inflate our poi entry layout
            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = inflater.inflate(R.layout.poi_entry, parent, false);
            // populate our poi entry with data
            TextView nameTextView = (TextView) view.findViewById(R.id.poi_name),
                    descriptionsTextView = (TextView) view.findViewById(R.id.poi_desc);
            nameTextView.setText(names[index]);
            descriptionsTextView.setText(descriptions[index]);

            return view;
        }


    }
}
