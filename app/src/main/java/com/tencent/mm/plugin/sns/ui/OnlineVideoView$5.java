package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.kz;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView.9;
import com.tencent.mm.plugin.sns.ui.af.1;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$5 extends c<kz> {
    final /* synthetic */ OnlineVideoView rvm;

    OnlineVideoView$5(OnlineVideoView onlineVideoView) {
        this.rvm = onlineVideoView;
        this.xen = kz.class.getName().hashCode();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(kz kzVar) {
        if (OnlineVideoView.k(this.rvm) == null) {
            x.w("MicroMsg.OnlineVideoView", "%d online video helper is null.", new Object[]{Integer.valueOf(this.rvm.hashCode())});
        } else {
            try {
                if (OnlineVideoView.k(this.rvm).LT(kzVar.fCj.mediaId)) {
                    if (kzVar.fCj.retCode == -21112) {
                        OnlineVideoView onlineVideoView = this.rvm;
                        g.pQN.a(354, 218, 1, false);
                        onlineVideoView.kRY.post(new 9(onlineVideoView));
                    } else if (kzVar.fCj.retCode == 0 || kzVar.fCj.retCode == -21006) {
                        int i;
                        int i2;
                        af k;
                        switch (kzVar.fCj.fuL) {
                            case 1:
                                af k2 = OnlineVideoView.k(this.rvm);
                                long j = (long) kzVar.fCj.offset;
                                long j2 = kzVar.fCj.fCk;
                                boolean z = kzVar.fCj.fCl;
                                x.i("MicroMsg.OnlineVideoViewHelper", "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]", new Object[]{Long.valueOf(j), Integer.valueOf(k2.hTA), k2.hTu, Long.valueOf(j2), Long.valueOf(k2.htG)});
                                if (k2.hTA != 0) {
                                    x.w("MicroMsg.OnlineVideoViewHelper", "moov had callback, do nothing.");
                                } else {
                                    if (j2 <= k2.htG) {
                                        j2 = k2.htG;
                                    }
                                    k2.htG = j2;
                                    k2.rvu = bh.Wp();
                                    try {
                                        if (k2.hTz == null) {
                                            x.w("MicroMsg.OnlineVideoViewHelper", "parser is null, thread is error.");
                                        } else if (k2.hTz.r(k2.hTv, j)) {
                                            k2.hTA = k2.hTz.ifa;
                                            x.i("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b", new Object[]{Integer.valueOf(k2.hTA), k2.hTu, Boolean.valueOf(z)});
                                            if (!z) {
                                                ag.y(new 1(k2));
                                            }
                                            if (k2.hTB == -1) {
                                                k2.hTy = 1;
                                            } else {
                                                k2.hTy = 2;
                                            }
                                            g.pQN.a(354, 204, 1, false);
                                        } else {
                                            x.w("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov error. cdnMediaId %s", new Object[]{k2.hTu});
                                            o.TV();
                                            f.f(k2.hTu, 0, -1);
                                            g.pQN.a(354, 205, 1, false);
                                            g.pQN.h(13836, new Object[]{Integer.valueOf(e.CTRL_INDEX), Long.valueOf(bh.Wo()), ""});
                                        }
                                    } catch (Exception e) {
                                        x.e("MicroMsg.OnlineVideoViewHelper", "deal moov ready error: " + e.toString());
                                    }
                                }
                                OnlineVideoView.r(this.rvm);
                                break;
                            case 2:
                                af k3 = OnlineVideoView.k(this.rvm);
                                String str = kzVar.fCj.mediaId;
                                i = kzVar.fCj.offset;
                                i2 = kzVar.fCj.length;
                                k3.hTH = false;
                                if (i < 0 || i2 < 0) {
                                    x.w("MicroMsg.OnlineVideoViewHelper", "deal data available error offset[%d], length[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                                } else if (k3.LT(str)) {
                                    Integer num = (Integer) k3.rvq.get(k3.hTu + i + "_" + i2);
                                    if (num == null || num.intValue() <= 0) {
                                        try {
                                            k3.hTE = k3.hTz.bu(i, i2);
                                        } catch (Exception e2) {
                                            x.e("MicroMsg.OnlineVideoViewHelper", "deal data available file pos to video time error: " + e2.toString());
                                        }
                                    } else {
                                        k3.hTE = num.intValue();
                                    }
                                    x.i("MicroMsg.OnlineVideoViewHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(k3.hTE)});
                                }
                                if (kzVar.fCj.length > 0) {
                                    this.rvm.bX(true);
                                    break;
                                }
                                break;
                            case 3:
                                this.rvm.bX(true);
                                break;
                            case 4:
                                x.i("MicroMsg.OnlineVideoView", "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d", new Object[]{Integer.valueOf(this.rvm.hashCode()), kzVar.fCj.mediaId, Integer.valueOf(OnlineVideoView.s(this.rvm)), Integer.valueOf(OnlineVideoView.t(this.rvm))});
                                k = OnlineVideoView.k(this.rvm);
                                x.i("MicroMsg.OnlineVideoViewHelper", "deal stream finish. playStatus %d cdnMediaId %s", new Object[]{Integer.valueOf(k.hTy), k.hTu});
                                k.hTH = false;
                                k.hTx = 3;
                                g.pQN.a(354, 206, 1, false);
                                if (k.hTy == 0) {
                                    x.w("MicroMsg.OnlineVideoViewHelper", "it had not moov callback and download finish start to play video.");
                                    k.bzV();
                                } else if (k.hTy == 5) {
                                    x.w("MicroMsg.OnlineVideoViewHelper", "it had play error, it request all video data finish, start to play." + k.hTu);
                                    k.bzV();
                                }
                                if (OnlineVideoView.s(this.rvm) <= 0) {
                                    if (OnlineVideoView.t(this.rvm) <= 0) {
                                        if (!OnlineVideoView.v(this.rvm)) {
                                            this.rvm.bX(true);
                                            break;
                                        }
                                        OnlineVideoView.n(this.rvm);
                                        OnlineVideoView.w(this.rvm);
                                        break;
                                    }
                                    OnlineVideoView.n(this.rvm);
                                    OnlineVideoView.b(this.rvm, OnlineVideoView.t(this.rvm), OnlineVideoView.u(this.rvm));
                                    break;
                                }
                                OnlineVideoView.n(this.rvm);
                                OnlineVideoView.b(this.rvm, OnlineVideoView.s(this.rvm));
                                break;
                            case 5:
                                if (OnlineVideoView.j(this.rvm) != 1) {
                                    if (OnlineVideoView.j(this.rvm) == 2) {
                                        OnlineVideoView.a(this.rvm, kzVar.fCj.offset, kzVar.fCj.length);
                                        break;
                                    }
                                }
                                k = OnlineVideoView.k(this.rvm);
                                String str2 = kzVar.fCj.mediaId;
                                i = kzVar.fCj.offset;
                                i2 = kzVar.fCj.length;
                                if (k.LT(str2)) {
                                    k.progress = i;
                                    k.qhf = i2;
                                    k.rvs = (k.progress * 100) / k.qhf;
                                    x.i("MicroMsg.OnlineVideoViewHelper", "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]", new Object[]{k.hTu, Integer.valueOf(k.progress), Integer.valueOf(k.qhf), Integer.valueOf(k.rvs)});
                                }
                                if (k.rvs >= 100) {
                                    k.hTx = 3;
                                    break;
                                }
                                break;
                            case 6:
                                x.i("MicroMsg.OnlineVideoViewHelper", "deal had dup video. cdnMediaId %s", new Object[]{OnlineVideoView.k(this.rvm).hTu});
                                k.bzV();
                                break;
                            default:
                                x.w("MicroMsg.OnlineVideoView", "%d unknown event opcode %d", new Object[]{Integer.valueOf(this.rvm.hashCode()), Integer.valueOf(kzVar.fCj.fuL)});
                                break;
                        }
                    } else {
                        x.w("MicroMsg.OnlineVideoView", "%d stream download online video error. retCode %d ", new Object[]{Integer.valueOf(this.rvm.hashCode()), Integer.valueOf(kzVar.fCj.retCode)});
                    }
                }
            } catch (Exception e22) {
                x.e("MicroMsg.OnlineVideoView", "online video callback error: " + e22.toString());
            }
        }
        return false;
    }
}
