package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.a.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pluginsdk.i.a.e.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

final class l {
    final String filePath;
    private final int fpm;
    private final int fpn;
    private final int fpo;
    private final boolean fpp;
    private final boolean fpt;
    volatile int state = -1;
    private final String url;
    final boolean vgM;
    final boolean vgN;
    final String vgd;
    private final String vgg;
    private final int vgh;
    private final byte[] vgi;
    private final String vgj;
    private final long vgl;
    private final String vgm;
    private final int vgn;
    private final int vgo;
    volatile String vhm = null;
    volatile String vhn = null;

    l(int i, int i2, String str, boolean z, boolean z2, String str2, int i3, boolean z3, boolean z4, byte[] bArr, String str3, String str4, long j, String str5, int i4, int i5, int i6) {
        this.vgd = i.ey(i, i2);
        this.fpm = i;
        this.fpn = i2;
        this.filePath = str;
        this.vgN = z;
        this.vgM = z2;
        this.vgg = str2;
        this.vgh = i3;
        this.vgi = bArr;
        this.vgj = str3;
        this.fpt = z3;
        this.fpp = z4;
        this.vgm = str4;
        this.vgl = j;
        this.url = str5;
        this.vgn = i4;
        this.vgo = i5;
        this.fpo = i6;
    }

