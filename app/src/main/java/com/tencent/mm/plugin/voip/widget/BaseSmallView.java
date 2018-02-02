package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public abstract class BaseSmallView extends FrameLayout {
    private WindowManager lEi;
    protected af lFk;
    private OnClickListener mOnClickListener;
    private long mStartTime;
    CaptureView slO;
    protected long slZ;
    private PointF svg = new PointF();
    private Point svh = new Point();
    private Point svi = new Point();
    private Point svj = new Point();
    private Point svk;
    private Runnable svl = new Runnable(this) {
        final /* synthetic */ BaseSmallView svm;

        {
            this.svm = r1;
        }

        public final void run() {
            float currentTimeMillis = (((float) (System.currentTimeMillis() - this.svm.mStartTime)) * 1.0f) / 200.0f;
            if (currentTimeMillis <= 1.0f) {
                this.svm.lFk.postDelayed(this.svm.svl, 5);
                this.svm.dV(this.svm.svi.x + ((int) (((((float) this.svm.svj.x) * 1.0f) - ((float) this.svm.svi.x)) * currentTimeMillis)), ((int) (currentTimeMillis * ((((float) this.svm.svj.y) * 1.0f) - ((float) this.svm.svi.y)))) + this.svm.svi.y);
                return;
            }
            this.svm.dV(this.svm.svj.x, this.svm.svj.y);
            this.svm.onAnimationEnd();
        }
    };

    public abstract void a(CaptureView captureView);

    public abstract void bIj();

    public abstract void bIk();

    public abstract void onAnimationEnd();

    public void b(int i, int i2, int[] iArr) {
    }

    public void bGZ() {
    }

    public void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5) {
    }

    public void dU(int i, int i2) {
    }

    public void uninit() {
        this.lFk.removeCallbacks(this.svl);
        this.lEi = null;
        if (this.slO != null) {
            removeView(this.slO);
            this.slO = null;
            x.d("MicroMsg.Voip.BaseSmallView", "CaptureView removed");
        }
    }

    public BaseSmallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lEi = (WindowManager) context.getSystemService("window");
        this.lFk = new af();
        this.svk = new Point(this.lEi.getDefaultDisplay().getWidth(), this.lEi.getDefaultDisplay().getHeight());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.svg.x = motionEvent.getRawX();
                this.svg.y = motionEvent.getRawY();
                LayoutParams layoutParams = (LayoutParams) getLayoutParams();
                this.svh.x = layoutParams.x;
                this.svh.y = layoutParams.y;
                break;
            case 1:
                if (Math.abs(motionEvent.getRawX() - this.svg.x) < ((float) b.b(getContext(), 3.0f)) && Math.abs(motionEvent.getRawY() - this.svg.y) < ((float) b.b(getContext(), 3.0f)) && this.mOnClickListener != null) {
                    this.mOnClickListener.onClick(this);
                }
                bIj();
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                this.svi.x = (int) Math.max(Math.min((rawX + ((float) this.svh.x)) - this.svg.x, (float) this.svk.x), 0.0f);
                this.svi.y = (int) Math.max(Math.min((rawY + ((float) this.svh.y)) - this.svg.y, (float) this.svk.y), 0.0f);
                int b = b.b(getContext(), 5.0f);
                if (this.svi.x + (getWidth() / 2) <= this.svk.x / 2) {
                    this.svj.x = b;
                } else {
                    this.svj.x = (this.svk.x - getWidth()) - b;
                }
                this.svj.y = this.svi.y;
                this.mStartTime = System.currentTimeMillis();
                this.lFk.postDelayed(this.svl, 5);
                bIk();
                break;
            case 2:
                dV((int) Math.max(Math.min((((float) this.svh.x) + motionEvent.getRawX()) - this.svg.x, (float) this.svk.x), 0.0f), (int) Math.max(Math.min((((float) this.svh.y) + motionEvent.getRawY()) - this.svg.y, (float) this.svk.y), 0.0f));
                break;
        }
        return true;
    }

    private void dV(int i, int i2) {
        if (this.lEi != null) {
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            layoutParams.x = i;
            layoutParams.y = i2;
            x.d("MicroMsg.Voip.BaseSmallView", "updateWindowPosition, x: %d, y: %d", new Object[]{Integer.valueOf(layoutParams.x), Integer.valueOf(layoutParams.y)});
            try {
                this.lEi.updateViewLayout(this, layoutParams);
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.Voip.BaseSmallView", th, "", new Object[0]);
            }
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public final void fe(long j) {
        this.slZ = j;
    }
}
