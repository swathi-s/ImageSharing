package com.example.user.imagesharing;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process(View view){

        Intent intent = null, chooser = null;

        if(view.getId() == R.id.launchMap)
        {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:19.076,72.877"));
            chooser = Intent.createChooser(intent,"Launch Map");
            startActivity(chooser);
        }
        if(view.getId() == R.id.launchMarket)
        {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=dolphin.developers.com"));
            chooser = Intent.createChooser(intent, "Launch market");
            startActivity(chooser);
        }
        if(view.getId() == R.id.sendEmail)
        {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to = {"swathi@chronicwatch.com","swathi.ehr@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL,to);
            intent.putExtra(Intent.EXTRA_SUBJECT,"hi, this was sent through my app");
            intent.putExtra(Intent.EXTRA_TEXT,"hey whats up, how you doing? this is my first email message");
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent,"Send mail");
            startActivity(chooser);
        }
        if(view.getId() == R.id.sendImage)
        {
            Uri imageUri = Uri.parse("android.resource://com.example.com/drawable/"+R.drawable.honda);
            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM,imageUri);
            intent.putExtra(Intent.EXTRA_TEXT,"Hey I have attched this image");
            chooser = Intent.createChooser(intent,"send Image");
            startActivity(chooser);
        }

        if(view.getId() == R.id.sendMultipleImages)
        {
            File pictures = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            Log.d("pictures","came here"+pictures.toString());
            String[] listOfPictures = pictures.list();
            Log.d("pictures","after came here");
            //Log.d("pictures",listOfPictures.toString());
            Log.d("pictures","after came here 1");
            for(String picture: listOfPictures)
            {
                Log.d("pictures",picture);
                //Toast.makeText(getApplicationContext(),picture,Toast.LENGTH_SHORT).show();
            }
        }
    }
}
