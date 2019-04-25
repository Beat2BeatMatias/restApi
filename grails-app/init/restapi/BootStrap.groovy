package restapi

import com.sun.xml.internal.bind.v2.model.core.ID
import groovy.json.JsonSlurper

class BootStrap {

    def init = { servletContext ->

          def site1 = new Site("sites1","XXX1").save()
          def site2 = new Site("sites2","XXX2").save()
          def site3 = new Site("sites3","XXX3").save()


          def c1 = new Category("MLA12", site1,"Deportes").save()
          def c2 = new Category("MXX2", site2, "Ropa").save()
          def c3 = new Category("MXX3", site3,"Categoria3").save()

          def item1=new Item(title: "pelota", subtitle: "futbol", price: "200", imageurl: "sdad", category: c1).save()
          def item2=new Item(title: "pelota", subtitle: "tenis", price: "100", imageurl: "asdasd", category: c1).save()
          def item3=new Item(title: "medias", subtitle: "sockete", price: "100", imageurl: "asdasd", category: c2).save()
    }
    def destroy = {
    }
}
