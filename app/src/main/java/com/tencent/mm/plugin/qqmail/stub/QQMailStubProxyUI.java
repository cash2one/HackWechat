package com.tencent.mm.plugin.qqmail.stub;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.qqmail.ui.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(7)
public class QQMailStubProxyUI extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.QQMail.QQMailStubProxyUI", "onCreate");
        c cVar = new c(this);
        cVar.a(new 1(this, cVar));
    }
}
