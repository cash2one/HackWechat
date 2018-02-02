package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.by.g;
import com.tencent.mm.by.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends i<i> implements a {
    public static final String[] gJN = new String[]{i.a(i.gJc, "IPCallPopularCountry")};
    public e gJP;
    public m hwl = new 1(this);

    public j(e eVar) {
        super(eVar, i.gJc, "IPCallPopularCountry", null);
        this.gJP = eVar;
    }

    public final String getTableName() {
        return "IPCallPopularCountry";
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gJP = gVar;
        }
        return 0;
    }

    public final void x(int i, long j) {
        boolean a;
        c iVar = new i();
        Cursor a2 = this.gJP.a("IPCallPopularCountry", null, "countryCode=?", new String[]{Integer.toString(i)}, null, null, null, 2);
        if (a2.moveToFirst()) {
            iVar.b(a2);
            iVar.field_callTimeCount++;
            iVar.field_lastCallTime = j;
            a = super.a(iVar);
            a2.close();
        } else {
            x.i("MicroMsg.IPCallPopularCountryStorage", "get null with countryCode:" + i);
            a2.close();
            iVar.field_countryCode = i;
            iVar.field_lastCallTime = j;
            iVar.field_callTimeCount = 1;
            a = b(iVar);
        }
        x.i("MicroMsg.IPCallPopularCountryStorage", "updatePopularCountryCode ret:" + a);
    }
}
