package com.naza.myapplication;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class OldStatusAdapter extends RecyclerView.Adapter<OldStatusAdapter.OldStatusViewHolder>{
    ArrayList<BMIRecord> bmi_record;

    public OldStatusAdapter(ArrayList<BMIRecord> bmi_record) {
        this.bmi_record = bmi_record;
    }

    @NonNull
    @Override
    public OldStatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View status_custom_item = LayoutInflater.from(parent.getContext()).inflate(R.layout.old_status_item,null,false);
        OldStatusViewHolder holder = new OldStatusViewHolder(status_custom_item);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull OldStatusViewHolder holder, int position) {
        BMIRecord current_bmi = bmi_record.get(position);
        holder.date.setText(current_bmi.getDate().toString());
        holder.weight.setText(Float.toString(current_bmi.getWeight()));
        holder.status.setText(current_bmi.getBmiMessage());
        holder.length.setText(Float.toString(current_bmi.getLength()));

    }


    @Override
    public int getItemCount() {
        return bmi_record.size();
    }





    class OldStatusViewHolder extends RecyclerView.ViewHolder{
        TextView date,weight,status,length;
        public OldStatusViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.old_status_tv_date);
            weight=itemView.findViewById(R.id.old_status_tv_weight);
            bmi-message=itemView.findViewById(R.id.old_status_tv_message);
            length=itemView.findViewById(R.id.old_status_tv_length);
        }
    }
}


