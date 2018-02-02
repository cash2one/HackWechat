package com.tencent.mm.plugin.exdevice.model;

import android.util.Base64;
import com.tencent.mm.ae.d;
import com.tencent.mm.g.a.db;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.exdevice.b.k;
import com.tencent.mm.plugin.exdevice.b.k.c;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.i.g;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;
import java.util.Map;
import junit.framework.Assert;

class ad$8 implements a {
    final /* synthetic */ ad lNY;

    ad$8(ad adVar) {
        this.lNY = adVar;
    }

    public final void a(d.a aVar) {
        if (ad.aEq() != null) {
            Object obj;
            Map y;
            ad.aEq();
            bw bwVar = aVar.hmq;
            x.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer");
            String a = n.a(bwVar.vGZ);
            if (bh.ov(a)) {
                x.e("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "msg content is null");
            } else {
                Map y2 = bi.y(a, "sysmsg");
                if (y2 != null && y2.size() > 0) {
                    a = (String) y2.get(".sysmsg.$type");
                    if (!bh.ov(a) && a.equalsIgnoreCase("wcdevicemsg")) {
                        a = (String) y2.get(".sysmsg.wcdevicemsg.xml.ToUserName");
                        String str = (String) y2.get(".sysmsg.wcdevicemsg.xml.FromUserName");
                        long j = bh.getLong((String) y2.get(".sysmsg.wcdevicemsg.xml.CreateTime"), -1);
                        String str2 = (String) y2.get(".sysmsg.wcdevicemsg.xml.MsgType");
                        String str3 = (String) y2.get(".sysmsg.wcdevicemsg.xml.DeviceType");
                        String str4 = (String) y2.get(".sysmsg.wcdevicemsg.xml.DeviceID");
                        int i = bh.getInt((String) y2.get(".sysmsg.wcdevicemsg.xml.DeviceStatus"), -1);
                        x.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer:tousr=" + a + ",fromuser=" + str + ",createtime=" + j + ",msgtype=" + str2 + ",devicetype=" + str3 + ",deviceid=" + str4 + ",devicestatus=" + i);
                        b zg = ad.aEk().zg(str4);
                        if (zg != null && bh.ou(zg.field_connProto).contains("4") && bh.ou(str2).contains("device_status")) {
                            if (i != 0) {
                                ad.aEv();
                                e.c(zg.field_brandName, zg.field_url, 2, zg.field_deviceID);
                            } else {
                                ad.aEv();
                                e.c(zg.field_brandName, zg.field_url, 4, zg.field_deviceID);
                            }
                            obj = 1;
                            if (obj == null) {
                                a = n.a(bwVar.vGZ);
                                if (bh.ov(a)) {
                                    y = bi.y(a, "sysmsg");
                                    if (y != null || y.size() <= 0) {
                                        x.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
                                        return;
                                    }
                                    a = (String) y.get(".sysmsg.$type");
                                    if (bh.ov(a) || !a.equalsIgnoreCase("wcdevicemsg")) {
                                        x.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, type not wcdevicemsg");
                                        return;
                                    }
                                    x.i("MicroMsg.exdevice.ExDeviceMessageService", "newXml wcdevicemsg msgType = %s", new Object[]{bh.ou((String) y.get(".sysmsg.wcdevicemsg.xml.MsgType"))});
                                    if (bh.ou((String) y.get(".sysmsg.wcdevicemsg.xml.MsgType")).equals("device_relation")) {
                                        com.tencent.mm.sdk.b.b dbVar = new db();
                                        dbVar.frv.frw = true;
                                        com.tencent.mm.sdk.b.a.xef.m(dbVar);
                                        return;
                                    }
                                    a = (String) y.get(".sysmsg.wcdevicemsg.xml.Content");
                                    x.i("MicroMsg.exdevice.ExDeviceMessageService", "contentBase64 = %s", new Object[]{a});
                                    if (bh.ov(a)) {
                                        x.e("MicroMsg.exdevice.ExDeviceMessageService", "Fuck off: contentBase64 is null");
                                        return;
                                    }
                                    try {
                                        byte[] decode = Base64.decode(a, 0);
                                        if (bh.bw(decode)) {
                                            x.e("MicroMsg.exdevice.ExDeviceMessageService", "null == decodedContent");
                                            return;
                                        }
                                        long j2 = bh.getLong((String) y.get(".sysmsg.wcdevicemsg.xml.SessionID"), -1);
                                        x.i("MicroMsg.exdevice.ExDeviceMessageService", "------NewXml Receive------sessionId = %d, deviceId = %s, message content = %s, length = %d", new Object[]{Long.valueOf(j2), (String) y.get(".sysmsg.wcdevicemsg.xml.DeviceID"), a, Integer.valueOf(decode.length)});
                                        zg = ad.aEk().zg(str);
                                        if (zg == null) {
                                            x.e("MicroMsg.exdevice.ExDeviceMessageService", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
                                            return;
                                        } else if (0 == j2) {
                                            u.aEM().a(new g(decode, 0, zg.field_mac));
                                            return;
                                        } else {
                                            k aDL = k.aDL();
                                            x.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Recivce sendDataToManufacturerResponse, sessionId = %d", new Object[]{Long.valueOf(j2)});
                                            Assert.assertTrue(j2 >= 0);
                                            c cVar = new c((byte) 0);
                                            cVar.mSessionId = j2;
                                            cVar.kwG = decode;
                                            aDL.mHandler.obtainMessage(3, cVar).sendToTarget();
                                            return;
                                        }
                                    } catch (Throwable e) {
                                        x.e("MicroMsg.exdevice.ExDeviceMessageService", "decode failed!!! %s", new Object[]{e.getMessage()});
                                        x.printErrStackTrace("MicroMsg.exdevice.ExDeviceMessageService", e, "", new Object[0]);
                                        return;
                                    }
                                }
                                x.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
                            }
                        }
                    }
                }
            }
            obj = null;
            if (obj == null) {
                a = n.a(bwVar.vGZ);
                if (bh.ov(a)) {
                    y = bi.y(a, "sysmsg");
                    if (y != null) {
                    }
                    x.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
                    return;
                }
                x.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
            }
        }
    }
}
