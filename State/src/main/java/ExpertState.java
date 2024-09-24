public class ExpertState implements State {
    @Override
    public void train(Character character) {
        System.out.println(character.getName() + " is training...");
        character.increaseExperience(30);
        checkLevelUp(character);
    }

    @Override
    public void meditate(Character character) {
        System.out.println(character.getName() + " is meditating...");
        character.increaseHealth(10);
    }

    @Override
    public void fight(Character character) {
        System.out.println(character.getName() + " is fighting...");
        character.decreaseHealth(15);
        character.increaseExperience(50);
        checkLevelUp(character);
    }

    private void checkLevelUp(Character character) {
        if (character.getExperience() >= 300) {
            System.out.println(character.getName() + " leveled up to Master!");
            character.setState(new MasterState());
        }
    }
}
