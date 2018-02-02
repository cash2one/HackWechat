package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.ComponentName;
import android.net.Uri;
import android.os.IBinder;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.ui.tools.widget.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.e.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;

public class b extends e {

    private class a extends c {
        final /* synthetic */ b tFq;

        private a(b bVar) {
            this.tFq = bVar;
            super(bVar);
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x.i("MicroMsg.GameFloatWebViewClient", "onServiceConnected");
            if (this.tFq.juE == null) {
                x.e("MicroMsg.GameFloatWebViewClient", "onServiceConnected, activity destroyed");
                return;
            }
            try {
                this.tFq.tFi = com.tencent.mm.plugin.webview.stub.d.a.X(iBinder);
                this.tFq.tFi.a(this.tFq.tKo, this.tFq.juE.hashCode());
                this.tFq.bUP();
                this.tFq.a(this.tFq.tFi, this.tFq.tGR);
                this.tFq.bUf();
            } catch (Exception e) {
                x.e("MicroMsg.GameFloatWebViewClient", "addCallback fail, ex = %s", new Object[]{e.getMessage()});
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            super.onServiceDisconnected(componentName);
        }
    }

    public b(MMWebView mMWebView) {
        super(mMWebView, false);
        this.tKn = new a();
    }

    protected boolean Py(String str) {
        return super.Py(str);
    }

    protected final void bUf() {
        try {
            this.tFi.a(this.tKf, true, null);
        } catch (Exception e) {
            x.w("MicroMsg.GameFloatWebViewClient", "postBinded, jumpToActivity, ex = " + e.getMessage());
        }
        if (!PM(this.tKf)) {
            Uri parse = Uri.parse(this.tKf);
            if (parse.getScheme() == null) {
                this.tKf += "http://";
                parse = Uri.parse(this.tKf);
            }
            if (parse.getScheme().startsWith("http")) {
                x.i("MicroMsg.GameFloatWebViewClient", "uri scheme not startwith http, scheme = " + parse.getScheme());
                this.tKd = new com.tencent.mm.plugin.webview.ui.tools.widget.e.a(this.tKj ? "" : this.tKf);
                this.tKj = false;
                if (!this.mZk && !this.tGR.has(this.tKf)) {
                    if (Pl(this.tKf)) {
                        BO(this.tKf);
                        this.mZd = this.tKf;
                    }
                    aR(this.tKf, false);
                } else if (!aa.Oj(this.tKf)) {
                    x.f("MicroMsg.GameFloatWebViewClient", "loadInitialUrl, canLoadUrl fail, url = " + this.tKf);
                    Pz(this.tKf);
                } else if (Pl(this.tKf)) {
                    BO(this.tKf);
                } else {
                    this.juE.loadUrl(this.tKf);
                }
            } else if (aa.Oj(this.tKf)) {
                this.juE.loadUrl(this.tKf);
            } else {
                Pz(this.tKf);
            }
        }
    }
}
