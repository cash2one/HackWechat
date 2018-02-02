package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.b.p$a;
import com.tencent.mm.plugin.qqmail.stub.QQMailStubProxyUI;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

class ReadMailUI$a extends p$a {
    final /* synthetic */ ReadMailUI puG;
    int puO;

    public ReadMailUI$a(ReadMailUI readMailUI, int i) {
        this.puG = readMailUI;
        this.puO = i;
    }

    public final void onSuccess(String str, Map<String, String> map) {
        x.d("MicroMsg.ReadMailUI", "onSuccess userData = %d", new Object[]{Integer.valueOf(this.puO)});
        switch (this.puO) {
            case 1:
                ReadMailUI.a(this.puG, new 1(this, map));
                return;
            case 2:
                ReadMailUI.i(this.puG).post(new 2(this));
                break;
        }
        x.e("MicroMsg.ReadMailUI", "onSuccess, invalid userData = %d", new Object[]{Integer.valueOf(this.puO)});
    }

    public final void onError(final int i, final String str) {
        x.d("MicroMsg.ReadMailUI", "onError errCode = %d, userData = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.puO)});
        ReadMailUI.i(this.puG).post(new Runnable(this) {
            final /* synthetic */ ReadMailUI$a puQ;

            public final void run() {
                if (!this.puQ.puG.isFinishing()) {
                    Intent intent;
                    switch (this.puQ.puO) {
                        case 1:
                            ReadMailUI.j(this.puQ.puG).setVisibility(0);
                            if (i == -5) {
                                intent = new Intent(this.puQ.puG, QQMailStubProxyUI.class);
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                this.puQ.puG.startActivityForResult(intent, 1);
                                return;
                            }
                            if (i == -7) {
                                ReadMailUI.j(this.puQ.puG).setVisibility(8);
                                try {
                                    new ReadMailProxy(ReadMailUI.l(this.puQ.puG), null).REMOTE_CALL("replaceMsgContent", new Object[]{Long.valueOf(ReadMailUI.k(this.puQ.puG)), str});
                                } catch (Exception e) {
                                    x.w("MicroMsg.ReadMailUI", "replaceMsgContent fail, ex = %s", new Object[]{e.getMessage()});
                                }
                            }
                            if (i == -10005 && !an.isConnected(this.puQ.puG)) {
                                Toast.makeText(this.puQ.puG, this.puQ.puG.getString(R.l.eiE, new Object[]{Integer.valueOf(2), Integer.valueOf(i)}), 1).show();
                            }
                            ReadMailUI.g(this.puQ.puG).loadDataWithBaseURL(p.bkn(), str + "(" + i + ")", "text/html", ProtocolPackage.ServerEncoding, null);
                            return;
                        case 2:
                            if (i == -5) {
                                intent = new Intent(this.puQ.puG, QQMailStubProxyUI.class);
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                this.puQ.puG.startActivityForResult(intent, 2);
                                return;
                            }
                            Toast.makeText(this.puQ.puG, str, 1).show();
                            return;
                        default:
                            x.e("MicroMsg.ReadMailUI", "onError invalid userData = %d", new Object[]{Integer.valueOf(this.puQ.puO)});
                            return;
                    }
                }
            }
        });
    }

    public final boolean onReady() {
        ReadMailUI.i(this.puG).post(new Runnable(this) {
            final /* synthetic */ ReadMailUI$a puQ;

            {
                this.puQ = r1;
            }

            public final void run() {
                ReadMailUI.a(this.puQ.puG, new HashMap());
            }
        });
        return true;
    }

    public final void onComplete() {
        ReadMailUI.i(this.puG).post(new Runnable(this) {
            final /* synthetic */ ReadMailUI$a puQ;

            {
                this.puQ = r1;
            }

            public final void run() {
                ReadMailUI.m(this.puQ.puG).setVisibility(8);
                ReadMailUI.n(this.puQ.puG);
            }
        });
    }
}
