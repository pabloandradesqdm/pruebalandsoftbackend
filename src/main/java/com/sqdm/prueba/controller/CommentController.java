package com.sqdm.prueba.controller;

import com.sqdm.prueba.model.Apicallhistory;
import com.sqdm.prueba.service.ApicallhistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Post")
@CrossOrigin(origins="*")
public class CommentController {
    @Autowired
    ApicallhistoryService apicallhistoryService;

    private String getRootUrl() {
        return "https://jsonplaceholder.typicode.com/";
    }

    @GetMapping("/GetComments")
    public String GetComments(){
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = getRootUrl() + "comments";
        String result = "";

        try{
            result = restTemplate.getForObject(endpoint, String.class);
        }
        catch (Exception ex){
            result = "{'message':'Error in Get Comments: ' "+ ex.getMessage() +"}";
        }
        finally {
            Apicallhistory appCall = new Apicallhistory();
            appCall.setTypecall("Comment");
            appCall.setCallDate(new Date());
            appCall.setEndPoint(endpoint);
            appCall.setHttpVerb(result);
            apicallhistoryService.saveApicallhistory(appCall);

            return result;
        }
    }

    @GetMapping("/GetComment")
    public String GetComment(@RequestParam int id){
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = getRootUrl() + "comments/"+id;
        String result = "";

        try{
            result = restTemplate.getForObject(endpoint, String.class);
        }
        catch (Exception ex){
            result = "{'message':'Error in Get Comment: ' "+ ex.getMessage() +"}";
        }
        finally {
            Apicallhistory appCall = new Apicallhistory();
            appCall.setTypecall("Comment");
            appCall.setCallDate(new Date());
            appCall.setEndPoint(endpoint);
            appCall.setHttpVerb(result);
            apicallhistoryService.saveApicallhistory(appCall);

            return result;
        }
    }

    @GetMapping("/GetCommentForPostId")
    public String GetCommentForPostId(@RequestParam int postId){
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = getRootUrl() + "comments/?postId="+postId;
        String result = "";

        try{
            result = restTemplate.getForObject(endpoint, String.class);
        }
        catch (Exception ex){
            result = "{'message':'Error in Get Comment For Post Id: ' "+ ex.getMessage() +"}";
        }
        finally {
            Apicallhistory appCall = new Apicallhistory();
            appCall.setTypecall("Comment");
            appCall.setCallDate(new Date());
            appCall.setEndPoint(endpoint);
            appCall.setHttpVerb(result);
            apicallhistoryService.saveApicallhistory(appCall);

            return result;
        }
    }

    @PostMapping("/CreateComment")
    public String CreateComment(@RequestBody String comment){
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = getRootUrl() + "comments";
        String result = "";

        try{
            result = restTemplate.postForObject(endpoint, comment, String.class);
        }
        catch (Exception ex){
            result = "{'message':'Error in Create Comment: ' "+ ex.getMessage() +"}";
        }
        finally {
            Apicallhistory appCall = new Apicallhistory();
            appCall.setTypecall("Comment");
            appCall.setCallDate(new Date());
            appCall.setEndPoint(endpoint);
            appCall.setHttpVerb(result);
            apicallhistoryService.saveApicallhistory(appCall);

            return result;
        }
    }

    @PostMapping("/UpdateComment")
    public String UpdateComment(@RequestParam int id, @RequestBody String comment){
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        String endpoint = getRootUrl() + "comments/" + id;
        String result = "";

        try {
            restTemplate.put(endpoint, comment, params);
            result = "{'message':'Update Comment successful'}";
        }
        catch (Exception ex){
            result = "{'message':'Error in Update Comment: ' "+ ex.getMessage() +"}";
        }
        finally {
            Apicallhistory appCall = new Apicallhistory();
            appCall.setTypecall("Comment");
            appCall.setCallDate(new Date());
            appCall.setEndPoint(endpoint);
            appCall.setHttpVerb(result);
            apicallhistoryService.saveApicallhistory(appCall);

            return result;
        }
    }

    @PostMapping("/DeleteComment")
    public String DeleteComment(@RequestParam int id){
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = getRootUrl() + "comments/" + id;
        String result = "";

        try {
            restTemplate.delete(endpoint);
            result = "{'message':'Delete comment successful'}";
        }
        catch (Exception ex){
            result = "{'message':'Error in Delete comment: ' "+ ex.getMessage() +"}";
        }
        finally {
            Apicallhistory appCall = new Apicallhistory();
            appCall.setTypecall("Comment");
            appCall.setCallDate(new Date());
            appCall.setEndPoint(endpoint);
            appCall.setHttpVerb(result);
            apicallhistoryService.saveApicallhistory(appCall);

            return result;
        }
    }
}
