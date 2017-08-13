package dadi.current_affairs;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Hindu extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
      //  return super.onCreateView(inflater, container, savedInstanceState);
        View x =  inflater.inflate(R.layout.hindu,null);
        return x;
    }
}
