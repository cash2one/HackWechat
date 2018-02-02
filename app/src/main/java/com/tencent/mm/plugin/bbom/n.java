package com.tencent.mm.plugin.bbom;

import com.tencent.mm.ae.t;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.fu;
import com.tencent.mm.g.a.ii;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.zero.a.c;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.bfm;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.o;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class n implements c {
    public final void a(NotifyService notifyService, int i, byte[] bArr, byte[] bArr2, long j) {
        b riVar;
        String str;
        b pjVar;
        switch (i) {
            case 10:
                x.d("MicroMsg.NotifyReceiverCallbackImpl", "on direct send notify");
                e bVar = new o.b();
                bVar.deviceID = q.yF();
                try {
                    if (new t(bVar, 10).a(10, bArr, null)) {
                        ar.CG().a(0, 0, "", new j(bVar));
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NotifyReceiverCallbackImpl", e, "", new Object[0]);
                    return;
                }
            case 102:
                x.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MM_VOIP_CS_PUSHTYPE_SYN do VoipSync");
                return;
            case 120:
                NotifyService.eg("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
                riVar = new ri();
                riVar.fJc.fJe = true;
                a.xef.m(riVar);
                str = riVar.fJd.fJg;
                if (!bh.ov(str)) {
                    x.v("MicroMsg.NotifyReceiverCallbackImpl", "voipinvite, exit talkroom first: " + str);
                    riVar = new ri();
                    riVar.fJc.fJf = true;
                    a.xef.m(riVar);
                }
                if (bArr != null && bArr.length > 0) {
                    if (bArr[0] == (byte) 1) {
                        x.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_VOIP_PUSHTYPE_INVITE, will launch voipUI");
                        riVar = new sp();
                        riVar.fKq.fuL = 3;
                        riVar.fKq.fKk = bArr;
                        a.xef.m(riVar);
                        return;
                    } else if (bArr[0] == (byte) 101) {
                        x.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_PSTN_PUSHTYPE_INVITE");
                        riVar = new ii();
                        riVar.fyN.fyO = bArr;
                        a.xef.m(riVar);
                        return;
                    } else if (bArr[0] == (byte) 3) {
                        x.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_CANCEL");
                        riVar = new sp();
                        riVar.fKq.fuL = 9;
                        riVar.fKq.fKk = bArr;
                        a.xef.m(riVar);
                        return;
                    } else if (bArr[0] == (byte) 2) {
                        x.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
                        riVar = new sp();
                        riVar.fKq.fuL = 10;
                        riVar.fKq.fKk = bArr;
                        a.xef.m(riVar);
                        return;
                    } else if (bArr[0] == (byte) 102) {
                        x.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
                        riVar = new sn();
                        riVar.fKj.fKk = bArr;
                        a.xef.m(riVar);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case GameJsApiOperateGameCenterMsg.CTRL_BYTE /*174*/:
                x.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MMFunc_VoipSync do VoipSync");
                riVar = new sp();
                riVar.fKq.fuL = 6;
                riVar.fKq.fKk = bArr;
                a.xef.m(riVar);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.ar.CTRL_INDEX /*192*/:
                riVar = new fu();
                riVar.fvo.fvp = bArr;
                a.xef.m(riVar);
                return;
            case GameJsApiGetGameCommInfo.CTRL_BYTE /*241*/:
                x.i("MicroMsg.NotifyReceiverCallbackImpl", "jacks do voice notify UI");
                if (bArr.length >= 8) {
                    Object obj = new byte[4];
                    Object obj2 = new byte[4];
                    System.arraycopy(bArr, 0, obj, 0, 4);
                    System.arraycopy(bArr, 4, obj2, 0, 4);
                    b kfVar = new kf();
                    kfVar.fBz.fBA = com.tencent.mm.a.n.p(obj, 0);
                    kfVar.fBz.fBB = com.tencent.mm.a.n.p(obj2, 0);
                    x.i("MicroMsg.NotifyReceiverCallbackImpl", "notifyId: %d, sequence: %d", new Object[]{Integer.valueOf(kfVar.fBz.fBA), Integer.valueOf(kfVar.fBz.fBB)});
                    a.xef.m(kfVar);
                    return;
                }
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.wifi.b.CTRL_INDEX /*318*/:
                byte[] decodeSecureNotifyData;
                String str2 = "MicroMsg.NotifyReceiverCallbackImpl";
                String str3 = "summerbadcr on MM_PKT_SILENCE_NOTIFY notify respBuf len[%d]";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                x.i(str2, str3, objArr);
                d.pPH.a(403, 38, 1, false);
                if (bArr != null) {
                    bfm com_tencent_mm_protocal_c_bfm = new bfm();
                    try {
                        com_tencent_mm_protocal_c_bfm.aF(bArr);
                        x.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData[%d, %d, %d, %d, %d, %d]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bfm.wKq), Integer.valueOf(com_tencent_mm_protocal_c_bfm.wKr), Integer.valueOf(com_tencent_mm_protocal_c_bfm.wKs), Integer.valueOf(com_tencent_mm_protocal_c_bfm.wKt), Integer.valueOf(com_tencent_mm_protocal_c_bfm.wKu), Integer.valueOf(com_tencent_mm_protocal_c_bfm.wKv)});
                        decodeSecureNotifyData = MMProtocalJni.decodeSecureNotifyData(bArr2, com_tencent_mm_protocal_c_bfm.wKq, com_tencent_mm_protocal_c_bfm.wKr, com_tencent_mm_protocal_c_bfm.wKs, com_tencent_mm_protocal_c_bfm.wKt, com_tencent_mm_protocal_c_bfm.wKu, com_tencent_mm_protocal_c_bfm.wKv, com_tencent_mm_protocal_c_bfm.wKw, com_tencent_mm_protocal_c_bfm.vZC.oz);
                    } catch (Exception e2) {
                        x.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData parseFrom e: " + e2.getMessage());
                        d.pPH.a(403, 39, 1, false);
                    }
                    if (decodeSecureNotifyData == null) {
                        x.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", new Object[]{Integer.valueOf(decodeSecureNotifyData.length)});
                        pjVar = new pj();
                        pjVar.fHn.data = decodeSecureNotifyData;
                        a.xef.m(pjVar);
                        return;
                    }
                    x.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
                    d.pPH.a(403, 40, 1, false);
                    return;
                }
                decodeSecureNotifyData = null;
                if (decodeSecureNotifyData == null) {
                    x.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
                    d.pPH.a(403, 40, 1, false);
                    return;
                }
                x.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", new Object[]{Integer.valueOf(decodeSecureNotifyData.length)});
                pjVar = new pj();
                pjVar.fHn.data = decodeSecureNotifyData;
                a.xef.m(pjVar);
                return;
            case 268369923:
                NotifyService.eg("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
                if (!bh.bw(bArr)) {
                    str = new String(bArr);
                    pjVar = new ah();
                    pjVar.foi.type = 4;
                    pjVar.foi.fok = str;
                    a.xef.m(pjVar);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
