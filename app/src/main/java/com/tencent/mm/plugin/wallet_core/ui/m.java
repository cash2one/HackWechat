package com.tencent.mm.plugin.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.g.a.na;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet_core.e.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.z.q;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class m extends k implements c {
    private static HashMap<String, Boolean> sVU = new HashMap();
    public OnCancelListener Gj;
    public ImageView hvY;
    private boolean isPaused = false;
    public View kND;
    protected MyKeyboardWindow mKeyboard;
    private Animation mzS;
    private int mzT = 0;
    protected View ofs;
    protected PayInfo pCn;
    public TextView pOz;
    public TextView pUY;
    protected boolean qoX;
    protected a sBT = new a();
    public FavorPayInfo sEQ = new FavorPayInfo();
    public TextView sFJ;
    protected a sFy = null;
    public TextView sVA;
    public TextView sVB;
    public View sVC;
    public TextView sVD;
    public a sVE;
    public OnClickListener sVF;
    public boolean sVG = false;
    protected boolean sVH = true;
    public Bankcard sVI = null;
    public TextView sVJ;
    public View sVK;
    public TextView sVL;
    public ImageView sVM;
    protected int sVN = 0;
    protected boolean sVO = false;
    private int sVP = 0;
    private Animation sVQ = null;
    private String sVR = "";
    private long sVS = -1;
    boolean sVT = false;
    public Button sVn;
    public ImageView sVo;
    public TextView sVp;
    public TextView sVq;
    public FavourLayout sVr;
    public ImageView sVs;
    public TextView sVt;
    public EditHintPasswdView sVu;
    public c sVv;
    public View sVw;
    public View sVx;
    public TextView sVy;
    public ImageView sVz;

    static /* synthetic */ void a(m mVar) {
        mVar.sVJ.setText(mVar.getContext().getString(i.uVw));
        mVar.sVN = 1;
        mVar.sVS = bh.Wq();
        mVar.sVK.setVisibility(0);
        mVar.sVM.setVisibility(0);
        mVar.sVL.setVisibility(8);
        mVar.sVu.setVisibility(8);
        mVar.ofs.setVisibility(8);
        mVar.sVp.setText(i.uVq);
        jQ(false);
        mVar.pCn.vzy = 1;
        g.pQN.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
        e.HF(9);
    }

    static /* synthetic */ boolean c(m mVar) {
        String str = "MicroMsg.WalletPwdDialog";
        String str2 = "hy: is screen on: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(!mVar.isPaused);
        x.i(str, str2, objArr);
        return !mVar.isPaused;
    }

    public m(Context context) {
        super(context, j.uYC);
        cd(context);
    }

    public void cd(Context context) {
        x.v("MicroMsg.WalletPwdDialog", "alvinluo WalletPwdDialog initView");
        dJ(context);
        dK(context);
        bMK();
    }

    public final void dJ(Context context) {
        this.kND = View.inflate(context, bMM(), null);
        this.sVn = (Button) this.kND.findViewById(f.cwl);
        this.sVo = (ImageView) this.kND.findViewById(f.uzV);
        this.mKeyboard = (MyKeyboardWindow) this.kND.findViewById(f.uwN);
        this.ofs = this.kND.findViewById(f.uwM);
        this.pUY = (TextView) this.kND.findViewById(f.content);
        this.sVp = (TextView) this.kND.findViewById(f.uzZ);
        this.pOz = (TextView) this.kND.findViewById(f.fpO);
        this.sFJ = (TextView) this.kND.findViewById(f.usK);
        this.sFJ.getPaint().setFlags(16);
        this.sVq = (TextView) this.kND.findViewById(f.ufw);
        this.sVr = (FavourLayout) this.kND.findViewById(f.ukt);
        this.sVs = (ImageView) this.kND.findViewById(f.ufp);
        this.sVw = this.kND.findViewById(f.ukp);
        this.sVt = (TextView) this.kND.findViewById(f.urJ);
        this.hvY = (ImageView) this.kND.findViewById(f.uhD);
        this.sVx = this.kND.findViewById(f.ufn);
        this.sVy = (TextView) this.kND.findViewById(f.uwu);
        b.a(this.hvY, e.getUsername());
        this.sVu = (EditHintPasswdView) this.kND.findViewById(f.ukY);
        this.sVz = (ImageView) this.kND.findViewById(f.ukO);
        this.sVJ = (TextView) this.kND.findViewById(f.uzQ);
        this.sVK = this.kND.findViewById(f.ukD);
        this.sVL = (TextView) this.kND.findViewById(f.ukE);
        this.sVM = (ImageView) this.kND.findViewById(f.ukC);
        this.sVA = (TextView) this.kND.findViewById(f.uhB);
        this.sVB = (TextView) this.kND.findViewById(f.uuz);
        this.sVC = this.kND.findViewById(f.ukn);
        this.sVD = (TextView) this.kND.findViewById(f.uks);
        this.sVr.setVisibility(8);
    }

    @TargetApi(14)
    public void dK(Context context) {
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        this.sVn.setEnabled(false);
        this.sVn.setTextColor(context.getResources().getColorStateList(c.ubs));
        com.tencent.mm.wallet_core.ui.formview.a.a(this.sVu);
        this.sVu.zJC = new 1(this);
        this.sVu.requestFocus();
        TextView textView = (TextView) this.kND.findViewById(f.uzZ);
        if (textView != null) {
            textView.setText(q.Gf() ? context.getString(i.uVv) : context.getString(i.uVu));
        }
        EditText editText = (EditText) this.kND.findViewById(f.uyz);
        e.setNoSystemInputOnEditText(editText);
        this.mKeyboard.setInputEditText(editText);
        if (VERSION.SDK_INT >= 14) {
            AccessibilityDelegate cVar = new com.tencent.mm.ui.a.c();
            this.mKeyboard.setSecureAccessibility(cVar);
            editText.setAccessibilityDelegate(cVar);
        }
        editText.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ m sVV;

            {
                this.sVV = r1;
            }

            public final void onClick(View view) {
                if (!this.sVV.ofs.isShown()) {
                    this.sVV.ofs.setVisibility(0);
                }
            }
        });
        this.kND.findViewById(f.itm).setOnClickListener(new 3(this));
    }

    private void bMK() {
        boolean z;
        x.v("MicroMsg.WalletPwdDialog", "alvinluo updateFingerprintMode");
        this.sVP = 0;
        this.sVJ.setVisibility(8);
        this.sVK.setVisibility(8);
        this.sVS = bh.Wq();
        l lVar = (l) com.tencent.mm.kernel.g.h(l.class);
        if (o.bLq() == null || !lVar.aJW()) {
            z = true;
        } else {
            z = lVar.aKp();
        }
        x.i("MicroMsg.WalletPwdDialog", "hy: soter key status: %b", new Object[]{Boolean.valueOf(z)});
        if ((this.pCn == null || !(this.pCn.vzA == 100000 || this.pCn.vzA == 100102)) && z) {
            if (this.pCn != null && this.pCn.vzA == 100001) {
                this.pCn.vzy = 1;
            }
            if (lVar == null || !lVar.aKd() || lVar.aJY()) {
                z = false;
            } else {
                z = true;
            }
            x.v("MicroMsg.WalletPwdDialog", "alvinluo isDeviceSupportFp: %b", new Object[]{Boolean.valueOf(z)});
            boolean z2 = lVar != null && lVar.aJW();
            if (z2 && z && this.sVO && !bMP()) {
                this.sVJ.setVisibility(0);
                this.sVJ.setText(getContext().getString(i.uVw));
                this.sVN = 1;
                this.sVK.setVisibility(0);
                this.sVM.setVisibility(0);
                this.sVu.setVisibility(8);
                this.ofs.setVisibility(8);
                this.sVp.setText(i.uVq);
                if (this.pCn != null) {
                    this.pCn.vzy = 1;
                }
                bMy();
                g.pQN.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            } else if (z2 && z && this.sVO && bMP()) {
                this.sVJ.setText(getContext().getString(i.uRH));
                this.sVJ.setVisibility(0);
                this.sVN = 0;
                this.sVK.setVisibility(8);
                this.sVu.setVisibility(0);
                if (!this.ofs.isShown()) {
                    this.ofs.setVisibility(0);
                }
                this.sVp.setText(i.uVu);
                if (this.pCn != null) {
                    this.pCn.vzy = 0;
                }
                g.pQN.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                e.HF(8);
            } else {
                if (this.pCn != null) {
                    this.pCn.vzy = 0;
                }
                this.sVJ.setVisibility(8);
                g.pQN.h(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            }
            x.i("MicroMsg.WalletPwdDialog", "isOpenTouch:" + z2 + ",  isDeviceSupport:" + z + ", use_pay_touch:" + this.sVO + ", isForcePwdMode:" + bMP());
            this.sVJ.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ m sVV;

                {
                    this.sVV = r1;
                }

                public final void onClick(View view) {
                    if (this.sVV.sVN == 0) {
                        m.a(this.sVV);
                    } else if (this.sVV.sVN == 1) {
                        t.d(this.sVV.pCn == null ? 0 : this.sVV.pCn.fCV, this.sVV.pCn == null ? "" : this.sVV.pCn.fuH, 19, "");
                        this.sVV.bML();
                    }
                    if (this.sVV.sVN == 1) {
                        m.bMz();
                        if (m.c(this.sVV)) {
                            this.sVV.bMy();
                        }
                    }
                }
            });
            return;
        }
        if (!this.ofs.isShown()) {
            this.ofs.setVisibility(0);
        }
        if (this.pCn != null) {
            this.pCn.vzy = 0;
            this.pCn.fwZ = "";
            this.pCn.fxa = "";
        }
        this.sVK.setVisibility(0);
        this.sVL.setVisibility(0);
        TextView textView = this.sVL;
        int i = (this.pCn == null || this.pCn.vzA != 100102) ? i.uRG : i.uRJ;
        textView.setText(i);
        this.sVL.setTextColor(getContext().getResources().getColor(c.ubG));
        if (z) {
            this.sVx.setVisibility(8);
            this.sVy.setVisibility(8);
        } else {
            this.sVx.setVisibility(0);
            this.sVy.setVisibility(0);
        }
        if (this.pCn != null && this.pCn.vzA == 100102) {
            com.tencent.mm.kernel.g.Dj().CU().a(w.a.xoN, Boolean.valueOf(true));
            lVar.fi(false);
            com.tencent.mm.kernel.g.Dj().CU().a(w.a.xoL, Boolean.valueOf(false));
        }
        g.pQN.h(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
    }

    private void bML() {
        this.sVJ.setText(getContext().getString(i.uRH));
        this.sVN = 0;
        this.sVS = bh.Wq();
        this.sVK.setVisibility(8);
        this.sVu.setVisibility(0);
        if (!this.ofs.isShown()) {
            this.ofs.setVisibility(0);
        }
        this.sVp.setText(i.uVu);
        jQ(true);
        this.pCn.vzy = 0;
        g.pQN.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
        e.HF(29);
        bMz();
    }

    private void bMy() {
        com.tencent.mm.plugin.soter.c.a.bCN();
        com.tencent.mm.sdk.b.b lfVar = new lf();
        lfVar.fCw.fwY = this.pCn.fuH;
        lfVar.fCw.fCy = 1;
        lfVar.fCw.fCA = new 5(this, lfVar);
        com.tencent.mm.sdk.b.a.xef.a(lfVar, Looper.getMainLooper());
    }

    private static void bMz() {
        x.i("MicroMsg.WalletPwdDialog", "hy: send release FPManager");
        com.tencent.mm.sdk.b.a.xef.m(new na());
    }

    public int bMM() {
        return com.tencent.mm.plugin.wxpay.a.g.uEX;
    }

    private void jO(boolean z) {
        View findViewById = this.kND.findViewById(f.ueY);
        if (findViewById == null) {
            return;
        }
        if (z) {
            findViewById.setVisibility(0);
            this.sVT = true;
            return;
        }
        findViewById.setVisibility(8);
        this.sVT = false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.Gj != null) {
                this.Gj.onCancel(this);
            }
            if (this.sVE != null) {
                this.sVE.bho();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.kND);
        com.tencent.d.b.f.f.cGi().cGj();
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.qoX = z;
        setCanceledOnTouchOutside(this.qoX);
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.WalletPwdDialog", "dismiss exception, e = " + e.getMessage());
        }
        bMz();
        this.sBT.destory();
        if (this.mzS != null) {
            this.mzS.cancel();
        }
    }

    public final void Np(String str) {
        this.pUY.setText(str);
    }

    public final void Nq(String str) {
        if (TextUtils.isEmpty(str)) {
            this.pOz.setVisibility(8);
            return;
        }
        this.pOz.setVisibility(0);
        this.pOz.setText(str);
    }

    private void Nr(String str) {
        if (TextUtils.isEmpty(str)) {
            x.i("MicroMsg.WalletPwdDialog", "ChargeFee is null");
            this.sVA.setVisibility(8);
            return;
        }
        this.sVA.setVisibility(0);
        this.sVA.setText(str);
    }

    public final void eC(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.sVt.setVisibility(8);
        } else {
            this.sVt.setVisibility(0);
            this.sVt.setText(str2);
        }
        if (TextUtils.isEmpty(str)) {
            this.sVD.setVisibility(8);
            return;
        }
        this.sVD.setText(str);
        this.sVD.setVisibility(0);
    }

    public final void Ns(String str) {
        if (TextUtils.isEmpty(str)) {
            this.sFJ.setVisibility(8);
            return;
        }
        this.sFJ.setVisibility(0);
        this.sFJ.setText(str);
    }

    private void g(Bankcard bankcard) {
        if (bankcard == null) {
            x.e("MicroMsg.WalletPwdDialog", "setBankcardText bankcard == null");
        } else if (bankcard.bKP()) {
            this.sVs.setImageResource(com.tencent.mm.plugin.wxpay.a.e.udF);
        } else if (bankcard.bKQ()) {
            this.sBT.a(bankcard, this.sVs);
        } else if (bankcard.bKT()) {
            b.a(this.sVs, bankcard.sLr, 0.06f, false);
        } else {
            this.sBT.a(getContext(), bankcard, this.sVs);
        }
    }

    public final void a(String str, View.OnClickListener onClickListener, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.sVx.setVisibility(8);
            this.sVy.setVisibility(8);
            return;
        }
        this.sVx.setOnClickListener(onClickListener);
        this.sVq.setText(str);
        if (this.sVH) {
            this.sVx.setVisibility(0);
            this.sVy.setVisibility(0);
        } else {
            this.sVx.setVisibility(8);
            this.sVy.setVisibility(8);
        }
        if (z) {
            this.sVw.setVisibility(0);
        } else {
            this.sVw.setVisibility(8);
        }
    }

    public final void a(Context context, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard) {
        this.sFy = b.sRa.a(orders);
        if (orders == null || orders.sNX == null || orders.sNX.sDr == null || orders.sNX.sDr.size() <= 0 || this.sFy == null) {
            this.sVt.setVisibility(8);
            return;
        }
        if (favorPayInfo == null) {
            this.sEQ = this.sFy.Nl(orders.sNX.sDq);
        } else {
            this.sEQ = favorPayInfo;
        }
        this.sVt.setVisibility(0);
        if (this.sVx != null) {
            this.sVx.setTag(this.sEQ);
        }
        this.sVI = bankcard;
        this.sVC.setOnClickListener(new 6(this, context, orders));
        Assert.assertNotNull(this.sFy);
        this.sVz.setVisibility(8);
    }

    public final void bMN() {
        if (this.sVn != null) {
            this.sVF = null;
            this.sVn.setOnClickListener(new 7(this));
        }
    }

    public void bMO() {
        jQ(false);
        if (this.sVF != null) {
            this.sVF.onClick(this, 0);
        }
        dismiss();
        if (this.sVv != null) {
            this.sVv.a(this.sVu.getText(), this.sEQ, this.sVG);
        }
        if (this.sVS < 0) {
            x.e("MicroMsg.WalletPwdDialog", "hy: not set update mode time yet. abandon");
        } else if (this.sVN == 0) {
            g.pQN.a(686, 0, 1, false);
            g.pQN.a(686, 1, bh.bA(this.sVS), false);
        } else if (this.sVN == 1) {
            g.pQN.a(686, 2, 1, false);
            g.pQN.a(686, 3, bh.bA(this.sVS), false);
        }
    }

    public final void a(OnCancelListener onCancelListener) {
        if (this.sVo != null) {
            this.Gj = onCancelListener;
            this.sVo.setVisibility(0);
            this.sVo.setOnClickListener(new 8(this, onCancelListener));
        }
    }

    public final void jP(boolean z) {
        if (z) {
            this.sVx.setVisibility(0);
        } else {
            this.sVx.setVisibility(8);
        }
    }

    private void am(LinkedList<String> linkedList) {
        if (this.sVr == null) {
            return;
        }
        if (linkedList == null || linkedList.size() <= 0) {
            this.sVr.setVisibility(8);
            return;
        }
        this.sVr.an(linkedList);
        this.sVr.setVisibility(0);
    }

    public final void Nt(String str) {
        if (bh.ov(str)) {
            this.sVB.setVisibility(8);
            return;
        }
        this.sVB.setText(str);
        this.sVB.setVisibility(0);
    }

    public final void bmK() {
        if (this.sVu != null) {
            this.sVu.bmK();
        }
    }

    public static m a(Context context, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, PayInfo payInfo, c cVar, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        return a(context, true, orders, favorPayInfo, bankcard, payInfo, null, cVar, onClickListener, onCancelListener);
    }

    public static m a(Context context, boolean z, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, PayInfo payInfo, String str, c cVar, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        if (orders == null || orders.sNW == null || orders.sNW.size() <= 0) {
            return null;
        }
        String str2;
        String aM;
        String str3;
        String str4;
        List bMo;
        String str5;
        boolean z2;
        String str6;
        a a = b.sRa.a(orders);
        String str7 = "MicroMsg.WalletPwdDialog";
        String str8 = "showAlert with favInfo %s bindSerial %s  bankcardType %s";
        Object[] objArr = new Object[3];
        objArr[0] = favorPayInfo == null ? "" : favorPayInfo.toString();
        if (bankcard == null) {
            str2 = "";
        } else {
            str2 = bankcard.field_bindSerial;
        }
        objArr[1] = str2;
        if (bankcard == null) {
            str2 = "";
        } else {
            str2 = bankcard.field_bankcardType;
        }
        objArr[2] = str2;
        x.i(str7, str8, objArr);
        if (a != null) {
            if (favorPayInfo != null && bankcard != null) {
                boolean z3;
                if (bankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                x.i("MicroMsg.WalletPwdDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[]{favorPayInfo.sMT, Boolean.valueOf(z3)});
                aM = a.aM(favorPayInfo.sMT, z3);
                x.i("MicroMsg.WalletPwdDialog", "nonBankSelectedFaovrCompId %s", new Object[]{aM});
                Map hashMap = new HashMap();
                if (a.sQU.sDs == null || a.sQU.sDs.sDC == null) {
                    x.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
                } else {
                    double d;
                    List list = a.sQU.sDs.sDC;
                    if (a.sQW.containsKey(aM)) {
                        d = ((h) a.sQW.get(aM)).sDF;
                    } else {
                        d = 0.0d;
                    }
                    for (int i = 0; i < list.size(); i++) {
                        h hVar = (h) list.get(i);
                        str7 = null;
                        if (aM.equals("0") && !hVar.equals("0")) {
                            str7 = hVar.sDE;
                        } else if (hVar.sDE.startsWith(aM) && !aM.equals(hVar.sDE)) {
                            str7 = hVar.sDE.replace(aM + "-", "");
                        }
                        String[] Nj = a.Nj(str7);
                        if (Nj != null && Nj.length > 0) {
                            com.tencent.mm.plugin.wallet.a.q qVar = (com.tencent.mm.plugin.wallet.a.q) a.sQV.get(Nj[0]);
                            if (qVar != null) {
                                Object obj;
                                if (qVar.sEh != 0) {
                                    obj = 1;
                                } else {
                                    obj = null;
                                }
                                if (obj != null && qVar.sEk.size() > 0) {
                                    Iterator it = qVar.sEk.iterator();
                                    while (it.hasNext()) {
                                        String a2 = n.a((com.tencent.mm.bq.b) it.next());
                                        a.a aVar = (a.a) hashMap.get(a2);
                                        if (aVar == null || hVar.sDF > aVar.sQX.sDF) {
                                            aVar = new a.a();
                                            aVar.sQX = hVar;
                                            aVar.pax = qVar.pax;
                                            aVar.sQY = hVar.sDF - d;
                                            aVar.sQZ = qVar.sEi;
                                            hashMap.put(a2, aVar);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                a.a aVar2 = (a.a) hashMap.get(bankcard.field_bindSerial);
                a.a aVar3 = (a.a) a.aL(aM, true).get(bankcard.field_bankcardType);
                h aK = a.aK(aM, z3);
                str3 = "MicroMsg.WalletPwdDialog";
                str4 = "defaultComposeInfo %s wrapperSerial %s wrapper %s";
                Object[] objArr2 = new Object[3];
                objArr2[0] = aK == null ? "" : aK.sDE;
                objArr2[1] = aVar2 == null ? "" : aVar2.toString();
                objArr2[2] = aVar3 == null ? "" : aVar3.toString();
                x.i(str3, str4, objArr2);
                if (aVar2 != null && aVar2.sQX != null && !bh.ov(aVar2.sQX.sDE)) {
                    favorPayInfo.sMT = aVar2.sQX.sDE;
                } else if (aVar3 != null && aVar3.sQX != null && !bh.ov(aVar3.sQX.sDE)) {
                    favorPayInfo.sMT = aVar3.sQX.sDE;
                } else if (aK != null) {
                    favorPayInfo.sMT = aK.sDE;
                } else {
                    favorPayInfo.sMT = aM;
                }
            } else if (orders.sNX != null) {
                favorPayInfo = a.Nl(a.Nm(orders.sNX.sDq));
            }
            bMo = a.bMo();
        } else {
            x.d("MicroMsg.WalletPwdDialog", "getFavorLogicHelper null");
            bMo = null;
        }
        String str9 = "";
        com.tencent.mm.storage.x WM;
        if (payInfo.fCV == 32 || payInfo.fCV == 33) {
            str2 = payInfo.vzx.getString("extinfo_key_5", "");
            str3 = payInfo.vzx.getString("extinfo_key_1", "");
            str8 = context.getString(i.uVt);
            if (!bh.ov(str2)) {
                str8 = str2;
                str9 = str2;
            }
            if (bh.ov(str3)) {
                x.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
            } else {
                com.tencent.mm.kernel.g.Dk();
                WM = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WM(str3);
                if (WM != null) {
                    objArr = new Object[1];
                    StringBuilder append = new StringBuilder().append(e.aaH(WM.AQ()));
                    if (bh.ov(str)) {
                        str2 = "";
                    } else {
                        str2 = "(" + str + ")";
                    }
                    objArr[0] = append.append(str2).toString();
                    str9 = bh.j(str8, objArr);
                } else {
                    x.e("MicroMsg.WalletPwdDialog", "can not found contact for user::" + str3);
                }
            }
        } else if (payInfo.fCV == 31) {
            str8 = payInfo.vzx.getString("extinfo_key_1", "");
            if (bh.ov(str8)) {
                x.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
            } else {
                com.tencent.mm.kernel.g.Dk();
                WM = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WM(str8);
                if (WM != null) {
                    str2 = WM.AP();
                    r6 = i.uVt;
                    objArr = new Object[1];
                    objArr[0] = str2 + (bh.ov(str) ? "" : "(" + str + ")");
                    str9 = context.getString(r6, objArr);
                } else {
                    x.e("MicroMsg.WalletPwdDialog", "can not found contact for user::" + str8);
                }
            }
        } else if (payInfo.fCV == 42) {
            str8 = payInfo.vzx.getString("extinfo_key_1", "");
            if (bh.ov(str8)) {
                x.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
            } else {
                com.tencent.mm.kernel.g.Dk();
                WM = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WM(str8);
                if (WM != null) {
                    str2 = WM.AP();
                    r6 = i.uVp;
                    objArr = new Object[1];
                    objArr[0] = str2 + (bh.ov(str) ? "" : "(" + str + ")");
                    str9 = context.getString(r6, objArr);
                } else {
                    x.e("MicroMsg.WalletPwdDialog", "can not found contact for user::" + str8);
                }
            }
        } else if (payInfo.fCV == 48) {
            str9 = context.getString(i.uMz);
        } else if (payInfo.fCV == 49) {
            if (bh.ov(payInfo.vzx.getString("extinfo_key_1", ""))) {
                x.e("MicroMsg.WalletPwdDialog", "userName is null, scene is %s", new Object[]{Integer.valueOf(payInfo.fCV)});
            } else {
                str9 = context.getString(i.uVt, new Object[]{payInfo.vzx.getString("extinfo_key_1", "")});
            }
        }
        if (!bh.ov(str9) || orders == null || orders.sNW == null) {
            x.w("MicroMsg.WalletPwdDialog", "orders null?:" + (orders == null));
            str5 = str9;
        } else {
            Commodity commodity = (Commodity) orders.sNW.get(0);
            if (commodity != null) {
                str8 = commodity.pao;
                Object obj2 = (payInfo == null || !(payInfo.fCV == 31 || payInfo.fCV == 32 || payInfo.fCV == 33)) ? null : 1;
                if (obj2 != null) {
                    if (!bh.ov(str8)) {
                        str8 = str8 + "\n";
                    }
                    str8 = str8 + commodity.desc;
                }
                if (bh.ov(str8)) {
                    str8 = commodity.desc;
                }
            } else {
                str8 = str9;
            }
            str5 = str8;
        }
        str2 = null;
        boolean z4 = false;
        if (a == null || favorPayInfo == null) {
            str7 = null;
            z2 = false;
            str8 = null;
            str9 = null;
            str3 = null;
            str4 = null;
        } else {
            h Ni = a.Ni(favorPayInfo.sMT);
            if (Ni != null && Ni.sDx > 0.0d) {
                z4 = true;
                str4 = e.d(orders.pNX, orders.paz);
                str7 = e.d(Ni.sDw, orders.paz);
                str3 = Ni.sDz;
                if (sVU.containsKey(payInfo.fuH)) {
                    str9 = str3;
                    str3 = str4;
                    str4 = str7;
                    str7 = null;
                } else {
                    g.pQN.h(14530, new Object[]{Integer.valueOf(3)});
                    str9 = str3;
                    str3 = str4;
                    str4 = str7;
                    str7 = null;
                }
            } else if (bMo == null || bMo.size() <= 0) {
                str9 = null;
                str3 = null;
                str4 = e.d(orders.pNX, orders.paz);
                str7 = null;
            } else {
                z4 = true;
                str9 = null;
                str3 = null;
                str4 = e.d(Ni.sDw, orders.paz);
                str7 = context.getString(i.uVr);
            }
            if (!(Ni == null || Ni.sDy == 0)) {
                str2 = Ni.sDA;
                if (!bh.ov(str9)) {
                    str2 = "," + str2;
                }
            }
            boolean z5;
            if (bh.ov(str9) && bh.ov(str2)) {
                z5 = z4;
                str8 = str7;
                str7 = str2;
                z2 = z5;
            } else {
                if (bh.ov(str7)) {
                    str7 = null;
                } else {
                    str7 = "," + str7;
                }
                z5 = z4;
                str8 = str7;
                str7 = str2;
                z2 = z5;
            }
        }
        if (orders.pKL > 0.0d) {
            Resources resources = context.getResources();
            int i2 = i.uQL;
            Object[] objArr3 = new Object[1];
            objArr3[0] = e.d(orders.pKL, orders.paz);
            aM = resources.getString(i2, objArr3);
        } else {
            aM = null;
        }
        if (bankcard == null) {
            str6 = "";
        } else {
            str6 = bankcard.field_desc;
        }
        Dialog mVar = new m(context);
        mVar.a(context, orders, favorPayInfo, bankcard);
        mVar.jP(z);
        mVar.sVH = z;
        mVar.bMN();
        mVar.a(new b(onCancelListener, (byte) 0));
        mVar.setOnCancelListener(new b(onCancelListener, (byte) 0));
        mVar.setCancelable(true);
        mVar.Np(str5);
        mVar.Nq(str4);
        mVar.Ns(str3);
        mVar.a(str6, new 9(payInfo, onClickListener, mVar), z2);
        mVar.g(bankcard);
        z2 = orders.sNU == 1;
        mVar.pCn = payInfo;
        mVar.sVO = z2;
        if (!q.Gf()) {
            mVar.bMK();
        }
        mVar.eC(str9, str8);
        str2 = orders.paz;
        mVar.Nt(str7);
        mVar.Nr(aM);
        mVar.sVv = cVar;
        mVar.am(a(bankcard, orders));
        if (a(bankcard, orders, payInfo.fuH)) {
            mVar.jO(true);
            g.pQN.h(14530, new Object[]{Integer.valueOf(1)});
        } else {
            mVar.jO(false);
        }
        mVar.show();
        com.tencent.mm.ui.base.h.a(context, mVar);
        return mVar;
    }

    private static LinkedList<String> a(Bankcard bankcard, Orders orders) {
        LinkedList<String> linkedList = new LinkedList();
        if (!(orders == null || orders.sNX == null || orders.sNX.sDB == null)) {
            Iterator it = orders.sNX.sDB.sDg.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.wallet.a.b bVar = (com.tencent.mm.plugin.wallet.a.b) it.next();
                if (bVar.oZA.equals(bankcard.field_bindSerial)) {
                    it = bVar.sDi.iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.plugin.wallet.a.c cVar = (com.tencent.mm.plugin.wallet.a.c) it.next();
                        if (cVar.sDj != 0) {
                            linkedList.add(cVar.pKc);
                        }
                    }
                    return linkedList;
                }
            }
        }
        return linkedList;
    }

    private static boolean a(Bankcard bankcard, Orders orders, String str) {
        if (sVU.containsKey(str) || orders.sNX == null || orders.sNX.sDB == null) {
            return false;
        }
        boolean z;
        if (orders.sNX.sDB.sDg.size() > 0) {
            Iterator it = orders.sNX.sDB.sDg.iterator();
            z = false;
            while (it.hasNext()) {
                boolean z2;
                com.tencent.mm.plugin.wallet.a.b bVar = (com.tencent.mm.plugin.wallet.a.b) it.next();
                if (bVar.oZA == null || !bVar.oZA.equals(bankcard.field_bindSerial)) {
                    z2 = z;
                } else {
                    z2 = true;
                }
                z = z2;
            }
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        if (orders.sNX.sDB.sDg.size() > 0) {
            return true;
        }
        if (orders.sNX.sDB.sDh == null || orders.sNX.sDB.sDh.sDL.size() <= 0) {
            return false;
        }
        return true;
    }

    public static m a(Context context, String str, String str2, c cVar, OnCancelListener onCancelListener, a aVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        return a(context, str, str2, "", cVar, onCancelListener, aVar);
    }

    public static m a(Context context, String str, String str2, String str3, c cVar, OnCancelListener onCancelListener, a aVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        m mVar = new m(context);
        mVar.bMN();
        mVar.a(onCancelListener);
        mVar.setOnCancelListener(onCancelListener);
        mVar.setCancelable(true);
        mVar.Np(str);
        mVar.Nq(str2);
        mVar.jP(false);
        mVar.sVH = false;
        mVar.sVE = aVar;
        mVar.Nr(str3);
        mVar.sVv = cVar;
        mVar.show();
        com.tencent.mm.ui.base.h.a(context, mVar);
        return mVar;
    }

    public static m a(Context context, String str, double d, String str2, Bankcard bankcard, c cVar, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        boolean z = true;
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        Dialog mVar = new m(context);
        mVar.bMN();
        mVar.a(onCancelListener);
        mVar.setOnCancelListener(onCancelListener);
        mVar.setCancelable(true);
        mVar.Np(str);
        mVar.Nq(e.d(d, str2));
        mVar.sVH = true;
        String str3 = bankcard == null ? "" : bankcard.field_desc;
        mVar.g(bankcard);
        if (TextUtils.isEmpty(str3)) {
            z = false;
        }
        mVar.jP(z);
        if (bankcard != null) {
            mVar.a(str3, onClickListener, false);
        }
        mVar.sVv = cVar;
        mVar.show();
        com.tencent.mm.ui.base.h.a(context, mVar);
        return mVar;
    }

    public final void bMp() {
        this.isPaused = false;
        if (!q.Gf()) {
        }
    }

    public final void bMq() {
        this.isPaused = true;
        if (!q.Gf() && this.sVN == 1) {
            bML();
        }
    }

    private static void jQ(boolean z) {
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dj().CU().a(w.a.xoH, Boolean.valueOf(z));
    }

    private static boolean bMP() {
        com.tencent.mm.kernel.g.Dk();
        Object obj = com.tencent.mm.kernel.g.Dj().CU().get(w.a.xoH, Boolean.valueOf(false));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }
}
