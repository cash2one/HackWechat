package com.tencent.mm.z;

import android.os.Message;
import android.webkit.URLUtil;
import com.tencent.mm.a.e;
import com.tencent.mm.aq.q;
import com.tencent.mm.network.b;
import com.tencent.mm.network.u;
import com.tencent.mm.network.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.w.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

class w$a implements Runnable {
    final /* synthetic */ w hfC;
    boolean hfF = true;

    w$a(w wVar) {
        this.hfC = wVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        c cVar;
        InputStream inputStream;
        OutputStream fileOutputStream;
        Throwable e;
        OutputStream outputStream;
        InputStream inputStream2;
        c cVar2;
        boolean z;
        Throwable th;
        InputStream inputStream3 = null;
        this.hfF = false;
        boolean z2 = false;
        while (!this.hfF) {
            if (z2 > true) {
                this.hfF = true;
                return;
            }
            try {
                cVar = (c) this.hfC.hfA.poll(500, TimeUnit.MILLISECONDS);
                if (cVar != null) {
                    if (!bh.ov(cVar.url)) {
                        x.d("MicroMsg.GetPicService", "Thread get :" + cVar.url + " file:" + cVar.filename);
                        if (e.bO(cVar.filename)) {
                            x.d("MicroMsg.GetPicService", "Thread exist file:" + cVar.filename);
                            z2 = false;
                        } else {
                            w.a(this.hfC, 0, 1);
                            long Wp = bh.Wp();
                            x.d("MicroMsg.GetPicService", "get GetPicRunnable, run, url:%s", new Object[]{cVar.url});
                            byte[] bArr;
                            int read;
                            String contentType;
                            if (URLUtil.isHttpsUrl(cVar.url)) {
                                v oh = b.oh(cVar.url);
                                if (q.PE() && q.lx(cVar.url)) {
                                    x.d("MicroMsg.GetPicService", "webp referer:%s", new Object[]{q.hY(d.vAz)});
                                    oh.iaw.setRequestProperty("Referer", r3);
                                }
                                x.i("MicroMsg.GetPicService", "getCookie = %s, url = %s", new Object[]{cVar.hfH, cVar.url});
                                if (!bh.ov(cVar.hfH)) {
                                    String str = cVar.hfH;
                                    oh.iaw.setRequestProperty("Cookie", str);
                                }
                                oh.VD();
                                oh.VB();
                                oh.VC();
                                inputStream = oh.iaw.getInputStream();
                                try {
                                    bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                                    fileOutputStream = new FileOutputStream(cVar.filename + ".tmp");
                                    while (true) {
                                        try {
                                            read = inputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                        } catch (Exception e2) {
                                            e = e2;
                                            outputStream = fileOutputStream;
                                            inputStream2 = inputStream;
                                            cVar2 = cVar;
                                            z = false;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            inputStream3 = inputStream;
                                        }
                                    }
                                    new File(cVar.filename + ".tmp").renameTo(new File(cVar.filename));
                                    contentType = oh.iaw.getContentType();
                                    x.d("MicroMsg.GetPicService", "contentType:%s", new Object[]{contentType});
                                } catch (Exception e3) {
                                    e = e3;
                                    inputStream2 = inputStream;
                                    outputStream = null;
                                    cVar2 = cVar;
                                    z = false;
                                    try {
                                        x.e("MicroMsg.GetPicService", "exception:%s", new Object[]{bh.i(e)});
                                        w.a(this.hfC, 2, 1);
                                        w.a(this.hfC, 15, 1);
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Exception e4) {
                                                z2 = z;
                                            }
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        z2 = z;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        inputStream3 = inputStream2;
                                        fileOutputStream = outputStream;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    fileOutputStream = null;
                                    inputStream3 = inputStream;
                                }
                            } else {
                                u a = b.a(cVar.url, null);
                                if (q.PE() && q.lx(cVar.url)) {
                                    x.d("MicroMsg.GetPicService", "webp referer:%s", new Object[]{q.hY(d.vAz)});
                                    a.oi(r3);
                                }
                                x.i("MicroMsg.GetPicService", "getCookie = %s, url = %s", new Object[]{cVar.hfH, cVar.url});
                                if (!bh.ov(cVar.hfH)) {
                                    a.setRequestProperty("Cookie", cVar.hfH);
                                }
                                a.setUseCaches(true);
                                a.setConnectTimeout(3000);
                                a.setReadTimeout(3000);
                                inputStream = a.getInputStream();
                                bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                                fileOutputStream = new FileOutputStream(cVar.filename + ".tmp");
                                while (true) {
                                    read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                new File(cVar.filename + ".tmp").renameTo(new File(cVar.filename));
                                contentType = a.aBw.getContentType();
                                x.d("MicroMsg.GetPicService", "contentType:%s", new Object[]{contentType});
                            }
                            if (q.PE() && q.lx(cVar.url) && !bh.ov(r1) && r1.equals("image/webp")) {
                                x.d("MicroMsg.GetPicService", "receive a webp picture");
                                cVar.hfG = true;
                                w.a(this.hfC, 13, 1);
                            } else {
                                cVar.hfG = false;
                            }
                            Message message = new Message();
                            message.obj = cVar;
                            message.arg1 = cVar.pos;
                            this.hfC.handler.sendMessage(message);
                            Wp = bh.Wp() - Wp;
                            x.d("MicroMsg.GetPicService", "download image used: %dms", new Object[]{Long.valueOf(Wp)});
                            w.a(this.hfC, 4, Wp);
                            if (cVar != null && cVar.hfG) {
                                w.a(this.hfC, 17, Wp);
                            }
                            try {
                                fileOutputStream.close();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                z2 = false;
                            } catch (Exception e5) {
                                z2 = false;
                            }
                        }
                    }
                }
                z2++;
            } catch (Exception e6) {
                e = e6;
                cVar2 = cVar;
                inputStream2 = null;
                outputStream = null;
                z = false;
                x.e("MicroMsg.GetPicService", "exception:%s", new Object[]{bh.i(e)});
                w.a(this.hfC, 2, 1);
                w.a(this.hfC, 15, 1);
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                z2 = z;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
        }
        return;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e7) {
                throw th;
            }
        }
        if (inputStream3 != null) {
            inputStream3.close();
        }
        throw th;
    }
}
