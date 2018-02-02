package com.tencent.mm.app;

import android.content.res.Resources;
import com.tencent.mm.svg.a.e;
import java.util.Map;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;

class AppBrandProfile$4 extends WebViewExtensionListener {
    final /* synthetic */ AppBrandProfile feI;

    AppBrandProfile$4(AppBrandProfile appBrandProfile) {
        this.feI = appBrandProfile;
    }

    public final Object onMiscCallBack(String str, Object... objArr) {
        if (WebViewExtension.EXTENSION_ADD_FILTER_RESOURCES.equals(str)) {
            e.a((Resources) objArr[0], (Map) objArr[1]);
        }
        return null;
    }
}
