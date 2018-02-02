package com.tencent.mm.plugin.masssend.a;

import android.content.ContentValues;
import com.tencent.mm.a.g;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.aqm;
import com.tencent.mm.protocal.c.aqn;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import junit.framework.Assert;

public final class f extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;
    a hEZ;
    int hVJ;
    boolean hnr;
    private int hzT;
    private a omW;
    int retCode;

    public f(a aVar, boolean z) {
        this(aVar, z, 0);
    }

    public f(a aVar, boolean z, int i) {
        int i2 = 1;
        this.omW = null;
        this.hEZ = null;
        this.retCode = 0;
        this.hVJ = 0;
        this.hnr = false;
        this.omW = aVar;
        this.hzT = i;
        aVar.hVE = bh.Wp();
        if (aVar.msgType == 43) {
            aVar.status = 104;
            o.TU();
            aVar.omR = s.nv(s.nu(aVar.aYw()));
            o.TU();
            aVar.fdR = s.nv(s.nt(aVar.aYw()));
            this.hVJ = 2500;
            if (aVar.omS == 2) {
                this.hVJ = 2500;
            }
        } else if (aVar.msgType == 34) {
            this.hVJ = 40;
            aVar.status = 104;
            aVar.fdR = com.tencent.mm.modelvoice.o.nv(aVar.aYw());
            aVar.omR = 0;
        } else if (aVar.msgType == 3) {
            int i3;
            this.hVJ = 40;
            if (i == 1) {
                this.hVJ = 1250;
                i3 = 1;
            } else {
                i3 = 0;
            }
            aVar.omT = i3;
            aVar.status = 104;
            aVar.omR = 0;
            StringBuilder stringBuilder = new StringBuilder();
            ar.Hg();
            aVar.fdR = com.tencent.mm.a.e.bN(stringBuilder.append(c.Fi()).append(aVar.aYw()).toString());
        } else if (aVar.msgType == 1) {
            this.hVJ = 1;
            aVar.status = 104;
            aVar.fdR = aVar.aYw().getBytes().length;
            aVar.omR = 0;
        } else {
            x.d("MicroMsg.NetSceneMasSend", "error msgtype:" + aVar.msgType);
            Assert.assertTrue("error msgtype:" + aVar.msgType, false);
        }
        b.a aVar2 = new b.a();
        aVar2.hmj = new aqm();
        aVar2.hmk = new aqn();
        aVar2.uri = "/cgi-bin/micromsg-bin/masssend";
        aVar2.hmi = JsApiChooseMedia.CTRL_INDEX;
        aVar2.hml = 84;
        aVar2.hmm = 1000000084;
        this.gJQ = aVar2.JZ();
        aqm com_tencent_mm_protocal_c_aqm = (aqm) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aqm.wxj = g.s(aVar.aYy().getBytes());
        com_tencent_mm_protocal_c_aqm.wxu = aVar.omO;
        com_tencent_mm_protocal_c_aqm.wxi = aVar.aYy();
        aVar.hOU = bh.Wp();
        com_tencent_mm_protocal_c_aqm.wxk = aVar.aYv();
        com_tencent_mm_protocal_c_aqm.ngq = aVar.msgType;
        com_tencent_mm_protocal_c_aqm.wxl = aVar.omP;
        if (!z) {
            i2 = 0;
        }
        com_tencent_mm_protocal_c_aqm.wxv = i2;
        com_tencent_mm_protocal_c_aqm.wmj = i;
        this.hEZ = new a();
    }

    public final void cancel() {
        this.hnr = true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 2;
        int i2 = 0;
        this.gJT = eVar2;
        if (this.hnr) {
            x.d("MicroMsg.NetSceneMasSend", "isCancel");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        }
        this.hVJ--;
        if (this.hVJ < 0) {
            x.d("MicroMsg.NetSceneMasSend", "MAX_SEND_TIMES");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (this.omW == null) {
            x.d("MicroMsg.NetSceneMasSend", "MasSendInfo is null");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (bh.ov(this.omW.aYy())) {
            x.d("MicroMsg.NetSceneMasSend", "MasSendInfo.toList is null");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (this.omW.omO == 0) {
            x.d("MicroMsg.NetSceneMasSend", "getTolistCount is 0");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (this.omW.fdR <= 0) {
            x.d("MicroMsg.NetSceneMasSend", "getDataLen is 0");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (this.omW.status == 103 && this.omW.omR <= 0) {
            x.d("MicroMsg.NetSceneMasSend", "getThumbTotalLen is 0");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (this.omW.status == 103 || this.omW.status == 104) {
            aqm com_tencent_mm_protocal_c_aqm = (aqm) this.gJQ.hmg.hmo;
            String aYw;
            if (this.omW.msgType == 43) {
                int i3;
                aYw = this.omW.aYw();
                if (bh.ov(aYw)) {
                    x.d("MicroMsg.NetSceneMasSend", "MasSendInfo.fileName is null");
                    this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                    i3 = -1;
                } else {
                    com_tencent_mm_protocal_c_aqm.wxm = new bdn();
                    com_tencent_mm_protocal_c_aqm.wxn = 0;
                    com_tencent_mm_protocal_c_aqm.wxr = new bdn();
                    com_tencent_mm_protocal_c_aqm.wxq = 0;
                    com_tencent_mm_protocal_c_aqm.wxs = 2;
                    com_tencent_mm_protocal_c_aqm.wxl = this.omW.omP;
                    if (this.omW.omS <= 0) {
                        i = 0;
                    }
                    com_tencent_mm_protocal_c_aqm.wxt = i;
                    com_tencent_mm_protocal_c_aqm.wxp = this.omW.omR;
                    com_tencent_mm_protocal_c_aqm.wxo = this.omW.fdR;
                    s.b i4;
                    Object obj;
                    bdn com_tencent_mm_protocal_c_bdn;
                    if (this.omW.status == 103) {
                        o.TU();
                        i4 = s.i(s.nu(aYw), this.omW.hVC, 8000);
                        if (i4.ret < 0 || i4.flp == 0) {
                            x.e("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + aYw + "]  Error ");
                            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                            i3 = -1;
                        } else {
                            x.d("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + aYw + "] read ret:" + i4.ret + " readlen:" + i4.flp + " newOff:" + i4.hWh + " netOff:" + this.omW.hVC);
                            if (i4.hWh < this.omW.hVC) {
                                x.e("MicroMsg.NetSceneMasSend", "Err doScene READ THUMB[" + aYw + "] newOff:" + i4.hWh + " OldtOff:" + this.omW.hVC);
                                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                                i3 = -1;
                            } else {
                                obj = new byte[i4.flp];
                                System.arraycopy(i4.buf, 0, obj, 0, i4.flp);
                                com_tencent_mm_protocal_c_aqm.wxq = this.omW.hVC;
                                com_tencent_mm_protocal_c_bdn = new bdn();
                                com_tencent_mm_protocal_c_bdn.bj(obj);
                                com_tencent_mm_protocal_c_aqm.wxr = com_tencent_mm_protocal_c_bdn;
                            }
                        }
                    } else {
                        o.TU();
                        i4 = s.i(s.nt(aYw), this.omW.omQ, 8000);
                        if (i4.ret < 0 || i4.flp == 0) {
                            x.e("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + aYw + "]  Error ");
                            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                            i3 = -1;
                        } else {
                            x.d("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + aYw + "] read ret:" + i4.ret + " readlen:" + i4.flp + " newOff:" + i4.hWh + " netOff:" + this.omW.omQ);
                            if (i4.hWh < this.omW.omQ) {
                                x.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + aYw + "] newOff:" + i4.hWh + " OldtOff:" + this.omW.omQ);
                                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                                i3 = -1;
                            } else if (i4.hWh >= com.tencent.mm.modelvideo.c.hTn) {
                                x.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + aYw + "] maxsize:" + com.tencent.mm.modelvideo.c.hTn);
                                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                                i3 = -1;
                            } else {
                                obj = new byte[i4.flp];
                                System.arraycopy(i4.buf, 0, obj, 0, i4.flp);
                                com_tencent_mm_protocal_c_aqm.wxn = this.omW.omQ;
                                com_tencent_mm_protocal_c_aqm.wxq = this.omW.hVC;
                                com_tencent_mm_protocal_c_bdn = new bdn();
                                com_tencent_mm_protocal_c_bdn.bj(obj);
                                com_tencent_mm_protocal_c_aqm.wxm = com_tencent_mm_protocal_c_bdn;
                            }
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    return i3;
                }
            } else if (this.omW.msgType == 34) {
                com_tencent_mm_protocal_c_aqm.wxs = 0;
                com_tencent_mm_protocal_c_aqm.wxt = 0;
                com_tencent_mm_protocal_c_aqm.wxm = new bdn().bj(new byte[0]);
                com_tencent_mm_protocal_c_aqm.wxn = 0;
                com_tencent_mm_protocal_c_aqm.wxr = new bdn().bj(new byte[0]);
                com_tencent_mm_protocal_c_aqm.wxq = 0;
                com_tencent_mm_protocal_c_aqm.wxp = 0;
                com_tencent_mm_protocal_c_aqm.wxo = this.omW.fdR;
                com.tencent.mm.modelvoice.b nT = q.nT(this.omW.aYw());
                if (nT == null) {
                    this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                    x.d("MicroMsg.NetSceneMasSend", "fileop is null");
                    i2 = -1;
                } else {
                    com.tencent.mm.modelvoice.g bp = nT.bp(this.omW.omQ, 8000);
                    if (bp.ret < 0) {
                        x.e("MicroMsg.NetSceneMasSend", "Err doScene READ file[" + this.omW.aYw() + "] read ret:" + bp.ret + " readlen:" + bp.flp + " newOff:" + bp.hWh + " netOff:" + this.omW.omQ);
                        this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                        i2 = -1;
                    } else if (bp.hWh < this.omW.omQ || bp.hWh >= 469000) {
                        x.e("MicroMsg.NetSceneMasSend", "Err doScene READ offseterror file[" + this.omW.aYw() + "] read ret:" + bp.ret + " readlen:" + bp.flp + " newOff:" + bp.hWh + " netOff:" + this.omW.omQ);
                        this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                        i2 = -1;
                    } else if (this.omW.fdR <= 0) {
                        x.e("MicroMsg.NetSceneMasSend", "Err doScene READ datalen file[" + this.omW.aYw() + "] read totalLen:" + this.omW.fdR);
                        this.retCode = com.tencent.mm.compatible.util.g.getLine() + 10000;
                        i2 = -1;
                    } else {
                        Object obj2 = new byte[bp.flp];
                        System.arraycopy(bp.buf, 0, obj2, 0, bp.flp);
                        com_tencent_mm_protocal_c_aqm.wxm = new bdn().bj(obj2);
                        com_tencent_mm_protocal_c_aqm.wxl = this.omW.omP;
                        com_tencent_mm_protocal_c_aqm.wxn = this.omW.omQ;
                        com_tencent_mm_protocal_c_aqm.wxw = nT.getFormat();
                    }
                }
                if (i2 != 0) {
                    return -1;
                }
            } else if (this.omW.msgType == 3) {
                if (bh.ov(this.omW.aYw())) {
                    x.d("MicroMsg.NetSceneMasSend", "getFilename is null");
                    this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                    i2 = -1;
                } else {
                    com_tencent_mm_protocal_c_aqm.wxs = 0;
                    com_tencent_mm_protocal_c_aqm.wxt = 0;
                    com_tencent_mm_protocal_c_aqm.wxm = new bdn().bj(new byte[0]);
                    com_tencent_mm_protocal_c_aqm.wxn = 0;
                    com_tencent_mm_protocal_c_aqm.wxr = new bdn().bj(new byte[0]);
                    com_tencent_mm_protocal_c_aqm.wxq = 0;
                    com_tencent_mm_protocal_c_aqm.wxp = 0;
                    com_tencent_mm_protocal_c_aqm.wxl = 0;
                    com_tencent_mm_protocal_c_aqm.wxp = this.omW.omR;
                    com_tencent_mm_protocal_c_aqm.wxo = this.omW.fdR;
                    com_tencent_mm_protocal_c_aqm.wmj = this.hzT;
                    StringBuilder stringBuilder = new StringBuilder();
                    ar.Hg();
                    aYw = stringBuilder.append(c.Fi()).append(this.omW.aYw()).toString();
                    i = this.omW.fdR - this.omW.omQ;
                    if (i > 8000) {
                        i = 8000;
                    }
                    byte[] d = com.tencent.mm.a.e.d(aYw, this.omW.omQ, i);
                    if (bh.bw(d)) {
                        x.e("MicroMsg.NetSceneMasSend", "doScene READ data[" + this.omW.aYw() + "]  Error ");
                        this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                        i2 = -1;
                    } else {
                        com_tencent_mm_protocal_c_aqm.wxn = this.omW.omQ;
                        com_tencent_mm_protocal_c_aqm.wxq = this.omW.hVC;
                        bdn com_tencent_mm_protocal_c_bdn2 = new bdn();
                        com_tencent_mm_protocal_c_bdn2.bj(d);
                        com_tencent_mm_protocal_c_aqm.wxm = com_tencent_mm_protocal_c_bdn2;
                    }
                }
                if (i2 != 0) {
                    return -1;
                }
            } else if (this.omW.msgType == 1) {
                com_tencent_mm_protocal_c_aqm.wxm = new bdn().bj(this.omW.aYw().getBytes());
                com_tencent_mm_protocal_c_aqm.wxo = this.omW.fdR;
                com_tencent_mm_protocal_c_aqm.wxl = 0;
                com_tencent_mm_protocal_c_aqm.wxn = 0;
                com_tencent_mm_protocal_c_aqm.wxr = new bdn().bj(new byte[0]);
                com_tencent_mm_protocal_c_aqm.wxq = 0;
                com_tencent_mm_protocal_c_aqm.wxp = 0;
                com_tencent_mm_protocal_c_aqm.wxs = 0;
                com_tencent_mm_protocal_c_aqm.wxt = 0;
            } else {
                x.d("MicroMsg.NetSceneMasSend", "error msgtype:" + this.omW.msgType);
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            }
            return a(eVar, this.gJQ, this);
        } else {
            x.d("MicroMsg.NetSceneMasSend", "msg type :" + this.omW.msgType);
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        }
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return k.b.hmP;
    }

    protected final int Bh() {
        return 2500;
    }

    protected final void a(k.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneMasSend", "onGYNetEnd  errtype:" + i2 + " errCode:" + i3);
        if (i2 != 0 || i3 != 0) {
            x.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd FAILED errtype:" + i2 + " errCode:" + i3);
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            this.gJT.a(i2, i3, str, this);
        } else if (this.omW == null) {
            x.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd Get INFO FAILED :");
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            this.gJT.a(i2, i3, str, this);
        } else if (this.omW.status == 104 || this.omW.status == 103) {
            aqn com_tencent_mm_protocal_c_aqn = (aqn) this.gJQ.hmh.hmo;
            aqm com_tencent_mm_protocal_c_aqm = (aqm) this.gJQ.hmg.hmo;
            if (com_tencent_mm_protocal_c_aqm.wxp > 0 && com_tencent_mm_protocal_c_aqm.wxr != null && com_tencent_mm_protocal_c_aqm.wxr.wJD != null && !bh.bw(com_tencent_mm_protocal_c_aqm.wxr.wJD.toByteArray()) && com_tencent_mm_protocal_c_aqm.wxq != com_tencent_mm_protocal_c_aqn.wxq - com_tencent_mm_protocal_c_aqm.wxr.wJB) {
                x.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Thumb ");
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                this.gJT.a(3, -1, "doScene failed", this);
            } else if (com_tencent_mm_protocal_c_aqm.wxo <= 0 || com_tencent_mm_protocal_c_aqm.wxm == null || com_tencent_mm_protocal_c_aqm.wxm.wJD == null || bh.bw(com_tencent_mm_protocal_c_aqm.wxm.wJD.toByteArray()) || com_tencent_mm_protocal_c_aqm.wxn == com_tencent_mm_protocal_c_aqn.wxn - com_tencent_mm_protocal_c_aqm.wxm.wJB) {
                this.omW.hVF = bh.Wo();
                int i4 = this.omW.status;
                if (i4 == 103) {
                    this.omW.hVC = com_tencent_mm_protocal_c_aqm.wxr.wJB + com_tencent_mm_protocal_c_aqm.wxq;
                    if (this.omW.hVC >= this.omW.omR) {
                        this.omW.status = 199;
                    }
                } else if (i4 == 104) {
                    this.omW.omQ = com_tencent_mm_protocal_c_aqm.wxm.wJB + com_tencent_mm_protocal_c_aqm.wxn;
                    if (this.omW.omQ >= this.omW.fdR) {
                        if (this.omW.omR > 0) {
                            this.omW.status = 103;
                        } else {
                            this.omW.status = 199;
                        }
                    }
                } else {
                    x.e("MicroMsg.NetSceneMasSend", "onGYNetEnd ERROR STATUS:" + i4);
                    this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                    this.gJT.a(3, -1, "doScene failed", this);
                    return;
                }
                if (this.omW.status == 199) {
                    b aYD = h.aYD();
                    a aVar = this.omW;
                    if (aVar != null) {
                        aVar.fDt = -1;
                        ContentValues contentValues = new ContentValues();
                        if ((aVar.fDt & 1) != 0) {
                            contentValues.put("clientid", aVar.aYv());
                        }
                        if ((aVar.fDt & 2) != 0) {
                            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(aVar.status));
                        }
                        if ((aVar.fDt & 4) != 0) {
                            contentValues.put("createtime", Long.valueOf(aVar.hVE));
                        }
                        if ((aVar.fDt & 8) != 0) {
                            contentValues.put("lastmodifytime", Long.valueOf(aVar.hVF));
                        }
                        if ((aVar.fDt & 16) != 0) {
                            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_FILENAME, aVar.aYw());
                        }
                        if ((aVar.fDt & 32) != 0) {
                            contentValues.put("thumbfilename", aVar.aYx());
                        }
                        if ((aVar.fDt & 64) != 0) {
                            contentValues.put("tolist", aVar.aYy());
                        }
                        if ((aVar.fDt & FileUtils.S_IWUSR) != 0) {
                            contentValues.put("tolistcount", Integer.valueOf(aVar.omO));
                        }
                        if ((aVar.fDt & 256) != 0) {
                            contentValues.put("msgtype", Integer.valueOf(aVar.msgType));
                        }
                        if ((aVar.fDt & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
                            contentValues.put("mediatime", Integer.valueOf(aVar.omP));
                        }
                        if ((aVar.fDt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                            contentValues.put("datanetoffset", Integer.valueOf(aVar.omQ));
                        }
                        if ((aVar.fDt & 2048) != 0) {
                            contentValues.put("datalen", Integer.valueOf(aVar.fdR));
                        }
                        if ((aVar.fDt & Downloads.RECV_BUFFER_SIZE) != 0) {
                            contentValues.put("thumbnetoffset", Integer.valueOf(aVar.hVC));
                        }
                        if ((aVar.fDt & 8192) != 0) {
                            contentValues.put("thumbtotallen", Integer.valueOf(aVar.omR));
                        }
                        if ((aVar.fDt & 16384) != 0) {
                            contentValues.put("reserved1", Integer.valueOf(aVar.omS));
                        }
                        if ((aVar.fDt & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
                            contentValues.put("reserved2", Integer.valueOf(aVar.omT));
                        }
                        if ((aVar.fDt & 65536) != 0) {
                            contentValues.put("reserved3", aVar.hhn == null ? "" : aVar.hhn);
                        }
                        if ((aVar.fDt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                            contentValues.put("reserved4", aVar.hho == null ? "" : aVar.hho);
                        }
                        if (((int) aYD.hhp.insert("massendinfo", "clientid", contentValues)) != -1) {
                            ar.Hg();
                            Object obj = c.Fd().WY("masssendapp") == null ? 1 : null;
                            ae aeVar = new ae();
                            aeVar.setUsername("masssendapp");
                            aeVar.setContent(b.a(aVar));
                            aeVar.aj(aVar.hVE);
                            aeVar.eR(0);
                            aeVar.eO(0);
                            if (obj != null) {
                                ar.Hg();
                                c.Fd().d(aeVar);
                            } else {
                                ar.Hg();
                                c.Fd().a(aeVar, "masssendapp");
                            }
                            aYD.doNotify();
                        }
                    }
                    x.d("MicroMsg.NetSceneMasSend", "!!!FIN: useTime:" + (this.hEZ != null ? this.hEZ.zi() : 0));
                    this.gJT.a(i2, i3, str, this);
                } else if (a(this.hmA, this.gJT) == -1) {
                    this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                    this.gJT.a(3, -1, "doScene failed", this);
                }
            } else {
                x.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Data ");
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                this.gJT.a(3, -1, "doScene failed", this);
            }
        } else {
            x.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd STATUS ERR: status:" + this.omW.status);
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return JsApiChooseMedia.CTRL_INDEX;
    }
}
