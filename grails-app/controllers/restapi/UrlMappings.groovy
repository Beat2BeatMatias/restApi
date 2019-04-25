package restapi

class UrlMappings {

    static mappings = {
//        "/sites"(resources: "site"){
//            "/categories"(resources:  "category"){
//                "/items"(resources: "item")
//            }
//        }
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "Client")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
