package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

final class d {
    private static Field Br;
    private static boolean Bs;

    static Drawable a(CompoundButton compoundButton) {
        if (!Bs) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                Br = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            Bs = true;
        }
        if (Br != null) {
            try {
                return (Drawable) Br.get(compoundButton);
            } catch (IllegalAccessException e2) {
                Br = null;
            }
        }
        return null;
    }
}
