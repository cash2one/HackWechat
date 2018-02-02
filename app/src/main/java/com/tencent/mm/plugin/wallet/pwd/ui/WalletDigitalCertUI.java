package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.pwd.a.d;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Iterator;
import java.util.Vector;

public class WalletDigitalCertUI extends WalletBaseUI {
    private ImageView jNs;
    private Button lgD;
    private TextView pJa;
    private Button sGI;
    private LinearLayout sGJ;
    private TextView sGK;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ji(1654);
        ji(1568);
        ji(1669);
        initView();
        g.pQN.h(13731, Integer.valueOf(1));
    }

    public final void initView() {
        setMMTitle(i.uTY);
        this.jNs = (ImageView) findViewById(a$f.uhv);
        this.pJa = (TextView) findViewById(a$f.uhy);
        this.sGI = (Button) findViewById(a$f.ulc);
        this.lgD = (Button) findViewById(a$f.ujh);
        this.sGJ = (LinearLayout) findViewById(a$f.ule);
        this.sGK = (TextView) findViewById(a$f.ulf);
        this.sGI.setOnClickListener(new 1(this));
        this.lgD.setOnClickListener(new 2(this));
        setBackBtn(new 3(this));
        bKx();
    }

    private void bKx() {
        x.i("MicroMsg.WalletDigitalCertUI", "updateCrtState");
        this.sGJ.removeAllViews();
        if (r.cBz().cBA()) {
            this.sGI.setVisibility(8);
            this.lgD.setVisibility(0);
            this.pJa.setText(i.uUf);
            this.jNs.setImageResource(e.udQ);
        } else {
            this.sGI.setVisibility(0);
            this.lgD.setVisibility(8);
            this.pJa.setText(i.uUa);
            this.jNs.setImageResource(e.udR);
        }
        Vector vector = r.cBz().zHO;
        if (vector.size() == 0) {
            this.sGJ.setVisibility(8);
            this.sGK.setVisibility(8);
            return;
        }
        this.sGJ.setVisibility(0);
        this.sGK.setVisibility(0);
        Iterator it = vector.iterator();
        while (it.hasNext()) {
            q qVar = (q) it.next();
            if (qVar.zHI <= 0) {
                View inflate = View.inflate(this, a.g.uEK, null);
                TextView textView = (TextView) inflate.findViewById(a$f.uhw);
                TextView textView2 = (TextView) inflate.findViewById(a$f.uji);
                ((TextView) inflate.findViewById(a$f.uhz)).setText(qVar.wWP);
                textView.setText(qVar.zHH);
                textView2.setTag(qVar);
                textView2.setOnClickListener(new 4(this));
                this.sGJ.addView(inflate);
            }
        }
        if (this.sGJ.getChildCount() == 0) {
            this.sGK.setVisibility(8);
        } else {
            this.sGK.setVisibility(0);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1654);
        jj(1568);
        jj(1669);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof d)) {
            if (kVar instanceof com.tencent.mm.wallet_core.c.e) {
                if (i2 == 0) {
                    g.pQN.h(13731, Integer.valueOf(11));
                    r.cBz().aaw(((com.tencent.mm.wallet_core.c.e) kVar).zHl);
                } else {
                    g.pQN.h(13731, Integer.valueOf(12));
                }
            }
            return false;
        }
        bKx();
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = null;
        super.onActivityResult(i, i2, intent);
        if (1 == i && i2 == -1) {
            String string;
            boolean aJW = ((l) com.tencent.mm.kernel.g.h(l.class)).aJW();
            SharedPreferences cft = ac.cft();
            if (cft != null) {
                String string2 = cft.getString("cpu_id", null);
                string = cft.getString("uid", null);
                str = string2;
            } else {
                string = null;
            }
            x.i("MicroMsg.WalletDigitalCertUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", Boolean.valueOf(aJW));
            b(new d(aJW, str, string), false);
        }
    }

    protected final int getLayoutId() {
        return a.g.uES;
    }
}
