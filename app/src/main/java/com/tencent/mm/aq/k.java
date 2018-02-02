package com.tencent.mm.aq;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelstat.h;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.c;
import com.tencent.mm.protocal.c.adr;
import com.tencent.mm.protocal.c.ads;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.util.Map;
import junit.framework.Assert;

public final class k extends com.tencent.mm.ae.k implements com.tencent.mm.network.k {
    String TAG;
    au fnB;
    private long fqm;
    private final b gJQ;
    e gJT;
    long gLP;
    final f hBj;
    public final long hBk;
    private int hBl;
    private h hBm;
    String hBn;
    int hBo;
    private String hBp;
    public String hBq;
    int hBr;
    public boolean hBs;
    private int hBt;
    private String hBu;
    private int hBv;
    boolean hBw;
    private a hBx;
    int hlp;
    private int hzT;
    private int startOffset;
    long startTime;
    private int token;

    public k(long j, long j2, int i, f fVar) {
        this(j, j2, i, fVar, -1);
    }

    public k(long j, long j2, int i, final f fVar, int i2) {
        e b;
        this.TAG = "MicroMsg.NetSceneGetMsgImg";
        this.hBm = null;
        this.fqm = -1;
        this.fnB = null;
        this.hBn = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.hBo = 0;
        this.hBp = "";
        this.hBq = "";
        this.hlp = 0;
        this.hBr = -1;
        this.hBs = false;
        this.hBt = -1;
        this.hBu = null;
        this.hBv = 0;
        this.token = -1;
        this.hBw = false;
        this.hBx = new 2(this);
        boolean z = j >= 0 && j2 >= 0 && fVar != null;
        Assert.assertTrue(z);
        this.hBj = fVar;
        this.hzT = i;
        this.hBk = j;
        this.gLP = j;
        this.fqm = j2;
        this.hBt = i2;
        e b2 = o.Pw().b(Long.valueOf(this.gLP));
        if (i == 1) {
            this.gLP = (long) b2.hzZ;
            b = o.Pw().b(Long.valueOf(this.gLP));
        } else {
            b = b2;
        }
        this.TAG += "[" + this.gLP + "]";
        b.a aVar = new b.a();
        aVar.hmj = new adr();
        aVar.hmk = new ads();
        aVar.uri = "/cgi-bin/micromsg-bin/getmsgimg";
        aVar.hmi = 109;
        aVar.hml = 10;
        aVar.hmm = 1000000010;
        this.gJQ = aVar.JZ();
        adr com_tencent_mm_protocal_c_adr = (adr) this.gJQ.hmg.hmo;
        this.fnB = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dH(j2);
        com_tencent_mm_protocal_c_adr.vIC = b.offset;
        com_tencent_mm_protocal_c_adr.vIB = b.hlp;
        x.d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", new Object[]{Integer.valueOf(b.offset), Integer.valueOf(b.hlp), bh.cgy()});
        com_tencent_mm_protocal_c_adr.vHe = this.fnB.field_msgSvrId;
        com_tencent_mm_protocal_c_adr.vGX = new bdo().UA(this.fnB.field_talker);
        com_tencent_mm_protocal_c_adr.vGY = new bdo().UA((String) g.Dj().CU().get(2, null));
        com_tencent_mm_protocal_c_adr.wmj = i;
        if (b.offset == 0) {
            this.hBm = new h(109, false, (long) b.hlp);
        }
        this.hBl = 8192;
        if (fVar != null) {
            final int i3 = b.offset;
            final int i4 = b.hlp;
            ag.y(new Runnable(this) {
                final /* synthetic */ k hBB;

                public final void run() {
                    fVar.a(i3, i4, this.hBB);
                }
            });
        }
    }

    protected final int Bh() {
        if (this.hzT == 0) {
            return 100;
        }
        return 1280;
    }

    protected final int a(q qVar) {
        return com.tencent.mm.ae.k.b.hmP;
    }

