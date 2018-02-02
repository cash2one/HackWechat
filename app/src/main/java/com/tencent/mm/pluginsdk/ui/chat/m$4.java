package com.tencent.mm.pluginsdk.ui.chat;

import android.view.MotionEvent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ui.base.HorizontalListView.a;

class m$4 implements a {
    final /* synthetic */ m vrP;

    m$4(m mVar) {
        this.vrP = mVar;
    }

    public final boolean q(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.vrP.mHandler.sendEmptyMessage(20002);
                break;
            case 1:
            case 3:
                this.vrP.mHandler.sendEmptyMessageDelayed(CdnLogic.kMediaTypeBackupFile, 3000);
                break;
        }
        return false;
    }
}
