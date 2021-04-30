package com.example.facebookadsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;

public class RewardAd_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_ad_);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final RewardedVideoAd rewardedVideoAd = new RewardedVideoAd(this, "488593069224727_488595159224518");
        RewardedVideoAdListener rewardedVideoAdListener = new RewardedVideoAdListener() {
            @Override
            public void onError(Ad ad, AdError error) {
                Toast.makeText(RewardAd_Activity.this, "Sorry, error on loading the ad. Try again!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Toast.makeText(RewardAd_Activity.this, "onAdLoaded()", Toast.LENGTH_SHORT).show();
                rewardedVideoAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                Toast.makeText(RewardAd_Activity.this, "onAdClicked()", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoggingImpression(Ad ad) {
            }

            @Override
            public void onRewardedVideoCompleted() {
                Toast.makeText(RewardAd_Activity.this, "Ad completed, now give reward to user", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoClosed() {
                Toast.makeText(RewardAd_Activity.this, "VideoClosed()", Toast.LENGTH_SHORT).show();
            }
        };
        rewardedVideoAd.loadAd(rewardedVideoAd.buildLoadAdConfig().withAdListener(rewardedVideoAdListener).build());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}