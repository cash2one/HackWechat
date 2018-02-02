package com.tencent.mm.plugin.fav.b.c;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.plugin.fav.a.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class d extends i<f> implements o {
    private static final String mox = ("xml,edittime" + ",ext,favProto" + ",flag,fromUser" + ",id,itemStatus" + ",localId,localSeq" + ",realChatName,sourceCreateTime" + ",sourceId,sourceType" + ",toUser,type" + ",updateSeq,updateTime" + ",tagProto,sessionId" + ",datatotalsize,rowid");
    private e gJP;

    public final /* synthetic */ boolean b(c cVar) {
        return f((f) cVar);
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        return a((f) cVar, strArr);
    }

    public d(e eVar) {
        super(eVar, f.gJc, "FavItemInfo", null);
        this.gJP = eVar;
    }

    public final e aHY() {
        return this.gJP;
    }

    public final f db(long j) {
        if (this.gJP == null) {
            x.e("MicroMsg.Fav.FavItemInfoStorage", "getBtLocalId, but db is null, return");
            return null;
        }
        Cursor a = this.gJP.a("FavItemInfo", null, "localId=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            f fVar = new f();
            try {
                fVar.b(a);
                a.close();
                return fVar;
            } catch (Exception e) {
                x.e("MicroMsg.Fav.FavItemInfoStorage", "getByLocalId convertFrom(cu) cause IlleagalStateException, return null");
                a.close();
                return null;
            }
        }
        x.w("MicroMsg.Fav.FavItemInfoStorage", "klem getByLocalId:%d, no data", new Object[]{Long.valueOf(j)});
        a.close();
        return null;
    }

    public final f dc(long j) {
        Cursor rawQuery = this.gJP.rawQuery("Select * from FavItemInfo where id = " + j, null);
        if (rawQuery.getCount() != 0) {
            f fVar = new f();
            rawQuery.moveToFirst();
            try {
                fVar.b(rawQuery);
                rawQuery.close();
                return fVar;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Fav.FavItemInfoStorage", e, "", new Object[0]);
                x.e("MicroMsg.Fav.FavItemInfoStorage", "getByFavId(%d),info.convertFrom error", new Object[]{Long.valueOf(j)});
                rawQuery.close();
                return null;
            }
        }
        x.w("MicroMsg.Fav.FavItemInfoStorage", "klem getByFavId:%d, no data", new Object[]{Long.valueOf(j)});
        rawQuery.close();
        return null;
    }

    public final int aHZ() {
        Cursor rawQuery = rawQuery("select count(*) from FavItemInfo where type = 2", new String[0]);
        if (rawQuery == null) {
            return 0;
        }
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i;
    }

    public final f zU(String str) {
        Cursor a = this.gJP.a("FavItemInfo", null, "sourceId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            f fVar = new f();
            fVar.b(a);
            a.close();
            return fVar;
        }
        x.w("MicroMsg.Fav.FavItemInfoStorage", "klem getBySourceId:%s, no data", new Object[]{str});
        a.close();
        return null;
    }

    public final boolean f(f fVar) {
        Assert.assertTrue(fVar.field_localId > 0);
        if (fVar.field_favProto.weS != null) {
            vk vkVar = fVar.field_favProto.weS;
            if (vkVar.fqd <= 0) {
                x.w("MicroMsg.Fav.FavItemInfoStorage", "insert::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId), Integer.valueOf(fVar.field_type), Integer.valueOf(vkVar.fqd)});
                vkVar.CS(1);
            } else {
                vkVar.CS(vkVar.fqd);
            }
        }
        b.a(fVar);
        boolean a = a(fVar, false);
        if (a) {
            b(fVar.field_localId, 2, Long.valueOf(fVar.field_localId));
        }
        return a;
    }

    public final boolean a(f fVar, String... strArr) {
        if (fVar.field_favProto.weS != null) {
            vk vkVar = fVar.field_favProto.weS;
            if (vkVar.fqd <= 0) {
                x.w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId), Integer.valueOf(fVar.field_type), Integer.valueOf(vkVar.fqd)});
                vkVar.CS(1);
            } else {
                vkVar.CS(vkVar.fqd);
            }
        }
        b.a(fVar);
        boolean b = super.b(fVar, false, strArr);
        if (b) {
            b(fVar.field_localId, 3, Long.valueOf(fVar.field_localId));
        }
        x.d("MicroMsg.Fav.FavItemInfoStorage", "update result[%B]", new Object[]{Boolean.valueOf(b)});
        return b;
    }

    public final boolean p(long j, int i) {
        String str = "select count(updateTime) from FavItemInfo where updateTime < " + j;
        if (i != -1) {
            str = str + " and type = " + i;
        }
        Cursor a = this.gJP.a(str, null, 2);
        if (a == null) {
            return true;
        }
        a.moveToFirst();
        if (a.getInt(0) == 0) {
            a.close();
            return true;
        }
        a.close();
        return false;
    }

    public final long f(long j, int i, int i2) {
        if (this.gJP == null) {
            x.e("MicroMsg.Fav.FavItemInfoStorage", "getNextUpdateTime, but db is null, return");
            return 0;
        } else if (j == 0) {
            r0 = "select updateTime from FavItemInfo where itemStatus > 0";
            if (i2 != -1) {
                r0 = r0 + " and type = " + i2;
            }
            Cursor rawQuery = this.gJP.rawQuery(r0 + " order by updateTime desc limit 20", null);
            if (rawQuery == null) {
                return 0;
            }
            if (rawQuery.getCount() == 0) {
                rawQuery.close();
                return 0;
            }
            rawQuery.moveToLast();
            r0 = rawQuery.getLong(0);
            rawQuery.close();
            return r0;
        } else {
            r0 = "select updateTime from FavItemInfo where updateTime < " + j;
            if (i2 != -1) {
                r0 = r0 + " and type = " + i2;
            }
            Cursor rawQuery2 = this.gJP.rawQuery((r0 + " and itemStatus > 0") + " order by updateTime desc limit 20", null);
            if (rawQuery2 == null || rawQuery2.getCount() <= 0) {
                r0 = j;
            } else {
                rawQuery2.moveToLast();
                r0 = rawQuery2.getLong(0);
            }
            if (rawQuery2 == null) {
                return r0;
            }
            rawQuery2.close();
            return r0;
        }
    }

    public final List<f> a(int i, int i2, Set<Integer> set, n nVar) {
        if (set == null || !set.contains(Integer.valueOf(i))) {
            String str;
            List<f> arrayList = new ArrayList();
            String str2 = "select " + mox + " from FavItemInfo where itemStatus" + " > 0";
            if (i != -1) {
                str = str2 + " and type = " + i;
            } else if (set != null) {
                str = str2;
                for (Integer intValue : set) {
                    str = str + " and type != " + intValue.intValue();
                }
            } else {
                str = str2;
            }
            Cursor a = this.gJP.a(str + " order by updateTime desc limit 20", null, 2);
            if (a == null) {
                return arrayList;
            }
            while (a.moveToNext()) {
                f fVar = new f();
                fVar.b(a);
                if (nVar == null || !nVar.e(fVar)) {
                    arrayList.add(fVar);
                } else {
                    x.w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", new Object[]{Integer.valueOf(fVar.field_id), Integer.valueOf(fVar.field_type)});
                }
            }
            a.close();
            return arrayList;
        }
        x.w("MicroMsg.Fav.FavItemInfoStorage", "getFirstPageList::block set contains target type, error, do return null");
        return null;
    }

    public final LinkedList<Integer> q(long j, int i) {
        LinkedList<Integer> linkedList = new LinkedList();
        String str = "select id from FavItemInfo where updateTime >= " + j;
        if (i != -1) {
            str = str + " and type = " + i;
        }
        Cursor a = this.gJP.a((str + " and updateSeq > localSeq") + " order by updateTime desc", null, 2);
        if (a == null) {
            return linkedList;
        }
        while (a.moveToNext()) {
            linkedList.add(Integer.valueOf(a.getInt(0)));
        }
        a.close();
        return linkedList;
    }

    public final long g(long j, int i, int i2) {
        if (this.gJP == null) {
            x.e("MicroMsg.Fav.FavItemInfoStorage", "getMinBatchGetUpdateTime, but db is null, return");
            return 0;
        } else if (j == 0) {
            r0 = "select updateTime from (select * from FavItemInfo";
            if (i2 != -1) {
                r0 = r0 + " where type = " + i2;
            }
            r4 = this.gJP.rawQuery((r0 + " order by updateTime desc limit 20") + ") where updateSeq > localSeq", null);
            if (r4 == null) {
                return 0;
            }
            if (r4.getCount() == 0) {
                r4.close();
                return 0;
            }
            r4.moveToLast();
            r0 = r4.getLong(0);
            r4.close();
            return r0;
        } else {
            r0 = "select updateTime from (select * from FavItemInfo where updateTime < " + j;
            if (i2 != -1) {
                r0 = r0 + " and type = " + i2;
            }
            r4 = this.gJP.rawQuery((r0 + " order by updateTime desc limit 20") + ") where updateSeq > localSeq", null);
            if (r4 == null) {
                return 0;
            }
            if (r4.getCount() == 0) {
                r4.close();
                return 0;
            }
            r4.moveToLast();
            r0 = r4.getLong(0);
            r4.close();
            return r0;
        }
    }

    public final List<f> a(long j, int i, Set<Integer> set, n nVar) {
        if (set == null || !set.contains(Integer.valueOf(i))) {
            String str;
            List<f> arrayList = new ArrayList();
            String str2 = "select " + mox + " from FavItemInfo where updateTime" + " >= " + j;
            if (i != -1) {
                str = str2 + " and type = " + i;
            } else if (set != null) {
                str = str2;
                for (Integer intValue : set) {
                    str = str + " and type != " + intValue.intValue();
                }
            } else {
                str = str2;
            }
            Cursor a = this.gJP.a((str + " and itemStatus > 0") + " order by updateTime desc", null, 2);
            if (a == null) {
                return arrayList;
            }
            while (a.moveToNext()) {
                f fVar = new f();
                try {
                    fVar.b(a);
                    if (nVar == null || !nVar.e(fVar)) {
                        arrayList.add(fVar);
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.Fav.FavItemInfoStorage", "fav getlist convertfrom (cu) error,continue");
                }
            }
            a.close();
            return arrayList;
        }
        x.w("MicroMsg.Fav.FavItemInfoStorage", "getList::block set contains target type, error, do return null");
        return null;
    }

    public final List<f> aIa() {
        List<f> list = null;
        Cursor rawQuery = this.gJP.rawQuery("select " + mox + " from FavItemInfo where itemStatus" + "=3", null);
        if (rawQuery != null) {
            if (rawQuery.getCount() == 0) {
                rawQuery.close();
            } else {
                list = new LinkedList();
                while (rawQuery.moveToNext()) {
                    f fVar = new f();
                    fVar.b(rawQuery);
                    list.add(fVar);
                }
                rawQuery.close();
            }
        }
        return list;
    }

    public final List<f> aIb() {
        List<f> list = null;
        Cursor a = this.gJP.a("select " + mox + " from FavItemInfo where itemStatus" + "=1", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                list = new LinkedList();
                do {
                    f fVar = new f();
                    fVar.b(a);
                    list.add(fVar);
                } while (a.moveToNext());
            }
            a.close();
        }
        return list;
    }

    public final void t(int i, long j) {
        x.d("MicroMsg.Fav.FavItemInfoStorage", "setStatus status:%d,localId:%d", new Object[]{Integer.valueOf(i), Long.valueOf(j)});
        this.gJP.fx("FavItemInfo", "update FavItemInfo set itemStatus = " + i + " where localId = " + j);
        Wc(String.valueOf(j));
    }

    public final void g(f fVar) {
        String str = "delete from FavItemInfo where localId = " + fVar.field_localId;
        x.i("MicroMsg.Fav.FavItemInfoStorage", "delete sql: " + str);
        this.gJP.fx("FavItemInfo", str);
        b(fVar.field_localId, 5, Long.valueOf(fVar.field_localId));
    }

    public final List<f> aIc() {
        List<f> list = null;
        Cursor a = this.gJP.a("select " + mox + " from FavItemInfo where (itemStatus" + "=9 or itemStatus" + "=12)", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    f fVar = new f();
                    fVar.b(a);
                    list.add(fVar);
                } while (a.moveToNext());
            }
            a.close();
        }
        return list;
    }

    public final List<f> aId() {
        List<f> list = null;
        Cursor a = this.gJP.a("select " + mox + " from FavItemInfo where itemStatus" + "=17", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    f fVar = new f();
                    fVar.b(a);
                    list.add(fVar);
                } while (a.moveToNext());
            }
            a.close();
        }
        return list;
    }

    public final List<f> aIe() {
        List<f> list = null;
        Cursor a = this.gJP.a("select " + mox + " from FavItemInfo where itemStatus" + "=3 or itemStatus" + "=6 or itemStatus" + "=11 or itemStatus" + "=14 or itemStatus" + "=16 or itemStatus" + "=18", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    f fVar = new f();
                    fVar.b(a);
                    list.add(fVar);
                } while (a.moveToNext());
            }
            a.close();
        }
        return list;
    }

    public final ArrayList<f> a(List<Long> list, List<f> list2, Set<Integer> set, n nVar) {
        if (list == null || list.size() == 0 || list.size() > 20) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select ").append(mox).append(" from FavItemInfo where ");
        if (set != null && set.size() > 0) {
            stringBuffer.append("( 1=1");
            for (Integer append : set) {
                stringBuffer.append(" and type != ").append(append);
            }
            stringBuffer.append(") and ");
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                stringBuffer.append("( ");
            }
            if (i == size - 1) {
                stringBuffer.append("localId = ").append(list.get(i)).append(" )");
            } else {
                stringBuffer.append("localId = ").append(list.get(i)).append(" or ");
            }
        }
        stringBuffer.append(" order by updateTime desc");
        x.d("MicroMsg.Fav.FavItemInfoStorage", "get list by id list sql %s", new Object[]{stringBuffer.toString()});
        Cursor a = this.gJP.a(r0, null, 2);
        if (a == null) {
            return null;
        }
        ArrayList<f> arrayList;
        if (a.moveToFirst()) {
            ArrayList<f> arrayList2 = new ArrayList();
            do {
                f fVar;
                if (list2 == null || list2.isEmpty()) {
                    fVar = new f();
                } else {
                    fVar = (f) list2.remove(0);
                }
                fVar.b(a);
                if (nVar == null || !nVar.e(fVar)) {
                    arrayList2.add(fVar);
                } else {
                    x.w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", new Object[]{Integer.valueOf(fVar.field_id), Integer.valueOf(fVar.field_type)});
                }
            } while (a.moveToNext());
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        a.close();
        return arrayList;
    }

    public final boolean b(f fVar, String... strArr) {
        if (fVar.field_favProto.weS != null) {
            vk vkVar = fVar.field_favProto.weS;
            if (vkVar.fqd <= 0) {
                x.w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId), Integer.valueOf(fVar.field_type), Integer.valueOf(vkVar.fqd)});
                vkVar.CS(1);
            } else {
                vkVar.CS(vkVar.fqd);
            }
        }
        return super.b(fVar, false, strArr);
    }

    public final List<f> aIf() {
        List<f> list = null;
        Cursor a = this.gJP.a("select " + mox + " from FavItemInfo where flag" + " =  -1 and itemStatus = 0 ", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    f fVar = new f();
                    fVar.b(a);
                    list.add(fVar);
                } while (a.moveToNext());
            }
            a.close();
        }
        return list;
    }

    public final List<Long> aIg() {
        long currentTimeMillis = System.currentTimeMillis();
        List<Long> arrayList = new ArrayList();
        String str = "select localId from FavItemInfo where ";
        String str2 = "";
        int[] iArr = a.mnS;
        int length = iArr.length;
        int i = 0;
        while (i < length) {
            i++;
            str2 = str2 + iArr[i] + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        str = (str + " itemStatus in (" + str2 + ")") + " and datatotalsize > 0 ";
        str2 = "";
        iArr = a.mnR;
        length = iArr.length;
        i = 0;
        while (i < length) {
            i++;
            str2 = str2 + iArr[i] + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        Cursor rawQuery = this.gJP.rawQuery((str + " and type in (" + str2 + ")") + " order by datatotalsize desc", null);
        if (rawQuery == null) {
            return arrayList;
        }
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            return arrayList;
        }
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        long currentTimeMillis2 = System.currentTimeMillis();
        x.i("MicroMsg.Fav.FavItemInfoStorage", "getCleanList cu.getCount() = %d,used %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
        return arrayList;
    }

    public final void aIh() {
        x.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength");
        String str = "select " + mox + " from FavItemInfo where ";
        String str2 = "";
        int[] iArr = a.mnS;
        int length = iArr.length;
        int i = 0;
        while (i < length) {
            i++;
            str2 = str2 + iArr[i] + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        str = str + "itemStatus in (" + str2 + ")";
        str2 = "";
        iArr = a.mnR;
        length = iArr.length;
        i = 0;
        while (i < length) {
            i++;
            str2 = str2 + iArr[i] + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        Cursor rawQuery = this.gJP.rawQuery(str + " and type in (" + str2 + ")", null);
        if (rawQuery == null) {
            x.e("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu = null");
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            x.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = 0");
        } else {
            long dz;
            x.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = " + rawQuery.getCount());
            if (this.gJP instanceof h) {
                dz = ((h) this.gJP).dz(Thread.currentThread().getId());
            } else {
                dz = 0;
            }
            while (rawQuery.moveToNext()) {
                f fVar = new f();
                fVar.b(rawQuery);
                if (pH(fVar.field_itemStatus)) {
                    long j;
                    if (fVar.field_favProto != null) {
                        Iterator it = fVar.field_favProto.weU.iterator();
                        j = 0;
                        while (it.hasNext()) {
                            j = ((uq) it.next()).wde + j;
                        }
                    } else {
                        j = 0;
                    }
                    fVar.field_datatotalsize = j;
                    a(fVar, "localId");
                }
            }
            if (this.gJP instanceof h) {
                ((h) this.gJP).fS(dz);
            }
            rawQuery.close();
            x.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength end");
        }
    }

    private static boolean pH(int i) {
        for (int i2 : a.mnS) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public final List<Long> aIi() {
        List arrayList = new ArrayList();
        Cursor a = this.gJP.a("select localId from FavItemInfo" + " order by updateTime desc", null, 2);
        if (a != null) {
            if (a.getCount() == 0) {
                a.close();
            } else {
                while (a.moveToNext()) {
                    arrayList.add(Long.valueOf(a.getLong(0)));
                }
                a.close();
            }
        }
        return arrayList;
    }
}
