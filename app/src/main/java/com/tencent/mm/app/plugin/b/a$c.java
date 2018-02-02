package com.tencent.mm.app.plugin.b;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ex;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public class a$c extends c<ex> {
    public a$c() {
        this.xen = ex.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ex exVar = (ex) bVar;
        k jVar = new j(exVar.ftO.toUserName, exVar.ftO.content, exVar.ftO.type);
        exVar.ftP.ftQ = jVar;
        exVar.ftP.fqm = jVar.fqm;
        return true;
    }
}
