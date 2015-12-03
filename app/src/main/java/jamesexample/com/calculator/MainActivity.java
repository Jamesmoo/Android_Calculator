package jamesexample.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText operandText1;
    private EditText operandText2;

    private Button plusButton;
    private Button minusButton;
    private Button multButton;
    private Button divideButton;
    private Button clearButton;

    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operandText1 = (EditText) findViewById(R.id.editTextOperand1);
        operandText2 = (EditText) findViewById(R.id.editTextOperand2);

        plusButton = (Button) findViewById(R.id.plusButton);
        minusButton = (Button) findViewById(R.id.minusButton);
        multButton = (Button) findViewById(R.id.multiplyButton);
        divideButton = (Button) findViewById(R.id.divideButton);
        clearButton = (Button) findViewById(R.id.clearButton);

        resultView = (TextView) findViewById(R.id.resultTextView);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double oper1 = CheckInput(operandText1.getText().toString());
                double oper2 = CheckInput(operandText2.getText().toString());
                double result = oper1 + oper2;
                resultView.setText(Double.toString(result));
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double oper1 = CheckInput(operandText1.getText().toString());
                double oper2 = CheckInput(operandText2.getText().toString());
                double result = oper1 - oper2;
                resultView.setText(Double.toString(result));
            }
        });

        multButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double oper1 = CheckInput(operandText1.getText().toString());
                double oper2 = CheckInput(operandText2.getText().toString());
                double result = oper1 * oper2;
                resultView.setText(Double.toString(result));
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double oper1 = CheckInput(operandText1.getText().toString());
                double oper2 = CheckInput(operandText2.getText().toString());
                double result = oper1 / oper2;
                resultView.setText(Double.toString(result));
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                operandText1.setText("");
                operandText2.setText("");
                resultView.setText("0.0");
                operandText1.requestFocus();
            }
        });
    }

    private double CheckInput(String value){
        if (value.length() > 0 && !(value.length() == 1 && value.equals("."))){
            return Double.parseDouble(value);
        }
        return 0.0;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
