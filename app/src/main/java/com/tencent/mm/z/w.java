package com.tencent.mm.z;

import com.tencent.mm.a.e;
import com.tencent.mm.aq.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class w {
    af handler;
    BlockingQueue<c> hfA = new ArrayBlockingQueue(80);
    public b hfB = null;
    private a hfy = null;
    boolean hfz = false;

    class c {
        String filename;
        final /* synthetic */ w hfC;
        boolean hfG = false;
        String hfH;
        int pos;
        String url;

        public c(w wVar, String str, String str2, int i, String str3) {
            this.hfC = wVar;
            this.url = str;
            if (q.PE() && wVar.hfz) {
                this.url = q.lw(this.url);
            }
            this.filename = str2;
            this.pos = i;
            this.hfG = false;
            this.hfH = str3;
        }
    }

    static /* synthetic */ void a(w wVar, long j, long j2) {
        if (wVar.hfz) {
            x.d("MicroMsg.GetPicService", "doIdKeyStat, key:%d, val:%d", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
            g.pQN.a(86, j, j2, false);
        }
    }

    public w(boolean z) {
        com.tencent.mm.kernel.g.Dk();
        this.handler = new 1(this, com.tencent.mm.kernel.g.Dm().oAt.getLooper());
        this.hfy = null;
        this.hfz = z;
        x.d("MicroMsg.GetPicService", "getPicService, isFromWebView:%b", new Object[]{Boolean.valueOf(z)});
    }

    public final void GM() {
        if (this.hfy != null) {
            this.hfy.hfF = true;
        }
        this.hfy = null;
    }

    public final String c(String str, int i, int i2, String str2) {
        String str3;
        if (str == null) {
            str3 = null;
        } else if (com.tencent.mm.kernel.g.Dh().Cy()) {
            str3 = com.tencent.mm.plugin.n.c.Fi() + "/reader_" + i + "_" + com.tencent.mm.a.g.s(str.getBytes()) + ".jpg";
        } else {
            x.i("MicroMsg.GetPicService", "genFileName, account not ready");
            File file = new File(com.tencent.mm.kernel.g.Dj().gQh + "/imagecache");
            if (!file.exists()) {
                file.mkdirs();
            }
            str3 = file.getAbsolutePath() + "/reader_" + i + "_" + com.tencent.mm.a.g.s(str.getBytes()) + ".jpg";
        }
        x.d("MicroMsg.GetPicService", "getPicfileByUrl type:" + i + " url:" + str);
        try {
            if (e.bO(str3)) {
                return str3;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.GetPicService", "exception:%s", new Object[]{bh.i(e)});
        }
        try {
            this.hfA.add(new c(this, str, str3, i2, str2));
            if (this.hfy == null || !com.tencent.mm.sdk.f.e.V(this.hfy)) {
                com.tencent.mm.sdk.f.e.remove(this.hfy);
                this.hfy = new a(this);
                com.tencent.mm.sdk.f.e.post(this.hfy, "GetPicService_getPic");
            }
        } catch (Throwable e2) {
            x.e("MicroMsg.GetPicService", "exception:%s", new Object[]{bh.i(e2)});
        }
        return null;
    }
}
