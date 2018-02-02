package com.tencent.mm.view.footer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View.MeasureSpec;
import com.tencent.mm.bj.a$g;
import com.tencent.mm.bj.a.c;
import com.tencent.mm.bj.a.d;
import com.tencent.mm.bj.a.h;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;

public final class b extends a {
    private Bitmap zFA;
    private Bitmap zFB;
    private Bitmap zFC;
    private Bitmap zFD;
    private Rect[] zFE;
    private Rect[] zFF;
    private boolean zFG;
    private boolean zFH;
    private boolean zFI;
    private boolean zFJ;
    private boolean zFK = true;
    private int zFL = -1;
    private Bitmap zFq;
    private Bitmap zFr;
    private Bitmap zFs;
    private Bitmap zFt;
    private Bitmap zFu;
    private Bitmap zFv;
    private Bitmap zFw;
    private Bitmap zFx;
    private Bitmap zFy;
    private Bitmap zFz;
    private Paint zgB;

    public b(Context context, com.tencent.mm.bo.b bVar) {
        super(context, bVar);
    }

    protected final void cAz() {
        super.cAz();
        this.zgB = new Paint(1);
        this.zgB.setTextSize(getResources().getDimension(c.vbc));
        this.zFu = BitmapFactory.decodeResource(getResources(), d.vbu);
        this.zFv = BitmapFactory.decodeResource(getResources(), d.vbt);
        this.zFw = BitmapFactory.decodeResource(getResources(), d.vbw);
        this.zFx = BitmapFactory.decodeResource(getResources(), d.vbv);
        this.zFr = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(a$g.vbQ));
        this.zFq = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(a$g.vbP));
        this.zFs = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(a$g.vbK));
        this.zFt = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(a$g.vbJ));
        this.zFy = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(a$g.vbR));
        this.zFz = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(a$g.vbS));
        this.zFB = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(a$g.vbU));
        this.zFA = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(a$g.vbT));
        this.zFC = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(a$g.vbI));
        this.zFD = com.tencent.mm.sdk.platformtools.d.u(getResources().getDrawable(a$g.vbH));
    }

    protected final void onMeasure(int i, int i2) {
        if (cAH() != com.tencent.mm.api.d.fdz) {
            super.onMeasure(i, i2);
            return;
        }
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        setMeasuredDimension(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(cAE(), 1073741824));
        cAF();
    }

    protected final void k(Canvas canvas) {
        if (cAH() != com.tencent.mm.api.d.fdz) {
            super.k(canvas);
        } else {
            l(canvas);
        }
    }

    protected final Bitmap a(com.tencent.mm.api.d dVar, boolean z) {
        if (dVar == com.tencent.mm.api.d.fdz) {
            return z ? this.zFt : this.zFs;
        } else {
            if (dVar == com.tencent.mm.api.d.fdy) {
                return z ? this.zFq : this.zFr;
            } else {
                return null;
            }
        }
    }

    protected final int cAE() {
        int cAE = super.cAE();
        if (cAE != 0) {
            return cAE;
        }
        if (cAH() == com.tencent.mm.api.d.fdy) {
            return (int) getResources().getDimension(c.vbk);
        }
        if (cAH() == com.tencent.mm.api.d.fdz) {
            return (int) (getResources().getDimension(c.vbl) + getResources().getDimension(c.vbd));
        }
        return cAE;
    }

    protected final boolean Ht(int i) {
        boolean Ht = super.Ht(i);
        switch (1.vAh[Hs(i).ordinal()]) {
            case 1:
            case 2:
                return true;
            default:
                return Ht;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void fr(int i, int i2) {
        int i3 = 0;
        super.fr(i, i2);
        switch (1.vAh[Hs(this.jUA).ordinal()]) {
            case 1:
                break;
            case 2:
                break;
            default:
                return;
        }
    }

    protected final void fs(int i, int i2) {
        int i3 = 0;
        super.fs(i, i2);
        switch (1.vAh[Hs(this.jUA).ordinal()]) {
            case 1:
                int i4 = 0;
                while (this.zFF != null && i4 < this.zFF.length) {
                    if (this.zFF[i4].contains(i, i2)) {
                        if ((i4 == 0 && this.zFH) || ((i4 == 1 && this.zFG) || ((i4 == 2 && this.zFI) || (i4 == 3 && this.zFJ)))) {
                            this.fhY.cdf().a(com.tencent.mm.api.d.fdz, i4);
                            this.zFe = this.jUA;
                        }
                        this.zFH = false;
                        this.zFG = false;
                        this.zFI = false;
                        this.zFJ = false;
                        return;
                    }
                    i4++;
                }
                return;
            case 2:
                break;
            default:
                return;
        }
        while (this.zFE != null && i3 < this.zFE.length) {
            if (this.zFE[i3].contains(i, i2) && i3 == this.zFL) {
                this.fhY.cdf().a(com.tencent.mm.api.d.fdy, i3);
                this.zFe = this.jUA;
                return;
            }
            i3++;
        }
    }

    protected final void cAF() {
        super.cAF();
        float measuredWidth;
        int width;
        int cAE;
        int width2;
        int width3;
        if (cAH() == com.tencent.mm.api.d.fdy) {
            if (this.zFE == null) {
                this.zFE = new Rect[2];
            }
            if (this.zFi == null) {
                this.zFi = new Rect();
            }
            measuredWidth = ((float) ((((getMeasuredWidth() - ((int) (this.zEV * 2.0f))) - this.zFc.getWidth()) - this.zFx.getWidth()) - this.zFu.getWidth())) / 3.0f;
            width = (int) (((float) (this.zFw.getWidth() / 2)) + measuredWidth);
            cAE = ((cAE() - this.zFw.getWidth()) / 2) + (this.zFw.getWidth() / 2);
            width2 = this.zFw.getWidth() * 2;
            this.zFE[0] = new Rect(width - width2, cAE - width2, width + width2, cAE + width2);
            width3 = (int) ((measuredWidth + ((float) this.zFw.getWidth())) + ((float) width));
            this.zFE[1] = new Rect(width3 - width2, cAE - width2, width3 + width2, cAE + width2);
            width3 = (getMeasuredWidth() - (((int) (this.zEV * 2.0f)) / 2)) - (this.zFc.getWidth() / 2);
            this.zFi.set(width3 - this.zFc.getWidth(), 0, width3 + this.zFc.getWidth(), cAE());
        } else if (cAH() == com.tencent.mm.api.d.fdz) {
            if (this.zFF == null) {
                this.zFF = new Rect[4];
            }
            width3 = (int) getResources().getDimension(c.vbd);
            float height = (float) ((width3 / 2) - (this.zFz.getHeight() / 2));
            measuredWidth = ((float) width3) + ((getResources().getDimension(c.vbl) / 2.0f) - ((float) (this.zFD.getHeight() / 2)));
            width = (int) (height + ((float) (this.zFD.getHeight() / 2)));
            cAE = (int) (((1.0f * ((float) ((int) (this.zEV * 2.0f)))) / 2.0f) + ((float) (this.zFD.getHeight() / 2)));
            width2 = this.zFD.getHeight();
            this.zFF[0] = new Rect(cAE - width2, width - width2, cAE + width2, width + width2);
            width3 = (int) (measuredWidth + ((float) (this.zFD.getHeight() / 2)));
            this.zFF[1] = new Rect(cAE - width2, width3 - width2, cAE + width2, width3 + width2);
            width = (getMeasuredWidth() - (((int) (this.zEV * 2.0f)) / 2)) - (this.zFD.getHeight() / 2);
            this.zFF[2] = new Rect(width - width2, width3 - width2, width + width2, width3 + width2);
            width = getMeasuredWidth() / 2;
            this.zFF[3] = new Rect(width - width2, width3 - width2, width + width2, width3 + width2);
        }
    }

    protected final void l(Canvas canvas) {
        super.l(canvas);
        float measuredWidth;
        float cAE;
        if (cAH() == com.tencent.mm.api.d.fdy) {
            Paint paint = new Paint();
            if (uM()) {
                paint.setAlpha(255);
            } else {
                paint.setAlpha(JsApiSetBackgroundAudioState.CTRL_INDEX);
            }
            Bitmap bitmap = (this.zFj && uM()) ? this.zFd : this.zFc;
            canvas.drawBitmap(bitmap, (float) ((getMeasuredWidth() - (((int) (this.zEV * 2.0f)) / 2)) - this.zFc.getWidth()), (float) ((cAE() - this.zFc.getHeight()) / 2), paint);
            measuredWidth = ((float) ((((getMeasuredWidth() - ((int) (this.zEV * 2.0f))) - this.zFc.getWidth()) - this.zFx.getWidth()) - this.zFu.getWidth())) / 3.0f;
            cAE = (((float) (cAE() - this.zFx.getHeight())) * 1.0f) / 2.0f;
            if (this.zFK) {
                this.zFL = 0;
                this.zFK = false;
            }
            if (this.zFL == 0) {
                canvas.drawBitmap(this.zFv, measuredWidth, cAE, null);
                canvas.drawBitmap(this.zFw, (measuredWidth + measuredWidth) + ((float) this.zFx.getWidth()), cAE, null);
            } else if (this.zFL == 1) {
                canvas.drawBitmap(this.zFu, measuredWidth, cAE, null);
                canvas.drawBitmap(this.zFx, (measuredWidth + measuredWidth) + ((float) this.zFx.getWidth()), cAE, null);
            } else {
                canvas.drawBitmap(this.zFu, measuredWidth, cAE, null);
                canvas.drawBitmap(this.zFw, (measuredWidth + measuredWidth) + ((float) this.zFx.getWidth()), cAE, null);
            }
        } else if (cAH() == com.tencent.mm.api.d.fdz) {
            int dimension = (int) getResources().getDimension(c.vbd);
            canvas.drawLine(0.0f, (float) dimension, (float) getMeasuredWidth(), (float) dimension, this.zFk);
            measuredWidth = ((getResources().getDimension(c.vbl) / 2.0f) - ((float) (this.zFD.getHeight() / 2))) + ((float) dimension);
            cAE = (((float) ((int) (this.zEV * 2.0f))) * 1.0f) / 2.0f;
            float height = (float) ((dimension / 2) - (this.zFz.getHeight() / 2));
            if (this.zFH) {
                canvas.drawBitmap(this.zFz, cAE, height, null);
            } else {
                canvas.drawBitmap(this.zFy, cAE, height, null);
            }
            if (this.zFI) {
                canvas.drawBitmap(this.zFB, (((float) getMeasuredWidth()) - cAE) - ((float) this.zFD.getWidth()), measuredWidth, null);
            } else {
                canvas.drawBitmap(this.zFA, (((float) getMeasuredWidth()) - cAE) - ((float) this.zFD.getWidth()), measuredWidth, null);
            }
            if (this.zFG) {
                canvas.drawBitmap(this.zFC, cAE, measuredWidth, null);
            } else {
                canvas.drawBitmap(this.zFD, cAE, measuredWidth, null);
            }
            measuredWidth = getResources().getDimension(c.vbc) * 2.0f;
            cAE = (((getResources().getDimension(c.vbc) - 8.0f) / 2.0f) + (getResources().getDimension(c.vbl) / 2.0f)) + ((float) dimension);
            height = (float) (getMeasuredWidth() / 2);
            if (this.zFJ) {
                this.zgB.setColor(-1);
                this.zgB.setAlpha(JsApiSetBackgroundAudioState.CTRL_INDEX);
                canvas.drawText(getResources().getString(h.vbZ), height - (measuredWidth / 2.0f), cAE, this.zgB);
            } else if (uM()) {
                this.zgB.setColor(-1);
                this.zgB.setAlpha(255);
                canvas.drawText(getResources().getString(h.vbZ), height - (measuredWidth / 2.0f), cAE, this.zgB);
            } else {
                this.zgB.setColor(-1);
                this.zgB.setAlpha(100);
                canvas.drawText(getResources().getString(h.vbZ), height - (measuredWidth / 2.0f), cAE, this.zgB);
            }
        }
    }
}
