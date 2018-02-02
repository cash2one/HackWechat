package com.tencent.mm.plugin.game.gamewebview.a;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.f;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static final Map<String, Integer> mVL;

    static {
        Map hashMap = new HashMap();
        mVL = hashMap;
        hashMap.put("addDownloadTaskStraight", Integer.valueOf(1));
        mVL.put(f.NAME, Integer.valueOf(2));
        mVL.put("pauseDownloadTask", Integer.valueOf(3));
        mVL.put("resumeDownloadTask", Integer.valueOf(4));
        mVL.put(ab.NAME, Integer.valueOf(5));
        mVL.put(af.NAME, Integer.valueOf(6));
        mVL.put(GameJsApiSendAppMessage.NAME, Integer.valueOf(7));
    }

    public static int Bz(String str) {
        if (mVL.containsKey(str)) {
            return ((Integer) mVL.get(str)).intValue();
        }
        return 0;
    }
}
