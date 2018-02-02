package com.tencent.mm.plugin.mmsight.model.a;

import android.os.HandlerThread;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    private static int otA = 4;
    static int otB = 4;
    af handler;
    HandlerThread[] otC;
    int otD = 0;
    private int otE = 0;
    private LinkedList<b> otF = new LinkedList();
    private a otG;
    boolean otH = false;
    com.tencent.mm.plugin.mmsight.model.a.b.a otI = new 1(this);

    static /* synthetic */ void a(a aVar, b bVar) {
        x.i("MicroMsg.ForwardMgr", "receive buf bufIndex: %d receiveIndex: %d", new Object[]{Integer.valueOf(bVar.otP), Integer.valueOf(aVar.otE)});
        if (aVar.otE == bVar.otP) {
            aVar.otE++;
            aVar.otG.output(bVar.otN);
            aVar.bap();
            return;
        }
        aVar.otF.add(bVar);
        aVar.bap();
    }

    public a(a aVar) {
        this.otG = aVar;
        otB = -1;
        if (CaptureMMProxy.getInstance() != null) {
            otB = CaptureMMProxy.getInstance().getInt(com.tencent.mm.storage.w.a.xsL, -1);
        }
        if (otB == -1) {
            otB = Runtime.getRuntime().availableProcessors();
            otB = Math.min(otA, otB);
            x.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from runtime %d, availableProcessors: %s", new Object[]{Integer.valueOf(otB), Integer.valueOf(Runtime.getRuntime().availableProcessors())});
        } else {
            x.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from config %d", new Object[]{Integer.valueOf(otB)});
        }
        this.otC = new HandlerThread[otB];
        SightVideoJNI.initScaleAndRoateBuffer(otB);
        for (int i = 0; i < this.otC.length; i++) {
            this.otC[i] = e.cZ("BigSightMediaCodecMP4MuxRecorder_FrameBufProcessMgr_" + i, -1);
            this.otC[i].start();
        }
        this.otH = false;
    }

    private void bap() {
        x.i("MicroMsg.ForwardMgr", "processBufList %d %d", new Object[]{Integer.valueOf(this.otF.size()), Integer.valueOf(this.otE)});
        while (this.otF.size() != 0) {
            int i;
            x.i("MicroMsg.ForwardMgr", "loop processBufList %d %d", new Object[]{Integer.valueOf(this.otF.size()), Integer.valueOf(this.otE)});
            Iterator it = this.otF.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (this.otE == bVar.otP) {
                    this.otE++;
                    this.otG.output(bVar.otN);
                    this.otF.remove(bVar);
                    i = 1;
                    continue;
                    break;
                }
            }
            i = 0;
            continue;
            if (i == 0) {
                return;
            }
        }
    }

    public final boolean baq() {
        return this.otE == this.otD;
    }

    public final void stop() {
        int i = 0;
        x.i("MicroMsg.ForwardMgr", "stop FrameBufProcessMgr %s", new Object[]{bh.cgy().toString()});
        while (i < this.otC.length) {
            if (this.otC[i] != null) {
                this.otC[i].quit();
                this.otC[i] = null;
            }
            i++;
        }
        SightVideoJNI.releaseScaleAndRoateBuffer(otB);
        this.otH = true;
    }
}
