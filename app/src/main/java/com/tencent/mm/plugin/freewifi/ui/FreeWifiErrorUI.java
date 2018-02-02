package com.tencent.mm.plugin.freewifi.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiErrorUI extends MMActivity {
    private ImageView mHd;
    private TextView mHe;
    private TextView mHf;
    private TextView mHg;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ekc);
        this.mHd = (ImageView) findViewById(R.h.cjx);
        if (getIntent().getIntExtra("free_wifi_show_detail_error", 0) == 1) {
            this.mHd.setImageResource(R.g.bCi);
        }
        this.mHe = (TextView) findViewById(R.h.cjw);
        this.mHf = (TextView) findViewById(R.h.cju);
        this.mHg = (TextView) findViewById(R.h.cjv);
        CharSequence stringExtra = getIntent().getStringExtra("free_wifi_error_ui_error_msg");
        CharSequence stringExtra2 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail1");
        CharSequence stringExtra3 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail12");
        if (!m.AA(stringExtra)) {
            this.mHe.setText(stringExtra);
        }
        if (!m.AA(stringExtra2)) {
            this.mHf.setText(stringExtra2);
        }
        if (!m.AA(stringExtra3)) {
            this.mHg.setText(stringExtra3);
        }
        setBackBtn(new 1(this));
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.cjx;
    }
}
