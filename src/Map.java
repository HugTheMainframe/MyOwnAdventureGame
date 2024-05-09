public class Map {
    private Room currentRoom;

    public Map(){
        Room room1 = new Room("Room 1 - The Crossroads", "Your journey begins at the desolate crossroads, " +
                "\nwhere the paths diverge into the unknown. To the left, " +
                "\njagged cliffs loom, their shadows concealing treacherous secrets. To the right, " +
                "\ngnarled trees twist and writhe, their branches reaching out like grasping claws. " +
                "\nChoose your path wisely, for each step brings you closer to the abyss.");
        Room room2 = new Room("Room 2 - The Forest Trail", "The forest trail winds through a haunted woodland, " +
                "\nits ancient trees bearing silent witness to untold horrors. " +
                "\nBranches creak and moan, as if mourning the souls lost within their grasp. " +
                "\nThe air is thick with the scent of decay, and every rustle of leaves sends shivers down your spine. " +
                "\nYet, as you press forward, the path splits once more, offering no respite from the darkness.");
        Room room3 = new Room("Room 3 - Whispering Hollow", "You venture deeper into the forest, " +
                "\ndrawn towards a clearing where the whispers of the damned echo through the trees. " +
                "\nShadows dance amidst the gnarled roots, and the air grows heavy with the weight of forgotten sins. " +
                "\nHere, in the heart of the Whispering Hollow, the spirits of the lost beckon you closer, " +
                "\ntheir voices promising salvation or damnation.");
        Room room4 = new Room("Room 4 - The Mountain Pass", "The mountain pass rises like a titan from the earth, " +
                "\nits jagged peaks piercing the heavens. The wind howls mournfully, " +
                "\ncarrying the echoes of ancient battles long forgotten. Each step is a struggle against the elements, " +
                "\nas if the very mountains themselves seek to test your resolve. " +
                "\nYet, amidst the desolation, a sense of purpose drives you ever onward.");
        Room room5 = new Room("Room 5 - Convergence Point", "Your journey brings you to the convergence point, " +
                "\nwhere the boundaries between worlds blur and reality fades into shadow. " +
                "\nThe air crackles with dark energy, and the ground trembles beneath your feet as if the very earth itself is alive. " +
                "\nHere, at the crossroads of fate, you stand on the precipice of oblivion, ready to embrace the darkness that awaits.");
        Room room6 = new Room("Room 6 - Shadowed Path", "You stray from the beaten trail, " +
                "\ndrawn towards a shadowed path that winds deeper into the forest's embrace. " +
                "\nThe trees loom overhead like twisted sentinels, their branches reaching out to ensnare unwary travelers. " +
                "\nThe air grows thick with the stench of decay, and every step forward feels like a descent into madness. " +
                "\nYet, despite the darkness that surrounds you, a glimmer of hope flickers in the distance.");
        Room room7 = new Room("Room 7 - The Crumbling Caverns", "The mountain pass leads you to the Crumbling Caverns, " +
                "\nwhere the earth itself seems to groan in agony. Ancient stalactites hang like daggers from the ceiling, " +
                "\ntheir shadows dancing upon the walls like specters of the damned. The air is thick with the scent of decay, " +
                "\nand every sound echoes through the darkness like a death knell. " +
                "\nYet, amidst the chaos, a sense of purpose drives you deeper into the abyss.");
        Room room8 = new Room("Room 8 - Summit's Edge", "At the summit's edge, you stand upon the brink of existence, " +
                "\nwhere the void stretches out before you in all its infinite darkness. " +
                "\nThe sky is a swirling vortex of chaos, its stars flickering like dying embers in the void. " +
                "\nHere, amidst the abyss, a sense of dread grips your soul, " +
                "\nas if the very fabric of reality is unraveling before your eyes.");
        Room room9 = new Room("Room 9 - The Nexus of Realms", "You have reached the Nexus of Realms, " +
                "\nhere the boundaries between worlds blur and reality is but a fleeting illusion. " +
                "\nThe air crackles with dark energy, and shadows twist and writhe like tortured souls in the void. " +
                "\nHere, amidst the chaos of existence, a sense of clarity fills your mind, " +
                "\nas if the answers you seek lie buried within the depths of your own soul.");

        room1.setEastConnection(room2);
        room1.setSouthConnection(room4);
        room2.setWestConnection(room1);
        room2.setEastConnection(room3);
        room3.setWestConnection(room2);
        room3.setSouthConnection(room6);
        room4.setNorthConnection(room1);
        room4.setSouthConnection(room7);
        room5.setSouthConnection(room8);
        room6.setNorthConnection(room3);
        room6.setSouthConnection(room9);
        room7.setNorthConnection(room4);
        room7.setEastConnection(room8);
        room8.setNorthConnection(room5);
        room8.setWestConnection(room7);
        room8.setEastConnection(room9);
        room9.setNorthConnection(room6);
        room9.setWestConnection(room8);
        Item sword = new Item("Sword", "Very sharp edge");
        Item teespoon = new Item("Teespoon", "is very dangerous");
        Item bow = new Item("Bow of light", "Will perish dark creatures");
        Item spear = new Item("Long Spear", "Will reach you from very far distance");
        Food apple = new Food("Apple", "Will protect you from the doctor", 25);
        Food banana = new Food("Banana", "Restore your calcium deficit", 50);
        Food poison = new Food("Poison", "Don't like your life. Here drink..", -100);

        room1.addItems(sword);
        room1.addItems(bow);
        room1.addItems(teespoon);
        room8.addItems(spear);
        room1.addItems(apple);
        room2.addItems(banana);
        room2.addItems(poison);

        currentRoom = room1;

    }

    public Room getCurrentRoom() {
        return currentRoom;
    }


}
