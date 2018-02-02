package com.tencent.mm.plugin.game.gamewebview.b;

import com.tencent.mm.sdk.platformtools.bh;
import java.util.Map;

public final class b {
    public static Map<String, a> mXG;

    public static void a(a aVar) {
        if (!bh.ov(aVar.getName())) {
            mXG.put(aVar.getName(), aVar);
        }
    }
}
