package com.tencent.mm.z;

import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public final class by {
    public static boolean hhX = false;
    private static by hia = null;
    private ArrayList<String> hhY = new ArrayList();
    private String hhZ = "";

    public by(String str, boolean z) {
        Throwable e;
        RandomAccessFile randomAccessFile;
        try {
            String format;
            this.hhZ = str + "version_history.cfg";
            randomAccessFile = new RandomAccessFile(this.hhZ, "rw");
            long length = randomAccessFile.length();
            x.i("MicroMsg.VersionHistory", "init fileLen:%d isNewAcc:%b curVer:0x%x path:%s", Long.valueOf(length), Boolean.valueOf(z), Integer.valueOf(d.vAz), this.hhZ);
            if (length <= 0 || length > 10240) {
                randomAccessFile.seek(0);
                if (!z) {
                    format = String.format("%x", new Object[]{Integer.valueOf(536870913)});
                    randomAccessFile.write((format + "\n").getBytes());
                    this.hhY.add(format);
                }
            } else {
                while (randomAccessFile.getFilePointer() < length) {
                    format = bh.az(randomAccessFile.readLine(), "");
                    if (format.length() != 8) {
                        x.e("MicroMsg.VersionHistory", "Read ver history failed , line len:%d path:%s", Integer.valueOf(format.length()), this.hhZ);
                    } else {
                        try {
                            if (format.startsWith("2")) {
                                this.hhY.add(format);
                            } else {
                                x.e("MicroMsg.VersionHistory", "Read ver history failed , line:%s %s", format, this.hhZ);
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                }
            }
            format = String.format("%x", new Object[]{Integer.valueOf(d.vAz)});
            if (this.hhY.size() == 0 || !format.equals(this.hhY.get(this.hhY.size() - 1))) {
                hhX = true;
                this.hhY.add(format);
                randomAccessFile.seek(length);
                randomAccessFile.write((format + "\n").getBytes());
            }
            format = "";
            int i = 0;
            while (i < this.hhY.size()) {
                String str2 = format + ((String) this.hhY.get(i)) + ";";
                i++;
                format = str2;
            }
            x.i("MicroMsg.VersionHistory", "Read succ isupdate:%b ver:%s file:%s", Boolean.valueOf(hhX), format, this.hhZ);
            try {
                randomAccessFile.close();
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.VersionHistory", e3, "Close Version History file failed.", "");
            }
        } catch (Exception e4) {
            e3 = e4;
            randomAccessFile = null;
            try {
                x.printErrStackTrace("MicroMsg.VersionHistory", e3, "Open Version History file failed.", "");
                try {
                    randomAccessFile.close();
                } catch (Throwable e32) {
                    x.printErrStackTrace("MicroMsg.VersionHistory", e32, "Close Version History file failed.", "");
                }
                if (hia != null) {
                    return;
                }
                return;
            } catch (Throwable th) {
                e32 = th;
                try {
                    randomAccessFile.close();
                } catch (Throwable e5) {
                    x.printErrStackTrace("MicroMsg.VersionHistory", e5, "Close Version History file failed.", "");
                }
                throw e32;
            }
        } catch (Throwable th2) {
            e32 = th2;
            randomAccessFile = null;
            randomAccessFile.close();
            throw e32;
        }
        if (hia != null && hia != this && hia.hhY.size() < this.hhY.size()) {
            hia.hhY = this.hhY;
            k.q(this.hhZ, hia.hhZ, false);
        }
    }

    public static void ic(String str) {
        hia = new by(str, true);
    }

    public static String Ig() {
        if (hia == null) {
            return "";
        }
        by byVar = hia;
        String str = "";
        String str2 = str;
        for (int size = 4 >= byVar.hhY.size() ? 0 : byVar.hhY.size() - 4; size < byVar.hhY.size(); size++) {
            str2 = str2 + ((String) byVar.hhY.get(size)) + ";";
        }
        return str2;
    }
}
