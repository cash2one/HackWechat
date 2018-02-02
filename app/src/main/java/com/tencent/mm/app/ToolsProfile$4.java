package com.tencent.mm.app;

import android.content.res.Resources;
import com.tencent.mm.svg.a.e;
import java.util.Map;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;

class ToolsProfile$4 extends WebViewExtensionListener {
    final /* synthetic */ ToolsProfile ffM;

    ToolsProfile$4(ToolsProfile toolsProfile) {
        this.ffM = toolsProfile;
    }

    public final Object onMiscCallBack(String str, Object... objArr) {
        if (WebViewExtension.EXTENSION_ADD_FILTER_RESOURCES.equals(str)) {
            e.a((Resources) objArr[0], (Map) objArr[1]);
        }
        return null;
    }
}
