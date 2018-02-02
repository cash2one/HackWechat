package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.luckymoney.b.ag;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.b.s;
import com.tencent.mm.plugin.luckymoney.b.t;
import com.tencent.mm.plugin.luckymoney.b.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;

@a(3)
public class LuckyMoneyBusiReceiveUI extends LuckyMoneyBaseUI {
    private ImageView oaE;
    private String ogE = null;
    private String ogG = null;
    private int ogI = 0;
    private TextView ogU;
    private TextView ogV;
    private TextView ogW;
    private Button ogX;
    private View ogY;
    private View ogZ;
    private ImageView ogs;
    private TextView ogw;
    private ImageView oha;
    private TextView ohb;
    private View ohc;
    private TextView ohd;
    private Button ohe;
    private TextView ohf;
    private CheckBox ohg;
    private int ohh;
    private String ohi = null;
    private int ohj = 0;
    private t ohk;
    private RealnameGuideHelper ohl;
    private r tipDialog = null;

    static /* synthetic */ void i(LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI) {
        luckyMoneyBusiReceiveUI.b(new s(luckyMoneyBusiReceiveUI.ohk.nZa, luckyMoneyBusiReceiveUI.ohk.fLC, luckyMoneyBusiReceiveUI.ohk.ocS, luckyMoneyBusiReceiveUI.getIntent().getStringExtra("packageExt"), luckyMoneyBusiReceiveUI.getIntent().getStringExtra("key_username")), false);
        n.a(luckyMoneyBusiReceiveUI.ogX);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ogG = getIntent().getStringExtra("key_native_url");
        this.ohh = getIntent().getIntExtra("key_way", 5);
        this.ogI = getIntent().getIntExtra("key_static_from_scene", 0);
        x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "nativeurl=" + bh.ou(this.ogG) + ", mWay=" + this.ohh);
        init();
        g.pQN.h(11701, Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        initView();
        ji(980);
    }

