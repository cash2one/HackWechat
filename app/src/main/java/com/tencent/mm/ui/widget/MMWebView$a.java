package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;

public class MMWebView$a {
    public static MMWebView cn(Context context) {
        x.i("MMWebView", "TRACE_ORDER:MMWebView.java");
        WebView.initWebviewCore(context, MMWebView.zvD, "tools", null);
        MMWebView.ge(context);
        MMWebView mMWebView = new MMWebView(context);
        mMWebView.gGO = true;
        MMWebView.a(mMWebView, mMWebView.isX5Kernel);
        return mMWebView;
    }

    public static MMWebView l(Activity activity, int i) {
        boolean z = true;
        MMWebView.ge(activity);
        MMWebView mMWebView = (MMWebView) activity.findViewById(i);
        mMWebView.gGO = true;
        if (mMWebView.getX5WebViewExtension() == null) {
            z = false;
        }
        MMWebView.b(mMWebView, z);
        return mMWebView;
    }

    public static MMWebView a(Context context, View view, int i) {
        boolean z = true;
        MMWebView.ge(context);
        MMWebView mMWebView = (MMWebView) view.findViewById(i);
        mMWebView.gGO = true;
        if (mMWebView.getX5WebViewExtension() == null) {
            z = false;
        }
        MMWebView.c(mMWebView, z);
        return mMWebView;
    }
}
