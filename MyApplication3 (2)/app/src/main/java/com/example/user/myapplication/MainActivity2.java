package com.example.user.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    MediaPlayer mp;
    Button next,b4,b5,b6;
    ImageButton b1,b2,b3;
    TextView tv,mot;
    int hp = 30000;
    int att = 50;
    int money = 0;
    int Buyclicked=0;
    int Buyclicked1=0;
    int Buyclicked2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mp= MediaPlayer.create(this,R.raw.bgm);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mot = (TextView)findViewById(R.id.money2);
        next = (Button)findViewById(R.id.next_2);
        tv = (TextView)findViewById(R.id.hptxt2);
        ImageButton river = (ImageButton)findViewById(R.id.riverstone_2);
        next.setEnabled(false);
        b1 = (ImageButton)findViewById(R.id.item2_1);
        b2 = (ImageButton)findViewById(R.id.item2_2);
        b3 = (ImageButton)findViewById(R.id.item2_3);
        b4 = (Button)findViewById(R.id.buyBtn2);
        b5 = (Button)findViewById(R.id.buyBtn2_2);
        b6 = (Button)findViewById(R.id.buyBtn2_3);
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);




        river.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money = money+5;
                hp = hp-att;
                if(hp>0){

                    mot.setText("머니 : "+Integer.toString(money));
                    tv.setText(Integer.toString(hp)+"/30000");
                }else if(hp<=0) {
                    mot.setText("머니 : "+Integer.toString(money));
                    next.setEnabled(true);
                    tv.setText("0/30000");
                    Toast.makeText(MainActivity2.this,"2단계 클리어! 다음으로를 누르면 다음단계로 들어갑니다",Toast.LENGTH_LONG).show();
                }
                if(money >= 100){
                    b4.setEnabled(true);


                }
                if(money >= 200){
                    b5.setEnabled(true);

                }
                if(money >= 300){
                    b6.setEnabled(true);

                }


            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(money<100){
                    Toast.makeText(MainActivity2.this,"잔액이 부족합니다",Toast.LENGTH_LONG).show();
                }else {

                    money = money - 100;
                    mot.setText("머니 : " + Integer.toString(money));
                    Toast.makeText(MainActivity2.this,"아이템을 구입하셨습니다 적용하실려면 아래의 버튼을 눌러주세요",Toast.LENGTH_LONG).show();
                    b1.setEnabled(true);
                    Buyclicked1=1;
                }
                if(Buyclicked1==1){
                    b4.setEnabled(false);
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(money<200){
                    Toast.makeText(MainActivity2.this,"잔액이 부족합니다",Toast.LENGTH_LONG).show();
                }else {

                    money = money - 200;
                    mot.setText("머니 : " + Integer.toString(money));
                    Toast.makeText(MainActivity2.this,"아이템을 구입하셨습니다 적용하실려면 아래의 버튼을 눌러주세요",Toast.LENGTH_LONG).show();
                    b2.setEnabled(true);
                    Buyclicked=1;
                }
                if(Buyclicked==1){
                    b5.setEnabled(false);
                }

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(money<100){
                    Toast.makeText(MainActivity2.this,"잔액이 부족합니다",Toast.LENGTH_LONG).show();
                }else {

                    money = money - 300;
                    mot.setText("머니 : " + Integer.toString(money));
                    Toast.makeText(MainActivity2.this,"아이템을 구입하셨습니다 적용하실려면 아래의 버튼을 눌러주세요",Toast.LENGTH_LONG).show();
                    b3.setEnabled(true);
                    Buyclicked2=1;
            }
                if(Buyclicked2==1);
                b6.setEnabled(false);

            }
        });
        if(money<=0){
            money = 0;
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                att = 200;
                Toast.makeText(MainActivity2.this,"공격력이 200이 되었습니다",Toast.LENGTH_LONG).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                att = 300;
                Toast.makeText(MainActivity2.this,"공격력이 300이 되었습니다",Toast.LENGTH_LONG).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                att = 400;
                Toast.makeText(MainActivity2.this,"공격력이 400이 되었습니다",Toast.LENGTH_LONG).show();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(it);
                finish();

            }
        });
    }

}
