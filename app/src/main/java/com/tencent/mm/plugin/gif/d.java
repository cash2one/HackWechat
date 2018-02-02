package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends a {
    private final Paint fC = new Paint(6);
    private af lFk = new af(Looper.getMainLooper());
    public int lHX = 0;
    private Context mContext;
    private int mHeight;
    public boolean mIsPlaying = true;
    private Resources mResources;
    private int mWidth;
    private float nyJ = 1.0f;
    private float nyK = 1.0f;
    private boolean nyL;
    private long nyU = 0;
    private final Runnable nza = new 2(this);
    private final Runnable nzb = new 1(this);
    private volatile boolean nzh = false;
    private int nzi;
    private int nzj;
    private int[] nzk;
    private Bitmap nzl = null;
    private boolean nzm = false;
    private String nzn;
    public int nzo = 0;
    private h nzp;
    private final Rect uk = new Rect();

    public d(Context context, boolean z, boolean z2, int i, int[] iArr, String str) {
        this.mContext = context;
        this.mResources = this.mContext.getResources();
        this.nzm = false;
        this.mIsPlaying = z2;
        this.nzn = str;
        this.nzj = i;
        this.nzk = iArr;
        if (z2) {
            this.nzl = re(this.nzk[0]);
        } else {
            this.nzl = re(Cr(str));
        }
        this.mWidth = this.nzl.getWidth();
        this.mHeight = this.nzl.getHeight();
        if (this.nzk.length == 3) {
            this.nzi = 300;
        } else {
            this.nzi = 100;
        }
        this.nzo = 0;
    }

    public final void draw(Canvas canvas) {
        if (this.nyL) {
            this.uk.set(getBounds());
            this.nyJ = ((float) this.uk.width()) / ((float) this.mWidth);
            this.nyK = ((float) this.uk.height()) / ((float) this.mHeight);
            this.nyL = false;
        }
        if (this.fC.getShader() == null) {
            canvas.scale(this.nyJ, this.nyK);
            if (this.nzm) {
                this.nzl = re(this.nzj);
                if (this.nzl != null && !this.nzl.isRecycled()) {
                    canvas.drawBitmap(this.nzl, 0.0f, 0.0f, this.fC);
                    return;
                }
                return;
            } else if (this.mIsPlaying) {
                x.i("MicroMsg.GIF.MMGIFGameDrawable", "mCurrentIndex:%d mNextInvaliteTime:%d mLoop:%d", Integer.valueOf(this.lHX), Integer.valueOf(this.nzi), Integer.valueOf(this.nzo));
                this.nzl = re(this.nzk[this.lHX]);
                if (!(this.nzl == null || this.nzl.isRecycled())) {
                    canvas.drawBitmap(this.nzl, 0.0f, 0.0f, this.fC);
                }
                this.lHX++;
                if (this.nzo < 3) {
                    if (this.lHX >= this.nzk.length) {
                        this.lHX = 0;
                        this.nzo++;
                    }
                    e(this.nzb, (long) this.nzi);
                    return;
                }
                this.mIsPlaying = false;
                e(this.nzb, (long) this.nzi);
                e(this.nza, 0);
                return;
            } else {
                this.nzl = re(Cr(this.nzn));
                if (this.nzl != null && !this.nzl.isRecycled()) {
                    canvas.drawBitmap(this.nzl, 0.0f, 0.0f, this.fC);
                    return;
                }
                return;
            }
        }
        x.i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
        canvas.drawRect(this.uk, this.fC);
    }

    private void e(Runnable runnable, long j) {
        this.nyU = SystemClock.uptimeMillis() + j;
        if (this.lFk != null) {
            this.lFk.postDelayed(runnable, j);
        }
    }

    public final int getIntrinsicHeight() {
        return this.mHeight;
    }

    public final int getIntrinsicWidth() {
        return this.mWidth;
    }

    public final void setAlpha(int i) {
        this.fC.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.fC.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -2;
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.nyL = true;
    }

    public final void start() {
        this.nzh = true;
        this.lFk.post(this.nzb);
    }

    public final void stop() {
        this.nzh = false;
    }

    public final boolean isRunning() {
        return this.nzh;
    }

    private Bitmap re(int i) {
        return BitmapFactory.decodeResource(this.mResources, i);
    }

    private int Cr(String str) {
        return this.mResources.getIdentifier(str.split("\\.")[0], "drawable", this.mContext.getPackageName());
    }

    protected final void finalize() {
        this.nzp = null;
        super.finalize();
    }

    public final void recycle() {
    }

    public final void reset() {
    }
}
