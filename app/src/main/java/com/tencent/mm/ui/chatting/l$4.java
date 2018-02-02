package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.ag.f;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.chatting.l.b;
import com.tencent.mm.ui.tools.l;
import java.util.List;

class l$4 implements d {
    final /* synthetic */ Context val$context;
    final /* synthetic */ List yrD;
    final /* synthetic */ ChattingUI$a yrN;
    final /* synthetic */ x yrO;
    final /* synthetic */ s yrP;

    l$4(List list, Context context, ChattingUI$a chattingUI$a, x xVar, s sVar) {
        this.yrD = list;
        this.val$context = context;
        this.yrN = chattingUI$a;
        this.yrO = xVar;
        this.yrP = sVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (menuItem.getItemId() == 1193046) {
            if (i.de(this.yrD)) {
                h.a(this.val$context, this.val$context.getString(R.l.dXy), "", this.val$context.getString(R.l.dBP), new OnClickListener(this) {
                    final /* synthetic */ l$4 yrQ;

                    {
                        this.yrQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i.df(this.yrD)) {
                h.a(this.val$context, this.val$context.getString(R.l.dXz), "", this.val$context.getString(R.l.dBP), new 2(this));
            } else if (i.dd(this.yrD)) {
                h.a(this.val$context, this.val$context.getString(R.l.dXA), "", new 3(this), null);
            } else if (m.a(this.yrN, this.yrD, this.yrO) && this.yrP != null) {
                this.yrP.crR();
            }
        } else if (i.de(this.yrD)) {
            h.a(this.val$context, this.val$context.getString(R.l.dXy), "", this.val$context.getString(R.l.dBP), new 4(this));
        } else if (i.df(this.yrD)) {
            h.a(this.val$context, this.val$context.getString(R.l.dXz), "", this.val$context.getString(R.l.dBP), new 5(this));
        } else {
            boolean z;
            List<au> list = this.yrD;
            if (list != null) {
                for (au auVar : list) {
                    if (auVar.field_isSend == 1) {
                        break;
                    } else if (auVar.cje()) {
                        e bi;
                        e bh;
                        if (auVar.field_msgId > 0) {
                            bi = o.Pw().bi(auVar.field_msgId);
                        } else {
                            bi = null;
                        }
                        if ((bi == null || bi.hzP <= 0) && auVar.field_msgSvrId > 0) {
                            bh = o.Pw().bh(auVar.field_msgSvrId);
                        } else {
                            bh = bi;
                        }
                        if (bh != null && (bh.offset < bh.hlp || bh.hlp == 0)) {
                            z = true;
                            break;
                        }
                    } else if (auVar.cjh()) {
                        r0 = com.tencent.mm.modelvideo.o.TU().nr(auVar.field_imgPath);
                        if (!(r0 == null || r0.status == 199 || r0.status == 199)) {
                            z = true;
                            break;
                        }
                    } else if (auVar.cji()) {
                        r0 = t.nF(auVar.field_imgPath);
                        if (!(r0 == null || r0.status == 199 || r0.status == 199)) {
                            z = true;
                            break;
                        }
                    } else if (auVar.cjk()) {
                        z = !i.aj(auVar);
                    }
                }
            } else {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
            }
            z = false;
            if (z || i.dd(this.yrD)) {
                h.a(this.val$context, this.val$context.getString(R.l.dXA), "", new 6(this), null);
                return;
            }
            final String str = (String) menuItem.getTitle();
            if (f.jV(str)) {
                if (this.yrD.size() <= 1) {
                    l.crt().yrT = true;
                    l.a(str, this.yrN, this.yrD);
                    return;
                }
                new l(this.val$context).b(menuItem.getActionView(), new 7(this), new d(this) {
                    final /* synthetic */ l$4 yrQ;

                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        if (menuItem.getItemId() == 0) {
                            l.crt().yrT = true;
                        } else {
                            l.crt().yrT = false;
                        }
                        l.a(str, this.yrQ.yrN, this.yrQ.yrD);
                    }
                });
            } else if (i.db(this.yrD)) {
                h.a(this.val$context, this.val$context.getString(R.l.epC), "", new 9(this, menuItem), null);
            } else {
                Context context = this.val$context;
                this.val$context.getString(R.l.dGO);
                l.a(h.a(context, this.val$context.getString(R.l.eKa), false, null));
                s.ytO.c(new b(this.yrN, this.val$context, menuItem.getTitle(), -1, l.crt()));
                if (this.yrP != null) {
                    this.yrP.crR();
                }
            }
        }
    }
}
