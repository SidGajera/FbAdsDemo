package com.example.facebookadsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

public class RectangleAd_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle_ad_);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RelativeLayout adContainer = findViewById(R.id.ad_rectangle);
        AdView adView = new AdView(this, "488593069224727_488594735891227"
                , AdSize.RECTANGLE_HEIGHT_250);
        adContainer.addView(adView);

        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("logAdLoadError", "Error: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Toast.makeText(RectangleAd_Activity.this, "onAdLoaded()", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                Toast.makeText(RectangleAd_Activity.this, "onAdClicked()", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        AdView.AdViewLoadConfig loadAdConfig = adView.buildLoadAdConfig().withAdListener(adListener).build();
        adView.loadAd(loadAdConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}