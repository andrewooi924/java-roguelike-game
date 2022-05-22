# Requirement 4

**Title**: Minecraft

**Description**: Mario can now punch trees and collect wood just like Minecraft! With wood, mario can also craft
tools to defend himself such as a sword from the crafting table! On top of that, there are treasures around the map which drop good loot
when you unlock it such as a galaxy sword! With the menu piling up with many options, the crafting menu comes in handy to provide easier focus on what the player would like to do. 

**Explanation why it adheres to SOLID principles** (WHY):
- All classes follows the SRP and will only have one sole responsibility. For instance, the chopping of a tree, the player may have an axe(to chop the tree), a chopping action, and a PickUpStackableAction when the player wants to pick up the wood. 
- The crafting of an item also follows the SRP where there is a crafting table(which the player can craft items at), and a craft action which then the item is added to the inventory!
- Open Closed Principle is also followed in the Switching of Menus. All classes which extended from the SwitchingAction does not modify the base code but instead just extends to it. For instance, the switching action can be switched to either shop or crafting menu.
- Interface Segregation Principle is followed. There are items that can be bought and items that is stackable. However, there are some items that only can be bought and not stackable, such as Axe. Thus, we split the 2 interfaces.
- Lastly, DIP is also followed. The CraftAction only needs to know the Craftable methods and not all the item's methods. Therefore, the interface Craftable was created to follow this principle so that only Craftable items can be passed to CraftAction.

![img.png](img.png)

# Requirement 5

**Title**:
Ranged Combat

**Description**:
Bows, arrows and guns now exist in the game! They utilize dfs to search through the enemies and finish them! Bows have a range of 5 and have arrows to shoot while guns have unlimited POWER(unlimited range and unlimited bullets)!! With these weapons, we're confident mario can one shot Bowser(who needs Peach when we got guns).

**Explanation why it adheres to SOLID principles** (WHY):
- All classes follow SRP. When the player wants to shoot an enemy, it must have a bow or gun and calls the RangedAttackAction which attacks the enemy. All classes mentioned have their single responsibility which meets the principle.
- Open Closed Principle is followed as well, where Bow and Gun extends to RangedWeapon without modifying the source code and only adds new features.

![img_1.png](img_1.png)





[comment]: <> (| Requirements                                                                                                            | Features &#40;HOW&#41; / Your Approach / Answer                                                                                                                               |)

[comment]: <> (| ----------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |)

[comment]: <> (| Must use at least two &#40;2&#41; classes from the engine package                                                               |We used Item and Action from the engine class. RangedWeapon, Gun, Arrow and Bow all extends Item while RangedAttackAction extends from Action. |)

[comment]: <> (| Must use/re-use at least one&#40;1&#41; existing feature &#40;either from assignment 2 and/or fixed requirements from assignment 3&#41; | Arrows implements the Tradable interface and can be bought from Toad for $40. RangedAttackAction uses AttackAction from assignment 2 as it works similar to how it attacks the enemy&#40;take damage etc&#41;. Arrow also implements the resettable which will be removed when the player resets the game. We also used MagicPouch where it can store coins and now arrows as well! Bow can also be crafted using the craftable interface which was created in Assignment 3 Req 4.                                                                                                                                                      |)

[comment]: <> (| Must use existing or create new abstractions &#40;e.g., abstract or interface, apart from the engine code&#41;                  |  We have created the RangedWeapon abstract class where Gun and Bow extends to it. As all ranged weapons do have the code to search for enemies at a distance and also have limited ammunition, it follows the Open Closed Principle by extending the code and not modifying the base code. Arrows do utilize the existing Stackable interface as well where one arrow item can have multiple amounts of arrow in it which reduces the amount of items on the ground.                                                                                                                                                            |)

[comment]: <> (| Must use existing or create new capabilities                                                                            |  We used the existing capability of HOSTILE_TO_PLAYER capability. In the dfs, if it finds any actor with that capability, it will let the player know that it can shoot that actor. Arrows also uses the existing CAN_CARRY_STORABLES where the magic pouch will then add the amount of arrows to the magic pouch. Furthermore, it also uses the RESETTABLE capability to reset the arrows if they are on the ground.                                                                                                                                                                     |)
