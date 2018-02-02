package c.t.m.g;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

class ai extends SSLSocketFactory {
    public boolean a = false;
    private String b;

    public ai(String str) {
        ai.class.getSimpleName();
        this.b = str;
    }

    public Socket createSocket() {
        return null;
    }

    public Socket createSocket(String str, int i) {
        return null;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return null;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        boolean z2 = false;
        if (TextUtils.isEmpty(this.b)) {
            throw new IOException("Halley set empty bizHost");
        }
        Socket socket2;
        if (VERSION.SDK_INT < 23) {
            z2 = true;
        }
        new StringBuilder("customized createSocket. host: ").append(this.b);
        SSLCertificateSocketFactory sSLCertificateSocketFactory;
        if (z2) {
            try {
                InetAddress inetAddress = socket.getInetAddress();
                if (z) {
                    socket.close();
                }
                sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(10000, new SSLSessionCache(m.a()));
                socket2 = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i);
                socket2.setEnabledProtocols(socket2.getSupportedProtocols());
                if (VERSION.SDK_INT >= 17) {
                    sSLCertificateSocketFactory.setUseSessionTickets(socket2, true);
                    sSLCertificateSocketFactory.setHostname(socket2, this.b);
                } else {
                    socket2.getClass().getMethod("setHostname", new Class[]{String.class}).invoke(socket2, new Object[]{this.b});
                }
                socket2.startHandshake();
            } catch (Exception e) {
                throw new IOException("SNI hostname setting error before API17, " + e);
            } catch (Throwable th) {
                this.a = true;
                IOException iOException = new IOException("HalleySNI exception: " + th);
            }
        } else {
            sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(10000, new SSLSessionCache(m.a()));
            SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, this.b, i, z);
            sSLCertificateSocketFactory.setUseSessionTickets(sSLSocket, true);
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
            sSLCertificateSocketFactory.setHostname(sSLSocket, this.b);
            sSLSocket.startHandshake();
        }
        return socket2;
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.b) || !(obj instanceof ai)) {
            return false;
        }
        CharSequence charSequence = ((ai) obj).b;
        return !TextUtils.isEmpty(charSequence) ? this.b.equals(charSequence) : false;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
