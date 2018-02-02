package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.wear.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.crypto.Cipher;

public final class b extends a {
    private byte[] bjP;
    private byte[] tiN;
    private byte[] tiO;

    public final byte[] CF() {
        boolean z = true;
        if (this.tiO == null || this.tiN == null || this.bjP == null) {
            boolean z2;
            x.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
            try {
                bOI();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", e, "loadAllKey", new Object[0]);
            }
            String str = "MicroMsg.Wear.HttpAuthServer";
            String str2 = "publicKey %s privateKey %s sessionKey %s";
            Object[] objArr = new Object[3];
            if (this.tiO != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            objArr[1] = Boolean.valueOf(this.tiN != null);
            if (this.bjP == null) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
        }
        return this.bjP;
    }

    private void bOI() {
        File file = new File(e.gZL, "wear/key");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "private.key");
        File file3 = new File(file, "public.key");
        File file4 = new File(file, "session.key");
        if (file2.exists() && file3.exists() && file4.exists()) {
            x.i("MicroMsg.Wear.HttpAuthServer", "use old keys");
            this.tiO = com.tencent.mm.a.e.e(file3.getAbsolutePath(), 0, Integer.MAX_VALUE);
            this.tiN = com.tencent.mm.a.e.e(file2.getAbsolutePath(), 0, Integer.MAX_VALUE);
            this.bjP = com.tencent.mm.a.e.e(file4.getAbsolutePath(), 0, Integer.MAX_VALUE);
        } else {
            x.i("MicroMsg.Wear.HttpAuthServer", "recreate keys");
            file2.delete();
            file3.delete();
            file4.delete();
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
            instance.initialize(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            KeyPair generateKeyPair = instance.generateKeyPair();
            RSAPublicKey rSAPublicKey = (RSAPublicKey) generateKeyPair.getPublic();
            RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) generateKeyPair.getPrivate();
            HashMap hashMap = new HashMap(2);
            hashMap.put("RSAPublicKey", rSAPublicKey);
            hashMap.put("RSAPrivateKey", rSAPrivateKey);
            RSAPrivateKey rSAPrivateKey2 = (RSAPrivateKey) hashMap.get("RSAPrivateKey");
            this.tiO = ((RSAPublicKey) hashMap.get("RSAPublicKey")).getEncoded();
            this.tiN = rSAPrivateKey2.getEncoded();
            this.bjP = a.bOK();
            com.tencent.mm.a.e.b(file2.getAbsolutePath(), this.tiN, this.tiN.length);
            com.tencent.mm.a.e.b(file3.getAbsolutePath(), this.tiO, this.tiO.length);
            com.tencent.mm.a.e.b(file4.getAbsolutePath(), this.bjP, this.bjP.length);
        }
        x.i("MicroMsg.Wear.HttpAuthServer", "publicKey=%s privateKey=%s sessionKey=%s", new Object[]{ab.bt(this.tiO), ab.bt(this.tiN), ab.bt(this.bjP)});
    }

    public final List<Integer> bOG() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(10001));
        arrayList.add(Integer.valueOf(10002));
        return arrayList;
    }

    protected final byte[] n(int i, byte[] bArr) {
        boolean z = true;
        switch (i) {
            case 10001:
                boolean z2;
                x.i("MicroMsg.Wear.HttpAuthServer", "request public key");
                if (this.tiO == null || this.tiN == null || this.bjP == null) {
                    x.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
                    try {
                        bOI();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", e, "loadAllKey", new Object[0]);
                    }
                }
                String str = "MicroMsg.Wear.HttpAuthServer";
                String str2 = "publicKey %s privateKey %s sessionKey %s";
                Object[] objArr = new Object[3];
                if (this.tiO != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                objArr[1] = Boolean.valueOf(this.tiN != null);
                if (this.bjP == null) {
                    z = false;
                }
                objArr[2] = Boolean.valueOf(z);
                x.i(str, str2, objArr);
                return this.tiO;
            case 10002:
                try {
                    KeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(this.tiN);
                    KeyFactory instance = KeyFactory.getInstance("RSA");
                    Key generatePrivate = instance.generatePrivate(pKCS8EncodedKeySpec);
                    Cipher instance2 = Cipher.getInstance(instance.getAlgorithm());
                    instance2.init(2, generatePrivate);
                    byte[] f = a.f(this.bjP, instance2.doFinal(bArr));
                    x.i("MicroMsg.Wear.HttpAuthServer", "funid %d, randomKey=%s", new Object[]{Integer.valueOf(i), ab.bt(r1)});
                    return f;
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", e2, "sessionKey resp error", new Object[0]);
                    break;
                }
        }
        return null;
    }
}
