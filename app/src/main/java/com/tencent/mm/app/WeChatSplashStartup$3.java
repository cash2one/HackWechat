package com.tencent.mm.app;

import com.tencent.mm.kernel.api.g;
import com.tencent.mm.splash.e;
import com.tencent.mm.splash.k.a;
import java.io.File;

class WeChatSplashStartup$3 implements g {
    final /* synthetic */ a ffZ;
    final /* synthetic */ WeChatSplashStartup fga;
    final /* synthetic */ boolean fgf;

    WeChatSplashStartup$3(WeChatSplashStartup weChatSplashStartup, boolean z, a aVar) {
        this.fga = weChatSplashStartup;
        this.fgf = z;
        this.ffZ = aVar;
    }

    public final void ul() {
        com.tencent.mm.kernel.g.Dk().b((g) this);
        if (this.fgf) {
            e.a("MicroMsg.FigLeaf", "deleteRequest ", new Object[0]);
            String chh = com.tencent.mm.splash.a.chh();
            if (new File(chh).exists()) {
                File file = new File(chh + "/main-process-blocking");
                if (file.exists()) {
                    boolean delete = file.delete();
                    e.a("MicroMsg.FigLeaf", "deleteRequest result %s.", Boolean.valueOf(delete));
                    return;
                }
                return;
            }
            e.a("MicroMsg.FigLeaf", "deleteRequest dex opt dir not exists.", new Object[0]);
            return;
        }
        this.ffZ.done();
    }

    public final void aG(boolean z) {
    }
}
