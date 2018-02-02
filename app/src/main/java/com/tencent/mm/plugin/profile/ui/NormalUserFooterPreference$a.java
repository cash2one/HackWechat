package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bf.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.modelfriend.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;

abstract class NormalUserFooterPreference$a implements e {
    boolean isDeleteCancel = false;
    final /* synthetic */ NormalUserFooterPreference pkA;
    private g pkB = null;

    protected abstract void bjD();

    static /* synthetic */ void a(NormalUserFooterPreference$a normalUserFooterPreference$a) {
        NormalUserFooterPreference.p(normalUserFooterPreference$a.pkA).setVisibility(8);
        s.i(NormalUserFooterPreference.a(normalUserFooterPreference$a.pkA));
        NormalUserFooterPreference.a(normalUserFooterPreference$a.pkA).Aj();
        normalUserFooterPreference$a.bjD();
    }

    static /* synthetic */ void b(NormalUserFooterPreference$a normalUserFooterPreference$a) {
        NormalUserFooterPreference.p(normalUserFooterPreference$a.pkA).setVisibility(0);
        s.h(NormalUserFooterPreference.a(normalUserFooterPreference$a.pkA));
        NormalUserFooterPreference.a(normalUserFooterPreference$a.pkA).Ai();
        normalUserFooterPreference$a.bjD();
    }

    static /* synthetic */ void c(NormalUserFooterPreference$a normalUserFooterPreference$a) {
        int i = 7;
        Intent intent = new Intent();
        switch (NormalUserFooterPreference.l(normalUserFooterPreference$a.pkA)) {
            case 1:
            case 2:
            case 3:
            case 12:
            case 13:
            case 58:
            case 59:
            case 60:
                intent.putExtra("k_outside_expose_proof_item_list", a.x(45, NormalUserFooterPreference.a(normalUserFooterPreference$a.pkA).field_username));
                i = 45;
                break;
            case 9:
            case 14:
                i = 35;
                break;
            case 18:
                i = NormalUserFooterPreference.m(normalUserFooterPreference$a.pkA) ? 2 : 1;
                intent.putStringArrayListExtra("k_outside_expose_proof_item_list", a.mP(NormalUserFooterPreference.a(normalUserFooterPreference$a.pkA).field_username));
                break;
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
                i = NormalUserFooterPreference.m(normalUserFooterPreference$a.pkA) ? 4 : 3;
                intent.putStringArrayListExtra("k_outside_expose_proof_item_list", a.mQ(NormalUserFooterPreference.a(normalUserFooterPreference$a.pkA).field_username));
                break;
            case 25:
                i = NormalUserFooterPreference.m(normalUserFooterPreference$a.pkA) ? 6 : 5;
                if (!NormalUserFooterPreference.m(normalUserFooterPreference$a.pkA)) {
                    intent.putExtra("k_outside_expose_proof_item_list", a.mR(!bh.ov(NormalUserFooterPreference.a(normalUserFooterPreference$a.pkA).xxQ) ? NormalUserFooterPreference.a(normalUserFooterPreference$a.pkA).xxQ : NormalUserFooterPreference.a(normalUserFooterPreference$a.pkA).field_username));
                    break;
                } else {
                    intent.putExtra("k_outside_expose_proof_item_list", a.x(i, NormalUserFooterPreference.a(normalUserFooterPreference$a.pkA).field_username));
                    break;
                }
            case 30:
                intent.putStringArrayListExtra("k_outside_expose_proof_item_list", a.x(7, NormalUserFooterPreference.a(normalUserFooterPreference$a.pkA).field_username));
                break;
            default:
                i = 999;
                break;
        }
        intent.putExtra("k_username", NormalUserFooterPreference.a(normalUserFooterPreference$a.pkA).field_username);
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
        d.b(NormalUserFooterPreference.b(normalUserFooterPreference$a.pkA), "webview", ".ui.tools.WebViewUI", intent);
    }

    public NormalUserFooterPreference$a(NormalUserFooterPreference normalUserFooterPreference) {
        this.pkA = normalUserFooterPreference;
    }

