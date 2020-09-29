package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.domain.Bike;
import com.example.myapplication.domain.User;
import com.example.myapplication.domain.UserService;
import com.example.myapplication.domain.UserServiceFactory;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BikesRecycleViewAdapter extends RecyclerView.Adapter<BikesRecycleViewAdapter.ViewHolder> {

    private List<Bike> bikes;
    private Context context;
    private boolean onClickEnable;

    public BikesRecycleViewAdapter(List<Bike> bikeList, Context context, boolean onClickEnable) {
        this.bikes = bikeList;
        this.context = context;
        this.onClickEnable = onClickEnable;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_bike, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Bike bike = bikes.get(position);

        TextView description = holder.description;
        description.setText(bike.getDescription());

        ImageView picture = holder.picture;
        Picasso.get().load(bike.getImageUrl()).into(picture);

        TextView name = holder.name;
        name.setText(bike.getName());

        TextView price = holder.price;
        price.setText(bike.getPrice());

        if(this.onClickEnable) {
            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, bike.getName(), Toast.LENGTH_LONG).show();
                    UserService userService = UserServiceFactory.getInstance(context);
                    User user = userService.getCurrentlyLoginUser().get();
                    user.addBike(bike);
                    userService.setCurrentlyLoginUser(user);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return bikes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView description;
        public ImageView picture;
        public LinearLayout parent;
        public TextView name;
        public TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            description = (TextView) itemView.findViewById((R.id.description));
            picture = (ImageView) itemView.findViewById((R.id.picture));
            parent = (LinearLayout) itemView.findViewById(R.id.parent);
            price = (TextView) itemView.findViewById(R.id.price);
        }
    }


}
