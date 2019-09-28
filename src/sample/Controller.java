package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private Label percent;

    @FXML
    private Slider slider;

    @FXML
    private TextField price;

    @FXML
    private Button btn;

    @FXML
    private TextField tip;

    @FXML
    private TextField cost;

    private int currentPercent = 15;

    @FXML
    void click(ActionEvent event) {
        String p = price.getText();
        if(p.equals("")){
            price.setText("empty");
            return;
        }
        if(!Character.isDigit(p.charAt(0))){
           price.setText("not an int");
           return;
        }
        double pr = Integer.valueOf(p);
        double t = pr / 100 * currentPercent;
        String tips = String.valueOf(t);
        tip.setText(
                tips.substring(0, tips.indexOf(".") + 2)
        );
        String costs = String.valueOf(pr + t);
        cost.setText(
                costs.substring(0, costs.indexOf(".") + 2)
        );
    }

    @FXML
    void sliderDrag(MouseEvent event) {
        Double i = slider.getValue() * 0.15;
        int val =  i.intValue();
        percent.setText(
                String.valueOf(val) + "%"
        );
        currentPercent = val;
    }

}
