package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.ae.d;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.g.a.ru;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bs.a;
import com.tencent.mm.z.c;
import java.util.Map;

class i$11 implements a {
    final /* synthetic */ i nDs;

    i$11(i iVar) {
        this.nDs = iVar;
    }

    public final void a(d.a aVar) {
        x.i("MicroMsg.SubCoreIPCall", "WeChatOut onRecieveMsg");
        String a = n.a(aVar.hmq.vGZ);
        if (a == null || a.length() == 0) {
            x.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, msgContent is null");
            return;
        }
        Map y = bi.y(a, "sysmsg");
        if (y == null) {
            x.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, values is null");
            return;
        }
        int i;
        int i2;
        String substring;
        if (y.containsKey(".sysmsg.WeChatOut.AccountRedDotType")) {
            i = bh.getInt((String) y.get(".sysmsg.WeChatOut.AccountRedDotType"), -1);
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountRedDotType: %d", new Object[]{Integer.valueOf(i)});
            ar.Hg();
            c.CU().a(w.a.xpi, Integer.valueOf(i));
            i2 = i;
        } else {
            i2 = -1;
        }
        if (y.containsKey(".sysmsg.WeChatOut.AcctRD")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut AcctRD: %d", new Object[]{Integer.valueOf(bh.getInt((String) y.get(".sysmsg.WeChatOut.AcctRD"), 0))});
            if (bh.getInt((String) y.get(".sysmsg.WeChatOut.AcctRD"), 0) != 0) {
                ar.Hg();
                c.CU().a(w.a.xph, Boolean.valueOf(true));
                g.pQN.h(13254, new Object[]{Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(-1), Integer.valueOf(-1)});
            } else {
                ar.Hg();
                c.CU().a(w.a.xph, Boolean.valueOf(false));
            }
        }
        if (y.containsKey(".sysmsg.WeChatOut.TabRD")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRD: %d", new Object[]{Integer.valueOf(bh.getInt((String) y.get(".sysmsg.WeChatOut.TabRD"), 0))});
            if (bh.getInt((String) y.get(".sysmsg.WeChatOut.TabRD"), 0) != 0) {
                ar.Hg();
                c.CU().a(w.a.xpu, Boolean.valueOf(true));
                g.pQN.h(13254, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1)});
            } else {
                ar.Hg();
                c.CU().a(w.a.xpu, Boolean.valueOf(false));
            }
        }
        if (y.containsKey(".sysmsg.WeChatOut.RechargeRD")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeRD: %d", new Object[]{Integer.valueOf(bh.getInt((String) y.get(".sysmsg.WeChatOut.RechargeRD"), 0))});
            if (bh.getInt((String) y.get(".sysmsg.WeChatOut.RechargeRD"), 0) != 0) {
                ar.Hg();
                c.CU().a(w.a.xpo, Boolean.valueOf(true));
                g.pQN.h(13254, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1)});
            } else {
                ar.Hg();
                c.CU().a(w.a.xpo, Boolean.valueOf(false));
            }
        }
        if (y.containsKey(".sysmsg.WeChatOut.RechargeWording")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWording: %s", new Object[]{(String) y.get(".sysmsg.WeChatOut.RechargeWording")});
            ar.Hg();
            c.CU().a(w.a.xpn, substring);
        }
        if (y.containsKey(".sysmsg.WeChatOut.PackagePurchaseWording")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut PackagePurchaseWording: %s", new Object[]{(String) y.get(".sysmsg.WeChatOut.PackagePurchaseWording")});
            ar.Hg();
            c.CU().a(w.a.xpp, substring);
        }
        if (y.containsKey(".sysmsg.WeChatOut.AccountWording")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountWording: %s", new Object[]{(String) y.get(".sysmsg.WeChatOut.AccountWording")});
            ar.Hg();
            c.CU().a(w.a.xpj, substring);
        }
        if (y.containsKey(".sysmsg.WeChatOut.RechargeWordingVersion")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWordingVersion: %d", new Object[]{Integer.valueOf(bh.getInt((String) y.get(".sysmsg.WeChatOut.RechargeWordingVersion"), 0))});
            ar.Hg();
            c.CU().a(w.a.xpy, Integer.valueOf(i));
        }
        if (y.containsKey(".sysmsg.WeChatOut.TabWording")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut TabWording: %s", new Object[]{(String) y.get(".sysmsg.WeChatOut.TabWording")});
            ar.Hg();
            c.CU().a(w.a.xpt, substring);
        }
        if (y.containsKey(".sysmsg.WeChatOut.AccountActivityWording")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWording: %s", new Object[]{(String) y.get(".sysmsg.WeChatOut.AccountActivityWording")});
            ar.Hg();
            c.CU().a(w.a.xpk, substring);
        }
        if (y.containsKey(".sysmsg.WeChatOut.AccountActivityWordingClearType")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingClearType : %d", new Object[]{Integer.valueOf(bh.getInt((String) y.get(".sysmsg.WeChatOut.AccountActivityWordingClearType"), 0))});
            ar.Hg();
            c.CU().a(w.a.xpl, Integer.valueOf(i));
        }
        if (y.containsKey(".sysmsg.WeChatOut.AccountActivityWordingVersion")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingVersion: %d", new Object[]{Integer.valueOf(bh.getInt((String) y.get(".sysmsg.WeChatOut.AccountActivityWordingVersion"), 0))});
            ar.Hg();
            c.CU().a(w.a.xpm, Integer.valueOf(i));
        }
        if (y.containsKey(".sysmsg.WeChatOut.TabRedDotType")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRedDotType: %d", new Object[]{Integer.valueOf(bh.getInt((String) y.get(".sysmsg.WeChatOut.TabRedDotType"), 0))});
            g.pQN.h(13254, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(i)});
            ar.Hg();
            c.CU().a(w.a.xpv, Integer.valueOf(i));
        }
        i = a.indexOf("<ActivityInfo>");
        i2 = a.indexOf("</ActivityInfo>");
        if (i > 0 && i2 > 0 && i2 > i) {
            substring = a.substring(i, i2 + 15);
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut ActivityInfo: %s", new Object[]{substring});
            com.tencent.mm.plugin.ipcall.a.g.a CB = com.tencent.mm.plugin.ipcall.a.g.a.CB(substring);
            if (CB != null && bh.ov(CB.fon) && bh.ov(CB.nfe)) {
                x.i("MicroMsg.SubCoreIPCall", "clear activity");
                ar.Hg();
                c.CU().a(w.a.xpH, Boolean.valueOf(false));
                ar.Hg();
                c.CU().a(w.a.xpI, "");
            } else if (CB != null) {
                if (!bh.ov(CB.nGE)) {
                    o.Pv().a(CB.nGE, null);
                }
                ar.Hg();
                c.CU().a(w.a.xpH, Boolean.valueOf(true));
                ar.Hg();
                c.CU().a(w.a.xpI, substring);
            }
        }
        com.tencent.mm.sdk.b.a.xef.m(new ih());
        com.tencent.mm.sdk.b.a.xef.m(new ru());
    }
}
