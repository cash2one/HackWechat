package com.tencent.mm.by;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public final class g implements e {
    public static String xBj = "";
    public int field_MARK_CURSOR_CHECK_IGNORE;
    public boolean veZ;
    public f xAK;
    public h xBi;
    public Map<String, i> xBk;
    public Queue<a> xBl;

    public interface a {
        int a(g gVar);

        String getTableName();
    }

    public final boolean cgM() {
        if (this.xAK != null && this.xAK.isOpen()) {
            return false;
        }
        x.e("MicroMsg.MemoryStorage", "memory db is close [%s]", xBj);
        return true;
    }

    public final int Yg(String str) {
        String str2 = null;
        if (!this.veZ) {
            return -4;
        }
        if (this.xBi == null || this.xBi.inTransaction()) {
            x.d("MicroMsg.MemoryStorage", "copy table but diskDB inTransaction");
            return -3;
        }
        try {
            if (f.a(this.xAK, str)) {
                this.xAK.execSQL("drop table " + str);
                x.i("MicroMsg.MemoryStorage", "table %s is in Memory DB,drop! ", str);
            }
            Cursor a = this.xBi.a(" select sql from sqlite_master where tbl_name=\"" + str + "\" and type = \"table\"", null, 0);
            if (a != null) {
                if (a.getCount() == 1) {
                    a.moveToFirst();
                    str2 = a.getString(0);
                }
                a.close();
            }
            if (str2 == null) {
                x.w("MicroMsg.MemoryStorage", "diskDB has not this table !");
                return -1;
            }
            this.xAK.execSQL(str2);
            this.xAK.execSQL("insert into " + str + " select * from old." + str);
            x.d("MicroMsg.MemoryStorage", "copy table %s success", str);
            return 0;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MemoryStorage", e, "copy table failed with exception.\n", new Object[0]);
            return -2;
        }
    }

    public final int delete(String str, String str2, String[] strArr) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.xBk.containsKey(str));
        if (this.xAK == null || !this.xAK.isOpen()) {
            x.w("MicroMsg.MemoryStorage", "memoryDB already close delete [%s] [%s]", str, xBj);
            if (this.xBi == null || !this.xBi.isOpen()) {
                return -1;
            }
            return this.xBi.delete(str, str2, strArr);
        }
        i iVar = (i) this.xBk.get(str);
        com.tencent.mm.by.i.a aVar = new com.tencent.mm.by.i.a();
        aVar.xhD = 5;
        aVar.xBE = str2;
        aVar.J(strArr);
        iVar.a(aVar);
        return this.xAK.delete(str, str2, strArr);
    }

    public final boolean fx(String str, String str2) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.xBk.containsKey(str));
        if (this.xAK == null || !this.xAK.isOpen()) {
            x.w("MicroMsg.MemoryStorage", "memoryDB already close execSQL [%s] [%s]", str, xBj);
            if (this.xBi == null || !this.xBi.isOpen()) {
                return false;
            }
            this.xBi.fx(str2, str);
            return true;
        }
        i iVar = (i) this.xBk.get(str);
        com.tencent.mm.by.i.a aVar = new com.tencent.mm.by.i.a();
        aVar.xhD = 1;
        aVar.xjB = str2;
        iVar.a(aVar);
        this.xAK.execSQL(str2);
        return true;
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.xBk.containsKey(str));
        if (this.xAK == null || !this.xAK.isOpen()) {
            x.w("MicroMsg.MemoryStorage", "memoryDB already close insert [%s] [%s]", str, xBj);
            if (this.xBi == null || !this.xBi.isOpen()) {
                return -1;
            }
            return this.xBi.insert(str, str2, contentValues);
        }
        i iVar = (i) this.xBk.get(str);
        com.tencent.mm.by.i.a aVar = new com.tencent.mm.by.i.a();
        aVar.xhD = 2;
        aVar.xjz = str2;
        aVar.values = new ContentValues(contentValues);
        iVar.a(aVar);
        return this.xAK.insert(str, str2, contentValues);
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.xBk.containsKey(str));
        if (this.xAK == null || !this.xAK.isOpen()) {
            x.w("MicroMsg.MemoryStorage", "memoryDB already close replace [%s] [%s]", str, xBj);
            if (this.xBi == null || !this.xBi.isOpen()) {
                return -1;
            }
            return this.xBi.replace(str, str2, contentValues);
        }
        i iVar = (i) this.xBk.get(str);
        com.tencent.mm.by.i.a aVar = new com.tencent.mm.by.i.a();
        aVar.xhD = 4;
        aVar.xjz = str2;
        aVar.values = new ContentValues(contentValues);
        iVar.a(aVar);
        return this.xAK.replace(str, str2, contentValues);
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.xBk.containsKey(str));
        if (this.xAK == null || !this.xAK.isOpen()) {
            x.w("MicroMsg.MemoryStorage", "memoryDB already close update [%s] [%s]", str, xBj);
            if (this.xBi == null || !this.xBi.isOpen()) {
                return -1;
            }
            return this.xBi.update(str, contentValues, str2, strArr);
        }
        i iVar = (i) this.xBk.get(str);
        com.tencent.mm.by.i.a aVar = new com.tencent.mm.by.i.a();
        aVar.xhD = 3;
        aVar.xBE = str2;
        aVar.values = new ContentValues(contentValues);
        aVar.J(strArr);
        iVar.a(aVar);
        return this.xAK.update(str, contentValues, str2, strArr);
    }

    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (this.xAK != null && this.xAK.isOpen()) {
            return this.xAK.a(str, strArr, str2, strArr2, str3, str4, str5, 0);
        }
        x.w("MicroMsg.MemoryStorage", "memoryDB already close query [%s] [%s]", str, xBj);
        return d.ckM();
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i) {
        return query(str, strArr, str2, strArr2, str3, str4, str5);
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        if (this.xAK != null && this.xAK.isOpen()) {
            return this.xAK.a(str, strArr, 0);
        }
        x.w("MicroMsg.MemoryStorage", "memoryDB already close rawQuery [%s] [%s]", str, xBj);
        return d.ckM();
    }

    public final Cursor a(String str, String[] strArr, int i) {
        return rawQuery(str, strArr);
    }
}
