package com.example.onlinemanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlinemanagement.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class ReportFragment extends Fragment {
    public ReportFragment() {
        // Required empty public constructor
        ActivityMainBinding binding;
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    ArrayList<TransactionModel> transactions=new ArrayList<>();
        transactions.add(new TransactionModel("","اتومبیل-بنزین","حساب خانه ما","","50,000"));
        transactions.add(new TransactionModel("","خوراک-رستوران","حساب خانه ما","","25,000"));
        transactions.add(new TransactionModel("","خرید-لباس","حساب خانه ما","","150,000"));
        transactions.add(new TransactionModel("","حقوق","حساب خانه ما","","1,500,000"));
    TransactionAdapter adapter=new TransactionAdapter(this,transactions);
    binding.transaction_list.setAdapter(adapter);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report, container, false);
    }
}