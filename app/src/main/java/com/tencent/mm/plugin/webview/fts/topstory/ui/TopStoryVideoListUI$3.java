package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class TopStoryVideoListUI$3 implements OnClickListener {
    final /* synthetic */ TopStoryVideoListUI toU;

    TopStoryVideoListUI$3(TopStoryVideoListUI topStoryVideoListUI) {
        this.toU = topStoryVideoListUI;
    }

    public final void onClick(View view) {
        if (TopStoryVideoListUI.g(this.toU) != null) {
            TopStoryVideoListUI.g(this.toU);
            if (!e.aeG()) {
                x.i("MicroMsg.WebSearch.TopStoryVideoListUI", "list consume back btn");
                return;
            }
        }
        this.toU.finish();
    }
}
