package com.tencent.mm.plugin.backup.i;

import android.content.Context;
import com.tencent.mm.g.a.aa;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<aa> {
    final /* synthetic */ a kus;

    a$1(a aVar) {
        this.kus = aVar;
        this.xen = aa.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        aa aaVar = (aa) bVar;
        if (aaVar != null && (aaVar instanceof aa)) {
            Context context = (Context) aaVar.fnS.fnT;
            c.mY(-1).j(new Object[]{context});
            x.i("MicroMsg.BackupCore", "receive BackupUSBStopActionEvent.");
        }
        return false;
    }
}
