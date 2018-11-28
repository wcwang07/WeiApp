package com.pluto.wservice.controller;

import com.pluto.wservice.dao.CustomFileWriter;
import com.pluto.wservice.model.WebPayload;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AppController
{
    @RequestMapping(path = "/single", method = RequestMethod.POST, consumes = "application/json")
    //@Consumes({MediaType.APPLICATION_JSON})
    public String postRequestToFile(@RequestBody WebPayload payload) throws IOException
    {
        CustomFileWriter customFileWriter = new CustomFileWriter();
        customFileWriter.toFile(payload);
        return "OK";
    }

    @RequestMapping(path = "/bulk", method = RequestMethod.POST, consumes = "application/json")
    public String postRequestToFile(@RequestBody WebPayload[] payload) throws IOException
    {
        CustomFileWriter customFileWriter = new CustomFileWriter();
        for (WebPayload elt : payload)
        {
            customFileWriter.toFile(elt);
        }

        return "OK";
    }


}
