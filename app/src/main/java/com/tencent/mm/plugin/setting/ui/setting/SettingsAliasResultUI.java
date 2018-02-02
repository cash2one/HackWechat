package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class SettingsAliasResultUI extends MMActivity {
    private String gfN;
    private TextView iir;
    private TextView qiT;
    private Button qiU;
    private ImageView qiV;
    private boolean qiW;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.Hg();
        this.gfN = (String) c.CU().get(42, null);
        this.qiW = Boolean.valueOf(getIntent().getBooleanExtra("has_pwd", true)).booleanValue();
        initView();
    }

    protected final int getLayoutId() {
        return R.i.drY;
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.evx);
        this.iir = (TextView) findViewById(R.h.caS);
        this.qiT = (TextView) findViewById(R.h.bJZ);
        this.qiU = (Button) findViewById(R.h.cLN);
        this.qiV = (ImageView) findViewById(R.h.cBD);
        setBackBtn(new 1(this));
        this.qiT.setText(this.gfN);
        if (this.qiW) {
            this.qiU.setVisibility(8);
            this.iir.setText(getString(R.l.evD));
        } else {
            this.qiU.setVisibility(0);
            this.iir.setText(getString(R.l.evC));
        }
        this.qiU.setOnClickListener(new 2(this));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }
}
