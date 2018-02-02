package com.tencent.mm.plugin.appbrand.game.c;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mm.plugin.appbrand.game.e.g;
import com.tencent.mm.plugin.appbrand.game.l;
import com.tencent.xweb.WebView;
import java.util.LinkedList;

public final class b extends WebView {
    boolean iYp = false;
    public View iYq;
    LinkedList<String> iYr;
    boolean iYs = false;

    public b(Context context) {
        super(context);
        getSettings().setJavaScriptEnabled(true);
        this.iYq = new a(getContext());
        this.iYq.setOnClickListener(new 1(this));
        setWebViewClient(new 2(this));
        loadUrl("wagame://WAGameVConsole.html");
        setTranslationY((float) aec());
    }

    private static int aec() {
        Point point = new Point();
        l lVar = l.iXJ;
        l.c(point);
        return point.y;
    }

    final void rL(String str) {
        String rV = g.rV(str);
        if (VERSION.SDK_INT >= 19) {
            evaluateJavascript("console._log('" + rV + "')", null);
        } else {
            loadUrl("javascript:console._log('" + rV + "')");
        }
    }
}
