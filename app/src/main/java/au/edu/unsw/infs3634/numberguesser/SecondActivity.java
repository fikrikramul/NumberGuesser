package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.TextView;

import android.content.Intent;

import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private TextView tvResultMessage;
    private Button btnTryAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnTryAgain = (Button) findViewById(R.id.btnTryAgain);
        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this , MainActivity.class));
            }
        });

        if(getIntent().hasExtra("Result")){
            tvResultMessage = (TextView)findViewById(R.id.tvResultMessage);
            String text = getIntent().getExtras().getString("Result");
            tvResultMessage.setText(text);
        }
    }
}
