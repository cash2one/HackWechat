package com.tencent.mm.plugin.game.gamewebview.model;

import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.m;
import java.io.InputStream;

public final class g {
    public static m BJ(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.GameWebViewResourceInterrupter", "url is null, return ");
            return null;
        } else if (bh.ov(str) || !str.startsWith("weixin://resourceid/")) {
            return null;
        } else {
            x.i("MicroMsg.GameWebViewResourceInterrupter", "it is wechat resource is, should intercept");
            try {
                m mVar;
                GWMainProcessTask commonLogicTask = new CommonLogicTask();
                commonLogicTask.type = 8;
                commonLogicTask.msB.putString("localId", str);
                GameWebViewMainProcessService.b(commonLogicTask);
                InputStream Ou = ai.Ou(commonLogicTask.msB.getString("file_path"));
                if (Ou != null) {
                    mVar = new m("image/*", ProtocolPackage.ServerEncoding, Ou);
                } else {
                    mVar = null;
                }
                return mVar;
            } catch (Exception e) {
                x.e("MicroMsg.GameWebViewResourceInterrupter", "get webview jssdk resource failed %s", e.getMessage());
                return null;
            }
        }
    }
}
