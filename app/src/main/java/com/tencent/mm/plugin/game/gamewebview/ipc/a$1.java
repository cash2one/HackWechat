package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Bundle;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.game.gamewebview.b.a.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

class a$1 extends a {
    private final byte[] gym = new byte[0];

    a$1() {
    }

    public final void eq(int i) {
        synchronized (this.gym) {
            Bundle bundle = new Bundle();
            bundle.putInt("mm_to_client_notify_type", 1);
            bundle.putString("js_event_name", d.NAME);
            bundle.putString(DownloadInfo.NETTYPE, s.bQV());
            a.z(bundle);
        }
    }
}
