package view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import pojo.Atribute;
import pojo.Atributes;

/**
 * @author Glaucio
 */
public class FormGenerateArff extends javax.swing.JDialog {

  private String texto;
  private static final Atributes ATRIBUTES = new Atributes();
  private int records;
  private static final String[] TIPOS_WEKA = new String[]{"string", "numeric", "nominal", "date"};

  /**
   * Creates new form FormImportCandidatos
   */
  public FormGenerateArff(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    lbSeparador = new javax.swing.JLabel();
    jcSeparador = new javax.swing.JComboBox();
    jScrollPane1 = new javax.swing.JScrollPane();
    tbAtributos = new javax.swing.JTable();
    btArff = new javax.swing.JButton();
    lbRelacao = new javax.swing.JLabel();
    tfRelacao = new javax.swing.JTextField();
    jScrollPane2 = new javax.swing.JScrollPane();
    tbValores = new javax.swing.JTable();
    btCSV = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("view/Bundle", FrmMain.local); // NOI18N
    lbSeparador.setText(bundle.getString("FormGenerateArff.lbSeparador.text")); // NOI18N

    jcSeparador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "|", ";", "," }));
    jcSeparador.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        jcSeparadorItemStateChanged(evt);
      }
    });

    tbAtributos.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Campo", "Tipo", "Valores"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.Object.class
      };
      boolean[] canEdit = new boolean [] {
        true, true, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tbAtributos);

    btArff.setText(bundle.getString("FormGenerateArff.btArff.text")); // NOI18N
    btArff.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btArffActionPerformed(evt);
      }
    });

    lbRelacao.setText(bundle.getString("FormGenerateArff.lbRelacao.text")); // NOI18N

    tbValores.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Seq.", "Valores"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane2.setViewportView(tbValores);

    btCSV.setText(bundle.getString("FormGenerateArff.btCSV.text")); // NOI18N
    btCSV.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btCSVActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addGroup(layout.createSequentialGroup()
                .addComponent(lbSeparador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcSeparador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbRelacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRelacao, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(btCSV)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btArff)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lbSeparador)
          .addComponent(jcSeparador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lbRelacao)
          .addComponent(tfRelacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btArff)
          .addComponent(btCSV))
        .addContainerGap())
    );

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  public void setTexto(String texto) {
    this.texto = texto;
  }

  private static int contAtributes(String xq, String separador) {
    int ret = 0;

    for (int x = 0; x < xq.length(); x++) {
      if (xq.charAt(x) == separador.charAt(0)) {
        ret++;
      }
    }

    if (xq.charAt(0) != separador.charAt(0)) {
      ret++;
    }

    return ret;
  }

  /*
  * Clean XQuery with regex to get attributes
   */
  private String[] getAtributesFromXq(String xq, String separador) throws Exception {
    int inicio = xq.lastIndexOf("return ");
    xq = xq.substring(inicio + "return ".length(), xq.length());
    xq = xq.replaceAll("[<][/][a-zA-Z0-9]{1,}[>]", "");
    xq = xq.replaceAll("[<][a-zA-Z0-9]{1,}[>]", "");
    xq = xq.replaceAll("[{]", "");
    xq = xq.replaceAll("[}]", "");
    xq = xq.replaceAll("[t][e][x][t][(]", "");
    xq = xq.replaceAll("[d][a][t][a][(]", "");
    xq = xq.replaceAll("[(]", "");
    xq = xq.replaceAll("[)]", "");
    xq = xq.replaceAll("[@]", "");
    xq = xq.replaceAll("[$]", "");
    xq = xq.replaceAll("[\\[]*[\\]]", "");//TODO: não funcionou
    xq = xq.replace("\n", "");

    int contAtributes = contAtributes(xq, separador);
    String[] ret = xq.split("\\|", contAtributes);
    for (int i = 0; i < ret.length; i++) {
      String[] tmp = ret[i].split("[/]");
      ret[i] = tmp[tmp.length - 1];
    }

    if (ret.length != contAtributes) {
      throw new Exception("Quantidade de Atributos difere dos Dados!");
    }

    return ret;
  }

  public void automatization(String xq) throws Exception {
    ATRIBUTES.clean();
    records = 0;
    String separador = (String) jcSeparador.getSelectedItem();
    String[] campos = getAtributesFromXq(xq, separador);
    this.texto = texto.replaceAll("[<][/][a-zA-Z0-9]{1,}[>]", "");
    this.texto = texto.replaceAll("[<][a-zA-Z0-9]{1,}[>]", "");
    this.texto = texto.replaceAll("[\n][\n]", "\n");
    this.texto = texto.replaceAll("[\r][\n]", "\n");
    String[] linha = this.texto.split("\n");
    records = linha.length;

    String[] col = linha[0].split("[\\" + separador + "]", campos.length);
    if (campos.length != col.length) {
      throw new Exception("Quantidade de Atributos difere dos Dados!");
    }

    tbAtributos.setModel(new DefaultTableModel(
            new Object[col.length][3],
            new String[]{"Campo", "Tipo", "Valores"}) {
      Class[] types = new Class[]{java.lang.String.class, java.lang.String.class, java.lang.Object.class};
      boolean[] canEdit = new boolean[]{true, true, false};

      @Override
      public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
      }

      @Override
      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
      }
    });

    TableModel t = tbAtributos.getModel();

    //Gerar Nomes para os campos
    for (int x = 0; x < col.length; x++) {
      String campo = campos[x];
      if ((campo == null) || (campo.trim().length() == 0)) {
        t.setValueAt("Campo_" + x, x, 0);
      } else {
        t.setValueAt(campo, x, 0);
      }

      //Combo para tipos de dados
      TableColumn colu = tbAtributos.getColumnModel().getColumn(1);
      colu.setCellEditor(new MyComboBoxEditor(TIPOS_WEKA));
      colu.setCellRenderer(new MyComboBoxRenderer(TIPOS_WEKA));
    }

    for (String linha1 : linha) {
      col = linha1.split("[\\" + separador + "]", campos.length);
      for (int y = 0; y < col.length; y++) {
        String value = col[y];
        if (value.trim().equals("")) {
          value = "?";
        }
        ATRIBUTES.addAtribute(y, value);
      }
    }

    Iterator<Atribute> val = ATRIBUTES.getAtributes().values().iterator();
    int i = 0;
    while (val.hasNext()) {
      Atribute a = val.next();
      t.setValueAt(a, i, 2);
      //Find type of atribute
      t.setValueAt(a.getTypeFromDistinctsValues(10), i, 1);
      i++;
    }

    ListSelectionModel cellSelectionModel = tbAtributos.getSelectionModel();
    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent e) {
        int[] selectedRow = tbAtributos.getSelectedRows();

        if (selectedRow.length != 1) {
          return;
        }
        Atribute atributo = (Atribute) tbAtributos.getModel().getValueAt(selectedRow[0], 2);
        defineTabelaValores(atributo);
      }
    });
  }

  private void defineTabelaValores(Atribute atributo) {
    if (atributo == null) {
      return;
    }
    tbValores.setModel(new DefaultTableModel(
            new Object[atributo.getValues().size()][1],
            new String[]{"Seq.", "Valores"}) {
      Class[] types = new Class[]{
        java.lang.Integer.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean[]{false, false};

      @Override
      public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
      }

      @Override
      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
      }
    });

    for (int i = 0; i < atributo.getValues().size(); i++) {
      String c = atributo.getValues().get(i);
      tbValores.getModel().setValueAt(i + 1, i, 0); //Sequencial
      tbValores.getModel().setValueAt(c, i, 1); //Valor
    }
  }

  private String getDirectory() {
    JFileChooser abrir = new JFileChooser();
    abrir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    //abrir.setCurrentDirectory(new File("F:/Cartões Resposta/"));
    abrir.setMultiSelectionEnabled(false);
    if (abrir.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
      return null;
    }

    return abrir.getSelectedFile().getPath();
  }

  private void btArffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btArffActionPerformed
    FileWriter fw = null;
    try {
      try {
        fw = new FileWriter(new File(getDirectory() + "/" + tfRelacao.getText() + ".arff"));

        Long inicio = System.currentTimeMillis();
        //Header
        fw.append("%Generated with xq2arff - Xquery tool to generate arff files(Weka) from XQuery in XML Files\n\n");
        fw.append("@RELATION " + tfRelacao.getText() + "\n\n");

        //atributos
        TableModel t = tbAtributos.getModel();
        for (int i = 0; i < t.getRowCount(); i++) {
          String tipo = (String) t.getValueAt(i, 1);
          if (tipo.equals("nominal")) {
            tipo = "{" + ATRIBUTES.getDistinctsValuesFromAtribute(i, true) + "}";
          }
          fw.append("@attribute " + t.getValueAt(i, 0) + " " + tipo + "\n");
        }
        fw.append("\n");

        //Dados
        fw.append("@DATA\n");
        String reg;
        String tipo;
        String aspas;
        String linha;
        for (int i = 0; i < records; i++) {
          reg = "";
          Iterator<Integer> itk = ATRIBUTES.getAtributes().keySet().iterator();

          while (itk.hasNext()) {
            int k = itk.next();
            tipo = (String) t.getValueAt(k, 1);
            linha = ATRIBUTES.getValuesFromAtribute(k).get(i);
            aspas = (tipo.equals("string") && (!linha.equals("?"))) ? "\"" : "";

            if (tipo.equals("nominal")) {
              linha = linha.replaceAll("[ ]", "_");
            }
            reg += (aspas + linha + aspas + ",");
          }
          reg = reg.replaceAll("[,]$", "");//Remove virgula no fim
          fw.append(reg + "\n");
        }

        Long fim = System.currentTimeMillis();
        System.out.println("Tempo de Geração Arquivo ARFF: " + ((fim - inicio) / 1000.0) + " seg.");
      } finally {
        if (fw != null) {
          fw.flush();
          fw.close();
        }
      }
    } catch (IOException ex) {
      Logger.getLogger(FormGenerateArff.class.getName()).log(Level.SEVERE, null, ex);
    }
    //decimal -> .
    //remover @ % ,
    //Separador -> ,
    //String entre aspas simples
    //campos vazios -> ?
  }//GEN-LAST:event_btArffActionPerformed

  private void btCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCSVActionPerformed
    FileWriter fw = null;
    try {
      try {
        fw = new FileWriter(new File(getDirectory() + "/" + tfRelacao.getText() + ".csv"));

        Long inicio = System.currentTimeMillis();
        //atributos
        TableModel t = tbAtributos.getModel();
        String reg = "";
        for (int i = 0; i < t.getRowCount(); i++) {
          reg += (t.getValueAt(i, 0) + ",");
        }
        reg = reg.replaceAll("[,]$", "");//Remove virgula no fim
        fw.append(reg);
        fw.append("\n");

        //Dados
        String tipo;
        String aspas;
        for (int i = 0; i < records; i++) {
          reg = "";
          Iterator<Integer> itk = ATRIBUTES.getAtributes().keySet().iterator();

          while (itk.hasNext()) {
            int k = itk.next();
            tipo = (String) t.getValueAt(k, 1);
            aspas = (tipo.equals("string")) ? "\"" : "";

            reg += (aspas + ATRIBUTES.getValuesFromAtribute(k).get(i) + aspas + ",");
          }
          reg = reg.replaceAll("[,]$", "");//Remove virgula no fim
          fw.append(reg + "\n");
        }

        Long fim = System.currentTimeMillis();
        System.out.println("Tempo de Geração Arquivo CSV: " + ((fim - inicio) / 1000.0) + " seg.");
      } finally {
        if (fw != null) {
          fw.flush();
          fw.close();
        }
      }
    } catch (IOException ex) {
      Logger.getLogger(FormGenerateArff.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_btCSVActionPerformed

  private void jcSeparadorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcSeparadorItemStateChanged
    System.err.println(jcSeparador.getSelectedItem());
  }//GEN-LAST:event_jcSeparadorItemStateChanged


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btArff;
  private javax.swing.JButton btCSV;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JComboBox jcSeparador;
  private javax.swing.JLabel lbRelacao;
  private javax.swing.JLabel lbSeparador;
  private javax.swing.JTable tbAtributos;
  private javax.swing.JTable tbValores;
  private javax.swing.JTextField tfRelacao;
  // End of variables declaration//GEN-END:variables
}
