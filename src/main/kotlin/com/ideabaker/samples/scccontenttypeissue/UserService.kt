package com.ideabaker.samples.scccontenttypeissue

import org.springframework.stereotype.Service
import reactor.kotlin.core.publisher.toMono

/**
 *
 * @author Arthur Kazemi<bidadh@gmail.com>
 * @since 16/6/20 11:10
 */
@Service
class UserService {
  fun register(body: SampleRequest) = body.toMono()
}