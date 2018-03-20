package com.metacog.pc.metacog2k18;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.bloder.magic.view.MagicButton;

public class gamingList extends AppCompatActivity {
    MagicButton b1,b2,b3,b4,b5,b6,b7,b8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming_list);
        b1=(MagicButton)findViewById(R.id.nfs);
        b2=(MagicButton)findViewById(R.id.fifa);
        b3=(MagicButton)findViewById(R.id.sudo);
        b4=(MagicButton)findViewById(R.id.exqu);
        b5=(MagicButton)findViewById(R.id.mini);
        b6=(MagicButton)findViewById(R.id.rubik);
        b7=(MagicButton)findViewById(R.id.counter);


        b1.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(gamingList.this,nfs.class);
                startActivity(i);
            }
        });
        b2.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(gamingList.this,fifa.class);
                startActivity(i);
            }
        });
        b3.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(gamingList.this,suduko.class);
                startActivity(i);
            }
        });
        b4.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(gamingList.this,ex.class);
                startActivity(i);
            }
        });
        b5.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(gamingList.this,mini.class);
                startActivity(i);
            }
        });
        b6.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(gamingList.this,rubics.class);
                startActivity(i);
            }
        });
        b7.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(gamingList.this,counter.class);
                startActivity(i);
            }
        });

    }
}


