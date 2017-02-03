package nyc.c4q.jordansmith.nycevents;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.jordansmith.nycevents.tabfragments.EventsFragment;
import nyc.c4q.jordansmith.nycevents.tabfragments.HomeFragment;

public class MainActivity extends AppCompatActivity {
    List<Fragment> fragmentList = new ArrayList<>();
    ImageView imageView;

//    EventsDatabaseHelper dbHelper;
    SQLiteDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateFragmentList();

        EventsDatabaseHelper dbHelper = EventsDatabaseHelper.getInstance(getApplicationContext());
        db = dbHelper.getWritableDatabase();


        ViewPager vPager = (ViewPager) findViewById(R.id.vPager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        vPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), fragmentList));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(vPager);
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        final int PAGE_COUNT = 2;
        private String tabTitles[] = new String[] { "Home", "Events"};
        List<Fragment> fragmentList;

        public MyPagerAdapter(FragmentManager fragmentManager, List<Fragment> fragmentList) {
            super(fragmentManager);
            this.fragmentList = fragmentList;
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return PAGE_COUNT ;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
//            switch (position) {
//                case 0:
//                    return new HomeFragment();
//                case 1:
//                    return new EventsFragment();
//                default:
//                    return null;
//            }
            return fragmentList.get(position);
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

    }

    public void populateFragmentList(){
        fragmentList.add(new HomeFragment());
        fragmentList.add(new EventsFragment());
    }
}
