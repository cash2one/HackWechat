package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.b;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.c;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.ajs;
import com.tencent.mm.protocal.c.arp;

class ExdeviceBindDeviceUI$f {
    final /* synthetic */ ExdeviceBindDeviceUI lSF;
    public boolean lSY;
    public int lSZ;
    public String lSh;
    public c lTa;
    public ExdeviceBindDeviceUI$d lTb;
    public ajr lTc;
    public ajs lTd;
    public int lTe;
    public arp lTf;
    public String lTg;

    private ExdeviceBindDeviceUI$f(ExdeviceBindDeviceUI exdeviceBindDeviceUI) {
        this.lSF = exdeviceBindDeviceUI;
        this.lSY = false;
        this.lSZ = b.lSQ;
    }

    public final String getKey() {
        if (this.lSZ == b.lSQ) {
            return this.lTb.lRh + this.lTb.lLS;
        }
        return this.lTa.bpq;
    }

    public final String aET() {
        if (this.lSZ != b.lSQ) {
            return this.lTa.bpq;
        }
        if (this.lTd == null) {
            return null;
        }
        return this.lTd.vLs;
    }
}
