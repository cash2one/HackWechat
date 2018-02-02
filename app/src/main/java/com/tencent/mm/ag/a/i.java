package com.tencent.mm.ag.a;

import com.tencent.mm.ag.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;

public final class i {
    public static void f(int i, String str, String str2) {
        if ("EnterpriseChatStatus".equals(str)) {
            String[] split = str2.split(";");
            String str3 = split[0];
            String str4 = split[1];
            bh.getInt(split[2], 0);
            if (i == 7) {
                al(str4, str3);
            } else if (i == 8) {
                al(str4, str3);
            } else if (i == 9) {
                al(str4, str3);
            }
        }
    }

    private static void al(String str, String str2) {
        long kt = e.kt(str);
        if (kt == -1) {
            x.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", str);
            return;
        }
        int i = y.Mi().aS(kt).field_newUnReadCount;
        y.Mi().aU(kt);
        c ag = y.Mh().ag(kt);
        ae WY = ((h) g.h(h.class)).Fd().WY(str2);
        if (WY == null) {
            x.w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", str2);
        } else if (ag.ho(1)) {
            if (WY.field_unReadMuteCount <= i) {
                WY.eV(0);
                ((h) g.h(h.class)).Fd().a(WY, str2);
                ((a) g.k(a.class)).getNotification().cancelNotification(str2);
                return;
            }
            WY.eV(WY.field_unReadMuteCount - i);
            ((h) g.h(h.class)).Fd().a(WY, str2);
        } else if (WY.field_unReadCount <= i) {
            ((h) g.h(h.class)).Fd().Xa(str2);
            ((a) g.k(a.class)).getNotification().cancelNotification(str2);
        } else {
            WY.eU(0);
            WY.eO(WY.field_unReadCount - i);
            ((h) g.h(h.class)).Fd().a(WY, str2);
        }
    }
}
