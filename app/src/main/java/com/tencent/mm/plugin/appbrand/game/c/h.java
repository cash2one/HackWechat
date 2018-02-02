package com.tencent.mm.plugin.appbrand.game.c;

import android.app.ActivityManager;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ac;

public final class h {
    public int iZm = Integer.MAX_VALUE;

    public final int a(MemoryInfo memoryInfo) {
        if (this.iZm == Integer.MAX_VALUE || memoryInfo == null) {
            return Integer.MAX_VALUE;
        }
        return b(memoryInfo) - this.iZm;
    }

    public static int b(MemoryInfo memoryInfo) {
        if (memoryInfo == null) {
            return 0;
        }
        return memoryInfo.getTotalPss() / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    }

    public static MemoryInfo aeg() {
        MemoryInfo[] processMemoryInfo = ((ActivityManager) ac.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()});
        if (processMemoryInfo == null || processMemoryInfo.length <= 0) {
            return null;
        }
        return processMemoryInfo[0];
    }
}
