package com.example.cloudbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class each_transaction_information extends AppCompatActivity {

    //take all the elements in the page and bind them

    @BindView(R.id.budgetChangeable)
    TextView budget;
    @BindView(R.id.dateChangeable)
    TextView dateTransactionInformation;

    @BindView(R.id.image_cellule)
    ImageView imageCellule;
    @BindView(R.id.transaction_type)
    TextView transaction_type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_transaction_information);
        ButterKnife.bind(this);



        //here we will take intent and we store it and we have the elements
        Bundle extras= getIntent().getExtras();
        if (extras != null){
            String Type=new String(extras.getString("Type"));
            String motant=new String(extras.getString("motant"));
            String date=new String(extras.getString("date"));
            Integer image=new Integer(extras.getInt("image"));


            imageCellule.setBackgroundResource(image);
            dateTransactionInformation.setText(date);
            transaction_type.setText(Type);
            budget.setText(motant);

        }


    }
}