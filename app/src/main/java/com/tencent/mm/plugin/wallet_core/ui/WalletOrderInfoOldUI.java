package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.a.in;
import com.tencent.mm.g.a.in$a;
import com.tencent.mm.plugin.wallet_core.c.n;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders$Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$b;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ak.b;
import com.tencent.mm.z.q;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@a(3)
public class WalletOrderInfoOldUI extends WalletOrderInfoUI {
    protected boolean foC = true;
    protected boolean foD = false;
    protected boolean foE = false;
    protected String jKk = null;
    protected String mAppId = "";
    protected String oWp;
    private c oYB = new 5(this);
    private String pOF;
    protected String pbR = null;
    protected PayInfo sEO;
    public Orders sEs;
    private HashMap<String, b> sRA = new HashMap();
    protected String sRB;
    protected boolean sRv = false;
    public Set<String> sTU = null;
    public List<Commodity> sTV = null;
    protected TextView sUA = null;
    public a sUB = null;
    protected String sUC = null;
    protected HashMap<String, TextView> sUD = new HashMap();
    protected c sUE;
    protected Map<Long, String> sUF = new HashMap();
    private d sUG;
    private boolean sUH = false;
    public b.a sUI = new 6(this);
    private OnLongClickListener sUJ = new 11(this);
    private c sUo = new 3(this);
    protected LinearLayout sUy = null;
    protected TextView sUz = null;

    protected final int getLayoutId() {
        return g.uzf;
    }

