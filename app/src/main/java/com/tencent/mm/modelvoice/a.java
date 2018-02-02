package com.tencent.mm.modelvoice;

import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class a implements b {
    private RandomAccessFile aBB = null;
    private String fileName = "";

    public a(String str) {
        this.fileName = str;
    }

    public final void Uu() {
        if (this.aBB != null) {
            try {
                this.aBB.close();
                this.aBB = null;
                x.d("MicroMsg.AmrFileOperator", "Close :" + this.fileName);
            } catch (IOException e) {
            }
        }
    }

    private boolean nM(String str) {
        boolean z;
        Assert.assertTrue(this.fileName.length() >= 0);
        if (this.aBB == null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (str.equals("r") || str.equals("rw")) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        x.d("MicroMsg.AmrFileOperator", "Open file:" + this.aBB + " mode:" + str);
        try {
            this.aBB = new RandomAccessFile(this.fileName, str);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.AmrFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + e.getMessage() + "]");
            this.aBB = null;
            return false;
        }
    }

    public final g bp(int i, int i2) {
        g gVar = new g();
        if (i < 0 || i2 <= 0) {
            gVar.ret = -3;
        } else if (this.aBB != null || nM("r")) {
            int i3 = i + 6;
            gVar.buf = new byte[i2];
            try {
                long length = this.aBB.length();
                this.aBB.seek((long) i3);
                int read = this.aBB.read(gVar.buf, 0, i2);
                x.d("MicroMsg.AmrFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + i3 + " readRet:" + read + " fileNow:" + this.aBB.getFilePointer() + " fileSize:" + length);
                if (read < 0) {
                    read = 0;
                }
                gVar.flp = read;
                gVar.hWh = (read + i3) - 6;
                gVar.ret = 0;
            } catch (Exception e) {
                x.e("MicroMsg.AmrFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + i3 + "  failed:[" + e.getMessage() + "] ");
                Uu();
                gVar.ret = -1;
            }
        } else {
            gVar.ret = -2;
        }
        return gVar;
    }

    public final int write(byte[] bArr, int i, int i2) {
        boolean z = true;
        boolean z2 = bArr.length > 0 && i > 0;
        Assert.assertTrue(z2);
        if (this.aBB == null && !nM("rw")) {
            return -1;
        }
        if (i2 == 0) {
            try {
                this.aBB.write("#!AMR\n".getBytes(), 0, 6);
            } catch (Exception e) {
                x.e("MicroMsg.AmrFileOperator", "ERR: WriteHeadToFile[" + this.fileName + "] failed:[" + e.getMessage() + "]");
                Uu();
                return -2;
            }
        }
        int i3 = i2 + 6;
        try {
            this.aBB.seek((long) i3);
            this.aBB.write(bArr, 0, i);
            i3 += i;
            if (((int) this.aBB.getFilePointer()) == i3) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assert.assertTrue(z2);
            int i4 = i3 - 6;
            if (i4 < 0) {
                z = false;
            }
            Assert.assertTrue(z);
            return i4;
        } catch (Exception e2) {
            x.e("MicroMsg.AmrFileOperator", "ERR: WriteFile[" + this.fileName + "] Offset:" + i3 + " failed:[" + e2.getMessage() + "]");
            Uu();
            return -3;
        }
    }

    public final int getFormat() {
        return 0;
    }
}
