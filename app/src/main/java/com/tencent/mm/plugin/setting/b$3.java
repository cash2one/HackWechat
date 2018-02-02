package com.tencent.mm.plugin.setting;

import android.content.Intent;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.e.g;
import java.util.Map;

class b$3 implements m {
    final /* synthetic */ b qfX;

    b$3(b bVar) {
        this.qfX = bVar;
    }

    public final void b(String str, Map<String, String> map, a aVar) {
        if (map != null) {
            String str2 = (String) map.get(".sysmsg.showtrustedfriends.wording");
            if (!bh.ov(str2)) {
                Intent intent = new Intent();
                intent.putExtra(g.xEo, str2);
                d.b(ac.getContext(), "setting", ".ui.setting.SettingsTrustFriendUI", intent);
            }
        }
    }
}
