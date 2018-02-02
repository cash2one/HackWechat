package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.y;
import com.tencent.mm.ar.b;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.k.g;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.appbrand.jsapi.media.e;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter$d;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.o;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.chatting.w;
import com.tencent.mm.ui.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class n {
    p fhr;
    protected ChatFooter one;
    private final ChatFooter$d vqf = new 1(this);
    private o yAc;
    protected ChatFooterCustom yAd;
    private int yAe = 0;
    private t yAf;
    private w yAg;
    private AnimationSet yAh;
    String yAi = null;
    private int yAj;
    private int yAk;
    private boolean yAl = false;
    public i yvL;
    public q yvR;
    public v yvT;
    public u yvY;
    public j yvZ;
    public c ywd;

    public n(p pVar) {
        this.fhr = pVar;
    }

    public final ChatFooter csB() {
        return this.one;
    }

    public final ChatFooterCustom csC() {
        return this.yAd;
    }

    public final void cqW() {
        boolean z = false;
        ar.Hg();
        aj WY = c.Fd().WY(this.fhr.csi().field_username);
        if (WY != null) {
            this.yAe = WY.field_chatmode;
        }
        x.d("MicroMsg.ChattingUI.FootMgr", "dkcm init old:%d   ", Integer.valueOf(this.yAe));
        String csk = this.fhr.csk();
        if (this.one == null) {
            this.one = (ChatFooter) this.fhr.csq().findViewById(R.h.cyG);
        }
        this.one.Co(R.h.bTA);
        x.i("MicroMsg.ChattingUI.FootMgr", "resetFooter customFooter is %s", this.yAd);
        if (this.yAd != null) {
            this.yAd.bAY();
            this.yAd.vqf = null;
            this.yAd.yqO = null;
            this.one.a(null);
            this.yAd.crl();
        }
        ctK();
        ChatFooter chatFooter = this.one;
        if (chatFooter.vpW != null) {
            chatFooter.vpW.setVisibility(0);
        }
        if (this.yvY.yAH || this.yvY.ysa) {
            ctK();
        } else if (s.gI(csk)) {
            ctK();
            g.a(this.fhr.csq(), R.h.cyF);
            boolean z2 = this.yAd == null;
            this.yAd = (ChatFooterCustom) this.fhr.csq().findViewById(R.h.cyH);
            if (z2) {
                this.yAd.k((ViewGroup) this.fhr.csq().findViewById(R.h.bTE));
            }
            this.yAf = new t(this.yAd);
            t tVar = this.yAf;
            z2 = f.fdS == 1;
            tVar.yub.findViewById(R.h.bUb).setVisibility(8);
            tVar.lHZ = (LinearLayout) tVar.yub.findViewById(R.h.bTX);
            tVar.yub.findViewById(R.h.bTW).setVisibility(8);
            tVar.lHZ.setWeightSum(z2 ? 1.0f : 2.0f);
            tVar.yuc = (FrameLayout) tVar.lHZ.getChildAt(0);
            tVar.yuc.setVisibility(0);
            tVar.yuc.setOnClickListener(tVar.yul);
            ((TextView) tVar.yuc.getChildAt(0).findViewById(R.h.bTZ)).setText(R.l.dQf);
            tVar.yuc.getChildAt(0).findViewById(R.h.bTY).setVisibility(8);
            tVar.yuc.getChildAt(1).setVisibility(8);
            int i;
            if (z2) {
                for (i = 1; i < 6; i++) {
                    tVar.lHZ.getChildAt(i).setVisibility(8);
                }
            } else {
                tVar.yud = (FrameLayout) tVar.lHZ.getChildAt(1);
                tVar.yud.setVisibility(0);
                tVar.yud.setOnClickListener(tVar.yum);
                tVar.yue = (TextView) tVar.yud.getChildAt(0).findViewById(R.h.bTZ);
                tVar.yuf = (ImageView) tVar.yud.getChildAt(0).findViewById(R.h.bTY);
                tVar.yuf.setVisibility(0);
                tVar.crV();
                ar.Hg();
                tVar.yuh = ((Integer) c.CU().get(a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(-1))).intValue();
                if (tVar.yuh >= 0) {
                    tVar.crX();
                } else {
                    tVar.yue.setText(R.l.dQs);
                }
                tVar.yud.getChildAt(1).setVisibility(8);
                for (i = 2; i < 6; i++) {
                    tVar.lHZ.getChildAt(i).setVisibility(8);
                }
                tVar.yuk = g.zZ().getMailAppEnterUlAndroid();
                if (bh.ov(tVar.yuk)) {
                    tVar.yuk = "qqmail://folderlist?app=weixin&action=list&uin=$uin$";
                }
                ar.Hg();
                tVar.yuk = tVar.yuk.replace("$uin$", new com.tencent.mm.a.o(bh.e((Integer) c.CU().get(9, null))).toString());
                tVar.puq = g.zZ().zO();
                tVar.yui = true;
            }
            ctI();
        } else {
            this.yAf = null;
            if (s.gB(csk)) {
                ctK();
                g.a(this.fhr.csq(), R.h.cyF);
                if (this.yAd == null) {
                    z = true;
                }
                this.yAd = (ChatFooterCustom) this.fhr.csq().findViewById(R.h.cyH);
                if (z) {
                    this.yAd.k((ViewGroup) this.fhr.csq().findViewById(R.h.bTE));
                }
                this.yAg = new w(this.yAd);
                this.yAg.cpo();
                ctI();
            } else {
                this.yAg = null;
                if (!(s.gJ(csk) || s.gB(csk) || s.gI(csk))) {
                    s.GE();
                    if (!s.hi(csk)) {
                        boolean z3;
                        q qVar;
                        ChatFooter csB;
                        ctJ();
                        W(this.fhr.csi());
                        ctO();
                        this.one.SA(csk);
                        this.one.cbm();
                        if (this.fhr.csA() != null && this.fhr.csA().ytm) {
                            x.w("MicroMsg.ChattingUI.FootMgr", "match shake, in show mode, do not open short video recode view");
                            z3 = false;
                        } else if (this.yvY.yAH || this.yvY.ysa) {
                            x.w("MicroMsg.ChattingUI.FootMgr", "match shake, in search mode, do not open short video recode view");
                            z3 = false;
                        } else if (com.tencent.mm.storage.x.Wz(this.fhr.csi().field_username) || com.tencent.mm.storage.x.gy(this.fhr.csi().field_username)) {
                            x.w("MicroMsg.ChattingUI.FootMgr", "match shake, but is Qcontact or Bcontact");
                            z3 = false;
                        } else {
                            z3 = !s.hn(this.fhr.csi().field_username);
                        }
                        if (!z3) {
                            this.one.cbw();
                        }
                        if (this.fhr.csf()) {
                            d jS = com.tencent.mm.ag.f.jS(this.fhr.crz());
                            if (jS == null || jS.field_enterpriseFather == null) {
                                z3 = false;
                            } else {
                                Cursor jM = y.Mf().jM(jS.field_enterpriseFather);
                                z3 = jM != null && jM.getCount() > 0;
                                if (jM != null) {
                                    jM.close();
                                }
                            }
                            if (z3) {
                                AppPanel appPanel = this.one.vpT;
                                appPanel.voY.vpN.value = true;
                                appPanel.cbe();
                            }
                        }
                        if (!this.fhr.cse()) {
                            this.one.cbJ();
                        }
                        if (!(this.fhr.csi() == null || com.tencent.mm.l.a.fZ(this.fhr.csi().field_type) || s.eV(this.fhr.csi().field_username))) {
                            this.one.cbC();
                        }
                        if (com.tencent.mm.storage.x.gy(csk)) {
                            this.one.cby();
                            this.one.cbF();
                            this.one.cbG();
                            this.one.cbx();
                            this.one.cbz();
                            this.one.cbE();
                            this.one.cbB();
                            this.one.cbC();
                            this.one.cbD();
                            this.one.cbK();
                        }
                        if (com.tencent.mm.storage.x.Wz(csk)) {
                            this.one.cby();
                            this.one.cbF();
                            this.one.cbG();
                            this.one.cbx();
                            this.one.cbz();
                            this.one.cbE();
                            this.one.cbB();
                            this.one.cbC();
                            this.one.cbD();
                            this.one.cbK();
                        }
                        if (com.tencent.mm.storage.x.Wx(csk)) {
                            this.one.cby();
                            this.one.cbF();
                            this.one.cbG();
                            this.one.cbx();
                            this.one.cbu();
                            this.one.cbz();
                            this.one.cbE();
                            this.one.cbB();
                            this.one.cbC();
                            this.one.cbD();
                            this.one.cbK();
                        }
                        if (s.gU(csk)) {
                            this.one.cby();
                            this.one.cbF();
                            this.one.cbG();
                            this.one.cbz();
                            this.one.cbE();
                            this.one.cbB();
                            this.one.cbC();
                            this.one.cbD();
                            this.one.cbK();
                        }
                        if (s.gR(csk)) {
                            this.one.cby();
                            this.one.cbB();
                            this.one.cbE();
                            this.one.cbK();
                        }
                        ar.Hg();
                        com.tencent.mm.storage.x WO = c.EY().WO(csk);
                        if (WO != null && WO.cia()) {
                            this.one.cby();
                            this.one.cbB();
                            this.one.cbx();
                            this.one.cbE();
                        }
                        if (this.fhr.cse()) {
                            if (g.zY().getInt("MultitalkBlockCaller", 0) == 0) {
                                this.one.lj(false);
                                if (this.fhr.cse() || this.fhr.csh()) {
                                    this.one.cbB();
                                    this.one.cbD();
                                }
                                com.tencent.mm.bm.d.ccW();
                                if (this.fhr.csh()) {
                                    this.one.cbE();
                                }
                                if (this.fhr.crz().equals(q.FS())) {
                                    this.one.cbE();
                                    this.one.cbB();
                                    this.one.cbC();
                                    this.one.cbD();
                                }
                                if (this.fhr.csf()) {
                                    this.one.cby();
                                    this.one.cbG();
                                    this.one.cbx();
                                    this.one.cbE();
                                    this.one.cbB();
                                    this.one.cbC();
                                    this.one.cbD();
                                    this.one.cbw();
                                    this.one.cbA();
                                    this.one.cbv();
                                    this.one.cbI();
                                    this.one.tj();
                                }
                                this.one.li(com.tencent.mm.bm.d.ccW());
                                chatFooter = this.one;
                                com.tencent.mm.bm.d.ccW();
                                if (b.PP()) {
                                    z = true;
                                }
                                chatFooter.lk(z);
                                this.one.cbE();
                                this.fhr.csS();
                                qVar = this.yvR;
                                if (qVar.fhr.csl()) {
                                    qVar.fhr.csB().vqi = true;
                                    csB = qVar.fhr.csB();
                                    if (csB.vpY != null) {
                                        csB.vpY.setVisibility(8);
                                    }
                                    chatFooter = qVar.fhr.csB();
                                    if (chatFooter.vpW != null) {
                                        chatFooter.vpW.setVisibility(8);
                                    }
                                }
                            }
                        }
                        this.one.lj(true);
                        this.one.cbB();
                        this.one.cbD();
                        com.tencent.mm.bm.d.ccW();
                        if (this.fhr.csh()) {
                            this.one.cbE();
                        }
                        if (this.fhr.crz().equals(q.FS())) {
                            this.one.cbE();
                            this.one.cbB();
                            this.one.cbC();
                            this.one.cbD();
                        }
                        if (this.fhr.csf()) {
                            this.one.cby();
                            this.one.cbG();
                            this.one.cbx();
                            this.one.cbE();
                            this.one.cbB();
                            this.one.cbC();
                            this.one.cbD();
                            this.one.cbw();
                            this.one.cbA();
                            this.one.cbv();
                            this.one.cbI();
                            this.one.tj();
                        }
                        this.one.li(com.tencent.mm.bm.d.ccW());
                        chatFooter = this.one;
                        com.tencent.mm.bm.d.ccW();
                        if (b.PP()) {
                            z = true;
                        }
                        chatFooter.lk(z);
                        this.one.cbE();
                        this.fhr.csS();
                        qVar = this.yvR;
                        if (qVar.fhr.csl()) {
                            qVar.fhr.csB().vqi = true;
                            csB = qVar.fhr.csB();
                            if (csB.vpY != null) {
                                csB.vpY.setVisibility(8);
                            }
                            chatFooter = qVar.fhr.csB();
                            if (chatFooter.vpW != null) {
                                chatFooter.vpW.setVisibility(8);
                            }
                        }
                    }
                }
                ctK();
            }
        }
        ctF();
        ctM();
        this.yAc = new o(this.fhr.csx(), this.fhr.csy(), this.fhr, this.one, this.fhr.csk());
        this.yAc.ysm = this.fhr.csq().getBooleanExtra("key_need_send_video", true).booleanValue();
        this.one.vqe = this.yAc;
        Object vVar = new v(this.fhr.csq().getContext(), this.fhr.csi(), this.fhr.csk());
        this.one.b(vVar);
        this.one.a(vVar);
        ctO();
        this.one.cbH();
        ctM();
        W(this.fhr.csi());
    }

    public final void bf() {
        if (this.one != null) {
            this.one.vqe = null;
            this.yAc = null;
            this.one.b(null);
            this.one.a(null);
        }
        if (this.yAd != null) {
            this.yAd.bAY();
            this.yAd = null;
        }
        ctF();
        if (this.yAd != null) {
            this.yAd.crl();
        }
        i.clearCache();
        if (this.one != null) {
            ChatFooter chatFooter = this.one;
            if (chatFooter.vqd != null) {
                chatFooter.vqd.vrJ = false;
                chatFooter.vqd.hide();
            }
        }
        if (this.fhr.csq().isCurrentActivity && this.one != null) {
            this.one.destroy();
        }
    }

    private void ctF() {
        if (!this.fhr.csq().isCurrentActivity) {
            if (this.fhr.csz() != null) {
                this.fhr.csz().mp(true);
            }
            if (this.one != null) {
                ChatFooter chatFooter = this.one;
                View findViewById = chatFooter.findViewById(R.h.bUF);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                chatFooter.Cm(0);
                chatFooter.mHandler.removeMessages(1002);
                if (chatFooter.vpY != null) {
                    chatFooter.vpY.setVisibility(8);
                }
                if (chatFooter.vpZ != null) {
                    chatFooter.vpZ.setVisibility(8);
                }
                if (chatFooter.vqa != null) {
                    chatFooter.vqa.setVisibility(8);
                }
                if (chatFooter.myF != null) {
                    chatFooter.myF.setVisibility(8);
                }
                chatFooter.okw.setVisibility(8);
                if (chatFooter.myH != null) {
                    chatFooter.myH.setVisibility(8);
                }
                if (chatFooter.myI != null) {
                    chatFooter.myI.setVisibility(8);
                }
                if (chatFooter.myG != null) {
                    chatFooter.myG.setVisibility(8);
                }
                if (chatFooter.vlG != null) {
                    chatFooter.vlG.setVisibility(8);
                    chatFooter.vlJ = false;
                    chatFooter.vlG.destroy();
                    if (chatFooter.okv != null) {
                        chatFooter.okv.setVisibility(0);
                    }
                }
                if (chatFooter.myF != null) {
                    chatFooter.myF.setVisibility(8);
                }
                if (chatFooter.scs != null) {
                    chatFooter.scs.setVisibility(8);
                }
                if (chatFooter.scp != null) {
                    chatFooter.scp.update();
                }
                if (chatFooter.vpU != null) {
                    chatFooter.vpU.setVisibility(8);
                }
                if (chatFooter.vpX != null) {
                    chatFooter.vpX.setVisibility(8);
                }
                chatFooter.vpT = (AppPanel) chatFooter.findViewById(R.h.bSO);
                if (chatFooter.vpT != null) {
                    chatFooter.vpT.setVisibility(8);
                    AppPanel appPanel = chatFooter.vpT;
                    if (appPanel.pZj != null) {
                        appPanel.pZj.EL(0);
                    }
                }
                if (chatFooter.okx != null) {
                    chatFooter.okx.destroy();
                    chatFooter.vpX.removeView(chatFooter.okx);
                    chatFooter.okx = null;
                }
                chatFooter.cbT();
                ChatFooter chatFooter2 = this.one;
                chatFooter2.okv.setText("");
                chatFooter2.lh(false);
                this.one.vqg.vre = null;
            }
        }
    }

    public final void ctn() {
        String str;
        this.yAi = this.fhr.csq().getStringExtra("smiley_product_id");
        if (this.one.cbU()) {
            this.yvL.keepSignalling();
        }
        if (s.gI(this.fhr.crz()) && this.yAf != null && this.yAf.yui) {
            this.yAf.crW();
        }
        ChatFooter chatFooter = this.one;
        u csq = this.fhr.csq();
        chatFooter.vqt = csq;
        if (!chatFooter.vlJ) {
            chatFooter.findViewById(R.h.bTV).setVisibility(0);
        }
        chatFooter.a(csq.getContext(), csq.thisActivity());
        chatFooter.vqY = true;
        if (!(bh.ov(this.yAi) || this.one == null)) {
            x.d("MicroMsg.ChattingUI.FootMgr", "deal use smiley panel in product: %s", this.yAi);
            chatFooter = this.one;
            str = this.yAi;
            if (!bh.ov(str)) {
                if (chatFooter.okx == null) {
                    chatFooter.cbo();
                }
                chatFooter.okx.cf(str);
            }
            this.one.cbq();
        }
        this.fhr.csq().getContext().getIntent().putExtra("smiley_product_id", "");
        this.one.SA(this.fhr.csi().field_username);
        chatFooter = this.one;
        str = this.fhr.csv();
        String crz = this.fhr.crz();
        chatFooter.fzO = str;
        chatFooter.toUser = crz;
        if (this.fhr.csq().getBooleanExtra("key_show_bottom_app_panel", false).booleanValue()) {
            chatFooter = this.one;
            if (chatFooter.vpY != null) {
                chatFooter.vpY.performClick();
                x.d("MicroMsg.ChatFooter", "perform click attach bt to show bottom panel");
            }
        }
        if (W(this.fhr.csi())) {
            if (this.one != null) {
                ar.Hg();
                boolean booleanValue = ((Boolean) c.CU().get(66832, Boolean.valueOf(false))).booleanValue();
                x.d("MicroMsg.ChattingUI.FootMgr", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", Boolean.valueOf(booleanValue));
                this.one.cbV();
                if (booleanValue) {
                    this.one.cbL();
                    this.one.cbH();
                }
                if (booleanValue) {
                    this.one.cbv();
                }
                chatFooter = this.one;
                if (chatFooter.vpT != null) {
                    chatFooter.vpT.cbd();
                }
            }
            this.yvZ.ctB();
            if (this.one != null) {
                this.one.vpT.refresh();
                this.one.addTextChangedListener(new a(this, (byte) 0));
                x.i("MicroMsg.ChattingUI.FootMgr", "addTextChangedListener");
            }
        }
        if (this.yvY.yAH || this.yvY.ysa || ((this.fhr.csA() != null && this.fhr.csA().ytm) || this.fhr.csi() == null || this.fhr.csi().cia() || s.hk(this.fhr.csi().field_username) || com.tencent.mm.ui.snackbar.a.aHh())) {
            x.i("MicroMsg.ChattingUI.FootMgr", "no call visibleFooter again.");
            return;
        }
        x.i("MicroMsg.ChattingUI.FootMgr", "call visibleFooter again.");
        ctJ();
    }

    public final void ctG() {
        if (this.one != null) {
            ChatFooter chatFooter = this.one;
            if (chatFooter.vqz != null) {
                chatFooter.okv.removeTextChangedListener(chatFooter.vqz);
                chatFooter.vqz = null;
            }
            x.i("MicroMsg.ChattingUI.FootMgr", "removeTextChangeListener");
            this.one.onPause();
            if (com.tencent.mm.kernel.g.Dh().Cy()) {
                ar.Hg();
                c.CU().set(18, Integer.valueOf(this.one.vql));
                x.d("MicroMsg.ChattingUI.FootMgr", "dkcm old:%d footer:%d ", Integer.valueOf(this.yAe), Integer.valueOf(this.one.vql));
                if (this.yAe != this.one.vql) {
                    this.yAe = this.one.vql;
                    ar.Hg();
                    ae WY = c.Fd().WY(this.fhr.crz());
                    if (WY != null && this.fhr.crz().equals(WY.field_username)) {
                        WY.eP(this.yAe);
                        ar.Hg();
                        c.Fd().a(WY, this.fhr.crz());
                    }
                }
                this.one.aJO();
                return;
            }
            x.w("MicroMsg.ChattingUI.FootMgr", "account not ready");
        }
    }

    public final boolean e(int i, Intent intent) {
        if (!(i == e.CTRL_INDEX || this.yAd == null)) {
            this.yAd.j(i, intent);
        }
        switch (i) {
            case 202:
                if (intent == null) {
                    x.e("MicroMsg.ChattingUI.FootMgr", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                    return true;
                }
                int intExtra = intent.getIntExtra("Chat_Mode", 1);
                if (this.one == null) {
                    return true;
                }
                this.one.aa(intExtra, true);
                return true;
            default:
                return false;
        }
    }

    public final void ctH() {
        try {
            if (this.one.cbN()) {
                this.one.cbP();
            }
        } catch (Exception e) {
        }
    }

    public final void ctI() {
        x.i("MicroMsg.ChattingUI.FootMgr", "visibleCustomFooter customFooter is %s", this.yAd);
        if (this.yAd != null) {
            this.yAd.setVisibility(0);
            if (this.one != null) {
                this.one.setVisibility(8);
            }
        }
    }

    public final void ctJ() {
        if (this.one != null) {
            this.one.setVisibility(0);
            if (this.yAd != null) {
                this.yAd.setVisibility(8);
            }
        }
    }

    private void ctK() {
        if (this.one != null) {
            this.one.setVisibility(8);
        }
        if (this.yAd != null) {
            this.yAd.setVisibility(8);
        }
    }

    public final void ctL() {
        this.yAh = new AnimationSet(false);
        Animation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.yAh.setInterpolator(new DecelerateInterpolator(DownloadHelper.SAVE_FATOR));
        this.yAh.addAnimation(translateAnimation);
        this.yAh.addAnimation(alphaAnimation);
        this.yAh.setDuration(300);
        this.yAh.setFillBefore(true);
        if (this.one != null) {
            this.one.startAnimation(this.yAh);
        }
    }

    private void ctM() {
        x.i("MicroMsg.ChattingUI.FootMgr", "isTempSession : %s, showType : %d.", Boolean.valueOf(this.fhr.csj()), Integer.valueOf(this.fhr.csq().getIntExtra("key_temp_session_show_type", 0)));
        ar.Hg();
        aj WY = c.Fd().WY(this.fhr.csi().field_username);
        if (this.fhr.csj()) {
            ar.CG().a(new k(this.fhr.csk(), this.fhr.csq().getIntExtra("key_temp_session_scene", 5), this.fhr.csq().getStringExtra("key_temp_session_from")), 0);
        }
        if (!this.fhr.csi().cia() || com.tencent.mm.l.a.fZ(this.fhr.csi().field_type)) {
            this.fhr.mH(false);
        } else if (WY == null) {
            if (this.fhr.csj()) {
                ae aeVar = new ae(this.fhr.csi().field_username);
                aeVar.gb(4194304);
                aeVar.ciy();
                ar.Hg();
                c.Fd().d(aeVar);
            }
        } else if (WY.gc(4194304)) {
            this.fhr.mH(true);
        } else if (WY.field_conversationTime < y.Mr()) {
            ar.Hg();
            r1 = c.Fd().a(this.fhr.csi().field_username, 4194304, true, WY.field_attrflag);
            x.i("MicroMsg.ChattingUI.FootMgr", "It is a old version temp session, Set attr flag(talker : %s), %s", this.fhr.csi().field_username, Boolean.valueOf(r1));
            this.fhr.mH(true);
        } else if (this.fhr.csj()) {
            ar.Hg();
            r1 = c.Fd().a(this.fhr.csi().field_username, 4194304, true, WY.field_attrflag);
            x.i("MicroMsg.ChattingUI.FootMgr", "It is a temp session, Set attr flag(talker : %s), %s", this.fhr.csi().field_username, Boolean.valueOf(r1));
        }
        x.d("MicroMsg.ChattingUI.FootMgr", "is temp session : %s.", Boolean.valueOf(this.fhr.csj()));
        if (!this.fhr.csj()) {
            return;
        }
        if (r0 == 1) {
            this.vqf.ln(true);
        } else {
            this.vqf.ln(false);
        }
    }

    public final void ctN() {
        x.i("MicroMsg.ChattingUI.FootMgr", "triggerFooter");
        if (this.one == null) {
            this.one = (ChatFooter) this.fhr.csq().findViewById(R.h.cyG);
        }
        if ((this.fhr.csA() == null || !this.fhr.csA().ytm) && !com.tencent.mm.ui.snackbar.a.aHh()) {
            this.yAl = false;
            if (this.yAj == 8 && this.yAk == 8) {
                ctK();
                return;
            } else if (this.yAj == 0) {
                ctJ();
                return;
            } else {
                ctI();
                return;
            }
        }
        if (!this.yAl) {
            this.yAj = this.one.getVisibility();
        }
        this.one.p(0, -1, false);
        if (this.yAd == null) {
            this.yAk = -1;
        } else if (!this.yAl) {
            this.yAk = this.yAd.getVisibility();
        }
        ctK();
        this.yAl = true;
    }

    public final boolean W(com.tencent.mm.storage.x xVar) {
        if (this.yvY.yAH || this.yvY.ysa || (this.fhr.csA() != null && this.fhr.csA().ytm)) {
            ctK();
            return false;
        }
        if (!(xVar == null || !xVar.cia() || this.fhr.csn() == null)) {
            d.b bI = this.fhr.csn().bI(false);
            if (bI != null) {
                if (bI.hou != null) {
                    bI.how = "1".equals(bI.hou.optString("IsHideInputToolbarInMsg"));
                }
                if (bI.how) {
                    x.i("MicroMsg.ChattingUI.FootMgr", "bizinfo name=" + xVar.field_username + " is hide tool bar");
                    ctK();
                    return false;
                }
            }
            if (!(bh.ov(xVar.field_username) || bI == null)) {
                int intExtra = this.fhr.csq().getIntExtra("key_temp_session_show_type", 0);
                switch (bI.Lw()) {
                    case 2:
                        x.i("MicroMsg.ChattingUI.FootMgr", "bizinfo name=" + xVar.field_username + " is show custom menu");
                        if (this.yAd == null) {
                            g.a(this.fhr.csq(), R.h.cyF);
                            this.yAd = (ChatFooterCustom) this.fhr.csq().findViewById(R.h.cyH);
                            this.yAd.k((ViewGroup) this.fhr.csq().findViewById(R.h.bTE));
                        }
                        d.b.c LE = bI.LE();
                        if (LE != null && LE.type == 1) {
                            this.one.Cm(1);
                            this.one.a(this.ywd.ypT);
                            ctJ();
                            break;
                        }
                        this.one.Cm(0);
                        try {
                            if (!s.gB(xVar.field_username)) {
                                ChatFooterCustom chatFooterCustom = this.yAd;
                                if (chatFooterCustom.yqM != null) {
                                    chatFooterCustom.yqM.setVisibility(0);
                                }
                                if (chatFooterCustom.yqN != null) {
                                    chatFooterCustom.yqN.cro();
                                }
                                this.yAd.fAh = this.fhr.csi();
                                this.yAd.a(this.fhr.csq(), this.fhr.csn(), xVar.field_username);
                                this.yAd.vqf = this.vqf;
                                this.yAd.yqO = this.ywd.yyO;
                                this.one.a(this.vqf);
                                if (!this.fhr.csj() || intExtra != 1) {
                                    ctI();
                                    break;
                                }
                                ctJ();
                                break;
                            }
                            this.yAg = new w(this.yAd);
                            this.yAg.cpo();
                            ctI();
                            break;
                        } catch (Throwable e) {
                            if (LE == null || LE.hpe == null || LE.hpe.size() == 0) {
                                ctJ();
                            } else {
                                this.vqf.ln(true);
                            }
                            x.printErrStackTrace("MicroMsg.ChattingUI.FootMgr", e, "", new Object[0]);
                            break;
                        }
                        break;
                    default:
                        boolean z;
                        ctJ();
                        String str = "MicroMsg.ChattingUI.FootMgr";
                        String str2 = "bizinfo name=%s, %b, %d";
                        Object[] objArr = new Object[3];
                        objArr[0] = xVar.field_username;
                        if (bI != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objArr[1] = Boolean.valueOf(z);
                        objArr[2] = Integer.valueOf(bI.Lw());
                        x.e(str, str2, objArr);
                        break;
                }
            }
        }
        return true;
    }

    public final void ctO() {
        int i;
        String csk = this.fhr.csk();
        if (s.gK(csk) || com.tencent.mm.storage.x.Wx(csk)) {
            i = 1;
        } else if (s.ha(csk)) {
            i = 2;
        } else {
            i = this.fhr.csq().getIntExtra("Chat_Mode", 0);
            x.d("MicroMsg.ChattingUI.FootMgr", "dkcm getChatMode old:%d intent:%d ", Integer.valueOf(this.yAe), Integer.valueOf(i));
            if (this.yAe != 0) {
                i = this.yAe;
            }
            String value = g.zY().getValue("DefaultMsgType");
            if (this.yAe == 0 && value != null) {
                x.d("MicroMsg.ChattingUI.FootMgr", "config def chatmode is %s", value);
                i = bh.getInt(g.zY().getValue("DefaultMsgType"), 0);
            }
            if (i == 0 && com.tencent.mm.l.a.fZ(this.fhr.csi().field_type)) {
                ar.Hg();
                i = ((Integer) c.CU().get(18, Integer.valueOf(0))).intValue();
            }
            if (i == 0) {
                i = 1;
            }
            x.d("MicroMsg.ChattingUI.FootMgr", "dkcm getChatMode old:%d intent:%d ", Integer.valueOf(this.yAe), Integer.valueOf(i));
        }
        if (i == 2) {
            x.i("MicroMsg.ChattingUI.FootMgr", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.fhr.csq().thisActivity(), "android.permission.RECORD_AUDIO", 80, "", "")), bh.cgy(), this.fhr.csq().thisActivity());
            if (com.tencent.mm.pluginsdk.g.a.a(this.fhr.csq().thisActivity(), "android.permission.RECORD_AUDIO", 80, "", "")) {
                this.one.aa(i, false);
                return;
            }
            return;
        }
        this.one.aa(i, false);
    }

    public final void ctP() {
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper setFooterMode mode[%d], footer[%s], stack[%s]", Integer.valueOf(2), this.one, bh.cgy());
        if (this.one != null) {
            this.one.aa(2, true);
        }
    }

    public final void crA() {
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper doOnEnterMultiTalk,footerEventImpl[%s], stack[%s]", this.yAc, bh.cgy());
        if (this.yAc != null) {
            this.yAc.crA();
        }
    }

    public final void ctQ() {
        int i = 0;
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper doFooterSightRequest,footerEventImpl[%s], stack[%s]", this.yAc, bh.cgy());
        if (this.yAc != null) {
            o oVar = this.yAc;
            if (!this.one.vpT.voY.vpK.value) {
                i = 2;
            }
            oVar.Ft(i);
        }
    }

    public final void crB() {
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper doOnVoipAudioRequest,footerEventImpl[%s], stack[%s]", this.yAc, bh.cgy());
        if (this.yAc != null) {
            this.yAc.crB();
        }
    }

    public final void crC() {
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper doOnVoipRequest,footerEventImpl[%s], stack[%s]", this.yAc, bh.cgy());
        if (this.yAc != null) {
            this.yAc.crC();
        }
    }

    public final void bjC() {
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper doVoipMenuVideoSelected,footerEventImpl[%s], stack[%s]", this.yAc, bh.cgy());
        if (this.yAc != null) {
            this.yAc.bjC();
        }
    }

    public final void bjB() {
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper doVoipMenuAudioSelected,footerEventImpl[%s], stack[%s]", this.yAc, bh.cgy());
        if (this.yAc != null) {
            this.yAc.bjB();
        }
    }

    public final void crD() {
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper doTalkRoomRequest,footerEventImpl[%s], stack[%s]", this.yAc, bh.cgy());
        if (this.yAc != null) {
            this.yAc.crD();
        }
    }

    public final void crE() {
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper doImageSelectTakePhotoRequest,footerEventImpl[%s], stack[%s]", this.yAc, bh.cgy());
        if (this.yAc != null) {
            this.yAc.crE();
        }
    }
}
