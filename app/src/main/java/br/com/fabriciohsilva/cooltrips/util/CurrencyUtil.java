package br.com.fabriciohsilva.cooltrips.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtil {

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";
    public static final String DEFAULT_FORMAT = "R$";
    public static final String FORMAT_WITH_SPACE = "R$ ";

    public static String formatBrasilianString(BigDecimal valor) {
        NumberFormat brasilianFormat = DecimalFormat.getCurrencyInstance( new Locale(PORTUGUES, BRASIL));
        return brasilianFormat.format(valor).replace(DEFAULT_FORMAT, FORMAT_WITH_SPACE);
    }

}
