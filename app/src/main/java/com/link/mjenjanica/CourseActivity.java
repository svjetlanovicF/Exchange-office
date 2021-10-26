package com.link.mjenjanica;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.VerifiedInputEvent;
import android.widget.FrameLayout;
import android.widget.Switch;

import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

public class CourseActivity extends MotherActivity implements OnFragmentSendMessageListener{

    ViewPager viewPager;
    CoursePagerAdapter coursePagerAdapter;
    TabLayout tabLayout;

    public static String[] PAGE_NAMES = {"Euro", "Am.dolar", "Šved.krune", "Kune", "Franak"};
    public static final int SUM = 5;

    public static class CoursePagerAdapter extends FragmentStatePagerAdapter {
        public CoursePagerAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new EuroFragment();
                case 1:
                    return new DolarFragment();
                case 2:
                    return new KruneFragment();
                case 3:
                    return new KuneFragment();
                case 4:
                    return new FranakFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return SUM;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return PAGE_NAMES[position];
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);


        enableUpButton();


//
//        if(savedInstanceState != null)
//            return;
//
//        int converter = this.getIntent().getIntExtra("CONVERTER", 0);
//
//
//
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//
//        Fragment fragment = null;
//
//        switch (converter){
//            case 0:
//                fragment = new EuroFragment();
//                break;
//            case 1:
//                fragment = new DolarFragment();
//                break;
//            case 2:
//                fragment = new KruneFragment();
//                break;
//            case 3:
//                fragment = new KuneFragment();
//                break;
//            case 4:
//                fragment = new FranakFragment();
//        }
//
//        ft.add(layoutContainer.getId(), fragment);
//        ft.commit();

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        coursePagerAdapter = new CoursePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(coursePagerAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                CharSequence title = coursePagerAdapter.getPageTitle(position);
//                changeActionBarText(title.toString());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        int converter = this.getIntent().getIntExtra("CONVERTER", 0);
//        if(viewPager.getCurrentItem() == converter){
//            changeActionBarText(coursePagerAdapter.getPageTitle(converter).toString());
//        }

        viewPager.setCurrentItem(converter);
        getSupportActionBar().setElevation(0);
    }

    @Override
    public void onFragmentSendMessage(CharSequence charSequence) {
        showConverterToast(charSequence);
    }
}