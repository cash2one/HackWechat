package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.bh;

public final class o {
    private final j ttL;
    public final SparseArray<Object> ttM;
    public final SparseArray<Boolean> ttN;

    private static final class a {
        private static final o ttO = new o();
    }

    private o() {
        this.ttL = new j();
        this.ttM = new SparseArray();
        this.ttN = new SparseArray();
    }

    public static boolean a(String str, d dVar, int i) {
        a.ttO;
        bh.ov(str);
        return false;
    }
}
