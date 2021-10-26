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

public class KuneFragment extends Fragment implements View.OnClickListener {

    EditText kuneEdittext;
    Button kuneToKmButton;
    Button kmToKuneButton;

    public KuneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kune, container, false);
        kuneEdittext = (EditText)view.findViewById(R.id.kune_edit_text);
        kuneToKmButton = (Button)view.findViewById(R.id.kune_to_km_button);
        kmToKuneButton = (Button)view.findViewById(R.id.km_to_kune_button);

        kuneToKmButton.setOnClickListener(this);
        kmToKuneButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        DecimalFormat df = new DecimalFormat("#.##");
        String value = kuneEdittext.getText().toString();
        double kmValue, kuneValue;

        switch (view.getId()){
            case R.id.kune_to_km_button:


                if(value.equals("")){
                    if(listener != null)
                        listener.onFragmentSendMessage("Molimo Vas unesite iznos");
                }
                else{
                    kmValue = Double.parseDouble(value);
                    Convertor convertor = new Convertor();
                    kuneValue = convertor.kuneToKm(kmValue);
                    if(listener != null) {
                        listener.onFragmentSendMessage("Vasa vrijednost je " + df.format(kuneValue) + "km");
                        kuneEdittext.setText("");
                    }
                    break;
                }
            case R.id.km_to_kune_button:
                if(value.equals("")){
                    if(listener != null)
                        listener.onFragmentSendMessage("Molimo Vas unesite iznos");
                }
                else {
                    kmValue = Double.parseDouble(value);
                    Convertor convertor1 = new Convertor();
                    kuneValue = convertor1.kmToKune(kmValue);
                    if(listener != null){
                        listener.onFragmentSendMessage("Vasa vrijednost je " + df.format(kuneValue) + "kuna");
                        kuneEdittext.setText("");
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