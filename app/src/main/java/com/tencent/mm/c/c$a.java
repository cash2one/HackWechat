package com.tencent.mm.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;

class c$a {
    Properties fee;
    byte[] fef;

    private c$a() {
        this.fee = new Properties();
    }

    final void y(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            c.to().getBytes();
            byte[] bArr2 = new byte[4];
            wrap.get(bArr2);
            System.out.println("securityPart: " + new k(bArr2).value);
            int i;
            if (c.to().equals(new k(bArr2))) {
                if (bArr.length - 4 <= 2) {
                    System.err.println("data.length - securityMarkLength <= 2");
                    return;
                }
                bArr2 = new byte[2];
                wrap.get(bArr2);
                i = new l(bArr2).value;
                if ((bArr.length - 4) - 2 < i) {
                    System.err.println("data.length - securityMarkLength - 2 < len");
                    System.err.println("exit");
                    return;
                }
                byte[] bArr3 = new byte[i];
                wrap.get(bArr3);
                this.fee.load(new ByteArrayInputStream(bArr3));
                i = ((bArr.length - 4) - i) - 2;
                if (i > 0) {
                    c.tp().getBytes();
                    bArr3 = new byte[4];
                    wrap.get(bArr3);
                    if (!c.tp().equals(new k(bArr3))) {
                        return;
                    }
                    if (i - 4 <= 2) {
                        System.err.println("data.length - oriMarkLength <= 2");
                        return;
                    }
                    bArr3 = new byte[2];
                    wrap.get(bArr3);
                    int i2 = new l(bArr3).value;
                    if ((i - 4) - 2 < i2) {
                        System.err.println("data.length - oriMarkLength - 2 < len");
                        System.err.println("exit");
                        return;
                    }
                    this.fef = new byte[i2];
                    wrap.get(this.fef);
                }
            } else if (c.tp().equals(new k(bArr2))) {
                c.tp().getBytes();
                if (bArr.length - 4 <= 2) {
                    System.err.println("data.length - oriMarkLength <= 2");
                    return;
                }
                bArr2 = new byte[2];
                wrap.get(bArr2);
                i = new l(bArr2).value;
                if ((bArr.length - 4) - 2 < i) {
                    System.err.println("data.length - oriMarkLength - 2 < len");
                    System.err.println("exit");
                    return;
                }
                this.fef = new byte[i];
                wrap.get(this.fef);
            } else {
                throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
            }
        }
    }

    final byte[] tq() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (this.fee.size() > 0) {
            byteArrayOutputStream.write(c.to().getBytes());
            String str = "";
            for (Object next : this.fee.keySet()) {
                str = new StringBuilder(String.valueOf(str)).append(next).append("=").append(this.fee.getProperty((String) next)).append("\r\n").toString();
            }
            byte[] bytes = str.getBytes();
            byteArrayOutputStream.write(new l(bytes.length).getBytes());
            byteArrayOutputStream.write(bytes);
        }
        if (this.fef != null && this.fef.length > 0) {
            byteArrayOutputStream.write(c.tp().getBytes());
            byteArrayOutputStream.write(new l(this.fef.length).getBytes());
            byteArrayOutputStream.write(this.fef);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
