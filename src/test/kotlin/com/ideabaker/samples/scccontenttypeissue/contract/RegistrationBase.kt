package com.ideabaker.samples.scccontenttypeissue.contract

import io.restassured.module.webtestclient.RestAssuredWebTestClient
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

/**
 *
 * @author Arthur Kazemi<bidadh@gmail.com>
 * @since 16/6/20 11:12
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
abstract class RegistrationBase {
  @Autowired
  lateinit var context: ApplicationContext

  @Suppress("UNCHECKED_CAST")
  fun <T> uninitialized(): T = null as T

  fun <T> any(): T {
    Mockito.any<T>()
    return uninitialized()
  }

  @BeforeEach
  fun setup() {
/*
    val registerAnswer = Answer { it.getArgument<SampleRequest>(0).toMono() }
    doAnswer(registerAnswer)
        .`when`(userService).register(any())
*/

    RestAssuredWebTestClient.applicationContextSetup(context)
  }
}
