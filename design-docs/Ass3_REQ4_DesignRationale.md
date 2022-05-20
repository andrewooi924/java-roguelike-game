# REQ 4: Minecraft Design Rationale

For reference here are the class and sequence diagrams.

## Class Diagram

![ass3 req4 class diagram]()

## Sequence Diagram

![ass3 req4 sequence diagram]()

## Rationale

To implement chopping trees into the game, we've allowed trees to have health points. Since we've
designed it so that Sprouts do not drop Wood while Saplings and Mature Trees do, We've made it
so that Saplings and Mature Trees have the capability "CAN_BE_CHOPPED" to allow the program to check
if the tree can be chopped before applying ChopAction(a new class) on it. 

ChopAction is the class used to actually chop the trees. The class utilises the execute method which
initialises the Player's punch as the main weapon for chopping, then it checks the Player's inventory
for an Axe, which is the only item in the game that has the new capability "CAN_CHOP", if it exists,
then the Player's main chopping tool switches to the Axe. The method then chops the tree, proceeding to
check if the tree's health points are below or equal to 0, and if so, will set the ground to Dirt and
drop Wood.

TODO here:
Implementation of Wood
Implementation of PickUpStackableAction <- changed from PickUpCoinAction
Implementation of Magic Pouch

As for the implementation of crafting, we've created a CraftingTable ground that is placed next to Toad
that can be used through the CraftAction class. To avoid violating the DRY principle, all the craftable items 
implement the Craftable interface which contains methods used to get the recipes for crafting said items, 
get the crafted items and their names.

The CraftAction class utilises the aforementioned Magic Pouch and checks if the Player has sufficient materials
to craft the item from the recipe. If so, the method will craft the item and add it to the Player's 
inventory, otherwise it will display a message saying the Player's does not have enough materials.

TODO here: 
Implementation of Menus

The TreasureChest class contains a Treasure Chest ground that can be "unlocked" by the Player to 
gain surprises. It utilises the UnlockChestAction class where it takes a random generated probability
and adds the actor or item that is within the range of the generated probability to the location of 
the Treasure Chest, the Treasure Chest is that set to Dirt.

For the GalaxySword class, to avoid violating the DRY principle, I've made the class extend the Sword class, the
only differences being the change in display character, returned damage and its name.

Since we've added a few weapons (including the ones in creative REQ5) into the game, we've also changed the
way the program access the Player's held weapon using the getWeapon method. What we've done is first override the
getWeapon method in the Player class, create an ArrayList to store all the weapons possessed by the Player including
his Intrinsic Weapon (punch), then utilising a Comparator to sort the ArrayList by weapon damage in decreasing order,
and finally choosing the weapon at the top of the ArrayList, which would ultimately be the weapon with the highest
damage.

