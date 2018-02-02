package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.os.Looper;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.gallery.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import org.xwalk.core.R$styleable;

public final class ag extends c<nz> {
    Activity activity = null;
    private a yxu = null;

    public ag(a aVar, Activity activity) {
        super(0);
        this.yxu = aVar;
        this.activity = activity;
        this.xen = nz.class.getName().hashCode();
    }

    private boolean a(nz nzVar) {
        int i = 1;
        if (!(this.yxu == null || nzVar == null || !(nzVar instanceof nz))) {
            cf cfVar;
            long j = nzVar.fFS.fqm;
            String str = nzVar.fFS.fFT;
            cf cfVar2 = nzVar.fFS.fFU;
            if (cfVar2 == null || cfVar2.field_msgId <= 0) {
                cfVar = nzVar.fFS.fFU;
            } else {
                cfVar = cfVar2;
            }
            if (cfVar != null) {
                switch (cfVar.getType()) {
                    case 3:
                        switch (3.yxw[this.yxu.ordinal()]) {
                            case 1:
                                if (cfVar != null && cfVar.field_msgId > 0) {
                                    try {
                                        g.MJ().kI(d.a("downimg", cfVar.field_createTime, cfVar.field_talker, cfVar.field_msgId));
                                        x.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", new Object[]{Boolean.valueOf(true)});
                                        ar.CG().cancel(109);
                                        o.Px().l(com.tencent.mm.ui.chatting.gallery.d.bl(cfVar).hzP, j);
                                    } catch (Throwable e) {
                                        x.printErrStackTrace("MicroMsg.RevokeMsgListener", e, "[oneliang][revokeMsgImage] cancel failure:%s", new Object[]{e.getMessage()});
                                    }
                                }
                                if (this.activity != null && (this.activity instanceof ImageGalleryUI)) {
                                    x.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", new Object[]{Long.valueOf(j), Long.valueOf(((ImageGalleryUI) this.activity).fqm)});
                                    if (j == ((ImageGalleryUI) this.activity).fqm) {
                                        h.a(this.activity, str, "", false, new 1(this));
                                        break;
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                    case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                    case 62:
                        String str2 = "MicroMsg.RevokeMsgListener";
                        String str3 = "ashutest::revoke msg, type %s, isWorkerThread %B";
                        Object[] objArr = new Object[2];
                        objArr[0] = this.yxu;
                        objArr[1] = Boolean.valueOf(Looper.myLooper() == ar.Dm().oAt.getLooper());
                        x.v(str2, str3, objArr);
                        switch (3.yxw[this.yxu.ordinal()]) {
                            case 2:
                                aL(cfVar);
                                if (this.activity instanceof ImageGalleryUI) {
                                    ImageGalleryUI imageGalleryUI = (ImageGalleryUI) this.activity;
                                    if (!(imageGalleryUI.yCR != null && b.aX(cfVar) && cfVar.field_msgId == imageGalleryUI.yCR.cuy().field_msgId)) {
                                        i = 0;
                                    }
                                    if (i != 0) {
                                        imageGalleryUI.Gd(imageGalleryUI.cuT());
                                        h.a(this.activity, str, "", false, new 2(this));
                                        break;
                                    }
                                }
                                break;
                            case 3:
                                aL(cfVar);
                                break;
                            default:
                                break;
                        }
                    default:
                        break;
                }
            }
            x.e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
        }
        return false;
    }

    private static void aL(au auVar) {
        r nF = t.nF(auVar.field_imgPath);
        if (nF != null) {
            try {
                g.MJ().kI(d.a("downvideo", nF.hVE, nF.Ud(), nF.getFileName()));
                x.i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", new Object[]{Boolean.valueOf(true)});
                a TZ = com.tencent.mm.modelvideo.o.TZ();
                com.tencent.mm.kernel.g.CG().c(TZ.hWr);
                TZ.vB();
                ba.j(auVar);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.RevokeMsgListener", e, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", new Object[]{e.getMessage()});
            }
        }
    }
}
