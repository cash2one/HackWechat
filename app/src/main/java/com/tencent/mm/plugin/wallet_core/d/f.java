package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.ArrayList;

public final class f extends i<x> {
    public static final String[] gJN = new String[]{i.a(x.gJc, "WalletKindInfo")};
    public e gJP;

    public f(e eVar) {
        super(eVar, x.gJc, "WalletKindInfo", null);
        this.gJP = eVar;
    }

    public final ArrayList<x> bMm() {
        ArrayList<x> arrayList = null;
        Cursor a = this.gJP.a("select * from WalletKindInfo", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    x xVar = new x();
                    xVar.b(a);
                    arrayList.add(xVar);
                } while (a.moveToNext());
            }
            a.close();
        }
        return arrayList;
    }
}
