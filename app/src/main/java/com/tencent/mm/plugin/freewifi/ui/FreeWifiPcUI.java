package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.r;

public class FreeWifiPcUI extends MMActivity {
    private String appId;
    private String frP;
    private Button krY;
    private String mFc;
    private Button mHm;
    private String mHs;
    private TextView mIj;
    private int mIk;
    private r mIl = null;

    static /* synthetic */ void a(FreeWifiPcUI freeWifiPcUI, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.putExtra("free_wifi_error_ui_error_msg_detail1", str2);
        intent.setClass(freeWifiPcUI, FreeWifiErrorUI.class);
        freeWifiPcUI.finish();
        freeWifiPcUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ekc);
        setBackBtn(new 1(this));
        this.appId = getIntent().getStringExtra("free_wifi_appid");
        this.mIk = getIntent().getIntExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", 0);
        this.frP = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET");
        this.mFc = getIntent().getStringExtra("free_wifi_app_nickname");
        this.mHs = getIntent().getStringExtra("free_wifi_privacy_url");
        this.mIj = (TextView) findViewById(R.h.cjC);
        this.krY = (Button) findViewById(R.h.cjD);
        this.mIj.setText("由" + this.mFc + "提供");
        this.krY.setOnClickListener(new 2(this));
        this.mHm = (Button) findViewById(R.h.cjE);
        this.mHm.setOnClickListener(new 3(this));
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        g.ifs.i(new Intent(), this);
        finish();
    }

    protected final int getLayoutId() {
        return R.i.diD;
    }
}
