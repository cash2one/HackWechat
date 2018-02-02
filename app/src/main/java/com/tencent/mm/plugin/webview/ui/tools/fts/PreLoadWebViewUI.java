package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.plugin.aj.b;
import com.tencent.mm.plugin.aj.c;
import com.tencent.mm.plugin.aj.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public abstract class PreLoadWebViewUI extends WebViewUI {
    protected String fqu;
    boolean tEd;
    CountDownLatch tEe = new CountDownLatch(bTJ() + 2);
    private b tEf;
    private int tjB = -1;
    protected String tjs;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (TextUtils.isEmpty(this.fqu)) {
            this.fqu = getIntent().getStringExtra("sessionId");
            this.tjs = getIntent().getStringExtra("subSessionId");
            if (TextUtils.isEmpty(this.tjs)) {
                this.tjs = this.fqu;
            }
        }
    }

    protected final b bSM() {
        return this.tEf;
    }

    protected final MMWebView bSE() {
        c cVar;
        Intent intent = getIntent();
        if (intent != null) {
            this.tjB = intent.getIntExtra("key_preload_biz", -1);
            x.i("PreLoadWebViewUI", "getting preloaded  webview, biz %d", new Object[]{Integer.valueOf(this.tjB)});
            cVar = (c) d.bOL().zF(this.tjB).dL(this);
        } else {
            cVar = null;
        }
        MMWebView mMWebView = cVar == null ? null : (MMWebView) cVar.tjr;
        this.tEf = cVar == null ? null : cVar.tjt;
        if (mMWebView == null) {
            x.i("PreLoadWebViewUI", "no available preloaded webview");
            this.tEd = false;
            Object bSL = bSL();
            boolean z = !TextUtils.isEmpty(bSL) ? bh.VI(Uri.parse(bSL).getQueryParameter("isOpenPreload")) == 1 : false;
            if (z) {
                g.pQN.h(15005, new Object[]{Integer.valueOf(this.tjB), Integer.valueOf(4), Integer.valueOf(0)});
            }
            return super.bSE();
        }
        x.i("PreLoadWebViewUI", "use preloaded webview ,%s ", new Object[]{mMWebView.toString()});
        this.tEd = true;
        g.pQN.h(15005, new Object[]{Integer.valueOf(this.tjB), Integer.valueOf(3), Integer.valueOf(0)});
        return mMWebView;
    }

    public void akN() {
        super.akN();
        this.tEe.countDown();
        if (this.tlx == null || this.tlx.tGQ) {
            bTT();
        } else {
            this.tlx.a(new 1(this));
        }
        if (!com.tencent.mm.sdk.a.b.ceK()) {
            return;
        }
        if (this.tEd) {
            u.makeText(ac.getContext(), "use preloaded webview(安装coolassist时弹出)", 1).show();
        } else {
            u.makeText(ac.getContext(), "no preloaded webview(安装coolassist时弹出)", 1).show();
        }
    }

    private void bTT() {
        if (this.tEd) {
            new Thread(new Runnable(this) {
                final /* synthetic */ PreLoadWebViewUI tEg;

                {
                    this.tEg = r1;
                }

                public final void run() {
                    try {
                        this.tEg.tEe.await();
                    } catch (Throwable e) {
                        x.printErrStackTrace("PreLoadWebViewUI", e, "", new Object[0]);
                    }
                    if (this.tEg.tEd) {
                        x.i("PreLoadWebViewUI", "send onUiInit to webview");
                        this.tEg.bTH();
                        this.tEg.tlx.al(this.tEg.bTU());
                    }
                }
            }).start();
        }
    }

    protected void onResume() {
        super.onResume();
        this.tEe.countDown();
    }

    protected final boolean bSN() {
        return this.tEd;
    }

    protected final void bSO() {
        this.tEd = false;
    }

    public final Map<String, Object> bTU() {
        Map<String, Object> emptyMap;
        Object bSL = bSL();
        if (TextUtils.isEmpty(bSL)) {
            emptyMap = Collections.emptyMap();
        } else {
            Map<String, Object> hashMap = new HashMap();
            Uri parse = Uri.parse(bSL);
            for (String str : parse.getQueryParameterNames()) {
                hashMap.put(str, parse.getQueryParameter(str));
            }
            emptyMap = hashMap;
        }
        Map bTK = bTK();
        if (bTK != null) {
            emptyMap.putAll(bTK);
        }
        x.i("PreLoadWebViewUI", "buildOnUiInitParams %s", new Object[]{emptyMap.toString()});
        return emptyMap;
    }

    protected Map<String, Object> bTK() {
        return null;
    }

    public int bTJ() {
        return 0;
    }

    protected void bTH() {
    }

    protected final void bTd() {
        g.pQN.h(15005, new Object[]{Integer.valueOf(this.tjB), Integer.valueOf(5), Integer.valueOf(0)});
    }
}
