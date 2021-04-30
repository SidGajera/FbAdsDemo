package com.example.facebookadsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    MaterialCardView cdBanner, cdInterstitial, cdRectangle, cdReward, cdNative, cdNativeBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cdBanner = findViewById(R.id.cdBanner);
        cdRectangle = findViewById(R.id.cdRectangle);
        cdInterstitial = findViewById(R.id.cdInterstitial);
        cdReward = findViewById(R.id.cdReward);
        cdNative = findViewById(R.id.cdNative);
        cdNativeBanner = findViewById(R.id.cdNativeBanner);

        cdBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BannerAd_Activity.class));
            }
        });

        cdRectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RectangleAd_Activity.class));
            }
        });

        cdInterstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InterstitialAd_Activity.class));
            }
        });

        cdReward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RewardAd_Activity.class));
            }
        });

        cdNative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NativeAd_Activity.class));
            }
        });

        cdNativeBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NativeBannerAd_Activity.class));
            }
        });
    }
}