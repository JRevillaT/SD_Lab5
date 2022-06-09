package server;
import java.rmi.server.UnicastRemoteObject;
import RMIinterface.RemoteInterface;

public class ServerImplements extends UnicastRemoteObject implements RemoteInterface {
	public String nombre="paracetamol";
	public double precioU = 2.50;
	public int stock=30;
	public ServerImplements() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public String Compra(int cantidad, String name) throws Exception {
		System.out.println(this.nombre.compareTo(name)==0);
		if(this.nombre.compareTo(name)==0) {
			
			return "Se a comprado " + cantidad + " de" + name+" costo total: "+(precioU*cantidad);
		}
		if(cantidad>stock) {
			return "No se dispone de la cantidad solicitada";
		}
		this.stock=stock-cantidad;
		
		return "No existe tal medicamento";
		
	}

	public String Consulta(String name) throws Exception {
		if(name!=nombre) {
			return "Si existe el medicamento "+name;
			
		}
		return "No existe tal medicamento";
	}
}
