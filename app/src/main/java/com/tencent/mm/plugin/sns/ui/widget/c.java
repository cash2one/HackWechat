package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;

public final class c {
    public static CharSequence a(Context context, bjk com_tencent_mm_protocal_c_bjk, av avVar, int i, String str) {
        String str2;
        String str3 = "";
        String a = a(com_tencent_mm_protocal_c_bjk);
        CharSequence charSequence = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = i == 21 ? 3 : 2;
        String str4 = com_tencent_mm_protocal_c_bjk.nje;
        x xVar = null;
        if (!bh.ov(str)) {
            g.Dk();
            xVar = ((h) g.h(h.class)).EY().WM(str);
        }
        if (com_tencent_mm_protocal_c_bjk.wMB == 1) {
            if (xVar != null) {
                if (!(xVar == null || TextUtils.isEmpty(xVar.AQ()))) {
                    str = xVar.AQ();
                }
                String str5 = a + context.getString(j.qKi);
                int length = str5.length();
                str2 = str5 + str;
                i3 = length;
            } else {
                com.tencent.mm.sdk.platformtools.x.w("SnsCommentUtil", "feedContact null by feedOwnUserName %s", str);
                str = null;
                str2 = a;
            }
        } else if (bh.ov(com_tencent_mm_protocal_c_bjk.wMQ)) {
            str = null;
            str2 = a;
        } else {
            xVar = ae.bvj().WN(com_tencent_mm_protocal_c_bjk.wMQ);
            str2 = xVar == null ? com_tencent_mm_protocal_c_bjk.wMQ : xVar.AQ();
            String str6 = a + context.getString(j.qLZ);
            i2 = str6.length();
            str = null;
            String str7 = str2;
            str2 = str6 + str2;
            Object obj = str7;
        }
        SpannableString a2 = i.a(context, (str3 + str2 + ": ") + str4, a.fromDPToPix(context, (int) (14.0f * a.eu(context))), 2);
        int i5 = i == 21 ? 3 : 2;
        g.Dk();
        ((h) g.h(h.class)).EY().WM(com_tencent_mm_protocal_c_bjk.vIy);
        Object jVar = new com.tencent.mm.pluginsdk.ui.d.j(a2);
        jVar.a(new n(com_tencent_mm_protocal_c_bjk.vIy, avVar.rzL, i5), a, 0, 33);
        if (str != null) {
            jVar.a(new n(com_tencent_mm_protocal_c_bjk.wMQ, avVar.rzL, i4), str, i3, 33);
        } else if (charSequence != null) {
            jVar.a(new n(com_tencent_mm_protocal_c_bjk.wMQ, avVar.rzL, i4), charSequence, i2, 33);
        }
        return jVar;
    }

    public static String a(bjk com_tencent_mm_protocal_c_bjk) {
        com.tencent.mm.l.a WN = ae.bvj().WN(com_tencent_mm_protocal_c_bjk.vIy);
        if (WN != null) {
            return WN.AQ();
        }
        return com_tencent_mm_protocal_c_bjk.wvW != null ? com_tencent_mm_protocal_c_bjk.wvW : com_tencent_mm_protocal_c_bjk.vIy;
    }
}
