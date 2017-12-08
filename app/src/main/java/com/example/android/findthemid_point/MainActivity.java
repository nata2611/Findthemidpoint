package com.example.android.findthemid_point;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /* Counting the difference between the answer and the mid-point */
    public int getAnswer (SeekBar seekBar) {
        int progress = seekBar.getProgress();
        int answer = progress - 500;
        return answer;
    }
    /* Display the result of Player 1 */
    public void showAnswerPlayer1 (View view) {
        SeekBar seekBarPlayer1 = findViewById(R.id.sbWeight_player1);
        String answerString, answerSign;
        answerSign = "";
        int answer = getAnswer(seekBarPlayer1);
        if (answer > 0) {
            answerSign = "+";
        }
        answerString = Integer.toString(answer);
        ((TextView) findViewById(R.id.answer_player1)).setText(answerSign + answerString);
    }
    /* Display the result of Player 2 */
    public void showAnswerPlayer2 (View view) {
        SeekBar seekBarPlayer2 = findViewById(R.id.sbWeight_player2);
        String answerString, answerSign;
        answerSign = "";
        int answer = getAnswer(seekBarPlayer2);
        if (answer > 0) {
            answerSign = "+";
        }
        answerString = Integer.toString(answer);
        ((TextView) findViewById(R.id.answer_player2)).setText(answerSign + answerString);
    }

    /* Display the result of the Game */
    public void showResult (View view) {
        SeekBar seekBarPlayer1 = findViewById(R.id.sbWeight_player1);
        SeekBar seekBarPlayer2 = findViewById(R.id.sbWeight_player2);
        TextView result = (TextView) findViewById(R.id.text_view_result);
        int resultPlayer1 = Math.abs(getAnswer(seekBarPlayer1));
        int resultPlayer2 = Math.abs(getAnswer(seekBarPlayer2));
        showAnswerPlayer1 (view);
        showAnswerPlayer2 (view);
        if (resultPlayer1 < resultPlayer2) {
            result.setText("Player 1 won!");
        } else
            if (resultPlayer1 > resultPlayer2) {
                result.setText("Player 2 won!");
            }
            else {
            result.setText("Dead heat!");
            }
        Button smthInteresting = (Button) findViewById(R.id.smthInteresting);
        smthInteresting.setVisibility(View.VISIBLE);
  }
    /** Called when the user taps the "Something Interesting..." button */
  public void smthInteresting (View view){
      Intent intent = new Intent(MainActivity.this, DisplayCard.class);
      MainActivity.this.startActivity(intent);

  }

}
