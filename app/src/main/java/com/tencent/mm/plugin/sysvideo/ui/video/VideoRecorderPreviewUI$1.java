package com.tencent.mm.plugin.sysvideo.ui.video;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class VideoRecorderPreviewUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ VideoRecorderPreviewUI rZP;

    VideoRecorderPreviewUI$1(VideoRecorderPreviewUI videoRecorderPreviewUI) {
        this.rZP = videoRecorderPreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rZP.finish();
        this.rZP.overridePendingTransition(0, 0);
        return true;
    }
}
