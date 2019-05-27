package br.com.fabriciohsilva.cooltrips.util;

import android.support.annotation.NonNull;

public class DaysUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    @NonNull
    public static String formatInText(int daysQuantity) {
        if(daysQuantity > 1){
            return daysQuantity + PLURAL;
        }
        return daysQuantity + SINGULAR;
    }

}
