package com.tencent.mm.plugin.ext;

import com.tencent.mm.g.a.fe;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public class b$b extends c<fe> {
    public final /* synthetic */ boolean a(b bVar) {
        fe feVar = (fe) bVar;
        if (feVar.fui == null) {
            x.e("MicroMsg.SubCoreExt", "StepCount revent.data is null");
        } else {
            x.i("MicroMsg.SubCoreExt", " action = " + feVar.fui.action);
            if (feVar.fui.action == 1) {
                b.aFF();
                x.d("MicroMsg.SubCoreExt", " sendBroadcast");
                return true;
            }
        }
        return false;
    }

    public b$b() {
        super(0);
        this.xen = fe.class.getName().hashCode();
    }
}
