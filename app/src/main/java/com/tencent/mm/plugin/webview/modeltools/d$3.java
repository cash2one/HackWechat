package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.g.a.oj;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class d$3 extends c<oj> {
    final /* synthetic */ d tuv;

    d$3(d dVar) {
        this.tuv = dVar;
        this.xen = oj.class.getName().hashCode();
    }

    private boolean a(oj ojVar) {
        if ((ojVar instanceof oj) && this.tuv.tuq.equalsIgnoreCase(ojVar.fGk.cardType)) {
            if (ojVar.fGk.fGl == 0) {
                d.b(this.tuv, this.tuv.tuq);
            } else if (ojVar.fGk.fGl == 2) {
                d.a(this.tuv, this.tuv.tuq);
            } else {
                try {
                    if (bh.ov(ojVar.fGk.fGm)) {
                        d.a(this.tuv, this.tuv.tuq, null, ojVar.fGk.fGn);
                    } else {
                        d.a(this.tuv, this.tuv.tuq, new JSONObject(ojVar.fGk.fGm), ojVar.fGk.fGn);
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.LicenceScanner", "Failed to parse json string: %s", new Object[]{e.getMessage()});
                    d.b(this.tuv, this.tuv.tuq);
                }
            }
            d.a(this.tuv);
        }
        return false;
    }
}
