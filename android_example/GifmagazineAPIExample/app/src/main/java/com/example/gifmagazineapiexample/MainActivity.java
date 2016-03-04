package com.example.gifmagazineapiexample;

import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.gifmagazineapiexample.Entity.Image;
import com.example.gifmagazineapiexample.Entity.SearchData;
import com.example.gifmagazineapiexample.Entity.SearchResponse;
import com.example.gifmagazineapiexample.Retrofits.GifMagazineAPI;
import com.example.gifmagazineapiexample.Retrofits.GifMagazineAPIClient;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final LinearLayout gifLayout = (LinearLayout) findViewById(R.id.gif_list);


        final EditText searchText = (EditText) findViewById(R.id.search_word);
        Button searchBtn = (Button) findViewById(R.id.search_btn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gifLayout.removeAllViews();
                GifMagazineAPIClient client = new GifMagazineAPIClient();
                GifMagazineAPI service = client.getGifMagazineAPI();
                service.getSearchResult(searchText.getText().toString(), 0, 2, 0, new Callback<SearchResponse>() {
                    @Override
                    public void success(SearchResponse searchResponse, Response response) {
                        if (searchResponse.getData() != null && searchResponse.getData().size() > 0) {
                            List<SearchData> gifList = searchResponse.getData();
                            for (SearchData gifData : gifList) {
                                ImageView image = new ImageView(getApplicationContext());
                                Image imageData = gifData.getImage().getDefaultImage();
                                Glide.with(getApplicationContext())
                                        .load(imageData.getUrl())
                                        .asGif()
                                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                        .listener(new RequestListener<String, GifDrawable>() {
                                            @Override
                                            public boolean onException(Exception e, String model, Target<GifDrawable> target, boolean isFirstResource) {
                                                return false;
                                            }

                                            @Override
                                            public boolean onResourceReady(final GifDrawable resource, String model, Target<GifDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                                return false;
                                            }
                                        })
                                        .into(image);
                                //横幅を最大に
                                Point size = new Point();
                                WindowManager w = getWindowManager();
                                w.getDefaultDisplay().getSize(size);
                                if (imageData.getWidth() != 0 || imageData.getHeight() != 0)
                                    image.setLayoutParams(new LinearLayout.LayoutParams(size.x,
                                            (int) ((float) (size.x / imageData.getWidth()) * (float) imageData
                                                    .getHeight())));
                                image.setScaleType(ImageView.ScaleType.FIT_XY);

                                gifLayout.addView(image);
                            }
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
