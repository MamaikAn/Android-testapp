package com.example.testhtc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private final ArrayList<CompanyInfo.Company.Employees> employees;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(@NonNull TextView view) {
            super(view);
            textView = view;
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public RecyclerViewAdapter(CompanyInfo companyInfo) {
        employees = companyInfo.company.employees;
        Collections.sort(employees, new Comparator<CompanyInfo.Company.Employees>() {
            @Override
            public int compare(CompanyInfo.Company.Employees o1, CompanyInfo.Company.Employees o2) {
                if (o1.name == null) {
                    return 1;
                }
                if (o2.name == null) {
                    return -1;
                }
                return o1.name.compareTo(o2.name);
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView textView = new TextView(parent.getContext());
        textView.setPadding(0, 0, 0, 32);
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CompanyInfo.Company.Employees employee = employees.get(position);
        StringBuilder text = new StringBuilder();
        if (employee.name != null) {
            text.append("Name: " + employee.name + "\n");
        }
        if (employee.phone_number != null) {
            text.append("Phone number: " + employee.phone_number + "\n");
        }
        if (employee.skills != null) {
            text.append("Skills: ");
            for (int i = 0; i < employee.skills.length; i++) {
                text.append(employee.skills[i]);
                if (i != employee.skills.length - 1) {
                    text.append(", ");
                }
            }
        }
        holder.getTextView().setText(text);
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }
}
