package com.tencent.mm.plugin.scanner.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.x;

class i$2 extends SimpleOnGestureListener {
    final /* synthetic */ i pXt;

    i$2(i iVar) {
        this.pXt = iVar;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        x.d("MicroMsg.scanner.ScanMode", "double click,pointer:%d,x:%f,y:%f", new Object[]{Integer.valueOf(motionEvent.getActionIndex()), Float.valueOf(motionEvent.getX(motionEvent.getActionIndex())), Float.valueOf(motionEvent.getY(motionEvent.getActionIndex()))});
        this.pXt.pXp.W(5, 2, 100);
        return true;
    }
}
