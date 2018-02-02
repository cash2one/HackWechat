package com.tencent.mm.plugin.welab.c;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class a extends i<com.tencent.mm.plugin.welab.c.a.a> {
    private e gJP;

    public final /* synthetic */ boolean a(c cVar) {
        return d((com.tencent.mm.plugin.welab.c.a.a) cVar);
    }

    public a(e eVar) {
        super(eVar, com.tencent.mm.plugin.welab.c.a.a.gJc, "LabAppInfo", null);
        this.gJP = eVar;
    }

    public final List<com.tencent.mm.plugin.welab.c.a.a> bVE() {
        Cursor Tj = Tj();
        List<com.tencent.mm.plugin.welab.c.a.a> arrayList = new ArrayList();
        while (Tj.moveToNext()) {
            com.tencent.mm.plugin.welab.c.a.a aVar = new com.tencent.mm.plugin.welab.c.a.a();
            aVar.b(Tj);
            arrayList.add(aVar);
        }
        Tj.close();
        return arrayList;
    }

    public final void ct(List<com.tencent.mm.plugin.welab.c.a.a> list) {
        long dz;
        h hVar;
        if (this.gJP instanceof h) {
            h hVar2 = (h) this.gJP;
            dz = hVar2.dz(-1);
            hVar = hVar2;
        } else {
            hVar = null;
            dz = 0;
        }
        for (com.tencent.mm.plugin.welab.c.a.a c : list) {
            c(c);
        }
        if (hVar != null) {
            hVar.fS(dz);
        }
    }

    public final void c(com.tencent.mm.plugin.welab.c.a.a aVar) {
        if (!d(aVar)) {
            b((c) aVar);
        }
    }

    private boolean d(com.tencent.mm.plugin.welab.c.a.a aVar) {
        c aVar2 = new com.tencent.mm.plugin.welab.c.a.a();
        aVar2.field_LabsAppId = aVar.field_LabsAppId;
        b(aVar2, new String[0]);
        if (aVar.field_sequence > aVar2.field_sequence) {
            return super.a(aVar);
        }
        x.i("LabAppInfoStorage", "sequence old origin.seq " + aVar2.field_sequence + " old.seq " + aVar.field_sequence);
        return false;
    }
}
