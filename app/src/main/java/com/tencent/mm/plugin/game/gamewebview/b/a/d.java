package com.tencent.mm.plugin.game.gamewebview.b.a;

import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_BYTE = 0;
    public static final String NAME = "onNetWorkChange";

    public final void k(int i, Bundle bundle) {
        x.i("MicroMsg.GameJsEventNetworkChange", "dispatch");
        if (bundle != null) {
            String string = bundle.getString(DownloadInfo.NETTYPE, "");
            com.tencent.mm.plugin.game.gamewebview.ui.d qF = com.tencent.mm.plugin.game.gamewebview.model.a.qF(i);
            if (qF != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(DownloadInfo.NETTYPE, string);
                    qF.cH(getName(), jSONObject.toString());
                } catch (Exception e) {
                    x.e("MicroMsg.GameJsEventNetworkChange", "ex : " + e.getMessage());
                }
            }
        }
    }
}
