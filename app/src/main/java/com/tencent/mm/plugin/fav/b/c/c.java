package com.tencent.mm.plugin.fav.b.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fav.a.e;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class c extends i<e> implements l {
    private com.tencent.mm.sdk.e.e gJP;

    public final /* synthetic */ boolean a(e eVar) {
        return super.b(eVar);
    }

    public final /* synthetic */ boolean a(e eVar, String[] strArr) {
        return super.c(eVar, strArr);
    }

    public c(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, e.gJc, "FavEditInfo", null);
        this.gJP = eVar;
        this.gJP.fx("FavEditInfo", "CREATE INDEX IF NOT EXISTS IndexLocalId_Type ON FavEditInfo(localId,type);");
    }

    public final e da(long j) {
        e eVar = null;
        Cursor a = this.gJP.a("select * from FavEditInfo where localId =  ? and type =  ?", new String[]{String.valueOf(j), "0"}, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                eVar = new e();
                eVar.b(a);
            }
            a.close();
        }
        return eVar;
    }

    public final void n(long j, int i) {
        this.gJP.delete("FavEditInfo", "localId=? and type=?", new String[]{String.valueOf(j), String.valueOf(i)});
    }

    public final List<e> aHX() {
        Cursor a = this.gJP.a("select count(*) from FavEditInfo", null, 2);
        if (a == null) {
            x.e("MicroMsg.Fav.FavEditInfoStorage", "count all edit info, cursor is null");
            return null;
        }
        try {
            if (a.moveToFirst()) {
                x.i("MicroMsg.Fav.FavEditInfoStorage", "get all edit infos, count %d", new Object[]{Integer.valueOf(a.getInt(0))});
            }
            a.close();
            a = this.gJP.a("select * from FavEditInfo", null, 2);
            if (a == null) {
                return null;
            }
            List<e> arrayList = new ArrayList();
            try {
                if (a.moveToFirst()) {
                    do {
                        e eVar = new e();
                        eVar.b(a);
                        arrayList.add(eVar);
                    } while (a.moveToNext());
                }
                a.close();
                return arrayList;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Fav.FavEditInfoStorage", e, "", new Object[0]);
                a.close();
                return null;
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Fav.FavEditInfoStorage", e2, "", new Object[0]);
            a.close();
            return null;
        }
    }
}
