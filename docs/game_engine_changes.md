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
