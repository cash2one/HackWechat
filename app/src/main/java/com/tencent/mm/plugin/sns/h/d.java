package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.w;
import java.util.HashMap;
import java.util.Map;

public final class d {
    public static d rdA = new d();
    public int gLV = 0;
    public s gyV;
    public HashMap<String, Integer> rdB;
    public HashMap<String, String> rdC;
    public int rdD = 200;
    public int rdE = 86400;

    private d() {
        c fn = com.tencent.mm.z.c.c.IF().fn("100077");
        if (fn.isValid()) {
            Map chI = fn.chI();
            this.rdD = bh.getInt((String) chI.get("maxCacheFeedCount"), 200);
            this.rdE = bh.getInt((String) chI.get("maxCacheSeconds"), 86400);
            this.gLV = bh.getInt((String) chI.get("needUploadData"), 0);
        }
        x.i("MicroMsg.SnsReportHelper", "initAbtestArg maxCacheFeedCount:%d, maxCacheSeconds:%d, needUploadData:%d", new Object[]{Integer.valueOf(this.rdD), Integer.valueOf(this.rdE), Integer.valueOf(this.gLV)});
        this.gyV = new s(w.gZK + "snsreport.cfg");
        Object obj = this.gyV.get(3, new HashMap());
        Object obj2 = this.gyV.get(4, new HashMap());
        if ((obj instanceof HashMap) && (obj2 instanceof HashMap)) {
            this.rdB = (HashMap) obj;
            this.rdC = (HashMap) obj2;
            return;
        }
        FileOp.deleteFile(w.gZK + "snsreport.cfg");
        this.rdB = new HashMap();
        this.rdC = new HashMap();
    }

    public final void KU(String str) {
        if (this.gLV != 0) {
            this.rdB.put(str, Integer.valueOf(this.rdB.containsKey(str) ? ((Integer) this.rdB.get(str)).intValue() + 1 : 1));
        }
    }

    public final void eg(String str, String str2) {
        if (this.gLV != 0 && !bh.ov(str) && !bh.ov(str2)) {
            this.rdC.put(str, str2);
        }
    }
}
