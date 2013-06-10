package com.jigbox.pojo;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HeadBangerActivity extends Activity {
    TextView jokeTitleTextView;
    Button shuffleButton;
    TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head_banger);
        jokeTitleTextView = (TextView) findViewById(R.id.joke_title_text);
        jokeTextView = (TextView) findViewById(R.id.joke_text);
        shuffleButton = (Button) findViewById(R.id.shuffle_btn);
        tellAJoke();
    }

    public void shuffle(View view){
        PoorJoke poorJoke = new PJRepository().getMeAJoke();
        populateJokeData(poorJoke);
    }

    private void tellAJoke() {
        PJRepository pjRepository = new PJRepository();
        PoorJoke poorJoke = pjRepository.getMeAJoke();
        populateJokeData(poorJoke);

    }

    private void populateJokeData(PoorJoke poorJoke) {
        jokeTitleTextView.setText(poorJoke.getJokeTitle());
        jokeTextView.setText(poorJoke.getJokeDescription());
        jokeTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}
