package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.luckymoney.b.ad;
import com.tencent.mm.plugin.luckymoney.b.ag;
import com.tencent.mm.plugin.luckymoney.b.c;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.q;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@a(19)
public class SnsLuckyMoneyPrepareUI extends LuckyMoneyBaseUI implements f {
    private ak iZb = null;
    protected Dialog ilS = null;
    private ScrollView jjn;
    protected Button lHb = null;
    protected TextView lml = null;
    private TextView lmo;
    protected MyKeyboardWindow mKeyboard;
    private int mType;
    protected Button nZJ = null;
    private c obJ;
    private int ofA;
    private boolean ofB;
    private String ofC;
    private int ofD;
    private com.tencent.mm.wallet_core.ui.a ofE;
    protected LuckyMoneyNumInputView ofp = null;
    protected LuckyMoneyMoneyInputView ofq = null;
    protected LuckyMoneyTextInputView ofr = null;
    protected View ofs;
    private View oft;
    private View ofu;
    private ViewGroup ofv;
    private TextView ofw;
    private com.tencent.mm.plugin.luckymoney.ui.a ofx = new com.tencent.mm.plugin.luckymoney.ui.a();
    private int ofy;
    private String ofz;

    class AnonymousClass13 implements OnClickListener {
        final /* synthetic */ boolean iiJ = false;
        final /* synthetic */ EditText iiL;
        final /* synthetic */ int iiN;
        final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;

        AnonymousClass13(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI, boolean z, int i, EditText editText) {
            this.ofF = snsLuckyMoneyPrepareUI;
            this.iiN = i;
            this.iiL = editText;
        }

        public final void onClick(View view) {
            if (!this.ofF.ofs.isShown() && !this.iiJ) {
                SnsLuckyMoneyPrepareUI.k(this.ofF);
                this.ofF.mKeyboard.setXMode(this.iiN);
            } else if (this.iiJ) {
                this.ofF.Xa();
                ((InputMethodManager) this.ofF.mController.xIM.getSystemService("input_method")).showSoftInput(this.iiL, 0);
            }
        }
    }

