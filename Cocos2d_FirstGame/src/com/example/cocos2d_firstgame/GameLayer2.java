package com.example.cocos2d_firstgame;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

public class GameLayer2 extends CCLayer{

	CCSprite sprite1;
	CCSprite sprite2;
	
	public GameLayer2(){
		
		sprite1 = CCSprite.sprite("player2.png");
		sprite2 = CCSprite.sprite("player2.png");
		this.addChild(sprite1);
		this.addChild(sprite2);
		
		CGPoint point1 = CGPoint.ccp(400, 400);
		sprite1.setPosition(point1);
		sprite2.setPosition(point1);
		
		CGPoint point2 = CGPoint.ccp(0,200);
		CGPoint addPoint = CGPoint.ccpAdd(point1, point2);
		sprite1.setPosition(addPoint);
		
		CGPoint subPoint = CGPoint.ccpSub(point1, point2);
		sprite2.setPosition(subPoint);
		
	}
	
}
