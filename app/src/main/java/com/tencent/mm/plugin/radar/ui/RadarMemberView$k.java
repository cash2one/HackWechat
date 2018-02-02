package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import b.c.b.e;
import b.i;
import com.tencent.mm.plugin.radar.ui.RadarMemberView.a;

final class RadarMemberView$k implements Runnable {
    final /* synthetic */ RadarMemberView pyq;

    RadarMemberView$k(RadarMemberView radarMemberView) {
        this.pyq = radarMemberView;
    }

    public final void run() {
        if (this.pyq.getContext() instanceof Activity) {
            a aVar = RadarMemberView.pyp;
            Context context = this.pyq.getContext();
            if (context == null) {
                throw new i("null cannot be cast to non-null type android.app.Activity");
            }
            Activity activity = (Activity) context;
            e.i(activity, "ac");
            Object systemService = activity.getSystemService("input_method");
            if (!(systemService instanceof InputMethodManager)) {
                systemService = null;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager != null) {
                View currentFocus = activity.getCurrentFocus();
                if (currentFocus != null && currentFocus.getWindowToken() != null) {
                    inputMethodManager.toggleSoftInput(0, 2);
                }
            }
        }
    }
}
