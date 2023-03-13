package space.xnet.repotest

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CountryController(
    private val countryRepository: CountryRestRepository
) {

  @PostMapping("/save_country")
  fun savePerson(@RequestBody country: Country): Long {
    countryRepository.save(country)

    return country.id
  }
}
