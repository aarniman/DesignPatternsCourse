public abstract class Map {

    private char[][] map = new char[10][50];

    public abstract Tile CreateTile();

    public void display() {
        // Display the map
        Tile tile;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                tile = CreateTile();
                System.out.print(tile.getContent());
            }
            System.out.println();
        }
        System.out.println();
    }
}
