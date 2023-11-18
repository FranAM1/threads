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

        this.playPauseButton = new JToggleButton("Play/Pause");
        this.playPauseButton.addActionListener(al);

        this.resetButton = new JButton("Reset");
        this.resetButton.addActionListener(al);

        this.applyButton = new JButton("Apply");
        this.applyButton.addActionListener(al);

        this.protectCriticalRegions = new JCheckBox("Protect Critical Regions");

        this.preventNegativeStocks = new JCheckBox("Prevent Negative Stocks");


    }

    private void addContentToPanel(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(this.playPauseButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(this.resetButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add(this.applyButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        this.add(this.protectCriticalRegions, gbc);

        gbc.gridx = 4;
        gbc.gridy = 0;
        this.add(this.preventNegativeStocks, gbc);
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
