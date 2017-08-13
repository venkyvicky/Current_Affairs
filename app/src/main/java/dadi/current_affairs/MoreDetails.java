package dadi.current_affairs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class MoreDetails extends AppCompatActivity {
 WebView mywebview;
    TextView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_details);
       // back = (TextView)findViewById(R.id.back);
        mywebview = (WebView)findViewById(R.id.mywebview);
        WebSettings mywebsettings = mywebview.getSettings();
        mywebsettings.setJavaScriptEnabled(true);
        mywebview.loadUrl(getIntent().getStringExtra("weburl"));
      /*  back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/
    }
}
