package com.tenpay.ndk;

import java.io.UnsupportedEncodingException;

public class Encrypt {
    private static final String CHARSET = "UTF-8";
    private byte[] dec_buf;
    private byte[] enc_buf;
    private byte[] enc_passwd;
    private byte[] key_buf;
    private byte[] raw_buf;
    private byte[] raw_passwd;
    private String server_time_stamp = "0";
    private int time_stamp;

    private native boolean decrypt(byte[] bArr, byte[] bArr2);

    private native boolean encrypt(byte[] bArr, byte[] bArr2);

    private native boolean encryptPasswd(byte b, byte[] bArr);

    private native boolean encryptPasswdWithRSA2048(byte b, byte[] bArr, int i);

    private native boolean encryptVerifyCode(byte[] bArr);

    private native byte[] getRandom();

    public native byte[] sm4BCDDecryptCBC(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public native byte[] sm4BCDEncryptCBC(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public String desedeEncode(String str) {
        String str2;
        if (str == null || str.length() <= 0) {
            str2 = null;
        } else {
            try {
                this.raw_buf = str.getBytes(CHARSET);
                encrypt(null, this.raw_buf);
                if (this.enc_buf == null) {
                    return null;
                }
                try {
                    str2 = new String(this.enc_buf, CHARSET);
                } catch (Exception e) {
                    return null;
                }
            } catch (Exception e2) {
                return null;
            }
        }
        return str2;
    }

    public String desedeVerifyCode(String str) {
        String str2;
        if (str == null || str.length() <= 0) {
            str2 = null;
        } else {
            try {
                this.raw_buf = str.getBytes(CHARSET);
                encryptVerifyCode(this.raw_buf);
                if (this.enc_buf == null) {
                    return null;
                }
                try {
                    str2 = new String(this.enc_buf, CHARSET);
                } catch (Exception e) {
                    return null;
                }
            } catch (Exception e2) {
                return null;
            }
        }
        return str2;
    }

    public String desedeEncode(String str, String str2) {
        String str3;
        if (str == null || str2 == null || str.length() <= 0) {
            str3 = null;
        } else {
            try {
                this.raw_buf = str.getBytes(CHARSET);
                this.key_buf = str2.getBytes(CHARSET);
                encrypt(this.key_buf, this.raw_buf);
                if (this.enc_buf == null) {
                    return null;
                }
                try {
                    str3 = new String(this.enc_buf, CHARSET);
                } catch (Exception e) {
                    return null;
                }
            } catch (Exception e2) {
                return null;
            }
        }
        return str3;
    }

    public String desedeDecode(String str, String str2) {
        String str3;
        if (str == null || str2 == null || str.length() <= 0) {
            str3 = null;
        } else {
            try {
                this.raw_buf = str.getBytes(CHARSET);
                this.key_buf = str2.getBytes(CHARSET);
                decrypt(this.key_buf, this.raw_buf);
                if (this.dec_buf == null) {
                    return null;
                }
                try {
                    str3 = new String(this.dec_buf, CHARSET);
                } catch (Exception e) {
                    return null;
                }
            } catch (Exception e2) {
                return null;
            }
        }
        return str3;
    }

    public String getPasswdTimeStamp() {
        return String.valueOf(this.time_stamp);
    }

    public void setTimeStamp(String str) {
        this.server_time_stamp = str;
    }

    public String encryptPasswdWithRSA2048(String str) {
        String str2;
        if (str == null || str.length() <= 0) {
            str2 = null;
        } else {
            this.raw_passwd = null;
            this.enc_passwd = null;
            if (str.length() > 0) {
                try {
                    this.raw_passwd = str.getBytes("ASCII");
                    if (!encryptPasswdWithRSA2048((byte) 2, this.raw_passwd, 1)) {
                        return null;
                    }
                } catch (Exception e) {
                    return null;
                }
            }
            if (this.enc_passwd == null) {
                return null;
            }
            try {
                str2 = new String(this.enc_passwd, "ASCII");
            } catch (Exception e2) {
                return null;
            }
        }
        return str2;
    }

    public String encryptPasswd(String str) {
        String str2;
        if (str == null || str.length() <= 0) {
            str2 = null;
        } else {
            try {
                this.raw_passwd = str.getBytes(CHARSET);
                encryptPasswd((byte) 2, this.raw_passwd);
                if (this.enc_passwd == null) {
                    return null;
                }
                try {
                    int length = this.enc_passwd.length / 2;
                    Object obj = new byte[length];
                    System.arraycopy(this.enc_passwd, length, obj, 0, length);
                    str2 = new String(obj, CHARSET);
                } catch (Exception e) {
                    return null;
                }
            } catch (Exception e2) {
                return null;
            }
        }
        return str2;
    }

    public String getRandomKey() {
        byte[] random = getRandom();
        if (random != null) {
            try {
                return new String(random, CHARSET);
            } catch (UnsupportedEncodingException e) {
            }
        }
        return null;
    }
}
