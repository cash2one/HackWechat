package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.mm.by.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.q.d;
import com.tencent.mm.pluginsdk.q.k;
import com.tencent.mm.pluginsdk.q.z;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;

public class c implements k, ap {
    private com.tencent.mm.sdk.b.c gyH = new 1(this);
    private a rVX = null;
    private b rVY = null;
    Map<String, Integer> rVZ = new HashMap();

    public final /* synthetic */ d bDY() {
        return bDT();
    }

    public c() {
        x.i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + bh.cgy());
    }

    public static c bDO() {
        c cVar = (c) z.vcD;
        if (cVar != null) {
            return cVar;
        }
        Object cVar2 = new c();
        z.vcD = cVar2;
        return cVar2;
    }

    public final HashMap<Integer, h.d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        x.i("MicroMsg.SubCoreJdIP6", "onAccountPostReset");
        if (this.rVX == null) {
            this.rVX = new a();
        }
        ar.getSysCmdMsgExtension().a("jd", this.rVX, true);
        a.xef.b(this.gyH);
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
        if (this.rVX != null) {
            a.xef.c(this.rVX.rVG);
            ar.getSysCmdMsgExtension().b("jd", this.rVX, true);
        }
        this.rVZ.clear();
        this.rVX = null;
        a.xef.c(this.gyH);
    }

    public final boolean bDP() {
        ar.Hg();
        return "1".equals((String) com.tencent.mm.z.c.CU().get(327939, ""));
    }

    public final boolean bDQ() {
        ar.Hg();
        return "1".equals((String) com.tencent.mm.z.c.CU().get(327938, ""));
    }

    public final void bDR() {
        ar.Hg();
        com.tencent.mm.z.c.CU().set(327938, "");
    }

    public final void bDS() {
        ar.Hg();
        com.tencent.mm.z.c.CU().set(327939, "");
    }

    public final b bDT() {
        if (this.rVY == null) {
            this.rVY = b.bDG();
        }
        return this.rVY;
    }

    public static void b(b bVar) {
        g.Dh().Ct();
        c bDO = bDO();
        if (bDO.rVY == null) {
            bDO.rVY = b.bDG();
        }
        x.i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", new Object[]{bDO.rVY.bDI(), bVar.bDI()});
        if (bVar.a(bDO.rVY)) {
            if (!bh.ov(bVar.rVN) || bVar.rVM) {
                ar.Hg();
                com.tencent.mm.z.c.CU().set(327939, "1");
            }
            if (bVar.rVL) {
                ar.Hg();
                com.tencent.mm.z.c.CU().set(327938, "1");
            } else {
                ar.Hg();
                com.tencent.mm.z.c.CU().set(327938, "");
            }
            bDO.rVY = bVar;
            ar.Hg();
            com.tencent.mm.z.c.CU().set(327942, bVar.fDP);
            bDO.bDU();
            return;
        }
        x.i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
    }

    private void bDU() {
        new af(Looper.getMainLooper()).post(new 2(this));
    }

    public final void bDV() {
        if (!ar.Hj()) {
            return;
        }
        if (bDO().bDP() || bDO().bDQ()) {
            b bDT = bDO().bDT();
            if ((!bh.ov(bDT.rVN) || bDT.rVM) && bDT.bDH()) {
                x.i("MicroMsg.SubCoreJdIP6", "clear red dot/friend dot");
                bDO().bDR();
                bDO().bDS();
                bDO().bDU();
            }
        }
    }

    public static String ck(String str, int i) {
        if (-1 != str.indexOf(35)) {
            return str;
        }
        if (-1 == str.indexOf(63)) {
            return str + "?wc_scene=" + i;
        }
        return str + "&wc_scene=" + i;
    }

    public static boolean bDW() {
        return (bh.ov(com.tencent.mm.k.g.zY().getValue("JDEntranceConfigName")) || bh.ov(com.tencent.mm.k.g.zY().getValue("JDEntranceConfigIconUrl")) || bh.ov(com.tencent.mm.k.g.zY().getValue("JDEntranceConfigJumpUrl"))) ? false : true;
    }

    public final String bDX() {
        int i = 1;
        String value = com.tencent.mm.k.g.zY().getValue("JDEntranceConfigJumpUrl");
        if (bh.ov(value)) {
            return null;
        }
        int i2;
        int i3;
        b bDT = bDT();
        if (bDP()) {
            if (!bDT.bDH() && TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(bDT.rVJ) && !bh.ov(bDT.jumpUrl)) {
                x.i("MicroMsg.SubCoreJdIP6", "jumpUrl update %s", new Object[]{bDT.jumpUrl});
                value = bDT.jumpUrl;
                i2 = 6;
                if (bDT.rVP < System.currentTimeMillis() / 1000) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                if (i3 != 0) {
                    i = 0;
                    if (i == 0) {
                        value = bDT.jumpUrl;
                        i2 = 3;
                    }
                }
                return ck(value, i2);
            } else if (bDT.rVM) {
                i2 = 2;
                if ("2".equals(bDT.rVJ) && !bh.ov(bDT.jumpUrl)) {
                    if (bDT.rVP < System.currentTimeMillis() / 1000) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        if (bDT.rVQ == 0 || bDT.rVQ >= System.currentTimeMillis() / 1000) {
                            i = 0;
                        }
                        if (i == 0) {
                            value = bDT.jumpUrl;
                            i2 = 3;
                        }
                    }
                }
                return ck(value, i2);
            }
        }
        i2 = 1;
        if (bDT.rVP < System.currentTimeMillis() / 1000) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            i = 0;
            if (i == 0) {
                value = bDT.jumpUrl;
                i2 = 3;
            }
        }
        return ck(value, i2);
    }
}
