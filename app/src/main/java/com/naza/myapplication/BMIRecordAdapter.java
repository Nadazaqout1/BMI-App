package com.naza.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

   public abstract class BMIRecordAdapter extends RecyclerView.Adapter<BMIRecordHolder> {

     private User user;
     private Context context;

     public BMIRecordAdapter(User user,Context context){
         this.user = user;
         this.context = context;
     }


    public BMIRecordHolder onCreateViewHolder(@NonNull ViewGroup parent.int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.old_status_item, parent);
        return new BMIRecordHolder(view);
    }


     public void onBindViewHolder(@NonNull BMIRecordHolder holder,int position){
         BMIRecord record =user.getRecords().get(position);
         holder.setBMIRecord(record);
     }

     public int getItemCount(){ return user.getRecords().size(); }

}
