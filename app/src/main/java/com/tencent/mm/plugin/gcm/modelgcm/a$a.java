package com.tencent.mm.plugin.gcm.modelgcm;

import android.os.AsyncTask;
import com.google.android.gms.gcm.a;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class a$a extends AsyncTask<Void, Void, String> {
    final /* synthetic */ a nyo;

    a$a(a aVar) {
        this.nyo = aVar;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return aSj();
    }

    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
    }

    private String aSj() {
        String str;
        Object obj = null;
        d.pPH.a(452, 5, 1, false);
        String b;
        try {
            x.i("GcmRegister", "RegisterAsyncTask doInBackground.");
            if (a.a(this.nyo) == null) {
                a.a(this.nyo, a.J(a.b(this.nyo)));
            }
            b = a.a(this.nyo).b(new String[]{"546136561403"});
            str = "Device registered, registration ID=" + b;
            if (b == null || b.length() <= 0) {
                g.pQN.k(11250, new StringBuilder("2,1").toString());
                d.pPH.a(452, 7, 1, false);
                b = str;
                x.i("GcmRegister", b);
                if (obj == null && a.c(this.nyo) > 0) {
                    a.a(this.nyo, a.c(this.nyo) - 1);
                    this.nyo.aSb();
                }
                return b;
            }
            this.nyo.af(a.b(this.nyo), b);
            this.nyo.aSg();
            obj = 1;
            d.pPH.a(452, 6, 1, false);
            b = str;
            x.i("GcmRegister", b);
            a.a(this.nyo, a.c(this.nyo) - 1);
            this.nyo.aSb();
            return b;
        } catch (Throwable e) {
            str = "Device register Error :" + e.getMessage();
            x.printErrStackTrace("GcmRegister", e, "", new Object[0]);
            g.pQN.k(11250, new StringBuilder("2,1").toString());
            d.pPH.a(452, 8, 1, false);
            b = str;
        } catch (Throwable e2) {
            a.a(this.nyo, 0);
            str = "Device register Error :" + e2.getMessage();
            x.printErrStackTrace("GcmRegister", e2, "", new Object[0]);
            g.pQN.k(11250, new StringBuilder("2,1").toString());
            d.pPH.a(452, 9, 1, false);
            b = str;
        } catch (Throwable e22) {
            str = "Device register Error :" + e22.getMessage();
            x.printErrStackTrace("GcmRegister", e22, "", new Object[0]);
            g.pQN.k(11250, new StringBuilder("2,1").toString());
            d.pPH.a(452, 10, 1, false);
            b = str;
        }
    }
}
