package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.facedetect.b.c;
import com.tencent.mm.plugin.facedetect.b.d;
import com.tencent.mm.plugin.facedetect.b.u;
import com.tencent.mm.plugin.facedetect.b.v;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.lang.ref.WeakReference;

public abstract class a {
    private Context mContext;
    private int meK;
    protected d meL = null;
    protected c meM = null;
    int mfA = -1;
    private com.tencent.mm.remoteservice.d mfB = null;
    protected com.tencent.mm.plugin.facedetect.b.a mfC = null;
    protected boolean mfD = false;
    protected WeakReference<e> mfy;
    protected boolean mfz = false;

    public abstract void Z(int i, String str);

    protected abstract k aGo();

    public abstract Bundle aGp();

    public abstract boolean e(int i, int i2, String str, Bundle bundle);

    public abstract void f(int i, int i2, String str, Bundle bundle);

    public abstract void h(int i, int i2, String str);

    public abstract void h(int i, int i2, String str, k kVar);

    public abstract void onRelease();

    protected abstract void onStart();

    a(Context context, e eVar, int i) {
        this.mContext = context;
        this.meK = i;
        this.mfy = new WeakReference(eVar);
        this.mfC = new com.tencent.mm.plugin.facedetect.b.a(i);
        this.mfA = FaceDetectReporter.pu(i);
    }

    public final void a(c cVar) {
        if (this.mfC != null) {
            this.meM = cVar;
            this.mfC.meM = this.meM;
        }
    }

    public final void a(d dVar) {
        if (this.mfC != null) {
            this.meL = dVar;
            this.mfC.meL = dVar;
        }
    }

    public final void aGk() {
        if (this.mfC != null) {
            e eVar = this.mfC;
            g.Dh();
            eVar.fmO = com.tencent.mm.kernel.a.Cx();
            x.i("MicroMsg.FaceUploadProcessor", "alvinluo isLogin: %b", new Object[]{Boolean.valueOf(eVar.fmO)});
            if (eVar.fmO) {
                g.CG().a(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION, eVar);
            } else {
                g.CG().a(733, eVar);
            }
            com.tencent.mm.plugin.facedetect.b.a aVar = this.mfC;
            aVar.meO = 0;
            aVar.meP = 0;
            if (aVar.meQ != null) {
                g.CG().c(aVar.meQ);
            }
            if (com.tencent.mm.plugin.facedetect.model.e.aGu()) {
                com.tencent.mm.plugin.facedetect.model.e.cR(aVar.meO);
            }
            if (aVar.fmO) {
                aVar.meQ = new u(aVar.meK);
            } else {
                aVar.meQ = new v(aVar.meK);
            }
            g.CG().a(aVar.meQ, 0);
        }
    }

    public final void aGl() {
        if (!(this.mfy == null || this.mfy.get() == null)) {
            ((e) this.mfy.get()).aGl();
        }
        onStart();
    }

    public final void zJ(String str) {
        if (this.mfC != null) {
            com.tencent.mm.plugin.facedetect.b.a aVar = this.mfC;
            if (!aVar.meN) {
                aVar.meP = 1;
                if (bh.ov(str)) {
                    x.e("MicroMsg.FaceUploadProcessor", "hy: err face file null");
                    aVar.g(4, 90011, "face file null");
                } else if (!FileOp.bO(str)) {
                    x.e("MicroMsg.FaceUploadProcessor", "hy: file not exist");
                    aVar.g(4, 90011, "get image failed");
                } else if (aVar.meO == 0) {
                    x.e("MicroMsg.FaceUploadProcessor", "hy: err not init");
                    aVar.g(4, 90014, "uploadId not init");
                } else {
                    x.i("MicroMsg.FaceUploadProcessor", "hy: start upload file : %s", new Object[]{str});
                    if (!aVar.meN) {
                        i iVar = new i();
                        iVar.htt = aVar.meU;
                        iVar.field_mediaId = n.zM(str);
                        iVar.field_fullpath = str;
                        iVar.field_thumbpath = "";
                        iVar.field_fileType = b.MediaType_FILE;
                        iVar.field_talker = "";
                        iVar.field_priority = b.hrK;
                        iVar.field_needStorage = false;
                        iVar.field_isStreamMedia = false;
                        iVar.field_appType = 0;
                        iVar.field_bzScene = 0;
                        iVar.field_largesvideo = false;
                        if (!com.tencent.mm.modelcdntran.g.MJ().c(iVar)) {
                            x.e("MicroMsg.FaceUploadProcessor", "hy: cdntra addSendTask failed. clientid:%s", new Object[]{iVar.field_mediaId});
                            aVar.g(4, 90019, "add to cdn failed");
                        }
                    }
                }
            }
        }
    }

