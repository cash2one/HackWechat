package com.tencent.mm.plugin.location.ui.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements OnTouchListener {
    final /* synthetic */ b nWq;

    b$1(b bVar) {
        this.nWq = bVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        x.i("MicroMsg.MMBaseMapUI", "map action " + action);
        switch (action) {
            case 0:
                this.nWq.nlE = motionEvent.getX();
                this.nWq.kCe = motionEvent.getY();
                break;
            case 1:
                if (Math.abs(motionEvent.getX() - this.nWq.nlE) > 10.0f || Math.abs(motionEvent.getY() - this.nWq.kCe) > 10.0f) {
                    this.nWq.aWv();
                    break;
                }
        }
        return false;
    }
}
