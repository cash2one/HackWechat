package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import java.lang.reflect.Field;

final class j {
    private static Field xo;
    private static boolean xp;

    static class a extends a implements Factory2 {
        a(k kVar) {
            super(kVar);
        }

        public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.xn.onCreateView(view, str, context, attributeSet);
        }
    }

    static void a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!xp) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                xo = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                new StringBuilder("forceSetFactory2 Could not find field 'mFactory2' on class ").append(LayoutInflater.class.getName()).append("; inflation may have unexpected results.");
            }
            xp = true;
        }
        if (xo != null) {
            try {
                xo.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                new StringBuilder("forceSetFactory2 could not set the Factory2 on LayoutInflater ").append(layoutInflater).append("; inflation may have unexpected results.");
            }
        }
    }
}
