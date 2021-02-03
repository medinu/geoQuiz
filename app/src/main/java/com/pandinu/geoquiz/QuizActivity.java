package com.pandinu.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton, mFalseButton, mNextButton;
    private TextView mQuestionText;
    private int mIndex = 0;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa , false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionText = (TextView) findViewById(R.id.question_text_view);

        int questionRef = mQuestionBank[mIndex].getmTextResId();
        mQuestionText.setText(questionRef);

        mTrueButton = (Button)findViewById(R.id.true_button);
        mFalseButton = (Button)findViewById(R.id.false_button);
        mNextButton = (Button) findViewById(R.id.next_button);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               checkAnswer(true);
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Next has been clicked.", Toast.LENGTH_SHORT).show();
                //mIndex =(mIndex +1 )% mQuestionBank.length;
                updateQuestion();
            }
        }
        );

        mQuestionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateQuestion();
            }
        });

        //updateQuestion();
    }

    private void updateQuestion (){
        mIndex =(mIndex +1 )% mQuestionBank.length;
        int questionRef = mQuestionBank[mIndex].getmTextResId();
        mQuestionText.setText(questionRef);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answer = mQuestionBank[mIndex].ismAnswerTrue();

        int messageResId = 0;

        if(userPressedTrue == answer){
            messageResId= R.string.correct_toast;
        }else{
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
}