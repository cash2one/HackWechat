package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(7)
public class WebSearchVoiceUI extends WebSearchBaseActivity {
    private String fqu;
    private com.tencent.mm.pluginsdk.ui.websearch.a tEN;
    private View tEO;
    private String tjs;

    protected final int getLayoutId() {
        return R.i.dua;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.fqu = getIntent().getStringExtra("sessionId");
            this.tjs = getIntent().getStringExtra("subSessionId");
        }
        this.tEO = findViewById(R.h.cXg);
        this.mController.hideTitleView();
        if (this.tEN == null) {
            this.tEN = new com.tencent.mm.pluginsdk.ui.websearch.a(this.mController.xIM);
            this.tEN.vzs = new 1(this);
        }
        this.tEN.ccc();
        com.tencent.mm.pluginsdk.ui.websearch.a aVar = this.tEN;
        x.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", new Object[]{Integer.valueOf(aVar.vpp), Boolean.valueOf(aVar.vsw)});
        if (aVar.vsw) {
            aVar.vsw = false;
            View findViewById = aVar.findViewById(R.h.cWs);
            LayoutParams layoutParams = findViewById.getLayoutParams();
            int i = aVar.vpp;
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, i);
            }
            layoutParams.height = i;
            findViewById.setLayoutParams(layoutParams);
            aVar.cce();
            aVar.requestLayout();
        }
        this.tEN.setVisibility(0);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        ((ViewGroup) findViewById(R.h.cIu)).addView(this.tEN, layoutParams2);
        g.pQN.h(15178, new Object[]{Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()), "", this.fqu, this.tjs});
    }

    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.tEN != null) {
            this.tEN.destroy();
        }
    }
}
