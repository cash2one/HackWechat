package com.tencent.mm.plugin.exdevice.service;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.exdevice.service.a.c;
import com.tencent.mm.plugin.exdevice.service.a.d;
import com.tencent.mm.plugin.exdevice.service.a.e;
import com.tencent.mm.plugin.exdevice.service.a.f;
import com.tencent.mm.plugin.exdevice.service.a.g;
import com.tencent.mm.sdk.platformtools.af;

final class a$a extends af {
    final /* synthetic */ a lPI;

    public a$a(a aVar, Looper looper) {
        this.lPI = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                c cVar = (c) message.obj;
                a.a(this.lPI).a(1, 0, null, cVar.kAu, cVar.kAv, cVar.kAw, cVar.kAx);
                return;
            case 2:
                a.a(this.lPI).a(2, 0, null, null, null, 0, null);
                return;
            case 3:
                e eVar = (e) message.obj;
                a.a(this.lPI).c(eVar.lPM, eVar.lKk, eVar.lJY, eVar.jcD);
                return;
            case 4:
                d dVar = (d) message.obj;
                a.a(this.lPI).b(dVar.kAq, dVar.lPK, dVar.lPL, dVar.lJY);
                return;
            case 5:
                a$b com_tencent_mm_plugin_exdevice_service_a_b = (a$b) message.obj;
                a.a(this.lPI).a(message.arg1, com_tencent_mm_plugin_exdevice_service_a_b.kAq, com_tencent_mm_plugin_exdevice_service_a_b.lKf, com_tencent_mm_plugin_exdevice_service_a_b.lPJ, com_tencent_mm_plugin_exdevice_service_a_b.lJZ);
                return;
            case 8:
                g gVar = (g) message.obj;
                a.a(this.lPI, gVar.lPM, gVar.lPN);
                return;
            case 9:
                a.cw(((Long) message.obj).longValue());
                return;
            case 10:
                f fVar = (f) message.obj;
                a.a(this.lPI, fVar.kAq, fVar.kwG);
                return;
            case 11:
                synchronized (a.b(this.lPI)) {
                    a.a(this.lPI, ((Long) message.obj).longValue());
                }
                return;
            case 12:
                synchronized (a.b(this.lPI)) {
                    a.b(this.lPI, ((Long) message.obj).longValue());
                }
                return;
            default:
                return;
        }
    }
}
