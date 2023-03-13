package space.xnet.repotest

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface CountryRestRepository : JpaRepository<Country, Long>
