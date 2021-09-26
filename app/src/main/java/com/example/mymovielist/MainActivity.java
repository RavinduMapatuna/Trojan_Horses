package com.example.mymovielist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.mymovielist.adapter.MainRecyclerAdapter;
import com.example.mymovielist.model.AllCategory;
import com.example.mymovielist.model.CategoryItem;
import com.google.android.material.tabs.TabLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView mainCategoryRecycler;
    private MainRecyclerAdapter mainRecyclerAdapter;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<CategoryItem> categoryItemList1 = new ArrayList<>();
        List<CategoryItem> categoryItemList2 = new ArrayList<>();
        List<CategoryItem> categoryItemList3 = new ArrayList<>();
        List<CategoryItem> categoryItemList4 = new ArrayList<>();
        List<CategoryItem> categoryItemList5 = new ArrayList<>();

        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);

        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.spiderman, "Spider-Man: No Way Home\nComing on December 17, 2021"));
        lstSlides.add(new Slide(R.drawable.jujutsu, "Jujutsu Kaisen 0\nComing on December 24, 2021  "));
        lstSlides.add(new Slide(R.drawable.got2, "House of the Dragon\nComing on January 1, 2022"));
        lstSlides.add(new Slide(R.drawable.batman, "The Batman\nComing on March 4, 2022"));
        lstSlides.add(new Slide(R.drawable.matrix, "The Matrix 4\nComing on December 22, 2021"));

        SliderPagerAdapter sliderpageradapter = new SliderPagerAdapter(this, lstSlides);
        sliderpager.setAdapter(sliderpageradapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(), 4000, 6000);

        indicator.setupWithViewPager(sliderpager,true);

        databaseReference = FirebaseDatabase.getInstance().getReference("Action");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot di:dataSnapshot.getChildren()){
                    CategoryItem categoryItem1 = di.getValue(CategoryItem.class);
                    categoryItemList1.add(new CategoryItem(categoryItem1.getMovieId(),categoryItem1.getMovieImg()));
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        List<AllCategory> allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory("Action", categoryItemList1));
        allCategoryList.add(new AllCategory("Adventure", categoryItemList2));
        allCategoryList.add(new AllCategory("Anime", categoryItemList3));
        allCategoryList.add(new AllCategory("TV Shows", categoryItemList4));
        allCategoryList.add(new AllCategory("Sci-Fi", categoryItemList5));

        setMainCategoryRecycler(allCategoryList);

    }

    class SliderTimer extends TimerTask{
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(sliderpager.getCurrentItem()<lstSlides.size()-1) {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else{
                        sliderpager.setCurrentItem(0);
                    }
                }
            });
        }
    }

    private void setMainCategoryRecycler(List<AllCategory> allCategoryList){
        mainCategoryRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainCategoryRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this,allCategoryList);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);

    }
}
