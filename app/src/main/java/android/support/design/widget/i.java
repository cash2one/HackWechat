package android.support.design.widget;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class i {
    private static Method hP;
    private static boolean hQ;
    private static Field hR;
    private static boolean hS;

    static boolean a(DrawableContainer drawableContainer, ConstantState constantState) {
        if (!hQ) {
            try {
                Method declaredMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[]{DrawableContainerState.class});
                hP = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            hQ = true;
        }
        if (hP != null) {
            try {
                hP.invoke(drawableContainer, new Object[]{constantState});
                return true;
            } catch (Exception e2) {
            }
        }
        return false;
    }

    static boolean b(DrawableContainer drawableContainer, ConstantState constantState) {
        if (!hS) {
            try {
                Field declaredField = DrawableContainer.class.getDeclaredField("mDrawableContainerStateField");
                hR = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            hS = true;
        }
        if (hR != null) {
            try {
                hR.set(drawableContainer, constantState);
                return true;
            } catch (Exception e2) {
            }
        }
        return false;
    }
}
