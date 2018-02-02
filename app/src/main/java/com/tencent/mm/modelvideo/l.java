package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.LinkedList;
import java.util.List;

public final class l extends i<j> {
    public static final String[] gJN = new String[]{i.a(j.gJc, "SightDraftInfo")};
    public e gJP;

    public l(e eVar) {
        super(eVar, j.gJc, "SightDraftInfo", null);
        this.gJP = eVar;
    }

    public final List<j> TP() {
        List linkedList = new LinkedList();
        String str = "SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC " + new StringBuilder(" LIMIT 5").toString();
        Cursor a = this.gJP.a(str, new String[]{"7"}, 2);
        if (a != null) {
            while (a.moveToNext()) {
                j jVar = new j();
                jVar.b(a);
                linkedList.add(jVar);
            }
            a.close();
        }
        return linkedList;
    }
}
