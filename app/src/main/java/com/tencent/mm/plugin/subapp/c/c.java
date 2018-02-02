package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class c {
    private RandomAccessFile aBB = null;
    private String fileName = "";

    public static class a {
        public byte[] buf = null;
        public int flp = 0;
        public int hWh = 0;
        public int ret = 0;
    }

    public c(String str) {
        this.fileName = str;
    }

    public static int nv(String str) {
        Assert.assertTrue(str.length() >= 0);
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        int length = (int) file.length();
        if (length > 0) {
            return length;
        }
        return 0;
    }

    public final void Uu() {
        if (this.aBB != null) {
            try {
                this.aBB.close();
                this.aBB = null;
                x.d("MicroMsg.SpxFileOperator", "Close :" + this.fileName);
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
        x.d("MicroMsg.SpxFileOperator", "Open file:" + this.aBB + " mode:" + str);
        try {
            this.aBB = new RandomAccessFile(this.fileName, str);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.SpxFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + e.getMessage() + "]");
            this.aBB = null;
            return false;
        }
    }

    public final a yf(int i) {
        a aVar = new a();
        if (i < 0) {
            aVar.ret = -3;
        } else if (this.aBB != null || nM("r")) {
            aVar.buf = new byte[6000];
            try {
                long length = this.aBB.length();
                this.aBB.seek((long) i);
                int read = this.aBB.read(aVar.buf, 0, 6000);
                x.d("MicroMsg.SpxFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + i + " readRet:" + read + " fileNow:" + this.aBB.getFilePointer() + " fileSize:" + length);
                if (read < 0) {
                    read = 0;
                }
                aVar.flp = read;
                aVar.hWh = read + i;
                aVar.ret = 0;
            } catch (Exception e) {
                x.e("MicroMsg.SpxFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + i + "  failed:[" + e.getMessage() + "] ");
                Uu();
                aVar.ret = -1;
            }
        } else {
            aVar.ret = -2;
        }
        return aVar;
    }
}
