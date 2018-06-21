package qthjen_dev.io.bestperformanceloadmorerecyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MAdapter extends RecyclerView.Adapter<MAdapter.ViewHolder> {

    private Context context;
    private ArrayList<MModel> list;

    public MAdapter(Context context,  ArrayList<MModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(list.get(position).getName());
        holder.tvNumber.setText(list.get(position).getNumber());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {

        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads);
        } else {
            Bundle o = (Bundle) payloads.get(0);
            for (String key : o.keySet()) {
                if (key.equals("name")) {
                    Toast.makeText(context, "MModel " + position + " name changed" , Toast.LENGTH_SHORT).show();
                    holder.tvName.setText(list.get(position).getName());
                }
                if (key.equals("number")) {
                    Toast.makeText(context, "MModel " + position + " name changed" , Toast.LENGTH_SHORT).show();
                    holder.tvNumber.setText(list.get(position).getNumber());
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvNumber;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.name);
            tvNumber = itemView.findViewById(R.id.number);
        }
    }

//    public ArrayList<MModel> getData() {
//        return list;
//    }

    public void onNewData(ArrayList<MModel> newData) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new Utils(newData, list));
        diffResult.dispatchUpdatesTo(this);
        this.list.clear();
        this.list.addAll(newData);
    }
}
