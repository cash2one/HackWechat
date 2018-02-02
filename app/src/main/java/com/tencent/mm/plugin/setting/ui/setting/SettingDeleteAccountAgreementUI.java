package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountAgreementUI extends MMActivity {
    protected final int getLayoutId() {
        return R.i.drU;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eKj);
        initView();
    }

    protected final void initView() {
        TextView textView = (TextView) findViewById(R.h.cAg);
        textView.setOnClickListener(new 1(this));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.h.bJI);
        checkedTextView.setOnClickListener(new 2(this, textView, checkedTextView));
        textView.setEnabled(checkedTextView.isChecked());
        setBackBtn(new 3(this));
    }
}
