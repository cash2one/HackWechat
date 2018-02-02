package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class GameJsApiOperateGameCenterMsg extends a {
    public static final int CTRL_BYTE = 174;
    public static final String NAME = "operateGameCenterMsg";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        String str = null;
        x.i("MicroMsg.GameJsApiOperateGameCenterMsg", "invoke");
        if (jSONObject == null) {
            x.i("MicroMsg.GameJsApiOperateGameCenterMsg", "data is null");
            dVar.E(i, a.e("getGameMessages:fail_invalid_data", null));
            return;
        }
        int optInt = jSONObject.optInt("cmd");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        GWMainProcessTask operateGameCenterMsgTask = new OperateGameCenterMsgTask();
        operateGameCenterMsgTask.pK = optInt;
        if (optJSONObject != null) {
            str = optJSONObject.toString();
        }
        operateGameCenterMsgTask.fwF = str;
        operateGameCenterMsgTask.jcI = new 1(this, operateGameCenterMsgTask, dVar, i);
        operateGameCenterMsgTask.afi();
        GameWebViewMainProcessService.a(operateGameCenterMsgTask);
    }
}
