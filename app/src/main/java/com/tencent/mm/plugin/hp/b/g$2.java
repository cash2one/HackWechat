package com.tencent.mm.plugin.hp.b;

import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.hp.a.b;
import com.tencent.mm.pluginsdk.h.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class g$2 implements Runnable {
    final /* synthetic */ String[] gIP;
    final /* synthetic */ g nAQ;

    g$2(g gVar, String[] strArr) {
        this.nAQ = gVar;
        this.gIP = strArr;
    }

    public final void run() {
        int i;
        String str = e.bnF + "/Download/2017-07-28_19-43-39.apk";
        String str2 = e.bnF + "/Download/39-50-diff.apk";
        String str3 = e.bnF + "/Download/new_50.apk";
        String str4 = "ab099f75f740be5d88e178d662a36779";
        if (this.gIP.length >= 3 && !bh.ov(this.gIP[2])) {
            str = this.gIP[2];
        }
        if (this.gIP.length >= 4 && !bh.ov(this.gIP[3])) {
            str2 = this.gIP[3];
        }
        if (this.gIP.length >= 5 && !bh.ov(this.gIP[4])) {
            str3 = this.gIP[4];
        }
        if (this.gIP.length >= 6 && !bh.ov(this.gIP[5])) {
            str4 = this.gIP[5];
        }
        if (com.tencent.mm.a.e.bO(str3)) {
            i = 0;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            i = b.b(str, str2, str3, str4);
            x.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk use :%d retCode：%d", new Object[]{Long.valueOf((System.currentTimeMillis() - currentTimeMillis) / 1000), Integer.valueOf(i)});
        }
        if (i == 0) {
            x.i("MicroMsg.Tinker.TinkerBootsCommand", "show dialog for install");
            x.i("MicroMsg.Tinker.TinkerBootsCommand", "New Apk md5:%s", new Object[]{g.bV(str3)});
            p.ba(ac.getContext(), str3);
            x.i("MicroMsg.Tinker.TinkerBootsCommand", "md5 is equal.");
            return;
        }
        x.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk failed.");
    }
}
