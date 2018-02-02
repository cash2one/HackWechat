package com.tencent.tinker.loader.shareutil;

import com.tencent.wcdb.FileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class ShareElfFile implements Closeable {
    private final FileInputStream AkF;
    private final Map<String, SectionHeader> AkG = new HashMap();
    public ElfHeader AkH = null;
    public ProgramHeader[] AkI = null;
    public SectionHeader[] AkJ = null;

    public static class ElfHeader {
        public final byte[] AkK;
        public final short AkL;
        public final short AkM;
        public final int AkN;
        public final long AkO;
        public final long AkP;
        public final long AkQ;
        public final int AkR;
        public final short AkS;
        public final short AkT;
        public final short AkU;
        public final short AkV;
        public final short AkW;
        public final short AkX;

        private ElfHeader(FileChannel fileChannel) {
            this.AkK = new byte[16];
            fileChannel.position(0);
            fileChannel.read(ByteBuffer.wrap(this.AkK));
            if (this.AkK[0] == Byte.MAX_VALUE && this.AkK[1] == (byte) 69 && this.AkK[2] == (byte) 76 && this.AkK[3] == (byte) 70) {
                ShareElfFile.x(this.AkK[4], 2, "bad elf class: " + this.AkK[4]);
                ShareElfFile.x(this.AkK[5], 2, "bad elf data encoding: " + this.AkK[5]);
                ByteBuffer allocate = ByteBuffer.allocate(this.AkK[4] == (byte) 1 ? 36 : 48);
                allocate.order(this.AkK[5] == (byte) 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                ShareElfFile.a(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.AkL = allocate.getShort();
                this.AkM = allocate.getShort();
                this.AkN = allocate.getInt();
                ShareElfFile.x(this.AkN, 1, "bad elf version: " + this.AkN);
                switch (this.AkK[4]) {
                    case (byte) 1:
                        this.AkO = (long) allocate.getInt();
                        this.AkP = (long) allocate.getInt();
                        this.AkQ = (long) allocate.getInt();
                        break;
                    case (byte) 2:
                        this.AkO = allocate.getLong();
                        this.AkP = allocate.getLong();
                        this.AkQ = allocate.getLong();
                        break;
                    default:
                        throw new IOException("Unexpected elf class: " + this.AkK[4]);
                }
                this.AkR = allocate.getInt();
                this.AkS = allocate.getShort();
                this.AkT = allocate.getShort();
                this.AkU = allocate.getShort();
                this.AkV = allocate.getShort();
                this.AkW = allocate.getShort();
                this.AkX = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", new Object[]{Byte.valueOf(this.AkK[0]), Byte.valueOf(this.AkK[1]), Byte.valueOf(this.AkK[2]), Byte.valueOf(this.AkK[3])}));
        }
    }

    public static class ProgramHeader {
        public final int AkY;
        public final int AkZ;
        public final long Ala;
        public final long Alb;
        public final long Alc;
        public final long Ald;
        public final long Ale;
        public final long Alf;

        private ProgramHeader(ByteBuffer byteBuffer, int i) {
            switch (i) {
                case 1:
                    this.AkY = byteBuffer.getInt();
                    this.Ala = (long) byteBuffer.getInt();
                    this.Alb = (long) byteBuffer.getInt();
                    this.Alc = (long) byteBuffer.getInt();
                    this.Ald = (long) byteBuffer.getInt();
                    this.Ale = (long) byteBuffer.getInt();
                    this.AkZ = byteBuffer.getInt();
                    this.Alf = (long) byteBuffer.getInt();
                    return;
                case 2:
                    this.AkY = byteBuffer.getInt();
                    this.AkZ = byteBuffer.getInt();
                    this.Ala = byteBuffer.getLong();
                    this.Alb = byteBuffer.getLong();
                    this.Alc = byteBuffer.getLong();
                    this.Ald = byteBuffer.getLong();
                    this.Ale = byteBuffer.getLong();
                    this.Alf = byteBuffer.getLong();
                    return;
                default:
                    throw new IOException("Unexpected elf class: " + i);
            }
        }
    }

    public static class SectionHeader {
        public final int Alg;
        public final int Alh;
        public final long Ali;
        public final long Alj;
        public final long Alk;
        public final long All;
        public final int Alm;
        public final int Aln;
        public final long Alo;
        public final long Alp;
        public String Alq;

        private SectionHeader(ByteBuffer byteBuffer, int i) {
            switch (i) {
                case 1:
                    this.Alg = byteBuffer.getInt();
                    this.Alh = byteBuffer.getInt();
                    this.Ali = (long) byteBuffer.getInt();
                    this.Alj = (long) byteBuffer.getInt();
                    this.Alk = (long) byteBuffer.getInt();
                    this.All = (long) byteBuffer.getInt();
                    this.Alm = byteBuffer.getInt();
                    this.Aln = byteBuffer.getInt();
                    this.Alo = (long) byteBuffer.getInt();
                    this.Alp = (long) byteBuffer.getInt();
                    break;
                case 2:
                    this.Alg = byteBuffer.getInt();
                    this.Alh = byteBuffer.getInt();
                    this.Ali = byteBuffer.getLong();
                    this.Alj = byteBuffer.getLong();
                    this.Alk = byteBuffer.getLong();
                    this.All = byteBuffer.getLong();
                    this.Alm = byteBuffer.getInt();
                    this.Aln = byteBuffer.getInt();
                    this.Alo = byteBuffer.getLong();
                    this.Alp = byteBuffer.getLong();
                    break;
                default:
                    throw new IOException("Unexpected elf class: " + i);
            }
            this.Alq = null;
        }
    }

    static /* synthetic */ void x(int i, int i2, String str) {
        if (i <= 0 || i > i2) {
            throw new IOException(str);
        }
    }

    public ShareElfFile(File file) {
        int i;
        int i2 = 0;
        this.AkF = new FileInputStream(file);
        FileChannel channel = this.AkF.getChannel();
        this.AkH = new ElfHeader(channel);
        ByteBuffer allocate = ByteBuffer.allocate(FileUtils.S_IWUSR);
        allocate.limit(this.AkH.AkT);
        allocate.order(this.AkH.AkK[5] == (byte) 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.AkH.AkP);
        this.AkI = new ProgramHeader[this.AkH.AkU];
        for (i = 0; i < this.AkI.length; i++) {
            a(channel, allocate, "failed to read phdr.");
            this.AkI[i] = new ProgramHeader(allocate, this.AkH.AkK[4]);
        }
        channel.position(this.AkH.AkQ);
        allocate.limit(this.AkH.AkV);
        this.AkJ = new SectionHeader[this.AkH.AkW];
        for (i = 0; i < this.AkJ.length; i++) {
            a(channel, allocate, "failed to read shdr.");
            this.AkJ[i] = new SectionHeader(allocate, this.AkH.AkK[4]);
        }
        if (this.AkH.AkX > (short) 0) {
            SectionHeader sectionHeader = this.AkJ[this.AkH.AkX];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) sectionHeader.All);
            this.AkF.getChannel().position(sectionHeader.Alk);
            a(this.AkF.getChannel(), allocate2, "failed to read section: " + sectionHeader.Alq);
            SectionHeader[] sectionHeaderArr = this.AkJ;
            int length = sectionHeaderArr.length;
            while (i2 < length) {
                SectionHeader sectionHeader2 = sectionHeaderArr[i2];
                allocate2.position(sectionHeader2.Alg);
                sectionHeader2.Alq = x(allocate2);
                this.AkG.put(sectionHeader2.Alq, sectionHeader2);
                i2++;
            }
        }
    }

    public static int ac(File file) {
        Throwable th;
        InputStream inputStream;
        try {
            byte[] bArr = new byte[4];
            InputStream fileInputStream = new FileInputStream(file);
            try {
                fileInputStream.read(bArr);
                if (bArr[0] == (byte) 100 && bArr[1] == (byte) 101 && bArr[2] == (byte) 121 && bArr[3] == (byte) 10) {
                    try {
                        fileInputStream.close();
                        return 0;
                    } catch (Throwable th2) {
                        return 0;
                    }
                } else if (bArr[0] == Byte.MAX_VALUE && bArr[1] == (byte) 69 && bArr[2] == (byte) 76 && bArr[3] == (byte) 70) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                    }
                    return 1;
                } else {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th4) {
                    }
                    return -1;
                }
            } catch (Throwable th5) {
                th = th5;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th6) {
                    }
                }
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public static void a(FileChannel fileChannel, ByteBuffer byteBuffer, String str) {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read != byteBuffer.limit()) {
            throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
        }
        byteBuffer.flip();
    }

    private static String x(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != (byte) 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName("ASCII"));
    }

    public void close() {
        this.AkF.close();
        this.AkG.clear();
        this.AkI = null;
        this.AkJ = null;
    }
}
