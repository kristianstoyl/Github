package com.ntnu.kristian.mandatory2list_detailview;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // just a variable for the view we will return to
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // Populate array with a few cake flavours, we will add this to listView
        String[] data = {"Chocolate", "Vanilla", "Peanut", "Lemon", "Apple",
                                "Carrot", "Raspberry"};
        ArrayList<String> listItems = new ArrayList<String>(Arrays.asList(data));
        // An arrayAdapter takes in an array to list items
        final ListAdapter listAdapter
                = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list_item, // list_item.xml layout file
                R.id.list_item_textview, // textview inside list_item.xml
                listItems); // array with data

        // Get a reference to the ListView, and attach this adapter to it.
        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)listAdapter.getItem(position);
                Intent intent = new Intent(getActivity(), DetailActivity.class).putExtra(Intent.EXTRA_TEXT, item);
                startActivity(intent);
            }
        });
        return rootView;
    }


}
