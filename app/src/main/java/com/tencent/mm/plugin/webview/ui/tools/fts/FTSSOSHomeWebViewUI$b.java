package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.37;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i$a;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class FTSSOSHomeWebViewUI$b extends d {
    c tDA = new c(this, (byte) 0);
    final /* synthetic */ FTSSOSHomeWebViewUI tDo;
    c tDx = new a();
    c tDy = new d(this, (byte) 0);
    c tDz = new b(this, (byte) 0);

    private class a extends b {
        final /* synthetic */ FTSSOSHomeWebViewUI$b tDB;

        private a(FTSSOSHomeWebViewUI$b fTSSOSHomeWebViewUI$b) {
            this.tDB = fTSSOSHomeWebViewUI$b;
        }

        public final void enter() {
            super.enter();
            FTSSOSHomeWebViewUI.F(this.tDB.tDo);
        }

        public final void exit() {
            super.exit();
            FTSSOSHomeWebViewUI.G(this.tDB.tDo).setBackgroundColor(this.tDB.tDo.getResources().getColor(R.e.transparent));
            this.tDB.tDo.tCg.Gy(8);
        }

        public final boolean j(Message message) {
            switch (message.what) {
                case 0:
                case 13:
                    if (this.tDB.tDo.bTC().length() > 0) {
                        this.tDB.tDo.bTy().cxd();
                        this.tDB.tDo.bTy().yig.clearFocus();
                        FTSSOSHomeWebViewUI.d(this.tDB.tDo, 0);
                        FTSSOSHomeWebViewUI.H(this.tDB.tDo).AV(a.b.tEF);
                        FTSSOSHomeWebViewUI.g(this.tDB.tDo, a.b.tEF);
                        this.tDB.tDo.tCf.setBackgroundResource(R.e.white);
                        FTSSOSHomeWebViewUI.z(this.tDB.tDo).clear();
                        break;
                    }
                    break;
                case 1:
                    this.tDB.tDo.bTy().cxd();
                    FTSSOSHomeWebViewUI.I(this.tDB.tDo).AV(a.b.tEF);
                    FTSSOSHomeWebViewUI.g(this.tDB.tDo, a.b.tEF);
                    this.tDB.tDo.tCf.setBackgroundResource(R.e.white);
                    FTSSOSHomeWebViewUI.z(this.tDB.tDo).clear();
                    FTSSOSHomeWebViewUI.J(this.tDB.tDo);
                    break;
                case 3:
                    this.tDB.tDo.tCk = true;
                    this.tDB.b(this.tDB.tDy);
                    break;
                case 4:
                    this.tDB.tDo.tCk = true;
                    this.tDB.b(this.tDB.tDz);
                    break;
                case 5:
                    if (this.tDB.tDo.bTy().yig.hasFocus() && this.tDB.tDo.bTC().length() > 0) {
                        FTSSOSHomeWebViewUI.A(this.tDB.tDo);
                    }
                    if (this.tDB.tDo.bTy().yig.hasFocus() && this.tDB.tDo.bTC().length() == 0) {
                        this.tDB.tDo.bTy().cxd();
                        FTSSOSHomeWebViewUI.I(this.tDB.tDo).AV(a.b.tEF);
                        FTSSOSHomeWebViewUI.g(this.tDB.tDo, a.b.tEF);
                        this.tDB.tDo.tCf.setBackgroundResource(R.e.white);
                        FTSSOSHomeWebViewUI.z(this.tDB.tDo).clear();
                        this.tDB.tDo.G(new Runnable(this) {
                            final /* synthetic */ a tDC;

                            {
                                this.tDC = r1;
                            }

                            public final void run() {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d K = FTSSOSHomeWebViewUI.K(this.tDC.tDB.tDo);
                                if (K.tGQ) {
                                    x.i("MicroMsg.JsApiHandler", "onFocusSearchInput success, ready");
                                    ag.y(new 37(K, i$a.a("onFocusSearchInput", null, K.tGS, K.tGT)));
                                    return;
                                }
                                x.e("MicroMsg.JsApiHandler", "onFocusSearchInput fail, not ready");
                            }
                        });
                        break;
                    }
                case 14:
                    this.tDB.tDo.bTy().cxd();
                    this.tDB.tDo.bTy().yig.clearFocus();
                    FTSSOSHomeWebViewUI.d(this.tDB.tDo, 0);
                    FTSSOSHomeWebViewUI.H(this.tDB.tDo).U(a.b.tEF, false);
                    FTSSOSHomeWebViewUI.g(this.tDB.tDo, a.b.tEF);
                    this.tDB.tDo.tCf.setBackgroundResource(R.e.white);
                    FTSSOSHomeWebViewUI.z(this.tDB.tDo).clear();
                    this.tDB.b(this.tDB.tDz);
                    this.tDB.tDo.tCk = true;
                    break;
                case 15:
                    if (FTSSOSHomeWebViewUI.c(this.tDB.tDo) != null && FTSSOSHomeWebViewUI.c(this.tDB.tDo).getVisibility() == 0) {
                        FTSSOSHomeWebViewUI.c(this.tDB.tDo).M((MotionEvent) message.obj);
                        break;
                    }
            }
            return super.j(message);
        }

        public final String getName() {
            return "InitSate";
        }
    }

    protected FTSSOSHomeWebViewUI$b(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, String str, Looper looper) {
        this.tDo = fTSSOSHomeWebViewUI;
        super(str, looper);
        a(this.tDx);
        a(this.tDy);
        a(this.tDz);
        a(this.tDA);
        b(this.tDx);
    }

    public final void bTN() {
        this.tDo.tCg.Gy(0);
        b(this.tDx);
    }

    public final void bTO() {
        this.tDo.tCg.Gy(8);
        b(this.tDz);
    }

    public final boolean bTP() {
        com.tencent.mm.sdk.d.a cgH = cgH();
        return cgH == this.tDy || cgH == this.tDz || cgH == this.tDA;
    }
}
