package com.tencent.xweb.sys;

import android.webkit.SslErrorHandler;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.xweb.h;

@JgClassChecked(author = 30, fComment = "checked", lastDate = "20171024", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
public class c$a implements h {
    SslErrorHandler Arc;

    public c$a(SslErrorHandler sslErrorHandler) {
        this.Arc = sslErrorHandler;
    }

    public final void proceed() {
        this.Arc.proceed();
    }

    public final void cancel() {
        this.Arc.cancel();
    }
}
