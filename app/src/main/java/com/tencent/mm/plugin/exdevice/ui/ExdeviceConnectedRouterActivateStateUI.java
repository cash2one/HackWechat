package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.c.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;

public class ExdeviceConnectedRouterActivateStateUI extends MMActivity {
    private String appId;
    private String ffq;
    private String frg;
    private String lKs;
    private final int lTY = 90000;
    private ExdeviceConnectedRouterStateView lTZ;
    private TextView lUa;
    private TextView lUb;
    private b<a> lUc = new 1(this);
    private String ssid;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.ConnectedRouterActivateStateUi", "create activity");
        setMMTitle(R.l.ecY);
        setBackBtn(new 2(this));
        this.lTZ = (ExdeviceConnectedRouterStateView) findViewById(R.h.ceY);
        this.lUa = (TextView) findViewById(R.h.ceX);
        this.lUb = (TextView) findViewById(R.h.ceZ);
        try {
            Uri parse = Uri.parse(getIntent().getStringExtra("key_connected_router"));
            this.ffq = parse.getQueryParameter("deviceid");
            this.frg = parse.getQueryParameter("devicetype");
            this.lKs = parse.getQueryParameter(ClientInfoTable.TABLE_NAME);
            this.appId = parse.getQueryParameter("appid");
            if (bh.ov(this.ffq) || bh.ov(this.frg) || bh.ov(this.lKs) || bh.ov(this.appId)) {
                x.e("MicroMsg.ConnectedRouterActivateStateUi", "loss param %s", new Object[]{parse.toString()});
                finish();
            }
            this.ssid = parse.getQueryParameter("ssid");
            x.d("MicroMsg.ConnectedRouterActivateStateUi", "uri: %s, deviceid: %s, devicetype: %s, clientinfo: %s. ssid: %s", new Object[]{parse.toString(), this.ffq, this.frg, this.lKs, this.ssid});
            if (this.ssid == null) {
                this.ssid = "";
            }
        } catch (Exception e) {
            x.d("MicroMsg.ConnectedRouterActivateStateUi", e.toString());
        }
        pi(1);
        ar.CG().a(new a(this.ffq, this.frg, this.lKs, this.appId, this.lUc), 0);
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
    }

    protected final void pi(int i) {
        this.lTZ.setOnClickListener(null);
        x.d("MicroMsg.ConnectedRouterActivateStateUi", "Current connection state : %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.lTZ.setImageResource(R.k.dyd);
                this.lTZ.setState(1);
                this.lUa.setText(R.l.ecS);
                return;
            case 2:
                this.lTZ.setImageResource(R.k.dye);
                this.lTZ.setState(2);
                this.lUa.setText(getString(R.l.ecW, new Object[]{this.ssid}));
                addTextOptionMenu(0, getString(R.l.ecR), new 3(this));
                return;
            case 3:
                this.lTZ.setImageResource(R.k.dyc);
                this.lTZ.setState(3);
                this.lTZ.lUf = 2;
                this.lUa.setText(R.l.ecT);
                this.lUb.setText(getString(R.l.ecU, new Object[]{this.ssid}));
                return;
            case 4:
                this.lTZ.setImageResource(R.k.dyc);
                this.lTZ.setState(3);
                this.lTZ.lUf = 2;
                this.lUa.setText(R.l.ecT);
                this.lUb.setText(getString(R.l.ecV));
                return;
            case 5:
                this.lTZ.setImageResource(R.k.dyc);
                this.lTZ.setState(3);
                this.lTZ.lUf = 2;
                this.lUa.setText(R.l.ecT);
                this.lUb.setText(getString(R.l.ecX));
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dgJ;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        aEW();
        return true;
    }

    private void aEW() {
        finish();
        Intent intent = new Intent();
        intent.putExtra("From_fail_notify", true);
        x.d("MicroMsg.ConnectedRouterActivateStateUi", "startMainUI");
        d.a(this, "com.tencent.mm.ui.LauncherUI", intent);
    }
}
