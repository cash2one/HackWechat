package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class TopStoryVideoListUI$4 implements OnCancelListener {
    final /* synthetic */ TopStoryVideoListUI toU;

    TopStoryVideoListUI$4(TopStoryVideoListUI topStoryVideoListUI) {
        this.toU = topStoryVideoListUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.toU.finish();
    }
}
