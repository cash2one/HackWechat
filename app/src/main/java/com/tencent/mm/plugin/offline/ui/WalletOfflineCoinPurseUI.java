package com.tencent.mm.plugin.offline.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.bu;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.kq;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.g.a.le;
import com.tencent.mm.g.a.st;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.q;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s$f;
import com.tencent.mm.plugin.offline.a.s$h;
import com.tencent.mm.plugin.offline.b;
import com.tencent.mm.plugin.offline.g;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.offline.ui.OfflineAlertView.2;
import com.tencent.mm.plugin.offline.ui.OfflineAlertView.8;
import com.tencent.mm.plugin.offline.ui.b.4;
import com.tencent.mm.plugin.offline.ui.c.1;
import com.tencent.mm.plugin.offline.ui.c.11;
import com.tencent.mm.plugin.offline.ui.c.13;
import com.tencent.mm.plugin.offline.ui.c.14;
import com.tencent.mm.plugin.offline.ui.c.15;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av$a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.i$a;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WalletOfflineCoinPurseUI extends WalletBaseUI implements com.tencent.mm.platformtools.j.a, com.tencent.mm.plugin.offline.a.s.a, b, a, av$a {
    private static int jUA = 0;
    private int hze = -1;
    private OnClickListener inN = new 14(this);
    private int kFm;
    private boolean kRg = true;
    private boolean lzK;
    private long mLastTime = 0;
    private int mState = 3;
    private int mfA;
    private String oVO = "";
    private m oVQ;
    private int oVS = 60000;
    private ak oVT = new ak(new 30(this), false);
    private String oVl = "";
    private HashMap<String, View> oXO = new HashMap();
    private HashMap<String, Integer> oXP = new HashMap();
    Bitmap oXQ = null;
    Bitmap oXR = null;
    private a oXS;
    private ArrayList<String> oXT = new ArrayList();
    private ArrayList<String> oXU = new ArrayList();
    private ArrayList<Boolean> oXV = new ArrayList();
    View oXW;
    private ImageView oXX;
    private ImageView oXY;
    private TextView oXZ;
    private c oYA = new 36(this);
    private c oYB = new 37(this);
    private c oYC = new 38(this);
    public boolean oYD = false;
    private HashMap<String, Integer> oYE = new HashMap();
    private ak oYF = new ak(new 31(this), false);
    private ak oYG = new ak(new com.tencent.mm.sdk.platformtools.ak.a(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI oYH;

        {
            this.oYH = r1;
        }

        public final boolean uF() {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "onTimerExpired, send ConsumedCardByOfflinePay event: %s", new Object[]{Boolean.valueOf(this.oYH.lzK)});
            if (this.oYH.lzK) {
                com.tencent.mm.sdk.b.b buVar = new bu();
                buVar.fpX.bjW = 0;
                com.tencent.mm.sdk.b.a.xef.m(buVar);
            }
            this.oYH.finish();
            return false;
        }
    }, false);
    private String oYa;
    private View oYb;
    private TextView oYc;
    private ImageView oYd;
    RelativeLayout oYe;
    private LinearLayout oYf;
    private LinearLayout oYg;
    private LinearLayout oYh;
    private LinearLayout oYi;
    private LinearLayout oYj;
    private Dialog oYk;
    private String oYl = "";
    private boolean oYm = false;
    private g oYn;
    private boolean oYo = false;
    private ArrayList<Bitmap> oYp = new ArrayList();
    private ArrayList<Bitmap> oYq = new ArrayList();
    private com.tencent.mm.wallet_core.ui.c oYr;
    private c oYs;
    OfflineAlertView oYt;
    private boolean oYu = false;
    c<sz> oYv = new c<sz>(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI oYH;

        {
            this.oYH = r2;
            this.xen = sz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            sz szVar = (sz) bVar;
            com.tencent.mm.sdk.b.a.xef.c(this);
            if (com.tencent.mm.plugin.offline.c.a.bij() && szVar.fLs.result == 0) {
                this.oYH.oYm = false;
            }
            return false;
        }
    };
    private c<cg> oYw = new 12(this);
    private c<le> oYx = new 23(this);
    private c<kq> oYy = new c<kq>(this) {
        final /* synthetic */ WalletOfflineCoinPurseUI oYH;

        {
            this.oYH = r2;
            this.xen = kq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            this.oYH.b(new com.tencent.mm.plugin.wallet_core.c.x(null, 8), false);
            this.oYH.bhA();
            this.oYH.bhB();
            this.oYH.bhy();
            return false;
        }
    };
    private c<kr> oYz = new 35(this);

    class a extends BaseAdapter {
        ArrayList<String> jRt = new ArrayList();
        final /* synthetic */ WalletOfflineCoinPurseUI oYH;
        ArrayList<Boolean> oZf = new ArrayList();

        public a(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
            this.oYH = walletOfflineCoinPurseUI;
        }

        public final int getCount() {
            return this.jRt.size();
        }

        public final Object getItem(int i) {
            return this.jRt.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final boolean isEnabled(int i) {
            return ((Boolean) this.oZf.get(i)).booleanValue();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.oYH, com.tencent.mm.plugin.wxpay.a.g.uFe, null);
            checkedTextView.setText((String) this.jRt.get(i));
            if (WalletOfflineCoinPurseUI.jUA == i) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            if (isEnabled(i)) {
                checkedTextView.setTextColor(this.oYH.getResources().getColor(a$c.btv));
                checkedTextView.setEnabled(true);
            } else {
                checkedTextView.setTextColor(this.oYH.getResources().getColor(a$c.bsO));
                checkedTextView.setEnabled(false);
            }
            return checkedTextView;
        }
    }

    static /* synthetic */ boolean a(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, s$h com_tencent_mm_plugin_offline_a_s_h) {
        if ("1".equals(com_tencent_mm_plugin_offline_a_s_h.fKP)) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "need realname verify");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceFetchUI");
            bundle.putString("realname_verify_process_jump_plugin", "wallet");
            walletOfflineCoinPurseUI.aYf();
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(walletOfflineCoinPurseUI, bundle, 0);
        } else if ("2".equals(com_tencent_mm_plugin_offline_a_s_h.fKP)) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "need upload credit");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(walletOfflineCoinPurseUI, com_tencent_mm_plugin_offline_a_s_h.fKQ, com_tencent_mm_plugin_offline_a_s_h.fKT, com_tencent_mm_plugin_offline_a_s_h.fKR, com_tencent_mm_plugin_offline_a_s_h.fKS, walletOfflineCoinPurseUI.aYf(), null);
        } else {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "realnameGuideFlag =  " + com_tencent_mm_plugin_offline_a_s_h.fKP);
            return false;
        }
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        View inflate = getLayoutInflater().inflate(com.tencent.mm.plugin.wxpay.a.g.uFd, null);
        ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(f.bJe);
        if (this.oXS == null) {
            this.oXS = new a(this);
        }
        if (i == 1) {
            a aVar = this.oXS;
            Collection collection = this.oXT;
            Collection collection2 = this.oXV;
            if (collection != null) {
                aVar.jRt.clear();
                aVar.jRt.addAll(collection);
            }
            if (collection2 != null) {
                aVar.oZf.clear();
                aVar.oZf.addAll(collection2);
            }
        }
        listViewInScrollView.setAdapter(this.oXS);
        this.oXS.notifyDataSetChanged();
        listViewInScrollView.setOnItemClickListener(new 18(this, i));
        i$a com_tencent_mm_ui_base_i_a = new i$a(this);
        if (i == 1) {
            com_tencent_mm_ui_base_i_a.Ez(i.uXx);
        }
        com_tencent_mm_ui_base_i_a.dk(inflate);
        com_tencent_mm_ui_base_i_a.d(null);
        return com_tencent_mm_ui_base_i_a.akx();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k.oWd = true;
        e.HF(41);
        Intent intent = getIntent();
        this.oYo = intent.getBooleanExtra("is_offline_create", false);
        if (intent != null && intent.hasExtra("key_entry_scene")) {
            this.hze = intent.getIntExtra("key_entry_scene", this.hze);
        }
        this.kFm = intent.getIntExtra("key_from_scene", 0);
        this.oYa = bh.az(intent.getStringExtra("key_business_attach"), "");
        this.mfA = 1;
        if (this.hze == 2) {
            this.mfA = 1;
        } else if (this.hze == 1) {
            this.mfA = 2;
        } else if (this.hze == 8) {
            this.mfA = 4;
        } else if (this.hze == 4) {
            this.mfA = 6;
        } else {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %d", new Object[]{Integer.valueOf(this.mfA)});
        }
        ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
        uD(0);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a$c.ubD)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(f.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(a$c.bsL));
            }
            customView = customView.findViewById(16908309);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(a$c.white));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(a$c.ubE));
        }
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        setBackBtn(new 33(this));
        e.cCg();
        if (!q.isEnabled()) {
            b(new com.tencent.mm.plugin.wallet_core.c.x(null, 8), false);
        }
        if (o.bLq().bLL()) {
            x.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is invalid");
        } else if (o.bLq().bLJ()) {
            x.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is isUnreg");
            com.tencent.mm.plugin.offline.c.a.bhS();
            k.bgX();
            k.au(196648, "0");
        } else if (o.bLq().bLM() && com.tencent.mm.plugin.offline.c.a.bhH()) {
            bhE();
        }
        initView();
        j.a(this);
        k.bgX();
        k.bgY().a(this);
        ji(606);
        ji(609);
        ji(1501);
        k.bgX();
        k.bgZ().bF(this);
        com.tencent.mm.sdk.b.a.xef.b(this.oYC);
        com.tencent.mm.plugin.offline.c.a.bhT();
        com.tencent.mm.sdk.b.a.xef.a(this.oYA);
        com.tencent.mm.sdk.b.a.xef.a(this.oYy);
        com.tencent.mm.sdk.b.a.xef.a(this.oYv);
        this.oYw.ceO();
        this.oYx.ceO();
        this.oYn = new g();
        com.tencent.mm.sdk.b.b krVar = new kr();
        krVar.fCc.aen = hashCode();
        com.tencent.mm.sdk.b.a.xef.m(krVar);
        this.oYz.ceO();
    }

    private void bhp() {
        bhA();
        bhC();
        bhB();
        bhy();
    }

    public void onResume() {
        boolean z;
        super.onResume();
        com.tencent.mm.sdk.b.a.xef.b(this.oYB);
        av.a(this);
        if (!this.oYu) {
            bhp();
            this.oYu = true;
        }
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on resume");
        this.lzK = true;
        com.tencent.mm.plugin.walletlock.a.b bVar = (com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.walletlock.a.b.class);
        bVar.a(this, bVar.bNx(), null);
        if (an.isNetworkConnected(getBaseContext())) {
            if (o.bLq().bLL()) {
                r(new com.tencent.mm.plugin.wallet_core.c.x(null, 8));
            }
            if (com.tencent.mm.plugin.offline.c.a.bhH()) {
                k.bgX();
                k.bha().hd(false);
                if (!c.bhn()) {
                    if (q.isEnabled()) {
                        b(new q(com.tencent.mm.plugin.offline.c.a.oZq), false);
                    } else {
                        bhw();
                    }
                }
            }
        }
        bhs();
        Bankcard bhJ = com.tencent.mm.plugin.offline.c.a.bhJ();
        if (bhJ == null || bhJ.field_bindSerial == null || bhJ.field_bindSerial.equals(this.oVl)) {
            z = false;
        } else {
            this.oVl = bhJ.field_bindSerial;
            k.bgX();
            k.bgZ().oVl = this.oVl;
            z = true;
        }
        if (z) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "onresume BindSerial isChange");
            bhx();
            up(0);
            he(true);
        }
        g gVar = this.oYn;
        if (com.tencent.mm.plugin.offline.c.a.bij()) {
            x.i(g.TAG, "OFFLINEGETMSGLOGIN START; IS stopped=" + gVar.oVF.cfK());
            if (gVar.oVF == null || gVar.oVF.cfK()) {
                gVar.status = 1;
                com.tencent.mm.plugin.report.service.g.pQN.a(135, 61, 1, true);
                long j;
                int i;
                if (gVar.oVE) {
                    g.bgT();
                    j = (long) g.oVo;
                    gVar.oVF.J(j, j);
                    i = g.oVo;
                    return;
                }
                j = (long) g.oVC;
                gVar.oVF.J(j, j);
                i = g.oVC;
                return;
            }
            return;
        }
        x.i(g.TAG, "OfflineGetMsg is not in abtest");
    }

    private void bhq() {
        e.HF(32);
        h.W(this, this.mfA);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on new intent");
    }

    public void onPause() {
        k.bgX();
        com.tencent.mm.plugin.offline.i bha = k.bha();
        bha.mHandler.removeCallbacks(bha.oVR);
        av.a(null);
        this.lzK = false;
        com.tencent.mm.sdk.b.a.xef.c(this.oYB);
        this.oYn.stop();
        super.onPause();
    }

    public void onDestroy() {
        k.oWd = false;
        e.u(this.oXQ);
        e.u(this.oXR);
        e.an(this.oYp);
        e.an(this.oYq);
        this.oYp.clear();
        this.oYq.clear();
        this.oXT.clear();
        this.oXU.clear();
        this.oXV.clear();
        j.c(this);
        k.bgX();
        k.bgY().b(this);
        jj(606);
        jj(609);
        jj(1501);
        k.bgX();
        k.bgZ().bG(this);
        com.tencent.mm.sdk.b.a.xef.c(this.oYC);
        com.tencent.mm.sdk.b.a.xef.c(this.oYA);
        com.tencent.mm.sdk.b.a.xef.c(this.oYv);
        if (!this.oVT.cfK()) {
            this.oVT.TG();
        }
        if (!this.oYG.cfK()) {
            this.oYG.TG();
        }
        if (this.oYr != null) {
            this.oYr.release();
        }
        if (this.oYs != null) {
            c cVar = this.oYs;
            cVar.kEd.cancel();
            cVar.mActivity = null;
        }
        com.tencent.mm.sdk.b.a.xef.c(this.oYy);
        this.oYw.dead();
        this.oYx.dead();
        g gVar = this.oYn;
        gVar.stop();
        g.bgT();
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(385, gVar.oVD);
        gVar.oVF = null;
        this.oYz.dead();
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "errType:" + i + "  errCode" + i2 + " errMsg:" + str + " scene: " + kVar);
        if ((kVar instanceof com.tencent.mm.plugin.offline.a.f) && ((i == 0 && i2 == 0) || i != 0)) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            this.oVQ.bhe();
            this.oVQ = null;
        }
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.x) {
                if (com.tencent.mm.plugin.offline.c.a.bhH()) {
                    if (com.tencent.mm.plugin.offline.c.a.bhK() != null) {
                        bhw();
                    }
                    bhE();
                }
                bhC();
            } else if (kVar instanceof m) {
                this.oVQ = (m) kVar;
                String str2 = this.oVQ.oWQ;
                k.bgX();
                com.tencent.mm.ae.k fVar = new com.tencent.mm.plugin.offline.a.f(str2, k.un(196617));
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Di().gPJ.a(fVar, 0);
            } else if (kVar instanceof com.tencent.mm.plugin.offline.a.j) {
                bhs();
                bhp();
            } else if (kVar instanceof n) {
                n nVar = (n) kVar;
                if ("1".equals(nVar.oWV)) {
                    x.w("MicroMsg.WalletOfflineCoinPurseUI", "hy: should pause. showFirstPostTip alert to finish");
                    com.tencent.mm.ui.base.h.a(this, bh.ov(nVar.oWW) ? getString(i.uRf) : nVar.oWW, "", false, new 2(this));
                } else if (nVar.oWq == 0) {
                    c cVar = this.oYs;
                    cVar.oXH = (float) com.tencent.mm.plugin.offline.c.a.bhO();
                    cVar.oXH = cVar.oXH;
                    if ("1".equals(nVar.oWU)) {
                        x.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: should refresh codes. doscene");
                        b(new m(((int) (System.currentTimeMillis() / 1000)), 8), false);
                    }
                } else if (nVar.oWq != 0) {
                    this.oYs.a(nVar, nVar.oWq, nVar.oWr);
                }
            } else if (!(kVar instanceof com.tencent.mm.plugin.offline.a.a)) {
                if (kVar instanceof com.tencent.mm.plugin.offline.a.e) {
                    this.oYs.d(i, i2, str, kVar);
                } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.f) {
                    if (this.oYk != null && this.oYk.isShowing()) {
                        this.oYk.dismiss();
                    }
                    com.tencent.mm.plugin.wallet_core.id_verify.model.f fVar2 = (com.tencent.mm.plugin.wallet_core.id_verify.model.f) kVar;
                    if ("1".equals(fVar2.sJX) || ("2".equals(fVar2.sJX) && !bh.ov(fVar2.sJY))) {
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOfflineCoinPurseUI");
                        bundle.putString("realname_verify_process_jump_plugin", "offline");
                        String str3 = fVar2.sJY;
                        str3 = fVar2.sJZ;
                        str3 = fVar2.sKa;
                        com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, 1006);
                    } else if ("collect".equals(fVar2.sKb)) {
                        bhq();
                    } else if ("reward".equals(fVar2.sKb)) {
                        d.y(this.mController.xIM, "collect", ".reward.ui.QrRewardMainUI");
                    } else {
                        x.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", new Object[]{fVar2.sKb});
                    }
                } else if (kVar instanceof q) {
                    q qVar = (q) kVar;
                    d(qVar.oXb.errType, qVar.oXb.errCode, qVar.oXb.fnL, qVar.oWZ);
                    d(qVar.oXa.errType, qVar.oXa.errCode, qVar.oXa.fnL, qVar.oWY);
                }
            }
            if ((kVar instanceof com.tencent.mm.plugin.wallet_core.c.x) || (kVar instanceof n) || (kVar instanceof com.tencent.mm.plugin.offline.a.a) || (kVar instanceof com.tencent.mm.plugin.offline.a.e)) {
                bhs();
                u(false, true);
            } else if (kVar instanceof com.tencent.mm.plugin.offline.a.f) {
                bhs();
                u(true, true);
            }
        } else if (kVar instanceof n) {
            bhs();
            u(false, true);
            if (411 == i2) {
                this.oYs.a(kVar, i2, str);
            }
        } else if (kVar instanceof com.tencent.mm.plugin.offline.a.e) {
            this.oYs.d(i, i2, str, kVar);
        } else if (!(kVar instanceof com.tencent.mm.plugin.offline.a.j)) {
            if (kVar instanceof com.tencent.mm.plugin.offline.a.f) {
                this.oVQ = null;
            } else if ((kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.f) && this.oYk != null && this.oYk.isShowing()) {
                this.oYk.dismiss();
            }
        }
        return true;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uFn;
    }

    protected final void initView() {
        this.oYt = (OfflineAlertView) findViewById(f.urX);
        this.oYt.dismiss();
        this.oYt.oXz = new com.tencent.mm.plugin.offline.ui.OfflineAlertView.a(this) {
            final /* synthetic */ WalletOfflineCoinPurseUI oYH;

            {
                this.oYH = r1;
            }

            public final void onClose() {
                this.oYH.oYt.getVisibility();
            }

            public final void onShow() {
                this.oYH.oYt.getVisibility();
            }
        };
        com.tencent.mm.wallet_core.c.a.cBn();
        com.tencent.mm.wallet_core.c.a.init(getApplicationContext());
        if (this.hze == 3 || this.hze == 10 || this.hze == 11) {
            setMMTitle(i.uXF);
        } else {
            setMMTitle(i.uXG);
        }
        this.oYs = new c(this, this);
        c cVar = this.oYs;
        cVar.kEd = (Vibrator) cVar.mActivity.getSystemService("vibrator");
        this.oYr = new com.tencent.mm.wallet_core.ui.c(this, true);
        this.oYr.init();
        this.oXW = findViewById(f.uAb);
        this.oXX = (ImageView) findViewById(f.uAa);
        this.oXY = (ImageView) findViewById(f.uyf);
        this.oXZ = (TextView) findViewById(f.uyg);
        this.oYb = findViewById(f.uAl);
        this.oYc = (TextView) findViewById(f.uAn);
        this.oYd = (ImageView) findViewById(f.uAk);
        this.oYe = (RelativeLayout) findViewById(f.uzd);
        this.oYe.setOnClickListener(new 11(this));
        this.oXX.setOnClickListener(this.inN);
        this.oXY.setOnClickListener(this.inN);
        this.oXZ.setOnClickListener(this.inN);
        this.oYb.setClickable(true);
        this.oYb.setOnClickListener(new 13(this));
        this.mLastTime = System.currentTimeMillis();
        this.oYf = (LinearLayout) findViewById(f.uzb);
        this.oYg = (LinearLayout) findViewById(f.uyZ);
        this.oYh = (LinearLayout) findViewById(f.uzc);
        this.oYi = (LinearLayout) findViewById(f.uze);
        this.oYj = (LinearLayout) findViewById(f.uza);
        if (this.hze == 3 || this.hze == 10 || this.hze == 11) {
            this.oYf.setVisibility(8);
            this.oYg.setVisibility(8);
            this.oYh.setVisibility(8);
            this.oYi.setVisibility(8);
        } else {
            this.oYi.setVisibility(0);
            this.oYj.setVisibility(0);
            final boolean b = com.tencent.mm.s.c.Bq().b(com.tencent.mm.storage.w.a.xxe, com.tencent.mm.storage.w.a.xwg);
            final boolean b2 = com.tencent.mm.s.c.Bq().b(com.tencent.mm.storage.w.a.xxf, com.tencent.mm.storage.w.a.xwg);
            final boolean b3 = com.tencent.mm.s.c.Bq().b(com.tencent.mm.storage.w.a.xxg, com.tencent.mm.storage.w.a.xwg);
            final boolean b4 = com.tencent.mm.s.c.Bq().b(com.tencent.mm.storage.w.a.xxh, com.tencent.mm.storage.w.a.xwg);
            final boolean b5 = com.tencent.mm.s.c.Bq().b(com.tencent.mm.storage.w.a.xxi, com.tencent.mm.storage.w.a.xwg);
            ImageView imageView = (ImageView) this.oYg.findViewById(f.ueb);
            ImageView imageView2 = (ImageView) this.oYf.findViewById(f.ukh);
            final ImageView imageView3 = (ImageView) this.oYh.findViewById(f.uke);
            ImageView imageView4 = (ImageView) this.oYi.findViewById(f.utJ);
            TextView textView = (TextView) this.oYf.findViewById(f.ukj);
            ImageView imageView5 = (ImageView) this.oYf.findViewById(f.uki);
            final ImageView imageView6 = (ImageView) this.oYj.findViewById(f.ufb);
            if (b) {
                imageView.setVisibility(0);
            }
            if (b2) {
                com.tencent.mm.kernel.g.Dk();
                String str = (String) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xww, "");
                if (bh.ov(str)) {
                    imageView2.setVisibility(0);
                } else {
                    textView.setText(str);
                    textView.setVisibility(0);
                    imageView5.setVisibility(0);
                }
            }
            if (b3) {
                imageView3.setVisibility(0);
            }
            if (b4) {
                imageView4.setVisibility(0);
            }
            if (b5) {
                imageView6.setVisibility(0);
            }
            if (((Boolean) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xxj, Boolean.valueOf(false))).booleanValue()) {
                x.i("MicroMsg.WalletOfflineCoinPurseUI", "no need scroll");
            } else {
                getWindow().getDecorView().post(new Runnable(this) {
                    final /* synthetic */ WalletOfflineCoinPurseUI oYH;

                    public final void run() {
                        int bottom;
                        ScrollView scrollView = (ScrollView) this.oYH.findViewById(f.usa);
                        int[] iArr = new int[2];
                        scrollView.getLocationInWindow(iArr);
                        int i = ae.fz(this.oYH.mController.xIM).y;
                        if (ae.fy(this.oYH.mController.xIM)) {
                            x.d("MicroMsg.WalletOfflineCoinPurseUI", "has navi");
                            i -= ae.fx(this.oYH.mController.xIM);
                        }
                        if (b2) {
                            bottom = iArr[1] + this.oYH.oYf.getBottom();
                        } else {
                            bottom = 0;
                        }
                        if (b4) {
                            bottom = iArr[1] + this.oYH.oYi.getBottom();
                        }
                        if (b) {
                            bottom = iArr[1] + this.oYH.oYg.getBottom();
                        }
                        if (b3) {
                            bottom = iArr[1] + this.oYH.oYh.getBottom();
                        }
                        if (b5) {
                            bottom = iArr[1] + this.oYH.oYj.getBottom();
                        }
                        x.d("MicroMsg.WalletOfflineCoinPurseUI", "f2f: %s, screen: %s", new Object[]{Integer.valueOf(bottom), Integer.valueOf(i)});
                        i = bottom - i;
                        if (i > 0) {
                            scrollView.scrollBy(0, i);
                        }
                        com.tencent.mm.kernel.g.Dj().CU().a(com.tencent.mm.storage.w.a.xxj, Boolean.valueOf(true));
                    }
                });
            }
            this.oYf.setOnClickListener(new 6(this, imageView2, textView, imageView5));
            this.oYg.setOnClickListener(new 7(this, imageView));
            this.oYh.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletOfflineCoinPurseUI oYH;

                public final void onClick(View view) {
                    x.i("MicroMsg.WalletOfflineCoinPurseUI", "click f2f lucky");
                    com.tencent.mm.plugin.report.service.g.pQN.h(14021, new Object[]{Integer.valueOf(4), Integer.valueOf(this.oYH.mfA)});
                    d.y(this.oYH.mController.xIM, "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
                    if (com.tencent.mm.s.c.Bq().b(com.tencent.mm.storage.w.a.xxg, com.tencent.mm.storage.w.a.xwg)) {
                        com.tencent.mm.s.c.Bq().c(com.tencent.mm.storage.w.a.xxg, com.tencent.mm.storage.w.a.xwg);
                        imageView3.setVisibility(8);
                        com.tencent.mm.plugin.report.service.g.pQN.h(14396, new Object[]{Integer.valueOf(5)});
                    }
                }
            });
            this.oYi.setOnClickListener(new 9(this, imageView4));
            this.oYj.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletOfflineCoinPurseUI oYH;

                public final void onClick(View view) {
                    d.y(this.oYH.mController.xIM, "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
                    if (com.tencent.mm.s.c.Bq().b(com.tencent.mm.storage.w.a.xxi, com.tencent.mm.storage.w.a.xwg)) {
                        com.tencent.mm.s.c.Bq().c(com.tencent.mm.storage.w.a.xxi, com.tencent.mm.storage.w.a.xwg);
                        imageView6.setVisibility(8);
                    }
                }
            });
        }
        if (com.tencent.mm.plugin.offline.c.a.bhH() && c.bhn()) {
            c cVar2 = this.oYs;
            k.bgX();
            cVar2.a(k.bgY().oXc);
        }
        bhs();
        u(true, false);
        long j = (long) this.oVS;
        this.oVT.J(j, j);
        if (com.tencent.mm.plugin.offline.c.a.oZq == 3 && com.tencent.mm.plugin.offline.c.a.oZt) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, is marked!");
            int i = com.tencent.mm.plugin.offline.c.a.oZr;
            j = com.tencent.mm.plugin.offline.c.a.oZs;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = (((long) (i * 1000)) + j) - currentTimeMillis;
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "expire_time:" + i + " beginTime:" + j + " now:" + currentTimeMillis + " interval:" + j2);
            if (com.tencent.mm.plugin.offline.c.a.oZr <= 0 || com.tencent.mm.plugin.offline.c.a.oZs <= 0 || j2 <= 0) {
                x.e("MicroMsg.WalletOfflineCoinPurseUI", "not to start card expire timer!");
            } else {
                if (!this.oYG.cfK()) {
                    this.oYG.TG();
                }
                this.oYG.J(j2, j2);
                x.i("MicroMsg.WalletOfflineCoinPurseUI", "start card expire timer!");
            }
        } else if (com.tencent.mm.plugin.offline.c.a.oZq == 3) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, not need to mark!");
        } else {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from %d, not need to start timer!", new Object[]{Integer.valueOf(com.tencent.mm.plugin.offline.c.a.oZq)});
        }
        bhr();
        com.tencent.mm.sdk.b.b stVar = new st();
        stVar.fKA.fKC = "5";
        stVar.fqI = new 4(this, stVar);
        com.tencent.mm.sdk.b.a.xef.m(stVar);
    }

    private void u(boolean z, boolean z2) {
        if (com.tencent.mm.plugin.offline.c.a.hf(true).size() > 0) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList size > 0");
            bhx();
            Bankcard bhJ = com.tencent.mm.plugin.offline.c.a.bhJ();
            if (bhJ != null) {
                x.i("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() have bankcard");
                com.tencent.mm.plugin.offline.c.a.GU(bhJ.field_bindSerial);
                this.oVl = bhJ.field_bindSerial;
                k.bgX();
                k.bgZ().oVl = this.oVl;
            } else {
                x.e("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() fail,  bankcard == null");
            }
            this.oYb.setVisibility(0);
        } else {
            this.oYb.setVisibility(8);
            x.e("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList== null or size is 0");
        }
        if (z) {
            up(0);
        }
        he(z2);
        if (com.tencent.mm.plugin.offline.c.a.bhH()) {
            this.oYe.setVisibility(0);
        } else {
            this.oYe.setVisibility(4);
        }
        bhr();
    }

    private void bhr() {
        if (!this.oYD && !an.isNetworkConnected(getBaseContext())) {
            k.bgX();
            k.bgZ();
            if (com.tencent.mm.plugin.offline.e.bgQ() == 0) {
                this.oYD = true;
                x.e("MicroMsg.OfflineErrorHelper", "offline code size is 0, show check network error dialog");
                com.tencent.mm.ui.base.h.a(this, getString(i.uXz), null, false, new 4(this));
                x.e("MicroMsg.WalletOfflineCoinPurseUI", "network disconnect and code count == 0");
            }
        }
    }

    private void bhs() {
        int bhM = com.tencent.mm.plugin.offline.c.a.bhM();
        Bankcard bhK = com.tencent.mm.plugin.offline.c.a.bhK();
        if (c.bhn()) {
            this.mState = 7;
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FREEZE");
        } else if (!an.isNetworkConnected(getBaseContext())) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_DISCONNECT_NETWORK");
            this.mState = 6;
        } else if (com.tencent.mm.plugin.offline.c.a.bhH()) {
            if (bhM == 0) {
                x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount == 0");
                this.mState = 1;
            } else if (bhM == 0 || bhK != null) {
                x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
                this.mState = 5;
            } else {
                x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount != 0 && bankcard == null");
                this.mState = 2;
            }
        } else if (bhM == 0) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount == 0");
            this.mState = 1;
        } else if (bhM == 0 || bhK != null) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
            this.mState = 5;
        } else {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount != 0 && bankcard == null");
            this.mState = 2;
        }
    }

    public final boolean aYj() {
        return false;
    }

    private void he(boolean z) {
        Bitmap bitmap;
        long currentTimeMillis = System.currentTimeMillis();
        if (z && (bh.ov(this.oYl) || bh.ov(this.oVO))) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "empty code!");
            if (this.oYt.uo(5)) {
                if (this.oYt.oXw == 5) {
                    this.oYt.dismiss();
                }
                OfflineAlertView offlineAlertView = this.oYt;
                View view = this.oXW;
                OnClickListener 24 = new 24(this);
                offlineAlertView.oXw = 5;
                offlineAlertView.setVisibility(0);
                offlineAlertView.oXy = false;
                offlineAlertView.oXx.removeAllViews();
                View inflate = LayoutInflater.from(offlineAlertView.getContext()).inflate(com.tencent.mm.plugin.wxpay.a.g.uFu, null);
                offlineAlertView.oXx.addView(inflate);
                ((TextView) inflate.findViewById(f.uez)).setText(i.uMc);
                Button button = (Button) inflate.findViewById(f.coJ);
                button.setText(i.uMb);
                button.setOnClickListener(24);
                view.post(new 8(offlineAlertView, view));
                com.tencent.mm.plugin.report.service.g.pQN.a(135, 73, 1, true);
            }
        } else if (this.oYt.isShowing() && this.oYt.oXw == 5) {
            this.oYt.dismiss();
        }
        Bitmap bitmap2 = this.oXQ;
        if (TextUtils.isEmpty(this.oYl)) {
            x.e("MicroMsg.WalletOfflineCoinPurseUI", "getBitmap mQRcode == null");
            bitmap = null;
        } else {
            bitmap = com.tencent.mm.bs.a.a.b(this, this.oYl, 0, 3);
        }
        this.oXQ = bitmap;
        this.oXX.setImageBitmap(this.oXQ);
        if (bht()) {
            this.oXX.setAlpha(10);
        } else {
            this.oXX.setAlpha(255);
        }
        this.oYp.add(0, bitmap2);
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh qrcode is " + (System.currentTimeMillis() - currentTimeMillis));
        bitmap2 = this.oXR;
        if (TextUtils.isEmpty(this.oVO)) {
            x.e("MicroMsg.WalletOfflineCoinPurseUI", "getBarcodeBitmap mBarcode == null");
            bitmap = null;
        } else {
            bitmap = com.tencent.mm.bs.a.a.b(this, this.oVO, 5, 0);
        }
        this.oXR = bitmap;
        this.oXY.setImageBitmap(this.oXR);
        if (bht()) {
            this.oXY.setAlpha(10);
        } else {
            this.oXY.setAlpha(255);
        }
        this.oYq.add(0, bitmap2);
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh is " + (System.currentTimeMillis() - currentTimeMillis));
        awi();
        bhu();
        p.ft(10, 0);
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(3);
        objArr[1] = Integer.valueOf(com.tencent.mm.plugin.offline.c.a.df(ac.getContext()) ? 0 : 1);
        objArr[2] = Integer.valueOf(an.isNetworkConnected(ac.getContext()) ? 1 : 0);
        k.bgX();
        k.bgZ();
        objArr[3] = Integer.valueOf(com.tencent.mm.plugin.offline.e.bgQ());
        gVar.h(14163, objArr);
        com.tencent.mm.plugin.report.service.g.pQN.a(135, 67, 1, true);
        if (an.isNetworkConnected(ac.getContext())) {
            com.tencent.mm.plugin.report.service.g.pQN.a(135, 32, 1, true);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.a(135, 33, 1, true);
        }
        if (com.tencent.mm.plugin.offline.c.a.df(this)) {
            com.tencent.mm.plugin.report.service.g.pQN.a(135, 34, 1, true);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.a(135, 35, 1, true);
        }
    }

    private boolean bht() {
        return this.mState == 2 || this.mState == 1 || this.mState == 7;
    }

    private void bhu() {
        if (this.oYr != null) {
            this.oYr.fS(this.oYl, this.oVO);
            this.oYr.oXQ = this.oXQ;
            this.oYr.oXR = this.oXR;
            this.oYr.cBV();
        }
    }

    private void awi() {
        int size;
        if (this.oYp.size() >= 2) {
            for (size = this.oYp.size() - 1; size > 1; size--) {
                e.u((Bitmap) this.oYp.remove(size));
            }
        }
        if (this.oYq.size() >= 2) {
            for (size = this.oYq.size() - 1; size > 1; size--) {
                e.u((Bitmap) this.oYq.remove(size));
            }
        }
    }

    private void up(int i) {
        int i2 = 0;
        if (com.tencent.mm.plugin.offline.c.a.bhH()) {
            k.bgX();
            com.tencent.mm.plugin.offline.e bgZ = k.bgZ();
            int i3 = this.hze;
            String str = this.oYa;
            x.i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i), bh.cgy().toString()});
            String k = bgZ.k(i3, i, str);
            this.oVO = k;
            this.oYl = k;
            x.v("MicroMsg.WalletOfflineCoinPurseUI", "updateCode isSnapshot:%s mBarcode:%s mQRcode:%s stack: %s", new Object[]{Integer.valueOf(i), this.oVO, this.oYl, bh.cgy().toString()});
            au bLf = com.tencent.mm.plugin.wallet_core.model.i.bLf();
            StringBuilder append = new StringBuilder().append(this.oYl);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Dh();
            str = ab.UZ(append.append(com.tencent.mm.a.o.getString(com.tencent.mm.kernel.a.Cg())).toString());
            if (bLf != null) {
                com.tencent.mm.plugin.report.service.g.pQN.h(13444, new Object[]{bLf.vFP, bLf.vFQ, Long.valueOf(bLf.vFO), str, bLf.vFR, bLf.vFS});
            }
            if (bh.ov(k)) {
                int i4;
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(1);
                if (com.tencent.mm.plugin.offline.c.a.df(ac.getContext())) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                objArr[1] = Integer.valueOf(i4);
                if (an.isNetworkConnected(getBaseContext())) {
                    i2 = 1;
                }
                objArr[2] = Integer.valueOf(i2);
                gVar.h(14163, objArr);
                com.tencent.mm.plugin.report.service.g.pQN.a(135, 26, 1, true);
                if (an.isNetworkConnected(getBaseContext())) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(135, 28, 1, true);
                    return;
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.a(135, 27, 1, true);
                    return;
                }
            }
            return;
        }
        x.w("MicroMsg.WalletOfflineCoinPurseUI", "offline is not create!");
    }

    public final boolean a(s.c cVar) {
        if (cVar == null) {
            x.e("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msg == null");
            return false;
        }
        boolean z;
        bhv();
        this.oYr.dismiss();
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "msgtype=" + cVar.oXj);
        if (4 == cVar.oXj) {
            this.oYm = false;
            z = false;
        } else {
            if (5 == cVar.oXj) {
                this.oYm = false;
                if (!this.oYF.cfK()) {
                    this.oYF.TG();
                }
                if (cVar instanceof s.e) {
                    z = ((s.e) cVar).oXp;
                }
            } else if (6 == cVar.oXj) {
                this.oYm = false;
                if (!this.oYF.cfK()) {
                    this.oYF.TG();
                }
                if (com.tencent.mm.plugin.offline.c.a.bhI()) {
                    z = false;
                }
            } else if (8 != cVar.oXj) {
                if (23 == cVar.oXj) {
                    if (!this.oYF.cfK()) {
                        this.oYF.TG();
                        z = false;
                    }
                } else if (20 == cVar.oXj) {
                    this.oYm = false;
                    if (!this.oYF.cfK()) {
                        this.oYF.TG();
                        z = false;
                    }
                } else if (24 == cVar.oXj) {
                    if (com.tencent.mm.plugin.offline.c.a.bij()) {
                        this.oYm = true;
                        if (com.tencent.mm.plugin.offline.c.a.bij()) {
                            if (this.oYk == null) {
                                this.oYk = com.tencent.mm.wallet_core.ui.g.a(this.mController.xIM, false, new 16(this));
                            } else if (!this.oYk.isShowing()) {
                                this.oYk.show();
                            }
                        }
                        long bgS = (long) g.bgS();
                        this.oYF.J(bgS, bgS);
                    }
                }
                z = false;
            } else if (!this.oYF.cfK()) {
                this.oYF.TG();
                z = true;
            }
            z = true;
        }
        c cVar2 = this.oYs;
        if (cVar == null) {
            x.e("MicroMsg.OfflineLogicMgr", "onNotify msg == null");
        } else {
            x.i("MicroMsg.OfflineLogicMgr", "onNotify OfflineMsg type :" + cVar.oXj);
            if (cVar.oXj == 24) {
                cVar2.kEd.vibrate(50);
            }
            if (4 == cVar.oXj) {
                cVar2.a((s.b) cVar);
                g.bgT();
            } else if (5 == cVar.oXj) {
                s.e eVar = (s.e) cVar;
                if (eVar != null) {
                    x.i("MicroMsg.OfflineLogicMgr", "showNotifyMsg msg.wxRetCode:" + eVar.oXm + " msg.wxRetMsg:" + eVar.oXn + " msg.cftRetCode:" + eVar.oXm + " msg.cftRetMsg:" + eVar.oXl);
                    if (!(TextUtils.isEmpty(eVar.oXm) && TextUtils.isEmpty(eVar.oXn) && TextUtils.isEmpty(eVar.oXk) && TextUtils.isEmpty(eVar.oXl))) {
                        if (TextUtils.isEmpty(eVar.oXm) && TextUtils.isEmpty(eVar.oXn) && !TextUtils.isEmpty(eVar.oXk) && !TextUtils.isEmpty(eVar.oXl)) {
                            b.b(cVar2.mActivity, eVar.oXl);
                        } else if (TextUtils.isEmpty(eVar.oXm) || !com.tencent.mm.plugin.offline.c.a.wP(eVar.oXm)) {
                            b.b(cVar2.mActivity, eVar.oXn);
                        } else {
                            cVar2.a(null, Integer.valueOf(eVar.oXm).intValue(), eVar.oXn, eVar.oXo);
                        }
                    }
                }
                g.bgT();
                com.tencent.mm.plugin.report.service.g.pQN.a(135, 0, 1, true);
            } else if (6 == cVar.oXj) {
                s$f com_tencent_mm_plugin_offline_a_s_f = (s$f) cVar;
                if (com_tencent_mm_plugin_offline_a_s_f != null) {
                    x.i("MicroMsg.OfflineLogicMgr", "showOrderSuccessUI transid : " + com_tencent_mm_plugin_offline_a_s_f.oXq);
                    k.bgX();
                    r GR = k.bhb().GR(com_tencent_mm_plugin_offline_a_s_f.oXr.fuH);
                    boolean z2 = GR != null ? GR.field_status == g.oVz : false;
                    if (!z2) {
                        g.bQ(com_tencent_mm_plugin_offline_a_s_f.oXr.fuH, g.oVz);
                        com.tencent.mm.plugin.offline.c.a.a(cVar2.mActivity, com_tencent_mm_plugin_offline_a_s_f);
                        cVar2.mActivity.setResult(-1);
                        cVar2.mActivity.finish();
                    }
                }
                g.bgT();
                com.tencent.mm.plugin.report.service.g.pQN.a(135, 7, 1, true);
                if (com.tencent.mm.plugin.offline.c.a.oZq == 4) {
                    x.i("MicroMsg.OfflineLogicMgr", "hy: is from ext");
                    com.tencent.mm.plugin.report.service.g.pQN.h(13412, new Object[0]);
                }
            } else if (8 == cVar.oXj) {
                s.g gVar = (s.g) cVar;
                x.i("MicroMsg.OfflineLogicMgr", "showPayConfirmMsg msg id:" + gVar.id);
                if (gVar.oXu == 0) {
                    View inflate = cVar2.mActivity.getLayoutInflater().inflate(com.tencent.mm.plugin.wxpay.a.g.uFs, null);
                    TextView textView = (TextView) inflate.findViewById(f.usQ);
                    ((TextView) inflate.findViewById(f.usO)).setText(gVar.oXt);
                    textView.setText(gVar.oXs);
                    g.bQ(gVar.fwY, g.oVB);
                    com.tencent.mm.ui.base.h.a(cVar2.mActivity, "", inflate, cVar2.getString(i.uXN), cVar2.getString(i.dEn), new 11(cVar2, gVar), new c$12(cVar2, gVar));
                } else if (gVar.oXu == 1) {
                    if (cVar2.oXG != null) {
                        cVar2.oXG.show();
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.h(13955, new Object[]{Integer.valueOf(1)});
                    x.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog msg id:" + gVar.id);
                    g.bQ(gVar.fwY, g.oVB);
                    cVar2.oXG = com.tencent.mm.plugin.wallet_core.ui.m.a(cVar2.mActivity, gVar.oXs, gVar.oXt, new 13(cVar2, gVar), new 14(cVar2), new 15(cVar2, gVar));
                    cVar2.oXG.pUY.setVisibility(0);
                    cVar2.oXG.pOz.setVisibility(8);
                }
            } else if (23 == cVar.oXj) {
                s.d dVar = (s.d) cVar;
                PayInfo payInfo = new PayInfo();
                payInfo.fuH = dVar.fwY;
                payInfo.fCV = 8;
                payInfo.vzF = 1;
                payInfo.vzx = new Bundle();
                payInfo.vzx.putLong("extinfo_key_9", System.currentTimeMillis());
                com.tencent.mm.sdk.b.a.xef.a(new 1(cVar2, payInfo));
                h.a(cVar2.mActivity, false, "", cVar2.oXF == null ? "" : cVar2.oXF.bhk(), payInfo, "", new Intent(), 1);
            } else if (20 == cVar.oXj) {
                g.bgT();
            }
        }
        if (z) {
            up(0);
            he(true);
        }
        return true;
    }

    private void bhv() {
        if (this.oYk != null && this.oYk.isShowing()) {
            this.oYk.dismiss();
        }
    }

    private void bhw() {
        b(new n(System.currentTimeMillis(), com.tencent.mm.plugin.offline.c.a.oZq), false);
    }

    public final void l(String str, Bitmap bitmap) {
        if (!TextUtils.isEmpty(str) && bitmap != null && !bitmap.isRecycled()) {
            ImageView imageView = (ImageView) this.oXO.get(str);
            Integer num = (Integer) this.oXP.get(str);
            if (imageView != null && num != null) {
                new af(getMainLooper()).post(new 17(this, num, bitmap, imageView));
            }
        }
    }

    public final void alG() {
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "setScreenShotCallback");
        up(1);
        he(true);
        e.HF(40);
        com.tencent.mm.plugin.report.service.g.pQN.a(135, 21, 1, true);
        if (this.oYr.inJ.isShowing()) {
            if (this.oYr.kRg) {
                this.oYr.cBW();
                return;
            }
            this.oYr.dismiss();
        }
        bhz();
    }

    public final void bhx() {
        boolean z;
        Bankcard bhJ = com.tencent.mm.plugin.offline.c.a.bhJ();
        findViewById(f.uAm).setVisibility(0);
        this.oYc.setTextSize(0, (float) getResources().getDimensionPixelSize(com.tencent.mm.plugin.wxpay.a.d.bvK));
        if (this.oYc == null || bhJ == null) {
            if (bhJ == null) {
                x.e("MicroMsg.WalletOfflineCoinPurseUI", "setChangeBankcardText bankcard == null");
            }
            z = false;
        } else {
            CharSequence charSequence;
            String string = getString(i.uXv, new Object[]{bhJ.field_desc});
            List<com.tencent.mm.plugin.wallet_core.model.c> bLY = o.bLq().bLY();
            if (!(bLY == null || bh.ov(bhJ.field_forbidWord))) {
                for (com.tencent.mm.plugin.wallet_core.model.c cVar : bLY) {
                    if (cVar.oZA.equals(bhJ.field_bindSerial)) {
                        break;
                    }
                }
            }
            com.tencent.mm.plugin.wallet_core.model.c cVar2 = null;
            if (cVar2 == null || bh.ov(cVar2.sKQ)) {
                Object obj = string;
                z = false;
            } else {
                charSequence = bhJ.field_desc + cVar2.sKQ;
                findViewById(f.uAm).setVisibility(8);
                com.tencent.mm.plugin.report.service.g.pQN.h(14515, new Object[]{Integer.valueOf(2)});
                this.oYc.setTextSize(0, (float) getResources().getDimensionPixelSize(com.tencent.mm.plugin.wxpay.a.d.bvs));
                z = true;
            }
            this.oYc.setText(charSequence);
        }
        if (bhJ != null) {
            if (TextUtils.isEmpty(this.oVl)) {
                x.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() mBindSerial is null");
            } else {
                obj = com.tencent.mm.plugin.offline.c.a.Hb(this.oVl);
                if (bhJ.bKQ() && bhJ.sLn != null) {
                    obj = bhJ.sLn.oPH;
                }
                if (TextUtils.isEmpty(obj)) {
                    x.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() icon_url == null, can not find this icon_url");
                } else {
                    ImageView imageView = this.oYd;
                    int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.tencent.mm.plugin.wxpay.a.d.ucs);
                    if (!(imageView == null || TextUtils.isEmpty(obj))) {
                        Bitmap a = j.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(obj));
                        if (a != null) {
                            imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(a, dimensionPixelOffset, dimensionPixelOffset, true, false));
                        }
                        this.oXO.put(obj, imageView);
                        this.oXP.put(obj, Integer.valueOf(dimensionPixelOffset));
                    }
                }
            }
        }
        if (z) {
            this.oYd.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uGx);
        }
    }

    private void bhy() {
        if (!this.oYo && this.oYt.uo(4)) {
            com.tencent.mm.kernel.g.Dk();
            if (!((Boolean) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xsv, Boolean.valueOf(false))).booleanValue() && !this.oYt.isShowing()) {
                bhz();
            }
        }
    }

    private void bhz() {
        if (this.oYt.uo(4)) {
            OfflineAlertView offlineAlertView = this.oYt;
            View view = this.oXW;
            offlineAlertView.setVisibility(0);
            offlineAlertView.oXx.removeAllViews();
            offlineAlertView.oXx.addView(LayoutInflater.from(offlineAlertView.getContext()).inflate(com.tencent.mm.plugin.wxpay.a.g.uFp, null));
            com.tencent.mm.plugin.report.service.g.pQN.h(13750, new Object[]{Integer.valueOf(1)});
            view.post(new 2(offlineAlertView, view, 4));
        }
    }

    private void bhA() {
        if (this.oYt.uo(1)) {
            if (this.oYt.oXw == 1) {
                this.oYt.dismiss();
            }
            boolean bLJ = o.bLq().bLJ();
            boolean bLN = o.bLq().bLN();
            if (bLJ || bLN) {
                x.i("MicroMsg.WalletOfflineCoinPurseUI", "unreg: %B, simplereg: %B", new Object[]{Boolean.valueOf(bLJ), Boolean.valueOf(bLN)});
                this.oYt.a(this.oXW, new OnClickListener(this) {
                    final /* synthetic */ WalletOfflineCoinPurseUI oYH;

                    {
                        this.oYH = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.offline.c.a.bhS();
                        k.bgX();
                        k.au(196648, "0");
                        com.tencent.mm.ui.base.h.a(this.oYH, false, this.oYH.getString(i.uXu), "", this.oYH.getString(i.uXA), this.oYH.getString(i.dEn), new DialogInterface.OnClickListener(this.oYH) {
                            final /* synthetic */ WalletOfflineCoinPurseUI oYH;

                            {
                                this.oYH = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                com.tencent.mm.plugin.offline.c.a.a(this.oYH, 0, this.oYH.hze);
                                x.v("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI startBindProcess()");
                            }
                        }, new 20(this.oYH));
                    }
                }, 1);
            }
        }
    }

    private void bhB() {
        if (this.oYt.uo(3)) {
            if (this.oYt.oXw == 3) {
                this.oYt.dismiss();
            }
            k.bgX();
            String un = k.un(196617);
            com.tencent.mm.wallet_core.c.a.cBn();
            boolean isCertExist = com.tencent.mm.wallet_core.c.a.isCertExist(un);
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "show unopened alert, %B, %B", new Object[]{Boolean.valueOf(isCertExist), Boolean.valueOf(com.tencent.mm.plugin.offline.c.a.bhH())});
            if (!isCertExist || !r2) {
                if (!isCertExist) {
                    com.tencent.mm.kernel.g.Dk();
                    String str = (String) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xmO, "");
                    if (str == null || !str.equals(com.tencent.mm.compatible.d.q.yE())) {
                        x.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is diff between create and getToken");
                    } else {
                        x.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is same between create and getToken");
                    }
                    x.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI CertUtil.getInstance().isCertExist(cn) is false ,cn == " + un + " ,recreate offline");
                    com.tencent.mm.plugin.offline.c.a.bhS();
                }
                this.oYt.a(this.oXW, new 22(this), 3);
            }
        }
    }

    private boolean bhC() {
        if (!this.oYt.uo(2)) {
            return false;
        }
        if (this.oYt.oXw == 2) {
            this.oYt.dismiss();
        }
        List bhN = com.tencent.mm.plugin.offline.c.a.bhN();
        if (bhN.size() <= 0) {
            x.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
            return false;
        }
        for (int i = 0; i < bhN.size(); i++) {
            Bankcard bankcard = (Bankcard) bhN.get(i);
            if (bankcard != null && bankcard.field_support_micropay && bh.ov(bankcard.field_forbidWord)) {
                return true;
            }
        }
        this.oYt.dismiss();
        OfflineAlertView offlineAlertView = this.oYt;
        View view = this.oXW;
        Runnable 26 = new 26(this);
        Runnable 27 = new 27(this);
        offlineAlertView.setVisibility(0);
        offlineAlertView.oXx.removeAllViews();
        offlineAlertView.oXx.addView(LayoutInflater.from(offlineAlertView.getContext()).inflate(com.tencent.mm.plugin.wxpay.a.g.uFr, null));
        view.post(new OfflineAlertView.1(offlineAlertView, view, 26, 27, 2));
        return false;
    }

    private static Bankcard g(List<Bankcard> list, String str) {
        for (Bankcard bankcard : list) {
            if (str.equals(bankcard.field_bindSerial)) {
                list.remove(bankcard);
                return bankcard;
            }
        }
        return null;
    }

    private void bhD() {
        int i = -1;
        List hf = com.tencent.mm.plugin.offline.c.a.hf(false);
        if (hf.size() <= 0) {
            x.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
            this.oYc.setVisibility(8);
            return;
        }
        int i2;
        Bankcard g;
        List<Bankcard> arrayList = new ArrayList();
        int i3 = 0;
        int i4 = -1;
        Bankcard bankcard = null;
        Object obj = null;
        while (i3 < hf.size()) {
            Bankcard bankcard2;
            if (((Bankcard) hf.get(i3)).bKP()) {
                i4 = i3;
                obj = (Bankcard) hf.get(i3);
            }
            if (((Bankcard) hf.get(i3)).bKQ()) {
                bankcard2 = (Bankcard) hf.get(i3);
                i2 = i3;
            } else {
                i2 = i;
                bankcard2 = bankcard;
            }
            i3++;
            bankcard = bankcard2;
            i = i2;
        }
        if (obj != null) {
            arrayList.add(obj);
        }
        if (bankcard != null) {
            arrayList.add(bankcard);
        }
        i2 = 0;
        while (i2 < hf.size()) {
            if (!(i2 == i || i2 == r5)) {
                arrayList.add(hf.get(i2));
            }
            i2++;
        }
        com.tencent.mm.plugin.offline.c.a.GW(com.tencent.mm.plugin.offline.c.a.bhX());
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "showChangeBankcardDialog() bankcard size is " + arrayList.size());
        List<com.tencent.mm.plugin.wallet_core.model.c> bLY = o.bLq().bLY();
        if (bLY != null && bLY.size() > 0) {
            List<Bankcard> linkedList = new LinkedList();
            for (Bankcard g2 : arrayList) {
                linkedList.add(g2);
            }
            arrayList.clear();
            for (com.tencent.mm.plugin.wallet_core.model.c cVar : bLY) {
                g2 = g(linkedList, cVar.oZA);
                if (g2 != null) {
                    arrayList.add(g2);
                }
            }
            for (Bankcard g22 : linkedList) {
                arrayList.add(g22);
            }
        }
        com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(this, com.tencent.mm.ui.widget.g.ztq, true);
        i = 0;
        for (i3 = 0; i3 < arrayList.size(); i3++) {
            g22 = (Bankcard) arrayList.get(i3);
            if (!bh.ov(g22.field_bindSerial) && this.oVl.equals(g22.field_bindSerial)) {
                i = i3;
            }
        }
        gVar.rKC = new 28(this, arrayList, gVar);
        gVar.rKD = new 29(this, gVar, arrayList);
        View inflate = View.inflate(this, com.tencent.mm.plugin.wxpay.a.g.uFm, null);
        gVar.pEa = true;
        gVar.ztz = i;
        gVar.ztx = true;
        gVar.dO(inflate);
        gVar.bUk();
        com.tencent.mm.plugin.report.service.g.pQN.h(13955, new Object[]{Integer.valueOf(3)});
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private static void bhE() {
        if (!com.tencent.mm.plugin.offline.c.a.bib()) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, token is invalid, do doNetSceneToken");
            k.bgX();
            k.bha().dc(3, 3);
        }
    }

    public final void atT() {
        up(0);
        he(true);
    }

    public final void o(int i, String str, String str2) {
        b(new com.tencent.mm.plugin.offline.a.e(i, str, str2), com.tencent.mm.plugin.offline.c.a.bhI());
    }

    public final void bhi() {
        bhD();
    }

    public final void bhj() {
        b(new com.tencent.mm.plugin.offline.a.j(""), false);
    }

    public final String bhk() {
        return this.oVl;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || this.oYt == null || this.oYt.getVisibility() != 0 || !this.oYt.oXy) {
            return super.onKeyUp(i, keyEvent);
        }
        this.oYt.dismiss();
        return true;
    }

    public final void bhl() {
        if (!this.oVT.cfK()) {
            this.oVT.TG();
        }
        up(0);
        he(true);
        long j = (long) this.oVS;
        this.oVT.J(j, j);
    }
}
