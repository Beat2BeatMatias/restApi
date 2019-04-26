package restapi

import grails.transaction.Transactional

@Transactional
class SiteController {

    def siteService
    def index() {
        siteService.serviceMethod()
    }
}
