package com.wrstech.spotour;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by wilso on 4/1/2018.
 */

public class PlaceAdapter extends ArrayAdapter<Place>{

    Intent intent;
    String placeq, type;

    public PlaceAdapter(Activity context, ArrayList<Place> place, String p, String t){
        super (context, 0, place);
        placeq = p;
        type = t;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        final Place currentPlace = getItem(position);

        ImageView image = (ImageView)listItemView.findViewById(R.id.image_place);
        image.setImageResource(currentPlace.getPicture());

        final TextView place_text = (TextView)listItemView.findViewById(R.id.place_txt);
        place_text.setText(currentPlace.getPlaceTitle());

        Button Tbtn = (Button)listItemView.findViewById(R.id.btn2);

        Tbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getContext(), Main3Activity.class);

                intent.putExtra("info", currentPlace.getInfo());
                intent.putExtra("title", currentPlace.getPlaceTitle());
                intent.putExtra("place", placeq);
                intent.putExtra("type", type);
                intent.putExtra("position", position);

                getContext().startActivity(intent);

            }
        });

        return listItemView;
    }
}
