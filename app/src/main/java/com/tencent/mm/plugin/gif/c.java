package com.tencent.mm.plugin.gif;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mm.bv.a;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;

public final class c extends a {
    private final Paint fC;
    private int hEF;
    private af lFk;
    private float mDensity;
    boolean mIsRunning;
    boolean nyF;
    private volatile long nyG;
    private AssetFileDescriptor nyH;
    private final int[] nyI;
    private float nyJ;
    private float nyK;
    private boolean nyL;
    private int[] nyM;
    private int nyN;
    private int nyO;
    private long nyP;
    private long nyQ;
    private long nyR;
    private long nyS;
    private long nyT;
    private long nyU;
    private int nyV;
    private boolean nyW;
    int nyX;
    private int nyY;
    h nyZ;
    private final Runnable nza;
    final Runnable nzb;
    private final Runnable nzc;
    private final Runnable nzd;
    private final Runnable nze;
    private final Runnable nzf;
    private final Rect uk;

    final void e(Runnable runnable, long j) {
        this.nyU = SystemClock.uptimeMillis() + j;
        if (this.lFk != null) {
            this.lFk.postAtTime(runnable, this.nyU);
        }
    }

    public c(Resources resources, int i) {
        this(resources.openRawResourceFd(i));
    }

    public c(String str) {
        int i = 0;
        this.mIsRunning = true;
        this.nyF = false;
        this.nyH = null;
        this.nyI = new int[6];
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
        this.nyW = false;
        this.nyX = 0;
        this.nyY = 0;
        this.lFk = new af();
        this.nza = new Runnable(this) {
            final /* synthetic */ c nzg;

            {
                this.nzg = r1;
            }

            public final void run() {
            }
        };
        this.nzb = new 2(this);
        this.nzc = new Runnable(this) {
            final /* synthetic */ c nzg;

            {
                this.nzg = r1;
            }

            public final void run() {
                MMGIFJNI.restoreRemainder(this.nzg.nyG);
                this.nzg.e(this.nzg.nzb, this.nzg.nyR);
            }
        };
        this.nzd = new 4(this);
        this.nze = new Runnable(this) {
            final /* synthetic */ c nzg;

            {
                this.nzg = r1;
            }

            public final void run() {
                MMGIFJNI.saveRemainder(this.nzg.nyG);
            }
        };
        this.nzf = new Runnable(this) {
            final /* synthetic */ c nzg;

            {
                this.nzg = r1;
            }

            public final void run() {
                if (this.nzg.nyF) {
                    x.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (this.nzg.nyO + 1 > this.nzg.nyN - 1) {
                    this.nzg.nyO = -1;
                }
                this.nzg.nyO = this.nzg.nyO + 1;
                if (MMGIFJNI.drawFramePixels(this.nzg.nyG, this.nzg.nyM, this.nzg.nyI)) {
                    this.nzg.nyY = this.nzg.nyY + 1;
                }
                this.nzg.nyP = System.currentTimeMillis() - currentTimeMillis;
                if (this.nzg.nyQ != 0) {
                    this.nzg.nyR = (this.nzg.nyQ - this.nzg.nyP) - this.nzg.nyT;
                    if (this.nzg.nyR < 0) {
                        x.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[]{Long.valueOf(this.nzg.nyP), Long.valueOf(this.nzg.nyT), Long.valueOf(this.nzg.nyR), Long.valueOf(this.nzg.nyQ), Integer.valueOf(this.nzg.nyI[5])});
                        g.pQN.a(401, 0, 1, false);
                        g.pQN.a(401, 1, Math.abs(this.nzg.nyR), false);
                        if (this.nzg.nyR < -100) {
                            boolean z = HardCoderJNI.hcGifEnable || HardCoderJNI.hcGifFrameEnable;
                            HardCoderJNI.stopPerformace(z, this.nzg.hEF);
                            this.nzg.hEF = HardCoderJNI.startPerformance(HardCoderJNI.hcGifFrameEnable, HardCoderJNI.hcGifFrameDelay, HardCoderJNI.hcGifFrameCPU, HardCoderJNI.hcGifFrameIO, HardCoderJNI.hcGifFrameThr ? Process.myTid() : 0, HardCoderJNI.hcGifFrameTimeout, 602, HardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMGIFDrawable");
                        }
                    }
                }
                this.nzg.e(this.nzg.nzb, this.nzg.nyR > 0 ? this.nzg.nyR : 0);
                if (this.nzg.nyI[2] == 1) {
                    this.nzg.nyQ = 5000;
                } else {
                    this.nzg.nyQ = (long) this.nzg.nyI[4];
                }
            }
        };
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("file path is null.");
        }
        boolean z = HardCoderJNI.hcGifEnable;
        int i2 = HardCoderJNI.hcGifDelay;
        int i3 = HardCoderJNI.hcGifCPU;
        int i4 = HardCoderJNI.hcGifIO;
        if (HardCoderJNI.hcGifThr) {
            i = Process.myTid();
        }
        this.hEF = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcGifTimeout, 602, HardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.nyG = MMGIFJNI.openByFilePath(str, this.nyI);
        init();
    }

