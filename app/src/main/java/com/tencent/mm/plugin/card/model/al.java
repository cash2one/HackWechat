package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class al extends i<ak> {
    public static final String[] gJN = new String[]{i.a(ak.gJc, "PendingCardId")};
    e gJP;

    public al(e eVar) {
        super(eVar, ak.gJc, "PendingCardId", null);
        this.gJP = eVar;
    }

    public final List<ak> aux() {
        List<ak> arrayList = new ArrayList();
        Cursor a = this.gJP.a("select * from PendingCardId where retryCount < 10", null, 2);
        while (a.moveToNext()) {
            ak akVar = new ak();
            akVar.b(a);
            arrayList.add(akVar);
        }
        a.close();
        x.d("MicroMsg.PendingCardIdInfoStorage", "getAll, count = %d", new Object[]{Integer.valueOf(arrayList.size())});
        return arrayList;
    }
}