    static /* synthetic */ void k(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        if (snsLuckyMoneyPrepareUI.ofs != null && !snsLuckyMoneyPrepareUI.ofs.isShown()) {
            snsLuckyMoneyPrepareUI.ofs.setVisibility(0);
            snsLuckyMoneyPrepareUI.ofE.hA(true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 1);
        this.ofy = getIntent().getIntExtra("key_way", 3);
        this.ofB = getIntent().getIntExtra("key_from", 0) == 1;
        this.ofD = getIntent().getIntExtra("pay_channel", -1);
        b(new w("v1.0", (byte) 0), false);
        com.tencent.mm.plugin.luckymoney.a.a.aWP();
        this.obJ = com.tencent.mm.plugin.luckymoney.a.a.aWQ().aXb();
        x.d("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.ofB + ", config " + this.obJ);
        initView();
        g.pQN.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aXr()), Integer.valueOf(1)});
    }

    protected final void initView() {
        r(getResources().getDrawable(e.ucI));
        setBackBtn(new 1(this));
        this.oft = findViewById(com.tencent.mm.plugin.wxpay.a.f.upe);
        this.ofu = findViewById(com.tencent.mm.plugin.wxpay.a.f.uph);
        this.lHb = (Button) findViewById(com.tencent.mm.plugin.wxpay.a.f.upg);
        this.ofr = (LuckyMoneyTextInputView) findViewById(com.tencent.mm.plugin.wxpay.a.f.upI);
        this.ofr.Ec(getString(i.uJN));
        this.nZJ = (Button) findViewById(com.tencent.mm.plugin.wxpay.a.f.uoX);
        this.mKeyboard = (MyKeyboardWindow) findViewById(com.tencent.mm.plugin.wxpay.a.f.uwN);
        this.ofs = findViewById(com.tencent.mm.plugin.wxpay.a.f.uwM);
        this.lmo = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uoW);
        this.ofp = (LuckyMoneyNumInputView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uoT);
        this.ofq = (LuckyMoneyMoneyInputView) findViewById(com.tencent.mm.plugin.wxpay.a.f.umC);
        this.lml = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.upi);
        this.ofv = (ViewGroup) findViewById(com.tencent.mm.plugin.wxpay.a.f.upd);
        this.jjn = (ScrollView) findViewById(com.tencent.mm.plugin.wxpay.a.f.upC);
        this.ofw = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.upb);
        if (this.mType == 1) {
            this.ofq.setTitle(getString(i.uKY));
            this.ofq.gu(true);
        } else {
            this.ofq.setTitle(getString(i.uKZ));
            this.ofq.gu(false);
        }
        this.ofq.ohZ = this;
        this.ofp.ohZ = this;
        this.ofr.ohZ = this;
        EditText editText = (EditText) this.ofq.findViewById(com.tencent.mm.plugin.wxpay.a.f.unA);
        EditText editText2 = (EditText) this.ofp.findViewById(com.tencent.mm.plugin.wxpay.a.f.unA);
        com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) this.mController.xIM.getSystemService("input_method")).showSoftInput(editText, 0);
        editText.setOnClickListener(new 19(this, editText, editText2));
        TextView textView = (TextView) this.ofq.findViewById(com.tencent.mm.plugin.wxpay.a.f.umD);
        if (textView != null) {
            textView.setOnClickListener(new 20(this, editText, editText2));
        }
        com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) this.mController.xIM.getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new 21(this, editText, editText2));
        if (this.obJ != null) {
            if (this.mType == 1) {
                this.ofq.oia = this.obJ.obA;
            } else {
                this.ofq.oia = this.obJ.obD;
            }
            this.ofq.oib = this.obJ.obF;
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
        if (this.ofB) {
            if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
                String string = getString(i.uKl);
                String string2 = getString(i.uKi);
                String string3 = getString(i.uKk);
                String string4 = getString(i.uKj);
                final CharSequence spannableString = new SpannableString(string + string2);
                com.tencent.mm.plugin.wallet_core.ui.g gVar = new com.tencent.mm.plugin.wallet_core.ui.g(this);
                spannableString.setSpan(gVar, string.length(), string.length() + string2.length(), 33);
                final SpannableString spannableString2 = new SpannableString(string3 + string4);
                com.tencent.mm.plugin.wallet_core.ui.g gVar2 = new com.tencent.mm.plugin.wallet_core.ui.g(this);
                spannableString2.setSpan(gVar2, string3.length(), string3.length() + string4.length(), 33);
                gVar.sTw = new com.tencent.mm.plugin.wallet_core.ui.g.a(this) {
                    final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;

                    public final void onClick(View view) {
                        int aXO = this.ofF.ofp.aXO();
                        double aXH = this.ofF.ofq.aXH();
                        this.ofF.mType = 0;
                        this.ofF.ofq.mType = this.ofF.mType;
                        this.ofF.ofq.gu(false);
                        this.ofF.ofq.setTitle(this.ofF.getString(i.uKZ));
                        if (aXH > 0.0d && aXO > 0) {
                            this.ofF.ofq.DZ(com.tencent.mm.wallet_core.ui.e.t(aXH / ((double) aXO)));
                        }
                        this.ofF.ofq.oia = this.ofF.obJ.obD;
                        this.ofF.lmo.setText(spannableString2);
                        g.pQN.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.ofF.aXr()), Integer.valueOf(3)});
                    }
                };
                gVar2.sTw = new com.tencent.mm.plugin.wallet_core.ui.g.a(this) {
                    final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;

                    public final void onClick(View view) {
                        int aXO = this.ofF.ofp.aXO();
                        double aXH = this.ofF.ofq.aXH();
                        this.ofF.mType = 1;
                        this.ofF.ofq.mType = this.ofF.mType;
                        this.ofF.ofq.setTitle(this.ofF.getString(i.uKY));
                        this.ofF.ofq.gu(true);
                        if (aXH > 0.0d && aXO > 0) {
                            this.ofF.ofq.DZ(com.tencent.mm.wallet_core.ui.e.t(aXH * ((double) aXO)));
                        }
                        this.ofF.ofq.oia = this.ofF.obJ.obA;
                        this.ofF.lmo.setText(spannableString);
                        g.pQN.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.ofF.aXr()), Integer.valueOf(2)});
                    }
                };
                this.lmo.setMovementMethod(LinkMovementMethod.getInstance());
                this.lmo.setText(spannableString);
                this.lmo.setVisibility(0);
            } else {
                this.ofp.setVisibility(8);
            }
        } else if (this.mType == 1) {
            this.lmo.setText(this.obJ.obB);
            this.lmo.setVisibility(0);
        } else if (this.mType == 0) {
            this.lmo.setText(this.obJ.obC);
            this.lmo.setVisibility(0);
        }
        this.nZJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;

            {
                this.ofF = r1;
            }

            public final void onClick(View view) {
                g.pQN.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.ofF.aXr()), Integer.valueOf(4)});
                if (this.ofF.ofq.aXG() != 0) {
                    u.makeText(this.ofF.mController.xIM, i.uPA, 0).show();
                    return;
                }
                long v;
                k adVar;
                int aXO = this.ofF.ofp.aXO();
                double aXH = this.ofF.ofq.aXH();
                long j = 0;
                if (this.ofF.mType == 1) {
                    v = com.tencent.mm.wallet_core.ui.e.v(aXH);
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Dj().CU().set(356354, Integer.valueOf(aXO));
                } else {
                    v = com.tencent.mm.wallet_core.ui.e.v(((double) aXO) * aXH);
                    j = com.tencent.mm.wallet_core.ui.e.v(aXH);
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Dj().CU().set(356353, Integer.valueOf(aXO));
                }
                String input = this.ofF.ofr.getInput();
                if (bh.ov(input)) {
                    input = this.ofF.getString(i.uJN);
                }
                String stringExtra = this.ofF.getIntent().getStringExtra("key_username");
                if (!this.ofF.ofB || bh.ov(stringExtra)) {
                    adVar = new ad(aXO, v, j, this.ofF.mType, input, n.aXg(), null, null, q.FS(), q.FU(), this.ofF.ofy);
                } else {
                    adVar = new ad(aXO, v, j, this.ofF.mType, input, n.aXg(), stringExtra, n.gt(stringExtra), q.FS(), q.FU(), this.ofF.ofy);
                }
                this.ofF.b(adVar, false);
                if (this.ofF.ilS != null) {
                    this.ofF.ilS.show();
                    return;
                }
                this.ofF.ilS = com.tencent.mm.wallet_core.ui.g.a(this.ofF.mController.xIM, true, new 1(this));
            }
        });
        this.lml.setText(com.tencent.mm.wallet_core.ui.e.u(0.0d));
        this.ofx.a(this.ofp);
        this.ofx.a(this.ofq);
        this.ofx.a(this.ofr);
        this.ofx.g((TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uoZ));
        if (this.ofB && this.mType == 1) {
            TextView textView2 = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.upc);
            textView2.setText(getString(i.uKv, new Object[]{Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8))}));
            textView2.setVisibility(0);
        }
        this.iZb = new ak(new 17(this), false);
        if (this.jjn != null) {
            this.jjn.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;

                {
                    this.ofF = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        this.ofF.Xa();
                        this.ofF.aWs();
                    }
                    return false;
                }
            });
        }
        this.ofq.mType = this.mType;
        if (this.ofB && getIntent().getIntExtra("key_chatroom_num", 0) == 0) {
            this.ofq.requestFocus();
        } else {
            this.ofp.requestFocus();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.ofx.clear();
        this.iZb.cfK();
        if (this.ilS != null && this.ilS.isShowing()) {
            this.ilS.dismiss();
        }
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
        if (kVar instanceof ad) {
            if (this.ilS != null && this.ilS.isShowing()) {
                this.ilS.hide();
            }
            if (i == 0 && i2 == 0) {
                ad adVar = (ad) kVar;
                this.ofA = adVar.liB;
                this.ofz = adVar.nZa;
                this.ofC = adVar.odt;
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
                com.tencent.mm.ui.base.h.bu(this, str);
                return true;
            }
        }
        if (kVar instanceof ag) {
            if (i == 0 && i2 == 0) {
                if (this.ofB) {
                    com.tencent.mm.ui.base.h.bu(this, getString(i.epb));
                    finish();
                } else {
                    aXz();
                    this.ofu.postDelayed(new Runnable(this) {
                        final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;

                        {
                            this.ofF = r1;
                        }

                        public final void run() {
                            Intent intent = new Intent();
                            intent.setClass(this.ofF.mController.xIM, LuckyMoneyIndexUI.class);
                            intent.addFlags(67108864);
                            this.ofF.mController.xIM.startActivity(intent);
                            this.ofF.finish();
                        }
                    }, 1000);
                }
                return true;
            } else if (i2 == com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX) {
                com.tencent.mm.ui.base.h.a(this.mController.xIM, str, "", getString(i.uKO), getString(i.dEn), new 3(this), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;

                    {
                        this.ofF = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        } else if (kVar instanceof w) {
            if (i == 0 && i2 == 0) {
                w wVar = (w) kVar;
                com.tencent.mm.plugin.luckymoney.a.a.aWP();
                this.obJ = com.tencent.mm.plugin.luckymoney.a.a.aWQ().aXb();
                x.d("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.obJ);
                if (this.mType == 1) {
                    this.ofq.oia = this.obJ.obA;
                } else {
                    this.ofq.oia = this.obJ.obD;
                }
                this.ofq.oib = this.obJ.obF;
                this.ofp.si(this.obJ.obz);
                if (wVar.odf && this.ofB) {
                    TextView textView = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.upa);
                    textView.setOnClickListener(new 5(this));
                    g.pQN.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aXr()), Integer.valueOf(8)});
                    textView.setVisibility(0);
                }
                if (bh.ov(wVar.liT)) {
                    this.ofw.setVisibility(8);
                } else {
                    x.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + wVar.liT);
                    this.ofw.setText(wVar.liT);
                    if (!bh.ov(wVar.odh)) {
                        this.ofw.setOnClickListener(new 6(this, wVar));
                    }
                    this.ofw.setVisibility(0);
                }
                com.tencent.mm.plugin.luckymoney.ui.g.c cVar = new com.tencent.mm.plugin.luckymoney.ui.g.c();
                cVar.textColor = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.ubA);
                com.tencent.mm.plugin.luckymoney.ui.g.a(this, this.ofv, wVar.odj, cVar);
            }
            return true;
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    g.pQN.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aXr()), Integer.valueOf(5)});
                    String stringExtra = getIntent().getStringExtra("key_username");
                    if (this.ofB && !bh.ov(stringExtra)) {
                        com.tencent.mm.ui.base.h.bu(this, getString(i.epb));
                        Map y = bi.y(this.ofC, "msg");
                        if (y != null) {
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
                            break;
                        }
                        x.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
                        finish();
                        return;
                    }
                    aXz();
                    new af().postDelayed(new 7(this), 200);
                    this.lHb.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;

                        {
                            this.ofF = r1;
                        }

                        public final void onClick(View view) {
                            g.pQN.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.ofF.aXr()), Integer.valueOf(6)});
                            n.a(this.ofF, this.ofF.mType, this.ofF.ofA, false);
                            this.ofF.oft.postDelayed(new 1(this), 100);
                        }
                    });
                    ((ImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uoY)).setOnClickListener(new 9(this));
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
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void z(View view, int i) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(com.tencent.mm.plugin.wxpay.a.f.uwN);
        this.ofs = findViewById(com.tencent.mm.plugin.wxpay.a.f.uwM);
        View findViewById = findViewById(com.tencent.mm.plugin.wxpay.a.f.itm);
        EditText editText = (EditText) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.unA);
        if (this.mKeyboard != null && editText != null && this.ofs != null) {
            com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(editText);
            editText.setOnFocusChangeListener(new 10(this, false, i, editText));
            editText.setOnClickListener(new 12(this, false, i, editText));
            TextView textView = (TextView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.umD);
            if (textView != null) {
                textView.setOnClickListener(new AnonymousClass13(this, false, i, editText));
            }
            findViewById.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;

                {
                    this.ofF = r1;
                }

                public final void onClick(View view) {
                    this.ofF.Xa();
                }
            });
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || this.ofs == null || !this.ofs.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        Xa();
        return true;
    }

    protected final void Xa() {
        if (this.ofs != null && this.ofs.isShown()) {
            this.ofs.setVisibility(8);
            this.ofE.hA(false);
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
                boolean z2;
                if (this.mType == 0) {
                    if (d > this.obJ.obD && this.obJ.obD > 0.0d) {
                        this.ofx.sh(getString(i.uKD, new Object[]{Math.round(this.obJ.obD), bh.az(this.obJ.obI, "")}));
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    if (d > this.obJ.obE && this.obJ.obE > 0.0d) {
                        this.ofx.sh(getString(i.uKD, new Object[]{Math.round(this.obJ.obE), bh.az(this.obJ.obI, "")}));
                        this.ofp.onError();
                        this.ofq.onError();
                        z2 = true;
                    }
                    z2 = false;
                }
                if (!z2) {
                    if (this.mType == 0) {
                        if (d < this.obJ.obF) {
                            this.ofx.sh(getString(i.uKE, new Object[]{com.tencent.mm.wallet_core.ui.e.t(this.obJ.obF), bh.az(this.obJ.obI, "")}));
                            z = true;
                        }
                    } else if (d < 0.01d) {
                        this.ofx.sh(getString(i.uKE, new Object[]{"0.01", bh.az(this.obJ.obI, "")}));
                        this.ofp.onError();
                        this.ofq.onError();
                        z = true;
                    }
                }
                z = z2;
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
        this.lml.setText(com.tencent.mm.wallet_core.ui.e.u(d2));
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
}
