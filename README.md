Terminal RPG Game designed using software patterns
- RUN WITH ant then java -jar in dist folder to play the game

- MVC:
    Model: Player/Character/Enemy, Containers
    Controller: User Interface, Battle system
    View: GameViewer,ShopViewer,BattleViewer

- Character/Player/Enemy classes are implemented using the template/strategy pattern
- Item class for weapons/armor and potions are implemented using decorator pattern
- Observer pattern for the battle system and game UI 
- Player owns a Bag container for all storable items including weapons and armor
- Factory classes are created to make Item and Character objects
- There are loader classes that load data to the game which is implemented using template method pattern
