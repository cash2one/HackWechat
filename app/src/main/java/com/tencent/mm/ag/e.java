package com.tencent.mm.ag;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.ag.d.b;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class e extends i<d> {
    public static final String[] fMK = new String[]{"CREATE  INDEX IF NOT EXISTS type_username_index ON bizinfo ( type,username ) ", "CREATE  INDEX IF NOT EXISTS  username_acceptType_index ON bizinfo ( username,acceptType ) "};
    public static final String[] gJN = new String[]{i.a(d.gJc, "bizinfo")};
    public static Map<String, String> hpx = new HashMap();
    private final k<a, b> hod = new 1(this);

    public interface a {
        void a(b bVar);
    }

    public final /* synthetic */ boolean a(c cVar) {
        return e((d) cVar);
    }

    public final /* synthetic */ boolean b(c cVar) {
        return d((d) cVar);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, d.gJc, "bizinfo", fMK);
    }

    public final void a(a aVar, Looper looper) {
        this.hod.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.hod != null) {
            this.hod.remove(aVar);
        }
    }

    public final d jK(String str) {
        c dVar = new d();
        dVar.field_username = str;
        super.b(dVar, new String[0]);
        return dVar;
    }

    public final void jL(String str) {
        c dVar = new d();
        dVar.field_username = str;
        String[] strArr = new String[]{"username"};
        x.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", new Object[]{Boolean.valueOf(super.a(dVar, strArr)), str});
        b bVar = new b();
        bVar.hog = str;
        bVar.hpD = a.hpA;
        bVar.hpE = dVar;
        this.hod.ca(bVar);
        this.hod.doNotify();
    }

    public final void c(d dVar) {
        String[] strArr = new String[]{"username"};
        x.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", new Object[]{Boolean.valueOf(super.a(dVar, strArr)), dVar.field_username});
        b bVar = new b();
        bVar.hog = dVar.field_username;
        bVar.hpD = a.hpA;
        bVar.hpE = dVar;
        this.hod.ca(bVar);
        this.hod.doNotify();
    }

    public final boolean d(d dVar) {
        dVar.field_updateTime = System.currentTimeMillis();
        dVar.KZ();
        x.v("MicroMsg.BizInfoStorage", "username is %s, %s, %d, %s, %s, %s, %d", new Object[]{dVar.field_username, dVar.field_brandList, Integer.valueOf(dVar.field_brandFlag), dVar.field_brandInfo, dVar.field_extInfo, dVar.field_brandIconURL, Long.valueOf(dVar.field_updateTime)});
        b bI = dVar.bI(false);
        if (bI != null) {
            b.b Ly = bI.Ly();
            if (Ly != null) {
                dVar.field_specialType = Ly.hpc;
            }
        }
        boolean b = super.b(dVar);
        if (b && !s.eV(dVar.field_username)) {
            b bVar = new b();
            bVar.hog = dVar.field_username;
            bVar.hoG = dVar.La();
            bVar.hpD = a.hpz;
            bVar.hpE = dVar;
            this.hod.ca(bVar);
            this.hod.doNotify();
        }
        return b;
    }

    public final boolean e(d dVar) {
        dVar.field_updateTime = System.currentTimeMillis();
        dVar.KZ();
        b bI = dVar.bI(false);
        if (bI != null) {
            b.b Ly = bI.Ly();
            if (Ly != null) {
                dVar.field_specialType = Ly.hpc;
            }
        }
        boolean a = super.a(dVar);
        if (a && !s.eV(dVar.field_username)) {
            b bVar = new b();
            bVar.hog = dVar.field_username;
            bVar.hoG = dVar.La();
            bVar.hpD = a.hpB;
            bVar.hpE = dVar;
            this.hod.ca(bVar);
            this.hod.doNotify();
        }
        return a;
    }

    public final List<String> hq(int i) {
        x.i("MicroMsg.BizInfoStorage", "getList: sql[%s]", new Object[]{String.format(Locale.US, "select %s from %s where %s & %d > 0", new Object[]{"username", "bizinfo", "acceptType", Integer.valueOf(i)})});
        long Wq = bh.Wq();
        Cursor rawQuery = rawQuery(r0, new String[0]);
        List<String> linkedList = new LinkedList();
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    linkedList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            x.i("MicroMsg.BizInfoStorage", "getMyAcceptList: type[%d], use time[%d ms]", new Object[]{Integer.valueOf(i), Long.valueOf(bh.bA(Wq))});
            return ((h) g.h(h.class)).EY().cQ(linkedList);
        }
        x.i("MicroMsg.BizInfoStorage", "getMyAcceptList: cursor not null, type[%d], use time[%d ms]", new Object[]{Integer.valueOf(i), Long.valueOf(bh.bA(Wq))});
        return linkedList;
    }

    public final int hr(int i) {
        List hq = hq(i);
        if (bh.cA(hq)) {
            return 0;
        }
        return hq.size();
    }

    public static String LI() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("rcontact.showHead asc, ");
        stringBuffer.append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(").append("rcontact.conRemarkPYFull) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" case when length(rcontact.conRemark) > 0 then upper(").append("rcontact.conRemark) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" upper(rcontact.quanPin) asc, ");
        stringBuffer.append(" upper(rcontact.nickname) asc, ");
        stringBuffer.append(" upper(rcontact.username) asc ");
        return stringBuffer.toString();
    }

    public static String LJ() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("rcontact.type & ").append(2048).append(" desc, ");
        stringBuffer.append("rcontact.showHead asc, ");
        stringBuffer.append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(").append("rcontact.conRemarkPYFull) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" case when length(rcontact.conRemark) > 0 then upper(").append("rcontact.conRemark) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" upper(rcontact.quanPin) asc, ");
        stringBuffer.append(" upper(rcontact.nickname) asc, ");
        stringBuffer.append(" upper(rcontact.username) asc ");
        return stringBuffer.toString();
    }

    public static void a(StringBuilder stringBuilder) {
        stringBuilder.append("select bizinfo.username").append(" ");
    }

    public static void b(StringBuilder stringBuilder) {
        stringBuilder.append("select bizinfo.brandIconURL");
        stringBuilder.append(", bizinfo.type");
        stringBuilder.append(", bizinfo.status");
        stringBuilder.append(", bizinfo.enterpriseFather");
        stringBuilder.append(", bizinfo.brandFlag");
        stringBuilder.append(", bizinfo.extInfo");
        stringBuilder.append(", rcontact.username");
        stringBuilder.append(", rcontact.conRemark");
        stringBuilder.append(", rcontact.quanPin");
        stringBuilder.append(", rcontact.nickname");
        stringBuilder.append(", rcontact.alias");
        stringBuilder.append(", rcontact.type").append(" ");
    }

    public static void c(StringBuilder stringBuilder) {
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where rcontact.username").append(" = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag").append(" & ").append(com.tencent.mm.storage.x.cic()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type").append(" & 1) != 0 ");
    }

    public static void d(StringBuilder stringBuilder) {
        stringBuilder.append(" and bizinfo.type").append(" = 3 ");
    }

    public static void a(StringBuilder stringBuilder, String str) {
        stringBuilder.append(" and bizinfo.type").append(" = 3");
        stringBuilder.append(" and bizinfo.enterpriseFather").append(" = '").append(str).append("' ");
    }

    public static void a(StringBuilder stringBuilder, boolean z) {
        stringBuilder.append(" and (bizinfo.bitFlag").append(" & 1) ");
        stringBuilder.append(z ? "!=" : "==").append(" 0 ");
    }

    public static void b(StringBuilder stringBuilder, boolean z) {
        stringBuilder.append(" and (bizinfo.brandFlag").append(" & 1) ");
        stringBuilder.append(z ? "==" : "!=").append(" 0 ");
    }

    public static Cursor J(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        a(stringBuilder, false);
        b(stringBuilder, true);
        stringBuilder.append(" and (bizinfo.acceptType").append(" & ").append(i).append(") > 0 ");
        stringBuilder.append(" order by ");
        stringBuilder.append(LI());
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseChildOfAcceptType sql %s", new Object[]{stringBuilder.toString()});
        return g.Dj().gQj.a(stringBuilder.toString(), null, 0);
    }

    public final Cursor jM(String str) {
        String str2;
        List<String> jN = jN(str);
        List arrayList = new ArrayList();
        for (String str22 : jN) {
            if (!bh.ov(jK(str22).Ll())) {
                arrayList.add(str22);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        b(stringBuilder, true);
        stringBuilder.append(" and (");
        for (int i = 0; i < arrayList.size(); i++) {
            str22 = (String) arrayList.get(i);
            if (i > 0) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("rcontact.username = '").append(str22).append("'");
        }
        stringBuilder.append(") order by ");
        stringBuilder.append(LJ());
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseChatConnector sql %s", new Object[]{stringBuilder.toString()});
        return g.Dj().gQj.a(stringBuilder.toString(), null, 0);
    }

    public static List<String> LK() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select rcontact.username");
        stringBuilder.append(", bizinfo.enterpriseFather");
        stringBuilder.append(", bizinfo.bitFlag").append(" & 1");
        c(stringBuilder);
        d(stringBuilder);
        stringBuilder.append(" and (");
        stringBuilder.append(" (bizinfo.bitFlag").append(" & 1) != 0");
        stringBuilder.append(" or ");
        stringBuilder.append(" (bizinfo.acceptType").append(" & 128) > 0 ");
        stringBuilder.append(" and (bizinfo.brandFlag").append(" & 1) == 0) ");
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseConnectorList sql %s", new Object[]{stringBuilder.toString()});
        Cursor a = g.Dj().gQj.a(r0, null, 2);
        List<String> arrayList = new ArrayList();
        if (a == null) {
            return arrayList;
        }
        while (a.moveToNext()) {
            int i;
            if (a.getInt(2) > 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                i = 0;
            } else {
                i = 1;
            }
            arrayList.add(a.getString(i));
        }
        a.close();
        return ((h) g.h(h.class)).EY().cQ(arrayList);
    }

    public static Cursor z(String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        b(stringBuilder, true);
        if (z) {
            a(stringBuilder, false);
        }
        stringBuilder.append(" order by ");
        stringBuilder.append(LJ());
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseEnableChild sql %s", new Object[]{stringBuilder.toString()});
        return g.Dj().gQj.a(stringBuilder.toString(), null, 0);
    }

    public static List<String> jN(String str) {
        List<String> list = null;
        StringBuilder stringBuilder = new StringBuilder();
        a(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseChildNameList sql %s", new Object[]{stringBuilder.toString()});
        Cursor a = g.Dj().gQj.a(r1, null, 2);
        if (a != null) {
            list = new ArrayList();
            while (a.moveToNext()) {
                list.add(a.getString(0));
            }
            a.close();
        }
        return list;
    }

    public static String jO(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.BizInfoStorage", "getBizChatBrandUserName userName is null");
            return null;
        } else if (hpx == null || !hpx.containsKey(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            a(stringBuilder);
            c(stringBuilder);
            a(stringBuilder, str);
            a(stringBuilder, true);
            x.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatChild sql %s", new Object[]{stringBuilder.toString()});
            Cursor a = g.Dj().gQj.a(r0, null, 2);
            if (a == null) {
                return null;
            }
            if (a.moveToFirst()) {
                r0 = a.getString(0);
                hpx.put(str, r0);
            } else {
                r0 = null;
            }
            a.close();
            return r0;
        } else {
            r0 = (String) hpx.get(str);
            if (bh.ov(r0) || !s.gE(r0)) {
                return null;
            }
            return r0;
        }
    }

    public static List<String> hs(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select bizinfo.username");
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where bizinfo.specialType").append(" = 1");
        stringBuilder.append(" and rcontact.username").append(" = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag").append(" & ").append(com.tencent.mm.storage.x.cic()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type").append(" & 1) != 0 ");
        x.i("MicroMsg.BizInfoStorage", "getSpecialInternalBizUsernames sql %s", new Object[]{stringBuilder.toString()});
        List<String> arrayList = new ArrayList();
        Cursor a = g.Dj().gQj.a(r0, null, 2);
        int columnIndex = a.getColumnIndex("username");
        while (a.moveToNext()) {
            arrayList.add(a.getString(columnIndex));
        }
        a.close();
        return arrayList;
    }

    public static boolean jP(String str) {
        boolean z = false;
        if (!bh.ov(str) && f.jY(str)) {
            d jS = f.jS(str);
            if (!(jS.bI(false) == null || jS.bI(false).LG() == null || bh.ov(jS.Lm()))) {
                aj Xk = ((h) g.h(h.class)).Fd().Xk(jS.Lm());
                if (Xk != null && Xk.field_username.equals(str) && Xk.field_unReadCount > 0) {
                    ((h) g.h(h.class)).Fd().Xa(jS.Lm());
                }
            }
            Cursor EH = ((h) g.h(h.class)).aZi().EH(str);
            EH.moveToFirst();
            while (!EH.isAfterLast()) {
                cf auVar = new au();
                auVar.b(EH);
                auVar.eQ(4);
                x.d("MicroMsg.BizInfoStorage", "writeOpLog: msgSvrId = " + auVar.field_msgSvrId + " status = " + auVar.field_status);
                EH.moveToNext();
                z = true;
            }
            EH.close();
            if (z) {
                ((h) g.h(h.class)).Fd().Xa(str);
                ((h) g.h(h.class)).aZi().EF(str);
            }
        }
        return z;
    }

    public static void jQ(String str) {
        if (!bh.ov(str) && f.jY(str)) {
            ((com.tencent.mm.plugin.notification.b.a) g.k(com.tencent.mm.plugin.notification.b.a.class)).getNotification().eo(str);
            ((com.tencent.mm.plugin.notification.b.a) g.k(com.tencent.mm.plugin.notification.b.a.class)).getNotification().up();
        }
    }

    public static void jR(String str) {
        if (!bh.ov(str) && f.jY(str)) {
            ((com.tencent.mm.plugin.notification.b.a) g.k(com.tencent.mm.plugin.notification.b.a.class)).getNotification().eo("");
        }
    }
}
