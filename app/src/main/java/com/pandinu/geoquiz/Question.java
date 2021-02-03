package com.pandinu.geoquiz;

public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;

    public Question(int textResId, boolean answerTrue){
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }

    public int getmTextResId(){
        return mTextResId;
    }

    public boolean ismAnswerTrue(){
        return mAnswerTrue;
    }

    public void setmTextResId(int textResId){
        mTextResId = textResId;
    }

    public void setmAnswerTrue(boolean answerTrue){
        this.mAnswerTrue = answerTrue;
    }
}
