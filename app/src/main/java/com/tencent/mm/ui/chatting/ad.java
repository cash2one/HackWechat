package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;

public final class ad {
    private static ad yxn;
    Object yxm;

    @TargetApi(14)
    public static class a implements OnHoverListener {
        private b yxo;

        public a(b bVar) {
            this.yxo = bVar;
        }

        public final boolean onHover(View view, MotionEvent motionEvent) {
            if (this.yxo != null) {
                return this.yxo.d(view, motionEvent);
            }
            return false;
        }
    }

    public static synchronized ad ctb() {
        ad adVar;
        synchronized (ad.class) {
            if (yxn == null) {
                yxn = new ad();
            }
            adVar = yxn;
        }
        return adVar;
    }
}
