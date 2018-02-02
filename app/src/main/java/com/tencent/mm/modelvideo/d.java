package com.tencent.mm.modelvideo;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.c;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.rk;
import com.tencent.mm.protocal.c.rl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.m;
import com.tencent.mm.z.s;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.File;
import java.util.Map;
import junit.framework.Assert;

public final class d extends k implements com.tencent.mm.network.k {
    String fileName;
    private b gJQ;
    e gJT;
    String hBn;
    String hBu;
    int hBv;
    private a hBx;
    boolean hTP;
    boolean hTQ;
    r hTR;
    j hTS;
    int hTT;
    private boolean hTU;
    boolean hTV;
    long hTW;
    private ak hkO;
    int hlp;
    private String mediaId;
    int retCode;
    private int startOffset;
    long startTime;

    protected final void cancel() {
        vo();
        super.cancel();
    }

    final boolean vo() {
        boolean z = false;
        if (!bh.ov(this.mediaId)) {
            if (this.hTP) {
                x.i("MicroMsg.NetSceneDownloadVideo", "%s cancel online video task.", TL());
                o.TV().b(this.mediaId, null);
            } else {
                x.i("MicroMsg.NetSceneDownloadVideo", "%s cancel offline video task.", TL());
                g.MJ().kI(this.mediaId);
            }
            z = true;
        }
        this.hTU = true;
        return z;
    }

    public d(String str) {
        this(str, false);
    }

    public d(String str, boolean z) {
        this.hTR = null;
        this.hBn = "";
        this.startOffset = 0;
        this.startTime = 0;
        this.hlp = 0;
        this.retCode = 0;
        this.hTT = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
        this.hTU = false;
        this.hTV = true;
        this.hBu = null;
        this.hBv = 0;
        this.hTW = 0;
        this.hBx = new 1(this);
        this.hkO = new ak(new 3(this), false);
        Assert.assertTrue(str != null);
        this.fileName = str;
        this.hTP = z;
        x.i("MicroMsg.NetSceneDownloadVideo", "%s NetSceneDownloadVideo:  file [%s] isCompleteOnlineVideo [%b]", TL(), str, Boolean.valueOf(z));
    }

