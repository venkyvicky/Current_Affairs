package dadi.current_affairs;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    RecyclerView mylistview;
    ArrayList<MyBaseStructure> myBaseStructures;
    CustomAdapter customAdapter;
    Toolbar toolbar;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    ImageView myimages;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    TextView mytext_news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mylistview = (RecyclerView) findViewById(R.id.mylistview);
        mytext_news = (TextView)findViewById(R.id.mytext_news);
       // Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomin);
       // mytext_news.startAnimation(animFadeIn);

        mTitle = mDrawerTitle = getTitle();

        myBaseStructures = new ArrayList<MyBaseStructure>();
        myBaseStructures.add(new MyBaseStructure("ABC News (AU) general",R.drawable.abc,"abc-news-au","top"));
        myBaseStructures.add(new MyBaseStructure("Al Jazeera English general",R.drawable.al,"al-jazeera-english","top"));
        myBaseStructures.add(new MyBaseStructure("Ars Technica technology",R.drawable.ars,"ars-technica","top"));
        myBaseStructures.add(new MyBaseStructure("Associated Press general",R.drawable.ap,"associated-press","top"));
        myBaseStructures.add(new MyBaseStructure("BBC News general",R.drawable.bbc,"bbc-news","top"));
        myBaseStructures.add(new MyBaseStructure("BBC Sport sport",R.drawable.bbcsports,"bbc-sport","top"));
        myBaseStructures.add(new MyBaseStructure("Bild general",R.drawable.bild,"bild","top"));
        myBaseStructures.add(new MyBaseStructure("Bloomberg business",R.drawable.bloomberg,"bloomberg","top"));
        myBaseStructures.add(new MyBaseStructure("Breitbart News politics",R.drawable.breitbart,"breitbart-news","top"));
        myBaseStructures.add(new MyBaseStructure("Business Insider business",R.drawable.businessinsider,"business-insider","top"));
        myBaseStructures.add(new MyBaseStructure("Business Insider (UK) business",R.drawable.businesinsideruk,"business-insider-uk","top"));
        myBaseStructures.add(new MyBaseStructure("Buzzfeed entertainment",R.drawable.buzzfeed,"buzzfeed","top"));
        myBaseStructures.add(new MyBaseStructure("CNBC business",R.drawable.cnbc,"cnbc","top"));
        myBaseStructures.add(new MyBaseStructure("CNN general",R.drawable.cnn,"cnn","top"));
        myBaseStructures.add(new MyBaseStructure("Daily Mail entertainment",R.drawable.dailymail,"daily-mail","top"));
        myBaseStructures.add(new MyBaseStructure("Der Tagesspiegel general",R.drawable.dertagess,"der-tagesspiegel","latest"));
        myBaseStructures.add(new MyBaseStructure("Die Zeit business",R.drawable.diezeit,"die-zeit","latest"));
        myBaseStructures.add(new MyBaseStructure("Engadget technology",R.drawable.engadget,"engadget","top"));
        myBaseStructures.add(new MyBaseStructure("Entertainment Weekly entertainment",R.drawable.entertaintmentweek,"entertainment-weekly","top"));
        myBaseStructures.add(new MyBaseStructure("ESPN sport",R.drawable.espn,"espn","top"));
        myBaseStructures.add(new MyBaseStructure("ESPN Cric Info sport",R.drawable.espncrick,"espn-cric-info","top"));
        myBaseStructures.add(new MyBaseStructure("Financial Times business",R.drawable.financialtimes,"financial-times","top"));
        myBaseStructures.add(new MyBaseStructure("Focus general",R.drawable.focus,"focus","top"));
        myBaseStructures.add(new MyBaseStructure("Football Italia sport",R.drawable.footballitalia,"football-italia","top"));
        myBaseStructures.add(new MyBaseStructure("Fortune business",R.drawable.fortune,"fortune","top"));
        myBaseStructures.add(new MyBaseStructure("FourFourTwo sport",R.drawable.fourfourtwo,"four-four-two","top"));
        myBaseStructures.add(new MyBaseStructure("Fox Sports sport",R.drawable.foxsports,"fox-sports","top"));
        myBaseStructures.add(new MyBaseStructure("Google News general",R.drawable.googlenews,"google-news","top"));
        myBaseStructures.add(new MyBaseStructure("Gruenderszene technology",R.drawable.gruenderszene,"gruenderszene","top"));
        myBaseStructures.add(new MyBaseStructure("Hacker News technology",R.drawable.hackernews,"hacker-news","latest"));
        myBaseStructures.add(new MyBaseStructure("Handelsblatt business",R.drawable.handelsblatt,"handelsblatt","top"));
        myBaseStructures.add(new MyBaseStructure("IGN gaming",R.drawable.ign,"ign","top"));
        myBaseStructures.add(new MyBaseStructure("Independent general",R.drawable.independent,"independent","top"));
        myBaseStructures.add(new MyBaseStructure("Mashable entertainment",R.drawable.mashable,"mashable","top"));
        myBaseStructures.add(new MyBaseStructure("Metro general",R.drawable.metro,"metro","top"));
        myBaseStructures.add(new MyBaseStructure("Mirror general",R.drawable.mirror,"mirror","top"));
        myBaseStructures.add(new MyBaseStructure("MTV News music",R.drawable.mtvnews,"mtv-news","top"));
        myBaseStructures.add(new MyBaseStructure("MTV News (UK) music",R.drawable.mtvnewsuk,"mtv-news-uk","top"));
        myBaseStructures.add(new MyBaseStructure("National Geographic science-and-nature",R.drawable.nationalgeo,"national-geographic","top"));
        myBaseStructures.add(new MyBaseStructure("New Scientist science-and-nature",R.drawable.newscientist,"new-scientist","top"));
        myBaseStructures.add(new MyBaseStructure("Newsweek general",R.drawable.newsweek,"newsweek","top"));
        myBaseStructures.add(new MyBaseStructure("New York Magazine general",R.drawable.newyorkmagazine,"new-york-magazine","top"));
        myBaseStructures.add(new MyBaseStructure("NFL News sport",R.drawable.nflnews,"nfl-news","top"));
        myBaseStructures.add(new MyBaseStructure("Polygon gaming",R.drawable.polygon,"polygon","top"));
        myBaseStructures.add(new MyBaseStructure("Recode technology",R.drawable.recode,"recode","top"));
        myBaseStructures.add(new MyBaseStructure("Reddit /r/all general",R.drawable.reddit,"reddit-r-all","top"));
        myBaseStructures.add(new MyBaseStructure("Reuters general",R.drawable.reuters,"reuters","top"));
        myBaseStructures.add(new MyBaseStructure("Spiegel Online general",R.drawable.spiegel,"spiegel-online","top"));
        myBaseStructures.add(new MyBaseStructure("T3n technology",R.drawable.tthreen,"t3n","top"));
        myBaseStructures.add(new MyBaseStructure("TalkSport sport",R.drawable.talksport,"talksport","top"));
        myBaseStructures.add(new MyBaseStructure("TechCrunch technology",R.drawable.techcrunch,"techcrunch","top"));
        myBaseStructures.add(new MyBaseStructure("TechRadar technology",R.drawable.techradar,"techradar","top"));
        myBaseStructures.add(new MyBaseStructure("The Economist business",R.drawable.theeconomist,"the-economist","top"));
        myBaseStructures.add(new MyBaseStructure("The Guardian (AU) general",R.drawable.theguardianau,"the-guardian-au","top"));
        myBaseStructures.add(new MyBaseStructure("The Guardian (UK) general",R.drawable.theguardianuk,"the-guardian-uk","top"));
        myBaseStructures.add(new MyBaseStructure("The Hindu general",R.drawable.thehindu,"the-hindu","top"));
        myBaseStructures.add(new MyBaseStructure("The Huffington Post general",R.drawable.thehuffington,"the-huffington-post","top"));
        myBaseStructures.add(new MyBaseStructure("The Lad Bible entertainment",R.drawable.theladbible,"the-lad-bible","top"));
        myBaseStructures.add(new MyBaseStructure("The New York Times general",R.drawable.thenewyork,"the-new-york-times","top"));
        myBaseStructures.add(new MyBaseStructure("The Next Web technology",R.drawable.thenextweb,"the-next-web","top"));
        myBaseStructures.add(new MyBaseStructure("The Sport Bible sport",R.drawable.thesportbible,"the-sport-bible","top"));
        myBaseStructures.add(new MyBaseStructure("The Telegraph general",R.drawable.thetelegraph,"the-telegraph","top"));
        myBaseStructures.add(new MyBaseStructure("The Times of India general",R.drawable.thetimesofindia,"the-times-of-india","top"));
        myBaseStructures.add(new MyBaseStructure("The Verge technology",R.drawable.theverge,"the-verge","top"));
        myBaseStructures.add(new MyBaseStructure("The Wall Street Journal business",R.drawable.thewallstreetjournal,"the-wall-street-journal","top"));
        myBaseStructures.add(new MyBaseStructure("The Washington Post general",R.drawable.thewashingtonpost,"the-washington-post","top"));
        myBaseStructures.add(new MyBaseStructure("Time general",R.drawable.time,"time","top"));
        myBaseStructures.add(new MyBaseStructure("USA Today general",R.drawable.usatoday,"usa-today","top"));
        myBaseStructures.add(new MyBaseStructure("Wired.de technology",R.drawable.wiredde,"wired-de","top"));
        myBaseStructures.add(new MyBaseStructure("Wirtschafts Woche business",R.drawable.wirtschafts,"wirtschafts-woche","latest"));


       /* customAdapter = new CustomAdapter(MainActivity.this, myBaseStructures);
        mylistview.setAdapter(customAdapter);*/

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mylistview.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new RecyclerViewAdapter(myBaseStructures,MainActivity.this);
        mylistview.setAdapter(adapter);

       // mylistview.setOnClickListener(new DrawerItemClickListener());
        mylistview.addOnItemTouchListener(new DrawerItemClickListener());
        //mylistview.setOnTouchListener(new DrawItemTouchListerner());

       // mylistview.setOnItemClickListener(new DrawerItemClickListener());
         setupToolbar();

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        setupDrawerToggle();
        myimages = (ImageView) findViewById(R.id.myimages);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
    private class DrawerItemClickListener implements RecyclerView.OnItemTouchListener {
        GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });
        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if(child != null && gestureDetector.onTouchEvent(e)) {
                int position = rv.getChildAdapterPosition(child);
                Fragment fragment = null;
                if (position>=0){
                    SharedPreferences.Editor shared = getSharedPreferences("channel",MODE_PRIVATE).edit();
                    shared.putString("channel",myBaseStructures.get(position).getChannelsub().toString());
                    shared.putString("sortby",myBaseStructures.get(position).getSortby().toString());
                    shared.commit();
                    fragment = new Home();
                }
                 if (fragment != null) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.myframelyout, fragment).commit();
                    //  mylistview.setItemChecked(position, true);
                    //  mylistview.setSelection(position);
                    setTitle(myBaseStructures.get(position).getChannelname().toLowerCase().toString());
                    drawerLayout.closeDrawer(mylistview);
                }
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

    void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    void setupDrawerToggle() {
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
    //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#ffffff\">" + getString(R.string.app_name) + "</font>")));
}


}
