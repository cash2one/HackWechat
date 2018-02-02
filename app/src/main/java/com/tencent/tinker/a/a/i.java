package com.tencent.tinker.a.a;

import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.tinker.a.a.a.a;
import com.tencent.tinker.a.a.b.d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.zip.Adler32;

public final class i {
    static final short[] AeS = new short[0];
    public final t AeT = new t();
    private final f AeU = new f(this, (byte) 0);
    private final g AeV = new g(this, (byte) 0);
    private final h AeW = new h(this, (byte) 0);
    private final d AeX = new d(this, (byte) 0);
    private final b AeY = new b(this, (byte) 0);
    private final c AeZ = new c(this, (byte) 0);
    private final a Afa = new a(this, (byte) 0);
    private int Afb = 0;
    private byte[] Afc = null;
    public ByteBuffer aif;

    public i(int i) {
        this.aif = ByteBuffer.wrap(new byte[i]);
        this.aif.order(ByteOrder.LITTLE_ENDIAN);
        this.AeT.fileSize = i;
    }

    public i(InputStream inputStream) {
        Object obj = -1;
        this.aif = ByteBuffer.wrap(d.b(inputStream, 0));
        this.aif.order(ByteOrder.LITTLE_ENDIAN);
        t tVar = this.AeT;
        a a = a(tVar.Afo);
        byte[] Ii = a.Ii(8);
        if (Ii.length == 8 && Ii[0] == (byte) 100 && Ii[1] == (byte) 101 && Ii[2] == (byte) 120 && Ii[3] == (byte) 10 && Ii[7] == (byte) 0) {
            String str = ((char) Ii[4]) + ((char) Ii[5]) + ((char) Ii[6]);
            if (str.equals("036")) {
                obj = 14;
            } else if (str.equals("035")) {
                int i = 13;
            }
        }
        if (obj != 13) {
            throw new j("Unexpected magic: " + Arrays.toString(Ii));
        }
        tVar.hXE = a.aif.getInt();
        tVar.Afc = a.Ii(20);
        tVar.fileSize = a.aif.getInt();
        i = a.aif.getInt();
        if (i != MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
            throw new j("Unexpected header: 0x" + Integer.toHexString(i));
        }
        i = a.aif.getInt();
        if (i != 305419896) {
            throw new j("Unexpected endian tag: 0x" + Integer.toHexString(i));
        }
        tVar.AfH = a.aif.getInt();
        tVar.AfI = a.aif.getInt();
        tVar.Afv.dzw = a.aif.getInt();
        if (tVar.Afv.dzw == 0) {
            throw new j("Cannot merge dex files that do not contain a map");
        }
        tVar.Afp.size = a.aif.getInt();
        tVar.Afp.dzw = a.aif.getInt();
        tVar.Afq.size = a.aif.getInt();
        tVar.Afq.dzw = a.aif.getInt();
        tVar.Afr.size = a.aif.getInt();
        tVar.Afr.dzw = a.aif.getInt();
        tVar.Afs.size = a.aif.getInt();
        tVar.Afs.dzw = a.aif.getInt();
        tVar.Aft.size = a.aif.getInt();
        tVar.Aft.dzw = a.aif.getInt();
        tVar.Afu.size = a.aif.getInt();
        tVar.Afu.dzw = a.aif.getInt();
        tVar.AfJ = a.aif.getInt();
        tVar.AfK = a.aif.getInt();
        tVar.a(Id(tVar.Afv.dzw));
        tVar.cGO();
    }

    private static void fG(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index:" + i + ", length=" + i2);
        }
    }

    public final e Id(int i) {
        if (i < 0 || i >= this.aif.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.aif.capacity());
        }
        ByteBuffer duplicate = this.aif.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i);
        duplicate.limit(this.aif.capacity());
        return new e(this, "temp-section", duplicate, (byte) 0);
    }

    public final e a(t.a aVar) {
        int i = aVar.dzw;
        if (i < 0 || i >= this.aif.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.aif.capacity());
        }
        ByteBuffer duplicate = this.aif.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i);
        duplicate.limit(i + aVar.AfN);
        return new e(this, "section", duplicate, (byte) 0);
    }

    public final byte[] nX(boolean z) {
        if (this.Afc != null && !z) {
            return this.Afc;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[8192];
            ByteBuffer duplicate = this.aif.duplicate();
            duplicate.limit(duplicate.capacity());
            duplicate.position(32);
            while (duplicate.hasRemaining()) {
                int min = Math.min(8192, duplicate.remaining());
                duplicate.get(bArr, 0, min);
                instance.update(bArr, 0, min);
            }
            byte[] digest = instance.digest();
            this.Afc = digest;
            return digest;
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    public final void cGp() {
        Id(12).write(nX(true));
        e Id = Id(8);
        Adler32 adler32 = new Adler32();
        byte[] bArr = new byte[8192];
        ByteBuffer duplicate = this.aif.duplicate();
        duplicate.limit(duplicate.capacity());
        duplicate.position(12);
        while (duplicate.hasRemaining()) {
            int min = Math.min(8192, duplicate.remaining());
            duplicate.get(bArr, 0, min);
            adler32.update(bArr, 0, min);
        }
        Id.writeInt((int) adler32.getValue());
    }

    public final int Ie(int i) {
        fG(i, this.AeT.Afq.size);
        return this.aif.getInt(this.AeT.Afq.dzw + (i * 4));
    }
}
