package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.k.b;
import com.google.android.gms.wearable.c.a;
import com.google.android.gms.wearable.c.d;
import com.google.android.gms.wearable.internal.bg.c;
import com.google.android.gms.wearable.k;
import java.util.List;
import java.util.concurrent.FutureTask;

final class an {

    static final class e extends a<d> {
        public e(b<d> bVar) {
            super(bVar);
        }

        public final void a(GetFdForAssetResponse getFdForAssetResponse) {
            ap(new c(ak.dN(getFdForAssetResponse.statusCode), getFdForAssetResponse.beE));
        }
    }

    static final class g extends a<a> {
        private final List<FutureTask<Boolean>> beU;

        g(b<a> bVar, List<FutureTask<Boolean>> list) {
            super(bVar);
            this.beU = list;
        }

        public final void a(PutDataResponse putDataResponse) {
            ap(new bg.a(ak.dN(putDataResponse.statusCode), putDataResponse.beD));
            if (putDataResponse.statusCode != 0) {
                for (FutureTask cancel : this.beU) {
                    cancel.cancel(true);
                }
            }
        }
    }

    static final class h extends a<k.b> {
        public h(b<k.b> bVar) {
            super(bVar);
        }

        public final void a(SendMessageResponse sendMessageResponse) {
            ap(new z.a(ak.dN(sendMessageResponse.statusCode), sendMessageResponse.aRm));
        }
    }
}
