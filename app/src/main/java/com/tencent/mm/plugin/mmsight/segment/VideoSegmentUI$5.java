package com.tencent.mm.plugin.mmsight.segment;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class VideoSegmentUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ VideoSegmentUI ozX;

    VideoSegmentUI$5(VideoSegmentUI videoSegmentUI) {
        this.ozX = videoSegmentUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ozX.finish();
        VideoSegmentUI.b(this.ozX);
        return true;
    }
}
