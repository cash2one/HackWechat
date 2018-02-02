package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.ui.chatting.e.c;
import com.tencent.mm.ui.u;

final class e$a implements c {
    e$a() {
    }

    public final boolean a(String str, Context context, u uVar, String str2) {
        if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendnormalhbrequest")) {
            Intent intent = new Intent();
            intent.putExtra("key_type", 0);
            d.b(context, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
            return true;
        } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendrandomhbrequest")) {
            r1 = new Intent();
            r1.putExtra("key_type", 1);
            d.b(context, "luckymoney", ".ui.LuckyMoneyPrepareUI", r1);
            return true;
        } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendhblistrequest")) {
            r1 = new Intent();
            r1.putExtra("key_type", 1);
            d.b(context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", r1);
            return true;
        } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startreceivehblistrequest")) {
            r1 = new Intent();
            r1.putExtra("key_type", 2);
            d.b(context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", r1);
            return true;
        } else if (str.startsWith("weixin://openNativeUrl/weixinHB/openDetail")) {
            r1 = new Intent();
            r1.putExtra("key_native_url", str);
            d.b(context, "luckymoney", ".ui.LuckyMoneyDetailUI", r1);
            return true;
        } else if (!str.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
            return false;
        } else {
            r1 = new Intent();
            r1.putExtra("key_way", 5);
            r1.putExtra("key_native_url", str);
            r1.putExtra("key_static_from_scene", 1);
            d.b(context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", r1);
            return true;
        }
    }
}
