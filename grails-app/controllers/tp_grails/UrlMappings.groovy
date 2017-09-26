package tp_grails

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

//        "/user/$id/show"(controller:"user", action: "show", method: "GET")
//        "/user/$id/edit"(controller:"user", action: "edit", method: "GET")

        name userProfile: "/user/$id/show"{
            controller={"user"}
            action=[GET:"show"]
        }

        name userEdit: "/user/$id/edit"{
            controller={"user"}
            action=[GET:"edit"]
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
