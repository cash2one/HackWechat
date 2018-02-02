package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.plugin.appbrand.compat.a.d;

final class b implements d {
    b() {
    }

    public final void a(String str, a aVar, com.tencent.mm.ae.g.b bVar) {
        com.tencent.mm.sdk.b.b ezVar = new ez();
        ezVar.ftT.op = 1;
        ezVar.ftT.fileName = str;
        ezVar.ftT.ftV = true;
        ezVar.ftT.fjt = true;
        ezVar.ftT.ftW = aVar;
        ezVar.ftT.ftX = bVar;
        com.tencent.mm.sdk.b.a.xef.m(ezVar);
    }

    public final void pause() {
        com.tencent.mm.sdk.b.b ezVar = new ez();
        ezVar.ftT.op = 4;
        com.tencent.mm.sdk.b.a.xef.m(ezVar);
    }

    public final void stop() {
        com.tencent.mm.sdk.b.b ezVar = new ez();
        ezVar.ftT.op = 2;
        com.tencent.mm.sdk.b.a.xef.m(ezVar);
    }
}
