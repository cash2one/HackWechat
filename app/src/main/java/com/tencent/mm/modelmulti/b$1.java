package com.tencent.mm.modelmulti;

import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ao;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Iterator;

class b$1 implements Runnable {
    final /* synthetic */ b hEG;

    b$1(b bVar) {
        this.hEG = bVar;
    }

    public final void run() {
        Cursor Tj = ar.Hg().FK().Tj();
        if (Tj != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            if (Tj.moveToFirst()) {
                while (!Tj.isAfterLast()) {
                    ao aoVar = new ao();
                    aoVar.b(Tj);
                    if (aoVar.field_originSvrId != 0) {
                        if (currentTimeMillis > 604800000 + (aoVar.field_createTime * 1000)) {
                            arrayList.add(aoVar);
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr get syscmdinfo from db originSvrId[%d] but expired and delete", new Object[]{Long.valueOf(aoVar.field_originSvrId)});
                        } else {
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr get syscmdinfo from db originSvrId[%d]", new Object[]{Long.valueOf(aoVar.field_originSvrId)});
                            this.hEG.hEE.put(Long.valueOf(aoVar.field_originSvrId), aoVar);
                        }
                    }
                    Tj.moveToNext();
                }
            }
            Tj.close();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ao aoVar2 = (ao) it.next();
                ar.Hg().FK().a(aoVar2, false, new String[]{""});
            }
        }
    }
}
