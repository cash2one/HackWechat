package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.plugin.wallet_core.model.j;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class MallIndexBaseUI extends WalletBaseUI implements a, j {
    protected String ned;
    private String ogG = null;
    private String okL = null;
    private ArrayList<MallFunction> okM = null;
    protected int okQ;
    private TextView olQ = null;
    protected ListView olR = null;
    private b olS = null;
    protected ImageView olT = null;
    protected ImageView olU;
    protected TextView olV = null;
    protected TextView olW;
    private int olX = 0;
    private boolean olY = true;
    private boolean olZ = false;

    protected abstract void aYc();

    protected abstract void aYd();

    protected abstract void aYe();

    protected abstract boolean aYg();

    protected abstract void aYl();

    protected abstract void aYm();

    protected abstract void aYo();

    protected abstract void aYp();

    protected abstract void cp(View view);

    protected final int getLayoutId() {
        return g.uCP;
    }

    public void onCreate(Bundle bundle) {
        x.i("MicroMsg.MallIndexBaseUI", "onCreate");
        super.onCreate(bundle);
        if (!com.tencent.mm.kernel.g.Dh().Cy()) {
            x.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
            finish();
        }
        com.tencent.mm.kernel.g.Dk();
        int intValue = ((Integer) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xrD, Integer.valueOf(0))).intValue();
        this.okQ = getIntent().getIntExtra("key_wallet_region", intValue);
        this.ned = getIntent().getStringExtra("key_uuid");
        if (!bh.ov(this.ned)) {
            this.ned = UUID.randomUUID().toString();
        }
        ji(495);
        o.bLx();
        aa.a(this);
        this.okL = getIntent().getStringExtra("key_func_id");
        x.i("MicroMsg.MallIndexBaseUI", "mFuncId:" + this.okL + " wallet_region: " + this.okQ + " walletType: " + q.FZ() + " default_region: " + intValue);
        this.ogG = getIntent().getStringExtra("key_native_url");
        x.i("MicroMsg.MallIndexBaseUI", "mNativeUrl:" + this.ogG);
        if (!aYf()) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(a$c.ubb));
            }
            if (d.fM(21)) {
                getWindow().setStatusBarColor(getResources().getColor(a$c.ubC));
            }
            cmS();
            uD(0);
            x.i("MicroMsg.MallIndexBaseUI", "index Oncreate");
            aYc();
            initView();
            c.bMh();
            aYd();
            x.i("MicroMsg.MallIndexBaseUI", "hy: use default controller for MallIndexUI");
            aYe();
            if (q.Gf()) {
                x.e("MicroMsg.MallIndexBaseUI", "it is payu account ,not initFingerPrint");
            } else {
                l lVar = (l) com.tencent.mm.kernel.g.h(l.class);
                if (lVar != null) {
                    x.i("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
                    lVar.cB(this);
                } else {
                    x.e("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null");
                }
            }
            p.ft(1, 0);
            com.tencent.mm.plugin.report.service.g.pQN.h(11850, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
        }
    }

    public final boolean aYf() {
        if (bh.ov(this.okL) && bh.ov(this.ogG)) {
            return false;
        }
        return true;
    }

    public void onResume() {
        boolean z = true;
        super.onResume();
        i.CB(1);
        x.i("MicroMsg.MallIndexBaseUI", "index onResume");
        if (!com.tencent.mm.kernel.g.Dh().Cy()) {
            x.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
            finish();
        }
        if (aYf()) {
            this.okM = com.tencent.mm.plugin.mall.a.d.aXX().so(this.okQ);
            if (this.okM == null || this.okM.size() <= 0) {
                x.i("MicroMsg.MallIndexBaseUI", "mFunctionList == null");
                try {
                    if (getIntent().getIntExtra("key_scene", 0) == 1 || !bh.ov(this.ogG)) {
                        r(new com.tencent.mm.plugin.mall.a.a(this.okQ, b.bMd()));
                        return;
                    }
                    String stringExtra = getIntent().getStringExtra("key_url");
                    if (stringExtra == null) {
                        stringExtra = "";
                    }
                    r(new com.tencent.mm.plugin.mall.a.a(this.okQ, b.bMd(), getIntent().getStringExtra("key_app_id"), this.okL, stringExtra));
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MallIndexBaseUI", e, "", new Object[0]);
                    aYk();
                    return;
                }
            }
            MallFunction be = be(this.okM);
            if (be == null) {
                be = bf(this.okM);
            }
            a(be, -1);
            finish();
            return;
        }
        aYg();
        x.d("MicroMsg.MallIndexBaseUI", "initFunctionList");
        if (com.tencent.mm.plugin.mall.a.d.aXX().so(this.okQ) == null) {
            b(new com.tencent.mm.plugin.mall.a.a(this.okQ, b.bMd()), true);
            x.e("MicroMsg.MallIndexBaseUI", "funcitonlist invalid");
            z = false;
        } else {
            b(new com.tencent.mm.plugin.mall.a.a(this.okQ, b.bMd()), false);
            this.okM = com.tencent.mm.plugin.mall.a.d.aXX().so(this.okQ);
        }
        if (z) {
            x.i("MicroMsg.MallIndexBaseUI", "has data");
            au();
        }
    }

    private void aYh() {
        boolean booleanExtra = getIntent().getBooleanExtra("key_wallet_has_red", false);
        if (this.olR.getChildCount() != 0) {
            x.i("MicroMsg.MallIndexBaseUI", "initCheckNew %s fpos %s top %s", new Object[]{Boolean.valueOf(booleanExtra), Integer.valueOf(this.olR.getFirstVisiblePosition()), Integer.valueOf(this.olR.getChildAt(0).getTop())});
            if (this.olR.getFirstVisiblePosition() == 0 && r2 == 0 && booleanExtra && !this.olZ && this.okM != null) {
                this.olZ = true;
                int count = this.olS.getCount() + this.olR.getHeaderViewsCount();
                List list = this.olS.oll;
                if (list != null) {
                    int i = count;
                    for (count = list.size() - 1; count > 0; count--) {
                        Iterator it = ((ArrayList) list.get(count)).iterator();
                        while (it.hasNext()) {
                            b.c cVar = (b.c) it.next();
                            if (cVar != null && cVar.olO != null && b.a(cVar.olO)) {
                                x.i("MicroMsg.MallIndexBaseUI", "get listview show top %s bottom %s redPos: %d", new Object[]{Integer.valueOf(this.olR.getFirstVisiblePosition()), Integer.valueOf(this.olR.getLastVisiblePosition()), Integer.valueOf(i)});
                                if (i < this.olR.getFirstVisiblePosition() || i > r1) {
                                    count = a.aYa();
                                    int aXZ = (a.aXZ() + (a.aXY() * (i + 1))) + count;
                                    if (i > 2) {
                                        aXZ += count;
                                    }
                                    if (i > 3) {
                                        aXZ += count;
                                    }
                                    count = (aXZ + (a.aXY() / 3)) - this.olR.getScrollY();
                                    aXZ = ae.fz(this).y;
                                    if (ae.fy(this)) {
                                        aXZ -= ae.fx(this);
                                    }
                                    if (getSupportActionBar() != null) {
                                        aXZ -= getSupportActionBar().getHeight();
                                    }
                                    this.olR.smoothScrollBy(count - aXZ, 1000);
                                    return;
                                }
                                return;
                            }
                        }
                        i--;
                    }
                }
            }
        }
    }

    public void a(MallFunction mallFunction, int i) {
        int i2;
        if (mallFunction != null && i >= 0) {
            String str = "";
            if (!(mallFunction.sQt == null || bh.ov(mallFunction.sQt.rVK))) {
                str = mallFunction.sQt.rVK;
            }
            int size = this.okM == null ? 0 : this.okM.size();
            boolean a = b.a(mallFunction);
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
            Object[] objArr = new Object[6];
            objArr[0] = mallFunction.pBK;
            objArr[1] = Integer.valueOf(size);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(i);
            objArr[4] = str;
            if (a) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            objArr[5] = Integer.valueOf(i2);
            gVar.h(10881, objArr);
        }
        if (mallFunction == null || bh.ov(mallFunction.fLC) || !((com.tencent.mm.plugin.appbrand.m.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.d.class)).tb(mallFunction.fLC)) {
            if (mallFunction != null) {
                c.bMe().Nb(mallFunction.pBK);
                com.tencent.mm.plugin.wallet_core.model.mall.d.bMi().Nb(mallFunction.pBK);
                if (mallFunction.sQt != null) {
                    c.bMe();
                    c.c(mallFunction);
                }
                if ("wxpay://bizmall/mobile_recharge".equals(mallFunction.fLC)) {
                    i2 = 0;
                } else if ("wxpay://bizmall/weixin_hongbao".equals(mallFunction.fLC)) {
                    i2 = 4;
                } else if ("wxpay://bizmall/weixin_scan_qrcode".equals(mallFunction.fLC)) {
                    i2 = 8;
                } else if ("wxpay://bizmall/weixin_transfer".equals(mallFunction.fLC)) {
                    i2 = 5;
                } else if ("wxpay://bizmall/weixin_offline_pay".equals(mallFunction.fLC)) {
                    i2 = 6;
                } else if ("wxpay://bizmall/old_mobile_recharge".equals(mallFunction.fLC)) {
                    i2 = 7;
                } else if (!bh.ov(mallFunction.nvp)) {
                    i2 = 1;
                } else if ("wxpay://bizmall/f2f_hongbao".equals(mallFunction.fLC)) {
                    i2 = 9;
                } else {
                    x.w("MicroMsg.MallIndexUIHelper", "doSelectFunction no jump");
                    i2 = 2;
                }
            } else {
                i2 = 3;
            }
            x.i("MicroMsg.MallIndexBaseUI", "functionType : " + i2);
            Intent intent;
            switch (i2) {
                case 0:
                    intent = new Intent();
                    if (aYf()) {
                        intent.putExtra("key_is_hide_progress", true);
                    }
                    intent.putExtra("key_func_info", mallFunction);
                    com.tencent.mm.bm.d.b(this, "recharge", ".ui.PhoneRechargeUI", intent);
                    p.ft(15, 0);
                    return;
                case 1:
                    com.tencent.mm.kernel.g.Dk();
                    this.okQ = ((Integer) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xrD, Integer.valueOf(0))).intValue();
                    intent = new Intent();
                    intent.putExtra("rawUrl", mallFunction.nvp);
                    intent.putExtra("geta8key_username", q.FS());
                    intent.putExtra("pay_channel", 1);
                    intent.putExtra("KPublisherId", "pay_wallet");
                    intent.putExtra("key_download_restrict", mallFunction.sQv);
                    intent.putExtra("key_wallet_region", this.okQ);
                    intent.putExtra("key_function_id", mallFunction.pBK);
                    intent.putExtra("geta8key_scene", 46);
                    com.tencent.mm.bm.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    return;
                case 2:
                    x.w("MicroMsg.MallIndexBaseUI", "doSelectFunction no jump");
                    return;
                case 3:
                    x.w("MicroMsg.MallIndexBaseUI", "doSelectFunction do nothing");
                    u.makeText(this, "fuction list error", 1).show();
                    return;
                case 4:
                    com.tencent.mm.plugin.report.service.g.pQN.h(11701, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
                    intent = new Intent();
                    intent.putExtra("pay_channel", 1);
                    com.tencent.mm.bm.d.b(this, "luckymoney", ".ui.LuckyMoneyIndexUI", intent);
                    p.ft(13, 0);
                    com.tencent.mm.plugin.report.service.g.pQN.h(11850, new Object[]{Integer.valueOf(4), Integer.valueOf(0)});
                    return;
                case 5:
                    com.tencent.mm.plugin.report.service.g.pQN.h(11458, new Object[]{Integer.valueOf(1)});
                    if (q.Gf()) {
                        List linkedList = new LinkedList();
                        List linkedList2 = new LinkedList();
                        linkedList.add(getString(com.tencent.mm.plugin.wxpay.a.i.uOk));
                        linkedList2.add(Integer.valueOf(0));
                        linkedList.add(getString(com.tencent.mm.plugin.wxpay.a.i.uIT));
                        linkedList2.add(Integer.valueOf(1));
                        h.a(this, getString(com.tencent.mm.plugin.wxpay.a.i.uNd), linkedList, linkedList2, null, true, new 3(this));
                    } else {
                        com.tencent.mm.kernel.g.Dk();
                        if (((Boolean) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xnT, Boolean.valueOf(false))).booleanValue()) {
                            aYn();
                        } else {
                            com.tencent.mm.kernel.g.Dk();
                            com.tencent.mm.kernel.g.Dj().CU().a(w.a.xnT, Boolean.valueOf(true));
                            h.a(this, getString(com.tencent.mm.plugin.wxpay.a.i.uRU), "", new 4(this));
                        }
                    }
                    p.ft(14, 0);
                    com.tencent.mm.plugin.report.service.g.pQN.h(11850, new Object[]{Integer.valueOf(3), Integer.valueOf(0)});
                    return;
                case 6:
                    intent = new Intent();
                    intent.putExtra("key_from_scene", 1);
                    com.tencent.mm.bm.d.b(this.mController.xIM, "offline", ".ui.WalletOfflineEntranceUI", intent);
                    p.ft(9, 0);
                    com.tencent.mm.plugin.report.service.g.pQN.h(11850, new Object[]{Integer.valueOf(5), Integer.valueOf(0)});
                    return;
                case 7:
                    intent = new Intent();
                    if (aYf()) {
                        intent.putExtra("key_is_hide_progress", true);
                    }
                    intent.putExtra("key_func_info", mallFunction);
                    com.tencent.mm.bm.d.b(this, "recharge", ".ui.RechargeUI", intent);
                    return;
                case 8:
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    com.tencent.mm.bm.d.b(this.mController.xIM, "scanner", ".ui.BaseScanUI", intent);
                    return;
                case 9:
                    com.tencent.mm.bm.d.y(this.mController.xIM, "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
                    return;
                default:
                    return;
            }
        }
        x.i("MicroMsg.MallIndexBaseUI", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[]{mallFunction.fLC});
        c.bMe().Nb(mallFunction.pBK);
        com.tencent.mm.plugin.wallet_core.model.mall.d.bMi().Nb(mallFunction.pBK);
        if (mallFunction.sQt != null) {
            c.bMe();
            c.c(mallFunction);
        }
    }

    public void onDestroy() {
        jj(495);
        o.bLx();
        aa.b(this);
        super.onDestroy();
    }

    public boolean d(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.MallIndexBaseUI", "onOtherSceneEnd");
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.b.a) {
            x.d("MicroMsg.MallIndexBaseUI", "hy: query bound scene end");
            if (i != 0 || i2 != 0) {
                finish();
                return true;
            } else if (this.olY) {
                this.olY = false;
                if (o.bLm().bMn().bLJ()) {
                    com.tencent.mm.wallet_core.a.b(this, "PayUOpenProcess", null);
                    return true;
                }
            }
        }
        switch (kVar.getType()) {
            case 495:
                com.tencent.mm.plugin.mall.a.a aVar = (com.tencent.mm.plugin.mall.a.a) kVar;
                if (aVar.okQ != this.okQ) {
                    x.i("MicroMsg.MallIndexBaseUI", "pass wallet local: %d cgi: %d", new Object[]{Integer.valueOf(this.okQ), Integer.valueOf(aVar.okQ)});
                }
                if (aYf()) {
                    x.d("MicroMsg.MallIndexBaseUI", "errorType:%d | errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (i != 0 || i2 != 0 || aVar.okM == null || aVar.okM.size() <= 0) {
                        aYk();
                        return true;
                    }
                    MallFunction be;
                    if (getIntent().getIntExtra("key_scene", 0) == 1) {
                        be = be(aVar.okM);
                        if (be != null) {
                            a(be, -1);
                        }
                    } else if (!bh.ov(this.ogG)) {
                        x.d("MicroMsg.MallIndexBaseUI", "NativeUrl: %s", new Object[]{this.ogG});
                        be = bf(aVar.okM);
                        if (be != null) {
                            a(be, -1);
                        } else {
                            aYk();
                            return true;
                        }
                    } else if (aVar.okM != null && aVar.okM.size() > 0) {
                        x.i("MicroMsg.MallIndexBaseUI", "functionScene.mFunctionList != null");
                        a(be(aVar.okM), -1);
                    } else if (com.tencent.mm.plugin.mall.a.d.aXX().so(this.okQ) == null || com.tencent.mm.plugin.mall.a.d.aXX().so(this.okQ).size() <= 0) {
                        x.e("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() == null");
                    } else {
                        x.i("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() != null");
                        a(be(com.tencent.mm.plugin.mall.a.d.aXX().so(this.okQ)), -1);
                    }
                    setResult(-1);
                    finish();
                    return true;
                }
                if (i == 0 && i2 == 0 && com.tencent.mm.plugin.mall.a.d.aXX().so(this.okQ) != null && aVar.okM != null && aVar.okM.size() > 0) {
                    this.okM = com.tencent.mm.plugin.mall.a.d.aXX().so(this.okQ);
                    x.i("MicroMsg.MallIndexBaseUI", "get from server now! " + this.okQ + " " + this.okM.size());
                    c.bMe().S(this.okM);
                }
                au();
                aYh();
                return true;
            default:
                return false;
        }
    }

    private MallFunction be(List<MallFunction> list) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(this.okL)) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            MallFunction mallFunction = (MallFunction) list.get(i);
            if (mallFunction != null && this.okL.equals(mallFunction.pBK)) {
                return mallFunction;
            }
        }
        return null;
    }

    private MallFunction bf(List<MallFunction> list) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(this.ogG)) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            MallFunction mallFunction = (MallFunction) list.get(i);
            if (mallFunction != null && this.ogG.equals(mallFunction.fLC)) {
                return mallFunction;
            }
        }
        return null;
    }

    protected final boolean aYi() {
        if (!aYf()) {
            au();
        }
        return true;
    }

    public final boolean aYj() {
        return false;
    }

    public final void l(String str, Bitmap bitmap) {
    }

    private void aYk() {
        setResult(0);
        finish();
    }

    private void au() {
        showOptionMenu(true);
        b bVar = this.olS;
        ArrayList arrayList = this.okM;
        bVar.oll.clear();
        if (arrayList != null) {
            int i;
            int i2;
            int i3 = 0;
            while (i3 < arrayList.size()) {
                ArrayList arrayList2 = new ArrayList();
                i = 0;
                while (i < 3 && i3 + i < arrayList.size()) {
                    int i4 = i3 + i;
                    if (i > 0) {
                        i2 = (i3 + i) - 1;
                        if (i2 >= 0 && ((MallFunction) arrayList.get(i2)).type != ((MallFunction) arrayList.get(i4)).type) {
                            break;
                        }
                    }
                    b.c cVar = new b.c(bVar);
                    cVar.olP = i3 + i;
                    cVar.olO = (MallFunction) arrayList.get(i3 + i);
                    arrayList2.add(cVar);
                    i++;
                }
                if (arrayList2.size() > 0) {
                    bVar.oll.add(arrayList2);
                }
                i3 += i;
            }
            bVar.olo = 0;
            bVar.olp = 0;
            i = -1;
            for (ArrayList arrayList3 : bVar.oll) {
                if (arrayList3.size() > 0) {
                    if (i != -1 && i != ((b.c) arrayList3.get(0)).olO.type) {
                        break;
                    }
                    bVar.olo += arrayList3.size();
                    bVar.olp++;
                    i2 = ((b.c) arrayList3.get(0)).olO.type;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            bVar.olp--;
        }
        bVar.okP = com.tencent.mm.plugin.mall.a.d.aXX().sn(bVar.okQ).okP;
        bVar.olq = bVar.aYb();
        bVar.notifyDataSetChanged();
        aYm();
        aYo();
        if (this.olQ != null) {
            this.olQ.setVisibility(8);
        }
        aYp();
    }

    public void onStop() {
        super.onStop();
    }

    public final void initView() {
        x.d("MicroMsg.MallIndexBaseUI", "index initView");
        setBackBtn(new 1(this));
        a.c(this);
        this.olR = (ListView) findViewById(f.upX);
        View inflate = v.fv(this).inflate(g.uCO, null);
        this.olR.addHeaderView(inflate);
        LayoutParams layoutParams = (AbsListView.LayoutParams) inflate.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
        }
        layoutParams.height = a.aXZ();
        inflate.setLayoutParams(layoutParams);
        this.olS = new b(this, this.okQ);
        this.olR.setAdapter(this.olS);
        this.olS.olm = new 2(this);
        cp(inflate);
        this.olW = (TextView) findViewById(f.ufy);
        aYl();
    }

    private void aYn() {
        if (q.Gf()) {
            com.tencent.mm.wallet_core.a.b(this.mController.xIM, "PayURemittanceProcess", null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("pay_channel", 1);
        com.tencent.mm.wallet_core.a.b(this.mController.xIM, "RemittanceProcess", bundle);
    }

    public void finish() {
        super.finish();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public final void sp(int i) {
        if (i == 12 && this.olV != null) {
            aYm();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            com.tencent.mm.kernel.g.Dk();
            this.okQ = ((Integer) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xrD, Integer.valueOf(0))).intValue();
            if (i2 != -1) {
                return;
            }
            if (q.Gg()) {
                finish();
                return;
            }
            finish();
            com.tencent.mm.sdk.b.b nkVar = new nk();
            nkVar.fFu.context = this.mController.xIM;
            com.tencent.mm.sdk.b.a.xef.m(nkVar);
        }
    }

    protected final void aYq() {
        com.tencent.mm.bm.d.c(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
    }

    protected static void x(Activity activity) {
        if (o.bLq().bLQ().bLH()) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "https://wx.tenpay.com/userroll/readtemplate?t=userroll/index_tmpl");
            com.tencent.mm.bm.d.b(activity, "webview", ".ui.tools.WebViewUI", intent);
        } else {
            com.tencent.mm.wallet_core.a.b(activity, "ShowOrdersInfoProcess", null);
        }
        e.HF(20);
    }
}
