package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.plugin.luckymoney.b.ad;
import com.tencent.mm.plugin.luckymoney.b.ag;
import com.tencent.mm.plugin.luckymoney.b.c;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.u;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@a(19)
public class LuckyMoneyPrepareUI extends LuckyMoneyBaseUI implements f {
    private ak iZb = null;
    private Dialog ilS = null;
    private int kFm;
    private Button lHb = null;
    private TextView lml = null;
    private TextView lmo;
    protected MyKeyboardWindow mKeyboard;
    private int mType;
    private Button nZJ = null;
    private c obJ;
    private int ofA;
    private boolean ofB;
    private String ofC;
    private int ofD;
    private LuckyMoneyNumInputView ofp = null;
    private LuckyMoneyMoneyInputView ofq = null;
    private LuckyMoneyTextInputView ofr = null;
    protected View ofs;
    private View oft;
    private View ofu;
    private ViewGroup ofv;
    private TextView ofw;
    private a ofx = new a();
    private int ofy;
    private String ofz;
    private String ogE;
    private boolean ojA = false;
    private com.tencent.mm.sdk.b.c<pg> ojB = new 8(this);
    private MMScrollView oju;
    private int ojv = 1;
    private String ojw = e.aay("CNY");
    private String ojx = null;
    private RealnameGuideHelper ojy;
    private String ojz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 1);
        this.ofy = getIntent().getIntExtra("key_way", 3);
        this.kFm = getIntent().getIntExtra("key_from", 0);
        this.ofB = this.kFm == 1;
        this.ofD = getIntent().getIntExtra("pay_channel", -1);
        b(new w("v1.0", (byte) 0), true);
        com.tencent.mm.plugin.luckymoney.a.a.aWP();
        this.obJ = com.tencent.mm.plugin.luckymoney.a.a.aWQ().aXb();
        x.i("MicroMsg.LuckyMoneyPrepareUI", "mInWay:" + this.ofy + "mChannel:" + this.ofD);
        x.i("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.ofB + ", config " + this.obJ);
        initView();
        com.tencent.mm.sdk.b.a.xef.a(this.ojB);
        g.pQN.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aXr()), Integer.valueOf(1)});
    }

    protected void onResume() {
        super.onResume();
        ji(1970);
    }

    protected void onStop() {
        super.onStop();
        jj(1970);
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        this.oft = findViewById(f.upe);
        this.ofu = findViewById(f.uph);
        this.lHb = (Button) findViewById(f.upg);
        this.ofr = (LuckyMoneyTextInputView) findViewById(f.upI);
        this.ofr.Ec(getString(i.uJN));
        this.nZJ = (Button) findViewById(f.uoX);
        this.mKeyboard = (MyKeyboardWindow) findViewById(f.uwN);
        this.ofs = findViewById(f.uwM);
        this.lmo = (TextView) findViewById(f.uoW);
        this.ofp = (LuckyMoneyNumInputView) findViewById(f.uoT);
        this.ofq = (LuckyMoneyMoneyInputView) findViewById(f.umC);
        this.lml = (TextView) findViewById(f.upi);
        this.ofv = (ViewGroup) findViewById(f.upd);
        this.oju = (MMScrollView) findViewById(f.upC);
        this.ofw = (TextView) findViewById(f.upb);
        if (this.mType == 1) {
            setMMTitle(i.uKh);
            this.ofq.setTitle(getString(i.uKY));
            this.ofq.gu(true);
        } else {
            setMMTitle(i.uKu);
            this.ofq.setTitle(getString(i.uKZ));
            this.ofq.gu(false);
        }
        this.ofq.ohZ = this;
        LuckyMoneyMoneyInputView luckyMoneyMoneyInputView = this.ofq;
        luckyMoneyMoneyInputView.ohW.setHint(getString(i.uKr));
        this.ofp.ohZ = this;
        LuckyMoneyNumInputView luckyMoneyNumInputView = this.ofp;
        luckyMoneyNumInputView.ojg.setHint(getString(i.uKw));
        this.ofr.ohZ = this;
        final EditText editText = (EditText) this.ofq.findViewById(f.unA);
        final EditText editText2 = (EditText) this.ofp.findViewById(f.unA);
        e.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) this.mController.xIM.getSystemService("input_method")).showSoftInput(editText, 0);
        editText.addTextChangedListener(new 29(this, editText));
        editText2.addTextChangedListener(new 2(this, editText2));
        editText.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyPrepareUI ojC;

            public final void onClick(View view) {
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                this.ojC.z(this.ojC.ofq, 2);
                this.ojC.z(this.ojC.ofp, 0);
                this.ojC.mKeyboard.setXMode(2);
                this.ojC.mKeyboard.setInputEditText((EditText) view);
                this.ojC.ofs.setVisibility(0);
            }
        });
        editText.requestFocus();
        TextView textView = (TextView) this.ofq.findViewById(f.umD);
        if (textView != null) {
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LuckyMoneyPrepareUI ojC;

                public final void onClick(View view) {
                    editText.setOnClickListener(null);
                    editText2.setOnClickListener(null);
                    this.ojC.z(this.ojC.ofq, 2);
                    this.ojC.z(this.ojC.ofp, 0);
                    this.ojC.mKeyboard.setXMode(2);
                    this.ojC.mKeyboard.setInputEditText(editText);
                    this.ojC.ofs.setVisibility(0);
                }
            });
        }
        e.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) this.mController.xIM.getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyPrepareUI ojC;

            public final void onClick(View view) {
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                this.ojC.z(this.ojC.ofq, 2);
                this.ojC.z(this.ojC.ofp, 0);
                this.ojC.mKeyboard.setXMode(0);
                this.ojC.mKeyboard.setInputEditText((EditText) view);
                this.ojC.ofs.setVisibility(0);
            }
        });
        ((MMEditText) this.ofr.findViewById(f.upD)).setOnFocusChangeListener(new 6(this, editText, editText2));
        if (this.obJ != null) {
            if (this.mType == 1) {
                this.ofq.oia = this.obJ.obA;
            } else {
                this.ofq.oia = this.obJ.obD;
            }
            this.ofq.oib = this.obJ.obF;
            if (this.obJ.liR != 1) {
                dh(this.obJ.obI, this.obJ.obH);
            }
        }
        if (!this.ofB || getIntent().getIntExtra("key_chatroom_num", 0) > 1) {
            this.ofp.Ea("");
        } else {
            this.ofp.Ea("1");
        }
        this.ofp.si(this.obJ.obz);
        this.ofp.ojk = 1;
        x.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.ofp.aXO());
        this.ofq.aXI();
        if (this.ofB || this.kFm == 2) {
            setMMTitle(i.uKW);
            int intExtra = getIntent().getIntExtra("key_chatroom_num", 0);
            if (this.ofB && intExtra == 0) {
                x.i("MicroMsg.LuckyMoneyPrepareUI", "single hb");
                this.ofp.setVisibility(8);
            } else {
                String string = getString(i.uJX);
                String string2 = getString(i.uKi);
                String string3 = getString(i.uJT);
                String string4 = getString(i.uKj);
                if (this.ofB && intExtra > 0) {
                    x.i("MicroMsg.LuckyMoneyPrepareUI", "group hb,%d people", new Object[]{Integer.valueOf(intExtra)});
                    String string5 = getString(i.uKl);
                    string = getString(i.uKk);
                    TextView textView2 = (TextView) findViewById(f.upc);
                    textView2.setText(getString(i.uKv, new Object[]{Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8))}));
                    textView2.setVisibility(0);
                    string3 = string;
                    string = string5;
                } else if (this.kFm == 2) {
                    x.i("MicroMsg.LuckyMoneyPrepareUI", "f2f hb");
                    this.ofr.setVisibility(8);
                }
                com.tencent.mm.plugin.wallet_core.ui.g gVar = new com.tencent.mm.plugin.wallet_core.ui.g(this);
                CharSequence spannableString = new SpannableString(string + string2);
                spannableString.setSpan(gVar, string.length(), string.length() + string2.length(), 33);
                SpannableString spannableString2 = new SpannableString(string3 + string4);
                com.tencent.mm.plugin.wallet_core.ui.g gVar2 = new com.tencent.mm.plugin.wallet_core.ui.g(this);
                spannableString2.setSpan(gVar2, string3.length(), string3.length() + string4.length(), 33);
                gVar.sTw = new 11(this, spannableString2);
                gVar2.sTw = new 22(this, spannableString);
                this.lmo.setMovementMethod(LinkMovementMethod.getInstance());
                if (com.tencent.mm.ui.a.a.a.cnI().cnH()) {
                    this.lmo.setOnClickListener(new 24(this, spannableString, gVar, gVar2));
                }
                this.lmo.setText(spannableString);
                this.lmo.setVisibility(0);
            }
        } else if (this.mType == 1) {
            this.lmo.setText(this.obJ.obB);
            this.lmo.setVisibility(0);
        } else if (this.mType == 0) {
            this.lmo.setText(this.obJ.obC);
            this.lmo.setVisibility(0);
        }
        this.nZJ.setOnClickListener(new 25(this));
        this.ofx.a(this.ofp);
        this.ofx.a(this.ofq);
        this.ofx.a(this.ofr);
        this.ofx.g((TextView) findViewById(f.uoZ));
        this.iZb = new ak(new 26(this), false);
        if (this.oju != null) {
            this.oju.setOnTouchListener(new 27(this));
        }
        this.ofq.mType = this.mType;
        addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.ucZ, new 28(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        this.ofx.clear();
        this.iZb.cfK();
        if (this.ilS != null && this.ilS.isShowing()) {
            this.ilS.dismiss();
        }
        com.tencent.mm.sdk.b.a.xef.c(this.ojB);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uCE;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.oft.getVisibility() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.oft.setVisibility(8);
        aXy();
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.LuckyMoneyPrepareUI", "errType:" + i + " errCode:" + i2 + " errMsg:" + str + " scenetype:" + kVar.getType());
        if (kVar instanceof ad) {
            if (this.ilS != null && this.ilS.isShowing()) {
                this.ilS.dismiss();
            }
            if (this.ojA) {
                x.i("MicroMsg.LuckyMoneyPrepareUI", "has show alert return");
                return true;
            } else if (i == 0 && i2 == 0) {
                ad adVar = (ad) kVar;
                this.ofA = adVar.liB;
                this.ofz = adVar.nZa;
                this.ofC = adVar.odt;
                this.ogE = adVar.nZa;
                this.ojz = adVar.odz;
                PayInfo payInfo = new PayInfo();
                payInfo.fuH = adVar.ods;
                payInfo.fCV = 37;
                payInfo.fCR = this.ofD;
                h.a(this, payInfo, 1);
                return true;
            } else if (i2 == 401) {
                this.nZJ.setEnabled(false);
                this.nZJ.setClickable(false);
                this.iZb.J(5000, 5000);
                com.tencent.mm.ui.base.h.bu(this, str);
                return true;
            } else {
                if (TextUtils.isEmpty(str)) {
                    str = getString(i.uXa);
                }
                com.tencent.mm.ui.base.h.a((Context) this, str, null, false, new 7(this));
                return true;
            }
        }
        if (kVar instanceof ag) {
            if (i == 0 && i2 == 0) {
                if (this.ofB) {
                    com.tencent.mm.ui.snackbar.a.h(this, getString(i.epb));
                    com.tencent.mm.sdk.platformtools.ag.h(new 9(this), 1800);
                } else {
                    aXz();
                    this.ofu.setVisibility(0);
                    this.ofu.postDelayed(new 10(this), 1000);
                }
                return true;
            } else if (i2 == com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX) {
                com.tencent.mm.ui.base.h.a(this.mController.xIM, str, "", getString(i.uKO), getString(i.dEn), new 12(this), new 13(this));
                return true;
            }
        } else if (kVar instanceof w) {
            x.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig resp,errType=" + i + ";errCode=" + i2 + ";errMsg=" + str);
            if (i == 0 && i2 == 0) {
                final w wVar = (w) kVar;
                com.tencent.mm.plugin.luckymoney.a.a.aWP();
                this.obJ = com.tencent.mm.plugin.luckymoney.a.a.aWQ().aXb();
                x.i("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.obJ);
                if (this.mType == 1) {
                    this.ofq.oia = this.obJ.obA;
                } else {
                    this.ofq.oia = this.obJ.obD;
                }
                this.ofq.oib = this.obJ.obF;
                this.ofp.si(this.obJ.obz);
                this.ojw = wVar.obH;
                this.ojv = wVar.liR;
                this.ojx = wVar.obN;
                if (!(bh.ov(this.ojx) || this.ofr == null)) {
                    com.tencent.mm.sdk.platformtools.ag.y(new 14(this));
                }
                if (wVar.odf && this.ofB) {
                    TextView textView = (TextView) findViewById(f.upa);
                    textView.setOnClickListener(new 15(this));
                    g.pQN.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aXr()), Integer.valueOf(8)});
                    textView.setVisibility(0);
                }
                if (bh.ov(wVar.liT)) {
                    this.ofw.setVisibility(8);
                } else {
                    x.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + wVar.liT);
                    this.ofw.setText(wVar.liT);
                    if (!bh.ov(wVar.odh)) {
                        this.ofw.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ LuckyMoneyPrepareUI ojC;

                            public final void onClick(View view) {
                                e.l(this.ojC.mController.xIM, wVar.odh, false);
                            }
                        });
                    }
                    this.ofw.setVisibility(0);
                }
                g.c cVar = new g.c();
                if (wVar.odj == null || bh.ov(wVar.odj.content)) {
                    cVar.textColor = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bsO);
                } else {
                    cVar.textColor = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.ubA);
                }
                g.a(this, this.ofv, wVar.odj, cVar);
                dh(wVar.obI, wVar.obH);
                b(0.0d, this.ojw);
            }
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.luckymoney.b.x) {
            jj(1645);
            if (this.ilS != null && this.ilS.isShowing()) {
                this.ilS.hide();
            }
            if (i == 0 && i2 == 0) {
                String str2 = ((com.tencent.mm.plugin.luckymoney.b.x) kVar).ljf;
                if (bh.ov(str2)) {
                    x.e("MicroMsg.LuckyMoneyPrepareUI", "payUrl is null");
                } else {
                    x.i("MicroMsg.LuckyMoneyPrepareUI", "payUrl is not null");
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    d.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
                }
                return true;
            }
        } else if (kVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.c) {
            if (i == 0 && i2 == 0) {
                if (this.ilS != null) {
                    this.ilS.dismiss();
                }
                this.ogE = ((com.tencent.mm.plugin.luckymoney.f2f.a.c) kVar).nZa;
                this.ojz = ((com.tencent.mm.plugin.luckymoney.f2f.a.c) kVar).nZm;
                payInfo = new PayInfo();
                payInfo.fuH = ((com.tencent.mm.plugin.luckymoney.f2f.a.c) kVar).fuH;
                payInfo.fCV = 37;
                t.j(37, payInfo.fuH, i2);
                h.a(this, payInfo, 4);
            } else {
                t.j(37, "", i2);
                if (!bh.ov(str)) {
                    com.tencent.mm.ui.base.h.b(this, str, getString(i.uJL), true);
                }
                this.ilS.dismiss();
            }
            return true;
        }
        return false;
    }

    private void dh(String str, String str2) {
        x.i("MicroMsg.LuckyMoneyPrepareUI", "initH5LuckyMoneyView  currencyWording=" + str);
        TextView textView = (TextView) findViewById(f.umD);
        if (bh.ov(str)) {
            textView.setText(getString(i.umD));
        } else {
            textView.setText(str);
        }
        if (bh.ov(str2)) {
            b(0.0d, e.aay("CNY"));
        } else {
            b(0.0d, str2);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str;
        switch (i) {
            case 1:
                if (intent != null && intent.hasExtra("key_realname_guide_helper")) {
                    this.ojy = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                }
                if (i2 == -1) {
                    g.pQN.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aXr()), Integer.valueOf(5)});
                    String stringExtra = getIntent().getStringExtra("key_username");
                    if (!this.ofB || bh.ov(stringExtra)) {
                        aXz();
                        View findViewById = findViewById(f.upf);
                        this.oft.setVisibility(0);
                        n.a(findViewById, null);
                        this.lHb.setOnClickListener(new 17(this));
                        ((ImageView) findViewById(f.uoY)).setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ LuckyMoneyPrepareUI ojC;

                            {
                                this.ojC = r1;
                            }

                            public final void onClick(View view) {
                                this.ojC.oft.setVisibility(8);
                                this.ojC.aXy();
                            }
                        });
                    } else {
                        com.tencent.mm.ui.base.h.bu(this, getString(i.epb));
                        Map y = bi.y(this.ofC, "msg");
                        if (y == null) {
                            x.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
                            finish();
                            return;
                        }
                        str = (String) y.get(".msg.appmsg.wcpayinfo.paymsgid");
                        if (com.tencent.mm.plugin.luckymoney.a.a.aWP().aWS().DT(str)) {
                            x.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
                            if (!n.z(this.ofC, stringExtra, 1)) {
                                x.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
                                com.tencent.mm.plugin.luckymoney.a.a.aWP().aWS().DU(str);
                            }
                        } else {
                            x.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
                        }
                        finish();
                    }
                    str = "";
                    if (intent != null) {
                        str = intent.getStringExtra("key_trans_id");
                    }
                    Eb(str);
                    break;
                }
                break;
            case 2:
                if (i2 != -1 || intent == null) {
                    if (i2 == 0) {
                        Intent intent2 = new Intent();
                        intent2.setClass(this.mController.xIM, LuckyMoneyMyRecordUI.class);
                        intent2.putExtra("key_type", 1);
                        startActivity(intent2);
                        break;
                    }
                }
                str = intent.getStringExtra("Select_Conv_User");
                g.pQN.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aXr()), Integer.valueOf(7), str});
                if (!bh.ov(str)) {
                    l(new ag(str.replaceAll(",", "|"), this.ofz, "v1.0"));
                    break;
                } else {
                    finish();
                    break;
                }
                break;
            case 3:
                if (intent != null && intent.hasExtra("result_data")) {
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra == null) {
                        x.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY bundle is null");
                        break;
                    }
                    int i3 = bh.getInt(bundleExtra.getString("payState", "2"), 0);
                    x.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY payState is " + i3 + ";STATE_H5_PAY_SUCC=0");
                    if (i3 == 0) {
                        finish();
                        break;
                    }
                }
                break;
            case 4:
                if (i2 == -1) {
                    str = "";
                    if (intent != null) {
                        str = intent.getStringExtra("key_trans_id");
                    }
                    Eb(str);
                }
                finish();
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void z(View view, int i) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(f.uwN);
        this.ofs = findViewById(f.uwM);
        View findViewById = findViewById(f.itm);
        EditText editText = (EditText) view.findViewById(f.unA);
        if (this.mKeyboard != null && editText != null && this.ofs != null) {
            e.setNoSystemInputOnEditText(editText);
            editText.setOnFocusChangeListener(new 19(this, false, i, editText));
            editText.setOnClickListener(new 20(this, false, i, editText));
            TextView textView = (TextView) view.findViewById(f.umD);
            if (textView != null) {
                textView.setOnClickListener(new 21(this, false, editText, view, i));
            }
            findViewById.setOnClickListener(new 23(this));
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || this.ofs == null || !this.ofs.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.ofs.setVisibility(8);
        return true;
    }

    protected final void Xa() {
        if (this.ofs != null && this.ofs.isShown()) {
            this.ofs.setVisibility(8);
        }
    }

    public final void aXq() {
        double d;
        double d2;
        com.tencent.mm.plugin.luckymoney.a.a.aWP();
        this.obJ = com.tencent.mm.plugin.luckymoney.a.a.aWQ().aXb();
        if (this.ofq.aXG() == 3 || this.ofp.aXG() == 3) {
            d = 0.0d;
            d2 = 0.0d;
        } else {
            int aXO = this.ofp.aXO();
            d2 = this.ofq.aXH();
            if (this.mType == 0) {
                d2 *= (double) aXO;
                d = this.ofq.aXH();
            } else {
                d = aXO > 0 ? this.ofq.aXH() / ((double) aXO) : 0.0d;
            }
        }
        if (this.ofx.aXE()) {
            x.i("MicroMsg.LuckyMoneyPrepareUI", "has error");
            this.nZJ.setClickable(false);
            this.nZJ.setEnabled(false);
        } else {
            boolean z;
            if (d2 == 0.0d || d == 0.0d) {
                z = true;
            } else if (d2 > this.obJ.obA && this.obJ.obA > 0.0d) {
                this.ofx.sh(getString(i.uKX, new Object[]{Math.round(this.obJ.obA), bh.az(this.obJ.obI, "")}));
                z = true;
            } else if (d > 0.0d) {
                x.i("MicroMsg.LuckyMoneyPrepareUI", "perAmount " + d);
                if (this.mType == 0) {
                    if (d > this.obJ.obD && this.obJ.obD > 0.0d) {
                        this.ofx.sh(getString(i.uKD, new Object[]{Math.round(this.obJ.obD), bh.az(this.obJ.obI, "")}));
                        z = true;
                    }
                    z = false;
                } else {
                    if (d > this.obJ.obE && this.obJ.obE > 0.0d) {
                        this.ofx.sh(getString(i.uKD, new Object[]{Math.round(this.obJ.obE), bh.az(this.obJ.obI, "")}));
                        this.ofp.onError();
                        this.ofq.onError();
                        z = true;
                    }
                    z = false;
                }
                x.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for max value");
                if (!z) {
                    if (this.mType == 0) {
                        if (d < this.obJ.obF) {
                            this.ofx.sh(getString(i.uKE, new Object[]{e.t(this.obJ.obF), bh.az(this.obJ.obI, "")}));
                            z = true;
                        }
                    } else if (d < 0.01d) {
                        this.ofx.sh(getString(i.uKE, new Object[]{"0.01", bh.az(this.obJ.obI, "")}));
                        this.ofp.onError();
                        this.ofq.onError();
                        z = true;
                    }
                }
                x.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for min value");
            } else {
                z = false;
            }
            if (z) {
                this.nZJ.setClickable(false);
                this.nZJ.setEnabled(false);
            } else {
                this.nZJ.setClickable(true);
                this.nZJ.setEnabled(true);
            }
        }
        b(d2, this.ojw);
    }

    private void b(double d, String str) {
        if (bh.ov(str)) {
            this.lml.setText(e.u(d));
        } else {
            this.lml.setText(str + e.t(d));
        }
    }

    private int aXr() {
        if (!this.ofB) {
            return 3;
        }
        if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
            return 2;
        }
        return 1;
    }

    public void finish() {
        if (this.ojy != null) {
            Intent intent = new Intent();
            intent.putExtra("key_realname_guide_helper", this.ojy);
            d.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", intent);
        }
        super.finish();
    }

    private void Eb(String str) {
        x.i("MicroMsg.LuckyMoneyPrepareUI", "do business callback");
        b(new u(this.ogE, str, this.ojz), false);
    }
}
