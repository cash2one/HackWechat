package com.tencent.mm.z;

import android.content.SharedPreferences;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.h;
import com.tencent.mm.storage.j;
import com.tencent.mm.storage.l;
import com.tencent.mm.storage.n;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.p;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.b.b;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;

public final class c {
    public static HashMap<Integer, d> gwY;
    public bj heA;
    h heB;
    com.tencent.mm.z.b.c heC;
    com.tencent.mm.z.b.d heD;
    ap heE;
    j heF;
    n heG;
    l heH;
    b heI;
    public bk hez;

    public c() {
        g.Dk();
        e Dj = g.Dj();
        Dj.gQf.aE(new 1(this));
        com.tencent.mm.kernel.a.c.Dt().add(new 3(this));
        com.tencent.mm.kernel.a.c.Dt().add(new f(this) {
            final /* synthetic */ c heJ;

            {
                this.heJ = r1;
            }

            public final void Dp() {
                ar.Hf();
            }

            public final void fN(String str) {
                if (com.tencent.mm.compatible.util.f.ze()) {
                    g.Dk();
                    if (g.Dj().gQh.equals(com.tencent.mm.compatible.util.e.bnF)) {
                        g.Dk();
                        com.tencent.mm.sdk.f.e.post(new b(g.Dj().cachePath, str), "AccountStorage_moveDataFiles");
                    }
                }
            }
        });
    }

    public static int Cg() {
        g.Dk();
        g.Dh();
        return a.Cg();
    }

    public static String ER() {
        g.Dk();
        return g.Dj().gQh;
    }

    public static void CW() {
        g.Dk();
        g.Dj().CW();
    }

    public static boolean isSDCardAvailable() {
        g.Dk();
        return g.Dj().isSDCardAvailable();
    }

    public static String CQ() {
        g.Dk();
        return g.Dj().CQ();
    }

    public static void ES() {
        g.Dk();
        g.Dj().eb(null);
    }

    public static void a(ao aoVar) {
        g.Dk();
        a Dh = g.Dh();
        x.i("MMKernel.CoreAccount", "UserStatusChange: add %s", new Object[]{aoVar});
        synchronized (Dh.gPu) {
            if (!Dh.gPu.contains(aoVar)) {
                Dh.gPu.add(aoVar);
            }
        }
    }

    public static void b(ao aoVar) {
        g.Dk();
        a Dh = g.Dh();
        x.i("MMKernel.CoreAccount", "UserStatusChange: remove %s", new Object[]{aoVar});
        synchronized (Dh.gPu) {
            Dh.gPu.remove(aoVar);
        }
    }

    public static void Cu() {
        g.Dk();
        g.Dh().Cu();
    }

    public static boolean ET() {
        g.Dk();
        return a.gB(g.Dh().gPs);
    }

    public static boolean gB(int i) {
        return a.gB(i);
    }

    public static int EU() {
        g.Dk();
        return g.Dh().gPt;
    }

    public static com.tencent.mm.by.h EV() {
        g.Dk();
        return g.Dj().gQj;
    }

    public static com.tencent.mm.by.h EW() {
        g.Dk();
        return g.Dj().gQk;
    }

    public static SharedPreferences fL(String str) {
        g.Dk();
        return g.Dj().fL(str);
    }

    public static t CU() {
        g.Dk();
        return g.Dj().CU();
    }

    public static be CV() {
        g.Dk();
        return g.Dj().CV();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.d EX() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EX();
    }

