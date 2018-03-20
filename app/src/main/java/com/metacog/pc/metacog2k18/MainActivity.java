package com.metacog.pc.metacog2k18;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.RelativeLayout;

import com.metacog.pc.metacog2k18.entities.Gallery;
import com.mzelzoghbi.zgallery.entities.ZColor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.metacog.pc.metacog2k18.entities.Gallery.with;
import static java.lang.Thread.sleep;

public class MainActivity extends Activity implements View.OnTouchListener {

    private boolean LOC = false, CAM = false;

    public Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(
                bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        return resizedBitmap;
    }

    ourview v;
    float x, y;
    float width, height;
    float incri;

    int fad = 0;
    float right, top;
    boolean flag = true, arb = false, cam_per = false, loc_per = false, calling = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v = new ourview(this);
        v.setOnTouchListener(this);
        v = new MainActivity.ourview(this);
        v.setOnTouchListener(this);
        setContentView(R.layout.activity_main);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.vMain);
        layout.addView(v);
    }

    @Override
    protected void onPause() {
        super.onPause();
        v.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        v.resume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent me) {

        x = me.getX();
        y = me.getY();
        fad = 100;

        if (y < height / 3 - Math.abs(x - (width / 2))) {

            Intent myIntent = new Intent(MainActivity.this, Sponsor.class);
            MainActivity.this.startActivity(myIntent);
            calling = false;
            return false;

        } else if (y > height * 2 / 3 + Math.abs(x - width / 2)) {

            Intent myIntent = new Intent(MainActivity.this,Events.class);
            MainActivity.this.startActivity(myIntent);
            calling = false;
            return false;

        } else if (y < height / 2 && x < width * 9 / 20 - Math.abs(y - height / 4)) {

            Intent myIntent = new Intent(MainActivity.this, Register.class);
            MainActivity.this.startActivity(myIntent);
            calling = false;
            return false;

        } else if (y > height / 2 && x < width * 9 / 20 - Math.abs(y - height * 3 / 4)) {

            Intent myIntent = new Intent(MainActivity.this, Developer.class);
            MainActivity.this.startActivity(myIntent);
            arb = true;
            loc_per = true;
            calling = false;
            return false;

        } else if (y < height / 2 && x > (width - width * 9 / 20) + Math.abs(y - height / 4)) {

            Gallery.with(MainActivity.this, getDummyImageList())
                    .setToolbarTitleColor(ZColor.WHITE)
                    .setGalleryBackgroundColor(ZColor.BLACK)
                    .setToolbarColorResId(R.color.colorPrimary)
                    .setTitle("Gallery")
                    .show();
            calling = false;
            return false;

        } else if (y > height / 2 && x > (width - width * 9 / 20) + Math.abs(y - height * 3 / 4)) {

            Intent myIntent = new Intent(MainActivity.this, Location.class);
            MainActivity.this.startActivity(myIntent);
            calling = false;
            return false;

        } else {

            Intent myIntent = new Intent(MainActivity.this, About.class);
            MainActivity.this.startActivity(myIntent);
            calling = false;
            return false;

        }
    }


    private ArrayList<String> getDummyImageList(){
        ArrayList<String> imagesList = new ArrayList<>();
        imagesList.add("http://www.metacognition.org.in/images/1.jpg");
        imagesList.add("http://www.metacognition.org.in/images/2.jpg");
        imagesList.add("http://www.metacognition.org.in/images/3.jpg");
        imagesList.add("http://www.metacognition.org.in/images/4.jpg");
        imagesList.add("http://www.metacognition.org.in/images/5.jpg");
        imagesList.add("http://www.metacognition.org.in/images/6.jpg");
        imagesList.add("http://www.metacognition.org.in/images/7.jpg");
        imagesList.add("http://www.metacognition.org.in/images/8.jpg");
        imagesList.add("http://www.metacognition.org.in/images/9.jpg");
        imagesList.add("http://www.metacognition.org.in/images/10.jpg");
        imagesList.add("http://www.metacognition.org.in/images/11.jpg");
        imagesList.add("http://www.metacognition.org.in/images/12.jpg");
        imagesList.add("http://www.metacognition.org.in/images/13.jpg");
        imagesList.add("http://www.metacognition.org.in/images/14.jpg");
        imagesList.add("http://www.metacognition.org.in/images/15.jpg");
        imagesList.add("http://www.metacognition.org.in/images/16.jpg");
        return imagesList;
    }


    public class ourview extends SurfaceView implements Runnable {
        Thread t = null;
        SurfaceHolder holder;
        boolean isitok = false;

        Bitmap developer = BitmapFactory.decodeResource(getResources(), R.drawable.developers);
        Bitmap gallery = BitmapFactory.decodeResource(getResources(), R.drawable.gallery);
        Bitmap events = BitmapFactory.decodeResource(getResources(), R.drawable.events);
        Bitmap loc = BitmapFactory.decodeResource(getResources(), R.drawable.loc);
        Bitmap spon = BitmapFactory.decodeResource(getResources(), R.drawable.sp);
        Bitmap register = BitmapFactory.decodeResource(getResources(), R.drawable.register);
        Bitmap backg=BitmapFactory.decodeResource(getResources(), R.drawable.splashbg);
        Bitmap about = BitmapFactory.decodeResource(getResources(), R.drawable.about);
        String countd, text = "days     hrs      min     sec";

        public ourview(Context context) {
            super(context);
            holder = getHolder();
        }

        @Override
        public void run() {
            while (isitok == true) {
                if (!holder.getSurface().isValid()) {
                    continue;
                }

                Canvas c = holder.lockCanvas();

                if (flag) {
                    developer = getResizedBitmap(developer, c.getWidth() * 9 / 20, c.getHeight() / 2);
                    register = getResizedBitmap(register, c.getWidth() * 9 / 20, c.getHeight() / 2 );
                    spon = getResizedBitmap(spon, c.getWidth(), c.getHeight() * 2 / 7);
                    loc = getResizedBitmap(loc, c.getWidth() * 9 / 20, c.getHeight() / 2);
                    gallery = getResizedBitmap(gallery, c.getWidth() * 9 / 20, c.getHeight() / 2);
                    events = getResizedBitmap(events, c.getWidth(), c.getHeight() * 2 / 7);
                    backg=getResizedBitmap(backg,c.getWidth(),c.getHeight());
                    about = getResizedBitmap(about, c.getWidth() * 4 / 15, c.getWidth() / 12);

                    width = c.getWidth();
                    height = c.getHeight();
                    flag = false;
                    top = c.getHeight() * 2 / 7;
                    right = c.getWidth() * 9 / 20;
                    incri = c.getHeight() / 23;
                }
                if (top > 0) {
                    if (top > incri)
                        top -= incri;
                    else
                        top = 0;
                }
                if (right > 0) {
                    if (right > incri)
                        right -= incri;
                    else
                        right = 0;
                }

                c.drawBitmap(backg, 0, 0, null);
                c.drawBitmap(register, 0 - right, 0, null);
                c.drawBitmap(gallery, c.getWidth() - gallery.getWidth() + right, 0, null);
                c.drawBitmap(spon, 0, 0 - top, null);
                c.drawBitmap(developer, 0 - right, c.getHeight() / 2, null);
                c.drawBitmap(loc, c.getWidth() - loc.getWidth() + right, c.getHeight() / 2, null);
                c.drawBitmap(events, 0, c.getHeight() - events.getHeight() + top, null);
                c.drawBitmap(about, c.getWidth() / 2 - about.getWidth() / 2, c.getHeight() / 2 - about.getHeight() / 2 - c.getWidth() / 4, null);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date futureDate = null;
                Date stopDate = null;
                try {
                    futureDate = dateFormat.parse("2018-03-11 09:00:00");
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                try {
                    stopDate = dateFormat.parse("2018-03-12 01:00:00");
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Date currentDate = new Date();
                if (!currentDate.after(futureDate)) {
                    long diff = futureDate.getTime() - currentDate.getTime();
                    long days = diff / (24 * 60 * 60 * 1000);
                    diff -= days * (24 * 60 * 60 * 1000);
                    long hours = diff / (60 * 60 * 1000);
                    diff -= hours * (60 * 60 * 1000);
                    long minutes = diff / (60 * 1000);
                    diff -= minutes * (60 * 1000);
                    long seconds = diff / 1000;
                    countd = String.format("%02d", days) + " : " + String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds);
                } else if (currentDate.before(stopDate)) {
                    countd = "Meta is Live!!";
                    text = "";

                } else {
                    countd = "See You Next Year!!";
                    text = "";
                }

                Paint fade = new Paint();
                fade.setColor(Color.argb(fad, 153, 153, 153));
                Paint text1 = new Paint();
                text1.setColor(Color.WHITE);
                text1.setTypeface(Typeface.create("Arial", Typeface.BOLD));
                text1.setTextSize(c.getWidth() / 14);

                Paint text2 = new Paint();
                text2.setColor(Color.WHITE);
                text2.setTypeface(Typeface.create("Arial", Typeface.BOLD));
                text2.setTextSize(c.getWidth() / 22);

                Rect bounds = new Rect();
                text1.getTextBounds(countd, 0, countd.length(), bounds);
                float xx = bounds.width();
                float yy = bounds.height();

                c.drawText(countd, c.getWidth() / 2 - xx / 2, c.getHeight() / 2 - yy / 2 + c.getWidth() / 10, text1);
                c.drawText(text, c.getWidth() / 2 - xx / 2, c.getHeight() / 2 + yy / 2 + c.getWidth() / 10, text2);
                c.drawRect(0, 0, c.getWidth(), c.getHeight(), fade);

                holder.unlockCanvasAndPost(c);

                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void pause() {
            isitok = false;
            fad = 0;
            while (true) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            t = null;
        }

        public void resume() {
            isitok = true;
            LOC = false;
            CAM = false;
            arb = false;
            calling = true;
            flag = true;
            t = new Thread(this);
            t.start();
        }
    }
}