    private void WT() {
        int i = 1;
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
        this.sEO = (PayInfo) this.vf.getParcelable("key_pay_info");
        this.oWp = this.vf.getString("key_trans_id");
        this.vf.getInt("key_pay_type", -1);
        x.i("MicroMsg.WalletOrderInfoOldUI", "mTransId %s", this.oWp);
        this.sEs = bMF();
        if (this.sEs != null) {
            uD(0);
            c(this.sEs);
            if (!(ag == null || this.sEs == null || this.sEO == null)) {
                boolean z;
                this.mAppId = this.sEO.appId;
                boolean cBk = ag.cBk();
                com.tencent.mm.plugin.wallet_core.e.c.b(this, this.vf, 7);
                int i2 = this.vf.getInt("key_support_bankcard", 1) == 2 ? 2 : 1;
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(this.sEO.fCV);
                if (this.sEO.fCV == 3) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                if (!cBk) {
                    i = 2;
                }
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(p.cBx());
                objArr[4] = Integer.valueOf((int) (this.sEs.pNX * 100.0d));
                objArr[5] = this.sEs.paz;
                objArr[6] = Integer.valueOf(i2);
                gVar.h(10691, objArr);
            }
            if (!((o.bLq().bLM() || ag == null || !ag.cBk()) && q.Gb())) {
                q.Gc();
            }
            if (this.sEs == null || this.sEs.sNW == null || this.sEs.sNW.size() <= 0) {
                x.k("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
                h.a(this.mController.xIM, i.uTp, 0, new 1(this));
            } else {
                this.sTV = this.sEs.sNW;
                this.oWp = ((Commodity) this.sTV.get(0)).fuI;
                if (!(this.sEO == null || ag == null || (!ag.cBj() && !ag.cBk()))) {
                    bMG();
                }
            }
            if (this.oWp == null) {
                boolean booleanValue;
                Object obj = com.tencent.mm.kernel.g.Dj().CU().get(w.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.valueOf(false));
                if (obj != null) {
                    booleanValue = ((Boolean) obj).booleanValue();
                } else {
                    booleanValue = false;
                }
                if (booleanValue) {
                    x.i("MicroMsg.WalletOrderInfoOldUI", "has show the finger print auth guide!");
                    return;
                }
                com.tencent.mm.wallet_core.c ag2 = com.tencent.mm.wallet_core.a.ag(this);
                Bundle bundle = new Bundle();
                if (ag2 != null) {
                    bundle = ag2.msB;
                }
                if (TextUtils.isEmpty(bundle.getString("key_pwd1"))) {
                    x.i("MicroMsg.WalletOrderInfoOldUI", "pwd is empty, not show the finger print auth guide!");
                    return;
                }
                this.sUH = false;
                if (ag2 != null) {
                    ag2.a(this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle);
                    return;
                }
                return;
            }
            return;
        }
        x.k("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
        h.a(this.mController.xIM, i.uTp, 0, new 4(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uD(4);
        this.sTU = new HashSet();
        WT();
        initView();
        ji(1979);
        com.tencent.mm.sdk.b.a.xef.b(this.sUo);
        com.tencent.mm.sdk.b.a.xef.b(this.oYB);
        this.sUH = false;
    }

    protected final boolean boa() {
        return false;
    }

    public Orders bMF() {
        return (Orders) this.vf.getParcelable("key_orders");
    }

    public void bMG() {
        l(new com.tencent.mm.plugin.wallet_core.c.x(bJQ(), 21));
    }

    public void No(String str) {
        l(new y(str));
    }

    protected final void cr(String str, int i) {
        l(new y(str, i));
    }

    protected final void a(Orders$Promotions orders$Promotions) {
        r(new n(orders$Promotions, bJQ(), this.oWp, orders$Promotions.sNw));
    }

    private void c(Orders orders) {
        this.sTU.clear();
        if (orders == null || orders.sNW == null) {
            x.w("MicroMsg.WalletOrderInfoOldUI", "hy: orders is null");
            return;
        }
        for (Commodity commodity : orders.sNW) {
            if (commodity.sNN == 2 && !bh.ov(commodity.sOl)) {
                x.d("MicroMsg.WalletOrderInfoOldUI", "hy: has username and is force recommend");
                this.sTU.add(commodity.sOl);
            }
        }
    }

    protected final void initView() {
        setMMTitle(i.uTP);
        showHomeBtn(false);
        enableBackMenu(false);
        String string = getString(i.dFl);
        if (this.sEO == null || this.sEO.fCV != 2) {
            if (!(this.sEs == null || bh.ov(this.sEs.sOh))) {
                string = this.sEs.sOh;
            }
        } else if (!bh.ov(this.sEO.tan)) {
            string = getString(i.dDO) + this.sEO.tan;
        } else if (!(bh.ov(this.sEO.appId) || bh.ov(com.tencent.mm.pluginsdk.model.app.g.l(this, this.sEO.appId)))) {
            string = getString(i.dDO) + com.tencent.mm.pluginsdk.model.app.g.l(this, this.sEO.appId);
        }
        addTextOptionMenu(0, string, new 7(this));
        this.sUy = (LinearLayout) findViewById(a$f.uzA);
        this.sUz = (TextView) findViewById(a$f.uzz);
        this.sUA = (TextView) findViewById(a$f.uzs);
        MaxListView maxListView = (MaxListView) findViewById(a$f.uzf);
        this.sUB = new a(this);
        maxListView.setAdapter(this.sUB);
        bMH();
        bMI();
        ((ScrollView) findViewById(a$f.cYz)).pageScroll(33);
    }

    public final void bMH() {
        if (this.sEs != null) {
            int i;
            this.sTV = this.sEs.sNW;
            for (Commodity commodity : this.sTV) {
                if ("1".equals(commodity.pas)) {
                    i = 0;
                    break;
                }
            }
            i = 1;
            this.sUy.setVisibility(0);
            this.sUz.setVisibility(0);
            if (i == 0) {
                this.sUz.setText(i.uTF);
            } else if (!bh.ov(this.sEs.sNP) && !bh.ov(this.sEs.sNP.trim())) {
                this.sUz.setText(this.sEs.sNP);
            } else if (this.sEs.sIJ != 1) {
                this.sUz.setText(i.uTE);
            } else {
                this.sUz.setText(i.uTD);
            }
        }
    }

    protected final void a(String str, d dVar) {
        bMu();
        this.sUG = dVar;
        e.r(this, str, 1);
        this.sUH = false;
    }

    protected final void Nn(String str) {
        bMu();
        e.l(this, str, false);
        this.sUH = false;
    }

    public final void bMu() {
        int i = 0;
        if (!this.sRv) {
            com.tencent.mm.sdk.b.b inVar = new in();
            inVar.fyU.fyV = 4;
            in$a com_tencent_mm_g_a_in_a = inVar.fyU;
            if (this.vf.getBoolean("intent_pay_end", false)) {
                i = -1;
            }
            com_tencent_mm_g_a_in_a.bjW = i;
            com.tencent.mm.sdk.b.a.xef.m(inVar);
            this.sRv = true;
        }
    }

    public final void K(com.tencent.mm.storage.x xVar) {
        if (xVar != null && ((int) xVar.gJd) != 0) {
            String AP = xVar.AP();
            x.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer nickName " + AP + " username: " + xVar.field_username);
            if (this.sTV != null && this.sTV.size() > 0) {
                for (Commodity commodity : this.sTV) {
                    commodity.paA = AP;
                }
                this.sUB.notifyDataSetChanged();
            }
            this.jKk = xVar.field_username;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xef.c(this.sUo);
        com.tencent.mm.sdk.b.a.xef.c(this.oYB);
        jj(1979);
    }

    public void done() {
        if (this.vf.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.vf.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoOldUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
                boolean b = realnameGuideHelper.b(this, bundle, new 8(this));
                this.vf.remove("key_realname_guide_helper");
                if (!b) {
                    bME();
                    return;
                }
                return;
            }
            return;
        }
        bME();
    }

    public final void bME() {
        bMu();
        this.sUH = false;
        com.tencent.mm.sdk.b.b alVar = new al();
        alVar.fox.foy = true;
        com.tencent.mm.sdk.b.a.xef.m(alVar);
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.vf.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.vf.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.vf.getBoolean("intent_pay_end"));
        x.i("MicroMsg.WalletOrderInfoOldUI", "pay done...feedbackData errCode:" + this.vf.getInt("intent_pay_end_errcode"));
        for (String str : this.sTU) {
            if (!bh.ov(str)) {
                x.i("MicroMsg.WalletOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", str);
                if (this.sEs == null || this.sEO == null) {
                    com.tencent.mm.kernel.g.Di().gPJ.a(new com.tencent.mm.wallet_core.c.i(str), 0);
                } else {
                    com.tencent.mm.kernel.g.Di().gPJ.a(new com.tencent.mm.wallet_core.c.i(str, this.sEs.fuH, this.sEs.sNW.size() > 0 ? ((Commodity) this.sEs.sNW.get(0)).fuI : "", this.sEO.fCV, this.sEO.fCR, this.sEs.sNN), 0);
                }
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(13033, Integer.valueOf(2), str, "", "", "");
        }
        com.tencent.mm.wallet_core.a.j(this, bundle);
        if (this.sEs != null && !bh.ov(this.sEs.lOX)) {
            String d = d(this.sEs.lOX, this.sEs.fuH, this.sEs.sNW.size() > 0 ? ((Commodity) this.sEs.sNW.get(0)).fuI : "", this.sEO.kKe, this.sEO.iIj);
            x.d("MicroMsg.WalletOrderInfoOldUI", "url = " + d);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", d);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", q.FS());
            intent.putExtra("stastic_scene", 8);
            d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        done();
        return true;
    }

    @Deprecated
    protected Dialog onCreateDialog(int i) {
        return h.a(this.mController.xIM, getString(i.uTB), getResources().getStringArray(a$b.uau), "", new 9(this));
    }

    public void onResume() {
        super.onResume();
        x.i("MicroMsg.WalletOrderInfoOldUI", "onResume, isClickActivityTinyApp: %s", Boolean.valueOf(this.sUH));
        if (this.sUH) {
            l(new z(this.sUG.sIN, this.sUG.sUt, this.sUG.sUu, this.sUG.sUv, this.sUG.fwY, this.sUG.pLr, this.sUG.sOP));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.WalletOrderInfoOldUI", "onActivityResult %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            l(new z(this.sUG.sIN, this.sUG.sUt, this.sUG.sUu, this.sUG.sUv, this.sUG.fwY, this.sUG.pLr, this.sUG.sOP));
        }
    }

    private void bMI() {
        if (this.sEs == null || this.sEs.sNW == null || this.sEs.sNW.size() <= 0 || ((Commodity) this.sEs.sNW.get(0)).sOu == null || bh.ov(((Commodity) this.sEs.sNW.get(0)).sOu.text) || bh.ov(((Commodity) this.sEs.sNW.get(0)).sOu.url)) {
            x.i("MicroMsg.WalletOrderInfoOldUI", "hy: no commodity or no link act or link act is illegal!");
            this.sUA.setVisibility(8);
            return;
        }
        this.sUA.setVisibility(0);
        this.sUA.setText(((Commodity) this.sEs.sNW.get(0)).sOu.text);
        this.sUA.setOnClickListener(new 10(this));
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if ((kVar instanceof z) && i == 0 && i2 == 0) {
            z zVar = (z) kVar;
            b bVar = new b(this, zVar.orF);
            boolean z = (bh.ov(bVar.url) || bh.ov(bVar.fyY)) ? false : true;
            if (z) {
                this.sRA.put(zVar.sIN, bVar);
            }
            this.sUB.notifyDataSetChanged();
        }
        if (kVar instanceof y) {
            if (i == 0 && i2 == 0) {
                uD(0);
                this.sEs = ((y) kVar).sIO;
                if (this.sEs != null) {
                    this.sTV = this.sEs.sNW;
                }
                c(this.sEs);
                x.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + this.sTV);
                if (!(this.sTV == null || this.sTV.size() == 0)) {
                    Commodity commodity = (Commodity) this.sTV.get(0);
                    this.oWp = commodity.fuI;
                    x.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + commodity.toString());
                    com.tencent.mm.l.a WO = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(commodity.paA);
                    if (WO == null || ((int) WO.gJd) == 0) {
                        ak.a.hfL.a(commodity.paA, "", this.sUI);
                    } else {
                        K(WO);
                    }
                    this.sUB.notifyDataSetChanged();
                    bMH();
                }
            }
            if (this.sUB != null) {
                this.sUB.notifyDataSetChanged();
            }
            bMI();
            return true;
        }
        if (kVar instanceof n) {
            if (i == 0 && i2 == 0) {
                n nVar = (n) kVar;
                String str2 = nVar.sIy;
                this.sUF.put(Long.valueOf(nVar.sIB.sIr), str2);
                nVar.sIB.sNx = nVar.kZo;
                if (!"-1".equals(str2) && !"0".equals(str2) && !bh.ov(nVar.sIz)) {
                    h.b(this, nVar.sIz, "", true);
                } else if ("0".equals(str2)) {
                    CharSequence string;
                    if (bh.ov(nVar.sIz)) {
                        string = getString(i.uUr);
                    } else {
                        string = nVar.sIz;
                    }
                    Toast.makeText(this, string, 0).show();
                }
                this.sUB.notifyDataSetChanged();
                return true;
            } else if (kVar instanceof n) {
                if (bh.ov(str)) {
                    str = getString(i.uXa);
                }
                h.a(this, str, null, false, new 2(this));
                return true;
            }
        }
        return false;
    }

    public final String fg(long j) {
        if (this.sUF.containsKey(Long.valueOf(j))) {
            return (String) this.sUF.get(Long.valueOf(j));
        }
        return "-1";
    }
}
