package com.tencent.mm.plugin.wallet_ecard.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.axk;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class b {
    public static boolean a(WalletBaseUI walletBaseUI, axk com_tencent_mm_protocal_c_axk) {
        if (com_tencent_mm_protocal_c_axk == null) {
            x.i("MicroMsg.ECardUtil", "no popItem");
            return false;
        } else if (bh.ov(com_tencent_mm_protocal_c_axk.wEC)) {
            return false;
        } else {
            if (!bh.ov(com_tencent_mm_protocal_c_axk.sEp) && !bh.ov(com_tencent_mm_protocal_c_axk.wED)) {
                x.i("MicroMsg.ECardUtil", "show guide info 1");
                h.a(walletBaseUI, com_tencent_mm_protocal_c_axk.wEC, "", com_tencent_mm_protocal_c_axk.sEp, com_tencent_mm_protocal_c_axk.wED, false, new 1(com_tencent_mm_protocal_c_axk, walletBaseUI, null), new 2(com_tencent_mm_protocal_c_axk, walletBaseUI));
                return true;
            } else if (bh.ov(com_tencent_mm_protocal_c_axk.wED)) {
                return false;
            } else {
                x.i("MicroMsg.ECardUtil", "show guide info 2");
                h.a(walletBaseUI, com_tencent_mm_protocal_c_axk.wEC, "", com_tencent_mm_protocal_c_axk.wED, false, new 3(com_tencent_mm_protocal_c_axk, walletBaseUI));
                return true;
            }
        }
    }

    public static String d(Context context, String... strArr) {
        String string = context.getString(i.uXa);
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (!bh.ov(str)) {
                    return str;
                }
            }
        }
        return string;
    }

    public static boolean a(WalletBaseUI walletBaseUI, k kVar, int i, String str, int i2, String str2) {
        if (i2 != 0) {
            i = i2;
            str = str2;
        }
        x.i("MicroMsg.ECardUtil", "finalRetCode: %s, finalRetMsg: %s", new Object[]{Integer.valueOf(i), str});
        return f.a(walletBaseUI, kVar, 1000, i, str);
    }

    public static void a(int i, String str, String str2, String str3, Context context, a aVar) {
        x.i("MicroMsg.ECardUtil", "start open ecard process, scene: %s, token==null%s, eCardType: %s, extraData: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(bh.ov(str)), str2, str3});
        Bundle bundle = new Bundle();
        bundle.putInt(a.sYX, i);
        bundle.putString(a.sYY, str);
        bundle.putString(a.sZc, str2);
        bundle.putString(a.sZd, str3);
        com.tencent.mm.wallet_core.a.a((Activity) context, com.tencent.mm.plugin.wallet_ecard.b.a.class, bundle, aVar);
    }
}
