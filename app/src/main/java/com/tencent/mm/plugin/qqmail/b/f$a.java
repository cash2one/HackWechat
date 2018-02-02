package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

class f$a implements HttpEntity {
    private File file;
    private int length;
    private String pon;
    private String poo;
    final /* synthetic */ f pop;

    public f$a(f fVar, String str, String str2, String str3) {
        this.pop = fVar;
        this.pon = str;
        this.file = new File(str2);
        this.poo = str3;
        this.length = (str.length() + ((int) this.file.length())) + str3.length();
    }

    public final boolean isRepeatable() {
        return true;
    }

    public final boolean isChunked() {
        return !isRepeatable();
    }

    public final boolean isStreaming() {
        return !isRepeatable();
    }

    public final long getContentLength() {
        return (long) this.length;
    }

    public final Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=----" + f.by());
    }

    public final Header getContentEncoding() {
        return null;
    }

    public final InputStream getContent() {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    public final void writeTo(OutputStream outputStream) {
        Throwable th;
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeBytes(this.pon);
        FileInputStream fileInputStream;
        try {
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            fileInputStream = new FileInputStream(this.file);
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        dataOutputStream.write(bArr, 0, read);
                    } else {
                        dataOutputStream.flush();
                        fileInputStream.close();
                        dataOutputStream.writeBytes(this.poo);
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public final void consumeContent() {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }
}
