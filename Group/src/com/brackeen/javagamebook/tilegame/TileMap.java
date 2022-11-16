package com.brackeen.javagamebook.tilegame;
import java.awt.Image;
import java.util.LinkedList;
import java.util.Iterator;
import com.brackeen.javagamebook.graphics.Sprite;
import java.util.ArrayList; 
import java.io.*;  
/**
 The TileMap class contains the data for a tile-based
 map, including Sprites. Each tile is a reference to an
 Image. Of course, Images are used multiple times in the tile
 map.
*/
public class TileMap {
 private Image[][] tiles;
 private LinkedList sprites;
 private Sprite player;
 /**
 Creates a new TileMap with the specified width and
 height (in number of tiles) of the map.
 */
 public TileMap(int width, int height) {
 tiles = new Image[width][height];
 sprites = new LinkedList();
 }
 /**
 Gets the width of this TileMap (number of tiles across).
 */
 public int getWidth() {
 return tiles.length;
 }
 /**
 Gets the height of this TileMap (number of tiles down).
 */
 public int getHeight() {
 return tiles[0].length;
 }
 /**
 Gets the tile at the specified location. Returns null if
 no tile is at the location or if the location is out of
 bounds.
 */
 public Image getTile(int x, int y) {
 if (x < 0 || x >= getWidth() ||
 y < 0 || y >= getHeight())
 {
 return null;
 }
 else {
 return tiles[x][y];
 }
 }
 /**
 Sets the tile at the specified location.
 */
 public void setTile(int x, int y, Image tile) {
 tiles[x][y] = tile;
 }
 /**
 Gets the player Sprite.
 */
 public Sprite getPlayer() {
 return player;
 }
 
 /**
 Sets the player Sprite.
 */
 public void setPlayer(Sprite player) {
 this.player = player;
 }
 /**
 Adds a Sprite object to this map.
 */
 public void addSprite(Sprite sprite) {
 sprites.add(sprite);
 }
 /**
 Removes a Sprite object from this map.
 */
 public void removeSprite(Sprite sprite) {
 sprites.remove(sprite);
 }
 /**
 Gets an Iterator of all the Sprites in this map,
 excluding the player Sprite.
 */
 public Iterator getSprites() {
	 return sprites.iterator();
 }
}


private TileMap loadMap(String filename) throws IOException {
	 ArrayList lines = new ArrayList();
	 int width = 0;
	 int height = 0;
	 // read every line in the text file into the list
	 BufferedReader reader = new BufferedReader(
	 new FileReader(filename));
	 while (true) {
	 String line = reader.readLine();
	 // no more lines to read
	 if (line == null) {
	 reader.close();
	 break;
	 }
	 // add every line except for comments
	 if (!line.startsWith("#")) {
	 lines.add(line);
	 width = Math.max(width, line.length());
	 }
	 }
	 // parse the lines to create a TileEngine
	 height = lines.size();
	 TileMap newMap = new TileMap(width, height);
	 for (int y=0; y<height; y++) {
	 String line = (String)lines.get(y);
	 for (int x=0; x<line.length(); x++) {
	 char ch = line.charAt(x);
	// check if the char represents tile A, B, C, etc.
	 int tile = ch - 'A';
	 if (tile >= 0 && tile < tiles.size()) {
	 newMap.setTile(x, y, (Image)tiles.get(tile));
	 }
	 // check if the char represents a sprite
	 else if (ch == 'o') {
	 addSprite(newMap, coinSprite, x, y);
	 }
	 else if (ch == '!') {
	 addSprite(newMap, musicSprite, x, y);
	 }
	 else if (ch == '*') {
	 addSprite(newMap, goalSprite, x, y);
	 }
	 else if (ch == '1') {
	 addSprite(newMap, grubSprite, x, y);
	 }
	 else if (ch == '2') {
	 addSprite(newMap, flySprite, x, y);
	 }
	 }
	 }
	 // add the player to the map
	 Sprite player = (Sprite)playerSprite.clone();
	 player.setX(TileMapRenderer.tilesToPixels(3));
	 player.setY(0);
	 newMap.setPlayer(player);
	 return newMap;
	}

	private void addSprite(TileMap map,
		 Sprite hostSprite, int tileX, int tileY)
		{
		 if (hostSprite != null) {
		 // clone the sprite from the "host"
		 Sprite sprite = (Sprite)hostSprite.clone();
		 // center the sprite
		 sprite.setX(
		 TileMapRenderer.tilesToPixels(tileX) +
		 (TileMapRenderer.tilesToPixels(1) -
		 sprite.getWidth()) / 2);
		 // bottom-justify the sprite
		 sprite.setY(
		 TileMapRenderer.tilesToPixels(tileY + 1) -
		 sprite.getHeight());
		 // add it to the map
		 map.addSprite(sprite);
		 }
		}
	int pixelSize = numTiles * TILE_SIZE;

	int offsetX = screenWidth / 2 -
			 Math.round(player.getX()) - TILE_SIZE;
	int mapWidth = tilesToPixels(map.getWidth());
	offsetX = Math.min(offsetX, 0);
	offsetX = Math.max(offsetX, screenWidth - mapWidth);
	int offsetY = screenHeight - tilesToPixels(map.getHeight());
	int firstTileX = pixelsToTiles(-offsetX);
	int lastTileX = firstTileX +
	 pixelsToTiles(screenWidth) + 1;
	for (int y=0; y<map.getHeight(); y++) {
	 for (int x=firstTileX; x <= lastTileX; x++) {
	 Image image = map.getTile(x, y);
	 if (image != null) {
	 g.drawImage(image,
	 tilesToPixels(x) + offsetX,
	 tilesToPixels(y) + offsetY,
	 null);
	 }
	 }
	}
	Iterator i = map.getSprites();
	while (i.hasNext()) {
	 Sprite sprite = (Sprite)i.next();
	 int x = Math.round(sprite.getX()) + offsetX;
	 int y = Math.round(sprite.getY()) + offsetY;
	 g.drawImage(sprite.getImage(), x, y, null);
	}
	int backgroundX = 0;
	g.drawImage(background, backgroundX, 0, null);
	int backgroundX = screenWidth - background.getWidth(null);
	g.drawImage(background, backgroundX, 0, null);
	int backgroundX = offsetX *
			 (screenWidth - background.getWidth(null)) /
			 (screenWidth - mapWidth);
			g.drawImage(background, backgroundX, 0, null);

			
			private TileMap loadMap(String filename) throws IOException {
				 ArrayList lines = new ArrayList();
				 int width = 0;
				 int height = 0;
				 // read every line in the text file into the list
				 BufferedReader reader = new BufferedReader(
				 new FileReader(filename));
				 while (true) {
				 String line = reader.readLine();
				 // no more lines to read
				 if (line == null) {
				 reader.close();
				 break;
				 }
				 // add every line except for comments
				 if (!line.startsWith("#")) {
				 lines.add(line);
				 width = Math.max(width, line.length());
				 }
				 }
				 // parse the lines to create a TileEngine
				 height = lines.size();
				 TileMap newMap = new TileMap(width, height);
				 for (int y=0; y<height; y++) {
				 String line = (String)lines.get(y);
				 for (int x=0; x<line.length(); x++) {
				 char ch = line.charAt(x);

	 
	 