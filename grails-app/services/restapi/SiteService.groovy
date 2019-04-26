package restapi

import grails.gorm.transactions.Transactional

@Transactional
class SiteService {

    def serviceMethod(Integer limite) {
        if (Site.list().size() > limite) {
            true

        } else {
            false

        }
    }

    def comprobarDuplicacion(Object listaJson) {
        def dbSites = Site.list()
        boolean estado = listaJson.any { it -> dbSites.any{ dbS -> dbS.id == it.id }}
        if(!estado)
            listaJson.each {it -> new Site(it.name,it.id).save(flush:true, failOnError:true)}
        return estado
    }
}
