package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA;
    int scoreTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreTeamA);
        scoreTeamA = 0;
        scoreTeamB = 0;
    }

    public void teamAThreePoints(View view) {
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }

    public void teamATwoPoints(View view) {
        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);
    }

    public void teamAFreeThrow(View view) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    public void teamBThreePoints(View view) {
        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
    }

    public void teamBTwoPoints(View view) {
        scoreTeamB += 2;
        displayForTeamB(scoreTeamB);
    }

    public void teamBFreeThrow(View view) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }


}
