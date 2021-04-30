package com.example.facebookadsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.ads.AbstractAdListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

public class InterstitialAd_Activity extends AppCompatActivity {

    TextView txStatus;
    ProgressBar progress;
    private final String TAG = InterstitialAd_Activity.class.getSimpleName();
    boolean canShowFullscreenAd;
    InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial_ad_);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txStatus = findViewById(R.id.interstitial_status);
        progress = findViewById(R.id.interstitial_progress);

        interstitialAd = new InterstitialAd(this,"488593069224727_488594119224622");
        Log.e(TAG, "onCreate: " + interstitialAd );

        AbstractAdListener adListener = new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError error) {
                progress.setVisibility(View.GONE);
                txStatus.setText("Ad Failed to load");
                Toast.makeText(InterstitialAd_Activity.this, "Error loading ad: " + error.getErrorMessage(), Toast.LENGTH_SHORT).show();
                super.onError(ad, error);
            }

            @Override
            public void onAdLoaded(Ad ad) {
                super.onAdLoaded(ad);
                txStatus.setText("Ad Loaded");
                if (canShowFullscreenAd) {
                    interstitialAd.show();
                }
            }

            @Override
            public void onAdClicked(Ad ad) {
                super.onAdClicked(ad);
            }

            @Override
            public void onInterstitialDisplayed(Ad ad) {
                super.onInterstitialDisplayed(ad);
                progress.setVisibility(View.GONE);
                txStatus.setText("Ad Displayed");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                super.onInterstitialDismissed(ad);
                progress.setVisibility(View.GONE);
                txStatus.setText("Ad Closed");
            }
        };
        InterstitialAd.InterstitialLoadAdConfig interstitialLoadAdConfig = interstitialAd.buildLoadAdConfig()
                .withAdListener(adListener).build();
        interstitialAd.loadAd(interstitialLoadAdConfig);
    }

//    private void showAdWithDelay() {
//        /**
//         * Here is an example for displaying the ad with delay;
//         * Please do not copy the Handler into your project
//         */
//         Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            public void run() {
//                // Check if interstitialAd has been loaded successfully
//                if(interstitialAd == null || !interstitialAd.isAdLoaded()) {
//                    return;
//                }
//                // Check if ad is already expired or invalidated, and do not show ad if that is the case. You will not get paid to show an invalidated ad.
//                if(interstitialAd.isAdInvalidated()) {
//                    return;
//                }
//                // Show the ad
//                interstitialAd.show();
//            }
//        }, 1000 * 60 * 15); // Show the ad after 15 minutes
//    }

    @Override
    protected void onPause() {
        super.onPause();
        canShowFullscreenAd = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        canShowFullscreenAd = true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        super.onDestroy();
    }
}