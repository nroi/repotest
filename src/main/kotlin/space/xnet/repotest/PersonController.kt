package space.xnet.repotest

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(
    private val personRestRepository: PersonRestRepository
) {

  @PostMapping("/save_person")
  fun savePerson(@RequestBody person: Person): Long {
    personRestRepository.save(person)

    return person.id
  }
}
