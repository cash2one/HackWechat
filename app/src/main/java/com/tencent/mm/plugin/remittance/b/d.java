package com.tencent.mm.plugin.remittance.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class d extends i<c> {
    public static final String[] gJN = new String[]{i.a(c.gJc, "RemittanceRecord")};
    private static final String[] ihe = new String[]{"*", "rowid"};
    public static Map<String, c> ihf = new HashMap();
    private e gJP;

    public final /* synthetic */ boolean a(c cVar, String[] strArr) {
        c cVar2 = (c) cVar;
        if (cVar2 != null && ihf.containsKey(cVar2.field_transferId)) {
            ihf.remove(cVar2.field_transferId);
        }
        return super.a(cVar2, strArr);
    }

    public final /* synthetic */ boolean b(c cVar) {
        c cVar2 = (c) cVar;
        if (cVar2 != null && ihf.containsKey(cVar2.field_transferId)) {
            ihf.put(cVar2.field_transferId, cVar2);
        }
        return super.b(cVar2);
    }

    public d(e eVar) {
        super(eVar, c.gJc, "RemittanceRecord", null);
        this.gJP = eVar;
    }

    public final c Ip(String str) {
        if (bh.ov(str)) {
            return null;
        }
        Cursor a = this.gJP.a("RemittanceRecord", ihe, "transferId=?", new String[]{str}, null, null, null, 2);
        c cVar;
        try {
            if (a.moveToFirst()) {
                cVar = new c();
                cVar.b(a);
                return cVar;
            }
            a.close();
            return null;
        } catch (Exception e) {
            cVar = e;
            x.printErrStackTrace("MicroMsg.RemittanceSendRecordStorage", cVar, "getRecordByTransferId error: %s", new Object[]{cVar.getMessage()});
            return null;
        } finally {
            a.close();
        }
    }

    public final boolean a(c cVar) {
        if (cVar != null && ihf.containsKey(cVar.field_transferId)) {
            ihf.put(cVar.field_transferId, cVar);
        }
        return super.a(cVar);
    }
}
