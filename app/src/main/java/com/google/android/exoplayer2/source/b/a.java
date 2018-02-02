package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.h;
import com.google.android.exoplayer2.h.i;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

final class a implements f {
    private final byte[] aiR;
    private final f asS;
    private final byte[] asT;
    private CipherInputStream asU;

    public a(f fVar, byte[] bArr, byte[] bArr2) {
        this.asS = fVar;
        this.aiR = bArr;
        this.asT = bArr2;
    }

    public final long a(i iVar) {
        Throwable e;
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                instance.init(2, new SecretKeySpec(this.aiR, "AES"), new IvParameterSpec(this.asT));
                this.asU = new CipherInputStream(new h(this.asS, iVar), instance);
                return -1;
            } catch (InvalidKeyException e2) {
                e = e2;
                throw new RuntimeException(e);
            } catch (InvalidAlgorithmParameterException e3) {
                e = e3;
                throw new RuntimeException(e);
            }
        } catch (NoSuchAlgorithmException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e5) {
            e = e5;
            throw new RuntimeException(e);
        }
    }

    public final void close() {
        this.asU = null;
        this.asS.close();
    }

    public final int read(byte[] bArr, int i, int i2) {
        com.google.android.exoplayer2.i.a.an(this.asU != null);
        int read = this.asU.read(bArr, i, i2);
        if (read < 0) {
            return -1;
        }
        return read;
    }

    public final Uri getUri() {
        return this.asS.getUri();
    }
}