    public static ar EY() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.g EZ() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EZ();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.c Fa() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi();
    }

    public static o Fb() {
        return ((com.tencent.mm.ag.o) g.h(com.tencent.mm.ag.o.class)).Fb();
    }

    public static p Fc() {
        return ((com.tencent.mm.ag.o) g.h(com.tencent.mm.ag.o.class)).Fc();
    }

    public static as Fd() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fd();
    }

    public static com.tencent.mm.plugin.downloader.e.b Fe() {
        return ((com.tencent.mm.plugin.downloader.b.a) g.h(com.tencent.mm.plugin.downloader.b.a.class)).Fe();
    }

    public static at Ff() {
        return ((com.tencent.mm.plugin.r.a.a) g.h(com.tencent.mm.plugin.r.a.a.class)).Ff();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.f Fg() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fg();
    }

    public static ae Fh() {
        g.Dk();
        g.Dh().Ct();
        return ((com.tencent.mm.plugin.chatroom.b.b) g.h(com.tencent.mm.plugin.chatroom.b.b.class)).Fh();
    }

    public static String Fi() {
        return com.tencent.mm.plugin.n.c.Fi();
    }

    public static String Fj() {
        return com.tencent.mm.plugin.n.c.Fj();
    }

    public static String Fk() {
        return com.tencent.mm.plugin.ad.a.Fk();
    }

    public static String Fl() {
        return q.Fl();
    }

    public static String Fm() {
        return q.Fm();
    }

    public static String Fn() {
        return com.tencent.mm.plugin.record.b.Fn();
    }

    public static String Fo() {
        return u.Fo();
    }

    public static String Fp() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dk();
        return stringBuilder.append(g.Dj().gQi).append("emoji/").toString();
    }

    public static String Fq() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dk();
        return stringBuilder.append(g.Dj().gQi).append("mailapp/").toString();
    }

    public static String getAccVideoPath() {
        com.tencent.mm.modelvideo.o.TT();
        return com.tencent.mm.modelvideo.o.getAccVideoPath();
    }

    public static String Fr() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dk();
        return stringBuilder.append(g.Dj().gQi).append("image/shakeTranImg/").toString();
    }

    public static String Fs() {
        return com.tencent.mm.plugin.l.a.Fs();
    }

    public static String Ft() {
        return com.tencent.mm.plugin.y.a.Ft();
    }

    public static String Fu() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dk();
        return stringBuilder.append(g.Dj().gQi).append("attachment/").toString();
    }

    public static String Fv() {
        return ((com.tencent.mm.ag.o) g.h(com.tencent.mm.ag.o.class)).Fv();
    }

    public static String Fw() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dk();
        return stringBuilder.append(g.Dj().gQi).append("record/").toString();
    }

    public static String Fx() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dk();
        return stringBuilder.append(g.Dj().gQi).append("draft/").toString();
    }

    public static String getAccSnsPath() {
        return ((com.tencent.mm.plugin.sns.b.b) g.k(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath();
    }

    public static String getAccSnsTmpPath() {
        return ((com.tencent.mm.plugin.sns.b.b) g.k(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath();
    }

    public static String Fy() {
        return com.tencent.mm.plugin.n.c.Fy();
    }

    public static String Fz() {
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return stringBuilder.append(FC()).append("voiceremind/").toString();
    }

    public static String FA() {
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return stringBuilder.append(FC()).append("wenote/").toString();
    }

    public static String CR() {
        g.Dk();
        return g.Dj().CR();
    }

    public static String CS() {
        g.Dk();
        return g.Dj().CS();
    }

    public static String FB() {
        g.Dk();
        return g.Dj().cachePath;
    }

    public static String FC() {
        g.Dk();
        return g.Dj().gQi;
    }

    public final void FD() {
        StringBuilder stringBuilder = new StringBuilder("mm");
        g.Dk();
        g.Dh();
        String s = com.tencent.mm.a.g.s(stringBuilder.append(a.Cg()).toString().getBytes());
        String str = w.gZK + s + "/";
        String str2 = com.tencent.mm.compatible.util.e.bnF + s + "/";
        String[] list = new File(str).list(new FilenameFilter(this) {
            final /* synthetic */ c heJ;

            {
                this.heJ = r1;
            }

            public final boolean accept(File file, String str) {
                return str.equals("EnMicroMsg.db") || str.startsWith("EnMicroMsg.dberr") || str.equals("FTS5IndexMicroMsg.db");
            }
        });
        if (list != null) {
            for (String str3 : list) {
                String str4 = str2 + str3 + ".dump";
                FileOp.deleteFile(str4);
                FileOp.x(str + str3, str4);
                x.i("MicroMsg.AccountStorage", "Exported: " + str4);
            }
        }
    }

    public static void FE() {
    }

    public static void gd(int i) {
        p.gK(i);
        if ((i & 16) != 0) {
            ba.a("medianote", null);
            ar.Hg();
            Fd().WX("medianote");
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("BOTTLE_MESSAGE_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return am.gJN;
            }
        });
        gwY.put(Integer.valueOf("APPBRAND_MESSAGE_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return h.gJN;
            }
        });
        gwY.put(Integer.valueOf("GetSysCmdMsgInfo".hashCode()), new d() {
            public final String[] wg() {
                return ap.gJN;
            }
        });
        gwY.put(Integer.valueOf("BackupMoveTime".hashCode()), new 9());
        gwY.put(Integer.valueOf("BackupTempMoveTime".hashCode()), new 10());
        gwY.put(Integer.valueOf("BackupRecoverMsgListDataId".hashCode()), new 2());
    }

    public final com.tencent.mm.z.b.c FF() {
        g.Dk();
        g.Dh().Ct();
        return this.heC;
    }

    public final com.tencent.mm.z.b.d FG() {
        g.Dk();
        g.Dh().Ct();
        return this.heD;
    }

    public final b FH() {
        g.Dk();
        g.Dh().Ct();
        return this.heI;
    }

    public static com.tencent.mm.storage.g FI() {
        g.Dk();
        g.Dh().Ct();
        return com.tencent.mm.plugin.d.a.XW().FI();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.b FJ() {
        g.Dk();
        g.Dh().Ct();
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).FJ();
    }

    public final ap FK() {
        g.Dk();
        g.Dh().Ct();
        return this.heE;
    }

    public final j FL() {
        g.Dk();
        g.Dh().Ct();
        return this.heF;
    }

    public final n FM() {
        g.Dk();
        g.Dh().Ct();
        return this.heG;
    }

    public final l FN() {
        g.Dk();
        g.Dh().Ct();
        return this.heH;
    }
}
