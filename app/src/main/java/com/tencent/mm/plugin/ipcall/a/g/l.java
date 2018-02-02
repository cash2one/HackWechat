package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class l extends i<k> {
    public static final String[] gJN = new String[]{i.a(k.gJc, "IPCallRecord")};
    public static final String[] nGQ = new String[]{"*", "rowid"};
    public e gJP;

    public l(e eVar) {
        super(eVar, k.gJc, "IPCallRecord", null);
        this.gJP = eVar;
    }

    public final Cursor CH(String str) {
        return this.gJP.query("IPCallRecord", nGQ, "phonenumber=?", new String[]{str}, null, null, "calltime desc");
    }

    public final Cursor dB(long j) {
        return this.gJP.query("IPCallRecord", nGQ, "addressId=?", new String[]{String.valueOf(j)}, null, null, "calltime desc");
    }

    public final void a(k kVar) {
        if (kVar != null) {
            a(kVar.xjy, kVar);
        }
    }
}
