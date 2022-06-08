package com.abrari.forex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private ProgressBar loadingProgressBar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView aedTextView, afnTextView, allTextView, amdTextView, arsTextView, brlTextView, hkdTextView, inrTextView, jpyTextView, rubTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout1);
        aedTextView = (TextView) findViewById(R.id.aedTextView);
        afnTextView = (TextView) findViewById(R.id.afnTextView);
        allTextView = (TextView) findViewById(R.id.allTextView);
        amdTextView = (TextView) findViewById(R.id.amdTextView);
        arsTextView = (TextView) findViewById(R.id.arsTextView);
        brlTextView = (TextView) findViewById(R.id.brlTextView);
        hkdTextView = (TextView) findViewById(R.id.hkdTextView);
        inrTextView = (TextView) findViewById(R.id.inrTextView);
        jpyTextView = (TextView) findViewById(R.id.jpyTextView);
        rubTextView = (TextView) findViewById(R.id.rubTextView);
        loadingProgressBar = (ProgressBar) findViewById(R.id.loadingProgressBar);

        initSwipeRefreshLayout();
        initForex();
    }

    private void initSwipeRefreshLayout(){
        swipeRefreshLayout.setOnRefreshListener((){
            initForex();
            swipeRefreshLayout.setRefreshing(false);
        });
    }

    public String formatNumber(double number, String format){
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(number);
    }

    private void initForex(){
        loadingProgressBar.setVisibility(TextView.VISIBLE);
        String url = "https://openexchangerates.org/api/latest.json?app_id=4fad9c8cf01749578cfe96894c33096f";
    }
}