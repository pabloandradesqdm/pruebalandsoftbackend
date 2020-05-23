package com.sqdm.prueba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "apicallhistory")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Apicallhistory {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "typecall")
    private String typecall;
    @Column(name = "calldate")
    private Date callDate;
    @Column(name = "endpoint")
    private String endPoint;
    @Column(name = "httpverb", columnDefinition = "text")
    private String httpVerb;

    public int getId() {
        return id;
    }

    public String getTypecall() {
        return typecall;
    }

    public void setTypecall(String typecall) {
        this.typecall = typecall;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getHttpVerb() {
        return httpVerb;
    }

    public void setHttpVerb(String httpVerb) {
        this.httpVerb = httpVerb;
    }
}
