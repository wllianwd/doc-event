package org.wd.doc.event.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.wd.doc.event.dto.Spec;
import java.io.IOException;
import java.util.Map;

@RestController
public class EventDocController {

    @Value("classpath:mdm-events-blueprint.yaml")
    private Resource yamlFile;

    private final ObjectMapper objectMapper;

    public EventDocController() {
        this.objectMapper = new ObjectMapper(new YAMLFactory());
    }

    @RequestMapping(value = "/parser", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    @ResponseBody
    public Map<String, Object> parse() throws IOException {

        Map<String, Object> mapped = objectMapper.readValue(yamlFile.getFile(), Map.class);


        return mapped;
    }

    public Spec getSpecFromMap(Map<String, Object> mapped) {
        Spec spec = new Spec();
        spec.setTitle((String) ((Map<String, Object>) mapped.get("info")).get("title"));
        spec.setVersion((String) ((Map<String, Object>) mapped.get("info")).get("version"));
        return spec;
    }

}
