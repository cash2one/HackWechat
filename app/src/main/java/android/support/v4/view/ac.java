package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

final class ac {
    static void j(View view, int i) {
        view.offsetTopAndBottom(i);
        an(view);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            an((View) parent);
        }
    }

    static void k(View view, int i) {
        view.offsetLeftAndRight(i);
        an(view);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            an((View) parent);
        }
    }

    private static void an(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
