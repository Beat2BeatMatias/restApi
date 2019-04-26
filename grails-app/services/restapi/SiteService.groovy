package restapi

import grails.gorm.transactions.Transactional

@Transactional
class SiteService {

    def serviceMethod(Integer limite) {
        return Site.list().size() > limite
    }

    def comprobarDuplicacion(Object listaJson) {
        def dbSites = Site.list()
        boolean estado = listaJson.any { it -> dbSites.any{ dbS -> dbS.id == it.id }}
        if(!estado)
            listaJson.each {it -> new Site(it.name,it.id).save(flush:true, failOnError:true)}
        return estado
    }
}
