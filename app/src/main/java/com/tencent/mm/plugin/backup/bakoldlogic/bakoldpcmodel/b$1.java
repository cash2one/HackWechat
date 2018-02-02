package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.a.n;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$1 implements Runnable {
    final /* synthetic */ int iGh;
    final /* synthetic */ b kqA;
    final /* synthetic */ List kqz;

    b$1(b bVar, int i, List list) {
        this.kqA = bVar;
        this.iGh = i;
        this.kqz = list;
    }

    public final void run() {
        switch (this.iGh) {
            case 0:
                b.a(this.kqA, ((Integer) ((ov) this.kqz.get(0)).vXH.getFirst()).intValue());
                return;
            case 1:
                WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
                int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
                DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
                if (dhcpInfo != null) {
                    int i = dhcpInfo.netmask;
                    String str = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
                    x.e("MicroMsg.BakOldJavaEngine", "localip:%s, mask:%d", str, Integer.valueOf(i));
                    String str2 = null;
                    int i2 = 0;
                    for (ov ovVar : this.kqz) {
                        x.i("MicroMsg.BakOldJavaEngine", "try ip:%s", ovVar.vXG);
                        if (ovVar.vXG != null) {
                            if (ovVar.vXG.split("\\.").length >= 4) {
                                int u = n.u(new byte[]{(byte) (bh.getInt(ovVar.vXG.split("\\.")[0], 0) & 255), (byte) (bh.getInt(ovVar.vXG.split("\\.")[1], 0) & 255), (byte) (bh.getInt(ovVar.vXG.split("\\.")[2], 0) & 255), (byte) (bh.getInt(ovVar.vXG.split("\\.")[3], 0) & 255)});
                                if ((i & u) == (i & ipAddress)) {
                                    b.a(this.kqA, ovVar.vXG, ((Integer) ovVar.vXH.getFirst()).intValue());
                                    return;
                                }
                                String str3;
                                int intValue;
                                if ((u & 65535) == (65535 & ipAddress)) {
                                    str3 = ovVar.vXG;
                                    intValue = ((Integer) ovVar.vXH.getFirst()).intValue();
                                } else {
                                    intValue = i2;
                                    str3 = str2;
                                }
                                str2 = str3;
                                i2 = intValue;
                            } else {
                                continue;
                            }
                        }
                    }
                    if (str2 != null) {
                        x.w("MicroMsg.BakOldJavaEngine", "try to connect to secondary:%s, port:%d", str2, Integer.valueOf(i2));
                        b.a(this.kqA, str2, i2);
                        return;
                    }
                    b.a(this.kqA, 10009, String.format("not match ip mask:%d, localip:%s", new Object[]{Integer.valueOf(i), str}).getBytes());
                    x.e("MicroMsg.BakOldJavaEngine", "not match ip mask:%d, localip:%s", Integer.valueOf(i), str);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
