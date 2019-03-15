package com.microsoft.rest.v2.http;

import java.net.SocketAddress;
/**
 * Proxy class that extends java.net.Proxy to allow configuration of Tunneling (CONNECT) and 
 * secure connections between client and proxy.
 * @author greg
 *
 */
public class Proxy extends java.net.Proxy {

    private boolean tunneling = true;
    private boolean secure = false;

    /**
     * Contructor that assumes tunneling=true and secure=false
     * @param proxy a java.net.Proxy
     */
    public Proxy(java.net.Proxy proxy) {
        super(proxy.type(), proxy.address());
    }

    /**
     * Contructor that assumes tunneling=true and secure=false
     * @param type
     * @param sa
     */
    public Proxy(Type type, SocketAddress sa) {
        super(type, sa);
    }

    public Proxy(Type type, SocketAddress sa, boolean tunneling, boolean secure) {
        super(type, sa);
        this.tunneling = tunneling;
        this.secure = secure;
    }

    public boolean isTunneling() {
        return tunneling;
    }

    public void setTunneling(boolean tunneling) {
        this.tunneling = tunneling;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    @Override
    public String toString() {
        return "Proxy [tunneling=" + tunneling + ", secure=" + secure + ", type=" + type() + ", address=" + address() + "]";
    }

}
