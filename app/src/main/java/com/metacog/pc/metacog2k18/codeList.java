package com.metacog.pc.metacog2k18;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.bloder.magic.view.MagicButton;

public class codeList extends AppCompatActivity {

    String eventname[]={"CODE.J","E-SURFING","INFOTRA 2K18","BLIND CODING","SHERLOCK AND THE CODE"};
MagicButton b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_list);
        b1=(MagicButton)findViewById(R.id.codej);
        b2=(MagicButton)findViewById(R.id.esurf);
        b3=(MagicButton)findViewById(R.id.infotra);
        b4=(MagicButton)findViewById(R.id.blind);
        b5=(MagicButton)findViewById(R.id.sher);
        b1.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(codeList.this,code_j.class);
                startActivity(i);
            }
        });
        b2.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(codeList.this,esurf.class);
                startActivity(i);
            }
        });
        b3.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(codeList.this,infotra.class);
                startActivity(i);
            }
        });
        b4.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(codeList.this,blind_coding.class);
                startActivity(i);
            }
        });
        b5.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(codeList.this,sherlock.class);
                startActivity(i);
            }
        });
    }
}
