package com.dg.livedataexample.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dg.livedataexample.R;
import com.dg.livedataexample.models.NameModel;

import java.util.List;

/**
 * Created by Giang Long on 9/10/2018.
 * Skype: gianglong7695@gmail.com (id: gianglong7695_1)
 * Phone: 0979 579 283
 */
public class ListNameAdapter extends RecyclerView.Adapter<ListNameAdapter.ViewHolder> {
    private Context context;
    private List<NameModel> listName;


    public ListNameAdapter(Context context, List<NameModel> listName) {
        this.context = context;
        this.listName = listName;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, null));
    }


    public void setListName(List<NameModel> listName) {
        this.listName = listName;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(listName.get(position));
    }

    @Override
    public int getItemCount() {
        return listName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id, tv_name;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_name = itemView.findViewById(R.id.tv_name);
        }


        public void setData(NameModel nameModel) {
            tv_id.setText(nameModel.getId() + "");
            tv_name.setText(nameModel.getName());
        }
    }
}
