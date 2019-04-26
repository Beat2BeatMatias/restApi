package restapi

import com.sun.xml.internal.bind.v2.model.core.ID
import groovy.json.JsonSlurper

class BootStrap {

    def init = { servletContext ->

          def site1 = new Site("sites1",'MM1').save(flush:true, failOnError:true)
          def site2 = new Site("sites2",'MM2').save(flush:true, failOnError:true)
          def site3 = new Site("sites3",'MM3').save(flush:true, failOnError:true)


          def c1 = new Category('MM11', site1,"Deportes").save(flush:true, failOnError:true)
          def c2 = new Category('MM22', site2, "Ropa").save(flush:true, failOnError:true)
          def c3 = new Category('MM23', site3,"Categoria3").save(flush:true, failOnError:true)

          def item1=new Item(title: "pelota", subtitle: "futbol", price: "200", imageurl: "sdad", category: c1).save(flush:true, failOnError:true)
          def item2=new Item(title: "pelota", subtitle: "tenis", price: "100", imageurl: "asdasd", category: c1).save(flush:true, failOnError:true)
          def item3=new Item(title: "medias", subtitle: "sockete", price: "100", imageurl: "asdasd", category: c2).save(flush:true, failOnError:true)
    }
    def destroy = {
    }
}
