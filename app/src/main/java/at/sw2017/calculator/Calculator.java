package at.sw2017.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    private Button buttonAdd, buttonSub, buttonMult, buttonEq, buttonDiv, buttonC;

    private ArrayList<Button> numberButtons = new ArrayList<Button>();

    private TextView numberView;

    private int firstNumber;

    public enum State {
        ADD , SUB , MUL , DIV , INIT , NUM
    }

    private State state = State.INIT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        buttonAdd = ( Button ) findViewById ( R.id.buttonplus );
        buttonAdd.setOnClickListener(this);

        buttonSub = ( Button ) findViewById ( R.id.buttonminus );
        buttonSub.setOnClickListener(this);

        buttonMult = ( Button ) findViewById ( R.id.buttonmul );
        buttonMult.setOnClickListener(this);

        buttonDiv = ( Button ) findViewById ( R.id.buttondiv );
        buttonDiv.setOnClickListener(this);

        buttonEq = ( Button ) findViewById ( R.id.buttoneq );
        buttonEq.setOnClickListener(this);

        buttonC = ( Button ) findViewById ( R.id.buttonC );
        buttonC.setOnClickListener(this);

        numberView = ( TextView ) findViewById ( R.id.textView);

        setUpNumberButtonListener();
    }

    public void setUpNumberButtonListener () {
        for ( int i = 0 ; i <= 9 ; i ++) {
            String buttonName = "button" + i;
            int id = getResources (). getIdentifier ( buttonName , "id" , R.class.getPackage().getName());
            Button button = ( Button ) findViewById ( id );
            button.setOnClickListener ( this );
            numberButtons.add( button );
        }
    }

    @Override
    public void onClick(View v) {
        Button clickedButton = (Button) v;
        switch (clickedButton.getId()) {
            case R.id.buttonplus:
                clearNumberView();
                state = State.ADD;
                break;
            case R.id.buttonminus:
                clearNumberView();
                state = State.SUB;
                break;
            case R.id.buttonmul:
                clearNumberView();
                state = State.MUL;
                break;
            case R.id.buttondiv:
                clearNumberView();
                state = State.DIV;
                break;
            case R.id.buttoneq:
                calculateResult();
                state = State.INIT;
                break;
            case R.id.buttonC:
                clearTextView();
                break;
            default:
                String recentNumber = numberView.getText().toString();
                if (recentNumber.equals("0")) {
                    recentNumber = "";
                }
                recentNumber += clickedButton.getText().toString();
                numberView.setText( recentNumber );
        }
    }

    private void clearTextView () {
        numberView.setText("0");
        firstNumber = 0;
        state = State . INIT;
    }

    private void clearNumberView () {
        String tempString = numberView.getText().toString();
        if (! tempString.equals ("")){
            firstNumber = Integer.valueOf(tempString );
        }
        numberView.setText("");
    }

    private void calculateResult () {
        int secondNumber = 0;
        String tempString = numberView.getText().toString();
        if (! tempString.equals ("")){
            secondNumber = Integer.valueOf(tempString);
        }
        int result;
        switch ( state ){
            case ADD:
                result = Calculations.doAddition ( firstNumber , secondNumber );
                break;
            case SUB:
                result = Calculations .doSubtraction ( firstNumber , secondNumber );
                break;
            case MUL:
                result = Calculations.doMultiplication ( firstNumber , secondNumber );
                break;
            case DIV:
                result = Calculations.doDivision ( firstNumber , secondNumber );
                break;
            default:
                result = secondNumber;
        }
        numberView.setText( Integer.toString ( result ));
    }
}
