package com.example.cocos2d_firstgame;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	private CCGLSurfaceView view = null;	//游戏图形画在这上面
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		view = new CCGLSurfaceView(this);
		setContentView(view);
		CCDirector director = CCDirector.sharedDirector();	//获得CCDirector对象
		
		director.attachInView(view);   //设置使用的view对象
		director.setDisplayFPS(true);	//设置显示FPS值
		director.setAnimationInterval(1 / 30.0);	//设置渲染每帧数据需要的时间
		
		CCScene scene = CCScene.node();		//生成一个场景对象
		GameLayer4 gameLayer = new GameLayer4();	//生成布景层对象
		scene.addChild(gameLayer);	//把布景层加入场景对象中
		
		director.runWithScene(scene);	//运行
		
	//	setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
