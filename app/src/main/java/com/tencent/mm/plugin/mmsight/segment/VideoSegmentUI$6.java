package com.tencent.mm.plugin.mmsight.segment;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class VideoSegmentUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ VideoSegmentUI ozX;

    VideoSegmentUI$6(VideoSegmentUI videoSegmentUI) {
        this.ozX = videoSegmentUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        VideoSegmentUI.c(this.ozX);
        return true;
    }
}