    final l bZr() {
        Throwable e;
        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), file_state = %s, before do decrypt, inPath = %s, outPath = %s, (key == empty) = %b", new Object[]{this.vgd, bZu(), this.vhm, this.vhn, Boolean.valueOf(bh.ov(this.vgg))});
        if (1 == this.state) {
            if (bh.ov(this.vgg)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), invalid encrypt key", new Object[]{this.vgd});
                this.vhm = null;
                this.state = 8;
                j.I(this.vgl, 54);
                j.I(this.vgl, 45);
            } else {
                boolean z;
                try {
                    String str = this.vhm;
                    String str2 = this.vhn;
                    String str3 = this.vgg;
                    File file = new File(str);
                    if (file.exists() && file.isFile()) {
                        file = new File(str2);
                        file.getParentFile().mkdirs();
                        file.delete();
                        byte[] RZ = a.RZ(str);
                        if (bh.bw(RZ)) {
                            x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "read bytes empty");
                            j.I(this.vgl, 56);
                            j.I(this.vgl, 45);
                            j.I(this.vgl, 18);
                            z = false;
                        } else {
                            RZ = MMProtocalJni.aesDecrypt(RZ, str3.getBytes());
                            if (bh.bw(RZ)) {
                                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypted bytes empty");
                                j.I(this.vgl, 55);
                                j.I(this.vgl, 45);
                                j.I(this.vgl, 18);
                                z = false;
                            } else {
                                z = a.u(str2, RZ);
                                if (!z) {
                                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypt write bytes fail");
                                    j.I(this.vgl, 57);
                                    j.I(this.vgl, 45);
                                    j.I(this.vgl, 18);
                                }
                            }
                        }
                    } else {
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[]{str});
                        z = false;
                    }
                    try {
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), decrypt done, ret = %b", new Object[]{this.vgd, Boolean.valueOf(z)});
                    } catch (Exception e2) {
                        e = e2;
                        x.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", new Object[]{this.vgd, e});
                        j.I(this.vgl, 45);
                        j.I(this.vgl, 18);
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", new Object[]{this.vgd, Boolean.valueOf(z)});
                        if (z) {
                            j.I(this.vgl, 17);
                            this.vhm = this.vhn;
                            if (this.vgM) {
                                this.vhn = this.filePath + ".decompressed";
                                this.state = 2;
                            } else {
                                this.state = 4;
                            }
                        } else {
                            this.vhm = null;
                            this.state = 8;
                        }
                        return this;
                    }
                } catch (Throwable e3) {
                    e = e3;
                    z = false;
                    x.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", new Object[]{this.vgd, e});
                    j.I(this.vgl, 45);
                    j.I(this.vgl, 18);
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", new Object[]{this.vgd, Boolean.valueOf(z)});
                    if (z) {
                        j.I(this.vgl, 17);
                        this.vhm = this.vhn;
                        if (this.vgM) {
                            this.state = 4;
                        } else {
                            this.vhn = this.filePath + ".decompressed";
                            this.state = 2;
                        }
                    } else {
                        this.vhm = null;
                        this.state = 8;
                    }
                    return this;
                }
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", new Object[]{this.vgd, Boolean.valueOf(z)});
                if (z) {
                    this.vhm = null;
                    this.state = 8;
                } else {
                    j.I(this.vgl, 17);
                    this.vhm = this.vhn;
                    if (this.vgM) {
                        this.vhn = this.filePath + ".decompressed";
                        this.state = 2;
                    } else {
                        this.state = 4;
                    }
                }
            }
        }
        return this;
    }

    final l bZs() {
        Throwable e;
        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), file_state = %s, before do decompress, inPath = %s, outPath = %s", new Object[]{this.vgd, bZu(), this.vhm, this.vhn});
        if (2 == this.state) {
            boolean z;
            try {
                String str = this.vhm;
                String str2 = this.vhn;
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    new File(str2).delete();
                    byte[] v = q.v(a.RZ(str));
                    if (bh.bw(v)) {
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "uncompressed bytes empty");
                        z = false;
                    } else {
                        z = a.u(str2, v);
                    }
                } else {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[]{str});
                    z = false;
                }
                try {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), decompress done, ret = %b", new Object[]{this.vgd, Boolean.valueOf(z)});
                } catch (Exception e2) {
                    e = e2;
                    x.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", new Object[]{this.vgd, e});
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", new Object[]{this.vgd, Boolean.valueOf(z)});
                    if (z) {
                        this.vhm = this.vhn;
                        this.state = 4;
                        j.I(this.vgl, 19);
                    } else {
                        this.vhm = null;
                        this.state = 8;
                        j.I(this.vgl, 20);
                        j.I(this.vgl, 46);
                        if (this.vgN) {
                            j.a(this.fpm, this.fpn, this.vgh, this.fpt, true, false, false, this.vgm);
                        } else {
                            j.a(this.fpm, this.fpn, this.url, this.fpo, this.vgn > this.vgo ? j.a.vhg : j.a.vhe, false, this.fpt, false, this.vgm);
                        }
                    }
                    return this;
                }
            } catch (Throwable e3) {
                e = e3;
                z = false;
                x.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", new Object[]{this.vgd, e});
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", new Object[]{this.vgd, Boolean.valueOf(z)});
                if (z) {
                    this.vhm = null;
                    this.state = 8;
                    j.I(this.vgl, 20);
                    j.I(this.vgl, 46);
                    if (this.vgN) {
                        if (this.vgn > this.vgo) {
                        }
                        j.a(this.fpm, this.fpn, this.url, this.fpo, this.vgn > this.vgo ? j.a.vhg : j.a.vhe, false, this.fpt, false, this.vgm);
                    } else {
                        j.a(this.fpm, this.fpn, this.vgh, this.fpt, true, false, false, this.vgm);
                    }
                } else {
                    this.vhm = this.vhn;
                    this.state = 4;
                    j.I(this.vgl, 19);
                }
                return this;
            }
            x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", new Object[]{this.vgd, Boolean.valueOf(z)});
            if (z) {
                this.vhm = this.vhn;
                this.state = 4;
                j.I(this.vgl, 19);
            } else {
                this.vhm = null;
                this.state = 8;
                j.I(this.vgl, 20);
                j.I(this.vgl, 46);
                if (this.vgN) {
                    j.a(this.fpm, this.fpn, this.vgh, this.fpt, true, false, false, this.vgm);
                } else if (this.vgM && this.fpp) {
                    if (this.vgn > this.vgo) {
                    }
                    j.a(this.fpm, this.fpn, this.url, this.fpo, this.vgn > this.vgo ? j.a.vhg : j.a.vhe, false, this.fpt, false, this.vgm);
                }
            }
        } else if (8 == this.state && this.vgN) {
            j.a(this.fpm, this.fpn, this.vgh, this.fpt, false, false, false, this.vgm);
        }
        return this;
    }

    final String bZt() {
        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + bZu(), new Object[]{this.vgd});
        if (16 == this.state) {
            return this.vhm;
        }
        if (4 != this.state && 32 != this.state) {
            return null;
        }
        String str;
        if (!bh.ov(this.vhm)) {
            String str2;
            String str3 = "MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer";
            String str4 = "%s: checkSumImpl(), state = %s, originalMd5 = %s, eccSig.size = %s";
            Object[] objArr = new Object[4];
            objArr[0] = this.vgd;
            objArr[1] = bZu();
            objArr[2] = this.vgj;
            if (this.vgi == null) {
                str2 = "null";
            } else {
                str2 = String.valueOf(this.vgi.length);
            }
            objArr[3] = str2;
            x.i(str3, str4, objArr);
            if (bh.ov(this.vgj) || !bh.ou(g.bV(this.vhm)).equals(this.vgj)) {
                if (this.state == 4) {
                    j.I(this.vgl, 24);
                }
                if (!bh.bw(this.vgi) && UtilsJni.doEcdsaSHAVerify(i.vgP, a.RZ(this.vhm), this.vgi) > 0) {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", new Object[]{this.vgd, bZu()});
                    if (this.state == 4) {
                        j.I(this.vgl, 25);
                    }
                    str = this.vhm;
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", new Object[]{this.vgd, str});
                    if (this.state == 4) {
                        return str;
                    }
                    if (bh.ov(str) && !this.vgM) {
                        j.I(this.vgl, 58);
                        j.I(this.vgl, 45);
                    }
                    if (bh.ov(str)) {
                        if (this.vgN) {
                            j.a(this.fpm, this.fpn, this.vgh, this.fpt, true, true, false, this.vgm);
                            return str;
                        } else if (this.vgM && this.fpp) {
                            j.a(this.fpm, this.fpn, this.url, this.fpo, this.vgn > this.vgo ? j.a.vhg : j.a.vhe, false, this.fpt, true, this.vgm);
                            return str;
                        }
                    } else if (this.vgN) {
                        j.a(this.fpm, this.fpn, this.vgh, this.fpt, true, true, true, this.vgm);
                        return str;
                    } else if (this.vgM && this.fpp) {
                        j.a(this.fpm, this.fpn, this.url, this.fpo, this.vgn > this.vgo ? j.a.vhg : j.a.vhe, true, this.fpt, true, this.vgm);
                        return str;
                    }
                } else if (this.state == 4) {
                    j.I(this.vgl, 26);
                }
            } else {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", new Object[]{this.vgd, bZu()});
                if (this.state == 4) {
                    j.I(this.vgl, 23);
                }
                str = this.vhm;
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", new Object[]{this.vgd, str});
                if (this.state == 4) {
                    return str;
                }
                j.I(this.vgl, 58);
                j.I(this.vgl, 45);
                if (bh.ov(str)) {
                    if (this.vgN) {
                        return this.vgM ? str : str;
                    } else {
                        j.a(this.fpm, this.fpn, this.vgh, this.fpt, true, true, true, this.vgm);
                        return str;
                    }
                } else if (this.vgN) {
                    return this.vgM ? str : str;
                } else {
                    j.a(this.fpm, this.fpn, this.vgh, this.fpt, true, true, false, this.vgm);
                    return str;
                }
            }
        }
        str = null;
        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", new Object[]{this.vgd, str});
        if (this.state == 4) {
            return str;
        }
        j.I(this.vgl, 58);
        j.I(this.vgl, 45);
        if (bh.ov(str)) {
            if (this.vgN) {
                j.a(this.fpm, this.fpn, this.vgh, this.fpt, true, true, false, this.vgm);
                return str;
            } else if (this.vgM) {
            }
        } else if (this.vgN) {
            j.a(this.fpm, this.fpn, this.vgh, this.fpt, true, true, true, this.vgm);
            return str;
        } else if (this.vgM) {
        }
    }

    final String bZu() {
        switch (this.state) {
            case 1:
                return "state_decrypt";
            case 2:
                return "state_decompress";
            case 4:
                return "state_check_sum";
            case 8:
                return "state_file_invalid";
            case 16:
                return "state_file_valid";
            case 32:
                return "state_pre_verify_check_sum";
            default:
                return this.state;
        }
    }
}
