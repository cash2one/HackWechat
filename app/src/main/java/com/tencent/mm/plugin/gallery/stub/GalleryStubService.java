package com.tencent.mm.plugin.gallery.stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.gallery.stub.a.a;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class GalleryStubService extends Service {
    private a mRG = new a(this) {
        private int hEF;
        final /* synthetic */ GalleryStubService mRH;

        {
            this.mRH = r1;
        }

        public final void aj(int i, String str) {
            g.pQN.k(i, str);
        }

        public final void a(String str, String str2, boolean z, int i, boolean z2) {
            if (com.tencent.mm.sdk.b.a.xef != null) {
                b ikVar = new ik();
                ikVar.fyP.fyQ = Boolean.valueOf(z);
                ikVar.fyP.imagePath = str;
                ikVar.fyP.fyR = i;
                ikVar.fyP.toUser = str2;
                ikVar.fyP.fyS = Boolean.valueOf(z2);
                com.tencent.mm.sdk.b.a.xef.m(ikVar);
            }
        }

        public final void aOk() {
            f.vA(19);
        }

        public final int zH() {
            return com.tencent.mm.k.b.zH();
        }

        public final int zF() {
            return com.tencent.mm.k.b.zF();
        }

        public final int zE() {
            return com.tencent.mm.k.b.zE();
        }

        public final boolean fp(boolean z) {
            ar.Hg();
            return c.CU().getBoolean(w.a.xtw, z);
        }

        public final int Bw(String str) {
            PInt pInt = new PInt();
            t.a(str, pInt, new PInt());
            return pInt.value;
        }

        public final int aOl() {
            HardCoderJNI.stopPerformace(HardCoderJNI.hcAlbumScrollEnable, this.hEF);
            return HardCoderJNI.startPerformance(HardCoderJNI.hcAlbumScrollEnable, HardCoderJNI.hcAlbumScrollDelay, HardCoderJNI.hcAlbumScrollCPU, HardCoderJNI.hcAlbumScrollIO, HardCoderJNI.hcAlbumScrollThr ? Process.myTid() : 0, HardCoderJNI.hcAlbumScrollTimeout, 702, HardCoderJNI.hcAlbumScrollAction, "MicroMsg.GalleryStubService");
        }

        public final int qq(int i) {
            int stopPerformace = HardCoderJNI.stopPerformace(HardCoderJNI.hcAlbumScrollEnable, this.hEF);
            this.hEF = 0;
            return stopPerformace;
        }
    };

    public IBinder onBind(Intent intent) {
        x.d("MicroMsg.GalleryStubService", "on bind, intent[%s]", new Object[]{intent});
        return this.mRG;
    }
}
