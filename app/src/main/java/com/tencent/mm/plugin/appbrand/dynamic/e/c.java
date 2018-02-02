package com.tencent.mm.plugin.appbrand.dynamic.e;

import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.x5.sdk.d;
import java.util.LinkedList;
import java.util.List;

public final class c {
    private static volatile boolean gPb;
    private static final List<a> iTY = new LinkedList();

    public interface a {
        void Za();
    }

    public static void initialize() {
        if (!gPb) {
            r.a(ac.getContext(), new 1(), new 2(), new 3());
            if (bh.cgC()) {
                d.forceSysWebView();
            }
            WebView.initWebviewCore(ac.getContext(), MMWebView.zvD, "support", new 4());
        }
    }

    public static boolean a(a aVar) {
        if (iTY.contains(aVar)) {
            return false;
        }
        if (!gPb) {
            return iTY.add(aVar);
        }
        aVar.Za();
        return true;
    }
}
