package com.tencent.mm.plugin.appbrand.j;

import com.tencent.mm.sdk.platformtools.x;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class l implements X509TrustManager {
    private LinkedList<X509TrustManager> jBY = new LinkedList();
    private LinkedList<X509TrustManager> jBZ = new LinkedList();
    KeyStore jCa;
    private X509Certificate[] jCb;

    public l() {
        try {
            this.jCa = KeyStore.getInstance(KeyStore.getDefaultType());
            this.jCa.load(null, null);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandX509TrustManager", "Local KeyStore init failed");
        }
    }

    public final void init() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            int i = 0;
            while (trustManagers != null && i < trustManagers.length) {
                this.jBY.add((X509TrustManager) trustManagers[i]);
                i++;
            }
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandX509TrustManager", "init SystemTrustManager: " + e);
        }
        aiG();
        aiH();
    }

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new CertificateException("Client Certification not supported");
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        Object obj;
        Iterator it = this.jBY.iterator();
        while (it.hasNext()) {
            try {
                ((X509TrustManager) it.next()).checkServerTrusted(x509CertificateArr, str);
                obj = 1;
                break;
            } catch (CertificateException e) {
            }
        }
        obj = null;
        if (obj == null) {
            it = this.jBZ.iterator();
            while (it.hasNext()) {
                try {
                    ((X509TrustManager) it.next()).checkServerTrusted(x509CertificateArr, str);
                    obj = 1;
                    break;
                } catch (CertificateException e2) {
                }
            }
            obj = null;
            if (obj == null) {
                throw new CertificateException("Server Certificate not trusted");
            }
        }
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return this.jCb;
    }

    private void aiG() {
        if (this.jCa != null) {
            try {
                TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance.init(this.jCa);
                TrustManager[] trustManagers = instance.getTrustManagers();
                int i = 0;
                while (trustManagers != null && i < trustManagers.length) {
                    this.jBZ.add((X509TrustManager) trustManagers[i]);
                    i++;
                }
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandX509TrustManager", "initLocalTrustManager: " + e);
            }
        }
    }

    private void aiH() {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = this.jBY.iterator();
        while (it.hasNext()) {
            X509Certificate[] acceptedIssuers = ((X509TrustManager) it.next()).getAcceptedIssuers();
            if (acceptedIssuers != null) {
                arrayList.addAll(Arrays.asList(acceptedIssuers));
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        Iterator it2 = this.jBZ.iterator();
        while (it2.hasNext()) {
            acceptedIssuers = ((X509TrustManager) it2.next()).getAcceptedIssuers();
            if (acceptedIssuers != null) {
                arrayList.addAll(Arrays.asList(acceptedIssuers));
            }
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        this.jCb = new X509Certificate[arrayList.size()];
        this.jCb = (X509Certificate[]) arrayList.toArray(this.jCb);
        long currentTimeMillis4 = System.currentTimeMillis();
        x.i("MicroMsg.AppBrandX509TrustManager", "initAcceptedIssuers: %d, %d, %d", new Object[]{Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis4 - currentTimeMillis3)});
    }
}
