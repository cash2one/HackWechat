package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.by.g;
import com.tencent.mm.by.g.a;
import com.tencent.mm.by.h;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ac extends i<z> implements a {
    public static final String[] gJN = new String[]{i.a(z.gJc, "ContactLabel")};
    private e gJP;
    private HashMap<String, int[]> xxR;
    public HashMap<Integer, ArrayList<String>> xxS;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] xxT = new int[a.cil().length];

        static {
            try {
                xxT[a.xxU - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                xxT[a.xxV - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                xxT[a.xxW - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public final /* synthetic */ boolean a(c cVar) {
        z zVar = (z) cVar;
        boolean a = super.a(zVar);
        if (a) {
            Wc(a("replace", zVar));
        }
        aUR();
        return a;
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a(true, (z) cVar);
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        return b(true, (z) cVar, strArr);
    }

    public ac(e eVar) {
        this(eVar, z.gJc, "ContactLabel");
    }

    private ac(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.xxR = null;
        this.xxS = null;
        this.gJP = eVar;
        eVar.fx("ContactLabel", "CREATE INDEX IF NOT EXISTS  contact_label_createtime_index ON ContactLabel ( createTime )");
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gJP = gVar;
        }
        return 0;
    }

    public final ArrayList<String> cih() {
        ArrayList<String> arrayList = null;
        long Wp = bh.Wp();
        Cursor a = this.gJP.a("ContactLabel", new String[]{"labelName"}, null, null, null, null, "createTime ASC ", 2);
        if (a != null) {
            arrayList = new ArrayList();
            while (a.moveToNext()) {
                arrayList.add(a.getString(0));
            }
            a.close();
            x.i("MicroMsg.Label.ContactLabelStorage", "getAllLabel time:%s count:%s stack:%s", Long.valueOf(bh.bz(Wp)), Integer.valueOf(arrayList.size()), bh.cgy());
        }
        return arrayList;
    }

    public final ArrayList<z> cii() {
        ArrayList<z> arrayList = null;
        long Wp = bh.Wp();
        Cursor a = this.gJP.a("select * from ContactLabel order by createTime ASC ", null, 2);
        if (a != null) {
            arrayList = new ArrayList();
            while (a.moveToNext()) {
                z zVar = new z();
                zVar.b(a);
                arrayList.add(zVar);
            }
            a.close();
            x.i("MicroMsg.Label.ContactLabelStorage", "getAllContactLable time:%s count:%s stack:%s", Long.valueOf(bh.bz(Wp)), Integer.valueOf(arrayList.size()), bh.cgy());
        }
        return arrayList;
    }

    public final void aUR() {
        x.v("MicroMsg.Label.ContactLabelStorage", "cleanCache %s", bh.cgy());
        this.xxR = null;
        this.xxS = null;
    }

    public final void cij() {
        if (this.xxR == null || this.xxS == null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            long Wp = bh.Wp();
            Cursor a = this.gJP.a("select username , contactLabelIds from rcontact where (type & " + com.tencent.mm.l.a.Ax() + " !=0 ) and ( contactLabelIds != '') ;", null, 2);
            if (a == null) {
                this.xxR = hashMap;
                this.xxS = hashMap2;
                return;
            }
            while (a.moveToNext()) {
                String string = a.getString(0);
                if (!bh.ov(string)) {
                    String[] split = bh.ou(a.getString(1)).split(",");
                    if (split != null && split.length > 0) {
                        Object obj = new int[split.length];
                        for (int i = 0; i < split.length; i++) {
                            obj[i] = bh.getInt(split[i], -1);
                            if (hashMap2.containsKey(Integer.valueOf(obj[i]))) {
                                ((ArrayList) hashMap2.get(Integer.valueOf(obj[i]))).add(string);
                            } else {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(string);
                                hashMap2.put(Integer.valueOf(obj[i]), arrayList);
                            }
                        }
                        hashMap.put(string, obj);
                    }
                }
            }
            a.close();
            x.i("MicroMsg.Label.ContactLabelStorage", "checkRebuildCache time:%s user:%s label:%s stack:%s", Long.valueOf(bh.bz(Wp)), Integer.valueOf(hashMap.size()), Integer.valueOf(hashMap2.size()), bh.cgy());
            this.xxR = hashMap;
            this.xxS = hashMap2;
        }
    }

    public final ArrayList<String> WE(String str) {
        int i = -1;
        long Wp = bh.Wp();
        int i2 = bh.getInt(str, -1);
        if (i2 == -1) {
            x.e("MicroMsg.Label.ContactLabelStorage", "getUserNameListById  failed id:%s", str);
            return null;
        }
        cij();
        ArrayList<String> arrayList = (ArrayList) this.xxS.get(Integer.valueOf(i2));
        String str2 = "MicroMsg.Label.ContactLabelStorage";
        String str3 = "getUserNameListById time:%s id:%s count:%s stack:%s";
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(bh.bz(Wp));
        objArr[1] = str;
        if (arrayList != null) {
            i = arrayList.size();
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = bh.cgy();
        x.i(str2, str3, objArr);
        return arrayList;
    }

    public final ArrayList<String> o(String str, List<String> list) {
        Cursor a;
        Exception e;
        Throwable th;
        x.d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", "select labelName from ContactLabel where labelName like ? or labelPYFull like ? or labelPYShort like ?  order by createTime ASC ");
        try {
            a = this.gJP.a("select labelName from ContactLabel where labelName like ? or labelPYFull like ? or labelPYShort like ?  order by createTime ASC ", new String[]{"%" + str + "%", "%" + str + "%", "%" + str + "%"}, 2);
            try {
                int columnIndex = a.getColumnIndex("labelName");
                if (a.moveToFirst()) {
                    ArrayList<String> arrayList = new ArrayList();
                    do {
                        String string = a.getString(columnIndex);
                        if (list == null || list.size() <= 0 || !list.contains(string)) {
                            arrayList.add(string);
                        }
                    } while (a.moveToNext());
                    if (a == null) {
                        return arrayList;
                    }
                    a.close();
                    return arrayList;
                }
                if (a != null) {
                    a.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    x.w("MicroMsg.Label.ContactLabelStorage", "cpan[query] exception %s", e.toString());
                    if (a != null) {
                        a.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[query] exception %s", e.toString());
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    public final ArrayList<String> H(String[] strArr) {
        Exception e;
        Throwable th;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        int length = strArr.length;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelID");
        stringBuilder.append(" in ( ");
        for (int i = 0; i < length; i++) {
            stringBuilder.append("'" + strArr[i] + "'");
            if (i < length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] SQL:%s", stringBuilder.toString());
        Cursor a;
        try {
            a = this.gJP.a(stringBuilder.toString(), null, 2);
            try {
                length = a.getColumnIndex("labelName");
                if (a.moveToFirst()) {
                    ArrayList<String> arrayList = new ArrayList();
                    do {
                        arrayList.add(a.getString(length));
                    } while (a.moveToNext());
                    x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] resut size:%d", Integer.valueOf(arrayList.size()));
                    if (a == null) {
                        return arrayList;
                    }
                    a.close();
                    return arrayList;
                }
                if (a != null) {
                    a.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] exception:%s", e.toString());
                    if (a != null) {
                        a.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] exception:%s", e.toString());
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    public final ArrayList<String> ae(ArrayList<String> arrayList) {
        Cursor a;
        Exception e;
        Throwable th;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        int size = arrayList.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelName");
        stringBuilder.append(" in ( ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append("\"" + ((String) arrayList.get(i)) + "\"");
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        stringBuilder.append(" and isTemporary=0");
        x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] SQL:%s", stringBuilder.toString());
        try {
            a = this.gJP.a(stringBuilder.toString(), null, 2);
            try {
                int columnIndex = a.getColumnIndex("labelID");
                if (a.moveToFirst()) {
                    ArrayList<String> arrayList2 = new ArrayList();
                    do {
                        arrayList2.add(a.getString(columnIndex));
                    } while (a.moveToNext());
                    x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] resut size:%d", Integer.valueOf(arrayList2.size()));
                    if (a == null) {
                        return arrayList2;
                    }
                    a.close();
                    return arrayList2;
                }
                if (a != null) {
                    a.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] exception:%s", e.toString());
                    if (a != null) {
                        a.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] exception:%s", e.toString());
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    private boolean a(boolean z, z zVar) {
        boolean b = super.b((c) zVar);
        if (b && z) {
            Wc(a("insert", zVar));
        }
        return b;
    }

    public final boolean iF(String str) {
        int delete;
        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[delete] labelID:%s", str);
        x.d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", "labelID =? ");
        try {
            delete = this.gJP.delete("ContactLabel", "labelID =? ", new String[]{str});
        } catch (Exception e) {
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[delete] exception %s", e.toString());
            delete = -1;
        }
        if (delete > 0) {
            return true;
        }
        return false;
    }

    public boolean a(boolean z, z zVar, String... strArr) {
        boolean a = super.a((c) zVar, strArr);
        if (a && z) {
            Wc(a("delete", zVar));
            cik();
        }
        aUR();
        return a;
    }

    public boolean b(boolean z, z zVar, String... strArr) {
        boolean c = super.c(zVar, strArr);
        if (c && z) {
            Wc(a("update", zVar));
        }
        aUR();
        return c;
    }

    public final boolean cE(List<z> list) {
        if (list.size() <= 0) {
            x.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertAddLabel] list is null.");
        } else {
            long dz;
            h hVar;
            if (this.gJP instanceof h) {
                h hVar2 = (h) this.gJP;
                dz = hVar2.dz(Thread.currentThread().getId());
                x.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", Long.valueOf(dz));
                hVar = hVar2;
            } else {
                hVar = null;
                dz = -1;
            }
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                String c = c((z) list.get(i));
                if (!bh.ov(c)) {
                    iF(c);
                }
            }
            if (hVar != null) {
                hVar.fS(dz);
                x.i("MicroMsg.Label.ContactLabelStorage", "end deleteLocalLabel transaction");
            }
            aUR();
        }
        return false;
    }

    public final boolean cF(List<z> list) {
        if (list.size() <= 0) {
            x.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] list is null.");
            return false;
        }
        long dz;
        h hVar;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (this.gJP instanceof h) {
            h hVar2 = (h) this.gJP;
            dz = hVar2.dz(Thread.currentThread().getId());
            x.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", Long.valueOf(dz));
            hVar = hVar2;
        } else {
            hVar = null;
            dz = -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            z zVar = (z) list.get(i);
            if (zVar != null) {
                switch (AnonymousClass1.xxT[b(zVar) - 1]) {
                    case 1:
                        break;
                    case 2:
                        b(false, zVar, "labelID");
                        arrayList2.add(zVar);
                        break;
                    case 3:
                        zVar.field_createTime = System.currentTimeMillis();
                        a(false, zVar);
                        arrayList.add(zVar);
                        break;
                    default:
                        x.w("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] unknow result.");
                        break;
                }
            }
        }
        if (hVar != null) {
            hVar.fS(dz);
            x.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
        }
        if (arrayList.size() > 0) {
            Wc(p("insert", arrayList));
        }
        if (arrayList2.size() > 0) {
            Wc(p("update", arrayList2));
        }
        aUR();
        return false;
    }

    public final String Dn(String str) {
        Exception e;
        Throwable th;
        Cursor a;
        try {
            a = this.gJP.a("ContactLabel", new String[]{"labelName"}, "labelID =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        String string = a.getString(a.getColumnIndex("labelName"));
                        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrById] label string is %s", string);
                        if (a == null) {
                            return string;
                        }
                        a.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrById] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrById] exception %s", e.toString());
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
        return null;
    }

    public final String Do(String str) {
        Exception e;
        Throwable th;
        Cursor a;
        try {
            a = this.gJP.a("ContactLabel", new String[]{"labelID"}, "labelName =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        String string = a.getString(a.getColumnIndex("labelID"));
                        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] label id is %s", string);
                        if (a == null) {
                            return string;
                        }
                        a.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", e.toString());
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
        return null;
    }

    public final z WF(String str) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        Cursor a;
        try {
            a = this.gJP.a("ContactLabel", new String[]{"labelID", "createTime", "isTemporary", "labelName", "labelPYFull", "labelPYShort"}, "labelName =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        z zVar = new z();
                        zVar.b(a);
                        if (a == null) {
                            return zVar;
                        }
                        a.close();
                        return zVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", e.toString());
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return null;
    }

    public final z WG(String str) {
        Cursor a;
        Exception e;
        Throwable th;
        Cursor cursor = null;
        try {
            a = this.gJP.a("ContactLabel", new String[]{"labelID", "createTime", "isTemporary", "labelName", "labelPYFull", "labelPYShort"}, "labelID =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        z zVar = new z();
                        zVar.b(a);
                        if (a == null) {
                            return zVar;
                        }
                        a.close();
                        return zVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelByID] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelByID] exception %s", e.toString());
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return null;
    }

    private int b(z zVar) {
        Cursor cursor = null;
        try {
            cursor = this.gJP.a("select * from ContactLabel where labelID=?", new String[]{zVar.field_labelID}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return a.xxW;
            }
            int i;
            if (zVar.field_labelName.equalsIgnoreCase(bh.az(cursor.getString(cursor.getColumnIndex("labelName")), ""))) {
                i = a.xxU;
                if (cursor == null) {
                    return i;
                }
                cursor.close();
                return i;
            }
            i = a.xxV;
            if (cursor == null) {
                return i;
            }
            cursor.close();
            return i;
        } catch (Exception e) {
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private String c(z zVar) {
        Exception e;
        Throwable th;
        String str = null;
        Cursor a;
        try {
            a = this.gJP.a("select * from ContactLabel where labelName=? and isTemporary =?", new String[]{zVar.field_labelName, "1"}, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        boolean equalsIgnoreCase = zVar.field_labelName.equalsIgnoreCase(bh.az(a.getString(a.getColumnIndex("labelName")), ""));
                        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] itemname:%s dbname:%s", zVar.field_labelName, r1);
                        if (equalsIgnoreCase) {
                            str = a.getString(a.getColumnIndex("labelID"));
                            if (a != null) {
                                a.close();
                            }
                            return str;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", e.toString());
            if (a != null) {
                a.close();
            }
            return str;
        } catch (Throwable th3) {
            a = null;
            th = th3;
            if (a != null) {
                a.close();
            }
            throw th;
        }
        return str;
    }

    private static String a(String str, z zVar) {
        if (zVar == null) {
            return null;
        }
        List arrayList = new ArrayList();
        arrayList.add(zVar);
        return p(str, arrayList);
    }

    private static String p(String str, List<z> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" ");
        if (list == null || list.size() <= 0) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            z zVar = (z) list.get(i);
            if (zVar != null) {
                stringBuilder.append(zVar.field_labelID);
                if (i < size - 1) {
                    stringBuilder.append(" ");
                }
            }
        }
        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[genNotifyString] event:%s", stringBuilder.toString());
        return stringBuilder.toString();
    }

    private static void cik() {
        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[publishUpdateSearchIndexEvent]");
        b scVar = new sc();
        scVar.fJP.fpS = 3000;
        com.tencent.mm.sdk.b.a.xef.m(scVar);
    }

    public final boolean cG(List<z> list) {
        if (list == null || list.size() <= 0) {
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[deleteList] list is null.");
            return false;
        }
        long dz;
        h hVar;
        if (this.gJP instanceof h) {
            h hVar2 = (h) this.gJP;
            dz = hVar2.dz(Thread.currentThread().getId());
            x.i("MicroMsg.Label.ContactLabelStorage", "begin deleteList in a transaction, ticket = %d", Long.valueOf(dz));
            hVar = hVar2;
        } else {
            hVar = null;
            dz = -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(false, (z) list.get(i), "labelID");
        }
        if (hVar != null) {
            hVar.fS(dz);
            x.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
        }
        Wc(p("delete", list));
        cik();
        return true;
    }

    public final ArrayList<z> cH(List<z> list) {
        Exception e;
        Throwable th;
        if (list.size() <= 0) {
            return null;
        }
        int size = list.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelID");
        stringBuilder.append(" not in ( ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append("'" + ((z) list.get(i)).field_labelID + "'");
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        stringBuilder.append(" and isTemporary=0");
        x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] SQL:%s", stringBuilder.toString());
        Cursor a;
        try {
            a = this.gJP.a(stringBuilder.toString(), null, 2);
            try {
                if (a.moveToFirst()) {
                    ArrayList<z> arrayList = new ArrayList();
                    do {
                        z zVar = new z();
                        zVar.b(a);
                        arrayList.add(zVar);
                    } while (a.moveToNext());
                    x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] resut size:%d", Integer.valueOf(arrayList.size()));
                    if (a == null) {
                        return arrayList;
                    }
                    a.close();
                    return arrayList;
                }
                if (a != null) {
                    a.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] exception:%s", e.toString());
                    if (a != null) {
                        a.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] exception:%s", e.toString());
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }
}
