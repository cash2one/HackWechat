package com.tencent.mm.plugin.g.a.d;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.g.a.d.b.d;
import com.tencent.mm.plugin.g.a.d.b.f;
import com.tencent.mm.plugin.g.a.d.b.g;
import com.tencent.mm.plugin.g.a.d.b.h;
import com.tencent.mm.plugin.g.a.d.b.i;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class b$c extends af {
    private WeakReference<b> kxt = null;

    public b$c(Looper looper, b bVar) {
        super(looper);
        this.kxt = new WeakReference(bVar);
    }

    public final void handleMessage(Message message) {
        b bVar = (b) this.kxt.get();
        if (bVar == null) {
            x.w("MicroMsg.exdevice.BluetoothSDKManager", "null == BluetoothSdkManager");
            return;
        }
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "handleMessage Message.What = " + message.what);
        switch (message.what) {
            case 0:
                b$j com_tencent_mm_plugin_g_a_d_b_j = (b$j) message.obj;
                bVar.kAn.h(com_tencent_mm_plugin_g_a_d_b_j.kAr, com_tencent_mm_plugin_g_a_d_b_j.kAs);
                return;
            case 1:
                h hVar = (h) message.obj;
                bVar.kAn.b(hVar.mSessionId, hVar.kwG);
                return;
            case 2:
                bVar.kAn.nd(message.arg1);
                return;
            case 3:
                i iVar = (i) message.obj;
                bVar.kAn.a(iVar.kAu, iVar.kAv, message.arg1, iVar.kAw, iVar.kAx);
                return;
            case 4:
                f fVar = (f) message.obj;
                bVar.kAn.g(fVar.kAr, fVar.kAs);
                return;
            case 5:
                bVar.kAn.bL(((g) message.obj).mSessionId);
                return;
            case 6:
                d dVar = (d) message.obj;
                bVar.kAn.b(dVar.mSessionId, dVar.kAq, dVar.kwX);
                return;
            default:
                return;
        }
    }
}
