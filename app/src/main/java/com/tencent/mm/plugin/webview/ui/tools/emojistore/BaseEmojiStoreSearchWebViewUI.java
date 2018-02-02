package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.os.Bundle;
import android.view.Menu;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.56;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;

public class BaseEmojiStoreSearchWebViewUI extends WebViewUI implements b {
    String fDj;
    private p kFi;
    private boolean tBI;
    private boolean tBJ = true;
    private int tBK;
    private int type;

    protected final void akN() {
        super.akN();
        this.fDj = getIntent().getStringExtra("keyword");
        this.type = getIntent().getIntExtra(DownloadSettingTable$Columns.TYPE, 0);
        this.tBI = getIntent().getBooleanExtra("showkeyboard", false);
        this.tBK = getIntent().getIntExtra("sence", 0);
        this.ptK.setWebViewClient(new a(this, (byte) 0));
        this.ptK.setOnTouchListener(new 1(this));
        this.kFi = new p();
        a(this.kFi);
        this.kFi.nu(false);
        this.kFi.zms = this;
        showOptionMenu(false);
        if (this.tAe != null) {
            this.tAe.kr(true);
        }
        this.ptK.setOnLongClickListener(new 2(this));
    }

    public final void Xs() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.kFi != null) {
            this.kFi.a(this, menu);
            this.kFi.setHint(getString(R.l.ead));
        }
        return true;
    }

    public final void Xr() {
        finish();
    }

    public final void oL(String str) {
        if (this.tBJ && bh.ov(str)) {
            this.tBJ = false;
            if (this.tBI) {
                this.kFi.cxy();
                showVKB();
                return;
            }
            ag.h(new 3(this), 500);
        }
    }

    public final boolean oK(String str) {
        if (str != null) {
            str = str.trim();
        }
        this.fDj = str;
        if (!bh.ov(str)) {
            this.fDj = str;
            this.handler.post(new 4(this));
            Bundle bundle = new Bundle();
            bundle.putInt(DownloadSettingTable$Columns.TYPE, this.type);
            bundle.putString("nextPageBuffer", "");
            bundle.putString("keyword", this.fDj);
            bundle.putInt("webview_instance_id", hashCode());
            bundle.putLong("searchID", this.tlx.bUt());
            try {
                if (this.juQ != null) {
                    this.juQ.q(1, bundle);
                } else {
                    x.e("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "invoker should not be null");
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", e, "doSearch", new Object[0]);
            }
        }
        aWs();
        String str2 = "";
        if (!bh.ov(str)) {
            str2 = str.replace(",", " ");
        }
        g.pQN.h(13054, new Object[]{Integer.valueOf(this.tBK), Integer.valueOf(1), str2});
        return false;
    }

    public final void Xt() {
        this.kFi.cxy();
        showVKB();
    }

    public final void Xu() {
    }

    protected void s(int i, Bundle bundle) {
        x.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 80001:
                String string = bundle.getString("emoji_store_json_data");
                boolean z = bundle.getBoolean("emoji_store_new_query", true);
                String string2 = bundle.getString("emoji_store_page_buf");
                long j = bundle.getLong("emoji_store_search_id");
                d dVar = this.tlx;
                if (dVar.tGQ) {
                    x.i("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData success, ready");
                    Map hashMap = new HashMap();
                    hashMap.put("json", string);
                    hashMap.put("newQuery", Boolean.valueOf(z));
                    hashMap.put("nextPageBuffer", string2);
                    x.d("MicroMsg.JsApiHandler", "cpan emoji set SearchID:%d", new Object[]{Long.valueOf(j)});
                    dVar.tHc = j;
                    x.i("MicroMsg.JsApiHandler", "event:%s", new Object[]{a.a("getSearchEmotionDataCallBack", hashMap, dVar.tGS, dVar.tGT)});
                    ag.y(new 56(dVar, string));
                    return;
                }
                x.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, not ready");
                return;
            case 80002:
                this.tlx.bUs();
                return;
            default:
                super.s(i, bundle);
                return;
        }
    }

    protected final void bSG() {
        finish();
    }

    protected final int getLayoutId() {
        return R.i.dgj;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final boolean bSW() {
        return true;
    }
}
