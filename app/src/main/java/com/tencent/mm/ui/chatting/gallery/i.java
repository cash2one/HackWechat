package com.tencent.mm.ui.chatting.gallery;

import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsimple.aj;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.s$a$a;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.s.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.d;
import com.tencent.mm.z.m;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.Map;

public final class i extends a implements a, d.a {
    public static boolean yFN = false;
    String filename;
    private d jtl;
    private ak kTk = new ak(new 16(this), true);
    private long lastCheckTime = 0;
    int mvC = 0;
    private b opG = new b(this) {
        final /* synthetic */ i yFV;

        {
            this.yFV = r1;
        }

        public final long aZz() {
            x.i("MicroMsg.Imagegallery.handler.video", "%d video get online cache sec", new Object[]{Integer.valueOf(this.yFV.hashCode())});
            ar.Hg();
            c.CU().a(w.a.xtK, Boolean.valueOf(true));
            try {
                if (this.yFV.ruY && this.yFV.yFF != null) {
                    return (long) this.yFV.yFF.hTE;
                }
            } catch (Exception e) {
            }
            return 0;
        }
    };
    private e ruN = new 7(this);
    private boolean ruY;
    long rvc = 0;
    long rvd = 0;
    private ak rve = new ak(new 15(this), true);
    private long rvi;
    int rvj;
    private long viX = 0;
    private com.tencent.mm.plugin.sight.decode.ui.b vjc = new com.tencent.mm.plugin.sight.decode.ui.b(this) {
        final /* synthetic */ i yFV;

        {
            this.yFV = r1;
        }

        public final void agX() {
            if (this.yFV.yCR.cuz() != null) {
                this.yFV.a(this.yFV.yCR.cuz());
            }
            this.yFV.yCR.yCS.yFr.TG();
        }

        public final void kH(int i) {
            String str = null;
            try {
                str = this.yFV.yCR.cuz().cvl().yGl.Ur();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "", new Object[0]);
                x.e("MicroMsg.Imagegallery.handler.video", "on seek get video path error: " + e.toString());
            }
            x.i("MicroMsg.Imagegallery.handler.video", "on seek to time[%d] isOnlinePlay[%b] videoPath[%s]", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.yFV.ruY), str});
            if (bh.ov(str)) {
                cf cuy = this.yFV.yCR.cuy();
                if (cuy != null && cuy.cjh()) {
                    t.d(cuy.field_imgPath, i * 1000, this.yFV.ruY);
                }
                this.yFV.yCR.FQ(this.yFV.yCR.yCS.cuT());
            } else {
                boolean ai;
                if (this.yFV.ruY) {
                    ai = this.yFV.yFF.ai(i, true);
                } else {
                    this.yFV.F(i, true);
                    ai = true;
                }
                if (ai) {
                    this.yFV.bX(false);
                }
            }
            this.yFV.yCR.yCS.cuQ();
        }
    };
    private HashMap<String, a> yEI = new HashMap();
    private com.tencent.mm.sdk.b.c yFD;
    final SparseArray<r> yFE = new SparseArray();
    private l yFF = new l(this);
    private boolean yFG = false;
    private boolean yFH = false;
    private boolean yFI = false;
    private int yFJ = 0;
    private int yFK = 0;
    private int yFL = 0;
    private boolean yFM = false;
    af yFO = new af(Looper.getMainLooper(), new 11(this));
    private int yFP = 0;
    private com.tencent.mm.sdk.b.c<kz> yFQ = new 4(this);
    private boolean yFR = false;
    private int yFS = 0;
    private int[] yFT = new int[]{DownloadResult.CODE_UNDEFINED, -2000, 3400};

    static /* synthetic */ void a(i iVar, String str, int i) {
        x.i("MicroMsg.Imagegallery.handler.video", "download online video error. mediaId: " + str);
        iVar.bzO();
        l lVar = iVar.yFF;
        x.i("MicroMsg.OnlineVideoUIHelper", "deal stream error.");
        if (lVar.LT(str)) {
            lVar.hTx = 2;
            o.TV().b(lVar.mediaId, lVar.cvq());
        }
        g.pQN.a(354, 9, 1, false);
        if (i == -10012) {
            x.w("MicroMsg.Imagegallery.handler.video", "download online video time out, quit imageGalleryUI.");
            ag.y(new 17(iVar));
            return;
        }
        ag.y(new 2(iVar, i));
    }

    public i(b bVar) {
        super(bVar);
        com.tencent.mm.sdk.b.a aVar = com.tencent.mm.sdk.b.a.xef;
        com.tencent.mm.sdk.b.c agVar = new com.tencent.mm.ui.chatting.ag(com.tencent.mm.ui.chatting.ag.a.yxz, bVar.yCS);
        this.yFD = agVar;
        aVar.b(agVar);
        com.tencent.mm.sdk.b.a.xef.b(this.yFQ);
        this.jtl = new d();
    }

    public final boolean a(j jVar, au auVar, int i) {
        super.a(jVar, auVar, i);
        r bq = bq(auVar);
        if (auVar == null) {
            x.e("MicroMsg.Imagegallery.handler.video", "msg is null!!");
            return false;
        }
        if (this.yEI != null) {
            this.yEI.put(auVar.field_imgPath, new a(auVar, i));
        } else {
            x.e("MicroMsg.Imagegallery.handler.video", "mCacheMap is null!");
        }
        if (bq == null) {
            return false;
        }
        o.TU();
        jVar.cvl().yGj.setImageBitmap(BackwardSupportUtil.b.b(s.nu(auVar.field_imgPath), 1.0f));
        if (jVar.cvl().yGl.isPlaying()) {
            jVar.cvl().yGl.stop();
        }
        jVar.yGn.setVisibility(8);
        jVar.cvl().yGm.setVisibility(8);
        jVar.cvl().yGt.setVisibility(8);
        jVar.a(false, 0.0f);
        this.yFK = 0;
        this.rvc = bh.Wp();
        return true;
    }

    public static r bq(au auVar) {
        if (b.aX(auVar)) {
            return t.nF(auVar.field_imgPath);
        }
        return null;
    }

    public final void pause(int i) {
        a(FJ(i));
        this.jtl.bx(false);
        this.yCR.yCS.mV(true);
    }

    public final void g(au auVar, int i) {
        x.i("MicroMsg.Imagegallery.handler.video", "toggle video");
        if (auVar != null) {
            if (b.aX(auVar) || b.aY(auVar)) {
                r bq = bq(auVar);
                if (bq == null) {
                    return;
                }
                if (this.ruY && this.yFF != null && this.yFF.hTD) {
                    x.i("MicroMsg.Imagegallery.handler.video", "%d it loading video data, do not response button click.", new Object[]{Integer.valueOf(hashCode())});
                } else if (this.yCR.yCS.bQg()) {
                    a(FJ(i));
                    this.yCR.yCS.mV(true);
                    this.yCR.yCS.yFr.TG();
                    this.jtl.bx(false);
                    x.i("MicroMsg.Imagegallery.handler.video", "toggle pause video.");
                } else {
                    ar.Hg();
                    if (c.isSDCardAvailable()) {
                        int currentPosition;
                        if (this.ruY) {
                            try {
                                if (this.yCR.cuz().yGl != null) {
                                    currentPosition = this.yCR.cuz().yGl.getCurrentPosition() / 1000;
                                    if (this.yFF != null) {
                                        x.w("MicroMsg.Imagegallery.handler.video", "%d toggle video but online video helper is null.", new Object[]{Integer.valueOf(hashCode())});
                                    } else if (this.yFF.iI(currentPosition)) {
                                        x.i("MicroMsg.Imagegallery.handler.video", "toggle start timer.");
                                        bX(false);
                                    } else {
                                        x.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
                                        a(auVar, bq, i, this.ruY);
                                    }
                                }
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "", new Object[0]);
                            }
                            currentPosition = 0;
                            if (this.yFF != null) {
                                x.w("MicroMsg.Imagegallery.handler.video", "%d toggle video but online video helper is null.", new Object[]{Integer.valueOf(hashCode())});
                            } else if (this.yFF.iI(currentPosition)) {
                                x.i("MicroMsg.Imagegallery.handler.video", "toggle start timer.");
                                bX(false);
                            } else {
                                x.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
                                a(auVar, bq, i, this.ruY);
                            }
                        } else {
                            if (auVar.field_isSend == 0) {
                                if (bq.status == 113 || bq.status == bc.CTRL_INDEX) {
                                    a(auVar, bq);
                                } else {
                                    if (bq.status == 199) {
                                        a(auVar, bq, i, false);
                                    }
                                    if (bq.status == 111) {
                                        a(auVar, bq);
                                    }
                                    if (bq.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                                        a(auVar, bq);
                                    }
                                    if (bq.status == 121 || bq.status == 122) {
                                        a(auVar, bq);
                                    }
                                    if (bq.status == 123) {
                                        a(auVar, bq, i, false);
                                    }
                                }
                            }
                            if (auVar.field_isSend == 1) {
                                currentPosition = bq.status;
                                if (currentPosition == 111 || currentPosition == 113 || currentPosition == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || currentPosition == 121 || currentPosition == 122) {
                                    x.i("MicroMsg.Imagegallery.handler.video", "download video. msg talker[%s], info status[%d]", new Object[]{auVar.field_talker, Integer.valueOf(currentPosition)});
                                    a(auVar, bq);
                                } else {
                                    a(auVar, bq, i, false);
                                }
                            }
                        }
                        if (this.yCR.yCS.yFq) {
                            this.yCR.yCS.cuQ();
                        }
                        cvh();
                        return;
                    }
                    u.fI(this.yCR.yCS.mController.xIM);
                }
            }
        }
    }

    public final void h(au auVar, int i) {
        x.i("MicroMsg.Imagegallery.handler.video", "toggleVideoMenu pos ");
        r nF = t.nF(auVar.field_imgPath);
        if (nF != null && !nF.Uj()) {
            a(FJ(i));
            this.yCR.yCS.mV(true);
            if (this.ruY) {
                this.yFF.cvn();
                this.yFF.reset();
            }
            a(auVar, nF);
            if (this.yCR.yCS.gm(auVar.field_msgId) == 2) {
                dn(auVar.field_imgPath, 8);
            } else {
                dn(auVar.field_imgPath, 5);
            }
        }
    }

    private void a(au auVar, r rVar, int i, boolean z) {
        if (auVar != null && rVar != null) {
            if (auVar.cjs()) {
                Toast.makeText(this.yCR.yCS, R.l.eTa, 0).show();
                return;
            }
            String nt;
            String Uf;
            if (rVar.hVO == -1) {
                Uf = rVar.Uf();
                if (!com.tencent.mm.a.e.bO(Uf)) {
                    o.TU();
                    nt = s.nt(auVar.field_imgPath);
                }
                nt = Uf;
            } else {
                o.TU();
                Uf = s.nt(auVar.field_imgPath);
                if (auVar.field_isSend == 1 && rVar.hVR != null && rVar.hVR.wwP) {
                    try {
                        String mg = FileOp.mg(Uf);
                        if (!mg.endsWith("/")) {
                            mg = mg + "/";
                        }
                        mg = mg + com.tencent.mm.a.e.bR(Uf) + "_hd.mp4";
                        x.i("MicroMsg.Imagegallery.handler.video", "local capture video, hdFilePath: %s, exist: %s", new Object[]{mg, Boolean.valueOf(FileOp.bO(mg))});
                        if (!FileOp.bO(mg)) {
                            mg = Uf;
                        }
                        nt = mg;
                    } catch (Exception e) {
                        x.e("MicroMsg.Imagegallery.handler.video", "try to get hd filePath error: %s", new Object[]{e.getMessage()});
                    }
                }
                nt = Uf;
            }
            if (nt == null || !com.tencent.mm.a.e.bO(nt)) {
                Toast.makeText(this.yCR.yCS, R.l.eTa, 0).show();
                return;
            }
            j FJ = FJ(i);
            if (FJ != null) {
                int gl;
                if (com.tencent.mm.z.s.eV(rVar.Ud())) {
                    gl = m.gl(rVar.Ud());
                } else {
                    gl = 0;
                }
                boolean nm = q.nm(nt);
                x.i("MicroMsg.Imagegallery.handler.video", "play video pos[%d], isOnlinePlay[%b] opcode[%d] resetByCompletion[%b]", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(this.yCR.yCS.gm(auVar.field_msgId)), Boolean.valueOf(this.yFM)});
                if (nm) {
                    g.pQN.h(12084, new Object[]{Integer.valueOf(rVar.hlp), Integer.valueOf(rVar.hVH * 1000), Integer.valueOf(0), Integer.valueOf(3), rVar.Ud(), Integer.valueOf(gl), r.nq(rVar.Ug()), Long.valueOf(rVar.hVE)});
                    if (!com.tencent.mm.pluginsdk.j.b.a.a.c(nt, this.yCR.yCS.mController.xIM, nm)) {
                        Toast.makeText(this.yCR.yCS.mController.xIM, this.yCR.yCS.getString(R.l.eTj), 0).show();
                    }
                } else if (com.tencent.mm.compatible.d.q.gGe.gFb != 1 || !com.tencent.mm.pluginsdk.j.b.a.a.b(rVar.getFileName(), this.yCR.yCS.mController.xIM, nm)) {
                    ar.Hg();
                    if (((Integer) c.CU().get(w.a.xsG, Integer.valueOf(0))).intValue() == 1 && FJ.yGn != null) {
                        FJ.yGn.setVisibility(0);
                        FJ.yGn.setText(com.tencent.mm.plugin.sight.base.d.Ff(nt));
                    }
                    int i2 = rVar.hVH;
                    int i3 = rVar.hlp;
                    String Ud = rVar.Ud();
                    String nq = r.nq(rVar.Ug());
                    long j = rVar.hVE;
                    FJ.rkQ = i2;
                    FJ.yGy = i3;
                    FJ.yGz = gl;
                    FJ.fzO = Ud;
                    FJ.fzR = nq;
                    FJ.hVE = j;
                    this.ruY = z;
                    this.yFG = true;
                    this.filename = rVar.getFileName();
                    if (r4 == 3) {
                        FJ.cvl().yGl.setMute(true);
                    } else {
                        FJ.cvl().yGl.setMute(false);
                    }
                    if (FJ.cvl().yGl.Ur() == null || !FJ.cvl().yGl.Ur().equals(nt) || FJ.cvl().yGl.isPlaying() || this.yFM) {
                        this.yFI = false;
                        this.yFM = false;
                        FJ.cvl().yGl.setVideoPath(nt);
                        if (FJ.cvl().yGl instanceof VideoPlayerTextureView) {
                            boolean z2;
                            ((VideoPlayerTextureView) FJ.cvl().yGl).opG = this.opG;
                            VideoPlayerTextureView videoPlayerTextureView = (VideoPlayerTextureView) FJ.cvl().yGl;
                            if (this.ruY) {
                                ar.Hg();
                                z2 = c.CU().getBoolean(w.a.xtK, false);
                            } else {
                                z2 = false;
                            }
                            videoPlayerTextureView.gz(z2);
                            ((VideoPlayerTextureView) FJ.cvl().yGl).gA(z);
                        }
                        FJ.a(true, 0.0f);
                    } else {
                        FJ.a(true, 1.0f);
                        FJ.cvl().yGl.start();
                        bzN();
                        if (!z) {
                            Zp(this.filename);
                        }
                        Gh(FJ.cvl().yGl.getCurrentPosition() / 1000);
                        bX(false);
                    }
                    this.yFE.put(i, rVar);
                    this.yCR.yCS.mV(false);
                    this.yCR.yCS.mController.xIM.getWindow().addFlags(FileUtils.S_IWUSR);
                    if (com.tencent.mm.compatible.util.d.fN(18)) {
                        Zp(this.filename);
                    }
                    this.jtl.a(this);
                } else {
                    return;
                }
                FJ.cvl().yGm.setVisibility(8);
            }
        }
    }

    private void a(au auVar, r rVar) {
        if (ab.bC(this.yCR.yCS.mController.xIM) || yFN) {
            b(auVar, rVar);
        } else {
            h.a(this.yCR.yCS.mController.xIM, R.l.eSZ, R.l.dGO, new 1(this, auVar, rVar), null);
        }
    }

    private void b(au auVar, r rVar) {
        x.i("MicroMsg.Imagegallery.handler.video", "startDownloading [%d]", new Object[]{Integer.valueOf(hashCode())});
        if (auVar != null && rVar != null) {
            j cuz = this.yCR.cuz();
            if (cuz != null) {
                Object obj;
                aj.t(auVar);
                int gm = this.yCR.yCS.gm(auVar.field_msgId);
                x.d("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode : " + gm);
                switch (gm) {
                    case 0:
                        break;
                    case 1:
                    case 2:
                        if (rVar.Ui()) {
                            x.i("MicroMsg.Imagegallery.handler.video", "start complete online video");
                            t.nJ(auVar.field_imgPath);
                        } else {
                            x.i("MicroMsg.Imagegallery.handler.video", "start complete offline video");
                            dn(auVar.field_imgPath, 10);
                            t.nB(auVar.field_imgPath);
                        }
                        o.TU().a(this, Looper.getMainLooper());
                        this.yCR.yCS.cuS();
                        this.yFR = false;
                        cuz.cvl().yGk.setVisibility(8);
                        cuz.cvl().yGm.setVisibility(0);
                        cuz.cvl().yGm.setProgress(t.f(rVar));
                        if (gm == 2) {
                            g.pQN.a(354, 14, 1, false);
                            return;
                        } else {
                            g.pQN.a(354, 11, 1, false);
                            return;
                        }
                    case 3:
                        x.i("MicroMsg.Imagegallery.handler.video", "%d mute play video [%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(gm)});
                        break;
                    default:
                        x.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[]{Integer.valueOf(gm)});
                        return;
                }
                l lVar = this.yFF;
                String str = auVar.field_imgPath;
                com.tencent.mm.modelcontrol.d.MU();
                if (com.tencent.mm.modelcontrol.d.MZ()) {
                    lVar.reset();
                    r nF = t.nF(str);
                    if (nF == null || nF.hlp >= lVar.yGU.yGW) {
                        j jVar;
                        t.Z(str, 1);
                        n.TS();
                        o.TV();
                        if (bh.ov(str)) {
                            jVar = null;
                        } else {
                            r nF2 = t.nF(str);
                            if (nF2 == null) {
                                jVar = null;
                            } else {
                                Map y = bi.y(nF2.Ug(), "msg");
                                if (y == null) {
                                    x.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
                                    jVar = null;
                                } else {
                                    String str2 = (String) y.get(".msg.videomsg.$cdnvideourl");
                                    if (bh.ov(str2)) {
                                        x.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
                                        jVar = null;
                                    } else {
                                        int intValue = Integer.valueOf((String) y.get(".msg.videomsg.$length")).intValue();
                                        String str3 = (String) y.get(".msg.videomsg.$md5");
                                        String str4 = (String) y.get(".msg.videomsg.$aeskey");
                                        String str5 = (String) y.get(".msg.videomsg.$fileparam");
                                        String a = com.tencent.mm.modelcdntran.d.a("downvideo", nF2.hVE, nF2.Ud(), nF2.getFileName());
                                        if (bh.ov(a)) {
                                            x.w("MicroMsg.OnlineVideoService", "cdntra genClientId failed not use cdn file:%s", new Object[]{nF2.getFileName()});
                                            jVar = null;
                                        } else {
                                            o.TU();
                                            String nt = s.nt(str);
                                            j jVar2 = new j();
                                            jVar2.filename = str;
                                            jVar2.htH = str3;
                                            jVar2.htI = intValue;
                                            jVar2.htJ = 1;
                                            jVar2.fzO = nF2.Ue();
                                            jVar2.htK = nF2.Ud();
                                            jVar2.fzQ = com.tencent.mm.z.s.eV(nF2.Ud()) ? m.gl(nF2.Ud()) : 0;
                                            jVar2.field_mediaId = a;
                                            jVar2.field_fullpath = nt;
                                            jVar2.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
                                            jVar2.field_totalLen = intValue;
                                            jVar2.field_aesKey = str4;
                                            jVar2.field_fileId = str2;
                                            jVar2.field_priority = com.tencent.mm.modelcdntran.b.hrK;
                                            jVar2.field_wxmsgparam = str5;
                                            jVar2.field_chattype = com.tencent.mm.z.s.eV(nF2.Ud()) ? 1 : 0;
                                            jVar2.htL = nF2.htL;
                                            cf F = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().F(nF2.Ud(), nF2.fFo);
                                            ba.b hT = ba.hT(F.gjF);
                                            jVar2.initialDownloadLength = hT != null ? hT.hgQ : 0;
                                            jVar2.initialDownloadOffset = 0;
                                            jVar2.htN = F.field_createTime;
                                            jVar2.fFo = F.field_msgSvrId;
                                            jVar2.htO = hT != null ? hT.hgR : 0;
                                            if (jVar2.initialDownloadLength > 0) {
                                                g.pQN.a(354, 36, 1, false);
                                            }
                                            jVar2.field_autostart = false;
                                            jVar2.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(1, nF2);
                                            jVar = jVar2;
                                        }
                                    }
                                }
                            }
                        }
                        if (jVar == null) {
                            obj = null;
                        } else {
                            lVar.mediaId = jVar.field_mediaId;
                            lVar.iFv = jVar.htI;
                            lVar.filename = str;
                            lVar.hTx = 1;
                            lVar.hTA = 0;
                            o.TV().a(jVar, o.TZ().Us());
                            lVar.htG = bh.Wp();
                            g.pQN.a(354, 1, 1, false);
                            x.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[]{lVar.mediaId, str, Long.valueOf(lVar.htG)});
                            obj = 1;
                        }
                    } else {
                        x.i("MicroMsg.OnlineVideoUIHelper", "video size[%d] less than config size[%d], do not stream video", new Object[]{Integer.valueOf(nF.hlp), Integer.valueOf(lVar.yGU.yGW)});
                        t.b(nF, 9);
                        g.pQN.a(354, 17, 1, false);
                        obj = null;
                    }
                } else {
                    obj = null;
                }
                if (obj != null) {
                    x.i("MicroMsg.Imagegallery.handler.video", "start online play video.");
                    this.ruY = true;
                    o.TU().a((a) this);
                    this.yCR.yCS.cuS();
                    this.yFR = false;
                    cuz.cvl().yGk.setVisibility(8);
                    cuz.cvl().yGm.setVisibility(8);
                    cuz.cvl().yGt.setVisibility(0);
                    return;
                }
                x.i("MicroMsg.Imagegallery.handler.video", "start offline play video.");
                this.ruY = false;
                o.TU().a(this, Looper.getMainLooper());
                t.nB(auVar.field_imgPath);
                this.yCR.yCS.cuS();
                this.yFR = false;
                cuz.cvl().yGk.setVisibility(8);
                cuz.cvl().yGm.setVisibility(0);
                cuz.cvl().yGm.setProgress(t.f(rVar));
            }
        }
    }

    private void dn(String str, int i) {
        ar.Dm().F(new 10(this, str, i));
    }

    private boolean b(a aVar) {
        if (aVar == null) {
            return false;
        }
        o.TU().a((a) this);
        if (this.yCR.yCS.cuT() == aVar.pos) {
            j FJ = FJ(aVar.pos);
            if (FJ != null) {
                FJ.cvl().yGt.setVisibility(8);
                FJ.cvl().yGm.setVisibility(8);
                FJ.cvl().yGk.setVisibility(8);
            }
            this.yFR = true;
            this.yCR.yCS.cuR();
            return true;
        }
        this.yCR.FS(aVar.pos);
        return false;
    }

    public final void cuG() {
        x.i("MicroMsg.Imagegallery.handler.video", "stopAll. video handler hash code : " + hashCode());
        this.rvd = bh.Wp();
        SparseArray sparseArray = this.yCR.yeR;
        int i = 0;
        boolean z = false;
        while (i < sparseArray.size()) {
            boolean z2;
            int keyAt = sparseArray.keyAt(i);
            if (!(sparseArray.get(keyAt) == null || ((View) sparseArray.get(keyAt)).getTag() == null)) {
                j jVar = (j) ((View) sparseArray.get(keyAt)).getTag();
                if (jVar.yGi != null && jVar.cvl().yGi.getVisibility() == 0 && (((View) jVar.cvl().yGl).getVisibility() == 0 || !bh.ov(jVar.cvl().yGl.Ur()) || (this.ruY && this.yFF.isStreaming()))) {
                    x.i("MicroMsg.Imagegallery.handler.video", "stop");
                    bzL();
                    if (jVar != null) {
                        bzO();
                        if (this.ruY) {
                            this.yFF.cvn();
                        }
                        if (!this.yFH) {
                            t.d(this.filename, this.yFJ + DownloadResult.CODE_UNDEFINED, this.ruY);
                        }
                        jVar.cvl().yGm.setVisibility(8);
                        jVar.cvl().yGt.setVisibility(8);
                        jVar.cvl().yGl.stop();
                        Gh(0);
                        jVar.a(false, 0.0f);
                        this.ruY = false;
                        this.yFR = false;
                        this.yFM = false;
                        this.filename = null;
                        this.rvj = 0;
                        this.rvi = 0;
                        this.yFS = 0;
                        this.yFP = 0;
                        this.yFL = 0;
                        this.yFK = 0;
                        this.viX = 0;
                        this.lastCheckTime = 0;
                    }
                    z2 = true;
                    i++;
                    z = z2;
                }
            }
            z2 = z;
            i++;
            z = z2;
        }
        this.jtl.bx(false);
        if (!z && this.ruY) {
            this.yFF.cvn();
            this.ruY = false;
        }
        bzL();
        this.yFE.clear();
    }

    private void a(j jVar) {
        if (jVar != null) {
            bzL();
            x.d("MicroMsg.Imagegallery.handler.video", "pause video.");
            if (jVar.cvl().yGl.isPlaying()) {
                jVar.cvl().yGl.pause();
                bzO();
            }
        }
    }

    protected final void onResume() {
        x.i("MicroMsg.Imagegallery.handler.video", "ui on resume, add online video event.");
        this.yFO.removeMessages(1);
        com.tencent.mm.sdk.b.a.xef.b(this.yFQ);
        if (this.yCR != null && com.tencent.mm.compatible.util.d.fM(21)) {
            j cuz = this.yCR.cuz();
            if (cuz != null && cuz.yGl != null) {
                if (cuz.yGl instanceof VideoPlayerTextureView) {
                    ((VideoPlayerTextureView) cuz.yGl).aZM();
                } else if (cuz.yGl instanceof VideoTextureView) {
                    ((VideoTextureView) cuz.yGl).aZM();
                }
            }
        }
    }

    public final void detach() {
        x.i("MicroMsg.Imagegallery.handler.video", "detach.[%d]", new Object[]{Integer.valueOf(hashCode())});
        this.rvd = bh.Wp();
        this.yFO.removeMessages(1);
        bzL();
        com.tencent.mm.sdk.b.a.xef.c(this.yFD);
        com.tencent.mm.sdk.b.a.xef.c(this.yFQ);
        cuG();
        this.yCR.yCS.mController.xIM.getWindow().clearFlags(FileUtils.S_IWUSR);
        this.yCR.yCS.cuI().yEZ.quk = null;
        super.detach();
        this.yEI.clear();
        this.yEI = null;
        o.TU().a((a) this);
        this.yFE.clear();
        l lVar = this.yFF;
        lVar.reset();
        lVar.hTz = null;
        lVar.yGT = null;
        lVar.yGU = null;
        if (com.tencent.mm.plugin.s.e.aZC()) {
            ar.Dm().F(new 9(this));
        }
        o.TZ().Us();
        o.TZ().run();
    }

    public final void cvf() {
        this.yFH = false;
        this.mvC = 0;
        j cuz = this.yCR != null ? this.yCR.cuz() : null;
        if (cuz == null) {
            x.w("MicroMsg.Imagegallery.handler.video", "notify video prepared, but holder is null.");
            return;
        }
        int fM = bh.fM((long) cuz.cvl().yGl.getDuration());
        int i = this.yCR.yCS.cuI().yEZ.qur;
        x.i("MicroMsg.Imagegallery.handler.video", "%d videoDuration %d hadSetTotalTime %d", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(fM), Integer.valueOf(i)});
        if (i <= 0 || Math.abs(i - fM) >= 2) {
            this.yCR.yCS.cuI().yEZ.wl(fM);
        }
        cvh();
        if (fM == 0 || fM >= 1800) {
            x.w("MicroMsg.Imagegallery.handler.video", "%d repair video duration[%d] error. filename[%s]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(fM), this.filename});
        } else {
            ar.Dm().F(new 6(this, fM));
        }
        fM = t.y(fM, this.filename);
        x.i("MicroMsg.Imagegallery.handler.video", "notify video prepared. isOnlinePlay[%b] playDuration[%d] playVideoWhenNotify[%b] hadPlayError[%b].", new Object[]{Boolean.valueOf(this.ruY), Integer.valueOf(fM), Boolean.valueOf(this.yFG), Boolean.valueOf(this.yFH)});
        cuz.cvl().yGl.a(this.ruN);
        if (this.yFG) {
            if (this.ruY) {
                l lVar = this.yFF;
                if (fM > 0) {
                    x.i("MicroMsg.OnlineVideoUIHelper", "seek to last duration : " + fM);
                    lVar.hTB = fM;
                    lVar.hTD = true;
                    lVar.hTy = 2;
                }
                this.yFF.iH(0);
            } else {
                this.yFF.reset();
                bzN();
                F(fM, true);
            }
            bX(false);
            return;
        }
        if (this.ruY) {
            this.yFF.ai(fM, false);
        } else {
            F(fM, false);
        }
        Gh(fM);
        this.yCR.yCS.mV(true);
        bzL();
    }

    public final void cvg() {
        int i;
        a aVar;
        x.i("MicroMsg.Imagegallery.handler.video", "notify video completion. isOnlinePlay : " + this.ruY);
        bzL();
        bzO();
        if (!(!this.ruY || this.yCR == null || this.yCR.cuz() == null)) {
            f fVar = this.yCR.cuz().cvl().yGl;
            if (fVar != null && fVar.getCurrentPosition() + MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN < fVar.getDuration()) {
                x.e("MicroMsg.Imagegallery.handler.video", "notify video completion, but cur pos[%d] is less than duration[%d]", new Object[]{Integer.valueOf(fVar.getCurrentPosition()), Integer.valueOf(fVar.getDuration())});
                i = 0;
                if (i == 0) {
                    ag.y(new 12(this));
                }
                try {
                    t.d(this.filename, this.yCR.cuz().yGl.getCurrentPosition(), this.ruY);
                    this.yCR.cuz().yGl.stop();
                    this.yFF.cvo();
                    i = this.yFP + 1;
                    this.yFP = i;
                    if (i <= 3) {
                        aVar = (a) this.yEI.get(this.filename);
                        if (aVar != null && aVar.fnB != null) {
                            a(aVar.fnB, bq(aVar.fnB), aVar.pos, this.ruY);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "notify video completion error[%s]", new Object[]{e.toString()});
                    return;
                }
            }
        }
        i = 1;
        if (i == 0) {
            t.d(this.filename, this.yCR.cuz().yGl.getCurrentPosition(), this.ruY);
            this.yCR.cuz().yGl.stop();
            this.yFF.cvo();
            i = this.yFP + 1;
            this.yFP = i;
            if (i <= 3) {
                aVar = (a) this.yEI.get(this.filename);
                if (aVar != null) {
                    return;
                }
                return;
            }
            return;
        }
        ag.y(new 12(this));
    }

    public final void eY(int i, int i2) {
        String str = "MicroMsg.Imagegallery.handler.video";
        String str2 = "notify video error, what %d, extras %d isOnlinePlay %b isLoading %b ";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(this.ruY);
        l lVar = this.yFF;
        boolean z = !bh.ov(lVar.mediaId) && lVar.hTx == 1;
        objArr[3] = Boolean.valueOf(z);
        x.e(str, str2, objArr);
        this.yFH = true;
        this.mvC = i2;
        if (this.ruY) {
            if (i == -1) {
                bzL();
                this.yCR.cuz().yGl.stop();
                this.yFF.cvo();
            } else if (i == -2) {
                bzL();
                t.d(this.filename, this.yCR.cuz().yGl.getCurrentPosition(), this.ruY);
                this.yCR.cuz().yGl.stop();
                this.yFF.cvo();
            } else if (i == -3) {
                this.yFH = false;
                this.yFF.cvo();
                return;
            }
            this.yFR = false;
            this.yCR.yCS.mV(true);
            this.yCR.cuz().cvl().yGt.setVisibility(0);
            bzO();
            g.pQN.a(354, 18, 1, false);
            return;
        }
        String str3;
        t.nI(this.filename);
        bzO();
        if (this.yCR == null || this.yCR.cuz() == null || this.yCR.cuz().yGl == null) {
            str3 = "";
        } else {
            str3 = this.yCR.cuz().yGl.Ur();
            this.yCR.cuz().yGl.stop();
        }
        if (this.yFI) {
            x.i("MicroMsg.Imagegallery.handler.video", "%d had play completion don't show error tips", new Object[]{Integer.valueOf(hashCode())});
            return;
        }
        ag.y(new 13(this, str3));
        g.pQN.a(354, 25, 1, false);
    }

    private void bzL() {
        x.i("MicroMsg.Imagegallery.handler.video", "clear timer");
        this.rve.TG();
        this.kTk.TG();
    }

    protected final void bX(boolean z) {
        if (!this.yFH) {
            if (!this.ruY) {
                this.kTk.J(500, 500);
            } else if (z) {
                ag.y(new 14(this));
            } else {
                this.rve.J(500, 500);
            }
        }
    }

    public final void Gg(int i) {
        this.yFE.remove(i);
    }

    public final void a(s$a$a com_tencent_mm_modelvideo_s_a_a) {
        String str = com_tencent_mm_modelvideo_s_a_a.fileName;
        if (!bh.ov(str) && this.yEI != null) {
            a aVar = (a) this.yEI.get(str);
            if (aVar != null) {
                au auVar = aVar.fnB;
                if (auVar != null && auVar.field_imgPath != null && auVar.field_imgPath.equals(str)) {
                    r bq = bq(auVar);
                    if (bq == null) {
                        return;
                    }
                    if (!auVar.cjs() && bq.status != bc.CTRL_INDEX) {
                        int f = t.f(bq);
                        j FJ = FJ(aVar.pos);
                        if (this.yCR.yCS.cuT() == aVar.pos && FJ != null) {
                            this.yCR.yCS.cuS();
                            this.yFR = false;
                            FJ.cvl().yGm.setVisibility(0);
                            FJ.cvl().yGm.setProgress(f);
                        } else if (FJ == null) {
                            return;
                        }
                        if (f >= FJ.cvl().yGm.zua) {
                            x.d("MicroMsg.Imagegallery.handler.video", "onNotifyChange, status:%d", new Object[]{Integer.valueOf(bq.status)});
                            if ((bq.status == 199 || bq.status == 199) && b(aVar)) {
                                this.yCR.yCS.ft(true);
                                switch (this.yCR.yCS.gm(auVar.field_msgId)) {
                                    case 0:
                                    case 3:
                                        a(auVar, bq, this.yCR.yCS.cuT(), false);
                                        return;
                                    case 1:
                                        x.d("MicroMsg.Imagegallery.handler.video", "do restransmit video");
                                        g.pQN.a(354, 15, 1, false);
                                        this.yCR.be(auVar);
                                        this.yCR.yCS.gn(-1);
                                        if (this.ruY) {
                                            t.d(this.filename, this.yCR.cuz().yGl.getCurrentPosition(), this.ruY);
                                            this.yFM = true;
                                        }
                                        this.ruY = false;
                                        return;
                                    case 2:
                                        g.pQN.a(354, 16, 1, false);
                                        b.a(this.yCR.yCS, auVar, true);
                                        this.yCR.yCS.gn(-1);
                                        if (this.ruY) {
                                            t.d(this.filename, this.yCR.cuz().yGl.getCurrentPosition(), this.ruY);
                                            this.yFM = true;
                                        }
                                        this.ruY = false;
                                        return;
                                    default:
                                        x.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[]{Integer.valueOf(this.yCR.yCS.gm(auVar.field_msgId))});
                                        return;
                                }
                            }
                        }
                    } else if (b(aVar)) {
                        Toast.makeText(this.yCR.yCS, R.l.eTa, 0).show();
                    }
                }
            }
        }
    }

    private void cvh() {
        try {
            this.yCR.yCS.cuI().yEZ.quk = this.vjc;
        } catch (Exception e) {
        }
    }

    protected final void aI(String str, boolean z) {
        ag.y(new 5(this, str, z));
    }

    protected final void F(int i, boolean z) {
        j cuz = this.yCR.cuz();
        if (cuz != null) {
            bzN();
            cuz.cvl().yGt.setVisibility(8);
            cuz.cvl().yGl.c((double) (i * 1000), z);
            this.yCR.yCS.mV(false);
            bX(false);
        }
    }

    protected final void TF() {
        j cuz = this.yCR.cuz();
        if (cuz != null) {
            x.i("MicroMsg.Imagegallery.handler.video", "start to pause");
            this.yCR.yCS.mV(true);
            cuz.cvl().yGt.setVisibility(0);
            cuz.cvl().yGl.pause();
            bzO();
        }
    }

    protected final boolean bzM() {
        j cuz = this.yCR.cuz();
        if (cuz == null) {
            return false;
        }
        boolean z = true;
        if (!cuz.cvl().yGl.isPlaying()) {
            x.i("MicroMsg.Imagegallery.handler.video", "start to play");
            this.yCR.yCS.mV(false);
            cuz.cvl().yGt.setVisibility(8);
            z = cuz.cvl().yGl.start();
            bzN();
        }
        if (cuz.cvl().yGt.getVisibility() == 8) {
            return z;
        }
        cuz.cvl().yGt.setVisibility(8);
        return z;
    }

    protected final void Gh(int i) {
        this.yCR.yCS.cuI().yEZ.seek(Math.max(0, i));
    }

    protected final void Zp(String str) {
        if (!this.yFR && !b((a) this.yEI.get(str))) {
            x.w("MicroMsg.Imagegallery.handler.video", "show tool bar error.");
        }
    }

    private void bzN() {
        this.rvi = bh.Wp();
        x.d("MicroMsg.Imagegallery.handler.video", "notePlayVideo filename %s notePlayVideo %d ", new Object[]{this.filename, Long.valueOf(this.rvi)});
    }

    private void bzO() {
        if (this.rvi > 0) {
            this.rvj = (int) (((long) this.rvj) + ((bh.Wp() - this.rvi) / 1000));
        }
        x.i("MicroMsg.Imagegallery.handler.video", "notePauseVideo filename %s playVideoDuration %d ", new Object[]{this.filename, Integer.valueOf(this.rvj)});
        this.rvi = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(j jVar) {
        int i = this.yFJ;
        this.yFJ = jVar.cvl().yGl.getCurrentPosition();
        if (i != this.yFJ) {
            this.lastCheckTime = bh.Wp();
            long bth = jVar.cvl().yGl.bth();
            if (bth <= 0 || bth == this.viX) {
                if (this.yFK != -1) {
                    this.yFK++;
                    x.w("MicroMsg.Imagegallery.handler.video", "media play is playing[%d], but surface is not update!! repair time[%d]", new Object[]{Integer.valueOf(this.yFK), Integer.valueOf(this.yFL)});
                    if (this.yFL >= 2) {
                        this.yFF.cvo();
                    }
                    switch (this.yFK) {
                        case 0:
                        case 1:
                            break;
                        case 2:
                            x.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[]{Integer.valueOf(this.yFJ / 1000)});
                            F(i, true);
                            this.yFL++;
                            return false;
                        case 3:
                            i = (this.yFJ - 2000) / 1000;
                            if (i < 0) {
                                i = 0;
                            }
                            x.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[]{Integer.valueOf(i)});
                            F(i, true);
                            this.yFL++;
                            return false;
                        case 4:
                            i = (this.yFJ - 4000) / 1000;
                            if (i < 0) {
                                i = 0;
                            }
                            x.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[]{Integer.valueOf(i)});
                            F(i, true);
                            this.yFL++;
                            return false;
                        default:
                            x.w("MicroMsg.Imagegallery.handler.video", "rpt surface not update!!");
                            x.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptSurfaceNotUpdate %s", new Object[]{Integer.valueOf(hashCode()), this.filename});
                            g.pQN.h(13836, new Object[]{Integer.valueOf(300), Long.valueOf(bh.Wo()), ""});
                            g.pQN.a(354, 20, 1, false);
                            this.yFK = -1;
                            break;
                    }
                }
            }
            this.viX = bth;
            switch (this.yFK) {
                case 2:
                    i = 21;
                    break;
                case 3:
                    i = 22;
                    break;
                case 4:
                    i = 23;
                    break;
                default:
                    this.yFK = 0;
                    break;
            }
        }
        x.i("MicroMsg.Imagegallery.handler.video", "check time[%d, %d], play time[%d, %d]", new Object[]{Long.valueOf(this.lastCheckTime), Long.valueOf(bh.Wp()), Integer.valueOf(i), Integer.valueOf(this.yFJ)});
        if (this.lastCheckTime > 0 && bh.bz(this.lastCheckTime) >= 1500) {
            x.w("MicroMsg.Imagegallery.handler.video", "play time not update! request all video data to play. ");
            i = this.yCR.cuz().yGl.getCurrentPosition();
            bzL();
            t.d(this.filename, i, this.ruY);
            this.yCR.cuz().yGl.stop();
            this.yFF.cvo();
            a aVar = (a) this.yEI.get(this.filename);
            if (aVar == null || aVar.fnB == null) {
                return false;
            }
            a(aVar.fnB, bq(aVar.fnB), aVar.pos, this.ruY);
            this.lastCheckTime = 0;
            return false;
        }
        return true;
    }
}
