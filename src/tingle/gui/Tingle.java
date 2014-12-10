/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingle.gui;

import tingle.gui.popups.AboutWindow;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import tingle.data.TileSet;
import tingle.data.TingleDataManager;

/**
 *
 * @author Kevin
 */
public class Tingle extends JFrame{
    //BEGIN GUI MEMBERS
    public JFrame frame;
    private JMenuBar menuBar;
    private JScrollPane tileSelectorScrollPane;
    private JScrollPane propertiesBox;
    
    //BEGIN DATA MEMBERS
    public static TingleDataManager myTingleDataManager;
    
    private Tingle() {
        myTingleDataManager = new TingleDataManager();
        run();
    }
    
    /**
     * Initializes the main JFrame state, size, layout, title, and close operation
     */
    private void initializeFrame() {
        frame = new JFrame("Menu");
        
        frame.setLayout(null);
        
        frame.setVisible(true);
        //frame.setExtendedState(frame.MAXIMIZED_BOTH);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tingle Map Editor");
    }
    
    /**
     * Creates the menu bar to be used within the main JFrame
     */
    private void createMenuBar() {
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        //BEGIN FILE MENU
        
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        
        JMenuItem newFile = new JMenuItem("New");
        JMenuItem openFile = new JMenuItem("Open...");
        JMenuItem saveFile = new JMenuItem("Save");
        JMenuItem saveAsFile = new JMenuItem("Save As...");
        JMenuItem exit = new JMenuItem("Exit");
        
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        fileMenu.add(exit);
        
        //BEGIN ABOUT MENU
        
        JMenu aboutMenu = new JMenu("About");
        menuBar.add(aboutMenu);
        
        JMenuItem about = new JMenuItem("About");
        
        aboutMenu.add(about);        
        
        //BEGIN ACTION LISTENERS
        
        about.addActionListener(new AboutAction());
        exit.addActionListener(new ExitAction());        
        newFile.addActionListener(new NewFileAction());
        openFile.addActionListener(new OpenFileAction());
        saveFile.addActionListener(new SaveFileAction());
        saveAsFile.addActionListener(new SaveAsFileAction());
    }
    
    /**
     * Creates the tileSelector scroll pane and adds it to the JFrame.
     */
    private void createTileSelectorScrollPane() {
        tileSelectorScrollPane = new JScrollPane();
        TileSelector ts = new TileSelector(new TileSet("src\\resources\\minecraft.png"));
        tileSelectorScrollPane.setViewportView(ts);
        tileSelectorScrollPane.add(ts);
    }
    
    /**
     * Creates the PropertiesBox and adds it to the JFrame.
     */
    private void createPropertiesBox() {
        PropertiesBoxPanel pbp = new PropertiesBoxPanel();
        propertiesBox = new JScrollPane(pbp);
        
        propertiesBox.setViewportView(pbp);
        
        frame.add(propertiesBox);
        propertiesBox.setBounds(new Rectangle(10, 310, 350, 220));
        
    }
    
    /**
     * Runs the GUI
     */
    private void run() {
        initializeFrame();
        createMenuBar();
        createPropertiesBox();
        //createTileSelectorScrollPane();
               
        JScrollPane MapGridScroll = new JScrollPane(new ObjectPane(new File("src\\resources\\bacon.jpg"), true));
        JScrollPane TileSelectorScroll = new JScrollPane(new ObjectPane(new File("src\\resources\\bacon.jpg"), false));
        
        MapGridScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        MapGridScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        frame.add(MapGridScroll);
        
        JPanel p =new JPanel();
        p.setBorder(new EmptyBorder(10, 10, 10, 10) );
        
        MapGridScroll.setBounds(new Rectangle(10, 10, 765, 290));
        
        frame.setLocationRelativeTo(menuBar);
        frame.add(TileSelectorScroll);
        //TileSelectorScroll.setBounds(new Rectangle(800, 300));
    }
    
    /**
     * Main method for the Tingle Map Editor program.  Where the magic begins!
     * @param args 
     */
    public static void main(String[] args) {
        Tingle tingle = new Tingle();
    }
    
    ///BEGIN PUBLIC CLASSES///
    
    /**
     * public action listener class which handles the about menu option
     */
    public class AboutAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AboutWindow gui = new AboutWindow(Tingle.this);
            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            gui.setSize(340, 125);
            gui.setLocation(300, 300);
            gui.setVisible(true);
            gui.setTitle("Tingle Map Editor");
        }
    }
    
    /**
     * public action listener class which handles the exit menu option
     */
    public class ExitAction implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {        
            int result = JOptionPane.showConfirmDialog(null, "Do you wish to save before exiting?", "Tingle Data Manager", WIDTH);
            
            if (result == 0) {
                myTingleDataManager.saveFile();
                System.exit(0);
            } else if (result == 1) {
                System.exit(0);
            }            
        }
    }
    
    /**
     * public action listener class which handles the new file creation option
     */
    public class NewFileAction implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            if (myTingleDataManager.getMapFile() != null) {
                //Save before closing dialog
            }
            
            myTingleDataManager = new TingleDataManager();
        }
    }
    
    /**
     * public action listener class which handles the open file menu dialog
     */
    public class OpenFileAction implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            final JFileChooser fc = new JFileChooser();
            FileFilter filter = new FileNameExtensionFilter("Tingle Map File", "tingle");
            fc.setFileFilter(filter);
            
            JLabel myLabel = new JLabel("");
            
            int response = fc.showOpenDialog(Tingle.this);
            
            if (response == JFileChooser.APPROVE_OPTION) {
                myTingleDataManager.setMapFile(new File(fc.getSelectedFile().toString()));              
                //System.out.println(myTingleDataManager.getMapFile());
                myTingleDataManager.loadFile();
            }
        }
    }
    
    /**
     * public action listener class which handles the save menu operation
     */
    public class SaveFileAction implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            myTingleDataManager.saveFile();
        }
    }
    
    /**
     * public action listener class which handles the save as menu dialog.
     */
    public class SaveAsFileAction implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            final JFileChooser fc = new JFileChooser();
            
            JLabel myLabel = new JLabel("");
            
            int response = fc.showSaveDialog(Tingle.this);
            
            if (response == JFileChooser.APPROVE_OPTION) {
                myTingleDataManager.setMapFile(new File(fc.getSelectedFile().toString()));              
                //System.out.println(myTingleDataManager.getMapFile());
                myTingleDataManager.saveFile();
            }
        }
    }
}
