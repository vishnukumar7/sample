package com.android.vishnu.allapps;

import android.annotation.SuppressLint;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WifiAdpater extends RecyclerView.Adapter<WifiAdpater.CustomViewHolder> {

    List<ScanResult> scanResultList;

    public WifiAdpater(List<ScanResult> scanResultList){
        this.scanResultList=scanResultList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_scan_result,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        ScanResult scanResult=scanResultList.get(position);
        holder.textView.setText(scanResult.BSSID);
        holder.textView1.setText(scanResult.capabilities);
        holder.textView2.setText(scanResult.SSID);
        holder.textView3.setText(scanResult.frequency);
        holder.textView4.setText(scanResult.level);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            holder.textView5.setText(scanResult.venueName);
        }
        else{
            holder.textView5.setText("no found");
        }
    }

    @Override
    public int getItemCount() {
        return scanResultList.size();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView textView,textView1,textView2,textView3,textView4,textView5;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            textView1=itemView.findViewById(R.id.textView1);
            textView2=itemView.findViewById(R.id.textView2);
            textView3=itemView.findViewById(R.id.textView3);
            textView4=itemView.findViewById(R.id.textView4);
            textView5=itemView.findViewById(R.id.textView5);
        }
    }
}
