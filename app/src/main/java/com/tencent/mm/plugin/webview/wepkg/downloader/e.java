package com.tencent.mm.plugin.webview.wepkg.downloader;

import java.util.concurrent.FutureTask;

public final class e<V> extends FutureTask<V> {
    c tMd;

    public e(Runnable runnable, V v, c cVar) {
        super(runnable, v);
        this.tMd = cVar;
    }
}
