package com.tencent.mm.d;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.api.i;
import com.tencent.mm.b.b;
import com.tencent.mm.b.c.2;
import com.tencent.mm.cache.c;
import com.tencent.mm.d.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.x.a;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

public final class e extends b<c> {
    private Timer bnp = new Timer();
    private boolean fiD = false;
    private boolean fjb = false;
    private TimerTask fjc;
    private Rect fjd = new Rect();
    private float fje = 0.0f;
    private float fjf = 0.0f;
    private int fjg = 0;
    private int fjh = 0;
    private boolean fji = false;
    private com.tencent.mm.b.c fjj = new com.tencent.mm.b.c(this);
    public a fjk;
    boolean fjl = false;
    Matrix mw = new Matrix();

    public final void uJ() {
        super.uJ();
        this.fjd.set(0, uQ().height() - ((int) ac.getResources().getDimension(com.tencent.mm.bj.a.c.vbo)), uQ().width(), uQ().height());
    }

    public final a uG() {
        return a.fhU;
    }

    public final void uH() {
    }

    public final void onDraw(Canvas canvas) {
        b(canvas);
        com.tencent.mm.t.c xz = ((c) uI()).xz();
        if (xz != null && xz.gNI) {
            xz.draw(canvas);
        }
    }

    public final boolean q(MotionEvent motionEvent) {
        com.tencent.mm.t.c n;
        boolean z;
        com.tencent.mm.t.c xz;
        switch (motionEvent.getActionMasked()) {
            case 0:
                vb();
                n = n(motionEvent.getX(), motionEvent.getY());
                if (n != null) {
                    z = n.gNM;
                    uZ();
                    this.fjb = true;
                    n.setSelected(true);
                    n.gNM = z;
                    n.gNJ.set(n.gNF);
                    ((c) uI()).b(n);
                    aI(true);
                    uS();
                    break;
                }
                this.fjb = false;
                xz = ((c) uI()).xz();
                if (xz != null) {
                    z = xz.gNI;
                } else {
                    z = false;
                }
                if (z) {
                    uZ();
                    aI(false);
                    uS();
                    break;
                }
                break;
            case 1:
                if (isAlive()) {
                    n = ((c) uI()).xz();
                    if (n != null) {
                        if (!this.fia.contains((int) n.gNF.x, (int) n.gNF.y)) {
                            this.fjj.fdb = true;
                            com.tencent.mm.b.c cVar = this.fjj;
                            cVar.fde = n;
                            cVar.fcR = n.gNJ.x - n.gNF.x;
                            cVar.fcS = n.gNJ.y - n.gNF.y;
                            cVar.fdf = n.gNC;
                            b bVar = this.fjj;
                            if (bVar.fdb) {
                                PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, bVar.fcS});
                                PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, bVar.fcR});
                                bVar.fcO = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2});
                                bVar.fcO.addUpdateListener(new AnimatorUpdateListener(bVar) {
                                    final /* synthetic */ c fdi;

                                    {
                                        this.fdi = r1;
                                    }

                                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                        float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
                                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
                                        x.d("MicroMsg.StickBackAnim", "animatorValueY:%s  %s", new Object[]{Float.valueOf(floatValue), Float.valueOf(floatValue - this.fdi.fdg)});
                                        e eVar = this.fdi.fdd;
                                        float f = floatValue2 - this.fdi.fdh;
                                        float f2 = floatValue - this.fdi.fdg;
                                        String str = this.fdi.fdf;
                                        ListIterator xA = ((com.tencent.mm.cache.c) eVar.uI()).xA();
                                        while (xA.hasPrevious()) {
                                            com.tencent.mm.t.c cVar = (com.tencent.mm.t.c) xA.previous();
                                            if (cVar.gNC.equals(str)) {
                                                cVar.gNF.offset(f, f2);
                                                eVar.uS();
                                                break;
                                            }
                                        }
                                        this.fdi.fdg = floatValue;
                                        this.fdi.fdh = floatValue2;
                                    }
                                });
                                bVar.fcO.addListener(new 2(bVar));
                                bVar.fcO.setInterpolator(new LinearInterpolator());
                                bVar.fcO.setDuration(100);
                                bVar.fcO.start();
                            }
                        }
                        if (n instanceof com.tencent.mm.t.e) {
                            com.tencent.mm.t.e eVar = (com.tencent.mm.t.e) n;
                            if (eVar.gNI && eVar.gNM) {
                                if (this.fjk != null) {
                                    this.fjk.a(eVar);
                                }
                            } else if (eVar.gNI) {
                                eVar.gNM = true;
                            }
                        }
                        PointF pointF = n.gNF;
                        x.i("MicroMsg.EmojiAndTextArtist", "mRubbishRect:%s pointF:%s", new Object[]{this.fjd, Float.valueOf(m(pointF.x, pointF.y)[1])});
                        if (n.gNI && ((float) this.fjd.top) <= r0[1] && this.fjb && this.fjk != null) {
                            ((c) uI()).xy();
                            uS();
                        }
                    }
                    va();
                    if (this.fiD && this.fjk != null) {
                        this.fjk.onHide();
                    }
                    this.fiD = false;
                    break;
                }
                x.e("MicroMsg.EmojiAndTextArtist", "[ACTION_UP] is not alive!");
                return false;
            case 2:
                if (!this.fji) {
                    if (this.fjb && u(motionEvent)) {
                        int toDegrees;
                        float f;
                        if (!(this.fiD || this.fjk == null)) {
                            this.fjk.onShow();
                        }
                        int[] iArr = new int[]{(int) (motionEvent.getX(0) - this.fih.x), (int) (motionEvent.getY(0) - this.fih.y)};
                        float f2 = 1.0f;
                        if (motionEvent.getPointerCount() > 1) {
                            if (0.0f != this.fje) {
                                f2 = ((float) r(motionEvent)) / this.fje;
                            }
                            toDegrees = this.fjg - ((int) Math.toDegrees(Math.atan2((double) s(motionEvent)[0], (double) s(motionEvent)[1])));
                            f = f2;
                        } else {
                            toDegrees = 0;
                            f = 1.0f;
                        }
                        float f3 = (float) iArr[0];
                        float f4 = (float) iArr[1];
                        float f5 = this.fjf;
                        int i = this.fjh;
                        int pointerCount = motionEvent.getPointerCount();
                        xz = ((c) uI()).xz();
                        if (xz != null) {
                            this.mw.reset();
                            this.mw.postRotate(-getRotation());
                            Matrix matrix = this.mw;
                            Matrix matrix2 = new Matrix();
                            matrix.invert(matrix2);
                            float[] fArr = new float[]{f3, f4};
                            matrix2.mapPoints(fArr);
                            if (pointerCount > 1) {
                                xz.b(0.0f, 0.0f, f * f5, (toDegrees + i) % 360);
                            } else {
                                xz.b(fArr[0] / getScale(), fArr[1] / getScale(), 0.0f, xz.gNG);
                            }
                            xz.BL();
                            PointF pointF2 = xz.gNF;
                            float[] m = m(pointF2.x, pointF2.y);
                            if (((float) this.fjd.top) <= m[1]) {
                                if (this.fjk != null) {
                                    this.fjk.Q((m[1] - ((float) this.fjd.top)) / ((float) this.fjd.height()));
                                }
                                this.fjl = true;
                            } else {
                                if (this.fjk != null && this.fjl) {
                                    this.fjk.Ep();
                                }
                                this.fjl = false;
                            }
                            if (xz instanceof com.tencent.mm.t.e) {
                                xz.gNM = false;
                            }
                        }
                        this.fiD = true;
                        uS();
                        break;
                    }
                }
                this.fji = false;
                return true;
            case 5:
                if (!this.fjb) {
                    int[] iArr2 = new int[2];
                    if (motionEvent.getPointerCount() > 1) {
                        iArr2[0] = ((int) (motionEvent.getX(0) + motionEvent.getX(1))) / 2;
                        iArr2[1] = ((int) (motionEvent.getY(0) + motionEvent.getY(1))) / 2;
                    }
                    n = n((float) iArr2[0], (float) iArr2[1]);
                    if (n != null) {
                        z = n.gNM;
                        uZ();
                        n.gNM = z;
                        this.fjb = true;
                        n.setSelected(true);
                        ((c) uI()).b(n);
                        this.fje = (float) r(motionEvent);
                        this.fjg = (int) Math.toDegrees(Math.atan2((double) s(motionEvent)[0], (double) s(motionEvent)[1]));
                        if (n != null && n.gNI) {
                            this.fjh = n.gNG;
                            this.fjf = n.gr;
                        }
                        aI(true);
                        uS();
                        break;
                    }
                }
                this.fje = (float) r(motionEvent);
                this.fjg = (int) Math.toDegrees(Math.atan2((double) s(motionEvent)[0], (double) s(motionEvent)[1]));
                xz = ((c) uI()).xz();
                if (xz != null && xz.gNI) {
                    this.fjh = xz.gNG;
                    this.fjf = xz.gr;
                    break;
                }
                break;
            case 6:
                this.fji = true;
                break;
        }
        super.q(motionEvent);
        return this.fjb;
    }

    public final void onDestroy() {
        super.onDestroy();
        vb();
    }

    private com.tencent.mm.t.c n(float f, float f2) {
        if (uI() == null) {
            x.e("MicroMsg.EmojiAndTextArtist", "[isContainsItem] getCache is null!");
            return null;
        }
        ListIterator xA = ((c) uI()).xA();
        com.tencent.mm.t.c cVar = null;
        while (xA.hasPrevious()) {
            cVar = (com.tencent.mm.t.c) xA.previous();
            float[] l = l(f, f2);
            float f3 = l[0];
            float f4 = l[1];
            cVar.gNN.clear();
            cVar.gNN.add(cVar.N(cVar.gNO - 180.0f));
            cVar.gNN.add(cVar.N(-cVar.gNO));
            cVar.gNN.add(cVar.N(cVar.gNO));
            cVar.gNN.add(cVar.N((-cVar.gNO) + 180.0f));
            com.tencent.mm.t.c.a aVar = new com.tencent.mm.t.c.a(cVar, cVar.gNN);
            Object obj = null;
            int i = 0;
            int i2 = aVar.gNS - 1;
            while (i < aVar.gNS) {
                if ((aVar.gNR[i] < f4 && aVar.gNR[i2] >= f4) || (aVar.gNR[i2] < f4 && aVar.gNR[i] >= f4)) {
                    if (((aVar.gNQ[i2] - aVar.gNQ[i]) * ((f4 - aVar.gNR[i]) / (aVar.gNR[i2] - aVar.gNR[i]))) + aVar.gNQ[i] < f3) {
                        obj = obj == null ? 1 : null;
                    }
                }
                int i3 = i;
                i++;
                i2 = i3;
            }
            if (obj != null) {
                return cVar;
            }
            cVar = null;
        }
        return cVar;
    }

    private com.tencent.mm.t.c uZ() {
        com.tencent.mm.t.c cVar = null;
        ListIterator xA = ((c) uI()).xA();
        while (xA.hasPrevious()) {
            com.tencent.mm.t.c cVar2 = (com.tencent.mm.t.c) xA.previous();
            if (cVar2.gNI) {
                cVar = cVar2;
            }
            cVar2.setSelected(false);
        }
        return cVar;
    }

    private void va() {
        x.d("MicroMsg.EmojiAndTextArtist", "[registerFocusTask]");
        if (this.fjc != null) {
            this.fjc.cancel();
        }
        this.fjc = new a(this, this);
        this.bnp.schedule(this.fjc, 1500);
    }

    private void vb() {
        x.d("MicroMsg.EmojiAndTextArtist", "[unRegisterFocusTask]");
        if (this.fjc != null) {
            this.fjc.cancel();
        }
    }

    public final void a(SpannableString spannableString, int i) {
        x.i("MicroMsg.EmojiAndTextArtist", "[addItem] text:%s", new Object[]{spannableString});
        if (!bh.M(spannableString)) {
            vb();
            uZ();
            aI(false);
            Rect uQ = uQ();
            com.tencent.mm.t.c eVar = new com.tencent.mm.t.e(ac.getContext(), uR(), ((c) uI()).aZ(true), uQ, spannableString, i);
            eVar.setSelected(true);
            eVar.gNM = true;
            float[] l = l((float) uQ.centerX(), (float) uQ.centerY());
            eVar.a(l[0], l[1], this.fhY.cdk() / this.fhY.cdl(), (int) getRotation());
            ((c) uI()).a(eVar);
            uS();
            va();
        }
    }

    public final void b(i iVar) {
        x.i("MicroMsg.EmojiAndTextArtist", "[addEmojiItem] item:%s", new Object[]{iVar});
        vb();
        uZ();
        aI(false);
        Rect uQ = uQ();
        com.tencent.mm.t.c cVar = new com.tencent.mm.t.c(ac.getContext(), uR(), ((c) uI()).aZ(true), iVar, uQ);
        cVar.setSelected(true);
        float[] l = l((float) uQ.centerX(), (float) uQ.centerY());
        cVar.a(l[0], l[1], this.fhY.cdk() / this.fhY.cdl(), (int) getRotation());
        ((c) uI()).a(cVar);
        uS();
        va();
    }

    public final void a(com.tencent.mm.t.e eVar, SpannableString spannableString, int i) {
        c cVar = (c) uI();
        x.i("MicroMsg.EmojiAndTextCache", "[delete] id:%s", new Object[]{eVar.gNC});
        if (cVar.gBu != null && cVar.gBu.size() > 0) {
            if (((com.tencent.mm.t.c) cVar.gBu.peek()).gNC.equalsIgnoreCase(r2)) {
                cVar.gBu.pop();
            } else {
                x.e("MicroMsg.EmojiAndTextCache", "[delete] id:%s emojiItem:%s", new Object[]{r2, (com.tencent.mm.t.c) cVar.gBu.peek()});
            }
        }
        eVar.setSelected(true);
        eVar.gNM = true;
        vb();
        uZ();
        aI(true);
        if (!bh.M(spannableString)) {
            com.tencent.mm.t.c eVar2 = new com.tencent.mm.t.e(ac.getContext(), uR(), ((c) uI()).aZ(true), uQ(), spannableString, i);
            eVar2.setSelected(true);
            PointF pointF = eVar.gNF;
            eVar2.a(pointF.x, pointF.y, this.fhY.cdk() / this.fhY.cdl(), eVar.gNG);
            ((c) uI()).a(eVar2);
        }
        uS();
        va();
    }
}
