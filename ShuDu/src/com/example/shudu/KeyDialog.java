package com.example.shudu;

import java.security.spec.KeySpec;

import android.R.integer;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class KeyDialog extends Dialog {

	private final int[] used;
	private final View keys[] = new View[9];
	private ShuDuView shuDuView;
	
	public KeyDialog(Context context, int[] used,ShuDuView shuDuView) {
		super(context);
		this.used = used;
		this.shuDuView = shuDuView;
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("KeyDialog");
		setContentView(R.layout.keypad);
		findViews();
		for(int i=0;i<used.length;i++){
			if(used[i] != 0){
				System.out.println(used[i]);
				keys[used[i]-1].setVisibility(View.INVISIBLE);
			}
		}
		setListeners();
	}
	private void returnResult(int tile) {
		shuDuView.setSelectedTile(tile);
		dismiss();
	}

	private void setListeners() {
		for(int i=0;i<keys.length;i++){
			final int t = i + 1;
			keys[i].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					returnResult(t);
				}	
			});
		}
	}

	private void findViews() {
		keys[0] = findViewById(R.id.keypad1);
		keys[1] = findViewById(R.id.keypad2);
		keys[2] = findViewById(R.id.keypad3);
		keys[3] = findViewById(R.id.keypad4);
		keys[4] = findViewById(R.id.keypad5);
		keys[5] = findViewById(R.id.keypad6);
		keys[6] = findViewById(R.id.keypad7);
		keys[7] = findViewById(R.id.keypad8);
		keys[8] = findViewById(R.id.keypad9);
	}
	
}
