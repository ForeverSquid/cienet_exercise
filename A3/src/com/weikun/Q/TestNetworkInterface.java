package com.weikun.Q;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class TestNetworkInterface {
	public static void main(String argv[]) throws Exception {
		 
        Enumeration<NetworkInterface> enumInterfaces = NetworkInterface
                .getNetworkInterfaces();
        while (enumInterfaces.hasMoreElements()) {
            NetworkInterface net = (NetworkInterface) enumInterfaces
                    .nextElement();
            System.out.println("Network Interface Display Name: "
                    + net.getDisplayName());
            System.out.println(net.getDisplayName() + " is up and running ?"
                    + net.isUp());
            System.out.println(net.getDisplayName() + " Supports Multicast: "
                    + net.supportsMulticast());
            System.out
                    .println(net.getDisplayName() + " Name: " + net.getName());
            System.out.println(net.getDisplayName() + " Is Virtual: "
                    + net.isVirtual());
            System.out.println("IP addresses:");
            Enumeration<InetAddress> enumIP = net.getInetAddresses();
            while (enumIP.hasMoreElements()) {
                InetAddress ip = (InetAddress) enumIP.nextElement();
                System.out.println("IP address:" + ip);
            }
        }
    }
}
