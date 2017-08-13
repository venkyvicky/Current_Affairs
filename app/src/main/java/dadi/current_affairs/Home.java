package dadi.current_affairs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Home extends Fragment implements View.OnClickListener {
    CardView entertainment, myhindu, Gaming, Music, Politics, Science, Sport, Technology,general;
    View context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //  return super.onCreateView(inflater, container, savedInstanceState);
        context = inflater.inflate(R.layout.home, null);
       // context = x;
       /* card_view  = (CardView) x.findViewById(R.id.card_view);
        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    Animation myAnim = AnimationUtils.loadAnimation(context.getContext(), R.anim.bounce);
                    card_view.startAnimation(myAnim);
                 }
            }
        });*/
     //   card_view_general = (CardView) x.findViewById(R.id.card_view_games);
        myhindu = (CardView) context.findViewById(R.id.card_view_busines);
        entertainment = (CardView) context.findViewById(R.id.card_view_ent);
        Gaming = (CardView) context.findViewById(R.id.card_view_games);
        general = (CardView) context.findViewById(R.id.card_view_general);
        Music = (CardView) context.findViewById(R.id.card_view_music);
        Politics = (CardView)context.findViewById(R.id.card_view_politc);
        Science = (CardView) context.findViewById(R.id.card_view_nature);
        Sport = (CardView) context.findViewById(R.id.card_view_sports);
        Technology = (CardView) context.findViewById(R.id.card_view_technology);

        /*Animation myAnim = AnimationUtils.loadAnimation(x.getContext(), R.anim.bounce);
        myhindu.startAnimation(myAnim);

        Animation myAnim_ent = AnimationUtils.loadAnimation(x.getContext(), R.anim.dancing);
        entertainment.startAnimation(myAnim_ent);
*/

        myhindu.setOnClickListener(this);
        entertainment.setOnClickListener(this);
        Gaming.setOnClickListener(this);
        general.setOnClickListener(this);
        Music.setOnClickListener(this);
        Politics.setOnClickListener(this);
        Science.setOnClickListener(this);
        Sport.setOnClickListener(this);
        Technology.setOnClickListener(this);


        return context;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.card_view_general:
                Intent card_view_general = new Intent(context.getContext(), NewsToday.class);
                card_view_general.putExtra("category","general");
                startActivity(card_view_general);
                break;
            case R.id.card_view_games:
                Intent newstoday = new Intent(context.getContext(), NewsToday.class);
                newstoday.putExtra("category","gaming");
                startActivity(newstoday);
                break;
            case R.id.card_view_music:
                Intent card_view_music = new Intent(context.getContext(), NewsToday.class);
                card_view_music.putExtra("category","music");
                startActivity(card_view_music);
                break;

            case R.id.card_view_politc:
                Intent card_view_politc = new Intent(context.getContext(), NewsToday.class);
                card_view_politc.putExtra("category","politics");
                startActivity(card_view_politc);
                break;
            case R.id.card_view_nature:
                Intent card_view_nature = new Intent(context.getContext(), NewsToday.class);
                card_view_nature.putExtra("category","science-and-nature");
                startActivity(card_view_nature);
                break;
            case R.id.card_view_sports:
                Intent card_view_sports = new Intent(context.getContext(), NewsToday.class);
                card_view_sports.putExtra("category","sport");
                startActivity(card_view_sports);
                break;
            case R.id.card_view_technology:
                Intent card_view_technology = new Intent(context.getContext(), NewsToday.class);
                card_view_technology.putExtra("category","technology");
                startActivity(card_view_technology);
                break;
            case R.id.card_view_busines:
                Intent card_view_busines = new Intent(context.getContext(), NewsToday.class);
                card_view_busines.putExtra("category","business");
                startActivity(card_view_busines);
                break;
            case R.id.card_view_ent:
                Intent card_view_ent = new Intent(context.getContext(), NewsToday.class);
                card_view_ent.putExtra("category","entertainment");
                startActivity(card_view_ent);
                break;
        }
    }
}
