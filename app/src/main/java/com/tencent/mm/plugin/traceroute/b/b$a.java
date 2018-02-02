package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class b$a implements Runnable {
    private List<Object> mOV;
    private String[] sfi;

    public b$a(String[] strArr, List<Object> list) {
        this.sfi = strArr;
        this.mOV = list;
    }

    public final void run() {
        Process start;
        long Wp;
        IOException iOException;
        BufferedReader bufferedReader;
        IOException iOException2;
        Process process;
        Throwable th;
        InterruptedException interruptedException;
        InterruptedException interruptedException2;
        Exception exception;
        Exception exception2;
        BufferedReader bufferedReader2 = null;
        StringBuilder stringBuilder = new StringBuilder();
        ProcessBuilder processBuilder = new ProcessBuilder(this.sfi);
        processBuilder.redirectErrorStream(true);
        long Wp2 = bh.Wp();
        long Wp3 = bh.Wp();
        try {
            start = processBuilder.start();
            try {
                bh.d(start.getOutputStream());
                Wp = bh.Wp();
            } catch (IOException e) {
                iOException = e;
                Wp = Wp3;
                bufferedReader = null;
                iOException2 = iOException;
                process = start;
                try {
                    x.e("MicroMsg.MMTraceRoute", "run cmd err, io exception: " + iOException2.getMessage());
                    b.a(process, bufferedReader);
                    this.mOV.add(stringBuilder.toString());
                    this.mOV.add(Long.valueOf(Wp - Wp2));
                    x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                } catch (Throwable th2) {
                    th = th2;
                    start = process;
                    bufferedReader2 = bufferedReader;
                    b.a(start, bufferedReader2);
                    throw th;
                }
            } catch (InterruptedException e2) {
                interruptedException = e2;
                Wp = Wp3;
                interruptedException2 = interruptedException;
                try {
                    x.e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + interruptedException2.getMessage());
                    b.a(start, bufferedReader2);
                    this.mOV.add(stringBuilder.toString());
                    this.mOV.add(Long.valueOf(Wp - Wp2));
                    x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                } catch (Throwable th3) {
                    th = th3;
                    b.a(start, bufferedReader2);
                    throw th;
                }
            } catch (Exception e3) {
                exception = e3;
                Wp = Wp3;
                exception2 = exception;
                x.e("MicroMsg.MMTraceRoute", "run cmd err: " + exception2.getMessage());
                b.a(start, bufferedReader2);
                this.mOV.add(stringBuilder.toString());
                this.mOV.add(Long.valueOf(Wp - Wp2));
                x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()), 8096);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuilder.append(readLine);
                    } catch (IOException e4) {
                        iOException2 = e4;
                        process = start;
                    } catch (InterruptedException e5) {
                        interruptedException2 = e5;
                        bufferedReader2 = bufferedReader;
                    } catch (Exception e6) {
                        exception2 = e6;
                        bufferedReader2 = bufferedReader;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader2 = bufferedReader;
                    }
                }
                start.waitFor();
                b.a(start, bufferedReader);
            } catch (IOException e7) {
                iOException2 = e7;
                bufferedReader = null;
                process = start;
                x.e("MicroMsg.MMTraceRoute", "run cmd err, io exception: " + iOException2.getMessage());
                b.a(process, bufferedReader);
                this.mOV.add(stringBuilder.toString());
                this.mOV.add(Long.valueOf(Wp - Wp2));
                x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
            } catch (InterruptedException e8) {
                interruptedException2 = e8;
                x.e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + interruptedException2.getMessage());
                b.a(start, bufferedReader2);
                this.mOV.add(stringBuilder.toString());
                this.mOV.add(Long.valueOf(Wp - Wp2));
                x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
            } catch (Exception e9) {
                exception2 = e9;
                x.e("MicroMsg.MMTraceRoute", "run cmd err: " + exception2.getMessage());
                b.a(start, bufferedReader2);
                this.mOV.add(stringBuilder.toString());
                this.mOV.add(Long.valueOf(Wp - Wp2));
                x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
            }
        } catch (IOException e10) {
            iOException = e10;
            Wp = Wp3;
            bufferedReader = null;
            iOException2 = iOException;
            x.e("MicroMsg.MMTraceRoute", "run cmd err, io exception: " + iOException2.getMessage());
            b.a(process, bufferedReader);
            this.mOV.add(stringBuilder.toString());
            this.mOV.add(Long.valueOf(Wp - Wp2));
            x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
        } catch (InterruptedException e22) {
            start = null;
            interruptedException = e22;
            Wp = Wp3;
            interruptedException2 = interruptedException;
            x.e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + interruptedException2.getMessage());
            b.a(start, bufferedReader2);
            this.mOV.add(stringBuilder.toString());
            this.mOV.add(Long.valueOf(Wp - Wp2));
            x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
        } catch (Exception e32) {
            start = null;
            exception = e32;
            Wp = Wp3;
            exception2 = exception;
            x.e("MicroMsg.MMTraceRoute", "run cmd err: " + exception2.getMessage());
            b.a(start, bufferedReader2);
            this.mOV.add(stringBuilder.toString());
            this.mOV.add(Long.valueOf(Wp - Wp2));
            x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
        } catch (Throwable th5) {
            th = th5;
            start = null;
            b.a(start, bufferedReader2);
            throw th;
        }
        this.mOV.add(stringBuilder.toString());
        this.mOV.add(Long.valueOf(Wp - Wp2));
        x.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
    }
}
