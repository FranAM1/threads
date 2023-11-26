import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class GeneralConfiguration extends JPanel {
    private JTextField numProductores;

    private JTextField numItemsProductores;

    private JSlider tiempoProduccionAleatorio;

    private JTextField tiempoProduccionFijo;

    private JCheckBox produccionAleatoria;



    private JTextField numConsumidores;

    private JTextField numItemsConsumidores;

    private JSlider tiempoConsumoAleatorio;

    private JTextField tiempoConsumoFijo;

    private JCheckBox consumoAleatorio;

    public GeneralConfiguration(){
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(400, 500));
        this.setMinimumSize(new Dimension(400, 500));

        this.setBackground(Color.darkGray);


        //PRODUCTORES
        this.numProductores = new JTextField(LabParameters.NUM_PRODUCTORES+"");

        this.numItemsProductores = new JTextField(LabParameters.NUM_ITEMS_PRODUCTORES+"");

        this.tiempoProduccionAleatorio = new JSlider(0, 1000, LabParameters.VALOR_TIEMPO_ALEATORIO_PRODUCTORES);
        this.tiempoProduccionAleatorio.setPaintTicks(true);
        this.tiempoProduccionAleatorio.setPaintLabels(true);
        this.tiempoProduccionAleatorio.setMajorTickSpacing(250);
        this.tiempoProduccionAleatorio.setMinorTickSpacing(100);

        this.tiempoProduccionFijo = new JTextField(LabParameters.VALOR_FIJO_TIEMPO_PRODUCTORES+"");

        this.produccionAleatoria = new JCheckBox("Hacer tiempo de produccion aleatorio");
        this.produccionAleatoria.setSelected(LabParameters.TIEMPO_ALEATORIO_PRODUCTORES);


        // CONSUMIDORES
        this.numConsumidores = new JTextField(LabParameters.NUM_CONSUMIDORES+"");

        this.numItemsConsumidores = new JTextField(LabParameters.NUM_ITEMS_CONSUMIDORES+"");

        this.tiempoConsumoAleatorio = new JSlider(0, 1000, LabParameters.VALOR_TIEMPO_ALEATORIO_CONSUMIDORES);
        this.tiempoConsumoAleatorio.setPaintTicks(true);
        this.tiempoConsumoAleatorio.setPaintLabels(true);
        this.tiempoConsumoAleatorio.setMajorTickSpacing(250);
        this.tiempoConsumoAleatorio.setMinorTickSpacing(100);

        this.tiempoConsumoFijo = new JTextField(LabParameters.VALOR_FIJO_TIEMPO_CONSUMIDORES+"");

        this.consumoAleatorio = new JCheckBox("Hacer tiempo de consumo aleatorio");
        this.consumoAleatorio.setSelected(LabParameters.TIEMPO_ALEATORIO_CONSUMIDORES);

        this.addContentToPane();
    }

    public void updatePanelInfo(){
        this.numProductores.setText(LabParameters.NUM_PRODUCTORES+"");
        this.numItemsProductores.setText(LabParameters.NUM_ITEMS_PRODUCTORES+"");
        this.tiempoProduccionAleatorio.setValue(LabParameters.VALOR_TIEMPO_ALEATORIO_PRODUCTORES);
        this.tiempoProduccionFijo.setText(LabParameters.VALOR_FIJO_TIEMPO_PRODUCTORES+"");
        this.produccionAleatoria.setSelected(LabParameters.TIEMPO_ALEATORIO_PRODUCTORES);

        this.numConsumidores.setText(LabParameters.NUM_CONSUMIDORES+"");
        this.numItemsConsumidores.setText(LabParameters.NUM_ITEMS_CONSUMIDORES+"");
        this.tiempoConsumoAleatorio.setValue(LabParameters.VALOR_TIEMPO_ALEATORIO_CONSUMIDORES);
        this.tiempoConsumoFijo.setText(LabParameters.VALOR_FIJO_TIEMPO_CONSUMIDORES+"");
        this.consumoAleatorio.setSelected(LabParameters.TIEMPO_ALEATORIO_CONSUMIDORES);
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
        this.add(addProductorPanel(), c);

        c.gridy++;
        this.add(addConsumidorPanel(), c);
    }

    private JPanel addConsumidorPanel(){
        JPanel consumidorPanel = new JPanel();
        consumidorPanel.setLayout(new GridBagLayout());
        consumidorPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        GridBagConstraints c = new GridBagConstraints();
        JLabel title = new JLabel("Consumidores");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setHorizontalAlignment(JLabel.CENTER);

        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 2;
        c.gridheight = 1;

        c.gridx = 0;
        c.gridy = 0;
        consumidorPanel.add(title, c);

        c.gridwidth = 1;
        c.gridy++;
        consumidorPanel.add(new JLabel("Numero consumidores: "), c);
        c.gridx++;
        consumidorPanel.add(this.numConsumidores, c);

        c.gridx = 0;
        c.gridy++;
        consumidorPanel.add(new JLabel("Numero items consumidores: "), c);
        c.gridx++;
        consumidorPanel.add(this.numItemsConsumidores, c);

        c.gridx = 0;
        c.gridy++;
        consumidorPanel.add(new JLabel("Tiempo consumo aleatorio: "), c);
        c.gridy++;
        consumidorPanel.add(this.tiempoConsumoAleatorio, c);

        c.gridy++;
        consumidorPanel.add(new JLabel("Tiempo consumo fijo: "), c);
        c.gridx++;
        consumidorPanel.add(this.tiempoConsumoFijo, c);

        c.gridx = 0;
        c.gridy++;
        consumidorPanel.add(this.consumoAleatorio, c);

        return consumidorPanel;
    }

    private JPanel addProductorPanel(){
        JPanel productorPanel = new JPanel();
        productorPanel.setLayout(new GridBagLayout());
        productorPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        GridBagConstraints c = new GridBagConstraints();
        JLabel title = new JLabel("Productores");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setHorizontalAlignment(JLabel.CENTER);

        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 2;
        c.gridheight = 1;

        c.gridx = 0;
        c.gridy = 0;
        productorPanel.add(title, c);

        c.gridwidth = 1;
        c.gridy++;
        productorPanel.add(new JLabel("Numero productores: "), c);
        c.gridx++;
        productorPanel.add(this.numProductores, c);

        c.gridx = 0;
        c.gridy++;
        productorPanel.add(new JLabel("Numero items productores: "), c);
        c.gridx++;
        productorPanel.add(this.numItemsProductores, c);

        c.gridx = 0;
        c.gridy++;
        productorPanel.add(new JLabel("Tiempo produccion aleatorio: "), c);
        c.gridy++;
        productorPanel.add(this.tiempoProduccionAleatorio, c);

        c.gridy++;
        productorPanel.add(new JLabel("Tiempo produccion fijo: "), c);
        c.gridx++;
        productorPanel.add(this.tiempoProduccionFijo, c);

        c.gridx = 0;
        c.gridy++;
        productorPanel.add(this.produccionAleatoria, c);

        return productorPanel;
    }

    public JTextField getNumProductores() {
        return numProductores;
    }

    public void setNumProductores(JTextField numProductores) {
        this.numProductores = numProductores;
    }

    public JTextField getNumItemsProductores() {
        return numItemsProductores;
    }

    public void setNumItemsProductores(JTextField numItemsProductores) {
        this.numItemsProductores = numItemsProductores;
    }

    public JSlider getTiempoProduccionAleatorio() {
        return tiempoProduccionAleatorio;
    }

    public void setTiempoProduccionAleatorio(JSlider tiempoProduccionAleatorio) {
        this.tiempoProduccionAleatorio = tiempoProduccionAleatorio;
    }

    public JTextField getTiempoProduccionFijo() {
        return tiempoProduccionFijo;
    }

    public void setTiempoProduccionFijo(JTextField tiempoProduccionFijo) {
        this.tiempoProduccionFijo = tiempoProduccionFijo;
    }

    public JCheckBox getProduccionAleatoria() {
        return produccionAleatoria;
    }

    public void setProduccionAleatoria(JCheckBox produccionAleatoria) {
        this.produccionAleatoria = produccionAleatoria;
    }

    public JTextField getNumConsumidores() {
        return numConsumidores;
    }

    public void setNumConsumidores(JTextField numConsumidores) {
        this.numConsumidores = numConsumidores;
    }

    public JTextField getNumItemsConsumidores() {
        return numItemsConsumidores;
    }

    public void setNumItemsConsumidores(JTextField numItemsConsumidores) {
        this.numItemsConsumidores = numItemsConsumidores;
    }

    public JSlider getTiempoConsumoAleatorio() {
        return tiempoConsumoAleatorio;
    }

    public void setTiempoConsumoAleatorio(JSlider tiempoConsumoAleatorio) {
        this.tiempoConsumoAleatorio = tiempoConsumoAleatorio;
    }

    public JTextField getTiempoConsumoFijo() {
        return tiempoConsumoFijo;
    }

    public void setTiempoConsumoFijo(JTextField tiempoConsumoFijo) {
        this.tiempoConsumoFijo = tiempoConsumoFijo;
    }

    public JCheckBox getConsumoAleatorio() {
        return consumoAleatorio;
    }

    public void setConsumoAleatorio(JCheckBox consumoAleatorio) {
        this.consumoAleatorio = consumoAleatorio;
    }
}
