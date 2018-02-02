package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static Dialog e(Context context, final View view) {
        View inflate = LayoutInflater.from(context).inflate(g.qGx, null);
        String str = w.cff() ? "font_1.otf" : w.cfg() ? "font_2.otf" : null;
        TextView textView = (TextView) inflate.findViewById(f.qCR);
        if (!bh.ov(str)) {
            textView.setTypeface(Typeface.createFromAsset(context.getAssets(), str));
        }
        if (!w.cfe()) {
            textView.setTextSize(1, 10.0f);
        }
        final Dialog dialog = new Dialog(context, k.eYV);
        dialog.setContentView(inflate);
        dialog.setTitle(null);
        dialog.setOnCancelListener(new 1(dialog));
        ((TextView) inflate.findViewById(f.qCk)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onClick");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                View view2 = view;
                if (view2 != null) {
                    view2.performClick();
                }
            }
        });
        View findViewById = inflate.findViewById(f.qFM);
        int b = b.b(context, 10.0f);
        bh.j(findViewById, b, b, b, b);
        findViewById.setOnClickListener(new 3(dialog));
        dialog.show();
        return dialog;
    }
}
