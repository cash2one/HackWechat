package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.g.a.fz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class l$1 extends c<fz> {
    final /* synthetic */ l lsP;

    l$1(l lVar) {
        this.lsP = lVar;
        this.xen = fz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fz fzVar = (fz) bVar;
        switch (fzVar.fvY.fvZ) {
            case 1:
                this.lsP.lsp.i(fzVar.fvY.id, fzVar.fvY.path);
                break;
            case 2:
                this.lsP.lsp.cc(fzVar.fvY.id);
                break;
            case 4:
                this.lsP.lsp.b(fzVar.fvY.id, fzVar.fvY.errCode, fzVar.fvY.fwa);
                break;
            case 5:
                this.lsP.lsp.cb(fzVar.fvY.id);
                break;
            case 6:
                this.lsP.lsp.j(fzVar.fvY.id, fzVar.fvY.path);
                break;
            case 7:
                this.lsP.lsp.cd(fzVar.fvY.id);
                break;
            case 101:
                f aAd = f.aAd();
                aAd.lsi = aAd.aAf();
                break;
        }
        return true;
    }
}
