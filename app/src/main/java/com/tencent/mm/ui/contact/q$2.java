package com.tencent.mm.ui.contact;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.sdk.platformtools.x;

class q$2 implements k {
    final /* synthetic */ q yTA;

    q$2(q qVar) {
        this.yTA = qVar;
    }

    public final void b(h hVar) {
        switch (hVar.bjW) {
            case -3:
            case -2:
            case -1:
                if (hVar.mJc.fDj.equals(q.d(this.yTA))) {
                    q.c(this.yTA);
                    return;
                }
                return;
            case 0:
                if (q.a(this.yTA) != null && q.a(this.yTA).equals(q.a(this.yTA))) {
                    q.a(this.yTA, hVar.mMb);
                    q.a(this.yTA, hVar.mMc);
                    if (hVar.mMc.size() > 0) {
                        switch (((j) hVar.mMc.get(0)).type) {
                            case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /*131072*/:
                                q.c(this.yTA, hVar.mMc);
                                break;
                            case 131075:
                                q.d(this.yTA, hVar.mMc);
                                break;
                            case 131076:
                                q.e(this.yTA, hVar.mMc);
                                break;
                            default:
                                x.i("MicroMsg.MMSearchContactAdapter", "not support search");
                                break;
                        }
                    }
                    q.a(this.yTA, hVar.mJc.fDj, q.c(this.yTA));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
