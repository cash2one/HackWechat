package com.tencent.mm.plugin.game.gamewebview.b.a;

import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.game.gamewebview.b.a {
    public static final int CTRL_BYTE = 0;
    public static final String NAME = "onCustomGameMenuClicked";

    public final void k(int i, Bundle bundle) {
        x.i("MicroMsg.GameJsEventCustomGameMenuClicked", "invoke");
        if (bundle != null) {
            int i2 = bundle.getInt("itemId");
            d qF = com.tencent.mm.plugin.game.gamewebview.model.a.qF(i);
            if (qF != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("itemId", i2);
                    qF.cH(getName(), jSONObject.toString());
                } catch (Exception e) {
                    x.e("MicroMsg.GameJsEventCustomGameMenuClicked", "ex : " + e.getMessage());
                }
            }
        }
    }
}
