package com.link.mjenjanica;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MotherActivity extends AppCompatActivity {

    Toast toast = null;

    public void showConverterToast(CharSequence message) {
        LayoutInflater inflater = getLayoutInflater();
        // Inflate the Layout
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_linear_layout));

        TextView text = (TextView) layout.findViewById(R.id.custom_message);
        // Set the Text to show in TextView
        text.setText(message);

        if (toast != null) {
            toast.cancel();
        }

        toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }

    protected void changeActionBarText(String text) {
        getSupportActionBar().setTitle(text);
    }
    protected void enableUpButton(){
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}
