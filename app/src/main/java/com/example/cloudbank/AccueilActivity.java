package com.example.cloudbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AccueilActivity extends AppCompatActivity {

    @BindView(R.id.listview_transaction)
    ListView listTransactions;
    @BindView(R.id.add_transaction)
    FloatingActionButton addButton;

    MyDatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        ButterKnife.bind(this);

        // now we need to create the array that will be holding all object (transactions)

        //this is the db that will be used in the displaye data
        myDB =new MyDatabaseHelper(AccueilActivity.this);

        ArrayList<Transaction> transactions = displayData();



        /* as we can see here this is the old way to create the transactions and show them
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(R.drawable.phone_transaction, "Phone Bills ", "200DH", "12/12/2022"));
        transactions.add(new Transaction(R.drawable.payement_paper, "Cash Payment ", "300DH", "01/12/2022"));
        transactions.add(new Transaction(R.drawable.valid_payment, "Card Payment ", "600DH", "01/12/2022"));
         */

        //this our adapter that we will be using
        adapter_transaction transaction_adapter = new adapter_transaction(getApplicationContext(), R.layout.cellule_transaction, transactions);
        listTransactions.setAdapter(transaction_adapter);
        //here do we apply the listener for each view or is for all of them
        //? we will see / why we use AdapterView before the object is it for
        listTransactions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent call_transaction_activity_information = new Intent(getApplicationContext(), each_transaction_information.class);
                call_transaction_activity_information.putExtra("Type", transactions.get(position).getName_transaction());
                call_transaction_activity_information.putExtra("image", transactions.get(position).getImageID_transaction());
                call_transaction_activity_information.putExtra("motant", transactions.get(position).getMontant_trsaction());
                call_transaction_activity_information.putExtra("date", transactions.get(position).getDate_transaction());

                startActivity(call_transaction_activity_information);

            }
        });


        //adding a onclick listner to the add transaction button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddTransactionActivity.class);
                startActivity(intent);
            }
        });


    }

    ArrayList<Transaction> displayData() {
        //so here we have all the transactions in our db
        Cursor cursor = myDB.selectTransaction();
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction transaction;
        if (cursor.getCount() == 0) {
            //display that our db is empty
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        } else {

            while (cursor.moveToNext()) {

                int resID = getResources().getIdentifier(cursor.getString(4),
                        "drawable", getPackageName());

                transaction=new Transaction(resID,
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3));
                //the get string is for the column number
                transactions.add(transaction);

            }

        }
        return transactions;
    }
}