package restapi

import grails.web.mapping.mvc.RedirectEventListener
import groovy.json.JsonSlurper

class ClientController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {

        def url = new URL("https://api.mercadolibre.com/sites")
        def connection = (HttpURLConnection) url.openConnection()
        connection.setRequestMethod("GET")
        connection.setRequestProperty("Accept","application/json")
        connection.setRequestProperty("user-Agent", "Mozilla/5.0")

        BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"))
        int read = 0;
        StringBuffer buffer = new StringBuffer()
        char[] chars = new char[1024];
        while((read = reader.read(chars)) != -1){
            buffer.append(chars,0,read)
        }
        reader.close()

        JsonSlurper json = new JsonSlurper()
        println(buffer.toString())
        def jsonText = json.parseText(buffer.toString())

        for (j in jsonText) {
                new Site(j.name,j.id).save(flush: true, failOnError: true)
        }
        [siteList: Site.list(), result:jsonText]
    }
    def categories(Site site){
        def url = new URL("https://api.mercadolibre.com/sites/"+params.id+"/categories")
        def connection = (HttpURLConnection) url.openConnection()
        connection.setRequestMethod("GET")
        connection.setRequestProperty("Accept","application/json")
        connection.setRequestProperty("user-Agent", "Mozilla/5.0")

        JsonSlurper json = new JsonSlurper()
        def result = json.parse(connection.getInputStream())
        println result
        result.each {it -> new Category(it.id,site,it.name).save(flush: true, failOnError: true)}
        [result: result]
    }
}
