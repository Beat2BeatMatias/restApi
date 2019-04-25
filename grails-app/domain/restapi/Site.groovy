package restapi

import grails.rest.Resource

import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Resource(formats = ['json','xml'])
class Site {
    String id
    String name

    Site(String name,String id){
        this.id=id
        this.name=name
    }
    static constraints = {
        //id generator:'assigned'
        id bindable:false
    }
    static mapping = {
        id generator:'assigned'
    }
}
