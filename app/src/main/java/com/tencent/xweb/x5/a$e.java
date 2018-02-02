package com.tencent.xweb.x5;

import android.net.Uri;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.xweb.l;
import java.util.Map;

public class a$e implements WebResourceRequest {
    public l ArG;

    public static WebResourceRequest a(l lVar) {
        if (lVar == null) {
            return null;
        }
        return new a$e(lVar);
    }

    private a$e(l lVar) {
        this.ArG = lVar;
    }

    public final Uri getUrl() {
        return this.ArG.getUrl();
    }

    public final boolean isForMainFrame() {
        return this.ArG.isForMainFrame();
    }

    public final boolean isRedirect() {
        return false;
    }

    public final boolean hasGesture() {
        return this.ArG.hasGesture();
    }

    public final String getMethod() {
        return this.ArG.getMethod();
    }

    public final Map<String, String> getRequestHeaders() {
        return this.ArG.getRequestHeaders();
    }
}
