package prueba2;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Caret;
import java.util.HashMap;
import java.util.Map;


public class panel2 {
	private JFrame frame;
	private JTextField emisor;
	private JTextField emisor1;
	private JTextField receptor;
	private JTextField receptor2;
	private DefaultListModel<String> listModel;

	public static void main(String[] args) {
		panel2 window = new panel2();
		window.frame.setVisible(true);
	}

	public panel2() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		emisor = new JTextField();
		emisor.setBounds(31, 12, 114, 21);
		frame.getContentPane().add(emisor);
		emisor.setColumns(10);

		emisor1 = new JTextField();
		emisor1.setColumns(10);
		emisor1.setBounds(31, 45, 114, 21);
		frame.getContentPane().add(emisor1);

		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.setBounds(31, 90, 105, 27);
		frame.getContentPane().add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setBounds(219, 129, 200, 100);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		receptor = new JTextField();
		receptor.setBounds(0, 0, 200, 21);
		panel.add(receptor);
		receptor.setColumns(10);

		receptor2 = new JTextField();
		receptor2.setColumns(10);
		receptor2.setBounds(0, 31, 200, 21);
		panel.add(receptor2);

		listModel = new DefaultListModel<String>();
		JList<String> list = new JList<String>(listModel);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(31, 129, 105, 100);
		frame.getContentPane().add(scrollPane);
		
		Map<String, String> nombreCompletoMap = new HashMap<>();

		btnNewButton.addActionListener(e -> {
		    String nombre = emisor.getText();
		    String apellido = emisor1.getText();
		    String nombreCompleto = nombre + " " + apellido;
		    listModel.addElement(nombre);
		    nombreCompletoMap.put(nombre, nombreCompleto);
		    emisor.setText("");
		    emisor1.setText("");
		});

		list.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent e) {
		        if (!e.getValueIsAdjusting()) {
		            String nombreSeleccionado = list.getSelectedValue();
		            String nombreCompletoSeleccionado = nombreCompletoMap.get(nombreSeleccionado);
		            String[] partes = nombreCompletoSeleccionado.split(" ");
		            receptor.setText(partes[0]);
		            receptor2.setText(partes[1]);
		        }
		    }
		});
	}
}
