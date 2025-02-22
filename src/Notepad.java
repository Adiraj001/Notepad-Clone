import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.awt.event.InputEvent;

public class Notepad extends JFrame implements ActionListener {
    private JTextArea area;

    public Notepad() {
        setSize(800, 600);
        setLocationRelativeTo(null);

        setTitle("Adiraj's Notepad");

        // ICON
        try {
            ImageIcon notepadIcon = new ImageIcon(ClassLoader.getSystemResource("icons/notepad.png"));
            Image icon = notepadIcon.getImage();
            setIconImage(icon);
        } catch (Exception e) {
            System.out.println("Icon not found");
        }

        // Making MenuBar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);

        // 1st Menu Option FILE
        JMenu file = new JMenu("File");
        file.setFont(new Font("Arial", Font.BOLD, 14));

        JMenuItem newDocument = new JMenuItem("New");
        newDocument.addActionListener(this);
        newDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        newDocument.setFont(new Font("Arial", Font.PLAIN, 12));

        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(this);
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        open.setFont(new Font("Arial", Font.PLAIN, 12));

        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(this);
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        save.setFont(new Font("Arial", Font.PLAIN, 12));

        JMenuItem print = new JMenuItem("Print");
        print.addActionListener(this);
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
        print.setFont(new Font("Arial", Font.PLAIN, 12));

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        exit.setFont(new Font("Arial", Font.PLAIN, 12));

        file.add(newDocument);
        file.add(open);
        file.add(save);
        file.add(print);
        file.addSeparator();  // Add separator before exit
        file.add(exit);

        // 2nd Menu Option EDIT
        JMenu edit = new JMenu("Edit");
        edit.setFont(new Font("Arial", Font.BOLD, 14));

        JMenuItem copy = new JMenuItem("Copy");
        copy.addActionListener(this);  // Added missing action listener
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        copy.setFont(new Font("Arial", Font.PLAIN, 12));

        JMenuItem cut = new JMenuItem("Cut");
        cut.addActionListener(this);  // Added missing action listener
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        cut.setFont(new Font("Arial", Font.PLAIN, 12));

        JMenuItem paste = new JMenuItem("Paste");
        paste.addActionListener(this);  // Added missing action listener
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        paste.setFont(new Font("Arial", Font.PLAIN, 12));

        edit.add(copy);
        edit.add(cut);
        edit.add(paste);

        // 3rd Menu Option HELP
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setFont(new Font("Arial", Font.BOLD, 14));

        JMenuItem help = new JMenuItem("Help");
        help.addActionListener(this);
        help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
        help.setFont(new Font("Arial", Font.PLAIN, 12));

        JMenuItem about = new JMenuItem("About");
        about.addActionListener(this);
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
        about.setFont(new Font("Arial", Font.PLAIN, 12));

        JMenuItem info = new JMenuItem("Info");
        info.addActionListener(this);
        info.setFont(new Font("Arial", Font.PLAIN, 12));

        helpMenu.add(help);
        helpMenu.add(about);
        helpMenu.add(info);
        help.addActionListener(this);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        area = new JTextArea();
        area.setFont(new Font("Arial", Font.PLAIN, 12));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        JScrollPane pane = new JScrollPane(area);
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        
        switch (command) {
            case "New":
                area.setText("");
                break;
                
            case "Open":
                JFileChooser chooser = new JFileChooser();
                chooser.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter restrict = new FileNameExtensionFilter("Text Files (*.txt)", "txt");
                chooser.addChoosableFileFilter(restrict);
                
                if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        area.read(reader, null);
                        reader.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
                
            case "Save":
                JFileChooser saveAs = new JFileChooser();
                saveAs.setFileFilter(new FileNameExtensionFilter("Text Files (*.txt)", "txt"));
                
                if (saveAs.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                    File file = saveAs.getSelectedFile();
                    if (!file.getName().toLowerCase().endsWith(".txt")) {
                        file = new File(file.getAbsolutePath() + ".txt");
                    }
                    
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        area.write(writer);
                        writer.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
                
            case "Print":
                try {
                    area.print();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error printing: " + e.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
                
            case "Exit":
                System.exit(0);
                break;
                
            case "Copy":
                area.copy();
                break;
                
            case "Cut":
                area.cut();
                break;
                
            case "Paste":
                area.paste();
                break;
                
            case "Help":
                JOptionPane.showMessageDialog(this, 
                    "This is a simple notepad application.\n\n" +
                    "Shortcuts:\n" +
                    "New: Ctrl+N\n" +
                    "Open: Ctrl+O\n" +
                    "Save: Ctrl+S\n" +
                    "Print: Ctrl+P\n" +
                    "Copy: Ctrl+C\n" +
                    "Cut: Ctrl+X\n" +
                    "Paste: Ctrl+V\n" +
                    "Help: Ctrl+H\n" +
                    "Exit: Esc",
                    "Help", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "About":
                JOptionPane.showMessageDialog(this,
                    "Notepad\n" +
                    "Version 1.0\n" +
                    "Developed by Adiraj Pandey",
                    "About", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Info":
                new Info().setVisible(true);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Error setting system look and feel: " + e.getMessage());
        }
        
        SwingUtilities.invokeLater(() -> new Notepad());
    }
}