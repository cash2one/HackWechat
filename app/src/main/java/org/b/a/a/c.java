package org.b.a.a;

import org.b.d.i;

public class c extends b {
    public String cKc() {
        return "http://api.twitter.com/oauth/access_token";
    }

    public String cKb() {
        return "http://api.twitter.com/oauth/request_token";
    }

    public final String b(i iVar) {
        return String.format("https://api.twitter.com/oauth/authorize?oauth_token=%s", new Object[]{iVar.token});
    }
}
