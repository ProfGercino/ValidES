module br.com.valides {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    exports br.com.valides;
    //exports br.com.valides.test.trigonometria;
    //exports br.com.valides.test.conversoes;
    //exports br.com.valides.test.calculos;
    //exports br.com.valides.test.validadores;

    opens br.com.valides to javafx.fxml;

    opens br.com.valides.controller to javafx.fxml;
    opens br.com.valides.controller.trigonometria to javafx.fxml;
    opens br.com.valides.controller.conversoes to javafx.fxml;
    opens br.com.valides.controller.calculos to javafx.fxml;
    opens br.com.valides.controller.validadores to javafx.fxml;

}