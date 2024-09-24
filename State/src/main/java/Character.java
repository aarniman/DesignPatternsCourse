public class Character {
    private String name;
    private int health;
    private double experience;
    private State state;

    public Character(String name) {
        this.name = name;
        this.health = 100;
        this.experience = 0;
        this.state = new NoviceState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void train() {
        state.train(this);
    }

    public void meditate() {
        state.meditate(this);
    }

    public void fight() {
        state.fight(this);
    }

    public double getExperience() {
        return experience;
    }

    public void increaseExperience(double experience) {
        this.experience += experience;
        System.out.println("Experience: " + this.experience);
    }

    public void increaseHealth(int health) {
        this.health += health;
        System.out.println("Health: " + this.health);
    }

    public void decreaseHealth(int health) {
        this.health -= health;
        System.out.println("Health: " + this.health);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public State getState() {
        return state;
    }

    public void displayStatus() {
        System.out.println();
        System.out.println("Character: " + name);
        System.out.println("Health: " + health);
        System.out.println("Experience: " + experience);
        if(state instanceof NoviceState)
            System.out.println("State: Novice");
        else if(state instanceof IntermediateState)
            System.out.println("State: Intermediate");
        else if(state instanceof ExpertState)
            System.out.println("State: Expert");
        System.out.println("State: Master");
    }
}
