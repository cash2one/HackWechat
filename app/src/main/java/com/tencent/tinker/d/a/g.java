package com.tencent.tinker.d.a;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.zip.ZipException;

public final class g implements Closeable {
    private RandomAccessFile AaB;
    public final LinkedHashMap<String, f> Amg;
    private File Amh;
    private final String filename;
    public String wLD;

    public g(File file) {
        this(file, (byte) 0);
    }

    public g(String str) {
        this(new File(str), (byte) 0);
    }

    private g(File file, byte b) {
        this.Amg = new LinkedHashMap();
        this.filename = file.getPath();
        this.Amh = null;
        this.AaB = new RandomAccessFile(this.filename, "r");
        cHn();
    }

    static void a(String str, long j, String str2, long j2, String str3, int i) {
        throw new ZipException("file name:" + str + ", file size" + j + ", entry name:" + str2 + ", entry localHeaderRelOffset:" + j2 + ", " + str3 + " signature not found; was " + Integer.toHexString(i));
    }

    public final void close() {
        RandomAccessFile randomAccessFile = this.AaB;
        if (randomAccessFile != null) {
            synchronized (randomAccessFile) {
                this.AaB = null;
                randomAccessFile.close();
            }
            if (this.Amh != null) {
                this.Amh.delete();
                this.Amh = null;
            }
        }
    }

    public final void cHm() {
        if (this.AaB == null) {
            throw new IllegalStateException("Zip file closed");
        }
    }

    public final f abP(String str) {
        cHm();
        if (str == null) {
            throw new NullPointerException("entryName == null");
        }
        f fVar = (f) this.Amg.get(str);
        if (fVar == null) {
            return (f) this.Amg.get(str + "/");
        }
        return fVar;
    }

    public final InputStream a(f fVar) {
        f abP = abP(fVar.name);
        if (abP == null) {
            return null;
        }
        InputStream aVar;
        RandomAccessFile randomAccessFile = this.AaB;
        synchronized (randomAccessFile) {
            aVar = new a(randomAccessFile, abP.Ame);
            DataInputStream dataInputStream = new DataInputStream(aVar);
            int reverseBytes = Integer.reverseBytes(dataInputStream.readInt());
            if (((long) reverseBytes) != 67324752) {
                a(this.filename, randomAccessFile.length(), abP.name, abP.Ame, "Local File Header", reverseBytes);
            }
            dataInputStream.skipBytes(2);
            int reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            if ((reverseBytes2 & 1) != 0) {
                throw new ZipException("Invalid General Purpose Bit Flag: " + reverseBytes2);
            }
            dataInputStream.skipBytes(18);
            reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            int reverseBytes3 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            dataInputStream.close();
            aVar.skip((long) (reverseBytes2 + reverseBytes3));
            if (abP.Amb == 0) {
                a.a(aVar, a.a(aVar) + abP.size);
            } else {
                a.a(aVar, a.a(aVar) + abP.Ama);
            }
        }
        return aVar;
    }

    private void cHn() {
        long j = 0;
        long length = this.AaB.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + this.AaB.length());
        }
        this.AaB.seek(0);
        if (((long) Integer.reverseBytes(this.AaB.readInt())) != 67324752) {
            throw new ZipException("Not a zip archive");
        }
        long j2 = length - HardCoderJNI.ACTION_ALLOC_MEMORY;
        if (j2 < 0) {
            j2 = length;
        } else {
            j = j2;
            j2 = length;
        }
        do {
            this.AaB.seek(j2);
            if (((long) Integer.reverseBytes(this.AaB.readInt())) != 101010256) {
                j2--;
            } else {
                byte[] bArr = new byte[18];
                this.AaB.readFully(bArr);
                b a = c.a(bArr, 18, ByteOrder.LITTLE_ENDIAN);
                int readShort = a.readShort() & 65535;
                int readShort2 = a.readShort() & 65535;
                int readShort3 = a.readShort() & 65535;
                int readShort4 = a.readShort() & 65535;
                a.cHl();
                long readInt = ((long) a.readInt()) & 4294967295L;
                int readShort5 = a.readShort() & 65535;
                if (readShort3 == readShort4 && readShort == 0 && readShort2 == 0) {
                    if (readShort5 > 0) {
                        bArr = new byte[readShort5];
                        this.AaB.readFully(bArr);
                        this.wLD = new String(bArr, 0, bArr.length, d.UTF_8);
                    }
                    InputStream bufferedInputStream = new BufferedInputStream(new a(this.AaB, readInt), Downloads.RECV_BUFFER_SIZE);
                    byte[] bArr2 = new byte[46];
                    for (readShort5 = 0; readShort5 < readShort3; readShort5++) {
                        f fVar = new f(bArr2, bufferedInputStream, d.UTF_8);
                        if (fVar.Ame >= readInt) {
                            throw new ZipException("Local file header offset is after central directory");
                        }
                        String str = fVar.name;
                        if (this.Amg.put(str, fVar) != null) {
                            throw new ZipException("Duplicate entry name: " + str);
                        }
                    }
                    return;
                }
                throw new ZipException("Spanned archives not supported");
            }
        } while (j2 >= j);
        throw new ZipException("End Of Central Directory signature not found");
    }
}
