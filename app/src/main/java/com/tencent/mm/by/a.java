package com.tencent.mm.by;

import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.by.h.d;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class a {
    public static final Pattern xAJ = Pattern.compile("^[\\s]*CREATE[\\s]+TABLE[\\s]*", 2);
    String aAM;
    private String fnL = "";
    f xAK;
    String xAL = "";
    public boolean xAM = false;
    private boolean xAN = false;
    String xAO = "";
    public boolean xAP = false;

    public final String getError() {
        if (bh.ov(this.fnL) || bh.ov(this.xAO)) {
            return "";
        }
        if (!bh.ov(com.tencent.mm.sdk.e.a.getValue(this.xAO, "Reported"))) {
            return "";
        }
        com.tencent.mm.sdk.e.a.ag(this.xAO, "Reported", "true");
        return this.fnL;
    }

    private void fG(String str, String str2) {
        Set hashSet = new HashSet();
        String str3 = "";
        Cursor a = this.xAK.a("select * from " + str + " limit 1 ", null, 0);
        if (a.getCount() == 0) {
            a.close();
            return;
        }
        a.moveToFirst();
        for (int i = 0; i < a.getColumnCount(); i++) {
            hashSet.add(a.getColumnName(i));
        }
        a.close();
        a = this.xAK.a("PRAGMA table_info( " + str2 + " )", null, 0);
        String str4 = str3;
        while (a.moveToNext()) {
            str3 = a.getString(a.getColumnIndex("name"));
            if (hashSet.contains(str3)) {
                str4 = (str4 + str3) + ",";
            }
        }
        a.close();
        str4 = str4.substring(0, str4.length() - 1);
        this.xAK.execSQL("insert into " + str2 + "(" + str4 + ") select " + str4 + " from " + str + ";");
    }

    private boolean l(Cursor cursor) {
        int i;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            hashSet.add(cursor.getString(0));
        }
        Cursor a = this.xAK.a("select DISTINCT tbl_name from old.sqlite_master;", null, 0);
        if (a == null) {
            return false;
        }
        for (i = 0; i < a.getCount(); i++) {
            a.moveToPosition(i);
            hashSet2.add(a.getString(0));
        }
        a.close();
        this.xAK.beginTransaction();
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!hashSet.contains(str)) {
                Cursor a2 = this.xAK.a("SELECT sql FROM old.sqlite_master WHERE type='table' AND tbl_name='" + str + "'", null, 0);
                if (a2 != null) {
                    this.xAK.execSQL(a2.getString(0));
                    a2.close();
                }
            }
        }
        this.xAK.endTransaction();
        return true;
    }

    private List<String> fH(String str, String str2) {
        List<String> arrayList = new ArrayList();
        if (this.xAK == null) {
            return arrayList;
        }
        Cursor a = this.xAK.a("PRAGMA table_info( " + str + " )", null, 0);
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
        a = this.xAK.a("PRAGMA table_info( " + str2 + " )", null, 0);
        if (a == null) {
            return arrayList;
        }
        Map hashMap2 = new HashMap();
        columnIndex = a.getColumnIndex("name");
        columnIndex2 = a.getColumnIndex(DownloadSettingTable$Columns.TYPE);
        while (a.moveToNext()) {
            hashMap.put(a.getString(columnIndex), a.getString(columnIndex2));
        }
        a.close();
        Iterator it = new HashSet(hashMap.entrySet()).iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            if (str4 != null && str4.length() > 0) {
                String str5 = (String) hashMap2.get(str3);
                if (str5 == null) {
                    arrayList.add("ALTER TABLE " + str2 + " ADD COLUMN " + str3 + " " + str4 + ";");
                    hashMap.remove(str3);
                } else if (!str4.toLowerCase().startsWith(str5.toLowerCase())) {
                    x.e("MicroMsg.DBInit", "conflicting alter table on column: " + str3 + ", " + str5 + "<o-n>" + str4);
                    hashMap.remove(str3);
                }
            }
        }
        return arrayList;
    }

    private boolean fI(String str, String str2) {
        Cursor a = this.xAK.a("select DISTINCT  tbl_name from sqlite_master;", null, 0);
        if (a == null) {
            return false;
        }
        try {
            if (bh.ov(str2)) {
                this.xAK.execSQL("ATTACH DATABASE '" + str + "' AS old KEY ''");
            } else {
                this.xAK.execSQL("ATTACH DATABASE '" + str + "' AS old KEY '" + str2 + "'");
            }
            if (!l(a)) {
                return false;
            }
            this.xAK.beginTransaction();
            for (int i = 0; i < a.getCount(); i++) {
                int count;
                a.moveToPosition(i);
                Cursor a2 = this.xAK.a("select * from old.sqlite_master where tbl_name = '" + a.getString(0) + "'", null, 0);
                if (a2 != null) {
                    count = a2.getCount();
                    a2.close();
                } else {
                    count = 0;
                }
                if (count == 0) {
                    x.w("MicroMsg.DBInit", "In old db not found :" + a.getString(0));
                } else {
                    try {
                        for (String execSQL : fH("old." + a.getString(0), a.getString(0))) {
                            this.xAK.execSQL(execSQL);
                        }
                        fG("old." + a.getString(0), a.getString(0));
                    } catch (Exception e) {
                        x.w("MicroMsg.DBInit", "Insertselect FAILED :" + a.getString(0));
                    }
                }
            }
            this.xAK.endTransaction();
            a.close();
            this.xAK.execSQL("DETACH DATABASE old;");
            return true;
        } catch (SQLiteDatabaseCorruptException e2) {
            x.e("MicroMsg.DBInit", "Attached database is corrupted: " + str);
            FileOp.deleteFile(str);
            throw e2;
        }
    }

    public final boolean a(String str, HashMap<Integer, d> hashMap, boolean z, boolean z2) {
        boolean z3 = false;
        if (this.xAK != null) {
            this.xAK.close();
            this.xAK = null;
        }
        try {
            x.i("MicroMsg.DBInit", "initSysDB checkini:%b exist:%b db:%s ", Boolean.valueOf(z), Boolean.valueOf(e.bO(str)), str);
            this.xAK = f.bg(str, z2);
            if (!e.bO(str)) {
                z3 = true;
            }
            a(hashMap, z, z3);
            return true;
        } catch (SQLiteException e) {
            return false;
        }
    }

    public final boolean a(String str, String str2, String str3, long j, String str4, HashMap<Integer, d> hashMap, boolean z) {
        Object obj;
        Assert.assertTrue("create SqliteDB enDbCachePath == null ", !bh.ov(str2));
        this.xAO = str2 + ".errreport";
        if (this.xAK != null) {
            this.xAK.close();
            this.xAK = null;
        }
        boolean bO = e.bO(str2);
        boolean bO2 = e.bO(str);
        boolean bO3 = e.bO(str3);
        Object obj2 = (bO || !bO2) ? null : 1;
        this.xAM = a(str2, j, str4, f.ckR(), str3);
        String str5 = "MicroMsg.DBInit";
        String str6 = "initDb(en) path:%s enExist:%b oldExist:%b copyold:%b dbopenSUCC:%b db:%b thr:%s";
        Object[] objArr = new Object[7];
        objArr[0] = str2;
        objArr[1] = Boolean.valueOf(bO);
        objArr[2] = Boolean.valueOf(bO2);
        objArr[3] = Boolean.valueOf(true);
        objArr[4] = Boolean.valueOf(this.xAM);
        objArr[5] = Boolean.valueOf(this.xAK != null);
        objArr[6] = Thread.currentThread().getName();
        x.i(str5, str6, objArr);
        if (this.xAK == null || this.xAK.getPath().equals(str3) || !bO3) {
            obj = null;
        } else {
            obj = 1;
            x.i("MicroMsg.DBInit", "backup db exsits, copy data to en db");
        }
        a(hashMap, z, this.xAN);
        if (!bO2 && !bO3) {
            return true;
        }
        if (!(obj == null && obj2 == null)) {
            this.xAP = true;
        }
        if (obj != null) {
            this.aAM = g.s((str4 + j).getBytes()).substring(0, 7);
            fJ(str3, this.aAM);
            com.tencent.mm.blink.a.i(201, 1);
        }
        if (obj2 != null) {
            boolean fJ = fJ(str, "");
            com.tencent.mm.blink.a.i(200, 1);
            return fJ;
        } else if (this.xAK != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean fJ(String str, String str2) {
        if (fI(str, str2)) {
            x.i("MicroMsg.DBInit", "system transfer success ,delete it path %s", str);
            x.i("MicroMsg.DBInit", "delete result :%b", Boolean.valueOf(b.deleteFile(str)));
            return true;
        }
        x.i("MicroMsg.DBInit", "system transfer fail path %s", str);
        return false;
    }

    private static void a(f fVar) {
        Cursor rawQueryWithFactory = (fVar.xAU != null ? fVar.xAU : fVar.xAV).rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT count(*) FROM sqlite_master;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            rawQueryWithFactory.close();
            return;
        }
        throw new SQLiteException("Cannot get count for sqlite_master");
    }

    private boolean a(String str, long j, String str2, boolean z, String str3) {
        Object obj;
        int i;
        if (this.xAK != null) {
            throw new AssertionError();
        }
        this.aAM = g.s((str2 + j).getBytes()).substring(0, 7);
        this.xAN = !FileOp.bO(str);
        try {
            this.xAK = f.s(str, this.aAM, z);
            a(this.xAK);
            return true;
        } catch (SQLiteException e) {
            if (e instanceof SQLiteDatabaseCorruptException) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                String deviceID = q.getDeviceID(ac.getContext());
                if (!(deviceID == null || deviceID.equals(str2))) {
                    obj = null;
                    String substring = g.s((deviceID + j).getBytes()).substring(0, 7);
                    try {
                        this.xAK = f.s(str, substring, z);
                        a(this.xAK);
                        this.aAM = substring;
                        l.yn().set(258, deviceID);
                        com.tencent.mm.plugin.report.d.pPH.a(181, 5, 1, false);
                        return true;
                    } catch (SQLiteException e2) {
                        if (e2 instanceof SQLiteDatabaseCorruptException) {
                            obj = 1;
                        }
                        if (!z) {
                            i = 42;
                        } else if (f.ckS()) {
                            i = 43;
                        } else {
                            i = 41;
                        }
                        com.tencent.mm.plugin.report.d.pPH.a(181, (long) i, 1, true);
                        f.Yf(str);
                        if (str.endsWith("EnMicroMsg.db")) {
                            f.Yf(com.tencent.mm.kernel.g.Dj().gQi + "dbback/EnMicroMsg.db");
                        }
                        try {
                            this.xAK = f.s(str, this.aAM, z);
                            a(this.xAK);
                            this.xAN = true;
                            com.tencent.mm.plugin.report.d.pPH.a(181, 6, 1, false);
                            return true;
                        } catch (SQLiteException e3) {
                            com.tencent.mm.plugin.report.d.pPH.a(181, 7, 1, false);
                            if (this.xAK != null) {
                                this.xAK.close();
                                this.xAK = null;
                            }
                            this.aAM = null;
                            return false;
                        }
                    }
                }
                if (this.xAK == null && r2 != null) {
                    if (!z) {
                        i = 42;
                    } else if (f.ckS()) {
                        i = 43;
                    } else {
                        i = 41;
                    }
                    com.tencent.mm.plugin.report.d.pPH.a(181, (long) i, 1, true);
                    f.Yf(str);
                    if (str.endsWith("EnMicroMsg.db")) {
                        f.Yf(com.tencent.mm.kernel.g.Dj().gQi + "dbback/EnMicroMsg.db");
                    }
                    this.xAK = f.s(str, this.aAM, z);
                    a(this.xAK);
                    this.xAN = true;
                    com.tencent.mm.plugin.report.d.pPH.a(181, 6, 1, false);
                    return true;
                }
            } else if (str3 != null && str3.length() > 0) {
                this.xAN = !FileOp.bO(str3);
                try {
                    this.xAK = f.s(str3, this.aAM, z);
                    a(this.xAK);
                    com.tencent.mm.plugin.report.d.pPH.a(181, 6, 1, false);
                    return true;
                } catch (SQLiteException e4) {
                    com.tencent.mm.plugin.report.d.pPH.a(181, 7, 1, false);
                    if (this.xAK != null) {
                        this.xAK.close();
                        this.xAK = null;
                    }
                    this.aAM = null;
                    return false;
                }
            }
            if (this.xAK != null) {
                this.xAK.close();
                this.xAK = null;
            }
            this.aAM = null;
            return false;
        }
    }

    private boolean a(HashMap<Integer, d> hashMap, boolean z, boolean z2) {
        int i;
        int i2;
        String str = "MicroMsg.DBInit";
        String str2 = "createtables checkCreateIni:%b  tables:%d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(hashMap == null ? -1 : hashMap.size());
        x.d(str, str2, objArr);
        String str3 = "";
        if (z) {
            this.xAL = this.xAK.getPath() + ".ini";
            StringBuilder stringBuilder = new StringBuilder();
            if (hashMap != null) {
                for (d dVar : hashMap.values()) {
                    if (dVar.wg() == null) {
                        x.e("MicroMsg.DBInit", "factory.getSQLs() is null: %s", dVar.getClass().toString());
                        Assert.assertTrue("factory.getSQLs() is null:" + dVar.getClass().toString(), false);
                    }
                    for (String hashCode : dVar.wg()) {
                        stringBuilder.append(hashCode.hashCode());
                    }
                }
            }
            str3 = g.s(stringBuilder.toString().getBytes());
            if (!z2) {
                str = com.tencent.mm.sdk.e.a.getValue(this.xAL, "createmd5");
                if (!bh.ov(str) && str3.equals(str)) {
                    x.i("MicroMsg.DBInit", "Create table factories not changed , no need create !  %s", this.xAK.getPath());
                    return true;
                }
            }
        }
        str = str3;
        this.xAK.execSQL("pragma auto_vacuum = 0 ");
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        this.xAK.beginTransaction();
        if (hashMap != null) {
            i2 = 0;
            for (d wg : hashMap.values()) {
                i = i2;
                for (String str4 : wg.wg()) {
                    try {
                        this.xAK.execSQL(str4);
                        i++;
                    } catch (Exception e) {
                        Matcher matcher = xAJ.matcher(str4);
                        if (matcher == null || !matcher.matches()) {
                            x.w("MicroMsg.DBInit", "CreateTable failed:[" + str4 + "][" + e.getMessage() + "]");
                        } else {
                            Assert.assertTrue("CreateTable failed:[" + str4 + "][" + e.getMessage() + "]", false);
                        }
                    }
                }
                i2 = i;
            }
        } else {
            i2 = 0;
        }
        long zi = aVar.zi();
        this.xAK.endTransaction();
        x.i("MicroMsg.DBInit", "createtables end sql:%d trans:%d sqlCount:%d", Long.valueOf(zi), Long.valueOf(aVar.zi()), Integer.valueOf(i2));
        if (z) {
            com.tencent.mm.sdk.e.a.ag(this.xAL, "createmd5", str);
        }
        return true;
    }
}
