package com.daniel_catlett.englishmetricdc;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    double valInputted;
    String convSelected;

    double inPerCM = 2.54;
    double ftPerM = .0348;
    double miPerKM = 1.60934;
    double lbsPerKG = .453592;
    double fahPerCel = .555556; //Don't forget to subtract 32
    double galPerL = 3.78941;

    double output;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText value = (EditText)findViewById(R.id.txtValue);
        final Spinner units = (Spinner)findViewById(R.id.txtUnit);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            final TextView result = ((TextView)findViewById(R.id.txtResult));
            String unit;
            @Override
            public void onClick(View v)
            {
                valInputted = Double.parseDouble(value.getText().toString());
                convSelected = units.getSelectedItem().toString();
                if(convSelected.equals("Inches to Centimeters"))
                {
                    output = valInputted * inPerCM;
                    if(output != 1)
                        unit = " Centimeters";
                    else
                        unit = " Centimeter";
                }
                else if(convSelected.equals("Feet to Meters"))
                {
                    output = valInputted * ftPerM;
                    if(output != 1)
                        unit = " Meters";
                    else
                        unit = " Meter";
                }
                else if(convSelected.equals("Miles to Kilometers"))
                {
                    output = valInputted * miPerKM;
                    if(output != 1)
                        unit = " Kilometers";
                    else
                        unit = " Kilometer";
                }
                else if(convSelected.equals("Pounds to Kilograms"))
                {
                    output = valInputted * lbsPerKG;
                    if(output != 1)
                        unit = " Kilograms";
                    else
                        unit = " Kilogram";
                }
                else if(convSelected.equals("Fahrenheit to Celcius"))
                {
                    output = (valInputted - 32) * fahPerCel;
                    if(output != 1)
                        unit = " Degrees Celcius";
                    else
                        unit = " Degree Celcius";
                }
                else
                {
                    output = valInputted * galPerL;
                    if(output != 1)
                        unit = " Liters";
                    else
                        unit = " Liter";
                }

                DecimalFormat x = new DecimalFormat("###,###.##");
                result.setText(x.format(output) + unit);
            }
        });
    }
}
