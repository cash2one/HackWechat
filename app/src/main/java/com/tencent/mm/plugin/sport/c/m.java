package com.tencent.mm.plugin.sport.c;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.b.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class m extends i<e> {
    public static final String[] rUj = new String[]{i.a(e.gJc, "SportStepItem")};
    private static final String[] rUk;

    static {
        r0 = new String[2];
        r0[0] = String.format("CREATE INDEX IF NOT EXISTS %s_date ON %s(date);", new Object[]{"SportStepItem", "SportStepItem"});
        r0[1] = String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[]{"SportStepItem", "SportStepItem"});
        rUk = r0;
    }

    public m() {
        super(g.Dj().gQj, e.gJc, "SportStepItem", rUk);
    }

    public static List<e> C(long j, long j2) {
        List arrayList = new ArrayList();
        String format = String.format("SELECT * FROM %s WHERE timestamp >= ? AND timestamp <= ?;", new Object[]{"SportStepItem"});
        Cursor a = g.Dj().gQj.a(format, new String[]{String.valueOf(j), String.valueOf(j2)}, 0);
        while (a.moveToNext()) {
            e eVar = new e();
            eVar.b(a);
            arrayList.add(eVar);
        }
        a.close();
        return arrayList;
    }

    public static e bDg() {
        e eVar = null;
        Cursor a = g.Dj().gQj.a(String.format("SELECT * FROM %s ORDER BY timestamp desc LIMIT 1;", new Object[]{"SportStepItem"}), null, 0);
        try {
            if (a.moveToNext()) {
                eVar = new e();
                eVar.b(a);
            } else {
                a.close();
            }
            return eVar;
        } finally {
            a.close();
        }
    }

    public static void D(long j, long j2) {
        g.Dj().gQj.fx(null, String.format("DELETE FROM %s WHERE timestamp >= %d AND timestamp <= endTime", new Object[]{"SportStepItem", Long.valueOf(j), Long.valueOf(j2)}));
    }

    public static void cb(List<e> list) {
        SQLiteDatabase ckV = g.Dj().gQj.ckV();
        if (!ckV.inTransaction()) {
            ckV.beginTransaction();
        }
        SQLiteStatement compileStatement = ckV.compileStatement(String.format("INSERT INTO %s (date, step, timestamp) VALUES (?,?,?)", new Object[]{"SportStepItem"}));
        for (e eVar : list) {
            compileStatement.bindString(1, eVar.field_date);
            compileStatement.bindLong(2, (long) eVar.field_step);
            compileStatement.bindLong(3, eVar.field_timestamp);
            compileStatement.execute();
        }
        if (ckV.inTransaction()) {
            ckV.setTransactionSuccessful();
            ckV.endTransaction();
        }
    }
}
