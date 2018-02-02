package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.g.a.i;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g$a;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;

public class WebViewDownloadUI extends MMActivity {
    private long jcE;
    private TextView lmo;
    private int lsy;
    private Context mContext;
    private boolean txe;
    private Button txk;
    private TextView txl;
    private a txm;
    private String txn;
    private TextView txo;
    private int txp;
    private o txq = new 4(this);

    static /* synthetic */ void a(WebViewDownloadUI webViewDownloadUI, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        b gpVar = new gp();
        gpVar.fwJ.url = str;
        gpVar.fwJ.fqR = str2;
        gpVar.fwJ.extInfo = str3;
        gpVar.fwJ.appId = str4;
        a.xef.m(gpVar);
        g.pQN.h(14217, new Object[]{str4, Integer.valueOf(2), str6, str, Integer.valueOf(0)});
        g$a com_tencent_mm_plugin_downloader_model_g_a = new g$a();
        com_tencent_mm_plugin_downloader_model_g_a.xL(str);
        com_tencent_mm_plugin_downloader_model_g_a.xM(str5);
        com_tencent_mm_plugin_downloader_model_g_a.xN(str7);
        com_tencent_mm_plugin_downloader_model_g_a.xO(str2);
        com_tencent_mm_plugin_downloader_model_g_a.setAppId(str4);
        com_tencent_mm_plugin_downloader_model_g_a.cu(str8);
        com_tencent_mm_plugin_downloader_model_g_a.ep(true);
        com_tencent_mm_plugin_downloader_model_g_a.ox(webViewDownloadUI.lsy);
        long a = f.aAd().a(com_tencent_mm_plugin_downloader_model_g_a.lsE);
        x.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick, lastDownloadId = %d, downloadId=%d", new Object[]{Long.valueOf(webViewDownloadUI.jcE), Long.valueOf(a)});
        webViewDownloadUI.jcE = a;
        b iVar = new i();
        iVar.fmX.fmZ = a;
        iVar.fmX.fmY = false;
        iVar.fmX.scene = webViewDownloadUI.txp;
        a.xef.m(iVar);
        webViewDownloadUI.txe = true;
        if (a <= 0) {
            Toast.makeText(webViewDownloadUI.mController.xIM, webViewDownloadUI.getString(R.l.eWA), 1).show();
            webViewDownloadUI.finish();
            return;
        }
        Toast.makeText(webViewDownloadUI.mController.xIM, webViewDownloadUI.getString(R.l.eWv), 1).show();
        webViewDownloadUI.a(a.txx);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        setMMTitle(getString(R.l.eWF));
        setBackBtn(new 1(this));
        overridePendingTransition(MMFragmentActivity.a.xKg, MMFragmentActivity.a.xKh);
        this.txk = (Button) findViewById(R.h.ccH);
        this.txl = (TextView) findViewById(R.h.ccx);
        TextView textView = (TextView) findViewById(R.h.ccS);
        this.txo = (TextView) findViewById(R.h.ccN);
        ImageView imageView = (ImageView) findViewById(R.h.ccQ);
        this.lmo = (TextView) findViewById(R.h.ccR);
        a(a.txw);
        String stringExtra = getIntent().getStringExtra("task_name");
        String stringExtra2 = getIntent().getStringExtra("task_url");
        String stringExtra3 = getIntent().getStringExtra("alternative_url");
        long longExtra = getIntent().getLongExtra("task_size", 0);
        String stringExtra4 = getIntent().getStringExtra("file_md5");
        String stringExtra5 = getIntent().getStringExtra("extInfo");
        String stringExtra6 = getIntent().getStringExtra("fileType");
        String stringExtra7 = getIntent().getStringExtra("appid");
        String stringExtra8 = getIntent().getStringExtra("package_name");
        String stringExtra9 = getIntent().getStringExtra("thumb_url");
        CharSequence stringExtra10 = getIntent().getStringExtra("title");
        String stringExtra11 = getIntent().getStringExtra("page_url");
        this.txp = getIntent().getIntExtra("page_scene", 0);
        g.pQN.h(14217, new Object[]{stringExtra7, Integer.valueOf(1), stringExtra11, stringExtra2, Integer.valueOf(0)});
        this.lsy = bh.getInt(stringExtra6, 1);
        if (bh.ov(stringExtra10)) {
            stringExtra10 = bh.ou(stringExtra);
        }
        if (!bh.ov(stringExtra10)) {
            textView.setText(stringExtra10);
            textView.setVisibility(0);
        }
        if (longExtra > 0) {
            this.txn = bh.fK(longExtra);
            this.txo.setText(this.txn);
            this.txk.setText(getString(R.l.eWx, new Object[]{this.txn}));
        }
        com.tencent.mm.aq.a.a PA = com.tencent.mm.aq.o.PA();
        c$a com_tencent_mm_aq_a_a_c_a = new c$a();
        com_tencent_mm_aq_a_a_c_a.hDP = R.k.dBI;
        com_tencent_mm_aq_a_a_c_a.hDA = true;
        PA.a(stringExtra9, imageView, com_tencent_mm_aq_a_a_c_a.PK());
        this.txk.setOnClickListener(new 2(this, stringExtra2, stringExtra4, stringExtra5, stringExtra7, stringExtra3, stringExtra11, stringExtra, stringExtra8));
        this.txl.setOnClickListener(new 3(this, stringExtra7, stringExtra11, stringExtra2));
        f.aAd();
        c.a(this.txq);
    }

    protected void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.WebViewDownloadUI", "onDestroy hasCallback=%b", new Object[]{Boolean.valueOf(this.txe)});
        if (!this.txe) {
            b iVar = new i();
            iVar.fmX.fmY = true;
            iVar.fmX.scene = this.txp;
            a.xef.m(iVar);
            this.txe = true;
        }
        f.aAd();
        c.b(this.txq);
    }

    protected final int getLayoutId() {
        return R.i.dub;
    }

    private void a(a aVar) {
        x.i("MicroMsg.WebViewDownloadUI", "setDownloadState old=%s new=%s", new Object[]{this.txm, aVar});
        this.txm = aVar;
        switch (5.txv[this.txm.ordinal()]) {
            case 1:
                this.txk.setVisibility(0);
                this.lmo.setVisibility(8);
                this.txl.setVisibility(8);
                break;
            case 2:
                this.txk.setVisibility(8);
                this.txl.setVisibility(0);
                this.lmo.setVisibility(0);
                if (!bh.ov(this.txn)) {
                    this.txo.setVisibility(0);
                    return;
                }
                break;
            default:
                return;
        }
        this.txo.setVisibility(8);
    }
}
