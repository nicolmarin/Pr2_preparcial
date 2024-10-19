module co.edu.uniquindio.parcial.pr2_parcial {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.parcial2.pr2_parcial2 to javafx.fxml;
    exports co.edu.uniquindio.parcial2.pr2_parcial2;
    opens co.edu.uniquindio.parcial2.pr2_parcial2.viewcontroller;
    exports co.edu.uniquindio.parcial2.pr2_parcial2.viewcontroller;
    opens co.edu.uniquindio.parcial2.pr2_parcial2.controller;
    exports co.edu.uniquindio.parcial2.pr2_parcial2.controller;
}