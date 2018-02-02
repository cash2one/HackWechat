package com.tencent.mm.ui.applet;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class b {
    int direction = 0;
    private GestureDetector lVX = new GestureDetector(new 2(this));
    private IdleHandler xGr;
    private int xVY;
    private c xVZ;
    LinkedList<String> xWa;
    a xWb;

    public b(a aVar) {
        this.xWb = aVar;
        this.xVY = 15;
        this.xVZ = new c(this, 40);
        this.xWa = new LinkedList();
        this.xGr = new IdleHandler(this) {
            final /* synthetic */ b xWc;

            {
                this.xWc = r1;
            }

            public final boolean queueIdle() {
                while (this.xWc.xWa.size() > 0) {
                    this.xWc.xWb.kX((String) this.xWc.xWa.removeFirst());
                }
                return true;
            }
        };
        Looper.myQueue().addIdleHandler(this.xGr);
    }

    public final void a(int i, b bVar) {
        if (bVar == null) {
            x.e("MicroMsg.EarlyGetHeadImg", "earlyGet, getter is null, no early get headimg will be performed");
        } else if (this.xVY <= 0) {
            x.e("MicroMsg.EarlyGetHeadImg", "earlyGet fail, threshold is invalid");
        } else {
            int NJ = bVar.NJ();
            for (int i2 = 1; i2 <= this.xVY; i2++) {
                String hC;
                if (this.direction == 1) {
                    if (i - i2 >= 0) {
                        hC = bVar.hC(i - i2);
                        if (!(hC == null || hC.length() == 0 || this.xVZ.contains(hC))) {
                            this.xVZ.OI(hC);
                            this.xWa.add(hC);
                        }
                    } else {
                        return;
                    }
                } else if (i + i2 < NJ) {
                    hC = bVar.hC(i + i2);
                    if (!(hC == null || hC.length() == 0 || this.xVZ.contains(hC))) {
                        this.xVZ.OI(hC);
                        this.xWa.add(hC);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final void onTouchEvent(MotionEvent motionEvent) {
        if (this.lVX != null) {
            this.lVX.onTouchEvent(motionEvent);
        }
    }

    public final void detach() {
        if (this.xGr != null) {
            Looper.myQueue().removeIdleHandler(this.xGr);
        }
    }
}
