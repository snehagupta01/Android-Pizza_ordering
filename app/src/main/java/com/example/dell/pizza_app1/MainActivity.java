package com.example.dell.pizza_app1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
TextView totalprice;
EditText nm,quantity,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void f1(View view) {
        totalprice=findViewById(R.id.tp);
        nm=findViewById(R.id.name);
        quantity=findViewById(R.id.qty);
        price=findViewById(R.id.pp);
        String nam = nm.getText().toString();
        int qty = Integer.parseInt(quantity.getText().toString());
        int p = Integer.parseInt(price.getText().toString());
        int np=qty*p;
        totalprice.setText(""+np);
        String message=cos(nam,np);
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:"));
        i.putExtra(Intent.EXTRA_TEXT,message);
        if(i.resolveActivity(getPackageManager())!=null)
        {
        startActivity(i);
        }
    }

    public void f2(View view){
        Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9876543210"));
        startActivity(intent);
    }
    private String cos(String name, int price)
    {
        String priceMessage = "NAME:"+name;
        priceMessage +="\n"+"PRICE:"+price+"\n"+"THANK YOU";
        return priceMessage;

    }
}
