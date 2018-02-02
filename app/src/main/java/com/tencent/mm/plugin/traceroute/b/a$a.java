package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Set;

class a$a implements Runnable {
    private String ip;
    private Set<Integer> seY;
    final /* synthetic */ a seZ;

    public a$a(a aVar, String str, Set<Integer> set) {
        this.seZ = aVar;
        this.ip = str;
        this.seY = set;
    }

    public final void run() {
        Socket socket;
        Throwable e;
        this.seZ.a(this.ip, String.format("connect %s: ", new Object[]{this.ip}), Integer.valueOf(1));
        for (Integer num : this.seY) {
            a aVar = this.seZ;
            String str = this.ip;
            int intValue = num.intValue();
            try {
                socket = new Socket();
                try {
                    socket.setSoTimeout(5000);
                    long Wp = bh.Wp();
                    socket.connect(new InetSocketAddress(str, intValue));
                    long Wp2 = bh.Wp();
                    x.i("MicroMsg.MMTraceRoute", "connect success" + str + ":" + intValue);
                    aVar.a(str, String.format("port = %d, time = %dms ", new Object[]{Integer.valueOf(intValue), Long.valueOf(Wp2 - Wp)}), Integer.valueOf(1));
                    try {
                        socket.close();
                    } catch (Throwable e2) {
                        x.e("MicroMsg.MMTraceRoute", "close err: " + e2.getMessage());
                        x.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                    }
                } catch (UnknownHostException e3) {
                    e2 = e3;
                    try {
                        aVar.a(str, String.format("connect err; UnknownHostException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2.toString()}), Integer.valueOf(1));
                        x.e("MicroMsg.MMTraceRoute", "connect err: " + e2.getMessage());
                        x.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                        if (socket != null) {
                            try {
                                socket.close();
                            } catch (Throwable e22) {
                                x.e("MicroMsg.MMTraceRoute", "close err: " + e22.getMessage());
                                x.printErrStackTrace("MicroMsg.MMTraceRoute", e22, "", new Object[0]);
                            }
                        }
                    } catch (Throwable th) {
                        e22 = th;
                    }
                } catch (IOException e4) {
                    e22 = e4;
                    aVar.a(str, String.format("connect err; IOException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e22.toString()}), Integer.valueOf(1));
                    x.e("MicroMsg.MMTraceRoute", "connect err:" + e22.getMessage());
                    x.printErrStackTrace("MicroMsg.MMTraceRoute", e22, "", new Object[0]);
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (Throwable e222) {
                            x.e("MicroMsg.MMTraceRoute", "close err: " + e222.getMessage());
                            x.printErrStackTrace("MicroMsg.MMTraceRoute", e222, "", new Object[0]);
                        }
                    }
                } catch (Exception e5) {
                    e222 = e5;
                    aVar.a(str, String.format("connect err; Exception: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e222.toString()}), Integer.valueOf(1));
                    x.e("MicroMsg.MMTraceRoute", "connect err:" + e222.toString());
                    x.printErrStackTrace("MicroMsg.MMTraceRoute", e222, "", new Object[0]);
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (Throwable e2222) {
                            x.e("MicroMsg.MMTraceRoute", "close err: " + e2222.getMessage());
                            x.printErrStackTrace("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                        }
                    }
                }
            } catch (UnknownHostException e6) {
                e2222 = e6;
                socket = null;
                aVar.a(str, String.format("connect err; UnknownHostException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2222.toString()}), Integer.valueOf(1));
                x.e("MicroMsg.MMTraceRoute", "connect err: " + e2222.getMessage());
                x.printErrStackTrace("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e7) {
                e2222 = e7;
                socket = null;
                aVar.a(str, String.format("connect err; IOException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2222.toString()}), Integer.valueOf(1));
                x.e("MicroMsg.MMTraceRoute", "connect err:" + e2222.getMessage());
                x.printErrStackTrace("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e8) {
                e2222 = e8;
                socket = null;
                aVar.a(str, String.format("connect err; Exception: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2222.toString()}), Integer.valueOf(1));
                x.e("MicroMsg.MMTraceRoute", "connect err:" + e2222.toString());
                x.printErrStackTrace("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                if (socket != null) {
                    socket.close();
                }
            } catch (Throwable th2) {
                e2222 = th2;
                socket = null;
            }
        }
        this.seZ.a(this.ip, "\n", Integer.valueOf(1));
        return;
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable e9) {
                x.e("MicroMsg.MMTraceRoute", "close err: " + e9.getMessage());
                x.printErrStackTrace("MicroMsg.MMTraceRoute", e9, "", new Object[0]);
            }
        }
        throw e2222;
        throw e2222;
    }
}
