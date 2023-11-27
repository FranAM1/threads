import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ResultsViewer extends JPanel implements Runnable{
    private JTable tablaMilisegundos;

    private JScrollPane scrollPaneMilisegundos;

    private JTable tablaCantidad;

    private JScrollPane scrollPaneCantidad;

    public ResultsViewer(){
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.darkGray);

        Object[][] dataMilisegundos = {
                {"Crear objectos Thread", 0},
                {"Arrancar los hilos", 0},
                {"Procesar los hilos consumidores", 0},
                {"Procesar los hilos productores", 0},
        };
        String[] columnMilisegundos = {"Acción", "Milisegundos"};

        DefaultTableModel modelMilisegundos = new DefaultTableModel(dataMilisegundos, columnMilisegundos);

        //CONFIGURACION JTABLE MILISEGUNDOS
        this.tablaMilisegundos = new JTable(modelMilisegundos);
        this.centerValue(this.tablaMilisegundos);
        this.configureColumnWidth(this.tablaMilisegundos);
        this.configureHeader(this.tablaMilisegundos);
        this.configurePadding(this.tablaMilisegundos);


        // CONFIGURACION SCROLLPANE MILISEGUNDOS
        this.scrollPaneMilisegundos = new JScrollPane(this.tablaMilisegundos);
        this.scrollPaneMilisegundos.setPreferredSize(new Dimension(400, 123));


        Object[][] dataCantidad = {
                {"Items producidos por los productores", 0},
                {"Items consumidos por los consumidores", 0},
                {"Hilos productores procesando", 0},
                {"Hilos productores finalizados", 0},
                {"Hilos consumidores procesando", 0},
                {"Hilos consumidores finalizados", 0},
        };
        String[] columnCantidad = {"Acción", "Cantidad"};

        DefaultTableModel modelCantidad = new DefaultTableModel(dataCantidad, columnCantidad);

        //CONFIGURACION JTABLE CANTIDAD
        this.tablaCantidad = new JTable(modelCantidad);
        this.centerValue(this.tablaCantidad);
        this.configureColumnWidth(this.tablaCantidad);
        this.configureHeader(this.tablaCantidad);
        this.configurePadding(this.tablaCantidad);



        // CONFIGURACION SCROLLPANE CANTIDAD
        this.scrollPaneCantidad = new JScrollPane(this.tablaCantidad);
        this.scrollPaneCantidad.setPreferredSize(new Dimension(400, 173));


        this.addComponentsToPane();
    }

    public void updateTableInfo(){
        this.tablaMilisegundos.setValueAt(LabResults.MS_CREAR_THREADS, 0, 1);
        this.tablaMilisegundos.setValueAt(LabResults.MS_INICIALIZAR_THREADS, 1, 1);
        this.tablaMilisegundos.setValueAt(LabResults.MS_PROCESAR_THREADS_PRODUCTORES, 2, 1);
        this.tablaMilisegundos.setValueAt(LabResults.MS_PROCESAR_THREADS_CONSUMIDORES, 3, 1);

        this.tablaCantidad.setValueAt(LabResults.CANTIDAD_ITEMS_PRODUCIDOS.getValue(), 0, 1);
        this.tablaCantidad.setValueAt(LabResults.CANTIDAD_ITEMS_CONSUMIDOS.getValue(), 1, 1);
        this.tablaCantidad.setValueAt(LabResults.CANTIDAD_HILOS_PRODUCTORES_INI.getValue(), 2, 1);
        this.tablaCantidad.setValueAt(LabResults.CANTIDAD_HILOS_PRODUCTORES_FIN.getValue(), 3, 1);
        this.tablaCantidad.setValueAt(LabResults.CANTIDAD_HILOS_CONSUMIDORES_INI.getValue(), 4, 1);
        this.tablaCantidad.setValueAt(LabResults.CANTIDAD_HILOS_CONSUMIDORES_FIN.getValue(), 5, 1);
    }

    private void addComponentsToPane(){
        GridBagConstraints c = new GridBagConstraints();

        JLabel title = new JLabel("Tablas de resultados");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(JLabel.CENTER);

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 2;
        c.gridheight = 1;


        c.gridx = 0;
        c.gridy = 0;
        this.add(title, c);

        c.gridy++;
        this.add(this.scrollPaneMilisegundos, c);

        c.gridy++;
        this.add(this.scrollPaneCantidad, c);
    }

    private void configureHeader(JTable table){
        table.getTableHeader().setBackground(Color.darkGray);
        table.getTableHeader().setForeground(Color.white);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
    }

    private void configurePadding(JTable table){
        table.setIntercellSpacing(new Dimension(10,10));
        table.setRowHeight(25);
    }

    public void run() {
        while (true){
            this.updateTableInfo();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void configureColumnWidth(JTable table){
        table.getColumnModel().getColumn(0).setPreferredWidth((int) (table.getPreferredSize().width * 0.9));
        table.getColumnModel().getColumn(1).setPreferredWidth((int) (table.getPreferredSize().width * 0.1));
    }

    private void centerValue(JTable table){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
    }

}