    public final long aGm() {
        if (this.mfC != null) {
            return this.mfC.meO;
        }
        return -1;
    }

    public final void aGn() {
        x.i("MicroMsg.FaceDetectBaseController", "alvinluo controller releaseFaceDetect");
        if (!(this.mfy == null || this.mfy.get() == null)) {
            ((e) this.mfy.get()).aGn();
        }
        this.mfy = null;
        String r = bh.r(ac.getContext(), Process.myPid());
        String packageName = ac.getPackageName();
        x.i("MicroMsg.FaceDetectBaseController", "process name: %s", new Object[]{r});
        if (r.equalsIgnoreCase(packageName)) {
            if (this.mfC != null) {
                e eVar = this.mfC;
                String str = "MicroMsg.FaceUploadProcessor";
                String str2 = "alvinluo uinit mCurrentNetScene == null: %b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(eVar.meQ == null);
                x.v(str, str2, objArr);
                eVar.meN = true;
                if (eVar.meQ != null) {
                    x.i("MicroMsg.FaceUploadProcessor", "alvinluo hy: current scene: %s is not finished yet. cancel.", new Object[]{eVar.meQ.getClass().getSimpleName()});
                    g.CG().c(eVar.meQ);
                }
                if (eVar.fmO) {
                    g.CG().b(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION, eVar);
                } else {
                    g.CG().b(733, eVar);
                }
                eVar.aGe();
            }
            this.mfC = null;
        }
        onRelease();
    }

    protected final void b(int i, int i2, String str, Bundle bundle) {
        boolean z = true;
        String str2 = "MicroMsg.FaceDetectBaseController";
        String str3 = "alvinluo finishWithResult mUIModel == null: %b";
        Object[] objArr = new Object[1];
        if (this.mfy != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str2, str3, objArr);
        if (this.mfy != null && this.mfy.get() != null) {
            ((e) this.mfy.get()).b(i, i2, str, bundle);
        }
    }

    public final void a(boolean z, boolean z2, com.tencent.mm.plugin.facedetect.ui.a.b bVar) {
        if (this.mfy != null && this.mfy.get() != null) {
            ((e) this.mfy.get()).a(z, z2, bVar);
        }
    }

    protected final void c(int i, int i2, String str, Bundle bundle) {
        if (this.mfy != null && this.mfy.get() != null) {
            ((e) this.mfy.get()).g(i, i2, str, bundle);
        }
    }

    public final void d(int i, int i2, String str, Bundle bundle) {
        if (i == 0 && i2 == 0 && !e(i, i2, str, bundle)) {
            x.i("MicroMsg.FaceDetectBaseController", "alvinluo onUploadSuccess");
            this.mfz = true;
            if (this.mfD) {
                k aGo = aGo();
                if (aGo == null) {
                    x.e("MicroMsg.FaceDetectBaseController", "alvinluo verifyNetScene is null, stop verify");
                    return;
                }
                x.i("MicroMsg.FaceDetectBaseController", "alvinluo start verify, sceneType: %d", new Object[]{Integer.valueOf(aGo.getType())});
                if (!this.mfz) {
                    x.e("MicroMsg.FaceDetectBaseController", "isUploadDone: %b, upload not done, can't startVerify", new Object[]{Boolean.valueOf(this.mfz)});
                } else if (this.mfC != null) {
                    Object obj = this.mfC;
                    if (aGo == null) {
                        x.e("MicroMsg.FaceUploadProcessor", "alvinluo verifyNetScene is null");
                        return;
                    }
                    x.i("MicroMsg.FaceUploadProcessor", "uploader start verify, sceneType: %d", new Object[]{Integer.valueOf(aGo.getType())});
                    obj.aGe();
                    obj.meR = aGo;
                    obj.meP = 2;
                    g.CG().a(aGo.getType(), obj);
                    g.CG().a(aGo, 0);
                    obj.meS = System.currentTimeMillis();
                }
            }
        }
    }
}
