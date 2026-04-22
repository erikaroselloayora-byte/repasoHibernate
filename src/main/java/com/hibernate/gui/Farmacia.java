package com.hibernate.gui;

//en la cosa esa de errores (ENE|FEB|MAR...)2[7-9]
//BOOLEAN -> tinyInt
//checkBox.selected

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import com.hibernate.dao.*;
import com.hibernate.model.*;

public class Farmacia {

	private JFrame frame;
	private JTable table;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtCaducidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Farmacia window = new Farmacia();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Farmacia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		MedicamentoDAO medicamentoDAO=new MedicamentoDAO();
		Medicamento producto=null;

		
		List<Medicamento> ls=MedicamentoDAO.selectAllMed();

		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("nombre");
		model.addColumn("formato");
		model.addColumn("caducidad");
		model.addColumn("existencias");


		
		for (Medicamento med:ls) {
			 Object[] row = new Object[5];
			 row[0] = med.getId();
			 row[1] = med.getNombre();
			 row[2] = med.getFormato();
			 row[3] = med.getCaducidad();
			 row[4] = med.getExistencias();
			 model.addRow(row);
		}
		
		
		
		frame = new JFrame();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(89, 225, 114, 26);
		frame.getContentPane().add(comboBox);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=table.getSelectedRow();
				TableModel model=table.getModel();
				
				txtId.setText(model.getValueAt(index, 0).toString());
				txtNombre.setText(model.getValueAt(index, 1).toString());
				//comboBox.set
				//txtUnidades.setText(model.getValueAt(index, 3).toString());
			}	
		});	
		
		frame.setBounds(100, 100, 699, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(29, 12, 576, 131);
		frame.getContentPane().add(table);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(29, 155, 60, 17);
		frame.getContentPane().add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(54, 155, 114, 21);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(29, 188, 60, 17);
		frame.getContentPane().add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(89, 186, 114, 21);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblFormato = new JLabel("Formato:");
		lblFormato.setBounds(29, 225, 60, 17);
		frame.getContentPane().add(lblFormato);
		
		
		
		JLabel lblCaducidad = new JLabel("Caducidad:");
		lblCaducidad.setBounds(29, 263, 76, 17);
		frame.getContentPane().add(lblCaducidad);
		
		txtCaducidad = new JTextField();
		txtCaducidad.setBounds(109, 261, 114, 21);
		frame.getContentPane().add(txtCaducidad);
		txtCaducidad.setColumns(10);
		
		JCheckBox checkExistencias = new JCheckBox("Existencias");
		checkExistencias.setBounds(54, 298, 114, 25);
		frame.getContentPane().add(checkExistencias);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(225, 155, 105, 27);
		frame.getContentPane().add(btnMostrar);
		
		JButton btnAadir = new JButton("Añadir");
		btnAadir.setBounds(342, 155, 105, 27);
		frame.getContentPane().add(btnAadir);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(459, 155, 105, 27);
		frame.getContentPane().add(btnBorrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(576, 155, 105, 27);
		frame.getContentPane().add(btnActualizar);
	}
}
