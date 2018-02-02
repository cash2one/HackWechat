package com.tencent.mm.plugin.safedevice.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMWizardActivity;

public class BindSafeDeviceUI extends MMWizardActivity {
    protected final int getLayoutId() {
        return R.i.drx;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.eGA);
        setBackBtn(new 1(this));
        ((ImageView) findViewById(R.h.cKs)).setImageResource(R.k.duN);
        ((TextView) findViewById(R.h.cKt)).setText(R.l.eGG);
        ((TextView) findViewById(R.h.cRU)).setText(R.l.eGH);
        findViewById(R.h.cRU).setOnClickListener(new 2(this));
    }
}
