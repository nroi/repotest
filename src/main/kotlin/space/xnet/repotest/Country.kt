package space.xnet.repotest

import javax.persistence.*

@Entity
class Country(
    @ManyToOne
    @JoinColumn(name = "head_of_state_id", nullable = false)
    var headOfState: Person,

    var name: String? = null
) : AbstractEntity() {

  override fun hashCode(): Int = 602
}

