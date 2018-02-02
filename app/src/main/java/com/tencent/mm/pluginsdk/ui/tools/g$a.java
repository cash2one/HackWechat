package com.tencent.mm.pluginsdk.ui.tools;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.af;
import java.util.LinkedList;

abstract class g$a<T> {
    private af handler;
    final /* synthetic */ g vxl;
    final int vxq = Math.max(1, 16);
    LinkedList<T> vxr = new LinkedList();

    protected abstract T ccy();

    public g$a(g gVar, int i, Looper looper) {
        this.vxl = gVar;
        this.handler = new 1(this, looper, gVar);
    }

    public final T ccz() {
        if (this.vxr.isEmpty()) {
            return ccy();
        }
        return this.vxr.removeFirst();
    }

    public final void C(T t) {
        this.handler.sendMessage(this.handler.obtainMessage(1, t));
    }
}
