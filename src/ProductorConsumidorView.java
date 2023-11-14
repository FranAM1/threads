import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ProductorConsumidorView extends JFrame implements ComponentListener, ActionListener, ItemListener, Runnable {
    private JButton startButton;

    private JLabel titleLabel;

    private JTextField textField;

    private JTextField consumidoresIniciados;

    private JTextField consumidoresAcabados;

    private JTextField productoresIniciados;

    private JTextField productoresAcabados;

    private JTextField horaInicio;

    private JTextField horaFin;

    private JTextField numeroProductores;

    private JTextField numeroConsumidores;

    private JSlider sliderProductorAleatorio;

    private JCheckBox checkBoxProductorAleatorio;

    private JTextField productorTiempoFijo;

    private JTextField consumidorTiempoFijo;

    private JSlider sliderConsumidorAleatorio;

    private JCheckBox checkBoxConsumidorAleatorio;

    private ProductorConsumidorController controller;

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    public ProductorConsumidorView(ProductorConsumidorController controller) {
        this.controller = controller;

        this.titleLabel = new JLabel("ThreadLab");
        this.titleLabel.setFont(new Font("Arial", Font.BOLD, 24));



        this.startButton = new JButton("Play");
        this.startButton.addActionListener(this);

        this.textField = new JTextField("0");
        this.textField.setBackground(Color.RED);
        this.textField.setForeground(Color.WHITE);
        this.textField.setFont(new Font("Arial", Font.BOLD, 30));
        this.textField.setHorizontalAlignment(JTextField.CENTER);

        this.consumidoresIniciados = new JTextField("0");
        this.consumidoresAcabados = new JTextField("0");
        this.productoresIniciados = new JTextField("0");
        this.productoresAcabados = new JTextField("0");
        this.horaInicio = new JTextField("0");
        this.horaFin = new JTextField("0");

        this.numeroProductores = new JTextField("200");
        this.numeroConsumidores = new JTextField("400");

        this.sliderProductorAleatorio = new JSlider(JSlider.HORIZONTAL, 0, 1000, 100);
        this.sliderProductorAleatorio.setMajorTickSpacing(250);
        this.sliderProductorAleatorio.setMinorTickSpacing(100);
        this.sliderProductorAleatorio.setPaintTicks(true);
        this.sliderProductorAleatorio.setPaintLabels(true);

        this.checkBoxProductorAleatorio = new JCheckBox();
        this.checkBoxProductorAleatorio.setSelected(true);
        this.productorTiempoFijo = new JTextField("100");
        this.productorTiempoFijo.setColumns(10);

        this.sliderConsumidorAleatorio = new JSlider(JSlider.HORIZONTAL, 0, 1000, 100);
        this.sliderConsumidorAleatorio.setMajorTickSpacing(250);
        this.sliderConsumidorAleatorio.setMinorTickSpacing(100);
        this.sliderConsumidorAleatorio.setPaintTicks(true);
        this.sliderConsumidorAleatorio.setPaintLabels(true);

        this.checkBoxConsumidorAleatorio = new JCheckBox();
        this.checkBoxConsumidorAleatorio.setSelected(true);
        this.consumidorTiempoFijo = new JTextField("100");
        this.consumidorTiempoFijo.setSize(100, 100);


        this.configureJFrame();

        this.setVisible(true);
    }

    private void addComponentsToPane(Container panel){
        GridBagConstraints c = new GridBagConstraints();

        JLabel labelCI = new JLabel("Consumidores iniciados: ");

        JLabel labelCA = new JLabel("Consumidores acabados: ");

        JLabel labelPI = new JLabel("Productores iniciados: ");

        JLabel labelPA = new JLabel("Productores acabados");

        JLabel horaInicio = new JLabel("Inicio: ");

        JLabel horaFinal = new JLabel("Fin: ");

        JLabel consumidorAleatorioLabel = new JLabel("Tiempo producir aleatorio: ");

        JLabel productorAleatorioLabel = new JLabel("Tiempo consumir aleatorio: ");

        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 1;
        c.weighty = 1;

        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 5;
        panel.add(this.titleLabel, c);
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        panel.add(this.startButton, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 5;
        panel.add(this.textField, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(labelCI, c);
        c.gridx = 1;
        panel.add(this.consumidoresIniciados, c);

        c.gridx = 0;
        c.gridy = 4;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(labelCA, c);
        c.gridx = 1;
        panel.add(this.consumidoresAcabados, c);

        c.gridx = 0;
        c.gridy = 5;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(labelPI, c);
        c.gridx = 1;
        panel.add(this.productoresIniciados, c);

        c.gridx = 0;
        c.gridy = 6;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(labelPA, c);
        c.gridx = 1;
        panel.add(this.productoresAcabados, c);

        c.gridx = 0;
        c.gridy = 7;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(horaInicio, c);
        c.gridx = 1;
        panel.add(this.horaInicio, c);

        c.gridx = 0;
        c.gridy = 8;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(horaFinal, c);
        c.gridx = 1;
        panel.add(this.horaFin, c);

        c.gridx = 3;
        c.gridy = 3;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(new JLabel("Numero de productores: "), c);
        c.gridx = 4;
        panel.add(this.numeroProductores, c);

        c.gridx = 3;
        c.gridy = 4;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(new JLabel("Numero de consumidores: "), c);
        c.gridx = 4;
        panel.add(this.numeroConsumidores, c);


        c.gridx = 3;
        c.gridy = 5;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(consumidorAleatorioLabel, c);
        c.gridx = 4;
        panel.add(this.checkBoxProductorAleatorio, c);
        c.gridy = 6;
        c.gridx = 3;
        panel.add(this.sliderProductorAleatorio, c);
        c.gridy = 7;
        panel.add(this.consumidorTiempoFijo, c);
        c.gridx = 4;
        panel.add(new JLabel("ms"), c);

        c.gridx = 3;
        c.gridy = 8;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(productorAleatorioLabel, c);
        c.gridx = 4;
        panel.add(this.checkBoxConsumidorAleatorio, c);
        c.gridx = 3;
        c.gridy = 9;
        panel.add(this.sliderConsumidorAleatorio, c);
        c.gridy = 10;
        panel.add(this.productorTiempoFijo, c);
        c.gridx = 4;
        panel.add(new JLabel("ms"), c);
    }

    private void configureJFrame(){
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 700);
        this.addComponentsToPane(this.getContentPane());
    }

    public void run() {
        while(true){
            try{
                Thread.sleep(100);
                this.getTextField().setText(String.valueOf(controller.getContador().getValor()));
                this.consumidoresIniciados.setText(String.valueOf(controller.getContadorCI().getValor()));
                this.consumidoresAcabados.setText(String.valueOf(controller.getContadorCA().getValor()));
                this.productoresIniciados.setText(String.valueOf(controller.getContadorPI().getValor()));
                this.productoresAcabados.setText(String.valueOf(controller.getContadorPA().getValor()));
                this.horaInicio.setText(controller.getPrimero().format(formatter));
                this.horaFin.setText(controller.getUltimo().format(formatter));
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Play":
                this.getTextField().setText("0");
                this.consumidoresIniciados.setText("0");
                this.consumidoresAcabados.setText("0");
                this.productoresIniciados.setText("0");
                this.productoresAcabados.setText("0");
                this.horaInicio.setText("0");
                this.horaFin.setText("0");
                controller.play();
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

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public ProductorConsumidorController getController() {
        return controller;
    }

    public void setController(ProductorConsumidorController controller) {
        this.controller = controller;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JTextField getConsumidoresIniciados() {
        return consumidoresIniciados;
    }

    public void setConsumidoresIniciados(JTextField consumidoresIniciados) {
        this.consumidoresIniciados = consumidoresIniciados;
    }

    public JTextField getConsumidoresAcabados() {
        return consumidoresAcabados;
    }

    public void setConsumidoresAcabados(JTextField consumidoresAcabados) {
        this.consumidoresAcabados = consumidoresAcabados;
    }

    public JTextField getProductoresIniciados() {
        return productoresIniciados;
    }

    public void setProductoresIniciados(JTextField productoresIniciados) {
        this.productoresIniciados = productoresIniciados;
    }

    public JTextField getProductoresAcabados() {
        return productoresAcabados;
    }

    public void setProductoresAcabados(JTextField productoresAcabados) {
        this.productoresAcabados = productoresAcabados;
    }

    public JTextField getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(JTextField horaInicio) {
        this.horaInicio = horaInicio;
    }

    public JTextField getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(JTextField horaFin) {
        this.horaFin = horaFin;
    }

    public JTextField getNumeroProductores() {
        return numeroProductores;
    }

    public void setNumeroProductores(JTextField numeroProductores) {
        this.numeroProductores = numeroProductores;
    }

    public JTextField getNumeroConsumidores() {
        return numeroConsumidores;
    }

    public void setNumeroConsumidores(JTextField numeroConsumidores) {
        this.numeroConsumidores = numeroConsumidores;
    }

    public JSlider getSliderProductorAleatorio() {
        return sliderProductorAleatorio;
    }

    public void setSliderProductorAleatorio(JSlider sliderProductorAleatorio) {
        this.sliderProductorAleatorio = sliderProductorAleatorio;
    }

    public JCheckBox getCheckBoxProductorAleatorio() {
        return checkBoxProductorAleatorio;
    }

    public void setCheckBoxProductorAleatorio(JCheckBox checkBoxProductorAleatorio) {
        this.checkBoxProductorAleatorio = checkBoxProductorAleatorio;
    }

    public JTextField getProductorTiempoFijo() {
        return productorTiempoFijo;
    }

    public void setProductorTiempoFijo(JTextField productorTiempoFijo) {
        this.productorTiempoFijo = productorTiempoFijo;
    }

    public JTextField getConsumidorTiempoFijo() {
        return consumidorTiempoFijo;
    }

    public void setConsumidorTiempoFijo(JTextField consumidorTiempoFijo) {
        this.consumidorTiempoFijo = consumidorTiempoFijo;
    }

    public JSlider getSliderConsumidorAleatorio() {
        return sliderConsumidorAleatorio;
    }

    public void setSliderConsumidorAleatorio(JSlider sliderConsumidorAleatorio) {
        this.sliderConsumidorAleatorio = sliderConsumidorAleatorio;
    }

    public JCheckBox getCheckBoxConsumidorAleatorio() {
        return checkBoxConsumidorAleatorio;
    }

    public void setCheckBoxConsumidorAleatorio(JCheckBox checkBoxConsumidorAleatorio) {
        this.checkBoxConsumidorAleatorio = checkBoxConsumidorAleatorio;
    }

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }

    public static void setFormatter(DateTimeFormatter formatter) {
        ProductorConsumidorView.formatter = formatter;
    }
}
