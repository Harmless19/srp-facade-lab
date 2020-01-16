package srpfacadelab;

import java.util.List;

public class InventoryManager {
      RpgPlayer player;

      public InventoryManager(RpgPlayer player){
            this.player = player;
      } 

      public int calculateInventoryWeight() {
            int sum=0;
            for (Item i: player.getInventory()) {
            sum += i.getWeight();
            }
            return sum;
      }

      public boolean checkIfItemExistsInInventory(Item item) {
            for (Item i: player.getInventory()) {
                  if (i.getId() == item.getId())
                  return true;
            }
            return false;
      }

      public boolean pickUpItem(Item item) {
            int weight = calculateInventoryWeight();
            if (weight + item.getWeight() > player.getCarryingCapacity())
                  return false;

            if (item.isUnique() && checkIfItemExistsInInventory(item))
                  return false;

            // Don't pick up items that give health, just consume them.
            if (item.getHeal() > 0) {
                  player.setHealth(player.getHealth() + item.getHeal());

                  if (player.getHealth() > player.getMaxHealth())
                        player.setHealth(player.getMaxHealth());

                  if (item.getHeal() > 500) {
                        player.getGameEngine().playSpecialEffect("green_swirly");
                  }

                  return true;
            }

            // Feature: Super rare items look more awesome
            if (item.isRare() && item.isUnique()){
                  player.getGameEngine().playSpecialEffect("blue_swirly");
            }
            else if (item.isRare())
                  player.getGameEngine().playSpecialEffect("cool_swirly_particles");

            player.AddToInventory(item);

            // update carying capacity
            player.setCurrentCapacity(player.getCurrentCapacity() + item.getWeight());

            player.calculateStats();

            return true;
      }

      public void useItem(Item item) {
            if (item.getName().equals("Stink Bomb"))
            {
                  List<IEnemy> enemies = player.getGameEngine().getEnemiesNear(player);

                  for (IEnemy enemy: enemies){
                  enemy.takeDamage(100);
                  }
            }
      }


}