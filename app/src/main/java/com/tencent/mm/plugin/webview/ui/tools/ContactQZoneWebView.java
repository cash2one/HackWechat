package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public class ContactQZoneWebView extends WebViewUI {
    private String pes = "";
    private boolean tvZ = false;
    private String twa = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(getString(R.l.dVR));
        this.ptK.setWebViewClient(new 1(this));
        this.ptK.loadUrl(this.fIG);
        x.d("MicroMsg.ContactQZoneWebView", "loadUrl:loadUrl, url = " + this.fIG);
    }

    protected void onResume() {
        super.onResume();
        this.tvZ = false;
    }

    final void OY(String str) {
        if (!this.tvZ) {
            this.tvZ = true;
            String substring = str.substring(19);
            x.d("MicroMsg.ContactQZoneWebView", "get url :" + substring);
            Intent intent = new Intent();
            intent.putExtra("nowUrl", substring);
            intent.putExtra("tweetid", bh.ou(getIntent().getStringExtra("tweetid")));
            intent.putExtra("htmlData", this.twa);
            intent.putExtra(DownloadSettingTable$Columns.TYPE, getIntent().getIntExtra(DownloadSettingTable$Columns.TYPE, 0));
            Bundle bundle = new Bundle();
            bundle.putInt("stat_scene", 4);
            bundle.putString("stat_url", aPk());
            intent.putExtra("_stat_obj", bundle);
            startActivity(intent);
            a.ifs.t(intent, this);
        }
    }
}
