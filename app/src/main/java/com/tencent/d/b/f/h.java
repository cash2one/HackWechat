package com.tencent.d.b.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.d.a.a.a.d;
import com.tencent.d.a.c.i;
import com.tencent.d.b.c.b;
import com.tencent.d.b.e.c;
import com.tencent.d.b.e.f;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.security.Signature;
import junit.framework.Assert;

public final class h extends d implements a {
    String AcJ = null;
    boolean AdA;
    private c Adr = null;
    f Ads = null;
    private WeakReference<Context> Adt = null;
    com.tencent.d.b.c.a Adu = null;
    b Adv = null;
    i Adw = null;
    private a Adx = null;
    boolean Ady;
    boolean Adz;
    private int irz = -1;
    String thp = null;

    private class a extends com.tencent.d.a.a.a.b {
        final /* synthetic */ h AdB;
        Signature AdC;

        private a(h hVar, Signature signature) {
            this.AdB = hVar;
            this.AdC = null;
            this.AdC = signature;
        }

        static String W(CharSequence charSequence) {
            return charSequence == null ? "unknown error" : charSequence.toString();
        }

        public final void onAuthenticationError(int i, CharSequence charSequence) {
            com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: on authentication fatal error: %d, %s", new Object[]{Integer.valueOf(i), charSequence});
            if (i != 10308) {
                g.cGk().y(new 1(this, i, charSequence));
                this.AdB.b(new com.tencent.d.b.a.a(21, W(charSequence)));
            } else {
                this.AdB.b(new com.tencent.d.b.a.a(25, W(charSequence)));
            }
            cGm();
        }

        public final void onAuthenticationHelp(int i, CharSequence charSequence) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", new Object[]{Integer.valueOf(i), charSequence});
            g.cGk().y(new 2(this, i, charSequence));
        }

        public final void bCU() {
            com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
            g.cGk().A(new Runnable(this) {
                final /* synthetic */ a AdF;

                {
                    this.AdF = r1;
                }

                public final void run() {
                    if (com.tencent.d.a.c.f.ov(this.AdF.AdB.thp)) {
                        com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: challenge is null. should not happen here", new Object[0]);
                        this.AdF.onAuthenticationError(DownloadResult.CODE_UNDEFINED, "challenge is null");
                        return;
                    }
                    try {
                        this.AdF.AdC.update(this.AdF.AdB.thp.getBytes(Charset.forName("UTF-8")));
                        h hVar = this.AdF.AdB;
                        try {
                            hVar.Adw = com.tencent.d.a.a.bN(this.AdF.AdC.sign());
                            if (hVar.Ads == null) {
                                com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
                                hVar.b(new com.tencent.d.b.a.a(hVar.Adw));
                            } else if (hVar.Adw == null) {
                                hVar.b(new com.tencent.d.b.a.a(22, "sign failed even after user authenticated the key."));
                            } else {
                                hVar.Ads.bq(new com.tencent.d.b.e.f.a(hVar.Adw.signature, hVar.Adw.AcA, hVar.Adw.Acz));
                                hVar.Ads.a(new 3(hVar));
                                hVar.Ads.execute();
                            }
                        } catch (Throwable e) {
                            com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: sign failed due to exception: %s", new Object[]{e.getMessage()});
                            com.tencent.d.a.c.c.a("Soter.TaskAuthentication", e, "soter: sign failed due to exception");
                            hVar.b(new com.tencent.d.b.a.a(22, "sign failed even after user authenticated the key."));
                        }
                    } catch (Throwable e2) {
                        com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: exception in update", new Object[0]);
                        com.tencent.d.a.c.c.a("Soter.TaskAuthentication", e2, "soter: exception in update");
                        com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: remove the auth key: %s", new Object[]{this.AdF.AdB.AcJ});
                        com.tencent.d.a.a.bs(this.AdF.AdB.AcJ, false);
                        this.AdF.onAuthenticationError(DownloadResult.CODE_UNDEFINED, "update signature failed");
                    }
                }
            });
            g.cGk().y(new Runnable(this) {
                final /* synthetic */ a AdF;

                {
                    this.AdF = r1;
                }

                public final void run() {
                    if (this.AdF.AdB.Adv != null) {
                        this.AdF.AdB.Adv.aKC();
                    }
                }
            });
            cGm();
        }

        public final void onAuthenticationFailed() {
            super.onAuthenticationFailed();
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: authentication failed once", new Object[0]);
            g.cGk().y(new Runnable(this) {
                final /* synthetic */ a AdF;

                {
                    this.AdF = r1;
                }

                public final void run() {
                    if (this.AdF.AdB.Adv != null) {
                        this.AdF.AdB.Adv.onAuthenticationFailed();
                    }
                }
            });
            if (this.AdB.Ady) {
                com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: should compat lower android version logic.", new Object[0]);
                this.AdB.Adu.nV(false);
                g.cGk().A(new 7(this));
                g.cGk().k(new 8(this), 1000);
            }
        }

        public final void aKD() {
            com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
            if (this.AdB.AdA) {
                com.tencent.d.a.c.c.v("Soter.TaskAuthentication", "soter: during ignore cancel period", new Object[0]);
                return;
            }
            super.aKD();
            g.cGk().y(new 6(this));
            this.AdB.b(new com.tencent.d.b.a.a(24, "user cancelled authentication"));
            cGm();
        }

