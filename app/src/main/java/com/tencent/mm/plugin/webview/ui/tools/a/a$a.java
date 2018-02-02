package com.tencent.mm.plugin.webview.ui.tools.a;

import android.os.Bundle;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class a$a {
    private e fBH = null;
    private String frn = "";
    public c tBR = new 1(this);
    public c tBS = new 2(this);
    public c tBT = new 3(this);
    public c tBU = new 4(this);
    public c tBV = new 5(this);

    public a$a(e eVar, String str) {
        this.fBH = eVar;
        this.frn = str;
    }

    final boolean h(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (this.fBH == null) {
            x.e("MicroMsg.webview.WebViewExDeviceLanMgr", "callbacker is null");
            return false;
        }
        try {
            Bundle bundle;
            if (bVar instanceof dr) {
                x.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceOnDeviceBindStateChangeEvent");
                dr drVar = (dr) bVar;
                if (bh.ov(drVar.fsp.ffq)) {
                    return true;
                }
                bundle = new Bundle();
                bundle.putString("exdevice_device_id", drVar.fsp.ffq);
                bundle.putBoolean("exdevice_is_bound", drVar.fsp.frk);
                this.fBH.n(17, bundle);
            } else if (bVar instanceof dl) {
                x.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceConnectStateEvent");
                dl dlVar = (dl) bVar;
                if (bh.ov(dlVar.fsf.ffq) || !this.frn.equals(dlVar.fsf.frn)) {
                    return true;
                }
                bundle = new Bundle();
                bundle.putString("exdevice_device_id", dlVar.fsf.ffq);
                bundle.putInt("exdevice_on_state_change_state", dlVar.fsf.fsg);
                bundle.putString("exdevice_device_type", a.bz());
                this.fBH.n(1004, bundle);
            } else if (bVar instanceof dm) {
                x.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceRecvDataEvent");
                dm dmVar = (dm) bVar;
                if (bh.ov(dmVar.fsh.ffq) || bh.ov(dmVar.fsh.frn) || dmVar.fsh.data == null) {
                    return true;
                }
                bundle = new Bundle();
                bundle.putString("exdevice_device_id", dmVar.fsh.ffq);
                bundle.putByteArray("exdevice_data", dmVar.fsh.data);
                bundle.putString("exdevice_brand_name", dmVar.fsh.frn);
                bundle.putString("exdevice_device_type", a.bz());
                this.fBH.n(16, bundle);
            } else if (bVar instanceof dn) {
                x.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceScanResultEvent");
                dn dnVar = (dn) bVar;
                bundle = new Bundle();
                bundle.putString("exdevice_device_id", dnVar.fsi.ffq);
                bundle.putByteArray("exdevice_broadcast_data", dnVar.fsi.fsj);
                bundle.putBoolean("exdevice_is_complete", dnVar.fsi.aow);
                bundle.putBoolean("exdevice_is_lan_device", true);
                bundle.putString("exdevice_device_type", a.bz());
                this.fBH.n(15, bundle);
            } else if (bVar instanceof do) {
                x.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceStateChangeEvent");
                do doVar = (do) bVar;
                bundle = new Bundle();
                if (doVar.fsk.fsl) {
                    bundle.putBoolean("exdevice_lan_state", true);
                } else {
                    bundle.putBoolean("exdevice_lan_state", false);
                }
                this.fBH.n(47, bundle);
            }
        } catch (Exception e) {
            x.w("MicroMsg.webview.WebViewExDeviceLanMgr", "exception in WVExDeviceEventListener callback, %s", new Object[]{e.getMessage()});
        }
        return true;
    }
}
