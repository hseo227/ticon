package com.example.ticon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
//import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import com.example.ticon.R;
import com.example.ticon.data.DataProvider;
import com.example.ticon.models.Emoticon;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView listRV;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_search);
        listRV = findViewById(R.id.listRView);
        searchView = findViewById(R.id.action_search);

        TextView textView = (TextView) SearchActivity.this.findViewById(R.id.search_text);

        Intent intent = getIntent();
        String query = intent.getStringExtra("query");

        if (query.equals("")){
            textView.setText("Popular");
            DataProvider.getAllData(emoticons -> {
                EmoticonAdapter emoticonAdapter = new EmoticonAdapter(this, emoticons, "three");
                getData(emoticonAdapter);
            });
            } else {
            DataProvider.getAllData(emoticons -> {
                List<Emoticon> resultEmoticons = getResults(emoticons, query);
                if (resultEmoticons.isEmpty()) {
                    textView.setText(R.string.no_results);
                    textView.setVisibility(View.VISIBLE);
                } else {
                    textView.setText(R.string.search_results);
                    textView.setVisibility(View.VISIBLE);
                }
                EmoticonAdapter emoticonAdapter = new EmoticonAdapter(this, resultEmoticons, "three");
                getData(emoticonAdapter);
            });
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent newIntent = new Intent(getBaseContext(), SearchActivity.class);
                newIntent.putExtra("query", query);
                startActivity(newIntent);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String query) {
                return false;
            }
        });


    }

    protected List<Emoticon> getResults(List<Emoticon> emoticons, String query) {
        List<Emoticon> searchResults = new ArrayList<Emoticon>();
        for (Emoticon emoticon : emoticons) {
            String emoticonIgnoreCase = emoticon.getName().toLowerCase();
            String queryIgnoreCase = query.toLowerCase();
            if (emoticonIgnoreCase.contains(queryIgnoreCase)) {
                searchResults.add(emoticon);
            }
        }
        return searchResults;
    }


    protected void getData(EmoticonAdapter emoticonAdapter) {
        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager layout = new LinearLayoutManager(this);
        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        listRV.setLayoutManager(layout);
        listRV.setAdapter(emoticonAdapter);
    }

}


