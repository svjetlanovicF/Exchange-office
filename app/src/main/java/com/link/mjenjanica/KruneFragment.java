package com.link.mjenjanica;

import android.content.Context;
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

public class KruneFragment extends Fragment implements View.OnClickListener {

    EditText svedKruneEdittext;
    Button svedKrunetoKmButton;
    Button kmToSvedKruneButton;

    public KruneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_krune, container, false);

        svedKruneEdittext = (EditText)view.findViewById(R.id.sved_kruna_edit_text);
        svedKrunetoKmButton = (Button)view.findViewById(R.id.sved_kruna_to_km_button);
        kmToSvedKruneButton = (Button)view.findViewById(R.id.km_to_sved_kruna_button);

        svedKrunetoKmButton.setOnClickListener(this);
        kmToSvedKruneButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        DecimalFormat df = new DecimalFormat("#.##");
        String value = svedKruneEdittext.getText().toString();
        double kmValue, svedKruneValue;

        switch (view.getId()){
            case R.id.sved_kruna_to_km_button:


                if(value.equals("")){
                    if(listener != null)
                        listener.onFragmentSendMessage("Molimo Vas unesite iznos");
                }
                else{
                    kmValue = Double.parseDouble(value);
                    Convertor convertor = new Convertor();
                    svedKruneValue = convertor.svedKruneToKm(kmValue);
                    if(listener != null) {
                        listener.onFragmentSendMessage("Vasa vrijednost je " + df.format(svedKruneValue) + "km");
                        svedKruneEdittext.setText("");
                    }
                    break;
                }
            case R.id.km_to_sved_kruna_button:
                if(value.equals("")){
                    if(listener != null)
                        listener.onFragmentSendMessage("Molimo Vas unesite iznos");
                }
                else {
                    kmValue = Double.parseDouble(value);
                    Convertor convertor1 = new Convertor();
                    svedKruneValue = convertor1.kmToSvedKrune(kmValue);
                    if(listener != null){
                        listener.onFragmentSendMessage("Vasa vrijednost je " + df.format(svedKruneValue) + "kruna");
                        svedKruneEdittext.setText("");
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