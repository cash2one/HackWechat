package com.tencent.mm.az;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.m;
import com.tencent.mm.g.a.me;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.protocal.c.avi;
import com.tencent.mm.protocal.c.rg;
import com.tencent.mm.protocal.c.rh;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.w;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public final class j extends k implements m, com.tencent.mm.network.k {
    private int fqo;
    private b gJQ;
    private e gJT;
    public int hJE;
    private int offset = 0;

    public j(int i, int i2) {
        this.hJE = i;
        this.fqo = i2;
        m be = r.QH().be(i, i2);
        if (be == null) {
            x.e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:" + i);
            return;
        }
        be.status = 3;
        be.fDt = 64;
        r.QH().b(be);
        if (i2 == 5) {
            com.tencent.mm.loader.stub.b.deleteFile(g.Dj().cachePath + "brand_i18n.apk");
            return;
        }
        com.tencent.mm.loader.stub.b.deleteFile(n.QE() + r.QH().bg(i, i2));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", new Object[]{Integer.valueOf(this.hJE), Integer.valueOf(this.fqo)});
        m be = r.QH().be(this.hJE, this.fqo);
        if (be == null) {
            x.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.hJE + " type:" + this.fqo);
            return -1;
        } else if (be.status != 3) {
            x.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.hJE + " stat:" + be.status);
            return -1;
        } else if (be.size <= 0) {
            x.e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.hJE + " size:" + be.size);
            return -1;
        } else {
            a aVar = new a();
            aVar.hmj = new rg();
            aVar.hmk = new rh();
            aVar.uri = "/cgi-bin/micromsg-bin/downloadpackage";
            aVar.hmi = JsApiSetBackgroundAudioState.CTRL_INDEX;
            aVar.hml = 0;
            aVar.hmm = 0;
            this.gJQ = aVar.JZ();
            rg rgVar = (rg) this.gJQ.hmg.hmo;
            avi com_tencent_mm_protocal_c_avi = new avi();
            com_tencent_mm_protocal_c_avi.nkn = be.id;
            com_tencent_mm_protocal_c_avi.ktM = be.version;
            rgVar.vZm = com_tencent_mm_protocal_c_avi;
            rgVar.vNW = this.offset;
            rgVar.vZn = 65536;
            rgVar.ktN = this.fqo;
            return a(eVar, this.gJQ, this);
        }
    }

    protected final int a(q qVar) {
        rg rgVar = (rg) ((b) qVar).hmg.hmo;
        m be = r.QH().be(this.hJE, this.fqo);
        if (be == null) {
            x.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.hJE);
            return k.b.hmQ;
        } else if (rgVar.vZm.nkn == this.hJE && rgVar.vNW == this.offset && rgVar.vNW < be.size && rgVar.vZn == 65536 && be.size > 0 && be.status == 3) {
            return k.b.hmP;
        } else {
            x.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.hJE);
            return k.b.hmQ;
        }
    }

    protected final int Bh() {
        return 50;
    }

    protected final void a(k.a aVar) {
        r.QH().bi(this.hJE, this.fqo);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.hJE + " + id:" + i + " errtype:" + i2 + " errCode:" + i3);
        if (i2 == 0 || i3 == 0) {
            rh rhVar = (rh) ((b) qVar).hmh.hmo;
            if (rhVar.ktN != this.fqo) {
                x.e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
                r.QH().bi(this.hJE, this.fqo);
                this.gJT.a(3, -1, "", this);
                return;
            }
            byte[] a = n.a(rhVar.vZo);
            if (a == null || a.length == 0) {
                x.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.hJE);
                r.QH().bi(this.hJE, this.fqo);
                this.gJT.a(3, -1, str, this);
                return;
            }
            m be = r.QH().be(this.hJE, this.fqo);
            if (be == null) {
                x.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.hJE);
                r.QH().bi(this.hJE, this.fqo);
                this.gJT.a(3, -1, str, this);
                return;
            } else if (be.size != rhVar.vZp) {
                x.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
                r.QH().bi(this.hJE, this.fqo);
                g.Di().gPJ.a(new k(this.fqo), 0);
                this.gJT.a(3, -1, str, this);
                return;
            } else {
                String str2;
                String str3;
                if (this.fqo == 5) {
                    str2 = g.Dj().cachePath;
                    str3 = "brand_i18n.apk";
                } else {
                    r.QH();
                    str2 = n.QE();
                    str3 = r.QH().bg(this.hJE, this.fqo);
                }
                x.d("MicroMsg.NetSceneDownloadPackage", "packagePath " + str2);
                x.d("MicroMsg.NetSceneDownloadPackage", "packageName " + str3);
                int a2 = com.tencent.mm.a.e.a(str2, str3, a);
                if (a2 != 0) {
                    r.QH().bi(this.hJE, this.fqo);
                    x.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = " + a2);
                    this.gJT.a(3, -1, str, this);
                    return;
                }
                this.offset = a.length + this.offset;
                if (this.offset >= be.size) {
                    String bh;
                    boolean z = false;
                    if (this.fqo == 1) {
                        bh = r.QH().bh(this.hJE, this.fqo);
                        a2 = bh.ft(str2 + str3, bh);
                        if (a2 < 0) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + a2 + ", zipFilePath = " + str2 + str3 + ", unzipPath = " + bh);
                            r.QH().bi(this.hJE, this.fqo);
                            this.gJT.a(3, 0, "unzip fail", this);
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                    if (this.fqo == 8) {
                        z = ap(str2, str3);
                    }
                    if (this.fqo == 23) {
                        if (bh.ov(str2) || bh.ov(str3)) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", new Object[]{str2, str3});
                            r.QH().bi(this.hJE, this.fqo);
                            this.gJT.a(3, 0, "open permission pkg failed", this);
                            z = false;
                        } else if (new File(str2 + str3).exists()) {
                            if (-1 == com.tencent.mm.a.e.x(str2 + str3, com.tencent.mm.compatible.util.e.gZK + "permissioncfg.cfg")) {
                                x.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
                                r.QH().bi(this.hJE, this.fqo);
                                this.gJT.a(3, 0, "copy file failed", this);
                                z = false;
                            } else {
                                z = true;
                            }
                        } else {
                            x.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, file no exist, path: %s, name: %s", new Object[]{str2, str3});
                            r.QH().bi(this.hJE, this.fqo);
                            this.gJT.a(3, 0, "file not exist", this);
                            z = false;
                        }
                    }
                    if (this.fqo == 7) {
                        z = true;
                    }
                    if (this.fqo == 9) {
                        z = true;
                    }
                    if (this.fqo == 5) {
                        z = true;
                        x.i("MicroMsg.NetSceneDownloadPackage", "resetResContextImp");
                    }
                    if (this.fqo == 12) {
                        com.tencent.mm.sdk.b.b meVar = new me();
                        meVar.fDQ.fDS = str2 + str3;
                        com.tencent.mm.sdk.b.a.xef.m(meVar);
                        z = true;
                    }
                    if (this.fqo == 18) {
                        bh = r.QH().bh(this.hJE, this.fqo);
                        a2 = bh.ft(str2 + str3, bh);
                        if (a2 < 0) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + a2 + ", zipFilePath = " + str2 + str3 + ", unzipPath = " + bh);
                            r.QH().bi(this.hJE, this.fqo);
                            this.gJT.a(3, 0, "unzip fail", this);
                            z = false;
                        } else {
                            x.i("MicroMsg.NetSceneDownloadPackage", "Unzip Path %s", new Object[]{bh});
                            z = true;
                        }
                    }
                    if (this.fqo == 20) {
                        z = true;
                    }
                    if (this.fqo == 21) {
                        z = true;
                    }
                    if (this.fqo == 26) {
                        if (bh.ov(str2) || bh.ov(str3)) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, packagePath: %s, packageName: %s", new Object[]{str2, str3});
                            this.gJT.a(3, 0, "open IPCallContryCodeConfigs pkg failed", this);
                            z = false;
                        } else if (new File(str2 + str3).exists()) {
                            if (-1 == com.tencent.mm.a.e.x(str2 + str3, com.tencent.mm.compatible.util.e.gZK + "ipcallCountryCodeConfig.cfg")) {
                                x.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
                                r.QH().bi(this.hJE, this.fqo);
                                this.gJT.a(3, 0, "copy file failed", this);
                                z = false;
                            } else {
                                x.d("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg success");
                                z = true;
                            }
                        } else {
                            x.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, file not exist, packagePath: %s, packageName: %s", new Object[]{str2, str3});
                            r.QH().bi(this.hJE, this.fqo);
                            this.gJT.a(3, 0, "file not exist", this);
                            z = false;
                        }
                    }
                    if (this.fqo == 36) {
                        z = ao(str2, str3);
                    }
                    if (z) {
                        be.status = 2;
                        be.fDt = 64;
                        r.QH().b(be);
                        this.gJT.a(0, 0, "", this);
                        return;
                    }
                    return;
                } else if (a(this.hmA, this.gJT) < 0) {
                    r.QH().bi(this.hJE, this.fqo);
                    this.gJT.a(3, -1, str, this);
                    return;
                } else {
                    return;
                }
            }
        }
        x.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + i2 + ", errCode = " + i3);
        r.QH().bi(this.hJE, this.fqo);
        this.gJT.a(i2, i3, str, this);
    }

    private static boolean ao(String str, String str2) {
        Throwable e;
        boolean z = true;
        if (bh.ov(str) || bh.ov(str2)) {
            return false;
        }
        try {
            String str3 = str + str2;
            String bT = com.tencent.mm.a.e.bT(str3);
            if (bh.ov(bT)) {
                z = false;
            } else {
                g.Dj().CU().a(w.a.xsh, bT);
            }
            try {
                com.tencent.mm.loader.stub.b.deleteFile(str3);
                x.i("MicroMsg.NetSceneDownloadPackage", "update sense where result[%b] filepath[%s] xml[%s] ", new Object[]{Boolean.valueOf(z), str3, bh.VT(bT)});
                return z;
            } catch (IOException e2) {
                e = e2;
                x.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", e, "", new Object[0]);
                return z;
            }
        } catch (Throwable e3) {
            e = e3;
            z = false;
            x.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", e, "", new Object[0]);
            return z;
        }
    }

    private boolean ap(String str, String str2) {
        BufferedWriter bufferedWriter;
        Throwable e;
        Throwable th;
        InputStream inputStream = null;
        if (bh.ov(str) || bh.ov(str2)) {
            x.e("MicroMsg.NetSceneDownloadPackage", "update regioncode failed, no file assigned, packagePath:" + str + " ,packageName:" + str2);
            r.QH().bi(this.hJE, this.fqo);
            this.gJT.a(3, 0, "open regioncode file fail", this);
            return false;
        }
        File file = new File(str + str2);
        if (file.exists()) {
            Map hashMap = new HashMap();
            InputStream fileInputStream;
            try {
                String XD;
                File file2;
                fileInputStream = new FileInputStream(file);
                Reader inputStreamReader = new InputStreamReader(fileInputStream, ProtocolPackage.ServerEncoding);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.trim().split("\\|");
                    if (split.length < 2 || bh.ov(split[0]) || bh.ov(split[1])) {
                        x.e("MicroMsg.NetSceneDownloadPackage", "dispatch regioncode, error line = " + readLine);
                    } else {
                        bufferedWriter = (BufferedWriter) hashMap.get(split[0]);
                        if (bufferedWriter == null) {
                            RegionCodeDecoder.cjP();
                            XD = RegionCodeDecoder.XD(split[0]);
                            if (bh.ov(XD)) {
                                x.e("MicroMsg.NetSceneDownloadPackage", "dispatch regioncode, output language unsupported");
                            } else {
                                try {
                                    file2 = new File(XD);
                                    if (!file2.exists()) {
                                        file2.createNewFile();
                                    }
                                    bufferedWriter = new BufferedWriter(new FileWriter(file2));
                                    hashMap.put(split[0], bufferedWriter);
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            }
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(split[1]);
                        stringBuffer.append('|');
                        stringBuffer.append(split[2]);
                        stringBuffer.append('\n');
                        bufferedWriter.write(stringBuffer.toString());
                    }
                }
                for (BufferedWriter bufferedWriter2 : hashMap.values()) {
                    if (bufferedWriter2 != null) {
                        bufferedWriter2.flush();
                    }
                }
                if (!bh.ov(XD)) {
                    for (File file22 : new File(XD).getParentFile().listFiles(new 1(this))) {
                        RegionCodeDecoder.cjP();
                        RegionCodeDecoder.f(file22, file22.getParentFile());
                    }
                    RegionCodeDecoder.cjP().chP();
                }
                bufferedReader.close();
                inputStreamReader.close();
                file.delete();
                try {
                    fileInputStream.close();
                    for (BufferedWriter bufferedWriter22 : hashMap.values()) {
                        if (bufferedWriter22 != null) {
                            bufferedWriter22.close();
                        }
                    }
                } catch (Throwable e3) {
                    x.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", new Object[]{bh.i(e3)});
                }
                return true;
            } catch (Exception e4) {
                e3 = e4;
                fileInputStream = null;
                try {
                    x.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", new Object[]{bh.i(e3)});
                    r.QH().bi(this.hJE, this.fqo);
                    this.gJT.a(3, 0, e3.getMessage(), this);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e32) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", new Object[]{bh.i(e32)});
                            return false;
                        }
                    }
                    for (BufferedWriter bufferedWriter222 : hashMap.values()) {
                        if (bufferedWriter222 != null) {
                            bufferedWriter222.close();
                        }
                    }
                    return false;
                } catch (Throwable e322) {
                    inputStream = fileInputStream;
                    th = e322;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e3222) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", new Object[]{bh.i(e3222)});
                            throw th;
                        }
                    }
                    for (BufferedWriter bufferedWriter2222 : hashMap.values()) {
                        if (bufferedWriter2222 != null) {
                            bufferedWriter2222.close();
                        }
                    }
                    throw th;
                }
            } catch (Throwable e32222) {
                th = e32222;
                if (inputStream != null) {
                    inputStream.close();
                }
                for (BufferedWriter bufferedWriter22222 : hashMap.values()) {
                    if (bufferedWriter22222 != null) {
                        bufferedWriter22222.close();
                    }
                }
                throw th;
            }
        }
        x.e("MicroMsg.NetSceneDownloadPackage", "update regioncode failed, file not exist, packagePath:" + str + " ,packageName:" + str2);
        r.QH().bi(this.hJE, this.fqo);
        this.gJT.a(3, 0, "no regioncode file found", this);
        return false;
    }

    public final int getType() {
        return JsApiSetBackgroundAudioState.CTRL_INDEX;
    }

    public final int Kl() {
        return this.fqo;
    }
}
