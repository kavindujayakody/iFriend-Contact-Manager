import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {
    private Cmethod cmethod = new Cmethod();
    private ImageIcon image;//------------------------------

    public static AddContact addContactForm;
    public static UpdateContact updateContactForm;
    public static SearchContact searchContactForm;
    public static DeleteContact deleteContactForm;
    public static ViewContact viewContactForm;

    HomePage() {

        image = new ImageIcon(getClass().getResource("ifriend.png"));//-------
        setTitle("iFriend Contact Manager");
        setSize(800, 600); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2)); 

        // Left panel with image and title
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        panel1.setLayout(new BorderLayout());
        
        JLabel titleLabel = new JLabel("iFriend Contact Manager", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        panel1.add(titleLabel, BorderLayout.NORTH);
        
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("ifriend.png"); // Specify your image path here
        imageLabel.setIcon(imageIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(imageLabel, BorderLayout.CENTER);

        // Right panel with buttons
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.LIGHT_GRAY);
        panel2.setLayout(new GridBagLayout()); // Using GridBagLayout for precise control
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add buttons to panel2
        gbc.gridx = 0;
        gbc.gridy = 0;
        JButton addc = createButton("Add New Contact", Color.YELLOW);
        addc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (addContactForm == null) {
                    addContactForm = new AddContact();
                }
                addContactForm.setVisible(true);
            }
        });
        panel2.add(addc, gbc);

        gbc.gridy = 1;
        JButton update = createButton("Update Contact", Color.GREEN);
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (updateContactForm == null) {
                    updateContactForm = new UpdateContact();
                }
                updateContactForm.setVisible(true);
            }
        });
        panel2.add(update, gbc);

        gbc.gridy = 2;
        JButton search = createButton("Search Contact", Color.GRAY);
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (searchContactForm == null) {
                    searchContactForm = new SearchContact();
                }
                searchContactForm.setVisible(true);
            }
        });
        panel2.add(search, gbc);

        gbc.gridy = 3;
        JButton delete = createButton("Delete Contact", Color.BLUE);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (deleteContactForm == null) {
                    deleteContactForm = new DeleteContact();
                }
                deleteContactForm.setVisible(true);
            }
        });
        panel2.add(delete, gbc);

        gbc.gridy = 4;
        JButton view = createButton("View Contact", Color.WHITE);
        view.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (viewContactForm == null) {
                    viewContactForm = new ViewContact();
                }
                viewContactForm.setVisible(true);
            }
        });
        panel2.add(view, gbc);

        gbc.gridy = 5;
        JButton exit = createButton("EXIT", Color.RED);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        panel2.add(exit, gbc);

        // Add the panels to the frame
        add(panel1);
        add(panel2);
        
    }

    // Method to create buttons
    private JButton createButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("", Font.BOLD, 20));
        button.setBackground(backgroundColor);
        button.setPreferredSize(new Dimension(200, 50)); // Set button size here
        return button;
    }

    public static void main(String[] args) {
        HomePage homePage = new HomePage();
        homePage.setVisible(true);
    }
}