    private c(AssetFileDescriptor assetFileDescriptor) {
        int i = 0;
        this.mIsRunning = true;
        this.nyF = false;
        this.nyH = null;
        this.nyI = new int[6];
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
        this.nyW = false;
        this.nyX = 0;
        this.nyY = 0;
        this.lFk = new af();
        this.nza = /* anonymous class already generated */;
        this.nzb = new 2(this);
        this.nzc = /* anonymous class already generated */;
        this.nzd = new 4(this);
        this.nze = /* anonymous class already generated */;
        this.nzf = /* anonymous class already generated */;
        if (assetFileDescriptor == null) {
            throw new NullPointerException("assert file Descriptor is null.");
        }
        boolean z = HardCoderJNI.hcGifEnable;
        int i2 = HardCoderJNI.hcGifDelay;
        int i3 = HardCoderJNI.hcGifCPU;
        int i4 = HardCoderJNI.hcGifIO;
        if (HardCoderJNI.hcGifThr) {
            i = Process.myTid();
        }
        this.hEF = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcGifTimeout, 602, HardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.nyH = assetFileDescriptor;
        this.nyG = MMGIFJNI.openByFileDescroptor(this.nyH.getFileDescriptor(), assetFileDescriptor.getStartOffset(), this.nyI);
        init();
    }

    public c(InputStream inputStream) {
        int i = 0;
        this.mIsRunning = true;
        this.nyF = false;
        this.nyH = null;
        this.nyI = new int[6];
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
        this.nyW = false;
        this.nyX = 0;
        this.nyY = 0;
        this.lFk = new af();
        this.nza = /* anonymous class already generated */;
        this.nzb = new 2(this);
        this.nzc = /* anonymous class already generated */;
        this.nzd = new 4(this);
        this.nze = /* anonymous class already generated */;
        this.nzf = /* anonymous class already generated */;
        if (inputStream == null) {
            throw new NullPointerException("input stream is null.");
        }
        boolean z = HardCoderJNI.hcGifEnable;
        int i2 = HardCoderJNI.hcGifDelay;
        int i3 = HardCoderJNI.hcGifCPU;
        int i4 = HardCoderJNI.hcGifIO;
        if (HardCoderJNI.hcGifThr) {
            i = Process.myTid();
        }
        this.hEF = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcGifTimeout, 602, HardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.nyG = MMGIFJNI.openByInputStrem(inputStream, this.nyI);
        init();
    }

    public c(byte[] bArr) {
        int i = 0;
        this.mIsRunning = true;
        this.nyF = false;
        this.nyH = null;
        this.nyI = new int[6];
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
        this.nyW = false;
        this.nyX = 0;
        this.nyY = 0;
        this.lFk = new af();
        this.nza = /* anonymous class already generated */;
        this.nzb = new 2(this);
        this.nzc = /* anonymous class already generated */;
        this.nzd = new 4(this);
        this.nze = /* anonymous class already generated */;
        this.nzf = /* anonymous class already generated */;
        if (bArr == null) {
            throw new NullPointerException("bytes is null.");
        }
        boolean z = HardCoderJNI.hcGifEnable;
        int i2 = HardCoderJNI.hcGifDelay;
        int i3 = HardCoderJNI.hcGifCPU;
        int i4 = HardCoderJNI.hcGifIO;
        if (HardCoderJNI.hcGifThr) {
            i = Process.myTid();
        }
        this.hEF = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcGifTimeout, 602, HardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
        this.nyG = MMGIFJNI.openByByteArray(bArr, this.nyI);
        init();
    }

