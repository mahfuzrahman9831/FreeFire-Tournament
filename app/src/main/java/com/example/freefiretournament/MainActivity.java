package com.example.freefiretournament;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

import static com.example.freefiretournament.R.id.tabLayoutId;
import static com.example.freefiretournament.R.id.viewPagerId;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(viewPagerId);
        tabLayout = findViewById(tabLayoutId);


        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

    class MyPagerAdapter extends FragmentPagerAdapter{



        String tabName [] = {"MATCH","JOINED","ROOM ID","RESULTS","WALLET","BLOCK"};


        public MyPagerAdapter(@NonNull FragmentManager fm ) {
            super(fm);

        }




        @NonNull
        @Override
        public Fragment getItem(int position) {

            if (position == 0){

                return  new MATCH();
            }
            if (position == 1){

                return  new JOINED();
            }
            if (position == 2){

                return  new ROOM_ID();
            }
            if (position == 3){

                return  new RESULTS();
            }
            if (position == 4){

                return  new WALLET();
            }
            if (position == 5){

                return  new BLOCK();
            }



            return null;
        }

        @Override
        public int getCount() {
            return tabName.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabName[position];
        }
    }


}
