package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.c$a;
import com.google.android.gms.wearable.internal.ao.1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.FutureTask;

class bg$1 extends aw<c$a> {
    final /* synthetic */ PutDataRequest bft;
    final /* synthetic */ bg bfu;

    bg$1(bg bgVar, c cVar, PutDataRequest putDataRequest) {
        this.bfu = bgVar;
        this.bft = putDataRequest;
        super(cVar);
    }

    public final /* synthetic */ g b(Status status) {
        return new bg$a(status, null);
    }

    protected final /* synthetic */ void b(b bVar) {
        ao aoVar = (ao) bVar;
        PutDataRequest putDataRequest = this.bft;
        for (Entry value : putDataRequest.rq().entrySet()) {
            Asset asset = (Asset) value.getValue();
            if (asset.bdg == null && asset.bdh == null && asset.bdi == null && asset.uri == null) {
                throw new IllegalArgumentException("Put for " + putDataRequest.aMK + " contains invalid asset: " + asset);
            }
        }
        PutDataRequest f = PutDataRequest.f(putDataRequest.aMK);
        f.bdg = putDataRequest.bdg;
        List arrayList = new ArrayList();
        for (Entry value2 : putDataRequest.rq().entrySet()) {
            Asset asset2 = (Asset) value2.getValue();
            if (asset2.bdg == null) {
                f.b((String) value2.getKey(), (Asset) value2.getValue());
            } else {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        new StringBuilder("processAssets: replacing data with FD in asset: ").append(asset2).append(" read:").append(createPipe[0]).append(" write:").append(createPipe[1]);
                    }
                    f.b((String) value2.getKey(), Asset.a(createPipe[0]));
                    Runnable futureTask = new FutureTask(new 1(aoVar, createPipe[1], asset2.bdg));
                    arrayList.add(futureTask);
                    aoVar.beV.submit(futureTask);
                } catch (Throwable e) {
                    throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + putDataRequest, e);
                }
            }
        }
        ((x) aoVar.oK()).a(new an.g(this, arrayList), f);
    }
}
