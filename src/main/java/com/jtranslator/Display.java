package com.jtranslator;

import java.awt.*;
import javax.swing.*;

public class Display extends JFrame {

    public static final int WIDTH = 381, HEIGHT = 437;

    //handle switch between panels
    private JPanel layouts;

    //JPanels names
    static final String SETTINGS_GUI = "SettingsGUI";
    static final String ABOUT = "About";

    private Translator translator;

    private SettingsGUI settingsGUI;
    private About about;

    //get the state of the frame and save it
    //when clicking Save
    private Settings settings;

    public Display(Settings settings, Translator translator) {
        this.settings = settings;
        this.translator = translator;
        initComponents();
    }

    private void initComponents() {
        layouts = new JPanel(new CardLayout());
        settingsGUI = new SettingsGUI(this, settings, translator);
        about = new About(this);

        layouts.add(settingsGUI, SETTINGS_GUI);
        layouts.add(about, ABOUT);

        this.setContentPane(layouts);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setTitle(Translator.APPLICATION_NAME);

        //center the program in the screen
        int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - WIDTH / 2;
        int y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - HEIGHT / 2;
        this.setLocation(x, y);

        this.setResizable(false);
        this.pack();
    }

    //Change the view to the panel specified by name
    void show(String name) {
        ((CardLayout) layouts.getLayout()).show(layouts, name);
    }
}
