package com.example.cocos2d_firstgame;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.types.CGPoint;

import android.text.Layout;
import android.view.MotionEvent;

public class GameLayer4 extends CCLayer{

	public GameLayer4(){
	//函数名，和间隔时间
		this.schedule("function",1);
		this.setIsTouchEnabled(true);
		
	}
	//要有一个参数
	//这里代表时间差，每次调用的时间减去之前的时间，得到的就是固定时间差
	public void function(float delta){
		System.out.println("function");
	}
	
	//触摸
	public boolean ccTouchesBegan(MotionEvent event){
		
		float x = event.getX();
		float y = event.getY();
		CGPoint point1 = CGPoint.ccp(x, y);
		CGPoint point2 = CCDirector.sharedDirector().convertToGL(point1);
		
		System.out.println("Touch began");
		System.out.println("point 1 : "+"x = "+x+"y = "+y);
		System.out.println("point 2 : "+"x = "+point2.x+"y = "+point2.y);
		
		this.unschedule("function");
		
		return super.ccTouchesBegan(event);
		
	}
	//离开
	public boolean ccTouchesEnded(MotionEvent event){
		
		System.out.println("Touch ended");
		return super.ccTouchesEnded(event);
		
	}
	//移动
	public boolean ccTouchesMoved(MotionEvent event){
		
		System.out.println("Touch moved");
		return super.ccTouchesMoved(event);
	
	}
}
