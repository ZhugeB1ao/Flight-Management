public class FlightManagement {
    public void run() {
        Menu menu = new Menu(6);
        menu.add("Add New Flight");
        menu.add("Remove Flight");
        menu.add("Update Flight");
        menu.add("Search Flight");
        menu.add("Display Flight Board");
        menu.add("Quit");
        int choice;
        Flight f = new Flight();
        do{
            System.out.println("\n FLIGHT MANAGER");
            choice = menu.getChoice();
            switch(choice){
                case 1: f.Add_Flight(); break;
                case 2: f.Remove_Flight(); break;
                case 3: f.Update_Flight(); break;
                case 4: f.Search_Flight(); break;
                case 5: f.Display_Flight(); break;
                case 6: return;
            }
        }while(choice >=1 && choice<6);
    }
}