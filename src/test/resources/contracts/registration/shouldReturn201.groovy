package contracts.registration

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("returns 201")

    request {
        method "POST"
        url '/register'
        headers { contentType(applicationJson()) }
        body([
                "name"    : anyAlphaNumeric(),
                "username": anyEmail()
        ])
    }

    response {
        status 201
        headers { contentType(applicationJson()) }
        body([
                "name"    : fromRequest().body("name"),
                "username": fromRequest().body("username")
        ])
    }
}