package com.tencent.mm.modelvideo;

import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.ba.b;
import com.tencent.mm.z.m;
import com.tencent.mm.z.s;
import java.util.Iterator;
import java.util.Map;

class i$2 implements Runnable {
    final /* synthetic */ i hUL;

    i$2(i iVar) {
        this.hUL = iVar;
    }

    public final void run() {
        if (!o.TZ().flQ && this.hUL.hUJ == null && !this.hUL.hUF && !this.hUL.hUG) {
            if (this.hUL.hUB.isEmpty()) {
                Object obj;
                i iVar = this.hUL;
                if (bh.by(iVar.hUK) > 600) {
                    iVar.hUK = bh.Wo();
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    i.a(this.hUL);
                    return;
                }
                return;
            }
            cf cfVar = null;
            PBool pBool = new PBool();
            synchronized (this.hUL.hUB) {
                Iterator it = this.hUL.hUB.iterator();
                while (it.hasNext()) {
                    Object obj2;
                    cfVar = (au) it.next();
                    i iVar2 = this.hUL;
                    if (cfVar == null) {
                        pBool.value = true;
                        obj2 = null;
                    } else {
                        r nF = t.nF(cfVar.field_imgPath);
                        if (nF != null && nF.Uj()) {
                            x.i("MicroMsg.PreloadVideoService", "%d it finish download all file[%s], needn't preload", Integer.valueOf(iVar2.hashCode()), nF.getFileName());
                            Map y = bi.y(nF.Ug(), "msg");
                            String str = (String) y.get(".msg.videomsg.$newmd5");
                            String str2 = (String) y.get(".msg.videomsg.$cdnvideourl");
                            boolean eV = s.eV(nF.Ud());
                            iVar2.a(str, eV ? 2 : 1, (long) nF.hlp, nF.Ue(), nF.Ud(), s.eV(nF.Ud()) ? m.gl(nF.Ud()) : 0, str2, "", "");
                            g.pQN.a(354, 146, 1, false);
                            if (eV) {
                                g.pQN.a(354, 126, 1, false);
                            } else {
                                g.pQN.a(354, 125, 1, false);
                            }
                            pBool.value = true;
                            obj2 = null;
                        } else if (bh.bz(cfVar.field_createTime) >= 86400000) {
                            x.i("MicroMsg.PreloadVideoService", "%d more than 1 day don't preload", Integer.valueOf(iVar2.hashCode()));
                            pBool.value = true;
                            obj2 = null;
                        } else {
                            if (iVar2.bZ(true)) {
                                x.i("MicroMsg.PreloadVideoService", "%d check c2c video preload timestamp[%d]", Integer.valueOf(iVar2.hashCode()), Long.valueOf(iVar2.hUC));
                            } else {
                                x.i("MicroMsg.PreloadVideoService", "%d check c2c video preload %d %s", Integer.valueOf(iVar2.hashCode()), Long.valueOf(cfVar.field_msgId), cfVar.gjF);
                                b hT = ba.hT(cfVar.gjF);
                                if (hT == null) {
                                    pBool.value = true;
                                    obj2 = null;
                                } else if (hT.hgR <= 0) {
                                    pBool.value = true;
                                    obj2 = null;
                                } else if (!com.tencent.mm.modelcontrol.b.kK(hT.hgT)) {
                                    int i;
                                    if (an.isWifi(ac.getContext())) {
                                        i = hT.hgS & 1;
                                    } else if (an.is4G(ac.getContext())) {
                                        i = hT.hgS & 2;
                                    } else if (an.is3G(ac.getContext())) {
                                        i = hT.hgS & 4;
                                    } else {
                                        pBool.value = false;
                                        obj2 = null;
                                    }
                                    if (i > 0) {
                                        pBool.value = false;
                                        obj2 = 1;
                                    }
                                }
                            }
                            pBool.value = false;
                            obj2 = null;
                        }
                    }
                    if (pBool.value) {
                        it.remove();
                    }
                    if (obj2 != null) {
                        break;
                    }
                    cfVar = null;
                }
            }
            if (cfVar != null) {
                this.hUL.hUJ = new f(cfVar.field_msgId);
                x.i("MicroMsg.PreloadVideoService", "%s start to preload video[%s]", Integer.valueOf(this.hUL.hashCode()), this.hUL.hUJ.TM());
                if (this.hUL.hUJ.a(this.hUL) < 0) {
                    x.w("MicroMsg.PreloadVideoService", "%s curr preload task do scene error.", Integer.valueOf(this.hUL.hashCode()));
                    synchronized (this.hUL.hUB) {
                        Iterator it2 = this.hUL.hUB.iterator();
                        while (it2.hasNext()) {
                            au auVar = (au) it2.next();
                            if (auVar != null && auVar.field_msgId == this.hUL.hUJ.fqm) {
                                x.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", Integer.valueOf(this.hUL.hashCode()), Long.valueOf(this.hUL.hUJ.fqm));
                                it2.remove();
                            }
                        }
                    }
                    this.hUL.hUJ = null;
                }
            }
        }
    }
}
