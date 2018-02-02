package com.tencent.mm.plugin.profile.ui;

import android.os.Looper;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.List;

public final class a extends o implements k {
    af handler = new af(Looper.getMainLooper());
    x jLe;
    private List<j> mOV;

    public a(l lVar, int i, x xVar) {
        super(lVar, new ArrayList(), true, false, i);
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

    public final void b(h hVar) {
        if (hVar.bjW == 0) {
            this.mOV = hVar.mMc;
        }
        notifyDataSetChanged();
    }
}
