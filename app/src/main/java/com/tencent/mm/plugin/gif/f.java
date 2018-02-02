package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.mm.a.e;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends a {
    private final Paint fC;
    private af lFk;
    private float mDensity;
    private int mHeight;
    private boolean mIsRunning;
    private int mWidth;
    private boolean nyF;
    private int[] nyI;
    private float nyJ;
    private float nyK;
    private boolean nyL;
    private int nyN;
    private int nyO;
    private long nyP;
    private long nyQ;
    private long nyR;
    private long nyS;
    private long nyT;
    private long nyU;
    private final Runnable nzb;
    private final Runnable nzc;
    private final Runnable nzf;
    private volatile long nzr;
    private int[] nzs;
    private Bitmap nzt;
    private boolean nzu;
    private final Rect uk;

    static /* synthetic */ void a(f fVar, Runnable runnable, long j) {
        fVar.nyU = SystemClock.uptimeMillis() + j;
        if (fVar.lFk != null) {
            fVar.lFk.postAtTime(runnable, fVar.nyU);
        }
    }

    public f(String str) {
        this(e.d(str, 0, e.bN(str)));
    }

    public f(byte[] bArr) {
        this.mIsRunning = false;
        this.nyF = false;
        this.nyI = new int[4];
        this.nzs = new int[4];
        this.nyJ = 1.0f;
        this.nyK = 1.0f;
        this.uk = new Rect();
        this.fC = new Paint(6);
        this.nyN = 0;
        this.nyO = -1;
        this.nyP = 0;
        this.nyQ = 0;
        this.nyR = 0;
        this.nyS = 0;
        this.nyU = 0;
        this.nzu = false;
        this.lFk = new af();
        this.nzb = new 1(this);
        this.nzc = new 2(this);
        this.nzf = new 3(this);
        if (bArr == null) {
            throw new NullPointerException("bytes is null.");
        }
        this.nzr = MMWXGFJNI.nativeInitWxAMDecoder();
        if (this.nzr == 0 || this.nzr == -901) {
            x.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan init wxam decoder failed. mWXGFJNIHandle:%d", Long.valueOf(this.nzr));
            if (this.nzr == -901) {
                g.pQN.a(711, 5, 1, false);
            }
            g.pQN.a(711, 4, 1, false);
            throw new MMGIFException(201);
        }
        int nativeDecodeBufferHeader = MMWXGFJNI.nativeDecodeBufferHeader(this.nzr, bArr, bArr.length);
        if (nativeDecodeBufferHeader != 0) {
            x.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF decode buffer header failed. result:%d", Integer.valueOf(nativeDecodeBufferHeader));
            if (nativeDecodeBufferHeader == -904) {
                g.pQN.a(711, 8, 1, false);
            } else {
                g.pQN.a(711, 3, 1, false);
            }
            throw new MMGIFException(nativeDecodeBufferHeader);
        }
        nativeDecodeBufferHeader = MMWXGFJNI.nativeGetOption(this.nzr, bArr, bArr.length, this.nyI);
        if (nativeDecodeBufferHeader != 0) {
            x.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF get option failed. result:%d", Integer.valueOf(nativeDecodeBufferHeader));
            if (nativeDecodeBufferHeader == -903) {
                g.pQN.a(711, 7, 1, false);
            } else {
                g.pQN.a(711, 3, 1, false);
            }
            throw new MMGIFException(nativeDecodeBufferHeader);
        }
        this.nyN = this.nyI[0];
        this.mWidth = this.nyI[1];
        this.mHeight = this.nyI[2];
        if (this.mWidth == 0 || this.mHeight == 0) {
            nativeDecodeBufferHeader = a.aa(ac.getContext(), c.lnJ);
            this.mHeight = nativeDecodeBufferHeader;
            this.mWidth = nativeDecodeBufferHeader;
        }
        this.nzt = Bitmap.createBitmap(this.mWidth, this.mHeight, Config.ARGB_8888);
    }

    private float aSl() {
        if (this.mDensity == 0.0f) {
            this.mDensity = a.getDensity(ac.getContext()) / 2.0f;
            if (this.mDensity < 1.0f) {
                this.mDensity = 1.0f;
            } else if (this.mDensity > 2.0f) {
                this.mDensity = 2.0f;
            }
        }
        return this.mDensity;
    }

    public final int getIntrinsicWidth() {
        return (int) (((float) this.mWidth) * aSl());
    }

    public final int getIntrinsicHeight() {
        return (int) (((float) this.mHeight) * aSl());
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.nyL = true;
    }

    public final void draw(Canvas canvas) {
        if (this.nyL) {
            this.uk.set(getBounds());
            this.nyJ = ((float) this.uk.width()) / ((float) this.mWidth);
            this.nyK = ((float) this.uk.height()) / ((float) this.mHeight);
            this.nyL = false;
        }
        if (this.fC.getShader() == null) {
            if (this.nyS == 0) {
                this.nyS = System.currentTimeMillis();
            }
            canvas.scale(this.nyJ, this.nyK);
            if (this.nzt == null || this.nzt.isRecycled() || this.nyF) {
                x.e("MicroMsg.GIF.MMWXGFDrawable", "Cpan draw bitmap failed. Bitmap buffer is null or recycle");
            } else {
                canvas.drawBitmap(this.nzt, 0.0f, 0.0f, null);
            }
            this.nyT = System.currentTimeMillis() - this.nyS;
            com.tencent.mm.ao.a.b(this.nzf, 0);
            return;
        }
        canvas.drawRect(this.uk, this.fC);
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

    public final void start() {
        this.mIsRunning = true;
        com.tencent.mm.ao.a.b(this.nzc, 0);
    }

    public final void stop() {
        this.mIsRunning = false;
    }

    public final boolean isRunning() {
        return this.mIsRunning;
    }

    protected final void finalize() {
        try {
            recycle();
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.GIF.MMWXGFDrawable", th, "", new Object[0]);
            super.finalize();
        }
    }

    public final void reset() {
        this.mIsRunning = true;
    }

    public final synchronized void recycle() {
        x.v("MicroMsg.GIF.MMWXGFDrawable", "Cpan recycle decode handle:%d", Long.valueOf(this.nzr));
        this.nyF = true;
        this.mIsRunning = false;
        long j = this.nzr;
        this.nzr = 0;
        this.lFk.removeCallbacks(this.nzb);
        int nativeUninit = MMWXGFJNI.nativeUninit(j);
        if (nativeUninit == -906) {
            g.pQN.a(401, 10, 1, false);
        }
        x.d("MicroMsg.GIF.MMWXGFDrawable", "nativeUninit result:%d mWXGFJNIHandle:%s mIsRender:%b", Integer.valueOf(nativeUninit), Long.valueOf(j), Boolean.valueOf(this.nzu));
        if (!(j == 0 || nativeUninit != 0 || this.nzt == null)) {
            this.nzt.isRecycled();
        }
        this.nzt = null;
    }
}
