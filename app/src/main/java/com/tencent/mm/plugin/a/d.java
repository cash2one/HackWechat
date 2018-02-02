package com.tencent.mm.plugin.a;

import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Random;

public final class d {
    private static final int ieG = Q(new byte[]{(byte) 102, (byte) 114, (byte) 101, (byte) 101});
    private static final int ieH = Q(new byte[]{(byte) 106, (byte) 117, (byte) 110, (byte) 107});
    private static final int ieI = Q(new byte[]{(byte) 109, (byte) 100, (byte) 97, (byte) 116});
    private static final int ieJ = Q(new byte[]{(byte) 109, (byte) 111, (byte) 111, (byte) 118});
    private static final int ieK = Q(new byte[]{(byte) 112, (byte) 110, (byte) 111, (byte) 116});
    private static final int ieL = Q(new byte[]{(byte) 115, (byte) 107, (byte) 105, (byte) 112});
    private static final int ieM = Q(new byte[]{(byte) 119, (byte) 105, (byte) 100, (byte) 101});
    private static final int ieN = Q(new byte[]{(byte) 80, (byte) 73, (byte) 67, (byte) 84});
    private static final int ieO = Q(new byte[]{(byte) 102, (byte) 116, (byte) 121, (byte) 112});
    private static final int ieP = Q(new byte[]{(byte) 117, (byte) 117, (byte) 105, (byte) 100});
    private static final int ieQ = Q(new byte[]{(byte) 99, (byte) 109, (byte) 111, (byte) 118});
    private static final int ieR = Q(new byte[]{(byte) 115, (byte) 116, (byte) 99, (byte) 111});
    private static final int ieS = Q(new byte[]{(byte) 99, (byte) 111, (byte) 54, (byte) 52});

