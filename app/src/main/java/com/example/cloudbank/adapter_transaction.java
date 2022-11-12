package com.example.cloudbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class adapter_transaction extends ArrayAdapter<Transaction> {

    private ArrayList<Transaction> transcations;

    public adapter_transaction(@NonNull Context context, int resource, @NonNull ArrayList<Transaction> transactions) {
        super(context, resource, transactions);
        this.transcations=transactions;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.cellule_transaction,parent,false);

        //thes is the binding of the image
        ImageView imageView= (ImageView) convertView.findViewById(R.id.image_cellule);
        // if we use setbackground we have to give it drawable
        imageView.setBackgroundResource(transcations.get(position).getImageID_transaction());

        //for the budget
        TextView textView =(TextView) convertView.findViewById(R.id.budget);
        textView.setText(transcations.get(position).getMontant_trsaction());


        //for the type of transaction
        TextView textView2 =(TextView) convertView.findViewById(R.id.transaction_type);
        textView2.setText(transcations.get(position).getName_transaction());

        //for the date of transaction
        TextView textView3 =(TextView) convertView.findViewById(R.id.date_transaction);
        textView3.setText(transcations.get(position).getDate_transaction());
        //here we should see the format that the date will give us if we use date

        return convertView;
    }
}
