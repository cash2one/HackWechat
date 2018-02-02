package com.tencent.mm.plugin.gallery.model;

import com.tencent.mm.sdk.platformtools.as.a;

class a$a {
    final /* synthetic */ a mQu;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a mQv;
        final /* synthetic */ a$a mQw;

        AnonymousClass1(a$a com_tencent_mm_plugin_gallery_model_a_a, a aVar) {
            this.mQw = com_tencent_mm_plugin_gallery_model_a_a;
            this.mQv = aVar;
        }

        public final void run() {
            if (this.mQv.JB()) {
                this.mQv.JC();
            }
            a.c(this.mQw.mQu);
            a.d(this.mQw.mQu);
        }

        public final String toString() {
            return super.toString() + "|QueueWorkerThreadForGallery";
        }
    }

    private a$a(a aVar) {
        this.mQu = aVar;
    }
}
