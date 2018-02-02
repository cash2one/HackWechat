package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ad extends a {
    public static final int CTRL_BYTE = 242;
    public static final String NAME = "openGameRegion";

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        x.i("MicroMsg.GameJsApiOpenGameRegion", "invoke");
        Context aPh = dVar.aPh();
        aPh.jwN = new MMActivity.a(this) {
            final /* synthetic */ ad mWX;

            public final void b(int i, int i2, Intent intent) {
                if (i != (this.mWX.hashCode() & 65535)) {
                    return;
                }
                d dVar;
                int i3;
                ad adVar;
                if (i2 == -1) {
                    if (intent != null) {
                        String az = bh.az(intent.getStringExtra("gameRegionName"), "");
                        Map hashMap = new HashMap();
                        hashMap.put("gameRegionName", az);
                        dVar.E(i, a.e("get game region:ok", hashMap));
                        return;
                    }
                    dVar = dVar;
                    i3 = i;
                    adVar = this.mWX;
                    dVar.E(i3, a.e("get game region:fail", null));
                } else if (i2 == 1) {
                    dVar = dVar;
                    i3 = i;
                    adVar = this.mWX;
                    dVar.E(i3, a.e("get game region:fail", null));
                } else {
                    dVar = dVar;
                    i3 = i;
                    adVar = this.mWX;
                    dVar.E(i3, a.e("get game region:cancel", null));
                }
            }
        };
        com.tencent.mm.bm.d.a(aPh, "game", ".ui.GameRegionSelectUI", null, hashCode() & 65535, false);
    }
}
