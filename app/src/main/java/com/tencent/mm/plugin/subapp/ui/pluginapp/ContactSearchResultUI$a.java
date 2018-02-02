package com.tencent.mm.plugin.subapp.ui.pluginapp;

abstract class ContactSearchResultUI$a implements Runnable {
    public String iconUrl;
    public String username;

    private ContactSearchResultUI$a() {
    }

    public final void er(String str, String str2) {
        this.username = str;
        this.iconUrl = str2;
    }
}
