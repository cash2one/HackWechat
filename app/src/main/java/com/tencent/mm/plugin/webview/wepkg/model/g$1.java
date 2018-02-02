package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Message;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class g$1 extends c {
    final /* synthetic */ String tMB;

    g$1(String str) {
        this.tMB = str;
    }

    public final void r(Message message) {
        final String string = message.getData().getString("used_wepkg_version");
        d.Dm().F(new Runnable(this) {
            final /* synthetic */ g$1 tNe;

            public final void run() {
                int i = 0;
                String Qp = d.Qp(this.tNe.tMB);
                String str = "";
                WepkgVersion Qi = h.Qi(this.tNe.tMB);
                if (Qi != null) {
                    str = Qi.version;
                }
                x.i("MicroMsg.Wepkg.WepkgManager", "clear all local wepkg, pkgid:%s, currVersion:%s, usedVersion:%s", new Object[]{this.tNe.tMB, str, string});
                try {
                    if (bh.ov(string) && bh.ov(str)) {
                        g.Qg(Qp);
                        return;
                    }
                    File file = new File(Qp);
                    if (file.exists() && !file.isFile()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null || listFiles.length == 0) {
                            file.delete();
                            return;
                        }
                        int length = listFiles.length;
                        while (i < length) {
                            File file2 = listFiles[i];
                            if (file2.isFile()) {
                                file2.delete();
                            }
                            if (!(!file2.isDirectory() || file2.getName().equalsIgnoreCase(string) || file2.getName().equalsIgnoreCase(str))) {
                                x.i("MicroMsg.Wepkg.WepkgManager", "delete local path:%s", new Object[]{file2.getAbsolutePath()});
                                g.Qg(file2.getAbsolutePath());
                            }
                            i++;
                        }
                    }
                } catch (Exception e) {
                    x.i("MicroMsg.Wepkg.WepkgManager", "clearAllLocalWepkg err:" + e.getMessage());
                }
            }
        });
    }
}
