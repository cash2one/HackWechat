package com.tencent.mm.ui.base.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;

class EditPreference$1 implements OnClickListener {
    final /* synthetic */ EditText yih;
    final /* synthetic */ EditPreference yii;

    EditPreference$1(EditPreference editPreference, EditText editText) {
        this.yii = editPreference;
        this.yih = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (EditPreference.a(this.yii) != null) {
            EditPreference.a(this.yii).dismiss();
        }
        this.yii.value = this.yih.getText().toString();
        if (EditPreference.b(this.yii) != null) {
            EditPreference.b(this.yii).cqm();
        }
        if (EditPreference.c(this.yii) != null) {
            EditPreference.c(this.yii).a(this.yii, EditPreference.d(this.yii));
        }
    }
}
