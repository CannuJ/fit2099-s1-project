# Recommendations for the game engine

## Introduction
The engine provided to us for this unit despite being complex, ended up being very powerful and modular once we got used to it.
However, there were many times during the past three assignments where we felt like we had to work around the engine or just
straight up fight against it. We've outlined some comments and recommendations in this document.

## Actors
### Inventory
There were quite a few times where I felt like the implementation of each actor's inventory was too basic, as it was just a list.
It makes it frustrating to do higher level operations such as: searching the inventory for items with a specific name (the only identifying quality to an item)
and converting items between being on the ground and being in an inventory on the fly.
My proposal would be to create a separate inventory class (e.g. Inventory) which would use a list internally to store items, including the basic list implementation methods
as well as other public methods which provide high level operations such as:
```java
public Item searchByName(String name) // search the inventory for an item with a given name and returns it
public void add(Item item) // adds an item to the inventory, changing its actions accordingly, could also check for weight of items
public int weight() // gets the weight of the inventory items
public void display() // prints a nice inventory screen to the console showing usefull metadata such as: name, weight, value, weapon or not etc...
```
Adding a specific class for inventory items into every actor would allow for further extensibility in the future for more game mechanics as mentioned above.
A downside may be that this class may obscure some of the more rarely used methods of Lists. However it could be mitigated more or less by having a method
which returns a read-only copy of the inventory list to perform operations on.
### Hitpoints
At the moment, each Actor's hitpoints is only visible to themselves. The only way to modify each Actor's hitpoints is via the `heal()` and `damage()` methods.
However, consider how you may implement a poison which instantly kills you or a binding spell which keeps an actor's hitpoints constant with another's.
This is impossible to do in an elegant manner, so my suggestion is to add the following methods into Actor:
```java
public void setHealth(int health)
public int getHealth()
public void setMaxHealth(int maxHealth)
public int getMaxHealth()
```
This would allow for more complex mechanics seen in some RPG-like games such as heart containers and other mechanics that rely on reading the actor's health or setting
the actor's health directly. A poison that halves you health or an instant death pad, these changed would allow for a larger variety of possibilities.
A downside may be that other programmer may rely to heavily on these less restrictive public methods and may use it for purposes that may be more suited to the existing,
more restrictive relative health changing methods. (i.e. `heal()` and `hurt()`). They may for example call something like: `actor.hurt(actor.getHealth() - 5)` instead of
`actor.hurt(5)`. It may be useful to modify the heal and hurt methods to call the `actor.setHealth()` method to make sure that all modifications to an actor's hitpoints
are done in the same place.


## AttackAction
Since AttackAction is managed by the `World` class, it is very hard to work around it without editing it or creating an entire subclass just to change one line.
### Refactor
The current state of the `AttackAction` class is that everything from calculating damage taken to printing the result on the screen to making the player "sleep" is
all handles in its `execute()` method, as it is a child of `Action`. In order to make AttackAction more flexible (and not to mention easier to read) I believe that
the AttackAction class should be refactored in such a way that its child classes can easily override these methods to allow for more complex methods of attacking.
(e.g. ranged attacks, poison damage, magic damage etc...)
### Actor's Death
On a similar topic to the Hitpoints section, the fact that death is exclusivly handled by the `AttackAction` class makes killing an actor *only* possible when another Actor "attacks" it
seems to me like a major design flaw. The `AttackAction` class holds too much power in this regard. It is impossible for a tile (`Ground` object), `Action` or other class to directly
"kill" (or make them fall asleep) an Actor. I feel that an `Actor` dying should be handles in the `Actor` class, as this would both simplify `AttackAction` and would allow Actors
to die by other means. It is extremely common in games that the environment, or performing certain actions have the ability to instantly kill Actors. Some examples include:
- lava tiles
- spikes on the ground
- pitfalls
- telefragging (having something teleport to your location kills you, would have been useful when the player goes to the moon in this game a la DOOM, Quake etc...)
- fall damage
the list goes on...

If the action of dying was in `Actor`, killing an actor would be as simple as `actor.kill()`, not relying on calling `hurt(99999)` and waiting for another actor to finish it off. 
