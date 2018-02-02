package com.tencent.mm.plugin.music.model.b;

import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class f {
    public String fileName;
    private String mUrl;
    public RandomAccessFile randomAccessFile = null;

    public f(String str) {
        this.mUrl = str;
        this.fileName = g.FL(this.mUrl);
        x.i("MicroMsg.PieceFileCache", "PieceFileCache mUrl:%s, fileName:%s,", new Object[]{this.mUrl, this.fileName});
    }

    public final synchronized void close() {
        Logger.i("MicroMsg.PieceFileCache", "close");
        if (this.randomAccessFile != null) {
            try {
                this.randomAccessFile.close();
            } catch (IOException e) {
                Logger.e("MicroMsg.PieceFileCache", "close RandomAccessFile error ", new Object[]{e.getMessage()});
            }
        }
    }

    public final synchronized int b(byte[] bArr, long j, int i) {
        int i2 = -1;
        synchronized (this) {
            if (i == 0) {
                Logger.e("MicroMsg.PieceFileCache", "read error, length == 0");
            } else if (this.randomAccessFile == null) {
                Logger.e("MicroMsg.PieceFileCache", "read error, randomAccessFile is null");
            } else {
                try {
                    this.randomAccessFile.seek(j);
                    i2 = this.randomAccessFile.read(bArr, 0, i);
                } catch (IOException e) {
                    Logger.e("MicroMsg.PieceFileCache", String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(getLength()), Integer.valueOf(bArr.length)}));
                }
            }
        }
        return i2;
    }

    public final synchronized boolean c(byte[] bArr, long j, int i) {
        boolean z = false;
        synchronized (this) {
            if (i == 0) {
                Logger.e("MicroMsg.PieceFileCache", "write error, length == 0");
            } else if (this.randomAccessFile == null) {
                Logger.e("MicroMsg.PieceFileCache", "write error, randomAccessFile is null");
            } else {
                try {
                    this.randomAccessFile.seek(j);
                    this.randomAccessFile.write(bArr, 0, i);
                    z = true;
                } catch (IOException e) {
                    Logger.e("MicroMsg.PieceFileCache", String.format("Error writing %d bytes to from buffer with size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(bArr.length)}));
                }
            }
        }
        return z;
    }

    public final synchronized int getLength() {
        int i = -1;
        synchronized (this) {
            if (this.randomAccessFile == null) {
                Logger.e("MicroMsg.PieceFileCache", "getLength error, randomAccessFile is null");
            } else {
                try {
                    i = (int) this.randomAccessFile.length();
                } catch (IOException e) {
                    Logger.e("MicroMsg.PieceFileCache", "Error get length of file , err %s", new Object[]{e.getMessage()});
                }
            }
        }
        return i;
    }

    public final synchronized void setLength(long j) {
        if (this.randomAccessFile == null) {
            Logger.e("MicroMsg.PieceFileCache", "setLength error, randomAccessFile is null");
        } else if (j <= 0) {
            Logger.e("MicroMsg.PieceFileCache", "setLength error, length is " + j);
        } else {
            Logger.e("MicroMsg.PieceFileCache", "set file length %s ", new Object[]{String.valueOf(j)});
            try {
                this.randomAccessFile.setLength(j);
            } catch (IOException e) {
                Logger.e("MicroMsg.PieceFileCache", "Error set length of file, err %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final synchronized long bel() {
        long length;
        File file = new File(this.fileName);
        if (file.exists()) {
            length = file.length();
        } else {
            length = -1;
        }
        return length;
    }

    public static void deleteFile(String str) {
        Logger.i("MicroMsg.PieceFileCache", "deleteFile, fileName:" + str);
        File file = new File(str);
        if (file.exists()) {
            Logger.i("MicroMsg.PieceFileCache", "delete the piece File");
            file.delete();
            return;
        }
        Logger.e("MicroMsg.PieceFileCache", "file not exist, delete piece File fail");
    }
}
