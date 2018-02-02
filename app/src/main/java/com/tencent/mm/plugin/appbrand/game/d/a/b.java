package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;

final class b extends f {
    static final int CTRL_INDEX = -2;
    static final String NAME = "onKeyboardConfirm";

    b() {
    }

    final void a(String str, j jVar) {
        Map hashMap = new HashMap(2);
        hashMap.put("errMsg", "ok");
        hashMap.put(DownloadSettingTable$Columns.VALUE, str);
        v(hashMap).a(jVar).afs();
    }
}
