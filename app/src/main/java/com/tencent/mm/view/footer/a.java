package com.tencent.mm.view.footer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.api.d;
import com.tencent.mm.bj.a$c;
import com.tencent.mm.bj.a.e;
import com.tencent.mm.bj.a.g;
import com.tencent.mm.bo.b;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public abstract class a extends View {
    public static final int[] zFl = new int[]{-1, WebView.NIGHT_MODE_COLOR, -707825, -17592, -16535286, -15172610, -7054596, -449092};
    b fhY;
    private Paint gNB;
    protected int jUA = -1;
    protected Paint zDB;
    final float zEV = getResources().getDimension(a$c.vbi);
    private Bitmap zEW;
    private Bitmap zEX;
    private Bitmap zEY;
    private Bitmap zEZ;
    private Bitmap zFa;
    private Bitmap zFb;
    protected Bitmap zFc;
    protected Bitmap zFd;
    protected int zFe = -1;
    protected int zFf = -1;
    private Rect[] zFg;
    private Rect[] zFh;
    protected Rect zFi;
    protected boolean zFj;
    protected Paint zFk;
    protected int zFm = -1;
    protected int zFn = -1;
    private boolean zFo = true;

    protected abstract Bitmap a(d dVar, boolean z);

    public a(Context context, b bVar) {
        super(context);
        setId(e.vbz);
        this.fhY = bVar;
        cAz();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        k(canvas);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                while (i < cAB()) {
                    if (this.zFg[i].contains(x, y)) {
                        this.zFm = i;
                        postInvalidate();
                        break;
                    }
                    if (cAA()) {
                        if (this.zFi == null || !this.zFi.contains(x, y)) {
                            fr(x, y);
                        } else {
                            this.zFj = true;
                            postInvalidate();
                        }
                    }
                    i++;
                }
                break;
            case 1:
            case 3:
                int i2 = 0;
                while (i2 < cAB()) {
                    if (this.zFg[i2].contains(x, y) && this.zFm == i2) {
                        if (Ht(i2)) {
                            if (this.zFm != this.jUA) {
                                this.jUA = this.zFm;
                            } else {
                                this.jUA = -1;
                            }
                        }
                        this.zFf = this.zFe;
                        if (Ht(i2)) {
                            this.zFe = this.jUA;
                            this.fhY.cdf().a(Hs(this.jUA));
                        } else {
                            this.zFe = i2;
                            this.fhY.cdf().a(Hs(i2));
                        }
                        if (cAA()) {
                            if (this.zFi == null && this.zFi.contains(x, y) && this.zFj) {
                                this.fhY.cdf().a(Hs(this.jUA), -1);
                            } else {
                                fs(x, y);
                            }
                        }
                        this.zFj = false;
                        this.zFm = -1;
                        requestLayout();
                        postInvalidate();
                        break;
                    }
                    i2++;
                }
                if (cAA()) {
                    if (this.zFi == null) {
                        break;
                    }
                    fs(x, y);
                }
                this.zFj = false;
                this.zFm = -1;
                requestLayout();
                postInvalidate();
                break;
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int dimension = (int) getResources().getDimension(a$c.vbl);
        if (cAA()) {
            dimension += cAE();
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(dimension, 1073741824));
        cAF();
    }

    protected void cAz() {
        this.zDB = new Paint(1);
        this.zDB.setColor(-16711936);
        this.zFk = new Paint(1);
        this.zFk.setColor(getResources().getColor(com.tencent.mm.bj.a.b.vaV));
        this.zFk.setStrokeWidth(0.6f);
        this.gNB = new Paint(1);
        this.gNB.setStyle(Style.FILL);
        this.gNB.setStrokeCap(Cap.ROUND);
        this.zFd = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(g.vbY));
        this.zFc = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(g.vbX));
        this.zEW = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(g.vbO));
        this.zEX = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(g.vbN));
        this.zEY = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(g.vbW));
        this.zEZ = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(g.vbV));
        this.zFa = BitmapFactory.decodeResource(getResources(), com.tencent.mm.bj.a.d.vbr);
        this.zFb = BitmapFactory.decodeResource(getResources(), com.tencent.mm.bj.a.d.vbq);
    }

    protected void fr(int i, int i2) {
        switch (3.vAh[Hs(this.jUA).ordinal()]) {
            case 1:
                for (int i3 = 0; i3 < this.zFh.length; i3++) {
                    if (this.zFh[i3].contains(i, i2)) {
                        this.zFn = i3;
                        this.zFo = false;
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    protected void fs(int i, int i2) {
        switch (3.vAh[Hs(this.jUA).ordinal()]) {
            case 1:
                int i3 = 0;
                while (this.zFh != null && i3 < this.zFh.length) {
                    if (this.zFh[i3].contains(i, i2) && i3 == this.zFn) {
                        this.fhY.cdf().a(d.fdv, i3);
                        return;
                    }
                    i3++;
                }
                return;
            default:
                return;
        }
    }

    private boolean cAA() {
        return cAE() > 0;
    }

    private Bitmap b(d dVar, boolean z) {
        Bitmap bitmap = null;
        switch (3.vAh[dVar.ordinal()]) {
            case 1:
                if (!z) {
                    bitmap = this.zEW;
                    break;
                }
                bitmap = this.zEX;
                break;
            case 2:
                if (!z) {
                    bitmap = this.zEY;
                    break;
                }
                bitmap = this.zEZ;
                break;
            case 3:
                if (!z) {
                    bitmap = this.zFa;
                    break;
                }
                bitmap = this.zFb;
                break;
        }
        if (bitmap == null) {
            return a(dVar, z);
        }
        return bitmap;
    }

    private int cAB() {
        return this.fhY.cde().length;
    }

    private float cAC() {
        Bitmap b = b(d.fdv, false);
        return b == null ? 0.0f : (float) b.getWidth();
    }

    public static int getColor(int i) {
        if (i < 0 || i >= zFl.length) {
            return -65536;
        }
        return zFl[i];
    }

    private float cAD() {
        return ((((float) getMeasuredWidth()) - (((float) cAB()) * cAC())) - ((float) ((int) (2.0f * this.zEV)))) / ((float) (cAB() - 1));
    }

    protected int cAE() {
        if (Hs(this.jUA) == d.fdv) {
            return (int) getResources().getDimension(a$c.vbk);
        }
        return 0;
    }

    protected final d Hs(int i) {
        if (i < 0 || i >= cAB()) {
            return d.fdu;
        }
        return this.fhY.cde()[i];
    }

    protected void cAF() {
        if (this.zFg == null) {
            this.zFg = new Rect[cAB()];
        }
        int cAC = (int) (this.zEV + (cAC() / 2.0f));
        int cAC2 = (int) cAC();
        for (int i = 0; i < cAB(); i++) {
            this.zFg[i] = new Rect(cAC - cAC2, cAE(), cAC + cAC2, cAE() + getMeasuredHeight());
            cAC = (int) (((float) cAC) + (cAD() + cAC()));
        }
        if (Hs(this.jUA) == d.fdv) {
            cAG();
        }
    }

    private void cAG() {
        int i;
        if (this.zFh == null) {
            this.zFh = new Rect[zFl.length];
        }
        if (this.zFi == null) {
            this.zFi = new Rect();
        }
        float dimension = getResources().getDimension(a$c.vbe);
        float measuredWidth = (((float) ((getMeasuredWidth() - ((int) (this.zEV * 2.0f))) - this.zFc.getWidth())) - ((2.0f * dimension) * ((float) zFl.length))) / ((float) zFl.length);
        int i2 = (int) (dimension * 2.0f);
        int cAE = (int) (((((float) cAE()) - (dimension * 2.0f)) / 2.0f) + dimension);
        int i3 = (int) ((((float) (((int) (this.zEV * 2.0f)) / 2)) + dimension) + 5.0f);
        for (i = 0; i < zFl.length; i++) {
            this.zFh[i] = new Rect(i3 - i2, cAE - i2, i3 + i2, cAE + i2);
            i3 = (int) (((float) i3) + ((2.0f * dimension) + measuredWidth));
        }
        i = (getMeasuredWidth() - (((int) (this.zEV * 2.0f)) / 2)) - (this.zFc.getWidth() / 2);
        this.zFi.set(i - this.zFc.getWidth(), 0, i + this.zFc.getWidth(), cAE());
    }

    protected void k(Canvas canvas) {
        if (cAA()) {
            canvas.drawLine(0.0f, (float) cAE(), (float) getMeasuredWidth(), (float) cAE(), this.zFk);
            l(canvas);
        }
        float measuredHeight = ((((float) (getMeasuredHeight() - cAE())) - cAC()) / 2.0f) + ((float) cAE());
        int i = 0;
        float f = this.zEV;
        while (i < cAB()) {
            boolean z;
            d dVar = this.fhY.cde()[i];
            if (this.zFm == i || i == this.jUA) {
                z = true;
            } else {
                z = false;
            }
            Bitmap b = b(dVar, z);
            if (b != null) {
                canvas.drawBitmap(b, f, measuredHeight, null);
            }
            f += cAD() + cAC();
            i++;
        }
    }

    protected void l(Canvas canvas) {
        if (Hs(this.jUA) == d.fdv) {
            float dimension = getResources().getDimension(a$c.vbe);
            float measuredWidth = (((float) ((getMeasuredWidth() - ((int) (this.zEV * 2.0f))) - this.zFc.getWidth())) - ((2.0f * dimension) * ((float) zFl.length))) / ((float) zFl.length);
            float cAE = ((((float) cAE()) - (dimension * 2.0f)) / 2.0f) + dimension;
            float aJ = (((float) (((int) (this.zEV * 2.0f)) / 2)) + dimension) + ((float) com.tencent.mm.cc.a.aJ(DownloadHelper.SAVE_FATOR));
            int i = 0;
            while (i < zFl.length) {
                float f = 0.0f;
                if (this.zFn == i) {
                    f = (float) com.tencent.mm.cc.a.aJ(2.0f);
                    this.zFo = false;
                } else if (this.zFo && i == 2) {
                    f = (float) com.tencent.mm.cc.a.aJ(2.0f);
                }
                this.gNB.setColor(-1);
                canvas.drawCircle(aJ, cAE, (((float) com.tencent.mm.cc.a.aJ(DownloadHelper.SAVE_FATOR)) + dimension) + f, this.gNB);
                this.gNB.setColor(zFl[i]);
                canvas.drawCircle(aJ, cAE, f + dimension, this.gNB);
                aJ += (2.0f * dimension) + measuredWidth;
                i++;
            }
            Paint paint = new Paint();
            if (uM()) {
                paint.setAlpha(255);
            } else {
                paint.setAlpha(JsApiSetBackgroundAudioState.CTRL_INDEX);
            }
            Bitmap bitmap = (this.zFj && uM()) ? this.zFd : this.zFc;
            canvas.drawBitmap(bitmap, (float) ((getMeasuredWidth() - (((int) (this.zEV * 2.0f)) / 2)) - this.zFc.getWidth()), (float) ((cAE() - this.zFc.getHeight()) / 2), paint);
        }
    }

    protected final boolean uM() {
        com.tencent.mm.d.b b = this.fhY.b(cAH());
        return b == null ? false : b.uM();
    }

    protected boolean Ht(int i) {
        switch (3.vAh[Hs(i).ordinal()]) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    public final d cAH() {
        return Hs(this.zFe);
    }

    public final void c(d dVar) {
        int i = 0;
        while (i < cAB()) {
            if (this.fhY.cde()[i] == dVar) {
                break;
            }
            i++;
        }
        i = -1;
        if (Ht(i)) {
            this.jUA = i;
        } else {
            this.jUA = -1;
        }
        this.zFe = i;
        requestLayout();
        invalidate();
    }

    public final void cAI() {
        this.zFe = this.zFf;
        requestLayout();
        invalidate();
    }
}
