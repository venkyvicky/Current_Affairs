package dadi.current_affairs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Srinivas on 4/29/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    ArrayList<NewsTodayStructure> myBaseStructures;
    Context context;
    public CustomAdapter(ArrayList<NewsTodayStructure> myBaseStructures, NewsToday mainActivity) {
        this.myBaseStructures = myBaseStructures;
        this.context = mainActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.singlelistview, viewGroup, false);
        return new CustomAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.tv_country.setText(myBaseStructures.get(position).getTitle().toString());
      //  viewHolder.myimageview.setImageDrawable(context.getResources().getDrawable(myBaseStructures.get(position).getChannellogo()));
        Picasso.with(context)
                .load(myBaseStructures.get(position).getUrlToImage().toString())
                .into(viewHolder.myimg);
    }


    @Override
    public int getItemCount() {
        return myBaseStructures.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_country;
        private ImageView myimg;
        public ViewHolder(View view) {
            super(view);
            tv_country = (TextView)view.findViewById(R.id.mytextveiw_single);
            myimg = (ImageView) view.findViewById(R.id.myimageview_single);
        }
    }

  /*  ArrayList<MyBaseStructure> myBaseStructures;
    Context context;

    public CustomAdapter(MainActivity mainActivity, ArrayList<MyBaseStructure> myBaseStructures) {
        this.context = mainActivity;
        this.myBaseStructures = myBaseStructures;
    }

    @Override
    public int getCount() {
        return myBaseStructures.size();
    }

    @Override
    public Object getItem(int i) {
        return myBaseStructures.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater;
        if (view == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.singlelistview, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.mytextveiw);
        textView.setText(myBaseStructures.get(i).getChannelname().toString());

        ImageView myimageview = (ImageView) view.findViewById(R.id.myimageview);
        //myimageview.setImageResource(R.drawable.abc);

        myimageview.setImageDrawable(view.getResources().getDrawable(myBaseStructures.get(i).getChannellogo()));


        return view;
    }*/
}
