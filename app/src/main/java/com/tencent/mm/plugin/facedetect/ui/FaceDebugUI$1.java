package com.tencent.mm.plugin.facedetect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FaceDebugUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FaceDebugUI miE;

    FaceDebugUI$1(FaceDebugUI faceDebugUI) {
        this.miE = faceDebugUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.miE.finish();
        return false;
    }
}
