package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.mm.pluginsdk.q.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Map;

public final class b implements d {
    public String fDP = "";
    public long hQs = 0;
    public String iconUrl = "";
    public String jumpUrl = "";
    public String rVJ = "";
    public String rVK = "";
    public boolean rVL = false;
    public boolean rVM = false;
    public String rVN = "";
    public String rVO = "";
    public long rVP;
    public long rVQ;
    public long rVR;
    public long rVS;
    public String rVT = "";
    public String rVU = "";
    public String rVV = "";
    public String rVW = "";
    public long startTime;
    public String title = "";

    public static b bDG() {
        ar.Hg();
        String str = (String) c.CU().get(327942, "");
        b bVar = new b();
        x.i("MicroMsg.JdMsgContent", " create xml : " + str);
        bVar.KV(str);
        return bVar;
    }

    public final void KV(String str) {
        this.rVJ = "";
        this.rVK = "";
        this.hQs = 0;
        this.rVN = "";
        this.rVL = false;
        this.rVM = false;
        this.rVU = "";
        this.rVV = "";
        this.rVW = "";
        this.rVT = "";
        this.jumpUrl = "";
        this.fDP = "";
        this.fDP = str;
        if (!bh.ov(str)) {
            x.i("MicroMsg.JdMsgContent", "feed xml %s", new Object[]{str});
            Map y = bi.y(str, "sysmsg");
            if (y != null) {
                this.rVJ = bh.az((String) y.get(".sysmsg.biztype"), "");
                this.rVT = bh.az((String) y.get(".sysmsg.alert"), "");
                this.rVK = bh.az((String) y.get(".sysmsg.activityid"), "");
                this.startTime = bh.VJ((String) y.get(".sysmsg.starttime"));
                this.hQs = bh.VJ((String) y.get(".sysmsg.expiretime"));
                this.title = bh.az((String) y.get(".sysmsg.content.title"), "");
                this.iconUrl = bh.az((String) y.get(".sysmsg.content.icon"), "");
                this.jumpUrl = bh.az((String) y.get(".sysmsg.content.jumpurl"), "");
                this.rVP = bh.VJ((String) y.get(".sysmsg.content.urlstarttime"));
                this.rVQ = bh.VJ((String) y.get(".sysmsg.content.urlexpiretime"));
                this.rVN = bh.az((String) y.get(".sysmsg.content.jdcelltitle"), "");
                this.rVO = bh.az((String) y.get(".sysmsg.content.jdcellicon"), "");
                this.rVR = bh.VJ((String) y.get(".sysmsg.content.titlestarttime"));
                this.rVS = bh.VJ((String) y.get(".sysmsg.content.titleexpiretime"));
                this.rVL = "1".equals(y.get(".sysmsg.content.findshowreddot"));
                this.rVM = "1".equals(y.get(".sysmsg.content.jdcellshowred"));
                this.rVU = bh.az((String) y.get(".sysmsg.content.alertviewtitle"), "");
                this.rVV = bh.az((String) y.get(".sysmsg.content.alertviewconfirm"), "");
                this.rVW = bh.az((String) y.get(".sysmsg.content.alertviewcancel"), "");
            }
        }
    }

    public final boolean agj() {
        return this.startTime < System.currentTimeMillis() / 1000;
    }

    public final boolean bDH() {
        return this.hQs != 0 && this.hQs < System.currentTimeMillis() / 1000;
    }

    public final boolean a(b bVar) {
        if (bVar != null && bh.az(this.rVK, "").equals(bh.az(bVar.rVK, ""))) {
            return false;
        }
        return true;
    }

    public final String bDI() {
        return bh.az(this.fDP, "");
    }

    public final String bDJ() {
        return this.rVK;
    }

    public final String bDK() {
        return this.rVN;
    }

    public final boolean bDL() {
        return this.rVM;
    }

    public final String bDM() {
        return this.rVJ;
    }

    public final String bDN() {
        return this.jumpUrl;
    }
}
