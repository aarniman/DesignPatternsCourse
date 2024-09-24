public class MasterState implements State{
    @Override
    public void train(Character character) {
        System.out.println(character.getName() + " has reached the Master level and the game has been completed!");
    }

    @Override
    public void meditate(Character character) {
        System.out.println(character.getName() + " has reached the Master level and the game has been completed!");
    }

    @Override
    public void fight(Character character) {
        System.out.println(character.getName() + " has reached the Master level and the game has been completed!");
    }
}
