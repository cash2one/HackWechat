package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.g.a.le;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.a.st;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.a.su$b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class MallIndexUI extends MallIndexBaseUI {
    private String fLh;
    private boolean joQ = false;
    private boolean omA;
    o omB = new o();
    private c<le> omC = new 1(this);
    private boolean omD = false;
    private g omE;
    su$b omt;
    private String omu;
    private ECardInfo omv;
    private boolean omw = true;
    private RelativeLayout omx;
    private View omy;
    private boolean omz;

    static /* synthetic */ boolean b(MallIndexUI mallIndexUI, su$b com_tencent_mm_g_a_su_b) {
        if (mallIndexUI.omD) {
            x.i("MicorMsg.MallIndexUI", "isDoRealname bye bye");
            return true;
        } else if ("1".equals(com_tencent_mm_g_a_su_b.fKP)) {
            x.i("MicorMsg.MallIndexUI", "need realname verify");
            mallIndexUI.omD = true;
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".mall.ui.WalletBalanceSaveUI");
            bundle.putString("realname_verify_process_jump_plugin", "mall");
            mallIndexUI.aYf();
            return a.a(mallIndexUI, bundle, 0);
        } else {
            if ("2".equals(com_tencent_mm_g_a_su_b.fKP)) {
                x.i("MicorMsg.MallIndexUI", "need upload credit");
                mallIndexUI.omD = true;
                j.a(mallIndexUI, com_tencent_mm_g_a_su_b.title, com_tencent_mm_g_a_su_b.fLa, com_tencent_mm_g_a_su_b.fLb, com_tencent_mm_g_a_su_b.fKU, com_tencent_mm_g_a_su_b.fKV, com_tencent_mm_g_a_su_b.fKW, com_tencent_mm_g_a_su_b.fKZ, com_tencent_mm_g_a_su_b.fKY, com_tencent_mm_g_a_su_b.fKX);
            } else if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(com_tencent_mm_g_a_su_b.fKP)) {
                x.i("MicorMsg.MallIndexUI", "need increase the balance amount");
                mallIndexUI.omu = com_tencent_mm_g_a_su_b.fKP;
                mallIndexUI.omv = com_tencent_mm_g_a_su_b.fLc;
            } else {
                x.i("MicorMsg.MallIndexUI", "realnameGuideFlag =  " + com_tencent_mm_g_a_su_b.fKP);
            }
            return false;
        }
    }

    static /* synthetic */ void m(MallIndexUI mallIndexUI) {
        final w wVar = new w();
        mallIndexUI.omE = new g(mallIndexUI, g.ztp, false);
        mallIndexUI.omE.rKC = new 13(mallIndexUI, wVar);
        mallIndexUI.omE.rKD = new d(mallIndexUI) {
            final /* synthetic */ MallIndexUI omF;

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                int i2;
                int i3;
                int i4;
                if (com.tencent.mm.plugin.wallet_core.model.o.bLq().bLM()) {
                    i2 = 2;
                } else if (com.tencent.mm.plugin.wallet_core.model.o.bLq().bLJ()) {
                    i2 = 1;
                } else {
                    i2 = 3;
                }
                if (com.tencent.mm.plugin.wallet_core.model.o.bLq().bLQ().bLG()) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                Intent intent;
                switch (menuItem.getItemId()) {
                    case 0:
                        MallIndexBaseUI.x(this.omF.mController.xIM);
                        i4 = 1;
                        break;
                    case 1:
                        Context context = this.omF;
                        if (q.Gf()) {
                            com.tencent.mm.bm.d.y(context, "wallet_payu", ".pwd.ui.WalletPayUPasswordSettingUI");
                        } else {
                            com.tencent.mm.bm.d.y(context, "wallet", ".pwd.ui.WalletPasswordSettingUI");
                        }
                        e.HF(21);
                        i4 = 2;
                        break;
                    case 2:
                        com.tencent.mm.bm.d.y(this.omF, "wallet", ".pwd.ui.WalletSecuritySettingUI");
                        e.HF(22);
                        i4 = 3;
                        break;
                    case 3:
                        MMActivity mMActivity = this.omF;
                        intent = new Intent();
                        intent.putExtra("rawUrl", q.Gf() ? "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/readtemplate?t=payu_faq_tmpl" : "https://kf.qq.com/touch/scene_product.html?scene_id=kf1");
                        com.tencent.mm.bm.d.b(mMActivity.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
                        e.HF(23);
                        i4 = 4;
                        break;
                    case 4:
                        this.omF.aYq();
                        i4 = 5;
                        break;
                    default:
                        i4 = menuItem.getItemId();
                        int size = wVar.list.size();
                        if (i4 >= 100) {
                            i4 -= 100;
                            if (i4 >= 0 && i4 < size) {
                                w.a aVar = (w.a) wVar.list.get(i4);
                                com.tencent.mm.plugin.report.service.g.pQN.h(14409, new Object[]{Integer.valueOf(2), Integer.valueOf(aVar.sPw), aVar.sPx, aVar.sPA, aVar.sPy});
                                if (aVar.sPw == 1) {
                                    intent = new Intent();
                                    intent.putExtra("rawUrl", aVar.sPx);
                                    x.d("MicorMsg.MallIndexUI", "raw url: %s", new Object[]{intent.getStringExtra("rawUrl")});
                                    com.tencent.mm.bm.d.b(this.omF, "webview", ".ui.tools.WebViewUI", intent);
                                    i4 = 6;
                                    break;
                                } else if (aVar.sPw == 2) {
                                    b qpVar = new qp();
                                    qpVar.fIi.fIm = 0;
                                    qpVar.fIi.userName = aVar.sPA;
                                    qpVar.fIi.fIk = aVar.sPy;
                                    com.tencent.mm.sdk.b.a.xef.m(qpVar);
                                }
                            }
                        }
                        i4 = 6;
                        break;
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(14423, new Object[]{this.omF.ned, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        };
        mallIndexUI.omE.bUk();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 3) {
            return;
        }
        if (i2 == -1) {
            this.omB.aYr();
        } else {
            this.omB.cancel();
        }
    }

    public void onCreate(Bundle bundle) {
        ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
        i.i(this, 2);
        this.omt = new su$b();
        this.omt.fKH = false;
        this.omt.fKI = true;
        this.omt.fKJ = false;
        this.omC.ceO();
        this.omB.sWX = new 6(this);
        super.onCreate(bundle);
    }

    protected final void aYc() {
        setMMTitle(com.tencent.mm.plugin.wxpay.a.i.uLe);
    }

    protected final void cp(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(f.ufc);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(f.ueJ);
        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(f.urY);
        this.omx = (RelativeLayout) view.findViewById(f.ulV);
        this.olV = (TextView) view.findViewById(f.ueR);
        if (this.olV instanceof WalletTextView) {
            WalletTextView walletTextView = (WalletTextView) this.olV;
            walletTextView.setTypeface(Typeface.createFromAsset(walletTextView.getContext().getAssets(), e.HC(7)));
        }
        relativeLayout.setOnClickListener(new 7(this));
        relativeLayout2.setOnClickListener(new 8(this, view));
        relativeLayout3.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallIndexUI omF;

            {
                this.omF = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("key_from_scene", 1);
                com.tencent.mm.bm.d.b(this.omF.mController.xIM, "offline", ".ui.WalletOfflineEntranceUI", intent);
                p.ft(9, 0);
                com.tencent.mm.plugin.report.service.g.pQN.h(11850, new Object[]{Integer.valueOf(5), Integer.valueOf(0)});
                com.tencent.mm.plugin.report.service.g.pQN.h(14419, new Object[]{this.omF.ned, Integer.valueOf(1)});
            }
        });
        this.omx.setOnClickListener(new 10(this));
        if (this.omz) {
            this.omx.setVisibility(0);
        } else {
            this.omx.setVisibility(8);
        }
        this.olT = (ImageView) findViewById(f.uft);
        this.olU = (ImageView) view.findViewById(f.ues);
        View findViewById = view.findViewById(f.ueT);
        com.tencent.mm.kernel.g.Dk();
        if (((Integer) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xvS, Integer.valueOf(-1))).intValue() == 1) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        this.omy = view.findViewById(f.umr);
        com.tencent.mm.kernel.g.Dk();
        if (((Integer) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xvU, Integer.valueOf(-1))).intValue() == 1) {
            this.omy.setVisibility(0);
        } else {
            this.omy.setVisibility(8);
        }
        aYp();
    }

    protected final void aYl() {
        b stVar = new st();
        stVar.fKA.fKC = "1";
        stVar.fqI = new 11(this, stVar);
        com.tencent.mm.sdk.b.a.xef.m(stVar);
    }

    protected final boolean aYg() {
        x.i("MicorMsg.MallIndexUI", "init BankcardList");
        final b suVar = new su();
        suVar.fKE.scene = 1;
        suVar.fKF.fKz = new Runnable(this) {
            final /* synthetic */ MallIndexUI omF;

            public final void run() {
                x.d("MicorMsg.MallIndexUI", "mUserInfo needBind : " + this.omF.omt.fKI + " hasNewTips : " + this.omF.omt.fKJ + " swipeOn : " + this.omF.omt.fKK);
                if (this.omF.joQ || this.omF.mController.xIM.isFinishing()) {
                    x.e("MicorMsg.MallIndexUI", "error for callback ac finish");
                    return;
                }
                this.omF.omt = suVar.fKF;
                if (this.omF.omt.errCode == 0) {
                    boolean booleanValue;
                    this.omF.aYp();
                    this.omF.aYm();
                    Context context = this.omF;
                    x.i("MicorMsg.MallIndexUI", "showGetNewWalletTip call");
                    if (context.omt == null || !(context.omt.fKH || context.omt.fKN)) {
                        x.e("MicorMsg.MallIndexUI", "user is not reg or simplereg，should not show this dialog");
                    } else {
                        boolean bLG = com.tencent.mm.plugin.wallet_core.model.o.bLq().bLQ().bLG();
                        com.tencent.mm.kernel.g.Dk();
                        Object obj = com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xqA, Boolean.valueOf(false));
                        if (obj != null) {
                            booleanValue = ((Boolean) obj).booleanValue();
                        } else {
                            booleanValue = false;
                        }
                        x.i("MicorMsg.MallIndexUI", "showGetNewWalletTip hadShow=" + booleanValue + ";isswc=" + bLG);
                        if (!booleanValue && bLG) {
                            com.tencent.mm.kernel.g.Dk();
                            com.tencent.mm.kernel.g.Dj().CU().a(com.tencent.mm.storage.w.a.xqA, Boolean.valueOf(true));
                            h.a(context, context.getString(com.tencent.mm.plugin.wxpay.a.i.uLg), null, true, null);
                        }
                    }
                    MallIndexUI.b(this.omF, this.omF.omt);
                    this.omF.aYo();
                    x.i("MicorMsg.MallIndexUI", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", new Object[]{Integer.valueOf(this.omF.omt.fLf), Boolean.valueOf(this.omF.omt.fLg), this.omF.omt.fLh});
                    MallIndexUI mallIndexUI = this.omF;
                    if (this.omF.omt.fLf == 1) {
                        booleanValue = true;
                    } else {
                        booleanValue = false;
                    }
                    mallIndexUI.omz = booleanValue;
                    this.omF.omA = this.omF.omt.fLg;
                    this.omF.fLh = this.omF.omt.fLh;
                    if (this.omF.omx != null) {
                        if (this.omF.omz) {
                            this.omF.omx.setVisibility(0);
                        } else {
                            this.omF.omx.setVisibility(8);
                        }
                    }
                    MallIndexUI mallIndexUI2 = this.omF;
                    mallIndexUI2.omB.a(new 3(mallIndexUI2), new ae().bLI());
                }
            }
        };
        com.tencent.mm.sdk.b.a.xef.a(suVar, Looper.myLooper());
        return false;
    }

    protected final void aYp() {
        if (this.olU != null) {
            if (!(com.tencent.mm.s.c.Bq().b(com.tencent.mm.storage.w.a.xwf, com.tencent.mm.storage.w.a.xwg) || this.omt.fKJ)) {
                int i;
                k kVar = com.tencent.mm.plugin.wallet_core.model.o.bLq().sQc;
                if (kVar != null) {
                    int i2 = kVar.field_red_dot_index;
                    com.tencent.mm.kernel.g.Dk();
                    if (((Integer) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xpV, Integer.valueOf(-1))).intValue() >= i2 || i2 <= 0) {
                        x.i("MicorMsg.MallIndexUI", "bankcard do not need red point");
                    } else {
                        x.i("MicorMsg.MallIndexUI", "bankcard need red point");
                        i = 1;
                        if (i == 0) {
                            this.olU.setVisibility(8);
                            return;
                        }
                    }
                }
                i = 0;
                if (i == 0) {
                    this.olU.setVisibility(8);
                    return;
                }
            }
            this.olU.setVisibility(0);
        }
    }

    protected final void aYm() {
        x.i("MicorMsg.MallIndexUI", "updateBalanceNum");
        ae aeVar = new ae();
        x.i("MicroMsg.WalletSwitchConfig", "isHideBalanceNum, ret = %s switchBit %s", new Object[]{Boolean.valueOf((aeVar.sPW & 16384) > 0), Integer.valueOf(aeVar.sPW)});
        if ((aeVar.sPW & 16384) > 0) {
            com.tencent.mm.kernel.g.Dk();
            String str = (String) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xrx, getString(com.tencent.mm.plugin.wxpay.a.i.uMN));
            this.olV.setTextColor(getResources().getColor(a$c.uba));
            this.olV.setText(str);
            this.olV.setVisibility(0);
            return;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isShowBalanceAmount, ret = %s switchBit %s", new Object[]{Boolean.valueOf((aeVar.sPW & 4194304) > 0), Integer.valueOf(aeVar.sPW)});
        if ((aeVar.sPW & 4194304) > 0) {
            x.i("MicorMsg.MallIndexUI", "show balance amount");
            this.olV.setTextColor(getResources().getColor(a$c.uaZ));
            Bankcard bankcard = com.tencent.mm.plugin.wallet_core.model.o.bLq().szU;
            if (bankcard == null || bankcard.sLf < 0.0d) {
                this.olV.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uRT));
            } else {
                this.olV.setText(e.u(bankcard.sLf));
            }
            this.olV.setVisibility(0);
            return;
        }
        this.olV.setVisibility(8);
    }

    protected final void aYo() {
        this.mController.removeAllOptionMenu();
        if (this.omt == null || !this.omt.fLd) {
            addIconOptionMenu(0, a$e.bDI, new 5(this));
            return;
        }
        int i;
        com.tencent.mm.kernel.g.Dk();
        final boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xxq, Boolean.valueOf(false))).booleanValue();
        x.i("MicorMsg.MallIndexUI", "addIconOptionMenuByMode, hasRedDot: %s", new Object[]{Boolean.valueOf(booleanValue)});
        addIconOptionMenu(0, booleanValue ? a$e.udg : a$e.udf, new OnMenuItemClickListener(this) {
            final /* synthetic */ MallIndexUI omF;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i;
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(0);
                if (booleanValue) {
                    i = 1;
                } else {
                    i = 0;
                }
                objArr[1] = Integer.valueOf(i);
                objArr[2] = "";
                objArr[3] = "";
                objArr[4] = Integer.valueOf(0);
                gVar.h(14872, objArr);
                Context context = this.omF;
                boolean z = this.omF.omt.fKO;
                Intent intent = new Intent(context, MallIndexMenuUI.class);
                intent.putExtra("key_default_show_currency", z);
                context.startActivity(intent);
                return true;
            }
        });
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(0);
        if (booleanValue) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = "";
        objArr[3] = "";
        objArr[4] = Integer.valueOf(1);
        gVar.h(14872, objArr);
    }

    public void onResume() {
        x.v("MicorMsg.MallIndexUI", "alvinluo MallIndexUI onResume");
        this.omB.onResume();
        com.tencent.mm.plugin.walletlock.a.b bVar = (com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.walletlock.a.b.class);
        bVar.a(this, bVar.bNx(), null);
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        this.omB.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        this.omC.dead();
    }

    protected final void aYd() {
        com.tencent.mm.plugin.mall.b.a.aYu();
    }

    protected final void aYe() {
        com.tencent.mm.plugin.wallet_core.model.o.bLm().bMn();
        if ((com.tencent.mm.plugin.wallet_core.model.o.bLm().bMn().bLK() || com.tencent.mm.plugin.wallet_core.model.o.bLm().bMn().bLJ()) && q.Gf()) {
            x.e("MicorMsg.MallIndexUI", "hy: user not open wallet or status unknown. try query");
            r(new com.tencent.mm.plugin.wallet_core.c.b.a("", false));
        }
    }

    public void finish() {
        this.joQ = true;
        super.finish();
    }
}
