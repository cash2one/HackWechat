package com.tencent.mm.plugin.subapp;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.api.f;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.subapp.a.1;
import com.tencent.mm.plugin.subapp.ui.voicetranstext.a;
import com.tencent.mm.plugin.subapp.ui.voicetranstext.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import java.util.HashMap;
import java.util.Map;

public class a$a extends c<ff> implements e {
    private int fuD;
    private int fuE;
    private String fzO;
    private boolean iQg;
    private a rVb;
    private com.tencent.mm.plugin.subapp.ui.voicetranstext.c rVc;
    private b rVd;
    private com.tencent.mm.modelvoice.b rVe;
    private p rVf;
    private volatile boolean rVg;
    boolean rVh;
    private ak rVi;
    private ff rVj;
    private int rVk;
    private Map<String, String> rVl;
    private int rVm;
    private boolean rVn;
    private long rVo;
    private long rVp;
    private boolean rVq;
    private String toUser;

    public a$a() {
        this.rVg = false;
        this.rVh = false;
        this.rVn = true;
        this.rVo = 0;
        this.rVq = false;
        this.rVl = new HashMap();
        this.xen = ff.class.getName().hashCode();
    }

    private boolean a(ff ffVar) {
        if (!(ffVar instanceof ff)) {
            x.f("MicroMsg.SubCoreSubapp", "mismatched event");
            return false;
        } else if (ffVar.fuq.fut == 2) {
            a(a.rVz);
            this.rVl.clear();
            x.i("MicroMsg.SubCoreSubapp", "Have clear the cache of the translate voice results.");
            return true;
        } else if (ffVar.fuq.fut == 1) {
            a(a.rVz);
            x.i("MicroMsg.SubCoreSubapp", "Have cancel translate voice action.");
            return true;
        } else if (ffVar.fuq.fut == 3) {
            a(a.rVA);
            x.i("MicroMsg.SubCoreSubapp", "alvinluo Have cancel translate voice action by user.");
            return true;
        } else if (ffVar.fuq.fut != 0) {
            x.i("MicroMsg.SubCoreSubapp", "The opCode(%d) is out of range.", new Object[]{Integer.valueOf(this.rVj.fuq.fut)});
            return false;
        } else if (this.iQg) {
            x.w("MicroMsg.SubCoreSubapp", "The Event handler is busy.");
            return false;
        } else if (m.UD() == null) {
            x.e("MicroMsg.SubCoreSubapp", "SubCoreVoice.getVoiceStg() == null" + bh.cgy());
            return false;
        } else {
            this.rVj = ffVar;
            String str = this.rVj.fuq.fus;
            String str2 = this.rVj.fuq.fileName;
            if (bh.ov(str) || bh.ov(str2)) {
                x.e("MicroMsg.SubCoreSubapp", "The localId(%s) is null or fileName(%s) is null.", new Object[]{str, str2});
                a(a.rVB);
                return false;
            }
            bDE();
            String str3 = (String) this.rVl.get(str2);
            if (bh.ov(str3)) {
                bl XO = m.UE().XO(str2);
                a.rUV = XO;
                if (XO == null || bh.ov(a.rUV.field_content)) {
                    x.i("MicroMsg.SubCoreSubapp", "alvinluo transform test voice scene: %d", new Object[]{Integer.valueOf(ffVar.fuq.scene)});
                    this.rVf = m.UD().of(str2);
                    try {
                        if (this.rVf == null) {
                            x.i("MicroMsg.SubCoreSubapp", "alvinluo the VoiceInfo do not exist. (localId : %s, fileName : %s)", new Object[]{str, str2});
                            this.rVf = new p();
                            this.rVf.fileName = str2;
                            this.rVf.hVE = System.currentTimeMillis() / 1000;
                            this.rVf.clientId = str2;
                            this.rVf.hVF = System.currentTimeMillis() / 1000;
                            this.rVf.status = 1;
                            if (ffVar.fuq.scene == 8) {
                                this.rVf.hVI = -1;
                            } else {
                                this.rVf.hVI = Integer.valueOf(str).intValue();
                            }
                            x.i("MicroMsg.SubCoreSubapp", "size : %d", new Object[]{Integer.valueOf(o.nv(str2))});
                            this.rVf.hlp = r0;
                        }
                        if (this.rVf.hVI < 0) {
                            x.i("MicroMsg.SubCoreSubapp", "alvinluo voiceInfo msgLocalId < 0");
                        } else {
                            cf dH = ((h) g.h(h.class)).aZi().dH((long) this.rVf.hVI);
                            com.tencent.mm.ag.a.c ag;
                            if (dH.field_isSend == 1) {
                                this.fzO = q.FS();
                                if (this.rVj.fuq.scene == 4 || this.rVj.fuq.scene == 5) {
                                    ag = ((f) g.h(f.class)).ag(dH.field_bizChatId);
                                    if (ag != null) {
                                        this.toUser = ag.field_bizChatServId;
                                    } else {
                                        this.toUser = "";
                                    }
                                } else {
                                    this.toUser = dH.field_talker;
                                }
                            } else if (dH.field_isSend == 0) {
                                this.toUser = q.FS();
                                if (this.rVj.fuq.scene == 4 || this.rVj.fuq.scene == 5) {
                                    ag = ((f) g.h(f.class)).ag(dH.field_bizChatId);
                                    if (ag != null) {
                                        this.fzO = ag.field_bizChatServId;
                                    } else {
                                        this.fzO = "";
                                    }
                                } else {
                                    this.fzO = dH.field_talker;
                                }
                            }
                        }
                        this.rVm = this.rVj.fuq.scene;
                        x.d("MicroMsg.SubCoreSubapp", "alvinluo VoiceTransformText fromUser: %s, toUser: %s, scene: %d", new Object[]{this.fzO, this.toUser, Integer.valueOf(this.rVm)});
                        this.rVe = com.tencent.mm.modelvoice.q.nT(this.rVf.fileName);
                        this.iQg = true;
                        this.rVk = 20;
                        a(a.rVt);
                        return true;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SubCoreSubapp", e, "alvinluo set voiceInfo exception", new Object[0]);
                        a(a.rVB);
                        return true;
                    }
                }
                x.i("MicroMsg.SubCoreSubapp", "finish With DB localId:%s,fileName:%s", new Object[]{str, str2});
                a(a.rUV.field_content, a.rVx);
                return true;
            }
            x.i("MicroMsg.SubCoreSubapp", "finish With Cache localId:%s,fileName:%s", new Object[]{str, str2});
            a(str3, a.rVx);
            return true;
        }
    }

