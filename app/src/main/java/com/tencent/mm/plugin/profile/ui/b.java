package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.List;

public final class b extends m {
    private String fDj;
    private af handler = new af();
    private x jLe;
    private a mMa;
    private List<j> mOV;
    private k phA = new k(this) {
        final /* synthetic */ b phB;

        {
            this.phB = r1;
        }

        public final void b(h hVar) {
            if (hVar.bjW == 0) {
                this.phB.mOV = hVar.mMc;
                if (this.phB.ySU != null) {
                    this.phB.ySU.r(hVar.mJc.fDj, this.phB.mOV.size(), true);
                }
            }
            this.phB.notifyDataSetChanged();
        }
    };

    public b(l lVar, int i, x xVar) {
        super(lVar, false, i);
        this.jLe = xVar;
    }

    protected final com.tencent.mm.ui.contact.a.a jb(int i) {
        com.tencent.mm.ui.contact.a.a eVar = new e(i);
        ar.Hg();
        eVar.jLe = c.EY().WO(((j) this.mOV.get(i)).mLs);
        return eVar;
    }

    public final int getCount() {
        if (this.mOV == null) {
            return 0;
        }
        return this.mOV.size();
    }

    public final void a(String str, int[] iArr, boolean z) {
        this.fDj = str;
        g gVar = new g();
        gVar.fDj = str;
        gVar.handler = this.handler;
        gVar.mLZ = this.phA;
        gVar.mLS = this.jLe.field_username;
        gVar.mLR = 7;
        this.mMa = ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).search(2, gVar);
    }

    public final void aaS() {
        this.fDj = null;
        if (this.mMa != null) {
            ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).cancelSearchTask(this.mMa);
        }
    }
}
