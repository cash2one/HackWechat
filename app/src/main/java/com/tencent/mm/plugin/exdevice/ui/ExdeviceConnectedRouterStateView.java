package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.jsapi.a.c;
import com.tencent.mm.sdk.platformtools.af;

public class ExdeviceConnectedRouterStateView extends ImageView {
    private int bottom;
    private Paint fC;
    private af hae;
    int lUf;
    private int lUg;
    private Runnable lUh;
    private int left;
    private Context mContext;
    private int right;
    private int state;
    private int top;

    public ExdeviceConnectedRouterStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExdeviceConnectedRouterStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lUf = 2;
        this.left = -1;
        this.top = -1;
        this.right = -1;
        this.bottom = -1;
        this.lUg = -1;
        this.lUh = new 1(this);
        this.mContext = context;
        this.fC = new Paint();
        this.fC.setAntiAlias(true);
        this.fC.setStyle(Style.STROKE);
        this.left = a.fromDPToPix(this.mContext, 2);
        this.top = this.left;
        this.lUg = a.fromDPToPix(this.mContext, 3);
        this.hae = new af(Looper.getMainLooper());
    }

    public final void setState(int i) {
        this.state = i;
        pj(10);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.state == 1) {
            int width = getWidth() / 2;
            this.fC.setARGB(255, 103, c.CTRL_INDEX, 79);
            this.fC.setStrokeWidth((float) this.lUg);
            if (this.right == -1) {
                this.right = (width * 2) - this.left;
            }
            if (this.bottom == -1) {
                this.bottom = this.right;
            }
            canvas.drawArc(new RectF((float) this.left, (float) this.top, (float) this.right, (float) this.bottom), 270.0f, (float) this.lUf, false, this.fC);
            this.lUf += 5;
            if (this.lUf > 365) {
                this.lUf = 0;
            }
            pj(100);
        }
    }

    private void pj(int i) {
        this.hae.removeCallbacks(this.lUh);
        this.hae.postDelayed(this.lUh, (long) i);
    }
}
