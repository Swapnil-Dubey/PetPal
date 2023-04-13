package ui;

import model.Event;
import model.EventLog;
import model.HouseOfPets;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Represents GUI Version Window for PetPal
public class HouseOfPetsGUI extends JFrame implements ActionListener {
    private static final String greetings = "Welcome to your House Of Pets!";
    private HouseOfPets hop;
    private GridBagConstraints constraints;
    private JFrame frame;
    private JPanel panel;
    private JButton showButton;
    private JButton removeButton;
    private JButton addButton;
    private JButton interactButton;
    private JButton historyButton;
    private JButton saveButton;
    private JButton loadButton;


    // Constructs main window
    // EFFECTS: sets up window in which HouseOfPets will be interacted with
    public HouseOfPetsGUI() {
        super("PetPal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);
        setupBasics();
        frame.add(panel);
        constraints = new GridBagConstraints();
        positioningOne();
        positioningTwo();
        positioningThree();
        detectingButtons();
        panel.setBackground(new Color(150, 111, 51));
        frameSettings();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                EventLog eventLog = EventLog.getInstance();
                for (Event event : eventLog) {
                    System.out.println(event);
                }
            }
        });
    }

    // MODIFIES: JFrame
    // EFFECTS: Sets settings of the JFrame

    private void frameSettings() {
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    // MODIFIES: JFrame, JPanel, HouseOfPets
    // EFFECTS: Sets up basic components of the project

    private void setupBasics() {
        hop = new HouseOfPets();
        frame = new JFrame();
        panel = new JPanel(new GridBagLayout());
    }

    // MODIFIES: panel
    // EFFECTS: Positions the heading, add and remove button on the screen
    public void positioningOne() {

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(10, 10, 10, 10);
        JLabel greetingslabel = new JLabel(greetings);
        greetingslabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        greetingslabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(greetingslabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(0, 10, 10, 5);
        addButton = new JButton("Add a Pet");
        panel.add(addButton, constraints);
        addButton.setActionCommand("add");


        constraints.gridx = 1;
        constraints.gridy = 1;
        removeButton = new JButton("Remove a Pet");
        panel.add(removeButton, constraints);
        removeButton.setActionCommand("remove");
    }

    // MODIFIES: panel
    // EFFECTS: Positions the show pets, interact, history of interactions buttons on the window
    public void positioningTwo() {
        // add the show button
        constraints.gridx = 0;
        constraints.gridy = 2;
        showButton = new JButton("Show all pets");
        panel.add(showButton, constraints);
        showButton.setActionCommand("show");


        constraints.gridx = 1;
        constraints.gridy = 2;
        interactButton = new JButton("Interact with a Pet");
        panel.add(interactButton, constraints);
        interactButton.setActionCommand("action");


        constraints.gridx = 0;
        constraints.gridy = 3;
        historyButton = new JButton("Show history of interactions");
        panel.add(historyButton, constraints);
        historyButton.setActionCommand("history");

    }

    // MODIFIES: panel
    // EFFECTS: Positions the save and load buttons on the screen
    public void positioningThree() {

        constraints.gridx = 1;
        constraints.gridy = 3;
        saveButton = new JButton("Save");
        panel.add(saveButton, constraints);
        saveButton.setActionCommand("save");


        constraints.gridx = 1;
        constraints.gridy = 4;
        loadButton = new JButton("Load");
        panel.add(loadButton, constraints);
        loadButton.setActionCommand("load");
    }

    // EFFECTS: Sets up an action listener for all the buttons
    public void detectingButtons() {
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        showButton.addActionListener(this);
        interactButton.addActionListener(this);
        historyButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    // REQUIRES: e is not null.
    // EFFECTS: Processes an action event from the buttons and performs the corresponding event.
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("add".equals(e.getActionCommand())) {
            AddPetPanel app = new AddPetPanel();
            app.addPet(hop);
        } else if ("remove".equals(e.getActionCommand())) {
            RemovePetPanel rpp = new RemovePetPanel();
            rpp.removePet(hop);
        } else if ("show".equals(e.getActionCommand())) {
            ShowPetsPanel spp = new ShowPetsPanel();
            spp.showPets(hop);
        } else if ("action".equals(e.getActionCommand())) {
            InteractionsPanel ip = new InteractionsPanel();
            ip.performInteraction(hop);
        } else if ("history".equals(e.getActionCommand())) {
            HistoryInteractionsPanel hip = new HistoryInteractionsPanel();
            hip.historyInteractions(hop);
        } else if ("save".equals(e.getActionCommand())) {
            SaveLoadPanel slp = new SaveLoadPanel();
            slp.save(hop);
        } else if ("load".equals(e.getActionCommand())) {
            SaveLoadPanel slp = new SaveLoadPanel();
            hop = slp.load(hop);
        }

    }


    public static void main(String[] args) {
        new HouseOfPetsGUI();
    }

}
