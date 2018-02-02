package com.tencent.mm.z;

import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.messenger.b$a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class r {
    private static Set<String> hfj = new HashSet();

    public static String gs(String str) {
        af WO = ((h) g.h(h.class)).EY().WO(str);
        if (WO == null || bh.ov(WO.field_nickname)) {
            return str;
        }
        return WO.field_nickname;
    }

    public static String L(String str, String str2) {
        if (bh.ov(str2)) {
            return gu(str);
        }
        String gv = gv(str);
        if (!bh.ov(gv)) {
            return gv;
        }
        gv = m.K(str, str2);
        if (bh.ov(gv)) {
            return gu(str);
        }
        return gv;
    }

    public static String gt(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        af WO = ((h) g.h(h.class)).EY().WO(str);
        x.d("MicroMsg.ContactCommDisplay", "username: %s", new Object[]{str});
        if (WO == null) {
            return str;
        }
        if (str.toLowerCase().endsWith("@chatroom") && bh.ov(WO.field_nickname)) {
            String gu = ((b) g.h(b.class)).Fh().gu(str);
            if (!bh.ov(gu)) {
                return gu;
            }
        }
        if (WO.AP() == null || WO.AP().length() <= 0) {
            return str;
        }
        return WO.AP();
    }

    public static String gu(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        return s.a(((h) g.h(h.class)).EY().WO(str), str);
    }

    public static String a(com.tencent.mm.storage.x xVar, String str) {
        return s.a(xVar, str);
    }

    public static String a(com.tencent.mm.storage.x xVar, String str, boolean z) {
        if (xVar == null) {
            return str;
        }
        if (z && bh.ov(xVar.field_nickname)) {
            return ((b) g.h(b.class)).Fh().gu(str);
        }
        if (xVar.AQ() != null && xVar.AQ().length() > 0) {
            return xVar.AQ();
        }
        if (bh.ov(xVar.field_nickname) && s.hm(str)) {
            return a.fa(str);
        }
        return str;
    }

    public static String c(com.tencent.mm.storage.x xVar) {
        String gu = gu(xVar.field_username);
        if (!s.eV(xVar.field_username) || !gu.equals(xVar.field_username)) {
            return gu;
        }
        List<String> hH = ((b) g.h(b.class)).Fh().hH(xVar.field_username);
        if (hH == null || hH.size() <= 0) {
            return ac.getResources().getString(b$a.dCN);
        }
        List arrayList = new ArrayList();
        for (String gu2 : hH) {
            arrayList.add(gu(gu2));
        }
        return "(" + bh.d(arrayList, ", ") + ")";
    }

    public static String gv(String str) {
        af WO = ((h) g.h(h.class)).EY().WO(str);
        if (WO == null) {
            return "";
        }
        if (bh.ov(WO.field_conRemark)) {
            return "";
        }
        return WO.field_conRemark;
    }

    public static void b(Set<String> set) {
        hfj = set;
    }

    public static String gw(String str) {
        if (hfj.contains(str)) {
            return "";
        }
        return str;
    }
}
