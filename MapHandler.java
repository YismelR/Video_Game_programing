import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
* A mock-up of a MapHandler class for a game. This loads tiles when needed and displays at a specific location, drawing
* all the tiles that the player can view. Certain variables should be configred / assigned at runtime - in particular the WIDTH / HEIGHT
* constants.
*
* Remember - I've omitted many of the convenience methods that would be practical to have as well! 
* 
* @author Ronan
*/
public class MapHandler {
   /* The screen width & height */
   private final int SCREEN_WIDTH = 600;
   private final int SCREEN_HEIGHT = 500;

   /* Dimensions of the tiles. */
   private final int TILE_WIDTH = 700;
   private final int TILE_HEIGHT = 700;

   /*
    * Map contains file-references to each tile-image. Ideally, you'd probably
    * want to cache-load these in an actual game. This would involve loading
    * the map-piece if it hasn't been loaded and storing the loaded-piece.
    *
    * Prior to attempting to load the piece, the Handler could check if it has
    * been loaded and use that instead.
    *
    * Obviously with large maps clean-up would need to be involved to unload
    * previous stored areas that aren't used commonly.
    */
   private File[][] map;

   /*
    * A possible implementation of the cache-loading process.
    */
   private HashMap<File, BufferedImage> loadedTiles;

   /*
    * Stores the pointer to the map-array, determining where our current location
    * is.
    */
   private Point current = new Point(0,0);

   /* Simple test constructor. */
   public MapHandler(File[][] map, Point current) {
       loadedTiles = new HashMap<File, BufferedImage>();

       this.map = map;

       moveCurrent(current);
   }

   /**
    * Loads the specific tile from the map-array. Deals with the cache-loading process.
    *
    * @param x The x-index of the tile to load.
    * @param y The y-index of the tile to load.
    *
    * @return Returns the loaded image from the map-array. Will throw an IOException
    *         if the image cannot be loaded.
    */
   public BufferedImage loadTile(int x, int y) {
       File currentFile = map[x][y];

       if(!loadedTiles.containsKey(currentFile)) {
           try {
               /* Place the loaded image and file into the loaded-tiles cache. */
               BufferedImage image = loadedTiles.put(currentFile, ImageIO.read(currentFile));

               return image;
           } catch (IOException e) {
               /*
                * Throw exception if the file can't be read correctly,
                * alternatively could deal with the error.
                */
               throw new RuntimeException("I/O Exception occured during reading " +
                       "of file: " + currentFile.getName());
           }
       } else {
           /* We've loaded the tile already - return it from the cache. */
           return loadedTiles.get(currentFile);
       }
   }

   /**
    * Used to move the player's active-area from one location to another.
    *
    * @param newLocation The point reference to the new-location. Corresponds
    *                    to the index to the map array.
    */
   public void moveCurrent(Point newLocation) {
       int newX = newLocation.x;
       int newY = newLocation.y;

       /* Error-check the location we're changing to. */
       if(newX < 0 || newY < 0 || newX >= map.length || newY > map[newX].length) {
           throw new RuntimeException("New Location out of Bounds: (" + newX + "," + newY + ")");
       }

       current.x = newX;
       current.y = newY;

       /*
        * Cache-loading details. Loads the current tile's file and adjacent
        * tiles when moved. Could also invole unloading of previous tiles.
        */
       for(int x = current.x - 1; x <= current.x + 1; x++) {
           /* Make sure we don't load tiles out of bounds. */
           if(x < 0 || x >= map.length) continue;

           for(int y = current.y - 1; y <= current.y + 1; y++) {
               /* Make sure we don't load tiles out of bounds. */
               if(y < 0 || y >= map[x].length) continue;

               loadTile(x, y);
           }
       }
   }

   /**
    * Draws the current tile and adjacent tiles.
    *
    * @param g The Graphics to draw the map to.
    * @param position The position to draw the map at. This position represents
    *                 the upper-left co-ordinate of the current tile and should
    *                 be determined at runtime based on your implementation of drawing.
    *
    * NOTE :- This doesn't implement cutting of the image-area that isn't going
    *         to be visible to the user. That may be something else to consider.
    *
    *         As you stated the screen is 500x400, I've edited it a bit to only
    *         draw the other tiles that are needed. Not all 8 adjacent.
    */
   public void paint(Graphics g, Point position) {
       /*
        * Calculate extra tiles to be drawn.
        */

       /*
        * Determines the number of tiles that we need to draw above and to the left
        * of the current tile.
        *
        * This is based on taking the gap between the upper-left of the 'viewport'
        * and the position that we're drawing the current tile at. We then
        * calculate the number of tiles that will fit into the gap, taking the
        * ceiling of the calculation to make sure no small-gaps are left.
        */
       Point upperLeft = new Point(position.x < 0 ? 0 : (int)Math.ceil((double)position.x / TILE_WIDTH),
               position.y < 0 ? 0 : (int)Math.ceil((double)position.y / TILE_WIDTH));

       int lowerWidth = SCREEN_WIDTH - position.x + TILE_WIDTH;
       int lowerHeight = SCREEN_HEIGHT - position.y + TILE_HEIGHT;

       /*
        * A similar method to above is used to calculate the lower-right boundaries.
        */
       Point lowerRight = new Point(lowerWidth < 0 ? 0 : (int)Math.ceil((double)lowerWidth / TILE_WIDTH),
               lowerHeight < 0 ? 0 : (int)Math.ceil((double)lowerHeight / TILE_HEIGHT));

       /*
        * We now loop over the entire 'area' that we've generated, skipping if
        * any points are out of bounds. (This should mean we're at the edge of
        * the map rather than a problem). 
        */
       for(int x = current.x - upperLeft.x; x <= current.x + lowerRight.x; x++) {
           if(x <= 0 || x >= map.length) continue;

           for(int y = current.y - upperLeft.y; y <= current.y + lowerRight.y; y++) {
               if(y <= 0 || y >= map[x].length) continue;

               /*
                * We draw the tile we're currently at, relative to the position specified
                * for the 'current' tile that the player is on.
                */
               g.drawImage(loadTile(x, y), position.x - ((current.x - x) * TILE_WIDTH),
                       position.y - ((current.y - y) * TILE_HEIGHT), null);
           }
       }
   }
}