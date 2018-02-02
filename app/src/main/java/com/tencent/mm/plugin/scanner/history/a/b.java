package com.tencent.mm.plugin.scanner.history.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class b extends i<a> {
    public static final String[] gJN = new String[]{i.a(a.gJc, "ScanHistoryItem")};
    public e gJP;

    public b(e eVar) {
        super(eVar, a.gJc, "ScanHistoryItem", null);
        this.gJP = eVar;
    }

    public final Cursor Tj() {
        return this.gJP.rawQuery("select * from ScanHistoryItem order by ScanTime desc", null);
    }
}
