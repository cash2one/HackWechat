package com.tencent.xweb.b;

import org.xwalk.core.Log;

public final class d implements b {
    public static a AqI = null;
    public c AqJ = null;

    public static void a(a aVar) {
        Log.i("WXFileDownloaderBridge", "XWalkLib SetFileDownloaderProxy:" + (aVar == null));
        AqI = aVar;
    }

    public static boolean isValid() {
        return AqI != null;
    }

    public final void u(String str, String str2, boolean z) {
        Log.i("WXFileDownloaderBridge", "onTaskFinished url=" + str + ", save_path=" + str2);
        this.AqJ.onTaskSucc(str, str2, z);
    }

    public final void t(String str, int i, boolean z) {
        Log.i("WXFileDownloaderBridge", "onTaskFailed, url=" + str + ", errCode=" + i);
        this.AqJ.onTaskFail(str, i, z);
    }

    public final void w(String str, long j, long j2) {
        Log.i("WXFileDownloaderBridge", "onTaskProgressChanged, url=" + str + ", cur_size:" + j + ", total_size:" + j2);
        this.AqJ.onProgressChange(str, j, j2);
    }
}
