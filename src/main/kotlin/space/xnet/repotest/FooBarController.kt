package space.xnet.repotest

import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping

@RepositoryRestController
class FooBarController {

  @GetMapping(path = ["/fooBars"])
  fun get(): ResponseEntity<String> {
    return ResponseEntity("ok", HttpStatus.OK)
  }
}
