package com.tencent.mm.ui.applet;

import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ca.b;
import com.tencent.mm.ui.applet.c.a;

class c$a$2 implements OnTouchListener {
    final /* synthetic */ a xWh;
    int xWi;
    int xWj;
    int xWk = ((this.xWn.widthPixels - this.xWh.xWf.width) - 1);
    int xWl = ((this.xWn.heightPixels - this.xWh.xWf.height) - 1);
    long xWm;
    final /* synthetic */ DisplayMetrics xWn;

    c$a$2(a aVar, DisplayMetrics displayMetrics) {
        this.xWh = aVar;
        this.xWn = displayMetrics;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.xWi = ((int) motionEvent.getRawX()) - this.xWh.xWf.x;
                this.xWj = ((int) motionEvent.getRawY()) - this.xWh.xWf.y;
                this.xWm = System.currentTimeMillis();
                break;
            case 1:
                if (System.currentTimeMillis() - this.xWm < 300) {
                    b.clo();
                    b.R(false, true);
                    this.xWh.coE();
                    break;
                }
                break;
            case 2:
                this.xWk = (this.xWn.widthPixels - this.xWh.xWf.width) - 1;
                this.xWl = (this.xWn.heightPixels - this.xWh.xWf.height) - 1;
                this.xWh.xWf.x = ((int) motionEvent.getRawX()) - this.xWi;
                this.xWh.xWf.y = ((int) motionEvent.getRawY()) - this.xWj;
                this.xWh.xWf.x = this.xWh.xWf.x < 0 ? 0 : this.xWh.xWf.x;
                this.xWh.xWf.x = this.xWh.xWf.x > this.xWk ? this.xWk : this.xWh.xWf.x;
                this.xWh.xWf.y = this.xWh.xWf.y < 0 ? 0 : this.xWh.xWf.y;
                this.xWh.xWf.y = this.xWh.xWf.y > this.xWl ? this.xWl : this.xWh.xWf.y;
                this.xWh.xWe.updateViewLayout(this.xWh.xWd, this.xWh.xWf);
                break;
        }
        return false;
    }
}
