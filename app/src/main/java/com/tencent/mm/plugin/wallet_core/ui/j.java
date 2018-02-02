package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.util.List;

public final class j {
    public static Dialog a(final Context context, String str, String str2, List<String> list, String str3, int i, String str4, String str5, String str6, String str7) {
        View inflate = LayoutInflater.from(context).inflate(g.uEZ, null);
        ImageView imageView = (ImageView) inflate.findViewById(f.bWl);
        int b = b.b(context, 15.0f);
        bh.j(imageView, b, b, b, b);
        TextView textView = (TextView) inflate.findViewById(f.upN);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(f.upO);
        Button button = (Button) inflate.findViewById(f.uxp);
        TextView textView2 = (TextView) inflate.findViewById(f.upM);
        ((TextView) inflate.findViewById(f.euB)).setText(str);
        textView.setText(str2);
        linearLayout.removeAllViews();
        for (String str8 : list) {
            View inflate2 = LayoutInflater.from(context).inflate(g.uFa, null);
            ((TextView) inflate2.findViewById(f.uAI)).setText(str8);
            linearLayout.addView(inflate2);
        }
        button.setText(str3);
        if (i > 0) {
            b = str4.length();
            int length = (str4 + str5).length();
            CharSequence spannableString = new SpannableString(str4 + str5);
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(a$c.ubF)), b, length, 33);
            textView2.setText(spannableString);
        } else {
            textView2.setText("");
        }
        textView2.setOnClickListener(new 1(str6, context));
        final Dialog dialog = new Dialog(context, com.tencent.mm.plugin.wxpay.a.j.eYV);
        dialog.setContentView(inflate);
        dialog.setTitle(null);
        dialog.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                x.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        imageView.setOnClickListener(new 4(dialog));
        final String str9 = str7;
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                x.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[]{str9});
                intent.putExtra("rawUrl", r1);
                intent.putExtra("geta8key_username", q.FS());
                intent.putExtra("pay_channel", 1);
                d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
        return dialog;
    }
}
