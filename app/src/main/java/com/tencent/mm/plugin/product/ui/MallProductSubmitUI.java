package com.tencent.mm.plugin.product.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.product.b.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.product.ui.d.1;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.biu;
import com.tencent.mm.protocal.c.ti;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ListViewInScrollView;
import java.util.ArrayList;
import java.util.List;

public class MallProductSubmitUI extends MallBaseUI implements a {
    private TextView jJn;
    private Button lRZ;
    private e pdZ;
    private c pfH;
    private RelativeLayout pgG;
    private TextView pgH;
    private TextView pgI;
    private MallProductItemView pgJ;
    private MallProductItemView pgK;
    private TextView pgL;
    private TextView pgM;
    private TextView pgN;
    private TextView pgO;
    private ListView pgP;
    private a pgQ;
    private ImageView pgj;
    private TextView pgk;
    private f pgq;

    protected final int getLayoutId() {
        return g.uDH;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pgq = new f(this.mController.xIM, new 1(this));
        com.tencent.mm.plugin.product.a.a.biM();
        this.pfH = com.tencent.mm.plugin.product.a.a.biN();
        this.pdZ = this.pfH.pdZ;
        initView();
        au();
    }

    public void onStart() {
        this.pgq.onStart();
        super.onStart();
    }

    protected void onStop() {
        this.pgq.onStop();
        super.onStop();
    }

