package com.example.onlinemanagement;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.onlinemanagement.databinding.FragmentCostBinding;
import com.example.onlinemanagement.databinding.FragmentIncomeBinding;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class CostFragment extends Fragment {
    public CostFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    FragmentCostBinding binding;
    FirebaseAuth auth;
    FirebaseFirestore database;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentCostBinding.inflate(inflater,container,false);
        database=FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();
        binding.btnsabthazineh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price,grouping,account,date,discription;
                price=binding.boxprice.getText().toString();
                grouping=binding.boxgrouping.getText().toString();
                account=binding.boxaccount.getText().toString();
                date=binding.boxdate.getText().toString();
                discription=binding.boxdiscription.getText().toString();
                Cost cost =new Cost(price,grouping,account,date,discription);
                database
                        .collection("Cost")
                        .document()
                        .set(cost).addOnCompleteListener(new View.OnClickListener<Void>()
                {
                    @Override
                    public void onComplete(@NonNull Task<Void> task){
                        Toast.makeText(IncomeFragment.this,"هزینه شما ثبت شد",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        return inflater.inflate(R.layout.fragment_cost, container, false);
    }
}