package mil.usmc.dmol.home

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id

@Entity
class Home (
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null,

    var title: String? = null
)