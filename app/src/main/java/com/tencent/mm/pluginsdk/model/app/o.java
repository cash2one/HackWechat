package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import com.tencent.mm.g.b.p;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class o extends i<p> {
    public static final String[] gJN = new String[]{i.a(n.gJc, "AppSort")};
    public e gJP;

    public o(e eVar) {
        super(eVar, n.gJc, "AppSort", null);
        this.gJP = eVar;
        eVar.fx("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( flag )");
        eVar.fx("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( sortId )");
    }

    public final List<String> fs(long j) {
        List<String> arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("select * from AppSort");
        stringBuilder.append(" where ");
        stringBuilder.append("flag = ").append(j);
        stringBuilder.append(" order by sortId desc ");
        Cursor rawQuery = rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            x.e("MicroMsg.AppSortStorage", "getAppListByFlag : cursor is null");
            return null;
        }
        x.d("MicroMsg.AppSortStorage", "getAppListByFlag count = %d", Integer.valueOf(rawQuery.getCount()));
        int columnIndex = rawQuery.getColumnIndex("appId");
        while (rawQuery.moveToNext()) {
            arrayList.add(rawQuery.getString(columnIndex));
        }
        rawQuery.close();
        return arrayList;
    }

    public final boolean a(n nVar) {
        return super.b((c) nVar);
    }
}
