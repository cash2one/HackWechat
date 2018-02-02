package com.tencent.mm.plugin.fav.b.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class e extends i<h> implements p {
    private com.tencent.mm.sdk.e.e gJP;

    public final /* synthetic */ boolean a(h hVar) {
        return super.b(hVar);
    }

    public final /* synthetic */ boolean a(h hVar, String[] strArr) {
        return super.c(hVar, strArr);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, h.gJc, "FavSearchInfo", null);
        this.gJP = eVar;
    }

    public final ArrayList<Long> a(List<String> list, List<String> list2, List<Integer> list3) {
        String str;
        ArrayList<Long> arrayList = new ArrayList();
        String str2 = "select localId from FavSearchInfo";
        String str3 = " 1=1 ";
        if (!(list == null || list.isEmpty())) {
            str = str3;
            for (String str32 : list) {
                str = str + " and content like '%" + str32 + "%'";
            }
            str32 = str;
        }
        if (!(list2 == null || list2.isEmpty())) {
            str = str32;
            for (String str322 : list2) {
                str = str + " and tagContent like '%" + str322 + "%'";
            }
            str322 = str;
        }
        str322 = str2 + " where " + str322;
        if (!(list3 == null || list3.isEmpty())) {
            str322 = str322 + " and ((1=1 ";
            str = str322;
            for (Integer intValue : list3) {
                str = str + " and type = " + intValue.intValue();
            }
            str322 = str + ") or (1=1";
            str = str322;
            for (Integer intValue2 : list3) {
                str = str + " and subtype & " + h.pG(intValue2.intValue()) + " != 0";
            }
            str322 = str + "))";
        }
        x.d("MicroMsg.FavSearchStorage", "search id sql {%s}", new Object[]{str322 + " order by time desc"});
        Cursor a = this.gJP.a(str322, null, 2);
        if (a == null) {
            return arrayList;
        }
        while (a.moveToNext()) {
            arrayList.add(Long.valueOf(a.getLong(0)));
        }
        a.close();
        return arrayList;
    }

    public final boolean zV(String str) {
        if (bh.ov(str)) {
            return false;
        }
        int i;
        x.d("MicroMsg.FavSearchStorage", "is tag exist sql {%s}", new Object[]{"select count(localId) from FavSearchInfo where tagContent like '%" + str + "%'"});
        Cursor a = this.gJP.a(r2, null, 2);
        if (a == null || !a.moveToFirst()) {
            i = 0;
        } else {
            i = a.getInt(0);
        }
        if (a != null) {
            a.close();
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    public final void dd(long j) {
        this.gJP.fx("FavSearchInfo", "delete from FavSearchInfo where localId = " + j);
    }

    public final h de(long j) {
        h hVar = null;
        Cursor a = this.gJP.a("select * from FavSearchInfo where localId = " + j, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                hVar = new h();
                hVar.b(a);
            }
            a.close();
        }
        return hVar;
    }
}
