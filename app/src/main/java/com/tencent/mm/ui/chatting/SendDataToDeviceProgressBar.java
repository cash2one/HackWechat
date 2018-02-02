package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.af;

class SendDataToDeviceProgressBar extends ImageView {
    private int bottom;
    private Paint fC;
    private af hae;
    private int lUf;
    private int lUg;
    private Runnable lUh;
    private int left;
    private Context mContext;
    private int nsd;
    private int right;
    private int top;

    public SendDataToDeviceProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SendDataToDeviceProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lUf = 2;
        this.left = -1;
        this.top = -1;
        this.right = -1;
        this.bottom = -1;
        this.lUg = -1;
        this.nsd = 10;
        this.lUh = new Runnable(this) {
            final /* synthetic */ SendDataToDeviceProgressBar yxB;

            {
                this.yxB = r1;
            }

            public final void run() {
                this.yxB.invalidate();
            }
        };
        setImageResource(R.g.bEP);
        this.mContext = context;
        this.fC = new Paint();
        this.fC.setAntiAlias(true);
        this.fC.setStyle(Style.STROKE);
        this.left = this.mContext.getResources().getDimensionPixelSize(R.f.bxT);
        this.top = this.left;
        this.lUg = this.mContext.getResources().getDimensionPixelSize(R.f.bxU);
        this.hae = new af(Looper.getMainLooper());
    }

    public final void setProgress(int i) {
        if (i >= 100) {
            i = 100;
        }
        this.lUf = (int) ((((float) i) / 100.0f) * 360.0f);
        this.hae.removeCallbacks(this.lUh);
        this.hae.postDelayed(this.lUh, 0);
    }

    public final int getProgress() {
        return (int) ((((float) this.lUf) / 360.0f) * 100.0f);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        this.fC.setColor(this.mContext.getResources().getColor(R.e.btA));
        this.fC.setStrokeWidth((float) this.lUg);
        if (this.right == -1) {
            this.right = (width * 2) - this.left;
        }
        if (this.bottom == -1) {
            this.bottom = this.right;
        }
        RectF rectF = new RectF((float) this.left, (float) this.top, (float) this.right, (float) this.bottom);
        canvas.drawArc(rectF, 270.0f, (float) this.lUf, false, this.fC);
        width = this.lUf + 270;
        if (width > 360) {
            width -= 360;
        }
        this.fC.setColor(this.mContext.getResources().getColor(R.e.btz));
        canvas.drawArc(rectF, (float) width, (float) (360 - this.lUf), false, this.fC);
    }
}
