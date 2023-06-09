package week8;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class week8 {
    private JFrame frame;
    private JPanel panel;
    public week8() {
        this.frame = new JFrame("Main Frame");
        this.panel = new JPanel();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.add(panel);
    }

    /**
     * GUI's
     * Java first party GUI toolkits
     *
     * AWT (Abstract Window Toolkit) - java.awt:
     *     - In Java 1.0
     *     - Uses native GUI widgets
     *     - Relative Positioning
     * Swing - javax.swing:
     *     - Uses custom widgets
     *     - Looks the same on all platforms
     *     - Could do fancier things - 2D, 3D, animation
     *
     * Object -> Component -> Container -> Panel -> Applet
     *                \            \
     *                 \            -> Window -> Frame
     *                  \                  \
     *                   \                  -> Dialog
     *                    \
     *                     -> JComponent -> JLabel
     *                                   -> JList
     *                                   -> JTable
     *                                   -> JComboBox
     *                                   -> JSlider
     *                                   -> JMenu
     *                                   -> AbstractButton -> JButton
     *
     * javax.swing.*
     * Provides a set of "lightweight" (all-Java language) components that, to the maximum degree possible,
     * work the same on all platforms
     *
     * - A JFrame creates the window
     * - A JPanel is a canvas to add GUI components (e.g JLabel, JButton, etc)
     * - Multiple frames and panels can be created
     * - Panel are added to a frame
     * - Program continues to run until the frame is closed
     */
    public void GUI() {
        JLabel label = new JLabel("Hello Gui");
        this.panel.add(label);
        this.frame.setVisible(true);
    }
    public void GUI2() {
        JLabel label = new JLabel("Hello Gui");
        JButton button = new JButton("Useless Button");
        this.panel.add(label);
        this.panel.add(button);
        this.frame.pack();
        this.frame.setVisible(true);
    }

    /**
     * Action Listeners
     * Things that happen in the GUI generate events
     * Listeners listen for these events and invoke methods when the events are heard
     *
     * For GUI's we will use the ActionListener interface
     *  -> ActionListener is an interface for receiving action events
     *  -> We implement the ActionListener and override the actionPerformed(ActionEvent e) method
     *  -> We register each individual component using the addActionListener method
     *  -> Each time a component triggers an event, the ActionPerformed method is invoked.
     *
     *  Useful listeners:
     *  -> MouseMovementListener
     *  -> MouseListener
     *  -> KeyboardListener
     *
     */
    public class ActionListenerExample implements ActionListener {
        private int count = 0;
        private JFrame frame;
        private JLabel label;
        public ActionListenerExample(JFrame frame, JLabel label) {
            this.frame = frame;
            this.label = label;
        }

        public void actionPerformed(ActionEvent e) {
            this.count++;
            this.label.setText(String.valueOf(getCount()));
            this.frame.pack();
            this.frame.setVisible(true);
        }
        public int getCount () {
            return this.count;
        }

    }
    public void counterGUI () {
        JButton counter = new JButton("Click me!");
        JLabel count = new JLabel(String.valueOf(0));
        ActionListenerExample buttonListener = new ActionListenerExample(this.frame,count);
        counter.addActionListener(buttonListener);
        this.panel.add(counter);
        this.panel.add(count);
        this.frame.pack();
        this.frame.setVisible(true);

    }

    public void textReverseGUI() {
        JLabel reversed = new JLabel();
        JTextField text = new JTextField();
        text.setColumns(20);
        JButton button = new JButton("Reverse da Text");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder build = new StringBuilder(text.getText());
                build.reverse();
                reversed.setText(build.toString());
                getFrame().pack();
                getFrame().setVisible(true);
            }
        });
        this.panel.add(text);
        this.panel.add(button);
        this.panel.add(reversed);
        this.frame.pack();
        this.frame.setVisible(true);


    }


    public JFrame getFrame() {
        return this.frame;
    }
    public JPanel getPanel() {
        return this.panel;
    }




}
