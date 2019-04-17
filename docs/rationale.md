# Rationale Document
_Team: JulianAndAlex_

#### Team Members:
- Alexander John Occhipinti (29994705)
- <julian's info goes here>
----
## Actors
### Enemies
### Miniboss: Doctor Maybe
### Q (NPC)
<br>
## Doors

** Class: ** `Door` extends `Ground`<br>
Doors intend to separate the `Player` between `Locations` on the map (`GameMap`) unless the Player is holding the right `Key`. _(subclass of `Item` explained later in the Items subsection)_.<br>

A `Door` acts as a normal wall (`Ground`) in all circumstances until the `Player` approaches the door attempting to walk through it. If the corresponding `Key` in the player's inventory, the door will allow the player to walk through it. Going through the door does not require an action or consume the `Key`.<br>

However, each `Key` will be tied to a specific `Door`. This means that only the correct `Key` can be used to unlock a given door. On the creation of a ``Key``, it must be tied to an instance of `Door` through the `Key`'s constructor via a reference to the `Door` instance.
<br>
## Items

### Rocket Items
** Instances of `Item` ** <br>
### Keys
** Class: ** `Key` extends `Item`<br>
<br>
## Places on the map

### Rocket Plan Room
** Behind a locked `Door` **
### Doctor Maybe's Room
** Behind a locked `Door` **
### Rocket Pad
** Instance of `Location` ** <br>
