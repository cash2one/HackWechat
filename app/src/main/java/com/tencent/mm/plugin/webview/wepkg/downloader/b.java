package com.tencent.mm.plugin.webview.wepkg.downloader;

import com.tencent.mm.pluginsdk.i.a.d.t;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class b {
    public static Object lock = new Object();
    public static b tLF;
    h tLG = new h(TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new t("WepkgDownloaderPool", "WepkgDownloaderThread"));

    public static b bVc() {
        if (tLF == null) {
            synchronized (lock) {
                if (tLF == null) {
                    tLF = new b();
                }
            }
        }
        return tLF;
    }
}
