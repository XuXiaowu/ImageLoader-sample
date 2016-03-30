package truecolor.sample;

import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import truecolor.imageloader_sample.Configure;
import truecolor.imageloader_sample.HttpImageDecoder;
import truecolor.imageloader_sample.ImageLoader;
import truecolor.imageloader_sample.ImageViewDisplayer;


public class MainActivity extends ActionBarActivity {

    private String url1 = "http://manga.1kxun.mobi/images/posters/31-3195fd37b3c0f7d54a6e62ebdcd80044.png";
    private String url2 = "http://i2.hdslb.com/user/4256/425642/myface.jpg";
    private String url3 = "http://img0.bdstatic.com/img/image/shouye/chongwu0715.jpg";

    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private Button btn1;

    private List<MTask> list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = (ImageView)findViewById(R.id.iv1);
        iv2 = (ImageView)findViewById(R.id.iv2);
        iv3 = (ImageView)findViewById(R.id.iv3);
        btn1 = (Button)findViewById(R.id.btn1);

        btn1.setOnClickListener(btn1OnClickListener);

    }

    private View.OnClickListener btn1OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Bitmap bitmap = ImageLoader.loadImage(url1);
            Configure.init(MainActivity.this);
            ImageLoader.loadImage(url1, HttpImageDecoder.getInstance(), ImageViewDisplayer.getInstance(),
                    iv1, R.mipmap.ic_launcher);
//            ImageLoader.loadImage(url2, HttpImageDecoder.getInstance(), ImageViewDisplayer.getInstance(),
//                    iv2, R.mipmap.ic_launcher);
//            ImageLoader.loadImage(url3, HttpImageDecoder.getInstance(), ImageViewDisplayer.getInstance(),
//                    iv3, R.mipmap.ic_launcher);
//            iv1.setImageBitmap(bitmap);


//            MTask mTask1 = new MTask(1);
//            MTask mTask2 = new MTask(2);
//            MTask mTask3 = new MTask(3);
//            list.add(mTask1);
//            list.add(mTask2);
//            list.add(mTask3);
//            Thread t = new Thread(mRunnable);
//            t.start();
        }
    };

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < list.size(); i++) {
                MTask mTask = list.get(i);
                mTask.run();
            }
        }
    };

    private class MTask implements Runnable {
        private int tag;

        MTask(int tag){
            this.tag = tag;
        }

        @Override
        public void run() {
            Log.e("MTask--","----tag---" + tag);
            for (int i = 0; i < 10000; i++) {
                Log.e("MTask--","----"+ tag +"---" + i);
            }

        }
    }


}
