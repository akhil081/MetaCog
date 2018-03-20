package com.metacog.pc.metacog2k18;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.bloder.magic.view.MagicButton;

public class fun_list1 extends AppCompatActivity {
    MagicButton b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_list1);
        b1=(MagicButton)findViewById(R.id.fun);
        b2=(MagicButton)findViewById(R.id.flip);
        b3=(MagicButton)findViewById(R.id.trea);
        b4=(MagicButton)findViewById(R.id.ring);
        b5=(MagicButton)findViewById(R.id.making);
        b1.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(fun_list1.this,fun.class);
                startActivity(i);
            }
        });
        b2.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(fun_list1.this,flip.class);
                startActivity(i);
            }
        });
        b3.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(fun_list1.this,treasure.class);
                startActivity(i);
            }
        });
        b4.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(fun_list1.this,ring.class);
                startActivity(i);
            }
        });
        b5.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(fun_list1.this,making.class);
                startActivity(i);
            }
        });
    }
}
