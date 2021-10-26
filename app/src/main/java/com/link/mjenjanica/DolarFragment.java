package com.link.mjenjanica;

import android.content.Context;
import android.media.MediaCodec;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

public class DolarFragment extends Fragment implements View.OnClickListener{

    EditText dolarEditText;
    Button dolarToKmButton;
    Button kmToDolarButton;

    public DolarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dolar, container, false);

        dolarEditText = (EditText)view.findViewById(R.id.am_dolar_edit_text);
        dolarToKmButton = (Button)view.findViewById(R.id.am_dolar_to_km_button);
        kmToDolarButton = (Button)view.findViewById(R.id.km_to_am_dolar_button);

        dolarToKmButton.setOnClickListener(this);
        kmToDolarButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        DecimalFormat df = new DecimalFormat("#.##");
        String value = dolarEditText.getText().toString();
        double kmValue, amDolarValue;

        switch (view.getId()){
            case R.id.am_dolar_to_km_button:


                if(value.equals("")){
                    if(listener != null)
                        listener.onFragmentSendMessage("Molimo Vas unesite iznos");
                }
                else{
                    kmValue = Double.parseDouble(value);
                    Convertor convertor = new Convertor();
                    amDolarValue = convertor.dolarToKm(kmValue);
                    if(listener != null) {
                        listener.onFragmentSendMessage("Vasa vrijednost je " + df.format(amDolarValue) + "km");
                        dolarEditText.setText("");
                    }
                    break;
                }
            case R.id.km_to_am_dolar_button:
                if(value.equals("")){
                    if(listener != null)
                        listener.onFragmentSendMessage("Molimo Vas unesite iznos");
                }
                else {
                    kmValue = Double.parseDouble(value);
                    Convertor convertor1 = new Convertor();
                    amDolarValue = convertor1.kmToDolar(kmValue);
                    if(listener != null){
                        listener.onFragmentSendMessage("Vasa vrijednost je " + df.format(amDolarValue) + "dolara");
                        dolarEditText.setText("");
                    }
                }

        }
    }

    OnFragmentSendMessageListener listener;

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        this.listener = (OnFragmentSendMessageListener)context;
    }
}