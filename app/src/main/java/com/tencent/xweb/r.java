package com.tencent.xweb;

import android.content.Context;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c.h;
import com.tencent.xweb.c.h.a;
import com.tencent.xweb.util.b;
import com.tencent.xweb.util.e;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class r {
    static boolean AqF = false;
    static boolean AqG = false;

    public static void a(Context context, b bVar) {
        a(context, bVar, null, null);
    }

    public static synchronized void a(Context context, b bVar, q qVar, WebViewExtensionListener webViewExtensionListener) {
        synchronized (r.class) {
            if (bVar != null) {
                Log.SetLogCallBack(bVar);
            }
            if (qVar != null) {
                e.a(qVar);
            }
            if ((context != null && XWalkEnvironment.getApplicationContext() == null) || !AqF) {
                AqF = true;
                XWalkEnvironment.init(context);
                a a = h.a(c.AqB);
                if (a != null) {
                    a.initEnviroment(context);
                }
                a = h.a(c.AqC);
                if (a != null) {
                    a.initEnviroment(context);
                }
            }
            if (webViewExtensionListener != null) {
                h.a(c.AqB).initCallback(webViewExtensionListener);
            }
        }
    }

    public static synchronized void initInterface() {
        synchronized (r.class) {
            if (!AqG) {
                AqG = true;
                a a = h.a(c.AqB);
                if (a != null) {
                    a.initInterface();
                }
                a = h.a(c.AqC);
                if (a != null) {
                    a.initInterface();
                }
            }
        }
    }
}
