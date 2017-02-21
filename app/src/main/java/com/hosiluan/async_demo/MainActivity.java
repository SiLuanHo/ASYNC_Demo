package com.hosiluan.async_demo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView hinh;
    ImageView hinh2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hinh = (ImageView) findViewById(R.id.imageView);
        hinh2 = (ImageView) findViewById(R.id.imageView2);

        ArrayList<String> links = new ArrayList<>();
        links.add("https://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS");
        links.add("http://media.mangtinmoi.com/files/kimngan/2016/09/08/jang-mi-bolero-bao-trang-la-ai-3-2003.jpg");
        LoadImageFromInterner loadImageFromInterner = new LoadImageFromInterner();
        loadImageFromInterner.execute(links);
        
//        String link = "http://media.mangtinmoi.com/files/kimngan/2016/09/08/jang-mi-bolero-bao-trang-la-ai-3-2003.jpg";
//        LoadImageFromInternet loadImageFromInternet = new LoadImageFromInternet();
//        loadImageFromInternet.execute(link);
    }

    private class LoadImageFromInterner extends  AsyncTask<ArrayList<String>,Void,ArrayList<Bitmap>>
    {


        @Override
        protected ArrayList<Bitmap> doInBackground(ArrayList<String>... arrayLists) {
            ArrayList<Bitmap> bitmaps = new ArrayList<>();
           //ArrayList ArrayList<String> links = arrayLists;
            try {
                bitmaps.add(BitmapFactory.decodeStream(new URL(arrayLists[0].get(0)).openStream()));
                bitmaps.add(BitmapFactory.decodeStream(new URL(arrayLists[0].get(1)).openStream()));
                return  bitmaps;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Bitmap> bitmaps) {
            super.onPostExecute(bitmaps);
            hinh.setImageBitmap(bitmaps.get(0));
            hinh2.setImageBitmap(bitmaps.get(1));

        }
    }

//    public class  LoadImageFromInternet extends AsyncTask<String,Void,Bitmap>{
//
//
//        @Override
//        protected Bitmap doInBackground(String... strings) {
//
//            try {
//                Bitmap bitmap = BitmapFactory.decodeStream(new URL(strings[0]).openStream());
//                return bitmap;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Bitmap bitmap) {
//            super.onPostExecute(bitmap);
//            hinh.setImageBitmap(bitmap);
//        }
//    }



}
