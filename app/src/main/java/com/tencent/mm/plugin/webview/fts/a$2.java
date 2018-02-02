package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.widget.g;
import java.util.List;

class a$2 implements c {
    final /* synthetic */ List msj;
    final /* synthetic */ g nal;
    final /* synthetic */ a tlq;

    public a$2(a aVar, List list, g gVar) {
        this.tlq = aVar;
        this.msj = list;
        this.nal = gVar;
    }

    public final void a(n nVar) {
        for (int i = 0; i < this.msj.size(); i++) {
            z zVar = (z) this.msj.get(i);
            nVar.a(i, zVar.title, zVar.desc);
            if (zVar.nuE) {
                this.nal.ztz = i;
            }
        }
    }
}
