package RMIinterface;

import java.rmi.Remote;

public interface RemoteInterface extends Remote {
	//public String helloTo(String name)throws RemoteException;
	public String Compra(int cantidad, String name)throws Exception;
	public String Consulta(String name)throws Exception;
}
