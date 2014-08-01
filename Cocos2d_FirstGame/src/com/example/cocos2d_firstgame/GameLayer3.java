package com.example.cocos2d_firstgame;

import org.cocos2d.actions.instant.CCCallFunc;
import org.cocos2d.actions.instant.CCCallFuncN;
import org.cocos2d.actions.interval.CCMoveTo;
import org.cocos2d.actions.interval.CCRotateTo;
import org.cocos2d.actions.interval.CCScaleTo;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.actions.interval.CCSpawn;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

public class GameLayer3 extends CCLayer{
	
	CCSprite sprite;
	
	public GameLayer3(){
		
		sprite = CCSprite.sprite("player.png");
		CGPoint initPoint = CGPoint.ccp(300, 300);
		this.addChild(sprite);
		sprite.setPosition(initPoint);
		
		CGPoint targetPoint = CGPoint.ccp(800, 600);
		CCMoveTo moveTo = CCMoveTo.action(2, targetPoint);
		CCRotateTo rotateTo = CCRotateTo.action(2, 300);
		CCScaleTo scaleTo = CCScaleTo.action(2, 2);
	/*	
		CCSpawn spawn = CCSpawn.actions(moveTo, rotateTo, scaleTo);
		sprite.runAction(spawn);
		让多个动作同时执行
	*/
		
	/*	
	    CCSequence sequence = CCSequence.actions(moveTo, rotateTo, scaleTo);
	    sprite.runAction(sequence);
	    一套动作链接起来
	*/
		CCCallFuncN funcN = CCCallFuncN.action(this, "onActionFinished");
		CCSequence sequence = CCSequence.actions(moveTo, rotateTo, funcN);
		sprite.runAction(sequence);
	}

	public void onActionFinished(Object sender){
		System.out.println("onActionFinished");
	}
}
