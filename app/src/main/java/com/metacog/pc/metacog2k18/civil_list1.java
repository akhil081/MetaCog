package com.metacog.pc.metacog2k18;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.bloder.magic.view.MagicButton;

public class civil_list1 extends AppCompatActivity {
    MagicButton b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil_list1);
        b1=(MagicButton)findViewById(R.id.build);
        b2=(MagicButton)findViewById(R.id.tech);
        b3=(MagicButton)findViewById(R.id.stick);

        b1.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(civil_list1.this,building.class);
                startActivity(i);
            }
        });
        b2.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(civil_list1.this,techdesign.class);
                startActivity(i);
            }
        });
        b3.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(civil_list1.this,stickbuild.class);
                startActivity(i);
            }
        });
    }
}
