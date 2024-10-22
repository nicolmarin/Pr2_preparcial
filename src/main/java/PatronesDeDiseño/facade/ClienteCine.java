package PatronesDeDiseño.facade;


import java.time.LocalDate;

public class ClienteCine {
    public static void main(String[] args) {
        CineFacade cineFacade = new CineFacade();
        cineFacade.realizarCompraCine("Barbie",(LocalDate.of(2023, 10, 2)),"VIP", "4D", 20, 10, "Big Mac Super Ultra");
    }
}
