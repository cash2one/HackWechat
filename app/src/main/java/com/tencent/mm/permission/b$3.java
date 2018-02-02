package com.tencent.mm.permission;

import com.tencent.mm.g.a.jl;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class b$3 extends c<jl> {
    final /* synthetic */ b ibN;

    b$3(b bVar) {
        this.ibN = bVar;
        this.xen = jl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.PermissionMgr", "show mute dlg");
        PermissionWarningDialog.bD(ac.getContext());
        return false;
    }
}
