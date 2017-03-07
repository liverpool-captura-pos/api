package com.liverpool.api.utilitarios;

import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;

/**
 * @autor: Genaro Bermúdez [06/03/2017]
 * @modificado: Genaro Bermúdez [06/03/2017]
 * @descripción: Clase que se encarga de encriptar o desencriptar AES-256bits
 * @see: <a href = "http://es.wikipedia.org/wiki/Advanced_Encryption_Standard" /> AES </a> / <a href = "https://bit502.wordpress.com/2016/06/23/java-encriptar-y-desencriptar-aes-ecb-128192256-bits/">Referencia</a>
 */
public class Aes {

	/**
	 * @autor: Genaro Bermúdez [06/03/2017]
	 * @modificado: Genaro Bermúdez [06/03/2017]
	 * @descripción: Metodo que permite aplicar el Cifrado César a una determinada cadena
	 * @parámetros: cadena: es un valor alfanúmerico el cual se desea encriptar (no debe contener carcteres especiales, ni acentos, ni 'ñ/Ñ'). Se espera que dicho valor venga natural
	 * @retorno: devuelve un string con la conversión de la cadena en Cifrado César
	 */
	public static byte[] encriptar(byte[] key, byte[] input) throws Exception {
		return processing(key, input, true);
	}

	/**
	 * @autor: Genaro Bermúdez [06/03/2017]
	 * @modificado: Genaro Bermúdez [06/03/2017]
	 * @descripción: Metodo que permite aplicar el Cifrado César a una determinada cadena
	 * @parámetros: cadena: es un valor alfanúmerico el cual se desea encriptar (no debe contener carcteres especiales, ni acentos, ni 'ñ/Ñ'). Se espera que dicho valor venga natural
	 * @retorno: devuelve un string con la conversión de la cadena en Cifrado César
	 */
	public static byte[] desencriptar(byte[] key, byte[] input) throws Exception {
		byte res1[] = processing(key, input, false);
		int i = res1.length - 1;
		while (res1[i] == 0x00) {
			i--;
		}
		byte res0[] = new byte[i + 1];
		System.arraycopy(res1, 0, res0, 0, res0.length);
		return res0;
	}

	/**
	 * @autor: Genaro Bermúdez [06/03/2017]
	 * @modificado: Genaro Bermúdez [06/03/2017]
	 * @descripción: Metodo que permite aplicar el Cifrado César a una determinada cadena
	 * @parámetros: cadena: es un valor alfanúmerico el cual se desea encriptar (no debe contener carcteres especiales, ni acentos, ni 'ñ/Ñ'). Se espera que dicho valor venga natural
	 * @retorno: devuelve un string con la conversión de la cadena en Cifrado César
	 */
	private static byte[] processing(byte[] key, byte[] input, boolean encrypt) throws Exception {
		PaddedBufferedBlockCipher pbbc = new PaddedBufferedBlockCipher(new AESEngine(), new PKCS7Padding());
		pbbc.init(encrypt, new KeyParameter(key));
		byte[] output = new byte[pbbc.getOutputSize(input.length)];
		int bytesWrittenOut = pbbc.processBytes(input, 0, input.length, output, 0);
		pbbc.doFinal(output, bytesWrittenOut);
		return output;
	}

}
