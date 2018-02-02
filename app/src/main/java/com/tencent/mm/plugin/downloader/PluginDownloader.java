package com.tencent.mm.plugin.downloader;

import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader.b.b;
import com.tencent.mm.sdk.platformtools.x;

public class PluginDownloader extends f implements c, b {
    public void execute(g gVar) {
        x.d("MicroMsg.PluginDownloader", "execute");
        com.tencent.mm.kernel.g.a(a.class, new a());
    }

    public void onAccountInitialized(e.c cVar) {
        new Thread(new 1(this)).start();
    }

    public void onAccountRelease() {
    }
}
