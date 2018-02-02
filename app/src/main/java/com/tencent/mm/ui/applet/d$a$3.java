package com.tencent.mm.ui.applet;

import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.ca.d;
import com.tencent.mm.ca.d$a;
import com.tencent.mm.ui.applet.d.a;

class d$a$3 implements OnTouchListener {
    final /* synthetic */ a xWC;
    int xWi;
    int xWj;
    int xWk = ((this.xWn.widthPixels - this.xWC.xWf.width) - 1);
    int xWl = ((this.xWn.heightPixels - this.xWC.xWf.height) - 1);
    long xWm;
    final /* synthetic */ DisplayMetrics xWn;

    d$a$3(a aVar, DisplayMetrics displayMetrics) {
        this.xWC = aVar;
        this.xWn = displayMetrics;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.xWi = ((int) motionEvent.getRawX()) - this.xWC.xWf.x;
                this.xWj = ((int) motionEvent.getRawY()) - this.xWC.xWf.y;
                this.xWm = System.currentTimeMillis();
                break;
            case 1:
                if (System.currentTimeMillis() - this.xWm < 300) {
                    a aVar = this.xWC;
                    aVar.xWB.removeMessages(0);
                    aVar.xWA = 0;
                    if (!aVar.xWx) {
                        aVar.fyg.setVisibility(0);
                        aVar.fyg.setBackgroundDrawable(aVar.context.getResources().getDrawable(R.g.bGY));
                        aVar.xWx = !aVar.xWx;
                        aVar.xWz = new d$a(null, 6, 8, 0);
                        d.clq().c(aVar.xWz);
                        aVar.coH();
                        break;
                    }
                    aVar.fyi.setVisibility(0);
                    aVar.fyg.setVisibility(4);
                    if (!d.clq().b(aVar.xWz)) {
                        aVar.fD(aVar.context);
                        break;
                    }
                }
                break;
            case 2:
                this.xWk = (this.xWn.widthPixels - this.xWC.xWf.width) - 1;
                this.xWl = (this.xWn.heightPixels - this.xWC.xWf.height) - 1;
                this.xWC.xWf.x = ((int) motionEvent.getRawX()) - this.xWi;
                this.xWC.xWf.y = ((int) motionEvent.getRawY()) - this.xWj;
                this.xWC.xWf.x = this.xWC.xWf.x < 0 ? 0 : this.xWC.xWf.x;
                this.xWC.xWf.x = this.xWC.xWf.x > this.xWk ? this.xWk : this.xWC.xWf.x;
                this.xWC.xWf.y = this.xWC.xWf.y < 0 ? 0 : this.xWC.xWf.y;
                this.xWC.xWf.y = this.xWC.xWf.y > this.xWl ? this.xWl : this.xWC.xWf.y;
                this.xWC.xWe.updateViewLayout(this.xWC.xWd, this.xWC.xWf);
                break;
        }
        return false;
    }
}
