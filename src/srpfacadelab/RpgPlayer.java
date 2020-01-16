package srpfacadelab;

import java.util.ArrayList;
import java.util.List;


public class RpgPlayer {
    public static final int MAX_CARRYING_CAPACITY = 1000;

    private final IGameEngine gameEngine;

    private int health;

    private int maxHealth;

    private int armour;

    private List<Item> inventory;

    private int currentCapacity;

    // How much the player can carry in pounds
    private int carryingCapacity;

    public RpgPlayer(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        inventory = new ArrayList<Item>();
        carryingCapacity = MAX_CARRYING_CAPACITY;
    }

    public void calculateStats() {
        for (Item i: inventory) {
            armour += i.getArmour();
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getArmour() {
        return armour;
    }

    private void setArmour(int armour) {
        this.armour = armour;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    private void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public List<Item> getInventory(){
        return inventory;
    }

    public IGameEngine getGameEngine(){
        return gameEngine;
    }

    public void AddToInventory(Item item){
        inventory.add(item);
    }

    public int getCurrentCapacity(){
        return currentCapacity;
    }

    public void setCurrentCapacity(int capacity){
        currentCapacity = capacity;
    }
}
