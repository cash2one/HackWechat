package com.tencent.mm.modelstat;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.q;
import com.tencent.mm.bq.b;
import com.tencent.mm.modelstat.c.4;
import com.tencent.mm.modelstat.c.a;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.acd;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class c$4$1 implements Runnable {
    final /* synthetic */ acd hQn;
    final /* synthetic */ 4 hQo;

    c$4$1(4 4, acd com_tencent_mm_protocal_c_acd) {
        this.hQo = 4;
        this.hQn = com_tencent_mm_protocal_c_acd;
    }

    public final void run() {
        String str = null;
        this.hQo.hQl.ai("LAST_UPDATE_CONFIG", bh.Wo());
        if (this.hQn.wkY == null || this.hQn.wkY.oz.length <= 0 || this.hQn.wkW == null || this.hQn.wkW.oz.length <= 0) {
            Integer num;
            Integer valueOf;
            String str2 = "MicroMsg.ClickFlowStatReceiver";
            String str3 = "OnSceneEnd NetSceneUpdateEventConfig failed, eventsampleconf:%s, versionbuffer:%s";
            Object[] objArr = new Object[2];
            if (this.hQn.wkY == null) {
                num = null;
            } else {
                num = Integer.valueOf(this.hQn.wkY.oz.length);
            }
            objArr[0] = num;
            if (this.hQn.wkW != null) {
                valueOf = Integer.valueOf(this.hQn.wkW.oz.length);
            }
            objArr[1] = valueOf;
            x.e(str2, str3, objArr);
            return;
        }
        d.pPH.a(346, 3, 1, false);
        str3 = bh.by(this.hQn.wkW.oz);
        String value = this.hQo.hQl.getValue("versionBuffer");
        this.hQo.hQl.fv("versionBuffer", str3);
        b bVar = this.hQn.wkY;
        try {
            str = new String(q.v(bVar.oz), "UTF-8");
        } catch (Throwable e) {
            int i;
            Throwable th = e;
            String str4 = "MicroMsg.ClickFlowStatReceiver";
            String str5 = "decompress failed, configString length %d, msg:%s  [%s]";
            Object[] objArr2 = new Object[3];
            if (bVar == null) {
                i = 0;
            } else {
                i = bVar.oz.length;
            }
            objArr2[0] = Integer.valueOf(i);
            objArr2[1] = th.getMessage();
            objArr2[2] = bh.i(th);
            x.e(str4, str5, objArr2);
        }
        if (TextUtils.isEmpty(str)) {
            d.pPH.a(346, 2, 1, false);
            return;
        }
        boolean z;
        try {
            a mK = a.mK(str);
            e.b(this.hQo.hQm, str.getBytes(), str.getBytes().length);
            c.a(this.hQo.hQj, mK);
            z = true;
        } catch (Throwable e2) {
            x.e("MicroMsg.ClickFlowStatReceiver", "readReportConfig failed :%s  [%s]", e2.getMessage(), bh.i(e2));
            z = false;
        }
        if (!str3.equals(value)) {
            long j;
            x.i("MicroMsg.ClickFlowStatReceiver", "idKeyStat, configOK:%b", Boolean.valueOf(z));
            d dVar = d.pPH;
            if (z) {
                j = 0;
            } else {
                j = 1;
            }
            dVar.a(346, j, 1, false);
        }
    }
}
