package com.socialcodia.famblah.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.socialcodia.famblah.R;
import com.socialcodia.famblah.model.ModelGroup;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterGroup extends RecyclerView.Adapter<AdapterGroup.ViewHolder> {

    List<ModelGroup> modelGroupList;
    Context context;

    public AdapterGroup(List<ModelGroup> modelGroupList, Context context) {
        this.modelGroupList = modelGroupList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_group,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String groupName = modelGroupList.get(position).getName();
        String groupImage = modelGroupList.get(position).getImage();

        holder.tvGroupName.setText(groupName);
        try {
            Picasso.get().load(groupImage).into(holder.groupImageIcon);
        }
        catch (Exception e)
        {
            Toast.makeText(context, "Oops! Something went wrong to load the group image"+e.getMessage(), Toast.LENGTH_LONG).show();
            Picasso.get().load(R.drawable.person_female).into(holder.groupImageIcon);
        }

        holder.groupLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Hello Group", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelGroupList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tvGroupName,tvLastMessageSenderName,tvLastMessage;
        private ImageView groupImageIcon;
        private ConstraintLayout groupLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvGroupName = itemView.findViewById(R.id.tvGroupName);
            tvLastMessage = itemView.findViewById(R.id.tvLastMessage);
            tvLastMessageSenderName = itemView.findViewById(R.id.tvLastMessageSenderName);
            groupImageIcon = itemView.findViewById(R.id.groupImageIcon);
            groupLayout = itemView.findViewById(R.id.groupLayout);

        }
    }
}