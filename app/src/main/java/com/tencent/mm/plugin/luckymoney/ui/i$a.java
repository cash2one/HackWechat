package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import com.tencent.mm.plugin.luckymoney.ui.i.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;

final class i$a implements b {
    final /* synthetic */ i okg;

    i$a(i iVar) {
        this.okg = iVar;
    }

    public final void a(i$c com_tencent_mm_plugin_luckymoney_ui_i_c, Context context) {
        int color = context.getResources().getColor(c.uaP);
        int color2 = context.getResources().getColor(c.uaQ);
        int color3 = context.getResources().getColor(c.uaV);
        com_tencent_mm_plugin_luckymoney_ui_i_c.ltB.setBackgroundResource(c.transparent);
        com_tencent_mm_plugin_luckymoney_ui_i_c.ltB.setPadding(0, context.getResources().getDimensionPixelOffset(d.bvB), 0, context.getResources().getDimensionPixelOffset(d.bvB));
        com_tencent_mm_plugin_luckymoney_ui_i_c.nqD.setTextColor(color);
        com_tencent_mm_plugin_luckymoney_ui_i_c.oid.setTextColor(color2);
        com_tencent_mm_plugin_luckymoney_ui_i_c.ogw.setTextColor(color);
        com_tencent_mm_plugin_luckymoney_ui_i_c.okh.setTextColor(color);
        com_tencent_mm_plugin_luckymoney_ui_i_c.oki.setTextColor(color3);
    }
}
