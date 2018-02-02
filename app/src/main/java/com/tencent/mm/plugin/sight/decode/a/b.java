package com.tencent.mm.plugin.sight.decode.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.memory.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class b {
    private static HashMap<String, WeakReference<Bitmap>> qtI = new HashMap();
    private static Map<String, Integer> qtM = new ConcurrentHashMap();
    private boolean hLV = false;
    private af lFk;
    private Surface mSurface;
    public boolean nDu = true;
    public int position;
    public volatile i qtA;
    private volatile c qtB;
    private k qtC;
    private j qtD;
    private d qtE;
    public boolean qtF = true;
    public boolean qtG = true;
    public boolean qtH = false;
    public boolean qtJ = false;
    public double qtK = -1.0d;
    boolean qtL = false;
    public double qtN = -1.0d;
    private boolean qtO = false;
    public boolean qtP = false;
    private a qtQ;
    public e qtR;
    public f qtS;
    public g qtT;
    private int qtj = 0;
    private int qtk = 0;
    public String qtl = "";
    private String qtm = "";
    private int qtn = -1;
    protected int qto = 41;
    private Bitmap qtp;
    public Bitmap qtq;
    private Bitmap qtr;
    private WeakReference<View> qts;
    private WeakReference<TextView> qtt;
    private long qtu;
    public WeakReference<View> qtv;
    private Animation qtw;
    private Animation qtx;
    private volatile h qty;
    private volatile b qtz;

    public interface e {
        void d(b bVar, int i);
    }

    public interface g {
        int bsR();

        View bsS();

        int bsT();
    }

    private class i implements Runnable {
        double qtN;
        final /* synthetic */ b qtU;
        MediaPlayer que;
        public int type;

        private i(b bVar) {
            this.qtU = bVar;
            this.qtN = -1.0d;
        }

        private void bdm() {
            x.i("MicroMsg.SightPlayController", "stopPlayer");
            try {
                if (this.que != null) {
                    this.que.stop();
                    this.que.release();
                    this.que = null;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SightPlayController", e, "stop play sound error: %s", new Object[]{e.getMessage()});
                this.que = null;
            }
        }

        public final double bsU() {
            if (this.que == null) {
                return 0.0d;
            }
            return (double) this.que.getCurrentPosition();
        }

        public final void run() {
            String str;
            String str2 = "MicroMsg.SightPlayController";
            String str3 = "do play sound, operation %s";
            Object[] objArr = new Object[1];
            switch (this.type) {
                case 0:
                    str = "stop";
                    break;
                case 1:
                    str = "start";
                    break;
                case 2:
                    str = "pause";
                    break;
                case 3:
                    str = "resume";
                    break;
                case 4:
                    str = "seek";
                    break;
                default:
                    str = "unknown";
                    break;
            }
            objArr[0] = str;
            x.i(str2, str3, objArr);
            switch (this.type) {
                case 0:
                    bdm();
                    return;
                case 1:
                    bdm();
                    if (!bh.ov(this.qtU.qtl)) {
                        try {
                            this.que = new com.tencent.mm.compatible.b.j();
                            this.que.setDisplay(null);
                            this.que.reset();
                            this.que.setDataSource(this.qtU.qtl);
                            this.que.setAudioStreamType(3);
                            this.que.setOnErrorListener(new 1(this));
                            this.que.prepare();
                            this.que.start();
                            return;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.SightPlayController", e, "play sound error: %s", new Object[]{e.getMessage()});
                            x.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", new Object[]{this.qtU.qtl});
                            this.qtU.clear();
                            if (this.qtU.qtR != null) {
                                this.qtU.qtR.d(this.qtU, -1);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                case 2:
                    try {
                        if (this.que != null && this.que.isPlaying()) {
                            this.que.pause();
                            return;
                        }
                        return;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.SightPlayController", e2, "pause sound error: %s", new Object[]{e2.getMessage()});
                        bdm();
                        return;
                    }
                case 3:
                    try {
                        if (this.que != null) {
                            this.que.start();
                            return;
                        }
                        return;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.SightPlayController", e22, "pause sound error: %s", new Object[]{e22.getMessage()});
                        bdm();
                        return;
                    }
                case 4:
                    try {
                        x.i("MicroMsg.SightPlayController", "soundplayer seek %f", new Object[]{Double.valueOf(this.qtN)});
                        this.que.seekTo((int) (this.qtN * 1000.0d));
                        return;
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.SightPlayController", e222, "seek sound error: %s", new Object[]{e222.getMessage()});
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private class j implements Runnable {
        final /* synthetic */ b qtU;

        private j(b bVar) {
            this.qtU = bVar;
        }

        public final void run() {
            if (this.qtU.qtn >= 0 && this.qtU.qtt != null && this.qtU.qtt.get() != null) {
                ((TextView) this.qtU.qtt.get()).setText(SightVideoJNI.getVideoInfo(this.qtU.qtn));
            }
        }
    }

    private class k implements Runnable {
        final /* synthetic */ b qtU;
        WeakReference<Bitmap> qug;

        private k(b bVar) {
            this.qtU = bVar;
            this.qug = new WeakReference(null);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            View view = null;
            boolean z = true;
            String str;
            View view2;
            if (this.qtU.mSurface == null || !this.qtU.mSurface.isValid()) {
                boolean z2;
                str = "MicroMsg.SightPlayController";
                String str2 = "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B";
                Object[] objArr = new Object[6];
                objArr[0] = Integer.valueOf(this.qtU.hashCode());
                objArr[1] = Integer.valueOf(hashCode());
                objArr[2] = Boolean.valueOf(this.qtU.mSurface == null);
                if (this.qtU.qts == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[3] = Boolean.valueOf(z2);
                if (this.qug.get() == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[4] = Boolean.valueOf(z2);
                if (this.qtU.qtq == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[5] = Boolean.valueOf(z2);
                x.w(str, str2, objArr);
                if (this.qtU.qtq == null) {
                    Bitmap bitmap = (Bitmap) this.qug.get();
                    if (this.qtU.qts != null) {
                        view = (View) this.qtU.qts.get();
                    }
                    if (view == null || bitmap == null || bitmap.isRecycled()) {
                        boolean z3;
                        str = "MicroMsg.SightPlayController";
                        str2 = "bgView:%B, thumb:%B";
                        objArr = new Object[2];
                        if (view == null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        objArr[0] = Boolean.valueOf(z3);
                        if (bitmap != null) {
                            z = false;
                        }
                        objArr[1] = Boolean.valueOf(z);
                        x.e(str, str2, objArr);
                        return;
                    }
                    view.post(new 1(this, view, bitmap));
                    return;
                }
                if (!(this.qtU.qtr != null && this.qtU.qtr.getWidth() == this.qtU.qtq.getWidth() && this.qtU.qtr.getHeight() == this.qtU.qtq.getHeight())) {
                    try {
                        this.qtU.qtr = Bitmap.createBitmap(this.qtU.qtq.getWidth(), this.qtU.qtq.getHeight(), Config.ARGB_8888);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SightPlayController", e, "try to create thumb bmp error:%s", new Object[]{e.getMessage()});
                        this.qtU.qtr = null;
                    }
                }
                if (this.qtU.qtr == null || this.qug.get() == null || ((Bitmap) this.qug.get()).isRecycled()) {
                    String str3 = "MicroMsg.SightPlayController";
                    str = "mThubmBgBmp:%B, thumbRef:%B";
                    Object[] objArr2 = new Object[2];
                    if (this.qtU.qtr == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr2[0] = Boolean.valueOf(z2);
                    if (this.qug.get() != null) {
                        z = false;
                    }
                    objArr2[1] = Boolean.valueOf(z);
                    x.e(str3, str, objArr2);
                    return;
                }
                long nanoTime = System.nanoTime();
                SightVideoJNI.handleThumb((Bitmap) this.qug.get(), this.qtU.qtr, this.qtU.qtq);
                x.i("MicroMsg.SightPlayController", "handle thumb use %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
                final Bitmap p = this.qtU.qtr;
                if (this.qtU.qts != null) {
                    view2 = (View) this.qtU.qts.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && p != null) {
                    view2.post(new Runnable(this) {
                        final /* synthetic */ k quj;

                        public final void run() {
                            view2.setBackgroundDrawable(new BitmapDrawable(p));
                        }
                    });
                    return;
                }
                return;
            }
            str3 = "MicroMsg.SightPlayController";
            str = "#0x%x-#0x%x draw thumb, thumb empty ? %B";
            objArr2 = new Object[3];
            objArr2[0] = Integer.valueOf(this.qtU.hashCode());
            objArr2[1] = Integer.valueOf(hashCode());
            objArr2[2] = Boolean.valueOf(this.qug.get() == null);
            x.d(str3, str, objArr2);
            if (this.qtU.qts != null) {
                view2 = (View) this.qtU.qts.get();
                if (view2 != null) {
                    view2.post(new 3(this, view2));
                }
            }
            if (this.qug.get() == null) {
                SightVideoJNI.drawSurfaceColor(this.qtU.mSurface, 0);
            } else {
                SightVideoJNI.drawSurfaceThumb(this.qtU.mSurface, (Bitmap) this.qug.get(), this.qtU.qtq);
            }
        }
    }

    public abstract void D(Bitmap bitmap);

    public abstract void cg(int i, int i2);

    static /* synthetic */ void A(b bVar) {
        if (bVar.qtv != null && -1 != bVar.bsJ() && bVar.qtF) {
            if (bVar.qtw == null && bVar.qtv.get() != null) {
                bVar.qtw = AnimationUtils.loadAnimation(((View) bVar.qtv.get()).getContext(), bVar.bsJ());
            }
            if (bVar.qtE == null) {
                bVar.qtE = new d(bVar, (byte) 0);
            }
            bVar.lFk.post(bVar.qtE);
        }
    }

    static /* synthetic */ void a(b bVar, int i, int i2) {
        x.d("MicroMsg.SightPlayController", "#0x%x check bmp, video width %d, height %d", new Object[]{Integer.valueOf(bVar.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (bVar.qtp == null) {
            bVar.qtp = o.han.a(new com.tencent.mm.memory.o.b(i, i2));
            x.j("MicroMsg.SightPlayController", "checkBmp, create new one, videoPath: %s", new Object[]{bVar.qtl});
        } else if (bVar.qtp.getWidth() != i || bVar.qtp.getHeight() != i2) {
            int i3;
            x.w("MicroMsg.SightPlayController", "reset bmp, old value " + bVar.qtp.getWidth() + "*" + bVar.qtp.getHeight());
            if (!d.fM(19) || bVar.qtp.getAllocationByteCount() < (i2 * i) * 4) {
                i3 = 0;
            } else {
                try {
                    x.w("MicroMsg.SightPlayController", "reset bmp, try directly reconfigure");
                    bVar.qtp.reconfigure(i, i2, Config.ARGB_8888);
                    i3 = 1;
                } catch (Exception e) {
                    x.e("MicroMsg.SightPlayController", "reconfigure failed: %s" + e.getMessage());
                    i3 = 0;
                }
            }
            if (i3 == 0) {
                o.han.g(bVar.qtp);
                bVar.qtp = o.han.a(new com.tencent.mm.memory.o.b(i, i2));
            }
            x.j("MicroMsg.SightPlayController", "checkBmp, the origin bmp size not match, create new one, videoPath: %s", new Object[]{bVar.qtl});
        }
    }

    public static Bitmap b(Context context, int i, int i2, int i3, int i4) {
        String format = String.format("%s-%s-%s-%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        WeakReference weakReference = (WeakReference) qtI.get(format);
        if (weakReference != null && weakReference.get() != null) {
            return (Bitmap) weakReference.get();
        }
        if (context == null) {
            x.w("MicroMsg.SightPlayController", "get mask bmp, but context is null");
            return null;
        } else if (i <= 0) {
            x.w("MicroMsg.SightPlayController", "get mask bmp, but mask id error");
            return null;
        } else if (i2 <= 0 || i4 <= 0 || i3 <= 0) {
            x.w("MicroMsg.SightPlayController", "get mask bmp, but size error");
            return null;
        } else {
            long Wq = bh.Wq();
            int i5 = (i2 * i4) / i3;
            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) context.getResources().getDrawable(i);
            ninePatchDrawable.setBounds(0, 0, i2, i5);
            Bitmap createBitmap = Bitmap.createBitmap(i2, i5, Config.ARGB_8888);
            ninePatchDrawable.draw(new Canvas(createBitmap));
            qtI.put(format, new WeakReference(createBitmap));
            x.d("MicroMsg.SightPlayController", "create mask bmp use %dms", new Object[]{Long.valueOf(bh.bA(Wq))});
            return createBitmap;
        }
    }

    public static void Es() {
        com.tencent.mm.modelvideo.o.c(new 1(), 0);
    }

    public b(int i, View view) {
        this.qtk = i;
        this.lFk = new af(Looper.getMainLooper());
        this.qtv = new WeakReference(view);
        x.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", new Object[]{Integer.valueOf(i)});
    }

    public int bsJ() {
        return -1;
    }

    public final void hZ(boolean z) {
        if (this.qty != null) {
            com.tencent.mm.modelvideo.o.k(this.qty);
            this.qty.otH = true;
        }
        if (this.qtB != null) {
            this.lFk.removeCallbacks(this.qtB);
            this.qtB.otH = true;
        }
        if (this.qtz != null) {
            com.tencent.mm.modelvideo.o.k(this.qtz);
            this.qtz.otH = true;
        }
        if (this.qtA != null) {
            this.qtA.type = z ? 0 : 2;
            com.tencent.mm.modelvideo.o.c(this.qtA, 0);
        }
    }

    public final boolean bsK() {
        if (1 == this.qtk) {
            if (this.qtz == null || this.qtz.otH) {
                return false;
            }
            return true;
        } else if (this.qtB == null || this.qtB.otH || this.qtz == null || this.qtz.otH) {
            return false;
        } else {
            return true;
        }
    }

    public final void restart() {
        x.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.qtG), this.qtl, Integer.valueOf(this.qtn)});
        if (!this.qtG) {
            clear();
        } else if (bsK()) {
            x.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", new Object[]{Integer.valueOf(hashCode()), this.qtl});
        } else {
            boolean z;
            if (this.qtn < 0) {
                z = true;
            } else {
                z = false;
            }
            hZ(z);
            this.qtu = 0;
            if (bsL()) {
                x.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", new Object[]{Integer.valueOf(hashCode())});
            } else if (this.qtn < 0) {
                x.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", new Object[]{Integer.valueOf(hashCode()), this.qtl});
                if (!bh.ov(this.qtl)) {
                    if (Jt(this.qtl)) {
                        this.qty = new h(this, (byte) 0);
                        com.tencent.mm.modelvideo.o.c(this.qty, 0);
                        return;
                    }
                    x.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                    clear();
                }
            } else if (1 == this.qtk) {
                this.qtz = new b(this, (byte) 0);
                this.qtB = null;
                com.tencent.mm.modelvideo.o.c(this.qtz, 0);
            } else {
                this.qtz = new b(this, (byte) 0);
                this.qtB = new c(this);
                this.qtz.qtZ = this.qtB;
                this.qtB.qud = this.qtz;
                com.tencent.mm.modelvideo.o.c(this.qtz, 0);
            }
        }
    }

    public final void clear() {
        x.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.qtn), Boolean.valueOf(bsK())});
        hZ(true);
        this.qtu = 0;
        wk(this.qtn);
        this.qtn = -1;
        this.qtl = "";
        this.qtm = "ERROR#PATH";
        this.qtr = null;
        this.qtK = 0.0d;
        this.qtL = false;
        o.han.g(this.qtp);
        this.qtp = null;
    }

    private void wk(int i) {
        com.tencent.mm.modelvideo.o.c(new 2(this, i), 0);
    }

    public final void aA(String str, boolean z) {
        x.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[]{Integer.valueOf(hashCode()), str, this.qtl, Boolean.valueOf(z), Integer.valueOf(this.qtn), Boolean.valueOf(this.qtP), Boolean.valueOf(this.qtG)});
        if (this.qtP) {
            hZ(false);
        } else if (bsL()) {
            x.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
            clear();
        } else if (!this.qtG) {
            clear();
        } else if (z) {
            this.qtm = str;
            hZ(false);
        } else if (this.qtl.equals(str)) {
            this.qtm = "ERROR#PATH";
            hZ(false);
            restart();
        } else {
            clear();
            if (str == null) {
                str = "";
            }
            this.qtl = str;
            if (bh.ov(this.qtl)) {
                x.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
                C(null);
            } else if (Jt(this.qtl)) {
                this.qty = new h(this, (byte) 0);
                com.tencent.mm.modelvideo.o.c(this.qty, 0);
            } else {
                x.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                clear();
            }
        }
    }

    public static boolean Jt(String str) {
        if (bh.ov(str)) {
            return false;
        }
        Integer num = (Integer) qtM.get(str);
        if (num == null || 2 != num.intValue()) {
            return true;
        }
        return false;
    }

    public final boolean bsL() {
        if (this.qtJ) {
            return false;
        }
        if (VERSION.SDK_INT >= 11) {
            if (this.qtj < 3) {
                return false;
            }
            x.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
            this.qtj = 0;
            return false;
        } else if (this.qtj >= 3) {
            return true;
        } else {
            return false;
        }
    }

    protected final void bsM() {
        this.qto = 1000 / Math.max(1, (int) SightVideoJNI.getVideoRate(this.qtn));
        x.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(r0), Integer.valueOf(this.qto)});
    }

    public final void d(Surface surface) {
        x.v("MicroMsg.SightPlayController", "set play surface %s", new Object[]{surface});
        this.mSurface = surface;
        com.tencent.mm.modelvideo.o.c(this.qtC, 0);
    }

    public final void h(TextView textView) {
        this.qtt = new WeakReference(textView);
    }

    public final void C(Bitmap bitmap) {
        boolean z = true;
        String str = "MicroMsg.SightPlayController";
        String str2 = "draw surface thumb, thumb is null ? %B";
        Object[] objArr = new Object[1];
        if (bitmap != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        com.tencent.mm.modelvideo.o.k(this.qtC);
        if (this.qtC == null) {
            this.qtC = new k();
        }
        this.qtC.qug = new WeakReference(bitmap);
        com.tencent.mm.modelvideo.o.c(this.qtC, 0);
    }

    public final c bsN() {
        if (this.qtQ == null) {
            this.qtQ = new a(this);
        }
        return this.qtQ;
    }

    public final double bsO() {
        if (this.qtn == -1) {
            return 0.0d;
        }
        return SightVideoJNI.getVideoDuration(this.qtn);
    }
}
