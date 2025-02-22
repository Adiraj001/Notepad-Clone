import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Info extends JFrame {

    Info() {
        setBounds(400, 100, 600, 500);
        setLayout(null);
        setTitle("Information About This Notepad");

        ImageIcon notepadIcon = new ImageIcon(getClass().getResource("/icons/notepad.png"));
        ImageIcon windowsIcon = new ImageIcon(getClass().getResource("/icons/windows.png"));
        Image windowsImage = windowsIcon.getImage().getScaledInstance(400, -1, Image.SCALE_SMOOTH);
        ImageIcon windowsImageIcon = new ImageIcon(windowsImage);
        setIconImage(notepadIcon.getImage());
        JLabel header = new JLabel(windowsImageIcon);
        add(header);
        header.setBounds(70, 40, 400, 80);

        Image notepadImage = notepadIcon.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon notepadImageIcon = new ImageIcon(notepadImage);
        JLabel notepadLabel = new JLabel(notepadImageIcon);
        add(notepadLabel);
        notepadLabel.setBounds(50, 180, 70, 70);

        JLabel text = new JLabel("<html>Windows Notepad BY Adiraj version 1.0 <br> All Right Reserved To Aditya <br> Made ON JAVA </html>");
        text.setFont(new Font("Arial", Font.PLAIN, 15));
        text.setForeground(Color.BLACK);
        text.setBounds(150, 100, 500, 250);
        add(text);

        // Adding social media links
        JEditorPane socialMedia = new JEditorPane();
        socialMedia.setContentType("text/html");
        socialMedia.setText("<html>Follow me on: <br>"
                + "<a href='https://github.com/Adiraj001'>GitHub</a> <br>"
                + "<a href='https://in.linkedin.com/in/aditya-raj-pandey-516262121'>LinkedIn</a></html>");
        socialMedia.setEditable(false);
        socialMedia.setOpaque(false);
        socialMedia.setFont(new Font("Arial", Font.PLAIN, 15));
        socialMedia.setBounds(150, 300, 500, 100);
        socialMedia.addHyperlinkListener(e -> {
            if (e.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED) {
                try {
                    Desktop.getDesktop().browse(e.getURL().toURI());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(socialMedia);

        JButton okButton = new JButton("OK");
        okButton.setBounds(250, 400, 100, 30);
        add(okButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Info();
    }
}
