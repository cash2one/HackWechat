package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.plugin.i.b.a;
import com.tencent.mm.plugin.i.b.b;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class b$b implements Runnable {
    final /* synthetic */ b lgr;

    private b$b(b bVar) {
        this.lgr = bVar;
    }

    public final void run() {
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        b asH = com.tencent.mm.plugin.i.b.asG().asH();
        String a = b.a(this.lgr);
        long Wq = bh.Wq();
        String str = "select max(msgtime), min(msgtime) from WxFileIndex2 where username='" + a + "' and msgType in (43,62,44,3,49,268435505 )";
        Cursor cursor = null;
        try {
            cursor = asH.gJP.rawQuery(str, null);
            if (cursor != null && cursor.moveToFirst()) {
                pLong.value = cursor.getLong(0);
                pLong2.value = cursor.getLong(1);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", str);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        x.i("MicroMsg.WxFileIndexStorage", "getMediaMsgTimeByUsername [%s] cost[%d]", a, Long.valueOf(bh.bA(Wq)));
        pLong2.value--;
        long j = pLong.value;
        Wq = Math.max(j - 604800000, pLong2.value);
        try {
            if (!b.b(this.lgr)) {
                if (Wq == j) {
                    Wq--;
                }
                av(com.tencent.mm.plugin.i.b.asG().asH().h(b.a(this.lgr), j, Wq));
                b.c(this.lgr);
                j = Wq;
                while (!b.b(this.lgr) && j > pLong2.value) {
                    Wq = Math.max(j - 15552000000L, pLong2.value);
                    if (Wq == j) {
                        Wq--;
                    }
                    av(com.tencent.mm.plugin.i.b.asG().asH().h(b.a(this.lgr), j, Wq));
                    b.c(this.lgr);
                    j = Wq;
                }
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.CleanChattingDetailAdapter", e2, "", new Object[0]);
        }
    }

    private void av(List<a> list) {
        int size = list.size();
        HashMap hashMap = new HashMap();
        Collection arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            a aVar = (a) list.get(i);
            i iVar = (i) hashMap.get(Long.valueOf(aVar.field_msgId));
            if (iVar == null) {
                iVar = new i();
                hashMap.put(Long.valueOf(aVar.field_msgId), iVar);
                arrayList.add(iVar);
            }
            iVar.lfI.add(aVar);
            iVar.hVF = aVar.field_msgtime;
            iVar.userName = aVar.field_username;
            iVar.fpG = aVar.field_msgId;
            if (!com.tencent.mm.plugin.i.a.nA(aVar.field_msgSubType)) {
                iVar.size += aVar.field_size;
            }
            switch (aVar.field_msgSubType) {
                case 1:
                    iVar.filePath = g.Dj().gQh + aVar.field_path;
                    iVar.type = 3;
                    break;
                case 2:
                    iVar.fvC = g.Dj().gQh + aVar.field_path;
                    iVar.type = 3;
                    break;
                case 20:
                    iVar.filePath = g.Dj().gQh + aVar.field_path;
                    iVar.type = 1;
                    break;
                case 21:
                    iVar.fvC = g.Dj().gQh + aVar.field_path;
                    iVar.type = 1;
                    break;
                case 30:
                    iVar.filePath = g.Dj().gQh + aVar.field_path;
                    iVar.type = 1;
                    break;
                case 31:
                    iVar.fvC = g.Dj().gQh + aVar.field_path;
                    iVar.type = 1;
                    break;
                case 32:
                    iVar.filePath = g.Dj().gQh + aVar.field_path;
                    iVar.type = 4;
                    break;
                case 33:
                    iVar.fvC = g.Dj().gQh + aVar.field_path;
                    iVar.type = 4;
                    break;
                case 34:
                    iVar.filePath = g.Dj().gQh + aVar.field_path;
                    iVar.type = 4;
                    break;
                case 35:
                    iVar.fvC = g.Dj().gQh + aVar.field_path;
                    iVar.type = 4;
                    break;
                default:
                    break;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((i) it.next()).size <= 0) {
                it.remove();
            }
        }
        b.d(this.lgr).addAll(arrayList);
    }
}
