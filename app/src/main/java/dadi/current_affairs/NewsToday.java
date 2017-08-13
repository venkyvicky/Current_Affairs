package dadi.current_affairs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NewsToday extends Activity implements View.OnClickListener{
    RecyclerView myrecycleview;
    ArrayList<NewsTodayStructure> countries;
    ImageView today_image,collapse;
    TextView new_description, new_title;
    LinearLayout ll_back;
    String category,url,timestamp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_today);
        ll_back = (LinearLayout)findViewById(R.id.ll_back);
         today_image = (ImageView) findViewById(R.id.today_image);
        collapse = (ImageView) findViewById(R.id.collapse);
        new_title = (TextView) findViewById(R.id.new_title);
        new_description = (TextView) findViewById(R.id.new_description);
        myrecycleview = (RecyclerView) findViewById(R.id.myrecycleview);
        category = getIntent().getStringExtra("category").toString();
     //   Toast.makeText(getBaseContext(),category.toString(),Toast.LENGTH_SHORT).show();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        myrecycleview.setLayoutManager(layoutManager);
        countries = new ArrayList<NewsTodayStructure>();

        new NewsToday.Mylatestnews().execute();
        myrecycleview.addOnItemTouchListener(new NewsToday.DrawerItemClickListener());
        today_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation myAnim = AnimationUtils.loadAnimation(NewsToday.this, R.anim.zoomin);
                today_image.startAnimation(myAnim);
            }
        });
        ll_back.setOnClickListener(this);
        new_description.setOnClickListener(this);

        //new Mylatestnews().execute();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.new_description:
                  mydescription(new_description.getText().toString());
                break;
        }
    }

    void mydescription(String description){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(NewsToday.this);
        // Setting Dialog Title
        alertDialog.setTitle("Bestapphome");
        // Setting Dialog Message
        alertDialog.setMessage(description);
        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.al);
        // Setting Positive "Yes" Button
       alertDialog.setPositiveButton("More", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
               Intent intent = new Intent(NewsToday.this,MoreDetails.class);
                intent.putExtra("weburl",url.toString());
                startActivity(intent);
            }
        });
        // Showing Alert Message
        alertDialog.show();
    }
    private class DrawerItemClickListener implements RecyclerView.OnItemTouchListener {
        GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && gestureDetector.onTouchEvent(e)) {
                int position = rv.getChildAdapterPosition(child);
                Picasso.with(NewsToday.this)
                        .load(countries.get(position).getUrlToImage().toString())
                        .into(today_image);
                new_description.setText(countries.get(position).getDescription().toString());
                new_title.setText(countries.get(position).getTitle().toString());
                url = countries.get(position).getUrl().toString();
                timestamp = countries.get(position).getPublishedAt().toString();
                Animation myAnim = AnimationUtils.loadAnimation(NewsToday.this, R.anim.zoomin);
                today_image.startAnimation(myAnim);
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

    class Mylatestnews extends AsyncTask<String, String, JSONObject> {
        private JSONObject json;
        ArrayList<NameValuePair> nameValuePairs;

        public Mylatestnews() {
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            super.onPostExecute(jsonObject);
           // Log.d("values",jsonObject.toString());
            try {
                JSONObject result = new JSONObject(jsonObject.toString());
                if (result.getString("status").equals("ok")) {
                    JSONArray jsonArray = result.getJSONArray("articles");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject last = jsonArray.getJSONObject(i);
                        //last.getString("author");
                        countries.add(new NewsTodayStructure(last.getString("author"), last.getString("title"), last.getString("description"),
                                last.getString("url"), last.getString("urlToImage"), last.getString("publishedAt")));
                        if (i == 0) {
                            Picasso.with(NewsToday.this)
                                    .load(countries.get(i).getUrlToImage().toString())
                                    .into(today_image);
                            new_description.setText(countries.get(i).getDescription().toString());
                            new_title.setText(countries.get(i).getTitle().toString());
                            url = countries.get(i).getUrl().toString();
                            timestamp = countries.get(i).getPublishedAt().toString();
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            RecyclerView.Adapter adapter = new CustomAdapter(countries, NewsToday.this);
            myrecycleview.setAdapter(adapter);
        }

        @Override
        protected JSONObject doInBackground(String... strings) {
            nameValuePairs = new ArrayList<NameValuePair>();
            SharedPreferences xx = getSharedPreferences("channel",MODE_PRIVATE);

            nameValuePairs.add(new BasicNameValuePair("apiKey", "c5595d75ac024309a66f62a2a1c6e243"));
           // https:
//newsapi.org/v1/articles?source=the-next-web&sortBy=latest&apiKey=c5595d75ac024309a66f62a2a1c6e243

            nameValuePairs.add(new BasicNameValuePair("source", xx.getString("channel","").toString()));
            nameValuePairs.add(new BasicNameValuePair("category", category.toString()));
            nameValuePairs.add(new BasicNameValuePair("sortBy",  xx.getString("sortby","").toString()));
            json = JSONParser.makeServiceCall("https://newsapi.org/v1/articles", 1, nameValuePairs);
          //  json = JSONParser.makeServiceCall("http://timesofindia.indiatimes.com/rssfeeds/-2128936835.cms", 1, nameValuePairs);
            return json;
        }
    }
}
