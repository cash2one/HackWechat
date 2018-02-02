package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import b.c.b.e;
import com.tencent.mm.protocal.c.bal;
import com.tencent.mm.protocal.c.bao;

public final class g {
    public static final g pzC = new g();

    private g() {
    }

    public static String b(bao com_tencent_mm_protocal_c_bao) {
        e.i(com_tencent_mm_protocal_c_bao, "member");
        String str = com_tencent_mm_protocal_c_bao.ksU;
        if (str != null) {
            return str;
        }
        str = com_tencent_mm_protocal_c_bao.wcv;
        return str == null ? "" : str;
    }

    public static String a(bal com_tencent_mm_protocal_c_bal) {
        if (com_tencent_mm_protocal_c_bal != null) {
            String str = com_tencent_mm_protocal_c_bal.wcv;
            if (str == null) {
                str = com_tencent_mm_protocal_c_bal.ksU;
                if (str == null) {
                    str = "";
                }
            }
            if (str != null) {
                return str;
            }
        }
        return "";
    }

    public static String c(bao com_tencent_mm_protocal_c_bao) {
        if (com_tencent_mm_protocal_c_bao != null) {
            String str = com_tencent_mm_protocal_c_bao.wcv;
            if (str == null) {
                str = com_tencent_mm_protocal_c_bao.ksU;
                if (str == null) {
                    str = "";
                }
            }
            if (str != null) {
                return str;
            }
        }
        return "";
    }

    public static boolean do(Context context) {
        e.i(context, "context");
        Object resources = context.getResources();
        e.h(resources, "context.resources");
        return resources.getDisplayMetrics().densityDpi <= 240;
    }
}
