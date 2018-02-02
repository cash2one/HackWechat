package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.luckymoney.b.af;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.v;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.z.q;
import java.io.IOException;

@a(3)
public class LuckyMoneyReceiveUI extends LuckyMoneyBaseUI {
    private long kCY = 0;
    private TextView lmo;
    private int maxSize = 0;
    private String ndd;
    private ImageView oaE;
    af odI;
    private String ogE;
    private String ogG;
    private TextView ogU;
    Button ogX;
    private View ogZ;
    private ImageView ogs;
    private TextView ogu;
    private View ojV;
    private ImageView ojW;
    private TextView ojX;
    private y ojY = null;
    private int textSize = 0;
    private r tipDialog = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ogG = getIntent().getStringExtra("key_native_url");
        x.i("MicroMsg.LuckyMoneyReceiveUI", "nativeUrl= " + bh.ou(this.ogG));
        initView();
        Uri parse = Uri.parse(bh.ou(this.ogG));
        try {
            this.ogE = parse.getQueryParameter("sendid");
        } catch (Exception e) {
        }
        this.ojY = o.bLn().Nf(this.ogG);
        if (this.ojY != null && this.ojY.field_receiveAmount > 0 && bh.bz(this.ojY.field_receiveTime) < 86400000) {
            x.i("MicroMsg.LuckyMoneyReceiveUI", "use cache this item %s %s", new Object[]{Long.valueOf(this.ojY.field_receiveTime), bh.ou(this.ogG)});
            Intent intent = new Intent();
            intent.setClass(this.mController.xIM, LuckyMoneyDetailUI.class);
            intent.putExtra("key_native_url", this.ojY.field_mNativeUrl);
            intent.putExtra("key_sendid", this.ogE);
            startActivity(intent);
            finish();
        } else if (bh.ov(this.ogE)) {
            finish();
            x.w("MicroMsg.LuckyMoneyReceiveUI", "sendid null & finish");
        } else {
            int i = bh.getInt(parse.getQueryParameter("channelid"), 1);
            this.ndd = parse.getQueryParameter("sendusername");
            b(new af(i, this.ogE, this.ogG, getIntent().getIntExtra("key_way", 0), "v1.0"), false);
            if (this.tipDialog != null) {
                this.tipDialog.show();
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
    }

    protected void onResume() {
        super.onResume();
        this.kCY = bh.Wo();
    }

    protected void onPause() {
        super.onPause();
        d.f("LuckyMoneyReceiveUI", this.kCY, bh.Wo());
    }

    protected final void initView() {
        this.ogZ = findViewById(f.upk);
        this.ogs = (ImageView) findViewById(f.upm);
        this.ogU = (TextView) findViewById(f.upn);
        this.lmo = (TextView) findViewById(f.upo);
        this.ogu = (TextView) findViewById(f.upp);
        this.ogX = (Button) findViewById(f.upt);
        this.ojX = (TextView) findViewById(f.upq);
        this.ojV = findViewById(f.upr);
        this.ojW = (ImageView) findViewById(f.umF);
        this.oaE = (ImageView) findViewById(f.ups);
        this.oaE.setOnClickListener(new 1(this));
        this.maxSize = (int) (((float) com.tencent.mm.bv.a.ab(this.mController.xIM, com.tencent.mm.plugin.wxpay.a.d.uca)) * 1.375f);
        this.textSize = com.tencent.mm.bv.a.aa(this.mController.xIM, com.tencent.mm.plugin.wxpay.a.d.uca);
        this.textSize = this.textSize > this.maxSize ? this.maxSize : this.textSize;
        this.ogu.setTextSize(0, (float) this.textSize);
        this.mController.contentView.setVisibility(8);
        this.tipDialog = h.a(this.mController.xIM, getString(i.ctB), true, new 2(this));
        if (this.ogX != null) {
            com.tencent.mm.plugin.normsg.a.d.oSu.tY(this.ogX.getId());
            String d = w.d(ac.getContext().getSharedPreferences(ac.cfs(), 0));
            if (d == null || d.length() <= 0 || !(d.equals("zh_CN") || d.equals("zh_TW") || d.equals("zh_HK"))) {
                this.ogX.setBackgroundResource(a$e.ude);
                this.ogX.setText(i.uKC);
            }
        }
    }

    protected final int getLayoutId() {
        return g.uCF;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        LayoutParams layoutParams;
        if (!(kVar instanceof af)) {
            if (kVar instanceof com.tencent.mm.plugin.luckymoney.b.ac) {
                n.c(this.ogX);
                if (i == 0 && i2 == 0) {
                    com.tencent.mm.plugin.luckymoney.b.ac acVar = (com.tencent.mm.plugin.luckymoney.b.ac) kVar;
                    e eVar = acVar.ocQ;
                    if (eVar.fLE == 2) {
                        Intent intent = new Intent();
                        intent.setClass(this.mController.xIM, LuckyMoneyDetailUI.class);
                        try {
                            intent.putExtra("key_detail_info", acVar.ocQ.toByteArray());
                            intent.putExtra("key_jump_from", 2);
                        } catch (IOException e) {
                            x.w("MicroMsg.LuckyMoneyReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e.getLocalizedMessage());
                        }
                        intent.putExtra("key_native_url", acVar.fLC);
                        intent.putExtra("key_sendid", acVar.nZa);
                        if (com.tencent.mm.k.g.zY().getInt("PlayCoinSound", 0) > 0) {
                            intent.putExtra("play_sound", true);
                        }
                        if (acVar.ocR != null) {
                            intent.putExtra("key_realname_guide_helper", acVar.ocR);
                        }
                        startActivity(intent);
                        y yVar = new y();
                        yVar.field_mNativeUrl = this.ogG;
                        yVar.field_hbType = eVar.obK;
                        yVar.field_receiveAmount = eVar.fLR;
                        yVar.field_receiveTime = System.currentTimeMillis();
                        yVar.field_hbStatus = eVar.fLD;
                        yVar.field_receiveStatus = eVar.fLE;
                        if (yVar.field_receiveAmount > 0) {
                            o.bLn().a(yVar);
                        }
                        finish();
                    } else {
                        this.ogX.setBackgroundResource(a$e.udd);
                        this.ogX.setText(i.uKz);
                        this.ogX.setOnClickListener(null);
                        this.ogX.setVisibility(8);
                        if (bh.ov(eVar.nZi)) {
                            this.lmo.setVisibility(8);
                        } else {
                            this.lmo.setText(eVar.nZi);
                            this.lmo.setVisibility(0);
                        }
                        this.ogu.setText(eVar.obL);
                        layoutParams = (LayoutParams) this.ojV.getLayoutParams();
                        layoutParams.bottomMargin = b.b(this.mController.xIM, 30.0f);
                        this.ojV.setLayoutParams(layoutParams);
                        if (q.FS().equals(this.ndd) || eVar.obK == 1) {
                            this.ojV.setVisibility(0);
                            this.ojV.setOnClickListener(new 6(this, acVar));
                            this.ojW.setVisibility(8);
                        } else {
                            this.ojV.setVisibility(8);
                            this.ojW.setVisibility(0);
                        }
                    }
                    return true;
                } else if (i2 == 416) {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.hide();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyReceiveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                    this.ogX.setBackgroundResource(a$e.ucE);
                    return n.a(this, i2, kVar, bundle, false, new 7(this), null, 1003);
                }
            } else if (kVar instanceof v) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                if (i == 0 && i2 == 0) {
                    v vVar = (v) kVar;
                    Intent intent2 = new Intent();
                    intent2.setClass(this.mController.xIM, LuckyMoneyDetailUI.class);
                    try {
                        intent2.putExtra("key_detail_info", vVar.ocQ.toByteArray());
                        intent2.putExtra("key_jump_from", 2);
                    } catch (IOException e2) {
                        x.w("MicroMsg.LuckyMoneyReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e2.getLocalizedMessage());
                    }
                    intent2.putExtra("key_native_url", this.ogG);
                    intent2.putExtra("key_sendid", this.ogE);
                    startActivity(intent2);
                    finish();
                    return true;
                }
                h.bu(this, str);
                finish();
                return true;
            }
            return false;
        } else if (i == 0 && i2 == 0) {
            this.odI = (af) kVar;
            com.tencent.mm.plugin.report.service.g.pQN.h(11701, new Object[]{Integer.valueOf(5), Integer.valueOf(sj(this.odI.obK)), Integer.valueOf(aXP()), Integer.valueOf(0), Integer.valueOf(1)});
            y yVar2 = new y();
            yVar2.field_mNativeUrl = this.ogG;
            yVar2.field_hbType = this.odI.obK;
            yVar2.field_hbStatus = this.odI.fLD;
            yVar2.field_receiveStatus = this.odI.fLE;
            o.bLn().a(yVar2);
            if (this.odI.fLE == 2) {
                b(new v(this.ogE, 11, 0, this.ogG, "v1.0"), false);
            } else {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                n.a(this.ogs, this.odI.obP, this.odI.ocj);
                n.a(this.mController.xIM, this.ogU, this.odI.odA);
                boolean z = false;
                if (this.odI.fLE == 1 || this.odI.fLD == 4 || this.odI.fLD == 5 || this.odI.fLD == 1) {
                    this.ogX.setBackgroundResource(a$e.udd);
                    this.ogX.setText(i.uKz);
                    this.ogX.setOnClickListener(null);
                    this.ogX.setVisibility(8);
                    if (bh.ov(this.odI.nZi)) {
                        this.lmo.setVisibility(8);
                    } else {
                        this.lmo.setText(this.odI.nZi);
                        this.lmo.setVisibility(0);
                    }
                    this.ogu.setText(this.odI.obL);
                    layoutParams = (LayoutParams) this.ojV.getLayoutParams();
                    layoutParams.bottomMargin = b.b(this.mController.xIM, 30.0f);
                    this.ojV.setLayoutParams(layoutParams);
                    z = true;
                } else {
                    if (!bh.ov(this.odI.obL)) {
                        this.lmo.setText(this.odI.obL);
                        this.lmo.setVisibility(0);
                    }
                    if (!bh.ov(this.odI.obN)) {
                        n.a(this.mController.xIM, this.ogu, this.odI.obN);
                        this.ogu.setVisibility(0);
                    }
                    this.ogX.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ LuckyMoneyReceiveUI ojZ;

                        {
                            this.ojZ = r1;
                        }

                        public final void onClick(View view) {
                            com.tencent.mm.plugin.report.service.g.pQN.h(11701, new Object[]{Integer.valueOf(5), Integer.valueOf(LuckyMoneyReceiveUI.sj(this.ojZ.odI.obK)), Integer.valueOf(this.ojZ.aXP()), Integer.valueOf(0), Integer.valueOf(2)});
                            LuckyMoneyReceiveUI luckyMoneyReceiveUI = this.ojZ;
                            luckyMoneyReceiveUI.b(new com.tencent.mm.plugin.luckymoney.b.ac(luckyMoneyReceiveUI.odI.msgType, luckyMoneyReceiveUI.odI.fdS, luckyMoneyReceiveUI.odI.nZa, luckyMoneyReceiveUI.odI.fLC, n.aXg(), q.FU(), luckyMoneyReceiveUI.getIntent().getStringExtra("key_username"), "v1.0", luckyMoneyReceiveUI.odI.odE), false);
                            n.b(luckyMoneyReceiveUI.ogX);
                        }
                    });
                }
                if (q.FS().equals(this.ndd) || (this.odI.obK == 1 && z)) {
                    if (this.odI.obK == 1) {
                        this.ojX.setText(i.uJP);
                    }
                    this.ojV.setVisibility(0);
                    this.ojV.setOnClickListener(new 4(this, z));
                    this.ojW.setVisibility(8);
                } else {
                    this.ojV.setVisibility(8);
                    this.ojW.setVisibility(0);
                }
                n.a(this.ogZ, null);
                this.mController.contentView.setVisibility(0);
                if (this.odI.fLD == 5 && yVar2.field_receiveAmount > 0) {
                    this.ojW.setVisibility(8);
                    this.ojV.setVisibility(0);
                    this.lmo.setVisibility(0);
                    this.lmo.setText(i.uKN);
                    this.ogu.setVisibility(8);
                    findViewById(f.upl).setVisibility(0);
                    ((WalletTextView) findViewById(f.umX)).setText(com.tencent.mm.wallet_core.ui.e.t(((double) yVar2.field_receiveAmount) / 100.0d));
                    this.ojV.setOnClickListener(new 5(this));
                }
            }
            return true;
        } else {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.hide();
            }
            return false;
        }
    }

    private int aXP() {
        if (q.FS().equals(this.ndd)) {
            return 1;
        }
        return 0;
    }

    private static int sj(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 0) {
            return 2;
        }
        return 0;
    }
}
