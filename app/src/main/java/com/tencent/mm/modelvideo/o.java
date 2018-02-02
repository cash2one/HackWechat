package com.tencent.mm.modelvideo;

import com.tencent.mm.ae.d.c;
import com.tencent.mm.ae.e;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.b;
import com.tencent.mm.z.p;
import java.io.File;
import java.util.HashMap;

public class o implements ap {
    private static HashMap<Integer, d> gwY;
    private static ag hVu = null;
    private static af hVv = null;
    private volatile u hVn = new u();
    private volatile s hVo;
    private volatile w hVp;
    private volatile a hVq = null;
    private volatile l hVr = null;
    private volatile k hVs = null;
    private volatile m hVt = null;
    private f hVw = null;
    private i hVx = null;

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("VIDEOINFO_TABLE".hashCode()), new 1());
        gwY.put(Integer.valueOf("VIDEOPLAYHISTORY_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return w.gJN;
            }
        });
        gwY.put(Integer.valueOf("SIGHTDRAFTSINFO_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return l.gJN;
            }
        });
    }

    public static o TT() {
        return (o) p.s(o.class);
    }

    public static s TU() {
        if (g.Dh().Cy()) {
            if (TT().hVo == null) {
                TT().hVo = new s(g.Dj().gQj);
            }
            return TT().hVo;
        }
        throw new b();
    }

    public static f TV() {
        g.Dh().Ct();
        if (TT().hVw == null) {
            TT().hVw = new f();
        }
        if ((com.tencent.mm.modelcdntran.g.MK().hsn == null ? 1 : null) != null) {
            com.tencent.mm.modelcdntran.g.MK().hsn = TT().hVw;
        }
        return TT().hVw;
    }

    public static i TW() {
        g.Dh().Ct();
        if (TT().hVx == null) {
            TT().hVx = new i();
        }
        return TT().hVx;
    }

    public static w TX() {
        if (g.Dh().Cy()) {
            if (TT().hVp == null) {
                TT().hVp = new w(g.Dj().gQj);
            }
            return TT().hVp;
        }
        throw new b();
    }

    public static synchronized l TY() {
        l lVar;
        synchronized (o.class) {
            if (g.Dh().Cy()) {
                if (TT().hVr == null) {
                    TT().hVr = new l(g.Dj().gQj);
                }
                lVar = TT().hVr;
            } else {
                throw new b();
            }
        }
        return lVar;
    }

    public static a TZ() {
        if (g.Dh().Cy()) {
            if (TT().hVq == null) {
                TT().hVq = new a();
            }
            return TT().hVq;
        }
        throw new b();
    }

    public static m Ua() {
        if (g.Dh().Cy()) {
            if (TT().hVt == null) {
                TT().hVt = new m();
            }
            return TT().hVt;
        }
        throw new b();
    }

    private static void Ub() {
        boolean z = false;
        if (hVv == null || hVu == null) {
            String str = "MicroMsg.SubCoreVideo";
            String str2 = "check decoder thread available fail, handler[%B] thread[%B] stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(hVv != null);
            if (hVu != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = bh.cgy();
            x.w(str, str2, objArr);
            if (hVv != null) {
                hVv.removeCallbacksAndMessages(null);
            }
            if (hVu != null) {
                hVu.a(null);
            } else {
                hVu = new ag("Short-Video-Decoder-Thread-" + System.currentTimeMillis());
            }
            hVv = new af(hVu.oAt.getLooper());
        }
    }

    public static boolean c(Runnable runnable, long j) {
        if (runnable == null) {
            return false;
        }
        Ub();
        if (j > 0) {
            hVv.postDelayed(runnable, j);
        } else {
            hVv.post(runnable);
        }
        return true;
    }

    public static boolean k(Runnable runnable) {
        if (runnable == null) {
            return true;
        }
        Ub();
        if (hVv == null) {
            x.e("MicroMsg.SubCoreVideo", "short video decoder handler is null");
            return false;
        }
        hVv.removeCallbacks(runnable);
        return true;
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreVideo", "%d onAccountRelease ", new Object[]{Integer.valueOf(hashCode())});
        try {
            if (TT().hVq != null) {
                e eVar = TT().hVq;
                eVar.flT = 0;
                if (eVar.hWr != null) {
                    g.CG().c(eVar.hWr);
                }
                if (eVar.hWs != null) {
                    g.CG().c(eVar.hWs);
                }
                g.CG().b(com.tencent.mm.plugin.appbrand.jsapi.g.f.CTRL_INDEX, eVar);
                g.CG().b(150, eVar);
            }
            if (TT().hVt != null) {
                m mVar = TT().hVt;
                mVar.flT = 0;
                x.i("MicroMsg.SightMassSendService", "stop, cur cdn client id %s", new Object[]{mVar.hUR});
                if (!bh.ov(mVar.hUR)) {
                    com.tencent.mm.modelcdntran.g.MJ().kH(mVar.hUR);
                }
            }
            if (TT().hVx != null) {
                i iVar = TT().hVx;
                iVar.stopDownload();
                iVar.hUB.clear();
            }
            if (TT().hVw != null) {
                g.CG().b(379, TT().hVw);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SubCoreVideo", e, "", new Object[0]);
        }
        c.b(Integer.valueOf(43), this.hVn);
        c.b(Integer.valueOf(44), this.hVn);
        c.b(Integer.valueOf(62), this.hVn);
        if (hVv != null) {
            hVv.removeCallbacksAndMessages(null);
        }
        try {
            a TZ = TZ();
            x.i("MicroMsg.VideoService", "quitVideoSendThread: %s", new Object[]{TZ.hWl});
            if (TZ.hWl != null) {
                try {
                    TZ.hWl.quit();
                    TZ.hWn = false;
                    TZ.hWm = null;
                    TZ.hWl = null;
                } catch (Exception e2) {
                    x.e("MicroMsg.VideoService", "quitVideoSendThread error: %s", new Object[]{e2.getMessage()});
                }
            }
        } catch (Exception e22) {
            x.e("MicroMsg.SubCoreVideo", "onAccountRelease, quitVideoSendThread error: %s", new Object[]{e22.getMessage()});
        }
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        x.i("MicroMsg.SubCoreVideo", "%d onAccountPostReset ", new Object[]{Integer.valueOf(hashCode())});
        c.a(Integer.valueOf(43), this.hVn);
        c.a(Integer.valueOf(44), this.hVn);
        c.a(Integer.valueOf(62), this.hVn);
        if (hVv != null) {
            hVv.removeCallbacksAndMessages(null);
        }
        g.Dm().F(new 4(this));
        File file = new File(k.TO());
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
    }

    public static String getAccVideoPath() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dk();
        return stringBuilder.append(g.Dj().gQi).append("video/").toString();
    }

    public final void br(boolean z) {
    }
}
