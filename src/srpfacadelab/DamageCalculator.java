package srpfacadelab;

public class DamageCalculator{
      RpgPlayer player;

      public DamageCalculator(RpgPlayer player){
            this.player = player;
      }
      public void takeDamage(int damage) {
            if (damage < player.getArmour()) {
                  player.getGameEngine().playSpecialEffect("parry");
            }

            int damageToDeal = damage - player.getArmour();

            // Feature: Un-encumbered players can parry more successfully
            if (player.getCurrentCapacity() < 0.5 * player.getCarryingCapacity()){
                  damageToDeal = (damageToDeal * 3) / 4;
            }

            player.setHealth(player.getHealth() - damageToDeal);

            player.getGameEngine().playSpecialEffect("lots_of_gore");
      }
}