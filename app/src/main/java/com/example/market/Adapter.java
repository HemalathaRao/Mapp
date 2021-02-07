package com.example.market;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
        private List<ListModel> listdata;
        private Context context;



        // RecyclerView recyclerView;
        public Adapter(Context applicationContext, List<ListModel> listdata) {
            this.listdata = listdata;
            this.context = applicationContext;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            ViewHolder viewHolder;
            View listItem= layoutInflater.inflate(R.layout.card_list, parent, false);

            viewHolder = new ViewHolder(listItem);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final ListModel myListData = listdata.get(position);
            holder.item.setText(listdata.get(position).getName());
            holder.desc.setText(listdata.get(position).getDescription());
            holder.price.setText(listdata.get(position).getPrice());
            holder.cate.setText(listdata.get(position).getCategory());



            holder.actn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                }
            });
        }


        @Override
        public int getItemCount() {
            return listdata.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView item,desc,price,cate,actn;

            public ViewHolder(View itemView) {
                super(itemView);


                this.item= itemView.findViewById(R.id.item);
                this.desc = (TextView) itemView.findViewById(R.id.desc);


                this.price = (TextView) itemView.findViewById(R.id.price);
                this.cate = (TextView) itemView.findViewById(R.id.cate);


                this.actn = (TextView) itemView.findViewById(R.id.actn);

            }
        }
    }

