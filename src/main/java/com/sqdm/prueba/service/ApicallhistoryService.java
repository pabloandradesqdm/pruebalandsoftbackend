package com.sqdm.prueba.service;

import com.sqdm.prueba.model.Apicallhistory;
import com.sqdm.prueba.repository.ApicallhistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApicallhistoryService  {
    @Autowired
    private ApicallhistoryRepository apicallhistoryRepository;

    public Apicallhistory saveApicallhistory(Apicallhistory apicallhistory){
        return apicallhistoryRepository.save(apicallhistory);
    }

    public List<Apicallhistory> saveApicallhistories(List<Apicallhistory> apicallhistories){
        return apicallhistoryRepository.saveAll(apicallhistories);
    }

    public List<Apicallhistory> getApicallhistories(){
        return apicallhistoryRepository.findAll();
    }

    public Apicallhistory getApicallhistoryById(int id){
        return apicallhistoryRepository.findById(id).orElse(null);
    }

    public void deleteApicallhistoryById(int id){
        apicallhistoryRepository.deleteById(id);
    }

    public Apicallhistory updateApicallhistory(Apicallhistory apicallhistory){
        Apicallhistory apicallhistoryUpd = apicallhistoryRepository.findById(apicallhistory.getId()).orElse(null);
        if(apicallhistoryUpd != null) {
            apicallhistoryUpd.setCallDate(apicallhistory.getCallDate());
            apicallhistoryUpd.setEndPoint(apicallhistory.getEndPoint());
            apicallhistoryUpd.setHttpVerb(apicallhistory.getHttpVerb());
            apicallhistoryUpd.setTypecall(apicallhistory.getTypecall());
            return apicallhistoryRepository.save(apicallhistoryUpd);
        }
        else {
            return apicallhistoryRepository.save(apicallhistory);
        }
    }
}
