OOSE Assignment for turn based combat system

- run java Game will prompt to a loader menu that asks which method of loading will occur to create the objects, this can be used to load from a file, database, web, html etc. The choices only appear if they are available, more types of loading can be added later.



- MVC:
    Model: Player/Character/Enemy, Containers
    Controller: User Interface, Battle system
    View: 

- Character/Player/Enemy classes are implemented using the template/strategy pattern
-
- Item class for weapons/armor and potions are implemented using decorator pattern
- Observer pattern for the battle system and game UI 
- Player owns a Bag container for all storable items including weapons and armor
- Factory classes are created to make Item and Character objects
- There are loader classes that load data to the game which is implemented using template method pattern
