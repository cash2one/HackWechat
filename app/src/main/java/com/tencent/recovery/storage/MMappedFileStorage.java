package com.tencent.recovery.storage;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.recovery.log.RecoveryLog;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;

public class MMappedFileStorage {
    private int currentIndex;
    private int zRK;
    private File zRL;
    private File zRM;
    private MappedByteBuffer zRN;
    private RandomAccessFile zRO;

    public final synchronized void f(byte[] bArr, boolean z) {
        try {
            if (this.zRO == null) {
                if (!this.zRM.exists()) {
                    this.zRM.createNewFile();
                }
                this.zRO = new RandomAccessFile(this.zRM, "rw");
            }
            if (this.zRN == null) {
                this.zRN = this.zRO.getChannel().map(MapMode.READ_WRITE, 0, (long) this.zRK);
            }
            if (!(this.zRM == null || this.zRN == null)) {
                if (this.currentIndex + bArr.length > this.zRK || z) {
                    this.zRN.force();
                    try {
                        this.zRO.close();
                    } catch (IOException e) {
                    }
                    h(this.zRM, this.zRL);
                    this.currentIndex = 4;
                    this.zRM.delete();
                    this.zRM.createNewFile();
                    this.zRO = new RandomAccessFile(this.zRM, "rw");
                    this.zRN = this.zRO.getChannel().map(MapMode.READ_WRITE, 0, (long) this.zRK);
                    this.zRN.putInt(this.currentIndex - 4);
                }
                if (bArr.length >= 0) {
                    this.zRN.position(this.currentIndex);
                    this.zRN.put(bArr);
                    this.zRN.position(0);
                    this.currentIndex += bArr.length;
                    this.zRN.putInt(this.currentIndex - 4);
                }
            }
        } catch (Throwable e2) {
            RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e2, "appendToBuffer", new Object[0]);
        }
    }

    private static void h(File file, File file2) {
        FileOutputStream fileOutputStream;
        Throwable e;
        DataInputStream dataInputStream = null;
        try {
            int readInt;
            DataInputStream dataInputStream2 = new DataInputStream(new FileInputStream(file));
            try {
                readInt = dataInputStream2.readInt();
                fileOutputStream = new FileOutputStream(file2, true);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
                dataInputStream = dataInputStream2;
                try {
                    RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e, "copyAppendTargetFile", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (fileOutputStream == null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    e = th;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = null;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                int i = 0;
                while (true) {
                    int i2 = i + WXMediaMessage.DESCRIPTION_LENGTH_LIMIT > readInt ? readInt - i : WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                    if (i2 > 0) {
                        i2 = dataInputStream2.read(bArr, 0, i2);
                        if (i2 > 0) {
                            fileOutputStream.write(bArr, 0, i2);
                            i = i2 + i;
                        }
                    }
                    try {
                        break;
                    } catch (IOException e7) {
                    }
                }
                dataInputStream2.close();
                try {
                    fileOutputStream.close();
                } catch (IOException e8) {
                }
            } catch (Exception e9) {
                e = e9;
                dataInputStream = dataInputStream2;
                RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e, "copyAppendTargetFile", new Object[0]);
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileOutputStream == null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th3) {
                e = th3;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
        } catch (Exception e10) {
            e = e10;
            fileOutputStream = null;
            RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e, "copyAppendTargetFile", new Object[0]);
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (fileOutputStream == null) {
                fileOutputStream.close();
            }
        } catch (Throwable th4) {
            e = th4;
            fileOutputStream = null;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e;
        }
    }
}
