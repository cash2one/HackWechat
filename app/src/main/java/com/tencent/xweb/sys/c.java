package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import com.tencent.xweb.m;

public final class c {
    public static WebResourceResponse a(m mVar) {
        if (mVar == null) {
            return null;
        }
        if (mVar.mStatusCode == 0 || VERSION.SDK_INT < 21) {
            return new WebResourceResponse(mVar.mMimeType, mVar.mEncoding, mVar.mInputStream);
        }
        return new WebResourceResponse(mVar.mMimeType, mVar.mEncoding, mVar.mStatusCode, mVar.mReasonPhrase, mVar.mResponseHeaders, mVar.mInputStream);
    }
}
