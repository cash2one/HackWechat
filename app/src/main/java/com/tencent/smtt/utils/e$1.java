package com.tencent.smtt.utils;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.utils.e.a;

class e$1 implements a {
    final /* synthetic */ WebView Aas;
    final /* synthetic */ RelativeLayout Aat;
    final /* synthetic */ TextView Aau;
    final /* synthetic */ e Aav;
    final /* synthetic */ Context val$context;
    final /* synthetic */ String val$url;

    e$1(e eVar, WebView webView, Context context, RelativeLayout relativeLayout, String str, TextView textView) {
        this.Aav = eVar;
        this.Aas = webView;
        this.val$context = context;
        this.Aat = relativeLayout;
        this.val$url = str;
        this.Aau = textView;
    }

    public final void cFo() {
        this.Aas.post(new Runnable(this) {
            final /* synthetic */ e$1 Aaw;

            {
                this.Aaw = r1;
            }

            public final void run() {
                Toast.makeText(this.Aaw.val$context, "下载成功", 0).show();
                this.Aaw.Aat.setVisibility(4);
                this.Aaw.Aav.a(this.Aaw.val$url, this.Aaw.Aas, this.Aaw.val$context, e.cFn());
            }
        });
    }

    public final void cFp() {
        this.Aas.post(new 3(this));
    }

    public final void kO(final int i) {
        this.Aas.post(new Runnable(this) {
            final /* synthetic */ e$1 Aaw;

            public final void run() {
                this.Aaw.Aau.setText("已下载" + i + "%");
            }
        });
    }
}
