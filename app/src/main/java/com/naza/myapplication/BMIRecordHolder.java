package com.naza.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BMIRecordHolder extends RecyclerView.ViewHolder {

    private final TextView date;
    private final TextView weight;
    private final TextView length;
    private final TextView message;
    private BMIRecord record;
    private View itemView;

    public BMIRecordHolder(@NonNull View itemView) {
        super(itemView);
        this.date = itemView.findViewById(R.id.old_status_tv_date);
        this.weight =itemView.findViewById(R.id.old_status_tv_weight);
        this.length =itemView.findViewById(R.id.old_status_tv_length);
        this.message =itemView.findViewById(R.id.old_status_tv_message);

    }

    public void setBMIRecord(BMIRecord record){
        this.record = record;
        date.setText(record.getDate());
        weight.setText(record.getWeight());
        length.setText(record.getLength());
        message.setText(record.getBmiMessage());
    }
}
