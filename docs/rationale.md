# Rationale Document
_Team: JulianAndAlex_

#### Team Members:
- Alexander John Occhipinti (29994705)
- <julian's info goes here>

## Actors
### Enemies
### Miniboss: Doctor Maybe
### Q (NPC)
<br>

## Doors

**Class:** `Door` extends `Ground`<br>
Doors intend to separate the `Player` between `Locations` on the map (`GameMap`) unless the Player is holding the right `Key`. _(subclass of `Item` explained later in the Items subsection)_.<br>

A `Door` acts as a normal wall (`Ground`) in all circumstances until the player approaches the door attempting to walk through it. If the corresponding `Key` in the player's inventory, the door will allow the player to walk through it. Going through the door does not require an action or consume the `Key`.<br>

However, each `Key` will be tied to a specific `Door`. This means that only the correct key can be used to unlock a given door. On the creation of a ``Key``, it must be tied to an instance of `Door` through the `Key`'s constructor via a reference to the `Door` instance.
<br>
## Items

### Rocket Items
**Instances of `Item`** <br>
These items are used to progress the narrative of the game and to serve as an end goal: to build a rocket.

The rocket is built by the player as the game progresses. The first goal of the Player is to obtain the rocket plans from inside a locket room (behind a `Door` unlockable with a `Key`). With the rocket plans in the player's inventory, they talk to Q (`npcQ`) in order to exchange them for a rocket body. Then, the player must enter another locked room containing a miniboss (`DrMaybe`). Once defeated, they will drop the rocket engine. Using both the rocket engine and the rocket body, the player must place both of these objects on the rocket pad (instance of `Location`) in order to finish the game.

- **Rocket plans**
  The plans of the rocket. Found within a locked room to be exchanged by Q for the rocket body.
- **Rocket body**
  The first item required to complete the game as described above.
- **Rocket engine**
  The second item required to complete the game as described above.

### Keys
**Class:** `Key` extends `Item`<br>
Keys are `Items` which are associated with a specific instance of `Door`. As a result, they can not be created without refering to a door. The job of keys are to allow the `Player` to "unlock" a specific door, allowing them to pass/walk through it.<br>

Keys are:
- applicable to only one specific `Door`
- passivly used when passing through a door: as in;  do not an `Action` from the player
- not consumed when used

In order for keys to tie information about which door they are unlocking, they require to be thier own subclass of `Item`.
<br>
## Places on the map

### Rocket Plan Room
**Behind a locked `Door`**<br>
A place on the `GameMap` which is surrounded by walls (`Ground`) which can only be accessed by unlocking a `Door` with a `Key`. This feature is not a class but rather a collection of game objects arranged on the `GameMap`.

Inside this room is the rocket plans item described above.
### Doctor Maybe's Room
**Behind a locked `Door`**<br>
A place on the `GameMap` which is surrounded by walls (`Ground`) which can only be accessed by unlocking a `Door` with a `Key`. This feature is not a class but rather a collection of game objects arranged on the `GameMap`.

Inside this room is the `DrMaybe` miniboss. The player must fight Dr Maybe (not much of a fight since he is stationary and weak) in order to gain the rocket engine. This fight takes place in this room.
### Rocket Pad
**Instance of `Location`** <br>
The rocket pad is a `Location` placed inside a locked room (as described many times above) on which the rocket items will be placed upon to complete the game. The rocket pad will be one tile inside the room and therefore should be represented by a `Location` class.
