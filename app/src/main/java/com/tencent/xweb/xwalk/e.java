package com.tencent.xweb.xwalk;

import android.net.Uri;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import com.tencent.xweb.a.a;
import com.tencent.xweb.f;
import com.tencent.xweb.l;
import java.util.Map;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkWebResourceRequest;

public final class e {

    public static class b implements Callback {
        XWalkGeolocationPermissionsCallback AsX;

        public b(XWalkGeolocationPermissionsCallback xWalkGeolocationPermissionsCallback) {
            this.AsX = xWalkGeolocationPermissionsCallback;
        }

        public final void invoke(String str, boolean z, boolean z2) {
            if (this.AsX != null) {
                this.AsX.invoke(str, z, z2);
            }
        }
    }

    public static class c extends f {
        public XWalkJavascriptResult AsY;

        public c(XWalkJavascriptResult xWalkJavascriptResult) {
            this.AsY = xWalkJavascriptResult;
        }

        public final void confirmWithResult(String str) {
            this.AsY.confirmWithResult(str);
        }

        public final void confirm() {
            this.AsY.confirm();
        }

        public final void cancel() {
            this.AsY.cancel();
        }
    }

    public static class d extends com.tencent.xweb.e {
        public XWalkJavascriptResult AsY;

        public d(XWalkJavascriptResult xWalkJavascriptResult) {
            this.AsY = xWalkJavascriptResult;
        }

        public final void confirmWithResult(String str) {
            this.AsY.confirmWithResult(str);
        }

        public final void confirm() {
            this.AsY.confirm();
        }

        public final void cancel() {
            this.AsY.cancel();
        }
    }

    public static class g implements com.tencent.xweb.h {
        ValueCallback<Boolean> AsZ;

        public g(ValueCallback<Boolean> valueCallback) {
            this.AsZ = valueCallback;
        }

        public final void proceed() {
            this.AsZ.onReceiveValue(Boolean.valueOf(true));
        }

        public final void cancel() {
            this.AsZ.onReceiveValue(Boolean.valueOf(false));
        }
    }

    public static class h implements l {
        private Uri Arf;
        a Arg = new a(this);
        private boolean hasUserGesture;
        private boolean isMainFrame;
        private String method;
        private Map<String, String> requestHeaders;

        public h(XWalkWebResourceRequest xWalkWebResourceRequest) {
            this.Arf = xWalkWebResourceRequest.getUrl();
            this.isMainFrame = xWalkWebResourceRequest.isForMainFrame();
            this.hasUserGesture = xWalkWebResourceRequest.hasGesture();
            this.method = xWalkWebResourceRequest.getMethod();
            this.requestHeaders = xWalkWebResourceRequest.getRequestHeaders();
        }

        public final Uri getUrl() {
            return this.Arf;
        }

        public final boolean isForMainFrame() {
            return this.isMainFrame;
        }

        public final boolean hasGesture() {
            return this.hasUserGesture;
        }

        public final String getMethod() {
            return this.method;
        }

        public final Map<String, String> getRequestHeaders() {
            return this.requestHeaders;
        }
    }
}
