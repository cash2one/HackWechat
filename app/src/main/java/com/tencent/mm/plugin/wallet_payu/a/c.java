package com.tencent.mm.plugin.wallet_payu.a;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.plugin.wallet_core.ui.g.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class c {
    public static void a(final Context context, TextView textView) {
        boolean z = (context == null || textView == null) ? false : true;
        Assert.assertTrue(z);
        g gVar = new g(context);
        gVar.sTw = new a() {
            public final void onClick(View view) {
                x.i("MicroMsg.PayUUtil", "hy: user clicked the span");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://www.payu.co.za/wechat/terms-and-conditions/");
                intent.putExtra("showShare", false);
                d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            }
        };
        g gVar2 = new g(context);
        gVar2.sTw = new 2(context);
        String charSequence = context.getText(i.uVj).toString();
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(gVar, 94, 115, 33);
        spannableString.setSpan(gVar2, charSequence.length() - 3, charSequence.length(), 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
