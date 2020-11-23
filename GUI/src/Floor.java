public class Floor {
    Room[] rooms;

    public Floor(int numberOfRooms) {

        rooms = new Room[numberOfRooms];
        for (int i = 0; i<numberOfRooms; i++) {
            rooms[i] = new Room();
        }
    }

    public int getAmount() {
        int amount = 0;
        for (int i=0; i<rooms.length; i++) {
            amount+= rooms[i].amount;
        }
        return amount;
    }


}
