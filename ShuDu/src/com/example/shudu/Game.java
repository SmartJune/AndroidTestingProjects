package com.example.shudu;

import android.R.integer;

public class Game {

	private final String puzzle = "360000000004230800000004200"
			+"070460003820000014500013020"+"001900000007048300000000048";
	
	private int suduku[] = new int[9*9];
	
	private int used[][][] = new int[9][9][];
	
	public Game(){
		suduku = fromPuzzleString(puzzle);
		calculateAllUsedTiles();
	}

	public int[] calculateUsedTiles(int x,int y){
		int c[] = new int[9];
		
		for(int i=0;i<9;i++){
			if(i == y)
				continue;
			int t = getTile(x, i);
			if(t != 0){
				c[t-1] = t;
			}
		}
		
		for(int i=0;i<9;i++){
			if(i == x)
				continue;
			int t = getTile(i, y);
			if(t != 0){
				c[t-1] = t;
			}
		}
		
		int startx = (x/3)*3;
		int starty = (y/3)*3;
		for(int i = startx;i<startx+3;i++){
			for(int j = starty;j<starty+3;j++){
				if(i == x && j == y){
					continue;
				}
				int t = getTile(i,j);
				if(t != 0){
					c[t-1] = t;
				}
			}
		}
		
		int nused = 0;
		for(int t : c){
			if(t != 0){
				nused++;
			}
		}
		int c1[] = new int[nused];
		nused = 0;
		for(int t:c){
			if(t != 0){
				c1[nused++] = t;
			}
		}
		return c1;
	}
	
	public void calculateAllUsedTiles(){
		for(int x=0;x<9;x++){
			for(int y=0;y<9;y++){
				used[x][y]=calculateUsedTiles(x, y);
			}
		}
	}
	
	public int[] getUsedTileByCoor(int x,int y){
		return used[x][y];
	}
	
	public String getTileString(int x,int y){
		int v = getTile(x, y);
		if(v == 0){
			return "";
		}else{
			return String.valueOf(v);
		}
	}
	
	private int getTile(int x, int y) {
		// TODO Auto-generated method stub
		return suduku[y*9+x];
	}

	private int[] fromPuzzleString(String string) {
		// TODO Auto-generated method stub
		int[] sudu = new int[string.length()];
		for(int i=0;i<sudu.length;i++){
			sudu[i] = string.charAt(i)-'0';
		}
		return sudu;
	}

	public boolean setTileIfValid(int seletedX, int seletedY, int tile) {
		// TODO Auto-generated method stub
		int tiles[] = getUsedTileByCoor(seletedX, seletedY);
		if(tile != 0){
			for(int value : tiles){
				if(value == tile){
					return false;
				}
			}
		}
		setTile(seletedX,seletedY,tile);
		calculateAllUsedTiles();
		return true;
	}

	private void setTile(int seletedX, int seletedY, int tile) {
		// TODO Auto-generated method stub
		suduku[seletedY*9+seletedX] = tile;
	}
}
