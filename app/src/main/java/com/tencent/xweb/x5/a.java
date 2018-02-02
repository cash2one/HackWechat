package com.tencent.xweb.x5;

import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.ab;
import com.tencent.xweb.m;

public final class a {

    public static class d<T> implements ab<T> {
        ValueCallback<T> ArF;

        public d(ValueCallback<T> valueCallback) {
            this.ArF = valueCallback;
        }

        public final void onReceiveValue(T t) {
            if (this.ArF != null) {
                this.ArF.onReceiveValue(t);
            }
        }
    }

    public static WebResourceResponse b(m mVar) {
        if (mVar == null) {
            return null;
        }
        return new WebResourceResponse(mVar.mMimeType, mVar.mEncoding, mVar.mStatusCode, mVar.mReasonPhrase, mVar.mResponseHeaders, mVar.mInputStream);
    }
}
