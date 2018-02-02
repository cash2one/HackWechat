package android.support.v4.widget;

import android.widget.TextView;
import java.lang.reflect.Field;

final class s {
    static Field ER;
    static boolean ES;
    static Field ET;
    static boolean EU;

    static Field s(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            new StringBuilder("Could not retrieve ").append(str).append(" field.");
            return field;
        }
    }

    static int a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException e) {
            new StringBuilder("Could not retrieve value of ").append(field.getName()).append(" field.");
            return -1;
        }
    }
}
