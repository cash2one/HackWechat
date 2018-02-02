package com.tencent.mm.ca;

import android.os.Debug;
import android.os.Environment;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.a.p;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public final class d implements EventListener {
    static af hae = new 2();
    public static a xCX = null;
    public static d xDc;
    private static int xDd = 5242880;
    public static final String xDf = (Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/tracedog/");
    private volatile boolean hOj;
    private volatile boolean xDe;
    private LinkedBlockingQueue<a> xDg;
    ExecutorService xDh;
    public WeakReference<b> xDi;

    public static d clq() {
        if (xDc == null) {
            xDc = new d();
        }
        return xDc;
    }

    private void a(a aVar) {
        if (!this.xDe) {
            if (c.ze()) {
                clr();
                try {
                    File file = new File(xDf);
                    if (aVar.fJn != 6 && file.exists()) {
                        x.i("MicroMsg.TraceDebugManager", "TRACE delete all file ");
                        K(file);
                    }
                    file.mkdirs();
                    Debug.startMethodTracing(aVar.savePath, aVar.xDl <= 0 ? xDd : (aVar.xDl * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    this.xDe = true;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                    throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
                } catch (Throwable e2) {
                    this.xDe = false;
                    x.printErrStackTrace("MicroMsg.TraceDebugManager", e2, "TRACE startMethodTracing ERROR", new Object[0]);
                }
                if (aVar.fJn == 6) {
                    x.i("MicroMsg.TraceDebugManager", "TRACE startTrace uploadType is CLIENT ");
                    return;
                } else if (this.xDe) {
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = aVar;
                    if (bh.ov(aVar.className) || aVar.fJn == 5) {
                        hae.sendMessageDelayed(obtain, 15000);
                        return;
                    } else {
                        hae.sendMessageDelayed(obtain, 10000);
                        return;
                    }
                } else {
                    return;
                }
            }
            x.i("MicroMsg.TraceDebugManager", "TRACE sdcard is invalid");
        }
    }

    private static void clr() {
        hae.removeMessages(0);
        hae.removeMessages(2);
        hae.removeMessages(1);
    }

    private static void K(File file) {
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                return;
            }
            for (File K : listFiles) {
                K(K);
            }
            file.delete();
        }
    }

    public final boolean b(a aVar) {
        clr();
        if (!this.xDe || this.hOj) {
            x.i("MicroMsg.TraceDebugManager", "TRACE stopTrace hasStartTrace : %b ,isUploading :%b  ", new Object[]{Boolean.valueOf(this.xDe), Boolean.valueOf(this.hOj)});
            return false;
        } else if (c.ze()) {
            this.xDh.execute(new 1(this, aVar));
            return true;
        } else {
            x.i("MicroMsg.TraceDebugManager", "TRACE stopTrace sdcard invalid");
            return false;
        }
    }

    private static String d(File file, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (file.isDirectory()) {
            x.i("MicroMsg.TraceDebugManager", "TRACE currentPath is dir");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                x.e("MicroMsg.TraceDebugManager", " get file list failed");
                return null;
            }
            for (Object add : listFiles) {
                arrayList.add(add);
            }
        } else {
            arrayList.add(file);
        }
        File file2 = new File(xDf + bh.Wp() + ".zip");
        try {
            p.a(arrayList, file2);
            for (int i = 0; i < arrayList.size(); i++) {
                ((File) arrayList.get(i)).delete();
            }
            if (file2.length() <= 3145728) {
                return file2.getAbsolutePath();
            }
            x.e("MicroMsg.TraceDebugManager", "trace file is too large:%d ", new Object[]{Long.valueOf(file2.length())});
            return null;
        } catch (Throwable e) {
            x.e("MicroMsg.TraceDebugManager", "exception:%s", new Object[]{bh.i(e)});
            x.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", new Object[]{e.getMessage()});
            return null;
        }
    }

    private d() {
    }

    public final void de(String str, int i) {
        if (this.xDg != null && this.xDg.size() > 0) {
            x.i("MicroMsg.TraceDebugManager", "TRACE gatherData : isUploading : %b  hasStart :%b currentClass : %s currentCode %d ", new Object[]{Boolean.valueOf(this.hOj), Boolean.valueOf(this.xDe), str, Integer.valueOf(i)});
            if (!this.hOj && !this.xDe) {
                Iterator it = this.xDg.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.className == null) {
                        a(null);
                        this.xDg.remove(aVar);
                        return;
                    } else if (aVar.className.equals(str) && aVar.fJn == i) {
                        a(aVar);
                        this.xDg.remove(aVar);
                        return;
                    }
                }
            }
        }
    }

    final void Yl(String str) {
        if (str != null) {
            this.hOj = true;
            if (bh.ov(str)) {
                x.e("MicroMsg.TraceDebugManager", "TRACE error uploadPath %s ", new Object[]{str});
            } else if (c.ze()) {
                File file = new File(str);
                if (file.exists()) {
                    if (file.isDirectory()) {
                        str = d(file, true);
                    }
                    if (str != null && new File(str).length() >= HardCoderJNI.ACTION_NET_RX) {
                        if (xCX == null) {
                            x.e("MicroMsg.TraceDebugManager", "TRACE upload : no file upload impl set!");
                        } else {
                            x.i("MicroMsg.TraceDebugManager", "TRACE upload : %b", new Object[]{Boolean.valueOf(xCX.Hr(str))});
                            if (xCX.Hr(str)) {
                                e.g(new File(xDf));
                            }
                        }
                    }
                } else {
                    x.e("MicroMsg.TraceDebugManager", "TRACE upload file is not exist");
                }
            } else {
                x.e("MicroMsg.TraceDebugManager", "TRACE sdcard invalid.");
            }
            this.hOj = false;
        }
    }

    public final void c(a aVar) {
        if (aVar.fJn > 0) {
            if (this.xDh == null) {
                this.xDh = Executors.newSingleThreadExecutor();
            }
            if (this.hOj || this.xDe) {
                x.i("MicroMsg.TraceDebugManager", "TRACE isUloading or hasStartTrace %b %b", new Object[]{Boolean.valueOf(this.hOj), Boolean.valueOf(this.xDe)});
                return;
            }
            hae.removeMessages(0);
            if (aVar.xDm == 4 || aVar.xDm == 5) {
                this.xDh.execute(new 3(this, aVar.xDm));
            } else if (aVar.fJn == 6 || aVar.fJn == 5) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.obj = aVar;
                if (aVar.fJn == 5) {
                    hae.sendMessage(obtain);
                } else {
                    hae.sendMessageDelayed(obtain, 500);
                }
            } else {
                if (this.xDg == null) {
                    this.xDg = new LinkedBlockingQueue();
                }
                this.xDg.clear();
                this.xDg.add(aVar);
            }
            x.i("MicroMsg.TraceDebugManager", "TRACE PUSH : class : %s  code :%s type :%s", new Object[]{aVar.className, Integer.valueOf(aVar.fJn), Integer.valueOf(aVar.xDm)});
        }
    }
}
