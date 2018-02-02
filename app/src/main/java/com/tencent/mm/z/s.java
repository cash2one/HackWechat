package com.tencent.mm.z;

import android.database.Cursor;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.protocal.c.ase;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class s {
    public static final String hfk = d("rconversation.username", new String[]{"@chatroom", "@micromsg.qq.com"});
    public static final String hfl = d("rconversation.username", new String[]{"@t.qq.com"});
    public static final String hfm = d("rconversation.username", new String[]{"@qqim"});
    public static final String hfn = d("rconversation.username", new String[]{"@chatroom_exclusive"});
    public static final String hfo = d("rconversation.username", new String[]{"@micromsg.qq.com"});
    public static final String hfp = d("rconversation.username", new String[]{"@app"});
    public static final String hfq = d("rconversation.username", new String[]{"@chatroom"});
    public static final String[] hfr = new String[]{"qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg"};

    public static boolean gx(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (!str.contains("@") || str.endsWith("@micromsg.qq.com")) {
            return true;
        }
        return false;
    }

    public static boolean eV(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@chatroom");
    }

    public static boolean gy(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@bottle");
    }

    public static boolean gz(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@qqim");
    }

    public static boolean gA(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@lbsroom");
    }

    public static boolean d(x xVar) {
        if (xVar != null && bh.ou(xVar.field_username).endsWith("@chatroom") && a.fZ(xVar.field_type)) {
            return true;
        }
        return false;
    }

    public static boolean gB(String str) {
        return "gh_43f2581f6fd6".equals(str);
    }

    public static boolean gC(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (!str.endsWith("@chatroom")) {
            return false;
        }
        af WO = ((h) g.h(h.class)).EY().WO(str);
        if (WO == null || !a.fZ(WO.field_type)) {
            return false;
        }
        return true;
    }

    public static boolean gD(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@stranger");
    }

    public static List<String> GC() {
        return ((h) g.h(h.class)).EY().cim();
    }

    public static List<x> GD() {
        List<x> arrayList = new ArrayList();
        Cursor cin = ((h) g.h(h.class)).EY().cin();
        if (cin.moveToFirst()) {
            do {
                x xVar = new x();
                xVar.b(cin);
                arrayList.add(xVar);
            } while (cin.moveToNext());
        }
        cin.close();
        return arrayList;
    }

    public static String a(x xVar, String str) {
        if (xVar == null) {
            return str;
        }
        if (str.toLowerCase().endsWith("@chatroom") && bh.ov(xVar.field_nickname)) {
            String gu = ((b) g.h(b.class)).Fh().gu(str);
            if (!bh.ov(gu)) {
                return gu;
            }
        }
        if (xVar.AQ() == null || xVar.AQ().length() <= 0) {
            return str;
        }
        return xVar.AQ();
    }

    public static boolean gE(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return a.fZ(((h) g.h(h.class)).EY().WO(str).field_type);
    }

    public static boolean gF(String str) {
        if (bh.ov(str)) {
            return false;
        }
        af WO = ((h) g.h(h.class)).EY().WO(str);
        if (WO == null) {
            return false;
        }
        return x.Dn(WO.field_verifyFlag);
    }

    public static boolean gM(int i) {
        return x.Dn(i);
    }

    public static void e(x xVar) {
        Assert.assertTrue(xVar != null);
        af WO = ((h) g.h(h.class)).EY().WO(xVar.field_username);
        if (!(WO == null || bh.ov(WO.field_username))) {
            af afVar = WO;
        }
        xVar.Am();
        t(xVar);
    }

    public static void q(String str, boolean z) {
        af WO = ((h) g.h(h.class)).EY().WO(str);
        if (WO != null && !bh.ov(WO.field_username)) {
            if (z) {
                WO.Av();
            } else {
                WO.Aw();
            }
            s(WO);
        }
    }

    public static void f(x xVar) {
        Assert.assertTrue(xVar != null);
        af WO = ((h) g.h(h.class)).EY().WO(xVar.field_username);
        if (!(WO == null || bh.ov(WO.field_username))) {
            af afVar = WO;
        }
        xVar.Ak();
        t(xVar);
    }

    public static void g(x xVar) {
        Assert.assertTrue(xVar != null);
        af WO = ((h) g.h(h.class)).EY().WO(xVar.field_username);
        if (!(WO == null || bh.ov(WO.field_username))) {
            af afVar = WO;
        }
        xVar.Al();
        t(xVar);
    }

    public static void h(x xVar) {
        Assert.assertTrue(xVar != null);
        af WO = ((h) g.h(h.class)).EY().WO(xVar.field_username);
        if (!(WO == null || bh.ov(WO.field_username))) {
            af afVar = WO;
        }
        xVar.Ai();
        t(xVar);
    }

    public static void i(x xVar) {
        Assert.assertTrue(xVar != null);
        x WO = ((h) g.h(h.class)).EY().WO(xVar.field_username);
        if (WO == null || bh.ov(WO.field_username)) {
            WO = xVar;
        }
        WO.Aj();
        t(WO);
        aj WY = ((h) g.h(h.class)).Fd().WY(xVar.field_username);
        if (WY != null && "@blacklist".equals(WY.field_parentRef)) {
            ((h) g.h(h.class)).Fd().d(new String[]{WY.field_username}, "");
        }
    }

    public static void j(x xVar) {
        Assert.assertTrue(xVar != null);
        x WO = ((h) g.h(h.class)).EY().WO(xVar.field_username);
        if (WO == null || bh.ov(WO.field_username)) {
            WO = xVar;
        }
        WO.Av();
        WO.ex(xVar.Ad());
        s(WO);
    }

    public static void k(x xVar) {
        Assert.assertTrue(xVar != null);
        x WO = ((h) g.h(h.class)).EY().WO(xVar.field_username);
        if (WO == null || bh.ov(WO.field_username)) {
            WO = xVar;
        }
        WO.Aw();
        WO.ex(xVar.Ad());
        s(WO);
    }

    public static void l(x xVar) {
        Assert.assertTrue(xVar != null);
        x WO = ((h) g.h(h.class)).EY().WO(xVar.field_username);
        if (WO == null || bh.ov(WO.field_username)) {
            WO = xVar;
        }
        WO.Ar();
        WO.ex(xVar.Ad());
        t(WO);
    }

    public static void m(x xVar) {
        Assert.assertTrue(xVar != null);
        x WO = ((h) g.h(h.class)).EY().WO(xVar.field_username);
        if (WO == null || bh.ov(WO.field_username)) {
            WO = xVar;
        }
        WO.As();
        WO.ex(xVar.Ad());
        t(WO);
    }

    public static void r(String str, boolean z) {
        Assert.assertTrue(!bh.ov(str));
        af WO = ((h) g.h(h.class)).EY().WO(str);
        if (WO != null && !bh.ov(WO.field_username)) {
            WO.setType(WO.field_type | 2048);
            t(WO);
            if (z) {
                ((h) g.h(h.class)).Fd().Xd(str);
            }
        }
    }

    public static void gG(String str) {
        ae WY = ((h) g.h(h.class)).Fd().WY(str);
        Object obj = null;
        if (WY == null) {
            WY = new ae();
            WY.ciy();
            obj = 1;
            WY.setUsername(str);
        }
        WY.aj(System.currentTimeMillis());
        if (obj != null) {
            ((h) g.h(h.class)).Fd().d(WY);
        } else {
            ((h) g.h(h.class)).Fd().a(WY, str);
        }
    }

    public static void s(String str, boolean z) {
        Assert.assertTrue(!bh.ov(str));
        af WO = ((h) g.h(h.class)).EY().WO(str);
        if (WO != null && !bh.ov(WO.field_username)) {
            WO.setType(WO.field_type & -2049);
            t(WO);
            if (z) {
                ((h) g.h(h.class)).Fd().Xe(str);
            }
        }
    }

    public static void n(x xVar) {
        Assert.assertTrue(xVar != null);
        af WO = ((h) g.h(h.class)).EY().WO(xVar.field_username);
        if (!(WO == null || bh.ov(WO.field_username))) {
            af afVar = WO;
        }
        xVar.At();
        t(xVar);
    }

    public static void o(x xVar) {
        Assert.assertTrue(xVar != null);
        af WO = ((h) g.h(h.class)).EY().WO(xVar.field_username);
        if (!(WO == null || bh.ov(WO.field_username))) {
            af afVar = WO;
        }
        xVar.Au();
        t(xVar);
    }

    public static void p(x xVar) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", xVar != null);
        String str = "MicroMsg.ContactStorageLogic: contactId == 0";
        if (((int) xVar.gJd) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        String str2 = "MicroMsg.ContactStorageLogic: username length <= 0";
        if (xVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(str2, z2);
        xVar.Ag();
        ((h) g.h(h.class)).EY().a(xVar.field_username, xVar);
    }

    public static void q(x xVar) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(xVar != null);
        if (((int) xVar.gJd) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (xVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        xVar.Ag();
        ((h) g.h(h.class)).EY().a(xVar.field_username, xVar);
        t(xVar);
    }

    public static void b(x xVar, String str) {
        x WO = ((h) g.h(h.class)).EY().WO(xVar.field_username);
        boolean z = (WO == null || str == null) ? false : true;
        Assert.assertTrue(z);
        WO.da(str);
        t(WO);
    }

    public static void r(x xVar) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(xVar != null);
        if (((int) xVar.gJd) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (xVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        xVar.AN();
        t(xVar);
    }

    private static void s(x xVar) {
        Assert.assertTrue(xVar != null);
        if (((int) xVar.gJd) == 0) {
            ((h) g.h(h.class)).EY().S(xVar);
            ((h) g.h(h.class)).EY().WO(xVar.field_username);
        }
        ((h) g.h(h.class)).EY().a(xVar.field_username, xVar);
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_ase = new ase();
        com_tencent_mm_protocal_c_ase.wzx = xVar.field_username;
        if (xVar.AK()) {
            com_tencent_mm_protocal_c_ase.wzJ = 1;
        } else {
            com_tencent_mm_protocal_c_ase.wzJ = 2;
        }
        ((h) g.h(h.class)).EX().b(new e.a(52, com_tencent_mm_protocal_c_ase));
    }

    public static void t(x xVar) {
        Assert.assertTrue(xVar != null);
        if (((int) xVar.gJd) == 0) {
            ((h) g.h(h.class)).EY().S(xVar);
            ((h) g.h(h.class)).EY().WO(xVar.field_username);
        }
        ((h) g.h(h.class)).EY().a(xVar.field_username, xVar);
        u(xVar);
    }

    public static void u(x xVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", xVar.field_username, xVar.field_conRemark, Integer.valueOf(xVar.field_type));
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_arp = new arp();
        com_tencent_mm_protocal_c_arp.vYI = new bdo().UA(bh.ou(xVar.field_username));
        com_tencent_mm_protocal_c_arp.wsB = new bdo().UA(bh.ou(xVar.field_nickname));
        com_tencent_mm_protocal_c_arp.vYw = new bdo().UA(bh.ou(xVar.vQ()));
        com_tencent_mm_protocal_c_arp.vYx = new bdo().UA(bh.ou(xVar.vR()));
        com_tencent_mm_protocal_c_arp.hvt = xVar.fWf;
        com_tencent_mm_protocal_c_arp.vXM = 561023;
        com_tencent_mm_protocal_c_arp.vXN = xVar.field_type;
        com_tencent_mm_protocal_c_arp.wyH = new bdo().UA(bh.ou(xVar.field_conRemark));
        com_tencent_mm_protocal_c_arp.wyI = new bdo().UA(bh.ou(xVar.field_conRemarkPYShort));
        com_tencent_mm_protocal_c_arp.wyJ = new bdo().UA(bh.ou(xVar.field_conRemarkPYFull));
        com_tencent_mm_protocal_c_arp.vXS = xVar.fWk;
        com_tencent_mm_protocal_c_arp.wzc = new bdo().UA(bh.ou(xVar.field_domainList));
        com_tencent_mm_protocal_c_arp.vXW = xVar.fWn;
        com_tencent_mm_protocal_c_arp.hvx = xVar.fWo;
        com_tencent_mm_protocal_c_arp.hvw = bh.ou(xVar.signature);
        com_tencent_mm_protocal_c_arp.hvv = bh.ou(xVar.getCityCode());
        com_tencent_mm_protocal_c_arp.hvu = bh.ou(xVar.cie());
        com_tencent_mm_protocal_c_arp.wvh = bh.ou(xVar.fWt);
        com_tencent_mm_protocal_c_arp.wvj = xVar.field_weiboFlag;
        com_tencent_mm_protocal_c_arp.wyY = 0;
        com_tencent_mm_protocal_c_arp.vHb = new bdn();
        com_tencent_mm_protocal_c_arp.hvC = bh.ou(xVar.getCountryCode());
        ((h) g.h(h.class)).EX().b(new e.a(2, com_tencent_mm_protocal_c_arp));
    }

    public static void gH(String str) {
        if (!bh.ov(str)) {
            x WO = ((h) g.h(h.class)).EY().WO(str);
            if (WO != null) {
                WO.Ae();
                ((h) g.h(h.class)).EY().a(str, WO);
            }
        }
    }

    public static int[] b(String str, String str2, List<String> list, String str3) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((h) g.h(h.class)).EY().b(str, str2, str3, (List) list);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            return null;
        }
        currentTimeMillis = System.currentTimeMillis();
        int[] c = ((h) g.h(h.class)).EY().c(str, str2, str3, (List) list);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (c == null) {
            return null;
        }
        Assert.assertTrue(b.length == c.length);
        int[] iArr = new int[c.length];
        int i2 = 0;
        int i3 = 0;
        while (i < b.length) {
            int i4 = i3 + 1;
            iArr[i3] = i2;
            i2 += c[i];
            i++;
            i3 = i4;
        }
        return iArr;
    }

    public static int[] C(List<String> list) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] cR = ((h) g.h(h.class)).EY().cR(list);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - currentTimeMillis));
        if (cR.length <= 0) {
            return null;
        }
        currentTimeMillis = System.currentTimeMillis();
        int[] cS = ((h) g.h(h.class)).EY().cS(list);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (cS == null) {
            return null;
        }
        Assert.assertTrue(cR.length == cS.length);
        int[] iArr = new int[cS.length];
        int i2 = 0;
        int i3 = 0;
        while (i < cR.length) {
            int i4 = i3 + 1;
            iArr[i3] = i2;
            i2 += cS[i];
            i++;
            i3 = i4;
        }
        return iArr;
    }

    public static int[] a(String str, String str2, List<String> list, String[] strArr) {
        int i = 0;
        int[] b = ((h) g.h(h.class)).EY().b(str, str2, strArr, (List) list);
        if (b.length <= 0) {
            return null;
        }
        int[] c = ((h) g.h(h.class)).EY().c(str, str2, strArr, (List) list);
        if (c == null) {
            return null;
        }
        Assert.assertTrue(b.length == c.length);
        int[] iArr = new int[c.length];
        int i2 = 0;
        int i3 = 0;
        while (i < b.length) {
            int i4 = i3 + 1;
            iArr[i3] = i2;
            i2 += c[i];
            i++;
            i3 = i4;
        }
        return iArr;
    }

    public static String[] a(String str, String str2, String[] strArr, List<String> list) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((h) g.h(h.class)).EY().b(str, str2, strArr, (List) list);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            return null;
        }
        String[] strArr2 = new String[b.length];
        int i2 = 0;
        while (i < b.length) {
            int i3;
            char c = (char) b[i];
            if (c == '{') {
                i3 = i2 + 1;
                strArr2[i2] = "#";
            } else if (c == ' ') {
                i3 = i2 + 1;
                strArr2[i2] = "$";
            } else {
                i3 = i2 + 1;
                strArr2[i2] = String.valueOf(c);
            }
            i++;
            i2 = i3;
        }
        return strArr2;
    }

    public static String[] a(String str, String str2, String str3, List<String> list) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((h) g.h(h.class)).EY().b(str, str2, str3, (List) list);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            return null;
        }
        String[] strArr = new String[b.length];
        int i2 = 0;
        while (i < b.length) {
            int i3;
            char c = (char) b[i];
            if (c == '{') {
                i3 = i2 + 1;
                strArr[i2] = "#";
            } else if (c == ' ') {
                i3 = i2 + 1;
                strArr[i2] = "$";
            } else {
                i3 = i2 + 1;
                strArr[i2] = String.valueOf(c);
            }
            i++;
            i2 = i3;
        }
        return strArr;
    }

    public static String[] D(List<String> list) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] cR = ((h) g.h(h.class)).EY().cR(list);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (cR.length <= 0) {
            return null;
        }
        String[] strArr = new String[cR.length];
        for (int i2 : cR) {
            int i22;
            char c = (char) i22;
            if (c == '{') {
                i22 = i + 1;
                strArr[i] = "#";
                i = i22;
            } else if (c == ' ') {
                i22 = i + 1;
                strArr[i] = "$";
                i = i22;
            } else {
                i22 = i + 1;
                strArr[i] = String.valueOf(c);
                i = i22;
            }
        }
        return strArr;
    }

    public static boolean gI(String str) {
        return str != null ? str.equalsIgnoreCase("qqmail") : false;
    }

    public static boolean gJ(String str) {
        return str != null ? str.equalsIgnoreCase("fmessage") : false;
    }

    public static boolean gK(String str) {
        return str != null ? str.equalsIgnoreCase("tmessage") : false;
    }

    public static boolean gL(String str) {
        return str != null ? str.equalsIgnoreCase("floatbottle") : false;
    }

    public static boolean gM(String str) {
        return str != null ? str.equalsIgnoreCase("qmessage") : false;
    }

    public static boolean gN(String str) {
        return str != null ? str.equalsIgnoreCase("facebookapp") : false;
    }

    public static boolean gO(String str) {
        return str != null ? str.equalsIgnoreCase("masssendapp") : false;
    }

    public static boolean GE() {
        return false;
    }

    public static boolean gP(String str) {
        return str != null ? str.equalsIgnoreCase("feedsapp") : false;
    }

    public static boolean gQ(String str) {
        return "qqsync".equalsIgnoreCase(str);
    }

    public static boolean gR(String str) {
        if (str != null) {
            return str.equalsIgnoreCase("weixin") || str.equalsIgnoreCase("gh_9639b5a92773");
        } else {
            return false;
        }
    }

    public static boolean gS(String str) {
        return str != null ? str.equalsIgnoreCase("lbsapp") : false;
    }

    public static boolean gT(String str) {
        return str != null ? str.equalsIgnoreCase("shakeapp") : false;
    }

    public static boolean gU(String str) {
        return str != null ? str.equalsIgnoreCase("medianote") : false;
    }

    public static boolean gV(String str) {
        return str != null ? str.equalsIgnoreCase("newsapp") : false;
    }

    public static boolean gW(String str) {
        return str != null ? str.equalsIgnoreCase("voipapp") : false;
    }

    public static boolean gX(String str) {
        return str != null ? str.equalsIgnoreCase("voicevoipapp") : false;
    }

    public static boolean gY(String str) {
        return str != null ? str.equalsIgnoreCase("voiceinputapp") : false;
    }

    public static boolean gZ(String str) {
        return str != null ? str.equalsIgnoreCase("linkedinplugin") : false;
    }

    public static boolean ha(String str) {
        return hb(str);
    }

    public static boolean hb(String str) {
        return str != null ? str.equalsIgnoreCase("gh_22b87fa7cb3c") : false;
    }

    public static boolean hc(String str) {
        return str != null ? str.equalsIgnoreCase("blogapp") : false;
    }

    public static boolean hd(String str) {
        return str != null ? str.equalsIgnoreCase("officialaccounts") : false;
    }

    public static boolean he(String str) {
        return str != null ? str.equalsIgnoreCase("helper_entry") : false;
    }

    public static boolean hf(String str) {
        return str != null ? str.equalsIgnoreCase("qqfriend") : false;
    }

    public static boolean hg(String str) {
        return "filehelper".equalsIgnoreCase(str);
    }

    public static boolean hh(String str) {
        return str != null ? str.equalsIgnoreCase("pc_share") : false;
    }

    public static boolean hi(String str) {
        return str != null ? str.equalsIgnoreCase("notifymessage") : false;
    }

    public static boolean hj(String str) {
        return str != null ? str.equalsIgnoreCase("notification_messages") : false;
    }

    public static boolean hk(String str) {
        if (hl(str) || hn(str) || hd(str) || he(str)) {
            return true;
        }
        return false;
    }

    public static boolean hl(String str) {
        g.Dk();
        String str2 = (String) g.Dj().CU().get(21, null);
        if ((str2 == null || !str2.equalsIgnoreCase(str)) && !str.equalsIgnoreCase("weixin")) {
            return false;
        }
        return true;
    }

    public static boolean hm(String str) {
        return str != null ? str.equalsIgnoreCase("appbrandcustomerservicemsg") : false;
    }

    public static boolean hn(String str) {
        for (String equalsIgnoreCase : hfr) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ho(String str) {
        if (hn(str) || x.Wz(str) || x.Wx(str) || x.gy(str)) {
            return true;
        }
        return false;
    }

    public static int hp(String str) {
        Assert.assertTrue(bh.ou(str).length() > 0);
        String toLowerCase = str.trim().toLowerCase();
        if (toLowerCase.endsWith("@chatroom")) {
            return 1;
        }
        if (x.Wx(toLowerCase)) {
            return 11;
        }
        if (x.Wz(toLowerCase)) {
            return 36;
        }
        return x.gy(toLowerCase) ? 1 : 1;
    }

    public static int hq(String str) {
        Assert.assertTrue(bh.ou(str).length() > 0);
        String toLowerCase = str.trim().toLowerCase();
        if (toLowerCase.endsWith("@chatroom")) {
            return 3;
        }
        if (x.Wx(toLowerCase)) {
            return 13;
        }
        if (x.Wz(toLowerCase)) {
            return 39;
        }
        if (x.gy(toLowerCase)) {
            return 3;
        }
        if (toLowerCase.contains("@")) {
            return 3;
        }
        return 3;
    }

    public static boolean hr(String str) {
        if (((h) g.h(h.class)).EY().WO(str).fWn != 1) {
            return false;
        }
        return true;
    }

    public static boolean hs(String str) {
        x WO = ((h) g.h(h.class)).EY().WO(str);
        if (WO == null || !WO.AI()) {
            return false;
        }
        return true;
    }

    public static boolean ht(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (str.startsWith("t.qq.com/") || str.startsWith("http://t.qq.com/")) {
            return true;
        }
        return false;
    }

    public static String hu(String str) {
        if (ht(str)) {
            return str.replace("http://t.qq.com/", "").replace("t.qq.com/", "");
        }
        return "";
    }

    public static boolean v(x xVar) {
        return (xVar.field_weiboFlag & 1) != 0;
    }

    public static boolean GF() {
        if (!q.Gz()) {
            return false;
        }
        bc EY = ((h) g.h(h.class)).Fg().EY("@t.qq.com");
        if (EY == null || bh.ov(EY.name)) {
            return false;
        }
        return true;
    }

    public static boolean GG() {
        if (!q.Gz()) {
            return false;
        }
        bc EY = ((h) g.h(h.class)).Fg().EY("@t.qq.com");
        if (EY == null || bh.ou(EY.name).length() == 0) {
            return false;
        }
        return true;
    }

    public static List<x> GH() {
        List<x> linkedList = new LinkedList();
        Cursor ciq = ((h) g.h(h.class)).EY().ciq();
        if (ciq.getCount() == 0) {
            ciq.close();
            return linkedList;
        }
        ciq.moveToFirst();
        do {
            x xVar = new x();
            xVar.b(ciq);
            linkedList.add(xVar);
        } while (ciq.moveToNext());
        ciq.close();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + linkedList.size());
        return linkedList;
    }

    public static List<String> GI() {
        List<String> linkedList = new LinkedList();
        Cursor cio = ((h) g.h(h.class)).EY().cio();
        if (cio.getCount() == 0) {
            cio.close();
            return linkedList;
        }
        cio.moveToFirst();
        do {
            af xVar = new x();
            xVar.b(cio);
            linkedList.add(xVar.field_username);
        } while (cio.moveToNext());
        cio.close();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + linkedList.size());
        return linkedList;
    }

    public static boolean a(ae aeVar) {
        String str = aeVar.field_username;
        if (hn(str) || hl(str) || hd(str) || he(str) || aeVar.field_conversationTime == -1) {
            return false;
        }
        if (gF(str)) {
            return true;
        }
        return true;
    }

    public static boolean b(ae aeVar) {
        String str = aeVar.field_username;
        if (hd(str) || hm(str)) {
            return false;
        }
        return true;
    }

    public static int GJ() {
        return ((h) g.h(h.class)).EY().b(hfr, q.FS(), "weixin", "helper_entry", "filehelper");
    }

    private static String d(String str, String[] strArr) {
        String str2 = " and ( 1 != 1 ";
        for (Object obj : strArr) {
            if ("@all.android".equals(obj)) {
                str2 = str2 + " or 1 = 1";
            } else if ("@micromsg.qq.com".equals(obj)) {
                str2 = str2 + " or " + str + " not like '%@%'";
            } else if ("@chatroom".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@chatroom'";
            } else if ("@talkroom".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@talkroom'";
            } else if ("@t.qq.com".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@t.qq.com'";
            } else if ("@qqim".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@qqim'";
            } else if ("@chatroom_exclusive".equals(obj)) {
                str2 = str2 + " or " + str + "not like %@chatroom";
            } else if ("@app".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@app'";
            }
        }
        return str2 + " ) ";
    }
}
