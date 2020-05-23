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
public class PostController {
    @Autowired
    ApicallhistoryService apicallhistoryService;

    private String getRootUrl() {
        return "https://jsonplaceholder.typicode.com/";
    }

    @GetMapping("/GetPosts")
    public String GetPosts(){
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = getRootUrl() + "posts";
        String result = "";

        try{
            result = restTemplate.getForObject(endpoint, String.class);
        }
        catch (Exception ex){
            result = "{'message':'Error in Get Posts: ' "+ ex.getMessage() +"}";
        }
        finally {
            Apicallhistory appCall = new Apicallhistory();
            appCall.setTypecall("Post");
            appCall.setCallDate(new Date());
            appCall.setEndPoint(endpoint);
            appCall.setHttpVerb(result);
            apicallhistoryService.saveApicallhistory(appCall);

            return result;
        }
    }

    @GetMapping("/GetPost")
    public String GetPost(@RequestParam int id){
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = getRootUrl() + "posts/"+id;
        String result = "";

        try {
            result = restTemplate.getForObject(endpoint, String.class);
        }
        catch (Exception ex){
            result = "{'message':'Error in Get Post: ' "+ ex.getMessage() +"}";
        }
        finally {
            Apicallhistory appCall = new Apicallhistory();
            appCall.setTypecall("Post");
            appCall.setCallDate(new Date());
            appCall.setEndPoint(endpoint);
            appCall.setHttpVerb(result);
            apicallhistoryService.saveApicallhistory(appCall);

            return result;
        }
    }

    @GetMapping("/GetPostForUserId")
    public String GetPostForUserId(@RequestParam int userId){
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = getRootUrl() + "posts/?userId="+userId;
        String result = "";

        try{
            result = restTemplate.getForObject(endpoint, String.class);
        }
        catch (Exception ex){
            result = "{'message':'Error in Get Post For Userid: ' "+ ex.getMessage() +"}";
        }
        finally {
            Apicallhistory appCall = new Apicallhistory();
            appCall.setTypecall("Post");
            appCall.setCallDate(new Date());
            appCall.setEndPoint(endpoint);
            appCall.setHttpVerb(result);
            apicallhistoryService.saveApicallhistory(appCall);

            return result;
        }
    }

    @PostMapping("/CreatePost")
    public String CreatePost(@RequestBody String post){
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = getRootUrl() + "posts";
        String result = "";

        try{
            result = restTemplate.postForObject(endpoint, post, String.class);
        }
        catch (Exception ex){
            result = "{'message':'Error in Create Post: ' "+ ex.getMessage() +"}";
        }
        finally {
            Apicallhistory appCall = new Apicallhistory();
            appCall.setTypecall("Post");
            appCall.setCallDate(new Date());
            appCall.setEndPoint(endpoint);
            appCall.setHttpVerb(result);
            apicallhistoryService.saveApicallhistory(appCall);

            return result;
        }
    }

    @PostMapping("/UpdatePost")
    public String UpdatePost(@RequestParam int id, @RequestBody String post){
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        String endpoint = getRootUrl() + "posts/" + id;
        String result = "";

        try {
            restTemplate.put(endpoint, post, params);
            result = "{'message':'Update post successful'}";
        }
        catch (Exception ex){
            result = "{'message':'Error in Update Post: ' "+ ex.getMessage() +"}";
        }
        finally {
            Apicallhistory appCall = new Apicallhistory();
            appCall.setTypecall("Post");
            appCall.setCallDate(new Date());
            appCall.setEndPoint(endpoint);
            appCall.setHttpVerb(result);
            apicallhistoryService.saveApicallhistory(appCall);

            return result;
        }
    }

    @PostMapping("/DeletePost")
    public String DeletePost(@RequestParam int id){
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = getRootUrl() + "posts/" + id;
        String result = "";

        try {
            restTemplate.delete(endpoint);
            result = "{'message':'Delete post successful'}";
        }
        catch (Exception ex){
            result = "{'message':'Error in Delete Post: ' "+ ex.getMessage() +"}";
        }
        finally {
            Apicallhistory appCall = new Apicallhistory();
            appCall.setTypecall("Post");
            appCall.setCallDate(new Date());
            appCall.setEndPoint(endpoint);
            appCall.setHttpVerb(result);
            apicallhistoryService.saveApicallhistory(appCall);

            return result;
        }
    }
}
