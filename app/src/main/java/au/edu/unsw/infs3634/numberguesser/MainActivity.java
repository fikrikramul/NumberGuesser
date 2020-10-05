package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.EditText;

import android.widget.TextView;

import android.content.Intent;

import android.widget.Button;

public class MainActivity extends AppCompatActivity{


    private EditText tvNumberGuesser;
    private TextView tvGuessedResult;
    private Button btnSubmit;
    private TextView tvGeneratedNumber;
    private Button btnReset;
    private String string;
    private int numberGuess;
    private int chance = 4;
    private int iterate = 0;
    private int numberGenerated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            numberGenerated = (int) (100 * Math.random());

            tvNumberGuesser = (EditText) findViewById(R.id.tvNumberGuesser);
            tvGuessedResult = (TextView) findViewById(R.id.tvGuessedResult);
            tvGeneratedNumber = (TextView) findViewById(R.id.tvGeneratedNumber);
            tvGeneratedNumber.setText(Integer.toString(numberGenerated));


            btnSubmit = (Button) findViewById(R.id.btnSubmit);
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TextView tv = MainActivity.this.findViewById(R.id.tvGuessedResult);
                    tv.setVisibility(View.VISIBLE);
                    try {
                        numberGuess = Integer.parseInt(tvNumberGuesser.getText().toString());
                    }
                    catch(Exception e) {
                    }

                    if (numberGenerated == numberGuess || chance == iterate) {
                        if (chance == iterate) {
                            string = "    You Lost.                 Better luck next time!";
                            btnSubmit.setEnabled(false);
                        } else
                            string = "    Congratulation!          you guessed the correct number";
                        openSecondActivity();

                    }


                    if (numberGuess <= 100 && numberGuess >= 0) {
                        iterate++;
                        if (numberGenerated < numberGuess) {
                            tvGuessedResult.setText("The guessed number is higher than the actual number");
                        }
                        if (numberGenerated > numberGuess) {
                            tvGuessedResult.setText("The guessed number is lower than the actual number");
                        }
                    } else {
                        tvGuessedResult.setText("Choose from 0 to 100");
                    }
                }
            });

            btnReset = (Button) findViewById(R.id.btnReset);
            btnReset.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    iterate = 0;
                    tvNumberGuesser.getText().clear();
                    btnSubmit.setEnabled(true);
                    numberGenerated = (int) (100 * Math.random());
                    tvGeneratedNumber.setText(Integer.toString(numberGenerated));
                }
            });
        }

    private void openSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("Result", string);
        startActivity(intent);
    }
}