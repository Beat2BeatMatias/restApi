package restapi

import grails.rest.Resource


@Resource(formats = ['xml','json'])
class Categoria {

    String nombre
    String descripcion

    static constraints = {
        nombre blank: false, nullable: false
        descripcion blank: false, nullable: false
    }
}
