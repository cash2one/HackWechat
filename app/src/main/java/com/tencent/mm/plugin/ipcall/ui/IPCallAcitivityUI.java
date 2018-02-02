package com.tencent.mm.plugin.ipcall.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

@a(3)
public class IPCallAcitivityUI extends MMActivity {
    private FrameLayout nHB;
    private TextView nHC;
    private TextView nHD;
    private Button nHE;
    private CdnImageView nHF;
    private boolean nHG = false;
    private com.tencent.mm.plugin.ipcall.a.g.a nHH;

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.dmf;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.mController.hideTitleView();
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        this.nHB = (FrameLayout) findViewById(R.h.crb);
        this.nHC = (TextView) findViewById(R.h.crf);
        this.nHD = (TextView) findViewById(R.h.crc);
        this.nHE = (Button) findViewById(R.h.crd);
        this.nHF = (CdnImageView) findViewById(R.h.cre);
        ar.Hg();
        String str = (String) c.CU().get(w.a.xpI, "");
        if (bh.ov(str)) {
            x.e("MicroMsg.IPCallAcitivityUI", "xml is empty");
            finish();
        } else {
            this.nHH = com.tencent.mm.plugin.ipcall.a.g.a.CB(str);
            if (this.nHH == null) {
                x.e("MicroMsg.IPCallAcitivityUI", "mMsgInfo is null");
                finish();
            } else {
                this.nHC.setText(this.nHH.fon);
                this.nHD.setText(this.nHH.nfe);
                this.nHE.setText(this.nHH.nGF);
                this.nHF.setUrl(this.nHH.nGE);
            }
        }
        this.nHB.setOnClickListener(new 1(this));
        this.nHE.setOnClickListener(new 2(this));
        setBackBtn(new 3(this));
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.bpQ, R.a.bql);
        if (this.nHG) {
            com.tencent.mm.plugin.ipcall.a.e.c.rv(1);
        } else {
            com.tencent.mm.plugin.ipcall.a.e.c.rv(0);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
