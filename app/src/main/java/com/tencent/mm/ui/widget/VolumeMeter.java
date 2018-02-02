package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public class VolumeMeter extends ImageView implements Runnable {
    private boolean huK = false;
    private Paint iYm;
    private Context mContext;
    private int nVA = 20;
    private float nVB;
    private float nVC;
    private float nVD = 0.0f;
    private float nVE = 40.0f;
    private float nVF = 30.0f;
    private boolean nVn = false;
    private View nVo;
    private int nVp = -1;
    private int nVq = -1;
    private af nVr = null;
    private float nVs;
    private float nVt;
    private float nVu;
    private float nVv;
    private int nVw = -6751336;
    private int nVx = 70;
    private float nVy = 0.5f;
    private float nVz = 0.001f;

    public void run() {
        if (this.huK) {
            float f;
            float f2 = this.nVu;
            if (this.nVt > this.nVs) {
                f = (this.nVt - this.nVs) / this.nVF;
                if (f > this.nVy) {
                    f = this.nVy;
                } else if (f < this.nVz) {
                    f = this.nVz;
                }
                f += f2;
            } else if (this.nVt <= this.nVs) {
                f = (this.nVs - this.nVt) / this.nVE;
                if (f > this.nVy) {
                    f = this.nVy;
                } else if (f < this.nVz) {
                    f = this.nVz;
                }
                f = f2 - f;
            } else {
                f = f2;
            }
            this.nVu = f;
            this.nVv = this.nVu;
            this.nVD = ((float) ((260.0d * Math.sqrt((double) this.nVu)) - ((double) (130.0f * this.nVu)))) / DownloadHelper.SAVE_FATOR;
            postInvalidate();
            this.nVr.postDelayed(this, (long) this.nVA);
        }
    }

    public VolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    public VolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        this.iYm = new Paint();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getWidth();
        getHeight();
        if (!(this.nVo == null || this.nVo.getVisibility() == 4)) {
            int[] iArr = new int[2];
            this.nVo.getLocationInWindow(iArr);
            if (!(iArr[0] == 0 || iArr[1] == 0)) {
                int width = this.nVo.getWidth();
                int height = this.nVo.getHeight();
                if (!(width == 0 || height == 0)) {
                    int b = b.b(this.mContext, 50.0f);
                    this.nVp = iArr[0] + (width / 2);
                    this.nVq = (iArr[1] + (height / 2)) - (b / 2);
                    this.nVC = (float) (width / 2);
                    this.nVB = ((float) (width / 2)) * 2.0f;
                }
            }
        }
        if (this.nVp >= 0 && this.nVq >= 0) {
            this.iYm.setColor(this.nVw);
            this.iYm.setAlpha(this.nVx);
            float b2 = (float) b.b(this.mContext, this.nVD);
            if (b2 > this.nVB) {
                b2 = this.nVB;
            }
            if (b2 < this.nVC) {
                b2 = this.nVC;
            }
            canvas.drawCircle((float) this.nVp, (float) this.nVq, b2, this.iYm);
        }
    }
}
