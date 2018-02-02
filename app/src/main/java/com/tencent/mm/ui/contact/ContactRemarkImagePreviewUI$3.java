package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class ContactRemarkImagePreviewUI$3 implements OnItemClickListener {
    final /* synthetic */ ContactRemarkImagePreviewUI yRB;

    ContactRemarkImagePreviewUI$3(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI) {
        this.yRB = contactRemarkImagePreviewUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.yRB.mController.isTitleShowing()) {
            this.yRB.mController.hideTitleView();
        } else {
            this.yRB.mController.showTitleView();
        }
    }
}