    private void init() {
        this.tipDialog = h.a(this.mController.xIM, getString(i.ctB), true, new OnCancelListener(this) {
            final /* synthetic */ LuckyMoneyBusiReceiveUI ohm;

            {
                this.ohm = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.ohm.tipDialog != null && this.ohm.tipDialog.isShowing()) {
                    this.ohm.tipDialog.dismiss();
                }
                this.ohm.ogp.aXc();
                if (this.ohm.mController.contentView.getVisibility() == 8 || this.ohm.mController.contentView.getVisibility() == 4) {
                    x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "user cancel & finish");
                    this.ohm.finish();
                }
            }
        });
        if (this.ohh == 3) {
            b(new com.tencent.mm.plugin.luckymoney.b.r(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL)), false);
        } else if (this.ohh == 4) {
            b(new com.tencent.mm.plugin.luckymoney.b.r(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("key_wxapi_sign"), getIntent().getStringExtra("key_wxapi_package_name")), false);
        } else {
            try {
                this.ogE = Uri.parse(bh.ou(this.ogG)).getQueryParameter("sendid");
            } catch (Exception e) {
            }
            if (bh.ov(this.ogE)) {
                finish();
                x.w("MicroMsg.LuckyMoneyBusiReceiveUI", "sendid null & finish");
            } else {
                b(new t(this.ogE, this.ogG, this.ohh, getIntent().getStringExtra("packageExt")), false);
            }
        }
        aq(0, "");
    }

    protected void onNewIntent(Intent intent) {
        if (intent != null && intent.hasExtra("key_is_realname_verify_process")) {
            if (intent.getIntExtra("realname_verify_process_ret", 0) == -1) {
                x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process succ");
                init();
                return;
            }
            x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process cancel");
            aq(-1, "");
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        jj(980);
    }

    protected final void initView() {
        this.ogZ = findViewById(a$f.umI);
        this.ogs = (ImageView) findViewById(a$f.umM);
        this.ogU = (TextView) findViewById(a$f.umN);
        this.ogW = (TextView) findViewById(a$f.umJ);
        this.ogV = (TextView) findViewById(a$f.umQ);
        this.ogX = (Button) findViewById(a$f.umK);
        this.oaE = (ImageView) findViewById(a$f.umT);
        this.ogY = findViewById(a$f.umH);
        this.ogw = (TextView) findViewById(a$f.umG);
        this.oha = (ImageView) findViewById(a$f.umU);
        this.ohb = (TextView) findViewById(a$f.umS);
        this.ohc = findViewById(a$f.umO);
        this.ohd = (TextView) findViewById(a$f.umP);
        this.ohe = (Button) findViewById(a$f.umV);
        this.ohf = (TextView) findViewById(a$f.umL);
        this.ohg = (CheckBox) findViewById(a$f.umW);
        this.oaE.setOnClickListener(new 3(this));
        uD(8);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof t) {
            if (i == 0 && i2 == 0) {
                this.ohk = (t) kVar;
                this.ogE = this.ohk.nZa;
                this.ohj = this.ohk.obK;
                g.pQN.h(13050, Integer.valueOf(this.ogI), Integer.valueOf(1), this.ohk.ocO);
                if (this.ohk.fLE == 2) {
                    aq(-1, "");
                    b(new v(this.ogE, 11, 0, this.ogG, "v1.0"), false);
                } else {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.hide();
                    }
                    n.a(this.ogs, this.ohk.ocT, true);
                    n.a(this.mController.xIM, this.ogU, this.ohk.ocI);
                    n.h(this.oha, this.ohk.oce);
                    if (this.ohk.fLE == 1 || this.ohk.fLD == 4 || this.ohk.fLD == 5 || this.ohk.fLD == 1) {
                        g.pQN.h(11701, Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
                        this.ogV.setVisibility(4);
                        this.ogW.setText(this.ohk.obL);
                        this.ogX.setVisibility(8);
                        if (this.ohj == 1) {
                            this.ohb.setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ LuckyMoneyBusiReceiveUI ohm;

                                {
                                    this.ohm = r1;
                                }

                                public final void onClick(View view) {
                                    g.pQN.h(11701, Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4));
                                    Intent intent = new Intent();
                                    intent.setClass(this.ohm.mController.xIM, LuckyMoneyBusiDetailUI.class);
                                    intent.putExtra("key_native_url", this.ohm.ogG);
                                    intent.putExtra("key_sendid", this.ohm.ohk.nZa);
                                    intent.putExtra("key_static_from_scene", this.ohm.ogI);
                                    this.ohm.startActivity(intent);
                                    this.ohm.finish();
                                }
                            });
                            this.ohb.setVisibility(0);
                        } else {
                            this.ohb.setVisibility(8);
                        }
                    } else {
                        if (!bh.ov(this.ohk.ocO)) {
                            this.ohi = this.ohk.ocO;
                            if (this.ohk.ocP == 1) {
                                this.ohg.setVisibility(8);
                            } else {
                                x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "show checkbox for " + this.ohk.ocO);
                                if (this.ohk.ocM == 1) {
                                    this.ohg.setChecked(true);
                                } else {
                                    this.ohg.setChecked(false);
                                }
                                this.ohg.setText(this.ohk.ocN);
                            }
                        }
                        this.ogX.setOnClickListener(new 4(this));
                        if (bh.ov(this.ohk.obL)) {
                            this.ogV.setVisibility(8);
                        } else {
                            this.ogV.setText(this.ohk.obL);
                        }
                        if (bh.ov(this.ohk.ocU)) {
                            this.ogW.setVisibility(8);
                        } else {
                            this.ogW.setText(this.ohk.ocU);
                        }
                    }
                    n.a(this.ogZ, null);
                    this.mController.contentView.setVisibility(0);
                }
                return true;
            }
        } else if (kVar instanceof s) {
            n.c(this.ogX);
            if (i == 0 && i2 == 0) {
                aq(-1, "");
                final s sVar = (s) kVar;
                if (sVar.fLE != 2) {
                    this.ogV.setVisibility(4);
                    this.ogW.setText(sVar.obL);
                    this.ogX.setVisibility(8);
                    if (this.ohj == 1) {
                        this.ohb.setOnClickListener(new 9(this, sVar));
                        this.ohb.setVisibility(0);
                    } else {
                        this.ohb.setVisibility(8);
                    }
                } else if (sVar.liB <= 1 || !(sVar.ocb == null || sVar.ocb.gEx == 1)) {
                    x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can not atomic go detail");
                    r1 = new Intent();
                    r1.putExtra("key_sendid", sVar.nZa);
                    r1.putExtra("key_static_from_scene", this.ogI);
                    if (sVar.ocR != null) {
                        r1.putExtra("key_realname_guide_helper", sVar.ocR);
                    }
                    try {
                        r1.putExtra("key_detail_info", sVar.ocQ.toByteArray());
                        r1.putExtra("key_jump_from", 2);
                    } catch (IOException e) {
                        x.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e.getLocalizedMessage());
                    }
                    if (com.tencent.mm.k.g.zY().getInt("PlayCoinSound", 0) > 0) {
                        r1.putExtra("play_sound", true);
                    }
                    d.b(this.mController.xIM, "luckymoney", ".ui.LuckyMoneyBusiDetailUI", r1);
                    finish();
                    return true;
                } else {
                    CharSequence string;
                    final View findViewById = findViewById(a$f.umR);
                    Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-findViewById.getHeight()));
                    translateAnimation.setDuration(400);
                    translateAnimation.setFillAfter(true);
                    translateAnimation.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ LuckyMoneyBusiReceiveUI ohm;

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            findViewById.setVisibility(8);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    findViewById.startAnimation(translateAnimation);
                    this.ogw.setText(e.t(((double) sVar.fLR) / 100.0d));
                    this.ogU.setText(sVar.ocI);
                    this.ogV.setVisibility(8);
                    this.ogW.setVisibility(8);
                    this.ogY.setVisibility(0);
                    this.ogX.setVisibility(8);
                    if (bh.ov(sVar.ocL)) {
                        string = getString(i.uKT);
                    } else {
                        string = sVar.ocL;
                    }
                    this.ohe.setText(string);
                    this.ohf.setVisibility(0);
                    g.pQN.h(11701, Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
                    x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "totalNum:" + sVar.liB);
                    if (sVar.liB > 1 || (sVar.ocb != null && sVar.ocb.gEx == 1)) {
                        x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can atomic");
                        this.ohl = sVar.ocR;
                        this.ohe.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ LuckyMoneyBusiReceiveUI ohm;

                            public final void onClick(View view) {
                                CharSequence string;
                                this.ohm.ogZ.setVisibility(4);
                                this.ohm.ohf.setVisibility(8);
                                this.ohm.ogY.setVisibility(8);
                                if (sVar.ocb == null || bh.ov(sVar.ocb.obw)) {
                                    string = this.ohm.getString(i.uKU);
                                } else {
                                    string = sVar.ocb.obw;
                                }
                                this.ohm.ohe.setText(string);
                                this.ohm.ohd.setText(sVar.ocJ);
                                this.ohm.ohc.setVisibility(0);
                                this.ohm.ohe.setOnClickListener(new 1(this));
                                n.a(this.ohm.ogZ, new 2(this));
                            }
                        });
                    } else {
                        this.ohe.setOnClickListener(new 8(this));
                    }
                    this.ohe.setVisibility(0);
                }
                return true;
            } else if (i2 == 416) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
                bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                this.ogX.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.ucE);
                return n.a(this, i2, kVar, bundle, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LuckyMoneyBusiReceiveUI ohm;

                    {
                        this.ohm = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, new c.a(this) {
                    final /* synthetic */ LuckyMoneyBusiReceiveUI ohm;

                    {
                        this.ohm = r1;
                    }

                    public final Intent l(int i, Bundle bundle) {
                        x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "re");
                        return null;
                    }
                }, 1005);
            }
        } else if (kVar instanceof ag) {
            if (i == 0 && i2 == 0) {
                h.bu(this, getString(i.epb));
                g.pQN.h(11701, Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4));
                finish();
                return true;
            }
            h.bu(this, str);
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.luckymoney.b.r) {
            if (i == 0 && i2 == 0) {
                l(new t(this.ogE, this.ogG, this.ohh, getIntent().getStringExtra("packageExt")));
                return true;
            }
        } else if (kVar instanceof o) {
            return true;
        } else {
            if (kVar instanceof v) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                if (i == 0 && i2 == 0) {
                    v vVar = (v) kVar;
                    r1 = new Intent();
                    r1.setClass(this.mController.xIM, LuckyMoneyBusiDetailUI.class);
                    try {
                        r1.putExtra("key_detail_info", vVar.ocQ.toByteArray());
                        r1.putExtra("key_jump_from", 2);
                    } catch (IOException e2) {
                        x.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e2.getLocalizedMessage());
                    }
                    r1.putExtra("key_native_url", this.ogG);
                    r1.putExtra("key_sendid", this.ogE);
                    r1.putExtra("key_static_from_scene", this.ogI);
                    startActivity(r1);
                    finish();
                    return true;
                }
            }
        }
        if (!(i == 0 && i2 == 0)) {
            aq(2, str);
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    g.pQN.h(11701, Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), stringExtra);
                    if (!bh.ov(stringExtra)) {
                        l(new ag(stringExtra, this.ogE, "v1.0"));
                        break;
                    }
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uCn;
    }

    private void aq(int i, String str) {
        x.i("MicroMsg.LuckyMoneyBusiReceiveUI", "markResult resultCode:%d errMsg:%s", Integer.valueOf(i), str);
        Intent intent = new Intent();
        intent.putExtra("key_result_errmsg", str);
        setResult(i, intent);
    }
}
