package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode.GetA8KeyTask;

class JsApiScanCode$GetA8KeyTask$1 implements a {
    final /* synthetic */ l jed;
    final /* synthetic */ GetA8KeyTask jee;

    JsApiScanCode$GetA8KeyTask$1(GetA8KeyTask getA8KeyTask, l lVar) {
        this.jee = getA8KeyTask;
        this.jed = lVar;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        if (i == 0 && i2 == 0) {
            this.jee.actionCode = this.jed.RG();
            switch (this.jee.actionCode) {
                case 26:
                    this.jee.jeb = this.jed.RE();
                    break;
                default:
                    this.jee.jeb = "";
                    break;
            }
            GetA8KeyTask.b(this.jee);
        } else {
            this.jee.actionCode = -1;
            GetA8KeyTask.a(this.jee);
        }
        return 0;
    }
}
