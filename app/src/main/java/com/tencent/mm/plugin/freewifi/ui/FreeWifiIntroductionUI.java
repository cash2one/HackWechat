package com.tencent.mm.plugin.freewifi.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiIntroductionUI extends MMActivity {
    private int cOY;
    private Button mGq;
    private Button mHK;
    private Button mHL;
    private CheckBox mHM;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.mHK = (Button) findViewById(R.h.bYT);
        this.mHM = (CheckBox) findViewById(R.h.bJF);
        this.mGq = (Button) findViewById(R.h.coz);
        this.mHL = (Button) findViewById(R.h.cUd);
        this.cOY = getIntent().getIntExtra("free_wifi_source", 1);
        if (this.cOY == 3) {
            setMMTitle(R.l.evg);
            ((TextView) findViewById(R.h.cjy)).setText(R.l.eve);
            ((TextView) findViewById(R.h.cjt)).setText(R.l.evd);
            this.mGq.setVisibility(8);
        } else {
            setMMTitle(R.l.ekc);
        }
        setBackBtn(new 1(this));
        this.mHK.setOnClickListener(new 2(this));
        this.mHM.setOnCheckedChangeListener(new 3(this));
        this.mHL.setOnClickListener(new 4(this));
        this.mGq.setOnClickListener(new 5(this));
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.diz;
    }
}
