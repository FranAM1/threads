import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel{
    private JToggleButton playPauseButton;

    private JButton applyButton;

    private JButton resetButton;

    private JCheckBox protectCriticalRegions;

    private JCheckBox preventNegativeStocks;

    public ControlPanel(ActionListener al){
        this.setLayout(new GridBagLayout());

        this.configureJPanel();

        this.playPauseButton = new JToggleButton("Play/Pause");
        this.playPauseButton.addActionListener(al);

        this.resetButton = new JButton("Reset");
        this.resetButton.addActionListener(al);

        this.applyButton = new JButton("Apply");
        this.applyButton.addActionListener(al);

        this.protectCriticalRegions = new JCheckBox("Protect Critical Regions");
        this.protectCriticalRegions.setSelected(LabParameters.PROTECCION_RC);
        this.protectCriticalRegions.setBackground(Color.darkGray);
        this.protectCriticalRegions.setForeground(Color.WHITE);

        this.preventNegativeStocks = new JCheckBox("Prevent Negative Stocks");
        this.preventNegativeStocks.setSelected(LabParameters.PREVENIR_STOCK_NEGATIVO);
        this.preventNegativeStocks.setBackground(Color.darkGray);
        this.preventNegativeStocks.setForeground(Color.WHITE);

        addContentToPane();
    }

    public void updatePanel(){
        this.protectCriticalRegions.setSelected(LabParameters.PROTECCION_RC);
        this.preventNegativeStocks.setSelected(LabParameters.PREVENIR_STOCK_NEGATIVO);
    }

    public void updateDTO(){
        LabParameters.PROTECCION_RC = this.protectCriticalRegions.isSelected();
        LabParameters.PREVENIR_STOCK_NEGATIVO = this.preventNegativeStocks.isSelected();
    }

    private void addContentToPane(){
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 0;

        this.add(this.playPauseButton, c);

        c.gridx++;
        this.add(this.resetButton, c);

        c.gridx++;
        this.add(this.applyButton, c);

        c.gridx++;
        this.add(this.protectCriticalRegions, c);

        c.gridx++;
        this.add(this.preventNegativeStocks, c);
    }

    private void configureJPanel(){
        this.setBackground(Color.RED);
        this.setBackground(Color.darkGray);
    }


    public JToggleButton getPlayPauseButton() {
        return playPauseButton;
    }

    public void setPlayPauseButton(JToggleButton playPauseButton) {
        this.playPauseButton = playPauseButton;
    }

    public JButton getApplyButton() {
        return applyButton;
    }

    public void setApplyButton(JButton applyButton) {
        this.applyButton = applyButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public void setResetButton(JButton resetButton) {
        this.resetButton = resetButton;
    }

    public JCheckBox getProtectCriticalRegions() {
        return protectCriticalRegions;
    }

    public void setProtectCriticalRegions(JCheckBox protectCriticalRegions) {
        this.protectCriticalRegions = protectCriticalRegions;
    }

    public JCheckBox getPreventNegativeStocks() {
        return preventNegativeStocks;
    }

    public void setPreventNegativeStocks(JCheckBox preventNegativeStocks) {
        this.preventNegativeStocks = preventNegativeStocks;
    }
}
