package com.tencent.mm.z.b;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class b {
    private boolean hiq = false;
    public ArrayList<a> mListeners = new ArrayList();

    public interface a {
        void Iw();
    }

    public enum b {
        Main,
        Chatting
    }

    public static String Im() {
        ar.Hg();
        return (String) c.CU().get(com.tencent.mm.storage.w.a.xvF, "");
    }

    public static String In() {
        ar.Hg();
        return (String) c.CU().get(com.tencent.mm.storage.w.a.xvG, "");
    }

    public static boolean Io() {
        ar.Hg();
        return ((Boolean) c.CU().get(com.tencent.mm.storage.w.a.xvI, Boolean.valueOf(false))).booleanValue();
    }

    public static String Ip() {
        ar.Hg();
        return (String) c.CU().get(com.tencent.mm.storage.w.a.xvz, "");
    }

    public static String Iq() {
        ar.Hg();
        return (String) c.CU().get(com.tencent.mm.storage.w.a.xvA, "");
    }

    public static boolean Ir() {
        ar.Hg();
        return ((Boolean) c.CU().get(com.tencent.mm.storage.w.a.xvC, Boolean.valueOf(false))).booleanValue();
    }

    private static boolean Is() {
        ar.Hg();
        return ((Boolean) c.CU().get(com.tencent.mm.storage.w.a.xvD, Boolean.valueOf(false))).booleanValue();
    }

    private static boolean It() {
        ar.Hg();
        return ((Boolean) c.CU().get(com.tencent.mm.storage.w.a.xvM, Boolean.valueOf(false))).booleanValue();
    }

    public final void p(Map<String, String> map) {
        if (map != null) {
            g.pQN.a(633, 3, 1, false);
            String ou = bh.ou((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.url"));
            String ou2 = bh.ou((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.wording"));
            long j = bh.getLong((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.duration"), 0);
            boolean z = bh.getInt((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.autotrigger"), 0) == 1;
            boolean z2 = bh.getInt((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.closable"), 0) == 1;
            String ou3 = bh.ou((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.url"));
            String ou4 = bh.ou((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.wording"));
            long j2 = bh.getLong((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.duration"), 0);
            boolean z3 = bh.getInt((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.autotrigger"), 0) == 1;
            boolean z4 = bh.getInt((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.closable"), 0) == 1;
            if (!bh.ov(ou2) || !bh.ov(ou4)) {
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xvz, ou4);
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xvA, ou3);
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xvB, Long.valueOf(j2));
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xvC, Boolean.valueOf(z4));
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xvD, Boolean.valueOf(z3));
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xvF, ou2);
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xvG, ou);
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xvH, Long.valueOf(j));
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xvI, Boolean.valueOf(z2));
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xvJ, Boolean.valueOf(z));
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xvL, Long.valueOf(bh.Wo()));
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xvE, Boolean.valueOf(false));
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xvK, Boolean.valueOf(false));
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xvM, Boolean.valueOf(false));
                ar.Hg();
                c.CU().lH(true);
                Iu();
            }
        }
    }

    public static boolean a(b bVar) {
        long longValue;
        boolean booleanValue;
        boolean Is;
        String Ip;
        x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: is checking monitor banner scene: %s", new Object[]{bVar});
        long Wo = bh.Wo();
        ar.Hg();
        long longValue2 = ((Long) c.CU().get(com.tencent.mm.storage.w.a.xvL, Long.valueOf(-1))).longValue();
        if (bVar == b.Chatting) {
            ar.Hg();
            longValue = ((Long) c.CU().get(com.tencent.mm.storage.w.a.xvB, Long.valueOf(0))).longValue();
            ar.Hg();
            booleanValue = ((Boolean) c.CU().get(com.tencent.mm.storage.w.a.xvE, Boolean.valueOf(false))).booleanValue();
            Is = Is();
            Ip = Ip();
        } else {
            ar.Hg();
            longValue = ((Long) c.CU().get(com.tencent.mm.storage.w.a.xvH, Long.valueOf(0))).longValue();
            ar.Hg();
            booleanValue = ((Boolean) c.CU().get(com.tencent.mm.storage.w.a.xvK, Boolean.valueOf(false))).booleanValue();
            ar.Hg();
            Is = ((Boolean) c.CU().get(com.tencent.mm.storage.w.a.xvJ, Boolean.valueOf(false))).booleanValue();
            Ip = Im();
        }
        if (bh.ov(Ip)) {
            x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not get wording");
            return false;
        } else if (booleanValue) {
            x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not check trigger and already closed");
            return false;
        } else if (longValue2 < 0) {
            x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: no msg occurs");
            return false;
        } else if (Is && !It()) {
            x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: should check triggered but not triggered");
            return false;
        } else if (longValue == -1) {
            x.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: should always show");
            return true;
        } else if (longValue2 + longValue > Wo) {
            x.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: still in show time. show banner");
            return true;
        } else {
            x.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: expired.");
            return false;
        }
    }

    private void Iu() {
        synchronized (b.class) {
            Iterator it = this.mListeners.iterator();
            while (it.hasNext()) {
                ((a) it.next()).Iw();
            }
        }
    }

    public final void Iv() {
        if (!It()) {
            x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: monitored illegal set text. mark now as the start time ");
            ar.Hg();
            c.CU().a(com.tencent.mm.storage.w.a.xvL, Long.valueOf(bh.Wo()));
            ar.Hg();
            c.CU().a(com.tencent.mm.storage.w.a.xvM, Boolean.valueOf(true));
            Iu();
        }
    }

    public final void b(b bVar) {
        if (bVar == b.Main) {
            ar.Hg();
            c.CU().a(com.tencent.mm.storage.w.a.xvK, Boolean.valueOf(false));
        } else {
            ar.Hg();
            c.CU().a(com.tencent.mm.storage.w.a.xvE, Boolean.valueOf(false));
        }
        Iu();
    }

    public final void c(b bVar) {
        if (bVar == b.Main) {
            ar.Hg();
            c.CU().a(com.tencent.mm.storage.w.a.xvH, Long.valueOf(0));
        } else if (bVar != b.Chatting) {
            return;
        } else {
            if (Is()) {
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xvE, Boolean.valueOf(true));
            } else {
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xvB, Long.valueOf(0));
            }
        }
        Iu();
    }
}
