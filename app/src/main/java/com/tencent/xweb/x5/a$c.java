package com.tencent.xweb.x5;

import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.xweb.f;

public class a$c implements JsResult {
    public f mZt;

    public a$c(f fVar) {
        this.mZt = fVar;
    }

    public final void confirm() {
        this.mZt.confirm();
    }

    public final void cancel() {
        this.mZt.cancel();
    }
}