    private boolean TK() {
        x.d("MicroMsg.NetSceneDownloadVideo", "%s parseVideoMsgXML content: %s", TL(), this.hTR.Ug());
        Map y = bi.y(this.hTR.Ug(), "msg");
        if (y == null) {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 214, 1, false);
            x.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", TL());
            return false;
        }
        String str = (String) y.get(".msg.videomsg.$cdnvideourl");
        if (bh.ov(str)) {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 213, 1, false);
            x.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", TL());
            return false;
        }
        String str2 = (String) y.get(".msg.videomsg.$aeskey");
        this.hlp = Integer.valueOf((String) y.get(".msg.videomsg.$length")).intValue();
        String str3 = (String) y.get(".msg.videomsg.$fileparam");
        this.hBn = com.tencent.mm.modelcdntran.d.a("downvideo", this.hTR.hVE, this.hTR.Ud(), this.hTR.getFileName());
        if (bh.ov(this.hBn)) {
            x.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra genClientId failed not use cdn file:%s", TL(), this.hTR.getFileName());
            return false;
        }
        int i;
        Object obj;
        String Ud;
        int i2;
        int subtype;
        if (!this.hTP && this.hlp < 1048576 && this.hTR != null && this.hTR.fzU > 0) {
            this.hTP = true;
            x.i("MicroMsg.NetSceneDownloadVideo", "%s less 1M and had preload, reset isCompleteOnlineVideo [%b]", TL(), Boolean.valueOf(this.hTP));
        }
        String str4 = (String) y.get(".msg.videomsg.$md5");
        StringBuilder stringBuilder = new StringBuilder();
        o.TU();
        String stringBuilder2 = stringBuilder.append(s.nt(this.fileName)).append(".tmp").toString();
        this.hTS = new j();
        this.hTS.filename = this.hTR.getFileName();
        this.hTS.htH = str4;
        this.hTS.htI = this.hlp;
        this.hTS.htJ = 0;
        this.hTS.fzO = this.hTR.Ue();
        this.hTS.htK = this.hTR.Ud();
        this.hTS.fzQ = s.eV(this.hTR.Ud()) ? m.gl(this.hTR.Ud()) : 0;
        this.hTS.field_mediaId = this.hBn;
        this.hTS.field_fullpath = stringBuilder2;
        this.hTS.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
        this.hTS.field_totalLen = this.hlp;
        this.hTS.field_aesKey = str2;
        this.hTS.field_fileId = str;
        this.hTS.field_priority = com.tencent.mm.modelcdntran.b.hrK;
        this.hTS.htt = this.hBx;
        this.hTS.field_wxmsgparam = str3;
        this.hTS.field_chattype = s.eV(this.hTR.Ud()) ? 1 : 0;
        this.hTS.htL = this.hTR.htL;
        au F = ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().F(this.hTR.Ud(), this.hTR.fFo);
        this.hTS.htN = F.field_createTime;
        this.hTS.fFo = F.field_msgSvrId;
        ba.b hT = ba.hT(F.gjF);
        this.hTS.htO = hT != null ? hT.hgR : 0;
        if (this.hTR.Ud().equals(F.field_talker)) {
            this.hTS.field_limitrate = hT == null ? 0 : hT.hgP / 8;
        }
        x.d("MicroMsg.NetSceneDownloadVideo", "%s limitrate:%d file:%s", TL(), Integer.valueOf(this.hTS.field_limitrate), this.hTR.getFileName());
        if (g.MJ().hsy.contains("video_" + this.hTR.hVI)) {
            g.MJ().hsy.remove("video_" + this.hTR.hVI);
            this.hTS.field_autostart = true;
        } else {
            this.hTS.field_autostart = false;
        }
        if (3 == this.hTR.hVO) {
            this.hTS.field_smallVideoFlag = 1;
        }
        if (!(bh.ov(str4) || this.hTP)) {
            str2 = ((com.tencent.mm.plugin.r.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.r.a.a.class)).Ff().dc(str4, this.hlp);
            int bN = com.tencent.mm.a.e.bN(str2);
            int i3 = this.hlp - bN;
            o.TU();
            str3 = s.nt(this.fileName);
            if (com.tencent.mm.a.e.bN(str3) > 0) {
                x.w("MicroMsg.NetSceneDownloadVideo", "%s already copy dup file, but download again, something error here.", TL());
                boolean deleteFile = com.tencent.mm.loader.stub.b.deleteFile(str3);
                at Ff = ((com.tencent.mm.plugin.r.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.r.a.a.class)).Ff();
                int i4 = this.hlp;
                i = 0;
                if (!bh.ov(str4)) {
                    i = Ff.gJP.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[]{str4, String.valueOf(i4), "100"});
                }
                r nF = t.nF(this.fileName);
                nF.hVB = 0;
                nF.fDt = 16;
                t.e(nF);
                x.w("MicroMsg.NetSceneDownloadVideo", "%s don't copy dup file, go to download now. target video len %d, delete file:%b,delete db: %d", TL(), Integer.valueOf(r11), Boolean.valueOf(deleteFile), Integer.valueOf(i));
                str2 = "";
            }
            x.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage: totallen:%s md5:%s  dup(len:%d path:%s) diffLen:%d to:%s target video len %d", TL(), Integer.valueOf(this.hlp), str4, Integer.valueOf(bN), str2, Integer.valueOf(i3), stringBuilder2, Integer.valueOf(r11));
            if (bh.ov(str2)) {
                this.hBu = str4;
                this.hBv = this.hlp;
            } else if (i3 >= 0 && i3 <= 16) {
                x.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage copy dup file now :%s -> %s", TL(), str2, stringBuilder2);
                com.tencent.mm.sdk.platformtools.k.fp(str2, stringBuilder2);
                iJ(this.hlp);
                ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().a(new c(F.field_talker, "update", F));
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                Object[] objArr = new Object[7];
                objArr[0] = str;
                objArr[1] = Long.valueOf(this.hTR.fFo);
                objArr[2] = str4;
                objArr[3] = Long.valueOf(this.hTR.hVE);
                objArr[4] = this.hTR.Ud();
                objArr[5] = Integer.valueOf(3 != this.hTR.hVO ? 43 : 62);
                objArr[6] = Integer.valueOf(bN);
                gVar.h(13267, objArr);
                obj = 1;
                if (obj == null) {
                    this.mediaId = this.hTS.field_mediaId;
                    this.hTW = bh.Wp();
                    this.hTQ = this.hTR.videoFormat != 2;
                    x.i("MicroMsg.NetSceneDownloadVideo", "%s check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", TL(), Boolean.valueOf(this.hTQ), Boolean.valueOf(this.hTP));
                    if (this.hTQ && this.hTP) {
                        this.hTV = false;
                        j jVar = this.hTS;
                        o.TU();
                        jVar.field_fullpath = s.nt(this.fileName);
                        o.TV().a(this.hTS, false);
                    } else if (!g.MJ().b(this.hTS, -1)) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(111, 212, 1, false);
                        x.e("MicroMsg.NetSceneDownloadVideo", "%s cdntra addSendTask failed.", TL());
                        this.hBn = "";
                        return false;
                    } else if (this.hTQ) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(354, 135, 1, false);
                    }
                }
                if (this.hTR.hVM != 1) {
                    this.hTR.hVM = 1;
                    this.hTR.fDt = SQLiteGlobal.journalSizeLimit;
                    t.e(this.hTR);
                }
                if (3 != this.hTR.hVO) {
                    Ud = this.hTR.Ud();
                    if (!bh.ov(Ud)) {
                        if (s.eV(Ud)) {
                            i2 = 0;
                        } else {
                            i2 = m.gl(Ud);
                        }
                        try {
                            NetworkInfo activeNetworkInfo;
                            activeNetworkInfo = ((ConnectivityManager) ac.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                            subtype = activeNetworkInfo.getSubtype();
                            if (activeNetworkInfo.getType() != 1) {
                                i = 1;
                            } else if (subtype != 13 || subtype == 15 || subtype == 14) {
                                i = 4;
                            } else if (subtype == 3 || subtype == 4 || subtype == 5 || subtype == 6 || subtype == 12) {
                                i = 3;
                            } else if (subtype == 1 || subtype == 2) {
                                i = 2;
                            } else {
                                i = 0;
                            }
                        } catch (Throwable e) {
                            x.e("MicroMsg.NetSceneDownloadVideo", "getNetType : %s", bh.i(e));
                            i = 0;
                        }
                        x.i("MicroMsg.NetSceneDownloadVideo", "%s dk12024 report:%s", TL(), Ud + "," + i2 + "," + str + "," + this.hlp + "," + i);
                        com.tencent.mm.plugin.report.service.g.pQN.k(12024, str);
                    }
                }
                return true;
            }
        }
        obj = null;
        if (obj == null) {
            this.mediaId = this.hTS.field_mediaId;
            this.hTW = bh.Wp();
            if (this.hTR.videoFormat != 2) {
            }
            this.hTQ = this.hTR.videoFormat != 2;
            x.i("MicroMsg.NetSceneDownloadVideo", "%s check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", TL(), Boolean.valueOf(this.hTQ), Boolean.valueOf(this.hTP));
            if (this.hTQ) {
            }
            if (!g.MJ().b(this.hTS, -1)) {
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 212, 1, false);
                x.e("MicroMsg.NetSceneDownloadVideo", "%s cdntra addSendTask failed.", TL());
                this.hBn = "";
                return false;
            } else if (this.hTQ) {
                com.tencent.mm.plugin.report.service.g.pQN.a(354, 135, 1, false);
            }
        }
        if (this.hTR.hVM != 1) {
            this.hTR.hVM = 1;
            this.hTR.fDt = SQLiteGlobal.journalSizeLimit;
            t.e(this.hTR);
        }
        if (3 != this.hTR.hVO) {
            Ud = this.hTR.Ud();
            if (bh.ov(Ud)) {
                if (s.eV(Ud)) {
                    i2 = 0;
                } else {
                    i2 = m.gl(Ud);
                }
                activeNetworkInfo = ((ConnectivityManager) ac.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                subtype = activeNetworkInfo.getSubtype();
                if (activeNetworkInfo.getType() != 1) {
                    if (subtype != 13) {
                    }
                    i = 4;
                } else {
                    i = 1;
                }
                x.i("MicroMsg.NetSceneDownloadVideo", "%s dk12024 report:%s", TL(), Ud + "," + i2 + "," + str + "," + this.hlp + "," + i);
                com.tencent.mm.plugin.report.service.g.pQN.k(12024, str);
            }
        }
        return true;
    }

    final void iJ(int i) {
        boolean renameTo;
        if (this.hTV) {
            StringBuilder stringBuilder = new StringBuilder();
            o.TU();
            File file = new File(stringBuilder.append(s.nt(this.fileName)).append(".tmp").toString());
            o.TU();
            renameTo = file.renameTo(new File(s.nt(this.fileName)));
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            o.TU();
            com.tencent.mm.loader.stub.b.deleteFile(stringBuilder2.append(s.nt(this.fileName)).append(".tmp").toString());
            renameTo = true;
        }
        com.tencent.mm.kernel.g.Dm().F(new 2(this, renameTo, i));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 1;
        this.gJT = eVar2;
        this.hTR = t.nF(this.fileName);
        if (this.hTR == null) {
            x.e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.fileName);
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            return -1;
        }
        if (this.hTR != null && 3 == this.hTR.hVO) {
            this.hTT = com.tencent.mm.modelcdntran.b.MediaType_TinyVideo;
        }
        if (this.startTime == 0) {
            this.startTime = bh.Wp();
            this.startOffset = this.hTR.hVB;
        }
        if (TK()) {
            x.d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", this.fileName);
            return 0;
        } else if (this.hTR.status != MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
            x.e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.hTR.status + " [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "]");
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            return -1;
        } else {
            x.d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "]  filesize:" + this.hTR.hVB + " file:" + this.hTR.hlp + " netTimes:" + this.hTR.hVJ);
            if (!t.nx(this.fileName)) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.hTR.hVJ + " [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                t.ny(this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                return -1;
            } else if (this.hTR.fFo <= 0) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.hTR.fFo + " [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                t.ny(this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                return -1;
            } else if (this.hTR.hVB < 0 || this.hTR.hlp <= this.hTR.hVB || this.hTR.hlp <= 0) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.hTR.hVB + " total:" + this.hTR.hlp + " [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                t.ny(this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                return -1;
            } else {
                b.a aVar = new b.a();
                aVar.hmj = new rk();
                aVar.hmk = new rl();
                aVar.uri = "/cgi-bin/micromsg-bin/downloadvideo";
                aVar.hmi = 150;
                aVar.hml = 40;
                aVar.hmm = 1000000040;
                this.gJQ = aVar.JZ();
                rk rkVar = (rk) this.gJQ.hmg.hmo;
                rkVar.vHe = this.hTR.fFo;
                rkVar.vIC = this.hTR.hVB;
                rkVar.vIB = this.hTR.hlp;
                if (!ab.bC(ac.getContext())) {
                    i = 2;
                }
                rkVar.vZu = i;
                return a(eVar, this.gJQ, this);
            }
        }
    }

    protected final int a(q qVar) {
        rk rkVar = (rk) ((b) qVar).hmg.hmo;
        if (rkVar.vHe > 0 && rkVar.vIC >= 0 && rkVar.vIB > 0 && rkVar.vIB > rkVar.vIC) {
            return b.hmP;
        }
        x.e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
        t.ny(this.fileName);
        return b.hmQ;
    }

    protected final int Bh() {
        return 2500;
    }

    public final boolean Ke() {
        boolean Ke = super.Ke();
        if (Ke) {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 210, 1, false);
        }
        return Ke;
    }

    protected final void a(a aVar) {
        com.tencent.mm.plugin.report.service.g.pQN.a(111, 211, 1, false);
        t.ny(this.fileName);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (this.hTU) {
            x.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
            this.gJT.a(i2, i3, str, this);
        } else if (i2 == 3 && i3 == -1 && !bh.ov(this.hBn)) {
            x.w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.hBn);
        } else {
            rl rlVar = (rl) ((b) qVar).hmh.hmo;
            rk rkVar = (rk) ((b) qVar).hmg.hmo;
            this.hTR = t.nF(this.fileName);
            if (this.hTR == null) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                this.gJT.a(i2, i3, str, this);
            } else if (this.hTR.status == 113) {
                x.w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                this.gJT.a(i2, i3, str, this);
            } else if (this.hTR.status != MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.hTR.status + " [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                this.gJT.a(i2, i3, str, this);
            } else if (i2 == 4 && i3 != 0) {
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 208, 1, false);
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + " [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                t.ny(this.fileName);
                com.tencent.mm.plugin.report.service.g.pQN.h(10420, Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ac.getContext())), Integer.valueOf(this.hTT), Integer.valueOf(this.hlp - this.startOffset));
                this.gJT.a(i2, i3, str, this);
            } else if (i2 != 0 || i3 != 0) {
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 207, 1, false);
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + i2 + " errCode:" + i3 + " [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                this.hTR.status = 113;
                t.e(this.hTR);
                this.gJT.a(i2, i3, str, this);
            } else if (bh.bw(rlVar.vXz.wJD.oz)) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                t.ny(this.fileName);
                this.gJT.a(i2, i3, str, this);
            } else if (rlVar.vIC != rkVar.vIC) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + rlVar.vIC + " reqStartPos:" + rkVar.vIC + " [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                t.ny(this.fileName);
                this.gJT.a(i2, i3, str, this);
            } else if (rlVar.vIB != rkVar.vIB) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + rlVar.vIB + " reqTotal:" + rkVar.vIB + " [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                t.ny(this.fileName);
                this.gJT.a(i2, i3, str, this);
            } else if (rkVar.vIB < rlVar.vIC) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + rlVar.vIB + " respStartPos:" + rkVar.vIC + " [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                t.ny(this.fileName);
                this.gJT.a(i2, i3, str, this);
            } else if (rlVar.vHe != rkVar.vHe) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + rlVar.vHe + " reqMsgId:" + rkVar.vHe + " [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                t.ny(this.fileName);
                this.gJT.a(i2, i3, str, this);
            } else {
                x.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + rlVar.vXz.wJB + " reqStartPos:" + rkVar.vIC + " totallen:" + rkVar.vIB + " [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                o.TU();
                int a = s.a(s.nt(this.fileName), rkVar.vIC, rlVar.vXz.wJD.toByteArray());
                if (a < 0) {
                    x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + a + " [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                    t.ny(this.fileName);
                    this.gJT.a(i2, i3, str, this);
                } else if (a > this.hTR.hlp) {
                    x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + a + " totalLen:" + this.hTR.hlp + " [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                    t.ny(this.fileName);
                    this.gJT.a(i2, i3, str, this);
                } else {
                    int line;
                    String str2 = this.fileName;
                    r nF = t.nF(str2);
                    if (nF == null) {
                        x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zh() + " getinfo failed: " + str2);
                        line = 0 - com.tencent.mm.compatible.util.g.getLine();
                    } else {
                        nF.hVB = a;
                        nF.hVF = bh.Wo();
                        nF.fDt = 1040;
                        line = 0;
                        if (nF.hlp > 0 && a >= nF.hlp) {
                            t.d(nF);
                            nF.status = 199;
                            nF.fDt |= 256;
                            x.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + str2 + " newsize:" + a + " total:" + nF.hlp + " status:" + nF.status + " netTimes:" + nF.hVJ);
                            line = 1;
                        }
                        x.d("MicroMsg.VideoLogic", "updateRecv " + com.tencent.mm.compatible.util.g.zh() + " file:" + str2 + " newsize:" + a + " total:" + nF.hlp + " status:" + nF.status);
                        if (!t.e(nF)) {
                            line = 0 - com.tencent.mm.compatible.util.g.getLine();
                        }
                    }
                    if (line < 0) {
                        x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + line + " newOffset :" + a + " [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                        this.gJT.a(i2, i3, str, this);
                    } else if (line == 1) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ac.getContext())), Integer.valueOf(this.hTT), Integer.valueOf(this.hlp - this.startOffset));
                        a.a(this.hTR, 1);
                        x.i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "]");
                        this.gJT.a(i2, i3, str, this);
                    } else if (this.hTU) {
                        this.gJT.a(i2, i3, str, this);
                    } else {
                        this.hkO.J(0, 0);
                    }
                }
            }
        }
    }

    public final int getType() {
        return 150;
    }

    final String TL() {
        return this.fileName + "_" + hashCode();
    }
}
