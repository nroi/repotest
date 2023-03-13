package space.xnet.repotest

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  open var id: Long = 0
    protected set

  override fun equals(other: Any?): Boolean {
    if (this === other) {
      return true
    }

    if (other == null || this.javaClass != other.javaClass || this.id == 0L) {
      return false
    }

    val that = other as AbstractEntity

    return this.id == that.id
  }

  override fun hashCode(): Int {
    return id.hashCode()
  }
}
