package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel.a;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class e {
    private static final List<WeakReference<ControlBoardPanel>> khF = new LinkedList();
    private static final a khG = new 1();

    static /* synthetic */ void a(ControlBoardPanel controlBoardPanel) {
        if (controlBoardPanel != null) {
            for (int i = 0; i < khF.size(); i++) {
                WeakReference weakReference = (WeakReference) khF.get(i);
                if (weakReference != null && controlBoardPanel == weakReference.get()) {
                    khF.remove(weakReference);
                }
            }
        }
    }

    public static void ck(Context context) {
        View view;
        View view2;
        if (context != null) {
            for (int i = 0; i < khF.size(); i++) {
                WeakReference weakReference = (WeakReference) khF.get(i);
                if (weakReference != null) {
                    view = (ControlBoardPanel) weakReference.get();
                    if (view != null && context == view.getContext()) {
                        break;
                    }
                }
            }
        }
        view = null;
        if (view == null) {
            view = new ControlBoardPanel(context);
            khF.add(new WeakReference(view));
            view2 = view;
        } else {
            view2 = view;
        }
        a aVar = khG;
        if (!view2.khP) {
            view2.khP = true;
            Activity activity = (Activity) view2.getContext();
            view2.khO = new LayoutParams(-2, -2, 1003, 520, -3);
            view2.khO.y = com.tencent.mm.compatible.util.a.f(activity);
            view2.khO.token = activity.getWindow().getDecorView().getWindowToken();
            view2.khO.gravity = 51;
            view2.khO.softInputMode = 16;
            view2.khN.addView(view2, view2.khO);
            view2.reset();
            view2.khG = aVar;
            if (view2.khG != null) {
                view2.khG.a(view2, true);
            }
        }
    }
}
