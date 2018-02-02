package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.aa.a.c.f;
import com.tencent.mm.plugin.aa.a.c.g;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.protocal.c.t;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PaylistAAUI extends BaseAAPresenterActivity {
    private String fEp;
    private String fpQ;
    private View iiH;
    private Dialog iib = null;
    private g ijY = ((g) q(g.class));
    private f ijZ = ((f) t(f.class));
    private LinearLayout ika;
    private LinearLayout ikb;
    private LinearLayout ikc;
    private WalletTextView ikd;
    private Button ike;
    private TextView ikf;
    private TextView ikg;
    private TextView ikh;
    private TextView iki;
    private String ikj;
    private String ikk;
    private String ikl;
    private int ikm;
    private String ikn;
    private long iko;
    private String title;

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, long j) {
        paylistAAUI.iib = com.tencent.mm.wallet_core.ui.g.a(paylistAAUI, false, null);
        double d = bh.getDouble(paylistAAUI.ikd.getText().toString(), 0.0d);
        com.tencent.mm.vending.g.g.cp(Long.valueOf(j)).b(paylistAAUI.ijY.ihG).e(new 2(paylistAAUI)).a(new 15(paylistAAUI));
        com.tencent.mm.plugin.report.service.g.pQN.h(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(9)});
        com.tencent.mm.plugin.report.service.g.pQN.h(13723, new Object[]{Integer.valueOf(3), Integer.valueOf(h.oA(paylistAAUI.ikk).size()), Integer.valueOf(paylistAAUI.ikm), Double.valueOf(d * 100.0d), paylistAAUI.title});
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, o oVar) {
        boolean z = paylistAAUI.getIntent().getIntExtra("enter_scene", 0) == 1;
        paylistAAUI.ikj = oVar.ods;
        paylistAAUI.fEp = oVar.fEn;
        paylistAAUI.ikn = oVar.vCY;
        paylistAAUI.fpQ = oVar.vDr;
        String str = paylistAAUI.ikj;
        String str2 = oVar.pKT;
        String str3 = paylistAAUI.ikl;
        x.d("MicroMsg.AAUtil", "startAAPay, reqKey: %s, isFromChatting: %s", new Object[]{str, Boolean.valueOf(z)});
        PayInfo payInfo = new PayInfo();
        payInfo.fuH = str;
        payInfo.fCV = 42;
        if (z) {
            payInfo.fCR = 14;
        } else {
            payInfo.fCR = 1;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str3);
        payInfo.vzx = bundle;
        com.tencent.mm.pluginsdk.wallet.h.a(paylistAAUI, false, "", payInfo, str2, new Intent(), 233);
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, v vVar) {
        String str = vVar.vDv;
        String str2 = vVar.title;
        double d = ((double) vVar.vDw) / 100.0d;
        b.o((ImageView) paylistAAUI.findViewById(a.f.usW), str);
        TextView textView = (TextView) paylistAAUI.findViewById(a.f.utf);
        CharSequence string = paylistAAUI.getString(i.uMq, new Object[]{str2, Double.valueOf(d)});
        if (vVar.type == 2 && vVar.vDJ > vVar.vDw) {
            string = paylistAAUI.getString(i.uMr, new Object[]{str2, Double.valueOf(((double) vVar.vDJ) / 100.0d), Double.valueOf(((double) vVar.vDw) / 100.0d)});
        }
        x.i("MicroMsg.PaylistAAUI", "tftest: cs: %s", new Object[]{string});
        try {
            textView.setText(com.tencent.mm.pluginsdk.ui.d.i.a(paylistAAUI.mController.xIM, string));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.PaylistAAUI", e, "", new Object[0]);
        }
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, String str) {
        if (paylistAAUI.iib != null) {
            paylistAAUI.iib.dismiss();
            paylistAAUI.iib = null;
        }
        if (bh.ov(str)) {
            Toast.makeText(paylistAAUI, i.uGW, 1).show();
        } else {
            Toast.makeText(paylistAAUI, str, 1).show();
        }
    }

    static /* synthetic */ void b(PaylistAAUI paylistAAUI) {
        if (paylistAAUI.iib != null) {
            paylistAAUI.iib.dismiss();
        }
        paylistAAUI.iib = com.tencent.mm.wallet_core.ui.g.a(paylistAAUI, false, null);
        com.tencent.mm.vending.g.g.czW().b(paylistAAUI.ijY.ihK).e(new 6(paylistAAUI)).a(new 5(paylistAAUI));
        com.tencent.mm.plugin.report.service.g.pQN.h(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(8)});
    }

    static /* synthetic */ void b(PaylistAAUI paylistAAUI, v vVar) {
        if (vVar.state == com.tencent.mm.plugin.aa.a.a.ifO) {
            paylistAAUI.ikf.setText(i.uMp);
            paylistAAUI.ikf.setTextColor(paylistAAUI.getResources().getColor(c.btB));
        } else if (vVar.state == com.tencent.mm.plugin.aa.a.a.ifP) {
            paylistAAUI.ikf.setText(i.uMn);
            paylistAAUI.ikf.setTextColor(paylistAAUI.getResources().getColor(c.btB));
            if (vVar.type != 2 || vVar.vDJ <= vVar.vDw) {
                paylistAAUI.ikg.setVisibility(8);
                return;
            }
            paylistAAUI.ikg.setText(paylistAAUI.getString(i.uMu, new Object[]{Double.valueOf(((double) vVar.vDy) / 100.0d)}));
            paylistAAUI.ikg.setVisibility(0);
        } else if (vVar.vDh == com.tencent.mm.plugin.aa.a.a.ifS) {
            paylistAAUI.ikb.setVisibility(8);
            paylistAAUI.ika.setVisibility(0);
            paylistAAUI.ikf.setText(paylistAAUI.getString(i.uMs));
            paylistAAUI.ikf.setTextColor(paylistAAUI.getResources().getColor(c.ubg));
        } else if (vVar.vDh == com.tencent.mm.plugin.aa.a.a.ifR) {
            paylistAAUI.ikb.setVisibility(8);
            paylistAAUI.ika.setVisibility(0);
            if (vVar.vDC == com.tencent.mm.plugin.aa.a.a.ifV) {
                paylistAAUI.ikf.setText(paylistAAUI.getString(i.uMo));
                paylistAAUI.ikf.setTextColor(paylistAAUI.getResources().getColor(c.ubg));
            } else if (vVar.vDC == com.tencent.mm.plugin.aa.a.a.ifU) {
                paylistAAUI.ikf.setText(paylistAAUI.getString(i.uMu, new Object[]{Double.valueOf(((double) vVar.vDy) / 100.0d)}));
            } else if (vVar.vDC == com.tencent.mm.plugin.aa.a.a.ifT) {
                paylistAAUI.ikf.setText(i.uMv);
            } else {
                x.e("MicroMsg.PaylistAAUI", "unhandled state, state: %s, type: %s, role: %s", new Object[]{Integer.valueOf(vVar.state), Integer.valueOf(vVar.type), Integer.valueOf(vVar.vDh)});
                paylistAAUI.ikf.setVisibility(8);
            }
        } else if (vVar.vDh == com.tencent.mm.plugin.aa.a.a.ifQ) {
            for (t tVar : vVar.vDb) {
                if (tVar.vDs.equals(q.FS())) {
                    break;
                }
            }
            x.i("MicroMsg.AAUtil", "not contains self");
            t tVar2 = null;
            if (vVar.vDC == com.tencent.mm.plugin.aa.a.a.ifX || (r0 != null && r0.vDu == com.tencent.mm.plugin.aa.a.a.ifX)) {
                CharSequence format = String.format("%.2f", new Object[]{Double.valueOf(((double) vVar.vDD) / 100.0d)});
                CharSequence string = paylistAAUI.getString(i.uMm);
                paylistAAUI.iko = vVar.vDD;
                int i = vVar.state;
                paylistAAUI.ikb.setVisibility(0);
                paylistAAUI.ika.setVisibility(8);
                paylistAAUI.ike = (Button) paylistAAUI.ikb.findViewById(a.f.utc);
                if (i == com.tencent.mm.plugin.aa.a.a.ifO || i == com.tencent.mm.plugin.aa.a.a.ifP) {
                    paylistAAUI.ike.setVisibility(8);
                }
                paylistAAUI.ike.setOnClickListener(new 14(paylistAAUI));
                paylistAAUI.ikd = (WalletTextView) paylistAAUI.findViewById(a.f.urN);
                TextView textView = (TextView) paylistAAUI.ikb.findViewById(a.f.ute);
                paylistAAUI.ikd.mPrefix = u.cBD();
                paylistAAUI.ikd.setText(format);
                textView.setText(string);
            } else if (vVar.vDC == com.tencent.mm.plugin.aa.a.a.ifY || (r0 != null && r0.vDu == com.tencent.mm.plugin.aa.a.a.ifY)) {
                paylistAAUI.ikb.setVisibility(8);
                paylistAAUI.ika.setVisibility(0);
                paylistAAUI.ikf.setText(paylistAAUI.getString(i.uMt, new Object[]{Double.valueOf(((double) vVar.vDD) / 100.0d)}));
                paylistAAUI.ikf.setTextColor(paylistAAUI.getResources().getColor(c.ubg));
            } else {
                x.e("MicroMsg.PaylistAAUI", "unhandled state, state: %s, type: %s, role: %s", new Object[]{Integer.valueOf(vVar.state), Integer.valueOf(vVar.type), Integer.valueOf(vVar.vDh)});
                paylistAAUI.ikb.setVisibility(8);
                paylistAAUI.ikf.setVisibility(8);
            }
        }
    }

    static /* synthetic */ void c(PaylistAAUI paylistAAUI, v vVar) {
        View findViewById = paylistAAUI.findViewById(a.f.divider);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Iterator it = vVar.vDb.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            if (tVar.vDu == com.tencent.mm.plugin.aa.a.a.ifX) {
                arrayList2.add(tVar);
            } else {
                arrayList.add(tVar);
            }
        }
        if (arrayList2.isEmpty()) {
            paylistAAUI.a(arrayList, paylistAAUI.getString(i.uMj, new Object[]{Integer.valueOf(arrayList.size())}), E(vVar.vDh, vVar.vDC, vVar.state));
            paylistAAUI.ikc.setVisibility(8);
            findViewById.setVisibility(4);
            return;
        }
        paylistAAUI.a(arrayList2, paylistAAUI.getString(i.uMi, new Object[]{Integer.valueOf(arrayList2.size())}), E(vVar.vDh, vVar.vDC, vVar.state));
        if (arrayList.isEmpty()) {
            paylistAAUI.ikc.setVisibility(8);
            findViewById.setVisibility(4);
            return;
        }
        String string = paylistAAUI.getString(i.uMj, new Object[]{Integer.valueOf(arrayList.size())});
        int i = vVar.vDh;
        i = vVar.vDC;
        i = vVar.state;
        paylistAAUI.e(arrayList, string);
    }

    static /* synthetic */ void e(PaylistAAUI paylistAAUI, v vVar) {
        if (vVar.vDh == com.tencent.mm.plugin.aa.a.a.ifR && vVar.vDv.equals(q.FS())) {
            paylistAAUI.iki.setVisibility(0);
        } else {
            paylistAAUI.iki.setVisibility(8);
        }
        if (paylistAAUI.iki.getVisibility() != 0) {
            x.i("MicroMsg.PaylistAAUI", "no need to show bottom tv");
        } else if (bh.ov(vVar.vDH)) {
            x.i("MicroMsg.PaylistAAUI", "wording is null");
        } else {
            CharSequence spannableStringBuilder = new SpannableStringBuilder(vVar.vDH);
            if (vVar.vDI == 1) {
                paylistAAUI.iki.setClickable(true);
                paylistAAUI.iki.setOnTouchListener(new l(paylistAAUI));
                spannableStringBuilder.setSpan(new a(new 11(paylistAAUI)), 0, spannableStringBuilder.length(), 18);
            }
            paylistAAUI.iki.setText(spannableStringBuilder);
            paylistAAUI.getWindow().getDecorView().post(new 12(paylistAAUI));
        }
    }

    static /* synthetic */ void h(PaylistAAUI paylistAAUI) {
        if (paylistAAUI.iib != null) {
            paylistAAUI.iib.dismiss();
        }
        paylistAAUI.iib = com.tencent.mm.wallet_core.ui.g.a(paylistAAUI, false, null);
        com.tencent.mm.vending.g.g.czW().b(paylistAAUI.ijY.ihJ).e(new 4(paylistAAUI)).a(new 3(paylistAAUI));
        com.tencent.mm.plugin.report.service.g.pQN.h(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(6)});
    }

    static /* synthetic */ void k(PaylistAAUI paylistAAUI) {
        Intent intent = new Intent();
        intent.putExtra("close_aa", true);
        intent.putExtra("item_position", paylistAAUI.getIntent().getIntExtra("item_position", 0));
        intent.putExtra("item_offset", paylistAAUI.getIntent().getIntExtra("item_offset", 0));
        paylistAAUI.setResult(-1, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        setMMTitle(i.uJG);
        this.ikk = getIntent().getStringExtra("chatroom");
        this.ika = (LinearLayout) findViewById(a.f.utk);
        this.ikb = (LinearLayout) findViewById(a.f.utd);
        this.ikc = (LinearLayout) findViewById(a.f.usX);
        this.ikf = (TextView) findViewById(a.f.utl);
        this.ikg = (TextView) findViewById(a.f.utb);
        this.iiH = findViewById(a.f.cIw);
        this.ikh = (TextView) findViewById(a.f.utm);
        this.ikh.setClickable(true);
        this.ikh.setOnTouchListener(new l(this));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(getString(i.uMw));
        spannableStringBuilder.setSpan(new a(new 8(this)), 0, spannableStringBuilder.length(), 18);
        this.ikh.setText(spannableStringBuilder);
        this.iki = (TextView) findViewById(a.f.uta);
        Xk();
    }

    private void Xk() {
        this.iib = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
        this.iiH.setVisibility(4);
        com.tencent.mm.vending.g.g.czW().b(this.ijY.ihF).e(new 10(this)).a(new 9(this));
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private static boolean E(int i, int i2, int i3) {
        return i == com.tencent.mm.plugin.aa.a.a.ifR && i2 != com.tencent.mm.plugin.aa.a.a.ifV && i3 == com.tencent.mm.plugin.aa.a.a.ifN;
    }

    private void a(List<t> list, String str, boolean z) {
        ((TextView) findViewById(a.f.utn)).setText(str);
        this.ikh.setVisibility(z ? 0 : 8);
        LinearLayout linearLayout = (LinearLayout) findViewById(a.f.uto);
        linearLayout.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            boolean z2;
            t tVar = (t) list.get(i);
            if (i >= list.size() - 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            a(linearLayout, tVar, z2);
        }
    }

    private void e(List<t> list, String str) {
        ((TextView) findViewById(a.f.usY)).setText(str);
        LinearLayout linearLayout = (LinearLayout) findViewById(a.f.usZ);
        linearLayout.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            boolean z;
            t tVar = (t) list.get(i);
            if (i >= list.size() - 1) {
                z = true;
            } else {
                z = false;
            }
            a(linearLayout, tVar, z);
        }
    }

    private void a(LinearLayout linearLayout, t tVar, boolean z) {
        LinearLayout linearLayout2 = (LinearLayout) getLayoutInflater().inflate(a.g.uDj, linearLayout, false);
        ImageView imageView = (ImageView) linearLayout2.findViewById(a.f.uth);
        TextView textView = (TextView) linearLayout2.findViewById(a.f.uti);
        TextView textView2 = (TextView) linearLayout2.findViewById(a.f.utj);
        View findViewById = linearLayout2.findViewById(a.f.divider);
        if (z) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        b.a(imageView, tVar.vDs);
        Context context = this.mController.xIM;
        com.tencent.mm.vending.app.a aVar = this.ijZ;
        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(context, ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.a.b.class)).L(tVar.vDs, aVar.zAZ.getStringExtra("chatroom")), textView.getTextSize()));
        if (tVar.vDu == com.tencent.mm.plugin.aa.a.a.ifY) {
            textView2.setText(getString(i.uMt, new Object[]{Double.valueOf(((double) tVar.vDf) / 100.0d)}));
            textView2.setTextColor(getResources().getColor(c.ubg));
            textView2.setVisibility(0);
            linearLayout.addView(linearLayout2);
        } else if (tVar.vDu == com.tencent.mm.plugin.aa.a.a.ifX) {
            textView2.setText(getString(i.uMl, new Object[]{Double.valueOf(((double) tVar.vDf) / 100.0d)}));
            textView2.setTextColor(getResources().getColor(c.ubh));
            textView2.setVisibility(0);
            linearLayout.addView(linearLayout2);
        } else {
            textView2.setVisibility(8);
            linearLayout.addView(linearLayout2);
        }
    }

    protected final int getLayoutId() {
        return a.g.uDk;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Intent intent2;
        String stringExtra;
        if (i == 233) {
            if (i2 == -1) {
                x.i("MicroMsg.PaylistAAUI", "pay success, payMsgId: %s", new Object[]{this.fEp});
                RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                if (realnameGuideHelper != null) {
                    x.i("MicroMsg.PaylistAAUI", "do realname guide");
                    intent2 = new Intent();
                    intent2.putExtra("key_realname_guide_helper", realnameGuideHelper);
                    d.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", intent2);
                }
                h.oB(this.ikk);
                finish();
                com.tencent.mm.vending.g.g.a(this.fEp, this.ikl, this.ikn).b(this.ijY.ihH).e(new 7(this));
                com.tencent.mm.plugin.report.service.g.pQN.a(407, 12, 1, false);
                stringExtra = intent.getStringExtra("key_trans_id");
                com.tencent.mm.vending.c.a aVar = this.ijY.ihI;
                long j = this.iko;
                com.tencent.mm.vending.g.g.a(Long.valueOf(j), this.fpQ, stringExtra).b(aVar);
            }
        } else if (i == 222 && i2 == -1) {
            stringExtra = intent.getStringExtra("Select_Conv_User");
            x.i("MicroMsg.PaylistAAUI", "select chatroom：%s", new Object[]{stringExtra});
            if (!bh.ov(stringExtra)) {
                intent2 = new Intent(this.mController.xIM, LaunchAAUI.class);
                intent2.putExtra("enter_scene", 3);
                intent2.putExtra("chatroom_name", stringExtra);
                startActivity(intent2);
            }
        }
    }
}
