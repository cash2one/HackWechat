package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.game.a.a;
import com.tencent.mm.plugin.game.c.br;
import com.tencent.mm.plugin.game.c.q;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ah;
import com.tencent.mm.plugin.game.model.bb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public class GameDownloadGuidanceUI extends GameCenterBaseUI implements e {
    private Dialog lNB;
    private LinearLayout muI;
    private br ndC;
    private boolean nnd;
    private String nne = "";
    private TextView npF;
    private TextView npG;
    private TextView npH;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(2586, this);
        initView();
        c.Dm().F(new 2(this));
    }

    protected void onDestroy() {
        x.i("MicroMsg.GameDownloadGuidanceUI", "onDestroy");
        super.onDestroy();
        a$a.nwW.clearCache();
        ar.CG().b(2586, this);
        SubCoreGameCenter.aRj().clearCache();
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        setMMTitle(R.l.enh);
        this.muI = (LinearLayout) findViewById(R.h.bYF);
        this.npF = (TextView) findViewById(R.h.cuM);
        this.npG = (TextView) findViewById(R.h.cKq);
        this.npH = (TextView) findViewById(R.h.cKj);
    }

    public final void a(ah ahVar, int i) {
        if (isFinishing()) {
            x.w("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI hasFinished");
        } else if (ahVar == null || ahVar.aQJ() == null) {
            x.e("MicroMsg.GameDownloadGuidanceUI", "Null data");
        } else {
            if (ahVar == null || ahVar.aQK() == null) {
                this.nne = "";
            } else {
                this.nne = ahVar.aQK().nfg;
            }
            if (bh.ov(this.nne)) {
                if (this.nnd) {
                    removeOptionMenu(0);
                    this.nnd = false;
                }
            } else if (!this.nnd) {
                addIconOptionMenu(0, R.k.dvc, new 4(this));
                this.nnd = true;
            }
            this.muI.setVisibility(0);
            q aQJ = ahVar.aQJ();
            if (bh.ov(aQJ.ngc)) {
                this.npF.setVisibility(8);
            } else {
                this.npF.setText(aQJ.ngc);
                this.npF.setVisibility(0);
            }
            if (bh.ov(aQJ.ngd)) {
                this.npG.setVisibility(8);
            } else {
                this.npG.setText(aQJ.ngd);
                this.npG.setVisibility(0);
            }
            if (bh.ov(aQJ.nge)) {
                this.npH.setVisibility(8);
            } else {
                this.npH.setText(aQJ.nge);
                this.npH.setVisibility(0);
            }
            if (i == 2) {
                c.Dm().F(new 3(this));
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dkv;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.GameDownloadGuidanceUI", "errType: %d errCode: %d, scene: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.hashCode())});
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 2586:
                    long currentTimeMillis = System.currentTimeMillis();
                    c.Dm().F(new 5(this, ((bb) kVar).lMW.hmh.hmo, currentTimeMillis));
                    return;
                default:
                    return;
            }
        }
        if (!a.ift.a(this, i, i2, str)) {
            Toast.makeText(this, getString(R.l.emx, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.lNB != null) {
            this.lNB.cancel();
        }
    }
}
