package com.tencent.mm.plugin.i;

import com.tencent.mm.g.a.cb;
import com.tencent.mm.plugin.i.b.11;
import com.tencent.mm.plugin.i.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$11$1 implements Runnable {
    final /* synthetic */ cb kHZ;
    final /* synthetic */ 11 kIa;

    b$11$1(11 11, cb cbVar) {
        this.kIa = 11;
        this.kHZ = cbVar;
    }

    public final void run() {
        if (this.kHZ != null && !bh.ov(this.kHZ.fql.talker)) {
            try {
                b asH = b.asG().asH();
                long j = this.kHZ.fql.fqm;
                String str = this.kHZ.fql.talker;
                int i = this.kHZ.fql.msgType;
                String[] strArr = new String[]{String.valueOf(j), String.valueOf(i), str};
                int delete = asH.gJP.delete("WxFileIndex2", "msgId=? AND msgType=? AND username=? ", strArr);
                x.i("MicroMsg.WxFileIndexStorage", "delete by msg [%d %d %s] result[%d]", new Object[]{Long.valueOf(j), Integer.valueOf(i), str, Integer.valueOf(delete)});
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CalcWxService", e, "", new Object[0]);
                g.pQN.a(664, 6, 1, false);
            }
        }
    }
}
