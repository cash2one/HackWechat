package com.tencent.mm.ui.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;

class i$5 implements OnTouchListener {
    final /* synthetic */ i zuq;

    i$5(i iVar) {
        this.zuq = iVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                i.GX((int) motionEvent.getRawX());
                i.GY((int) motionEvent.getRawY());
                i.b(this.zuq, i.e(this.zuq));
                i.cyQ();
                x.i("MicroMsg.MMPopupMenu", "popmenu view set , x_down=" + i.bJo() + "y_down=" + i.cyR());
                break;
        }
        return false;
    }
}
