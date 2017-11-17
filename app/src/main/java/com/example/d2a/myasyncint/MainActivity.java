package com.example.d2a.myasyncint;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConnectInternetTask c1;
    DownloadImageTask downloadImage;

    static TextView myText;
    static ImageView myImages;

    ConnectivityManager myConnManag;
    NetworkInfo myInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText = (TextView)findViewById(R.id.myResult);
        myImages = (ImageView)findViewById(R.id.myImage);

        myConnManag = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        myInfo = myConnManag.getActiveNetworkInfo();
    }

    public void doSomething(View view) {
        c1 = new ConnectInternetTask(this);
        c1.execute("https://www.google.com");
    }

    public void download(View view) {
        if (myInfo != null && myInfo.isConnected()){
            downloadImage = new DownloadImageTask();
            downloadImage.execute("https://www1-lw.xda-cdn.com/files/2016/08/nougat-easter-egg.png");
        }
        else {
            Toast.makeText(this,"Internet not connected",Toast.LENGTH_SHORT).show();
        }
    }
}
