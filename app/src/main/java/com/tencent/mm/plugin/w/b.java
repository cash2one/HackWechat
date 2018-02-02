package com.tencent.mm.plugin.w;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b {
    public static int oFk = 0;
    public static int oFl = 1644429312;
    public static int oFm = 302122240;
    public static int oFn = 50;
    public static int oFo = 20;
    public static int oFp = 100;
    public static int oFq = 3;

    public static void bbL() {
        c fn = com.tencent.mm.z.c.c.IF().fn("100224");
        if (fn.isValid()) {
            Map chI = fn.chI();
            oFk = bh.getInt((String) chI.get("SyncOpen"), 0);
            oFl = bh.getInt((String) chI.get("WindowsVersion"), 1644429312);
            oFm = bh.getInt((String) chI.get("MacVersion"), 302122240);
            oFn = bh.getInt((String) chI.get("MsgSyncSessionCount"), 50);
            oFo = bh.getInt((String) chI.get("MsgSyncMsgCount"), 20);
            oFp = bh.getInt((String) chI.get("MsgSyncSessionListCount"), 100);
            oFq = bh.getInt((String) chI.get("MsgSyncTimeLimit"), 3);
        }
        x.i("MicroMsg.MsgSynchronizeConstants", "initMsgSynchronizeAbtest, SYNC_CLOSE:%d, WINDOWS_VERSION:%d, MAC_VERSION:%d, SESSION_COUNT:%d, MSG_COUNT%d, MSG_LIST_COUNT:%d, TIME_LIMIT:%d", new Object[]{Integer.valueOf(oFk), Integer.valueOf(oFl), Integer.valueOf(oFm), Integer.valueOf(oFn), Integer.valueOf(oFo), Integer.valueOf(oFp), Integer.valueOf(oFq)});
    }
}
