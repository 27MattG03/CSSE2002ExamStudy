package week9;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
    private JFrame frame;
    private JPanel panel;

    private Model model;
    public View (Model model) {
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.model = model;
        JButton countButton = new JButton("Click me!");
        JLabel counter = new JLabel(String.valueOf(this.model.getCount()));
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countButtonAction();
            }
        });
        this.panel.add(countButton);
        this.panel.add(counter);
        this.frame.pack();
        this.frame.setVisible(true);
    }
    public void countButtonAction () {
        this.model.countIncrement();
        this.frame.setVisible(true);
    }


}
