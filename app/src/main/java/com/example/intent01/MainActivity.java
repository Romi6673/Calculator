package com.example.intent01;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;


import android.os.Bundle;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        devision = findViewById(R.id.devision);
        multification = findViewById(R.id.multification);
        AC = findViewById(R.id.AC);
        equals = findViewById(R.id.equals);
        credits = findViewById(R.id.credits);
    }

    EditText display;
    Button plus;
    Button minus;
    Button multification;
    Button devision;
    Button AC;
    Button equals;
    Button credits;
    double result;



    public void operatorOnClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String currentText = display.getText().toString();
        display.setText(currentText + " " + buttonText + " ");
    }

    public void equalsOnClick(View view) {
        String expression = display.getText().toString();
        String[] parts = expression.split(" ");
        if (parts.length > 0 && parts[0].matches("-?\\d+(\\.\\d+)?")) {
            result = Double.parseDouble(parts[0]);
        } else {
            display.setText("Error");
            return;
        }

        double result = Double.parseDouble(parts[0]);


        for (int i = 1; i < parts.length; i += 2) {
            if ( (parts[i].matches("[a-zA-Z]")) ){
                display.setText("Error");
            }
            String operator = parts[i];


            double operand = Double.parseDouble(parts[i + 1]);

            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    if (operand != 0) {
                        result /= operand;
                        break;
                    } else {
                        display.setText("Error");
                        return;
                    }

                default:
                    display.setText("Error");
                    return;
            }
        }
        display.setText(result+"");

        Intent si = new Intent(this,second_activity.class);

        si.putExtra("result",result);
        startActivity(si);
    }
    public void ACOnClick(View view) {
        display.setText("");

    }


}