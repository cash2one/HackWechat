package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.mm.bv.a;
import com.tencent.mm.cb.a$b;
import com.tencent.mm.cb.a.c;
import com.tencent.mm.cb.a.h;
import com.tencent.mm.cb.a.j;
import com.tencent.mm.sdk.platformtools.bh;

public class MMSwitchBtn extends View {
    private int maxHeight;
    private int maxWidth;
    private int nmE;
    private Paint oJe = new Paint(1);
    private float rRh;
    private float rRi;
    private long zuS;
    private int zuT;
    private int zuU;
    private int zuV;
    private boolean zuW = false;
    private boolean zuX = false;
    private int zuY;
    private int zuZ = 80;
    private int zva = 300;
    private float zvb;
    private float zvc;
    private int zvd;
    private int zve;
    private int zvf;
    public boolean zvg = false;
    private RectF zvh = new RectF();
    private RectF zvi = new RectF();
    private int zvj;
    private int zvk;
    private int zvl;
    private String zvm;
    private String zvn;
    private b zvo = new b(this);
    public a zvp;

    public MMSwitchBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
        b(context.obtainStyledAttributes(attributeSet, j.faH));
    }

    public MMSwitchBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
        b(context.obtainStyledAttributes(attributeSet, j.faH));
    }

    private void init() {
        this.zuY = getResources().getDimensionPixelSize(c.bvV);
        this.zvb = (float) getResources().getDimensionPixelSize(c.zyW);
        this.zvc = (float) getResources().getDimensionPixelSize(c.zyV);
        this.zvd = getResources().getColor(a$b.white);
        this.zve = getResources().getColor(a$b.zyO);
        this.zvf = getResources().getColor(a$b.zyP);
        this.zvk = this.zvf;
        this.zvj = this.zve;
        this.zvl = this.zvd;
        this.nmE = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void b(TypedArray typedArray) {
        this.zvk = typedArray.getColor(j.zAH, this.zvf);
        this.zvj = typedArray.getColor(j.zAI, this.zve);
        this.zvl = typedArray.getColor(j.zAJ, this.zvd);
        this.zvm = typedArray.getString(j.zAK);
        this.zvn = typedArray.getString(j.zAL);
        typedArray.recycle();
    }

    public final void nB(boolean z) {
        if (this.zvg != z) {
            clearAnimation();
            this.zvg = z;
            cyS();
            this.zuW = false;
            invalidate();
        }
        setContentDescription(z ? getContext().getString(h.zzC) : getContext().getString(h.zzD));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.maxWidth = i3 - i;
        this.maxHeight = i4 - i2;
        this.zuU = (this.maxWidth - ((int) (this.zvc * 2.0f))) - (this.zuY * 2);
        this.zuT = this.zuU / 2;
        this.zuV = getResources().getDimensionPixelSize(c.zyU);
        if (this.zuV < this.maxHeight) {
            this.zvh.top = (float) ((this.maxHeight - this.zuV) / 2);
            this.zvh.bottom = this.zvh.top + ((float) this.zuV);
        } else {
            this.zvh.top = 0.0f;
            this.zvh.bottom = (float) this.maxHeight;
        }
        this.zvh.left = 0.0f;
        this.zvh.right = (float) this.maxWidth;
        cyS();
        this.oJe.setStyle(Style.FILL);
        this.oJe.setColor(this.zve);
    }

    private void cyS() {
        if (this.zuV < this.maxHeight) {
            this.zvi.top = (float) (((this.maxHeight - this.zuV) / 2) + this.zuY);
            this.zvi.bottom = (this.zvi.top + ((float) this.zuV)) - ((float) (this.zuY * 2));
        } else {
            this.zvi.top = (float) this.zuY;
            this.zvi.bottom = (float) (this.maxHeight - this.zuY);
        }
        if (this.zvg) {
            this.zvi.left = (float) (this.zuU + this.zuY);
            this.zvi.right = (float) (this.maxWidth - this.zuY);
            return;
        }
        this.zvi.left = (float) this.zuY;
        this.zvi.right = (float) (((int) (this.zvc * 2.0f)) + this.zuY);
    }

    private void cyT() {
        if (this.zvi.left < ((float) this.zuY)) {
            this.zvi.left = (float) this.zuY;
        }
        if (this.zvi.left > ((float) (this.zuU + this.zuY))) {
            this.zvi.left = (float) (this.zuU + this.zuY);
        }
        this.zvi.right = this.zvi.left + ((float) ((int) (this.zvc * 2.0f)));
    }

    private void nC(boolean z) {
        this.zuW = true;
        this.zvo.reset();
        if (z) {
            this.zvo.zvr = (((long) this.zuU) - ((long) this.zvi.left)) + ((long) this.zuY);
            this.zvo.direction = 1;
        } else {
            this.zvo.zvr = (long) this.zvi.left;
            this.zvo.direction = 0;
        }
        this.zvo.zvq = this.zvi.left;
        this.zvo.setDuration((((long) this.zuZ) * this.zvo.zvr) / ((long) this.zuU));
        startAnimation(this.zvo);
    }

    private void ey(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private void cye() {
        if (this.zvi.left > ((float) this.zuT)) {
            nC(true);
        } else {
            nC(false);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.zuW && isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    clearAnimation();
                    this.rRh = motionEvent.getX();
                    this.rRi = motionEvent.getY();
                    this.zuS = SystemClock.elapsedRealtime();
                    this.zuX = false;
                    break;
                case 1:
                    if (SystemClock.elapsedRealtime() - this.zuS < ((long) this.zva)) {
                        nC(!this.zvg);
                    } else {
                        cye();
                    }
                    ey(false);
                    this.zuX = false;
                    break;
                case 2:
                    float x;
                    if (this.zuX) {
                        ey(true);
                        x = motionEvent.getX() - this.rRh;
                        RectF rectF = this.zvi;
                        rectF.left = x + rectF.left;
                        cyT();
                    } else {
                        float x2 = motionEvent.getX() - this.rRh;
                        x = motionEvent.getY() - this.rRi;
                        if (Math.abs(x2) >= ((float) this.nmE) / 10.0f) {
                            if (x == 0.0f) {
                                x = 1.0f;
                            }
                            if (Math.abs(x2 / x) > 3.0f) {
                                z = true;
                            }
                        }
                        if (z) {
                            this.zuX = true;
                            ey(true);
                        }
                    }
                    this.rRh = motionEvent.getX();
                    this.rRi = motionEvent.getY();
                    break;
                case 3:
                    if (this.zuX) {
                        cye();
                    }
                    ey(false);
                    this.zuX = false;
                    break;
            }
            if (this.zuX) {
                invalidate();
            }
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        this.oJe.setColor(this.zvj);
        this.oJe.setAlpha(255);
        canvas.drawRoundRect(this.zvh, this.zvb, this.zvb, this.oJe);
        this.oJe.setColor(this.zvk);
        this.oJe.setAlpha(Math.min(255, (int) (((this.zvi.left - ((float) this.zuY)) / ((float) this.zuU)) * 255.0f)));
        canvas.drawRoundRect(this.zvh, this.zvb, this.zvb, this.oJe);
        this.oJe.setColor(this.zvl);
        canvas.drawRoundRect(this.zvi, this.zvc, this.zvc, this.oJe);
        if (!bh.ov(this.zvm) && !bh.ov(this.zvn)) {
            Paint paint = new Paint();
            paint.setTextSize(getResources().getDimension(c.ubK));
            paint.setColor(getResources().getColor(a$b.buj));
            paint.setAntiAlias(true);
            int min = Math.min(255, (int) (((this.zvi.left - ((float) this.zuY)) / ((float) this.zuU)) * 255.0f));
            int measureText = (int) paint.measureText(this.zvm);
            Rect rect = new Rect();
            paint.getTextBounds(this.zvm, 0, this.zvm.length(), rect);
            paint.setAlpha(min);
            float height = ((((float) rect.height()) / 2.0f) + ((this.zvh.top + this.zvh.bottom) / 2.0f)) - ((float) a.fromDPToPix(getContext(), 1));
            canvas.drawText(this.zvm, ((this.zvh.left + this.zvb) - (((float) measureText) / 2.0f)) + ((float) a.fromDPToPix(getContext(), 1)), height, paint);
            float fromDPToPix = ((this.zvh.right - this.zvb) - (((float) measureText) / 2.0f)) - ((float) a.fromDPToPix(getContext(), 1));
            paint.setAlpha(255 - min);
            canvas.drawText(this.zvn, fromDPToPix, height, paint);
        }
    }
}
