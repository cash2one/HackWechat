package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

class d$3 extends c<sm> {
    final /* synthetic */ d rWp;

    d$3(d dVar) {
        this.rWp = dVar;
        super(0);
        this.xen = sm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sm smVar = (sm) bVar;
        e Mj = e.Mj(smVar.fKi.fCs);
        cf cfVar = smVar.fKi.fnB;
        if (Mj != null) {
            d bEa = d.bEa();
            String str = cfVar.field_talker;
            String str2 = smVar.fKi.description;
            String S = n.S(ac.getContext(), Mj.rWq);
            String str3 = "";
            if (S != null && S.length() > 0) {
                String[] split = S.split(";");
                str3 = str3 + split[0];
                if (split.length > 1) {
                    str3 = str3 + split[1];
                }
            }
            if (str2 != null) {
                str3 = str3 + str2;
            }
            bEa.f(str, str3, cfVar.field_createTime);
        }
        return false;
    }
}
