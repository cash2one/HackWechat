package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.by.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import junit.framework.Assert;

public final class t extends m implements c<Object, Object> {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS userinfo ( id INTEGER PRIMARY KEY, type INT, value TEXT )", "CREATE TABLE IF NOT EXISTS userinfo2 ( sid TEXT PRIMARY KEY, type INT, value TEXT )"};
    private long hSp;
    private h hhp;
    private au<Object, Object> xmC;
    private au<Object, Object> xmD;
    private BlockingQueue<Integer> xmE = new LinkedBlockingQueue();
    private BlockingQueue<String> xmF = new LinkedBlockingQueue();

    static class a {
        public String hhA = null;
        public int type = -1;

        a() {
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.type != aVar.type) {
                return false;
            }
            if (this.hhA != null) {
                return this.hhA.equals(aVar.hhA);
            }
            if (aVar.hhA == null) {
                return true;
            }
            return false;
        }
    }

    public t(h hVar) {
        this.hhp = hVar;
        this.xmC = new au(this, g.Dm().oAt.getLooper(), 100, 20, 60000, 100);
        this.xmC.setTag(Integer.valueOf(1));
        this.xmD = new au(this, g.Dm().oAt.getLooper(), 100, 20, 60000, 100);
        this.xmD.setTag(Integer.valueOf(3));
    }

    public final Object get(int i, Object obj) {
        Assert.assertTrue("db is null", this.hhp != null);
        Object obj2 = this.xmC.get(Integer.valueOf(i));
        if (obj2 == null && !this.xmE.contains(Integer.valueOf(i))) {
            a aVar = new a();
            Cursor a = this.hhp.a("userinfo", null, "id=" + i, null, null, null, null, 2);
            if (a.moveToFirst()) {
                aVar.type = a.getInt(1);
                aVar.hhA = a.getString(2);
            }
            a.close();
            obj2 = m(aVar.type, aVar.hhA);
            this.xmC.r(Integer.valueOf(i), aVar);
            if (obj2 == null) {
                return obj;
            }
        } else if (obj2 instanceof a) {
            a aVar2 = (a) obj2;
            obj2 = m(aVar2.type, aVar2.hhA);
            if (obj2 == null) {
                return obj;
            }
        }
        return obj2;
    }

    public final Object get(com.tencent.mm.storage.w.a aVar, Object obj) {
        if (aVar == null) {
            return obj;
        }
        String name = aVar.name();
        if (bh.ov(name)) {
            return obj;
        }
        String str;
        String[] split = name.split("_");
        String str2 = split[split.length - 1];
        if (str2.equals("SYNC")) {
            str = split[split.length - 2];
        } else {
            str = str2;
        }
        String substring = name.substring(0, name.lastIndexOf(str) + str.length());
        Assert.assertTrue("db is null", this.hhp != null);
        Object obj2 = this.xmD.get(substring);
        if (obj2 == null && !this.xmF.contains(substring)) {
            a aVar2 = new a();
            Cursor a = this.hhp.a("userinfo2", null, "sid=?", new String[]{substring}, null, null, null, 2);
            if (a.moveToFirst()) {
                aVar2.type = a.getInt(1);
                aVar2.hhA = a.getString(2);
            }
            a.close();
            obj2 = m(aVar2.type, aVar2.hhA);
            this.xmD.r(substring, aVar2);
            if (obj2 == null) {
                obj2 = obj;
            }
        } else if (obj2 instanceof a) {
            a aVar3 = (a) obj2;
            obj2 = m(aVar3.type, aVar3.hhA);
            if (obj2 == null) {
                obj2 = obj;
            }
        }
        if (a(str, obj2, false)) {
            return obj2;
        }
        return obj;
    }

    public final boolean getBoolean(com.tencent.mm.storage.w.a aVar, boolean z) {
        Object obj = get(aVar, Boolean.valueOf(z));
        if (obj == null || !(obj instanceof Boolean)) {
            return z;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final void set(int i, Object obj) {
        boolean r;
        Assert.assertTrue("db is null", this.hhp != null);
        if (obj == null) {
            r = this.xmC.r(Integer.valueOf(i), null);
            if (r && !this.xmE.contains(Integer.valueOf(i))) {
                this.xmE.add(Integer.valueOf(i));
            }
        } else {
            a aVar = new a();
            aVar.type = cb(obj);
            if (aVar.type != -1) {
                aVar.hhA = obj.toString();
                r = this.xmC.r(Integer.valueOf(i), aVar);
                if (r && this.xmE.contains(Integer.valueOf(i))) {
                    this.xmE.remove(Integer.valueOf(i));
                }
            } else {
                return;
            }
        }
        if (r) {
            b(obj == null ? 5 : 4, this, Integer.valueOf(i));
        }
    }

    public final void a(com.tencent.mm.storage.w.a aVar, Object obj) {
        if (aVar != null) {
            String name = aVar.name();
            if (!bh.ov(name)) {
                boolean z;
                String[] split = name.split("_");
                String str = split[split.length - 1];
                if (str.equals("SYNC")) {
                    str = split[split.length - 2];
                    z = true;
                } else {
                    z = false;
                }
                if (a(str, obj, true)) {
                    boolean r;
                    String substring = name.substring(0, str.length() + name.lastIndexOf(str));
                    if (obj == null) {
                        r = this.xmD.r(substring, null);
                        if (r && !this.xmF.contains(substring)) {
                            this.xmF.add(substring);
                        }
                    } else {
                        a aVar2 = new a();
                        aVar2.type = cb(obj);
                        if (aVar2.type != -1) {
                            aVar2.hhA = obj.toString();
                            r = this.xmD.r(substring, aVar2);
                            if (r && this.xmF.contains(substring)) {
                                this.xmF.remove(substring);
                            }
                        } else {
                            return;
                        }
                    }
                    if (r) {
                        b(obj == null ? 5 : 4, this, aVar);
                    }
                    if (z) {
                        lH(true);
                    }
                }
            }
        }
    }

    private static boolean a(String str, Object obj, boolean z) {
        if (obj == null && z) {
            return true;
        }
        if (str.equals("INT") && (obj instanceof Integer)) {
            return true;
        }
        if (str.equals("LONG") && (obj instanceof Long)) {
            return true;
        }
        if (str.equals("STRING") && (obj instanceof String)) {
            return true;
        }
        if (str.equals("BOOLEAN") && (obj instanceof Boolean)) {
            return true;
        }
        if (str.equals("FLOAT") && (obj instanceof Float)) {
            return true;
        }
        if (str.equals("DOUBLE") && (obj instanceof Double)) {
            return true;
        }
        if (obj != null && b.ceK()) {
            Assert.assertTrue("checkType failed, input type and value[" + str + ", " + obj + "] are not match", false);
        }
        if (z) {
            x.e("MicroMsg.ConfigStorage", "checkType failed, input type and value[%s, %s] are not match", str, obj);
        }
        return false;
    }

    private static int cb(Object obj) {
        if (obj instanceof Integer) {
            return 1;
        }
        if (obj instanceof Long) {
            return 2;
        }
        if (obj instanceof String) {
            return 3;
        }
        if (obj instanceof Boolean) {
            return 4;
        }
        if (obj instanceof Float) {
            return 5;
        }
        if (obj instanceof Double) {
            return 6;
        }
        x.e("MicroMsg.ConfigStorage", "unresolve failed, unknown type=" + obj.getClass().toString());
        return -1;
    }

    private static Object m(int i, String str) {
        switch (i) {
            case 1:
                try {
                    return Integer.valueOf(str);
                } catch (Throwable e) {
                    x.e("MicroMsg.ConfigStorage", "exception:%s", bh.i(e));
                    break;
                }
            case 2:
                return Long.valueOf(str);
            case 3:
                return str;
            case 4:
                return Boolean.valueOf(str);
            case 5:
                return Float.valueOf(str);
            case 6:
                return Double.valueOf(str);
        }
        return null;
    }

    protected final boolean NE() {
        if (this.hhp != null && !this.hhp.cgM()) {
            return true;
        }
        String str = "MicroMsg.ConfigStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.hhp == null ? "null" : Boolean.valueOf(this.hhp.cgM());
        x.w(str, str2, objArr);
        return false;
    }

    public final boolean SY() {
        if (this.hhp.inTransaction()) {
            x.i("MicroMsg.ConfigStorage", "summer preAppend inTransaction return false");
            return false;
        }
        this.hSp = this.hhp.dz(Thread.currentThread().getId());
        if (this.hSp > 0) {
            return true;
        }
        x.i("MicroMsg.ConfigStorage", "summer preAppend ticket: " + this.hSp + " return false");
        return false;
    }

    public final void a(au<Object, Object> auVar, au.b<Object, Object> bVar) {
        Object obj = bVar.vxB;
        Object obj2 = bVar.values;
        int i = bVar.xhD;
        ContentValues contentValues;
        switch (((Integer) auVar.getTag()).intValue()) {
            case 1:
                if (i == 1) {
                    if (obj2 != null && (obj2 instanceof a)) {
                        a aVar = (a) obj2;
                        if (aVar.type != -1) {
                            contentValues = new ContentValues();
                            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, (Integer) bVar.vxB);
                            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(aVar.type));
                            contentValues.put(DownloadSettingTable$Columns.VALUE, aVar.hhA.toString());
                            this.hhp.replace("userinfo", SlookAirButtonFrequentContactAdapter.ID, contentValues);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (i == 2) {
                    this.hhp.delete("userinfo", "id=" + obj, null);
                    return;
                } else {
                    return;
                }
            case 3:
                if (i == 1) {
                    if (obj2 != null && (obj2 instanceof a)) {
                        a aVar2 = (a) obj2;
                        if (aVar2.type != -1) {
                            contentValues = new ContentValues();
                            contentValues.put("sid", (String) bVar.vxB);
                            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(aVar2.type));
                            contentValues.put(DownloadSettingTable$Columns.VALUE, aVar2.hhA.toString());
                            this.hhp.replace("userinfo2", SlookAirButtonFrequentContactAdapter.ID, contentValues);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (i == 2) {
                    this.hhp.delete("userinfo2", "sid= ?", new String[]{obj.toString()});
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void SZ() {
        if (this.hSp > 0) {
            this.hhp.fS(this.hSp);
        }
    }

    public final void lH(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.xmC.lE(z);
        this.xmD.lE(z);
        x.i("MicroMsg.ConfigStorage", "summer config appendAllToDisk force[%b] end takes[%d]ms ", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final void setInt(int i, int i2) {
        set(i, Integer.valueOf(i2));
    }

    public final int getInt(int i, int i2) {
        Integer num = (Integer) get(i, null);
        return num == null ? i2 : num.intValue();
    }

    public final void setLong(int i, long j) {
        set(i, Long.valueOf(j));
    }

    public final long Dm(int i) {
        Long l = (Long) get(i, null);
        return l == null ? 0 : l.longValue();
    }
}
