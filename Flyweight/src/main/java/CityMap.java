import java.util.Random;

public class CityMap extends Map{

    @Override
    public Tile CreateTile() {
        Random rand = new Random();
        int randInt = rand.nextInt(3);

        if (randInt == 0) {
            return new RoadTile();
        } else if (randInt == 1) {
            return new BuildingTile();
        } else {
            return new ForestTile();
        }
    }
}
