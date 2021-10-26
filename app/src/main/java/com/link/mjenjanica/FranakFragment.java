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


public class FranakFragment extends Fragment implements View.OnClickListener {

    EditText franacEditText;
    Button franacToKmButton;
    Button kmToFranacButton;


    public FranakFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_franak, container, false);

        franacEditText = (EditText)view.findViewById(R.id.franac_edit_text);
        franacToKmButton = (Button)view.findViewById(R.id.franac_to_km_button);
        kmToFranacButton = (Button)view.findViewById(R.id.km_to_franac_button);

        franacToKmButton.setOnClickListener(this);
        kmToFranacButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        DecimalFormat df = new DecimalFormat("#.##");
        String value = franacEditText.getText().toString();
        double kmValue, franacValue;

        switch (view.getId()){
            case R.id.franac_to_km_button:


                if(value.equals("")){
                    if(listener != null)
                        listener.onFragmentSendMessage("Molimo Vas unesite iznos");
                }
                else{
                    kmValue = Double.parseDouble(value);
                    Convertor convertor = new Convertor();
                    franacValue = convertor.franacToKm(kmValue);
                    if(listener != null) {
                        listener.onFragmentSendMessage("Vasa vrijednost je " + df.format(franacValue) + "km");
                        franacEditText.setText("");
                    }
                    break;
                }
            case R.id.km_to_franac_button:
                if(value.equals("")){
                    if(listener != null)
                        listener.onFragmentSendMessage("Molimo Vas unesite iznos");
                }
                else {
                    kmValue = Double.parseDouble(value);
                    Convertor convertor1 = new Convertor();
                    franacValue = convertor1.kmToFranac(kmValue);
                    if(listener != null){
                        listener.onFragmentSendMessage("Vasa vrijednost je " + df.format(franacValue) + "franaka");
                        franacEditText.setText("");
                    }
                }

        }
    }

    OnFragmentSendMessageListener listener;

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        listener = (OnFragmentSendMessageListener)context;
    }
}