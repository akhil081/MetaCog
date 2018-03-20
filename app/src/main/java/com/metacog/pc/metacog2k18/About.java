package com.metacog.pc.metacog2k18;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription("Metacognition 2018, the technical fiesta of Galgotias College of Engineering and Technology is a collaboration of cognitive minds coming together and preparing a platform for budding technocrats to show their mettle and sparkle with their awe-inspiring innovative ideas and research oriented talents. Held annually at the institution, this year it's bigger than it has ever been and while much of the festival has evolutionized, the idea remains to ideate. The motto remains too, and along with it the legacy in which we invite everyone to be a part of. So rewire your robots, setup your devices and place a pin on the calendar for what will be one of the most memorable technical journeys of your life.")
                .setImage(R.drawable.dummy_image)
                .addEmail("teamenthiran@gmail.com")
                .addWebsite("http://www.pc.pc.pc.metacog.org.in/")
                .addFacebook("https://www.facebook.com/metacognitionfest/")
                .addInstagram("https://www.instagram.com/teamenthiran/")
                .addPlayStore("")
                .addItem(getCopyRightsElement())
                .create();

        setContentView(aboutPage);
    }


    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        final String copyrights = String.format(getString(R.string.copy_right), Calendar.getInstance().get(Calendar.YEAR));
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setIconDrawable(R.drawable.about_icon_copy_right);
        copyRightsElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
        copyRightsElement.setIconNightTint(android.R.color.white);
        copyRightsElement.setGravity(Gravity.CENTER);
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(About.this, copyrights, Toast.LENGTH_SHORT).show();
            }
        });
        return copyRightsElement;
    }

}
