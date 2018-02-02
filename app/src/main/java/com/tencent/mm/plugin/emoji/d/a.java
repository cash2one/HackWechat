package com.tencent.mm.plugin.emoji.d;

import com.tencent.mm.aq.a.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class a implements b {
    public final com.tencent.mm.aq.a.d.b lA(String str) {
        String str2;
        int i;
        Throwable e;
        String str3 = "";
        String str4 = "";
        try {
            com.tencent.mm.network.b.b bVar = new com.tencent.mm.network.b.b(str);
            if (bh.ov(bVar.ip)) {
                str2 = str3;
            } else {
                str2 = bVar.ip;
            }
            try {
                str3 = bVar.ip;
                try {
                    i = bVar.hZy;
                    try {
                        return a.c(str, bVar);
                    } catch (ProtocolException e2) {
                        e = e2;
                        x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                        g.pQN.a(315, 7, 1, false);
                        return new com.tencent.mm.aq.a.d.b(null, null);
                    } catch (InterruptedException e3) {
                        e = e3;
                        x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                        g.pQN.a(315, 0, 1, false);
                        return new com.tencent.mm.aq.a.d.b(null, null);
                    } catch (UnknownHostException e4) {
                        e = e4;
                        x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                        g.pQN.a(315, 1, 1, false);
                        return new com.tencent.mm.aq.a.d.b(null, null);
                    } catch (SSLHandshakeException e5) {
                        e = e5;
                        x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                        g.pQN.a(315, 2, 1, false);
                        return new com.tencent.mm.aq.a.d.b(null, null);
                    } catch (SocketException e6) {
                        e = e6;
                        x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                        g.pQN.a(315, 3, 1, false);
                        return new com.tencent.mm.aq.a.d.b(null, null);
                    } catch (SocketTimeoutException e7) {
                        e = e7;
                        x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                        g.pQN.a(315, 4, 1, false);
                        return new com.tencent.mm.aq.a.d.b(null, null);
                    } catch (IOException e8) {
                        e = e8;
                        x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                        g.pQN.a(315, 5, 1, false);
                        return new com.tencent.mm.aq.a.d.b(null, null);
                    } catch (Exception e9) {
                        e = e9;
                        x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                        g.pQN.a(315, 6, 1, false);
                        return new com.tencent.mm.aq.a.d.b(null, null);
                    }
                } catch (ProtocolException e10) {
                    e = e10;
                    i = 0;
                    x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                    g.pQN.a(315, 7, 1, false);
                    return new com.tencent.mm.aq.a.d.b(null, null);
                } catch (InterruptedException e11) {
                    e = e11;
                    i = 0;
                    x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                    g.pQN.a(315, 0, 1, false);
                    return new com.tencent.mm.aq.a.d.b(null, null);
                } catch (UnknownHostException e12) {
                    e = e12;
                    i = 0;
                    x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                    g.pQN.a(315, 1, 1, false);
                    return new com.tencent.mm.aq.a.d.b(null, null);
                } catch (SSLHandshakeException e13) {
                    e = e13;
                    i = 0;
                    x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                    g.pQN.a(315, 2, 1, false);
                    return new com.tencent.mm.aq.a.d.b(null, null);
                } catch (SocketException e14) {
                    e = e14;
                    i = 0;
                    x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                    g.pQN.a(315, 3, 1, false);
                    return new com.tencent.mm.aq.a.d.b(null, null);
                } catch (SocketTimeoutException e15) {
                    e = e15;
                    i = 0;
                    x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                    g.pQN.a(315, 4, 1, false);
                    return new com.tencent.mm.aq.a.d.b(null, null);
                } catch (IOException e16) {
                    e = e16;
                    i = 0;
                    x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                    g.pQN.a(315, 5, 1, false);
                    return new com.tencent.mm.aq.a.d.b(null, null);
                } catch (Exception e17) {
                    e = e17;
                    i = 0;
                    x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                    g.pQN.a(315, 6, 1, false);
                    return new com.tencent.mm.aq.a.d.b(null, null);
                }
            } catch (ProtocolException e18) {
                e = e18;
                str3 = str4;
                i = 0;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                g.pQN.a(315, 7, 1, false);
                return new com.tencent.mm.aq.a.d.b(null, null);
            } catch (InterruptedException e19) {
                e = e19;
                str3 = str4;
                i = 0;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                g.pQN.a(315, 0, 1, false);
                return new com.tencent.mm.aq.a.d.b(null, null);
            } catch (UnknownHostException e20) {
                e = e20;
                str3 = str4;
                i = 0;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                g.pQN.a(315, 1, 1, false);
                return new com.tencent.mm.aq.a.d.b(null, null);
            } catch (SSLHandshakeException e21) {
                e = e21;
                str3 = str4;
                i = 0;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                g.pQN.a(315, 2, 1, false);
                return new com.tencent.mm.aq.a.d.b(null, null);
            } catch (SocketException e22) {
                e = e22;
                str3 = str4;
                i = 0;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                g.pQN.a(315, 3, 1, false);
                return new com.tencent.mm.aq.a.d.b(null, null);
            } catch (SocketTimeoutException e23) {
                e = e23;
                str3 = str4;
                i = 0;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                g.pQN.a(315, 4, 1, false);
                return new com.tencent.mm.aq.a.d.b(null, null);
            } catch (IOException e24) {
                e = e24;
                str3 = str4;
                i = 0;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                g.pQN.a(315, 5, 1, false);
                return new com.tencent.mm.aq.a.d.b(null, null);
            } catch (Exception e25) {
                e = e25;
                str3 = str4;
                i = 0;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
                g.pQN.a(315, 6, 1, false);
                return new com.tencent.mm.aq.a.d.b(null, null);
            }
        } catch (ProtocolException e26) {
            e = e26;
            str2 = str3;
            str3 = str4;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
            g.pQN.a(315, 7, 1, false);
            return new com.tencent.mm.aq.a.d.b(null, null);
        } catch (InterruptedException e27) {
            e = e27;
            str2 = str3;
            str3 = str4;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
            g.pQN.a(315, 0, 1, false);
            return new com.tencent.mm.aq.a.d.b(null, null);
        } catch (UnknownHostException e28) {
            e = e28;
            str2 = str3;
            str3 = str4;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
            g.pQN.a(315, 1, 1, false);
            return new com.tencent.mm.aq.a.d.b(null, null);
        } catch (SSLHandshakeException e29) {
            e = e29;
            str2 = str3;
            str3 = str4;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
            g.pQN.a(315, 2, 1, false);
            return new com.tencent.mm.aq.a.d.b(null, null);
        } catch (SocketException e30) {
            e = e30;
            str2 = str3;
            str3 = str4;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
            g.pQN.a(315, 3, 1, false);
            return new com.tencent.mm.aq.a.d.b(null, null);
        } catch (SocketTimeoutException e31) {
            e = e31;
            str2 = str3;
            str3 = str4;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
            g.pQN.a(315, 4, 1, false);
            return new com.tencent.mm.aq.a.d.b(null, null);
        } catch (IOException e32) {
            e = e32;
            str2 = str3;
            str3 = str4;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
            g.pQN.a(315, 5, 1, false);
            return new com.tencent.mm.aq.a.d.b(null, null);
        } catch (Exception e33) {
            e = e33;
            str2 = str3;
            str3 = str4;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", new Object[]{str, str2, str3, Integer.valueOf(i), bh.i(e)});
            g.pQN.a(315, 6, 1, false);
            return new com.tencent.mm.aq.a.d.b(null, null);
        }
    }
}
