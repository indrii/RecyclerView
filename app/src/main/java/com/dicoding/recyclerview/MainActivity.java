package com.dicoding.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        private RecyclerView rvCategory;
        private ArrayList<President> list;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                setActionBarTitle("Mode List");
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                rvCategory = (RecyclerView)findViewById(R.id.rv_category);
                rvCategory.setHasFixedSize(true);

                list = new ArrayList<>();
                list.addAll(PresidentData.getListData());

                showRecyclerList();
        }

        private void showRecyclerList(){
                rvCategory.setLayoutManager(new LinearLayoutManager(this));
                ListPresidentAdapter listPresidentAdapter = new ListPresidentAdapter(this);
                listPresidentAdapter.setListPresident(list);
                rvCategory.setAdapter(listPresidentAdapter);
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                getMenuInflater().inflate(R.menu.main_menu, menu);
                return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

                switch (item.getItemId()){
                        case R.id.action_list:

                                break;

                        case R.id.action_grid:

                                break;

                        case R.id.action_cardview:

                                break;
                }
                return super.onOptionsItemSelected(item);
        }
        private void setActionBarTitle(String title){
                getSupportActionBar().setTitle(title);
        }
        private void showRecyclerCardView(){
                rvCategory.setLayoutManager(new LinearLayoutManager(this));

                CardViewPresidentAdapter cardViewPresidentAdapter = new CardViewPresidentAdapter(this);
                cardViewPresidentAdapter.setListPresident(list);
                rvCategory.setAdapter(cardViewPresidentAdapter);
        }
        private void showRecyclerGrid(){
                rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
                GridPresidentAdapter gridPresidentAdapter = new GridPresidentAdapter(this);
                gridPresidentAdapter.setListPresident(list);
                rvCategory.setAdapter(gridPresidentAdapter);
        }
    private void showSelectedPresident(President president){
        Toast.makeText(this, "Kamu memilih "+president.getName(), Toast.LENGTH_SHORT).show();
    }
}




