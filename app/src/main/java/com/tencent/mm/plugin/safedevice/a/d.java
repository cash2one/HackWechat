package com.tencent.mm.plugin.safedevice.a;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.LinkedList;
import java.util.List;

public final class d extends i<c> {
    public static final String[] gJN = new String[]{i.a(c.gJc, "SafeDeviceInfo")};
    h pRg = null;

    public final /* bridge */ /* synthetic */ boolean b(c cVar) {
        return super.b((c) cVar);
    }

    public d(e eVar) {
        super(eVar, c.gJc, "SafeDeviceInfo", null);
        if (eVar instanceof h) {
            this.pRg = (h) eVar;
        }
    }

    public final boolean a(c cVar) {
        return super.b(cVar);
    }

    public final List<c> bop() {
        List<c> linkedList = new LinkedList();
        if (getCount() > 0) {
            Cursor Tj = super.Tj();
            while (Tj.moveToNext()) {
                c cVar = new c();
                cVar.b(Tj);
                linkedList.add(cVar);
            }
            Tj.close();
        }
        return linkedList;
    }
}
