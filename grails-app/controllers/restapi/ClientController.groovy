package restapi

import grails.transaction.Transactional
import grails.web.mapping.mvc.RedirectEventListener
import groovy.json.JsonSlurper

@Transactional
class ClientController {

    def siteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(String limite) {
        limite=limite?:"30"
        def url = new URL("https://api.mercadolibre.com/sites")
        def connection = (HttpURLConnection) url.openConnection()
        connection.setRequestMethod("GET")
        connection.setRequestProperty("Accept", "application/json")
        connection.setRequestProperty("user-Agent", "Mozilla/5.0")

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"))
        int read = 0;
        StringBuffer buffer = new StringBuffer()
        char[] chars = new char[1024];
        while ((read = reader.read(chars)) != -1) {
            buffer.append(chars, 0, read)
        }
        reader.close()

        JsonSlurper json = new JsonSlurper()
        println(buffer.toString())
        def jsonText = json.parseText(buffer.toString())
        if (siteService.comprobarDuplicacion(jsonText)) {
            flash.message="Existen datos duplicados en la bd"
            render view: 'error'
        }

        if (siteService.serviceMethod(limite.toInteger())) {
            [siteList: Site.list(), result: jsonText]
        } else {
             flash.message="No superó el limite"
             render view: 'error'
        }

    }
    def borrar(){
        Site.list().each {it -> if (!(it.id=="MM1"||it.id=="MM2"||it.id=="MM3")) it.delete(flush: true, failOnError: true)}
        flash.message="Borrados los datos"
        render view:'error'
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
        result.each
                {it -> new Category(it.id,site,it.name).save(flush: true, failOnError: true)}
        [result: result]
    }
    def subcategories(){
        def url = new URL("https://api.mercadolibre.com/categories/"+params.id)
        def connection = (HttpURLConnection) url.openConnection()
        connection.setRequestMethod("GET")
        connection.setRequestProperty("Accept","application/json")
        connection.setRequestProperty("user-Agent", "Mozilla/5.0")

        JsonSlurper json = new JsonSlurper()
        def result = json.parse(connection.getInputStream())
        println result

        [result: result, parametro:params.id]
    }
}
