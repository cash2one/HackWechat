package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.i.b;
import com.google.android.exoplayer2.q.a;
import java.util.Iterator;

class h$1 extends Handler {
    final /* synthetic */ h adc;

    h$1(h hVar, Looper looper) {
        this.adc = hVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        h hVar = this.adc;
        Iterator it;
        Iterator it2;
        Iterator it3;
        switch (message.what) {
            case 0:
                hVar.acR--;
                return;
            case 1:
                hVar.acP = message.arg1;
                it = hVar.acK.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a(hVar.acO, hVar.acP);
                }
                return;
            case 2:
                hVar.acS = message.arg1 != 0;
                it = hVar.acK.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).ag(hVar.acS);
                }
                return;
            case 3:
                if (hVar.acR == 0) {
                    h hVar2 = (h) message.obj;
                    hVar.acN = true;
                    hVar.acV = hVar2.aAw;
                    hVar.acW = hVar2.aAx;
                    hVar.acG.W(hVar2.aAy);
                    it2 = hVar.acK.iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                    return;
                }
                return;
            case 4:
                int i = hVar.acQ - 1;
                hVar.acQ = i;
                if (i == 0) {
                    hVar.acY = (b) message.obj;
                    if (hVar.acT.isEmpty()) {
                        hVar.ada = 0;
                        hVar.acZ = 0;
                        hVar.adb = 0;
                    }
                    if (message.arg1 != 0) {
                        it = hVar.acK.iterator();
                        while (it.hasNext()) {
                            ((a) it.next()).ir();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (hVar.acQ == 0) {
                    hVar.acY = (b) message.obj;
                    it = hVar.acK.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).ir();
                    }
                    return;
                }
                return;
            case 6:
                i$d com_google_android_exoplayer2_i_d = (i$d) message.obj;
                hVar.acQ -= com_google_android_exoplayer2_i_d.adP;
                if (hVar.acR == 0) {
                    hVar.acT = com_google_android_exoplayer2_i_d.acT;
                    hVar.acU = com_google_android_exoplayer2_i_d.acU;
                    hVar.acY = com_google_android_exoplayer2_i_d.acY;
                    if (hVar.acQ == 0 && hVar.acT.isEmpty()) {
                        hVar.ada = 0;
                        hVar.acZ = 0;
                        hVar.adb = 0;
                    }
                    it2 = hVar.acK.iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                    return;
                }
                return;
            case 7:
                p pVar = (p) message.obj;
                if (!hVar.acX.equals(pVar)) {
                    hVar.acX = pVar;
                    it3 = hVar.acK.iterator();
                    while (it3.hasNext()) {
                        ((a) it3.next()).a(pVar);
                    }
                    return;
                }
                return;
            case 8:
                e eVar = (e) message.obj;
                it3 = hVar.acK.iterator();
                while (it3.hasNext()) {
                    ((a) it3.next()).a(eVar);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
