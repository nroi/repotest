package space.xnet.repotest

import javax.persistence.Entity

@Entity
class Person(
    var surname: String? = null,
    var givenName: String? = null
) : AbstractEntity() {

  override fun hashCode(): Int = 602
}
