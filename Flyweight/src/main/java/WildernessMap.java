import java.util.Random;

public class WildernessMap extends Map{

    @Override
    public Tile CreateTile() {
        Random rand = new Random();
        int randInt = rand.nextInt(3);

        if (randInt == 0) {
            return new WaterTile();
        } else if (randInt == 1) {
            return new ForestTile();
        } else {
            return new SwampTile();
        }
    }
}
