package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.TextView;

class SettingDeleteAccountAgreementUI$2 implements OnClickListener {
    final /* synthetic */ SettingDeleteAccountAgreementUI qhO;
    final /* synthetic */ TextView qhP;
    final /* synthetic */ CheckedTextView qhQ;

    SettingDeleteAccountAgreementUI$2(SettingDeleteAccountAgreementUI settingDeleteAccountAgreementUI, TextView textView, CheckedTextView checkedTextView) {
        this.qhO = settingDeleteAccountAgreementUI;
        this.qhP = textView;
        this.qhQ = checkedTextView;
    }

    public final void onClick(View view) {
        this.qhP.setEnabled(this.qhQ.isChecked());
    }
}
