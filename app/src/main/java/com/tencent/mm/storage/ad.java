package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.by.d;
import com.tencent.mm.by.h;
import com.tencent.mm.g.b.af;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ad extends m implements ar {
    public static final String[] fMK = new String[]{"CREATE UNIQUE INDEX IF NOT EXISTS  contact_username_unique_index ON rcontact ( username )", "CREATE INDEX IF NOT EXISTS  contact_alias_index ON rcontact ( alias )", "CREATE INDEX IF NOT EXISTS  en_username_unique_index ON rcontact ( encryptUsername )", "CREATE UNIQUE INDEX IF NOT EXISTS  bottle_username_unique_index ON bottlecontact ( username )", "CREATE INDEX IF NOT EXISTS type_verifyFlag_index ON rcontact ( type,verifyFlag ) "};
    public static final String[] gJN = new String[]{i.a(x.gJc, "rcontact"), i.a(x.gJc, "bottlecontact"), i.a(y.gJc, "ContactCmdBuf"), "CREATE TABLE IF NOT EXISTS contact ( contactID INTEGER PRIMARY KEY, sex INT, type INT, showHead INT, username VARCHAR(40), nickname VARCHAR(40), pyInitial VARCHAR(40), quanPin VARCHAR(60), reserved TEXT );", "CREATE TABLE IF NOT EXISTS contact_ext ( username VARCHAR(40), Uin INTEGER DEFAULT 0, Email VARCHAR(128), Mobile VARCHAR(40), ShowFlag INTEGER DEFAULT 0 , ConType INTEGER DEFAULT 0 , ConRemark TEXT, ConRemark_PYShort TEXT, ConRemark_PYFull TEXT, ConQQMBlog TEXT, ConSMBlog TEXT, DomainList TEXT, reserved1 INT DEFAULT 0 , reserved2 INT DEFAULT 0 , reserved3 INT DEFAULT 0 , reserved4 INT DEFAULT 0 , reserved5 INT DEFAULT 0 , reserved6 TEXT, reserved7 TEXT, reserved8 TEXT, reserved9 TEXT, reserved10 TEXT, weiboflag  INT DEFAULT 0 ,weibonickname TEXT  );"};
    private static String xyb = "showHead = 32";
    private static String xyc = "type & 64 !=0 ";
    private e gJP;
    private final k<a, x> hod = new 1(this);
    private e xxY;
    public final f<String, x> xxZ = new f(200);
    public final f<String, Integer> xya = new f(400);

    private static String WH(String str) {
        return "select *,rowid from " + WI(str) + " ";
    }

    private static String WI(String str) {
        if (x.gy(str)) {
            return "bottlecontact";
        }
        return "rcontact";
    }

    public ad(h hVar) {
        int i = 1;
        int i2 = 0;
        Cursor a = hVar.a("PRAGMA table_info( contact_ext )", null, 2);
        int columnIndex = a.getColumnIndex("name");
        int i3 = 0;
        int i4 = 0;
        while (a.moveToNext() && (i4 == 0 || i3 == 0)) {
            if (columnIndex >= 0) {
                String string = a.getString(columnIndex);
                if ("weiboNickname".equalsIgnoreCase(string)) {
                    i3 = 1;
                } else if ("weiboFlag".equalsIgnoreCase(string)) {
                    i4 = 1;
                }
            }
        }
        a.close();
        if (i4 == 0) {
            hVar.fx("contact_ext", "Alter table contact_ext add weiboFlag INT DEFAULT 0 ");
        }
        if (i3 == 0) {
            hVar.fx("contact_ext", "Alter table contact_ext add weiboNickname INT DEFAULT 0 ");
        }
        Cursor a2 = hVar.a("PRAGMA table_info( rcontact )", null, 2);
        i4 = a2.getColumnIndex("name");
        while (a2.moveToNext()) {
            if (i4 >= 0) {
                if ("verifyFlag".equalsIgnoreCase(a2.getString(i4))) {
                    break;
                }
            }
        }
        i = 0;
        a2.close();
        if (i == 0) {
            hVar.fx("rcontact", "Alter table rcontact add verifyFlag INT DEFAULT 0 ");
        }
        for (String fx : i.a(com.tencent.mm.l.a.gJc, "bottlecontact", hVar)) {
            hVar.fx("bottlecontact", fx);
        }
        for (String fx2 : i.a(com.tencent.mm.l.a.gJc, "rcontact", hVar)) {
            hVar.fx("rcontact", fx2);
        }
        String[] strArr = fMK;
        i = strArr.length;
        while (i2 < i) {
            hVar.fx("rcontact", strArr[i2]);
            i2++;
        }
        this.gJP = hVar;
        this.xxY = hVar;
    }

    public final void a(a aVar) {
        this.hod.a(aVar, null);
    }

    public final void b(a aVar) {
        if (this.hod != null) {
            this.hod.remove(aVar);
        }
    }

    public final x WJ(String str) {
        x xVar = (x) this.xxZ.get(str);
        return xVar != null ? xVar : null;
    }

    public final void O(x xVar) {
        if (xVar != null && xVar.field_username != null && xVar.field_type != 0) {
            this.xxZ.l(xVar.field_username, xVar);
            this.xya.l(xVar.field_username, Integer.valueOf(xVar.field_type));
        }
    }

    private void IV(String str) {
        if (!bh.ov(str)) {
            this.xxZ.remove(str);
            this.xya.remove(str);
        }
    }

    public final boolean WK(String str) {
        if (bh.ov(str) || (str.contains("@") && !str.endsWith("@stranger"))) {
            return false;
        }
        Integer num = (Integer) this.xya.get(str);
        if (num != null) {
            return com.tencent.mm.l.a.fZ(num.intValue());
        }
        af WO = WO(str);
        if (WO == null || !(WO.field_username.equals(str) || str.equals(WO.field_encryptUsername))) {
            this.xya.l(str, Integer.valueOf(0));
            return false;
        }
        this.xya.l(str, Integer.valueOf(WO.field_type));
        return com.tencent.mm.l.a.fZ(WO.field_type);
    }

    public final boolean P(x xVar) {
        if (WQ(xVar.field_username)) {
            if (a(xVar.field_username, xVar) == 0) {
                return true;
            }
            return false;
        } else if (S(xVar) < 0) {
            return false;
        } else {
            return true;
        }
    }

    public final x WL(String str) {
        if (bh.ov(str)) {
            return null;
        }
        x xVar = new x();
        Cursor a = this.gJP.a("select *,rowid from rcontact where alias=" + h.fe(str), null, 2);
        if (a.moveToFirst()) {
            xVar.b(a);
            O(xVar);
        }
        a.close();
        xVar.cif();
        return xVar;
    }

    public final Cursor a(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2) {
        String str3 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff from rcontact " + d(str, str2, list) + cM(list2) + cis();
        x.v("MicroMsg.ContactStorage", str3);
        if (!z) {
            return this.gJP.a(str3, null, 4);
        }
        com.tencent.mm.by.a.f[] fVarArr = new com.tencent.mm.by.a.f[2];
        String str4 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff from rcontact " + k(list, z2) + cit();
        x.v("MicroMsg.ContactStorage", "favourSql " + str3);
        Cursor a = this.gJP.a(str4, null, 4);
        Cursor a2 = this.gJP.a(str3, null, 4);
        if (!(a instanceof com.tencent.mm.by.a.f) || !(a2 instanceof com.tencent.mm.by.a.f)) {
            return d.ckM();
        }
        fVarArr[0] = (com.tencent.mm.by.a.f) a;
        fVarArr[1] = (com.tencent.mm.by.a.f) a2;
        return new com.tencent.mm.by.a.e(fVarArr);
    }

    public final Cursor cI(List<String> list) {
        boolean z;
        int i = 0;
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,type from rcontact  where ";
        while (i < list.size()) {
            if (i != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i)) + "'";
            }
            i++;
        }
        return this.gJP.rawQuery(str + cis(), null);
    }

    public final Cursor cJ(List<String> list) {
        boolean z;
        int i = 0;
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff from rcontact  where ";
        while (i < list.size()) {
            if (i != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i)) + "'";
            }
            i++;
        }
        return this.gJP.rawQuery(str + cis(), null);
    }

    public final Cursor b(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2) {
        String str3 = "select username from rcontact " + d(str, str2, list) + cM(list2) + cis();
        x.v("MicroMsg.ContactStorage", str3);
        if (!z) {
            return this.gJP.rawQuery(str3, null);
        }
        com.tencent.mm.by.a.f[] fVarArr = new com.tencent.mm.by.a.f[2];
        String str4 = "select username from rcontact " + k(list, z2) + cit();
        x.v("MicroMsg.ContactStorage", "favourSql " + str3);
        Cursor a = this.gJP.a(str4, null, 4);
        Cursor a2 = this.gJP.a(str3, null, 4);
        if (!(a instanceof com.tencent.mm.by.a.f) || !(a2 instanceof com.tencent.mm.by.a.f)) {
            return d.ckM();
        }
        fVarArr[0] = (com.tencent.mm.by.a.f) a;
        fVarArr[1] = (com.tencent.mm.by.a.f) a2;
        return new com.tencent.mm.by.a.e(fVarArr);
    }

    public final x WM(String str) {
        if (bh.ov(str)) {
            return null;
        }
        if (x.gy(str)) {
            str = x.WD(str);
        }
        x WJ = WJ(str);
        if (WJ != null) {
            WJ.cif();
            return WJ;
        }
        WJ = new x();
        Cursor a = this.gJP.a(WH(str) + " where username=" + h.fe(str), null, 2);
        if (a.moveToFirst()) {
            WJ.b(a);
            O(WJ);
        }
        a.close();
        WJ.cif();
        return WJ;
    }

    public final x WN(String str) {
        if (bh.ov(str)) {
            return null;
        }
        if (x.gy(str)) {
            str = x.WD(str);
        }
        x WJ = WJ(str);
        if (WJ != null) {
            return WJ;
        }
        WJ = new x();
        Cursor a = this.gJP.a(WH(str) + " where username=" + h.fe(str) + " or encryptUsername=" + h.fe(str), null, 2);
        if (a.moveToFirst()) {
            WJ.b(a);
            O(WJ);
        }
        a.close();
        return WJ;
    }

    public final x WO(String str) {
        if (bh.ov(str)) {
            return null;
        }
        if (x.gy(str)) {
            str = x.WD(str);
        }
        x WJ = WJ(str);
        if (WJ != null) {
            return WJ;
        }
        WJ = new x();
        Cursor a = this.gJP.a(WH(str) + " where username=" + h.fe(str) + " or encryptUsername=" + h.fe(str), null, 2);
        if (a.moveToFirst()) {
            WJ.b(a);
            a.close();
            WJ.cif();
            O(WJ);
        } else {
            a.close();
        }
        return WJ;
    }

    public final x fO(long j) {
        x xVar = null;
        if (j > 0) {
            Cursor a = this.gJP.a("select * ,rowid from rcontact  where rowid=" + j, null, 2);
            if (a.moveToFirst()) {
                xVar = new x();
                xVar.b(a);
                O(xVar);
            }
            a.close();
            if (xVar != null) {
                xVar.cif();
            }
        }
        return xVar;
    }

    public final long WP(String str) {
        com.tencent.mm.l.a WO = WO(str);
        if (WO == null || WO.gJd <= 0) {
            return -1;
        }
        return (long) ((int) WO.gJd);
    }

    public final boolean WQ(String str) {
        af WO = WO(str);
        if (WO == null || bh.ov(WO.field_username) || !WO.field_username.equals(str)) {
            return false;
        }
        return true;
    }

    public final boolean WR(String str) {
        boolean z = false;
        if (!bh.ov(str)) {
            Cursor a = this.gJP.a("select count(*) from " + WI(str) + " where type & " + com.tencent.mm.l.a.Ay() + " !=0 and username=" + h.fe(str), null, 2);
            if (a.moveToFirst() && a.getInt(0) > 0) {
                z = true;
            }
            a.close();
        }
        return z;
    }

    public final boolean Q(x xVar) {
        Assert.assertTrue("contact NULL !", xVar != null);
        if (!T(xVar)) {
            return true;
        }
        xVar.ex(xVar.Ad());
        this.hod.ca(xVar);
        this.hod.doNotify();
        x.d("MicroMsg.ContactStorage", "replace : username=%s, showHead=%d, verifyFlag=%d", new Object[]{xVar.field_username, Integer.valueOf(xVar.field_showHead), Integer.valueOf(xVar.field_verifyFlag)});
        ContentValues vI = xVar.vI();
        if (((int) xVar.gJd) > 0) {
            vI.put("rowid", Integer.valueOf((int) xVar.gJd));
        }
        boolean z = this.gJP.replace(WI(xVar.field_username), com.tencent.mm.l.a.gJc.xjz, vI) > 0;
        IV(xVar.field_username);
        if (!bh.ov(xVar.field_encryptUsername)) {
            IV(xVar.field_encryptUsername);
        }
        if (!z) {
            return false;
        }
        b(4, this, xVar.field_username);
        return true;
    }

    public final boolean R(x xVar) {
        return S(xVar) > 0;
    }

    public final int S(x xVar) {
        if (bh.ou(xVar.field_username).length() <= 0) {
            x.e("MicroMsg.ContactStorage", "FATAL ERROR, invalid contact, empty username");
            return -1;
        }
        int i;
        xVar.ex(xVar.Ad());
        this.hod.ca(xVar);
        this.hod.doNotify();
        int insert = (int) this.gJP.insert(WI(xVar.field_username), com.tencent.mm.l.a.gJc.xjz, xVar.vI());
        int bz = (int) bh.bz(System.currentTimeMillis());
        boolean z = b.foreground;
        com.tencent.mm.plugin.report.d dVar = com.tencent.mm.plugin.report.d.pPH;
        int i2 = z ? 11 : 14;
        if (z) {
            i = 12;
        } else {
            i = 15;
        }
        dVar.c(463, i2, i, bz, false);
        x.i("MicroMsg.ContactStorage", "insert : username=%s, showHead=%d, verifyFlag=%d, ret=:%d take[%s]ms fg:%b", new Object[]{xVar.field_username, Integer.valueOf(xVar.field_showHead), Integer.valueOf(xVar.field_verifyFlag), Integer.valueOf(insert), Integer.valueOf(bz), Boolean.valueOf(z)});
        if (insert != -1) {
            xVar.gJd = (long) insert;
            O(xVar);
            b(2, this, xVar.field_username);
            return insert;
        }
        x.e("MicroMsg.ContactStorage", "insert failed: username=" + xVar.field_username);
        return -1;
    }

    public final int w(String str, byte[] bArr) {
        int i = -1;
        if (bh.ov(str)) {
            x.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
            return -1;
        }
        y yVar = new y();
        yVar.field_cmdbuf = bArr;
        yVar.field_username = str;
        int replace = (int) this.gJP.replace("ContactCmdBuf", "username", yVar.vI());
        String str2 = "MicroMsg.ContactStorage";
        String str3 = "setCmdbuf user:%s buf:%d result:%d";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        if (bArr != null) {
            i = bArr.length;
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(replace);
        x.d(str2, str3, objArr);
        return replace;
    }

    public final byte[] WS(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
            return null;
        }
        y yVar = new y();
        Cursor a = this.gJP.a("ContactCmdBuf", null, "username=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            yVar.b(a);
        }
        a.close();
        String str2 = "MicroMsg.ContactStorage";
        String str3 = "getCmdbuf user:%s buf:%d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(yVar.field_cmdbuf == null ? -1 : yVar.field_cmdbuf.length);
        x.d(str2, str3, objArr);
        return yVar.field_cmdbuf;
    }

    public final int WT(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.ContactStorage", "delCmdBuf failed user is null");
            return -1;
        }
        x.d("MicroMsg.ContactStorage", "delCmdBuf user:%s ret:%d", new Object[]{str, Integer.valueOf(this.gJP.delete("ContactCmdBuf", "username=?", new String[]{str}))});
        return this.gJP.delete("ContactCmdBuf", "username=?", new String[]{str});
    }

    public final int WU(String str) {
        Assert.assertTrue(str.length() > 0);
        if (x.gy(str)) {
            str = x.WD(str);
        }
        IV(str);
        x xVar = new x(str);
        xVar.setType(0);
        xVar.setUsername("fake_" + bh.Wp());
        xVar.di("fake_" + bh.Wp());
        int update = this.gJP.update(WI(str), xVar.vI(), "username=?", new String[]{str});
        WT(str);
        x.w("MicroMsg.ContactStorage", "delete (because the fucking talker id , dk just mark it  disappear .) user:%s res:%s %s", new Object[]{str, Integer.valueOf(update), bh.cgy()});
        if (update != 0) {
            b(5, this, str);
        }
        return update;
    }

    public final int a(String str, x xVar) {
        x.i("MicroMsg.ContactStorage", "begin to update contact : " + str);
        if (!T(xVar)) {
            return 1;
        }
        int update;
        long currentTimeMillis = System.currentTimeMillis();
        if (x.gy(str)) {
            str = x.WD(str);
        }
        xVar.ex(xVar.Ad());
        this.hod.ca(xVar);
        this.hod.doNotify();
        ContentValues vI = xVar.vI();
        if (((int) xVar.gJd) > 0) {
            vI.put("rowid", Integer.valueOf((int) xVar.gJd));
        }
        if (vI.size() > 0) {
            update = this.gJP.update(WI(str), vI, "username=?", new String[]{str});
        } else {
            update = 0;
        }
        x.i("MicroMsg.ContactStorage", "update : username=%s, showHead=%d, verifyFlag=%d, result1=%d, take[%d]ms", new Object[]{xVar.field_username, Integer.valueOf(xVar.field_showHead), Integer.valueOf(xVar.field_verifyFlag), Integer.valueOf(update), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        IV(str);
        if (!bh.ov(xVar.field_encryptUsername)) {
            IV(xVar.field_encryptUsername);
        }
        if (update == 0) {
            return update;
        }
        b(4, this, str);
        return update;
    }

    public final int b(String str, x xVar) {
        int i = 0;
        if (bh.ov(str) || xVar == null || bh.ov(xVar.field_username)) {
            x.e("MicroMsg.ContactStorage", "update : wrong input!");
            return 0;
        }
        x.d("MicroMsg.ContactStorage", "updateEncryptUser contact: " + xVar.field_username + " enUsername: " + str);
        if (!T(xVar)) {
            return 1;
        }
        if (x.gy(xVar.field_username)) {
            xVar.setUsername(x.WD(xVar.field_username));
        }
        xVar.ex(xVar.Ad());
        this.hod.ca(xVar);
        this.hod.doNotify();
        x.d("MicroMsg.ContactStorage", "update : oldUsername=%s, username=%s, showHead=%d, verifyFlag=%d", new Object[]{str, xVar.field_username, Integer.valueOf(xVar.field_showHead), Integer.valueOf(xVar.field_verifyFlag)});
        ContentValues vI = xVar.vI();
        x xVar2;
        if (xVar.gJd <= 0) {
            xVar2 = new x(str);
            xVar2.setType(0);
            xVar2.setUsername("fake_" + bh.Wp());
            xVar2.di("fake_" + bh.Wp());
            x.d("MicroMsg.ContactStorage", "newContact.contactId <= 0 | delete " + WI(str) + " user :" + str + ", res:" + this.gJP.update(WI(str), xVar2.vI(), "username=?", new String[]{str}));
            if (vI.size() > 0) {
                i = (int) this.gJP.replace(WI(xVar.field_username), com.tencent.mm.l.a.gJc.xjz, vI);
            }
        } else if (!str.equals(xVar.field_username)) {
            xVar2 = new x(str);
            xVar2.setType(0);
            xVar2.setUsername("fake_" + bh.Wp());
            xVar2.di("fake_" + bh.Wp());
            x.d("MicroMsg.ContactStorage", "delete " + WI(str) + " user :" + str + ", res:" + this.gJP.update(WI(str), xVar2.vI(), "username=?", new String[]{str}));
            if (vI.size() > 0) {
                i = this.gJP.update(WI(xVar.field_username), vI, "rowid=?", new String[]{xVar.gJd});
            }
        } else if (vI.size() > 0) {
            x.i("MicroMsg.ContactStorage", "summercontact en equal username[%s], result1[%d], contactId[%d]", new Object[]{xVar.field_username, Integer.valueOf(this.gJP.update(WI(xVar.field_username), vI, "rowid=?", new String[]{xVar.gJd})), Long.valueOf(xVar.gJd)});
            i = r1;
        }
        IV(xVar.field_username);
        if (!bh.ov(xVar.field_encryptUsername)) {
            IV(xVar.field_encryptUsername);
        }
        b(3, this, str);
        b(3, this, xVar.field_username);
        return i;
    }

    public final void c(String str, x xVar) {
        if (str != null) {
            if (x.gy(str)) {
                str = x.WD(str);
            }
            xVar.ex(xVar.Ad());
            if (s.d(xVar)) {
                xVar.ex(43);
                xVar.dd(c.om(xVar.AP()));
                xVar.de(c.ol(xVar.AP()));
                xVar.dg(c.ol(xVar.AQ()));
                xVar.dh(xVar.AQ());
                return;
            }
            if (s.hd(xVar.field_username)) {
                x.i("MicroMsg.ContactStorage", "update official account helper showhead %d", new Object[]{Integer.valueOf(31)});
                xVar.ex(31);
            }
            this.hod.ca(xVar);
            this.hod.doNotify();
            x.d("MicroMsg.ContactStorage", "username=%s, showHead=%d, verifyFlag=%d", new Object[]{xVar.field_username, Integer.valueOf(xVar.field_showHead), Integer.valueOf(xVar.field_verifyFlag)});
            ContentValues vI = xVar.vI();
            if (((int) xVar.gJd) > 0) {
                vI.put("rowid", Integer.valueOf((int) xVar.gJd));
            }
            if (vI.size() > 0) {
                this.gJP.update(WI(str), vI, "username=?", new String[]{str});
            }
        }
    }

    public final Cursor cK(List<String> list) {
        boolean z;
        int i = 0;
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select * ,rowid from rcontact  where ";
        while (i < list.size()) {
            if (i != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i)) + "'";
            }
            i++;
        }
        return this.gJP.rawQuery(str + cis(), null);
    }

    public final Cursor cL(List<String> list) {
        boolean z;
        int i = 0;
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select * ,rowid from rcontact  where (";
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i2)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i2)) + "'";
            }
        }
        str = str + ") order by case username ";
        while (i < list.size()) {
            str = str + " when '" + ((String) list.get(i)) + "' then " + i;
            i++;
        }
        str = str + " end";
        x.d("MicroMsg.ContactStorage", "getCursorByNamesInListOrder sql:" + str);
        return this.gJP.rawQuery(str, null);
    }

    public final List<String> cim() {
        Cursor a = this.gJP.a("select username from rcontact where " + civ(), null, 2);
        List arrayList = new ArrayList();
        if (a != null) {
            if (a.moveToFirst()) {
                do {
                    arrayList.add(a.getString(0));
                } while (a.moveToNext());
            }
            a.close();
        }
        return arrayList;
    }

    public final Cursor cin() {
        return this.gJP.rawQuery("select * ,rowid from rcontact  where " + ("type & " + com.tencent.mm.l.a.Ay() + "=0 and username like '%@chatroom" + "'"), null);
    }

    public final Cursor cio() {
        String str = "select * ,rowid from rcontact " + ciu() + " AND type & 256" + " !=0 " + cis();
        x.v("MicroMsg.ContactStorage", str);
        return this.gJP.rawQuery(str, null);
    }

    public final Cursor cip() {
        String str = "select * ,rowid from rcontact  where " + xyc + " and verifyFlag & " + x.cic() + " !=0 ";
        x.v("MicroMsg.ContactStorage", "dkbf:" + str);
        return this.gJP.rawQuery(str, null);
    }

    public final Cursor ciq() {
        String str = "select * ,rowid from rcontact " + ciu() + " AND " + xyc + " AND " + xyb + cit();
        x.v("MicroMsg.ContactStorage", str);
        return this.gJP.rawQuery(str, null);
    }

    private static String cM(List<String> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : list) {
            stringBuilder.append(" or username = '").append(append).append("'");
        }
        return stringBuilder.toString();
    }

    public final Cursor a(String str, String str2, List<String> list, boolean z, boolean z2) {
        String str3 = "select * ,rowid from rcontact " + d(str, str2, list) + cM(null) + cis();
        x.v("MicroMsg.ContactStorage", str3);
        return this.gJP.rawQuery(str3, null);
    }

    private static String cN(List<String> list) {
        String cM = cM(list);
        int indexOf = cM.indexOf("or");
        if (indexOf <= 2) {
            return cM.substring(indexOf + 2);
        }
        return cM;
    }

    public final Cursor j(List<String> list, boolean z) {
        String str = "select * ,rowid from rcontact  where " + cN(list);
        if (z) {
            str = str + " " + cis();
        }
        x.d("MicroMsg.ContactStorage", "sql " + str);
        return this.gJP.rawQuery(str, null);
    }

    public final Cursor cO(List<String> list) {
        return this.gJP.rawQuery("select * ,rowid from rcontact where (" + xyc + ") and (" + cN(list) + ")" + cit(), null);
    }

    public final Cursor cP(List<String> list) {
        String str = "select * ,rowid from rcontact " + k(list, false) + cit();
        x.v("MicroMsg.ContactStorage", "favourSql " + str);
        return this.gJP.rawQuery(str, null);
    }

    public final Cursor b(String str, String str2, List<String> list) {
        return a(str, str2, (List) list, false, false);
    }

    public final Cursor c(String str, String str2, List<String> list) {
        String str3 = "select * ,rowid from rcontact " + d(str, str2, list) + cis();
        x.v("MicroMsg.ContactStorage", str3);
        return this.gJP.rawQuery(str3, null);
    }

    public final int cir() {
        int i = 0;
        String str = "select count(rowid) from rcontact " + d("@biz.contact", null, null);
        x.v("MicroMsg.ContactStorage", str);
        Cursor a = this.gJP.a(str, null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final List<String> cQ(List<String> list) {
        if (list.isEmpty()) {
            x.w("MicroMsg.ContactStorage", "getFilterList: but white list is empty");
            return new LinkedList();
        }
        long Wq = bh.Wq();
        List<String> linkedList = new LinkedList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("username='").append((String) list.get(0)).append("'");
        for (int i = 1; i < list.size(); i++) {
            stringBuilder.append(" or username='").append((String) list.get(i)).append("'");
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("showHead asc, ");
        stringBuilder2.append("pyInitial asc, ");
        stringBuilder2.append("quanPin asc, ");
        stringBuilder2.append("nickname asc, ");
        stringBuilder2.append("username asc ");
        x.i("MicroMsg.ContactStorage", "getFilterList: sql is %s", new Object[]{String.format("select %s from %s where (%s) and (%s & %d != 0)  order by %s", new Object[]{"username", "rcontact", stringBuilder.toString(), DownloadSettingTable$Columns.TYPE, Integer.valueOf(com.tencent.mm.l.a.Ax()), stringBuilder2.toString()})});
        Cursor a = this.gJP.a(r0, null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                linkedList.add(a.getString(0));
            }
            a.close();
        }
        x.i("MicroMsg.ContactStorage", "getFilerList: use time[%d ms] whiteList[%s], usernameList[%s]", new Object[]{Long.valueOf(bh.bA(Wq)), list, linkedList.toString()});
        return linkedList;
    }

    public final int[] b(String str, String str2, String[] strArr, List<String> list) {
        String str3 = "select distinct showHead from rcontact " + d(str, str2, list) + I(strArr) + cis();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.gJP.rawQuery(str3, null);
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct db.rawQuery last" + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct  cu.getCount() last" + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final int[] b(String str, String str2, String str3, List<String> list) {
        String str4 = "select distinct showHead from rcontact " + d(str, str2, list) + WV(str3) + cis();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.gJP.rawQuery(str4, null);
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final int[] cR(List<String> list) {
        String str = "select distinct showHead from rcontact  where (" + cN(list) + ") " + cis();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.gJP.rawQuery(str, null);
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final int[] c(String str, String str2, String str3, List<String> list) {
        int[] iArr = null;
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.gJP.rawQuery(("select count(*) from rcontact " + d(str, str2, list) + WV(str3)) + " group by showHead", null);
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount();
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        if (count > 0) {
            iArr = new int[count];
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final int[] cS(List<String> list) {
        int[] iArr = null;
        long currentTimeMillis = System.currentTimeMillis();
        Cursor a = this.gJP.a(("select count(*) from rcontact " + "where " + cN(list)) + " group by showHead", null, 2);
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = a.getCount();
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        if (count > 0) {
            iArr = new int[count];
            for (int i = 0; i < count; i++) {
                a.moveToPosition(i);
                iArr[i] = a.getInt(0);
            }
        }
        a.close();
        return iArr;
    }

    public final int[] c(String str, String str2, String[] strArr, List<String> list) {
        int[] iArr = null;
        Cursor rawQuery = this.gJP.rawQuery(("select count(*) from rcontact " + d(str, str2, list) + I(strArr)) + " group by showHead", null);
        if (rawQuery.getCount() > 0) {
            int count = rawQuery.getCount();
            iArr = new int[count];
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final Cursor a(String[] strArr, String str, List<String> list) {
        String str2 = "select * ,rowid from rcontact " + d(str, null, list) + I(strArr);
        if (strArr != null && strArr.length > 0) {
            String str3 = str2 + " order by 1=1 ";
            int length = strArr.length;
            str2 = str3;
            int i = 0;
            while (i < length) {
                i++;
                str2 = str2 + ",username='" + strArr[i] + "' desc";
            }
        }
        x.v("MicroMsg.ContactStorage", "getSearchCursorByArrOrder sql : " + str2);
        return this.gJP.rawQuery(str2, null);
    }

    public final Cursor a(String[] strArr, String str, String str2, List<String> list, List<String> list2) {
        String str3 = "select * ,rowid from rcontact " + d(str, str2, list2) + I(strArr) + q(str2, list) + cis();
        x.i("MicroMsg.ContactStorage", str3);
        return this.gJP.rawQuery(str3, null);
    }

    private static String q(String str, List<String> list) {
        if (str == null || str.equals("")) {
            return "";
        }
        String str2 = " and (";
        if (!(list == null || list.size() == 0)) {
            String str3 = str2;
            for (String str22 : list) {
                str3 = str3 + "username = '" + str22 + "' or ";
            }
            str22 = str3;
        }
        return (((((((str22 + "conRemark like '%" + str + "%' or ") + "conRemarkPYFull like '%" + str + "%' or ") + "conRemarkPYShort like '%" + str + "%' or ") + "alias like '%" + str + "%' or ") + "username like '%" + str + "%' or ") + "nickname like '%" + str + "%' or ") + "pyInitial like '%" + str + "%' or ") + "quanPin like '%" + str + "%' )";
    }

    private static String I(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        String str = " and (";
        int i = 0;
        while (i < strArr.length) {
            if (i > 0) {
                str = str + " or ";
            }
            String str2 = str + "username = '" + strArr[i] + "' ";
            i++;
            str = str2;
        }
        return str + " )";
    }

    public final String WV(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        return (((((((" and (" + "conRemark like '%" + str + "%' or ") + "conRemarkPYFull like '%" + str + "%' or ") + "conRemarkPYShort like '%" + str + "%' or ") + "alias like '%" + str + "%' or ") + "username like '%" + str + "%' or ") + "nickname like '%" + str + "%' or ") + "pyInitial like '%" + str + "%' or ") + "quanPin like '%" + str + "%' )";
    }

    private static String cis() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" order by showHead asc, ");
        stringBuffer.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" upper(quanPin) asc, ");
        stringBuffer.append(" upper(nickname) asc, ");
        stringBuffer.append(" upper(username) asc ");
        return stringBuffer.toString();
    }

    public final String LI() {
        return cis();
    }

    public final String cit() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" order by case when verifyFlag & " + x.cic() + " != 0 then 0 else 1 end , showHead asc, ");
        stringBuffer.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" upper(quanPin) asc, ");
        stringBuffer.append(" upper(nickname) asc, ");
        stringBuffer.append(" upper(username) asc ");
        return stringBuffer.toString();
    }

    private static String P(boolean z, boolean z2) {
        String str = "type & " + com.tencent.mm.l.a.Ax() + "!=0";
        if (z) {
            str = str + " or type & " + com.tencent.mm.l.a.AA() + "!=0";
        }
        str = ((" where (" + str + ")") + " and type & " + com.tencent.mm.l.a.AB() + "=0 ") + " and type & " + com.tencent.mm.l.a.Ay() + " =0 ";
        if (z2) {
            return str;
        }
        return str + " and verifyFlag & " + x.cic() + " =0 ";
    }

    private static String ciu() {
        return (" where (" + ("type & " + com.tencent.mm.l.a.Ax() + "!=0") + ") and ") + "type & " + com.tencent.mm.l.a.AB() + "=0  ";
    }

    private static String civ() {
        return "( (" + ("type & " + com.tencent.mm.l.a.Ax() + "!=0") + ") and type & " + com.tencent.mm.l.a.Ay() + "=0 and username like '%@chatroom" + "')";
    }

    private static String ciw() {
        return "( (" + ("type & " + com.tencent.mm.l.a.Ax() + "!=0") + ") and type & " + com.tencent.mm.l.a.Ay() + "=0 and username like '%@talkroom" + "')";
    }

    public final String k(List<String> list, boolean z) {
        String str = P(false, z) + " AND " + xyc;
        String str2 = "";
        if (list != null && list.size() > 0) {
            String str3 = str2;
            for (String str22 : list) {
                str3 = str3 + " AND username != '" + str22 + "'";
            }
            str22 = str3;
        }
        return str + str22;
    }

    public final String d(String str, String str2, List<String> list) {
        String str3;
        String str4;
        boolean z = true;
        String str5 = "";
        if (str == null || str.equals("@all.android")) {
            str3 = str5 + P(true, false);
        } else if (str.equals("@all.contact.android")) {
            str3 = str5 + ciu();
        } else if (str.equals("@all.chatroom.contact")) {
            str3 = str5 + ((" where (" + ("(type & " + com.tencent.mm.l.a.Ax() + "!=0 and username like '%@chatroom" + "')") + ") and ") + "type & " + com.tencent.mm.l.a.AB() + "=0 ");
        } else if (str.equals("@all.contact.without.chatroom")) {
            r2 = new StringBuilder().append(str5);
            r3 = P(false, false);
            if (r3 == null || r3.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = r2.append(r3 + " and ( username not like '%@%'" + (" or (" + ciw() + ')') + ")").toString();
        } else if (str.equals("@black.android")) {
            str3 = str5 + (" where type & " + com.tencent.mm.l.a.Ay() + "!=0");
        } else if (str.equals("@werun.black.android")) {
            str3 = str5 + (" where type & " + com.tencent.mm.l.a.Az() + "!=0");
        } else if (str.equals("@t.qq.com")) {
            str3 = str5 + (" where username like '%" + "@t.qq.com" + "'");
        } else if (str.equals("@domain.android")) {
            r2 = new StringBuilder().append(str5);
            r3 = P(true, false);
            if (r3 == null || r3.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = r2.append(r3 + " and domainList like '%" + str2 + "%'").toString();
        } else if (str.equals("@micromsg.qq.com")) {
            r2 = new StringBuilder().append(str5);
            r3 = P(false, false);
            if (r3 == null || r3.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str4 = " or (" + civ() + ')';
            str3 = r2.append(r3 + " and ( username not like '%@%'" + str4 + (" or (" + ciw() + ')') + ")").toString();
        } else if (str.equals("@micromsg.no.verify.biz.qq.com")) {
            r2 = new StringBuilder().append(str5);
            r3 = (((" where (" + ("type & " + com.tencent.mm.l.a.Ax() + " !=0 ") + ") and ") + "type & " + com.tencent.mm.l.a.AB() + " =0 and ") + "type & " + com.tencent.mm.l.a.Ay() + " =0 and ") + "verifyFlag & " + x.cic() + " =0";
            if (r3 == null || r3.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = r2.append(r3 + " and ( username not like '%@%'" + (" or (" + civ() + ')') + ")").toString();
        } else if (str.equals("@micromsg.with.all.biz.qq.com")) {
            r2 = new StringBuilder().append(str5);
            r3 = ((" where (" + ("type & " + com.tencent.mm.l.a.Ax() + " !=0 ") + ") and ") + "type & " + com.tencent.mm.l.a.AB() + " =0 and ") + "type & " + com.tencent.mm.l.a.Ay() + " =0";
            if (r3 == null || r3.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = r2.append(r3 + " and ( username not like '%@%'" + (" or (" + civ() + ')') + ")").toString();
        } else if (str.equals("@qqim")) {
            r2 = new StringBuilder().append(str5);
            r3 = "@qqim";
            String P = P(false, false);
            if (P == null || P.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = r2.append(P + " and username like '%" + r3 + "'").toString();
        } else if (str.equals("@all.chatroom")) {
            str3 = str5 + (" where (" + (((("type & " + com.tencent.mm.l.a.Ax() + " !=0") + " or type & 2 !=0") + " or type & 4 !=0") + " or 1") + ") ");
        } else if (str.equals("@verify.contact")) {
            str3 = str5 + (" where (" + (("type & " + com.tencent.mm.l.a.Ax() + " != 0 and ") + "verifyFlag & " + x.cib() + " != 0") + ") ");
        } else if (str.equals("@biz.contact")) {
            str3 = str5 + (" where (" + (("type & " + com.tencent.mm.l.a.Ax() + " != 0 and ") + "verifyFlag & " + x.cic() + " != 0") + ") ");
        } else if (str.equals("@all.weixin.android")) {
            str3 = str5 + (" where (" + ("type & " + com.tencent.mm.l.a.Ax() + " != 0 or  (username not like '%@qqim" + "' and username not like '%@qr" + "' and username not like '%@bottle" + "' and username not like '%@fb" + "' and username not like '%@google" + "' and username not like '%@t.qq.com" + "' and username not like '%@t.sina.com" + "' and username not like '%@t.sina.com" + "')") + ") ");
        } else {
            x.d("MicroMsg.ContactStorage", "unknow role type");
            str3 = str5 + P(false, false);
        }
        str4 = "";
        if (list != null && list.size() > 0) {
            str5 = str4;
            for (String str42 : list) {
                str5 = str5 + " and username != '" + str42 + "'";
            }
            str42 = str5;
        }
        return str3 + str42;
    }

    public final int b(String[] strArr, String... strArr2) {
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select count(username) from rcontact where ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.Ax()).append(" !=0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.AB()).append(" =0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.Ay()).append(" =0 and ");
        stringBuilder.append("verifyFlag & 8").append(" = 0 and ");
        stringBuilder.append("( username not like '%@%')");
        if (strArr != null && strArr.length > 0) {
            for (String append : strArr) {
                stringBuilder.append(" and rcontact.username").append(" != '").append(append).append("'");
            }
        }
        for (i = 0; i < 4; i++) {
            stringBuilder.append(" and rcontact.username").append(" != '").append(strArr2[i]).append("'");
        }
        stringBuilder.append(" or username = 'weixin").append("'");
        Cursor a = this.gJP.a(stringBuilder.toString(), null, 2);
        if (a == null || !a.moveToFirst()) {
            i = 0;
        } else {
            i = a.getInt(0);
            a.close();
        }
        x.d("MicroMsg.ContactStorage", "getNormalContactCount, sql:%s, result:%d", new Object[]{r2, Integer.valueOf(i)});
        return i;
    }

    public final int c(String[] strArr, String... strArr2) {
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select count(username) from rcontact where ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.Ax()).append(" !=0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.AB()).append(" =0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.Ay()).append(" =0 and ");
        stringBuilder.append("verifyFlag & 8").append(" = 0 and ");
        stringBuilder.append("( username like '%@chatroom')");
        if (strArr != null && strArr.length > 0) {
            for (String append : strArr) {
                stringBuilder.append(" and rcontact.username").append(" != '").append(append).append("'");
            }
        }
        for (i = 0; i < 4; i++) {
            stringBuilder.append(" and rcontact.username").append(" != '").append(strArr2[i]).append("'");
        }
        Cursor a = this.gJP.a(stringBuilder.toString(), null, 2);
        if (a == null || !a.moveToFirst()) {
            i = 0;
        } else {
            i = a.getInt(0);
            a.close();
        }
        x.v("MicroMsg.ContactStorage", "getChatroomContactCount, sql:%s, result:%d", new Object[]{r2, Integer.valueOf(i)});
        return i;
    }

    public final Cursor aZs() {
        return this.gJP.rawQuery("select * ,rowid from rcontact  where rowid = -1", null);
    }

    protected final boolean NE() {
        if (this.gJP != null && !this.gJP.cgM()) {
            return true;
        }
        String str = "MicroMsg.ContactStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.gJP == null ? "null" : Boolean.valueOf(this.gJP.cgM());
        x.w(str, str2, objArr);
        return false;
    }

    private static boolean T(x xVar) {
        boolean z = false;
        if (xVar != null) {
            int i = xVar.versionCode;
            if (i > 0) {
                z = true;
            }
            x.d("MicroMsg.ContactStorage", "it need to update contact: " + z + " version code : " + i + " user: " + xVar.field_username);
        }
        return z;
    }

    public final Cursor cix() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff from rcontact  where ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.Ax()).append(" !=0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.AB()).append(" =0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.Ay()).append(" =0 and ");
        stringBuilder.append("verifyFlag & 8").append(" = 0 and ");
        stringBuilder.append("( username not like '%@%')");
        stringBuilder.append(" or username = 'weixin").append("'");
        Cursor a = this.gJP.a(stringBuilder.toString(), null, 2);
        x.i("MicroMsg.ContactStorage", "[oneliang]getNormalContactCursor, sql:%s", new Object[]{r0});
        return a;
    }
}