    protected void EI() {
        bjD();
        bjF();
        NormalUserFooterPreference.f(this.pkA).setOnClickListener(new 12(this));
        NormalUserFooterPreference.g(this.pkA).setOnClickListener(new 13(this));
        NormalUserFooterPreference.h(this.pkA).setOnClickListener(new 14(this));
        NormalUserFooterPreference.i(this.pkA).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NormalUserFooterPreference$a pkC;

            {
                this.pkC = r1;
            }

            public final void onClick(View view) {
                NormalUserFooterPreference$a.c(this.pkC);
            }
        });
        NormalUserFooterPreference.j(this.pkA).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NormalUserFooterPreference$a pkC;

            {
                this.pkC = r1;
            }

            public final void onClick(View view) {
                NormalUserFooterPreference$a.c(this.pkC);
            }
        });
        NormalUserFooterPreference.k(this.pkA).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NormalUserFooterPreference$a pkC;

            {
                this.pkC = r1;
            }

            public final void onClick(View view) {
                NormalUserFooterPreference$a.c(this.pkC);
            }
        });
    }

    protected void onDetach() {
    }

    public void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.NormalUserFooterPreference", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + kVar.getType());
    }

    protected final void bjE() {
        NormalUserFooterPreference.b(this.pkA).addIconOptionMenu(0, R.g.bDI, new 1(this));
    }

    protected final void v(boolean z, boolean z2) {
        if (!z || !z2) {
            NormalUserFooterPreference.b(this.pkA).addIconOptionMenu(0, R.g.bDI, new 11(this, z, z2));
        }
    }

    protected void bjF() {
        if (NormalUserFooterPreference.d(this.pkA)) {
            NormalUserFooterPreference.b(this.pkA).showOptionMenu(false);
        } else if (!q.FS().equals(NormalUserFooterPreference.a(this.pkA).field_username)) {
            if (!com.tencent.mm.l.a.fZ(NormalUserFooterPreference.a(this.pkA).field_type)) {
                v(false, false);
            } else if (!s.hg(NormalUserFooterPreference.a(this.pkA).field_username)) {
                bjE();
            }
        }
    }

    final void bjG() {
        this.pkB = new g(NormalUserFooterPreference.b(this.pkA), g.ztp, false);
        this.pkB.rKC = new c(this) {
            final /* synthetic */ NormalUserFooterPreference$a pkC;

            {
                this.pkC = r1;
            }

            public final void a(n nVar) {
                nVar.ai(2, R.l.dFg, R.k.dAG);
                nVar.ai(1, R.l.dFh, R.k.dAH);
            }
        };
        this.pkB.rKD = new p$d(this) {
            final /* synthetic */ NormalUserFooterPreference$a pkC;

            {
                this.pkC = r1;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        this.pkC.pkA.bjB();
                        return;
                    case 2:
                        this.pkC.pkA.bjC();
                        return;
                    default:
                        return;
                }
            }
        };
        this.pkB.bUk();
    }

    final void HB(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.NormalUserFooterPreference", "mod stranger remark, username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Scene", NormalUserFooterPreference.l(this.pkA));
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", NormalUserFooterPreference.a(this.pkA).field_username);
        intent.putExtra("Contact_Nick", NormalUserFooterPreference.a(this.pkA).field_nickname);
        intent.putExtra("Contact_RemarkName", NormalUserFooterPreference.a(this.pkA).field_conRemark);
        com.tencent.mm.plugin.profile.a.ifs.q(intent, this.pkA.mContext);
    }

    protected final void bjH() {
        com.tencent.mm.plugin.report.service.g.pQN.h(14553, new Object[]{Integer.valueOf(2), Integer.valueOf(2), NormalUserFooterPreference.a(this.pkA).field_username});
        String str = NormalUserFooterPreference.a(this.pkA).field_username;
        if (s.gC(str)) {
            NormalUserFooterPreference.a(this.pkA).Ah();
            ar.Hg();
            com.tencent.mm.z.c.EX().b(new com.tencent.mm.ay.c(str));
            ar.Hg();
            com.tencent.mm.z.c.EY().WU(str);
            ar.Hg();
            com.tencent.mm.z.c.Fh().hJ(str);
            return;
        }
        String str2;
        this.isDeleteCancel = false;
        Context context = this.pkA.mContext;
        this.pkA.mContext.getString(R.l.dGO);
        ProgressDialog a = h.a(context, this.pkA.mContext.getString(R.l.dHc), true, new 6(this));
        if (this.isDeleteCancel) {
            str2 = null;
        } else {
            str2 = com.tencent.mm.pluginsdk.wallet.e.SZ(NormalUserFooterPreference.a(this.pkA).field_username);
        }
        if (bh.ov(str2)) {
            qU(str);
            return;
        }
        a.dismiss();
        h.a(this.pkA.mContext, false, this.pkA.mContext.getString(R.l.eWj, new Object[]{str2}), null, this.pkA.mContext.getString(R.l.enD), this.pkA.mContext.getString(R.l.dYr), new 7(this), new 8(this, a, str), -1, R.e.brm);
    }

    final void qU(String str) {
        com.tencent.mm.modelfriend.h hVar = null;
        NormalUserFooterPreference.a(this.pkA).Ah();
        ar.Hg();
        com.tencent.mm.z.c.EX().b(new com.tencent.mm.ay.c(str));
        ba.a(str, new ba.a(this) {
            final /* synthetic */ NormalUserFooterPreference$a pkC;

            {
                this.pkC = r1;
            }

            public final boolean HB() {
                return this.pkC.isDeleteCancel;
            }

            public final void HA() {
                if (this.pkC.pkA.iln != null) {
                    this.pkC.pkA.iln.dismiss();
                }
            }
        });
        ar.Hg();
        com.tencent.mm.z.c.EY().a(str, NormalUserFooterPreference.a(this.pkA));
        ar.Hg();
        com.tencent.mm.z.c.Fd().WX(str);
        switch (NormalUserFooterPreference.l(this.pkA)) {
            case 10:
                com.tencent.mm.modelsimple.d.C(this.pkA.mContext, str);
                break;
            case 12:
                ad lc = af.OI().lc(str);
                if (lc != null) {
                    lc.hwS = 1;
                    af.OI().a(lc.hwR, lc);
                    break;
                }
                break;
            case 13:
                b kR = af.OD().kR(str);
                if (!(kR == null || bh.ov(kR.hvs))) {
                    kR.status = 1;
                    af.OD().a(kR.Nr(), kR);
                }
                com.tencent.mm.modelsimple.d.C(this.pkA.mContext, str);
                break;
            case 31:
                i OE = af.OE();
                Cursor a = OE.hhp.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.username = \"" + str + "\"", null, 2);
                if (a != null) {
                    if (a.moveToFirst()) {
                        hVar = new com.tencent.mm.modelfriend.h();
                        hVar.b(a);
                    }
                    a.close();
                }
                if (hVar != null) {
                    hVar.status = 100;
                    af.OE().a(hVar);
                    break;
                }
                break;
            case 58:
            case 59:
            case 60:
                af.OL().N(str, 2);
                break;
        }
        if (NormalUserFooterPreference.l(this.pkA) == 9) {
            x.i("MicroMsg.NormalUserFooterPreference", "add scene unkown, check the contact getsource: " + NormalUserFooterPreference.a(this.pkA).getSource());
            switch (NormalUserFooterPreference.a(this.pkA).getSource()) {
                case 10:
                case 13:
                    x.i("MicroMsg.NormalUserFooterPreference", "delete the system contact info added by wechat");
                    com.tencent.mm.modelsimple.d.C(this.pkA.mContext, str);
                    break;
            }
        }
        if (NormalUserFooterPreference.o(this.pkA) == 0) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            com.tencent.mm.plugin.profile.a.ifs.s(intent, this.pkA.mContext);
            return;
        }
        NormalUserFooterPreference.b(this.pkA).setResult(-1, NormalUserFooterPreference.b(this.pkA).getIntent().putExtra("_delete_ok_", true));
        ((Activity) this.pkA.mContext).finish();
    }
}
