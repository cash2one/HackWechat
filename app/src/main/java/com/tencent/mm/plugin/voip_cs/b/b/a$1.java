package com.tencent.mm.plugin.voip_cs.b.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.protocal.c.brt;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

class a$1 extends af {
    final /* synthetic */ a sxF;

    a$1(a aVar, Looper looper) {
        this.sxF = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message == null) {
            super.handleMessage(message);
            return;
        }
        x.d("MicroMsg.VoipCSEngine", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[]{Integer.valueOf(message.what), message.obj, Integer.valueOf(message.arg1), Integer.valueOf(message.arg2)});
        a aVar;
        switch (message.arg1) {
            case 1:
            case 4:
                return;
            case 3:
                x.d("MicroMsg.VoipCSEngine", "start dev!");
                return;
            case 5:
                x.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_RESET");
                if (message.arg2 == 4) {
                    x.i("MicroMsg.VoipCSEngine", "channel broken...");
                    b.bIU().swp = 1;
                } else if (message.arg2 == 5) {
                    x.i("MicroMsg.VoipCSEngine", "channel event network failer...");
                    b.bIU().swp = 6;
                } else {
                    x.i("MicroMsg.VoipCSEngine", "channel connect fail...");
                    b.bIU().swp = 5;
                }
                aVar = this.sxF;
                x.i("MicroMsg.VoipCSEngine", "channel connect failed!");
                b.bIU().bjS = 1;
                if (aVar.sxE != null) {
                    aVar.sxE.bJi();
                    return;
                }
                return;
            case 6:
                x.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_CHANNEL_CONNECTED");
                c bIU = b.bIU();
                x.d("MicroMsg.VoipCSReportHelper", "channelConnect");
                bIU.sws = 1;
                aVar = this.sxF;
                x.i("MicroMsg.VoipCSEngine", "channel connect!");
                if (aVar.nEJ) {
                    x.i("MicroMsg.VoipCSEngine", "channel already connect! do call not startEngine again");
                    return;
                }
                aVar.nEJ = true;
                x.i("MicroMsg.VoipCSEngine", "start engine");
                aVar.nEG.setInactive();
                x.d("MicroMsg.VoipCSEngine", "setChannelActiveAfterAccept");
                if (!aVar.nEJ) {
                    x.d("MicroMsg.VoipCSEngine", "channel not connect now");
                }
                aVar.nEG.setActive();
                int startEngine = aVar.nEG.startEngine();
                if (startEngine == 0) {
                    x.i("MicroMsg.VoipCSEngine", "start engine suc!");
                    int[] iArr = new int[]{b.bIS().nEG.spk, b.bIS().nEG.spl};
                    ByteBuffer allocate = ByteBuffer.allocate(8);
                    allocate.asIntBuffer().put(iArr);
                    if (b.bIS().nEG.setAppCmd(34, allocate.array(), 2) < 0) {
                        x.i("MicroMsg.VoipCSEngine", "setAppCmd: type:34,qosparam:" + iArr[0] + "," + iArr[1] + ",ret:" + startEngine);
                    }
                    b.bIU().swq = 1;
                } else {
                    x.i("MicroMsg.VoipCSEngine", "start engine fail!");
                    b.bIU().swq = 0;
                }
                if (aVar.sxE != null && b.bIT().swV != 2) {
                    aVar.sxE.aSV();
                    b.bIT().swV = 2;
                    return;
                }
                return;
            case 8:
                byte[] bArr = (byte[]) message.obj;
                a aVar2 = this.sxF;
                try {
                    brt com_tencent_mm_protocal_c_brt = (brt) new brt().aF(bArr);
                    a.et("MicroMsg.VoipCSEngine", "steve: onRecvRUDPCmd:" + com_tencent_mm_protocal_c_brt.wTq);
                    switch (com_tencent_mm_protocal_c_brt.wTq) {
                        case 3:
                            if (com_tencent_mm_protocal_c_brt.wTr != null) {
                                Object obj = com_tencent_mm_protocal_c_brt.wTr.oz;
                                a.et("MicroMsg.VoipCSEngine", "steve: remote new network type:" + obj);
                                int appCmd = aVar2.nEG.setAppCmd(HardCoderJNI.SCENE_QUIT_CHATTING, obj, 4);
                                if (appCmd < 0) {
                                    a.et("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + obj + "fail:" + appCmd + ", [roomid=" + aVar2.nEG.sod + ", roomkey=" + aVar2.nEG.nDy + "]");
                                    return;
                                }
                                return;
                            }
                            a.et("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
                            return;
                        default:
                            return;
                    }
                } catch (Exception e) {
                    a.et("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
                    return;
                }
                a.et("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
                return;
            case 100:
                a.b((byte[]) message.obj, "MicroMsg.VoipCSEngine", message.arg2);
                return;
            case 101:
                a.b((byte[]) message.obj, "MicroMsg.VoipCSEngine-JNI_CORE", message.arg2);
                return;
            default:
                return;
        }
    }
}
