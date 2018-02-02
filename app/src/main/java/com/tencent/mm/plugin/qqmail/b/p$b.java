package com.tencent.mm.plugin.qqmail.b;

import android.os.AsyncTask;
import com.tencent.mm.plugin.qqmail.b.h.c;
import com.tencent.mm.plugin.qqmail.b.p.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class p$b extends AsyncTask<d, Integer, d> implements h$a {
    final /* synthetic */ p ppf;
    private h ppg;
    d pph;

    private p$b(p pVar) {
        this.ppf = pVar;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        d dVar = ((d[]) objArr)[0];
        if (!bh.ov((String) dVar.ppn.poy.get("skey"))) {
            if (!dVar.ppm.ppj && dVar.ppm.ppk) {
                byte[] k = p.c(this.ppf).k(dVar.uri, dVar.ppn.pox);
                String str = k == null ? null : new String(k);
                if (str != null) {
                    dVar.ppo = new c(304, null, str);
                    if (dVar.ppm.ppl || !(dVar.ppo.status == 304 || dVar.ppo.status == 200)) {
                        x.e("MicroMsg.NormalMailAppService", "http error, %d", new Object[]{Integer.valueOf(dVar.ppo.status)});
                    } else {
                        dVar.ppp = bi.y(dVar.ppo.content, "Response");
                    }
                }
            }
            if (dVar.ppn.poz != null) {
                this.ppg = new f();
            } else {
                this.ppg = new g();
            }
            dVar.ppo = this.ppg.a("https://", dVar.uri, dVar.ppn, this);
            if (dVar.ppo == null) {
                return null;
            }
            if (dVar.ppm.ppl) {
            }
            x.e("MicroMsg.NormalMailAppService", "http error, %d", new Object[]{Integer.valueOf(dVar.ppo.status)});
        }
        return dVar;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        d dVar = (d) obj;
        if (dVar != null) {
            if (bh.ov((String) dVar.ppn.poy.get("skey"))) {
                dVar.ppq.onError(-5, "");
            } else if (dVar.ppo.status == 304) {
                p.a(this.ppf, dVar);
            } else if (dVar.ppo.status == 200) {
                p.a(this.ppf, dVar.ppo.poy);
                if (p.a(this.ppf, dVar) == 0 && dVar.ppm.ppk) {
                    p.c(this.ppf).a(dVar.uri, dVar.ppn.pox, dVar.ppo.content.getBytes());
                }
            } else {
                dVar.ppq.onError(dVar.ppo.status, p.a(this.ppf, dVar.ppo.status));
            }
            dVar.ppq.onComplete();
            p.a(this.ppf).remove(Long.valueOf(dVar.id));
            p.b(this.ppf).remove(Long.valueOf(dVar.id));
        }
    }

    protected final /* synthetic */ void onProgressUpdate(Object[] objArr) {
        this.pph.ppq.onProgress(((Integer[]) objArr)[0].intValue());
    }

    public final boolean a(d dVar) {
        if (!dVar.ppq.onReady()) {
            return false;
        }
        this.pph = dVar;
        super.execute(new d[]{dVar});
        return true;
    }

    public final void bkh() {
        publishProgress(new Integer[]{Integer.valueOf(0)});
    }

    protected final void onCancelled() {
        ar.Dm().F(new Runnable(this) {
            final /* synthetic */ p$b ppi;

            {
                this.ppi = r1;
            }

            public final void run() {
                if (this.ppi.ppg != null) {
                    this.ppi.ppg.cancel();
                }
            }

            public final String toString() {
                return super.toString() + "|onCancelled";
            }
        });
        super.onCancelled();
    }
}
