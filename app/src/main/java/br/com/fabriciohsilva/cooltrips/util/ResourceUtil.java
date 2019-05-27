package br.com.fabriciohsilva.cooltrips.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourceUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable returnDrawable(Context context, String drawableInString) {
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(drawableInString
                , DRAWABLE, context.getPackageName());
        return resources.getDrawable(idDoDrawable);
    }
}