    protected final void initView() {
        setMMTitle(i.uLL);
        this.pgG = (RelativeLayout) findViewById(f.ura);
        this.pgH = (TextView) findViewById(f.urc);
        this.pgI = (TextView) findViewById(f.urb);
        this.pgJ = (MallProductItemView) findViewById(f.urd);
        this.pgK = (MallProductItemView) findViewById(f.urf);
        this.pgj = (ImageView) findViewById(f.ure);
        this.jJn = (TextView) findViewById(f.uro);
        this.pgL = (TextView) findViewById(f.urg);
        this.pgk = (TextView) findViewById(f.urm);
        this.pgM = (TextView) findViewById(f.urk);
        this.pgN = (TextView) findViewById(f.urj);
        this.pgO = (TextView) findViewById(f.urp);
        this.pgP = (ListView) findViewById(f.urh);
        this.pgQ = new a(this);
        this.pgP.setAdapter(this.pgQ);
        this.pgP.setOnItemClickListener(new 2(this));
        this.lRZ = (Button) findViewById(f.urn);
        this.lRZ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductSubmitUI pgR;

            {
                this.pgR = r1;
            }

            public final void onClick(View view) {
                f d = this.pgR.pgq;
                if (d.pfH.bjb()) {
                    int i;
                    if (d.pfH.biS() == 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        com.tencent.mm.kernel.g.Dk();
                        n nVar = com.tencent.mm.kernel.g.Di().gPJ;
                        biu bjd = d.pfH.bjd();
                        d.pfH.getAppId();
                        nVar.a(new k(bjd), 0);
                        return;
                    }
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Di().gPJ.a(new l(d.pfH.bjd(), d.pfH.getAppId()), 0);
                }
            }
        });
        this.pgG.setOnClickListener(new 4(this));
        this.pgJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductSubmitUI pgR;

            {
                this.pgR = r1;
            }

            public final void onClick(View view) {
                this.pgR.showDialog(1);
            }
        });
        this.pgK.setOnClickListener(new 6(this));
        MallProductItemView mallProductItemView = this.pgK;
        boolean z = (this.pfH.biP().pfE & 2) > 0;
        x.d("MicroMsg.MallProductConfig", "hasReceipt, ret = " + z);
        mallProductItemView.setVisibility(z ? 0 : 8);
        if (this.pfH.biP().bjl()) {
            this.pgJ.setEnabled(false);
            this.pgJ.setClickable(false);
            this.pgJ.Hv(getString(i.uLK));
        }
    }

    private void au() {
        m mVar = this.pfH.pdK;
        if (this.pdZ != null) {
            this.pgk.setText(b.l(this.pdZ.ped, this.pdZ.ped, mVar.peo.paz) + " x " + this.pfH.mCount);
        } else {
            this.pgk.setText(b.l(mVar.peo.peA, mVar.peo.peB, mVar.peo.paz));
        }
        if (!bh.ov(this.pfH.biQ())) {
            this.pgj.setImageBitmap(j.a(new c(this.pfH.biQ())));
            j.a(this);
        }
        this.jJn.setText(mVar.peo.name);
        this.pgL.setText(this.pfH.biR());
        bbk biU = this.pfH.biU();
        if (biU == null || bh.ov(biU.ngs)) {
            this.pgK.Hv("");
        } else {
            this.pgK.Hv(biU.ngs);
        }
        String str = "";
        if (!this.pfH.biP().bjl()) {
            ti tiVar = this.pfH.pdP;
            if (tiVar != null) {
                this.pgJ.setEnabled(true);
                this.pgJ.setClickable(true);
                this.pgJ.Hv(b.a(this, tiVar));
                str = getString(i.uLI, new Object[]{b.c((double) tiVar.vPD, tiVar.waD)});
                this.pgI.setVisibility(8);
            } else {
                this.pgJ.setEnabled(false);
                this.pgJ.setClickable(false);
                this.pgJ.Hv(getString(i.uLJ));
                this.pgI.setVisibility(0);
            }
        }
        String str2 = "";
        if (this.pfH.biT() > 0) {
            bh.ov(str);
            str2 = getString(i.uLH, new Object[]{b.c((double) r3, mVar.peo.paz)});
        }
        List G = this.pfH.G(this);
        if (G.size() > 0) {
            this.pgP.setVisibility(0);
            this.pgQ.bn(G);
            this.pgQ.notifyDataSetChanged();
        } else {
            this.pgP.setVisibility(8);
        }
        if (this.pfH.pdQ != null) {
            this.pgH.setText(Html.fromHtml(String.format("%s %s<br><br>%s %s %s", new Object[]{r3.ksU, r3.vHm, r3.hvu, r3.hvv, r3.ngs})));
        }
        if (bh.ov(str + str2)) {
            this.pgN.setVisibility(0);
            this.pgM.setVisibility(8);
        } else {
            this.pgM.setText(getString(i.uLG, new Object[]{str}));
            this.pgN.setVisibility(8);
            this.pgM.setVisibility(0);
        }
        this.pgO.setText(b.c((double) this.pfH.biS(), mVar.peo.paz));
        this.lRZ.setEnabled(this.pfH.bjb());
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.pgq.onActivityResult(i, i2, intent);
    }

    public final void l(String str, Bitmap bitmap) {
        x.d("MicroMsg.MallProductSubmitUI", str + ", bitmap = " + (bitmap == null));
        if (!bh.ov(this.pfH.biQ())) {
            this.pgj.post(new 7(this, bitmap));
        }
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                List<ti> list = this.pfH.pdX;
                if (list != null) {
                    List arrayList = new ArrayList();
                    for (ti a : list) {
                        arrayList.add(b.a(this, a));
                    }
                    String string = getString(i.urd);
                    OnItemClickListener 8 = new 8(this);
                    ListAdapter aVar = new d.a(this);
                    ListViewInScrollView listViewInScrollView = (ListViewInScrollView) View.inflate(this, g.gXz, null);
                    listViewInScrollView.setOnItemClickListener(new 1(8, aVar));
                    aVar.pfy = arrayList;
                    aVar.pfz = 0;
                    listViewInScrollView.setAdapter(aVar);
                    com.tencent.mm.ui.base.i.a aVar2 = new com.tencent.mm.ui.base.i.a(this);
                    aVar2.YF(string);
                    aVar2.dk(listViewInScrollView);
                    aVar2.d(null);
                    Dialog akx = aVar2.akx();
                    akx.show();
                    return akx;
                }
                break;
        }
        return super.onCreateDialog(i);
    }
}