    protected final void cancel() {
        if (!(bh.ov(this.hBn) || com.tencent.mm.modelcdntran.g.MJ() == null)) {
            x.d(this.TAG, "cancel recv task");
            com.tencent.mm.modelcdntran.g.MJ().kI(this.hBn);
        }
        super.cancel();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        adr com_tencent_mm_protocal_c_adr = (adr) this.gJQ.hmg.hmo;
        e b = o.Pw().b(Long.valueOf(this.gLP));
        if (b.hzP == 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 195, 1, false);
            x.e(this.TAG, "doScene id:%d  img:%s", new Object[]{Long.valueOf(this.gLP), b});
            return -1;
        } else if (b.status != 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 194, 1, false);
            x.e(this.TAG, "doSceneError, id:%d, status:%d", new Object[]{Long.valueOf(b.hzP), Integer.valueOf(b.status)});
            return -1;
        } else {
            Object obj;
            if (b.hzQ.startsWith("SERVERID://")) {
                this.hBp = com.tencent.mm.a.g.s(b.hzQ.getBytes());
                this.hBq = o.Pw().m(this.hBp, null, ".temp");
                b.lg(this.hBp + ".temp");
                o.Pw().a(Long.valueOf(this.gLP), b);
            } else {
                this.hBp = b.hzQ;
                this.hBq = o.Pw().m(this.hBp, null, "");
            }
            x.i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", new Object[]{Long.valueOf(b.hzP), Integer.valueOf(this.hzT), Integer.valueOf(b.offset), Integer.valueOf(b.hlp), r4, this.hBp, this.hBq});
            if (this.startTime == 0) {
                this.startTime = bh.Wp();
                this.startOffset = b.offset;
                this.hBo = this.hzT == 1 ? com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE : com.tencent.mm.modelcdntran.b.MediaType_IMAGE;
            }
            String str = com_tencent_mm_protocal_c_adr.vGX.wJF;
            long j = com_tencent_mm_protocal_c_adr.vHe;
            if (bh.ov(b.hAa)) {
                obj = null;
            } else {
                Map y = bi.y(b.hAa, "msg");
                if (y == null) {
                    x.e(this.TAG, "parse cdnInfo failed. [%s]", new Object[]{b.hAa});
                    obj = null;
                } else {
                    String str2;
                    this.hlp = 0;
                    if (this.hzT != 1) {
                        str = (String) y.get(".msg.img.$cdnmidimgurl");
                        this.hlp = bh.getInt((String) y.get(".msg.img.$length"), 0);
                        str2 = str;
                    } else {
                        str = (String) y.get(".msg.img.$cdnbigimgurl");
                        this.hlp = bh.getInt((String) y.get(".msg.img.$hdlength"), 0);
                        str2 = str;
                    }
                    x.d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s]", new Object[]{Integer.valueOf(this.hzT), Integer.valueOf(this.hlp), str2});
                    if (bh.ov(str2)) {
                        x.e(this.TAG, "cdntra get cdnUrlfailed.");
                        obj = null;
                    } else {
                        str = (String) y.get(".msg.img.$aeskey");
                        if (bh.ov(str)) {
                            x.e(this.TAG, "cdntra get aes key failed.");
                            obj = null;
                        } else {
                            this.hBn = d.a("downimg", (long) b.hzW, this.fnB.field_talker, this.fnB.field_msgId);
                            if (bh.ov(this.hBn)) {
                                x.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[]{Long.valueOf(this.gLP)});
                                obj = null;
                            } else {
                                String str3 = (String) y.get(".msg.img.$md5");
                                if (!bh.ov(str3) && (bh.ov((String) y.get(".msg.img.$cdnbigimgurl")) || this.hzT == 1)) {
                                    com.tencent.mm.plugin.n.b.aSL();
                                    String dc = com.tencent.mm.plugin.n.b.Ff().dc(str3, this.hlp);
                                    int bN = com.tencent.mm.a.e.bN(dc);
                                    int i = this.hlp - bN;
                                    String str4 = this.TAG;
                                    String str5 = "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s";
                                    Integer[] numArr = new Object[8];
                                    numArr[0] = Integer.valueOf(this.hlp);
                                    numArr[1] = str3;
                                    numArr[2] = y.get(".msg.img.$cdnbigimgurl");
                                    numArr[3] = Boolean.valueOf(this.hzT == 1);
                                    numArr[4] = Integer.valueOf(bN);
                                    numArr[5] = dc;
                                    numArr[6] = Integer.valueOf(i);
                                    numArr[7] = this.hBq;
                                    x.i(str4, str5, numArr);
                                    if (bh.ov(dc)) {
                                        this.hBu = str3;
                                        this.hBv = this.hlp;
                                    } else if (i >= 0 && i <= 16) {
                                        boolean fp = com.tencent.mm.sdk.platformtools.k.fp(dc, this.hBq);
                                        x.i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", new Object[]{dc, this.hBq, Boolean.valueOf(fp)});
                                        a(b, this.hlp, this.hlp, 0, null);
                                        if (this.fnB != null) {
                                            ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().a(new c(this.fnB.field_talker, "update", this.fnB));
                                        }
                                        com.tencent.mm.plugin.report.service.g.pQN.h(13267, new Object[]{str2, Long.valueOf(this.fnB.field_msgSvrId), str3, Long.valueOf(this.fnB.field_createTime / 1000), this.fnB.field_talker, Integer.valueOf(3), Integer.valueOf(bN)});
                                        obj = 1;
                                    }
                                }
                                i iVar = new i();
                                iVar.field_mediaId = this.hBn;
                                iVar.field_fullpath = this.hBq;
                                iVar.field_fileType = this.hBo;
                                iVar.field_totalLen = this.hlp;
                                iVar.field_aesKey = str;
                                iVar.field_fileId = str2;
                                iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
                                iVar.htt = this.hBx;
                                iVar.field_chattype = s.eV(this.fnB.field_talker) ? 1 : 0;
                                x.i(this.TAG, "cdnautostart %s %b", new Object[]{"image_" + this.fnB.field_msgId, Boolean.valueOf(com.tencent.mm.modelcdntran.g.MJ().hsy.contains("image_" + this.fnB.field_msgId))});
                                if (com.tencent.mm.modelcdntran.g.MJ().hsy.contains("image_" + this.fnB.field_msgId)) {
                                    com.tencent.mm.modelcdntran.g.MJ().hsy.remove("image_" + this.fnB.field_msgId);
                                    iVar.field_autostart = true;
                                } else {
                                    iVar.field_autostart = false;
                                }
                                if (com.tencent.mm.modelcdntran.g.MJ().b(iVar, this.hBt)) {
                                    x.d(this.TAG, "add recv task");
                                    obj = 1;
                                } else {
                                    com.tencent.mm.plugin.report.service.g.pQN.a(111, 196, 1, false);
                                    x.e(this.TAG, "addRecvTask failed :%s", new Object[]{this.hBn});
                                    this.hBn = "";
                                    obj = null;
                                }
                            }
                        }
                    }
                }
            }
            if (obj != null) {
                x.d(this.TAG, "cdntra this img use cdn : %s", new Object[]{this.hBn});
                return 0;
            }
            x.d(this.TAG, "cdntra this img NOT USE CDN: %s", new Object[]{this.hBn});
            b.lj("");
            b.fDt = Downloads.RECV_BUFFER_SIZE;
            o.Pw().a(Long.valueOf(this.gLP), b);
            com_tencent_mm_protocal_c_adr.vIC = b.offset;
            com_tencent_mm_protocal_c_adr.vID = this.hBl;
            com_tencent_mm_protocal_c_adr.vIB = b.hlp;
            if (this.hBm != null) {
                this.hBm.SW();
            }
            return a(eVar, this.gJQ, this);
        }
    }

    public final int getType() {
        return 109;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 3 && i3 == -1 && !bh.ov(this.hBn)) {
            x.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[]{this.hBn});
        } else if (i2 == 0 && i3 == 0) {
            ads com_tencent_mm_protocal_c_ads = (ads) ((b) qVar).hmh.hmo;
            e b = o.Pw().b(Long.valueOf(this.gLP));
            Object obj = null;
            if (com_tencent_mm_protocal_c_ads.vID <= 0) {
                x.e(this.TAG, "flood control, malformed data_len");
                obj = -1;
            } else if (com_tencent_mm_protocal_c_ads.vXz == null || com_tencent_mm_protocal_c_ads.vID != com_tencent_mm_protocal_c_ads.vXz.wJB) {
                x.e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
                obj = -1;
            } else if (com_tencent_mm_protocal_c_ads.vIC < 0 || com_tencent_mm_protocal_c_ads.vIC + com_tencent_mm_protocal_c_ads.vID > com_tencent_mm_protocal_c_ads.vIB) {
                x.e(this.TAG, "flood control, malformed start pos");
                obj = -1;
            } else if (com_tencent_mm_protocal_c_ads.vIC != b.offset) {
                x.e(this.TAG, "flood control, malformed start_pos");
                obj = -1;
            } else if (com_tencent_mm_protocal_c_ads.vIB <= 0) {
                x.e(this.TAG, "flood control, malformed total_len");
                obj = -1;
            }
            if (obj != null) {
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 192, 1, false);
                com.tencent.mm.plugin.report.service.g.pQN.h(10420, new Object[]{Integer.valueOf(-1), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.hBo), Integer.valueOf(this.hlp - this.startOffset)});
                this.gJT.a(4, -1, "", this);
                return;
            }
            if (a(b, com_tencent_mm_protocal_c_ads.vIB, com_tencent_mm_protocal_c_ads.vIC, com_tencent_mm_protocal_c_ads.vID, com_tencent_mm_protocal_c_ads.vXz.wJD.oz) && a(this.hmA, this.gJT) < 0) {
                this.gJT.a(3, -1, "", this);
            }
        } else {
            if (i2 == 4) {
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 193, 1, false);
                com.tencent.mm.plugin.report.service.g.pQN.h(10420, new Object[]{Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.hBo), Integer.valueOf(this.hlp - this.startOffset)});
            }
            this.gJT.a(i2, i3, str, this);
        }
    }

    private boolean a(e eVar, int i, int i2, int i3, byte[] bArr) {
        String str;
        boolean z;
        eVar.hL(i);
        eVar.setOffset(i2 + i3);
        this.hBl = i3;
        if (bArr != null) {
            com.tencent.mm.a.e.d(this.hBq, bArr);
        }
        x.d(this.TAG, "onGYNetEnd : offset = " + eVar.offset + " totalLen = " + eVar.hlp + " stack:[%s]", new Object[]{bh.cgy()});
        if (eVar.Pd()) {
            String str2 = this.hBq;
            if (str2 == null || str2.equals("")) {
                str2 = "";
            } else {
                byte[] d = com.tencent.mm.a.e.d(str2, 0, 2);
                if (d == null || d.length < 2) {
                    str2 = "";
                } else {
                    str = ".jpg";
                    byte b = d[0];
                    if (b < (byte) 0) {
                        b += 256;
                    }
                    byte b2 = d[1];
                    if (b2 < (byte) 0) {
                        b2 += 256;
                    }
                    str2 = (b == (byte) 66 && b2 == (byte) 77) ? ".bmp" : (b == (byte) -1 && b2 == (byte) -40) ? ".jpg" : (b == (byte) -119 && b2 == (byte) 80) ? ".png" : (b == (byte) 71 && b2 == (byte) 73) ? ".gif" : str;
                }
            }
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            boolean checkIsImageLegal = MMBitmapFactory.checkIsImageLegal(this.hBq, decodeResultLogger);
            File file = new File(this.hBq);
            if (checkIsImageLegal) {
                str = o.Pw().m(this.hBp, null, str2);
                x.i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", new Object[]{str2, this.hBp, this.hBq, str});
                file.renameTo(new File(str));
                eVar.lg(this.hBp + str2);
                eVar.lf(FileOp.mk(str));
                eVar.hP(this.hzT);
                if (o.Pw().a(Long.valueOf(this.gLP), eVar) >= 0) {
                    x.e(this.TAG, "onGYNetEnd : update img fail");
                    this.gJT.a(3, -1, "", this);
                    return false;
                }
                if (this.hBj != null) {
                    ag.y(new 3(this, eVar));
                }
                x.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", new Object[]{Boolean.valueOf(eVar.Pd()), this.hBn});
                if (eVar.Pd()) {
                    return true;
                }
                if (bh.ov(this.hBn)) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(10420, new Object[]{Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.hBo), Integer.valueOf(i - this.startOffset)});
                }
                z = false;
                if (this.hBr > 0) {
                    z = o.Pw().a(str, eVar.hzS, this.hBr, 1);
                }
                if (z) {
                    eVar.gjK = 1;
                    eVar.hAq = true;
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().a(this.fnB.field_msgId, this.fnB);
                }
                o.Pw().a(Long.valueOf(this.gLP), eVar);
                x.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", new Object[]{this.hBq, str, eVar.hzQ, this.hBu});
                if (this.hBm != null) {
                    this.hBm.br((long) eVar.hlp);
                }
                if (!bh.ov(this.hBu) && this.hBv > 0) {
                    com.tencent.mm.plugin.n.b.aSL();
                    com.tencent.mm.plugin.n.b.Ff().y(this.hBu, this.hBv, str);
                }
                this.gJT.a(0, 0, "", this);
                return false;
            }
            file.delete();
            if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(this.hBq, 2, decodeResultLogger));
            }
        }
        str = null;
        if (o.Pw().a(Long.valueOf(this.gLP), eVar) >= 0) {
            if (this.hBj != null) {
                ag.y(new 3(this, eVar));
            }
            x.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", new Object[]{Boolean.valueOf(eVar.Pd()), this.hBn});
            if (eVar.Pd()) {
                return true;
            }
            if (bh.ov(this.hBn)) {
                com.tencent.mm.plugin.report.service.g.pQN.h(10420, new Object[]{Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.hBo), Integer.valueOf(i - this.startOffset)});
            }
            z = false;
            if (this.hBr > 0) {
                z = o.Pw().a(str, eVar.hzS, this.hBr, 1);
            }
            if (z) {
                eVar.gjK = 1;
                eVar.hAq = true;
                ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().a(this.fnB.field_msgId, this.fnB);
            }
            o.Pw().a(Long.valueOf(this.gLP), eVar);
            x.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", new Object[]{this.hBq, str, eVar.hzQ, this.hBu});
            if (this.hBm != null) {
                this.hBm.br((long) eVar.hlp);
            }
            com.tencent.mm.plugin.n.b.aSL();
            com.tencent.mm.plugin.n.b.Ff().y(this.hBu, this.hBv, str);
            this.gJT.a(0, 0, "", this);
            return false;
        }
        x.e(this.TAG, "onGYNetEnd : update img fail");
        this.gJT.a(3, -1, "", this);
        return false;
    }
}
