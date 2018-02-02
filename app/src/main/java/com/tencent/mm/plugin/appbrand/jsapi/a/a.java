package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends ClickableSpan {
    private String jgo;
    private int jgp = ac.getContext().getResources().getColor(d.bsE);

    public a(String str) {
        this.jgo = str;
    }

    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.jgp);
        textPaint.setUnderlineText(false);
    }

    public final void onClick(View view) {
        if (bh.ov(this.jgo)) {
            x.e("MicroMsg.ExposeSpan", "exposeUrl is null, return");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.jgo);
        intent.putExtra("forceHideShare", true);
        com.tencent.mm.bm.d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        x.d("MicroMsg.ExposeSpan", "expose click, exposeUrl:%s", new Object[]{this.jgo});
    }
}
