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
                break;
            case R.id.buttonminus:
                break;
            case R.id.buttonmul:
                break;
            case R.id.buttondiv:
                break;
            case R.id.buttoneq:
                break;
            case R.id.buttonC:
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
}
