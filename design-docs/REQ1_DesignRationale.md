# REQ1:Let it grow! :deciduous_tree:

For reference, here are the class diagrams and the sequence diagrams.

## Class Diagram

![req1 class diagram](./REQ1_class.png "REQ1 Class Diagram")

## Sequence Diagram (Tree's tick method)

![req1 sequence diagram](./REQ1_sequence.png "REQ1 Sequence Diagram")

## Rationale

A Coin extends an Item, like in the real world, it is a physical "thing" that
we can _see_ and _pick up_. In the engine, this helps us be able to re-use logic to
display the item, and pick it up, without having to worry about the
implementation details of that.

### Problems WalletKeeper interface fixes

The interesting thing here is the WalletKeeper interface. As an analogy,
in the real world, you would find a $5 coin and a $10 coin on the floor and
pick those up, you would have two separate coins on your person. A $5 coin and
a $10 coin. The usefulness of this is that it mirrors the real world more
closely, which is useful beause it is easier to think about since we deal with
it ourselves. There are a few downsides though.

In this game, having that logic would get _very_ messy, _very_ quickly. To find
how much money an actor has, in the Actor-derived class, it would need to
manually loop through the entire inventory, look for anything that resembles a
coin, and add it to a "total" amount of coins.

Now, consider that you accumulate hundreds of $5 coins. you would have way more
than the 26 extra actions ('a' to 'z') to drop each individual $5 coin.

How about, if in the future, we would want to do something with the money, and
buy or sell items? (This is actually part of REQ5). In the real world, there is
some messiness with this when handling transactions, such as considering when
you want to buy a $4 item, but you only have a $5 coin, and the shopkeeper
doesn't have a $1 coin to give you back as change.

The WalletKeeper interface fixes all these problems. We would have an entity,
for example the "Player" class implement this interface. Rather than keeping
individual coins, it lets the player keep a virtual "wallet" with money
being accumulated it in as a number instead of individual coins. This means
it will always have an up-to-date balance for the player's wallet.

As for the actions for dropping coins, there would be no more coins to drop.

For the trading problem, the WalletKeeper interface would enforce
a way to withdraw or deposit to-and-fro your wallet.

It also adds some additioanal functionality. We can now use it for _any_ actor
that implements WalletKeeper, not just the Player. Looking at PickUpCoinAction,
note how it has a dependency on WalletKeeper. Folowing the Liskov Substitution
Principle, we could use the methods of WalletKeeper (so here, to add money
to the wallet) as a substitute for any class that implements it. This
abstraction is useful, because ideally we want a Single Responsibility for the
class and not hard-code wallet functionality into specific classes like Player,
which we only want to do a single thing. Now, we can, if needed, create a new
class "Bandit", that will have a behaviour that makes them wander and pick up coins
as well.

### Problems with the WalletKeeperInterface

There are some downsides to it. You cannot drop coins anymore, if that would
need to be done; The coins items are destroyed as you insert it into your wallet.

You can't have "special" coins that do things, for example, imagine wanting "red coins"
that besides adding to your balance, gives you an invincibility status
for a period of time.

### Design of Tree

Looking at the sequence diagram for the tree's `tick()` method, you can see how
long it is with a lot of alternating logic on class communication depending on what
stage the tree is at.

An Alternative design would be to have separate classes for different stages of
a Tree, and each time it needs to grow, the tree would remove itself from the
map and replace itself with the next stage of the tree.

The way the sequence diagram would then look would be to have 3
separate sequence diagrams, each quite short, and all with less width than this
sequence diagram, because it would not need to worry about the classes that it
won't communicate with in that current stage, for example, in a Sprout sequence
diagram, it won't have a `coin :Coin` or `koopa :Koopa` because those are only
interacted wi th in the other stages. This is quite nice as we can separate the
concerns of the behaviour of different stages of the tree into separate
classes. If we were want to change some of the behaviour of a particular stage
of the tree (e.g: Sprout) , we could do it in the Sprout class instead which is specifically
single responsibility for that stage of the tree.

The problem with that approach is that it would be harder to have the common
attributes shared across all the tree stage classes. For example, what if we
want to give trees a HP bar and ability to be punched down in any stage of the
tree? Then, all three classes would need to be modified to account for this.
Hence, we use a TreeState enum to keep track of the tree's stage of growth
instead.

The reason for a GroundCharacteristic enum is to check for fertile grounds
on the surrounding. In the Dirt class (not pictured), the constructor would
add the capability of it being FERTILE. This way, it would be easy to extend in
the future, if we have other types of ground besides dirt that we want to be
fertile enough to grow trees on.
