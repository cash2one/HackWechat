package com.tencent.mm.storage;

import android.util.SparseArray;
import com.tencent.mm.by.h;
import com.tencent.mm.g.b.f;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.List;

public final class g extends i<f> {
    public static final String[] gJN = new String[]{i.a(f.vJ(), "AddContactAntispamTicket")};
    private h hhp;
    SparseArray<String> xmv = new SparseArray();

    public g(e eVar) {
        super(eVar, f.vJ(), "AddContactAntispamTicket", null);
        this.hhp = (h) eVar;
    }

    public final void x(String str, int i, String str2) {
        if (!bh.ov(str)) {
            c aVar = new a();
            aVar.field_userName = str;
            aVar.field_scene = i;
            aVar.field_ticket = str2;
            a(aVar);
            fB(str, str2);
        }
    }

    public final void cC(List<f> list) {
        if (list.size() != 0) {
            long dz = this.hhp.dz(Thread.currentThread().getId());
            for (f a : list) {
                a(a);
            }
            this.hhp.fS(dz);
        }
    }

    public final void fB(String str, String str2) {
        if (!bh.ov(str)) {
            this.xmv.put(str.hashCode(), str2);
        }
    }

    public final String Wr(String str) {
        if (bh.ov(str)) {
            return null;
        }
        String str2 = (String) this.xmv.get(str.hashCode());
        if (!bh.ov(str2)) {
            return str2;
        }
        c aVar = new a();
        aVar.field_userName = str;
        if (!b(aVar, "userName")) {
            return null;
        }
        String str3 = aVar.field_userName;
        int i = aVar.field_scene;
        fB(str3, aVar.field_ticket);
        return aVar.field_ticket;
    }
}
