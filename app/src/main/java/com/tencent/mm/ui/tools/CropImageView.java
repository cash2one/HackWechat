package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.base.g;
import java.util.Timer;

public class CropImageView extends ImageView {
    int fyR = 0;
    private Timer jwk = new Timer(true);
    private float kCe;
    Bitmap mTJ;
    private long nVh;
    private float nlE;
    float nqU = 0.0f;
    float nqV = 0.0f;
    private OnTouchListener ozr = new 3(this);
    private boolean rCa = false;
    boolean yfy = false;
    Drawable yfz;
    private boolean zhA = false;
    private boolean zhB = false;
    private boolean zhC = false;
    private boolean zhD = false;
    private boolean zhE = false;
    private float zhF = 1.0f;
    private float zhG = 0.0f;
    private float zhH = 0.0f;
    private c zhI = null;
    private boolean zhJ = false;
    private Timer zhK;
    private af zhL = new 1(this);
    private b zhM = null;
    private af zhN = new af(this) {
        final /* synthetic */ CropImageView zhQ;

        {
            this.zhQ = r1;
        }

        public final void handleMessage(Message message) {
            if (message.what != 4653) {
                CropImageView.o(this.zhQ);
            } else if (!(this.zhQ.jwk == null || this.zhQ.zhM == null)) {
                this.zhQ.zhM.cancel();
                this.zhQ.zhM = null;
            }
            super.handleMessage(message);
        }
    };
    a zhO;
    boolean zhP = true;
    boolean zhs = true;
    private boolean zht = false;
    private float zhu;
    private float zhv;
    private PointF zhw = new PointF();
    boolean zhx = false;
    private boolean zhy = false;
    private boolean zhz = false;

    static /* synthetic */ void o(CropImageView cropImageView) {
        if (cropImageView.zhB) {
            cropImageView.zhG -= -20.0f;
            if (cropImageView.zhG > 0.0f) {
                cropImageView.zhB = false;
            }
            cropImageView.getImageMatrix().postTranslate(-20.0f, 0.0f);
        }
        if (cropImageView.zhC) {
            cropImageView.zhG -= 20.0f;
            if (cropImageView.zhG < 0.0f) {
                cropImageView.zhC = false;
            }
            cropImageView.getImageMatrix().postTranslate(20.0f, 0.0f);
        }
        if (cropImageView.zhD) {
            cropImageView.zhH -= 20.0f;
            if (cropImageView.zhH < 0.0f) {
                cropImageView.zhD = false;
            }
            cropImageView.getImageMatrix().postTranslate(0.0f, 20.0f);
        }
        if (cropImageView.zhE) {
            cropImageView.zhH -= -20.0f;
            if (cropImageView.zhH > 0.0f) {
                cropImageView.zhE = false;
            }
            cropImageView.getImageMatrix().postTranslate(0.0f, -20.0f);
        }
        cropImageView.setImageBitmap(cropImageView.mTJ);
        cropImageView.invalidate();
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cxI();
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.yfy = false;
        this.mTJ = bitmap;
        g.a(this.zhw, bitmap);
        super.setImageBitmap(bitmap);
    }

    public final void cxI() {
        setOnTouchListener(this.ozr);
    }

    public final void cxJ() {
        this.zhF *= 1.0666f;
        if (1.0f <= this.zhF) {
            this.zhA = false;
        }
        if (1.6f < this.zhF) {
            this.zhz = true;
        } else {
            this.zhz = false;
        }
        if (!this.zhs || 4.0f >= this.zhF) {
            float[] fArr = new float[2];
            r1 = new float[2];
            float f = this.zhw.x;
            r1[0] = f;
            fArr[0] = f;
            f = this.zhw.y;
            r1[1] = f;
            fArr[1] = f;
            getImageMatrix().mapPoints(fArr);
            getImageMatrix().postScale(1.0666f, 1.0666f);
            getImageMatrix().mapPoints(r1);
            getImageMatrix().postTranslate((fArr[0] - r1[0]) / 2.0f, (fArr[1] - r1[1]) / 2.0f);
            setImageBitmap(this.mTJ);
            invalidate();
            return;
        }
        this.zhF = 4.0f;
    }

    public final void cxK() {
        this.zhF *= 0.9375f;
        if (1.6f > this.zhF) {
            this.zhz = false;
        }
        if (1.0f > this.zhF) {
            this.zhA = true;
        } else {
            this.zhA = false;
        }
        if (0.4f > this.zhF) {
            this.zhF = 0.4f;
            return;
        }
        float[] fArr = new float[2];
        r1 = new float[2];
        float f = this.zhw.x;
        r1[0] = f;
        fArr[0] = f;
        f = this.zhw.y;
        r1[1] = f;
        fArr[1] = f;
        getImageMatrix().mapPoints(fArr);
        getImageMatrix().postScale(0.9375f, 0.9375f);
        getImageMatrix().mapPoints(r1);
        getImageMatrix().postTranslate((fArr[0] - r1[0]) / 2.0f, (fArr[1] - r1[1]) / 2.0f);
        setImageBitmap(this.mTJ);
        invalidate();
    }

    public final int cxL() {
        if (!this.yfy || this.yfz == null) {
            return getWidth();
        }
        return this.yfz.getIntrinsicWidth();
    }

    public final int cxM() {
        if (!this.yfy || this.yfz == null) {
            return getHeight();
        }
        return this.yfz.getIntrinsicHeight();
    }
}
