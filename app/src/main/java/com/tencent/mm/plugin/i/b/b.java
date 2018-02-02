package com.tencent.mm.plugin.i.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.List;

public final class b extends i<a> {
    public static final String[] fMK = new String[]{"CREATE  INDEX IF NOT EXISTS msgid_username_index ON WxFileIndex2 ( msgId,username,msgSubType ) ", "CREATE  INDEX IF NOT EXISTS username_type_index ON WxFileIndex2 ( username,msgtime,msgSubType ) "};
    public static final String[] gJN = new String[]{i.a(a.gJc, "WxFileIndex2"), "DROP TABLE IF EXISTS WxFileIndex"};
    public e gJP;

    public b(e eVar) {
        super(eVar, a.gJc, "WxFileIndex2", fMK);
        this.gJP = eVar;
    }

    public final boolean delete() {
        long delete;
        try {
            delete = (long) this.gJP.delete("WxFileIndex2", null, null);
        } catch (Exception e) {
            delete = 0;
        }
        return delete > 0;
    }

    public final long nB(int i) {
        Cursor cursor = null;
        long j = 0;
        try {
            cursor = this.gJP.rawQuery("select sum(size)  from WxFileIndex2  where msgType=" + i, null);
            if (cursor != null && cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final long nC(int i) {
        Cursor cursor = null;
        long j = 0;
        try {
            cursor = this.gJP.rawQuery("select count(*)  from WxFileIndex2  where msgType=" + i + " and size>0", null);
            if (cursor != null && cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final long asQ() {
        Cursor cursor = null;
        long j = 0;
        try {
            cursor = this.gJP.rawQuery("select sum(size)  from WxFileIndex2 where msgSubType in (1,20,23,30,32,34 )", null);
            if (cursor != null && cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final Cursor asR() {
        Cursor cursor = null;
        try {
            cursor = this.gJP.rawQuery("select username,  sum(size) as total from WxFileIndex2 where size > 0  and msgSubType in (1,20,23,30,32,34 ) group by username order by total desc", null);
        } catch (Exception e) {
        }
        return cursor;
    }

    public final List<a> g(String str, long j, long j2) {
        long Wq = bh.Wq();
        String str2 = "select *, rowid from WxFileIndex2  where username='" + str + "' and msgtime<=" + j + " and msgtime>" + j2 + " and msgSubType in (1,20,23,30,32,34 ) and size" + " > 0  order by msgtime DESC,msgSubType" + " ASC ";
        List<a> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.gJP.rawQuery(str2, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    a aVar = new a();
                    aVar.b(cursor);
                    arrayList.add(aVar);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", new Object[]{str2});
            x.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaWxFileIndex [%s] size[%d] cost[%d] ", new Object[]{str, Integer.valueOf(arrayList.size()), Long.valueOf(bh.bA(Wq))});
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        x.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaWxFileIndex [%s] size[%d] cost[%d] ", new Object[]{str, Integer.valueOf(arrayList.size()), Long.valueOf(bh.bA(Wq))});
        return arrayList;
    }

    public final List<a> h(String str, long j, long j2) {
        long Wq = bh.Wq();
        String str2 = "select *, rowid from WxFileIndex2  where username='" + str + "' and msgtime<=" + j + " and msgtime>" + j2 + " and msgType in (43,62,44,3,49,268435505 ) order by msgtime" + " DESC,msgSubType ASC ";
        List<a> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.gJP.rawQuery(str2, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    a aVar = new a();
                    aVar.b(cursor);
                    arrayList.add(aVar);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", new Object[]{str2});
            x.i("MicroMsg.WxFileIndexStorage", "getMediaWxFileIndex [%s] size[%d] cost[%d] ", new Object[]{str, Integer.valueOf(arrayList.size()), Long.valueOf(bh.bA(Wq))});
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        x.i("MicroMsg.WxFileIndexStorage", "getMediaWxFileIndex [%s] size[%d] cost[%d] ", new Object[]{str, Integer.valueOf(arrayList.size()), Long.valueOf(bh.bA(Wq))});
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<a> L(au auVar) {
        Cursor cursor = null;
        if (auVar == null) {
            return cursor;
        }
        String str = "select *, rowid from WxFileIndex2  where msgId=" + auVar.field_msgId + " AND username='" + auVar.field_talker + "' order by msgSubType ASC ";
        List arrayList = new ArrayList();
        try {
            cursor = this.gJP.rawQuery(str, null);
            while (cursor.moveToNext()) {
                a aVar = new a();
                aVar.b(cursor);
                arrayList.add(aVar);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            Cursor cursor2 = cursor;
            Throwable th3 = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th3;
        }
        return arrayList;
    }

    public final int aj(List<a> list) {
        if (list.isEmpty()) {
            return 0;
        }
        long Wq = bh.Wq();
        int i = 0;
        for (a a : list) {
            int i2;
            if (a(a, false)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            i = i2 + i;
        }
        x.d("MicroMsg.WxFileIndexStorage", "insert list result[%d %d] cost[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(list.size()), Long.valueOf(bh.bA(Wq))});
        return i;
    }

    public final int ak(List<a> list) {
        if (list.isEmpty()) {
            return 0;
        }
        long Wq = bh.Wq();
        int i = 0;
        for (a aVar : list) {
            int i2;
            if (a(aVar.xjy, aVar, false)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            i = i2 + i;
        }
        x.d("MicroMsg.WxFileIndexStorage", "update list result[%d %d] cost[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(list.size()), Long.valueOf(bh.bA(Wq))});
        return i;
    }
}
