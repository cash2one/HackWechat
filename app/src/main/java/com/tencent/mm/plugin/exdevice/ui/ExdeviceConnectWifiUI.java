package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.MulticastLock;
import android.os.Bundle;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.bm.d;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.exdevice.d.b;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class ExdeviceConnectWifiUI extends MMActivity {
    private TextWatcher XD;
    private long lTA;
    boolean lTB = false;
    private b lTC;
    private int lTD;
    private n lTE;
    private a lTF;
    private MulticastLock lTG;
    private Runnable lTH = new 1(this);
    private View lTh;
    private TextView lTi;
    private View lTj;
    private EditText lTk;
    private View lTl;
    private r lTm;
    private WifiInfo lTn;
    private com.tencent.mm.plugin.exdevice.d.a lTo;
    private String lTp;
    private boolean lTq;
    private boolean lTr;
    private boolean lTs;
    private int lTt;
    private byte[] lTu;
    private int lTv;
    private int lTw;
    private int lTx;
    private String lTy = "";
    private int lTz;
    private String lyx = "";

    static /* synthetic */ void a(ExdeviceConnectWifiUI exdeviceConnectWifiUI, WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            x.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "WifiInfo is null.");
            return;
        }
        exdeviceConnectWifiUI.lTB = true;
        exdeviceConnectWifiUI.lTA = System.currentTimeMillis();
        exdeviceConnectWifiUI.pg(3);
        String password = exdeviceConnectWifiUI.getPassword();
        String ssid = wifiInfo.getSSID();
        x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "SSID = %s", new Object[]{ssid});
        if (bh.ov(ssid)) {
            x.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Error parameter: aSSID is null or nil");
            ssid = "";
        } else {
            ssid = ssid.replaceAll("\"", "");
        }
        x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "do start AirKiss, ssid(%s).", new Object[]{ssid});
        if (bh.ov(ssid)) {
            x.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid is invalid");
            Toast.makeText(exdeviceConnectWifiUI.mController.xIM, "SSID is invalid", 0).show();
            return;
        }
        exdeviceConnectWifiUI.ph(b.lTU);
        ar.Dm().F(new 2(exdeviceConnectWifiUI, password, ssid, wifiInfo));
    }

    static /* synthetic */ void q(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        if (exdeviceConnectWifiUI.lTn == null) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "wifiInfo is null.");
            return;
        }
        String ssid = exdeviceConnectWifiUI.lTn.getSSID();
        String ou = bh.ou(exdeviceConnectWifiUI.getPassword());
        if (bh.ov(ssid)) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid is null or nil.");
            return;
        }
        if (bh.ov(exdeviceConnectWifiUI.lTo.lOe) || (ssid.equals(exdeviceConnectWifiUI.lTo.lOe) && !ou.equals(exdeviceConnectWifiUI.lTo.lOf))) {
            com.tencent.mm.plugin.exdevice.d.a W = exdeviceConnectWifiUI.W(exdeviceConnectWifiUI.lTt, ssid);
            if (W == null) {
                W = new com.tencent.mm.plugin.exdevice.d.a();
                W.lOe = ssid;
                W.lOd = exdeviceConnectWifiUI.lTt;
                exdeviceConnectWifiUI.lTC.lOg.add(W);
            }
            W.lOf = com.tencent.mm.plugin.base.model.b.bI(ou, a.X(exdeviceConnectWifiUI.lTt, ssid));
        } else if (!exdeviceConnectWifiUI.lTq) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "password hasn't changed, so do not need to save.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        ssid = stringBuilder.append(c.FC()).append("exdevice_wifi_infos").toString();
        try {
            byte[] toByteArray = exdeviceConnectWifiUI.lTC.toByteArray();
            e.b(ssid, toByteArray, toByteArray.length);
        } catch (Throwable e) {
            x.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", e.getMessage());
            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", e, "", new Object[0]);
        }
        x.v("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Current wifiInfo was save to file(%s).", new Object[]{ssid});
    }

    static /* synthetic */ void r(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        Java2CExDevice.stopAirKiss();
        exdeviceConnectWifiUI.eJ(true);
        if (exdeviceConnectWifiUI.lTG.isHeld()) {
            exdeviceConnectWifiUI.lTG.release();
        }
    }

    protected final int getLayoutId() {
        return R.i.dgI;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lTE = new 8(this);
        this.lTD = b.lTS;
        if (ar.Hj()) {
            this.lTC = new b();
            this.lTo = new com.tencent.mm.plugin.exdevice.d.a();
            ar.Hg();
            this.lTt = c.Cg();
            String stringExtra = getIntent().getStringExtra("encryptKey");
            this.lTv = getIntent().getIntExtra("procInterval", 0);
            this.lTw = getIntent().getIntExtra("dataInterval", 0);
            x.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Process interval:" + this.lTv + " Data interval:" + this.lTw);
            if (!bh.ov(stringExtra)) {
                this.lTu = Base64.decode(stringExtra, 0);
                this.lTz = 1;
            }
            this.lTB = false;
            this.lTx = getIntent().getExtras().getInt("exdevice_airkiss_open_type");
            if (this.lTx == 2) {
                this.lTy = getIntent().getStringExtra("device_brand_name");
                this.lyx = getIntent().getStringExtra("device_category_id");
            }
            this.lTF = new 9(this);
            j.aEb().a(0, this.lTF);
            initView();
            ar.Dm().F(new 3(this));
            pg(1);
            this.lTG = ((WifiManager) getSystemService("wifi")).createMulticastLock("localWifi");
            return;
        }
        finish();
    }

    protected void onResume() {
        super.onResume();
        eJ(false);
        ar.a(this.lTE);
        if (this.lTr) {
            aEU();
            this.lTr = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!this.lTB) {
            pg(2);
        }
        j.aEb().b(0, this.lTF);
    }

    protected void onStop() {
        super.onStop();
        ar.b(this.lTE);
    }

    protected final void initView() {
        setMMTitle(R.l.dgI);
        setBackBtn(new 10(this));
        this.lTh = findViewById(R.h.cLF);
        this.lTi = (TextView) findViewById(R.h.cyA);
        this.lTj = findViewById(R.h.bJX);
        this.lTk = (EditText) findViewById(R.h.cCm);
        this.lTl = findViewById(R.h.bXb);
        this.XD = new 11(this);
        this.lTh.setOnTouchListener(new 12(this));
        this.lTl.setOnClickListener(new 13(this));
        this.lTk.setTransformationMethod(new PasswordTransformationMethod());
        this.lTk.addTextChangedListener(this.XD);
        this.lTk.setOnEditorActionListener(new 14(this));
        this.lTk.setOnKeyListener(new 15(this));
        this.lTk.requestFocus();
    }

    private void pg(int i) {
        long j = 0;
        if (i == 4) {
            j = System.currentTimeMillis() - this.lTA;
        }
        g.pQN.h(13503, new Object[]{Integer.valueOf(i), Integer.valueOf(this.lTx), Long.valueOf(j), this.lTy, this.lyx, Integer.valueOf(this.lTz)});
    }

    private com.tencent.mm.plugin.exdevice.d.a W(int i, String str) {
        if (bh.ov(str) || this.lTC == null) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid or wifiInfoList is null or nil.");
            return null;
        }
        int i2 = 0;
        while (i2 < this.lTC.lOg.size()) {
            com.tencent.mm.plugin.exdevice.d.a aVar = (com.tencent.mm.plugin.exdevice.d.a) this.lTC.lOg.get(i2);
            if (aVar == null) {
                int i3 = i2 - 1;
                this.lTC.lOg.remove(i2);
                this.lTq = true;
                i2 = i3;
            } else if (aVar.lOd == i && str.equals(aVar.lOe)) {
                return aVar;
            }
            i2++;
        }
        return null;
    }

    private void aEU() {
        if (this.lTn == null) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "wifiInfo is null, delay to fill.");
            this.lTr = true;
            return;
        }
        this.lTo.lOf = "";
        this.lTo.lOe = "";
        com.tencent.mm.plugin.exdevice.d.a W = W(this.lTt, this.lTn.getSSID());
        if (W == null) {
            return;
        }
        if (bh.ov(W.lOf)) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Do not have a local password to fill for the current wifi.");
            this.lTC.lOg.remove(W);
            this.lTq = true;
            return;
        }
        this.lTo.lOf = com.tencent.mm.plugin.base.model.b.bI(W.lOf, a.X(this.lTt, W.lOe));
        this.lTo.lOe = W.lOe;
        ag.y(this.lTH);
    }

    private String getPassword() {
        return this.lTk.getText() != null ? this.lTk.getText().toString() : null;
    }

    private void eJ(boolean z) {
        this.lTn = an.getWifiInfo(this);
        int i = z ? b.lTS : this.lTD;
        if (this.lTn == null) {
            i = b.lTT;
        } else {
            String ssid = this.lTn.getSSID();
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Get SSID(%s)", new Object[]{ssid});
            if (bh.ov(ssid)) {
                this.lTi.setText("");
            } else {
                this.lTi.setText(ssid.replaceAll("\"", ""));
            }
            if (!(bh.ov(ssid) || ssid.equals(this.lTp))) {
                this.lTp = ssid;
            }
        }
        ph(i);
    }

    public final synchronized void ph(int i) {
        if (i == 0) {
            x.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Status is null.");
        } else {
            this.lTD = i;
            switch (7.lTO[i - 1]) {
                case 1:
                    b(true, false, false);
                    break;
                case 2:
                    b(true, true, false);
                    break;
                case 3:
                    b(false, false, false);
                    break;
                case 4:
                    pg(5);
                    this.lTs = true;
                    setResult(1);
                    break;
                case 5:
                    pg(4);
                    b(true, false, true);
                    this.lTs = true;
                    setResult(-1);
                    ar.Dm().F(new 4(this));
                    if (getIntent().getBooleanExtra("jumpToBindDevice", false)) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", getIntent().getStringExtra("device_scan_mode"));
                        intent.putExtra("device_scan_conn_proto", getIntent().getStringExtra("device_scan_conn_proto"));
                        intent.putExtra("device_id", getIntent().getStringExtra("device_id"));
                        intent.putExtra("device_type", getIntent().getStringExtra("device_type"));
                        intent.putExtra("device_title", getIntent().getStringExtra("device_title"));
                        intent.putExtra("device_desc", getIntent().getStringExtra("device_desc"));
                        intent.putExtra("device_icon_url", getIntent().getStringExtra("device_icon_url"));
                        intent.putExtra("device_category_id", getIntent().getStringExtra("device_category_id"));
                        intent.putExtra("device_brand_name", getIntent().getStringExtra("device_brand_name"));
                        intent.putExtra("bind_ticket", getIntent().getStringExtra("bind_ticket"));
                        d.b(this.mController.xIM, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                        break;
                    }
                    break;
            }
            finish();
            if (i != b.lTS) {
                this.lTk.clearFocus();
                aWs();
            }
        }
    }

    private void b(boolean z, boolean z2, boolean z3) {
        this.lTh.setVisibility(z ? 0 : 8);
        if (z2) {
            runOnUiThread(new 5(this));
        } else {
            runOnUiThread(new 6(this));
            if (this.lTG.isHeld()) {
                this.lTG.release();
            }
        }
        if (z3) {
            Toast.makeText(this.mController.xIM, R.l.ecQ, 0).show();
        }
    }
}
