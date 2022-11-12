package com.example.cloudbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddTransactionActivity extends AppCompatActivity {


    @BindView(R.id.montant)
    EditText montant;
    @BindView(R.id.date)
    EditText date;
    @BindView(R.id.type_transaction)
    EditText type_transaction;
    @BindView(R.id.image_id)
    EditText image_id;
    @BindView(R.id.buttonAddTransaction)
    Button buttonAddTransaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);
        ButterKnife.bind(this);

        buttonAddTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDb=new MyDatabaseHelper(AddTransactionActivity.this);
                myDb.insertTransaction(type_transaction.getText().toString()
                        ,montant.getText().toString()
                        ,date.getText().toString(),
                        image_id.getText().toString() );
            }
        });

    }
}