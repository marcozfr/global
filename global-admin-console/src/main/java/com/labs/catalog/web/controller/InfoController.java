package com.labs.catalog.web.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import com.labs.catalog.service.beans.InfoService;
import com.labs.catalog.service.beans.extension.FormValidator;
import com.labs.catalog.service.model.Form;
import com.labs.catalog.service.model.InfoData;

@Controller
@RequestMapping("/info")
@RequestScope
@SessionAttributes("infoData")
public class InfoController {
    
    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    InfoService infoService;
    
    @Autowired
    Validator jsr303Validator;
    
    @Autowired
    HttpSession session;

    @PostConstruct
    public void init(){
        logger.info("Post construct "+this.getClass().getName());
    }
    
    @GetMapping(path="/{id}")
    @ResponseBody
    public String hello(@PathVariable(name="id") String id,
            @RequestParam(name="version",defaultValue="0.1") Double version,
            @MatrixVariable(name="q",defaultValue="1",pathVar="id") Double q,
            HttpServletRequest request){
        
        request.getSession();
        
        StringBuilder retunBody = new StringBuilder("");
        
        retunBody.append("id: "+id).append(",");
        retunBody.append("version: "+version).append(",");
        retunBody.append("q: "+q);
        
        return retunBody.toString();
    }
    
    @PutMapping(path="/data/test",consumes={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public InfoData hello(@RequestBody(required=true) InfoData data){
        data.setDetails("Sent to server on "+ new Date());
        return data;
    }
    
    @PutMapping(path="/data/list",consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<InfoData> dataList(@RequestBody(required=true) List<InfoData> data){
        data.stream().map(a -> { a.setDetails("Sent to server on "+ new Date()); return a;}).collect(Collectors.toList()); 
        return data;
    }
    
//    @PostMapping(path="/data/add",consumes={MediaType.APPLICATION_JSON_VALUE})
//    @ModelAttribute("infoData")
//    public InfoData dataAdd(@RequestBody(required=true) InfoData data){
//        data.setDetails("Sent to server on "+ new Date());
//        return data;
//    }
    
    @GetMapping(path="/data")
    public String getData(){
        return "infoData";
    }
    
    @PostMapping(path="/data/add",consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    public ModelAndView dataAdd(@RequestBody(required=true) InfoData data){
        ModelAndView model = new ModelAndView();
        data.setDetails("Sent to server on "+ new Date());
        
        @SuppressWarnings("unchecked")
        List<InfoData> dataList = (List<InfoData>)session.getAttribute("infoData");
        if(dataList == null) dataList = new ArrayList<>();
        dataList.add(data);
        
        model.addObject("infoData", dataList);
        model.setViewName("redirect:/s/info/data");
        return model;
    }
    
    @PostMapping(path="/entity",consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InfoData> hello(HttpEntity<InfoData> entity){
        InfoData data = entity.getBody();
        HttpHeaders headers = entity.getHeaders();
        data.setDetails("Sent to server on "+ new Date() +" @ Host: "+headers.getOrigin());

        ResponseEntity<InfoData> responseEntity = new ResponseEntity<InfoData>(data, HttpStatus.OK);
        return responseEntity;
    }
    
    @PostMapping(path="/validate",consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> validate(@RequestBody Form form, BindingResult result){
        
        new FormValidator().validate(form, result);
        
        if(result.hasErrors()){
           return new ResponseEntity<String>(result.getAllErrors().toString(), HttpStatus.OK);
        }

        ResponseEntity<String> responseEntity = new ResponseEntity<String>("Ok", HttpStatus.OK);
        return responseEntity;
    }
    
    @PostMapping("/form/send")
    public String sendForm(String username,String firstName,String lastName){
        BeanWrapper form = new BeanWrapperImpl(new Form());
        form.setPropertyValue("username",username);
        form.setPropertyValue("firstName",firstName);
        form.setPropertyValue("lastName",lastName);
        
        return "ok";
    }
    
    @PutMapping("/handle")
    public void handle(@RequestBody String body, Writer writer) throws IOException{
        writer.write(body);
    }
    
    
    
}
