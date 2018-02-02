package com.tencent.xweb.c;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.f;

public interface e {
    boolean a(String str, String str2, f fVar);

    boolean a(String str, String str2, String str3, com.tencent.xweb.e eVar);

    boolean b(String str, String str2, f fVar);

    void onHideCustomView();

    void onShowCustomView(View view, CustomViewCallback customViewCallback);

    void x(String str, Bitmap bitmap);
}
