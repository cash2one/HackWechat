package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.g.a.mq;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.plugin.ac.a.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class n$3 implements a {
    final /* synthetic */ n pTn;

    n$3(n nVar) {
        this.pTn = nVar;
    }

    public final void j(String str, String str2, int i, int i2) {
        x.i("MicroMsg.RecogQBarOfImageFileListener", "result: %s, codeType: %s, codeVersion: %s, filePath:%s", new Object[]{str2, Integer.valueOf(i), Integer.valueOf(i2), str});
        l.pST.aUb();
        b mrVar = new mr();
        mrVar.fED.filePath = str;
        mrVar.fED.result = str2;
        mrVar.fED.fqb = i;
        mrVar.fED.fqc = i2;
        com.tencent.mm.sdk.b.a.xef.m(mrVar);
    }

    public final void HX(String str) {
        x.i("MicroMsg.RecogQBarOfImageFileListener", "result(failed): %s", new Object[]{str});
        b mqVar = new mq();
        mqVar.fEC.filePath = str;
        com.tencent.mm.sdk.b.a.xef.m(mqVar);
    }
}
