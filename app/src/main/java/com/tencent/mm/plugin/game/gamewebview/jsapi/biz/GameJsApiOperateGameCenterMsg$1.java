package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg.OperateGameCenterMsgTask;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;
import java.util.Map;

class GameJsApiOperateGameCenterMsg$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ d mWr;
    final /* synthetic */ OperateGameCenterMsgTask mXa;
    final /* synthetic */ GameJsApiOperateGameCenterMsg mXb;

    GameJsApiOperateGameCenterMsg$1(GameJsApiOperateGameCenterMsg gameJsApiOperateGameCenterMsg, OperateGameCenterMsgTask operateGameCenterMsgTask, d dVar, int i) {
        this.mXb = gameJsApiOperateGameCenterMsg;
        this.mXa = operateGameCenterMsgTask;
        this.mWr = dVar;
        this.gOK = i;
    }

    public final void run() {
        this.mXa.afj();
        Map hashMap = new HashMap();
        hashMap.put("result", bh.ou(this.mXa.result));
        this.mWr.E(this.gOK, GameJsApiOperateGameCenterMsg.e("getGameMessages:ok", hashMap));
    }
}
