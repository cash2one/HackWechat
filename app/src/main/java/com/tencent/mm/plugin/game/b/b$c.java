package com.tencent.mm.plugin.game.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c;
import java.util.ArrayList;
import java.util.Collections;

class b$c extends f {
    final /* synthetic */ b mVK;

    b$c(b bVar, g gVar) {
        this.mVK = bVar;
        super(gVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void a(h hVar) {
        hVar.mMb = e.an(this.mLN.fDj, true);
        hVar.mMc = new ArrayList();
        Cursor a = this.mVK.mVJ.a(hVar.mMb, c.mKd, this.mLN.mLV, true, true);
        while (a.moveToNext()) {
            k kVar = new k();
            kVar.h(a);
            kVar.aMY();
            hVar.mMc.add(kVar);
        }
        if (a != null) {
            a.close();
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        } else if (this.mLN.mLY != null) {
            Collections.sort(hVar.mMc, this.mLN.mLY);
        }
    }

    public final String getName() {
        return "SearchGameTask";
    }

    public final int getId() {
        return 10;
    }
}
