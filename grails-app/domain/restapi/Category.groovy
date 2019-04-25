package restapi

import grails.rest.Resource

@Resource(formats = ['json','xml'])
class Category {

    String id
    Site   site
    String name

    Category(String id, Site site, String nombre) {
        this.id = id
        this.site = site
        this.name = nombre
    }
    static constraints = {
        id bindable:false
    }
    static mapping = {
        id generator:'assigned'
    }

}
