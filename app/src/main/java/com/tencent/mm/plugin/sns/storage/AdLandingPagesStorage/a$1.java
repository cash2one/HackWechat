package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import java.lang.ref.WeakReference;

class a$1 implements o {
    final /* synthetic */ a rfA;

    a$1(a aVar) {
        this.rfA = aVar;
    }

    public final void onTaskStarted(long j, String str) {
        this.rfA.H(1, j);
    }

    public final void c(long j, String str, boolean z) {
        WeakReference weakReference = (WeakReference) this.rfA.rfy.get(Long.valueOf(j));
        if (weakReference != null) {
            a$a com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a = (a$a) weakReference.get();
            if (com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a != null) {
                com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a.buu();
                this.rfA.rfy.remove(Long.valueOf(j));
            }
            this.rfA.H(3, j);
        }
    }

    public final void c(long j, int i, boolean z) {
        WeakReference weakReference = (WeakReference) this.rfA.rfy.get(Long.valueOf(j));
        if (weakReference != null) {
            a$a com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a = (a$a) weakReference.get();
            if (com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a != null) {
                com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a.buv();
                this.rfA.rfy.remove(Long.valueOf(j));
            }
            this.rfA.H(8, j);
        }
    }

    public final void onTaskRemoved(long j) {
        WeakReference weakReference = (WeakReference) this.rfA.rfy.get(Long.valueOf(j));
        if (weakReference != null) {
            a$a com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a = (a$a) weakReference.get();
            if (com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a != null) {
                com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a.but();
                this.rfA.rfy.remove(Long.valueOf(j));
            }
            this.rfA.H(2, j);
        }
    }

    public final void onTaskPaused(long j) {
        WeakReference weakReference = (WeakReference) this.rfA.rfy.get(Long.valueOf(j));
        if (weakReference != null) {
            a$a com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a = (a$a) weakReference.get();
            if (com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a != null) {
                com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a.bus();
            }
            this.rfA.H(6, j);
        }
    }

    public final void ck(long j) {
        WeakReference weakReference = (WeakReference) this.rfA.rfy.get(Long.valueOf(j));
        if (weakReference != null) {
            a$a com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a = (a$a) weakReference.get();
            if (com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a != null) {
                FileDownloadTaskInfo bY = f.aAd().bY(j);
                if (bY.fwf >= 0 && bY.fwg > 0) {
                    com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a.wy((int) ((bY.fwf * 100) / bY.fwg));
                }
            }
        }
    }

    public final void k(long j, String str) {
        WeakReference weakReference = (WeakReference) this.rfA.rfy.get(Long.valueOf(j));
        if (weakReference != null) {
            a$a com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a = (a$a) weakReference.get();
            if (com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a != null) {
                com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_a_a.buw();
            }
            this.rfA.H(7, j);
        }
    }
}
