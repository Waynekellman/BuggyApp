package nyc.c4q.ramonaharrison.buggyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class FifthActivity extends AppCompatActivity {
    private static final String TAG = "FifthActivity";
    EditText wordInput;
    Button runButton;
    TextView resultDisplay;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        wordInput = (EditText) findViewById(R.id.input);
        runButton = (Button) findViewById(R.id.run_button);
        resultDisplay = (TextView) findViewById(R.id.repeated_word);
        imageView = (ImageView) findViewById(R.id.imgView);
        //I'm trying to create an OutOfMemoryException but don't know how. Tried this big img but it's fine.
        Glide.with(getApplicationContext())
                .load("https://upload.wikimedia.org/wikipedia/commons/3/3f/Fronalpstock_big.jpg")
                .asBitmap()
                .into(imageView);

        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeatWord();
            }
        });
    }

    /**
     * You take a word and create a string the show
     * the word repeated for the amount of letters in the original word.
     *
     * This if for the person debugging
     */
    public void repeatWord() {
        if (!wordInput.getText().equals(null)){
            String retpeatedWord = "";
            String word = wordInput.getText().toString();
            for (int i = 0; i < word.length(); i++) {
                retpeatedWord = word;
            }
            resultDisplay.setText(retpeatedWord);
        }
    }
}
