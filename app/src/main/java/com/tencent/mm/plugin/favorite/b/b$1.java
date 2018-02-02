package com.tencent.mm.plugin.favorite.b;

import android.database.Cursor;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;

class b$1 extends a {
    final /* synthetic */ b mrg;

    b$1(b bVar) {
        this.mrg = bVar;
    }

    public final void eq(int i) {
        try {
            boolean isWifi = an.isWifi(ac.getContext());
            x.i("MicroMsg.Fav.FavCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[]{Integer.valueOf(i), Boolean.valueOf(isWifi), Boolean.valueOf(this.mrg.mrc)});
            if (i == 4 || i == 6) {
                b bVar;
                if (this.mrg.mrc && !isWifi) {
                    c cVar;
                    bVar = this.mrg;
                    x.i("MicroMsg.Fav.FavCdnService", "pauseAll");
                    Cursor aHU = h.aIs().aHU();
                    if (aHU != null && aHU.moveToFirst()) {
                        while (aHU.moveToNext()) {
                            cVar = new c();
                            cVar.b(aHU);
                            x.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseUpload dataId:%s", new Object[]{cVar.field_dataId});
                            cVar.field_status = 4;
                            h.aIs().a(cVar, new String[]{"dataId"});
                            g.MJ().kH(cVar.field_dataId);
                            b.d(h.aIs().zT(cVar.field_dataId));
                            bVar.Ak(cVar.field_dataId);
                        }
                        aHU.close();
                    }
                    aHU = h.aIs().aHV();
                    if (aHU != null && aHU.moveToFirst()) {
                        while (aHU.moveToNext()) {
                            cVar = new c();
                            cVar.b(aHU);
                            x.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseDownload dataId:%s", new Object[]{cVar.field_dataId});
                            cVar.field_status = 4;
                            h.aIs().a(cVar, new String[]{"dataId"});
                            g.MJ().kI(cVar.field_dataId);
                            b.d(h.aIs().zT(cVar.field_dataId));
                            bVar.Ak(cVar.field_dataId);
                        }
                    }
                    if (aHU != null) {
                        aHU.close();
                    }
                }
                if (!this.mrg.mrc && isWifi) {
                    bVar = this.mrg;
                    x.i("MicroMsg.Fav.FavCdnService", "startAll");
                    h.aIs().aHS();
                    bVar.run();
                }
                this.mrg.mrc = isWifi;
                return;
            }
            this.mrg.mrc = isWifi;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e, "", new Object[0]);
        }
    }
}
