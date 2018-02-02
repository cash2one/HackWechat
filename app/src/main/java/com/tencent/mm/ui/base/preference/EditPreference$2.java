package com.tencent.mm.ui.base.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class EditPreference$2 implements OnClickListener {
    final /* synthetic */ EditPreference yii;

    EditPreference$2(EditPreference editPreference) {
        this.yii = editPreference;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (EditPreference.a(this.yii) != null) {
            EditPreference.a(this.yii).dismiss();
        }
    }
}
