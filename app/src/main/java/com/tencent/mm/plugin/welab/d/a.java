package com.tencent.mm.plugin.welab.d;

import android.app.Activity;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.b.cb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;

public final class a implements b {
    public final void e(Activity activity, String str) {
        cb Qx = ((d) g.h(d.class)).Qx(str);
        com.tencent.mm.sdk.b.b qpVar = new qp();
        qpVar.fIi.userName = Qx.field_WeAppUser;
        qpVar.fIi.fIk = Qx.field_WeAppPath;
        qpVar.fIi.scene = 1051;
        qpVar.fIi.fIl = Qx.field_WeAppDebugMode;
        qpVar.fIi.fnp = String.format("%s:%s:%s:%s", new Object[]{(String) g.Dj().CU().get(2, null), Qx.field_expId, Qx.field_LabsAppId, Long.valueOf(System.currentTimeMillis() / 1000)});
        com.tencent.mm.sdk.b.a.xef.m(qpVar);
    }

    public final String bVC() {
        return null;
    }

    public final String bVD() {
        return null;
    }
}
