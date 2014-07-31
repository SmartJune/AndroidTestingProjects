package com.example.shudu;

import android.R.integer;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class ShuDuView extends View{

	private float width;
	private float height;
	private int seletedX;
	private int seletedY;
	
	private Game game = new Game();
	
	public ShuDuView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	protected void onSizeChanged(int w,int h,int oldw,int oldh) {
		this.width = w / 9f;
		this.height = h / 9f;
		super.onSizeChanged(w, h, oldw, oldh);
	}
	
	protected void onDraw(Canvas canvas) {
		
		Paint backgroundPaint = new Paint();
		backgroundPaint.setColor(getResources().getColor(R.color.background));
		
		canvas.drawRect(0, 0, getWidth(), getHeight(), backgroundPaint);

		Paint dartPaint = new Paint();
		dartPaint.setColor(getResources().getColor(R.color.dart));
		
		Paint lightPaint = new Paint();
		lightPaint.setColor(getResources().getColor(R.color.light));
		
		Paint hilitePaint = new Paint();
		hilitePaint.setColor(getResources().getColor(R.color.hilite));
		
		for(int i=1;i<9;i++){
			canvas.drawLine(0, i*height, getWidth(), i*height, lightPaint);
			canvas.drawLine(0, i*height+1, getWidth(), i*height+1, hilitePaint);
			
			canvas.drawLine(i*width,0, i*width, getHeight(), lightPaint);
			canvas.drawLine(i*width+1,0, i*width+1, getHeight(), hilitePaint);
			
			if(i%3 == 0){
				canvas.drawLine(0, i*height, getWidth(), i*height, dartPaint);
				canvas.drawLine(0, i*height+1, getWidth(), i*height+1, hilitePaint);
				
				canvas.drawLine(i*width,0, i*width, getHeight(), dartPaint);
				canvas.drawLine(i*width+1,0, i*width+1, getHeight(), hilitePaint);
			}
		}
		
		Paint numberPaint = new Paint();
		numberPaint.setColor(Color.BLACK);
		numberPaint.setStyle(Style.STROKE);
		numberPaint.setTextSize(height*0.75f);
		numberPaint.setTextAlign(Paint.Align.CENTER); //对齐
	
		FontMetrics fontMetrics = numberPaint.getFontMetrics();
		float x = width/2;
		float y = height/2 - (fontMetrics.ascent + fontMetrics.descent)/2;
	//	canvas.drawText("1", 3*width + x, y, numberPaint);
	//	canvas.drawText("2", 4*width + x, y, numberPaint);
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				canvas.drawText(game.getTileString(i, j)
						,i*width+x,j*height+y,numberPaint);
			}
		}
			
		super.onDraw(canvas);
	}
	public boolean onTouchEvent(MotionEvent event){
		if(event.getAction()!=MotionEvent.ACTION_DOWN){
			return super.onTouchEvent(event);
		}
		
		seletedX = (int)(event.getX()/width);
		seletedY = (int)(event.getY()/height);
		
		int used[] = game.getUsedTileByCoor(seletedX, seletedY);
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=0;i<used.length;i++){
			stringBuffer.append(used[i]);
		}
		
		KeyDialog keyDialog = new KeyDialog(getContext(), used,this);
		keyDialog.show();
		
/*		LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
		//使用layoutinflater对象根据布局文件生成一个View对象
		View layoutView = layoutInflater.inflate(R.layout.dialog,null);
		TextView textView = (TextView)layoutView.findViewById(R.id.usedTextId);
		textView.setText(stringBuffer.toString());
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
		builder.setView(layoutView);
		
		AlertDialog alertDialog = builder.create();
		alertDialog.show();                       */
		
		return true;
	}

	public void setSelectedTile(int tile) {
	//	if(game.setTileIfValid(selet))
		if(game.setTileIfValid(seletedX,seletedY,tile)){
			invalidate();
		}
	}
}
