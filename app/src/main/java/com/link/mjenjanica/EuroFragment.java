package com.link.mjenjanica;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

import static android.view.Gravity.CENTER;


public class EuroFragment extends Fragment implements View.OnClickListener {

    EditText euroEditText;
    Button euroToKmButton;
    Button kmToEuroButton;


    public EuroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_euro, container, false);

        euroEditText = (EditText) view.findViewById(R.id.euro_edit_Text);
        euroToKmButton = (Button) view.findViewById(R.id.euro_to_km_Button);
        kmToEuroButton = (Button) view.findViewById(R.id.km_to_euro_button);

        euroToKmButton.setOnClickListener(this);
        kmToEuroButton.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {

        DecimalFormat df = new DecimalFormat("#.##");
        String value = euroEditText.getText().toString();
        double kmValue, euroValue;

        switch (view.getId()){
            case R.id.euro_to_km_Button:


                if(value.equals("")){
                    if(listener != null)
                        listener.onFragmentSendMessage("Molimo Vas unesite iznos");
                }
                else{
                    kmValue = Double.parseDouble(value);
                    Convertor convertor = new Convertor();
                    euroValue = convertor.euroToKm(kmValue);
                    if(listener != null) {
                        listener.onFragmentSendMessage("Vasa vrijednost je " + df.format(euroValue) + "km");
                        euroEditText.setText("");
                    }
                    break;
                }
            case R.id.km_to_euro_button:
                if(value.equals("")){
                    if(listener != null)
                        listener.onFragmentSendMessage("Molimo Vas unesite iznos");
                }
                else {
                    kmValue = Double.parseDouble(value);
                    Convertor convertor1 = new Convertor();
                    euroValue = convertor1.kmToEuro(kmValue);
                    if(listener != null){
                        listener.onFragmentSendMessage("Vasa vrijednost je " + df.format(euroValue) + "euro");
                        euroEditText.setText("");
                    }
                }

                }
        }



    OnFragmentSendMessageListener listener;

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        this.listener = (OnFragmentSendMessageListener) context;
    }
}