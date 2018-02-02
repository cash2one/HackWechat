package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnHoverListener;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public final class p {
    public static b ysz = new b();

    static /* synthetic */ void p(Context context, String str, int i) {
        b spVar = new sp();
        spVar.fKq.fuL = 5;
        spVar.fKq.talker = str;
        spVar.fKq.context = context;
        spVar.fKq.fKl = i;
        a.xef.m(spVar);
        g.pQN.h(11033, new Object[]{Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0)});
    }

    public static void dn(View view) {
        ad.b bVar = ysz;
        if (view == null || bVar == null) {
            x.w("MicroMsg.OnHoverCompatibleHelper", "view or callback is null.");
        } else if (VERSION.SDK_INT >= 14) {
            ad ctb = ad.ctb();
            if (VERSION.SDK_INT >= 14 && ctb.yxm == null) {
                ctb.yxm = new ad.a(bVar);
            }
            Object obj = ctb.yxm;
            if (obj != null && VERSION.SDK_INT >= 14 && (obj instanceof OnHoverListener)) {
                view.setOnHoverListener((OnHoverListener) obj);
            }
        }
    }

    public static void dismiss() {
        try {
            if (ysz != null) {
                b.a(ysz);
            }
        } catch (Exception e) {
            x.e("MicroMsg.ChattingItemAvatarOnHoverHelper", "exception in dismiss, %s", new Object[]{e.getMessage()});
        }
    }
}
