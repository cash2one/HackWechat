package com.tencent.mm.app;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.mm.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.io.File;
import java.io.RandomAccessFile;

public final class c {
    private static final String feL = (w.gZK + "channel_history.cfg");

    public static void al(Context context) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        f.eH(context);
        try {
            a cg = a.cg(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir);
            if (!(cg == null || cg.fdP == null)) {
                x.i("MicroMsg.ChannelHistory", "apk external info not null");
                if (cg.fdP.fdS != 0) {
                    f.fdS = cg.fdP.fdS;
                    x.i("MicroMsg.ChannelHistory", "read channelId from apk external");
                }
            }
        } catch (NameNotFoundException e2) {
            x.e("MicroMsg.ChannelHistory", "NameNotFoundException");
        } catch (Exception e3) {
            x.e("MicroMsg.ChannelHistory", "Exception in initChannel, %s", new Object[]{e3.getMessage()});
        }
        x.i("MicroMsg.ChannelHistory", "now channel id = %d, proce name = %s", new Object[]{Integer.valueOf(f.fdS), ac.Br()});
        if (!tL()) {
            try {
                randomAccessFile = new RandomAccessFile(feL, "rw");
                try {
                    randomAccessFile.write(String.format("%d\n", new Object[]{Integer.valueOf(f.fdS)}).getBytes());
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e4) {
                        x.printErrStackTrace("MicroMsg.ChannelHistory", e4, "Close ChannelHistory History file failed.", new Object[]{""});
                    }
                } catch (Exception e5) {
                    e4 = e5;
                    try {
                        x.printErrStackTrace("MicroMsg.ChannelHistory", e4, "Open ChannelHistory History file failed.", new Object[]{""});
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e42) {
                                x.printErrStackTrace("MicroMsg.ChannelHistory", e42, "Close ChannelHistory History file failed.", new Object[]{""});
                            }
                        }
                    } catch (Throwable th) {
                        e42 = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e6) {
                                x.printErrStackTrace("MicroMsg.ChannelHistory", e6, "Close ChannelHistory History file failed.", new Object[]{""});
                            }
                        }
                        throw e42;
                    }
                }
            } catch (Exception e7) {
                e42 = e7;
                randomAccessFile = null;
                x.printErrStackTrace("MicroMsg.ChannelHistory", e42, "Open ChannelHistory History file failed.", new Object[]{""});
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (Throwable th2) {
                e42 = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e42;
            }
        }
    }

    public static void tK() {
        RandomAccessFile randomAccessFile;
        Throwable e;
        if (tL()) {
            try {
                randomAccessFile = new RandomAccessFile(feL, "rw");
                try {
                    long length = randomAccessFile.length();
                    x.i("MicroMsg.ChannelHistory", "correctChannleIdBySource fileLen:%d  curChannelId:%d", new Object[]{Long.valueOf(length), Integer.valueOf(f.fdS)});
                    if (length <= 0) {
                        x.w("MicroMsg.ChannelHistory", "channel history file fileLen <= 0");
                        try {
                            randomAccessFile.close();
                            return;
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.ChannelHistory", e2, "Close ChannelHistory History file failed.", new Object[]{""});
                            return;
                        }
                    }
                    String readLine = randomAccessFile.readLine();
                    int i = f.fdS;
                    int i2 = f.fdS;
                    f.xex = f.fdS;
                    String str = "";
                    if (!bh.ov(readLine)) {
                        str = str + readLine + ",";
                        i2 = bh.getInt(readLine, 0);
                        if (i2 != f.fdS) {
                            f.xex = i2;
                            x.i("MicroMsg.ChannelHistory", "real correct final channelid: " + f.fdS);
                        }
                    }
                    if (ac.xft) {
                        while (true) {
                            readLine = randomAccessFile.readLine();
                            if (bh.ov(readLine)) {
                                break;
                            }
                            str = str + readLine + ",";
                            i2 = bh.getInt(readLine, 0);
                        }
                        x.i("MicroMsg.ChannelHistory", "channel list: %s", new Object[]{str});
                        if (i2 != i) {
                            randomAccessFile.seek(length);
                            randomAccessFile.write(String.format("%d\n", new Object[]{Integer.valueOf(i)}).getBytes());
                            x.i("MicroMsg.ChannelHistory", "channelid change from %d to %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
                        }
                    }
                    try {
                        randomAccessFile.close();
                        return;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.ChannelHistory", e22, "Close ChannelHistory History file failed.", new Object[]{""});
                        return;
                    }
                } catch (Exception e3) {
                    e22 = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.ChannelHistory", e22, "Open ChannelHistory History file failed.", new Object[]{""});
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                                return;
                            } catch (Throwable e222) {
                                x.printErrStackTrace("MicroMsg.ChannelHistory", e222, "Close ChannelHistory History file failed.", new Object[]{""});
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        e222 = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e4) {
                                x.printErrStackTrace("MicroMsg.ChannelHistory", e4, "Close ChannelHistory History file failed.", new Object[]{""});
                            }
                        }
                        throw e222;
                    }
                }
            } catch (Exception e5) {
                e222 = e5;
                randomAccessFile = null;
                x.printErrStackTrace("MicroMsg.ChannelHistory", e222, "Open ChannelHistory History file failed.", new Object[]{""});
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                    return;
                }
                return;
            } catch (Throwable th2) {
                e222 = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e222;
            }
        }
        x.w("MicroMsg.ChannelHistory", "channel history file does not exit!");
    }

    private static boolean tL() {
        return new File(feL).exists();
    }
}