        @SuppressLint({"NewApi"})
        private void cGm() {
            if (this.AdB.Adz) {
                this.AdB.Adu.nV(false);
                this.AdB.AdA = true;
            }
        }
    }

    public h(b bVar) {
        boolean z = true;
        boolean z2 = VERSION.SDK_INT < 23 && Build.MANUFACTURER.equalsIgnoreCase("vivo");
        this.Ady = z2;
        if (VERSION.SDK_INT >= 23) {
            z = false;
        }
        this.Adz = z;
        this.AdA = false;
        if (bVar == null) {
            throw new IllegalArgumentException("param is null!");
        }
        this.irz = bVar.irz;
        this.Adr = bVar.AcW;
        this.Ads = bVar.AcX;
        this.Adt = new WeakReference(bVar.mContext);
        this.Adv = bVar.AcY;
        this.Adu = bVar.mzB;
        this.thp = bVar.thp;
    }

    @SuppressLint({"DefaultLocale", "NewApi"})
    final boolean cGg() {
        if (!com.tencent.d.b.b.a.cFX().isInit()) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: not initialized yet", new Object[0]);
            b(new com.tencent.d.b.a.a(14));
            return true;
        } else if (com.tencent.d.b.b.a.cFX().cFW()) {
            boolean z;
            if (VERSION.SDK_INT >= 16) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            this.AcJ = (String) com.tencent.d.b.b.a.cFX().cFZ().get(this.irz, "");
            if (com.tencent.d.a.c.f.ov(this.AcJ)) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
                b(new com.tencent.d.b.a.a(15, String.format("auth scene %d not initialized in map", new Object[]{Integer.valueOf(this.irz)})));
                return true;
            } else if (!com.tencent.d.a.a.cFM()) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: app secure key not exists. need re-generate", new Object[0]);
                b(new com.tencent.d.b.a.a(3));
                return true;
            } else if (!com.tencent.d.a.a.abt(this.AcJ) || com.tencent.d.a.a.abv(this.AcJ) == null) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: auth key %s not exists. need re-generate", new Object[]{this.AcJ});
                b(new com.tencent.d.b.a.a(12, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", new Object[]{Integer.valueOf(this.irz)})));
                return true;
            } else if (!com.tencent.d.a.a.abu(this.AcJ)) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: auth key %s has already expired, and we've already deleted them. need re-generate", new Object[]{this.AcJ});
                b(new com.tencent.d.b.a.a(11, String.format("the auth key to scene %d has already been expired. in Android versions above 6.0, a key would be expired when user enrolls a new fingerprint. please prepare the key again", new Object[]{Integer.valueOf(this.irz)})));
                return true;
            } else if (this.Adr == null && com.tencent.d.a.c.f.ov(this.thp)) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: challenge wrapper is null!", new Object[0]);
                b(new com.tencent.d.b.a.a(16, "neither get challenge wrapper nor challenge str is found in request parameter"));
                return true;
            } else {
                Context context = (Context) this.Adt.get();
                if (context == null) {
                    com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: context instance released in preExecute", new Object[0]);
                    b(new com.tencent.d.b.a.a(17));
                    return true;
                } else if (!com.tencent.d.a.a.a.if(context).hasEnrolledFingerprints()) {
                    com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: user has not enrolled any fingerprint in system.", new Object[0]);
                    b(new com.tencent.d.b.a.a(18));
                    return true;
                } else if (com.tencent.d.a.a.ie(context)) {
                    com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: fingerprint sensor frozen", new Object[0]);
                    b(new com.tencent.d.b.a.a(25, "Too many failed times"));
                    return true;
                } else if (this.Adu == null) {
                    com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
                    this.Adu = new com.tencent.d.b.c.a();
                    return false;
                } else {
                    if (this.Ads == null) {
                        com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
                    }
                    return false;
                }
            }
        } else {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: not support soter", new Object[0]);
            b(new com.tencent.d.b.a.a(2));
            return true;
        }
    }

    final void cGh() {
        if (this.Adu != null) {
            this.Adu.nV(true);
        }
    }

    final void execute() {
        if (com.tencent.d.a.c.f.ov(this.thp)) {
            com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: not provide the challenge. we will do the job", new Object[0]);
            this.Adr.bq(new com.tencent.d.b.e.c.a());
            this.Adr.a(new 1(this));
            this.Adr.execute();
            return;
        }
        com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: already provided the challenge. directly authenticate", new Object[0]);
        cGl();
    }

    final void cGl() {
        Signature abw = com.tencent.d.a.a.abw(this.AcJ);
        if (abw == null) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: error occurred when init sign", new Object[0]);
            b(new com.tencent.d.b.a.a(13));
            return;
        }
        this.Adx = new a(abw);
        a(abw);
        g.cGk().y(new 2(this));
    }

    @SuppressLint({"NewApi"})
    final void a(Signature signature) {
        if (this.AcN) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: already finished. can not authenticate", new Object[0]);
            return;
        }
        Context context = (Context) this.Adt.get();
        if (context == null) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: context instance released in startAuthenticate", new Object[0]);
            b(new com.tencent.d.b.a.a(17));
            return;
        }
        try {
            com.tencent.d.a.c.c.v("Soter.TaskAuthentication", "soter: performing start", new Object[0]);
            com.tencent.d.a.a.a.if(context).a(new d(signature), this.Adu != null ? this.Adu.AcF : null, this.Adx);
        } catch (Throwable e) {
            String message = e.getMessage();
            com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: caused exception when authenticating: %s", new Object[]{message});
            com.tencent.d.a.c.c.a("Soter.TaskAuthentication", e, "soter: caused exception when authenticating");
            b(new com.tencent.d.b.a.a(20, String.format("start authentication failed due to %s", new Object[]{message})));
        }
    }

    public final void cGf() {
        com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: called from cancellation signal", new Object[0]);
        if (this.Adx != null) {
            this.Adx.aKD();
        }
    }

    public final boolean isCancelled() {
        return this.AdA;
    }
}
