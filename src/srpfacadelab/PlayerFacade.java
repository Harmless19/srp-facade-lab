package srpfacadelab;

public class PlayerFacade{
      RpgPlayer player;
      InventoryManager inventory;
      DamageCalculator damageCalculator;

      public PlayerFacade(RpgPlayer player){
            this.player = player;
            inventory = new InventoryManager(player);
            damageCalculator = new DamageCalculator(player);
      }

      public void takeDamage(int damage){
            damageCalculator.takeDamage(damage);
      }

      public int calculateInventoryWeight(){
            return inventory.calculateInventoryWeight();
      }

      public boolean checkIfItemExistsInInventory(Item item){
            return inventory.checkIfItemExistsInInventory(item);
      }


      public boolean pickUpItem(Item item){
            return inventory.pickUpItem(item);
      }

      public void useItem(Item item){
            inventory.useItem(item);
      }
}