package com.tencent.mm.modelvideo;

import com.tencent.mm.g.a.jj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.n.2;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class n$3 extends c<jj> {
    final /* synthetic */ n hUY;

    n$3(n nVar) {
        this.hUY = nVar;
        this.xen = jj.class.getName().hashCode();
    }

    private boolean a(jj jjVar) {
        x.d("MicroMsg.SubCoreMediaRpt", "get media info report event.");
        if (jjVar == null) {
            return false;
        }
        String str;
        String str2 = jjVar.fzN.path;
        try {
            if (str2.endsWith(".tmp")) {
                str2 = str2.substring(0, str2.lastIndexOf(".tmp"));
                x.i("MicroMsg.SubCoreMediaRpt", "media info event path[%s, %s]", new Object[]{str2, jjVar.fzN.path});
            }
            str = str2;
        } catch (Exception e) {
            str = str2;
        }
        n nVar = this.hUY;
        String str3 = jjVar.fzN.fzO;
        String str4 = jjVar.fzN.fzP;
        int i = jjVar.fzN.fzQ;
        String str5 = jjVar.fzN.fzR;
        String str6 = jjVar.fzN.fzT;
        long j = jjVar.fzN.startTime;
        long j2 = jjVar.fzN.endTime;
        g.Dm().F(new 2(nVar, str, jjVar.fzN.fzS, str3, str4, i, str5, str6, j, j2, jjVar.fzN.fzU, jjVar.fzN.fzV, jjVar.fzN.fzW));
        return false;
    }
}
