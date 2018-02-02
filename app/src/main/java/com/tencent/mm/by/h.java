package com.tencent.mm.by;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.repair.DBDumpUtil;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class h implements com.tencent.mm.sdk.e.e {
    String TAG = "MicroMsg.SqliteDB";
    public int field_MARK_CURSOR_CHECK_IGNORE = 1;
    private long kko = 0;
    protected f xAK = null;
    private a xBm = null;
    public a xBn = new a();
    private String xBo = "";
    public e xBp = null;
    public String xBq = "";
    final LinkedList<b> xBr = new LinkedList();
    private af xBs = null;

    public interface a {
        void Db();

        void Dc();

        void Dd();
    }

    public static class b {
        public long lastReportTime;
        public String xBA;
        public c xBB;
        public Cursor xBw;
        public String xBx;
        public long xBy;
        public boolean xBz;
        public String xjD;
    }

    private static class c extends AssertionError {
        c() {
        }

        c(String str) {
            super(str);
        }
    }

    public interface d {
        String[] wg();
    }

    public interface e {
        void De();
    }

    public h(a aVar) {
        this.xBm = aVar;
    }

    protected void finalize() {
        eb(null);
    }

    public void ES() {
        eb(null);
    }

    public void eb(String str) {
        if (this.xAK != null) {
            if (this.xBm != null) {
                this.xBm.Db();
            }
            x.w(this.TAG, "begin close db, inTrans:%b ticket:%s  thr:%d {%s}", Boolean.valueOf(inTransaction()), Long.toHexString(this.kko), Long.valueOf(Thread.currentThread().getId()), bh.cgy());
            com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
            if (str != null) {
                this.xBo = str;
            }
            this.xAK.close();
            this.xAK = null;
            x.d(this.TAG, "end close db time:%d", Long.valueOf(aVar.zi()));
        }
    }

    public final boolean cgM() {
        return this.xAK == null || !this.xAK.isOpen();
    }

    private void Yh(String str) {
        String Br = ac.Br();
        String packageName = ac.getPackageName();
        x.i(this.TAG, "check process :[%s] [%s] path[%s]", Br, packageName, str);
        if (Br != null && packageName != null && !packageName.equals(Br)) {
            Assert.assertTrue("processName:" + Br + "  packagename:" + packageName, false);
        }
    }

    public final boolean b(String str, HashMap<Integer, d> hashMap, boolean z, boolean z2) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            this.TAG += "." + str.substring(lastIndexOf + 1);
        }
        Yh(str);
        if (!this.xBn.a(str, hashMap, true, z2) || this.xBn.xAK == null) {
            this.xAK = null;
            this.xBn = null;
            x.e(this.TAG, "initDB failed.");
            return false;
        }
        this.xAK = this.xBn.xAK;
        x.i(this.TAG, "SqliteDB db %s", this.xAK);
        return true;
    }

    public final boolean a(String str, String str2, String str3, long j, String str4, HashMap<Integer, d> hashMap, boolean z) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            this.TAG += "." + str.substring(lastIndexOf + 1);
        }
        Yh(str2);
        if (!this.xBn.a(str, str2, str3, j, str4, hashMap, z) || this.xBn.xAK == null) {
            this.xBq = this.xBn.getError();
            this.xAK = null;
            this.xBn = null;
            x.i(this.TAG, "initDB failed. %s", this.xBq);
            return false;
        }
        this.xBq = this.xBn.getError();
        this.xAK = this.xBn.xAK;
        return true;
    }

    public final boolean a(String str, String str2, long j, String str3, HashMap<Integer, d> hashMap) {
        return a(str, str2, "", j, str3, hashMap, true);
    }

    public final boolean isOpen() {
        if (this.xAK != null && this.xAK.isOpen()) {
            return true;
        }
        Assert.assertTrue("DB has been closed :[" + this.xBo + "]", bh.ov(this.xBo));
        return false;
    }

    public final String getKey() {
        if (this.xBn == null) {
            return null;
        }
        return this.xBn.aAM;
    }

    public final String getPath() {
        if (isOpen()) {
            return this.xAK.getPath();
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bh.cgy());
        return null;
    }

    public static String fe(String str) {
        if (bh.ov(str)) {
            return "";
        }
        return DatabaseUtils.sqlEscapeString(str);
    }

    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return a(str, strArr, str2, strArr2, str3, str4, str5, 0);
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i) {
        Cursor a;
        if (isOpen()) {
            int cfD;
            boolean z = HardCoderJNI.hcDBEnable;
            int i2 = HardCoderJNI.hcDBDelayQuery;
            int i3 = HardCoderJNI.hcDBCPU;
            int i4 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                cfD = g.Dm().cfD();
            } else {
                cfD = 0;
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i2, i3, i4, cfD, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionQuery, this.TAG);
            c.begin();
            try {
                a = this.xAK.a(str, strArr, str2, strArr2, str3, str4, str5, i);
                c.a(str, a, this.kko);
                return a;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.d.pPH.a(181, 10, 1, false);
                x.e(this.TAG, "execSQL Error :" + e.getMessage());
                c.i(e);
                a = d.ckM();
                return a;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
            }
        } else {
            x.e(this.TAG, "DB IS CLOSED ! {%s}", bh.cgy());
            return d.ckM();
        }
    }

    public final Cursor a(final String str, String[] strArr, int i) {
        int i2 = 0;
        Assert.assertTrue("sql is null ", !bh.ov(str));
        if (isOpen()) {
            boolean z = HardCoderJNI.hcDBEnable;
            int i3 = HardCoderJNI.hcDBDelayQuery;
            int i4 = HardCoderJNI.hcDBCPU;
            int i5 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                i2 = g.Dm().cfD();
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i3, i4, i5, i2, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionQuery, this.TAG);
            c.begin();
            final Cursor a;
            try {
                a = this.xAK.a(str, strArr, i);
                if (com.tencent.mm.sdk.a.b.ceI() || com.tencent.mm.sdk.a.b.ceK()) {
                    if (this.xBs == null) {
                        HandlerThread Wf = com.tencent.mm.sdk.f.e.Wf("CheckCursor");
                        Wf.start();
                        this.xBs = new af(Wf.getLooper());
                    }
                    final c cVar = new c();
                    this.xBs.postDelayed(new Runnable(this) {
                        final /* synthetic */ h xBv;

                        public final void run() {
                            try {
                                long Wp = bh.Wp();
                                if (a != null && !a.isClosed()) {
                                    int intValue;
                                    String str;
                                    String className;
                                    HashMap hashMap = new HashMap();
                                    int i = 0;
                                    c cVar = null;
                                    synchronized (this.xBv.xBr) {
                                        Pair pair;
                                        c cVar2;
                                        Iterator it = this.xBv.xBr.iterator();
                                        while (it.hasNext()) {
                                            b bVar = (b) it.next();
                                            if (bVar == null || bVar.xBw == null || bVar.xBw.isClosed()) {
                                                it.remove();
                                            } else {
                                                Pair pair2;
                                                if ((Wp - bVar.lastReportTime) / 1000 > 100) {
                                                    bVar.lastReportTime = Wp;
                                                    if (!bVar.xBz) {
                                                        x.w(this.xBv.TAG, "CheckCursorRES time:%d MSG: NOTCLOSE cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(Wp - bVar.xBy), Integer.valueOf(bVar.xBw.hashCode()), bVar.xBx, Boolean.valueOf(bVar.xBz), bVar.xBA);
                                                    } else if (TextUtils.isEmpty(bVar.xBA)) {
                                                        x.w(this.xBv.TAG, "CheckCursorRES time:%d MSG: BadOut cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(Wp - bVar.xBy), Integer.valueOf(bVar.xBw.hashCode()), bVar.xBx, Boolean.valueOf(bVar.xBz), bVar.xBA);
                                                    } else {
                                                        x.w(this.xBv.TAG, "CheckCursorRES time:%d MSG: Adapter cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(Wp - bVar.xBy), Integer.valueOf(bVar.xBw.hashCode()), bVar.xBx, Boolean.valueOf(bVar.xBz), bVar.xBA);
                                                    }
                                                }
                                                pair = (Pair) hashMap.get(bVar.xBx);
                                                if (pair == null) {
                                                    pair = new Pair(Integer.valueOf(Wp - bVar.xBy > 30000 ? 1 : 0), bVar);
                                                    hashMap.put(bVar.xBx, pair);
                                                    pair2 = pair;
                                                } else if (Wp - bVar.xBy > 30000) {
                                                    Pair pair3 = new Pair(Integer.valueOf(((Integer) pair.first).intValue() + 1), pair.second);
                                                    hashMap.put(bVar.xBx, pair3);
                                                    pair2 = pair3;
                                                } else {
                                                    pair2 = pair;
                                                }
                                                if (i < ((Integer) pair2.first).intValue()) {
                                                    intValue = ((Integer) pair2.first).intValue();
                                                    cVar2 = ((b) pair2.second).xBB;
                                                } else {
                                                    cVar2 = cVar;
                                                    intValue = i;
                                                }
                                                cVar = cVar2;
                                                i = intValue;
                                            }
                                        }
                                        x.d(this.xBv.TAG, "CheckCursor: checkAss max:%d list:%d map:%d", Integer.valueOf(i), Integer.valueOf(this.xBv.xBr.size()), Integer.valueOf(hashMap.size()));
                                        if (i <= (com.tencent.mm.sdk.a.b.ceI() ? 20 : 50)) {
                                            if (this.xBv.xBr.size() <= (com.tencent.mm.sdk.a.b.ceI() ? 50 : 100)) {
                                            }
                                        }
                                        str = "";
                                        for (String className2 : hashMap.keySet()) {
                                            pair = (Pair) hashMap.get(className2);
                                            str = str + className2 + "," + pair.first + "," + ((b) pair.second).xBz + "," + ((b) pair.second).xBA + ";";
                                        }
                                        if (cVar != null) {
                                            cVar2 = new c(str);
                                            cVar2.setStackTrace(cVar.getStackTrace());
                                            throw cVar2;
                                        }
                                        throw new AssertionError(str);
                                    }
                                    long Wp2 = bh.Wp();
                                    b bVar2 = new b();
                                    bVar2.xBw = a;
                                    bVar2.xjD = str;
                                    bVar2.xBy = Wp;
                                    bVar2.xBx = "";
                                    bVar2.xBz = true;
                                    bVar2.xBB = cVar;
                                    StackTraceElement[] stackTrace = cVar.getStackTrace();
                                    for (intValue = 0; intValue < stackTrace.length; intValue++) {
                                        Object obj;
                                        className2 = stackTrace[intValue].getClassName();
                                        String methodName = stackTrace[intValue].getMethodName();
                                        str = className2.replace("com.tencent.mm.", "") + ":" + methodName + "(" + stackTrace[intValue].getLineNumber() + ")";
                                        Class cls = Class.forName(className2);
                                        try {
                                            obj = cls.getDeclaredField("field_MARK_CURSOR_CHECK_IGNORE") != null ? 1 : null;
                                        } catch (Exception e) {
                                            obj = null;
                                        }
                                        if (obj == null) {
                                            if (!TextUtils.isEmpty(bVar2.xBx)) {
                                                if (!bVar2.xBz) {
                                                    break;
                                                }
                                                className2 = str.toLowerCase();
                                                if (className2.contains("cursor") || className2.contains("adapter")) {
                                                    bVar2.xBA = str;
                                                }
                                            } else {
                                                bVar2.xBx = str;
                                                boolean z = false;
                                                for (Method method : cls.getMethods()) {
                                                    if (method.getName().equals(methodName)) {
                                                        z = method.getReturnType().getName().contains(".Cursor");
                                                        if (z) {
                                                            break;
                                                        }
                                                    }
                                                }
                                                bVar2.xBz = z;
                                            }
                                        }
                                    }
                                    if (TextUtils.isEmpty(bVar2.xBx)) {
                                        bVar2.xBx = ai.b(stackTrace);
                                    }
                                    synchronized (this.xBv.xBr) {
                                        this.xBv.xBr.add(bVar2);
                                    }
                                    x.d(this.xBv.TAG, "checkCursor insert [%d,%d] caller:%s outCu:%b kw:%s", Long.valueOf(Wp2 - Wp), Long.valueOf(bh.bz(Wp)), bVar2.xBx, Boolean.valueOf(bVar2.xBz), bVar2.xBA);
                                }
                            } catch (Throwable e2) {
                                x.e(this.xBv.TAG, "checkCursor table:[%s] e:%s[%s]", str, e2.getMessage(), bh.i(e2));
                            }
                        }
                    }, 500);
                }
                c.a(str, a, this.kko);
                return a;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.d.pPH.a(181, 10, 1, false);
                x.e(this.TAG, "execSQL Error :" + e.getMessage());
                c.i(e);
                a = d.ckM();
                return a;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
            }
        } else {
            x.e(this.TAG, "DB IS CLOSED ! {%s}", bh.cgy());
            return d.ckM();
        }
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        return a(str, strArr, 0);
    }

    public final boolean a(String str, String str2, String str3, List<String> list, ExecuteSqlCallback executeSqlCallback) {
        if (isOpen()) {
            return DBDumpUtil.doRecoveryDb(this.xAK.xAU, str, str2, str3, list, null, executeSqlCallback, true);
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bh.cgy());
        return false;
    }

    public final long getPageSize() {
        return this.xAK.xAU.getPageSize();
    }

    public final f ckU() {
        return this.xAK;
    }

    public final SQLiteDatabase ckV() {
        f fVar = this.xAK;
        return fVar.xAU != null ? fVar.xAU : fVar.xAV;
    }

    public final boolean fx(String str, String str2) {
        Assert.assertTrue("sql is null ", !bh.ov(str2));
        if (isOpen()) {
            int cfD;
            boolean z = HardCoderJNI.hcDBEnable;
            int i = HardCoderJNI.hcDBDelayWrite;
            int i2 = HardCoderJNI.hcDBCPU;
            int i3 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                cfD = g.Dm().cfD();
            } else {
                cfD = 0;
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i, i2, i3, cfD, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                this.xAK.execSQL(str2);
                c.a(str2, null, this.kko);
                return true;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.d.pPH.a(181, 11, 1, false);
                String message = e.getMessage();
                x.e(this.TAG, "execSQL Error :" + message);
                if (message != null && message.contains("no such table")) {
                    x.d("MicroMsg.DBInit", "resetIniCache iniFilename:%s", this.xBn.xAL);
                    com.tencent.mm.loader.stub.b.deleteFile(r1.xAL);
                    if (this.xBp != null) {
                        this.xBp.De();
                    }
                    Assert.assertTrue("clean ini cache and reboot", false);
                }
                c.i(e);
                return false;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
            }
        } else {
            x.e(this.TAG, "DB IS CLOSED ! {%s}", bh.cgy());
            return false;
        }
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        return a(str, str2, contentValues, false);
    }

    public final long a(String str, String str2, ContentValues contentValues, boolean z) {
        int i = 0;
        if (isOpen()) {
            long insert;
            boolean z2 = HardCoderJNI.hcDBEnable;
            int i2 = HardCoderJNI.hcDBDelayWrite;
            int i3 = HardCoderJNI.hcDBCPU;
            int i4 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                i = g.Dm().cfD();
            }
            int startPerformance = HardCoderJNI.startPerformance(z2, i2, i3, i4, i, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                insert = this.xAK.insert(str, str2, contentValues);
                c.a(str, null, this.kko);
            } catch (Exception e) {
                com.tencent.mm.plugin.report.d.pPH.a(181, 11, 1, false);
                x.e(this.TAG, "insert Error :" + e.getMessage());
                c.i(e);
                if (!z) {
                    return -1;
                }
                throw e;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
            }
            return insert;
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bh.cgy());
        return -2;
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        int i = 0;
        if (isOpen()) {
            int update;
            boolean z = HardCoderJNI.hcDBEnable;
            int i2 = HardCoderJNI.hcDBDelayWrite;
            int i3 = HardCoderJNI.hcDBCPU;
            int i4 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                i = g.Dm().cfD();
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                update = this.xAK.update(str, contentValues, str2, strArr);
                c.a(str, null, this.kko);
            } catch (Exception e) {
                com.tencent.mm.plugin.report.d.pPH.a(181, 11, 1, false);
                x.e(this.TAG, "update Error :" + e.getMessage());
                c.i(e);
                return -1;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
            }
            return update;
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bh.cgy());
        return -2;
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        int i = 0;
        if (isOpen()) {
            long replace;
            boolean z = HardCoderJNI.hcDBEnable;
            int i2 = HardCoderJNI.hcDBDelayWrite;
            int i3 = HardCoderJNI.hcDBCPU;
            int i4 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                i = g.Dm().cfD();
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                replace = this.xAK.replace(str, str2, contentValues);
                c.a(str, null, this.kko);
            } catch (Exception e) {
                com.tencent.mm.plugin.report.d.pPH.a(181, 11, 1, false);
                x.e(this.TAG, "repalce  Error :" + e.getMessage());
                c.i(e);
                return -1;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
            }
            return replace;
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bh.cgy());
        return -2;
    }

    public final int delete(String str, String str2, String[] strArr) {
        int i = 0;
        if (isOpen()) {
            int delete;
            boolean z = HardCoderJNI.hcDBEnable;
            int i2 = HardCoderJNI.hcDBDelayWrite;
            int i3 = HardCoderJNI.hcDBCPU;
            int i4 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                i = g.Dm().cfD();
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                delete = this.xAK.delete(str, str2, strArr);
                c.a(str, null, this.kko);
            } catch (Exception e) {
                com.tencent.mm.plugin.report.d.pPH.a(181, 11, 1, false);
                x.e(this.TAG, "delete Error :" + e.getMessage());
                c.i(e);
                return -1;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
            }
            return delete;
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bh.cgy());
        return -2;
    }

    public final boolean Yi(String str) {
        if (isOpen()) {
            try {
                this.xAK.execSQL("DROP TABLE " + str);
            } catch (Exception e) {
                com.tencent.mm.plugin.report.d.pPH.a(181, 11, 1, false);
                x.e(this.TAG, "drop table Error :" + e.getMessage());
                c.i(e);
            }
        } else {
            x.e(this.TAG, "DB IS CLOSED ! {%s}", bh.cgy());
        }
        return false;
    }

    public final synchronized long dz(long j) {
        long j2 = -1;
        synchronized (this) {
            x.i(this.TAG, "beginTransaction thr:(%d,%d) ticket:%d db:%b  {%s}", Long.valueOf(j), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(this.kko), Boolean.valueOf(isOpen()), bh.cgy());
            if (!isOpen()) {
                x.e(this.TAG, "DB IS CLOSED ! {%s}", bh.cgy());
                j2 = -4;
            } else if (this.kko > 0) {
                x.e(this.TAG, "ERROR beginTransaction transactionTicket:" + this.kko);
            } else if (ag.isMainThread() || j != -1) {
                try {
                    c.begin();
                    this.xAK.beginTransaction();
                    c.a("beginTrans", null, 0);
                    this.kko = bh.Wp() & 2147483647L;
                    this.kko |= (r2 & 2147483647L) << 32;
                    if (this.xBm != null) {
                        this.xBm.Dc();
                    }
                    j2 = this.kko;
                } catch (Exception e) {
                    com.tencent.mm.plugin.report.d.pPH.a(181, 8, 1, false);
                    x.e(this.TAG, "beginTransaction Error :" + e.getMessage());
                    c.i(e);
                    j2 = -3;
                }
            } else {
                x.e(this.TAG, "FORBID: beginTrans UNKNOW_THREAD ParamID:%d nowThr:%d", Long.valueOf(j), Long.valueOf(r2));
                j2 = -2;
            }
        }
        return j2;
    }

    public final synchronized int fS(long j) {
        int i = 0;
        synchronized (this) {
            long Wp = bh.Wp();
            x.i(this.TAG, "endTransaction thr:%d ticket:(%d,%d) db:%b  {%s} ", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(j), Long.valueOf(this.kko), Boolean.valueOf(isOpen()), bh.cgy());
            if (!isOpen()) {
                x.e(this.TAG, "DB IS CLOSED ! {%s}", bh.cgy());
                i = -4;
            } else if (j != this.kko) {
                x.e(this.TAG, "ERROR endTransaction ticket:" + j + " transactionTicket:" + this.kko);
                i = -1;
            } else {
                if (((j >> 32) & 2147483647L) != r4) {
                    x.e(this.TAG, "FORBID: endTrans UNKNOW_THREAD ticket:%s ParamID:%d nowThr:%d", Long.toHexString(j), Long.valueOf((j >> 32) & 2147483647L), Long.valueOf(r4));
                    i = -2;
                } else {
                    try {
                        c.begin();
                        this.xAK.endTransaction();
                        x.i(this.TAG, "endTransaction Succ Time:%d thr:%d ticket:(%d,%d) db:%b  {%s} ", Long.valueOf(bh.bz(Wp)), Long.valueOf(r4), Long.valueOf(j), Long.valueOf(this.kko), Boolean.valueOf(isOpen()), bh.cgy());
                        c.a("endTrans", null, 0);
                        this.kko = 0;
                        if (this.xBm != null) {
                            this.xBm.Dd();
                        }
                    } catch (Exception e) {
                        x.e(this.TAG, "endTransaction Error :" + e.getMessage());
                        com.tencent.mm.plugin.report.d.pPH.a(181, 9, 1, false);
                        c.i(e);
                        i = -3;
                    }
                }
            }
        }
        return i;
    }

    public final synchronized boolean inTransaction() {
        boolean z = false;
        synchronized (this) {
            if (!isOpen()) {
                x.e(this.TAG, "DB IS CLOSED ! {%s}", bh.cgy());
            } else if (this.kko > 0) {
                z = true;
            }
        }
        return z;
    }
}
