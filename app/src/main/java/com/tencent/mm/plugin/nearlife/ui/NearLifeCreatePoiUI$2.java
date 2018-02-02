package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class NearLifeCreatePoiUI$2 implements OnClickListener {
    final /* synthetic */ NearLifeCreatePoiUI oRe;

    NearLifeCreatePoiUI$2(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        this.oRe = nearLifeCreatePoiUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.oRe.mController.xIM, SelectPoiCategoryUI.class);
        this.oRe.startActivityForResult(intent, 2);
    }
}
