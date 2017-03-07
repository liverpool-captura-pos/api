package api;

import com.liverpool.api.utilitarios.Aes;

public class Test {

	private static final byte[] KEY_256 = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, };

	public static void main(String[] args) throws Exception {
		testAESECB256("Hola");
	}

	private static void testAESECB256(String valor) throws Exception {
		System.out.println("--------------AES ECB Key 256 ------------------");
		//byte[] normal = { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F };
		byte[] normal = valor.getBytes();
		System.out.println(byteToHex(normal));
		byte[] enc = Aes.encriptar(KEY_256, normal);
		System.out.println(byteToHex(enc));
		byte[] dec = Aes.desencriptar(KEY_256, enc);
		System.out.println(byteToHex(dec));
	}

	public static String byteToHex(byte[] data) {
		StringBuilder localStringBuilder = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			String str;
			if ((str = Integer.toHexString(data[i] & 0xFF).toUpperCase()).length() == 1) {
				localStringBuilder.append(0);
			}
			localStringBuilder.append(str).append(" ");
		}
		return localStringBuilder.substring(0, localStringBuilder.length() - 1);
	}
}
