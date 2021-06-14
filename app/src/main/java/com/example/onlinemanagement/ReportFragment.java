package com.example.onlinemanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlinemanagement.databinding.ActivityMainBinding;
import com.example.onlinemanagement.databinding.FragmentIncomeBinding;
import com.example.onlinemanagement.databinding.FragmentReportBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class ReportFragment extends Fragment {
    public ReportFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentReportBinding binding;
        FirebaseAuth auth;
        FirebaseFirestore database;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentReportBinding.inflate(inflater,container,false);
        database=FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();
        ArrayList<TransactionModel> transactions=new ArrayList<>();
        transactions.add(new TransactionModel("","اتومبیل-بنزین","حساب خانه ما","","50,000"));
        transactions.add(new TransactionModel("","خوراک-رستوران","حساب خانه ما","","25,000"));
        transactions.add(new TransactionModel("","خرید-لباس","حساب خانه ما","","150,000"));
        transactions.add(new TransactionModel("","حقوق","حساب خانه ما","","1,500,000"));
        TransactionAdapter adapter=new TransactionAdapter(this,transactions);
        binding.transaction_list.setAdapter(adapter);
        return inflater.inflate(R.layout.fragment_report, container, false);
    }
}