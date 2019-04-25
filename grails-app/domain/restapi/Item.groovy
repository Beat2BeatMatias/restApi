package restapi

import grails.rest.Resource

@Resource(formats = ['json','xml'])
class Item {

    Category category
    String title
    String subtitle
    String price
    String imageurl


    static constraints = {
    }
}
