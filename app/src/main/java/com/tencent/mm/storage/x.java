package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.sdk.platformtools.bh;

public final class x extends a implements Cloneable {
    public CharSequence xmu;
    public String xxQ = null;

    public x(String str) {
        super(str);
    }

    public static boolean Wx(String str) {
        return str != null ? str.endsWith("@t.qq.com") : false;
    }

    public static boolean Wy(String str) {
        return str != null ? str.endsWith("@qr") : false;
    }

    public static boolean Wz(String str) {
        return str != null ? str.endsWith("@qqim") : false;
    }

    public static boolean WA(String str) {
        return str != null ? str.endsWith("@fb") : false;
    }

    public static boolean gy(String str) {
        if (str != null) {
            return str.contains("@bottle:") || str.endsWith("@bottle");
        } else {
            return false;
        }
    }

    public static boolean Dn(int i) {
        return (i & 8) > 0;
    }

    public static boolean fV(String str) {
        return str != null ? str.endsWith("@app") : false;
    }

    public static boolean WB(String str) {
        if (bh.ov(str)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Contact", "Contact invisibleUsername username == null or nil");
            return false;
        }
        String F = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zZ().F("HideWechatID", "idprefix");
        if (F == null) {
            return false;
        }
        String[] split = F.split(";");
        int i = 0;
        while (i < split.length) {
            if (split[i] != null && str.startsWith(split[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static boolean WC(String str) {
        if (bh.ov(str)) {
            return true;
        }
        for (String str2 : "wx_;wxid_;gh_;a0;a1;a2;a3;a4;a5;a6;a7;a8;a9;q0;q1;q2;q3;q4;q5;q6;q7;q8;q9;qq0;qq1;qq2;qq3;qq4;qq5;qq6;qq7;qq8;qq9;f0;f1;f2;f3;f4;f5;f6;f7;f8;f9;F0;F1;F2;F3;F4;F5;F6;F7;F8;F9;".split(";")) {
            if (!bh.ov(str2) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean chZ() {
        return false;
    }

    public static String WD(String str) {
        if (gy(str)) {
            String[] split = str.split(":");
            if (split == null || split.length <= 0) {
                return str;
            }
            return split[0];
        } else if (str == null || !str.contains("@")) {
            return str + "@bottle";
        } else {
            return "";
        }
    }

    public final boolean cia() {
        return (this.field_verifyFlag & 8) > 0;
    }

    public static int cib() {
        return 16;
    }

    public static int cic() {
        return 8;
    }

    public final boolean cid() {
        return ((long) (((int) bh.Wo()) - this.fWw)) > 86400;
    }

    public static String k(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("username"));
    }

    public final void dv(String str) {
        super.dv(str);
        cif();
    }

    public final String getCountryCode() {
        String str = this.fWv;
        if (bh.ov(str)) {
            return "";
        }
        String[] split = str.split("_");
        if (split == null || split.length <= 0) {
            return "";
        }
        return bh.ou(split[0]);
    }

    public final String cie() {
        String str = this.fWv;
        if (bh.ov(str)) {
            return "";
        }
        String[] split = str.split("_");
        if (split == null || split.length < 2) {
            return "";
        }
        return bh.ou(split[1]);
    }

    public final String getCityCode() {
        String str = this.fWv;
        if (bh.ov(str)) {
            return "";
        }
        String[] split = str.split("_");
        if (split == null || split.length < 3) {
            return "";
        }
        return bh.ou(split[2]);
    }

    @Deprecated
    public final void dq(String str) {
        super.dq(str);
    }

    @Deprecated
    public final void dr(String str) {
        super.dr(str);
    }

    public final String getProvince() {
        return super.getProvince();
    }

    public final String getCity() {
        return super.getCity();
    }

    public final void cif() {
        String str = this.fWv;
        if (!bh.ov(str)) {
            String[] split = str.split("_");
            if (split.length <= 0) {
                return;
            }
            if (split.length > 2) {
                if (RegionCodeDecoder.XE(split[0])) {
                    super.dq(RegionCodeDecoder.cjP().fE(split[0], split[1]));
                } else {
                    super.dq(RegionCodeDecoder.cjP().XF(split[0]));
                }
                super.dr(RegionCodeDecoder.cjP().ai(split[0], split[1], split[2]));
            } else if (split.length == 2) {
                super.dq(RegionCodeDecoder.cjP().XF(split[0]));
                super.dr(RegionCodeDecoder.cjP().fE(split[0], split[1]));
            } else {
                super.dq(RegionCodeDecoder.cjP().XF(split[0]));
                super.dr("");
            }
        }
    }

    public final x cig() {
        try {
            return (x) super.clone();
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.Contact", e, "", new Object[0]);
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Contact", "clone Contact error. e: " + e.toString());
            return null;
        }
    }
}
