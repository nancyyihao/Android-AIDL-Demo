package com.nancyyihao.aidlserver;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.nancyyihao.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IBookManager bookManager = IBookManager.Stub.asInterface(service);
            Log.e("trace", "onServiceConnected");
            try {
                List<Book> bookList = bookManager.getBookList();
                Log.e(TAG, "query book list, list type:" + bookList.getClass().getCanonicalName());
                Log.e(TAG, "query book list:" + bookList.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent();
        intent.setAction("com.nancyyihao.startservice");
        intent.setPackage("com.nancyyihao.aidlserver"); // server's package name
        Log.e("trace", "bindService");
        bindService(intent, mConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mConnection);
    }
}
