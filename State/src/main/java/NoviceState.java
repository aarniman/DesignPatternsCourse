public class NoviceState implements State{
    @Override
    public void train(Character character) {
        System.out.println(character.getName() + " is training...");
        character.increaseExperience(10);
        checkLevelUp(character);
    }

    @Override
    public void meditate(Character character) {
        System.out.println("Novices can't meditate.");
    }

    @Override
    public void fight(Character character) {
        System.out.println("Novices can't fight.");
    }

    private void checkLevelUp(Character character) {
        if (character.getExperience() >= 70) {
            System.out.println(character.getName() + " has leveled up to Intermediate!");
            character.setState(new IntermediateState());
        }
    }
}
