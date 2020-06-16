package com.ideabaker.samples.scccontenttypeissue

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.BodyInserters.fromValue
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@SpringBootApplication
class SccContentTypeIssueApplication

fun main(args: Array<String>) {
  runApplication<SccContentTypeIssueApplication>(*args)
}

@Configuration
class Routes {
  @Bean
  fun sampleRoute(userService: UserService) = router {
    POST("/register", contentType(MediaType.APPLICATION_JSON)) { request ->
      request.bodyToMono(SampleRequest::class.java)
          .flatMap { userService.register(it) }
          .flatMap { ServerResponse.status(HttpStatus.CREATED).body(fromValue(it)) }
    }
  }
}