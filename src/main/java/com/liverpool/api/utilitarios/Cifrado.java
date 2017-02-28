package com.liverpool.api.utilitarios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @autor: Genaro Bermúdez [22/01/2017]
 * @modificado: Genaro Bermúdez [22/01/2017]
 * @descripción: Clase utilitaria que se encarga de aplicar encriptado y desencriptado basado en el Cifrado Cesar
 * @see: <a href = "https://es.wikipedia.org/wiki/Criptografía" /> Criptografía </a> / <a href = "https://es.wikipedia.org/wiki/Cifrado_César" /> Cifrado César </a>
 */
public class Cifrado {

	/** Preparación de las variables locales de a clase */
	private static String tabla = "135aABbCcDdEeFf-GgHhIiJj024kKLlmMNnoOPpqQR_rsS79TtUuVvwWxX68.yYzZ";
	private static int clave = 2;

	/**
	 * @autor: Genaro Bermúdez [22/01/2017]
	 * @modificado: Genaro Bermúdez [22/01/2017]
	 * @descripción: Metodo que permite aplicar el Cifrado César a una determinada cadena
	 * @parametros: cadena: es un valor alfanúmerico el cual se desea encriptar (no debe contener carcteres especiales, ni acentos, ni 'ñ/Ñ'). Se espera que dicho valor venga natural
	 * @retorno: devuelve un string con la conversión de la cadena en Cifrado César
	 */
	public static String Encriptar(String cadena) {
		if (!ValidarCaracteresEspeciales(cadena)) {
			return "@@ Imposible encriptar la cadena especificada @@";
		}
		String texto = LimpiarCadena(cadena);
		String resultado = "";
		for (int i = 0; i < texto.length(); i++) {
			int posicion = tabla.indexOf(texto.charAt(i));
			if ((posicion + clave) < tabla.length()) {
				resultado = resultado + tabla.charAt(posicion + clave);
			} else {
				resultado = resultado + tabla.charAt((posicion + clave) - tabla.length());
			}
		}
		return resultado;
	}

	/**
	 * @autor: Genaro Bermúdez [22/01/2017]
	 * @modificado: Genaro Bermúdez [22/01/2017]
	 * @descripción: método que permite revertir una cadena previamente con Cifrado César a una cadena natural
	 * @parametros: cadena: es un valor alfanúmerico el cual se desea desencriptar (no debe contener carcteres especiales, ni acentos, ni 'ñ/Ñ'). Se espera que dicho valor venga en Cifrado César
	 * @retorno: devuelve un string con la conversión de la cadena en natural
	 */
	public static String Desencriptar(String cadena) {
		if (!ValidarCaracteresEspeciales(cadena)) {
			return "@@ Imposible desencriptar la cadena especificada @@";
		}
		String texto = LimpiarCadena(cadena);
		String resultado = "";
		for (int i = 0; i < texto.length(); i++) {
			int posicion = tabla.indexOf(texto.charAt(i));
			if ((posicion - clave) < 0) {
				resultado = resultado + tabla.charAt((posicion - clave) + tabla.length());
			} else {
				resultado = resultado + tabla.charAt(posicion - clave);
			}
		}
		return resultado;
	}

	/**
	 * @autor: Genaro Bermúdez [22/01/2017]
	 * @modificado: Genaro Bermúdez [22/01/2017]
	 * @descripción: método que permite limpiar algunos valores no permitidos
	 * @parametros: ver parámetros de los métodos Encriptar o Desemcriptar
	 * @retorno: devuelve un string con la cadena limpia y lista para el procesamiento
	 */
	private static String LimpiarCadena(String cadena) {
		cadena = cadena.replaceAll("\n", "");
		for (int i = 0; i < cadena.length(); i++) {
			int posicion = tabla.indexOf(cadena.charAt(i));
			if (posicion == -1) {
				cadena = cadena.replace(cadena.charAt(i), ' ');
			}
		}
		return cadena;
	}

	/**
	 * @autor: Genaro Bermúdez [22/01/2017]
	 * @modificado: Genaro Bermúdez [22/01/2017]
	 * @descripción: método que permite evaluar si la cadena cumple con las condiciones básicas para ser transformada en Cifrado César
	 * @parametros: ver parámetros de los métodos Encriptar o Desemcriptar
	 * @retorno: devuelve un valor boolena que indica: true = si es correcta la cadena / false = no es correcta la cadena
	 */
	private static boolean ValidarCaracteresEspeciales(String cadena) {
		boolean resultado = false;
		Pattern pat = Pattern.compile("(1|3|5|a|A|B|b|C|c|D|d|E|e|F|f|-|G|g|H|h|I|i|J|j|0|2|4|k|K|L|l|m|M|N|n|o|O|P|p|q|Q|R|_|r|s|S|7|9|T|t|U|u|V|v|w|W|x|X|6|8|.|y|Y|z|Z)+");
		Matcher mat = pat.matcher(cadena);
		if (mat.matches()) {
			resultado = true;
		} else {
			resultado = false;
		}
		return resultado;
	}

}
