package com.tencent.mm.plugin.extqlauncher;

import com.tencent.mm.g.a.es;
import com.tencent.mm.plugin.extqlauncher.provider.ExtControlProviderQLauncher;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public class b$a extends c<es> {
    public b$a() {
        this.xen = es.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        es esVar = (es) bVar;
        if (esVar instanceof es) {
            ExtControlProviderQLauncher extControlProviderQLauncher = new ExtControlProviderQLauncher(esVar.ftk.fmW, esVar.ftk.ftm, esVar.ftk.context);
            esVar.ftl.ftn = extControlProviderQLauncher.query(esVar.ftk.uri, null, null, esVar.ftk.selectionArgs, null);
            return true;
        }
        x.f("MicroMsg.SubCoreExtQLauncher", "mismatched event");
        return false;
    }
}