    private static boolean aB(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Exception e;
        FileInputStream fileInputStream3;
        Throwable th;
        FileInputStream fileInputStream4 = null;
        File file = new File(str);
        File file2 = new File(str2);
        if (file.length() != file2.length()) {
            x.w("MicroMsg.FastStart", "check size not right");
            return false;
        }
        long ox = new b().ox(str);
        f fVar = new f();
        fVar.r(str, ox);
        int i = fVar.ifa;
        long ox2 = new b().ox(str2);
        f fVar2 = new f();
        fVar2.r(str2, ox2);
        int i2 = fVar2.ifa;
        if (i2 != i) {
            x.w("MicroMsg.FastStart", "check duration not right");
            return false;
        }
        x.d("MicroMsg.FastStart", "old duration:" + i + " new duration: " + i2);
        i = new Random().nextInt(i2 - 1) + 1;
        if (i + 1 <= i2) {
            i2 = i + 1;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        fVar.a(i, i2, pInt, pInt2);
        PInt pInt3 = new PInt();
        PInt pInt4 = new PInt();
        fVar2.a(i, i2, pInt3, pInt4);
        if (pInt4.value != pInt2.value) {
            x.w("MicroMsg.FastStart", "check len not right");
            return false;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileInputStream.skip((long) pInt.value);
                byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                fileInputStream.read(bArr);
                fileInputStream2 = new FileInputStream(file2);
                try {
                    fileInputStream2.skip((long) pInt3.value);
                    byte[] bArr2 = new byte[Downloads.RECV_BUFFER_SIZE];
                    fileInputStream.read(bArr2);
                    if (Arrays.equals(bArr, bArr2)) {
                        x.w("MicroMsg.FastStart", "check data not right");
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                        }
                        try {
                            fileInputStream2.close();
                        } catch (IOException e3) {
                        }
                        return false;
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                    }
                    return true;
                } catch (Exception e6) {
                    e = e6;
                    fileInputStream3 = fileInputStream2;
                    fileInputStream4 = fileInputStream;
                    try {
                        x.w("MicroMsg.FastStart", "fast start error: " + e.toString());
                        if (fileInputStream4 != null) {
                            try {
                                fileInputStream4.close();
                            } catch (IOException e7) {
                            }
                        }
                        if (fileInputStream3 != null) {
                            try {
                                fileInputStream3.close();
                            } catch (IOException e8) {
                            }
                        }
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream3;
                        fileInputStream = fileInputStream4;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e10) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                fileInputStream3 = null;
                fileInputStream4 = fileInputStream;
                x.w("MicroMsg.FastStart", "fast start error: " + e.toString());
                if (fileInputStream4 != null) {
                    fileInputStream4.close();
                }
                if (fileInputStream3 != null) {
                    fileInputStream3.close();
                }
                return true;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream2 = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            fileInputStream3 = null;
            x.w("MicroMsg.FastStart", "fast start error: " + e.toString());
            if (fileInputStream4 != null) {
                fileInputStream4.close();
            }
            if (fileInputStream3 != null) {
                fileInputStream3.close();
            }
            return true;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream2 = null;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    private static int Q(byte[] bArr) {
        return ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getInt();
    }

    private static int bB(long j) {
        if (j <= 2147483647L && j >= 0) {
            return (int) j;
        }
        throw new Exception("uint32 value is too large");
    }

    private static boolean a(FileChannel fileChannel, ByteBuffer byteBuffer) {
        byteBuffer.clear();
        int read = fileChannel.read(byteBuffer);
        byteBuffer.flip();
        return read == byteBuffer.capacity();
    }

    private static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                x.w("MicroMsg.FastStart", "Failed to close file: ");
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(String str, String str2, PInt pInt) {
        Closeable fileOutputStream;
        boolean a;
        boolean z;
        Exception exception;
        Throwable th;
        Closeable closeable = null;
        File file = new File(str);
        File file2 = new File(str2);
        try {
            Closeable fileInputStream = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream.getChannel();
                fileOutputStream = new FileOutputStream(file2);
                try {
                    a = a(channel, fileOutputStream.getChannel(), pInt);
                    if (a) {
                        a = aB(str, str2);
                    }
                    e(fileInputStream);
                    e(fileOutputStream);
                } catch (Exception e) {
                    Exception exception2 = e;
                    closeable = fileOutputStream;
                    fileOutputStream = fileInputStream;
                    z = a;
                    exception = exception2;
                    try {
                        x.w("MicroMsg.FastStart", "fast start error: " + exception.toString());
                        e(fileOutputStream);
                        e(closeable);
                        a = z;
                        if (!a) {
                            file2.delete();
                        }
                        return a;
                    } catch (Throwable th2) {
                        th = th2;
                        e(fileOutputStream);
                        e(closeable);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    closeable = fileOutputStream;
                    fileOutputStream = fileInputStream;
                    e(fileOutputStream);
                    e(closeable);
                    throw th;
                }
            } catch (Exception e2) {
                exception = e2;
                fileOutputStream = fileInputStream;
                z = false;
                x.w("MicroMsg.FastStart", "fast start error: " + exception.toString());
                e(fileOutputStream);
                e(closeable);
                a = z;
                if (a) {
                    file2.delete();
                }
                return a;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = fileInputStream;
                e(fileOutputStream);
                e(closeable);
                throw th;
            }
        } catch (Exception e3) {
            exception = e3;
            fileOutputStream = null;
            z = false;
            x.w("MicroMsg.FastStart", "fast start error: " + exception.toString());
            e(fileOutputStream);
            e(closeable);
            a = z;
            if (a) {
                file2.delete();
            }
            return a;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            e(fileOutputStream);
            e(closeable);
            throw th;
        }
        if (a) {
            file2.delete();
        }
        return a;
    }

    private static boolean a(FileChannel fileChannel, FileChannel fileChannel2, PInt pInt) {
        int i = 0;
        long j = 0;
        ByteBuffer byteBuffer = null;
        ByteBuffer order = ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN);
        long j2 = 0;
        Object obj = null;
        Object obj2 = null;
        long j3 = -1;
        while (a(fileChannel, order)) {
            int bB;
            long j4 = 4294967295L & ((long) order.getInt());
            i = order.getInt();
            if (i == ieO) {
                obj = 1;
                bB = bB(j4);
                byteBuffer = ByteBuffer.allocate(bB).order(ByteOrder.BIG_ENDIAN);
                order.rewind();
                byteBuffer.put(order);
                if (fileChannel.read(byteBuffer) < bB - 8) {
                    obj2 = null;
                    j = j4;
                    break;
                }
                byteBuffer.flip();
                j2 = fileChannel.position();
                j = j4;
            } else if (i == ieJ) {
                j = fileChannel.position() - 8;
                if (obj2 == null) {
                    x.d("MicroMsg.FastStart", "it moov before mdat, needn't fast start");
                    pInt.value = 1;
                    return false;
                }
                x.d("MicroMsg.FastStart", "it moov after mdat, need fast start");
                obj2 = 1;
                j3 = j;
                j = j4;
            } else {
                if (i == ieI) {
                    obj2 = 1;
                }
                if (j4 == 1) {
                    order.clear();
                    if (!a(fileChannel, order)) {
                        obj2 = null;
                        j = j4;
                        break;
                    }
                    j4 = order.getLong();
                    if (j4 < 0) {
                        throw new Exception("uint64 value is too large");
                    }
                    fileChannel.position((fileChannel.position() + j4) - 16);
                    j = j4;
                } else {
                    fileChannel.position((fileChannel.position() + j4) - 8);
                    j = j4;
                }
            }
            if (j < 8) {
                x.w("MicroMsg.FastStart", "atom size less 8, it error mp4.");
                return false;
            }
        }
        obj2 = null;
        if (obj == null || r2 == null) {
            x.w("MicroMsg.FastStart", "it can not find moov or ftyp");
            return false;
        } else if (i != ieJ || j3 < 0) {
            x.w("MicroMsg.FastStart", "it can not find moov atom");
            return false;
        } else {
            int bB2 = bB(j);
            ByteBuffer order2 = ByteBuffer.allocate(bB2).order(ByteOrder.BIG_ENDIAN);
            order2.clear();
            int read = fileChannel.read(order2, j3);
            order2.flip();
            if ((read == order2.capacity() ? 1 : null) == null) {
                x.w("MicroMsg.FastStart", "failed to read moov atom");
                return false;
            } else if (order2.getInt(12) == ieQ) {
                x.w("MicroMsg.FastStart", "this utility does not support compressed moov atoms yet");
                return false;
            } else {
                while (order2.remaining() >= 8) {
                    read = order2.position();
                    i = order2.getInt(read + 4);
                    if (i != ieR && i != ieS) {
                        order2.position(order2.position() + 1);
                    } else if ((((long) order2.getInt(read)) & 4294967295L) > ((long) order2.remaining())) {
                        x.w("MicroMsg.FastStart", "bad atom size");
                        return false;
                    } else {
                        order2.position(read + 12);
                        if (order2.remaining() < 4) {
                            x.w("MicroMsg.FastStart", "malformed atom");
                            return false;
                        }
                        bB = bB((long) order2.getInt());
                        if (i == ieR) {
                            if (order2.remaining() < bB * 4) {
                                x.w("MicroMsg.FastStart", "bad atom size/element count");
                                return false;
                            }
                            for (read = 0; read < bB; read++) {
                                i = order2.getInt(order2.position());
                                int i2 = i + bB2;
                                if (i < 0 && i2 >= 0) {
                                    return false;
                                }
                                order2.putInt(i2);
                            }
                            continue;
                        } else if (i != ieS) {
                            continue;
                        } else if (order2.remaining() < bB * 8) {
                            x.w("MicroMsg.FastStart", "bad atom size/element count");
                            return false;
                        } else {
                            for (read = 0; read < bB; read++) {
                                order2.putLong(order2.getLong(order2.position()) + ((long) bB2));
                            }
                        }
                    }
                }
                fileChannel.position(j2);
                if (byteBuffer != null) {
                    byteBuffer.rewind();
                    fileChannel2.write(byteBuffer);
                }
                order2.rewind();
                fileChannel2.write(order2);
                fileChannel.transferTo(j2, j3 - j2, fileChannel2);
                fileChannel.transferTo(j3 + ((long) bB2), (fileChannel.size() - j3) - ((long) bB2), fileChannel2);
                return true;
            }
        }
    }
}
