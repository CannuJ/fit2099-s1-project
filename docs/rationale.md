# Rationale Document
_Team: JulianAndAlex_

#### Team Members:
- Alexander John Occhipinti (29994705)
- Julian Cannuli (27821706)

## Actors

### QuittablePlayer
**Class:** `QuittablePlayer` inherits from `Player`<br>
The only difference between this inherited version of `Player` and `Player` itself, is that every `QuittablePlayer`
has the action of `QuitGameAction` appened to its list of actions at every point in the game, enabling it to quit directly from the menu.
A `QuittablePlayer` is able to lose when its `hitPoints` reach 0 or lower, during the `hurt()` call a `GameOver` screen is shown via `GameOver().show()`

#### QuitGameAction
**Class:** `QuitGameAction` inherits from `Action`
An action, when executed (`execute()`) quits the game via `System.exit(0)`. It's menu character is always `x`.

### Enemies

**Class:** `Enemy` inherits from `Actor`<br>
An `Enemy` serves as an obstacle that must be defeated in order for the `Player` to continue on their adventure.<br>

The `Player` will be the target of an `Enemy`, who's goal is to inflict damage or hinder the `Player` on their journey, where through inflicting damage, or acting as a physical obstacle.<br>

**Instances of 'Enemy'** <br>

### Grunt
**Class:** `Grunt` inherits from `Actor`<br>
A `Grunt` will follow the `Player` around and 'slap' them, inflicting damage.<br>

This class will serve as the main class containing Goons, and Dr. Maybe.<br>

### Goon
**Class:** `Goon` inherits from `Actor`<br>
Goons will follow the `Player` around and deal double the amount of damage inflicted by a `Grunt`.<br>

There is also a 10% chance they will shout an insult at the `Player`.<br>

For the most part, this means that Grunts will act just as a `Grunt` except with the additions mentioned above.<br>

### Ninja
**Class:** `Ninja` inherits from `Actor`<br>
A `Ninja` works differently to other units in that is does no deal damage to the `Player` but rather inhibits movement through the use of stun powder.<br>

The `Ninja` will not move unless it is within 5 squares of the `Player`, in which it will either move one space away from the `Player`, or attempt to stun them by throwing a Bag of Stun Powder.<br>

### MiniBoss: Doctor Maybe
**Class:** `DrMaybe` inherits from `Actor`<br>
Dr. Maybe has half the hit-points of a `Grunt` and deals half the damage of a `Grunt`.<br>

Furthermore, Dr.Maybe does not move.<br>

Located in a locked room, and will drop the **Rocket engine** (See below) upon being defeated. <br>

### Q (NPC)
**Class:** `NPC` inherits from `Actor`<br>
`Q`, unlike the rest of the actor subclasses mentioned above, is a friendly NPC.<br>

`Q` will supply the `Player` with **Rocket body** in exchange for the **Rocket plans** (See below).<br>

`Q` will randomly roam the map (TBD on implementation).<br>

### FinalBoss: Yugo Maxx
**Class:** `FinalBoss` inherits from `Actor`<br>
FinalBoss has an `exoskeleton`, rendering them invulnerable and deals double the damage of a `Grunt`.<br>

`FinalBoss` is located on the move and moves around freely.<br>

To damage `FinalBoss`, one must first destroy the `exoskeleton` by using the `WaterPistol` on it. When the boss has an exoskeleton and is holding a filled `WaterPistol`, the `FinalBoss` allows the action of `SquirtWaterAction` to destroy the skeleton. (See: `WaterPistol`)

Defeating `FinalBoss` will complete the game. When the boss' `hitPoints` reach 0 or lower, an instance of `GameOver` (in its winning state) is created an executed (`show()`) 

## Doors

**Class:** `Door` inherits from `Ground`<br>
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
**Class:** `Key` inherits from `Item`<br>
Keys are `Items` which are associated with a specific instance of `Door`. As a result, they can not be created without referring to a door. The job of keys are to allow the `Player` to "unlock" a specific door, allowing them to pass/walk through it.<br>

Keys are:
- applicable to only one specific `Door`
- passively used when passing through a door: as in;  do not an `Action` from the player
- not consumed when used

In order for keys to tie information about which door they are unlocking, they require to be their own subclass of `Item`.

### WaterPistol
**Class:** `WaterPistol` inherits from `Item`
The water pistol is a weapon which is used against Yugo Maxx and the end of the game to break down his exoskeleton and make him vulnerable to damage. The pistol itself is not a weapon, so it can not be used to attack anything else.

The water pistol tracks whether it contains water or not using the private `filled` attribute. It can be refilled by going to a `Water` tile which files the pistol using `fill()`, given to the user as a `FillWaterPistolAction`. When the WaterPistol is full and the player is standing next to a Yugo Maxx with
an exoskeleton, the `SquirtWaterAction` becomes available which removes Maxx's exoskeleton using `FinalBoss`'s `shed()` method which empties the pistol (`empty()`).

Can be found on the `moonMap` and can be filled at the lake located on the `earthMap`.
<br>
## Places on the `earthMap`
### Main
This space is a 20x10 space containing walls, doors, several enemies, as well as `NPCQ` and `DrMaybe`.

The premise here is to work your way around the `earthMap` collecting all 3 items required to build the `Rocket`, so that you can venture to the `moonMap` (see below) and defeat the `FinalBoss`, Yugo Maxx.
### Lake
**Class:** `Lake`
The `Lake` class is used to build a square of `Water` tiles onto a given map via the `buildLake()` method.
It is useful to the player as it is a source of water for the `WaterPistol`, a key item needed to finish the game.
A lake is placed on the bottom right corner of `earthMap`.

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
## Places on the `moonMap`

### Main
This space essentially mimics that of `earthMap`, containing several enemies and especially `FinalBoss`.

The aim here is to defeat `FinalBoss` by first breaking his `exoskeleton` using the `waterPistol`, rendering the `FinalBoss` vulnerable to damage (invulnerable otherwise). We do this by having a 'stat' called `hasExoskeleton`, a boolean. While this is true, any damage inflicted on `FinalBoss` is mitigated.

## Other

### GameOver
**Class:** `GameOver`
A class that represents a game over screen with pre-determined messages for winning and losing.
To specify a win or a lose screen, a `boolean` being `true` for a win and `false` for a loss, can be passed into the constructor.
A game over screen is displayed whenever a `QuittablePlayer` reaches 0 or less `hitPoints` (loss) or when Yugo Maxx reaches 0 or less `hitPoints` (win).
A screen is displayed using public method `show()`
A text screen is displayed depending on the outcome and the player is prompted to press enter to quit. After they press enter, the game terminates. 
