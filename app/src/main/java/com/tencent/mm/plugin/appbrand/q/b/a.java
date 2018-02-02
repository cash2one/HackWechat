package com.tencent.mm.plugin.appbrand.q.b;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;

public final class a {
    private final TencentLocationManager jSG = TencentLocationManager.getInstance(ac.getContext());
    private final a jSH = new a();
    final HashSet<b> jSI = new HashSet();

    private class a implements TencentLocationListener {
        final /* synthetic */ a jSJ;

        private a(a aVar) {
            this.jSJ = aVar;
        }

        public final void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
            synchronized (this.jSJ.jSI) {
            }
            for (b bVar : (b[]) this.jSJ.jSI.toArray(new b[0])) {
                if (bVar != null) {
                    bVar.a(tencentLocation.getLatitude(), tencentLocation.getLongitude(), com.tencent.mm.plugin.appbrand.q.b.b.a.uG(tencentLocation.getProvider()), (double) tencentLocation.getSpeed(), (double) tencentLocation.getAccuracy(), tencentLocation.getAltitude());
                }
            }
        }

        public final void onStatusUpdate(String str, int i, String str2) {
        }
    }

    a() {
        x.i("MicroMsg.AppbrandLocationUpdateRegistry", "construct in process %s", new Object[]{((h) g.Dg().CN()).gOs});
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(b bVar) {
        synchronized (this.jSI) {
            Iterator it = this.jSI.iterator();
            while (it.hasNext()) {
                b bVar2 = (b) it.next();
                if (bVar2 != null && bVar2.equals(bVar)) {
                    return;
                }
            }
            this.jSI.add(bVar);
            x.i("MicroMsg.AppbrandLocationUpdateRegistry", "registerLocationListener %d", new Object[]{Integer.valueOf(this.jSI.size())});
            if (this.jSI.size() == 1) {
                x.i("MicroMsg.AppbrandLocationUpdateRegistry", "registerLocation ");
                TencentLocationRequest create = TencentLocationRequest.create();
                create.setInterval(2000);
                this.jSG.setCoordinateType(1);
                this.jSG.requestLocationUpdates(create, this.jSH, com.tencent.mm.bz.a.cll().getLooper());
            }
        }
    }

    public final void b(b bVar) {
        if (bVar != null) {
            synchronized (this.jSI) {
                Iterator it = this.jSI.iterator();
                while (it.hasNext()) {
                    b bVar2 = (b) it.next();
                    if (bVar2 != null && bVar2.equals(bVar)) {
                        this.jSI.remove(bVar2);
                        break;
                    }
                }
                x.i("MicroMsg.AppbrandLocationUpdateRegistry", "unregisterLocationListener %d", new Object[]{Integer.valueOf(this.jSI.size())});
                if (this.jSI.size() == 0) {
                    x.i("MicroMsg.AppbrandLocationUpdateRegistry", "unregisterLocation ");
                    this.jSG.removeUpdates(this.jSH);
                }
            }
        }
    }
}
