package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.h.d;

class e$1 implements d {
    final /* synthetic */ Context val$context;
    final /* synthetic */ String zJg;

    e$1(Context context, String str) {
        this.val$context = context;
        this.zJg = str;
    }

    public final void cn(int i, int i2) {
        Intent intent = new Intent();
        switch (i) {
            case 0:
                intent.putExtra("rawUrl", this.val$context.getString(i.uOH, new Object[]{w.cfi()}));
                break;
            case 1:
                if (this.zJg != null) {
                    intent.putExtra("rawUrl", this.val$context.getString(i.uOG, new Object[]{w.cfi(), this.zJg}));
                    break;
                }
                break;
            case 2:
                if (this.zJg != null) {
                    intent.putExtra("rawUrl", this.val$context.getString(i.uOI, new Object[]{w.cfi(), this.zJg}));
                    break;
                }
                break;
            case 3:
                if (this.zJg != null) {
                    intent.putExtra("rawUrl", this.val$context.getString(i.uOJ, new Object[]{w.cfi(), this.zJg}));
                    break;
                }
                break;
        }
        intent.putExtra("showShare", false);
        com.tencent.mm.bm.d.b(this.val$context, "webview", ".ui.tools.WebViewUI", intent);
    }
}
