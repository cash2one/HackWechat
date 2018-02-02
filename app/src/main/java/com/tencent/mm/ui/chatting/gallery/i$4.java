package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.g.a.kz;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.gallery.l.1;

class i$4 extends c<kz> {
    final /* synthetic */ i yFV;

    i$4(i iVar) {
        this.yFV = iVar;
        this.xen = kz.class.getName().hashCode();
    }

    private boolean a(kz kzVar) {
        if (!i.f(this.yFV).LT(kzVar.fCj.mediaId)) {
            return false;
        }
        if (kzVar.fCj.retCode == 0 || kzVar.fCj.retCode == -21006) {
            String nt;
            int i;
            l f;
            switch (kzVar.fCj.fuL) {
                case 1:
                    l f2 = i.f(this.yFV);
                    long j = (long) kzVar.fCj.offset;
                    long j2 = kzVar.fCj.fCk;
                    boolean z = kzVar.fCj.fCl;
                    x.i("MicroMsg.OnlineVideoUIHelper", "deal moov ready moovPos[%d] needSeekTime[%d] timeDuration[%d] startDownload[%d %d]", new Object[]{Long.valueOf(j), Integer.valueOf(f2.hTB), Integer.valueOf(f2.hTA), Long.valueOf(j2), Long.valueOf(f2.htG)});
                    if (f2.hTA != 0) {
                        x.w("MicroMsg.OnlineVideoUIHelper", "moov had callback, do nothing.");
                    } else {
                        if (j2 <= f2.htG) {
                            j2 = f2.htG;
                        }
                        f2.htG = j2;
                        g.pQN.a(354, 5, 1, false);
                        f2.rvu = bh.Wp();
                        o.TU();
                        nt = s.nt(f2.filename);
                        try {
                            if (f2.hTz == null) {
                                x.w("MicroMsg.OnlineVideoUIHelper", "parser is null, thread is error.");
                            } else if (f2.hTz.r(nt, j)) {
                                f2.hTA = f2.hTz.ifa;
                                x.i("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov success. duration %d filename %s isFastStart %b", new Object[]{Integer.valueOf(f2.hTA), f2.filename, Boolean.valueOf(z)});
                                if (!z) {
                                    ag.y(new 1(f2));
                                }
                                if (f2.hTB == -1) {
                                    f2.hTy = 1;
                                } else {
                                    f2.hTy = 2;
                                }
                                g.pQN.a(354, 7, 1, false);
                            } else {
                                x.w("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov error.");
                                o.TV();
                                f.f(f2.mediaId, 0, -1);
                                t.Y(f2.filename, 15);
                                g.pQN.a(354, 8, 1, false);
                                x.w("MicroMsg.OnlineVideoUIHelper", "%d rpt parse moov fail %s ", new Object[]{Integer.valueOf(f2.hashCode()), f2.filename});
                                g.pQN.h(13836, new Object[]{Integer.valueOf(HardCoderJNI.SCENE_QUIT_CHATTING), Long.valueOf(bh.Wo()), ""});
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
                            x.e("MicroMsg.OnlineVideoUIHelper", "deal moov ready error: " + e.toString());
                        }
                    }
                    i.a(this.yFV, true);
                    break;
                case 2:
                    l f3 = i.f(this.yFV);
                    nt = kzVar.fCj.mediaId;
                    i = kzVar.fCj.offset;
                    int i2 = kzVar.fCj.length;
                    f3.hTH = false;
                    if (i < 0 || i2 < 0) {
                        x.w("MicroMsg.OnlineVideoUIHelper", "deal data available error offset[%d], length[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    } else if (f3.LT(nt)) {
                        Integer num = (Integer) f3.rvq.get(f3.mediaId + i + "_" + i2);
                        if (num == null || num.intValue() <= 0) {
                            try {
                                f3.hTE = f3.hTz.bu(i, i2);
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e2, "", new Object[0]);
                                x.e("MicroMsg.OnlineVideoUIHelper", "deal data available file pos to video time error: " + e2.toString());
                            }
                        } else {
                            f3.hTE = num.intValue();
                        }
                        x.i("MicroMsg.OnlineVideoUIHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(f3.hTE)});
                    }
                    if (kzVar.fCj.length > 0) {
                        this.yFV.bX(true);
                        break;
                    }
                    break;
                case 3:
                    this.yFV.bX(true);
                    break;
                case 4:
                    f = i.f(this.yFV);
                    x.i("MicroMsg.OnlineVideoUIHelper", "deal stream finish. playStatus %d ", new Object[]{Integer.valueOf(f.hTy)});
                    f.hTH = false;
                    f.hTx = 3;
                    if (f.hTy == 0) {
                        x.w("MicroMsg.OnlineVideoUIHelper", "it had not moov callback and download finish start to play video.");
                        f.bzV();
                        g.pQN.a(354, 6, 1, false);
                    } else if (f.hTy == 5) {
                        x.w("MicroMsg.OnlineVideoUIHelper", "it had play error, it request all video data finish, start to play." + f.mediaId);
                        f.bzV();
                    }
                    f.cvp();
                    g.pQN.a(354, 26, 1, false);
                    this.yFV.bX(true);
                    break;
                case 5:
                    f = i.f(this.yFV);
                    String str = kzVar.fCj.mediaId;
                    i = kzVar.fCj.offset;
                    if (f.LT(str)) {
                        f.rvs = (i * 100) / f.iFv;
                        x.i("MicroMsg.OnlineVideoUIHelper", "deal progress callback. downloadedPercent : " + f.rvs);
                    }
                    if (f.rvs >= 100) {
                        f.hTx = 3;
                        break;
                    }
                    break;
                case 6:
                    f = i.f(this.yFV);
                    x.i("MicroMsg.OnlineVideoUIHelper", "deal had dup video.");
                    f.cvp();
                    f.bzV();
                    break;
                default:
                    x.w("MicroMsg.Imagegallery.handler.video", "unknown event opcode " + kzVar.fCj.fuL);
                    break;
            }
            return false;
        }
        x.w("MicroMsg.Imagegallery.handler.video", "stream download online video error. retCode: " + kzVar.fCj.retCode);
        i.a(this.yFV, kzVar.fCj.mediaId, kzVar.fCj.retCode);
        return false;
    }
}
