package com.tencent.mm.plugin.game.gamewebview.model;

import android.os.Bundle;
import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.game.gamewebview.b.a.b;
import com.tencent.mm.plugin.game.gamewebview.b.a.c;
import com.tencent.mm.sdk.platformtools.x;

public final class e implements o {
    public final void onTaskStarted(long j, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", c.NAME);
        bundle.putString("state", "download_start");
        a ce = com.tencent.mm.plugin.downloader.model.e.ce(j);
        bundle.putString("appid", ce != null ? ce.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.z(bundle);
    }

    public final void c(long j, String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", c.NAME);
        bundle.putString("state", "download_succ");
        a ce = com.tencent.mm.plugin.downloader.model.e.ce(j);
        bundle.putString("appid", ce != null ? ce.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.z(bundle);
    }

    public final void c(long j, int i, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", c.NAME);
        bundle.putString("state", "download_fail");
        bundle.putInt("err_code", i);
        a ce = com.tencent.mm.plugin.downloader.model.e.ce(j);
        bundle.putString("appid", ce != null ? ce.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.z(bundle);
    }

    public final void onTaskRemoved(long j) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", c.NAME);
        bundle.putString("state", "download_removed");
        a ce = com.tencent.mm.plugin.downloader.model.e.ce(j);
        bundle.putString("appid", ce != null ? ce.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.z(bundle);
    }

    public final void onTaskPaused(long j) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", c.NAME);
        bundle.putString("state", "download_pause");
        a ce = com.tencent.mm.plugin.downloader.model.e.ce(j);
        bundle.putString("appid", ce != null ? ce.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.z(bundle);
    }

    public final void ck(long j) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", b.NAME);
        a ce = com.tencent.mm.plugin.downloader.model.e.ce(j);
        if (ce == null || ce.field_totalSize == 0) {
            x.w("MicroMsg.GameWebViewDownloadEventBus", "loadDownloadProgress failed, downloadId = " + j);
            return;
        }
        bundle.putInt("progress", (int) ((((double) ce.field_downloadedSize) / ((double) ce.field_totalSize)) * 100.0d));
        bundle.putString("appid", ce.field_appId);
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.z(bundle);
    }

    public final void k(long j, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", c.NAME);
        bundle.putString("state", "download_resumed");
        a ce = com.tencent.mm.plugin.downloader.model.e.ce(j);
        bundle.putString("appid", ce != null ? ce.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.z(bundle);
    }
}
