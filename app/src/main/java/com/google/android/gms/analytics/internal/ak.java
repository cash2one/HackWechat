package com.google.android.gms.analytics.internal;

public final class ak extends ab<b> {

    private static class a implements com.google.android.gms.analytics.internal.ab.a<b> {
        private final q aFo;
        private final b aIm = new b();

        public a(q qVar) {
            this.aFo = qVar;
        }

        public final void e(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.aIm.aFa = z ? 1 : 0;
                return;
            }
            this.aFo.mS().e("Bool xml configuration name not recognized", str);
        }

        public final void k(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.aIm.aEZ = i;
            } else {
                this.aFo.mS().e("Int xml configuration name not recognized", str);
            }
        }

        public final void l(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.aIm.aEW = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.aIm.aEX = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.aIm.aEY = str2;
            } else {
                this.aFo.mS().e("String xml configuration name not recognized", str);
            }
        }

        public final /* synthetic */ aa nt() {
            return this.aIm;
        }
    }

    public ak(q qVar) {
        super(qVar, new a(qVar));
    }
}
