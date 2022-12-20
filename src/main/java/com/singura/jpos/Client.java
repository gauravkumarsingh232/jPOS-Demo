package com.singura.jpos;

import org.jpos.iso.ISOChannel;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.channel.XMLChannel;
import org.jpos.iso.packager.XMLPackager;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws ISOException, IOException {
        ISOPackager packager = new XMLPackager();
        ISOChannel channel = new XMLChannel("localhost", 10000, packager);
        channel.connect();
        ISOMsg request = new ISOMsg();

        request.setMTI("0200");
        request.set(2, "5421287475388412");
        request.set(3, "000000");
        request.set(4, "000000001000");
        request.set(7, "0716070815");
        request.set(11, "844515");

        channel.send(request);
        ISOMsg response = channel.receive();

        response.dump(System.out, "response:");

    }
}