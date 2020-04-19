import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Interface extends JFrame {
    private JPanel mainPanel;

    private JPanel top;
    private ImagePanel center;
    private JPanel bottom;
    private JPanel right;
    private JPanel buttons;


    private JLabel name;
    private JLabel energy;
    private JLabel health;
    private JLabel inteligence;
    private JLabel happiness;
    private JLabel money;

    private JProgressBar energyBar;
    private JProgressBar healthBar;
    private JProgressBar inteligenceBar;
    private JProgressBar happinessBar;
    private JProgressBar moneyBar;

    private JTextArea scenario;

    private JButton choice1;
    private JButton choice2;


    public Interface(int lg, int larg){

        super("Vie a l'INSA");

        //Dimensions de la fenetre graphique et fermeture
        this.setSize(lg,larg);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Creation des Panels
        mainPanel = new JPanel(new BorderLayout());
        //top = new JPanel(new FlowLayout());
        center = new ImagePanel (new FlowLayout());
        right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setBorder(BorderFactory.createEmptyBorder(20, 20, 20 ,20));
        bottom = new JPanel (new FlowLayout());
        bottom.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();



        //Couleur de chaque panel
        //top.setBackground(Color.BLACK);
        bottom.setBackground(Color.RED);
        center.setBackground(Color.WHITE);

        //CENTER
        //Image center
        BufferedImage img2 = null;
        try {
            img2 = ImageIO.read(new File("imagem.jpg"));
        } catch (IOException e) {
        }

        center.setBackground(img2);


        //RIGHT
        //Image Profil
        BufferedImage img1 = null;
        try {
            img1 = ImageIO.read(new File("petit xing.jpg"));
        } catch (IOException e) {
        }
        JLabel photoProfil = new JLabel(new ImageIcon(getScaledImage(img1,100,100)));

        right.add(photoProfil);

        //Progress Bars
        //Se for pro numero aparecer: healthBar.setStringPainted(true);
        energyBar = new JProgressBar();
        energyBar.setValue(90);
        healthBar = new JProgressBar();
        healthBar.setValue(50);
        inteligenceBar = new JProgressBar();
        inteligenceBar.setValue(10);
        happinessBar = new JProgressBar();
        happinessBar.setValue(100);
        moneyBar = new JProgressBar();
        moneyBar.setValue(5);

        //Atributs Personnage
        name = new JLabel("Xinguinho"); // Usar getName
        name.setBorder(BorderFactory.createEmptyBorder(5, 0, 5 ,5));
        energy = new JLabel("Energy:");
        energy.setBorder(BorderFactory.createEmptyBorder(5, 0, 5 ,5));
        health = new JLabel("Health:");
        health.setBorder(BorderFactory.createEmptyBorder(5, 0, 5 ,5));
        inteligence = new JLabel("Inteligence:");
        inteligence.setBorder(BorderFactory.createEmptyBorder(5, 0, 5 ,5));
        happiness = new JLabel("Happiness:");
        happiness.setBorder(BorderFactory.createEmptyBorder(5, 0, 5 ,5));
        money = new JLabel("Money:");
        money.setBorder(BorderFactory.createEmptyBorder(5, 0, 5 ,5));

        right.add(name);
        right.add(energy);
        right.add(energyBar);
        right.add(health);
        right.add(healthBar);
        right.add(inteligence);
        right.add(inteligenceBar);
        right.add(happiness);
        right.add(happinessBar);
        right.add(money);
        right.add(moneyBar);

        //BOTTOM
        scenario = new JTextArea("Parabens, voce entrou no INSA, sua vida sera destruida em pouco tempo.O que voce gostaria de fazer?");
        scenario.setEditable(false);
        scenario.setBackground(Color.red);
        scenario.setBorder(BorderFactory.createEmptyBorder(5, 5, 2 ,5));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        bottom.add(scenario, gbc);

        //Buttons
        buttons = new JPanel(new FlowLayout());
        buttons.setBackground(Color.RED);
        choice1 = new JButton("Ir para Kfet");
        choice2 = new JButton("Desistir");
        buttons.add(choice1);
        buttons.add(choice2);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 1;
        bottom.add(buttons, gbc);

        //ajout du conteneur principal dans la fenetre
        this.add(mainPanel);


        //Ajout des éléments graphiques au conteneur principal
        //mainPanel.add(top, BorderLayout.NORTH);
        mainPanel.add(center, BorderLayout.CENTER);
        mainPanel.add(right, BorderLayout.EAST);
        mainPanel.add(bottom, BorderLayout.SOUTH);



        setVisible(true);
    }

    public Image getScaledImage(Image Img, int wt, int ht) {
        BufferedImage resizedImg = new BufferedImage(wt, ht, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(Img, 0, 0, wt, ht, null);
        g2.dispose();

        return resizedImg;
    }


}


