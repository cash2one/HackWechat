package com.tencent.wecall.talkroom.model;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.mm.plugin.multi.talk.a;
import com.tencent.pb.common.c.c;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class f$1 implements a {
    final /* synthetic */ f Aog;

    f$1(f fVar) {
        this.Aog = fVar;
    }

    public final void keep_OnOpenSuccess() {
        int[] iArr = null;
        this.Aog.AnF.nEU = 1;
        c.d("TalkRoomService", new Object[]{"engine OnOpenSuccess"});
        if (f.a(this.Aog) != 4) {
            c.m("TalkRoomService", new Object[]{"has exit the talkroom state:%d", Integer.valueOf(f.a(this.Aog))});
            return;
        }
        f fVar = this.Aog;
        c cHH = c.cHH();
        Object b = f.b(this.Aog);
        if (!TextUtils.isEmpty(b)) {
            TalkRoom abU = cHH.abU(b);
            if (abU != null) {
                List cHB = abU.cHB();
                if (cHB != null) {
                    int[] iArr2 = new int[cHB.size()];
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i = 0; i < cHB.size(); i++) {
                        d dVar = (d) cHB.get(i);
                        if (dVar != null) {
                            iArr2[i] = dVar.cHK();
                            stringBuffer.append(iArr2[i]);
                            stringBuffer.append(",");
                        }
                    }
                    c.m("TalkRoomManager", new Object[]{"getAllMemberIds memberIds: ", stringBuffer.toString()});
                    iArr = iArr2;
                }
            }
        }
        f.a(fVar, iArr);
        if (f.c(this.Aog) != null) {
            b c = f.c(this.Aog);
            boolean xQ = f.xQ();
            if (com.tencent.pb.common.a.a.zLH) {
                if (xQ) {
                    c.AmY.td(401);
                } else {
                    c.AmY.td(e.CTRL_INDEX);
                }
            }
        }
        f.d(this.Aog);
        f.c(this.Aog);
        com.tencent.pb.talkroom.sdk.e cHY = f.cHY();
        if (cHY != null) {
            cHY.bbW();
        }
        talk com_tencent_mm_plugin_multi_talk = f.c(this.Aog).AmY;
        if (com.tencent.pb.common.a.a.zLH) {
            AtomicInteger atomicInteger = new AtomicInteger();
            AtomicInteger atomicInteger2 = new AtomicInteger();
            try {
                com_tencent_mm_plugin_multi_talk.getSampleRate(atomicInteger, atomicInteger2);
            } catch (Throwable th) {
                c.m("TalkRoomService", new Object[]{"keep_OnOpenSuccess:  ", th});
                return;
            }
            int i2 = atomicInteger.get();
            int i3 = atomicInteger2.get();
            talk.oFK = i2;
            talk.oFL = i3;
            c.m("VoipAdapterUtil", new Object[]{"adapterInitv2engineSampleRate getSampleRate:", Integer.valueOf(talk.oFK), Integer.valueOf(talk.oFL)});
        }
        try {
            f.e(this.Aog);
        } catch (Throwable th2) {
            c.m("TalkRoomService", new Object[]{"keep_OnOpenSuccess initMediaComponent:  ", th2});
        }
        h hVar = this.Aog.AnF;
        if (hVar.Apf == 0) {
            hVar.AoU = 0;
        } else {
            hVar.AoU = System.currentTimeMillis() - hVar.Apf;
        }
        c.d(h.TAG, new Object[]{"endFirstSendPcm", Long.valueOf(hVar.AoU), Long.valueOf(hVar.Apf)});
        g f = f.f(this.Aog);
        Runnable com_tencent_wecall_talkroom_model_g_3 = new g$3(f);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com_tencent_wecall_talkroom_model_g_3.run();
        } else {
            f.handler.post(com_tencent_wecall_talkroom_model_g_3);
        }
    }

    public final void keep_OnError(int i) {
        int i2 = 207;
        int i3 = -3007;
        int i4 = 103;
        switch (i) {
            case -4:
                i2 = b.CTRL_INDEX;
                i3 = -3006;
                i4 = 115;
                break;
            case -3:
                i2 = g.CTRL_INDEX;
                i3 = -3005;
                i4 = 114;
                break;
            case -2:
                i2 = d.CTRL_INDEX;
                i3 = -3004;
                i4 = 113;
                break;
            case -1:
                i2 = 203;
                i3 = -3003;
                i4 = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                break;
        }
        h.Jg(i3);
        this.Aog.AnF.Jh(i2);
        c.d("TalkRoomService", new Object[]{"engine exitTalkRoom engineCallback OnError:", Integer.valueOf(i)});
        this.Aog.a(f.b(this.Aog), f.g(this.Aog), f.h(this.Aog), i4, true);
        f.f(this.Aog).g(-400, null);
    }

    public final void keep_OnNotify(int i) {
        c.m("TalkRoomService", new Object[]{"keep_OnNotify eventCode: ", Integer.valueOf(i)});
        if (i == 5) {
            this.Aog.AnF.AoS = 1;
            h hVar = this.Aog.AnF;
            if (hVar.Apf == 0) {
                hVar.AoT = 0;
            } else {
                hVar.AoT = System.currentTimeMillis() - hVar.Apf;
            }
            c.d(h.TAG, new Object[]{"endRecvFirstPcm", Long.valueOf(hVar.Apf), Long.valueOf(hVar.AoT)});
            f.i(this.Aog);
            f.j(this.Aog);
        }
    }

    public final void keep_OnReportEngineRecv(String str, int i) {
        c.d("TalkRoomService", new Object[]{"keep_OnReportEngineRecv:", Integer.valueOf(i), str});
        StringBuilder stringBuilder = new StringBuilder(com.tencent.pb.common.c.g.aaJ(this.Aog.AnR));
        stringBuilder.append(",");
        stringBuilder.append(str);
        h.acd(stringBuilder.toString());
    }

    public final void keep_OnReportEngineSend(String str) {
        c.d("TalkRoomService", new Object[]{"keep_OnReportEngineSend:", str});
        StringBuilder stringBuilder = new StringBuilder(com.tencent.pb.common.c.g.aaJ(this.Aog.AnR));
        stringBuilder.append(",");
        stringBuilder.append(str);
        h.ace(stringBuilder.toString());
    }

    public final void keep_OnReportChannel(String str) {
        c.d("TalkRoomService", new Object[]{"keep_OnReportChannel:", str});
        StringBuilder stringBuilder = new StringBuilder(com.tencent.pb.common.c.g.aaJ(this.Aog.AnR));
        stringBuilder.append(",");
        stringBuilder.append(str);
        h.acf(stringBuilder.toString());
    }
}
