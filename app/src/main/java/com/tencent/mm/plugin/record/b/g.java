package com.tencent.mm.plugin.record.b;

import android.database.Cursor;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class g extends i<com.tencent.mm.plugin.record.a.g> implements e {
    private com.tencent.mm.sdk.e.e gJP;

    public g(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, com.tencent.mm.plugin.record.a.g.gJc, "RecordMessageInfo", null);
        this.gJP = eVar;
    }

    public final List<com.tencent.mm.plugin.record.a.g> bmN() {
        List<com.tencent.mm.plugin.record.a.g> linkedList = new LinkedList();
        Cursor Tj = Tj();
        if (Tj != null) {
            Tj.moveToFirst();
            while (!Tj.isAfterLast()) {
                com.tencent.mm.plugin.record.a.g gVar = new com.tencent.mm.plugin.record.a.g();
                gVar.b(Tj);
                linkedList.add(gVar);
                Tj.moveToNext();
            }
            Tj.close();
        }
        x.d("MicroMsg.RecordMsgStorage", "get all finish, result count %d", new Object[]{Integer.valueOf(linkedList.size())});
        return linkedList;
    }

    public final void vq(int i) {
        int delete = this.gJP.delete("RecordMessageInfo", "localId=?", new String[]{String.valueOf(i)});
        x.d("MicroMsg.RecordMsgStorage", "delete record msg item, local id %d, result %d", new Object[]{Integer.valueOf(i), Integer.valueOf(delete)});
    }

    public final com.tencent.mm.plugin.record.a.g vr(int i) {
        com.tencent.mm.plugin.record.a.g gVar = null;
        x.d("MicroMsg.RecordMsgStorage", "get by local id, sql[%s], local[%d]", new Object[]{"SELECT * FROM RecordMessageInfo WHERE localId=" + i, Integer.valueOf(i)});
        Cursor a = this.gJP.a(r1, null, 2);
        if (a != null && a.moveToFirst()) {
            gVar = new com.tencent.mm.plugin.record.a.g();
            gVar.b(a);
        }
        if (a != null) {
            a.close();
        }
        return gVar;
    }
}
