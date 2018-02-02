package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public final class a {
    public static b dL(View view) {
        if (view == null) {
            return null;
        }
        View view2 = view;
        while (!(view2 instanceof b)) {
            ViewParent parent = view2.getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                return null;
            }
            view2 = (View) parent;
        }
        return (b) view2;
    }

    public static void d(View view, int i, boolean z) {
        if (view != null && c.zga) {
            b dL = dL(view);
            if (dL != null) {
                dL.ak(i, z);
                return;
            }
            Activity cg = d.cg(view.getContext());
            if (cg != null) {
                cg.getWindow().setStatusBarColor(i);
                d.a(cg.getWindow(), z);
            }
        }
    }

    public static int ab(Activity activity) {
        if (c.zga && activity != null) {
            return c.ac(activity).zge;
        }
        return 0;
    }
}
