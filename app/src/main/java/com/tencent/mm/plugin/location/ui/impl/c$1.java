package com.tencent.mm.plugin.location.ui.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements OnTouchListener {
    private float nXg;
    private short nXh = (short) 0;
    final /* synthetic */ c nXi;

    c$1(c cVar) {
        this.nXi = cVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!c.a(this.nXi)) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                x.d("MicroMsg.MMPoiMapUI", "newpoi action down %s", new Object[]{Float.valueOf(motionEvent.getRawY())});
                this.nXg = motionEvent.getRawY();
                c.a(this.nXi, false);
                break;
            case 1:
                x.d("MicroMsg.MMPoiMapUI", "newpoi action up ");
                c.a(this.nXi, false);
                break;
            case 2:
                x.d("MicroMsg.MMPoiMapUI", "newpoi action move %s", new Object[]{Float.valueOf(motionEvent.getRawY())});
                if (c.b(this.nXi)) {
                    x.d("MicroMsg.MMPoiMapUI", "newpoi blocked");
                    c.c(this.nXi).setSelection(0);
                }
                float rawY = this.nXg - motionEvent.getRawY();
                if (Math.abs(rawY) < ((float) b.b(this.nXi.activity, 20.0f))) {
                    this.nXh = (short) 0;
                } else if (rawY > 0.0f) {
                    this.nXh = (short) 1;
                } else {
                    this.nXh = (short) -1;
                }
                if ((this.nXi.aWw() <= c.d(this.nXi) && this.nXh == (short) 1) || ((!c.c(this.nXi).yca && this.nXh == (short) -1 && this.nXi.aWw() < c.e(this.nXi)) || (this.nXh == (short) -1 && this.nXi.aWw() >= c.e(this.nXi)))) {
                    return false;
                }
                if (!c.a(this.nXi) || this.nXh == (short) 0) {
                    return true;
                }
                x.d("MicroMsg.MMPoiMapUI", "newpoi start play isUP %s", new Object[]{Short.valueOf(this.nXh)});
                if (this.nXh == (short) 1) {
                    c.b(this.nXi, true);
                    return false;
                }
                c.b(this.nXi, false);
                return false;
        }
        return false;
    }
}
