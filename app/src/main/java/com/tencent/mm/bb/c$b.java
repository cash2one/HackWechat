package com.tencent.mm.bb;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.b;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.as.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

class c$b implements a {
    private String hDC;
    private String hKw;
    private c$a hKx;
    final /* synthetic */ c hKy;
    private boolean success = false;
    private String username;

    public c$b(c cVar, String str, String str2, c$a com_tencent_mm_bb_c_a) {
        this.hKy = cVar;
        this.username = str;
        this.hKw = str2;
        this.hKx = com_tencent_mm_bb_c_a;
    }

    public final boolean JB() {
        Throwable e;
        u uVar;
        OutputStream outputStream;
        InputStream inputStream = null;
        if (bh.ov(this.username)) {
            return false;
        }
        this.hDC = c.lO(this.username);
        String str = "";
        if (g.Dh().Cy()) {
            r4 = new Object[4];
            g.Dh();
            r4[1] = o.getString(com.tencent.mm.kernel.a.Cg());
            r4[2] = Integer.valueOf(an.getNetTypeForStat(ac.getContext()));
            r4[3] = Integer.valueOf(an.getStrength(ac.getContext()));
            str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r4);
        }
        x.d("MicroMsg.RemarkImageStorage", "get remark image user: %s referer: %s  url:%s", this.username, str, this.hKw);
        this.success = false;
        u a;
        try {
            a = b.a(this.hKw, null);
            try {
                a.setRequestMethod("GET");
                a.setRequestProperty("referer", str);
                a.setConnectTimeout(5000);
                a.setReadTimeout(5000);
                if (b.a(a) != 0) {
                    x.e("MicroMsg.RemarkImageStorage", "checkHttpConnection failed! url:%s", this.hKw);
                    try {
                        a.aBw.disconnect();
                    } catch (Throwable e2) {
                        x.e("MicroMsg.RemarkImageStorage", "exception:%s", bh.i(e2));
                    }
                    return true;
                }
                InputStream inputStream2 = a.getInputStream();
                if (inputStream2 == null) {
                    try {
                        x.d("MicroMsg.RemarkImageStorage", "getInputStream failed. url:%s", this.hKw);
                        try {
                            a.aBw.disconnect();
                        } catch (Throwable e22) {
                            x.e("MicroMsg.RemarkImageStorage", "exception:%s", bh.i(e22));
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable e222) {
                                x.e("MicroMsg.RemarkImageStorage", "exception:%s", bh.i(e222));
                            }
                        }
                        return true;
                    } catch (Exception e3) {
                        e222 = e3;
                        uVar = a;
                        inputStream = inputStream2;
                        Object obj = null;
                        try {
                            x.e("MicroMsg.RemarkImageStorage", "exception:%s", bh.i(e222));
                            this.success = false;
                            if (uVar != null) {
                                try {
                                    uVar.aBw.disconnect();
                                } catch (Throwable e2222) {
                                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", bh.i(e2222));
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e22222) {
                                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", bh.i(e22222));
                                }
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable e222222) {
                                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", bh.i(e222222));
                                }
                            }
                            return true;
                        } catch (Throwable th) {
                            e222222 = th;
                            a = uVar;
                            if (a != null) {
                                try {
                                    a.aBw.disconnect();
                                } catch (Throwable e4) {
                                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", bh.i(e4));
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e5) {
                                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", bh.i(e5));
                                }
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable e52) {
                                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", bh.i(e52));
                                }
                            }
                            throw e222222;
                        }
                    } catch (Throwable th2) {
                        e222222 = th2;
                        InputStream inputStream3 = inputStream2;
                        outputStream = null;
                        inputStream = inputStream3;
                        if (a != null) {
                            a.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw e222222;
                    }
                }
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                OutputStream fileOutputStream = new FileOutputStream(this.hDC + ".tmp");
                while (true) {
                    try {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (Exception e6) {
                        e222222 = e6;
                        inputStream = inputStream2;
                        outputStream = fileOutputStream;
                        uVar = a;
                    } catch (Throwable th3) {
                        e222222 = th3;
                        inputStream = inputStream2;
                        outputStream = fileOutputStream;
                    }
                }
                this.success = true;
                try {
                    a.aBw.disconnect();
                } catch (Throwable e2222222) {
                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", bh.i(e2222222));
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable e22222222) {
                        x.e("MicroMsg.RemarkImageStorage", "exception:%s", bh.i(e22222222));
                    }
                }
                try {
                    fileOutputStream.close();
                } catch (Throwable e222222222) {
                    x.e("MicroMsg.RemarkImageStorage", "exception:%s", bh.i(e222222222));
                }
                return true;
            } catch (Exception e7) {
                e222222222 = e7;
                outputStream = null;
                uVar = a;
                x.e("MicroMsg.RemarkImageStorage", "exception:%s", bh.i(e222222222));
                this.success = false;
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
            } catch (Throwable th4) {
                e222222222 = th4;
                outputStream = null;
                if (a != null) {
                    a.aBw.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                throw e222222222;
            }
        } catch (Exception e8) {
            e222222222 = e8;
            outputStream = null;
            uVar = null;
            x.e("MicroMsg.RemarkImageStorage", "exception:%s", bh.i(e222222222));
            this.success = false;
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
        } catch (Throwable th5) {
            e222222222 = th5;
            outputStream = null;
            a = null;
            if (a != null) {
                a.aBw.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw e222222222;
        }
    }

    public final boolean JC() {
        if (this.success) {
            com.tencent.mm.loader.stub.b.deleteFile(this.hDC);
            new File(this.hDC + ".tmp").renameTo(new File(this.hDC));
            this.hKx.bQ(true);
            return true;
        }
        this.hKx.bQ(false);
        return false;
    }
}
