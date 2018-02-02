package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.mr;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class r$1 extends c<mr> {
    final /* synthetic */ r qUk;

    r$1(r rVar) {
        this.qUk = rVar;
        this.xen = mr.class.getName().hashCode();
    }

    private boolean a(mr mrVar) {
        if (this.qUk.qUi.containsKey(mrVar.fED.filePath)) {
            String encode;
            int intValue = ((Integer) this.qUk.qUi.remove(mrVar.fED.filePath)).intValue();
            String str = "";
            try {
                encode = URLEncoder.encode(mrVar.fED.result, "UTF-8");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsPost", e, "", new Object[0]);
                encode = str;
            }
            if (this.qUk.gLV != 0) {
                aqr com_tencent_mm_protocal_c_aqr = (aqr) this.qUk.qUh.get(mrVar.fED.filePath);
                this.qUk.qUg += String.format("position=%d&qrUrl=%s&md5=%s&imgUrl=%s&codeType=%d|", new Object[]{Integer.valueOf(intValue), encode, com_tencent_mm_protocal_c_aqr.wxS, com_tencent_mm_protocal_c_aqr.nfX, Integer.valueOf(mrVar.fED.fqb)});
            }
            if (this.qUk.qUf == 12) {
                str = "2,3,," + encode;
                if (intValue == 0) {
                    try {
                        str = str + "," + URLEncoder.encode(this.qUk.qUj, "UTF-8");
                    } catch (UnsupportedEncodingException e2) {
                        x.e("MicroMsg.NetSceneSnsPost", "", new Object[]{e2.getMessage()});
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
