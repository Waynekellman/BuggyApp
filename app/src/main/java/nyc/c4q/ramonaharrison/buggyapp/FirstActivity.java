package nyc.c4q.ramonaharrison.buggyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {
    Button nextButton;
    TextView myTextView;

    String welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        nextButton = (Button) findViewById(R.id.button_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        myTextView = (TextView) findViewById(R.id.my_text_view);

        if (savedInstanceState != null) {
            welcome = savedInstanceState.getString("welcomeString");
        } else {
            welcome = "Welcome to the Buggy App!";
        }

        myTextView.setText(welcome.toUpperCase());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("welcomeString", welcome);
    }
}
