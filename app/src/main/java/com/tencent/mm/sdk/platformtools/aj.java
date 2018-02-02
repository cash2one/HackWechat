package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.mm.cd.i;
import com.tencent.recovery.crash.DefaultExceptionHandler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class aj implements UncaughtExceptionHandler {
    private static aj xfH = null;
    private d xfI;
    private com.tencent.mm.sdk.a.a xfJ;
    public a xfK;
    public Map<String, b> xfL;
    private UncaughtExceptionHandler xfM;
    private boolean xfN;
    private List<c> xfO;

    public interface a {
        void tR();
    }

    public interface b {
        String IO();
    }

    public interface c {
        void a(String str, Throwable th);
    }

    public interface d {
        void a(aj ajVar, String str, Throwable th);
    }

    public static synchronized void a(d dVar) {
        synchronized (aj.class) {
            if (xfH == null) {
                xfH = new aj();
            }
            xfH.xfI = dVar;
        }
    }

    public static synchronized void a(com.tencent.mm.sdk.a.a aVar) {
        synchronized (aj.class) {
            if (xfH == null) {
                xfH = new aj();
            }
            xfH.xfJ = aVar;
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (aj.class) {
            if (xfH == null) {
                xfH = new aj();
            }
            xfH.xfK = aVar;
        }
    }

    public static synchronized void a(String str, b bVar) {
        synchronized (aj.class) {
            if (xfH == null) {
                xfH = new aj();
            }
            xfH.xfL.put(str, bVar);
        }
    }

    public static synchronized void r(String str, final String str2, boolean z) {
        synchronized (aj.class) {
            a(str, new b() {
                public final String IO() {
                    return "subinfo=" + str2;
                }
            });
            Assert.assertTrue(str, z);
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (aj.class) {
            if (cVar != null) {
                if (xfH == null) {
                    xfH = new aj();
                }
                xfH.xfO.add(cVar);
            }
        }
    }

    private aj() {
        this.xfI = null;
        this.xfJ = null;
        this.xfK = null;
        this.xfL = new HashMap();
        this.xfM = null;
        this.xfN = false;
        this.xfO = new LinkedList();
        this.xfM = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(this));
    }

    private static String Vg(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            return null;
        }
        char c;
        int i = 0;
        while (i < toCharArray.length) {
            if (toCharArray[i] > '') {
                toCharArray[i] = '\u0000';
                c = '\u0001';
                break;
            }
            i++;
        }
        c = '\u0000';
        if (c != '\u0000') {
            return new String(toCharArray, 0, i);
        }
        return str;
    }

    public static String j(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (th.getCause() != null) {
            try {
                th = th.getCause();
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            }
        }
        th.printStackTrace(printStream);
        String Vg = Vg(byteArrayOutputStream.toString());
        return Vg;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (!this.xfN) {
            this.xfN = true;
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(byteArrayOutputStream);
                Throwable th2 = th;
                while (th2.getCause() != null) {
                    th2 = th2.getCause();
                }
                th2.printStackTrace(printStream);
                final String Vg = Vg(byteArrayOutputStream.toString());
                if (!(this.xfJ == null || Vg == null)) {
                    HandlerThread handlerThread = new HandlerThread("close-db-while-crash");
                    handlerThread.start();
                    final i iVar = new i();
                    new Handler(handlerThread.getLooper()).post(new Runnable(this) {
                        final /* synthetic */ aj xfS;

                        public final void run() {
                            this.xfS.xfJ.fI(Vg);
                            i iVar = iVar;
                            synchronized (iVar.gOg) {
                                if (iVar.gOg[0] == (byte) 0) {
                                    iVar.gOg[0] = (byte) 1;
                                    iVar.gOg.notifyAll();
                                    x.i("MicroMsg.WxTimeoutLock", "notify done %s", iVar);
                                }
                            }
                        }
                    });
                    synchronized (iVar.gOg) {
                        if (iVar.gOg[0] != (byte) 0) {
                            x.i("MicroMsg.WxTimeoutLock", "no need lock %s", iVar);
                        } else {
                            try {
                                iVar.gOg.wait(3000);
                            } catch (Throwable th22) {
                                x.printErrStackTrace("MicroMsg.WxTimeoutLock", th22, "", new Object[0]);
                            }
                        }
                    }
                }
                if (!(this.xfI == null || Vg == null)) {
                    this.xfI.a(this, Vg, th);
                    this.xfK.tR();
                }
                for (c cVar : this.xfO) {
                    if (cVar != null) {
                        try {
                            cVar.a(Vg, th);
                        } catch (Exception e) {
                        }
                    }
                }
                byteArrayOutputStream.close();
            } catch (Exception e2) {
            }
            x.appenderClose();
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }
}
