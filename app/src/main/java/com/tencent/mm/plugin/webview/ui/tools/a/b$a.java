package com.tencent.mm.plugin.webview.ui.tools.a;

import android.os.Bundle;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.g.a.la;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class b$a {
    private e fBH = null;
    private String frn = "";
    public c qsg = new 5(this);
    public c tBR = new 3(this);
    public c tCb = new 1(this);
    public c tCc = new 2(this);
    public c tCd = new 4(this);

    public b$a(e eVar, String str) {
        this.fBH = eVar;
        this.frn = str;
    }

    final boolean h(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (this.fBH == null) {
            x.e("MicroMsg.webview.WebViewExDeviceMgr", "callbacker is null");
            return false;
        }
        try {
            Bundle bundle;
            if (bVar instanceof dt) {
                x.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnScanDeviceResultEvent");
                dt dtVar = (dt) bVar;
                bundle = new Bundle();
                bundle.putString("exdevice_device_id", dtVar.fsr.ffq);
                bundle.putByteArray("exdevice_broadcast_data", dtVar.fsr.fsj);
                bundle.putBoolean("exdevice_is_complete", dtVar.fsr.aow);
                this.fBH.n(15, bundle);
            } else if (bVar instanceof ds) {
                x.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnRecvDataFromDeviceEvent");
                ds dsVar = (ds) bVar;
                if (bh.ov(dsVar.fsq.ffq) || bh.ov(dsVar.fsq.frn) || dsVar.fsq.data == null) {
                    return true;
                }
                bundle = new Bundle();
                bundle.putString("exdevice_device_id", dsVar.fsq.ffq);
                bundle.putByteArray("exdevice_data", dsVar.fsq.data);
                bundle.putString("exdevice_brand_name", dsVar.fsq.frn);
                this.fBH.n(16, bundle);
            } else if (bVar instanceof dr) {
                x.d("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnDeviceBindStateChangeEvent");
                dr drVar = (dr) bVar;
                if (bh.ov(drVar.fsp.ffq)) {
                    return true;
                }
                bundle = new Bundle();
                bundle.putString("exdevice_device_id", drVar.fsp.ffq);
                bundle.putBoolean("exdevice_is_bound", drVar.fsp.frk);
                this.fBH.n(17, bundle);
            } else if (bVar instanceof la) {
                la laVar = (la) bVar;
                if (laVar.fCm.op != 2) {
                    return true;
                }
                if (bh.ov(laVar.fCm.fzF) || !this.frn.equals(laVar.fCm.fzF)) {
                    return true;
                }
                bundle = new Bundle();
                bundle.putString("exdevice_device_id", laVar.fCm.ffq);
                bundle.putInt("exdevice_on_state_change_state", laVar.fCm.fsg);
                this.fBH.n(1004, bundle);
            } else if (bVar instanceof dq) {
                dq dqVar = (dq) bVar;
                bundle = new Bundle();
                if (dqVar.fsn.fso == 12) {
                    bundle.putBoolean("exdevice_bt_state", true);
                } else {
                    bundle.putBoolean("exdevice_bt_state", false);
                }
                this.fBH.n(18, bundle);
            }
        } catch (Exception e) {
            x.w("MicroMsg.webview.WebViewExDeviceMgr", "exception in WVExDeviceEventListener callback, %s", e.getMessage());
        }
        return true;
    }
}
