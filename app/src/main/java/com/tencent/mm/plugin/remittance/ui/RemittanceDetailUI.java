package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.model.h;
import com.tencent.mm.plugin.remittance.model.s;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.z.q;
import com.tencent.rtmp.TXLiveConstants;

public class RemittanceDetailUI extends WalletBaseUI {
    public TextView ogW = null;
    private String pMl = null;
    private int pMm;
    public String pMq = null;
    public Button pOA = null;
    public TextView pOB = null;
    public TextView pOC = null;
    public int pOD;
    public int pOE;
    public String pOF = null;
    public String pOG = null;
    protected String pOH = null;
    public int pOI = 3;
    protected boolean pOJ = false;
    protected int pOK;
    private int pOL;
    private s pOM;
    private c<nb> pON = new 1(this);
    public ImageView pOx = null;
    public TextView pOy = null;
    public TextView pOz = null;
    private String paO;
    private String paV;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pOD = getIntent().getIntExtra("invalid_time", 0);
        this.pOE = getIntent().getIntExtra("appmsg_type", 0);
        this.pOF = getIntent().getStringExtra("transaction_id");
        this.pOH = getIntent().getStringExtra("bill_id");
        this.pMq = getIntent().getStringExtra("transfer_id");
        this.pOG = getIntent().getStringExtra("sender_name");
        this.pOI = getIntent().getIntExtra("effective_date", 3);
        this.pOJ = getIntent().getBooleanExtra("is_sender", false);
        this.pOK = getIntent().getIntExtra("total_fee", 0);
        initView();
        vv(0);
        getIntent();
        a.xef.b(this.pON);
    }

    public void onDestroy() {
        a.xef.c(this.pON);
        super.onDestroy();
    }

    public void vv(int i) {
        b(new v(i, this.pOF, this.pMq, this.pOD), true);
    }

    protected final void initView() {
        setMMTitle(i.uOh);
        this.pOx = (ImageView) findViewById(f.uvH);
        this.pOy = (TextView) findViewById(f.uvK);
        this.pOz = (TextView) findViewById(f.uvI);
        this.pOA = (Button) findViewById(f.uvG);
        this.ogW = (TextView) findViewById(f.uvJ);
        this.pOB = (TextView) findViewById(f.uvL);
        this.pOC = (TextView) findViewById(f.uvM);
    }

    public void vw(int i) {
        k hVar;
        if (getIntent().getBooleanExtra("is_sender", false)) {
            hVar = new h(this.pOF, this.pOH, i);
        } else {
            hVar = new h(this.pMq, this.pOH, i);
        }
        hVar.gOs = "RemittanceProcess";
        l(hVar);
    }

    public void T(Intent intent) {
        d.b(this, "remittance", ".ui.RemittanceResendMsgUI", intent);
    }

    public void bnV() {
        k sVar = new s(this.pOF, this.pMq, this.pOK, "confirm", this.pOG, this.pOD);
        sVar.gOs = "RemittanceProcess";
        l(sVar);
    }

    public void bnW() {
        k sVar = new s(this.pOF, this.pMq, this.pOK, "refuse", this.pOG, this.pOD);
        sVar.gOs = "RemittanceProcess";
        l(sVar);
    }

    private void bnL() {
        if (this.pOL == 0 || this.pMm != 1 || bh.ov(this.pMl)) {
            x.i("MicroMsg.RemittanceDetailUI", "flag: %d, descUrl empty: %B", new Object[]{Integer.valueOf(this.pOL), Boolean.valueOf(bh.ov(this.pMl))});
            this.mController.removeAllOptionMenu();
            return;
        }
        addIconOptionMenu(0, e.udW, new 8(this));
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof v) {
            final v vVar = (v) kVar;
            if (i == 0 && i2 == 0) {
                if (vVar != null) {
                    if (vVar.pLv) {
                        this.paV = q.FS();
                        this.paO = this.pOG;
                    } else {
                        this.paV = this.pOG;
                        this.paO = q.FS();
                    }
                    boolean equals = q.FS().equals(this.paO);
                    this.pOA.setVisibility(8);
                    this.pOz.setText(com.tencent.mm.wallet_core.ui.e.d(vVar.ljg, vVar.paz));
                    CharSequence charSequence = vVar.pLx;
                    if (!bh.ov(charSequence) && charSequence.contains("%s")) {
                        charSequence = charSequence.trim().replace("%s", ax(this.paO, true));
                    }
                    CharSequence charSequence2 = vVar.pLy;
                    Bundle bundle = new Bundle();
                    bundle.putString("transaction_id", this.pOF);
                    bundle.putString("receiver_name", this.paO);
                    bundle.putString("transfer_id", this.pMq);
                    bundle.putInt("total_fee", this.pOK);
                    bundle.putString("sender_name", this.pOG);
                    bundle.putInt("invalid_time", this.pOD);
                    this.ogW.setClickable(true);
                    this.pOy.setClickable(true);
                    int i3 = vVar.status;
                    x.d("MicroMsg.RemittanceDetailUI", "status: %d", new Object[]{Integer.valueOf(i3)});
                    String string;
                    String string2;
                    CharSequence spannableString;
                    switch (i3) {
                        case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                            com.tencent.mm.plugin.order.c.a aVar;
                            if (equals) {
                                this.pOx.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uGH);
                                this.pOA.setVisibility(0);
                                this.pOA.setOnClickListener(new OnClickListener(this) {
                                    final /* synthetic */ RemittanceDetailUI pOO;

                                    {
                                        this.pOO = r1;
                                    }

                                    public final void onClick(View view) {
                                        o.bLl();
                                        if (!o.a(this.pOO, this.pOO.zIY, new 1(this))) {
                                            this.pOO.bnV();
                                        }
                                    }
                                });
                                if (bh.ov(charSequence) || bh.ov(charSequence2)) {
                                    this.pOy.setText(i.uNC);
                                    if (vVar.pLz == 0) {
                                        string = getString(i.uNF, new Object[]{Integer.valueOf(this.pOI)});
                                    } else if (bh.ov(vVar.pLy)) {
                                        x.i("MicroMsg.RemittanceDetailUI", "use hardcode wording");
                                        string = vVar.pLz == 1 ? "24" : "2";
                                        string = getString(i.uNE, new Object[]{string}) + getString(i.uNF, new Object[]{Integer.valueOf(this.pOI)});
                                    } else {
                                        string = vVar.pLy;
                                    }
                                    string2 = getString(i.uNu);
                                    charSequence2 = new SpannableString(string + string2);
                                    aVar = new com.tencent.mm.plugin.order.c.a(this);
                                    aVar.pdj = new com.tencent.mm.plugin.order.c.a.a(this) {
                                        final /* synthetic */ RemittanceDetailUI pOO;

                                        public final void onClick(View view) {
                                            com.tencent.mm.ui.base.h.a(this.pOO, this.pOO.getString(i.uNq, new Object[]{RemittanceDetailUI.ax(vVar.pLu, false)}), this.pOO.getString(i.dGt), this.pOO.getString(i.uNv), this.pOO.getString(i.dEn), new 1(this), new DialogInterface.OnClickListener(this) {
                                                final /* synthetic */ AnonymousClass4 pOU;

                                                {
                                                    this.pOU = r1;
                                                }

                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                }
                                            });
                                        }
                                    };
                                    charSequence2.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                    this.ogW.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.ogW.setText(charSequence2);
                                } else {
                                    this.pOy.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this, charSequence, (int) this.pOy.getTextSize(), bundle));
                                    this.ogW.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this, charSequence2, (int) this.ogW.getTextSize(), bundle));
                                    this.pOy.setOnTouchListener(new l());
                                    this.ogW.setOnTouchListener(new l());
                                }
                            } else if (bh.ov(charSequence) || bh.ov(charSequence2)) {
                                this.pOy.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, getString(i.uND, new Object[]{ax(this.paO, true)}), this.pOy.getTextSize()));
                                string = getString(i.uNJ, new Object[]{Integer.valueOf(this.pOI)});
                                string2 = getString(i.uOc);
                                charSequence2 = new SpannableString(string + string2);
                                aVar = new com.tencent.mm.plugin.order.c.a(this);
                                aVar.pdj = new 2(this);
                                charSequence2.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                this.ogW.setMovementMethod(LinkMovementMethod.getInstance());
                                this.ogW.setText(charSequence2);
                            } else {
                                this.pOy.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this, charSequence, (int) this.pOy.getTextSize(), bundle));
                                this.ogW.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this, charSequence2, (int) this.ogW.getTextSize(), bundle));
                                this.pOy.setOnTouchListener(new l());
                                this.ogW.setOnTouchListener(new l());
                            }
                            this.pOx.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uGH);
                            this.pOB.setText(getString(i.uNL, new Object[]{com.tencent.mm.wallet_core.ui.e.HD(vVar.pLs)}));
                            this.pOB.setVisibility(0);
                            this.pOC.setVisibility(8);
                            break;
                        case 2001:
                            this.pOx.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uGE);
                            if (!bh.ov(charSequence) && !bh.ov(charSequence2)) {
                                this.pOy.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this, charSequence, (int) this.pOy.getTextSize(), bundle));
                                this.ogW.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this, charSequence2, (int) this.ogW.getTextSize(), bundle));
                                this.pOy.setOnTouchListener(new l());
                                this.ogW.setOnTouchListener(new l());
                            } else if (equals) {
                                this.pOy.setText(i.uNx);
                                charSequence = new SpannableStringBuilder(getString(i.uNi));
                                com.tencent.mm.plugin.order.c.a aVar2 = new com.tencent.mm.plugin.order.c.a(this);
                                aVar2.pdj = new com.tencent.mm.plugin.order.c.a.a(this) {
                                    final /* synthetic */ RemittanceDetailUI pOO;

                                    {
                                        this.pOO = r1;
                                    }

                                    public final void onClick(View view) {
                                        com.tencent.mm.pluginsdk.wallet.h.Y(this.pOO, 0);
                                    }
                                };
                                charSequence.setSpan(aVar2, 0, charSequence.length(), 18);
                                this.ogW.setMovementMethod(LinkMovementMethod.getInstance());
                                this.ogW.setText(charSequence);
                                this.ogW.setVisibility(0);
                            } else {
                                this.pOy.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, ax(this.paO, true) + getString(i.uNx), this.pOy.getTextSize()));
                                this.ogW.setText(i.uNI);
                                this.ogW.setVisibility(0);
                            }
                            this.pOB.setText(getString(i.uNL, new Object[]{com.tencent.mm.wallet_core.ui.e.HD(vVar.pLs)}));
                            this.pOB.setVisibility(0);
                            this.pOC.setText(getString(i.uNm, new Object[]{com.tencent.mm.wallet_core.ui.e.HD(vVar.pLw)}));
                            this.pOC.setVisibility(0);
                            break;
                        case 2002:
                        case 2003:
                            if (i3 != 2003 || equals) {
                                this.pOx.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uGF);
                                if (!bh.ov(charSequence)) {
                                    this.pOy.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this, charSequence, (int) this.pOy.getTextSize(), bundle));
                                    this.pOy.setOnTouchListener(new l());
                                } else if (equals) {
                                    this.pOy.setText(i.uNz);
                                } else {
                                    this.pOy.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, ax(this.paO, true) + getString(i.uNz), this.pOy.getTextSize()));
                                }
                            } else {
                                this.pOx.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uGG);
                                if (bh.ov(charSequence)) {
                                    this.pOy.setText(i.uNB);
                                } else {
                                    this.pOy.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this, charSequence, (int) this.pOy.getTextSize(), bundle));
                                    this.pOy.setOnTouchListener(new l());
                                }
                            }
                            if (equals) {
                                this.ogW.setVisibility(8);
                            } else {
                                if (!bh.ov(charSequence2)) {
                                    this.ogW.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this, charSequence2, (int) this.ogW.getTextSize(), bundle));
                                    this.ogW.setOnTouchListener(new l());
                                } else if ("CFT".equals(vVar.paX) || "LQT".equals(vVar.paX)) {
                                    final boolean equals2 = "LQT".equals(vVar.paX);
                                    string2 = equals2 ? getString(i.uNt) : getString(i.uNr);
                                    string = equals2 ? getString(i.uNj) : getString(i.uNi);
                                    spannableString = new SpannableString(string2 + string);
                                    com.tencent.mm.plugin.order.c.a aVar3 = new com.tencent.mm.plugin.order.c.a(this);
                                    aVar3.pdj = new com.tencent.mm.plugin.order.c.a.a(this) {
                                        final /* synthetic */ RemittanceDetailUI pOO;

                                        public final void onClick(View view) {
                                            if (equals2) {
                                                d.y(this.pOO, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                                            } else {
                                                com.tencent.mm.pluginsdk.wallet.h.Y(this.pOO, 0);
                                            }
                                        }
                                    };
                                    spannableString.setSpan(aVar3, string2.length(), string.length() + string2.length(), 33);
                                    this.ogW.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.ogW.setText(spannableString);
                                } else {
                                    this.ogW.setText(i.uNs);
                                }
                                this.ogW.setVisibility(0);
                            }
                            this.pOB.setText(getString(i.uNL, new Object[]{com.tencent.mm.wallet_core.ui.e.HD(vVar.pLs)}));
                            this.pOB.setVisibility(0);
                            this.pOC.setText(getString(i.uNp, new Object[]{com.tencent.mm.wallet_core.ui.e.HD(vVar.pLw)}));
                            this.pOC.setVisibility(0);
                            break;
                        case TXLiveConstants.PLAY_EVT_PLAY_BEGIN /*2004*/:
                            if (equals) {
                                this.pOx.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uGH);
                                if (bh.ov(charSequence) || bh.ov(charSequence2)) {
                                    if (bh.ov(vVar.pLx)) {
                                        this.pOy.setText(i.uNy);
                                    } else {
                                        this.pOy.setText(vVar.pLx);
                                    }
                                    if (bh.ov(vVar.pLy)) {
                                        this.ogW.setText(i.uNo);
                                    } else {
                                        this.ogW.setText(vVar.pLy);
                                    }
                                } else {
                                    this.pOy.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this, charSequence, (int) this.pOy.getTextSize(), bundle));
                                    this.ogW.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this, charSequence2, (int) this.ogW.getTextSize(), bundle));
                                    this.pOy.setOnTouchListener(new l());
                                    this.ogW.setOnTouchListener(new l());
                                }
                            } else {
                                this.pOx.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uGH);
                                if (bh.ov(charSequence) || bh.ov(charSequence2)) {
                                    if (!bh.ov(vVar.pLx)) {
                                        try {
                                            this.pOy.setText(String.format(vVar.pLx, new Object[]{ax(this.paO, true)}));
                                        } catch (Throwable e) {
                                            x.printErrStackTrace("MicroMsg.RemittanceDetailUI", e, "", new Object[0]);
                                        }
                                        if (bh.ov(vVar.pLy)) {
                                            this.ogW.setText(vVar.pLy);
                                        } else {
                                            this.ogW.setText("");
                                        }
                                    }
                                    this.pOy.setText(getString(i.uNA, new Object[]{ax(this.paO, true)}));
                                    if (bh.ov(vVar.pLy)) {
                                        this.ogW.setText("");
                                    } else {
                                        this.ogW.setText(vVar.pLy);
                                    }
                                } else {
                                    this.pOy.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this, charSequence, (int) this.pOy.getTextSize(), bundle));
                                    this.ogW.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this, charSequence2, (int) this.ogW.getTextSize(), bundle));
                                    this.pOy.setOnTouchListener(new l());
                                    this.ogW.setOnTouchListener(new l());
                                }
                            }
                            this.pOB.setText(getString(i.uNL, new Object[]{com.tencent.mm.wallet_core.ui.e.HD(vVar.pLs)}));
                            this.pOB.setVisibility(0);
                            this.pOC.setText(getString(i.uNm, new Object[]{com.tencent.mm.wallet_core.ui.e.HD(vVar.pLw)}));
                            this.pOC.setVisibility(0);
                            break;
                        case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                            this.pOx.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uGD);
                            if (bh.ov(charSequence) || bh.ov(charSequence2)) {
                                if (bh.ov(vVar.pLx)) {
                                    this.pOy.setText(i.uNw);
                                } else {
                                    this.pOy.setText(vVar.pLx);
                                }
                                if (bh.ov(vVar.pLy)) {
                                    if (equals) {
                                        this.ogW.setText(i.uNn);
                                    } else {
                                        this.ogW.setText(i.uNH);
                                    }
                                } else if ("CFT".equals(vVar.paX) || "LQT".equals(vVar.paX)) {
                                    equals = "LQT".equals(vVar.paX);
                                    Object obj = vVar.pLy;
                                    charSequence = equals ? getString(i.uNj) : getString(i.uNi);
                                    spannableString = new SpannableStringBuilder();
                                    spannableString.append(obj);
                                    spannableString.append(charSequence);
                                    com.tencent.mm.plugin.order.c.a aVar4 = new com.tencent.mm.plugin.order.c.a(this);
                                    aVar4.pdj = new 7(this, equals);
                                    spannableString.setSpan(aVar4, obj.length(), spannableString.length(), 18);
                                    this.ogW.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.ogW.setText(spannableString);
                                } else {
                                    this.ogW.setText(vVar.pLy);
                                }
                            } else {
                                this.pOy.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this, charSequence, (int) this.pOy.getTextSize(), bundle));
                                this.ogW.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this, charSequence2, (int) this.ogW.getTextSize(), bundle));
                                this.pOy.setOnTouchListener(new l());
                                this.ogW.setOnTouchListener(new l());
                            }
                            this.pOB.setText(getString(i.uNL, new Object[]{com.tencent.mm.wallet_core.ui.e.HD(vVar.pLs)}));
                            this.pOB.setVisibility(0);
                            if (vVar.pLw <= 0) {
                                this.pOC.setVisibility(8);
                                break;
                            }
                            this.pOC.setText(getString(i.uNh, new Object[]{com.tencent.mm.wallet_core.ui.e.HD(vVar.pLw)}));
                            this.pOC.setVisibility(0);
                            break;
                            break;
                        default:
                            finish();
                            break;
                    }
                    if (!bh.ov(vVar.pLA)) {
                        com.tencent.mm.wallet_core.ui.e.a((TextView) findViewById(f.ufy), "7", vVar.pLA, vVar.pLB);
                    }
                }
                this.pOL = vVar.pLz;
                g.Dk();
                this.pMl = (String) g.Dj().CU().get(w.a.xtr, "");
                g.Dk();
                this.pMm = ((Integer) g.Dj().CU().get(w.a.xts, Integer.valueOf(0))).intValue();
                if (bh.ov(this.pMl)) {
                    ad.a(true, this.zIY);
                } else {
                    ad.a(false, this.zIY);
                }
                bnL();
                if (vVar.pbh == 1) {
                    g.Dk();
                    if (((String) g.Dj().CU().get(327729, "0")).equals("0")) {
                        com.tencent.mm.ui.base.h.a(this.mController.xIM, q.Gf() ? i.uId : i.uWb, i.uWc, new 9(this));
                        g.Dk();
                        g.Dj().CU().set(327729, "1");
                    } else if (this.pOL == 0) {
                        com.tencent.mm.ui.base.h.bu(this.mController.xIM, getString(i.uNk));
                    }
                }
                return true;
            }
        } else if (kVar instanceof s) {
            if (i == 0 && i2 == 0) {
                this.pOM = (s) kVar;
                if ("confirm".equals(this.pOM.pKH)) {
                    vv(1);
                } else {
                    ay(0, getString(i.uNl));
                }
                return true;
            } else if (i2 == 416) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("realname_verify_process_jump_plugin", "remittance");
                bundle2.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
                return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, i2, kVar, bundle2, 1008);
            } else {
                ay(i2, str);
                return true;
            }
        } else if (kVar instanceof ad) {
            if (i == 0 && i2 == 0) {
                this.pMl = ((ad) kVar).sIW;
                this.pMm = ((ad) kVar).sIX;
                bnL();
            } else {
                x.i("MicroMsg.RemittanceDetailUI", "net error");
            }
            return true;
        }
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.e) {
            return true;
        }
        return false;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uEa;
    }

    public final void ay(int i, String str) {
        Intent intent = new Intent();
        intent.putExtra("result_msg", str);
        setResult(i, intent);
        finish();
    }

    public void finish() {
        Bundle bundle = new Bundle();
        bundle.putString("realname_verify_process_jump_plugin", "remittance");
        bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
        if (this.pOM == null || !com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) this, this.pOM, bundle, true, null, 1008, 1)) {
            super.finish();
        } else {
            this.pOM = null;
        }
    }

    public static String ax(String str, boolean z) {
        String gu = com.tencent.mm.wallet_core.ui.e.gu(str);
        if (gu == null) {
            return "";
        }
        if (gu.length() <= 10 || !z) {
            return gu;
        }
        return gu.substring(0, 8) + "...";
    }
}
