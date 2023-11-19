import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TJTLVista extends JFrame implements ComponentListener, ActionListener, ItemListener{

    private ControlPanel controlPanel;

    private GeneralConfiguration generalConfiguration;

    private ResultsViewer resultsViewer;



    private JLabel titleLabel;


    public TJTLVista(TJTLController controller) {
        titleLabel = new JLabel("ThreadLab 🔬");
        titleLabel.setFont(new Font("Sherif", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        this.controlPanel = new ControlPanel(this);
        this.generalConfiguration = new GeneralConfiguration();
        this.resultsViewer = new ResultsViewer();


        this.configureJFrame();
        this.setVisible(true);
        this.pack();
    }

    private void addComponentsToPane(Container panel){
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 2;
        c.gridheight = 1;

        c.gridx = 0;
        c.gridy = 0;
        panel.add(this.titleLabel, c);

        c.gridy++;
        panel.add(this.controlPanel, c);

        c.gridy++;
        c.gridwidth = 1;
        panel.add(this.generalConfiguration, c);

        c.gridx++;
        panel.add(this.resultsViewer, c);
    }

    private void configureJFrame(){
        this.setLayout(new GridBagLayout());
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addComponentsToPane(this.getContentPane());
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Play/Pause":
                break;
            default:
                System.err.println("Acción NO tratada: " + e);
        }
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
        //System.out.println("Frame hidden");
    }


    @Override
    public void componentMoved(ComponentEvent ce) {
        // System.out.println("Frame moved");
    }


    @Override
    public void componentResized(ComponentEvent ce) {
        // System.out.println("Frame resized");
    }


    @Override
    public void componentShown(ComponentEvent ce) {
        // System.out.println("Frame Shown");
    }


    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        int estado = itemEvent.getStateChange();
        if (estado == ItemEvent.SELECTED) {
        } else {
        }
    }
}
