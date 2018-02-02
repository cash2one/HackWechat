package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.compatible.util.d;

public class ScanMaskView extends View {
    private Paint fC;
    private Bitmap pWC = null;
    private Bitmap pWD = null;
    private Bitmap pWE = null;
    private Bitmap pWF = null;
    int pWG = 0;
    int pWH = 0;
    private boolean pWI = false;
    private Rect pWJ = new Rect();
    private Rect pWK = new Rect();
    private Rect pWL = new Rect();
    private Rect pWM = new Rect();
    private Rect pWN = new Rect();
    private Rect pWO = new Rect();
    private Rect pWP = new Rect();
    private Rect pWQ = new Rect();
    private Rect pWR = new Rect();
    private Path pWS = new Path();
    Rect pWT;
    private PorterDuffXfermode pWU;
    private int pWV = R.e.btF;
    private long pWW = 0;
    boolean pWX = false;
    Rect pWY;
    private final long pWZ = 200;
    float pXa = 0.0f;
    float pXb = 0.0f;
    float pXc = 0.0f;
    float pXd = 0.0f;
    private Paint pXe;
    ValueAnimator pXf = null;

    public ScanMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScanMaskView(Context context, Rect rect) {
        super(context);
        this.pWT = rect;
        getDrawingRect(this.pWJ);
        this.fC = new Paint();
        this.pWC = a.decodeResource(getResources(), R.g.bFC);
        this.pWD = a.decodeResource(getResources(), R.g.bFD);
        this.pWE = a.decodeResource(getResources(), R.g.bFE);
        this.pWF = a.decodeResource(getResources(), R.g.bFF);
        this.pWG = this.pWC.getWidth();
        this.pWH = this.pWC.getHeight();
        this.pXe = new Paint();
        this.pWU = new PorterDuffXfermode(Mode.CLEAR);
    }

    public final void bpm() {
        this.pWI = true;
        if (this.pWC != null) {
            this.pWC.recycle();
            this.pWC = null;
        }
        if (this.pWD != null) {
            this.pWD.recycle();
            this.pWD = null;
        }
        if (this.pWE != null) {
            this.pWE.recycle();
            this.pWE = null;
        }
        if (this.pWF != null) {
            this.pWF.recycle();
            this.pWF = null;
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.pWT != null && !this.pWI) {
            System.currentTimeMillis();
            System.currentTimeMillis();
            int save = canvas.save();
            this.fC.reset();
            if (d.fN(18)) {
                this.pWO.left = 0;
                this.pWO.top = this.pWT.top;
                this.pWO.right = this.pWT.left;
                this.pWO.bottom = this.pWT.bottom;
                this.pWP.left = this.pWT.left;
                this.pWP.top = 0;
                this.pWP.right = this.pWT.right;
                this.pWP.bottom = this.pWT.top;
                this.pWQ.left = this.pWT.right;
                this.pWQ.top = this.pWT.top;
                this.pWQ.right = getWidth();
                this.pWQ.bottom = this.pWT.bottom;
                this.pWR.left = this.pWT.left;
                this.pWR.top = this.pWT.bottom;
                this.pWR.right = this.pWT.right;
                this.pWR.bottom = getHeight();
                this.pWK.left = 0;
                this.pWK.top = 0;
                this.pWK.right = this.pWT.left;
                this.pWK.bottom = this.pWT.top;
                this.pWL.left = this.pWT.right;
                this.pWL.top = 0;
                this.pWL.right = getWidth();
                this.pWL.bottom = this.pWT.top;
                this.pWM.left = 0;
                this.pWM.top = this.pWT.bottom;
                this.pWM.right = this.pWT.left;
                this.pWM.bottom = getHeight();
                this.pWN.left = this.pWT.right;
                this.pWN.top = this.pWT.bottom;
                this.pWN.right = getWidth();
                this.pWN.bottom = getHeight();
                canvas.save();
                canvas.clipRect(this.pWO, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.pWV));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.pWP, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.pWV));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.pWQ, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.pWV));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.pWR, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.pWV));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.pWK, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.pWV));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.pWL, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.pWV));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.pWM, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.pWV));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.pWN, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.pWV));
                canvas.restore();
            } else {
                canvas.clipRect(this.pWT, Op.DIFFERENCE);
                canvas.drawColor(getResources().getColor(this.pWV));
            }
            System.currentTimeMillis();
            System.currentTimeMillis();
            canvas.restoreToCount(save);
            this.fC.reset();
            this.fC.setStyle(Style.STROKE);
            this.fC.setStrokeWidth(1.0f);
            this.fC.setColor(-3355444);
            this.fC.setAntiAlias(true);
            canvas.drawRect(this.pWT, this.fC);
            System.currentTimeMillis();
            System.currentTimeMillis();
            canvas.drawBitmap(this.pWC, (float) this.pWT.left, (float) this.pWT.top, this.pXe);
            canvas.drawBitmap(this.pWD, (float) (this.pWT.right - this.pWG), (float) this.pWT.top, this.pXe);
            canvas.drawBitmap(this.pWE, (float) this.pWT.left, (float) (this.pWT.bottom - this.pWH), this.pXe);
            canvas.drawBitmap(this.pWF, (float) (this.pWT.right - this.pWG), (float) (this.pWT.bottom - this.pWH), this.pXe);
            System.currentTimeMillis();
            super.onDraw(canvas);
            System.currentTimeMillis();
        }
    }
}
