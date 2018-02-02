package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.s;
import java.util.Iterator;

public class RecordMsgDetailUI extends RecordMsgBaseUI {
    private boolean fBV = true;
    private String fEG = null;
    private long fqm = -1;
    private r jmO = null;
    private c pGh = null;
    private boolean pGi = false;
    private String pGj = "";
    private String pGk = "";
    private String title = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void bmX() {
        this.fqm = getIntent().getLongExtra("message_id", -1);
        this.fEG = getIntent().getStringExtra("record_xml");
        this.fBV = getIntent().getBooleanExtra("record_show_share", true);
        this.pGi = getIntent().getBooleanExtra("big_appmsg", false);
        this.pGh = h.Ik(this.fEG);
        if (this.pGh != null) {
            if (a(this.pGh) != null) {
                this.title = a(this.pGh);
            } else {
                this.title = this.pGh.title;
            }
            if (!bh.cA(this.pGh.hdX)) {
                this.pGj = ((uq) this.pGh.hdX.getFirst()).wdH;
                this.pGk = ((uq) this.pGh.hdX.getLast()).wdH;
            }
        } else {
            ar.Hg();
            cf dH = com.tencent.mm.z.c.Fa().dH(this.fqm);
            a I = a.I(dH.field_content, dH.field_reserved);
            if (I != null) {
                this.title = I.title;
                this.jmO = r.b(this, getString(R.l.ctB), true, 0, null);
            }
        }
        if (this.fEG == null || this.pGh == null) {
            bnf();
            setBackBtn(new 1(this));
            if (this.pGi && an.aqd().fo(this.fqm) != null) {
                ar.Hg();
                ar.CG().a(new ab(this.fqm, com.tencent.mm.z.c.Fa().dH(this.fqm).field_msgSvrId, new f(this) {
                    final /* synthetic */ RecordMsgDetailUI pGl;

                    {
                        this.pGl = r1;
                    }

                    public final void a(int i, int i2, k kVar) {
                        if (i == i2) {
                            if (this.pGl.jmO != null) {
                                this.pGl.jmO.dismiss();
                                this.pGl.jmO = null;
                            }
                            ar.Hg();
                            cf dH = com.tencent.mm.z.c.Fa().dH(this.pGl.fqm);
                            String str = dH.field_content;
                            if (s.eV(dH.field_talker)) {
                                str = ba.hQ(dH.field_content);
                            }
                            a fT = a.fT(str);
                            if (fT != null) {
                                this.pGl.fEG = fT.hbB;
                                this.pGl.pGh = h.Ik(this.pGl.fEG);
                                if (this.pGl.pGh != null) {
                                    if (this.pGl.a(this.pGl.pGh) != null) {
                                        this.pGl.title = this.pGl.a(this.pGl.pGh);
                                    } else {
                                        this.pGl.title = this.pGl.pGh.title;
                                    }
                                    this.pGl.pGj = ((uq) this.pGl.pGh.hdX.getFirst()).wdH;
                                    this.pGl.pGk = ((uq) this.pGl.pGh.hdX.getLast()).wdH;
                                }
                                this.pGl.au();
                            }
                        }
                    }
                }), 0);
                return;
            }
            return;
        }
        au();
    }

    private String a(c cVar) {
        Object obj = null;
        if (cVar == null) {
            return null;
        }
        Iterator it = cVar.hdX.iterator();
        int i = 0;
        String str = null;
        String str2 = null;
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            if (uqVar.wdD.wdX.wet != null) {
                i = 1;
                str2 = this.mController.xIM.getString(R.l.eCA);
            } else {
                String str3;
                if (uqVar.wdD.wdX.fzO != null) {
                    if (str == null) {
                        str = uqVar.wdF;
                    } else if (str != uqVar.wdF) {
                        str3 = uqVar.wdF;
                        obj = str3;
                    }
                }
                str3 = obj;
                obj = str3;
            }
        }
        if (str != null && obj == null && r2 == 0) {
            return this.mController.xIM.getString(R.l.egj, new Object[]{str});
        } else if (str == null || obj == null || str.equals(obj) || r2 != 0) {
            return str2;
        } else {
            return this.mController.xIM.getString(R.l.egi, new Object[]{str, obj});
        }
    }

    private void au() {
        a fVar = new f();
        fVar.pFF = this.pGh.hdX;
        fVar.fqm = this.fqm;
        fVar.fEG = this.fEG;
        super.bmX();
        this.pGe.a(fVar);
        n.getRecordMsgCDNStorage().a((e) this.pGe);
    }

    protected final h bmY() {
        return new e(this, new g());
    }

    protected void onDestroy() {
        super.onDestroy();
        n.getRecordMsgCDNStorage().b((e) this.pGe);
    }

    protected final String bmZ() {
        return this.title;
    }

    protected final String bna() {
        return this.pGj;
    }

    protected final String bnb() {
        return this.pGk;
    }

    protected final void bnc() {
        if (this.fBV) {
            addIconOptionMenu(0, R.g.bDI, new 3(this));
        }
    }

    protected final void c(int i, int i2, Intent intent) {
        if (-1 != i2) {
            x.e("MicroMsg.RecordMsgDetailUI", "processResult %d", new Object[]{Integer.valueOf(i2)});
        } else if (1001 == i) {
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            if (bh.ov(stringExtra)) {
                x.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but toUser is null");
                return;
            }
            ar.Hg();
            cf dH = com.tencent.mm.z.c.Fa().dH(this.fqm);
            if (dH.field_msgId != this.fqm) {
                x.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but message info is null");
            } else {
                ar.Dm().F(new 4(this, stringExtra, stringExtra2, dH, com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.efz), false, null)));
            }
        } else if (1002 == i && intent.getBooleanExtra("kfavorite", false)) {
            com.tencent.mm.g.a.cf cfVar = new com.tencent.mm.g.a.cf();
            com.tencent.mm.pluginsdk.model.f.a(cfVar, intent);
            cfVar.fqp.activity = this;
            cfVar.fqp.fqw = 8;
            com.tencent.mm.sdk.b.a.xef.m(cfVar);
        }
    }
}
