package com.tencent.mm.ad;

import android.annotation.SuppressLint;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.io.OutputStream;
import junit.framework.Assert;
import org.xwalk.core.XWalkUpdater;

public final class e implements com.tencent.mm.ae.e {
    h hkV = null;
    b hle = null;
    k hlf = null;
    boolean hlg = false;
    private as hlh = null;

    public interface b {
        int ba(int i, int i2);
    }

    @SuppressLint({"DefaultLocale"})
    class a implements com.tencent.mm.sdk.platformtools.as.a {
        public h hkR = null;
        public String hli = null;
        public boolean hlj = true;
        private com.tencent.mm.compatible.util.g.a hlk;
        final /* synthetic */ e hll;

        public a(e eVar, h hVar) {
            this.hll = eVar;
            this.hkR = hVar;
            n.Jz();
            this.hli = d.x(hVar.getUsername(), true);
            this.hlk = new com.tencent.mm.compatible.util.g.a();
        }

        public final boolean JB() {
            Throwable e;
            u uVar;
            Object obj;
            OutputStream outputStream;
            InputStream inputStream = null;
            if (this.hkR == null) {
                return false;
            }
            String JG = this.hkR.JG();
            String str = "";
            if (g.Dh().Cy()) {
                r4 = new Object[4];
                g.Dh();
                r4[1] = o.getString(com.tencent.mm.kernel.a.Cg());
                r4[2] = Integer.valueOf(an.getNetTypeForStat(ac.getContext()));
                r4[3] = Integer.valueOf(an.getStrength(ac.getContext()));
                str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r4);
            }
            x.d("MicroMsg.GetHDHeadImgHelper", "dkreferer dkavatar user: %s referer: %s  url:%s", this.hkR.getUsername(), str, JG);
            this.hlj = true;
            try {
                u a = com.tencent.mm.network.b.a(JG, null);
                try {
                    a.setRequestMethod("GET");
                    a.setRequestProperty("referer", str);
                    a.setConnectTimeout(5000);
                    a.setReadTimeout(5000);
                    if (com.tencent.mm.network.b.a(a) != 0) {
                        x.e("MicroMsg.GetHDHeadImgHelper", "checkHttpConnection failed! url:%s", JG);
                        return true;
                    }
                    InputStream inputStream2 = a.getInputStream();
                    if (inputStream2 == null) {
                        try {
                            x.d("MicroMsg.GetHDHeadImgHelper", "getInputStream failed. url:%s", JG);
                            return true;
                        } catch (Exception e2) {
                            e = e2;
                            uVar = a;
                            inputStream = inputStream2;
                            obj = null;
                            x.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bh.i(e));
                            this.hlj = true;
                            if (uVar != null) {
                                try {
                                    uVar.aBw.disconnect();
                                } catch (Throwable e3) {
                                    x.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bh.i(e3));
                                    x.e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e3.getMessage());
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            return true;
                        }
                    }
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    OutputStream iE = FileOp.iE(this.hli + ".tmp");
                    while (true) {
                        try {
                            int read = inputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            iE.write(bArr, 0, read);
                        } catch (Exception e4) {
                            e3 = e4;
                            inputStream = inputStream2;
                            outputStream = iE;
                            uVar = a;
                        }
                    }
                    this.hlj = false;
                    iE.close();
                    a.aBw.disconnect();
                    try {
                        inputStream2.close();
                        outputStream = null;
                        uVar = null;
                    } catch (Exception e5) {
                        e3 = e5;
                        uVar = null;
                        inputStream = inputStream2;
                        obj = null;
                        x.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bh.i(e3));
                        this.hlj = true;
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        return true;
                    }
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return true;
                } catch (Exception e6) {
                    e3 = e6;
                    outputStream = null;
                    uVar = a;
                    x.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bh.i(e3));
                    this.hlj = true;
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return true;
                }
            } catch (Exception e7) {
                e3 = e7;
                outputStream = null;
                uVar = null;
                x.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bh.i(e3));
                this.hlj = true;
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                return true;
            }
        }

        public final boolean JC() {
            if (this.hll.hlg) {
                return false;
            }
            if (this.hlj || bh.ov(this.hli)) {
                this.hll.hle.ba(4, -1);
                return false;
            }
            x.d("MicroMsg.GetHDHeadImgHelper", "dkavatar user:" + this.hkR.getUsername() + " urltime:" + this.hlk.zi());
            if (com.tencent.mm.z.ak.a.hfM != null) {
                com.tencent.mm.z.ak.a.hfM.aV((int) FileOp.me(this.hli + ".tmp"), 0);
            }
            FileOp.deleteFile(this.hli);
            FileOp.at(this.hli + ".tmp", this.hli);
            k.ad(this.hli, this.hll.hkV.getUsername());
            this.hll.hle.ba(0, 0);
            return true;
        }
    }

    public e() {
        g.CG().a(158, (com.tencent.mm.ae.e) this);
    }

    public final void JD() {
        g.CG().b(158, (com.tencent.mm.ae.e) this);
    }

    public final int a(String str, b bVar) {
        Assert.assertTrue("GetHDHeadImg must set callback", true);
        if (bh.ov(str)) {
            bVar.ba(3, XWalkUpdater.ERROR_SET_VERNUM);
            return XWalkUpdater.ERROR_SET_VERNUM;
        }
        String WD;
        this.hle = bVar;
        if (com.tencent.mm.storage.x.gy(str)) {
            WD = com.tencent.mm.storage.x.WD(str);
        } else {
            WD = str;
        }
        this.hkV = n.JQ().jm(WD);
        x.d("MicroMsg.GetHDHeadImgHelper", "GetHDHeadImg: %s", WD);
        if (this.hkV == null || !this.hkV.getUsername().equals(WD)) {
            this.hkV = new h();
            this.hkV.username = WD;
        }
        if (bh.ov(this.hkV.JG())) {
            x.w("MicroMsg.GetHDHeadImgHelper", "dkhurl [%s] has NO URL flag:%d !", str, Integer.valueOf(this.hkV.fWe));
            this.hlf = new k(WD);
            if (g.CG().a(this.hlf, 0)) {
                return 0;
            }
            bVar.ba(3, -102);
            return -102;
        }
        h hVar = this.hkV;
        if (this.hlh == null || this.hlh.cfT()) {
            this.hlh = new as(1, "get-hd-headimg", 1);
        }
        if (this.hlh.c(new a(this, hVar)) == 0) {
            return 0;
        }
        bVar.ba(3, -103);
        return -103;
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.hle.ba(i, i2);
    }
}
