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

TODO:
Implementation of Wood
Implementation of Crafting
Implementation of Menus
Implementation of Magic Pouch
Implementation of Treasure Chests
Implementation of Galaxy Sword (LSP)
Implementation of new getWeapon() method for Player class

