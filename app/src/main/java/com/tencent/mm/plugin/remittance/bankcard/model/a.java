package com.tencent.mm.plugin.remittance.bankcard.model;

import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigDecimal;

public final class a {
    public static long dM(String str, String str2) {
        try {
            return new BigDecimal(bh.getDouble(str.trim(), 0.0d) == 0.0d ? "0" : str.trim()).divide(new BigDecimal(str2.trim()), 0, 4).longValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BankRemitUtil", e, "", new Object[0]);
            return 0;
        }
    }

    public static double dN(String str, String str2) {
        try {
            return new BigDecimal(bh.getDouble(str.trim(), 0.0d) == 0.0d ? "0" : str.trim()).divide(new BigDecimal(str2.trim()), 2, 4).doubleValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BankRemitUtil", e, "", new Object[0]);
            return 0.0d;
        }
    }

    public static double dO(String str, String str2) {
        double d = 0.0d;
        try {
            double d2 = bh.getDouble(str, 0.0d);
            double d3 = bh.getDouble(str2, 0.0d);
            if (d2 == 0.0d) {
                str = "0";
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            if (d3 == 0.0d) {
                str2 = "0";
            }
            d = bigDecimal.multiply(new BigDecimal(str2)).doubleValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BankRemitUtil", e, "", new Object[0]);
        }
        return d;
    }

    public static double vu(int i) {
        return dN(String.valueOf(i), "100");
    }

    public static char In(String str) {
        String g = SpellMap.g(str.charAt(0));
        x.d("MicroMsg.BankRemitUtil", "pinyin: %s", new Object[]{g});
        if (bh.ov(g)) {
            return '#';
        }
        return g.toUpperCase().charAt(0);
    }
}
