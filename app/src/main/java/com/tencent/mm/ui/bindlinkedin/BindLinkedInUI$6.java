package com.tencent.mm.ui.bindlinkedin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

class BindLinkedInUI$6 implements OnClickListener {
    final /* synthetic */ BindLinkedInUI ylv;

    BindLinkedInUI$6(BindLinkedInUI bindLinkedInUI) {
        this.ylv = bindLinkedInUI;
    }

    public final void onClick(View view) {
        ar.Hg();
        String str = (String) c.CU().get(286723, null);
        if (!bh.ov(str)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("geta8key_username", q.FS());
            d.b(this.ylv, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }
}
