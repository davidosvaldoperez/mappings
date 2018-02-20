package com.mycompany.mappings.model;

/**
 *
 * @author David <david.perez@hospitalitaliano.org.ar>
 */
public class UrlService {

    public String getUrlByString(String string) {
        return String.format("http://documentos/%s", string.toLowerCase());
    }
    
    public String getStringByUrl(String url){
        return url.substring(18).toUpperCase();
    }
}
