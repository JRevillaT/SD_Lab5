package cliente;

import javax.swing.*;
import RMIinterface.RemoteInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainCliente {
	public static void main(String[] args) {
		try {

			String pedido = JOptionPane.showInputDialog("Ingrese:\n1. Consulta \n2. Compra");
			int p = Integer.parseInt(pedido);

			Registry miRegistro = LocateRegistry.getRegistry("127.0.0.1", 1234);
			RemoteInterface s = (RemoteInterface) miRegistro.lookup("Medicamentos");
			if (p == 1) {
				JOptionPane.showMessageDialog(null, "Usted Realiso una consulta:");
				String medicamento=JOptionPane.showInputDialog("Ingrese el nombre del medicamento");
				JOptionPane.showMessageDialog(null, s.Consulta(medicamento));
			}else {
				JOptionPane.showMessageDialog(null, "Usted desea realizar una compra:");
				String medicamento=JOptionPane.showInputDialog("Ingrese el nombre del medicamento");
				String cant=JOptionPane.showInputDialog("Ingrese la cantidad");
				int c=Integer.parseInt(cant);
				JOptionPane.showMessageDialog(null, s.Compra(c, medicamento));
			}
			

		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}

	}
}
