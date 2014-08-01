package com.example.cocos2d_firstgame;

import org.cocos2d.actions.instant.CCFlipX;
import org.cocos2d.actions.instant.CCFlipY;
import org.cocos2d.actions.instant.CCHide;
import org.cocos2d.actions.instant.CCShow;
import org.cocos2d.actions.interval.CCJumpTo;
import org.cocos2d.actions.interval.CCMoveTo;
import org.cocos2d.actions.interval.CCRotateTo;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

public class GameLayer extends CCLayer{		//继承的是Layer
	
	CCSprite player;	//精灵对象
	
	public GameLayer(){
		player = CCSprite.sprite("player.png");		//初始化，默认路径是assets里面
//		player.setPosition(500, 500);	//坐标	
		CGPoint point1 = CGPoint.ccp(100, 200);	//CGPoint常用于表示坐标和向量
		CGPoint point2 = CGPoint.ccp(100, 1000);	//CGPoint常用于表示坐标和向量
		player.setPosition(point1);
		this.addChild(player);
		
		CCJumpTo jumpTo = CCJumpTo.action(3, point2, 200, 3);	
		//跳跃需要的时间.跳到哪个坐标，跳跃的高度，跳几次
		player.runAction(jumpTo);
		//X轴Y轴旋转
		CCFlipX flipX = CCFlipX.action(true);
		player.runAction(flipX);
		CCFlipY flipY = CCFlipY.action(true);
		player.runAction(flipY);
		//隐藏与显示
		CCHide hide = CCHide.action();
		player.runAction(hide);
		CCShow show = CCShow.action();
		player.runAction(show);
		//移动
		CGPoint point3 = CGPoint.ccp(600, 1000);
		CCMoveTo moveTo = CCMoveTo.action(3, point3);
		player.runAction(moveTo);
		//旋转
		CCRotateTo rotateTo =CCRotateTo.action(3, 180);
		player.runAction(rotateTo);
		
	}
}
