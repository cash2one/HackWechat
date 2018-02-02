package com.tencent.xweb.x5;

import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.xweb.h;

public class g$a implements h {
    SslErrorHandler ArM;

    public g$a(SslErrorHandler sslErrorHandler) {
        this.ArM = sslErrorHandler;
    }

    public final void proceed() {
        this.ArM.proceed();
    }

    public final void cancel() {
        this.ArM.cancel();
    }
}
