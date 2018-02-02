package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.f2f.a.b;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.protocal.c.bbg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.s;
import java.io.IOException;

@a(3)
public class LuckyMoneyF2FReceiveUI extends LuckyMoneyBaseUI {
    private DisplayMetrics icn;
    private String lOX;
    private String nZa;
    private String nZc;
    private int nZd;
    private String nZi;
    private ImageView nZx;
    private TextView nZy;
    private View oaC;
    private TextView oaD;
    private ImageView oaE;
    private ValueAnimator oaF;
    private ValueAnimator oaG;
    private Intent oaH;
    private boolean oaI = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oaC = findViewById(f.upk);
        this.nZx = (ImageView) findViewById(f.upm);
        this.nZy = (TextView) findViewById(f.upn);
        this.oaD = (TextView) findViewById(f.upo);
        this.oaE = (ImageView) findViewById(f.ups);
        this.oaE.setOnClickListener(new 1(this));
        this.mController.contentView.setVisibility(8);
        this.lOX = getIntent().getStringExtra("key_share_url");
        i.i(this, 6);
        b(new b(this.lOX), true);
        this.icn = getResources().getDisplayMetrics();
        this.oaF = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(300);
        this.oaG = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
        this.oaG.setStartDelay(1000);
        this.oaF.addUpdateListener(new 2(this));
        this.oaF.addListener(new 3(this));
        this.oaG.addListener(new AnimatorListener(this) {
            final /* synthetic */ LuckyMoneyF2FReceiveUI oaJ;

            {
                this.oaJ = r1;
            }

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                x.i("LuckyMoneyF2FReceiveUI", "packet exit animator end");
                if (this.oaJ.oaH != null) {
                    this.oaJ.a(LuckyMoneyDetailUI.class, this.oaJ.oaH);
                }
                this.oaJ.setResult(-1, null);
                this.oaJ.finish();
                if (this.oaJ.oaH != null) {
                    this.oaJ.overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.bqk, com.tencent.mm.plugin.wxpay.a.a.bql);
                }
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
    }

    protected final int getLayoutId() {
        return a$g.uCt;
    }

    protected void onResume() {
        super.onResume();
        ji(1997);
        if (this.oaI) {
            finish();
        }
    }

    protected void onStop() {
        super.onStop();
        jj(1997);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("LuckyMoneyF2FReceiveUI", "errType: %d,errCode: %d,errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!(kVar instanceof b)) {
            return true;
        }
        b bVar = (b) kVar;
        int i3 = bVar.fLD;
        int i4 = bVar.nZb;
        this.nZd = bVar.nZd;
        int i5 = bVar.nZf;
        String str2 = bVar.nZg;
        String str3 = bVar.nZh;
        x.i("LuckyMoneyF2FReceiveUI", "hbStatus: %d, recvStatus:%d, errorType:%d", new Object[]{Integer.valueOf(bVar.fLD), Integer.valueOf(bVar.nZb), Integer.valueOf(bVar.fqv)});
        bbg com_tencent_mm_protocal_c_bbg;
        if (i4 == 2) {
            if (i3 == 5) {
                h.a(this, getString(a$i.uJU), "", new 5(this));
            } else {
                this.nZa = bVar.nZa;
                this.nZc = bVar.nZc;
                this.nZi = bVar.nZi;
                this.oaH = new Intent();
                if (!(bh.ov(this.nZc) || s.gE(this.nZc))) {
                    com.tencent.mm.ad.h hVar = new com.tencent.mm.ad.h();
                    hVar.username = this.nZc;
                    n.JQ().a(hVar);
                }
                com.tencent.mm.plugin.luckymoney.b.n.a(this.nZx, null, this.nZc);
                e eVar = new e();
                eVar.fLR = (long) this.nZd;
                eVar.nZa = this.nZa;
                eVar.fLD = i3;
                eVar.fLE = i4;
                eVar.nZh = str3;
                eVar.nZf = i5;
                eVar.ocj = this.nZc;
                eVar.nZg = str2;
                eVar.obO = com.tencent.mm.plugin.luckymoney.b.n.gt(this.nZc);
                eVar.nZi = this.nZi;
                eVar.obK = 2;
                x.i("LuckyMoneyF2FReceiveUI", "is most lucky %d", new Object[]{Integer.valueOf(bVar.nZj)});
                if (bVar.nZj > 0) {
                    eVar.obM = getString(a$i.uKp);
                }
                eVar.obP = com.tencent.mm.plugin.luckymoney.b.n.DV(this.nZc);
                try {
                    this.oaH.putExtra("key_detail_info", eVar.toByteArray());
                    com_tencent_mm_protocal_c_bbg = bVar.nZe;
                    if (com_tencent_mm_protocal_c_bbg != null) {
                        Parcelable realnameGuideHelper = new RealnameGuideHelper();
                        realnameGuideHelper.a(String.valueOf(com_tencent_mm_protocal_c_bbg.vDQ), com_tencent_mm_protocal_c_bbg.odv, com_tencent_mm_protocal_c_bbg.odw, com_tencent_mm_protocal_c_bbg.odx, com_tencent_mm_protocal_c_bbg.ody, kVar.getType());
                        this.oaH.putExtra("key_realname_guide_helper", realnameGuideHelper);
                    }
                } catch (IOException e) {
                    x.e("LuckyMoneyF2FReceiveUI", "lucky detail toBytes error: " + e.getMessage());
                }
                if (!bh.G(new String[]{this.nZa, this.nZc})) {
                    com.tencent.mm.plugin.luckymoney.b.n.a(this, this.nZy, com.tencent.mm.plugin.luckymoney.b.n.gt(this.nZc));
                    com.tencent.mm.plugin.luckymoney.b.n.a(this, this.oaD, this.nZi);
                    this.oaF.start();
                    this.mController.contentView.setVisibility(0);
                }
            }
            return true;
        }
        if (bVar.nZe != null) {
            x.i("LuckyMoneyF2FReceiveUI", "need real name verify");
            com_tencent_mm_protocal_c_bbg = bVar.nZe;
            RealnameGuideHelper realnameGuideHelper2 = new RealnameGuideHelper();
            realnameGuideHelper2.a(String.valueOf(com_tencent_mm_protocal_c_bbg.vDQ), com_tencent_mm_protocal_c_bbg.odv, com_tencent_mm_protocal_c_bbg.odw, com_tencent_mm_protocal_c_bbg.odx, com_tencent_mm_protocal_c_bbg.ody, kVar.getType());
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".f2f.ui.LuckyMoneyF2FReceiveUI");
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            OnClickListener 6 = new 6(this);
            7 7 = new 7(this);
            if (realnameGuideHelper2.a(this, bundle, 6, false)) {
                this.oaI = true;
                return true;
            }
        }
        if (bh.ov(str)) {
            str = getString(a$i.uJY);
        }
        h.a(this, str, "", new 8(this));
        return true;
    }
}
