import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TJTLVista extends JFrame implements ComponentListener, ActionListener, ItemListener{

    private ControlPanel controlPanel;

    private GeneralConfiguration generalConfiguration;

    private ResultsViewer resultsViewer;

    private TJTLController controller;

    private JLabel titleLabel;


    public TJTLVista(TJTLController controller) {
        this.controller = controller;
        titleLabel = new JLabel("ThreadLab 🔬");
        //because of the font
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
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
                if (this.controlPanel.getPlayPauseButton().isSelected()){
                    this.controller.play();
                } else {
                    this.controller.pause();
                }
                break;
            case "Reset":
                this.controller.resetConfig();
                this.generalConfiguration.updatePanelInfo();
                this.resultsViewer.updateTableInfo();
                this.controlPanel.updatePanel();
                break;
            case "Apply":
                this.generalConfiguration.updateDTO();
                this.controlPanel.updateDTO();

                this.showApplyMessage();
                break;
            default:
                System.err.println("Acción NO tratada: " + e);
        }
    }

    private void showApplyMessage() {
        JOptionPane.showMessageDialog(this, "Se han aplicado los cambios", "Cambios aplicados", JOptionPane.INFORMATION_MESSAGE);
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

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public GeneralConfiguration getGeneralConfiguration() {
        return generalConfiguration;
    }

    public void setGeneralConfiguration(GeneralConfiguration generalConfiguration) {
        this.generalConfiguration = generalConfiguration;
    }

    public ResultsViewer getResultsViewer() {
        return resultsViewer;
    }

    public void setResultsViewer(ResultsViewer resultsViewer) {
        this.resultsViewer = resultsViewer;
    }

    public TJTLController getController() {
        return controller;
    }

    public void setController(TJTLController controller) {
        this.controller = controller;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }
}
