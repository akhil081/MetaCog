package com.metacog.pc.metacog2k18;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.bloder.magic.view.MagicButton;

public class robo_list1 extends AppCompatActivity {
    MagicButton b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robo_list1);
        b1=(MagicButton)findViewById(R.id.lfr);
        b2=(MagicButton)findViewById(R.id.roborace);
        b3=(MagicButton)findViewById(R.id.robos);
        b4=(MagicButton)findViewById(R.id.drone);
        b5=(MagicButton)findViewById(R.id.roboa);
        b1.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(robo_list1.this,lfr.class);
                startActivity(i);
            }
        });
        b2.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(robo_list1.this,roborace.class);
                startActivity(i);
            }
        });
        b3.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(robo_list1.this,roboso.class);
                startActivity(i);
            }
        });
        b4.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(robo_list1.this,drone.class);
                startActivity(i);
            }
        });
        b5.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(robo_list1.this,robowar.class);
                startActivity(i);
            }
        });

    }
}
