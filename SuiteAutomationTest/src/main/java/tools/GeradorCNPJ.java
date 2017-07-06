/**
 * @author Eduardo C. de Sá
 *
 * 10/12/2015
 */
package tools;

/**
 * @author eduardo.sa
 *
 */
public class GeradorCNPJ {

	public String generate() {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < 8; i++) {
			builder.append(Math.round(Math.random() * 9));
		}
		builder.append("0001");
		builder.append(getValidationDigits(builder.toString()));
		return builder.toString();
	}

	protected static String getValidationDigits(String cnpj) {
		if (cnpj == null || !cnpj.matches("\\d{12,14}")) {
			throw new IllegalArgumentException("CNPJ is not valid: " + cnpj);
		}
		// calculate both digit
		int d1 = 0, d2 = 0;
		for (int i = 0, m1 = 5, m2 = 6; i < 12; i++, m1--, m2--) {
			m1 = (m1 < 2) ? m1 + 8 : m1; // shift list
			d1 += Integer.parseInt(cnpj.substring(i, i + 1)) * m1;
			m2 = (m2 < 2) ? m2 + 8 : m2;
			d2 += Integer.parseInt(cnpj.substring(i, i + 1)) * m2;
		}
		d1 = 11 - d1 % 11;
		d1 = (d1 > 9) ? 0 : d1;
		// complete using the previous calculated digit
		d2 += d1 * 2;
		d2 = 11 - d2 % 11;
		d2 = (d2 > 9) ? 0 : d2;
		return "" + d1 + d2;
	}

	/**
	 * Total validation of the CNPJ ignoring the format. All non-numeric
	 * characters will be ignored. Validation digits are tested as well.
	 * 
	 * @param cnpj
	 *            The CNPJ to be tested.
	 * @return true if CNPJ is full valid.
	 * @author Jorge Lee
	 */
	public static boolean validate(String cnpj) {
		if (cnpj == null) {
			return false;
		}
		String _cnpj = cnpj.replaceAll("[^\\d]", "");
		if (!_cnpj.matches("\\d{14}"))
			return false;
		return _cnpj
				.equals(_cnpj.substring(0, 12) + getValidationDigits(_cnpj));
	}

}