    private void init() {
        x.i("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", new Object[]{Long.valueOf(this.nyG)});
        this.nyN = this.nyI[2];
        this.nyV = a.aa(ac.getContext(), com.tencent.mm.plugin.m.a.c.lnJ);
        if (this.nyI[0] > 1024 || this.nyI[1] > 1024) {
            x.w("MicroMsg.GIF.MMGIFDrawable", "emoji width or height over size. Width:%d Height:%d", new Object[]{Integer.valueOf(this.nyI[0]), Integer.valueOf(this.nyI[1])});
            this.nyM = new int[(this.nyV * this.nyV)];
            this.nyW = true;
            g.pQN.a(401, 2, 1, false);
            return;
        }
        this.nyM = new int[(this.nyI[0] * this.nyI[1])];
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
        return (int) (((float) this.nyI[0]) * aSl());
    }

    public final int getIntrinsicHeight() {
        return (int) (((float) this.nyI[1]) * aSl());
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.nyL = true;
    }

    public final void draw(Canvas canvas) {
        if (this.nyL) {
            this.uk.set(getBounds());
            this.nyJ = ((float) this.uk.width()) / ((float) this.nyI[0]);
            this.nyK = ((float) this.uk.height()) / ((float) this.nyI[1]);
            this.nyL = false;
        }
        if (this.fC.getShader() == null) {
            if (this.nyS == 0) {
                this.nyS = System.currentTimeMillis();
            }
            canvas.scale(this.nyJ, this.nyK);
            int[] iArr = this.nyM;
            if (iArr == null) {
                x.e("MicroMsg.GIF.MMGIFDrawable", "colors is null.");
            } else if (iArr.length == this.nyI[0] * this.nyI[1]) {
                canvas.drawBitmap(iArr, 0, this.nyI[0], 0.0f, 0.0f, this.nyI[0], this.nyI[1], true, this.fC);
            } else {
                canvas.drawRGB(bs.CTRL_INDEX, bs.CTRL_INDEX, bs.CTRL_INDEX);
                x.w("MicroMsg.GIF.MMGIFDrawable", "colors is not equal width*height. length:%d width:%d height:%d", new Object[]{Integer.valueOf(iArr.length), Integer.valueOf(this.nyI[0]), Integer.valueOf(this.nyI[1])});
            }
            this.nyT = System.currentTimeMillis() - this.nyS;
            if (this.nyW || this.nyI[2] <= 0) {
                x.e("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post and oversize:%b", new Object[]{Integer.valueOf(this.nyI[2]), Integer.valueOf(this.nyI[4]), Boolean.valueOf(this.nyW)});
                return;
            }
            if (this.nyI[4] < 0) {
                x.i("MicroMsg.GIF.MMGIFDrawable", "current index error. start first frame");
            }
            if (this.nyX == 0 || this.nyY <= this.nyX - 1) {
                com.tencent.mm.ao.a.b(this.nzf, 0);
                return;
            } else {
                e(this.nza, 0);
                return;
            }
        }
        x.i("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ");
        canvas.drawRect(this.uk, this.fC);
    }

    public final int getOpacity() {
        return -2;
    }

    public final void setAlpha(int i) {
        this.fC.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.fC.setColorFilter(colorFilter);
    }

    public final boolean isRunning() {
        return this.mIsRunning;
    }

    public final void start() {
        this.mIsRunning = true;
        com.tencent.mm.ao.a.b(this.nzc, 0);
    }

    public final void stop() {
        boolean z = true;
        x.d("MicroMsg.GIF.MMGIFDrawable", "stop");
        this.mIsRunning = false;
        if (this.hEF != 0) {
            x.i("MicroMsg.GIF.MMGIFDrawable", "summerhardcoder stopPerformace startPerformance:%x ", new Object[]{Integer.valueOf(this.hEF)});
            if (!(HardCoderJNI.hcGifEnable || HardCoderJNI.hcGifFrameEnable)) {
                z = false;
            }
            HardCoderJNI.stopPerformace(z, this.hEF);
            this.hEF = 0;
        }
        com.tencent.mm.ao.a.b(this.nze, 300);
    }

    public final void reset() {
        this.nyF = false;
        this.mIsRunning = true;
        com.tencent.mm.ao.a.b(this.nzd, 300);
    }

    public final void recycle() {
        x.d("MicroMsg.GIF.MMGIFDrawable", "recycle");
        this.nyF = true;
        this.mIsRunning = false;
        long j = this.nyG;
        this.nyG = 0;
        MMGIFJNI.recycle(j);
        this.nyM = null;
        if (this.nyH != null) {
            try {
                this.nyH.close();
            } catch (Exception e) {
            }
        }
    }

    protected final void finalize() {
        try {
            recycle();
        } catch (Throwable th) {
            super.finalize();
        }
    }
}
