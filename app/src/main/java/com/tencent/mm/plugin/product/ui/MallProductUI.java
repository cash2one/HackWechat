package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.product.ui.f.1;
import com.tencent.mm.plugin.product.ui.f.2;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import java.util.List;

@a(3)
public class MallProductUI extends MallBaseUI implements j.a {
    private Button lRZ;
    private TextView lkn;
    protected c pfH;
    private HtmlTextView pfn;
    private ListView pgP;
    private a pgQ;
    private LinearLayout pgS;
    private LinearLayout pgT;
    private ImageView pgU;
    private TextView pgV;
    private HtmlTextView pgW;
    private RelativeLayout pgX;
    private ListView pgY;
    private k pgZ = null;
    private TextView pgk;
    private f pgq;
    private Button pha;

    static /* synthetic */ void d(MallProductUI mallProductUI) {
        List list = mallProductUI.pfH.pdL;
        if (list != null && list.size() > 0) {
            mallProductUI.pgZ.pgA = list;
        }
    }

    protected final int getLayoutId() {
        return g.uDI;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uD(8);
        boolean booleanExtra = getIntent().getBooleanExtra("key_go_finish", false);
        setResult(-1);
        if (booleanExtra) {
            finish();
            return;
        }
        initView();
        com.tencent.mm.plugin.product.a.a.biM();
        this.pfH = com.tencent.mm.plugin.product.a.a.biN();
        this.pgq = new f(this.mController.xIM, new 1(this));
        f fVar = this.pgq;
        com.tencent.mm.kernel.g.Dm().a(new 1(fVar, getIntent(), new m()));
        fVar.pfF = true;
        b mfVar = new mf();
        mfVar.fDU.errCode = -1;
        mfVar.fqI = new 2(fVar, mfVar);
        com.tencent.mm.sdk.b.a.xef.a(mfVar, Looper.getMainLooper());
    }

    protected void onResume() {
        super.onResume();
        this.pgq.onStart();
    }

    protected void onPause() {
        this.pgq.onStop();
        super.onPause();
    }

    protected final void initView() {
        setMMTitle(i.uLM);
        setBackBtn(new 2(this));
        this.pgS = (LinearLayout) findViewById(f.uqD);
        this.pgT = (LinearLayout) findViewById(f.uqY);
        this.pgU = (ImageView) findViewById(f.uqB);
        this.lkn = (TextView) findViewById(f.uqx);
        this.pgk = (TextView) findViewById(f.uqG);
        this.pgV = (TextView) findViewById(f.uqE);
        this.pgV.getPaint().setFlags(16);
        this.pgX = (RelativeLayout) findViewById(f.uqz);
        this.pfn = (HtmlTextView) findViewById(f.uqy);
        this.pgW = (HtmlTextView) findViewById(f.uqF);
        this.pgP = (ListView) findViewById(f.uqw);
        this.pgQ = new a(this);
        this.pgP.setAdapter(this.pgQ);
        this.pgP.setOnItemClickListener(new 3(this));
        this.pha = (Button) findViewById(f.uqQ);
        this.pha.setOnClickListener(new 4(this));
        this.pgY = (ListView) findViewById(f.uqZ);
        this.pgZ = new k(this);
        this.pgZ.pgt = new 5(this);
        this.pgY.setAdapter(this.pgZ);
        this.lRZ = (Button) findViewById(f.uqA);
        this.lRZ.setOnClickListener(new 6(this));
        addIconOptionMenu(0, e.bDI, new 7(this));
        showOptionMenu(false);
        this.pgU.setFocusable(true);
        this.pgU.setFocusableInTouchMode(true);
        this.pgU.requestFocus();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        x.v("MicroMsg.MallProductUI", "onNewIntent");
        setIntent(intent);
    }

    protected final void au() {
        m mVar = this.pfH.pdK;
        if (mVar == null) {
            showOptionMenu(false);
            return;
        }
        showOptionMenu(true);
        uD(0);
        this.pgS.setVisibility(0);
        this.pgT.setVisibility(8);
        if (mVar.peo != null) {
            this.lkn.setText(mVar.peo.name);
            this.pgk.setText(com.tencent.mm.plugin.product.b.b.l(mVar.peo.peA, mVar.peo.peB, mVar.peo.paz));
            this.pgV.setText(com.tencent.mm.plugin.product.b.b.c((double) mVar.peo.pez, mVar.peo.paz));
        }
        if (this.pfH.biY() <= 0) {
            this.lRZ.setEnabled(false);
            this.lRZ.setText(i.uLD);
        } else if (this.pfH.pdK.pen <= 0) {
            this.lRZ.setEnabled(false);
            this.lRZ.setText(i.uLC);
        } else {
            this.lRZ.setEnabled(true);
            if (bh.ov(mVar.pet)) {
                this.lRZ.setText(i.uqA);
            } else {
                this.lRZ.setText(mVar.pet);
            }
        }
        if (mVar.peo == null || mVar.peo.peK == null || mVar.peo.peK.size() <= 0) {
            this.pgP.setVisibility(8);
        } else {
            this.pgP.setVisibility(0);
            this.pgQ.bn(mVar.peo.peK);
            this.pgQ.notifyDataSetChanged();
        }
        if (mVar.peo == null || bh.ov(mVar.peo.peD)) {
            this.pgX.setVisibility(8);
            this.pfn.setVisibility(8);
        } else {
            this.pgX.setVisibility(0);
            this.pfn.setVisibility(0);
            this.pfn.setText(mVar.peo.peD);
        }
        if (bh.ov(mVar.peu)) {
            this.pgW.setVisibility(8);
        } else {
            this.pgW.setVisibility(0);
            this.pgW.setText(mVar.peu);
        }
        showOptionMenu(true);
        if (!bh.ov(this.pfH.pdS)) {
            this.pgU.setImageBitmap(j.a(new c(this.pfH.pdS)));
            j.a(this);
        }
    }

    public final void l(String str, Bitmap bitmap) {
        if (str != null && str.equals(this.pfH.pdS)) {
            this.pgU.post(new 8(this, bitmap));
        }
    }
}
