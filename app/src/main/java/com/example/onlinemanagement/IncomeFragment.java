package com.example.onlinemanagement;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.onlinemanagement.databinding.ActivityMainBinding;
import com.example.onlinemanagement.databinding.FragmentIncomeBinding;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class IncomeFragment extends Fragment {
    public IncomeFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    FragmentIncomeBinding binding;
    FirebaseAuth auth;
    FirebaseFirestore database;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentIncomeBinding.inflate(inflater,container,false);
        database=FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();
        binding.btnsabtdaramad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price,grouping,account,date,discription;
                price=binding.pricebox.getText().toString();
                grouping=binding.groupingbox.getText().toString();
                account=binding.accountbox.getText().toString();
                date=binding.datebox.getText().toString();
                discription=binding.discriptionbox.getText().toString();
                Income income =new Income(price,grouping,account,date,discription);
                database
                        .collection("Income")
                        .document()
                        .set(income).addOnCompleteListener(new View.OnClickListener<Void>()
                {
                    @Override
                    public void onComplete(@NonNull Task<Void> task){
                        Toast.makeText(IncomeFragment.this,"درآمد شما ثبت شد",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        return inflater.inflate(R.layout.fragment_income, container, false);
    }
}