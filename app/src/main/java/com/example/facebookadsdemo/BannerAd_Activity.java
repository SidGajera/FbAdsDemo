package com.example.facebookadsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

public class BannerAd_Activity extends AppCompatActivity {

    AdView adView;
    private final String TAG = BannerAd_Activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_ad_);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adView = new AdView(this, "488593069224727_488593585891342", AdSize.BANNER_HEIGHT_50);
        Log.e(TAG, "onCreate: " + adView);

        // Find the Ad Container
        LinearLayout adContainer = findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();

        AdListener adListener = new AdListener() {

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e(TAG, "onAdLoaded: " + ad);
                Toast.makeText(BannerAd_Activity.this, "onAdloaded()", Toast.LENGTH_SHORT).show();
                // Ad loaded callback
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e(TAG, "onError: " + adError.getErrorMessage());
                Toast.makeText(BannerAd_Activity.this, "Error: " + adError.getErrorMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                Toast.makeText(BannerAd_Activity.this, "onAdClicked()", Toast.LENGTH_SHORT).show();
                // Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
            }
        };

        // Request an ad
        adView.loadAd(adView.buildLoadAdConfig().withAdListener(adListener).build());

//        String android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
//        String deviceId = md5(android_id).toUpperCase();
//        AdSettings.addTestDevice(deviceId);
//        Log.e("device ","md5 test device id = "+deviceId);
    }

    //    public static final String md5(final String s) {
//        try {
//            // Create MD5 Hash
//            MessageDigest digest = java.security.MessageDigest
//                    .getInstance("MD5");
//            digest.update(s.getBytes());
//            byte messageDigest[] = digest.digest();
//
//            // Create Hex String
//            StringBuffer hexString = new StringBuffer();
//            for (int i = 0; i < messageDigest.length; i++) {
//                String h = Integer.toHexString(0xFF & messageDigest[i]);
//                while (h.length() < 2)
//                    h = "0" + h;
//                hexString.append(h);
//            }
//            return hexString.toString();
//
//        } catch (NoSuchAlgorithmException e) {
//            Log.e("TAG", "md5: test device id  NoSuchAlgorithmException "+e );
//        }
//        return "";
//    }
    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}