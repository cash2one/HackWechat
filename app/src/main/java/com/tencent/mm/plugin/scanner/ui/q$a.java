package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.r;

final class q$a implements Runnable {
    final /* synthetic */ q pYI;
    String url;

    private q$a(q qVar) {
        this.pYI = qVar;
    }

    public final void run() {
        if (this.pYI.pXp != null && !q.e(this.pYI)) {
            r.a(new e());
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("jsapi_args_appid", "wx751a1acca5688ba3");
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("rawUrl", this.url);
            intent.putExtra("show_bottom", false);
            intent.putExtra("title", R.l.eHB);
            intent.putExtra("webview_bg_color_rsID", R.e.black);
            intent.putExtra("geta8key_scene", 13);
            intent.setFlags(65536);
            b.ifs.j(intent, this.pYI.pXp.getContext());
            this.pYI.pXp.getContext().finish();
            this.pYI.pXp.getContext().overridePendingTransition(0, 0);
        }
    }
}
