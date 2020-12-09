package com.example.testhtc;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.*;
import java.net.URL;

public class Application {
    protected RecyclerView recyclerView;
    protected MainActivity activity;
    protected StringBuilder jsonString = new StringBuilder();
    protected CompanyInfo companyInfo;

    public Application(RecyclerView view, MainActivity mainActivity) {
        recyclerView = view;
        activity = mainActivity;
    }

    public void main() {
        new Thread(() -> {
            try {
                ReadURL();
            } catch (Exception e) {
                activity.showErrorMessage("Error on reading JSON from URL");
                return;
            }

            try {
                parseJSON();
            } catch (Exception e) {
                activity.showErrorMessage("Error on parsing JSON");
                return;
            }

            try {
                updateRecyclerView();
            } catch (Exception e) {
                activity.showErrorMessage("Error on setting text in RecyclerView");
                return;
            }

        }).start();
    }

    protected void ReadURL() throws Exception {
        URL url = new URL("https://www.mocky.io/v2/5ddcd3673400005800eae483");
        BufferedReader input = new BufferedReader(
                new InputStreamReader(url.openStream()));
        String inputLine;
        while ((inputLine = input.readLine()) != null) {
            jsonString.append(inputLine);
        }
        input.close();
    }

    protected void parseJSON() {
        Gson gson = new Gson();
        companyInfo = gson.fromJson(jsonString.toString(), CompanyInfo.class);
    }

    protected void updateRecyclerView() {
        activity.runOnUiThread(() -> {
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));
            recyclerView.setAdapter(new RecyclerViewAdapter(companyInfo));
        });
    }
}
