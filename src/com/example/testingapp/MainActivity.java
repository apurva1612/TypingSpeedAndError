package com.example.testingapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class MainActivity extends Activity implements OnClickListener {

	private TextView givenStatementView, speedView, speedValueView, errorView, errorValueView, 
	input_error_msg, extra_missed_wordsView, words_to_showView, charSpeedView, charSpeedValueView;
	private EditText inputStatementView;
	private long startSystemTime, endSystemTime, secondsTaken;
	private int words=20, counter = 0, i, minLength, countSpace = 0;
	private String enteredStmt, enteredStmt1;
	private String EMPTY_STRING = "";
	private String ZERO_STRING = "0";
	private String generatedString = null;
	private String missedOrExtra = "", s = "";
	private long rate;
	private String SPEED_WORD_PER_MINUTE = "Speed(words/minute): ";
	private String SPEED_CHAR_PER_MINUTE = "Speed(char/minute): ";
	private String NO_OF_ERROR = "No. of Errors: ";
	private String TYPE_WHOLE_STRING = "Please type the whole given string.";
	private String WORDS_MISSED = "Words which you missed: ";
	private String NO_EXTRA_WORDS = "Please don't type extra words.";
	private String ENTERED_EXTRA_WORDS = "Extra words which you entered: ";
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);

		setContentView(R.layout.activity_main);
		
		findViewById(R.id.done).setOnClickListener(this);
		findViewById(R.id.inputStmt).setOnClickListener(this);
		findViewById(R.id.reset).setOnClickListener(this);
		
		initializeViewComponents();

	}

	protected void initializeViewComponents() {

		givenStatementView = (TextView) findViewById(R.id.givenStmt);
		RandomSentenceGenerator randonSentenceGenerator = new RandomSentenceGenerator();
		generatedString = randonSentenceGenerator.generateSentence().trim();
		givenStatementView.setText(generatedString);
		
		inputStatementView = (EditText) findViewById(R.id.inputStmt);
		inputStatementView.setText(EMPTY_STRING);
		
		input_error_msg = (TextView) findViewById(R.id.input_error);
		input_error_msg.setText(EMPTY_STRING);
		
		speedView = (TextView) findViewById(R.id.speed);
		speedView.setText(SPEED_WORD_PER_MINUTE);
		speedValueView = (TextView) findViewById(R.id.speedValue);
		speedValueView.setText(ZERO_STRING);
		
		errorView = (TextView) findViewById(R.id.error);
		errorView.setText(NO_OF_ERROR);
		errorValueView = (TextView) findViewById(R.id.errorValue);
		errorValueView.setText(ZERO_STRING);
		
		charSpeedView = (TextView) findViewById(R.id.charSpeed);
		charSpeedView.setText(EMPTY_STRING);
		charSpeedValueView = (TextView) findViewById(R.id.charSpeedValue);
		charSpeedValueView.setText(EMPTY_STRING);
		
		extra_missed_wordsView = (TextView) findViewById(R.id.extra_missed_words);
		extra_missed_wordsView.setText(EMPTY_STRING);
		
		words_to_showView = (TextView) findViewById(R.id.words_to_show);
		words_to_showView.setText(EMPTY_STRING);
	}

	private void hideKeyboard(){
		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(inputStatementView.getWindowToken(), 0);
	}
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.done:
			endSystemTime = System.currentTimeMillis();
			hideKeyboard();
			calculateError();
			break;
		case R.id.inputStmt:
			inputStatementView.setText(EMPTY_STRING);
			startSystemTime = System.currentTimeMillis();
			break;
		case R.id.reset:
			initializeViewComponents();
			hideKeyboard();
			break;
		}
	}

	private void calculateError() {

		secondsTaken = (endSystemTime - startSystemTime)/1000;
		rate = (words*60)/secondsTaken;
		s = String.valueOf(rate);
		
		setEnteredStmt(inputStatementView.getText().toString().trim());
		enteredStmt1 = getEnteredStmt();
		
		if(enteredStmt1 != null || enteredStmt1 != EMPTY_STRING)
			speedValueView.setText(s);
		
		char[] first  = generatedString.toCharArray();
		char[] second = enteredStmt1.toCharArray();
		
		if(second.length < first.length)
			minLength = second.length;
		else
			minLength = first.length;

		if(second.length < first.length || second.length==0){
			lengthNotEqual(TYPE_WHOLE_STRING, first.length, WORDS_MISSED, first);
		}
		else if(second.length > first.length){
			lengthNotEqual(NO_EXTRA_WORDS, second.length, ENTERED_EXTRA_WORDS, second);
		}
		
		else{
			sameLength(first, second);
	}
		speedCharPerMinute();
	}

	private void sameLength(char [] first, char [] second){
		input_error_msg.setText(EMPTY_STRING);
		extra_missed_wordsView.setText(EMPTY_STRING);
		words_to_showView.setText(EMPTY_STRING);
		
		counter = 0;
		
		SpannableStringBuilder builder = new SpannableStringBuilder();
		SpannableString redSpannable;
		minLength = second.length;
			for(i = 0; i < minLength; i++)
			{
			        if (first[i] != second[i])
			        {
			            counter++;
			            String red = second[i] + EMPTY_STRING;
			            redSpannable= new SpannableString(red);
			            redSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, red.length(), 0);
			            builder.append(redSpannable);
			        }
			        else
			        {
			        	String black = second[i] + EMPTY_STRING;
			            redSpannable= new SpannableString(black);
			            redSpannable.setSpan(new ForegroundColorSpan(Color.BLACK), 0, black.length(), 0);
			            builder.append(redSpannable);
			        }
			}
	inputStatementView.setText(builder, BufferType.SPANNABLE);
	s = String.valueOf(counter);
	errorValueView.setText(s);
	}
	
	private void speedCharPerMinute(){

		charSpeedView.setText(SPEED_CHAR_PER_MINUTE);
		rate = (minLength*60)/secondsTaken;
		s = String.valueOf(rate);
		charSpeedValueView.setText(s);
		
	}
	
	private void lengthNotEqual(String inputErrorMessage, int endIndex, String extraOrMissedWord, char[] array){
		missedOrExtra = EMPTY_STRING;
		countSpace = 0;
		input_error_msg.setText(inputErrorMessage);
		input_error_msg.setTextColor(Color.RED);

		speedValueView.setText(ZERO_STRING);
		errorValueView.setText(ZERO_STRING);
		for(i = minLength; i < endIndex; i++)
		{
			missedOrExtra += array[i];
			if(array[i] == 32)
				countSpace++;
		}
		extra_missed_wordsView.setText(extraOrMissedWord);
		words_to_showView.setText(missedOrExtra);
		rate = ((countSpace+1)*60)/secondsTaken;
		s = String.valueOf(rate);
		speedValueView.setText(s);
	}
	
	public String getEnteredStmt() {
		return enteredStmt;
	}

	public void setEnteredStmt(String enteredStmt) {
		this.enteredStmt = enteredStmt;
	}
	}