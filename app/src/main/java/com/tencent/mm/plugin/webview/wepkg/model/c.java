package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Message;
import java.lang.ref.WeakReference;

public abstract class c {
    public final WeakReference<Object> tME;

    public abstract void r(Message message);

    public c() {
        this.tME = null;
    }

    public c(Object obj) {
        this.tME = new WeakReference(obj);
    }
}
