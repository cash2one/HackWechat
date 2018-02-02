package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.ag;

class MMSightRecordViewTestUI$4 implements OnClickListener {
    final /* synthetic */ MMSightRecordViewTestUI oBx;

    MMSightRecordViewTestUI$4(MMSightRecordViewTestUI mMSightRecordViewTestUI) {
        this.oBx = mMSightRecordViewTestUI;
    }

    public final void onClick(View view) {
        MMSightRecordViewTestUI.a(this.oBx).oqX.vr();
        ag.h(new 1(this), 5000);
    }
}
