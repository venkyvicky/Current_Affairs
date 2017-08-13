package dadi.current_affairs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ratan on 7/27/2015.
 */
public class TabFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 8;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        View x = inflater.inflate(R.layout.tab_layout, null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);


        setupViewPager(viewPager);

       tabLayout.setupWithViewPager(viewPager);
       setupTabIcons();

        return x;

    }

    private void setupTabIcons() {

        TextView Business = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        Business.setText("Business");
        Business.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.business, 0, 0);
        tabLayout.getTabAt(0).setCustomView(Business);

        TextView Entertainment = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        Entertainment.setText("Entertainment");
        Entertainment.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.entertainment, 0, 0);
        tabLayout.getTabAt(1).setCustomView(Entertainment);

        TextView Gaming = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        Gaming.setText("Gaming");
        Gaming.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.gaming, 0, 0);
        tabLayout.getTabAt(2).setCustomView(Gaming);

        TextView General = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        General.setText("General");
        General.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.general, 0, 0);
        tabLayout.getTabAt(0).setCustomView(General);

        TextView Music = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        Music.setText("Music");
        Music.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.music, 0, 0);
        tabLayout.getTabAt(1).setCustomView(Music);

        TextView Politics = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        Politics.setText("Politics");
        Politics.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.politics, 0, 0);
        tabLayout.getTabAt(2).setCustomView(Politics);

        TextView nature = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        nature.setText("nature");
        nature.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.nature, 0, 0);
        tabLayout.getTabAt(2).setCustomView(nature);

        TextView Sport = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        Sport.setText("Sport");
        Sport.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.sports, 0, 0);
        tabLayout.getTabAt(2).setCustomView(Sport);

        TextView Technology = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        Technology.setText("Technology");
        Technology.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.technology, 0, 0);
        tabLayout.getTabAt(2).setCustomView(Technology);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFrag(new Hindu(), "Business");
        adapter.addFrag(new Hindu(), "Entertainment");
        adapter.addFrag(new Hindu(), "Gaming");
        adapter.addFrag(new Hindu(), "General");
        adapter.addFrag(new Hindu(), "Music");
        adapter.addFrag(new Hindu(), "Politics");
        adapter.addFrag(new Hindu(), "Science-and-nature");
        adapter.addFrag(new Hindu(), "Sport");
        adapter.addFrag(new Hindu(), "Technology");


        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}
