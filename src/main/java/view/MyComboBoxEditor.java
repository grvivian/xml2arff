package view;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

/**
 *
 * @author glaucio
 */
public class MyComboBoxEditor extends DefaultCellEditor {

  public MyComboBoxEditor(String[] items) {
    super(new JComboBox(items));
  }
}
