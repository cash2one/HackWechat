package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.model.aj.m;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

class a$1 implements Runnable {
    final /* synthetic */ String trO;
    final /* synthetic */ d trP;
    final /* synthetic */ a trQ;

    public a$1(a aVar, String str, d dVar) {
        this.trQ = aVar;
        this.trO = str;
        this.trP = dVar;
    }

    public final void run() {
        Map y = bi.y(this.trO, "DNSAdvanceRelateDomain");
        LinkedList linkedList = new LinkedList();
        if (y != null && y.size() > 0) {
            String str;
            int i = 0;
            while (i < y.size()) {
                str = (String) y.get(".DNSAdvanceRelateDomain.RelateDomain" + (i == 0 ? "" : Integer.valueOf(i)) + ".$domain");
                if (bh.ov(str)) {
                    x.i("MicroMsg.DNSPreGetOptimize", "now break for main domain i = %d", new Object[]{Integer.valueOf(i)});
                    break;
                }
                if (!linkedList.contains(str)) {
                    linkedList.add(str);
                }
                i++;
            }
            int i2 = 0;
            while (true) {
                String str2 = (String) y.get(".DNSAdvanceRelateDomain.RelateDomain" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".Relate");
                str = (String) y.get(".DNSAdvanceRelateDomain.RelateDomain.Relate" + (i2 == 0 ? "" : Integer.valueOf(i2)));
                if (bh.ov(str2) && bh.ov(str)) {
                    break;
                }
                if (!(bh.ov(str2) || linkedList.contains(str2))) {
                    linkedList.add(str2);
                }
                if (!(bh.ov(str) || linkedList.contains(str))) {
                    linkedList.add(str);
                }
                i2++;
            }
            x.i("MicroMsg.DNSPreGetOptimize", "now break for releated domain j = %d", new Object[]{Integer.valueOf(i2)});
            m bQW = this.trQ.trN.bQW();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                InetAddress inetAddress;
                long currentTimeMillis;
                str = (String) it.next();
                long currentTimeMillis2 = System.currentTimeMillis();
                InetAddress inetAddress2 = null;
                try {
                    inetAddress2 = InetAddress.getByName(str);
                    x.i("MicroMsg.DNSPreGetOptimize", "get dns for domain : %s, cost time : %d", new Object[]{str, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                    inetAddress = inetAddress2;
                    currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                } catch (Exception e) {
                    x.e("MicroMsg.DNSPreGetOptimize", "get dns failed : %s", new Object[]{e.getMessage()});
                    inetAddress = inetAddress2;
                    currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                }
                try {
                    bQW.jHU = currentTimeMillis;
                    bQW.url = str;
                    if (inetAddress != null) {
                        bQW.fsH = true;
                    } else {
                        bQW.fsH = false;
                    }
                    d dVar = this.trP;
                    if (dVar != null) {
                        x.i("MicroMsg.WebviewReporter", "WebviewPreGetDNSReporter, netType = %d, costTime = %d, url = %s, isSuccess = %s", new Object[]{Integer.valueOf(aj.bQU()), Long.valueOf(bQW.jHU), bQW.url, Boolean.valueOf(bQW.fsH)});
                        String str3 = bQW.ttb;
                        Object[] objArr = new Object[11];
                        objArr[0] = Integer.valueOf(1);
                        objArr[1] = Long.valueOf(bQW.jHU);
                        objArr[2] = Integer.valueOf(an.getNetType(ac.getContext()));
                        objArr[3] = bQW.url == null ? bQW.url : bQW.url.replace(",", "!");
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(0);
                        objArr[6] = Integer.valueOf(0);
                        objArr[7] = Integer.valueOf(aj.mYb);
                        objArr[8] = Integer.valueOf(aj.tsS);
                        objArr[9] = Integer.valueOf(bQW.fMy);
                        objArr[10] = bQW.ttb;
                        aj.a(dVar, str3, objArr);
                        if (!bQW.fsH) {
                            g.pQN.a(32, 12, 1, true);
                        }
                        g.pQN.a(32, 1, 1, true);
                        g.pQN.a(32, 5, bQW.jHU, true);
                    }
                } catch (Exception e2) {
                    x.e("MicroMsg.DNSPreGetOptimize", "get dns failed 2 : %s", new Object[]{e2.getMessage()});
                    return;
                }
            }
        }
    }
}
