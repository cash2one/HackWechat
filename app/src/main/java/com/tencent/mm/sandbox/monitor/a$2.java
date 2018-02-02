package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements Runnable {
    final /* synthetic */ String gIT;
    final /* synthetic */ String mpO;
    final /* synthetic */ int sfa;
    final /* synthetic */ String sfb;
    final /* synthetic */ PByteArray sfc;

    a$2(int i, String str, String str2, String str3, PByteArray pByteArray) {
        this.sfa = i;
        this.sfb = str;
        this.mpO = str2;
        this.gIT = str3;
        this.sfc = pByteArray;
    }

    public final void run() {
        StringBuilder append = new StringBuilder().append("http://" + ac.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com")).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(d.vAz)).append("&devicetype=").append(d.DEVICE_TYPE).append("&filelength=").append(this.sfa).append("&sum=").append(this.sfb).append("&reporttype=1&NewReportType=").append(bh.e((Integer) a.gJg.get(this.mpO)));
        if (!(this.gIT == null || this.gIT.equals(""))) {
            append.append("&username=").append(this.gIT);
        }
        x.d("MicroMsg.CrashUpload", "dkcrash sb:" + append.toString());
        a.v(append.toString(), this.sfc.value);
    }
}
