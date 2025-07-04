package com.example.apisplash;

import android.os.Bundle;
import android.os.Handler; // ডেটা লোডিং সিমুলেট করার জন্য
import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;
import androidx.core.splashscreen.SplashScreen; // SplashScreen ইম্পোর্ট করতে হবে

public class MainActivity extends ComponentActivity {

    private boolean isDataLoaded = false; // ডেটা লোড হয়েছে কিনা তা চেক করার জন্য একটা boolean ফ্ল্যাগ

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this); //এটি Android 12 থেকে চালু হওয়া SplashScreen API

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//MainActivity এর মূল UI কে দেখায়।
        splashScreen.setKeepOnScreenCondition(() -> !isDataLoaded);
        //যতক্ষণ isDataLoaded false, ততক্ষণ Splash Screen দেখাতে থাকবে।যখন isDataLoaded = true;, তখন Splash Screen আপনা-আপনি বন্ধ হয়ে যাবে।
        //এভাবে  splash screen কে ইচ্ছামতো সময় ধরে রাখতে পারি, ডেটা লোড বা এনিমেশন শেষ না হওয়া পর্যন্ত। ডেটা লোড হতে দেরি হলে splashscreen অনেকক্ষন থাকে এতে user বিরক্ত হতে পারে ।
        new Handler().postDelayed(() -> {
            isDataLoaded = true;
        }, 1000); //1s themes এ splash screen দেখাবে ।
        //মানে হচ্ছে ১ সেকেন্ড (1000 মিলিসেকেন্ড) পরে {...} এর ভিতরের কাজ হবে।
        //১ সেকেন্ড পরে isDataLoaded = true; করা হচ্ছে
    }
}
