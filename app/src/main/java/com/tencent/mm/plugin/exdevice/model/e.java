package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.d$b;
import com.tencent.mm.ag.f;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.g.a.de;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.g.a.du;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.ei;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.en;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.g.a.ht;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.g.a.kx;
import com.tencent.mm.g.a.la;
import com.tencent.mm.plugin.exdevice.i.g;
import com.tencent.mm.plugin.exdevice.i.j;
import com.tencent.mm.plugin.exdevice.i.k;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.g.8;
import com.tencent.mm.plugin.exdevice.model.i.a;
import com.tencent.mm.plugin.exdevice.service.ExDeviceService;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.pluginsdk.q.aa;
import com.tencent.mm.protocal.c.act;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {
    public com.tencent.mm.sdk.b.c kuw = new 21(this);
    List<b> lKU = new LinkedList();
    Map<String, b> lKV = new HashMap();
    public com.tencent.mm.sdk.b.c lKW = new 1(this);
    public com.tencent.mm.sdk.b.c lKX = new 12(this);
    public com.tencent.mm.sdk.b.c lKY = new 23(this);
    public com.tencent.mm.sdk.b.c lKZ = new 34(this);
    public com.tencent.mm.sdk.b.c lLA = new 26(this);
    public com.tencent.mm.sdk.b.c lLB = new com.tencent.mm.sdk.b.c<en>(this) {
        final /* synthetic */ e lLO;

        {
            this.lLO = r2;
            this.xen = en.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            en enVar = (en) bVar;
            g gVar = this.lLO.lLK;
            if (!gVar.lLT) {
                x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "stopScanNetworkDevice...");
                Java2CExDevice.stopScanWCLanDevice();
                gVar.lLT = true;
            }
            ar.Dm().F(new 8(gVar));
            ar.CG().b(1717, gVar);
            j.aEb().b(14, gVar.lMm);
            j.aEb().b(12, gVar.lMn);
            j.aEb().b(13, gVar.lMo);
            j.aEb().b(15, gVar.lMp);
            enVar.fte.fsH = true;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lLC = new 28(this);
    public com.tencent.mm.sdk.b.c lLD = new 29(this);
    public com.tencent.mm.sdk.b.c lLE = new 30(this);
    public com.tencent.mm.sdk.b.c lLF = new 31(this);
    public com.tencent.mm.sdk.b.c lLG = new 32(this);
    public com.tencent.mm.sdk.b.c lLH = new 33(this);
    public com.tencent.mm.sdk.b.c lLI = new 35(this);
    ExdeviceWCLanSDKUtil lLJ;
    g lLK;
    private final long lLL = 300000;
    private boolean lLM = false;
    private c lLN;
    public com.tencent.mm.sdk.b.c lLa = new com.tencent.mm.sdk.b.c<eo>(this) {
        final /* synthetic */ e lLO;

        {
            this.lLO = r2;
            this.xen = eo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            eo eoVar = (eo) bVar;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceUnBindHardDeviceEvent");
            ad.aEr().pa(0);
            eoVar = eoVar;
            if (bh.ov(eoVar.ftf.frn)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "brandName is null, can not unbind device");
                return false;
            }
            ajr com_tencent_mm_protocal_c_ajr = new ajr();
            com_tencent_mm_protocal_c_ajr.ksX = "";
            com_tencent_mm_protocal_c_ajr.vJA = eoVar.ftf.frn;
            ar.CG().a(new x(com_tencent_mm_protocal_c_ajr, 1), 0);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lLb = new 43(this);
    public com.tencent.mm.sdk.b.c lLc = new 44(this);
    public com.tencent.mm.sdk.b.c lLd = new 45(this);
    public com.tencent.mm.sdk.b.c lLe = new 46(this);
    public com.tencent.mm.sdk.b.c lLf = new 2(this);
    public com.tencent.mm.sdk.b.c lLg = new 3(this);
    public com.tencent.mm.sdk.b.c lLh = new 4(this);
    public com.tencent.mm.sdk.b.c lLi = new 5(this);
    public com.tencent.mm.sdk.b.c lLj = new 6(this);
    public com.tencent.mm.sdk.b.c lLk = new com.tencent.mm.sdk.b.c<dy>(this) {
        final /* synthetic */ e lLO;

        {
            this.lLO = r2;
            this.xen = dy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return e.e((dy) bVar);
        }
    };
    public com.tencent.mm.sdk.b.c lLl = new 8(this);
    public com.tencent.mm.sdk.b.c lLm = new com.tencent.mm.sdk.b.c<dd>(this) {
        final /* synthetic */ e lLO;

        {
            this.lLO = r2;
            this.xen = dd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return e.d((dd) bVar);
        }
    };
    public com.tencent.mm.sdk.b.c lLn = new 10(this);
    public com.tencent.mm.sdk.b.c lLo = new 11(this);
    public com.tencent.mm.sdk.b.c lLp = new 13(this);
    public com.tencent.mm.sdk.b.c lLq = new 14(this);
    public com.tencent.mm.sdk.b.c lLr = new 15(this);
    public com.tencent.mm.sdk.b.c lLs = new com.tencent.mm.sdk.b.c<el>(this) {
        final /* synthetic */ e lLO;

        {
            this.lLO = r2;
            this.xen = el.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            el elVar = (el) bVar;
            if (elVar == null || !(elVar instanceof el)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTUploadDataToServerEvent");
                return false;
            }
            elVar = elVar;
            if (e.b(elVar.ftb.mac, elVar.ftb.frn, elVar.ftb.data)) {
                elVar.ftc.frp = true;
                return true;
            }
            elVar.ftc.frp = false;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lLt = new 17(this);
    public com.tencent.mm.sdk.b.c lLu = new 18(this);
    public com.tencent.mm.sdk.b.c lLv = new 19(this);
    public com.tencent.mm.sdk.b.c lLw = new com.tencent.mm.sdk.b.c<kv>(this) {
        final /* synthetic */ e lLO;

        {
            this.lLO = r2;
            this.xen = kv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((kv) bVar) == null) {
                x.w("MicroMsg.exdevice.ExdeviceEventManager", "handleOnAuthSyncEvent, event is null.");
            } else {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleOnAuthSyncEvent");
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lLx = new com.tencent.mm.sdk.b.c<kx>(this) {
        final /* synthetic */ e lLO;

        {
            this.lLO = r2;
            this.xen = kx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "OnSubCoreInited, process : %s", new Object[]{ac.Br()});
            return !ac.cfz();
        }
    };
    public com.tencent.mm.sdk.b.c lLy = new 24(this);
    public com.tencent.mm.sdk.b.c lLz = new 25(this);
    af mHandler;

    class AnonymousClass39 implements a {
        final /* synthetic */ e lLO;
        final /* synthetic */ du lLQ;

        AnonymousClass39(e eVar, du duVar) {
            this.lLO = eVar;
            this.lLQ = duVar;
        }

        public final void eH(boolean z) {
            if (z) {
                this.lLO.V(this.lLQ.fss.op, this.lLQ.fss.userName);
            }
        }
    }

    private class c implements Runnable {
        List<com.tencent.mm.plugin.exdevice.h.b> hiw;
        final /* synthetic */ e lLO;

        public c(e eVar, List<com.tencent.mm.plugin.exdevice.h.b> list) {
            this.lLO = eVar;
            this.hiw = list;
        }

        public final void run() {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi device heart beat");
            if (this.hiw != null && this.hiw.size() > 0) {
                for (com.tencent.mm.plugin.exdevice.h.b bVar : this.hiw) {
                    u.aEM().a(new k(bVar.field_brandName, bVar.field_deviceType, bVar.field_deviceID, 1));
                }
                this.lLO.mHandler.postDelayed(this, 300000);
            }
        }
    }

    public e() {
        HandlerThread Wf = com.tencent.mm.sdk.f.e.Wf("wifi_device_heart_beat");
        Wf.start();
        this.mHandler = new af(Wf.getLooper());
    }

    final boolean c(b bVar) {
        de deVar = (de) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceGetLanDeviceInfosEvent: brandName=%s, context=%s", new Object[]{deVar.frD.frn, deVar.frD.context});
        if (yP(deVar.frD.frn)) {
            LinkedList zi = ad.aEk().zi(deVar.frD.frn);
            JSONArray jSONArray = new JSONArray();
            try {
                Iterator it = zi.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.plugin.exdevice.h.b bVar2 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                    if (!zi.isEmpty() && bh.ou(bVar2.field_connProto).contains("4")) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("deviceId", bVar2.field_deviceID);
                        if (this.lLJ.yT(bVar2.field_deviceID)) {
                            jSONObject.put("state", "connected");
                        } else {
                            jSONObject.put("state", "disconnected");
                        }
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[]{e.getMessage()});
            }
            deVar.frE.frC = jSONArray;
            deVar.frE.frp = true;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[]{jSONArray.toString()});
        } else {
            deVar.frE.frC = null;
            deVar.frE.frp = false;
        }
        return true;
    }

    static boolean e(String str, List<com.tencent.mm.plugin.exdevice.h.b> list) {
        String host = Uri.parse(str).getHost();
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "is url...");
        JSONArray jSONArray = null;
        boolean z = false;
        for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
            boolean z2;
            String str2 = bVar.gfT;
            String str3 = bVar.gfU;
            if (str3 == null || str3.length() <= 0 || str2 == null || !str2.contains("wxmsg_url")) {
                z2 = z;
            } else {
                JSONArray jSONArray2;
                boolean z3;
                try {
                    jSONArray2 = new JSONObject(str3).getJSONArray("wxmsg_url");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", e, "", new Object[0]);
                    jSONArray2 = jSONArray;
                }
                int length = jSONArray2.length();
                int i = 0;
                while (i < length) {
                    try {
                        if (jSONArray2.getString(i).equals(host)) {
                            z3 = true;
                            break;
                        }
                        i++;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", e2, "", new Object[0]);
                    }
                }
                z3 = z;
                if (z3) {
                    return z3;
                }
                JSONArray jSONArray3 = jSONArray2;
                z2 = z3;
                jSONArray = jSONArray3;
            }
            z = z2;
        }
        return z;
    }

    static boolean f(String str, List<com.tencent.mm.plugin.exdevice.h.b> list) {
        if (str == null) {
            return false;
        }
        boolean z;
        b htVar = new ht();
        htVar.fyb.frH = str;
        com.tencent.mm.sdk.b.a.xef.m(htVar);
        bnp com_tencent_mm_protocal_c_bnp = htVar.fyc.fyd;
        int i = com_tencent_mm_protocal_c_bnp.wQo.vYc;
        String str2;
        if (i == 1) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "is photo...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
                str2 = bVar.gfT;
                if (str2 != null && str2.contains("wxmsg_image")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else if (i == 4) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "is music...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar2 : list) {
                str2 = bVar2.gfT;
                if (str2 != null && str2.contains("wxmsg_music")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else if (i == 15) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "is sight...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar22 : list) {
                str2 = bVar22.gfT;
                if (str2 != null && str2.contains("wxmsg_video")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = i == 3 ? e(com_tencent_mm_protocal_c_bnp.wQo.nfX, (List) list) : false;
        }
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsSnsInfo = " + z + ", snsLocalId = " + str);
        return z;
    }

    static boolean d(b bVar) {
        dd ddVar = (dd) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetDeviceInfosEvent: brandName=%s, context=%s", new Object[]{ddVar.frA.frn, ddVar.frA.context});
        LinkedList zi = ad.aEk().zi(ddVar.frA.frn);
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = zi.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.exdevice.h.b bVar2 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                if (!zi.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("deviceId", bVar2.field_deviceID);
                    if (u.aEL().cx(bVar2.field_mac)) {
                        jSONObject.put("state", "connected");
                    } else {
                        jSONObject.put("state", "disconnected");
                    }
                    jSONArray.put(jSONObject);
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[]{e.getMessage()});
        }
        ddVar.frB.frC = jSONArray;
        ddVar.frB.frp = true;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[]{jSONArray.toString()});
        return true;
    }

    static boolean e(b bVar) {
        dy dyVar = (dy) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSendDataToDeviceEvent: brandName=%s, deviceId=%s", new Object[]{dyVar.fsz.frn, dyVar.fsz.ffq});
        if (bh.bw(dyVar.fsz.data)) {
            dyVar.fsA.frp = false;
            return false;
        }
        com.tencent.mm.plugin.exdevice.h.b zg = ad.aEk().zg(dyVar.fsz.ffq);
        if (zg == null) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
            dyVar.fsA.frp = false;
            return false;
        } else if (!u.aEL().cx(zg.field_mac)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't connect");
            dyVar.fsA.frp = false;
            return false;
        } else if (u.aEL().cD(zg.field_mac)) {
            if (aa.aEh().lMx) {
                aa.aEh().pb(a(zg));
            }
            u.aEM().a(new g(dyVar.fsz.data, 10001, zg.field_mac));
            dyVar.fsA.frp = true;
            return true;
        } else {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't authed");
            dyVar.fsA.frp = false;
            return false;
        }
    }

    static int a(com.tencent.mm.plugin.exdevice.h.b bVar) {
        if (bh.ou(bVar.field_connProto).contains("1")) {
            return 1;
        }
        if (bh.ou(bVar.field_connProto).contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            return 0;
        }
        return -1;
    }

    final boolean f(b bVar) {
        dg dgVar = (dg) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetTicketEvent: brandName=%s, deviceId=%s, type=%d", new Object[]{dgVar.frL.frn, dgVar.frL.ffq, Integer.valueOf(dgVar.frL.type)});
        act com_tencent_mm_protocal_c_act = new act();
        com_tencent_mm_protocal_c_act.wlp = dgVar.frL.type;
        com_tencent_mm_protocal_c_act.wlq = 0;
        com_tencent_mm_protocal_c_act.vLz = new ajr();
        com_tencent_mm_protocal_c_act.vLz.ksX = dgVar.frL.ffq;
        com_tencent_mm_protocal_c_act.vLz.vJA = dgVar.frL.frn;
        LinkedList linkedList = new LinkedList();
        linkedList.add(com_tencent_mm_protocal_c_act);
        com.tencent.mm.ae.e 36 = new 36(this, dgVar);
        com.tencent.mm.ae.k zVar = new z(linkedList, dgVar.frL.frn, dgVar.frL.frN);
        ar.CG().a(543, 36);
        if (ar.CG().a(zVar, 0)) {
            return false;
        }
        x.e("MicroMsg.exdevice.ExdeviceEventManager", "MMCore.getNetSceneQueue().doScene failed!!!");
        ar.CG().b(543, 36);
        dgVar.frM.frO = true;
        dgVar.frM.frP = null;
        if (dgVar.fqI == null) {
            return true;
        }
        dgVar.fqI.run();
        return true;
    }

    final boolean g(b bVar) {
        dw dwVar = (dw) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleScanDeviceEvent: brandName=%s, op=%s, btVersion=%s", new Object[]{dwVar.fsu.frn, Boolean.valueOf(dwVar.fsu.fro), Integer.valueOf(dwVar.fsu.fsw)});
        int i = dwVar.fsu.fsw;
        if (!(i == 0 || i == 1)) {
            if (com.tencent.mm.plugin.g.a.e.a.co(ac.getContext())) {
                x.w("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, use defalut BLE", new Object[]{Integer.valueOf(i)});
                i = 0;
            } else {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, return fail", new Object[]{Integer.valueOf(i)});
                dwVar.fsv.frp = false;
                return false;
            }
        }
        if (dwVar.fsu.fro) {
            aa aEh = aa.aEh();
            String str = dwVar.fsu.frn;
            aa.a anonymousClass37 = new aa.a(this) {
                final /* synthetic */ e lLO;

                {
                    this.lLO = r1;
                }

                public final void a(String str, byte[] bArr, boolean z) {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "OnScanDevice %s", new Object[]{str});
                    if (bArr == null) {
                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, isCompleted=%s", new Object[]{str, Boolean.valueOf(z)});
                    } else {
                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, base64(broadcastData)=%s, isCompleted=%s", new Object[]{str, Base64.encodeToString(bArr, 0), Boolean.valueOf(z)});
                    }
                    b dtVar = new dt();
                    dtVar.fsr.fsj = bArr;
                    dtVar.fsr.ffq = str;
                    dtVar.fsr.aow = z;
                    com.tencent.mm.sdk.b.a.xef.a(dtVar, Looper.getMainLooper());
                }
            };
            x.i("MicroMsg.exdevice.ScanDeviceLogic", "startScanDevice, brandName=%s", new Object[]{str});
            if (bh.ov(str)) {
                x.i("MicroMsg.exdevice.ScanDeviceLogic", "brand name is null");
            } else {
                aEh.lLR = str;
                aEh.lNl = anonymousClass37;
                aEh.lNm.clear();
                Iterator it = aEh.lNn.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.ae.k kVar = (com.tencent.mm.ae.k) it.next();
                    if (kVar != null) {
                        ar.CG().c(kVar);
                    }
                }
                aEh.lNn.clear();
                synchronized (aa.hpF) {
                    aa.lNo.clear();
                }
                if (aEh.lMx) {
                    x.w("MicroMsg.exdevice.ScanDeviceLogic", "still scanning. just change brand name and callback");
                } else {
                    aEh.lMx = true;
                    ar.CG().a(542, aEh);
                    ad.aEr().a(i, aEh);
                    x.i("MicroMsg.exdevice.ScanDeviceLogic", "should start scan, startTimer");
                    aEh.iZb.J(12000, 12000);
                }
            }
        } else {
            aa.aEh().pb(i);
        }
        dwVar.fsv.frp = true;
        return true;
    }

    static boolean yP(String str) {
        d jS = f.jS(str);
        if (jS == null) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
            return false;
        }
        d$b bI = jS.bI(false);
        if (bI != null && bI.Ly() != null && bI.Ly().LH()) {
            return true;
        }
        x.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
        return false;
    }

    final boolean a(com.tencent.mm.plugin.exdevice.h.b bVar, int i, int i2) {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSwitchViewEvent");
        if (bVar == null) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null.");
            return false;
        }
        String str = bVar.field_brandName;
        com.tencent.mm.plugin.exdevice.service.f.a cz = u.aEL().cz(bVar.field_mac);
        if (cz == null) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
            return false;
        }
        if (cz.fsg == 2) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "notify the connect device %s", new Object[]{str});
            u.aEM().a(new j(i, i2, bVar.field_mac));
        }
        ad.aEr().pa(i == 1 ? 1 : 0);
        if (i == 2) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "now exit chattingui, do not notify change the subtitle");
            ak akVar = (ak) ad.aEr().lKD.remove(Long.valueOf(bVar.field_mac));
            if (akVar != null) {
                akVar.TG();
            }
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "Device close strategy(%d)", new Object[]{Integer.valueOf(bVar.field_closeStrategy)});
            if (!((bVar.field_closeStrategy & 1) == 0 && u.aEL().cD(cz.lQj) && (2 == cz.fsg || cz.fsg == 0))) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "now the device is not auth or not connect  or closeStrategy is to close after exit, try to stop connetct, connet state is %d, device is %s", new Object[]{Integer.valueOf(cz.fsg), str});
                if (u.aEM().lKw != null) {
                    u.aEM().lKw.cF(cz.lQj);
                }
            }
            if (f.b(bVar)) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "try to disconnect simpleBTDevice(%s).", new Object[]{Long.valueOf(bVar.field_mac)});
                yQ(com.tencent.mm.plugin.exdevice.j.b.cK(bVar.field_mac));
            }
            return true;
        } else if (2 == cz.fsg || aa.vcE == null || !aa.vcE.bOx()) {
            return true;
        } else {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "getWearCommand is null or wear has connected in the brandName.");
            return false;
        }
    }

    final boolean e(List<com.tencent.mm.plugin.exdevice.h.b> list, int i) {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleWifiDeviceSwitchViewEvent");
        if (list.size() == 0) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null or nil.");
            return false;
        }
        int i2 = -1;
        switch (i) {
            case 1:
                if (this.lLM) {
                    this.mHandler.removeCallbacks(this.lLN);
                }
                this.lLN = new c(this, list);
                this.mHandler.postDelayed(this.lLN, 300000);
                this.lLM = true;
                i2 = 2;
                break;
            case 2:
                if (this.lLM) {
                    this.mHandler.removeCallbacks(this.lLN);
                    this.lLM = false;
                }
                i2 = 0;
                break;
        }
        for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
            u.aEM().a(new k(bVar.field_brandName, bVar.field_deviceType, bVar.field_deviceID, i2));
        }
        return true;
    }

    static boolean aDU() {
        LinkedList aEQ = ad.aEk().aEQ();
        if (aEQ.isEmpty()) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "get harddevice info is null or empty");
            return false;
        }
        ad.aEr().pa(2);
        Iterator it = aEQ.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.exdevice.h.b bVar = (com.tencent.mm.plugin.exdevice.h.b) it.next();
            ar.Hg();
            com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(bVar.field_brandName);
            if (WO == null || !com.tencent.mm.l.a.fZ(WO.field_type)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "%s is not my contact now, may be has been deleted", new Object[]{bVar.field_brandName});
            } else if ((bVar.field_connStrategy & 4) == 0) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect Strategy is %d, no need to sync in main ui", new Object[]{Integer.valueOf(bVar.field_connStrategy)});
            } else {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "now try to connect %s", new Object[]{bVar.field_brandName});
                ad.aEr().a(bVar.field_brandName, bVar.field_mac, 0, true);
            }
        }
        return true;
    }

    static boolean aDV() {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelEvent");
        ad.aEr();
        d.eG(false);
        ad.aEr().aDT();
        return true;
    }

    final boolean V(int i, String str) {
        x.v("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI.");
        d jS = f.jS(str);
        if (jS == null) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
            return false;
        }
        d$b bI = jS.bI(false);
        if (bI != null) {
            d$b.b Ly = bI.Ly();
            if (Ly != null && Ly.LH()) {
                List<com.tencent.mm.plugin.exdevice.h.b> zi = ad.aEk().zi(str);
                if (Ly.hpc == 1) {
                    List<com.tencent.mm.plugin.exdevice.h.b> aEQ = ad.aEk().aEQ();
                    if (aEQ.size() != 0) {
                        for (com.tencent.mm.plugin.exdevice.h.b bVar : aEQ) {
                            x.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE hard device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d)", new Object[]{Long.valueOf(bVar.field_mac), bVar.field_deviceID, bVar.field_deviceType, Long.valueOf(bVar.gfS)});
                            if (0 != (bVar.gfS & 1)) {
                                zi.add(bVar);
                            }
                        }
                    }
                }
                if (zi == null) {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo is null.");
                    return false;
                } else if (zi.size() == 0) {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo size is 0.");
                    return true;
                } else {
                    int i2 = 0;
                    int i3 = 0;
                    for (com.tencent.mm.plugin.exdevice.h.b bVar2 : zi) {
                        if (bVar2 == null) {
                            x.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
                        } else if (bh.ou(bVar2.field_connProto).contains("4")) {
                            x.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Wifi biz, continue.", new Object[]{bVar2.field_brandName});
                        } else if ((bVar2.field_connStrategy & 16) != 0) {
                            x.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Connect stragegy(%d) ignore connection on chat, continue!!!", new Object[]{bVar2.field_brandName, Integer.valueOf(bVar2.field_connStrategy)});
                        } else {
                            int i4;
                            int i5;
                            int i6;
                            if (bh.ou(bVar2.field_connProto).contains("1")) {
                                i6 = i2 + 1;
                                if (com.tencent.mm.plugin.g.a.e.a.art()) {
                                    i4 = i3;
                                    i5 = i6;
                                    i3 = 1;
                                } else {
                                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "%s, device is BC, but you phone not support BC.", new Object[]{bVar2.field_brandName});
                                    i2 = i6;
                                }
                            } else if (bh.ou(bVar2.field_connProto).contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                                i6 = i3 + 1;
                                if (com.tencent.mm.plugin.g.a.e.a.co(ac.getContext())) {
                                    i3 = 0;
                                    i4 = i6;
                                    i5 = i2;
                                } else {
                                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                                    i3 = i6;
                                }
                            } else {
                                i4 = i3;
                                i5 = i2;
                                i3 = -1;
                            }
                            x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceOpInChattingUIEventListener, op(%d), brandName(%s), connProto(%s),", new Object[]{Integer.valueOf(i), bVar2.field_brandName, bVar2.field_connProto});
                            if (i == 0) {
                                d aEr = ad.aEr();
                                long j = bVar2.field_mac;
                                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "StopSyncTimer, device Id = %d", new Object[]{Long.valueOf(j)});
                                if (aEr.lKE.containsKey(Long.valueOf(j))) {
                                    x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Switch from main view to chatting view before exdevice sync timeout, just stop MTimerHandler");
                                    ak akVar = (ak) aEr.lKE.remove(Long.valueOf(j));
                                    if (akVar != null) {
                                        akVar.TG();
                                    } else {
                                        x.e("MicroMsg.exdevice.ExdeviceConnectManager", "Remove deviceId(%d) from syncTimeOutMap failed!!!", new Object[]{Long.valueOf(j)});
                                    }
                                }
                                if (u.aEL().cx(bVar2.field_mac)) {
                                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "Enter chatting ui, find this deivce has been connected aready, device name = %s, device id = %d", new Object[]{bVar2.field_brandName, Long.valueOf(bVar2.field_mac)});
                                    if (u.aEL().cD(bVar2.field_mac)) {
                                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "This device is auth aready");
                                        c(bVar2.field_brandName, bVar2.field_url, 2, bVar2.field_deviceID);
                                        i3 = i4;
                                        i2 = i5;
                                    } else {
                                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "This device has been connected but not auth yet.");
                                        i3 = i4;
                                        i2 = i5;
                                    }
                                } else if (!com.tencent.mm.plugin.exdevice.service.d.cy(ac.getContext())) {
                                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "service not running");
                                    i3 = i4;
                                    i2 = i5;
                                } else if (f.b(bVar2)) {
                                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect simple device, mac(%s), brandName(%s)", new Object[]{com.tencent.mm.plugin.exdevice.j.b.cK(bVar2.field_mac), bVar2.field_brandName});
                                    a(bVar2.field_brandName + bVar2.field_mac, new a(this, bVar2.field_brandName, com.tencent.mm.plugin.exdevice.j.b.cK(bVar2.field_mac), bVar2.field_url, bVar2.field_deviceID));
                                    yR(com.tencent.mm.plugin.exdevice.j.b.cK(bVar2.field_mac));
                                    i3 = i4;
                                    i2 = i5;
                                } else {
                                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect AirSync device, mac(%s), brandName(%s)", new Object[]{com.tencent.mm.plugin.exdevice.j.b.cK(bVar2.field_mac), bVar2.field_brandName});
                                    ad.aEr().pa(1);
                                    ad.aEr().a(Long.valueOf(bVar2.field_mac), bVar2.field_connStrategy);
                                    ad.aEr().a(bVar2.field_brandName, bVar2.field_mac, i3);
                                    i3 = i4;
                                    i2 = i5;
                                }
                            } else if (i != 1) {
                                if (i == 2) {
                                    if (f.b(bVar2)) {
                                        yQ(com.tencent.mm.plugin.exdevice.j.b.cK(bVar2.field_mac));
                                        i3 = i4;
                                        i2 = i5;
                                    } else {
                                        ad.aEr();
                                        d.cn(bVar2.field_mac);
                                    }
                                }
                                i3 = i4;
                                i2 = i5;
                            } else if (f.b(bVar2)) {
                                a(bVar2.field_brandName + bVar2.field_mac, new a(this, bVar2.field_brandName, com.tencent.mm.plugin.exdevice.j.b.cK(bVar2.field_mac), bVar2.field_url, bVar2.field_deviceID));
                                yR(com.tencent.mm.plugin.exdevice.j.b.cK(bVar2.field_mac));
                                i3 = i4;
                                i2 = i5;
                            } else {
                                ad.aEr().a(Long.valueOf(bVar2.field_mac), bVar2.field_connStrategy);
                                ad.aEr().a(bVar2.field_brandName, bVar2.field_mac, i3);
                                i3 = i4;
                                i2 = i5;
                            }
                        }
                    }
                    if (i2 + i3 <= 0) {
                        bg(str, -1);
                    } else if (!com.tencent.mm.plugin.g.a.e.a.arv()) {
                        x.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                        bg(str, 0);
                    } else if (i3 > 0 && i2 == 0 && !com.tencent.mm.plugin.g.a.e.a.co(ac.getContext())) {
                        bg(str, 1);
                    }
                    return true;
                }
            }
        }
        x.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
        return false;
    }

    private static boolean aDW() {
        if (!com.tencent.mm.plugin.g.a.e.a.co(ac.getContext())) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
            return false;
        } else if (com.tencent.mm.plugin.g.a.e.a.arv()) {
            return true;
        } else {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
            return false;
        }
    }

    public static boolean aDX() {
        x.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTScanDevice");
        if (aDW()) {
            ad.aEw().aEa();
            return true;
        }
        x.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
        return false;
    }

    public static boolean yQ(String str) {
        x.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTDisconnectDevice, mac(%s).", new Object[]{str});
        if (!aDW()) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
            return false;
        } else if (bh.ov(str)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
            return false;
        } else {
            ad.aEw();
            h.cn(com.tencent.mm.plugin.exdevice.j.b.zu(str));
            return true;
        }
    }

    public final boolean yR(String str) {
        x.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTConnectDevice");
        if (!aDW()) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
            return false;
        } else if (bh.ov(str)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
            return false;
        } else {
            ad.aEw().a(com.tencent.mm.plugin.exdevice.j.b.zu(str), new 40(this));
            return true;
        }
    }

    public final boolean m(String str, byte[] bArr) {
        if (bh.ov(str) || bh.bw(bArr)) {
            String str2;
            int i;
            String str3 = "MicroMsg.exdevice.ExdeviceEventManager";
            String str4 = "input error. mac = %s, dataLen = %d";
            Object[] objArr = new Object[2];
            if (bh.ov(str)) {
                str2 = "null";
            } else {
                str2 = "mac";
            }
            objArr[0] = str2;
            if (bh.bw(bArr)) {
                i = 0;
            } else {
                i = bArr.length;
            }
            objArr[1] = Integer.valueOf(i);
            x.e(str3, str4, objArr);
            return false;
        }
        str3 = "MicroMsg.exdevice.ExdeviceEventManager";
        str4 = "handleExDeviceSimpleBTSendDataToDevice. mac = %s, dataLen = %d";
        objArr = new Object[2];
        objArr[0] = bh.ov(str) ? "null" : str;
        objArr[1] = Integer.valueOf(bh.bw(bArr) ? 0 : bArr.length);
        x.e(str3, str4, objArr);
        long zu = com.tencent.mm.plugin.exdevice.j.b.zu(str);
        com.tencent.mm.plugin.exdevice.service.f.a cA = ad.aEw().lMy.cA(zu);
        if (cA == null) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
            return false;
        } else if (cA.fsg != 2) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "device is not connected.");
            return false;
        } else {
            ad.aEw();
            return h.a(zu, bArr, new 41(this));
        }
    }

    public static boolean b(String str, String str2, byte[] bArr) {
        if (bh.ov(str) || bh.ov(str2) || bh.bw(bArr)) {
            int i;
            String str3 = "MicroMsg.exdevice.ExdeviceEventManager";
            String str4 = "input error. mac = %s, brandName = %s, dataLen = %d";
            Object[] objArr = new Object[3];
            if (bh.ov(str)) {
                str = "null";
            }
            objArr[0] = str;
            if (bh.ov(str2)) {
                str2 = "null";
            }
            objArr[1] = str2;
            if (bh.bw(bArr)) {
                i = 0;
            } else {
                i = bArr.length;
            }
            objArr[2] = Integer.valueOf(i);
            x.e(str3, str4, objArr);
            return false;
        }
        str3 = "MicroMsg.exdevice.ExdeviceEventManager";
        str4 = "handleExDeviceSimpleBTUploadDataToServer. mac = %s, brandName = %s, dataLen = %d";
        objArr = new Object[3];
        objArr[0] = bh.ov(str) ? "null" : str;
        objArr[1] = bh.ov(str2) ? "null" : str2;
        objArr[2] = Integer.valueOf(bh.bw(bArr) ? 0 : bArr.length);
        x.d(str3, str4, objArr);
        com.tencent.mm.plugin.exdevice.h.b cJ = ad.aEk().cJ(com.tencent.mm.plugin.exdevice.j.b.zu(str));
        if (cJ == null) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "device(mac=%s) not found in brand(brandName=%s)", new Object[]{str, str2});
            return false;
        }
        com.tencent.mm.plugin.g.a.b.a.a ad = com.tencent.mm.plugin.g.a.b.a.a.ad(bArr);
        if (1 != ad.kxJ) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "not step profile type %d != %d", new Object[]{Long.valueOf(1), Long.valueOf(ad.kxJ)});
            return false;
        }
        com.tencent.mm.plugin.g.a.b.a.f fVar = (com.tencent.mm.plugin.g.a.b.a.f) ad;
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        ((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sport.b.b.class)).a(cJ.field_deviceID, cJ.field_deviceType, (int) (instance.getTimeInMillis() / 1000), (int) (System.currentTimeMillis() / 1000), fVar.kzx, "");
        return true;
    }

    public final void h(String str, String str2, boolean z) {
        List<b> linkedList;
        synchronized (this.lKU) {
            linkedList = new LinkedList(this.lKU);
        }
        for (b j : linkedList) {
            j.j(str, str2, z);
        }
        linkedList.clear();
        for (b j2 : this.lKV.values()) {
            j2.j(str, str2, z);
        }
        x.d("MicroMsg.exdevice.ExdeviceEventManager", "simple BT on scan result: broadcastName=" + str + ", mac=" + str2 + ", isCompleted=" + z);
        b eiVar = new ei();
        eiVar.fsW.fsQ = str;
        eiVar.fsW.mac = str2;
        eiVar.fsW.aow = z;
        com.tencent.mm.sdk.b.a.xef.a(eiVar, Looper.getMainLooper());
    }

    public static void c(String str, String str2, int i, String str3) {
        b laVar = new la();
        laVar.fCm.op = 2;
        laVar.fCm.fzF = str;
        laVar.fCm.fsg = i;
        laVar.fCm.url = str2;
        laVar.fCm.ffq = str3;
        com.tencent.mm.sdk.b.a.xef.a(laVar, Looper.getMainLooper());
    }

    public static void bg(String str, int i) {
        b laVar = new la();
        laVar.fCm.op = 1;
        laVar.fCm.fzF = str;
        laVar.fCm.aAk = i;
        com.tencent.mm.sdk.b.a.xef.a(laVar, Looper.getMainLooper());
    }

    public static void c(String str, String str2, byte[] bArr) {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnRecvDataFromDevice. deviceId=%s, brandName=%s", new Object[]{str, str2});
        b dsVar = new ds();
        dsVar.fsq.ffq = str;
        dsVar.fsq.frn = str2;
        dsVar.fsq.data = bArr;
        com.tencent.mm.sdk.b.a.xef.a(dsVar, Looper.getMainLooper());
    }

    public static void ad(String str, boolean z) {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnDeviceBindStateChange. deviceId=%s, isBound=%s", new Object[]{str, Boolean.valueOf(z)});
        b drVar = new dr();
        drVar.fsp.ffq = str;
        drVar.fsp.frk = z;
        com.tencent.mm.sdk.b.a.xef.a(drVar, Looper.getMainLooper());
    }

    public final boolean a(b bVar) {
        if (bVar == null || this.lKU.contains(bVar)) {
            return false;
        }
        return this.lKU.add(bVar);
    }

    public final boolean b(b bVar) {
        return bVar != null && this.lKU.remove(bVar);
    }

    private b a(String str, b bVar) {
        return (b) this.lKV.put(str, bVar);
    }

    static boolean aDY() {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat exit, stop ExDeviceService.");
        Context context = ac.getContext();
        try {
            ad.aEr().aDT();
        } catch (Throwable e) {
            x.w("MicroMsg.exdevice.ExDeviceServiceHelper", "unbindService() Service is not start by bindService.%s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.exdevice.ExDeviceServiceHelper", e, "", new Object[0]);
        }
        context.stopService(new Intent(context, ExDeviceService.class));
        return true;
    }
}