    private void bDE() {
        this.rVn = true;
        this.rVo = 0;
        this.rVp = 0;
        this.fuD = 0;
        this.fuE = 0;
        this.rVq = false;
    }

    final void a(a aVar) {
        switch (1.rVa[aVar.ordinal()]) {
            case 1:
                x.i("MicroMsg.SubCoreSubapp", "net check");
                if (this.rVf.fFo > 0) {
                    x.i("MicroMsg.SubCoreSubapp", "has msg svr id: %d", new Object[]{Long.valueOf(this.rVf.fFo)});
                    this.rVb = new a(this.rVf.clientId, this.rVf.hlp, this.rVe.getFormat(), this.rVf.fFo, this.rVf.fileName, this.rVm, this.fzO, this.toUser);
                } else {
                    x.i("MicroMsg.SubCoreSubapp", "not existex msg svr id: %d", new Object[]{Long.valueOf(this.rVf.fFo)});
                    this.rVb = new a(this.rVf.clientId, this.rVf.hlp, this.rVf.fileName, this.rVm, this.fzO, this.toUser);
                }
                ar.CG().a(this.rVb, 0);
                ar.CG().a(this.rVb.getType(), this);
                this.rVp = System.currentTimeMillis();
                return;
            case 2:
                x.i("MicroMsg.SubCoreSubapp", "net upload");
                if (this.rVb == null) {
                    x.w("MicroMsg.SubCoreSubapp", "request upload must after check!");
                    return;
                }
                this.rVc = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.rVf.clientId, this.rVb.rZc, this.rVe.getFormat(), this.rVf.fileName, this.rVm, this.fzO, this.toUser);
                ar.CG().a(this.rVc, 0);
                ar.CG().a(this.rVc.getType(), this);
                return;
            case 3:
                x.i("MicroMsg.SubCoreSubapp", "net upload more");
                if (this.rVc == null) {
                    x.w("MicroMsg.SubCoreSubapp", "upload more need has upload netScene!");
                    return;
                }
                this.rVc = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.rVc);
                ar.CG().a(this.rVc, 0);
                ar.CG().a(this.rVc.getType(), this);
                return;
            case 4:
                if (this.rVg) {
                    x.i("MicroMsg.SubCoreSubapp", "pulling so pass");
                    return;
                }
                x.i("MicroMsg.SubCoreSubapp", "net get");
                if (this.rVb == null) {
                    x.w("MicroMsg.SubCoreSubapp", "request get must after check!");
                    return;
                }
                this.rVg = true;
                this.rVd = new b(this.rVf.clientId);
                ar.CG().a(this.rVd, 0);
                ar.CG().a(this.rVd.getType(), this);
                return;
            case 5:
                this.rVh = true;
                return;
            case 6:
                ar.CG().c(this.rVb);
                ar.CG().c(this.rVc);
                ar.CG().c(this.rVd);
                this.rVq = true;
                a(null, a.rVz);
                return;
            case 7:
            case 8:
                this.rVq = true;
                a(null, aVar);
                return;
            case 9:
                this.rVq = true;
                a(null, aVar);
                return;
            default:
                return;
        }
    }

    private void bDF() {
        if (this.rVn) {
            this.rVn = false;
            this.rVo = System.currentTimeMillis();
            this.fuD = (int) (this.rVo - this.rVp);
        }
    }

    private void a(String str, a aVar) {
        x.i("MicroMsg.SubCoreSubapp", "finishWithResult mstate:%s", new Object[]{aVar});
        if (this.rVi != null) {
            this.rVi.TG();
        }
        ar.CG().b(546, this);
        ar.CG().b(547, this);
        ar.CG().b(548, this);
        if (this.rVj != null) {
            if (!bh.ov(str)) {
                this.rVl.put(this.rVj.fuq.fileName, str);
                if ((a.rUV == null || bh.ov(a.rUV.field_content)) && this.rVj.fuq.fqe == 1) {
                    bm UE = m.UE();
                    x.i("MicroMsg.SubCoreSubapp", "createVoiceTT localId(%s) , fileName(%s).", new Object[]{this.rVj.fuq.fus, this.rVj.fuq.fileName});
                    bl blVar = new bl();
                    blVar.field_msgId = Long.valueOf(this.rVj.fuq.fus).longValue();
                    blVar.XN(this.rVj.fuq.fileName);
                    blVar.field_content = str;
                    UE.a(blVar);
                }
            } else if (aVar == a.rVx) {
                x.i("MicroMsg.SubCoreSubapp", "finishWithResult State.FINISH id:%s", new Object[]{this.rVj.fuq.fus});
                this.rVj.fur.state = 2;
            }
            this.rVj.fur.aow = true;
            this.rVj.fur.content = str;
            if (aVar == a.rVz) {
                this.rVj.fur.state = 1;
            } else if (aVar == a.rVB || aVar == a.rVC) {
                this.rVj.fur.state = 2;
            }
            x.d("MicroMsg.SubCoreSubapp", "finishWithResult result : %s", new Object[]{str});
            if (this.rVj.fuq.fuu != null) {
                this.rVj.fuq.fuu.run();
            }
        }
        if (this.rVq && this.rVf != null) {
            int length;
            int i;
            if (str != null) {
                length = str.length();
            } else {
                length = 0;
            }
            if (aVar != a.rVx) {
                this.fuD = 0;
                this.fuE = 0;
                if (aVar == a.rVz) {
                    i = 5;
                    length = 0;
                } else if (aVar == a.rVC) {
                    length = 0;
                    i = 3;
                } else if (aVar == a.rVB) {
                    i = 4;
                    length = 0;
                } else if (aVar == a.rVD) {
                    length = 0;
                    i = 2;
                } else {
                    length = 0;
                    i = 0;
                }
            } else if (bh.ov(str)) {
                this.fuD = 0;
                this.fuE = 0;
                length = 0;
                i = 3;
            } else {
                i = 1;
            }
            x.i("MicroMsg.SubCoreSubapp", "alvinluo transformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, transformResult: %d", new Object[]{this.rVf.clientId, Integer.valueOf(length), Integer.valueOf(this.fuD), Integer.valueOf(this.fuE), Integer.valueOf(i)});
            if (i != 0) {
                com.tencent.mm.plugin.subapp.d.b.b(this.rVf.clientId, length, this.fuD, this.fuE, i);
            }
        }
        this.rVb = null;
        this.rVc = null;
        this.rVd = null;
        this.rVj = null;
        this.iQg = false;
        this.rVh = false;
        this.rVg = false;
        this.rVk = 20;
        a.rUV = null;
        bDE();
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = null;
        x.i("MicroMsg.SubCoreSubapp", "onSceneEnd errType(%d) , errCode(%d).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            int i3;
            switch (kVar.getType()) {
                case 546:
                    if (this.rVb.mState == a.rZa) {
                        x.i("MicroMsg.SubCoreSubapp", "check result: done");
                        a(a.rVx);
                        bDF();
                        this.fuE = 0;
                        this.rVq = true;
                        if (this.rVb.bEk()) {
                            str2 = this.rVb.rZb.wUh;
                        }
                        a(str2, a.rVx);
                        return;
                    } else if (this.rVb.mState == a.rYZ) {
                        if (this.rVb.rZb != null) {
                            bh.ov(this.rVb.rZb.wUh);
                        }
                        x.i("MicroMsg.SubCoreSubapp", "check result: processing");
                        a(a.rVw);
                        return;
                    } else if (this.rVb.mState == a.rYY) {
                        x.i("MicroMsg.SubCoreSubapp", "check result: not exist");
                        a(a.rVu);
                        return;
                    } else if (this.rVb.rZd != null) {
                        i3 = this.rVb.rZd.wHb;
                        return;
                    } else {
                        return;
                    }
                case 547:
                    if (this.rVc.bEm()) {
                        x.i("MicroMsg.SubCoreSubapp", "succeed upload");
                        a(a.rVw);
                        return;
                    }
                    x.d("MicroMsg.SubCoreSubapp", "start upload more: start:%d, len:%d", new Object[]{Integer.valueOf(this.rVc.rZc.vIC), Integer.valueOf(this.rVc.rZc.vID)});
                    a(a.rVv);
                    return;
                case 548:
                    int i4 = this.rVd.rZf;
                    x.i("MicroMsg.SubCoreSubapp", "get mIntervalSec:%ds", new Object[]{Integer.valueOf(i4)});
                    this.rVg = false;
                    bDF();
                    if (!this.rVd.isComplete() && this.rVd.bEk()) {
                        x.i("MicroMsg.SubCoreSubapp", "refreshResult result");
                        String str3 = this.rVd.rZb.wUh;
                        if (this.rVj != null) {
                            this.rVj.fur.aow = false;
                            this.rVj.fur.content = str3;
                            x.i("MicroMsg.SubCoreSubapp", "refreshResult result is null ? : %s", new Object[]{Boolean.valueOf(bh.ov(str3))});
                            if (this.rVj.fuq.fuu != null) {
                                this.rVj.fuq.fuu.run();
                            }
                        }
                    } else if (!this.rVd.bEk()) {
                        x.d("MicroMsg.SubCoreSubapp", "result not valid");
                    }
                    if (this.rVd.isComplete()) {
                        x.i("MicroMsg.SubCoreSubapp", "succeed get");
                        if (this.rVd.bEk()) {
                            str2 = this.rVd.rZb.wUh;
                        }
                        a(a.rVx);
                        this.fuE = (int) (System.currentTimeMillis() - this.rVo);
                        this.rVq = true;
                        a(str2, a.rVx);
                        return;
                    }
                    x.i("MicroMsg.SubCoreSubapp", "do get again after:%ds", new Object[]{Integer.valueOf(i4)});
                    if (!this.rVh) {
                        i3 = this.rVk - 1;
                        this.rVk = i3;
                        if (i3 < 0) {
                            x.e("MicroMsg.SubCoreSubapp", "Has try to translate delay for %d times.", new Object[]{Integer.valueOf(20)});
                            a(a.rVC);
                            return;
                        }
                        if (this.rVi == null) {
                            this.rVi = new ak(new 1(this, i4), false);
                        }
                        long j = (long) (i4 * 1000);
                        this.rVi.J(j, j);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 2) {
            a(a.rVD);
        } else {
            a(a.rVC);
        }
    }
}
