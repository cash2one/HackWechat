package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.jsapi.i.d.2;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;

class d$2$1 implements a {
    final /* synthetic */ 2 jqm;

    d$2$1(2 2) {
        this.jqm = 2;
    }

    public final boolean uF() {
        d.bH(this.jqm.jqg.jqe);
        this.jqm.jqg.jqe = null;
        u.GK().hy(this.jqm.iZy.hashCode() + "toast_name");
        x.d("MicroMsg.JsApiShowToast", "on timer expired!");
        l bS = l.bS(this.jqm.jfB.aeM());
        if (bS != null) {
            bS.a(this.jqm.jqg.jqf);
        }
        return true;
    }
}
