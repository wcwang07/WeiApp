package com.pluto.wservice.dao;

import com.pluto.wservice.model.WebPayload;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.time.Instant;
import java.util.UUID;

public class CustomFileWriter
{
    public CustomFileWriter()
    {
    }

    public void toFile(WebPayload payload) throws IOException
    {

        JSONObject parentData = new JSONObject();
        JSONObject childData = new JSONObject();
        JSONObject gchildData = new JSONObject();

        UUID uuid = UUID.randomUUID();
        InetAddress iAddress = InetAddress.getLocalHost();
        gchildData.put("name", payload.getName());
        gchildData.put("age", payload.getAge());
        gchildData.put("cars", payload.getCars());
        childData.put("uuid", uuid.toString());
        childData.put("ip", iAddress.getHostAddress());
        childData.put("timestamp", Instant.now().getEpochSecond());
        parentData.put("meta", childData);
        parentData.put("payload",gchildData);


        FileWriter file = new FileWriter("C:\\examplefile-"+uuid+".json");
        file.write(parentData.toString());
        file.close();

    }
}
