package com.tencent.d.a.a;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.d.a.c.c;

public final class a {
    static final e AbH;
    private Context mContext;

    private static class a implements e {
        static /* synthetic */ boolean a(b$a com_tencent_d_a_a_b_a, Context context) {
            if (c.cFP()) {
                c.v("Soter.FingerprintManagerCompat", "soter: using system anti brute force strategy", new Object[0]);
                return false;
            } else if (c.im(context)) {
                if (c.in(context)) {
                    return false;
                }
                c.v("Soter.FingerprintManagerCompat", "soter: unfreeze former frozen status", new Object[0]);
                c.il(context);
                return false;
            } else if (c.in(context)) {
                c.v("Soter.FingerprintManagerCompat", "soter: failure time available", new Object[0]);
                return false;
            } else {
                a(com_tencent_d_a_a_b_a);
                return true;
            }
        }

        public final boolean ig(Context context) {
            return b.ig(context);
        }

        public final boolean ih(Context context) {
            return b.ih(context);
        }

        public final void a(Context context, d dVar, int i, CancellationSignal cancellationSignal, b bVar, Handler handler) {
            b$c com_tencent_d_a_a_b_c;
            b$a 1;
            FingerprintManager ii;
            CryptoObject cryptoObject;
            if (dVar != null) {
                if (dVar.AbM != null) {
                    com_tencent_d_a_a_b_c = new b$c(dVar.AbM);
                } else if (dVar.AbL != null) {
                    com_tencent_d_a_a_b_c = new b$c(dVar.AbL);
                } else if (dVar.AbN != null) {
                    com_tencent_d_a_a_b_c = new b$c(dVar.AbN);
                }
                1 = new 1(bVar, context);
                if (b.b(context, "android.permission.USE_FINGERPRINT") == 0) {
                    c.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: authenticate", new Object[0]);
                }
                try {
                    ii = b.ii(context);
                    if (ii == null) {
                        if (com_tencent_d_a_a_b_c != null) {
                            if (com_tencent_d_a_a_b_c.AbM != null) {
                                cryptoObject = new CryptoObject(com_tencent_d_a_a_b_c.AbM);
                            } else if (com_tencent_d_a_a_b_c.AbL != null) {
                                cryptoObject = new CryptoObject(com_tencent_d_a_a_b_c.AbL);
                            } else if (com_tencent_d_a_a_b_c.AbN != null) {
                                cryptoObject = new CryptoObject(com_tencent_d_a_a_b_c.AbN);
                            }
                            ii.authenticate(cryptoObject, cancellationSignal, 0, new b$1(1), null);
                            return;
                        }
                        cryptoObject = null;
                        ii.authenticate(cryptoObject, cancellationSignal, 0, new b$1(1), null);
                        return;
                    }
                    c.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
                    return;
                } catch (SecurityException e) {
                    c.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
                    return;
                }
            }
            com_tencent_d_a_a_b_c = null;
            1 = new 1(bVar, context);
            if (b.b(context, "android.permission.USE_FINGERPRINT") == 0) {
                ii = b.ii(context);
                if (ii == null) {
                    c.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
                    return;
                }
                if (com_tencent_d_a_a_b_c != null) {
                    if (com_tencent_d_a_a_b_c.AbM != null) {
                        cryptoObject = new CryptoObject(com_tencent_d_a_a_b_c.AbM);
                    } else if (com_tencent_d_a_a_b_c.AbL != null) {
                        cryptoObject = new CryptoObject(com_tencent_d_a_a_b_c.AbL);
                    } else if (com_tencent_d_a_a_b_c.AbN != null) {
                        cryptoObject = new CryptoObject(com_tencent_d_a_a_b_c.AbN);
                    }
                    ii.authenticate(cryptoObject, cancellationSignal, 0, new b$1(1), null);
                    return;
                }
                cryptoObject = null;
                ii.authenticate(cryptoObject, cancellationSignal, 0, new b$1(1), null);
                return;
            }
            c.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: authenticate", new Object[0]);
        }

        static void a(b$a com_tencent_d_a_a_b_a) {
            c.w("Soter.FingerprintManagerCompat", "soter: too many fail fingerprint callback. inform it.", new Object[0]);
            com_tencent_d_a_a_b_a.onAuthenticationError(10308, "Too many failed times");
        }
    }

    public static a if(Context context) {
        return new a(context);
    }

    private a(Context context) {
        this.mContext = context;
    }

    static {
        if (com.tencent.d.a.a.cFI()) {
            AbH = new a();
        } else {
            AbH = new f();
        }
    }

    public final boolean hasEnrolledFingerprints() {
        return AbH.ig(this.mContext);
    }

    public final boolean isHardwareDetected() {
        return AbH.ih(this.mContext);
    }

    public final void a(d dVar, CancellationSignal cancellationSignal, b bVar) {
        AbH.a(this.mContext, dVar, 0, cancellationSignal, bVar, null);
    }
}
