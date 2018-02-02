package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.bc.b;
import com.tencent.mm.bv.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.wcdb.FileUtils;

public class FTSSOSMoreWebViewUI extends BaseSOSWebViewUI {
    private int tCV;
    private View tDE;

    protected final void akN() {
        super.akN();
        this.tDE = findViewById(R.h.cYR);
        bTy().cxj();
        bTy().cxd();
        this.qgW.setVisibility(0);
        this.oNG.setVisibility(8);
        this.tCV = a.fromDPToPix(this, 48);
        bTy().w(b.b(getType(), this));
        if (aRr() == 24) {
            this.tDE.setVisibility(4);
        }
        findViewById(R.h.cIu).setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FTSSOSMoreWebViewUI tDF;

            {
                this.tDF = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.tDF.bTy().yig.clearFocus();
                this.tDF.aWs();
                return false;
            }
        });
        if (getIntent() != null && getIntent().getBooleanExtra("ftsneedkeyboard", false)) {
            this.mController.contentView.postDelayed(new 2(this), 128);
        }
        T(getResources().getColor(R.e.white), true);
    }

    protected final int akH() {
        if (!d.fM(23) || h.zj()) {
            return super.akH();
        }
        return getResources().getColor(R.e.white);
    }

    public final void hL(boolean z) {
        super.hL(z);
        if (z) {
            this.tCf.setPadding(0, 0, this.tCf.getPaddingRight(), 0);
            this.qgW.setVisibility(8);
        } else {
            this.tCf.setPadding(this.tCV, 0, this.tCf.getPaddingRight(), 0);
            this.qgW.setVisibility(0);
        }
        bTy().cxd();
    }

    public boolean akL() {
        bTy().cxd();
        this.tDE.setVisibility(0);
        return super.akL();
    }

    protected final int getLayoutId() {
        return R.i.dsP;
    }

    protected final void bTu() {
        finish();
    }

    protected final String getHint() {
        int i = -1;
        if (getType() != 8 || !this.tCw) {
            switch (getType()) {
                case 1:
                    i = R.l.eIQ;
                    break;
                case 2:
                    i = R.l.eIP;
                    break;
                case 8:
                    i = R.l.ekA;
                    break;
                case 16:
                    i = R.l.ekz;
                    break;
                case 64:
                    i = R.l.dDT;
                    break;
                case FileUtils.S_IWUSR /*128*/:
                    i = R.l.ekv;
                    break;
                case 256:
                case 384:
                    i = R.l.eku;
                    break;
                case WXMediaMessage.TITLE_LENGTH_LIMIT /*512*/:
                    i = R.l.ekx;
                    break;
                case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                    i = R.l.eky;
                    break;
                default:
                    break;
            }
        }
        i = R.l.ekB;
        if (i < 0) {
            return ac.getContext().getResources().getString(R.l.dGz) + AP(getType());
        }
        return ac.getContext().getResources().getString(R.l.eIO, new Object[]{ac.getContext().getResources().getString(i)});
    }

    protected final void bTv() {
        super.bTv();
        this.tDE.setVisibility(0);
    }
}
