package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.c.au;
import com.google.android.gms.c.av;
import com.google.android.gms.c.be;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.c.a.1;
import com.google.android.gms.common.api.o;
import com.google.android.gms.common.api.u;
import com.google.android.gms.common.api.v;
import com.google.android.gms.common.api.v.b;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.c$d;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.i;
import com.google.android.gms.wearable.k;
import com.google.android.gms.wearable.m;
import com.google.android.gms.wearable.n$a;
import com.google.android.gms.wearable.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class a implements b {
    private c tiG;

    public a() {
        boolean z;
        c cVar = null;
        boolean z2 = true;
        com.google.android.gms.common.api.c.a aVar = new com.google.android.gms.common.api.c.a(ac.getContext());
        com.google.android.gms.common.api.a aVar2 = p.baZ;
        aVar.aKa.put(aVar2, null);
        aVar.aJU.addAll(aVar2.nS().nU());
        if (aVar.aKa.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        w.e(z, "must call addApi() to add at least one API");
        if (aVar.aKc >= 0) {
            c oVar = new o(aVar.mContext.getApplicationContext(), aVar.aKf, aVar.oc(), aVar.aKg, aVar.aKh, aVar.aKa, aVar.aKi, aVar.aKj, aVar.aKc, -1);
            u a = u.a(aVar.aKb);
            if (a == null) {
                new Handler(aVar.mContext.getMainLooper()).post(new 1(aVar, oVar));
            } else {
                aVar.a(a, oVar);
            }
            cVar = oVar;
        } else if (aVar.aKd >= 0) {
            android.support.v4.app.t.a c = v.c(aVar.aKb);
            int i = aVar.aKd;
            if (c.getActivity() != null) {
                v$a dk = c.dk(i);
                if (dk != null) {
                    cVar = dk.aLU;
                }
            }
            if (cVar == null) {
                cVar = new o(aVar.mContext.getApplicationContext(), aVar.aKf, aVar.oc(), aVar.aKg, aVar.aKh, aVar.aKa, aVar.aKi, aVar.aKj, -1, aVar.aKd);
            }
            i = aVar.aKd;
            c.c cVar2 = aVar.aKe;
            w.i(cVar, "GoogleApiClient instance cannot be null");
            if (c.aLS.indexOfKey(i) >= 0) {
                z2 = false;
            }
            w.d(z2, "Already managing a GoogleApiClient with id " + i);
            c.aLS.put(i, new b(cVar, cVar2, (byte) 0));
            if (c.getActivity() != null) {
                android.support.v4.app.u.DEBUG = false;
                c.getLoaderManager().a(i, c);
            }
        } else {
            cVar = new o(aVar.mContext, aVar.aKf, aVar.oc(), aVar.aKg, aVar.aKh, aVar.aKa, aVar.aKi, aVar.aKj, -1, -1);
        }
        this.tiG = cVar;
    }

    public final boolean isAvailable() {
        return h.aBt() || h.aBs();
    }

    public final void bOB() {
        this.tiG.disconnect();
        bOC();
    }

    public final c bOC() {
        if (!this.tiG.isConnected()) {
            x.i("MicroMsg.Wear.GlobalConnection", "connect to google api client");
            if (!this.tiG.a(TimeUnit.SECONDS).isSuccess()) {
                x.e("MicroMsg.Wear.GlobalConnection", "google api client connect error, code=%d, ", new Object[]{Integer.valueOf(this.tiG.a(TimeUnit.SECONDS).aJD)});
            }
        }
        return this.tiG;
    }

    public final byte[] a(Asset asset) {
        c$d com_google_android_gms_wearable_c_d = (c$d) p.bdu.a(bOC(), asset).of();
        if (com_google_android_gms_wearable_c_d.og().isSuccess()) {
            return com.tencent.mm.loader.stub.b.d(com_google_android_gms_wearable_c_d.getInputStream());
        }
        x.e("MicroMsg.Wear.GlobalConnection", "read asset data not success errorCode=%d | errorMsg=%s", new Object[]{Integer.valueOf(com_google_android_gms_wearable_c_d.og().aJD), com_google_android_gms_wearable_c_d.og().aKv});
        return null;
    }

    public final com.tencent.mm.plugin.wear.model.a.b.a s(String str, byte[] bArr) {
        HashSet bOD = bOD();
        com.tencent.mm.plugin.wear.model.a.b.a aVar = new com.tencent.mm.plugin.wear.model.a.b.a();
        Iterator it = bOD.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.wear.model.a.b.a aVar2;
            String str2 = (String) it.next();
            if (bOC().isConnected()) {
                com.tencent.mm.plugin.wear.model.a.b.a aVar3 = new com.tencent.mm.plugin.wear.model.a.b.a();
                Status og = ((k.b) p.bdw.a(bOC(), str2, str, bArr).b(TimeUnit.SECONDS)).og();
                if (!og.isSuccess()) {
                    aVar3.code = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                    aVar3.fnL = og.aKv;
                    x.e("MicroMsg.Wear.GlobalConnection", "send message not success errorCode=%d | errorMsg=%s", new Object[]{Integer.valueOf(og.aJD), og.aKv});
                }
                String str3 = "MicroMsg.Wear.GlobalConnection";
                String str4 = "send Message %s %s %d";
                Object[] objArr = new Object[3];
                objArr[0] = str2;
                objArr[1] = str;
                objArr[2] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                x.d(str3, str4, objArr);
                aVar2 = aVar3;
            } else {
                aVar2 = new com.tencent.mm.plugin.wear.model.a.b.a((byte) 0);
            }
            if (aVar2.code != 0) {
                return aVar2;
            }
        }
        return aVar;
    }

    public final HashSet<String> bOD() {
        HashSet<String> hashSet = new HashSet();
        n$a com_google_android_gms_wearable_n_a = (n$a) p.bdx.b(bOC()).of();
        if (com_google_android_gms_wearable_n_a != null) {
            for (m id : com_google_android_gms_wearable_n_a.rs()) {
                hashSet.add(id.getId());
            }
        }
        return hashSet;
    }

    public final com.tencent.mm.plugin.wear.model.a.b.a t(String str, byte[] bArr) {
        if (!bOC().isConnected()) {
            return new com.tencent.mm.plugin.wear.model.a.b.a((byte) 0);
        }
        com.google.android.gms.wearable.o oVar = new com.google.android.gms.wearable.o(PutDataRequest.bl(str));
        oVar.bdq.putLong("key_timestamp", System.currentTimeMillis());
        oVar.bdq.a("key_data", Asset.n(bArr));
        i iVar = oVar.bdq;
        av avVar = new av();
        List arrayList = new ArrayList();
        avVar.aZw = au.a(iVar, arrayList);
        com.google.android.gms.c.au.a aVar = new com.google.android.gms.c.au.a(avVar, arrayList);
        oVar.bdr.bdg = be.c(aVar.aZu);
        int size = aVar.aZv.size();
        int i = 0;
        while (i < size) {
            String num = Integer.toString(i);
            Asset asset = (Asset) aVar.aZv.get(i);
            if (num == null) {
                throw new IllegalStateException("asset key cannot be null: " + asset);
            } else if (asset == null) {
                throw new IllegalStateException("asset cannot be null: key=" + num);
            } else {
                if (Log.isLoggable("DataMap", 3)) {
                    new StringBuilder("asPutDataRequest: adding asset: ").append(num).append(" ").append(asset);
                }
                oVar.bdr.b(num, asset);
                i++;
            }
        }
        p.bdu.a(bOC(), oVar.bdr);
        x.d("MicroMsg.Wear.GlobalConnection", "send data request path=%s | length=%d", new Object[]{r0.aMK.getPath(), Integer.valueOf(r0.bdg.length)});
        return new com.tencent.mm.plugin.wear.model.a.b.a();
    }

    public final boolean h(Uri uri) {
        p.bdu.b(bOC(), uri);
        x.i("MicroMsg.Wear.GlobalConnection", "delete data item %s", new Object[]{uri});
        return true;
    }

    public final boolean bOE() {
        if (bOC().isConnected() && bOD().size() != 0) {
            return true;
        }
        return false;
    }

    public final void finish() {
        this.tiG.disconnect();
    }

    public final void bOF() {
        com.google.android.gms.wearable.h hVar = (com.google.android.gms.wearable.h) p.bdu.a(bOC()).of();
        Iterator it = hVar.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.getUri().toString().startsWith("/wechat")) {
                x.i("MicroMsg.Wear.GlobalConnection", "delete data item %s", new Object[]{fVar.getUri().toString()});
                p.bdu.b(bOC(), fVar.getUri());
            }
        }
        hVar.release();
    }
}
