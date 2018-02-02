package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.plugin.luckymoney.b.c;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.p;

public class LuckyMoneyIndexUI extends LuckyMoneyBaseUI {
    private int ofD;
    private LinearLayout ohN;
    private LinearLayout ohO;
    private LinearLayout ohP;

    static /* synthetic */ void a(LuckyMoneyIndexUI luckyMoneyIndexUI, int i) {
        Intent intent = new Intent();
        intent.setClass(luckyMoneyIndexUI.mController.xIM, LuckyMoneyPrepareUI.class);
        intent.putExtra("key_way", 3);
        intent.putExtra("key_type", i);
        intent.putExtra("pay_channel", luckyMoneyIndexUI.ofD);
        luckyMoneyIndexUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((b) g.h(b.class)).a(this, null);
        initView();
        b(new w("v1.0", (byte) 0), false);
        this.ofD = getIntent().getIntExtra("pay_channel", -1);
        com.tencent.mm.plugin.report.service.g.pQN.h(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
    }

    protected void onResume() {
        super.onResume();
        b bVar = (b) g.h(b.class);
        bVar.a(this, bVar.bNx(), null);
    }

    protected final void initView() {
        setMMTitle(i.uKV);
        setBackBtn(new 1(this));
        this.ohN = (LinearLayout) findViewById(f.unV);
        this.ohO = (LinearLayout) findViewById(f.unT);
        this.ohP = (LinearLayout) findViewById(f.unR);
        ((Button) findViewById(f.unU)).setOnClickListener(new 2(this));
        ((Button) findViewById(f.unS)).setOnClickListener(new 3(this));
        a(0, getString(i.uKq), new 4(this), p.b.xJG);
        aXD();
    }

    private void aXD() {
        a.aWP();
        c aXb = a.aWQ().aXb();
        if (aXb != null) {
            ImageView imageView = (ImageView) findViewById(f.udb);
            if ((aXb.obG & 1) == 1) {
                x.i("MicroMsg.LuckyMoneyIndexUI", "initView: topBg use money bg");
                imageView.setImageResource(e.udb);
                return;
            }
            imageView.setImageResource(e.udc);
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uCv;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof w)) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            w wVar = (w) kVar;
            g.c cVar = new g.c();
            cVar.textColor = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uaW);
            cVar.ojs = 101;
            g.a(this, this.ohN, wVar.ocd, cVar, "Text");
            cVar = new g.c();
            cVar.textColor = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uaW);
            cVar.ojs = 100;
            g.a(this, this.ohO, wVar.odk, cVar, "Text");
            cVar = new g.c();
            cVar.ojs = 102;
            g.a(this, this.ohP, wVar.odi, cVar, "Pic");
            aXD();
        }
        return true;
    }
}
