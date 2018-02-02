package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public class MultiTouchImageView extends ImageView {
    public int imageHeight;
    public int imageWidth;
    public int lXQ;
    public int lXR;
    protected af mHandler;
    private boolean oxo;
    public float pXP;
    private a rCA;
    public boolean rCd;
    protected Bitmap rnH;
    protected Matrix yfe;
    protected Matrix yff;
    private final Matrix yfg;
    private final float[] yfh;
    int yfi;
    int yfj;
    private float yfk;
    private float yfl;
    private float yfm;
    private boolean yfn;
    private float yfo;
    private float yfp;
    private float yfq;
    public boolean yfr;
    public boolean yfs;
    public boolean yft;
    private float yfu;
    private float yfv;
    private float yfw;
    float yfx;
    public boolean yfy;
    public Drawable yfz;

    public final void aE(float f) {
        if (Float.compare(f, 1.0f) < 0) {
            x.w("MicroMsg.MultiTouchImageView", "max scale limit is less than 1.0, change nothing, return");
        } else {
            this.yfq = f;
        }
    }

    public MultiTouchImageView(Context context, int i, int i2, a aVar) {
        super(context);
        this.yfe = new Matrix();
        this.yff = new Matrix();
        this.yfg = new Matrix();
        this.yfh = new float[9];
        this.rnH = null;
        this.yfi = -1;
        this.yfj = -1;
        this.yfk = 0.0f;
        this.yfl = 0.0f;
        this.yfm = 0.0f;
        this.oxo = false;
        this.yfn = false;
        this.yfo = 2.0f;
        this.yfp = 0.75f;
        this.yfq = 20.0f;
        this.yfr = false;
        this.yfs = false;
        this.yft = false;
        this.rCd = true;
        this.mHandler = new af();
        this.yfw = 1.0f;
        this.yfx = 0.0f;
        this.yfy = false;
        this.imageHeight = i2;
        this.imageWidth = i;
        this.rCA = aVar;
        init();
    }

    public MultiTouchImageView(Context context, int i, int i2) {
        this(context, i, i2, null);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private MultiTouchImageView(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet);
        this.yfe = new Matrix();
        this.yff = new Matrix();
        this.yfg = new Matrix();
        this.yfh = new float[9];
        this.rnH = null;
        this.yfi = -1;
        this.yfj = -1;
        this.yfk = 0.0f;
        this.yfl = 0.0f;
        this.yfm = 0.0f;
        this.oxo = false;
        this.yfn = false;
        this.yfo = 2.0f;
        this.yfp = 0.75f;
        this.yfq = 20.0f;
        this.yfr = false;
        this.yfs = false;
        this.yft = false;
        this.rCd = true;
        this.mHandler = new af();
        this.yfw = 1.0f;
        this.yfx = 0.0f;
        this.yfy = false;
        this.imageHeight = 0;
        this.imageWidth = 0;
        init();
    }

    public final void eS(int i, int i2) {
        this.imageWidth = i;
        this.imageHeight = i2;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.lXQ == MeasureSpec.getSize(i) && this.lXR == MeasureSpec.getSize(i2)) {
            this.yfn = false;
        } else {
            this.yfn = true;
        }
        this.lXQ = MeasureSpec.getSize(i);
        this.lXR = MeasureSpec.getSize(i2);
        if (!this.oxo) {
            this.oxo = true;
            init();
        }
        if (this.yfn) {
            cpS();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.yfy = false;
        this.rnH = bitmap;
        this.oxo = false;
        super.setImageBitmap(bitmap);
    }

    protected void onDraw(Canvas canvas) {
        if (this.yfy || this.rnH == null || !this.rnH.isRecycled()) {
            super.onDraw(canvas);
        } else {
            x.e("MicroMsg.MultiTouchImageView", "this bitmap is recycled! draw nothing!");
        }
    }

    public final void cpS() {
        this.yff.reset();
        cpT();
        h(this.pXP, 0.0f, 0.0f);
    }

    public final void I(float f, float f2) {
        cpT();
        i(this.pXP, f, f2);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            this.oxo = false;
        }
    }

    private void cpT() {
        boolean z;
        boolean z2 = true;
        this.yfu = ((float) this.lXQ) / ((float) this.imageWidth);
        this.yfv = ((float) this.lXR) / ((float) this.imageHeight);
        this.yfs = ((float) this.imageWidth) > ((float) this.imageHeight) * 2.2f;
        if (((float) this.imageHeight) > ((float) this.imageWidth) * 2.2f) {
            z = true;
        } else {
            z = false;
        }
        this.yft = z;
        if (!this.yfs || this.imageWidth <= this.lXQ) {
            z = false;
        } else {
            z = true;
        }
        this.yfs = z;
        if (!this.yft || this.imageHeight <= this.lXR) {
            z2 = false;
        }
        this.yft = z2;
        float f = ((float) this.imageHeight) / ((float) this.imageWidth);
        float f2 = 1.8f;
        if (!(this.lXQ == 0 || this.lXR == 0)) {
            f2 = ((float) this.lXR) / ((float) this.lXQ);
        }
        if (f <= f2 || ((double) f) > 2.2d) {
            this.pXP = this.yfu;
        } else {
            this.pXP = this.yfv;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        if (g.coK()) {
            f fVar = new f();
            keyEvent.startTracking();
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z = false;
        if (i == 4) {
            boolean isTracking;
            if (g.coK()) {
                f fVar = new f();
                isTracking = keyEvent.isTracking();
            } else {
                isTracking = false;
            }
            if (isTracking) {
                if (g.coK()) {
                    f fVar2 = new f();
                    z = keyEvent.isCanceled();
                }
                if (!z && getScale() > 1.0f) {
                    h(1.0f, ((float) this.lXQ) / 2.0f, ((float) this.lXR) / 2.0f);
                    return true;
                }
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    private void U(boolean z, boolean z2) {
        float f = 0.0f;
        if (this.rnH == null && !this.yfy) {
            return;
        }
        if (this.yfz != null || !this.yfy) {
            RectF rectF;
            Matrix cpU = cpU();
            if (this.yfy) {
                rectF = new RectF(0.0f, 0.0f, (float) this.yfz.getIntrinsicWidth(), (float) this.yfz.getIntrinsicHeight());
            } else {
                rectF = new RectF(0.0f, 0.0f, (float) this.rnH.getWidth(), (float) this.rnH.getHeight());
            }
            cpU.mapRect(rectF);
            float height = rectF.height();
            float width = rectF.width();
            if (z2) {
                if (height < ((float) this.lXR)) {
                    height = ((((float) this.lXR) - height) / 2.0f) - rectF.top;
                } else if (rectF.top > 0.0f) {
                    height = -rectF.top;
                } else {
                    if (rectF.bottom < ((float) this.lXR)) {
                        height = ((float) this.lXR) - rectF.bottom;
                    }
                    height = 0.0f;
                }
            } else if (rectF.top > 0.0f) {
                height = -rectF.top;
            } else {
                if (rectF.bottom < ((float) this.lXR)) {
                    height = ((float) this.lXR) - rectF.bottom;
                }
                height = 0.0f;
            }
            if (z) {
                if (width < ((float) this.lXQ)) {
                    f = ((((float) this.lXQ) - width) / 2.0f) - rectF.left;
                } else if (rectF.left > 0.0f) {
                    f = -rectF.left;
                } else if (rectF.right < ((float) this.lXQ)) {
                    f = ((float) this.lXQ) - rectF.right;
                }
            } else if (rectF.left > 0.0f) {
                f = -rectF.left;
            } else if (rectF.right < ((float) this.lXQ)) {
                f = ((float) this.lXQ) - rectF.right;
            }
            K(f, height);
            Matrix cpU2 = cpU();
            setImageMatrix(cpU2);
            cpU2.mapRect(rectF);
            rectF.height();
            rectF.width();
        }
    }

    private void init() {
        x.d("dktest", "init screenWidth:" + this.lXQ + " screenHeight :" + this.lXR);
        setScaleType(ScaleType.MATRIX);
        float f = ((float) getContext().getResources().getDisplayMetrics().widthPixels) / 720.0f;
        if (f > 1.0f) {
            this.yfw = f;
        }
        cpS();
    }

    public final float getScale() {
        this.yff.getValues(this.yfh);
        cpT();
        this.yfl = this.yfq * this.yfw;
        this.yfm = this.pXP * this.yfp;
        if (this.yfl < 1.0f) {
            this.yfl = 1.0f;
        }
        if (this.yfm > 1.0f) {
            this.yfm = 1.0f;
        }
        return this.yfh[0];
    }

    private Matrix cpU() {
        this.yfg.set(this.yfe);
        this.yfg.postConcat(this.yff);
        return this.yfg;
    }

    public final void cpV() {
        boolean z;
        boolean z2 = true;
        if (this.rCd && this.yfs) {
            z = false;
        } else {
            z = true;
        }
        if (this.yft) {
            z2 = false;
        }
        U(z, z2);
    }

    public final void cpW() {
        if (this.yfr && 0.0f == this.yfk) {
            this.yfk = cpX();
        }
    }

    public final void h(float f, float f2, float f3) {
        boolean z;
        boolean z2 = true;
        float scale = getScale();
        if (this.yfr) {
            this.yfl = 0.0f == this.yfk ? this.yfq * this.yfw : this.yfk;
        }
        if (f > this.yfl * 2.0f) {
            f = (this.yfl * 2.0f) + ((f - this.yfl) * 0.1f);
        } else if (f < this.yfm) {
            f = this.yfm;
        }
        scale = f / scale;
        if (!this.yfy) {
            setImageMatrix(cpU());
            this.yff.postScale(scale, scale, f2, f3);
        }
        if (this.rCd && this.yfs) {
            z = false;
        } else {
            z = true;
        }
        if (this.yft) {
            z2 = false;
        }
        U(z, z2);
        if (this.rCA == null) {
            return;
        }
        if (scale > 1.0f) {
            this.rCA.bBf();
        } else if (scale < 1.0f) {
            this.rCA.bBe();
        }
    }

    public final float cpX() {
        float f = this.pXP;
        if (this.yfu * 0.7f > f) {
            f = this.yfu;
        } else if (this.yfv * 0.7f > f) {
            f = this.yfv;
        } else {
            f = this.pXP * this.yfo;
        }
        if (((double) f) < 1.0d) {
            f = 1.0f;
        }
        if (f > this.yfl) {
            return this.yfl;
        }
        return f;
    }

    public final void J(float f, float f2) {
        this.yfk = cpX();
        i(this.yfk, f, f2);
    }

    private void i(float f, float f2, float f3) {
        float scale = (f - getScale()) / 128.0f;
        float scale2 = getScale();
        this.mHandler.post(new 1(this, 128.0f, System.currentTimeMillis(), scale2, scale, f2, f3));
    }

    public final void K(float f, float f2) {
        this.yff.postTranslate(f, f2);
        setImageMatrix(cpU());
    }
}
