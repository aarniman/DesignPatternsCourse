public class IntermediateState implements State {
    @Override
    public void train(Character character) {
        System.out.println(character.getName() + " is training...");
        character.increaseExperience(20);
        checkLevelUp(character);
    }

    @Override
    public void meditate(Character character) {
        System.out.println(character.getName() + " is meditating...");
        character.increaseHealth(5);
    }

    @Override
    public void fight(Character character) {
        System.out.println("Intermediate characters can't fight.");
    }

    private void checkLevelUp(Character character) {
        if (character.getExperience() >= 150) {
            System.out.println(character.getName() + " has leveled up to Expert!");
            character.setState(new ExpertState());
        }
    }
}
