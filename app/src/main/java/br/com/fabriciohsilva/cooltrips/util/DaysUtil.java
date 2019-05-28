package br.com.fabriciohsilva.cooltrips.util;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DaysUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";
    public static final String day_month = "dd/MM";

    @NonNull
    public static String formatInText(int daysQuantity) {
        if(daysQuantity > 1){
            return daysQuantity + PLURAL;
        }
        return daysQuantity + SINGULAR;
    }

    @NonNull
    public static String periodInText(int days) {
        Calendar goDate = Calendar.getInstance();
        Calendar backDate = Calendar.getInstance();
        backDate.add(Calendar.DATE, days);

        SimpleDateFormat brasilDateFormat = new SimpleDateFormat(day_month);
        String goDateFormated = brasilDateFormat.format(goDate.getTime());
        String backDateFormated = brasilDateFormat.format(backDate.getTime());

        return goDateFormated + " - " + backDateFormated + " de " + backDate.get(Calendar.YEAR);
    }

}
