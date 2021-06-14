package com.example.onlinemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.AdapterView;

import com.example.onlinemanagement.databinding.ActivityDashboardBinding;
import com.example.onlinemanagement.databinding.ActivityMainBinding;
import com.example.onlinemanagement.databinding.FragmentCostBinding;
import com.example.onlinemanagement.databinding.FragmentIncomeBinding;
import com.example.onlinemanagement.databinding.FragmentReportBinding;

import java.util.ArrayList;

import me.ibrahimsn.lib.OnItemSelectedListener;

public class DashboardActivity extends AppCompatActivity {
    ActivityDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content,new ReportFragment());
        transaction.commit();
        binding.bottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

                switch (i)
                {
                    case 0:
                        transaction.replace(R.id.content,new ReportFragment());
                        transaction.commit();
                        break;
                    case 1:
                        transaction.replace(R.id.content,new IncomeFragment());
                        transaction.commit();
                        break;
                    case  2:
                        transaction.replace(R.id.content,new CostFragment());
                        transaction.commit();
                        break;
                }
                return false;
            }
        });

    }
}