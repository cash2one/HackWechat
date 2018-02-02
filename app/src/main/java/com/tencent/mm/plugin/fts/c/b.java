package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.xwalk.core.XWalkUpdater;

public final class b extends a {
    private SQLiteStatement mOq;

    protected final void AX() {
        if (AY()) {
            this.mJR.execSQL(String.format("DROP TABLE IF EXISTS %s", new Object[]{"Feature"}));
            t(-101, 2);
        }
        if (!this.mJR.AV("Feature")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CREATE TABLE IF NOT EXISTS Feature ( ");
            stringBuilder.append(c.gJc.xjB);
            stringBuilder.append(");");
            this.mJR.execSQL(stringBuilder.toString());
        }
        this.mOq = this.mJR.compileStatement(String.format("INSERT INTO %s (featureId, title, titlePY, titleShortPY, tag, actionType, url, helpUrl, updateUrl, androidUrl, iconPath, timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{"Feature"}));
    }

    protected final boolean AY() {
        return !cB(XWalkUpdater.ERROR_SET_VERNUM, 2);
    }

    public final List<a> aNk() {
        List<a> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Cursor rawQuery = this.mJR.rawQuery(String.format("SELECT entity_id, timestamp FROM %s", new Object[]{aMR()}), null);
        while (rawQuery.moveToNext()) {
            int i = rawQuery.getInt(0);
            if (hashSet.add(Integer.valueOf(i))) {
                a aVar = new a();
                aVar.mOr = i;
                aVar.timestamp = rawQuery.getLong(1);
                arrayList.add(aVar);
            }
        }
        rawQuery.close();
        return arrayList;
    }

    public final boolean aT(List<c> list) {
        boolean inTransaction = this.mJR.inTransaction();
        if (!inTransaction) {
            this.mJR.beginTransaction();
        }
        this.mJR.execSQL("Delete from Feature");
        for (c cVar : list) {
            try {
                this.mOq.bindLong(1, (long) cVar.field_featureId);
                this.mOq.bindString(2, cVar.field_title);
                this.mOq.bindString(3, cVar.field_titlePY);
                this.mOq.bindString(4, cVar.field_titleShortPY);
                this.mOq.bindString(5, cVar.field_tag);
                this.mOq.bindLong(6, (long) cVar.field_actionType);
                this.mOq.bindString(7, cVar.field_url);
                this.mOq.bindString(8, cVar.field_helpUrl);
                this.mOq.bindString(9, cVar.field_updateUrl);
                this.mOq.bindString(10, cVar.field_androidUrl);
                this.mOq.bindString(11, cVar.field_iconPath);
                this.mOq.bindLong(12, cVar.field_timestamp);
                long executeInsert = this.mOq.executeInsert();
                x.d("MicroMsg.FTS.FTS5FeatureStorage", "insertFeatureItem rowid=%d timestamp=%d", new Object[]{Long.valueOf(executeInsert), Long.valueOf(cVar.field_timestamp)});
            } catch (Exception e) {
            }
        }
        if (!inTransaction) {
            this.mJR.commit();
        }
        return true;
    }

    public final c qd(int i) {
        c cVar = null;
        Cursor rawQuery = this.mJR.rawQuery("Select * from Feature where featureId = " + i, null);
        try {
            if (rawQuery.moveToFirst()) {
                cVar = new c();
                cVar.b(rawQuery);
                rawQuery.close();
            }
            return cVar;
        } finally {
            rawQuery.close();
        }
    }

    protected final String getTableName() {
        return "Feature";
    }

    public final String getName() {
        return "FTS5FeatureStorage";
    }

    public final int getType() {
        return 17;
    }

    public final int getPriority() {
        return 17;
    }

    protected final boolean AZ() {
        super.AZ();
        this.mOq.close();
        return true;
    }

    protected final boolean aMT() {
        return true;
    }
}
