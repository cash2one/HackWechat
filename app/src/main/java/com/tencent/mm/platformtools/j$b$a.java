package com.tencent.mm.platformtools;

import android.graphics.Bitmap;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.q;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.network.b;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.as.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

class j$b$a implements a {
    private Bitmap hkT = null;
    private int icp = 0;
    private i icq;

    public j$b$a(i iVar) {
        if (j.c(iVar)) {
            this.icq = iVar;
            return;
        }
        throw new IllegalArgumentException("from net, picture strategy here must be validity");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean JB() {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        Throwable e;
        InputStream inputStream2;
        FileOutputStream fileOutputStream2;
        String str;
        InputStream inputStream3 = null;
        if (this.icq == null) {
            x.e("MicroMsg.MMPictureLogic", "picStrategy == null");
        } else {
            try {
                u a;
                String contentType;
                this.icq.Wm();
                File file = new File(this.icq.Wf());
                fileOutputStream = new FileOutputStream(file.getAbsolutePath() + "_tmp");
                try {
                    a = b.a(this.icq.Wg(), null);
                    if (q.PE() && q.lx(this.icq.Wg())) {
                        x.d("MicroMsg.MMPictureLogic", "webp referer:%s", new Object[]{q.hZ(d.vAz)});
                        a.oi(contentType);
                    }
                    a.setConnectTimeout(10000);
                    a.setReadTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
                    a.setRequestMethod("GET");
                    if (b.a(a) == 0) {
                        inputStream = a.getInputStream();
                    } else {
                        inputStream = null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    inputStream2 = null;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bh.i(e)});
                        x.w("MicroMsg.MMPictureLogic", "get url:%s failed.", new Object[]{this.icq.Wg()});
                        this.icq.N(str, false);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable e3) {
                                x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bh.i(e3)});
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable e32) {
                                x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bh.i(e32)});
                            }
                        }
                        return true;
                    } catch (Throwable th) {
                        e32 = th;
                        inputStream3 = inputStream2;
                        fileOutputStream = fileOutputStream2;
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Throwable e4) {
                                x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bh.i(e4)});
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e42) {
                                x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bh.i(e42)});
                            }
                        }
                        throw e32;
                    }
                } catch (Throwable th2) {
                    e32 = th2;
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e32;
                }
                try {
                    contentType = a.aBw.getContentType();
                    x.d("MicroMsg.MMPictureLogic", "contentType:%s", new Object[]{contentType});
                    if (inputStream == null) {
                        x.w("MicroMsg.MMPictureLogic", "download %s error, can not open http stream", new Object[]{this.icq.Wg()});
                        this.icq.N(contentType, false);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e322) {
                                x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bh.i(e322)});
                            }
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e3222) {
                            x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bh.i(e3222)});
                        }
                    } else {
                        Bitmap a2;
                        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            this.icp += read;
                            fileOutputStream.write(bArr, 0, read);
                        }
                        x.i("MicroMsg.MMPictureLogic", "get url[%s] ok, bufSize[%d]", new Object[]{this.icq.Wg(), Integer.valueOf(this.icp)});
                        this.icq.N(contentType, true);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e32222) {
                                x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bh.i(e32222)});
                            }
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e322222) {
                            x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bh.i(e322222)});
                        }
                        try {
                            Bitmap oo;
                            g.bV(file.getAbsolutePath() + "_tmp");
                            i.b We = this.icq.We();
                            if (We != null) {
                                oo = We.oo(file.getAbsolutePath() + "_tmp");
                            } else {
                                oo = j.b.op(file.getAbsolutePath() + "_tmp");
                            }
                            if (oo != null) {
                                a2 = this.icq.a(oo, i.a.ice, file.getAbsolutePath() + "_tmp");
                            } else {
                                this.icq.a(i.a.ice, contentType);
                                a2 = null;
                            }
                            if (!(a2 == oo || oo.isRecycled())) {
                                x.i("MicroMsg.MMPictureLogic", "recycle bitmap:%s", new Object[]{oo.toString()});
                                oo.recycle();
                            }
                            j.b.a(j.b.ici, this.icq, a2);
                            new File(file.getAbsolutePath() + "_tmp").delete();
                        } catch (Throwable e3222222) {
                            x.w("MicroMsg.MMPictureLogic", "update pic for %s, error", new Object[]{this.icq.Wg()});
                            x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bh.i(e3222222)});
                            a2 = null;
                        }
                        this.hkT = a2;
                    }
                } catch (Exception e5) {
                    e3222222 = e5;
                    str = contentType;
                    inputStream2 = inputStream;
                    fileOutputStream2 = fileOutputStream;
                    x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bh.i(e3222222)});
                    x.w("MicroMsg.MMPictureLogic", "get url:%s failed.", new Object[]{this.icq.Wg()});
                    this.icq.N(str, false);
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    return true;
                } catch (Throwable th3) {
                    e3222222 = th3;
                    inputStream3 = inputStream;
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e3222222;
                }
            } catch (Exception e6) {
                e3222222 = e6;
                inputStream2 = null;
                fileOutputStream2 = null;
                x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bh.i(e3222222)});
                x.w("MicroMsg.MMPictureLogic", "get url:%s failed.", new Object[]{this.icq.Wg()});
                this.icq.N(str, false);
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return true;
            } catch (Throwable th4) {
                e3222222 = th4;
                fileOutputStream = null;
                if (inputStream3 != null) {
                    inputStream3.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e3222222;
            }
        }
        return true;
    }

    public final boolean JC() {
        try {
            ak.a.hfM.aV(this.icp, 0);
        } catch (Throwable e) {
            x.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[]{bh.i(e)});
        }
        j.b.a(j.b.ici, this.icq.Wg(), this.icq.Wh(), this.hkT);
        this.hkT = null;
        return false;
    }
}
