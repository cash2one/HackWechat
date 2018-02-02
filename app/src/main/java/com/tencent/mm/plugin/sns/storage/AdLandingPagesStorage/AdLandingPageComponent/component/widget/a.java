package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.memory.o;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a {
    private static HashMap<String, WeakReference<Bitmap>> qtI = new HashMap();
    private static Map<String, Integer> qtM = new ConcurrentHashMap();
    private boolean hLV;
    private af lFk;
    private Surface mSurface;
    boolean nDu;
    private int position;
    boolean qtG;
    public boolean qtH;
    public boolean qtJ;
    double qtK;
    boolean qtL;
    double qtN;
    private boolean qtO;
    boolean qtP;
    private int qtj;
    private int qtk;
    String qtl;
    String qtm;
    int qtn;
    protected int qto;
    private Bitmap qtp;
    private Bitmap qtq;
    private Bitmap qtr;
    private WeakReference<View> qts;
    private WeakReference<TextView> qtt;
    private long qtu;
    private WeakReference<View> qtv;
    private Animation qtw;
    private Animation qtx;
    volatile h rlZ;
    private volatile b rma;
    volatile i rmb;
    private volatile c rmc;
    private k rmd;
    private j rme;
    private d rmf;
    private a rmg;
    e rmh;
    f rmi;
    private g rmj;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ double qtV;
        final /* synthetic */ a rmk;

        AnonymousClass2(a aVar, double d) {
            this.rmk = aVar;
            this.qtV = d;
        }

        public final void run() {
            x.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", Double.valueOf(this.qtV), bh.cgy().toString());
            this.rmk.qtN = this.qtV;
        }
    }

    public abstract void D(Bitmap bitmap);

    public abstract void cg(int i, int i2);

    static /* synthetic */ void A(a aVar) {
        if (aVar.qtv != null && -1 != aVar.bsJ()) {
            if (aVar.qtw == null && aVar.qtv.get() != null) {
                aVar.qtw = AnimationUtils.loadAnimation(((View) aVar.qtv.get()).getContext(), aVar.bsJ());
            }
            if (aVar.rmf == null) {
                aVar.rmf = new d(aVar, (byte) 0);
            }
            aVar.lFk.post(aVar.rmf);
        }
    }

    static /* synthetic */ void a(a aVar, int i, int i2) {
        x.d("MicroMsg.SightPlayController", "#0x%x check bmp, video width %d, height %d", Integer.valueOf(aVar.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (aVar.qtp == null) {
            aVar.qtp = o.han.a(new b(i, i2));
            x.j("MicroMsg.SightPlayController", "checkBmp, create new one, videoPath: %s", aVar.qtl);
        } else if (aVar.qtp.getWidth() != i || aVar.qtp.getHeight() != i2) {
            int i3;
            x.w("MicroMsg.SightPlayController", "reset bmp, old value " + aVar.qtp.getWidth() + "*" + aVar.qtp.getHeight());
            if (!d.fM(19) || aVar.qtp.getAllocationByteCount() < (i2 * i) * 4) {
                i3 = 0;
            } else {
                try {
                    x.w("MicroMsg.SightPlayController", "reset bmp, try directly reconfigure");
                    aVar.qtp.reconfigure(i, i2, Config.ARGB_8888);
                    i3 = 1;
                } catch (Exception e) {
                    x.e("MicroMsg.SightPlayController", "reconfigure failed: %s" + e.getMessage());
                    i3 = 0;
                }
            }
            if (i3 == 0) {
                o.han.g(aVar.qtp);
                aVar.qtp = o.han.a(new b(i, i2));
            }
            x.j("MicroMsg.SightPlayController", "checkBmp, the origin bmp size not match, create new one, videoPath: %s", aVar.qtl);
        }
    }

    public a(int i, View view) {
        this.hLV = false;
        this.qtj = 0;
        this.qtk = 0;
        this.qtl = "";
        this.qtm = "";
        this.qtn = -1;
        this.qto = 41;
        this.qtG = true;
        this.qtH = false;
        this.qtJ = false;
        this.nDu = true;
        this.qtK = -1.0d;
        this.qtL = false;
        this.qtN = -1.0d;
        this.qtO = false;
        this.qtP = false;
        this.qtk = 0;
        this.lFk = new af(Looper.getMainLooper());
        this.qtv = new WeakReference(view);
        x.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", Integer.valueOf(0));
    }

    protected int bsJ() {
        return -1;
    }

    public final void hZ(boolean z) {
        if (this.rlZ != null) {
            com.tencent.mm.modelvideo.o.k(this.rlZ);
            this.rlZ.otH = true;
        }
        if (this.rmc != null) {
            this.lFk.removeCallbacks(this.rmc);
            this.rmc.otH = true;
        }
        if (this.rma != null) {
            com.tencent.mm.modelvideo.o.k(this.rma);
            this.rma.otH = true;
        }
        if (this.rmb != null) {
            this.rmb.type = z ? 0 : 2;
            com.tencent.mm.modelvideo.o.c(this.rmb, 0);
        }
    }

    public final boolean bsK() {
        if (1 == this.qtk) {
            if (this.rma == null || this.rma.otH) {
                return false;
            }
            return true;
        } else if (this.rmc == null || this.rmc.otH || this.rma == null || this.rma.otH) {
            return false;
        } else {
            return true;
        }
    }

    public final void restart() {
        x.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.qtG), this.qtl, Integer.valueOf(this.qtn));
        if (!this.qtG) {
            clear();
        } else if (bsK()) {
            x.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", Integer.valueOf(hashCode()), this.qtl);
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
                x.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", Integer.valueOf(hashCode()));
            } else if (this.qtn < 0) {
                x.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", Integer.valueOf(hashCode()), this.qtl);
                if (!bh.ov(this.qtl)) {
                    if (Jt(this.qtl)) {
                        this.rlZ = new h(this, (byte) 0);
                        com.tencent.mm.modelvideo.o.c(this.rlZ, 0);
                        return;
                    }
                    x.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                    clear();
                }
            } else if (1 == this.qtk) {
                this.rma = new b(this, (byte) 0);
                this.rmc = null;
                com.tencent.mm.modelvideo.o.c(this.rma, 0);
            } else {
                this.rma = new b(this, (byte) 0);
                this.rmc = new c(this);
                this.rma.rml = this.rmc;
                this.rmc.rmn = this.rma;
                com.tencent.mm.modelvideo.o.c(this.rma, 0);
            }
        }
    }

    public final void clear() {
        x.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", Integer.valueOf(hashCode()), Integer.valueOf(this.qtn), Boolean.valueOf(bsK()));
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
        com.tencent.mm.modelvideo.o.c(new 1(this, i), 0);
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

    final boolean bsL() {
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
        x.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", Integer.valueOf(hashCode()), Integer.valueOf(r0), Integer.valueOf(this.qto));
    }

    public final void bxx() {
        x.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", Boolean.valueOf(true));
        com.tencent.mm.modelvideo.o.k(this.rmd);
        if (this.rmd == null) {
            this.rmd = new k(this, (byte) 0);
        }
        this.rmd.qug = new WeakReference(null);
        com.tencent.mm.modelvideo.o.c(this.rmd, 0);
    }

    public final c bsN() {
        if (this.rmg == null) {
            this.rmg = new a(this);
        }
        return this.rmg;
    }
}
