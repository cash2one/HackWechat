package com.tencent.mm.plugin.ipcall.a.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.plugin.ipcall.a.g;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class a$1 extends af {
    final /* synthetic */ a nEM;

    a$1(a aVar, Looper looper) {
        this.nEM = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message == null || message.what != 59998) {
            super.handleMessage(message);
            return;
        }
        x.d("MicroMsg.IPCallEngineManager", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[]{Integer.valueOf(message.what), message.obj, Integer.valueOf(message.arg1), Integer.valueOf(message.arg2)});
        a aVar;
        switch (message.arg1) {
            case 3:
                x.d("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEV");
                return;
            case 4:
                x.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEVFAILED");
                aVar = this.nEM;
                x.d("MicroMsg.IPCallEngineManager", "handleStartDevFailed");
                if (aVar.nEL != null) {
                    aVar.nEL.aSU();
                    return;
                }
                return;
            case 5:
                x.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_RESET");
                if (message.arg2 == 4) {
                    x.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_BROKEN");
                    a.a(this.nEM, 34);
                    return;
                } else if (message.arg2 == 1) {
                    x.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_FAIL");
                    a.a(this.nEM, 20);
                    return;
                } else if (message.arg2 == 5) {
                    x.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_NETWORK_ERROR");
                    a.a(this.nEM, 30);
                    return;
                } else {
                    return;
                }
            case 6:
                aVar = this.nEM;
                x.d("MicroMsg.IPCallEngineManager", "channel connect!");
                if (aVar.nEJ) {
                    x.d("MicroMsg.IPCallEngineManager", "channel already connect! do call not startEngine again");
                    return;
                }
                x.d("MicroMsg.IPCallEngineManager", "startNativeEngine, ret: %d", new Object[]{Integer.valueOf(aVar.nEG.startEngine())});
                if (aVar.nEG.startEngine() == 0) {
                    aVar.nEG.soD = 0;
                } else {
                    aVar.nEG.soD = 1;
                }
                aVar.nEG.setInactive();
                aVar.nEJ = true;
                if (aVar.nEL != null) {
                    aVar.nEL.aSV();
                    return;
                }
                return;
            case 9:
                x.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_FIRST_PKT");
                return;
            case 10:
                x.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_ANSWER_MARK");
                x.i("MicroMsg.IPCallEngineManager", "handleChannelAccept");
                g aTx = i.aTx();
                x.i("MicroMsg.IPCallSvrLogic", "handleChannelAccept");
                if (aTx.fDV) {
                    x.i("MicroMsg.IPCallSvrLogic", "current status has accepted, ignore channel accept");
                    return;
                }
                aTx.nCR = true;
                if (aTx.nCP != null) {
                    aTx.nCP.jir = 2;
                    ar.CG().a(new o(aTx.nCP.nDx, aTx.nCP.nDy, aTx.nCP.aTO(), aTx.nCP.nDz, true), 0);
                }
                aTx.rt(2);
                return;
            default:
                return;
        }
    }
}
