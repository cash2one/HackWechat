package com.tencent.mm.plugin.sysvideo.ui.video;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class VideoRecorderUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ VideoRecorderUI sao;

    VideoRecorderUI$6(VideoRecorderUI videoRecorderUI) {
        this.sao = videoRecorderUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        VideoRecorderUI.j(this.sao);
        return true;
    }
}
