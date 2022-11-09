package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) throws IOException {
		String host = "localhost";
		int puertoRemoto = 6007;

		Socket cliente = new Socket(host, puertoRemoto);
		
		DataOutputStream msgCliente = new DataOutputStream(cliente.getOutputStream());
		msgCliente.writeUTF("Saludos al servidor desde el cliente");
		
		DataInputStream msgServidor = new DataInputStream(cliente.getInputStream());
		System.out.println(msgServidor.readUTF());
		
		msgCliente.close();
		msgServidor.close();
		
		cliente.close();
	}
}