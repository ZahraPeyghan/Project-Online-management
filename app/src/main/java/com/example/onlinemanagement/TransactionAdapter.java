package com.example.onlinemanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {
    Context context;
    ArrayList<TransactionModel> transactionModels;
    public TransactionAdapter(Context context, ArrayList<TransactionModel> transactionModels){
        this.context=context;
        this.transactionModels=transactionModels;
    }
    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_transaction,null);

        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  TransactionAdapter.TransactionViewHolder holder, int position) {
       TransactionModel model=transactionModels.get(position);
       holder.txtname.setText(model.getTransactionName());
       holder.txtaccount.setText(model.getTransactionAccount());
       holder.txtprice.setText(model.getTransactionPrice());
    }

    @Override
    public int getItemCount() {
        return transactionModels.size();
    }

    public class TransactionViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtname,txtaccount,txtprice;
        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.transaction_image);
            txtname=itemView.findViewById(R.id.transaction_name);
            txtaccount=itemView.findViewById(R.id.transaction_account);
            txtprice=itemView.findViewById(R.id.transaction_price);
        }
    }
}

