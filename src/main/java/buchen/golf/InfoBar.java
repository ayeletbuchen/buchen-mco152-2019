package buchen.golf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoBar {

    private JPanel infoBar = new JPanel();
    private final int textFieldLength = 5;
    private JTextField powerText;
    private JTextField angleText;
    JLabel angleLabel;
    JLabel powerLabel;
    private GolfCourseComponent golfCourseComponent;


    public InfoBar(GolfCourseComponent golfCourseComponent) {
        this.golfCourseComponent = golfCourseComponent;
        setUpVelocity();
        setUpAngle();
        setUpGoButton();
    }

    public JPanel getInfoBar() {
        return infoBar;
    }

    private void setUpVelocity() {
        powerLabel = new JLabel("Power");
        powerText = new JTextField();
        powerText.setColumns(textFieldLength);
        infoBar.add(powerLabel);
        infoBar.add(powerText);
    }

    private void setUpAngle() {
        angleLabel = new JLabel("Angle");
        angleText = new JTextField();
        angleText.setColumns(textFieldLength);
        infoBar.add(angleLabel);
        infoBar.add(angleText);
    }

    private void setUpGoButton() {
        JButton goButton = new JButton("GO!");
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                golfCourseComponent.goClicked(Double.parseDouble(powerText.getText()), Double.parseDouble(angleText.getText()));
            }
        });
        infoBar.add(goButton);
    }
}
