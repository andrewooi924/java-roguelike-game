# REQ 3: Enemies Design Rationale

For reference, here are the class diagrams and sequence diagrams.

## Class Diagram

![req3 class diagram](./REQ3_class.png "REQ3 Class Diagram")

## Sequence Diagram

![req3 sequence diagram](./REQ3_sequence_01.png)
![req3 sequence diagram](./REQ3_sequence_02.png)

## Rationale
The Koopa and Goomba are enemies that appear in the game that can attack
the Player. The Koopa and Goomba classes instantiate the following classes:    
  
(1). WanderBehaviour: It is used to allow the enemies to wander around the map.  
(2). FollowBehaviour: It is used to make the enemies follow the Player if the Player
is standing next to them.  
(3). AttackBehaviour: It is used to make the enemies automatically attack the Player
if the Player is standing next to them.
  
The AttackBehaviour class creates the KickAction class which is used by a Goomba
to kick(attack) the Player and the PunchAction class which is used by a Koopa
to punch(attack) the Player.  
  
The AttackAction class which is used by the Player to attack enemies will drop
create a new SuperMushroom object after the Player breaks a Koopa shell with 
a Wrench.  
