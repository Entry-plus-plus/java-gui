public class Floor {

    Room[] rooms;

    public Floor(int numberOfRooms) {
        //er wordt een Floor aangemaakt met een aantal kamers
        //de kamers worden in een array gezet

        rooms = new Room[numberOfRooms];
        for (int i = 0; i<numberOfRooms; i++) {
            rooms[i] = new Room();
        }
    }

    //geeft het totaal aan mensen op de hele verdieping terug door de hoeveelheden van alle kamers op te tellen
    public int getAmount() {
        int amount = 0;
        for (Room room : rooms) {
            amount += room.amount;
        }
        return amount;
    }


}
