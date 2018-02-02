package com.tencent.mm.bk;

import android.content.Context;
import com.tencent.mm.bf.l;
import com.tencent.mm.bm.d;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.platformtools.bh;

public final class a {
    public static boolean bXU() {
        Object value = g.zY().getValue("EnableStrangerChat");
        String str = "1";
        if (bh.ov(value)) {
            value = "0";
        }
        return str.equals(value);
    }

    public static void dV(Context context) {
        if (bXU() || l.Ty().Tq() <= 0) {
            d.y(context, "nearby", ".ui.NearbyFriendsUI");
        } else {
            d.y(context, "nearby", ".ui.NearbyFriendShowSayHiUI");
        }
    }
}
