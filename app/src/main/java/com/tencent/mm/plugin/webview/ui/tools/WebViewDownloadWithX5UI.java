package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.xweb.x5.sdk.d;
import java.util.HashMap;

@a(2)
public class WebViewDownloadWithX5UI extends MMActivity {
    private Context mContext;
    private Button txk;
    private final com.tencent.mm.plugin.webview.modeltools.a txz = new com.tencent.mm.plugin.webview.modeltools.a();

    static /* synthetic */ void a(WebViewDownloadWithX5UI webViewDownloadWithX5UI, String str, String str2) {
        int i;
        b gpVar = new gp();
        gpVar.fwJ.url = str;
        gpVar.fwJ.fqR = "";
        gpVar.fwJ.extInfo = "";
        gpVar.fwJ.appId = "";
        com.tencent.mm.sdk.b.a.xef.m(gpVar);
        g.pQN.h(14217, new Object[]{"", Integer.valueOf(2), str2, str, Integer.valueOf(1)});
        int tbsVersion = d.getTbsVersion(webViewDownloadWithX5UI);
        if (ar.Hj()) {
            ar.Hg();
            String str3 = (String) c.CU().get(274528, "");
            if (TextUtils.isEmpty(str3) || !p.m(webViewDownloadWithX5UI.mController.xIM, str3)) {
                i = 0;
            } else {
                x.i("MicroMsg.WebViewDownloadWithX5UI", "use always option PackageName is %s", new Object[]{str3});
                i = 1;
            }
        } else {
            i = 0;
        }
        if (i != 0 || tbsVersion <= 0) {
            com.tencent.mm.plugin.webview.modeltools.a.d(webViewDownloadWithX5UI, str);
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
        hashMap.put(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, "9");
        x.i("MicroMsg.WebViewDownloadWithX5UI", "startQbOrMiniQBToLoadUrl ret = %b", new Object[]{Boolean.valueOf(d.a(webViewDownloadWithX5UI, str, hashMap, new ValueCallback<String>(webViewDownloadWithX5UI) {
            final /* synthetic */ WebViewDownloadWithX5UI txA;

            {
                this.txA = r1;
            }

            public final /* synthetic */ void onReceiveValue(Object obj) {
                x.i("MicroMsg.WebViewDownloadWithX5UI", "onReceiveValue Value = %s", new Object[]{(String) obj});
                if ("closeMiniQb".equals((String) obj)) {
                    this.txA.finish();
                }
            }
        }))});
        if (!d.a(webViewDownloadWithX5UI, str, hashMap, /* anonymous class already generated */)) {
            com.tencent.mm.plugin.webview.modeltools.a.d(webViewDownloadWithX5UI, str);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        setMMTitle(getString(R.l.eWF));
        setBackBtn(new 1(this));
        overridePendingTransition(MMFragmentActivity.a.xKg, MMFragmentActivity.a.xKh);
        this.txk = (Button) findViewById(R.h.ccH);
        ImageView imageView = (ImageView) findViewById(R.h.ccQ);
        TextView textView = (TextView) findViewById(R.h.ccS);
        String stringExtra = getIntent().getStringExtra("task_url");
        CharSequence stringExtra2 = getIntent().getStringExtra("title");
        long longExtra = getIntent().getLongExtra("task_size", 0);
        String stringExtra3 = getIntent().getStringExtra("page_url");
        x.i("MicroMsg.WebViewDownloadWithX5UI", "onCreate: url=%s,taskSize=%d, thumbUrl=%s", new Object[]{stringExtra, Long.valueOf(longExtra), getIntent().getStringExtra("thumb_url")});
        if (longExtra > 0) {
            String fK = bh.fK(longExtra);
            this.txk.setText(getString(R.l.eWx, new Object[]{fK}));
        }
        if (ar.Hj()) {
            com.tencent.mm.aq.a.a PA = o.PA();
            com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
            aVar.hDP = R.k.dBI;
            aVar.hDA = true;
            PA.a(r7, imageView, aVar.PK());
        } else {
            imageView.setImageResource(R.k.dBI);
        }
        textView.setVisibility(0);
        if (bh.ov(stringExtra2)) {
            textView.setText(getString(R.l.eWE));
        } else {
            textView.setText(stringExtra2);
        }
        g.pQN.h(14217, new Object[]{"", Integer.valueOf(1), stringExtra3, stringExtra, Integer.valueOf(1)});
        this.txk.setOnClickListener(new 2(this, longExtra, stringExtra, stringExtra3));
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dub;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (com.tencent.mm.plugin.webview.modeltools.a.b(this, i, i2, intent) && -1 == i2) {
            finish();
        }
    }
}
