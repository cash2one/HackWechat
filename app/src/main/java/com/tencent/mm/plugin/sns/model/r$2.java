package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.mq;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class r$2 extends c<mq> {
    final /* synthetic */ r qUk;

    r$2(r rVar) {
        this.qUk = rVar;
        this.xen = mq.class.getName().hashCode();
    }

    private boolean a(mq mqVar) {
        if (this.qUk.qUi.containsKey(mqVar.fEC.filePath)) {
            int intValue = ((Integer) this.qUk.qUi.remove(mqVar.fEC.filePath)).intValue();
            if (this.qUk.qUf == 12) {
                String str = "2,3,,";
                if (intValue == 0) {
                    try {
                        str = str + "," + URLEncoder.encode(this.qUk.qUj, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        x.e("MicroMsg.NetSceneSnsPost", "", new Object[]{e.getMessage()});
                    }
                }
                x.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[]{Integer.valueOf(intValue), str});
                g.pQN.k(13717, str);
            }
            r.a(this.qUk);
        }
        return false;
    }
}
