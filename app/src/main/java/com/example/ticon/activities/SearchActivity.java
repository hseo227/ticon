package com.example.ticon.activities;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
//import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
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
        Intent intent = getIntent();
        String query = intent.getStringExtra("query");

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
        }

        setContentView(R.layout.search_app_bar_list);
        listRV = findViewById(R.id.listRView);
        searchView = findViewById(R.id.action_search);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView = (TextView) SearchActivity.this.findViewById(R.id.search_text);


        if (query.equals("")){
//            searchView.setIconified(false);
//            searchView.setIconifiedByDefault(false);
            textView.setText(R.string.popular);
            DataProvider.getAllData(emoticons -> {
                EmoticonAdapter emoticonAdapter = new EmoticonAdapter(this, emoticons, "three");
                getData(emoticonAdapter);
            });
        } else {
//            searchView.setIconifiedByDefault(false);
//            searchView.setFocusable(false);
//            searchView.clearFocus();
            String finalQuery = query;
            DataProvider.getAllData(emoticons -> {
                List<Emoticon> resultEmoticons = getResults(emoticons, finalQuery);
                if (resultEmoticons.isEmpty()) {
                    textView.setText(R.string.no_results);
                    textView.setVisibility(View.VISIBLE);
                } else {
                    textView.setText(getString(R.string.search_results) + " \"" + finalQuery + "\"");
                    textView.setVisibility(View.VISIBLE);
                }
                EmoticonAdapter emoticonAdapter = new EmoticonAdapter(this, resultEmoticons, "three");
                getData(emoticonAdapter);
            });
        }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        SearchView search = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        search.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this, SearchActivity.class)));
        search.setQueryHint(getResources().getString(R.string.search_hint));

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            return true;
        } else if (item.getItemId() == R.id.favorite) {
            return true;
        } else {
            onBackPressed();
            return true;
        }
    }

}


