package com.tencent.mm.plugin.freewifi.b;

import android.database.MatrixCursor;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ew;
import com.tencent.mm.plugin.freewifi.b.a.a;
import com.tencent.mm.plugin.freewifi.d.j;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.aqh;
import com.tencent.mm.protocal.c.aqi;
import com.tencent.mm.protocal.c.aqj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class c$1 implements e {
    final /* synthetic */ LinkedList mDI;
    final /* synthetic */ int mDJ;
    final /* synthetic */ ew mDK;
    final /* synthetic */ c mDL;

    c$1(c cVar, LinkedList linkedList, int i, ew ewVar) {
        this.mDL = cVar;
        this.mDI = linkedList;
        this.mDJ = i;
        this.mDK = ewVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        Exception e;
        synchronized (this.mDL) {
            aqh aMi = ((j) kVar).aMi();
            this.mDL.du(System.currentTimeMillis());
            this.mDL.pV(aMi.mDG <= 0 ? 180 : aMi.mDG);
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "resp.reqMaxApCount=" + aMi.mDF);
            int i3 = aMi.mDF <= 0 ? 200 : aMi.mDF;
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "_reqMaxApCount = " + i3);
            this.mDL.pU(i3);
            if (i == 0 && i2 == 0) {
                LinkedList linkedList = aMi.wxd;
                MatrixCursor matrixCursor = null;
                try {
                    MatrixCursor matrixCursor2 = new MatrixCursor(c.aI());
                    try {
                        Map hashMap = new HashMap();
                        for (int i4 = 0; i4 < linkedList.size(); i4++) {
                            aqj com_tencent_mm_protocal_c_aqj = (aqj) linkedList.get(i4);
                            hashMap.put(com_tencent_mm_protocal_c_aqj.ssid + "-" + com_tencent_mm_protocal_c_aqj.bssid, Integer.valueOf(i4));
                        }
                        for (int i5 = 0; i5 < this.mDI.size(); i5++) {
                            aqi com_tencent_mm_protocal_c_aqi = (aqi) this.mDI.get(i5);
                            aqj com_tencent_mm_protocal_c_aqj2 = new aqj();
                            com_tencent_mm_protocal_c_aqj2.ssid = com_tencent_mm_protocal_c_aqi.ssid;
                            com_tencent_mm_protocal_c_aqj2.bssid = com_tencent_mm_protocal_c_aqi.bssid;
                            com_tencent_mm_protocal_c_aqj2.ftq = com_tencent_mm_protocal_c_aqi.ftq;
                            com_tencent_mm_protocal_c_aqj2.wxe = 0;
                            com_tencent_mm_protocal_c_aqj2.wxf = null;
                            com_tencent_mm_protocal_c_aqj2.mCv = 0;
                            com_tencent_mm_protocal_c_aqj2.fpz = null;
                            if (hashMap.get(com_tencent_mm_protocal_c_aqj2.ssid + "-" + com_tencent_mm_protocal_c_aqj2.bssid) != null) {
                                Integer num = (Integer) hashMap.get(com_tencent_mm_protocal_c_aqj2.ssid + "-" + com_tencent_mm_protocal_c_aqj2.bssid);
                                if (linkedList.get(num.intValue()) != null) {
                                    com_tencent_mm_protocal_c_aqj2.wxe = ((aqj) linkedList.get(num.intValue())).wxe;
                                    com_tencent_mm_protocal_c_aqj2.wxf = ((aqj) linkedList.get(num.intValue())).wxf;
                                    com_tencent_mm_protocal_c_aqj2.mCv = ((aqj) linkedList.get(num.intValue())).mCv;
                                    com_tencent_mm_protocal_c_aqj2.fpz = ((aqj) linkedList.get(num.intValue())).fpz;
                                }
                            }
                            if (com_tencent_mm_protocal_c_aqj2.mCv == 4 || com_tencent_mm_protocal_c_aqj2.mCv == 31) {
                                matrixCursor2.addRow(new Object[]{com_tencent_mm_protocal_c_aqj2.ssid, com_tencent_mm_protocal_c_aqj2.bssid, Integer.valueOf(com_tencent_mm_protocal_c_aqj2.ftq), Integer.valueOf(com_tencent_mm_protocal_c_aqj2.wxe), com_tencent_mm_protocal_c_aqj2.wxf, Integer.valueOf(this.mDL.aLs()), Integer.valueOf(this.mDL.aLt())});
                                x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", com_tencent_mm_protocal_c_aqj2.ssid, com_tencent_mm_protocal_c_aqj2.bssid, Integer.valueOf(com_tencent_mm_protocal_c_aqj2.ftq), Integer.valueOf(com_tencent_mm_protocal_c_aqj2.wxe), com_tencent_mm_protocal_c_aqj2.wxf, Integer.valueOf(this.mDL.aLs()), Integer.valueOf(this.mDL.aLt()));
                                if (com_tencent_mm_protocal_c_aqj2.wxe == 1 && this.mDJ == 1) {
                                    a.aLp().c(com_tencent_mm_protocal_c_aqj2.ssid, com_tencent_mm_protocal_c_aqj2.bssid, com_tencent_mm_protocal_c_aqj2.fpz, com_tencent_mm_protocal_c_aqj2.mCv);
                                    x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cached : ssid=%s, bssid=%s, apKey=%s, protocolType=%d. ", com_tencent_mm_protocal_c_aqj2.ssid, com_tencent_mm_protocal_c_aqj2.bssid, com_tencent_mm_protocal_c_aqj2.fpz, Integer.valueOf(com_tencent_mm_protocal_c_aqj2.mCv));
                                }
                            } else {
                                matrixCursor2.addRow(new Object[]{com_tencent_mm_protocal_c_aqj2.ssid, com_tencent_mm_protocal_c_aqj2.bssid, Integer.valueOf(com_tencent_mm_protocal_c_aqj2.ftq), Integer.valueOf(0), null, Integer.valueOf(this.mDL.aLs()), Integer.valueOf(this.mDL.aLt())});
                                x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", com_tencent_mm_protocal_c_aqj2.ssid, com_tencent_mm_protocal_c_aqj2.bssid, Integer.valueOf(com_tencent_mm_protocal_c_aqj2.ftq), Integer.valueOf(0), null, Integer.valueOf(this.mDL.aLs()), Integer.valueOf(this.mDL.aLt()));
                            }
                        }
                        c.a(this.mDK, matrixCursor2);
                    } catch (Exception e2) {
                        e = e2;
                        matrixCursor = matrixCursor2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    if (matrixCursor != null) {
                        matrixCursor.close();
                    }
                    x.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", e);
                    c.a(this.mDL, this.mDK, 1108, "cursor exception.");
                }
            } else if (i2 == -30035) {
                c.a(this.mDL, this.mDK, 1110, "Too many ap. The number of ap requested per time should be between 1 and " + this.mDL.aLs() + ".");
            } else {
                c.a(this.mDL, this.mDK, 1121, "Server returns errtype= " + i + ", errcode=" + i2 + ", errMsg=" + m.AC(str) + ".");
            }
        }
    }
}
