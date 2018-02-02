package com.tencent.mm.d;

import android.graphics.Canvas;
import android.graphics.Path;
import android.view.MotionEvent;
import com.tencent.mm.t.b;
import com.tencent.mm.view.footer.a;

public final class d extends b {
    private float YR;
    private float YS;
    private boolean fiD = false;
    private float fiE;
    private float fiF;
    private float fja;
    private boolean fjb = true;
    private Path mY = new Path();
    public int su = a.zFl[2];

    public final void uJ() {
        super.uJ();
        this.fja = this.fhY.cdk();
    }

    public final a uG() {
        return a.fhS;
    }

    public final boolean q(MotionEvent motionEvent) {
        if (!uO()) {
            return false;
        }
        float[] l = l(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (this.fia.contains((int) l[0], (int) l[1])) {
                    float f = l[0];
                    this.fiE = f;
                    this.YR = f;
                    float f2 = l[1];
                    this.fiF = f2;
                    this.YS = f2;
                    this.fjb = true;
                } else {
                    this.fjb = false;
                }
                this.fiD = false;
                break;
            case 1:
            case 5:
                if (this.fjb && this.fiD) {
                    uI().add(new b(new Path(this.mY), (this.fja / this.fhY.cdk()) / this.fhY.cdl(), this.su));
                    aI(false);
                }
                uT();
                this.mY.reset();
                this.fiD = false;
                this.fjb = false;
                break;
            case 2:
                if (!this.fjb || !this.fiD) {
                    if (this.fjb && !this.fiD) {
                        this.mY.moveTo(l[0], l[1]);
                        this.fiD = true;
                        break;
                    }
                }
                this.fiE = this.YR;
                this.fiF = this.YS;
                this.YR = l[0];
                this.YS = l[1];
                this.mY.quadTo(this.fiE, this.fiF, (this.YR + this.fiE) / 2.0f, (this.YS + this.fiF) / 2.0f);
                uS();
                break;
                break;
        }
        return this.fjb;
    }

    public final void onDraw(Canvas canvas) {
        canvas.save();
        canvas.clipRect(this.fia);
        b(canvas);
        if (!this.mY.isEmpty()) {
            new b(this.mY, (this.fja / this.fhY.cdk()) / this.fhY.cdl(), this.su).draw(canvas);
        }
        canvas.restore();
    }

    public final void uH() {
        aI(true);
    }
}
