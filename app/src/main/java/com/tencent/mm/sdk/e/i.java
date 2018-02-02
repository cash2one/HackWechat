package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public abstract class i<T extends c> extends j implements d<T> {
    public int field_MARK_CURSOR_CHECK_IGNORE = 1;
    private final e gJP;
    public final a xjC;
    private final String xjD;

    public i(e eVar, a aVar, String str, String[] strArr) {
        int i = 0;
        this.gJP = eVar;
        this.xjC = aVar;
        this.xjC.xjz = bh.ov(this.xjC.xjz) ? "rowid" : this.xjC.xjz;
        this.xjD = str;
        List a = a(this.xjC, getTableName(), this.gJP);
        for (int i2 = 0; i2 < a.size(); i2++) {
            if (!this.gJP.fx(this.xjD, (String) a.get(i2))) {
                x.i("MicroMsg.SDK.MAutoStorage", "updateColumnSQLs table failed %s, sql %s", this.xjD, a.get(i2));
            }
        }
        if (strArr != null && strArr.length > 0) {
            while (i < strArr.length) {
                this.gJP.fx(this.xjD, strArr[i]);
                i++;
            }
        }
    }

    public String getTableName() {
        return this.xjD;
    }

    public static String a(a aVar, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE IF NOT EXISTS " + str + " ( ");
        stringBuilder.append(aVar.xjB);
        stringBuilder.append(");");
        return stringBuilder.toString();
    }

    public static List<String> a(a aVar, String str, e eVar) {
        List<String> arrayList = new ArrayList();
        if (eVar == null || str == null) {
            boolean z;
            String str2 = "MicroMsg.SDK.MAutoStorage";
            String str3 = "dk getUpdateSQLs db==null :%b  table:%s";
            Object[] objArr = new Object[2];
            if (eVar == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = str;
            x.e(str2, str3, objArr);
            return arrayList;
        }
        Cursor a = eVar.a("PRAGMA table_info( " + str + " )", new String[0], 2);
        if (a == null) {
            return arrayList;
        }
        Map hashMap = new HashMap();
        int columnIndex = a.getColumnIndex("name");
        int columnIndex2 = a.getColumnIndex(DownloadSettingTable$Columns.TYPE);
        while (a.moveToNext()) {
            hashMap.put(a.getString(columnIndex), a.getString(columnIndex2));
        }
        a.close();
        for (Entry entry : aVar.xjA.entrySet()) {
            String str4 = (String) entry.getValue();
            String str5 = (String) entry.getKey();
            if (str4 != null && str4.length() > 0) {
                String str6 = (String) hashMap.get(str5);
                if (str6 == null) {
                    arrayList.add("ALTER TABLE " + str + " ADD COLUMN " + str5 + " " + str4 + ";");
                    hashMap.remove(str5);
                } else if (!str4.toLowerCase().startsWith(str6.toLowerCase())) {
                    x.e("MicroMsg.SDK.MAutoStorage", "conflicting alter table on column: " + str5 + ", " + str6 + "<o-n>" + str4);
                    hashMap.remove(str5);
                }
            }
        }
        return arrayList;
    }

    public final boolean fx(String str, String str2) {
        if (str.length() == 0) {
            We("null or nill table");
            return false;
        } else if (str2 != null && str2.length() != 0) {
            return this.gJP.fx(str, str2);
        } else {
            We("null or nill sql");
            return false;
        }
    }

    public boolean b(T t) {
        return a((c) t, true);
    }

    public boolean a(T t, boolean z) {
        ContentValues vI = t.vI();
        if (vI == null || vI.size() <= 0) {
            We("insert failed, value.size <= 0");
            return false;
        }
        t.xjy = this.gJP.insert(getTableName(), this.xjC.xjz, vI);
        if (t.xjy <= 0) {
            We("insert failed");
            return false;
        }
        vI.put("rowid", Long.valueOf(t.xjy));
        if (z) {
            Wc(vI.getAsString(this.xjC.xjz));
        }
        return true;
    }

    public boolean a(T t, boolean z, String... strArr) {
        boolean z2 = false;
        ContentValues vI = t.vI();
        if (vI == null || vI.size() <= 0) {
            We("delete failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            Wd("delete with primary key");
            if (this.gJP.delete(getTableName(), this.xjC.xjz + " = ?", new String[]{bh.ou(vI.getAsString(this.xjC.xjz))}) > 0) {
                z2 = true;
            }
            if (!z2 || !z) {
                return z2;
            }
            doNotify();
            return z2;
        } else {
            StringBuilder a = a(vI, strArr);
            if (a == null) {
                We("delete failed, check keys failed");
                return false;
            } else if (this.gJP.delete(getTableName(), a.toString(), a(strArr, vI)) <= 0 || !z) {
                We("delete failed");
                return false;
            } else {
                Wc(this.xjC.xjz);
                return true;
            }
        }
    }

    public boolean a(T t, String... strArr) {
        return a((c) t, true, strArr);
    }

    public boolean delete(long j) {
        boolean z = true;
        if (this.gJP.delete(getTableName(), "rowid = ?", new String[]{String.valueOf(j)}) <= 0) {
            z = false;
        }
        if (z) {
            doNotify();
        }
        return z;
    }

    public final boolean b(long j, T t) {
        Cursor a = this.gJP.a(getTableName(), this.xjC.columns, "rowid = ?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            t.b(a);
            a.close();
            return true;
        }
        a.close();
        return false;
    }

    public boolean b(T t, String... strArr) {
        ContentValues vI = t.vI();
        if (vI == null || vI.size() <= 0) {
            We("get failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            Wd("get with primary key");
            r0 = this.gJP.a(getTableName(), this.xjC.columns, this.xjC.xjz + " = ?", new String[]{bh.ou(vI.getAsString(this.xjC.xjz))}, null, null, null, 2);
            if (r0.moveToFirst()) {
                t.b(r0);
                r0.close();
                return true;
            }
            r0.close();
            return false;
        } else {
            StringBuilder a = a(vI, strArr);
            if (a == null) {
                We("get failed, check keys failed");
                return false;
            }
            r0 = this.gJP.a(getTableName(), this.xjC.columns, a.toString(), a(strArr, vI), null, null, null, 2);
            if (r0.moveToFirst()) {
                t.b(r0);
                r0.close();
                return true;
            }
            r0.close();
            Wd("get failed, not found");
            return false;
        }
    }

    public final boolean a(long j, T t, boolean z) {
        ContentValues vI = t.vI();
        if (vI == null || vI.size() <= 0) {
            We("update failed, value.size <= 0");
            return false;
        }
        Cursor query = this.gJP.query(getTableName(), this.xjC.columns, "rowid = ?", new String[]{String.valueOf(j)}, null, null, null);
        if (c.a(vI, query)) {
            query.close();
            Wd("no need replace , fields no change");
            return true;
        }
        boolean z2;
        query.close();
        if (this.gJP.update(getTableName(), vI, "rowid = ?", new String[]{String.valueOf(j)}) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || !z) {
            return z2;
        }
        doNotify();
        return z2;
    }

    public boolean a(long j, T t) {
        return a(j, (c) t, true);
    }

    public boolean b(T t, boolean z, String... strArr) {
        boolean z2 = false;
        ContentValues vI = t.vI();
        if (vI == null || vI.size() <= 0) {
            We("update failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            Wd("update with primary key");
            if (b(vI)) {
                Wd("no need replace , fields no change");
                return true;
            }
            if (this.gJP.update(getTableName(), vI, this.xjC.xjz + " = ?", new String[]{bh.ou(vI.getAsString(this.xjC.xjz))}) > 0) {
                z2 = true;
            }
            if (!z2 || !z) {
                return z2;
            }
            doNotify();
            return z2;
        } else {
            StringBuilder a = a(vI, strArr);
            if (a == null) {
                We("update failed, check keys failed");
                return false;
            } else if (this.gJP.update(getTableName(), vI, a.toString(), a(strArr, vI)) > 0) {
                if (z) {
                    Wc(vI.getAsString(this.xjC.xjz));
                }
                return true;
            } else {
                We("update failed");
                return false;
            }
        }
    }

    public boolean c(T t, String... strArr) {
        return b(t, true, strArr);
    }

    public boolean a(T t) {
        Assert.assertTrue("replace primaryKey == null", !bh.ov(this.xjC.xjz));
        ContentValues vI = t.vI();
        if (vI != null) {
            int i;
            int size = vI.size();
            int length = t.Ac().hSY.length;
            if (vI.containsKey("rowid")) {
                i = 1;
            } else {
                i = 0;
            }
            if (size == i + length) {
                if (b(vI)) {
                    Wd("no need replace , fields no change");
                    return true;
                } else if (this.gJP.replace(getTableName(), this.xjC.xjz, vI) > 0) {
                    Wc(this.xjC.xjz);
                    return true;
                } else {
                    We("replace failed");
                    return false;
                }
            }
        }
        We("replace failed, cv.size() != item.fields().length");
        return false;
    }

    private boolean b(ContentValues contentValues) {
        Cursor query = this.gJP.query(getTableName(), this.xjC.columns, this.xjC.xjz + " = ?", new String[]{bh.ou(contentValues.getAsString(this.xjC.xjz))}, null, null, null);
        boolean a = c.a(contentValues, query);
        query.close();
        return a;
    }

    public Cursor Tj() {
        return this.gJP.query(getTableName(), this.xjC.columns, null, null, null, null, null);
    }

    public int getCount() {
        Cursor rawQuery = rawQuery("select count(*) from " + getTableName(), new String[0]);
        if (rawQuery == null) {
            return 0;
        }
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i;
    }

    public final Cursor rawQuery(String str, String... strArr) {
        return this.gJP.rawQuery(str, strArr);
    }

    private static StringBuilder a(ContentValues contentValues, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strArr) {
            stringBuilder.append(str + " = ? AND ");
            if (contentValues.get(str) == null) {
                return null;
            }
        }
        stringBuilder.append(" 1=1");
        return stringBuilder;
    }

    private static String[] a(String[] strArr, ContentValues contentValues) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr2.length; i++) {
            strArr2[i] = bh.ou(contentValues.getAsString(strArr[i]));
        }
        return strArr2;
    }

    private void Wd(String str) {
        x.d("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + str);
    }

    private void We(String str) {
        x.e("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + str);
    }
}
