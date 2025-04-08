package com.example.androidlifecycle;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private TextView counterTextView;
    private static final String COUNTER_KEY = "counter";
    private final String TAG = "MainActivity Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView = findViewById(R.id.counterTextView);
        Button incrementButton = findViewById(R.id.incrementButton);

        // Restore the counter value if savedInstanceState is not null
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(COUNTER_KEY, 0);
            Log.d("onCreate", "Counter restored: " + counter);
        } else {
            Log.d("onCreate", "Initial counter value: " + counter);
        }

        updateCounterDisplay();

        incrementButton.setOnClickListener(v -> {
            counter++;
            updateCounterDisplay();
        });

        showToast("onCreate");
        Log.d(TAG + "onCreate", "onCreate called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart");
        Log.d(TAG + "onStart", "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showToast("onResume");
        Log.d(TAG + "onResume", "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showToast("onPause");
        Log.d(TAG + "onPause", "onPause called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy");
        Log.d(TAG + "onDestroy", "onDestroy called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop");
        Log.d(TAG + "onStop", "onStop called");
    }



    // Save the counter value before the activity is destroyed
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_KEY, counter);
        Log.d("onSaveInstanceState", "Counter saved: " + counter);
    }

    private void updateCounterDisplay() {
        counterTextView.setText("Counter: " + counter);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

//package com.example.androidlifecycle;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity extends AppCompatActivity {
//
//
//    private final String TAG = "MainActivity Lifecycle";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        showToast("onCreate");
//        Log.d(TAG, "onCreate: ");
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        showToast("onStart");
//        Log.d(TAG, "onStart: ");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        showToast("onResume");
//        Log.d(TAG, "onResume: ");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        showToast("onPause");
//        Log.d(TAG, "onPause: ");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        showToast("onStop");
//        Log.d(TAG, "onStop: ");
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        showToast("onRestart");
//        Log.d(TAG, "onRestart: ");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        showToast("onDestroy");
//        Log.d(TAG, "onDestroy: ");
//
//    }
//
//    private void showToast(String message) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//    }
//}