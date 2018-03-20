package com.metacog.pc.metacog2k18;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.bloder.magic.view.MagicButton;

public class other_list1 extends AppCompatActivity {
    MagicButton b1,b2,b3,b4,b5,b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_list1);
        b1=(MagicButton)findViewById(R.id.cross);
        b2=(MagicButton)findViewById(R.id.point);
        b3=(MagicButton)findViewById(R.id.circuit);
        b4=(MagicButton)findViewById(R.id.pandora);
        b5=(MagicButton)findViewById(R.id.funk);
        b6=(MagicButton)findViewById(R.id.thefinal);
        b1.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(other_list1.this,crossbit.class);
                startActivity(i);
            }
        });
        b2.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(other_list1.this,pointblank.class);
                startActivity(i);
            }
        });
        b3.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(other_list1.this,circuit.class);
                startActivity(i);
            }
        });
        b4.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(other_list1.this,pandora.class);
                startActivity(i);
            }
        });
        b5.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(other_list1.this,funk.class);
                startActivity(i);
            }
        });
        b6.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(other_list1.this,thefinal.class);
                startActivity(i);
            }
        });
    }
}
