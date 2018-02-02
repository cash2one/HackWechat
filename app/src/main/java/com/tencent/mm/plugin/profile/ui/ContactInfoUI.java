package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ag.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.pq;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bi;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;

public class ContactInfoUI extends MMPreference implements a, j.a, b {
    private String iQs = "";
    private f ilB;
    private x jLe;
    private String mOi;
    private com.tencent.mm.pluginsdk.c.a phC;
    private boolean phD;
    private boolean phE;
    private int phF;
    private byte[] phG;
    private boolean phH = false;
    String phI = null;
    private String phJ = "";
    private boolean phK = false;

    public final int XB() {
        return R.o.fbF;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactInfoUI", "onCreate MMCore.accHasReady[%b]", new Object[]{Boolean.valueOf(ar.Hj())});
        this.phI = getIntent().getStringExtra("Contact_Search_Mobile");
        if (g.Dh().Cy()) {
            ar.Hg();
            c.EY().a(this);
            ar.Hg();
            c.EZ().a(this);
            initView();
            return;
        }
        finish();
    }

    public void onDestroy() {
        if (g.Dh().Cy()) {
            ar.Hg();
            c.EY().b(this);
            ar.Hg();
            c.EZ().b(this);
        }
        if (this.phC != null) {
            this.phC.arS();
        }
        if (n.qQy != null) {
            n.qQy.K(this);
        }
        super.onDestroy();
    }

    public void onResume() {
        d.b(3, "ContactInfoUI" + getIdentString(), hashCode());
        y.Mf().c(this);
        super.onResume();
        View focusedChild = ((ViewGroup) this.mController.contentView).getFocusedChild();
        if (focusedChild != null) {
            focusedChild.clearFocus();
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactInfoUI", "try to clear focus. id:%s", new Object[]{Integer.valueOf(focusedChild.getId())});
        }
    }

    protected void onRestart() {
        super.onRestart();
        this.phK = false;
    }

    public void onPause() {
        d.b(4, "ContactInfoUI" + getIdentString(), hashCode());
        y.Mf().j(this);
        super.onPause();
        ar.Dm().J(new Runnable(this) {
            final /* synthetic */ ContactInfoUI phL;

            {
                this.phL = r1;
            }

            public final void run() {
                ar.Hg();
                c.CU().lH(true);
            }
        });
    }

