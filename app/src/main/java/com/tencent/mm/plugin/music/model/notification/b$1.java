package com.tencent.mm.plugin.music.model.notification;

import com.tencent.mm.av.a;
import com.tencent.mm.g.a.js;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class b$1 extends c<js> {
    final /* synthetic */ b oMa;

    public b$1(b bVar) {
        this.oMa = bVar;
        this.xen = js.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        js jsVar = (js) bVar;
        if (this.oMa.oLT == null) {
            this.oMa.bev();
        } else {
            x.i("MicroMsg.Music.MMMusicNotificationHelper", "event.data.action:%d", new Object[]{Integer.valueOf(jsVar.fAz.action)});
            if (jsVar.fAz.fAv == null || !g.m(jsVar.fAz.fAv)) {
                a bdo;
                switch (jsVar.fAz.action) {
                    case 0:
                    case 1:
                    case 11:
                        if (this.oMa.oLT != null) {
                            bdo = h.bdz().bdo();
                            if (bdo != null) {
                                this.oMa.oLT.k(bdo);
                                break;
                            }
                            x.e("MicroMsg.Music.MMMusicNotificationHelper", "music is null, return");
                            break;
                        }
                        break;
                    case 2:
                        if (!(this.oMa.oLT == null || jsVar.fAz.fAC)) {
                            this.oMa.oLT.stop();
                            break;
                        }
                    case 3:
                        if (this.oMa.oLT != null) {
                            bdo = h.bdz().bdo();
                            if (bdo != null) {
                                this.oMa.oLT.l(bdo);
                                break;
                            }
                            x.e("MicroMsg.Music.MMMusicNotificationHelper", "music is null, return");
                            break;
                        }
                        break;
                    case 4:
                        if (this.oMa.oLT != null) {
                            this.oMa.oLT.stop();
                            break;
                        }
                        break;
                    case 7:
                        if (h.bdz().mode == 1 && this.oMa.oLT != null) {
                            MMMusicPlayerService mMMusicPlayerService = this.oMa.oLT;
                            x.i("MicroMsg.Music.MMMusicPlayerService", "end");
                            a aVar = mMMusicPlayerService.oMb;
                            if (!aVar.isInit) {
                                x.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
                            } else if (aVar.oLT == null) {
                                x.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
                            } else {
                                x.i("MicroMsg.Music.MMMusicNotification", "end");
                                ag.K(aVar.oLV);
                                ag.h(aVar.oLV, 2000);
                            }
                            ag.K(mMMusicPlayerService.oMc);
                            ag.h(mMMusicPlayerService.oMc, 60000);
                            break;
                        }
                    default:
                        break;
                }
            }
            x.e("MicroMsg.Music.MMMusicNotificationHelper", "livePlayer event, ingore");
        }
        return false;
    }
}
