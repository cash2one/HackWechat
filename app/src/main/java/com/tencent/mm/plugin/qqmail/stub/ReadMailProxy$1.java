package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.mm.plugin.downloader.model.o;

class ReadMailProxy$1 implements o {
    final /* synthetic */ ReadMailProxy pqi;

    ReadMailProxy$1(ReadMailProxy readMailProxy) {
        this.pqi = readMailProxy;
    }

    public final void onTaskStarted(long j, String str) {
        this.pqi.CLIENT_CALL("onTaskStarted", new Object[]{Long.valueOf(j), str});
    }

    public final void onTaskRemoved(long j) {
        this.pqi.CLIENT_CALL("onTaskRemoved", new Object[]{Long.valueOf(j)});
    }

    public final void c(long j, String str, boolean z) {
        this.pqi.CLIENT_CALL("onTaskFinished", new Object[]{Long.valueOf(j)});
    }

    public final void c(long j, int i, boolean z) {
        this.pqi.CLIENT_CALL("onTaskFailed", new Object[]{Long.valueOf(j)});
    }

    public final void onTaskPaused(long j) {
        this.pqi.CLIENT_CALL("onTaskPaused", new Object[]{Long.valueOf(j)});
    }

    public final void ck(long j) {
    }

    public final void k(long j, String str) {
    }
}