    protected final String getIdentString() {
        if (this.jLe == null || ((int) this.jLe.gJd) == 0 || bh.ov(this.jLe.field_username)) {
            return "";
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactInfoUI", "getIdentString %s", new Object[]{this.jLe.field_username});
        if (com.tencent.mm.ag.f.eE(this.jLe.field_username)) {
            return "_EnterpriseChat";
        }
        if (com.tencent.mm.ag.f.jX(this.jLe.field_username)) {
            return "_EnterpriseFatherBiz";
        }
        if (com.tencent.mm.ag.f.jW(this.jLe.field_username)) {
            return "_EnterpriseChildBiz";
        }
        if (this.jLe.cia()) {
            return "_bizContact";
        }
        if (s.eV(this.jLe.field_username)) {
            return "_chatroom";
        }
        if (s.gy(this.jLe.field_username)) {
            return "_bottle";
        }
        if (s.gz(this.jLe.field_username)) {
            return "_QQ";
        }
        if (s.hn(this.jLe.field_username)) {
            return "_" + this.jLe.field_username;
        }
        return "";
    }

    protected final void initView() {
        String str;
        this.ilB = this.yjd;
        this.ilB.removeAll();
        this.phF = getIntent().getIntExtra("Contact_Scene", 9);
        this.mOi = getIntent().getStringExtra("Verify_ticket");
        this.phD = getIntent().getBooleanExtra("Chat_Readonly", false);
        this.phE = getIntent().getBooleanExtra("User_Verify", false);
        this.iQs = getIntent().getStringExtra("Contact_ChatRoomId");
        String ou = bh.ou(getIntent().getStringExtra("Contact_User"));
        String ou2 = bh.ou(getIntent().getStringExtra("Contact_Alias"));
        String ou3 = bh.ou(getIntent().getStringExtra("Contact_Encryptusername"));
        if (ou.endsWith("@stranger")) {
            ou3 = ou;
        }
        ar.Hg();
        this.jLe = c.EY().WO(ou);
        if (this.jLe != null) {
            this.jLe.xxQ = ou;
        }
        com.tencent.mm.plugin.profile.a.ift.a(this.jLe);
        String stringExtra = getIntent().getStringExtra("Contact_Nick");
        int intExtra = getIntent().getIntExtra("Contact_Sex", 0);
        String stringExtra2 = getIntent().getStringExtra("Contact_Province");
        String stringExtra3 = getIntent().getStringExtra("Contact_City");
        String stringExtra4 = getIntent().getStringExtra("Contact_Signature");
        int intExtra2 = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
        String stringExtra5 = getIntent().getStringExtra("Contact_VUser_Info");
        String stringExtra6 = getIntent().getStringExtra("Contact_Distance");
        int intExtra3 = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
        String stringExtra7 = getIntent().getStringExtra("Contact_KWeibo");
        String stringExtra8 = getIntent().getStringExtra("Contact_KWeiboNick");
        String stringExtra9 = getIntent().getStringExtra("Contact_KFacebookName");
        long longExtra = getIntent().getLongExtra("Contact_KFacebookId", 0);
        this.phJ = getIntent().getStringExtra("Contact_BrandIconURL");
        String stringExtra10 = getIntent().getStringExtra("Contact_RegionCode");
        this.phG = getIntent().getByteArrayExtra("Contact_customInfo");
        int intExtra4 = getIntent().getIntExtra("Contact_Ext_Flag", 0);
        boolean booleanExtra = getIntent().getBooleanExtra("force_get_contact", false);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactInfoUI", "dkverify forceAddContact:%s  user:%s  roomid:%s ", new Object[]{Boolean.valueOf(booleanExtra), ou, this.iQs});
        if (booleanExtra) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoUI", "initView, forceAddContact, user = " + ou);
            if (this.jLe == null || !com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
                ak.a.hfL.Q(ou, "");
            } else {
                ak.a.hfL.Q(ou, this.iQs);
            }
        }
        if (this.jLe != null && ((int) this.jLe.gJd) > 0 && (!s.ho(this.jLe.field_username) || (x.Wz(this.jLe.field_username) && !s.gD(this.jLe.field_username)))) {
            com.tencent.mm.ag.d jS = com.tencent.mm.ag.f.jS(this.jLe.field_username);
            Object obj = (this.jLe.cia() && com.tencent.mm.ag.a.KV()) ? 1 : null;
            if (jS == null || (jS.KY() && obj == null)) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoUI", "update contact, verifyFlag %d.", new Object[]{Integer.valueOf(intExtra2)});
                ak.a.hfL.Q(this.jLe.field_username, com.tencent.mm.l.a.fZ(this.jLe.field_type) ? "" : this.iQs);
                com.tencent.mm.ad.b.iX(this.jLe.field_username);
            } else if (this.jLe.cid() && obj == null) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoUI", "update contact, last check time=%d", new Object[]{Integer.valueOf(this.jLe.fWw)});
                ak.b bVar = ak.a.hfL;
                String str2 = this.jLe.field_username;
                if (com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
                    str = "";
                } else {
                    str = this.iQs;
                }
                bVar.Q(str2, str);
                com.tencent.mm.ad.b.iX(this.jLe.field_username);
            }
        }
        int intExtra5 = getIntent().getIntExtra("Contact_verify_Scene", 9);
        if (this.jLe == null || ((int) this.jLe.gJd) == 0 || bh.ou(this.jLe.field_username).length() <= 0) {
            this.jLe = new x();
            this.jLe.setUsername(ou);
            this.jLe.cZ(ou2);
            this.jLe.dc(stringExtra);
            this.jLe.dd(getIntent().getStringExtra("Contact_PyInitial"));
            this.jLe.de(getIntent().getStringExtra("Contact_QuanPin"));
            this.jLe.eD(intExtra);
            this.jLe.dq(stringExtra2);
            this.jLe.dr(stringExtra3);
            this.jLe.dp(stringExtra4);
            this.jLe.ez(intExtra2);
            this.jLe.du(stringExtra5);
            this.jLe.ds(stringExtra6);
            this.jLe.eJ(intExtra5);
            this.jLe.dt(stringExtra7);
            this.jLe.ey(intExtra3);
            this.jLe.df(stringExtra8);
            this.jLe.ai(longExtra);
            this.jLe.dk(stringExtra9);
            this.jLe.dv(stringExtra10);
            this.jLe.eM(intExtra4);
            if (!bh.ov(this.phI) && this.phF == 15) {
                ar.Hg();
                bf EZ = c.EZ().EZ(ou);
                com.tencent.mm.sdk.e.c bfVar = new bf(ou);
                bfVar.field_conRemark = EZ.field_conRemark;
                bfVar.field_conDescription = EZ.field_conDescription;
                bfVar.field_contactLabels = EZ.field_contactLabels;
                bfVar.field_conPhone = this.phI;
                ar.Hg();
                c.EZ().a(bfVar);
                this.phI = null;
            }
        } else {
            if (this.jLe.fWf == 0) {
                this.jLe.eD(intExtra);
            }
            if (!(stringExtra2 == null || stringExtra2.equals(""))) {
                this.jLe.dq(stringExtra2);
            }
            if (!(stringExtra3 == null || stringExtra3.equals(""))) {
                this.jLe.dr(stringExtra3);
            }
            if (stringExtra10 != null) {
                if (!stringExtra10.equals("")) {
                    this.jLe.dv(stringExtra10);
                }
            }
            if (!(!bh.ov(this.jLe.signature) || stringExtra4 == null || stringExtra4.equals(""))) {
                this.jLe.dp(stringExtra4);
            }
            if (intExtra2 != 0) {
                this.jLe.ez(intExtra2);
            }
            if (!(!bh.ov(this.jLe.fWu) || stringExtra5 == null || stringExtra5.equals(""))) {
                this.jLe.du(stringExtra5);
            }
            if (!(!bh.ov(this.jLe.field_nickname) || stringExtra == null || stringExtra.equals(""))) {
                this.jLe.dc(stringExtra);
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactInfoUI", "searchMobilePhone:%s", new Object[]{bh.ou(this.phI)});
            if (!bh.ov(this.phI) && this.phF == 15) {
                obj = 1;
                stringExtra = this.jLe.fWE;
                if (stringExtra != null) {
                    for (String str3 : this.jLe.fWE.split(",")) {
                        if (str3.equals(this.phI)) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                    }
                }
                if (obj != null) {
                    this.jLe.dC(stringExtra + this.phI + ",");
                    this.phI = null;
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactInfoUI", "contact PhoneList:%s", new Object[]{bh.ou(this.jLe.fWE)});
                this.jLe.setSource(15);
            }
            this.jLe.ds(stringExtra6);
            this.jLe.eJ(intExtra5);
            this.jLe.ai(longExtra);
            this.jLe.dk(stringExtra9);
        }
        if (!bh.ov(ou3)) {
            this.jLe.di(ou3);
        }
        if (this.jLe == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactInfoUI", "contact = null");
        } else {
            bf EZ2;
            if (!bh.ov(ou3)) {
                ar.Hg();
                EZ2 = c.EZ().EZ(ou3);
                if (!(EZ2 == null || bh.ov(EZ2.field_encryptUsername))) {
                    this.jLe.da(EZ2.field_conRemark);
                }
            }
            if (!bh.ov(ou)) {
                ar.Hg();
                EZ2 = c.EZ().EZ(ou);
                if (!(EZ2 == null || bh.ov(EZ2.field_encryptUsername))) {
                    this.jLe.da(EZ2.field_conRemark);
                }
            }
        }
        getIntent().putExtra("Contact_User", this.jLe.field_username);
        if (!booleanExtra && ((int) this.jLe.gJd) <= 0 && this.jLe.cia() && (this.phF == 17 || this.phF == 41)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoUI", "come from card, getContact %s", new Object[]{this.jLe.field_username});
            ak.a.hfL.Q(this.jLe.field_username, "");
            com.tencent.mm.ad.b.iX(this.jLe.field_username);
        }
        str3 = "MicroMsg.ContactInfoUI";
        ou2 = "contact.getRemarkDesc() (%s, %s, %s)";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.jLe.fWy == null);
        objArr[1] = Integer.valueOf(this.jLe.fWy == null ? 0 : this.jLe.fWy.length());
        if (this.jLe.fWy == null) {
            ou3 = "";
        } else {
            ou3 = bh.VT(this.jLe.fWy);
        }
        objArr[2] = ou3;
        com.tencent.mm.sdk.platformtools.x.i(str3, ou2, objArr);
        if (!booleanExtra && ((int) this.jLe.gJd) <= 0 && this.phF == 96) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactInfoUI", "come from chatroom accessverify, getContact %s", new Object[]{this.jLe.field_username});
            ak.a.hfL.R(this.jLe.field_username, getIntent().getStringExtra("key_add_contact_verify_ticket"));
            com.tencent.mm.ad.b.I(this.jLe.field_username, 3);
        }
        if (this.jLe.field_username.equals(q.FS())) {
            x xVar;
            ar.Hg();
            long j = bh.getLong((String) c.CU().get(65825, null), 0);
            if (j > 0) {
                this.jLe.ai(j);
                xVar = this.jLe;
                ar.Hg();
                xVar.dk((String) c.CU().get(65826, null));
            }
            xVar = this.jLe;
            ar.Hg();
            xVar.dy((String) c.CU().get(286721, null));
            xVar = this.jLe;
            ar.Hg();
            xVar.dz((String) c.CU().get(286722, null));
            xVar = this.jLe;
            ar.Hg();
            xVar.dA((String) c.CU().get(286723, null));
        }
        if (this.jLe.field_username != null && this.jLe.field_username.equals(x.WD(q.FS()))) {
            bi HQ = bi.HQ();
            str3 = bh.ou(HQ.getProvince());
            ou2 = bh.ou(HQ.getCity());
            if (!bh.ov(str3)) {
                this.jLe.dq(str3);
            }
            if (!bh.ov(ou2)) {
                this.jLe.dr(ou2);
            }
            if (!bh.ov(HQ.countryCode)) {
                this.jLe.dv(RegionCodeDecoder.ah(HQ.countryCode, HQ.hhx, HQ.hhw));
            }
            int a = bh.a(Integer.valueOf(HQ.fWf), 0);
            ou3 = bh.ou(HQ.signature);
            this.jLe.eD(a);
            this.jLe.dp(ou3);
        }
        if (bh.ov(this.jLe.field_username)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactInfoUI", "username is null %s", new Object[]{ou});
            finish();
            return;
        }
        setMMTitle(s.hn(this.jLe.field_username) ? R.l.eMB : R.l.dXc);
        if (s.eV(this.jLe.field_username)) {
            setMMTitle(R.l.dWj);
        }
        str3 = this.phJ;
        if (s.gB(this.jLe.field_username)) {
            this.phC = com.tencent.mm.bm.d.Q(this, "sport");
        } else if (s.gI(this.jLe.field_username)) {
            this.phC = com.tencent.mm.bm.d.Q(this, "qqmail");
        } else if (s.gJ(this.jLe.field_username)) {
            this.phC = new e(this);
            setMMTitle(R.l.eMB);
        } else if (s.gL(this.jLe.field_username)) {
            this.phC = com.tencent.mm.bm.d.Q(this, "bottle");
            setMMTitle(R.l.eMB);
        } else if (s.gK(this.jLe.field_username)) {
            this.phC = com.tencent.mm.bm.d.Q(this, "tmessage");
            setMMTitle(R.l.eMB);
        } else if (s.gC(this.jLe.field_username)) {
            this.phC = new h(this);
        } else if (s.gQ(this.jLe.field_username)) {
            this.phC = new m(this);
        } else if (x.gy(this.jLe.field_username)) {
            this.phC = new d(this);
        } else if (s.gS(this.jLe.field_username)) {
            this.phC = com.tencent.mm.bm.d.Q(this, "nearby");
        } else if (s.gT(this.jLe.field_username)) {
            this.phC = com.tencent.mm.bm.d.Q(this, "shake");
        } else if (s.gU(this.jLe.field_username)) {
            this.phC = new j(this);
        } else if (s.gV(this.jLe.field_username)) {
            this.phC = com.tencent.mm.bm.d.z(this, "readerapp", "widget_type_news");
        } else if (s.hc(this.jLe.field_username)) {
            this.phC = com.tencent.mm.bm.d.z(this, "readerapp", "widget_type_weibo");
        } else if (s.gN(this.jLe.field_username)) {
            this.phC = new f(this);
        } else if (s.gO(this.jLe.field_username)) {
            this.phC = com.tencent.mm.bm.d.Q(this, "masssend");
        } else if (s.gP(this.jLe.field_username)) {
            this.phC = new g(this);
        } else if (this.jLe.cia()) {
            pq pqVar;
            try {
                pqVar = this.phG == null ? null : (pq) new pq().aF(this.phG);
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.ContactInfoUI", e, "", new Object[0]);
                pqVar = null;
            }
            com.tencent.mm.pluginsdk.c.a cVar = new c(this, str3, pqVar);
            if (!bh.ov(this.mOi)) {
                cVar.mOi = this.mOi;
            }
            this.phC = cVar;
        } else if (s.gY(this.jLe.field_username)) {
            this.phC = new n(this);
        } else if (s.gZ(this.jLe.field_username)) {
            this.phC = new i(this);
        } else {
            this.phC = new k(this);
        }
        if (this.phC != null) {
            this.phC.a(this.ilB, this.jLe, this.phD, this.phF);
            com.tencent.mm.modelfriend.b kR = af.OD().kR(this.jLe.field_username);
            ou3 = "";
            if (kR != null) {
                ou3 = bh.ou(kR.Nz()).replace(" ", "");
            }
            if (!this.phK && com.tencent.mm.l.a.fZ(this.jLe.field_type) && (this.phC instanceof k)) {
                int i;
                int i2;
                if (bh.ov(this.jLe.fWE)) {
                    i = 0;
                } else {
                    i = this.jLe.fWE.split(",").length;
                }
                if (bh.ov(ou3)) {
                    a = 0;
                } else {
                    a = 1;
                }
                i += a;
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                objArr = new Object[4];
                objArr[0] = this.jLe.field_username;
                objArr[1] = Integer.valueOf(1);
                if (bh.ov(ou3)) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                objArr[2] = Integer.valueOf(i2);
                if (i >= 5) {
                    i2 = 5;
                } else {
                    i2 = i;
                }
                objArr[3] = Integer.valueOf(i2);
                gVar.h(12040, objArr);
                this.phK = true;
            }
            if (!((this.phC instanceof k) || (this.phC instanceof c))) {
                ar.Hg();
                ou3 = (String) c.CU().get(w.a.xvi, "");
                if (ou3.contains(this.jLe.field_username)) {
                    ou3 = ou3.replaceAll(this.jLe.field_username + ",*", "");
                    ar.Hg();
                    c.CU().a(w.a.xvi, ou3);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactInfoUI", "mark plugin read, userName:%s, newVal:%s", new Object[]{this.jLe.field_username, ou3});
                    if (bh.ov(ou3)) {
                        com.tencent.mm.s.c.Bq().p(262158, false);
                    }
                }
            }
        }
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactInfoUI phL;

            {
                this.phL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if ((s.gU(this.phL.jLe.field_username) && !q.Gm()) || ((s.gM(this.phL.jLe.field_username) && !q.Gi()) || ((s.gO(this.phL.jLe.field_username) && !q.Gs()) || (s.gI(this.phL.jLe.field_username) && !q.Gu())))) {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.profile.a.ifs.s(intent, this.phL);
                }
                this.phL.finish();
                return true;
            }
        });
        com.tencent.mm.ad.n.JS().iZ(this.jLe.field_username);
        if ((s.gU(this.jLe.field_username) && q.Gm()) || ((s.gM(this.jLe.field_username) && q.Gi()) || ((s.gO(this.jLe.field_username) && q.Gs()) || (s.gI(this.jLe.field_username) && q.Gu())))) {
            this.phH = true;
        } else {
            this.phH = false;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.phC != null) {
            this.phC.onActivityResult(i, i2, intent);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactInfoUI", str + " item has been clicked!");
        if (this.phC != null) {
            this.phC.vQ(str);
        }
        return false;
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        a((String) obj, null);
    }

    public final void a(final String str, l lVar) {
        new com.tencent.mm.sdk.platformtools.af().post(new Runnable(this) {
            final /* synthetic */ ContactInfoUI phL;

            public final void run() {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[]{Boolean.valueOf(this.phL.phE), this.phL.jLe.field_username, str});
                if (this.phL.jLe != null && !bh.ov(this.phL.jLe.field_username)) {
                    if (this.phL.jLe.field_username.equals(str) || this.phL.jLe.field_username.equals(x.WD(str))) {
                        if (this.phL.phC != null) {
                            this.phL.phC.arS();
                            this.phL.ilB.removeAll();
                        }
                        this.phL.initView();
                    }
                }
            }
        });
    }

    public final void a(final bf bfVar) {
        ag.y(new Runnable(this) {
            final /* synthetic */ ContactInfoUI phL;

            public final void run() {
                if (this.phL.jLe != null && bfVar != null && !bh.ov(this.phL.jLe.field_username) && this.phL.jLe.field_username.equals(bfVar.field_encryptUsername) && !s.ho(this.phL.jLe.field_username)) {
                    this.phL.jLe.da(bfVar.field_conRemark);
                    this.phL.getIntent().putExtra("Contact_User", this.phL.jLe.field_username);
                    if (this.phL.phC != null) {
                        this.phL.phC.arS();
                        this.phL.ilB.removeAll();
                    }
                    this.phL.initView();
                }
            }
        });
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactInfoUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        NormalUserFooterPreference normalUserFooterPreference;
        switch (i) {
            case 19:
                if (iArr[0] == 0) {
                    normalUserFooterPreference = (NormalUserFooterPreference) this.ilB.YN("contact_info_footer_normal");
                    if (normalUserFooterPreference != null) {
                        normalUserFooterPreference.bjC();
                        return;
                    }
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.ezM : R.l.ezQ;
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(i2), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 5(this), new 6(this));
                    return;
                }
                return;
            case 82:
                if (iArr[0] == 0) {
                    normalUserFooterPreference = (NormalUserFooterPreference) this.ilB.YN("contact_info_footer_normal");
                    if (normalUserFooterPreference != null) {
                        normalUserFooterPreference.bjB();
                        return;
                    }
                    return;
                }
                h.a((Context) this, getString(R.l.ezP), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 7(this), null);
                return;
            default:
                return;
        }
    }
}
