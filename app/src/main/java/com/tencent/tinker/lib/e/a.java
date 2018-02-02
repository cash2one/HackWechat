package com.tencent.tinker.lib.e;

import android.content.Context;
import com.tencent.tinker.lib.b.b;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public class a {
    private static a Aix;
    public static boolean Aiy = false;
    final b AiA;
    public final c AiB;
    public final d AiC;
    public final File AiD;
    public final File AiE;
    public final boolean AiF;
    public d AiG;
    public boolean AiH;
    public final File Aiz;
    public final Context context;
    public final boolean rSa;
    public int tinkerFlags;
    final boolean tinkerLoadVerifyFlag;

    public static class a {
        public b AiA;
        public c AiB;
        public d AiC;
        private File AiD;
        private File AiE;
        private final boolean AiI;
        private final boolean AiJ;
        public Boolean AiK;
        private File Aiz;
        private final Context context;
        public int status = -1;

        public a(Context context) {
            if (context == null) {
                throw new TinkerRuntimeException("Context must not be null.");
            }
            this.context = context;
            this.AiI = com.tencent.tinker.lib.f.b.iF(context);
            this.AiJ = com.tencent.tinker.lib.f.b.it(context);
            this.Aiz = SharePatchFileUtil.iy(context);
            if (this.Aiz == null) {
                com.tencent.tinker.lib.f.a.e("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
                return;
            }
            this.AiD = SharePatchFileUtil.abH(this.Aiz.getAbsolutePath());
            this.AiE = SharePatchFileUtil.abI(this.Aiz.getAbsolutePath());
            com.tencent.tinker.lib.f.a.w("Tinker.Tinker", "tinker patch directory: %s", new Object[]{this.Aiz});
        }

        public final a cGY() {
            if (this.status == -1) {
                this.status = 7;
            }
            if (this.AiB == null) {
                this.AiB = new com.tencent.tinker.lib.d.a(this.context);
            }
            if (this.AiC == null) {
                this.AiC = new com.tencent.tinker.lib.d.b(this.context);
            }
            if (this.AiA == null) {
                this.AiA = new com.tencent.tinker.lib.b.a(this.context);
            }
            if (this.AiK == null) {
                this.AiK = Boolean.valueOf(false);
            }
            return new a(this.context, this.status, this.AiB, this.AiC, this.AiA, this.Aiz, this.AiD, this.AiE, this.AiI, this.AiJ, this.AiK.booleanValue());
        }
    }

    private a(Context context, int i, c cVar, d dVar, b bVar, File file, File file2, File file3, boolean z, boolean z2, boolean z3) {
        this.AiH = false;
        this.context = context;
        this.AiA = bVar;
        this.AiB = cVar;
        this.AiC = dVar;
        this.tinkerFlags = i;
        this.Aiz = file;
        this.AiD = file2;
        this.AiE = file3;
        this.rSa = z;
        this.tinkerLoadVerifyFlag = z3;
        this.AiF = z2;
    }

    public static a ip(Context context) {
        if (Aiy) {
            synchronized (a.class) {
                if (Aix == null) {
                    Aix = new a(context).cGY();
                }
            }
            return Aix;
        }
        throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }

    public static void a(a aVar) {
        if (Aix != null) {
            throw new TinkerRuntimeException("Tinker instance is already set.");
        }
        Aix = aVar;
    }

    public final void aSE() {
        if (this.Aiz != null) {
            if (this.AiH) {
                com.tencent.tinker.lib.f.a.e("Tinker.Tinker", "it is not safety to clean patch when tinker is loaded, you should kill all your process after clean!", new Object[0]);
            }
            SharePatchFileUtil.g(this.Aiz);
        }
    }

    public final void Z(File file) {
        if (this.Aiz != null && file != null && file.exists()) {
            String abJ = SharePatchFileUtil.abJ(SharePatchFileUtil.ah(file));
            if (this.Aiz != null && abJ != null) {
                SharePatchFileUtil.bP(this.Aiz.getAbsolutePath() + "/" + abJ);
            }
        }
    }
}
