package dadi.current_affairs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Srinivas on 4/29/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<MyBaseStructure> countries;

    Context context;

    public RecyclerViewAdapter(ArrayList<MyBaseStructure> myBaseStructures, MainActivity mainActivity) {
        this.countries = myBaseStructures; this.context = mainActivity;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.newssingleview, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder viewHolder, int position) {
        viewHolder.tv_country.setText(countries.get(position).getChannelname().toString());
        viewHolder.myimageview.setImageDrawable(context.getResources().getDrawable(countries.get(position).getChannellogo()));

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_country;
        private ImageView myimageview;

        public ViewHolder(View view) {
            super(view);

            tv_country = (TextView) view.findViewById(R.id.mytextveiw);
            myimageview = (ImageView) view.findViewById(R.id.myimageview);
        }
    }


}

