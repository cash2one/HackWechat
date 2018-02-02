package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.g.b.cf;
import com.tencent.mm.k.g;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import java.util.Map;

public final class a {
    public String desc;
    public String fqR;
    public int fyp;
    public long hQs;
    public int size;
    public String url;
    public long veb;

    public static a bYz() {
        ar.Hg();
        String str = (String) c.CU().get(352273, "");
        if (bh.ov(str)) {
            return null;
        }
        a aVar = new a(str);
        if (aVar.isValid() && !aVar.bPi()) {
            return aVar;
        }
        bYA();
        return null;
    }

    public a(String str) {
        Map y = bi.y(str, "msg");
        this.desc = (String) y.get(".msg.appmsg.des");
        this.fyp = bh.getInt((String) y.get(".msg.alphainfo.clientVersion"), 0);
        this.url = (String) y.get(".msg.alphainfo.url");
        this.size = bh.getInt((String) y.get(".msg.alphainfo.size"), 0);
        this.fqR = (String) y.get(".msg.alphainfo.md5");
        this.veb = bh.getLong((String) y.get(".msg.alphainfo.maxAge"), 0);
        this.hQs = bh.getLong((String) y.get(".msg.alphainfo.expireTime"), 0);
        x.i("MicroMsg.AlphaUpdateInfo", "updateInfo, content:%s, clientVersion:%d, url:%s, size:%d, md5:%s, desc:%s, maxAge:%d, expireTime:%d", new Object[]{str, Integer.valueOf(this.fyp), this.url, Integer.valueOf(this.size), this.fqR, this.desc, Long.valueOf(this.veb), Long.valueOf(this.hQs)});
    }

    private boolean isValid() {
        boolean z;
        if (this.fyp <= d.vAz || bh.ov(this.url) || bh.ov(this.fqR) || bh.ov(this.desc)) {
            z = false;
        } else {
            z = true;
        }
        x.i("MicroMsg.AlphaUpdateInfo", "isValid %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    private boolean bPi() {
        boolean z;
        ar.Hg();
        if (System.currentTimeMillis() - ((Long) c.CU().get(352274, Long.valueOf(System.currentTimeMillis()))).longValue() > this.veb || System.currentTimeMillis() > this.hQs) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.AlphaUpdateInfo", "isExpired: %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public static void bYA() {
        ar.Hg();
        c.CU().set(352273, null);
        ar.Hg();
        c.CU().set(352274, null);
    }

    public final void bYB() {
        cf auVar = new au();
        auVar.aq(ba.n("weixin", bh.Wo()));
        auVar.setType(1);
        auVar.setContent(this.desc);
        x.d("MicroMsg.AlphaUpdateInfo", auVar.field_content);
        auVar.eR(0);
        auVar.dS("weixin");
        auVar.eQ(3);
        ba.i(auVar);
        x.i("MicroMsg.AlphaUpdateInfo", "insertUpdateTextMsg");
        bYA();
    }

    public final void bYC() {
        x.i("MicroMsg.AlphaUpdateInfo", "downloadInSilence.");
        if (isValid() && !bPi()) {
            int i;
            if (bh.VI(g.zY().getValue("SilentDownloadApkAtWiFi")) != 0) {
                i = 0;
            } else {
                ar.Hg();
                i = (!an.isWifi(ac.getContext()) || ((((Integer) c.CU().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0 ? 1 : 0) == 0) ? 0 : 1;
                if ((f.fdU & 1) != 0) {
                    x.d("MicroMsg.AlphaUpdateInfo", "channel pack, not silence download.");
                    i = 0;
                } else {
                    x.d("MicroMsg.AlphaUpdateInfo", "not channel pack.");
                }
            }
            if (i == 0) {
                bYB();
                return;
            }
            x.i("MicroMsg.AlphaUpdateInfo", "go to download, %s, %d, %s, %s", new Object[]{this.fqR, Integer.valueOf(this.size), this.desc, this.url});
            q.x.bYd().c(this.fqR, this.size, this.desc.replaceFirst("(\n)*<a.*</a>(\n)*", "\n"), this.url);
        }
    }
}
